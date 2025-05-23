package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ProxyService(proxy = RequestProxy.class)
/* loaded from: classes23.dex */
public class RequestProxyDefault extends RequestProxy {
    public ConcurrentHashMap<String, RequestTask> taskMap = new ConcurrentHashMap<>();

    /* loaded from: classes23.dex */
    public class RequestTask implements Runnable {
        public volatile boolean mAbort;
        public byte[] mBodyData;
        public Map<String, String> mHeader;
        public RequestProxy.RequestListener mListener;
        public String mMethod;
        public int mTimeout;
        public String mUrl;

        public RequestTask(String str, byte[] bArr, Map<String, String> map, String str2, int i3, RequestProxy.RequestListener requestListener) {
            if (bArr != null) {
                byte[] bArr2 = new byte[bArr.length];
                this.mBodyData = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            }
            this.mUrl = str;
            this.mHeader = map;
            this.mMethod = str2;
            this.mTimeout = i3;
            this.mListener = requestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
                httpURLConnection.setConnectTimeout(this.mTimeout);
                httpURLConnection.setRequestMethod(this.mMethod);
                Map<String, String> map = this.mHeader;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, this.mHeader.get(str));
                    }
                }
                if (this.mBodyData != null && this.mMethod.equalsIgnoreCase("POST")) {
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(this.mBodyData);
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (this.mAbort) {
                    return;
                }
                this.mListener.onRequestHeadersReceived(responseCode, httpURLConnection.getHeaderFields());
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            if (this.mAbort) {
                                inputStream.close();
                                byteArrayOutputStream.close();
                                return;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            inputStream.close();
                            byteArrayOutputStream.close();
                            httpURLConnection.disconnect();
                            RequestProxyDefault.this.taskMap.remove(this.mUrl);
                            this.mListener.onRequestSucceed(responseCode, byteArrayOutputStream.toByteArray(), httpURLConnection.getHeaderFields());
                            return;
                        }
                    }
                } else {
                    RequestProxyDefault.this.taskMap.remove(this.mUrl);
                    this.mListener.onRequestFailed(httpURLConnection.getResponseCode(), "http error code");
                }
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                RequestProxyDefault.this.taskMap.remove(this.mUrl);
                this.mListener.onRequestFailed(-1, e16.getMessage());
            } catch (IOException e17) {
                e17.printStackTrace();
                RequestProxyDefault.this.taskMap.remove(this.mUrl);
                this.mListener.onRequestFailed(-2, e17.getMessage());
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy
    public void abort(String str) {
        this.taskMap.get(str).mAbort = true;
        this.taskMap.remove(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy
    public boolean request(String str, byte[] bArr, Map<String, String> map, String str2, int i3, RequestProxy.RequestListener requestListener) {
        RequestTask requestTask = new RequestTask(str, bArr, map, str2.toUpperCase(), i3, requestListener);
        this.taskMap.put(str, requestTask);
        ThreadManager.executeOnNetworkIOThreadPool(requestTask);
        return true;
    }
}

package com.qq.e.comm.net;

import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NetworkClientImpl implements NetworkClient {

    /* renamed from: a, reason: collision with root package name */
    private static final NetworkClient f38291a = new NetworkClientImpl();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class TaskCallable implements Callable<Response> {

        /* renamed from: a, reason: collision with root package name */
        private Request f38292a;

        /* renamed from: b, reason: collision with root package name */
        private NetworkCallBack f38293b;

        /* renamed from: c, reason: collision with root package name */
        private int f38294c;

        public TaskCallable(Request request) {
            this(request, null);
        }

        private void a(HttpURLConnection httpURLConnection) {
            if (httpURLConnection == null) {
                return;
            }
            for (Map.Entry<String, String> entry : this.f38292a.getUnmodifiableHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setRequestProperty("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            if (this.f38292a.getConnectionTimeOut() > 0) {
                httpURLConnection.setConnectTimeout(this.f38292a.getConnectionTimeOut());
            } else {
                httpURLConnection.setConnectTimeout(30000);
            }
            if (this.f38292a.getSocketTimeOut() > 0) {
                httpURLConnection.setReadTimeout(this.f38292a.getSocketTimeOut());
            } else {
                httpURLConnection.setReadTimeout(30000);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Finally extract failed */
        @Override // java.util.concurrent.Callable
        public Response call() throws Exception {
            Response response = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f38292a.getUrlWithParas()).openConnection();
                a(httpURLConnection);
                int i3 = this.f38294c;
                if (i3 != Integer.MAX_VALUE) {
                    httpURLConnection.setConnectTimeout(i3);
                }
                if (this.f38292a.getMethod() == 2) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setChunkedStreamingMode(0);
                    byte[] postData = this.f38292a.getPostData();
                    if (postData != null && postData.length > 0) {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                        bufferedOutputStream.write(postData);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                response = this.f38292a.initResponse(NetworkUtil.followRedirect(httpURLConnection));
                NetworkCallBack networkCallBack = this.f38293b;
                if (networkCallBack != null) {
                    networkCallBack.onResponse(this.f38292a, response);
                }
                if (this.f38292a.isAutoClose() && response != null) {
                    response.close();
                }
            } catch (Exception e16) {
                if (this.f38293b == null) {
                    throw e16;
                }
                GDTLogger.w("NetworkClientException", e16);
                this.f38293b.onException(e16);
            } catch (Throwable th5) {
                NetworkCallBack networkCallBack2 = this.f38293b;
                if (networkCallBack2 != null) {
                    networkCallBack2.onResponse(this.f38292a, null);
                }
                this.f38292a.isAutoClose();
                throw th5;
            }
            return response;
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f38292a = request;
            this.f38293b = networkCallBack;
            this.f38294c = Integer.MAX_VALUE;
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack, int i3) {
            this.f38292a = request;
            this.f38293b = networkCallBack;
            this.f38294c = i3;
        }
    }

    NetworkClientImpl() {
    }

    public static NetworkClient getInstance() {
        return f38291a;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request) {
        return submit(request, 2);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, int i3) {
        return submit(request, i3, 0);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, int i3, int i16) {
        a aVar = new a(new TaskCallable(request), i3);
        GdtSDKThreadManager.getInstance().runOnThread(2, aVar);
        return aVar;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, int i3, NetworkCallBack networkCallBack) {
        GdtSDKThreadManager.getInstance().runOnThread(2, new a(new TaskCallable(request, networkCallBack), i3));
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, int i3, NetworkCallBack networkCallBack, int i16) {
        GdtSDKThreadManager.getInstance().runOnThread(2, new a(new TaskCallable(request, networkCallBack, i16), i3));
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, 2, networkCallBack);
    }
}

package com.tencent.ark.open.delegate;

import android.os.AsyncTask;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultNetDelegate implements IArkDelegateNet {
    static final String TAG = "ArkApp.Net";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class HttpParam {
        public IArkDelegateHTTPCallback callback;
        public Map<String, String> headers;
        public byte[] postData;
        public String url;

        HttpParam() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class HttpTask extends AsyncTask<HttpParam, Void, Void> {
        HttpTask() {
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static void httpRequest(HttpParam httpParam) {
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            InputStream inputStream2 = null;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(httpParam.url).openConnection();
                    Map<String, String> map = httpParam.headers;
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (httpParam.postData != null) {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.getOutputStream().write(httpParam.postData);
                    }
                    InputStream inputStream3 = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[65536];
                            while (true) {
                                int read = inputStream3.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                }
                            }
                            httpParam.callback.onComplete(0, byteArrayOutputStream2.toByteArray());
                            try {
                                inputStream3.close();
                            } catch (IOException unused) {
                            }
                            byteArrayOutputStream2.close();
                        } catch (Exception e16) {
                            inputStream = inputStream3;
                            e = e16;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                Log.e(DefaultNetDelegate.TAG, String.format("download fail, url: %s, error: %s", httpParam.url, e.getMessage()));
                                httpParam.callback.onComplete(1, null);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (byteArrayOutputStream == null) {
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (IOException unused4) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream2 = inputStream3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (inputStream2 != null) {
                            }
                            if (byteArrayOutputStream == null) {
                            }
                        }
                    } catch (Exception e17) {
                        byteArrayOutputStream = null;
                        inputStream = inputStream3;
                        e = e17;
                    } catch (Throwable th7) {
                        th = th7;
                        byteArrayOutputStream = null;
                        inputStream2 = inputStream3;
                    }
                } catch (Exception e18) {
                    e = e18;
                    inputStream = null;
                    byteArrayOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    byteArrayOutputStream = null;
                }
            } catch (IOException unused5) {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(HttpParam... httpParamArr) {
            if (httpParamArr.length == 0) {
                return null;
            }
            httpRequest(httpParamArr[0]);
            return null;
        }
    }

    static void runTask(String str, HashMap<String, String> hashMap, byte[] bArr, IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
        HttpParam httpParam = new HttpParam();
        httpParam.url = str;
        httpParam.headers = hashMap;
        httpParam.postData = bArr;
        httpParam.callback = iArkDelegateHTTPCallback;
        new HttpTask().execute(httpParam);
    }

    @Override // com.tencent.ark.open.delegate.IArkDelegateNet
    public void get(String str, HashMap<String, String> hashMap, IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
        runTask(str, hashMap, null, iArkDelegateHTTPCallback);
    }

    @Override // com.tencent.ark.open.delegate.IArkDelegateNet
    public int getNetworkType() {
        return 0;
    }

    @Override // com.tencent.ark.open.delegate.IArkDelegateNet
    public boolean isNetworkAvailable() {
        return true;
    }

    @Override // com.tencent.ark.open.delegate.IArkDelegateNet
    public void post(String str, HashMap<String, String> hashMap, byte[] bArr, IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
        runTask(str, hashMap, bArr, iArkDelegateHTTPCallback);
    }
}

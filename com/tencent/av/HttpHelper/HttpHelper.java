package com.tencent.av.HttpHelper;

import android.net.http.Headers;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HttpHelper {
    private static final String TAG = "HttpHelper";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface HttpRequestListener {
        void onCompleted(String str, int i3, byte[] bArr, Object obj);
    }

    public static boolean httpGetRequest(String str, Object obj, HttpRequestListener httpRequestListener) {
        return httpGetRequest(str, obj, 5000, httpRequestListener);
    }

    public static boolean httpPostRequest(String str, byte[] bArr, Map<String, String> map, Object obj, HttpRequestListener httpRequestListener) {
        return httpPostRequest(str, bArr, map, obj, 5000, httpRequestListener);
    }

    public static boolean httpGetRequest(final String str, final Object obj, final int i3, final HttpRequestListener httpRequestListener) {
        Log.e(TAG, "httpGetRequest|url = " + str + "|| http request timeout =" + i3);
        new BaseThread(new Runnable() { // from class: com.tencent.av.HttpHelper.HttpHelper.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
            /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00b5  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
            /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v14 */
            /* JADX WARN: Type inference failed for: r0v16 */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v18 */
            /* JADX WARN: Type inference failed for: r0v19, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.av.HttpHelper.HttpHelper$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r1v7, types: [com.tencent.av.HttpHelper.HttpHelper$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v11, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v14 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v17 */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v2 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v21 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v23 */
            /* JADX WARN: Type inference failed for: r2v24 */
            /* JADX WARN: Type inference failed for: r2v25 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v27 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v29 */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1 */
            /* JADX WARN: Type inference failed for: r3v11 */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                HttpURLConnection httpURLConnection;
                int i16;
                BufferedInputStream bufferedInputStream;
                HttpRequestListener httpRequestListener2;
                String str2;
                Object obj2;
                int i17;
                byte[] bArr;
                HttpRequestListener httpRequestListener3;
                HttpRequestListener httpRequestListener4;
                ?? r06 = "httpGetRequest|http request failed.";
                ?? r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                ?? r36 = 200;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(i3);
                            httpURLConnection.setReadTimeout(i3);
                            httpURLConnection.connect();
                            i16 = httpURLConnection.getResponseCode();
                            try {
                                if (i16 == 200) {
                                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                    try {
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10240);
                                        byte[] bArr2 = new byte[1024];
                                        while (true) {
                                            int read = bufferedInputStream.read(bArr2);
                                            if (read < 0) {
                                                break;
                                            } else {
                                                byteArrayOutputStream.write(bArr2, 0, read);
                                            }
                                        }
                                        r06 = byteArrayOutputStream.toByteArray();
                                        r26 = bufferedInputStream;
                                        r06 = r06;
                                        r26 = r26;
                                    } catch (UnknownHostException e16) {
                                        e = e16;
                                        Log.e(HttpHelper.TAG, r06, e);
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e17) {
                                                e17.printStackTrace();
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        httpRequestListener4 = httpRequestListener;
                                        if (httpRequestListener4 == null) {
                                            str2 = str;
                                            obj2 = obj;
                                            i17 = 404;
                                            httpRequestListener3 = httpRequestListener4;
                                            bArr = r26;
                                            httpRequestListener3.onCompleted(str2, i17, bArr, obj2);
                                            return;
                                        }
                                        return;
                                    } catch (IOException e18) {
                                        e = e18;
                                        Log.e(HttpHelper.TAG, r06, e);
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e19) {
                                                e19.printStackTrace();
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        httpRequestListener2 = httpRequestListener;
                                        if (httpRequestListener2 == null) {
                                            str2 = str;
                                            obj2 = obj;
                                            i17 = -1;
                                            httpRequestListener3 = httpRequestListener2;
                                            bArr = r26;
                                            httpRequestListener3.onCompleted(str2, i17, bArr, obj2);
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    Log.e(HttpHelper.TAG, "httpGetRequest|http request failed. http response code =" + i16);
                                    r06 = 0;
                                }
                                if (r26 != 0) {
                                    try {
                                        r26.close();
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                    }
                                }
                                httpURLConnection.disconnect();
                                ?? r16 = httpRequestListener;
                                if (r16 != 0) {
                                    r16.onCompleted(str, i16, r06, obj);
                                }
                            } catch (UnknownHostException e27) {
                                e = e27;
                                bufferedInputStream = r26;
                                Log.e(HttpHelper.TAG, r06, e);
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                httpRequestListener4 = httpRequestListener;
                                if (httpRequestListener4 == null) {
                                }
                            } catch (IOException e28) {
                                e = e28;
                                bufferedInputStream = r26;
                                Log.e(HttpHelper.TAG, r06, e);
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                httpRequestListener2 = httpRequestListener;
                                if (httpRequestListener2 == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                r36 = r26;
                                if (r36 != 0) {
                                    try {
                                        r36.close();
                                    } catch (IOException e29) {
                                        e29.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                ?? r17 = httpRequestListener;
                                if (r17 != 0) {
                                    r17.onCompleted(str, i16, r26, obj);
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (UnknownHostException e36) {
                            e = e36;
                        } catch (IOException e37) {
                            e = e37;
                        } catch (Throwable th6) {
                            th = th6;
                            i16 = 200;
                        }
                    } catch (UnknownHostException e38) {
                        e = e38;
                        httpURLConnection = null;
                        bufferedInputStream = null;
                    } catch (IOException e39) {
                        e = e39;
                        httpURLConnection = null;
                        bufferedInputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        httpURLConnection = null;
                        i16 = 200;
                        r36 = 0;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        }).start();
        return true;
    }

    public static boolean httpPostRequest(final String str, final byte[] bArr, final Map<String, String> map, final Object obj, final int i3, final HttpRequestListener httpRequestListener) {
        Log.e(TAG, "httpPostRequest|url = " + str + "|| http request timeout =" + i3);
        new BaseThread(new Runnable() { // from class: com.tencent.av.HttpHelper.HttpHelper.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:43:0x012f  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0136  */
            /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x010e  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x0115  */
            /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v14 */
            /* JADX WARN: Type inference failed for: r0v16 */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v18 */
            /* JADX WARN: Type inference failed for: r0v19, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v24 */
            /* JADX WARN: Type inference failed for: r0v25 */
            /* JADX WARN: Type inference failed for: r0v26 */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r0v28 */
            /* JADX WARN: Type inference failed for: r0v29 */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.av.HttpHelper.HttpHelper$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.av.HttpHelper.HttpHelper$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r1v7, types: [com.tencent.av.HttpHelper.HttpHelper$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v11, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v23 */
            /* JADX WARN: Type inference failed for: r2v24 */
            /* JADX WARN: Type inference failed for: r2v25 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v29 */
            /* JADX WARN: Type inference failed for: r2v3, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r2v30 */
            /* JADX WARN: Type inference failed for: r2v31 */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1 */
            /* JADX WARN: Type inference failed for: r3v11 */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                HttpURLConnection httpURLConnection;
                int i16;
                IOException e16;
                BufferedInputStream bufferedInputStream;
                UnknownHostException e17;
                HttpRequestListener httpRequestListener2;
                String str2;
                Object obj2;
                int i17;
                ?? r26;
                ?? r06;
                HttpRequestListener httpRequestListener3;
                ?? r07 = "httpPostRequest|http request failed.";
                ?? r27 = 0;
                r2 = null;
                r2 = null;
                r27 = 0;
                r27 = 0;
                r27 = 0;
                r27 = 0;
                r2 = null;
                r2 = null;
                r27 = 0;
                r27 = 0;
                r2 = null;
                BufferedInputStream bufferedInputStream2 = null;
                ?? r36 = 200;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setConnectTimeout(i3);
                            httpURLConnection.setReadTimeout(i3);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "close");
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                            Map map2 = map;
                            if (map2 != null && !map2.isEmpty()) {
                                for (Map.Entry entry : map.entrySet()) {
                                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                }
                            }
                            httpURLConnection.getOutputStream().write(bArr);
                            i16 = httpURLConnection.getResponseCode();
                        } catch (UnknownHostException e18) {
                            e17 = e18;
                            r07 = r07;
                        } catch (IOException e19) {
                            e16 = e19;
                            r07 = r07;
                        } catch (Throwable th5) {
                            th = th5;
                            i16 = 200;
                        }
                    } catch (UnknownHostException e26) {
                        httpURLConnection = null;
                        e17 = e26;
                        bufferedInputStream = null;
                    } catch (IOException e27) {
                        httpURLConnection = null;
                        e16 = e27;
                        bufferedInputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection = null;
                        i16 = 200;
                        r36 = 0;
                    }
                    try {
                        if (i16 == 200) {
                            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10240);
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr2);
                                    if (read < 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                }
                                r07 = byteArrayOutputStream.toByteArray();
                                bufferedInputStream2 = bufferedInputStream;
                                r07 = r07;
                                r27 = bufferedInputStream2;
                            } catch (UnknownHostException e28) {
                                e17 = e28;
                                Log.e(HttpHelper.TAG, r07, e17);
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e29) {
                                        e29.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                httpRequestListener3 = httpRequestListener;
                                if (httpRequestListener3 == null) {
                                    str2 = str;
                                    obj2 = obj;
                                    i17 = 404;
                                    r06 = httpRequestListener3;
                                    r26 = bufferedInputStream2;
                                    r06.onCompleted(str2, i17, r26, obj2);
                                    return;
                                }
                                return;
                            } catch (IOException e36) {
                                e16 = e36;
                                Log.e(HttpHelper.TAG, r07, e16);
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e37) {
                                        e37.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                httpRequestListener2 = httpRequestListener;
                                if (httpRequestListener2 == null) {
                                    str2 = str;
                                    obj2 = obj;
                                    i17 = -1;
                                    r06 = httpRequestListener2;
                                    r26 = bufferedInputStream2;
                                    r06.onCompleted(str2, i17, r26, obj2);
                                    return;
                                }
                                return;
                            }
                        } else {
                            Log.e(HttpHelper.TAG, "httpPostRequest|http request failed. http response code =" + i16);
                            r07 = 0;
                        }
                        if (r27 != 0) {
                            try {
                                r27.close();
                            } catch (IOException e38) {
                                e38.printStackTrace();
                            }
                        }
                        httpURLConnection.disconnect();
                        ?? r16 = httpRequestListener;
                        if (r16 != 0) {
                            r16.onCompleted(str, i16, r07, obj);
                        }
                    } catch (UnknownHostException e39) {
                        e17 = e39;
                        r07 = r07;
                        bufferedInputStream2 = r27;
                        bufferedInputStream = bufferedInputStream2;
                        Log.e(HttpHelper.TAG, r07, e17);
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        httpRequestListener3 = httpRequestListener;
                        if (httpRequestListener3 == null) {
                        }
                    } catch (IOException e46) {
                        e16 = e46;
                        r07 = r07;
                        bufferedInputStream2 = r27;
                        bufferedInputStream = bufferedInputStream2;
                        Log.e(HttpHelper.TAG, r07, e16);
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        httpRequestListener2 = httpRequestListener;
                        if (httpRequestListener2 == null) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        r36 = r27;
                        if (r36 != 0) {
                            try {
                                r36.close();
                            } catch (IOException e47) {
                                e47.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        ?? r17 = httpRequestListener;
                        if (r17 != 0) {
                            r17.onCompleted(str, i16, r27, obj);
                            throw th;
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        }).start();
        return true;
    }
}

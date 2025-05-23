package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class w {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    public static n0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    private static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return k1.a(inputStream);
            } catch (IOException unused) {
                v.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
                k1.a((Closeable) inputStream);
                return "";
            }
        } finally {
            k1.a((Closeable) inputStream);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0152  */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.OutputStream, java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static n0 a(String str, byte[] bArr, Map<String, String> map, String str2) {
        HttpURLConnection httpURLConnection;
        ?? r95;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        HttpURLConnection httpURLConnection8;
        int responseCode;
        if (TextUtils.isEmpty(str)) {
            return new n0(-100, "");
        }
        String str3 = null;
        int i3 = -102;
        try {
            try {
                httpURLConnection = a(str, bArr.length, (Map<String, String>) map, str2);
                try {
                    if (httpURLConnection == null) {
                        n0 n0Var = new n0(-101, "");
                        k1.a((Closeable) null);
                        k1.a((Closeable) null);
                        if (httpURLConnection != null) {
                            k1.a(httpURLConnection);
                        }
                        return n0Var;
                    }
                    map = httpURLConnection.getOutputStream();
                    try {
                        r95 = new BufferedOutputStream(map);
                    } catch (a unused) {
                        r95 = 0;
                        httpURLConnection2 = httpURLConnection;
                        v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        n0 n0Var2 = new n0(-101, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection2 != null) {
                        }
                        return n0Var2;
                    } catch (SSLHandshakeException unused2) {
                        r95 = 0;
                        httpURLConnection5 = httpURLConnection;
                        v.f("hmsSdk", "Chain validation failed,Certificate expired");
                        n0 n0Var3 = new n0(i3, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection5 != null) {
                        }
                        return n0Var3;
                    } catch (SSLPeerUnverifiedException unused3) {
                        r95 = 0;
                        httpURLConnection4 = httpURLConnection;
                        v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                        n0 n0Var4 = new n0(i3, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection4 != null) {
                        }
                        return n0Var4;
                    } catch (IOException unused4) {
                        r95 = 0;
                        httpURLConnection3 = httpURLConnection;
                        v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                        n0 n0Var5 = new n0(i3, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection3 != null) {
                        }
                        return n0Var5;
                    } catch (SecurityException unused5) {
                        r95 = 0;
                        httpURLConnection8 = httpURLConnection;
                        v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                        n0 n0Var6 = new n0(i3, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection8 != null) {
                        }
                        return n0Var6;
                    } catch (ConnectException unused6) {
                        r95 = 0;
                        httpURLConnection7 = httpURLConnection;
                        v.f("hmsSdk", "Network is unreachable or Connection refused");
                        n0 n0Var7 = new n0(i3, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection7 != null) {
                        }
                        return n0Var7;
                    } catch (UnknownHostException unused7) {
                        r95 = 0;
                        httpURLConnection6 = httpURLConnection;
                        v.f("hmsSdk", "No address associated with hostname or No network");
                        n0 n0Var8 = new n0(i3, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection6 != null) {
                        }
                        return n0Var8;
                    } catch (Throwable th5) {
                        th = th5;
                        r95 = str3;
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            r95.write(bArr);
                            r95.flush();
                            responseCode = httpURLConnection.getResponseCode();
                        } catch (ConnectException unused8) {
                        } catch (UnknownHostException unused9) {
                        } catch (SSLHandshakeException unused10) {
                        } catch (SSLPeerUnverifiedException unused11) {
                        } catch (IOException unused12) {
                        } catch (SecurityException unused13) {
                        }
                        try {
                            n0 n0Var9 = new n0(responseCode, b(httpURLConnection));
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            k1.a(httpURLConnection);
                            return n0Var9;
                        } catch (SecurityException unused14) {
                            i3 = responseCode;
                            httpURLConnection8 = httpURLConnection;
                            v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                            n0 n0Var62 = new n0(i3, "");
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            if (httpURLConnection8 != null) {
                                k1.a(httpURLConnection8);
                            }
                            return n0Var62;
                        } catch (ConnectException unused15) {
                            i3 = responseCode;
                            httpURLConnection7 = httpURLConnection;
                            v.f("hmsSdk", "Network is unreachable or Connection refused");
                            n0 n0Var72 = new n0(i3, "");
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            if (httpURLConnection7 != null) {
                                k1.a(httpURLConnection7);
                            }
                            return n0Var72;
                        } catch (UnknownHostException unused16) {
                            i3 = responseCode;
                            httpURLConnection6 = httpURLConnection;
                            v.f("hmsSdk", "No address associated with hostname or No network");
                            n0 n0Var82 = new n0(i3, "");
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            if (httpURLConnection6 != null) {
                                k1.a(httpURLConnection6);
                            }
                            return n0Var82;
                        } catch (SSLHandshakeException unused17) {
                            i3 = responseCode;
                            httpURLConnection5 = httpURLConnection;
                            v.f("hmsSdk", "Chain validation failed,Certificate expired");
                            n0 n0Var32 = new n0(i3, "");
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            if (httpURLConnection5 != null) {
                                k1.a(httpURLConnection5);
                            }
                            return n0Var32;
                        } catch (SSLPeerUnverifiedException unused18) {
                            i3 = responseCode;
                            httpURLConnection4 = httpURLConnection;
                            v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                            n0 n0Var42 = new n0(i3, "");
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            if (httpURLConnection4 != null) {
                                k1.a(httpURLConnection4);
                            }
                            return n0Var42;
                        } catch (IOException unused19) {
                            i3 = responseCode;
                            httpURLConnection3 = httpURLConnection;
                            v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                            n0 n0Var52 = new n0(i3, "");
                            k1.a((Closeable) r95);
                            k1.a((Closeable) map);
                            if (httpURLConnection3 != null) {
                                k1.a(httpURLConnection3);
                            }
                            return n0Var52;
                        }
                    } catch (a unused20) {
                        httpURLConnection2 = httpURLConnection;
                        v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        n0 n0Var22 = new n0(-101, "");
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection2 != null) {
                            k1.a(httpURLConnection2);
                        }
                        return n0Var22;
                    } catch (Throwable th6) {
                        th = th6;
                        k1.a((Closeable) r95);
                        k1.a((Closeable) map);
                        if (httpURLConnection != null) {
                            k1.a(httpURLConnection);
                        }
                        throw th;
                    }
                } catch (a unused21) {
                    map = 0;
                } catch (SecurityException unused22) {
                    map = 0;
                } catch (ConnectException unused23) {
                    map = 0;
                } catch (UnknownHostException unused24) {
                    map = 0;
                } catch (SSLHandshakeException unused25) {
                    map = 0;
                } catch (SSLPeerUnverifiedException unused26) {
                    map = 0;
                } catch (IOException unused27) {
                    map = 0;
                } catch (Throwable th7) {
                    th = th7;
                    map = 0;
                }
            } catch (a unused28) {
                httpURLConnection = null;
                map = 0;
            } catch (ConnectException unused29) {
                httpURLConnection = null;
                map = 0;
            } catch (SSLPeerUnverifiedException unused30) {
                httpURLConnection = null;
                map = 0;
            } catch (IOException unused31) {
                httpURLConnection = null;
                map = 0;
            } catch (SecurityException unused32) {
                httpURLConnection = null;
                map = 0;
            } catch (UnknownHostException unused33) {
                httpURLConnection = null;
                map = 0;
            } catch (SSLHandshakeException unused34) {
                httpURLConnection = null;
                map = 0;
            } catch (Throwable th8) {
                th = th8;
                httpURLConnection = null;
                map = 0;
            }
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection = null;
            str3 = str2;
        }
    }

    private static HttpURLConnection a(String str, int i3, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            v.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i3));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(HttpURLConnection httpURLConnection) {
        String str;
        SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(q0.i());
            } catch (IOException unused) {
                str = "getSocketFactory(): IO Exception!";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (IllegalAccessException unused2) {
                str = "getSocketFactory(): Illegal Access Exception ";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (KeyStoreException unused3) {
                str = "getSocketFactory(): Key Store exception";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (NoSuchAlgorithmException unused4) {
                str = "getSocketFactory(): Algorithm Exception!";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (GeneralSecurityException unused5) {
                str = "getSocketFactory(): General Security Exception";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            }
            if (secureSSLSocketFactory != null) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }
}

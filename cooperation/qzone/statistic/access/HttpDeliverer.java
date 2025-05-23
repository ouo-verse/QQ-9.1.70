package cooperation.qzone.statistic.access;

import android.net.Proxy;
import cooperation.qzone.statistic.access.concept.Deliverer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class HttpDeliverer extends Deliverer {
    public static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    public static final int DEFAULT_READ_TIMEOUT = 60000;
    public static final String GET = "GET";
    public static final String GZIP = "gzip";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_HOST = "Host";
    public static final String HEADER_X_ONLINE_HOST = "X-Online-Host";
    public static final int HTTP_CLIENT_ERROR = 400;
    public static final int HTTP_CODE_ERROR = 4096;
    public static final int HTTP_CONNECT_ERROR = 1024;
    public static final int HTTP_REDIRECT = 300;
    public static final int HTTP_SERVER_ERROR = 500;
    public static final int HTTP_SUCCESS = 200;
    public static final int HTTP_URL_NOT_AVALIBLE = 2048;
    public static final String POST = "POST";
    public static final char PROTOCOL_HOST_SPLITTER = '/';
    public static final char PROTOCOL_PORT_SPLITTER = ':';
    public static final String PROTOCOL_PREFIX = "https://";
    public static final int PROTOCOL_PREFIX_LENGTH = 8;
    public static final String TAG = "Statistic.Deliverer";
    protected boolean gzipEnabled = true;
    protected HttpMultiServer servers = new HttpMultiServer("https://wspeed.qq.com/w.cgi", false) { // from class: cooperation.qzone.statistic.access.HttpDeliverer.1
        @Override // cooperation.qzone.statistic.access.HttpMultiServer
        public String acquireOptionalServer() {
            return null;
        }

        @Override // cooperation.qzone.statistic.access.HttpMultiServer
        public String getOptionalRedirectHost() {
            return "wspeed.qq.com";
        }
    };

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class IProxy {
        public static IProxy Default = new IProxy() { // from class: cooperation.qzone.statistic.access.HttpDeliverer.IProxy.1
            @Override // cooperation.qzone.statistic.access.HttpDeliverer.IProxy
            public String getHost() {
                return Proxy.getDefaultHost();
            }

            @Override // cooperation.qzone.statistic.access.HttpDeliverer.IProxy
            public int getPort() {
                return Proxy.getDefaultPort();
            }
        };

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static class ProxyMode {
            public static final int Direct = 1;
            public static final int NeverTry = 0;
            public static final int ViaProxy = 2;
        }

        public abstract String getHost();

        public abstract int getPort();

        public String toString() {
            return getHost() + ':' + getPort();
        }
    }

    public HttpDeliverer(String str) {
        setServerURL(str);
    }

    public static int doRequest(String str, String str2, String str3, boolean z16, IProxy iProxy, int i3, int i16, String str4) {
        return doRequest(str, str2, str3 == null ? null : str3.getBytes(), z16, iProxy, i3, i16, str4);
    }

    public static String[] splitUrl(String str) {
        String[] strArr = new String[2];
        if (str != null) {
            int length = str.length();
            int i3 = PROTOCOL_PREFIX_LENGTH;
            if (length >= i3) {
                if (!str.toLowerCase().startsWith("https://")) {
                    str = "https://".concat(str);
                }
                int indexOf = str.indexOf(47, i3);
                if (indexOf <= i3) {
                    indexOf = str.length();
                }
                strArr[0] = str.substring(i3, indexOf);
                if (indexOf < str.length()) {
                    strArr[1] = str.substring(indexOf, str.length());
                } else {
                    strArr[1] = "";
                }
            }
        }
        return strArr;
    }

    @Override // cooperation.qzone.statistic.access.concept.Deliverer
    public int deliver(String str, int i3) {
        String str2;
        String optionalServer;
        String str3;
        if (i3 < 1) {
            return -1;
        }
        String defaultServer = getServers().getDefaultServer();
        if (i3 == 1) {
            str2 = "GET";
        } else {
            str2 = "POST";
        }
        int doRequest = doRequest(defaultServer, str2, str, this.gzipEnabled, getProxy(), 60000, 60000, (String) null);
        if (doRequest != 200 && (optionalServer = getServers().getOptionalServer()) != null) {
            if (i3 == 1) {
                str3 = "GET";
            } else {
                str3 = "POST";
            }
            doRequest = doRequest(optionalServer, str3, str, this.gzipEnabled, getProxy(), 60000, 60000, getServers().getOptionalRedirectHost());
        }
        if (doRequest == 200) {
            return 0;
        }
        return doRequest;
    }

    public IProxy getProxy() {
        return null;
    }

    public HttpMultiServer getServers() {
        return this.servers;
    }

    public void setGZipEnabled(boolean z16) {
        this.gzipEnabled = z16;
    }

    public void setServerURL(String str) {
        getServers().setDefaultServer(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0102 A[Catch: Exception -> 0x00cd, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x00cd, blocks: (B:27:0x00c8, B:79:0x0102, B:90:0x0117), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0117 A[Catch: Exception -> 0x00cd, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x00cd, blocks: (B:27:0x00c8, B:79:0x0102, B:90:0x0117), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v32, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v39, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v48 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v50 */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x00ce -> B:28:0x0152). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int doRequest(String str, String str2, byte[] bArr, boolean z16, IProxy iProxy, int i3, int i16, String str3) {
        String[] strArr;
        int i17 = 4096;
        OutputStream outputStream = null;
        try {
            try {
                if (iProxy != null) {
                    try {
                        String[] splitUrl = splitUrl(str);
                        strArr = splitUrl;
                        str = iProxy.toString() + splitUrl[1];
                    } catch (MalformedURLException e16) {
                        e = e16;
                        str2 = 0;
                        e.printStackTrace();
                        if (outputStream != null) {
                        }
                        if (str2 != 0) {
                        }
                        i17 = 2048;
                        return i17;
                    } catch (IOException e17) {
                        e = e17;
                        str2 = 0;
                        e.printStackTrace();
                        if (outputStream != null) {
                        }
                        if (str2 != 0) {
                        }
                        i17 = 1024;
                        return i17;
                    } catch (Error e18) {
                        e = e18;
                        str2 = 0;
                        e.printStackTrace();
                        if (outputStream != null) {
                        }
                        if (str2 != 0) {
                        }
                        return i17;
                    } catch (Exception e19) {
                        e = e19;
                        str2 = 0;
                        e.printStackTrace();
                        if (outputStream != null) {
                        }
                        if (str2 != 0) {
                        }
                        return i17;
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = 0;
                        if (outputStream != null) {
                        }
                        if (str2 == 0) {
                        }
                    }
                } else {
                    strArr = null;
                }
                if (!str.toLowerCase().startsWith("https://")) {
                    str = "https://".concat(str);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setReadTimeout(i16);
                    httpURLConnection.setConnectTimeout(i3);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod(str2);
                    httpURLConnection.setDoInput(true);
                    ?? r85 = str2;
                    if (str3 != null) {
                        int length = str3.length();
                        r85 = length;
                        if (length > 0) {
                            httpURLConnection.setRequestProperty("Host", str3);
                            r85 = "Host";
                        }
                    }
                    if (z16) {
                        r85 = "Content-Encoding";
                        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                    }
                    if (iProxy != null) {
                        r85 = "X-Online-Host";
                        httpURLConnection.setRequestProperty("X-Online-Host", strArr[0]);
                    }
                    if (bArr != null) {
                        httpURLConnection.setDoOutput(true);
                        r85 = httpURLConnection.getOutputStream();
                        try {
                            if (z16) {
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(r85);
                                gZIPOutputStream.write(bArr);
                                gZIPOutputStream.flush();
                                gZIPOutputStream.close();
                                outputStream = r85;
                            } else {
                                r85.write(bArr);
                                r85.flush();
                                r85.close();
                            }
                        } catch (MalformedURLException e26) {
                            outputStream = r85;
                            str2 = httpURLConnection;
                            e = e26;
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                try {
                                    str2.disconnect();
                                } catch (Exception e28) {
                                    e28.printStackTrace();
                                }
                            }
                            i17 = 2048;
                            return i17;
                        } catch (IOException e29) {
                            outputStream = r85;
                            str2 = httpURLConnection;
                            e = e29;
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e36) {
                                    e36.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                try {
                                    str2.disconnect();
                                } catch (Exception e37) {
                                    e37.printStackTrace();
                                }
                            }
                            i17 = 1024;
                            return i17;
                        } catch (Error e38) {
                            outputStream = r85;
                            str2 = httpURLConnection;
                            e = e38;
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e39) {
                                    e39.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                                str2 = str2;
                            }
                            return i17;
                        } catch (Exception e46) {
                            outputStream = r85;
                            str2 = httpURLConnection;
                            e = e46;
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e47) {
                                    e47.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                                str2 = str2;
                            }
                            return i17;
                        } catch (Throwable th6) {
                            outputStream = r85;
                            str2 = httpURLConnection;
                            th = th6;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e48) {
                                    e48.printStackTrace();
                                }
                            }
                            if (str2 == 0) {
                                try {
                                    str2.disconnect();
                                    throw th;
                                } catch (Exception e49) {
                                    e49.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } else {
                        httpURLConnection.setDoOutput(false);
                    }
                    i17 = httpURLConnection.getResponseCode();
                    IOException iOException = r85;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            iOException = r85;
                        } catch (IOException e56) {
                            e56.printStackTrace();
                            iOException = e56;
                        }
                    }
                    httpURLConnection.disconnect();
                    str2 = iOException;
                } catch (MalformedURLException e57) {
                    str2 = httpURLConnection;
                    e = e57;
                } catch (IOException e58) {
                    str2 = httpURLConnection;
                    e = e58;
                } catch (Error e59) {
                    str2 = httpURLConnection;
                    e = e59;
                } catch (Exception e65) {
                    str2 = httpURLConnection;
                    e = e65;
                } catch (Throwable th7) {
                    str2 = httpURLConnection;
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Exception e66) {
            e66.printStackTrace();
            str2 = str2;
        }
        return i17;
    }
}

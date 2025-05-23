package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.gcloudsdk.apollo.ApolloVoiceLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ChunkedURLRequest {
    private final int AV_HTTP_STATUS_SUCC = 0;
    private final int AV_HTTP_STATUS_FAIL = 1;
    private final int AV_HTTP_STATUS_TIMEOUT = 2;
    private final int AV_HTTP_STATUS_INVALIED_HOST = 3;
    private final int AV_HTTP_STATUS_INVALIED_URL = 4;
    private final int AV_HTTP_STATUS_NOHEADERS = 5;
    private final int AV_HTTP_STATUS_READBODY = 6;
    private final int AV_HTTP_STATUS_SEND_INCOMPLETE = 7;
    private final int AV_HTTP_STATUS_GET_CREATEFILE = 8;
    private final int AV_HTTP_STATUS_GET_WRITEFILE = 9;
    private final int AV_HTTP_STATUS_POST_READFILE = 10;
    private URL reqConnURL = null;
    private HttpURLConnection urlConn = null;
    private byte[] body = null;
    private long delegate = 0;
    private String method = "";
    private String url = "";
    private int timeout = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class RequestTask implements Runnable {
        RequestTask() {
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x01db: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:476), block:B:165:0x01db */
        @Override // java.lang.Runnable
        public void run() {
            OutputStream outputStream;
            BufferedOutputStream bufferedOutputStream;
            Exception e16;
            BufferedOutputStream bufferedOutputStream2 = null;
            Map<String, List<String>> map = null;
            OutputStream outputStream2 = null;
            BufferedOutputStream bufferedOutputStream3 = null;
            try {
            } catch (Throwable th5) {
                th = th5;
                outputStream2 = outputStream;
            }
            try {
                try {
                    if (ChunkedURLRequest.this.body != null) {
                        bufferedOutputStream = new BufferedOutputStream(ChunkedURLRequest.this.urlConn.getOutputStream());
                        try {
                            bufferedOutputStream.write(ChunkedURLRequest.this.body);
                            bufferedOutputStream.flush();
                        } catch (SocketTimeoutException unused) {
                            bufferedOutputStream3 = bufferedOutputStream;
                            ApolloVoiceLog.LogI("SocketTimeoutException");
                            ChunkedURLRequest.this.response2cpp(2);
                            if (bufferedOutputStream3 != null) {
                                try {
                                    bufferedOutputStream3.close();
                                    return;
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        } catch (UnknownHostException unused2) {
                            bufferedOutputStream2 = bufferedOutputStream;
                            ApolloVoiceLog.LogI("UnknownHost");
                            ChunkedURLRequest.this.response2cpp(3);
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                    return;
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        } catch (Exception e19) {
                            e16 = e19;
                            e16.printStackTrace();
                            ChunkedURLRequest.this.response2cpp(1);
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                    return;
                                } catch (Exception e26) {
                                    e26.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        }
                    } else if (ChunkedURLRequest.this.urlConn == null) {
                        ApolloVoiceLog.LogE("urlConn is null");
                        return;
                    } else {
                        ChunkedURLRequest.this.urlConn.connect();
                        bufferedOutputStream = null;
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e27) {
                            e27.printStackTrace();
                        }
                    }
                    try {
                        map = ChunkedURLRequest.this.urlConn.getHeaderFields();
                    } catch (Exception e28) {
                        e28.printStackTrace();
                    }
                    if (map != null && map.entrySet() != null) {
                        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                            String key = entry.getKey();
                            List<String> value = entry.getValue();
                            String str = "";
                            if (value != null) {
                                Iterator<String> it = value.iterator();
                                while (it.hasNext()) {
                                    str = str + it.next();
                                }
                            }
                            if (key != null) {
                                ApolloVoiceLog.LogI(key + ":" + str);
                                ChunkedURLRequest.header(ChunkedURLRequest.this.delegate, key + ":" + str);
                            }
                        }
                        try {
                            ChunkedURLRequest.this.urlConn.getResponseCode();
                        } catch (Exception e29) {
                            e29.printStackTrace();
                        }
                        try {
                            ChunkedURLRequest.this.urlConn.getResponseMessage();
                        } catch (Exception e36) {
                            e36.printStackTrace();
                        }
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(ChunkedURLRequest.this.urlConn.getInputStream());
                            byte[] bArr = new byte[1500];
                            while (true) {
                                try {
                                    try {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read != -1) {
                                            ApolloVoiceLog.LogI("len: " + read);
                                            ChunkedURLRequest.chunkeddata(ChunkedURLRequest.this.delegate, bArr, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e37) {
                                                e37.printStackTrace();
                                            }
                                        }
                                    } catch (Exception e38) {
                                        e38.printStackTrace();
                                        ChunkedURLRequest.this.response2cpp(6);
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e39) {
                                            e39.printStackTrace();
                                        }
                                        try {
                                            if (ChunkedURLRequest.this.urlConn != null) {
                                                ChunkedURLRequest.this.urlConn.disconnect();
                                                return;
                                            }
                                            return;
                                        } catch (Exception e46) {
                                            e46.printStackTrace();
                                            return;
                                        }
                                    }
                                } catch (Throwable th6) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e47) {
                                        e47.printStackTrace();
                                    }
                                    try {
                                        if (ChunkedURLRequest.this.urlConn != null) {
                                            ChunkedURLRequest.this.urlConn.disconnect();
                                            throw th6;
                                        }
                                        throw th6;
                                    } catch (Exception e48) {
                                        e48.printStackTrace();
                                        throw th6;
                                    }
                                }
                            }
                            bufferedInputStream.close();
                            try {
                                if (ChunkedURLRequest.this.urlConn != null) {
                                    ChunkedURLRequest.this.urlConn.disconnect();
                                }
                            } catch (Exception e49) {
                                e49.printStackTrace();
                            }
                            ChunkedURLRequest.this.response2cpp(0);
                            return;
                        } catch (Exception e56) {
                            e56.printStackTrace();
                            ChunkedURLRequest.this.response2cpp(1);
                            return;
                        }
                    }
                    ApolloVoiceLog.LogE("headerFields == null || headerFields.entrySet() == null");
                    ChunkedURLRequest.this.response2cpp(5);
                } catch (SocketTimeoutException unused3) {
                } catch (UnknownHostException unused4) {
                } catch (Exception e57) {
                    bufferedOutputStream = null;
                    e16 = e57;
                }
            } catch (Throwable th7) {
                th = th7;
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e58) {
                        e58.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static native void chunkeddata(long j3, byte[] bArr, int i3);

    public static native void header(long j3, String str);

    public static native void response(long j3, int i3);

    public void addHead(String str, String str2) {
        try {
            this.urlConn.setRequestProperty(str, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public int initWithURL(String str, int i3) {
        this.url = str;
        this.method = "POST";
        this.timeout = i3;
        try {
            URL url = new URL(this.url);
            this.reqConnURL = url;
            try {
                this.urlConn = (HttpURLConnection) url.openConnection();
                ApolloVoiceLog.LogI("After open Connection With URL: " + str);
                HttpURLConnection httpURLConnection = this.urlConn;
                if (httpURLConnection == null) {
                    ApolloVoiceLog.LogI("urlConn == null");
                    return -1;
                }
                try {
                    httpURLConnection.setRequestMethod(this.method);
                    try {
                        this.urlConn.setReadTimeout(i3);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    try {
                        this.urlConn.setConnectTimeout(i3);
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    try {
                        if (this.method == "POST") {
                            this.urlConn.setDoOutput(true);
                            this.urlConn.setUseCaches(false);
                        }
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                    return 0;
                } catch (ProtocolException e19) {
                    e19.printStackTrace();
                    return -1;
                } catch (Exception e26) {
                    e26.printStackTrace();
                    return -1;
                }
            } catch (Exception e27) {
                e27.printStackTrace();
                return -1;
            }
        } catch (MalformedURLException e28) {
            e28.printStackTrace();
            return -1;
        } catch (Exception e29) {
            e29.printStackTrace();
            return -1;
        }
    }

    public void quitHttp() {
        try {
            HttpURLConnection httpURLConnection = this.urlConn;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void response2cpp(int i3) {
        ApolloVoiceLog.LogI("url[" + this.url + "]response2cpp with result :" + i3);
        response(this.delegate, i3);
    }

    public void sendRequest() {
        new BaseThread(new RequestTask(), "GVoiceChunkedRequest").start();
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public void setDelegate(long j3) {
        this.delegate = j3;
    }

    public void setMethod(String str) {
        this.method = str;
        try {
            this.urlConn.setRequestMethod(str);
        } catch (ProtocolException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }
}

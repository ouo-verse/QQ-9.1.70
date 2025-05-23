package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.gcloudsdk.apollo.ApolloVoiceLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.video.decode.AVDecodeError;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes2.dex */
public class URLRequest {
    private byte[] body;
    private long delegate;
    private String getFilePath;
    private String method;
    private String postFilePath;
    private URL reqConnURL;
    private URLResponse response;
    private int timeout;
    private HttpURLConnection urlConn;
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
    private final int HTTP_OK = 0;
    private final int HTTP_CANNOT_FIND_FILE = -100;
    private final int HTTP_OPEN_FILE_SECURITY_EXCEPTION = -101;
    private final int HTTP_OPEN_FILE_OTERH_EXCEPTION = -102;
    private final int HTTP_UNKNOWN_HOST_EXCEPTION = -103;
    private final int HTTP_TIMEOUT_EXCEPTION = -104;
    private final int HTTP_POST_OTHER_EXCEPTION = -105;
    private final int HTTP_NO_HEADER_ERROR = -106;
    private final int HTTP_RESPONSE_ERROR_404 = -107;
    private final int HTTP_RESPONSE_FILE_NOT_FOUND_EXCEPTION = AVDecodeError.VIDEO_DECODE_V_ERR;
    private final int HTTP_RESPONSE_OTHER_EXCEPTION = AVDecodeError.VIDEO_DECODE_A_ERR;
    private final int HTTP_WRITE_FILE_ACCESS_EXCEPTION = -110;
    private final int HTTP_WRITE_FILE_SECURITY_EXCEPTION = -111;
    private final int HTTP_WRITE_FILE_OTHER_EXCEPTION = -112;
    private final int HTTP_READ_AND_WRITE_DATA_EXCEPTION = -113;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class RequestTask implements Runnable {
        private String filepath;

        public RequestTask(String str) {
            this.filepath = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:307:0x0588 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:314:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:315:0x057e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:325:0x05c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:332:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:333:0x05b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:343:0x054d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:350:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:351:0x0543 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:360:0x05d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:367:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:368:0x05ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v57, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.io.InputStream] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            FileInputStream fileInputStream;
            OutputStream outputStream;
            Map<String, List<String>> map;
            int i3;
            String str;
            BufferedInputStream bufferedInputStream;
            String str2;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        if (this.filepath != "" && URLRequest.this.method == "POST") {
                            try {
                                fileInputStream = new FileInputStream(this.filepath);
                            } catch (FileNotFoundException e16) {
                                ApolloVoiceLog.LogE("Post File,open file cannot find file");
                                e16.printStackTrace();
                                URLRequest.this.response.status = -100;
                                URLRequest.this.response.statusMsg = "open file cannot find file";
                                URLRequest.this.response2cpp(10);
                                return;
                            } catch (SecurityException e17) {
                                ApolloVoiceLog.LogE("Post File,open file security exception");
                                e17.printStackTrace();
                                URLRequest.this.response.status = -101;
                                URLRequest.this.response.statusMsg = "open file security exception";
                                URLRequest.this.response2cpp(10);
                                return;
                            } catch (Exception e18) {
                                ApolloVoiceLog.LogE("Post File,open file other exception");
                                e18.printStackTrace();
                                URLRequest.this.response.status = -102;
                                URLRequest.this.response.statusMsg = "open file other exception";
                                URLRequest.this.response2cpp(10);
                                return;
                            }
                        } else {
                            fileInputStream = null;
                        }
                        try {
                            ?? r85 = 1500;
                            if (URLRequest.this.body != null) {
                                ?? bufferedOutputStream = new BufferedOutputStream(URLRequest.this.urlConn.getOutputStream());
                                try {
                                    bufferedOutputStream.write(URLRequest.this.body);
                                    bufferedOutputStream.flush();
                                    outputStream = bufferedOutputStream;
                                } catch (SocketTimeoutException e19) {
                                    e = e19;
                                    fileOutputStream = bufferedOutputStream;
                                    ApolloVoiceLog.LogE("Post File,timeout exception");
                                    e.printStackTrace();
                                    URLRequest.this.response.status = -104;
                                    URLRequest.this.response.statusMsg = "timeout exception";
                                    URLRequest.this.response2cpp(2);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e26) {
                                            e26.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream == null) {
                                        try {
                                            fileInputStream.close();
                                            return;
                                        } catch (Exception e27) {
                                            e27.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                } catch (UnknownHostException e28) {
                                    e = e28;
                                    fileOutputStream = bufferedOutputStream;
                                    ApolloVoiceLog.LogE("Post File,unknown host exception");
                                    e.printStackTrace();
                                    URLRequest.this.response.status = -103;
                                    URLRequest.this.response.statusMsg = "unknown host exception";
                                    URLRequest.this.response2cpp(3);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e29) {
                                            e29.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream == null) {
                                        try {
                                            fileInputStream.close();
                                            return;
                                        } catch (Exception e36) {
                                            e36.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Exception e37) {
                                    e = e37;
                                    fileOutputStream = bufferedOutputStream;
                                    ApolloVoiceLog.LogE("Post File,other exception");
                                    e.printStackTrace();
                                    URLRequest.this.response.status = -105;
                                    URLRequest.this.response.statusMsg = "other exception";
                                    URLRequest.this.response2cpp(1);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e38) {
                                            e38.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream == null) {
                                        try {
                                            fileInputStream.close();
                                            return;
                                        } catch (Exception e39) {
                                            e39.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    fileOutputStream = bufferedOutputStream;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e46) {
                                            e46.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream == null) {
                                        try {
                                            fileInputStream.close();
                                            throw th;
                                        } catch (Exception e47) {
                                            e47.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } else if (this.filepath != "" && URLRequest.this.method == "POST" && fileInputStream != null) {
                                byte[] bArr = new byte[1500];
                                ?? bufferedOutputStream2 = new BufferedOutputStream(URLRequest.this.urlConn.getOutputStream());
                                while (true) {
                                    try {
                                        int read = fileInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                        bufferedOutputStream2.flush();
                                    } catch (SocketTimeoutException e48) {
                                        e = e48;
                                        fileOutputStream = bufferedOutputStream2;
                                        ApolloVoiceLog.LogE("Post File,timeout exception");
                                        e.printStackTrace();
                                        URLRequest.this.response.status = -104;
                                        URLRequest.this.response.statusMsg = "timeout exception";
                                        URLRequest.this.response2cpp(2);
                                        if (fileOutputStream != null) {
                                        }
                                        if (fileInputStream == null) {
                                        }
                                    } catch (UnknownHostException e49) {
                                        e = e49;
                                        fileOutputStream = bufferedOutputStream2;
                                        ApolloVoiceLog.LogE("Post File,unknown host exception");
                                        e.printStackTrace();
                                        URLRequest.this.response.status = -103;
                                        URLRequest.this.response.statusMsg = "unknown host exception";
                                        URLRequest.this.response2cpp(3);
                                        if (fileOutputStream != null) {
                                        }
                                        if (fileInputStream == null) {
                                        }
                                    } catch (Exception e56) {
                                        e = e56;
                                        fileOutputStream = bufferedOutputStream2;
                                        ApolloVoiceLog.LogE("Post File,other exception");
                                        e.printStackTrace();
                                        URLRequest.this.response.status = -105;
                                        URLRequest.this.response.statusMsg = "other exception";
                                        URLRequest.this.response2cpp(1);
                                        if (fileOutputStream != null) {
                                        }
                                        if (fileInputStream == null) {
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileOutputStream = bufferedOutputStream2;
                                        if (fileOutputStream != null) {
                                        }
                                        if (fileInputStream == null) {
                                        }
                                    }
                                }
                                outputStream = bufferedOutputStream2;
                            } else {
                                if (URLRequest.this.urlConn == null) {
                                    ApolloVoiceLog.LogE("urlConn is null");
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                            return;
                                        } catch (Exception e57) {
                                            e57.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                URLRequest.this.urlConn.connect();
                                outputStream = null;
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e58) {
                                    e58.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e59) {
                                    e59.printStackTrace();
                                }
                            }
                            try {
                                map = URLRequest.this.urlConn.getHeaderFields();
                            } catch (Exception e65) {
                                e65.printStackTrace();
                                map = null;
                            }
                            if (map != null && map.entrySet() != null) {
                                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                                    String key = entry.getKey();
                                    List<String> value = entry.getValue();
                                    if (value == null) {
                                        str2 = "";
                                    } else {
                                        Iterator<String> it = value.iterator();
                                        str2 = "";
                                        while (it.hasNext()) {
                                            str2 = str2 + it.next();
                                        }
                                    }
                                    if (key == null) {
                                        URLRequest.this.response.version = str2.split("\\ ")[0];
                                    } else {
                                        URLRequest.this.response.headers.put(key, str2);
                                    }
                                }
                                try {
                                    i3 = URLRequest.this.urlConn.getResponseCode();
                                } catch (Exception e66) {
                                    e66.printStackTrace();
                                    ApolloVoiceLog.LogE("getResponseCode exception.");
                                    i3 = 0;
                                }
                                try {
                                    str = URLRequest.this.urlConn.getResponseMessage();
                                } catch (Exception e67) {
                                    e67.printStackTrace();
                                    ApolloVoiceLog.LogE("getResponseMessage exception.");
                                    str = "";
                                }
                                ApolloVoiceLog.LogI("getResponse code=" + i3 + ",msg=" + str);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr2 = new byte[1500];
                                try {
                                    try {
                                        try {
                                            try {
                                                bufferedInputStream = new BufferedInputStream(URLRequest.this.urlConn.getInputStream());
                                                try {
                                                    if (this.filepath != "" && URLRequest.this.method == "GET") {
                                                        try {
                                                            File file = new File(this.filepath);
                                                            file.createNewFile();
                                                            fileOutputStream = new FileOutputStream(file);
                                                        } catch (FileNotFoundException e68) {
                                                            ApolloVoiceLog.LogE("Write File,Create File Error");
                                                            e68.printStackTrace();
                                                            URLRequest.this.response.status = -110;
                                                            URLRequest.this.response.statusMsg = "access file cannot find file exception";
                                                            URLRequest.this.response2cpp(8);
                                                            try {
                                                                byteArrayOutputStream.close();
                                                            } catch (Exception e69) {
                                                                e69.printStackTrace();
                                                            }
                                                            try {
                                                                bufferedInputStream.close();
                                                            } catch (Exception e75) {
                                                                e75.printStackTrace();
                                                            }
                                                            try {
                                                                if (URLRequest.this.urlConn != null) {
                                                                    URLRequest.this.urlConn.disconnect();
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (Exception e76) {
                                                                e76.printStackTrace();
                                                                return;
                                                            }
                                                        } catch (SecurityException e77) {
                                                            ApolloVoiceLog.LogE("Write File,access file security exception");
                                                            e77.printStackTrace();
                                                            URLRequest.this.response.status = -111;
                                                            URLRequest.this.response.statusMsg = "access file security exception";
                                                            URLRequest.this.response2cpp(8);
                                                            try {
                                                                byteArrayOutputStream.close();
                                                            } catch (Exception e78) {
                                                                e78.printStackTrace();
                                                            }
                                                            try {
                                                                bufferedInputStream.close();
                                                            } catch (Exception e79) {
                                                                e79.printStackTrace();
                                                            }
                                                            try {
                                                                if (URLRequest.this.urlConn != null) {
                                                                    URLRequest.this.urlConn.disconnect();
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (Exception e85) {
                                                                e85.printStackTrace();
                                                                return;
                                                            }
                                                        } catch (Exception e86) {
                                                            ApolloVoiceLog.LogE("Write File,access file other exception");
                                                            e86.printStackTrace();
                                                            URLRequest.this.response.status = -112;
                                                            URLRequest.this.response.statusMsg = "access file other exception";
                                                            URLRequest.this.response2cpp(8);
                                                            try {
                                                                byteArrayOutputStream.close();
                                                            } catch (Exception e87) {
                                                                e87.printStackTrace();
                                                            }
                                                            try {
                                                                bufferedInputStream.close();
                                                            } catch (Exception e88) {
                                                                e88.printStackTrace();
                                                            }
                                                            try {
                                                                if (URLRequest.this.urlConn != null) {
                                                                    URLRequest.this.urlConn.disconnect();
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (Exception e89) {
                                                                e89.printStackTrace();
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    while (true) {
                                                        int read2 = bufferedInputStream.read(bArr2);
                                                        if (read2 == -1) {
                                                            break;
                                                        }
                                                        if (fileOutputStream == null) {
                                                            byteArrayOutputStream.write(bArr2, 0, read2);
                                                            byteArrayOutputStream.flush();
                                                        } else {
                                                            fileOutputStream.write(bArr2, 0, read2);
                                                            fileOutputStream.flush();
                                                        }
                                                    }
                                                    URLRequest.this.response.body = byteArrayOutputStream.toByteArray();
                                                    ApolloVoiceLog.LogE("Java body size is " + URLRequest.this.response.body.length);
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e95) {
                                                        e95.printStackTrace();
                                                    }
                                                    if (fileOutputStream != null) {
                                                        try {
                                                            fileOutputStream.close();
                                                        } catch (Exception e96) {
                                                            e96.printStackTrace();
                                                        }
                                                    }
                                                    try {
                                                        bufferedInputStream.close();
                                                    } catch (Exception e97) {
                                                        e97.printStackTrace();
                                                    }
                                                    try {
                                                        if (URLRequest.this.urlConn != null) {
                                                            URLRequest.this.urlConn.disconnect();
                                                        }
                                                    } catch (Exception e98) {
                                                        e98.printStackTrace();
                                                    }
                                                    URLRequest.this.response.status = 0;
                                                    URLRequest.this.response.statusMsg = "http ok";
                                                    URLRequest.this.response2cpp(0);
                                                } catch (Exception e99) {
                                                    e = e99;
                                                    e.printStackTrace();
                                                    URLRequest.this.response.status = -113;
                                                    URLRequest.this.response.statusMsg = "read http data and write data to file exception";
                                                    URLRequest.this.response2cpp(6);
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e100) {
                                                        e100.printStackTrace();
                                                    }
                                                    if (0 != 0) {
                                                        try {
                                                            fileOutputStream.close();
                                                        } catch (Exception e101) {
                                                            e101.printStackTrace();
                                                        }
                                                    }
                                                    if (bufferedInputStream != null) {
                                                        try {
                                                            bufferedInputStream.close();
                                                        } catch (Exception e102) {
                                                            e102.printStackTrace();
                                                        }
                                                    }
                                                    try {
                                                        if (URLRequest.this.urlConn != null) {
                                                            URLRequest.this.urlConn.disconnect();
                                                        }
                                                    } catch (Exception e103) {
                                                        e103.printStackTrace();
                                                    }
                                                }
                                            } catch (FileNotFoundException e104) {
                                                if (i3 == 404) {
                                                    URLRequest.this.response.status = -107;
                                                    URLRequest.this.response.statusMsg = "getInputStream 404.";
                                                    URLRequest.this.response2cpp(3);
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e105) {
                                                        e105.printStackTrace();
                                                    }
                                                    try {
                                                        if (URLRequest.this.urlConn != null) {
                                                            URLRequest.this.urlConn.disconnect();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Exception e106) {
                                                        e106.printStackTrace();
                                                        return;
                                                    }
                                                }
                                                URLRequest.this.response.status = AVDecodeError.VIDEO_DECODE_V_ERR;
                                                URLRequest.this.response.statusMsg = "getInputStream file not found exception.";
                                                e104.printStackTrace();
                                                URLRequest.this.response2cpp(1);
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e107) {
                                                    e107.printStackTrace();
                                                }
                                                try {
                                                    if (URLRequest.this.urlConn != null) {
                                                        URLRequest.this.urlConn.disconnect();
                                                    }
                                                } catch (Exception e108) {
                                                    e108.printStackTrace();
                                                }
                                            } catch (Exception e109) {
                                                URLRequest.this.response.status = AVDecodeError.VIDEO_DECODE_A_ERR;
                                                URLRequest.this.response.statusMsg = "getInputStream other exception.";
                                                e109.printStackTrace();
                                                URLRequest.this.response2cpp(1);
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e110) {
                                                    e110.printStackTrace();
                                                }
                                                try {
                                                    if (URLRequest.this.urlConn != null) {
                                                        URLRequest.this.urlConn.disconnect();
                                                    }
                                                } catch (Exception e111) {
                                                    e111.printStackTrace();
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e112) {
                                                e112.printStackTrace();
                                            }
                                            if (0 != 0) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Exception e113) {
                                                    e113.printStackTrace();
                                                }
                                            }
                                            if (r85 != 0) {
                                                try {
                                                    r85.close();
                                                } catch (Exception e114) {
                                                    e114.printStackTrace();
                                                }
                                            }
                                            try {
                                                if (URLRequest.this.urlConn != null) {
                                                    URLRequest.this.urlConn.disconnect();
                                                    throw th;
                                                }
                                                throw th;
                                            } catch (Exception e115) {
                                                e115.printStackTrace();
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e116) {
                                        e = e116;
                                        bufferedInputStream = null;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    r85 = 0;
                                }
                            } else {
                                ApolloVoiceLog.LogE("headerFields == null || headerFields.entrySet() == null");
                                URLRequest.this.response.status = -106;
                                URLRequest.this.response.statusMsg = "no header error";
                                URLRequest.this.response2cpp(5);
                            }
                        } catch (SocketTimeoutException e117) {
                            e = e117;
                        } catch (UnknownHostException e118) {
                            e = e118;
                        } catch (Exception e119) {
                            e = e119;
                        }
                    } catch (SocketTimeoutException e120) {
                        e = e120;
                        fileInputStream = null;
                    } catch (UnknownHostException e121) {
                        e = e121;
                        fileInputStream = null;
                    } catch (Exception e122) {
                        e = e122;
                        fileInputStream = null;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    fileInputStream = null;
                }
            } catch (Throwable th10) {
                th = th10;
            }
        }
    }

    public static native void response(int i3, long j3, int i16, String str, String str2, String str3, byte[] bArr, String[] strArr);

    public void addHead(String str, String str2) {
        this.urlConn.setRequestProperty(str, str2);
    }

    public void getFile(String str) {
        setMethod("GET");
        sendRequest(str);
    }

    public int initWithURL(String str, int i3) {
        URLResponse uRLResponse = new URLResponse();
        this.response = uRLResponse;
        uRLResponse.URL = str;
        this.method = "GET";
        this.timeout = i3;
        try {
            this.reqConnURL = new URL(this.response.URL);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        }
        URL url = this.reqConnURL;
        if (url == null) {
            ApolloVoiceLog.LogE("reqConnURL");
            return -1;
        }
        try {
            this.urlConn = (HttpURLConnection) url.openConnection();
            ApolloVoiceLog.LogI("After open Connection With URL: " + str);
            if (this.urlConn == null) {
                ApolloVoiceLog.LogI("urlConn == null");
                return -1;
            }
            if (HttpsUtils.connnectWithIP(str)) {
                HttpURLConnection httpURLConnection = this.urlConn;
                if (httpURLConnection instanceof HttpsURLConnection) {
                    try {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpsUtils.getHostNameVerify(str));
                    } catch (IllegalArgumentException e17) {
                        ApolloVoiceLog.LogE("Maybe HttpsUtils's HostnameVerifier or SSLSocketFactory is null!");
                        e17.printStackTrace();
                    }
                } else {
                    ApolloVoiceLog.LogI("urlConn is not an instance of HttpsURLConnection.");
                }
            }
            try {
                this.urlConn.setRequestMethod(this.method);
                this.urlConn.setReadTimeout(i3);
                if (this.method == "POST") {
                    this.urlConn.setDoOutput(true);
                    this.urlConn.setUseCaches(false);
                }
                this.urlConn.setConnectTimeout(i3);
                return 0;
            } catch (ProtocolException e18) {
                e18.printStackTrace();
                return -1;
            }
        } catch (Exception e19) {
            e19.printStackTrace();
            return -1;
        }
    }

    public void postFile(String str) {
        setMethod("POST");
        sendRequest(str);
    }

    public void response2cpp(int i3) {
        ApolloVoiceLog.LogI("url[" + this.response.URL + "]response2cpp with result :" + i3);
        if (i3 != 0) {
            response(i3, this.delegate, 0, "", this.response.URL, "", null, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.response.headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && key != null) {
                arrayList.add(key);
                arrayList.add(value);
            }
        }
        long j3 = this.delegate;
        URLResponse uRLResponse = this.response;
        response(i3, j3, uRLResponse.status, uRLResponse.statusMsg, uRLResponse.URL, uRLResponse.version, uRLResponse.body, (String[]) arrayList.toArray(new String[0]));
    }

    public void sendRequest() {
        this.method = "GET";
        sendRequest("");
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
        }
    }

    public void sendRequest(String str) {
        new BaseThread(new RequestTask(str), "GVoiceRequest").start();
    }
}

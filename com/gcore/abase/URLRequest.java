package com.gcore.abase;

import com.gcore.abase.log.XLog;
import com.gcore.abase.utils.FileUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class URLRequest {
    private static final int ABASE_WWW_FAILED = 1;
    private static final int ABASE_WWW_IOEXCEPTION = 6;
    private static final int ABASE_WWW_NETWORKEXCEPTION = 5;
    private static final int ABASE_WWW_SECURITYEXCEPTION = 7;
    private static final int ABASE_WWW_SUCC = 0;
    private static final int ABASE_WWW_TIMEOUT = 2;
    private static final int ABASE_WWW_UNKNOWNHOST = 3;
    private static final int ABASE_WWW_UNSUPPORTEDURL = 4;
    private static final int CHUNK = 128000;
    private static final int INIT = 0;
    private static final int PAUSE = 2;
    private static final int PROCESSING = 1;
    private static final String TAG = "URLRequest";
    private long dataTask;
    private long delegate;
    private long downloadTask;
    private long mDownloadDelegate;
    private String mFilePath;
    private String mUrlStr;
    private int timeout;
    private Map<String, String> mHeaders = new HashMap();
    private long mFileSize = 0;
    private long mFileCurrentSize = 0;
    private int mState = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class DownloadTask implements Runnable {
        DownloadTask() {
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x01aa A[Catch: Exception -> 0x01a6, TryCatch #5 {Exception -> 0x01a6, blocks: (B:111:0x01a2, B:100:0x01aa, B:102:0x01af), top: B:110:0x01a2 }] */
        /* JADX WARN: Removed duplicated region for block: B:102:0x01af A[Catch: Exception -> 0x01a6, TRY_LEAVE, TryCatch #5 {Exception -> 0x01a6, blocks: (B:111:0x01a2, B:100:0x01aa, B:102:0x01af), top: B:110:0x01a2 }] */
        /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:110:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x0266 A[Catch: Exception -> 0x0262, TryCatch #6 {Exception -> 0x0262, blocks: (B:137:0x025e, B:126:0x0266, B:128:0x026b), top: B:136:0x025e }] */
        /* JADX WARN: Removed duplicated region for block: B:128:0x026b A[Catch: Exception -> 0x0262, TRY_LEAVE, TryCatch #6 {Exception -> 0x0262, blocks: (B:137:0x025e, B:126:0x0266, B:128:0x026b), top: B:136:0x025e }] */
        /* JADX WARN: Removed duplicated region for block: B:135:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:136:0x025e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0218 A[Catch: Exception -> 0x0214, TryCatch #13 {Exception -> 0x0214, blocks: (B:63:0x0210, B:52:0x0218, B:54:0x021d), top: B:62:0x0210 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x021d A[Catch: Exception -> 0x0214, TRY_LEAVE, TryCatch #13 {Exception -> 0x0214, blocks: (B:63:0x0210, B:52:0x0218, B:54:0x021d), top: B:62:0x0210 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x024d A[Catch: Exception -> 0x0249, TryCatch #11 {Exception -> 0x0249, blocks: (B:79:0x0245, B:68:0x024d, B:70:0x0252), top: B:78:0x0245 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0252 A[Catch: Exception -> 0x0249, TRY_LEAVE, TryCatch #11 {Exception -> 0x0249, blocks: (B:79:0x0245, B:68:0x024d, B:70:0x0252), top: B:78:0x0245 }] */
        /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0245 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01e3 A[Catch: Exception -> 0x01df, TryCatch #3 {Exception -> 0x01df, blocks: (B:95:0x01db, B:84:0x01e3, B:86:0x01e8), top: B:94:0x01db }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01e8 A[Catch: Exception -> 0x01df, TRY_LEAVE, TryCatch #3 {Exception -> 0x01df, blocks: (B:95:0x01db, B:84:0x01e3, B:86:0x01e8), top: B:94:0x01db }] */
        /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th5;
            RandomAccessFile randomAccessFile;
            HttpURLConnection httpURLConnection;
            RandomAccessFile randomAccessFile2;
            InputStream inputStream = null;
            try {
                try {
                    URL url = new URL(URLRequest.this.mUrlStr);
                    if (URLRequest.this.mState == 0) {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection2.setReadTimeout(URLRequest.this.timeout);
                            httpURLConnection2.setConnectTimeout(URLRequest.this.timeout);
                            if (!URLRequest.this.initDownload(httpURLConnection2)) {
                                URLRequest uRLRequest = URLRequest.this;
                                uRLRequest.JNITaskFinished(uRLRequest.mDownloadDelegate, 4, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    return;
                                }
                            }
                        } catch (SocketTimeoutException unused) {
                            httpURLConnection = httpURLConnection2;
                            randomAccessFile2 = null;
                            XLog.e(URLRequest.TAG, "SocketTimeoutException");
                            URLRequest uRLRequest2 = URLRequest.this;
                            uRLRequest2.JNITaskFinished(uRLRequest2.mDownloadDelegate, 2, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                        } catch (UnknownHostException unused2) {
                            httpURLConnection = httpURLConnection2;
                            randomAccessFile2 = null;
                            XLog.e(URLRequest.TAG, "UnknownHost");
                            URLRequest uRLRequest3 = URLRequest.this;
                            uRLRequest3.JNITaskFinished(uRLRequest3.mDownloadDelegate, 3, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                        } catch (IOException e17) {
                            e = e17;
                            httpURLConnection = httpURLConnection2;
                            randomAccessFile2 = null;
                            XLog.e(URLRequest.TAG, "IOException");
                            e.printStackTrace();
                            URLRequest uRLRequest4 = URLRequest.this;
                            uRLRequest4.JNITaskFinished(uRLRequest4.mDownloadDelegate, 6, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                        } catch (Exception e18) {
                            e = e18;
                            httpURLConnection = httpURLConnection2;
                            randomAccessFile2 = null;
                            XLog.e(URLRequest.TAG, "Exception error=" + e.toString());
                            e.printStackTrace();
                            URLRequest uRLRequest5 = URLRequest.this;
                            uRLRequest5.JNITaskFinished(uRLRequest5.mDownloadDelegate, 1, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            httpURLConnection = httpURLConnection2;
                            randomAccessFile = null;
                            if (0 != 0) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (randomAccessFile == null) {
                            }
                        }
                    }
                    URLRequest.this.mState = 1;
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(URLRequest.this.timeout);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setRequestProperty("Range", "bytes=" + URLRequest.this.mFileCurrentSize + "-" + URLRequest.this.mFileSize);
                        URLRequest.this.addHeadersToConn(httpURLConnection);
                        randomAccessFile2 = new RandomAccessFile(URLRequest.this.mFilePath, "rwd");
                    } catch (SocketTimeoutException unused3) {
                        randomAccessFile2 = null;
                        XLog.e(URLRequest.TAG, "SocketTimeoutException");
                        URLRequest uRLRequest22 = URLRequest.this;
                        uRLRequest22.JNITaskFinished(uRLRequest22.mDownloadDelegate, 2, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (randomAccessFile2 != null) {
                        }
                    } catch (UnknownHostException unused4) {
                        randomAccessFile2 = null;
                        XLog.e(URLRequest.TAG, "UnknownHost");
                        URLRequest uRLRequest32 = URLRequest.this;
                        uRLRequest32.JNITaskFinished(uRLRequest32.mDownloadDelegate, 3, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (randomAccessFile2 != null) {
                        }
                    } catch (IOException e19) {
                        e = e19;
                        randomAccessFile2 = null;
                        XLog.e(URLRequest.TAG, "IOException");
                        e.printStackTrace();
                        URLRequest uRLRequest42 = URLRequest.this;
                        uRLRequest42.JNITaskFinished(uRLRequest42.mDownloadDelegate, 6, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (randomAccessFile2 != null) {
                        }
                    } catch (Exception e26) {
                        e = e26;
                        randomAccessFile2 = null;
                        XLog.e(URLRequest.TAG, "Exception error=" + e.toString());
                        e.printStackTrace();
                        URLRequest uRLRequest52 = URLRequest.this;
                        uRLRequest52.JNITaskFinished(uRLRequest52.mDownloadDelegate, 1, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (randomAccessFile2 != null) {
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        randomAccessFile = null;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e27) {
                                e27.printStackTrace();
                                throw th5;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (randomAccessFile == null) {
                            randomAccessFile.close();
                            throw th5;
                        }
                        throw th5;
                    }
                    try {
                        randomAccessFile2.seek(URLRequest.this.mFileCurrentSize);
                        inputStream = httpURLConnection.getInputStream();
                        byte[] bArr = new byte[6144];
                        try {
                            do {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    randomAccessFile2.write(bArr, 0, read);
                                    URLRequest.this.mFileCurrentSize += read;
                                    URLRequest uRLRequest6 = URLRequest.this;
                                    uRLRequest6.JNITaskProgress(uRLRequest6.mDownloadDelegate, URLRequest.this.mFileCurrentSize, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                                    if (URLRequest.this.mState != 2) {
                                    }
                                    inputStream.close();
                                    httpURLConnection.disconnect();
                                    randomAccessFile2.close();
                                }
                                URLRequest uRLRequest7 = URLRequest.this;
                                uRLRequest7.JNITaskFinished(uRLRequest7.mDownloadDelegate, 0, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                                URLRequest.this.uninit();
                                try {
                                    inputStream.close();
                                    httpURLConnection.disconnect();
                                    randomAccessFile2.close();
                                    return;
                                } catch (Exception e28) {
                                    e28.printStackTrace();
                                    return;
                                }
                            } while (URLRequest.this.mState != 0);
                            inputStream.close();
                            httpURLConnection.disconnect();
                            randomAccessFile2.close();
                        } catch (Exception e29) {
                            e29.printStackTrace();
                        }
                    } catch (SocketTimeoutException unused5) {
                        XLog.e(URLRequest.TAG, "SocketTimeoutException");
                        URLRequest uRLRequest222 = URLRequest.this;
                        uRLRequest222.JNITaskFinished(uRLRequest222.mDownloadDelegate, 2, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e36) {
                                e36.printStackTrace();
                                return;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                    } catch (UnknownHostException unused6) {
                        XLog.e(URLRequest.TAG, "UnknownHost");
                        URLRequest uRLRequest322 = URLRequest.this;
                        uRLRequest322.JNITaskFinished(uRLRequest322.mDownloadDelegate, 3, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e37) {
                                e37.printStackTrace();
                                return;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                    } catch (IOException e38) {
                        e = e38;
                        XLog.e(URLRequest.TAG, "IOException");
                        e.printStackTrace();
                        URLRequest uRLRequest422 = URLRequest.this;
                        uRLRequest422.JNITaskFinished(uRLRequest422.mDownloadDelegate, 6, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e39) {
                                e39.printStackTrace();
                                return;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                    } catch (Exception e46) {
                        e = e46;
                        XLog.e(URLRequest.TAG, "Exception error=" + e.toString());
                        e.printStackTrace();
                        URLRequest uRLRequest522 = URLRequest.this;
                        uRLRequest522.JNITaskFinished(uRLRequest522.mDownloadDelegate, 1, URLRequest.this.mFileSize, URLRequest.this.downloadTask);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e47) {
                                e47.printStackTrace();
                                return;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                    }
                } catch (SocketTimeoutException unused7) {
                    randomAccessFile2 = null;
                    httpURLConnection = null;
                } catch (UnknownHostException unused8) {
                    randomAccessFile2 = null;
                    httpURLConnection = null;
                } catch (IOException e48) {
                    e = e48;
                    randomAccessFile2 = null;
                    httpURLConnection = null;
                } catch (Exception e49) {
                    e = e49;
                    randomAccessFile2 = null;
                    httpURLConnection = null;
                } catch (Throwable th8) {
                    th5 = th8;
                    randomAccessFile = null;
                    httpURLConnection = null;
                }
            } catch (Throwable th9) {
                th5 = th9;
            }
        }
    }

    private void JNITaskBegan(long j3, long j16, long j17) {
        try {
            nativeTaskBegan(j3, j16, j17);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JNITaskFinished(long j3, int i3, long j16, long j17) {
        try {
            nativeTaskFinished(j3, i3, j16, j17);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JNITaskProgress(long j3, long j16, long j17, long j18) {
        try {
            nativeTaskProgress(j3, j16, j17, j18);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHeadersToConn(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            XLog.e(TAG, "urlConn is null!");
            return;
        }
        for (String str : this.mHeaders.keySet()) {
            httpURLConnection.setRequestProperty(str, this.mHeaders.get(str));
        }
    }

    public static void init() {
        XLog.i(TAG, "URLRequest init");
        try {
            nativeInit();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initDownload(HttpURLConnection httpURLConnection) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                if (httpURLConnection == null) {
                    XLog.e(TAG, "urlConn is null");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(null);
                    return false;
                }
                this.mFileCurrentSize = 0L;
                File file = new File(this.mFilePath);
                if (!file.exists() && !file.createNewFile()) {
                    XLog.e(TAG, "createNewFile failed");
                    httpURLConnection.disconnect();
                    FileUtils.closeQuietly(null);
                    return false;
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                try {
                    long contentLength = httpURLConnection.getContentLength();
                    this.mFileSize = contentLength;
                    if (contentLength == -1) {
                        XLog.i(TAG, "get fileSize Fail");
                        randomAccessFile2.close();
                        httpURLConnection.disconnect();
                        FileUtils.closeQuietly(randomAccessFile2);
                        return false;
                    }
                    XLog.i(TAG, "fileSize" + this.mFileSize);
                    randomAccessFile2.setLength(this.mFileSize);
                    JNITaskBegan(this.mDownloadDelegate, this.mFileSize, this.downloadTask);
                    randomAccessFile2.close();
                    httpURLConnection.disconnect();
                    FileUtils.closeQuietly(randomAccessFile2);
                    return true;
                } catch (SocketTimeoutException unused) {
                    randomAccessFile = randomAccessFile2;
                    XLog.e(TAG, "SocketTimeoutException");
                    JNITaskFinished(this.mDownloadDelegate, 2, this.mFileSize, this.downloadTask);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (UnknownHostException unused2) {
                    randomAccessFile = randomAccessFile2;
                    XLog.e(TAG, "UnknownHost");
                    JNITaskFinished(this.mDownloadDelegate, 3, this.mFileSize, this.downloadTask);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (Exception e16) {
                    e = e16;
                    randomAccessFile = randomAccessFile2;
                    JNITaskFinished(this.mDownloadDelegate, 1, this.mFileSize, this.downloadTask);
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    FileUtils.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (SocketTimeoutException unused3) {
            } catch (UnknownHostException unused4) {
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static native void nativeInit();

    public static native void nativeResponse(int i3, long j3, int i16, String str, String str2, String str3, byte[] bArr, String[] strArr, long j16);

    public static native void nativeTaskBegan(long j3, long j16, long j17);

    public static native void nativeTaskFinished(long j3, int i3, long j16, long j17);

    public static native void nativeTaskProgress(long j3, long j16, long j17, long j18);

    /* JADX INFO: Access modifiers changed from: private */
    public void uninit() {
        this.mState = 0;
        this.mFileCurrentSize = 0L;
        this.mFileSize = 0L;
    }

    public void addHead(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public void cancel() {
        uninit();
    }

    public void downloadFile(String str) {
        this.mFilePath = str;
        if (this.mState == 1) {
            return;
        }
        new BaseThread(new DownloadTask()).start();
    }

    public void get(String str) {
        this.mUrlStr = str;
        new BaseThread(new RequestTask()).start();
    }

    public int initWithURL(String str, int i3) {
        this.mUrlStr = str;
        this.timeout = i3;
        return 0;
    }

    public void pause() {
        if (this.mState == 1) {
            this.mState = 2;
        }
    }

    public void post(String str, byte[] bArr) {
        this.mUrlStr = str;
        new BaseThread(new RequestTask(bArr)).start();
    }

    public void response2cpp(URLResponse uRLResponse, int i3) {
        XLog.i(TAG, "url[" + uRLResponse.URL + "]response2cpp with result :" + i3);
        if (i3 != 0) {
            try {
                nativeResponse(i3, this.delegate, 0, "", uRLResponse.URL, "", null, null, this.dataTask);
                return;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : uRLResponse.headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && key != null) {
                arrayList.add(key);
                arrayList.add(value);
            }
        }
        try {
            nativeResponse(i3, this.delegate, uRLResponse.status, uRLResponse.statusMsg, uRLResponse.URL, uRLResponse.version, uRLResponse.body, (String[]) arrayList.toArray(new String[0]), this.dataTask);
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    public void setDelegate(long j3, long j16) {
        this.delegate = j3;
        this.dataTask = j16;
    }

    public void setDownloadDelegate(long j3, long j16) {
        this.mDownloadDelegate = j3;
        this.downloadTask = j16;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class RequestTask implements Runnable {
        byte[] mBody;

        RequestTask() {
            this.mBody = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            URLResponse uRLResponse = new URLResponse();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URLRequest.this.mUrlStr).openConnection();
                httpURLConnection.setReadTimeout(URLRequest.this.timeout);
                httpURLConnection.setConnectTimeout(URLRequest.this.timeout);
                URLRequest.this.addHeadersToConn(httpURLConnection);
                if (this.mBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(this.mBody);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                httpURLConnection.connect();
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (headerFields != null && headerFields.entrySet() != null) {
                        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                            String key = entry.getKey();
                            List<String> value = entry.getValue();
                            StringBuilder sb5 = new StringBuilder();
                            if (value != null) {
                                Iterator<String> it = value.iterator();
                                while (it.hasNext()) {
                                    sb5.append(it.next());
                                }
                            }
                            if (key == null) {
                                uRLResponse.version = sb5.toString().split("\\ ")[0];
                            } else {
                                uRLResponse.headers.put(key, sb5.toString());
                            }
                        }
                        try {
                            uRLResponse.status = httpURLConnection.getResponseCode();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            uRLResponse.status = 0;
                        }
                        try {
                            uRLResponse.statusMsg = httpURLConnection.getResponseMessage();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            uRLResponse.statusMsg = "No Status Message!";
                        }
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[6144];
                            while (true) {
                                try {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            byteArrayOutputStream.flush();
                                            byteArrayOutputStream.close();
                                            uRLResponse.body = byteArrayOutputStream.toByteArray();
                                            URLRequest.this.response2cpp(uRLResponse, 0);
                                            return;
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                            URLRequest.this.response2cpp(uRLResponse, 6);
                                            return;
                                        }
                                    }
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                    URLRequest.this.response2cpp(uRLResponse, 6);
                                    return;
                                }
                            }
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            URLRequest.this.response2cpp(uRLResponse, 6);
                            return;
                        }
                    }
                    XLog.e(URLRequest.TAG, "headerFields == null || headerFields.entrySet() == null");
                } catch (Exception e27) {
                    XLog.e(URLRequest.TAG, "Read head Exception error=" + e27.toString());
                    URLRequest.this.response2cpp(uRLResponse, 1);
                }
            } catch (SecurityException e28) {
                XLog.e(URLRequest.TAG, "SecurityException error=" + e28.toString());
                URLRequest.this.response2cpp(uRLResponse, 7);
            } catch (SocketTimeoutException unused) {
                XLog.e(URLRequest.TAG, "SocketTimeoutException");
                URLRequest.this.response2cpp(uRLResponse, 2);
            } catch (UnknownHostException unused2) {
                XLog.e(URLRequest.TAG, "UnknownHost");
                URLRequest.this.response2cpp(uRLResponse, 3);
            } catch (IOException e29) {
                XLog.e(URLRequest.TAG, "IOException");
                e29.printStackTrace();
                URLRequest.this.response2cpp(uRLResponse, 6);
            } catch (Exception e36) {
                XLog.e(URLRequest.TAG, "Exception error=" + e36.toString());
                URLRequest.this.response2cpp(uRLResponse, 1);
            }
        }

        RequestTask(byte[] bArr) {
            this.mBody = bArr;
        }
    }

    public void setBody(byte[] bArr) {
    }
}

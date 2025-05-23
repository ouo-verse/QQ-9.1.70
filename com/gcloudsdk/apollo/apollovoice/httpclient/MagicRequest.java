package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.gcloudsdk.apollo.ApolloVoiceLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MagicRequest {
    private static String LOGTAG = "GCloudVoice";
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
    private boolean mInit = false;
    private long mDelegate = 0;
    private int mHttpCnt = 0;
    ExecutorService mFixedThreadPool = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class MagicHTTPTask {
        public String mContent;
        public int mEnd;
        public int mSeq;
        public String mSession;
        public int mTimeout;
        public String mToken;
        public String mUrl;

        public MagicHTTPTask(String str, String str2, String str3, String str4, int i3, int i16, int i17) {
            this.mSession = str;
            this.mUrl = str2;
            this.mToken = str3;
            this.mContent = str4;
            this.mSeq = i3;
            this.mEnd = i16;
            this.mTimeout = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class RunTask implements Runnable {
        private MagicHTTPTask mTask;

        public RunTask(MagicHTTPTask magicHTTPTask) {
            this.mTask = magicHTTPTask;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0174  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void dealTask() {
            URL url;
            HttpURLConnection httpURLConnection;
            int i3;
            ByteArrayOutputStream byteArrayOutputStream;
            int i16;
            ApolloVoiceLog.LogI("rsts http begin, seq=" + this.mTask.mSeq);
            byte[] bArr = null;
            try {
                url = new URL(this.mTask.mUrl);
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                url = null;
            }
            if (url == null) {
                ApolloVoiceLog.LogE("reqConnURL");
                i3 = 4;
            } else {
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (Exception e17) {
                    e17.printStackTrace();
                    httpURLConnection = null;
                }
                ApolloVoiceLog.LogI("After open Connection With URL:" + this.mTask.mUrl);
                if (httpURLConnection == null) {
                    ApolloVoiceLog.LogI("urlConn == null");
                    i3 = 3;
                } else {
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Connection", "keep-alive");
                        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                        httpURLConnection.setRequestProperty("Authorization", this.mTask.mToken);
                        httpURLConnection.setReadTimeout(this.mTask.mTimeout);
                        httpURLConnection.setConnectTimeout(this.mTask.mTimeout);
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                try {
                                    bufferedOutputStream.write(this.mTask.mContent.getBytes("UTF-8"));
                                    bufferedOutputStream.flush();
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            try {
                                                try {
                                                    int read = bufferedInputStream.read(bArr2);
                                                    if (read == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream.write(bArr2, 0, read);
                                                    }
                                                } catch (Throwable th5) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e19) {
                                                        e19.printStackTrace();
                                                    }
                                                    try {
                                                        bufferedInputStream.close();
                                                    } catch (Exception e26) {
                                                        e26.printStackTrace();
                                                    }
                                                    try {
                                                        httpURLConnection.disconnect();
                                                        throw th5;
                                                    } catch (Exception e27) {
                                                        e27.printStackTrace();
                                                        throw th5;
                                                    }
                                                }
                                            } catch (IOException e28) {
                                                e28.printStackTrace();
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e29) {
                                                    e29.printStackTrace();
                                                }
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (Exception e36) {
                                                    e36.printStackTrace();
                                                }
                                                try {
                                                    httpURLConnection.disconnect();
                                                } catch (Exception e37) {
                                                    e37.printStackTrace();
                                                }
                                                i3 = 6;
                                            }
                                        }
                                        byteArrayOutputStream.flush();
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e38) {
                                            e38.printStackTrace();
                                        }
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e39) {
                                            e39.printStackTrace();
                                        }
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Exception e46) {
                                            e46.printStackTrace();
                                        }
                                        i16 = 0;
                                    } catch (IOException e47) {
                                        e47.printStackTrace();
                                        i3 = 1;
                                    }
                                } catch (Throwable th6) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e48) {
                                        e48.printStackTrace();
                                    }
                                    throw th6;
                                }
                            } catch (IOException e49) {
                                e49.printStackTrace();
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e56) {
                                    e56.printStackTrace();
                                }
                                i3 = 7;
                            }
                        } catch (IOException e57) {
                            e57.printStackTrace();
                            i3 = 9;
                        }
                    } catch (ProtocolException e58) {
                        e58.printStackTrace();
                        i3 = 10;
                    }
                    MagicRequest.access$006(MagicRequest.this);
                    long j3 = MagicRequest.this.mDelegate;
                    MagicHTTPTask magicHTTPTask = this.mTask;
                    String str = magicHTTPTask.mSession;
                    int i17 = magicHTTPTask.mSeq;
                    int i18 = magicHTTPTask.mEnd;
                    if (byteArrayOutputStream != null) {
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    MagicRequest.response(j3, i16, str, i17, i18, bArr);
                }
            }
            byteArrayOutputStream = null;
            i16 = i3;
            MagicRequest.access$006(MagicRequest.this);
            long j36 = MagicRequest.this.mDelegate;
            MagicHTTPTask magicHTTPTask2 = this.mTask;
            String str2 = magicHTTPTask2.mSession;
            int i172 = magicHTTPTask2.mSeq;
            int i182 = magicHTTPTask2.mEnd;
            if (byteArrayOutputStream != null) {
            }
            MagicRequest.response(j36, i16, str2, i172, i182, bArr);
        }

        @Override // java.lang.Runnable
        public void run() {
            dealTask();
        }
    }

    static /* synthetic */ int access$006(MagicRequest magicRequest) {
        int i3 = magicRequest.mHttpCnt - 1;
        magicRequest.mHttpCnt = i3;
        return i3;
    }

    public static native void response(long j3, int i3, String str, int i16, int i17, byte[] bArr);

    public int addTask(String str, String str2, String str3, String str4, int i3, int i16, int i17) {
        if (!this.mInit) {
            return -1;
        }
        if (this.mHttpCnt > 1600) {
            ApolloVoiceLog.LogE("too many https task waiting...");
            return -1;
        }
        MagicHTTPTask magicHTTPTask = new MagicHTTPTask(str, str2, str3, str4, i3, i16, i17);
        this.mHttpCnt++;
        this.mFixedThreadPool.submit(new RunTask(magicHTTPTask));
        return 0;
    }

    public void setDelegate(long j3) {
        this.mHttpCnt = 0;
        this.mDelegate = j3;
        this.mFixedThreadPool = ProxyExecutors.newFixedThreadPool(10);
        this.mInit = true;
    }
}

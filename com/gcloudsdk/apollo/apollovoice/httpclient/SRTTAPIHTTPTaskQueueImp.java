package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.gcloudsdk.apollo.ApolloVoiceLog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public class SRTTAPIHTTPTaskQueueImp {
    public static final int RSTT_HTTP_ERR_FAIL = 1;
    public static final int RSTT_HTTP_ERR_SUCC = 0;
    public static final int RSTT_HTTP_ERR_getInputStream_IOException = 13;
    public static final int RSTT_HTTP_ERR_getInputStream_UnknownServiceException = 12;
    public static final int RSTT_HTTP_ERR_getOutputStream_IOException = 16;
    public static final int RSTT_HTTP_ERR_getResponseCode_IOException = 17;
    public static final int RSTT_HTTP_ERR_new_URL = 10;
    public static final int RSTT_HTTP_ERR_openConnection = 11;
    public static final int RSTT_HTTP_ERR_read_IOException = 14;
    public static final int RSTT_HTTP_ERR_write_IOException = 15;
    private static String apiAddr = "";
    private static String apiKey = "";
    public static ThreadPoolExecutor threadPool;
    private HashMap<Integer, RSTTSession> sessionMap = new HashMap<>();
    public ArrayList<String> tryUrlsList = new ArrayList<>();
    int maxHttpTryTimes = 20;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class RSTTSession {
        public boolean isValid;
        public long lastFeedTime;
        public String lastUrl;
        public int sessionid;
        public LinkedList<SRTTAPIHTTPTask> taskQueue;
        public int taskid;
        public ArrayList<UrlPair> tryUrls;

        RSTTSession() {
        }

        public void ResetTryUrls() {
            synchronized (this.tryUrls) {
                if (SRTTAPIHTTPTaskQueueImp.this.maxHttpTryTimes < 4) {
                    this.tryUrls.clear();
                    String formatURL = SRTTAPIHTTPTaskQueueImp.this.formatURL(SRTTAPIHTTPTaskQueueImp.apiAddr, true);
                    if (formatURL != null && formatURL.length() > 0) {
                        this.tryUrls.add(new UrlPair(formatURL, true));
                    }
                    return;
                }
                for (int i3 = 0; i3 < this.tryUrls.size(); i3++) {
                    this.tryUrls.set(i3, new UrlPair(this.tryUrls.get(i3).key, true));
                }
            }
        }

        public void addTask(int i3, int i16, String str, byte[] bArr) {
            if (!this.isValid) {
                ApolloVoiceLog.LogE("rstt session is invalid,cannot add task");
                return;
            }
            this.lastFeedTime = System.currentTimeMillis();
            SRTTAPIHTTPTask sRTTAPIHTTPTask = new SRTTAPIHTTPTask();
            sRTTAPIHTTPTask.type = i3;
            sRTTAPIHTTPTask.body = bArr;
            sRTTAPIHTTPTask.key = str;
            sRTTAPIHTTPTask.seq = i16;
            try {
                SRTTAPIHTTPTaskQueueImp.threadPool.execute(new RequestTask(this, sRTTAPIHTTPTask));
                ApolloVoiceLog.LogI("rstt thread feed task");
            } catch (RejectedExecutionException unused) {
                ApolloVoiceLog.LogI("rstt thread queue task");
                synchronized (this.taskQueue) {
                    this.taskQueue.offer(sRTTAPIHTTPTask);
                }
            }
        }

        boolean checkTimeout() {
            if (System.currentTimeMillis() - this.lastFeedTime > 10000) {
                return true;
            }
            return false;
        }

        protected void finalize() {
            ApolloVoiceLog.LogI("rstt session release, id:" + this.sessionid);
        }

        public void init(int i3, ArrayList<String> arrayList) {
            this.lastUrl = "";
            this.taskid = 0;
            this.sessionid = i3;
            this.isValid = true;
            this.lastFeedTime = 0L;
            this.taskQueue = new LinkedList<>();
            this.tryUrls = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.tryUrls.add(new UrlPair(it.next(), true));
            }
        }

        public String nextUrl() {
            synchronized (this.tryUrls) {
                if (!this.isValid) {
                    return null;
                }
                if (this.lastUrl.length() > 0) {
                    return this.lastUrl;
                }
                if (this.tryUrls.size() <= 0) {
                    return "";
                }
                for (int i3 = 0; i3 < this.tryUrls.size(); i3++) {
                    if (this.tryUrls.get(i3).value) {
                        String str = this.tryUrls.get(i3).key;
                        this.tryUrls.set(i3, new UrlPair(str, false));
                        return str;
                    }
                }
                ResetTryUrls();
                try {
                    LockMethodProxy.sleep(2000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                return nextUrl();
            }
        }

        public void setLastUrl(String str) {
            synchronized (this.tryUrls) {
                this.lastUrl = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class RequestTask implements Runnable {
        private RSTTSession session;
        private SRTTAPIHTTPTask task;

        public RequestTask(RSTTSession rSTTSession, SRTTAPIHTTPTask sRTTAPIHTTPTask) {
            this.session = rSTTSession;
            this.task = sRTTAPIHTTPTask;
        }

        /* JADX WARN: Code restructure failed: missing block: B:227:0x02e9, code lost:
        
            r15 = r0;
            r18 = r2;
            r17 = r3;
            r16 = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int dealTask() {
            String nextUrl;
            String str;
            String str2 = "No error";
            String str3 = "";
            String str4 = "OK";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.session.ResetTryUrls();
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = 0;
            int i16 = 0;
            int i17 = 200;
            while (true) {
                nextUrl = this.session.nextUrl();
                if (nextUrl == null || nextUrl.length() <= 0) {
                    break;
                }
                i3++;
                if (i3 > SRTTAPIHTTPTaskQueueImp.this.maxHttpTryTimes) {
                    ApolloVoiceLog.LogE("http try max times:" + SRTTAPIHTTPTaskQueueImp.this.maxHttpTryTimes);
                    break;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 10000) {
                    ApolloVoiceLog.LogE("rstt try timeout:" + currentTimeMillis2);
                    break;
                }
                ApolloVoiceLog.LogI("rstt url:" + nextUrl);
                try {
                    if (1 == this.task.type) {
                        str = nextUrl + "?cmd=1&appid=" + SRTTAPIHTTPTaskQueueImp.apiKey;
                    } else {
                        str = nextUrl + "?platform=android&cmd=6&appid=" + SRTTAPIHTTPTaskQueueImp.apiKey + "&voice_id=" + this.task.key;
                    }
                    String str5 = str;
                    try {
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str5).openConnection();
                            if (str5.startsWith("https") && HttpsUtils.connnectWithIP(str5)) {
                                if (httpURLConnection instanceof HttpsURLConnection) {
                                    try {
                                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpsUtils.getHostNameVerify(str5));
                                    } catch (IllegalArgumentException e16) {
                                        ApolloVoiceLog.LogE("Maybe HttpsUtils's HostnameVerifier or SSLSocketFactory is null!");
                                        e16.printStackTrace();
                                    }
                                } else {
                                    ApolloVoiceLog.LogI("reqConn is not an instance of HttpsURLConnection.");
                                }
                            }
                            try {
                                httpURLConnection.setRequestMethod("POST");
                            } catch (ProtocolException e17) {
                                e17.printStackTrace();
                            }
                            if (1 == this.task.type) {
                                httpURLConnection.setRequestProperty("Content-Type", "text/html");
                            } else {
                                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                            }
                            httpURLConnection.setRequestProperty("Connection", "keep-alive");
                            httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            if (1 != this.task.type) {
                                try {
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                                    try {
                                        try {
                                            bufferedOutputStream.write(this.task.body);
                                            bufferedOutputStream.flush();
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e18) {
                                                e18.printStackTrace();
                                            }
                                        } catch (IOException e19) {
                                            String ExceptionToString = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e19);
                                            this.session.setLastUrl("");
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e26) {
                                                e26.printStackTrace();
                                            }
                                            str3 = ExceptionToString;
                                            i16 = 15;
                                            str2 = "OutputStream write failed,IOException";
                                        }
                                    } finally {
                                    }
                                } catch (IOException e27) {
                                    str3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e27);
                                    str2 = "getOutputStream failed,IOException";
                                    this.session.setLastUrl("");
                                    i16 = 16;
                                }
                            }
                            try {
                                i17 = httpURLConnection.getResponseCode();
                                try {
                                    String responseMessage = httpURLConnection.getResponseMessage();
                                    if (responseMessage != null) {
                                        str4 = responseMessage;
                                    }
                                } catch (IOException e28) {
                                    SRTTAPIHTTPTaskQueueImp.ExceptionToString(e28);
                                }
                                try {
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                    byte[] bArr = new byte[1500];
                                    while (true) {
                                        try {
                                            try {
                                                int read = bufferedInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, read);
                                            } finally {
                                            }
                                        } catch (IOException e29) {
                                            String ExceptionToString2 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e29);
                                            this.session.setLastUrl("");
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e36) {
                                                e36.printStackTrace();
                                            }
                                            try {
                                                bufferedInputStream.close();
                                            } catch (Exception e37) {
                                                e37.printStackTrace();
                                            }
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception e38) {
                                                e38.printStackTrace();
                                            }
                                            i16 = 14;
                                            str3 = ExceptionToString2;
                                            str2 = "InputStream read failed,IOException";
                                        }
                                    }
                                    byteArrayOutputStream.flush();
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e39) {
                                        e39.printStackTrace();
                                    }
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e46) {
                                        e46.printStackTrace();
                                    }
                                    try {
                                        httpURLConnection.disconnect();
                                        break;
                                    } catch (Exception e47) {
                                        e47.printStackTrace();
                                    }
                                } catch (UnknownServiceException e48) {
                                    str3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e48);
                                    str2 = "getInputStream failed,UnknownServiceException";
                                    this.session.setLastUrl("");
                                    i16 = 12;
                                } catch (IOException e49) {
                                    str3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e49);
                                    str2 = "getInputStream failed,IOException";
                                    this.session.setLastUrl("");
                                    i16 = 13;
                                }
                            } catch (IOException e56) {
                                str3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e56);
                                str2 = "getResponseCode failed,IOException";
                                this.session.setLastUrl("");
                                i16 = 17;
                            }
                        } catch (IOException e57) {
                            str3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e57);
                            str2 = "openConnection failed,IOException";
                            this.session.setLastUrl("");
                            i16 = 11;
                        }
                    } catch (MalformedURLException e58) {
                        String ExceptionToString3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e58);
                        String str6 = "new URL failed,MalformedURLException,url=" + str5;
                        this.session.setLastUrl("");
                        i16 = 10;
                        str3 = ExceptionToString3;
                        str2 = str6;
                    }
                } catch (Exception e59) {
                    str3 = SRTTAPIHTTPTaskQueueImp.ExceptionToString(e59);
                    str2 = "unknown exception";
                    this.session.setLastUrl("");
                    i16 = 1;
                }
            }
            this.session.setLastUrl(nextUrl);
            String str7 = "No error";
            String str8 = "";
            String str9 = "OK";
            i16 = 0;
            int i18 = 200;
            if (this.session.isValid) {
                SRTTAPIHTTPTaskQueueImp.callback(i16, str7, i18, str9, str8, byteArrayOutputStream.toByteArray(), this.session.sessionid);
            }
            synchronized (this.session.taskQueue) {
                if (i16 != 0) {
                    this.session.taskQueue.clear();
                    this.session.isValid = false;
                }
            }
            if (!this.session.isValid || this.task.type == 3) {
                synchronized (SRTTAPIHTTPTaskQueueImp.this.sessionMap) {
                    if (SRTTAPIHTTPTaskQueueImp.this.sessionMap.remove(Integer.valueOf(this.session.sessionid)) != null) {
                        ApolloVoiceLog.LogI("rstt session end!!!sessionid:" + this.session.sessionid);
                    }
                }
            }
            return i16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x0000, code lost:
        
            continue;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            RSTTSession rSTTSession;
            while (this.session != null && this.task != null) {
                ApolloVoiceLog.LogI("rstt thread:" + Thread.currentThread().getName() + ",run task,sessionid:" + this.session.sessionid + ",taskid:" + this.task.seq);
                int i3 = this.task.type;
                if (i3 != 1 && i3 != 2 && i3 != 3) {
                    ApolloVoiceLog.LogI("Unknown type: " + this.task.type);
                } else if (dealTask() != 0) {
                    ApolloVoiceLog.LogE("rstt failed, session:" + this.session.sessionid + ",taskid:" + this.task.seq);
                } else {
                    ApolloVoiceLog.LogI("rstt done, session:" + this.session.sessionid + ",taskid:" + this.task.seq);
                }
                HashSet<Integer> hashSet = new HashSet();
                synchronized (SRTTAPIHTTPTaskQueueImp.this.sessionMap) {
                    hashSet.addAll(SRTTAPIHTTPTaskQueueImp.this.sessionMap.keySet());
                }
                this.task = null;
                while (true) {
                    RSTTSession rSTTSession2 = this.session;
                    if (rSTTSession2 != null) {
                        synchronized (rSTTSession2.taskQueue) {
                            if (!this.session.taskQueue.isEmpty()) {
                                try {
                                    this.task = this.session.taskQueue.remove();
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    this.task = null;
                                }
                            }
                        }
                        if (this.task != null) {
                            break;
                        }
                        if (this.session.checkTimeout()) {
                            synchronized (SRTTAPIHTTPTaskQueueImp.this.sessionMap) {
                                if (SRTTAPIHTTPTaskQueueImp.this.sessionMap.remove(Integer.valueOf(this.session.sessionid)) != null) {
                                    ApolloVoiceLog.LogI("rstt session timeout!!!sessionid:" + this.session.sessionid);
                                }
                            }
                        }
                        this.session = null;
                        for (Integer num : hashSet) {
                            synchronized (SRTTAPIHTTPTaskQueueImp.this.sessionMap) {
                                rSTTSession = (RSTTSession) SRTTAPIHTTPTaskQueueImp.this.sessionMap.get(num);
                                this.session = rSTTSession;
                            }
                            if (rSTTSession != null) {
                                break;
                            }
                        }
                    }
                }
            }
            ApolloVoiceLog.LogI("rstt thread:" + Thread.currentThread().getName() + " run end");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class UrlPair {
        public String key;
        public boolean value;

        public UrlPair(String str, boolean z16) {
            this.key = str;
            this.value = z16;
        }
    }

    public static String ExceptionToString(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th5.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            ApolloVoiceLog.LogE(stringWriter2);
            return stringWriter2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static native void callback(int i3, String str, int i16, String str2, String str3, byte[] bArr, int i17);

    /* JADX INFO: Access modifiers changed from: private */
    public String formatURL(String str, boolean z16) {
        if (str != null && str.length() >= 5) {
            if (z16 && str.startsWith("https:")) {
                return str;
            }
            if (!z16 && str.startsWith("http:")) {
                return str;
            }
            if (!z16 && str.startsWith("https:")) {
                return "http".concat(str.substring(5));
            }
            if (z16 && str.startsWith("http:")) {
                return "https".concat(str.substring(4));
            }
            return str;
        }
        ApolloVoiceLog.LogI("url is null");
        return "";
    }

    private void initTryUrls(String str, String str2) {
        this.tryUrlsList.clear();
        if (str2 != null && str2.length() > 0) {
            for (String str3 : str2.split("\\|")) {
                if (str3 != null && str3.length() != 0) {
                    this.tryUrlsList.add("https://" + str3 + "/cgi-bin/wxvoicereco");
                    this.tryUrlsList.add("http://" + str3 + "/cgi-bin/wxvoicereco");
                }
            }
            String formatURL = formatURL(str, false);
            if (formatURL != null && formatURL.length() > 0) {
                this.tryUrlsList.add(formatURL);
            }
            String formatURL2 = formatURL(str, true);
            if (formatURL2 != null && formatURL2.length() > 0) {
                this.tryUrlsList.add(formatURL2);
                return;
            }
            return;
        }
        String formatURL3 = formatURL(str, true);
        if (formatURL3 != null && formatURL3.length() > 0) {
            this.tryUrlsList.add(formatURL3);
        }
        String formatURL4 = formatURL(str, false);
        if (formatURL4 != null && formatURL4.length() > 0) {
            this.tryUrlsList.add(formatURL4);
        }
        if (formatURL3 != null && formatURL3.length() > 0) {
            this.tryUrlsList.add(formatURL3);
        }
    }

    public void addTask(int i3, String str, byte[] bArr, int i16) {
        RSTTSession rSTTSession;
        synchronized (this.sessionMap) {
            rSTTSession = this.sessionMap.get(Integer.valueOf(i16));
        }
        if (rSTTSession != null) {
            int i17 = rSTTSession.taskid + 1;
            rSTTSession.taskid = i17;
            rSTTSession.addTask(i3, i17, str, bArr);
            return;
        }
        if (i3 != 1) {
            ApolloVoiceLog.LogE("addTask failed,sessionid:" + i16);
            return;
        }
        if (threadPool == null) {
            threadPool = new BaseThreadPoolExecutor(0, 5, 1L, TimeUnit.SECONDS, new SynchronousQueue());
        }
        RSTTSession rSTTSession2 = new RSTTSession();
        rSTTSession2.init(i16, this.tryUrlsList);
        int i18 = rSTTSession2.taskid + 1;
        rSTTSession2.taskid = i18;
        rSTTSession2.addTask(i3, i18, str, bArr);
        synchronized (this.sessionMap) {
            ApolloVoiceLog.LogE("rstt session count:" + this.sessionMap.size());
            this.sessionMap.put(Integer.valueOf(i16), rSTTSession2);
        }
    }

    public void setAppInfo(String str, String str2, String str3, int i3) {
        apiKey = str;
        apiAddr = str2;
        this.maxHttpTryTimes = i3;
        initTryUrls(str2, str3);
    }
}

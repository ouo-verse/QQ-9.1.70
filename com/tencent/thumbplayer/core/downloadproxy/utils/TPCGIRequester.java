package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPCGIRequester {
    private static final String FILE_NAME = "TPCGIRequester";
    private static final int MAX_RETRY_TIMES = 3;
    private static final int MSG_CONFIG_URL = 2011;
    private static final int MSG_REPORT_URL = 2010;
    private static final int MSG_WUJI_CONFIG_URL = 2013;
    private static final int RETRY_INTERVAL = 3000;
    private static final int TIMEOUT = 3000;
    private static volatile ExecutorService mCustomExecutor;
    private static TPCGIRequester mRequester;
    private final Runnable mCommand;
    private final LinkedBlockingQueue<TPRequestItem> mRetryQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<TPRequestItem> mRequestQueue = new LinkedBlockingQueue<>();

    TPCGIRequester() {
        Runnable runnable = new Runnable() { // from class: com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester.1
            @Override // java.lang.Runnable
            public void run() {
                while (TPCGIRequester.this.mRetryQueue.peek() != null && System.currentTimeMillis() - ((TPRequestItem) TPCGIRequester.this.mRetryQueue.peek()).getRequestFailedTime() > 3000) {
                    TPCGIRequester tPCGIRequester = TPCGIRequester.this;
                    tPCGIRequester.addNotifyReqQueue((TPRequestItem) tPCGIRequester.mRetryQueue.poll());
                }
            }
        };
        this.mCommand = runnable;
        try {
            TVKThreadUtil.getScheduledExecutorServiceInstance().scheduleAtFixedRate(runnable, 0L, 1L, TimeUnit.SECONDS);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "executor.scheduleAtFixedRate failed: " + th5);
        }
        process();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNotifyReqQueue(TPRequestItem tPRequestItem) {
        try {
            this.mRequestQueue.put(tPRequestItem);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "RequestQueue add failed:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRetryRequestItem(TPRequestItem tPRequestItem) {
        try {
            if (tPRequestItem.getRequestTimes() <= 3) {
                this.mRetryQueue.put(tPRequestItem);
            }
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "retry queue add failed" + th5);
        }
    }

    public static TPCGIRequester getInstance() {
        if (mRequester == null) {
            synchronized (TPCGIRequester.class) {
                if (mRequester == null) {
                    mRequester = new TPCGIRequester();
                }
            }
        }
        return mRequester;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleRequestItem(TPRequestItem tPRequestItem) {
        boolean z16;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        boolean z17 = false;
        try {
            httpURLConnection = (HttpURLConnection) new URL(tPRequestItem.getUrl()).openConnection();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200 || responseCode == 206) {
                try {
                    if (tPRequestItem.getRequestType() == 2011 || tPRequestItem.getRequestType() == 2013) {
                        StringBuffer stringBuffer = new StringBuffer();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                            stringBuffer.append("\n");
                        }
                        bufferedReader.close();
                        String replace = stringBuffer.toString().replace("QZOutputJson=", "");
                        JSONObject jSONObject = new JSONObject(replace);
                        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "start update config. responce data: " + replace);
                        if (tPRequestItem.getRequestType() == 2013) {
                            if (jSONObject.getInt("code") == 0) {
                                TPDownloadProxyNative.getInstance().setUserData("proxy_config", jSONObject.getString("data"));
                            }
                        } else if (jSONObject.getInt("ret") == 0) {
                            TPDownloadProxyNative.getInstance().setUserData("proxy_config", jSONObject.getJSONObject(DownloadInfo.spKey_Config).toString());
                        }
                    }
                    z17 = true;
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection2 = httpURLConnection;
                    z16 = true;
                    try {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "Send Request Routine error:" + th);
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.getInputStream().close();
                                httpURLConnection2.disconnect();
                            } catch (IOException e16) {
                                throw new RuntimeException(e16);
                            }
                        }
                        return z16;
                    } catch (Throwable th7) {
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.getInputStream().close();
                                httpURLConnection2.disconnect();
                            } catch (IOException e17) {
                                throw new RuntimeException(e17);
                            }
                        }
                        throw th7;
                    }
                }
            }
            try {
                httpURLConnection.getInputStream().close();
                httpURLConnection.disconnect();
                return z17;
            } catch (IOException e18) {
                throw new RuntimeException(e18);
            }
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection2 = httpURLConnection;
            z16 = false;
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "Send Request Routine error:" + th);
            if (httpURLConnection2 != null) {
            }
            return z16;
        }
    }

    private static ExecutorService obtainThreadExcutor() {
        if (mCustomExecutor == null) {
            synchronized (TPCGIRequester.class) {
                if (mCustomExecutor == null) {
                    mCustomExecutor = ProxyExecutors.newSingleThreadExecutor();
                }
            }
        }
        return mCustomExecutor;
    }

    private void process() {
        obtainThreadExcutor().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester.2
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        TPRequestItem tPRequestItem = (TPRequestItem) TPCGIRequester.this.mRequestQueue.take();
                        if (!TPCGIRequester.this.handleRequestItem(tPRequestItem)) {
                            tPRequestItem.updateFailedTime();
                            TPCGIRequester.this.addRetryRequestItem(tPRequestItem);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPCGIRequester.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "request queue take failed: " + th5);
                    }
                }
            }
        });
    }

    public void addRequestItem(String str, int i3) {
        if (str.isEmpty()) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "request url null");
        } else {
            addNotifyReqQueue(new TPRequestItem(str, i3));
        }
    }
}

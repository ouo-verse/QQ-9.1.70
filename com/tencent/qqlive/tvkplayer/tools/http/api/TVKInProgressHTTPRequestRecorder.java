package com.tencent.qqlive.tvkplayer.tools.http.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public final class TVKInProgressHTTPRequestRecorder {
    private static final int WAIT_IN_PROGRESS_TIMEOUT_MS = 1000;
    private static final Map<String, Boolean[]> sInProgressHttpRequestMap = new ConcurrentHashMap();

    public static boolean isHttpRequestInProgress(@NonNull String str) {
        if (sInProgressHttpRequestMap.get(str) != null) {
            return true;
        }
        return false;
    }

    public static void notifyAllHttpRequestDone(@NonNull String str, boolean z16, @NonNull ITVKLogger iTVKLogger) {
        iTVKLogger.info("VOD/LIVE CGI: notifyAllHttpRequestDone, cacheKey=" + str + " alreadySaveCache=" + z16, new Object[0]);
        Boolean[] remove = sInProgressHttpRequestMap.remove(str);
        if (remove == null) {
            iTVKLogger.info("VOD/LIVE CGI: notifyAllHttpRequestDone, lockObject of cacheKey=" + str + " is null, return", new Object[0]);
            return;
        }
        synchronized (remove) {
            iTVKLogger.info("VOD/LIVE CGI: notifyAllHttpRequestDone, cacheKey=" + str, new Object[0]);
            remove[0] = Boolean.TRUE;
            remove[1] = Boolean.valueOf(z16);
            remove.notifyAll();
        }
    }

    public static void recordHTTPRequestInProgress(@NonNull String str, @NonNull ITVKLogger iTVKLogger) {
        iTVKLogger.info("recordHTTPRequestInProgress, cacheKey=" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            iTVKLogger.warn("recordHTTPRequestInProgress, empty cacheKey, ignore", new Object[0]);
            return;
        }
        Map<String, Boolean[]> map = sInProgressHttpRequestMap;
        Boolean bool = Boolean.FALSE;
        map.put(str, new Boolean[]{bool, bool});
    }

    public static boolean waitOtherHttpRequestDone(@NonNull String str, @NonNull ITVKLogger iTVKLogger) throws InterruptedException {
        boolean z16;
        Boolean[] boolArr = sInProgressHttpRequestMap.get(str);
        boolean z17 = true;
        if (boolArr == null) {
            iTVKLogger.warn("VOD/LIVE CGI: waitOtherHttpRequestDone, lockObject of cacheKey=" + str + " is null, return", new Object[0]);
            return true;
        }
        synchronized (boolArr) {
            try {
                try {
                    if (boolArr[0].booleanValue()) {
                        iTVKLogger.info("VOD/LIVE CGI: waitOtherHttpRequestDone, already notify all, no need to wait", new Object[0]);
                        if (!boolArr[0].booleanValue() || !boolArr[1].booleanValue()) {
                            z17 = false;
                        }
                        return z17;
                    }
                    iTVKLogger.info("VOD/LIVE CGI: waitOtherHttpRequestDone, wait begin, cacheKey=" + str, new Object[0]);
                    boolArr.wait(1000L);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("VOD/LIVE CGI: waitOtherHttpRequestDone, wait finish isWaitTimeOut=");
                    if (!boolArr[0].booleanValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    sb5.append(" networkRequestSuccess=");
                    sb5.append(boolArr[1]);
                    sb5.append(", cacheKey=");
                    sb5.append(str);
                    iTVKLogger.info(sb5.toString(), new Object[0]);
                    if (!boolArr[0].booleanValue() || !boolArr[1].booleanValue()) {
                        z17 = false;
                    }
                    return z17;
                } catch (InterruptedException e16) {
                    iTVKLogger.error("VOD/LIVE CGI: waitOtherHttpRequestDone has interrupted exception, cacheKey=" + str, new Object[0]);
                    throw e16;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }
}

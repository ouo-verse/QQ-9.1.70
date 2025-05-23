package com.tencent.multidownloader;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes34.dex */
public class MDDownloadLog {
    private static final IMDDownloadLogProxy defaultProxy = new IMDDownloadLogProxy() { // from class: com.tencent.multidownloader.MDDownloadLog.1
        @Override // com.tencent.multidownloader.IMDDownloadLogProxy
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.multidownloader.IMDDownloadLogProxy
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.tencent.multidownloader.IMDDownloadLogProxy
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.multidownloader.IMDDownloadLogProxy
        public void w(String str, String str2) {
            Log.w(str, str2);
        }
    };
    private static IMDDownloadLogProxy sLogProxy;

    public static void log(int i3, String str, String str2) {
        if (sLogProxy == null) {
            sLogProxy = defaultProxy;
        }
        if (i3 == MDLogLevel.LOG_DEBUG.ordinal()) {
            sLogProxy.d(str, str2);
            return;
        }
        if (i3 == MDLogLevel.LOG_INFO.ordinal()) {
            sLogProxy.i(str, str2);
        } else if (i3 == MDLogLevel.LOG_WARNING.ordinal()) {
            sLogProxy.w(str, str2);
        } else if (i3 == MDLogLevel.LOG_ERROR.ordinal()) {
            sLogProxy.e(str, str2);
        }
    }

    public static void setProxyLogger(IMDDownloadLogProxy iMDDownloadLogProxy) {
        sLogProxy = iMDDownloadLogProxy;
        log(MDLogLevel.LOG_INFO.ordinal(), "MDDownloadLog", "init#setProxyLogger - " + iMDDownloadLogProxy);
    }
}

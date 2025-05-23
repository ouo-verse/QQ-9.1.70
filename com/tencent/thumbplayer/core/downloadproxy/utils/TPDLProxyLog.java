package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

/* loaded from: classes26.dex */
public class TPDLProxyLog {
    private static ITPDLProxyLogListener mLogListener;
    private static final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("");
    private static int mServiceType;

    public static void d(String str, int i3, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.d(str, i3, str2, str3);
        } else {
            mLogger.d(str2, str, i3, str3);
        }
    }

    public static void e(String str, int i3, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.e(str, i3, str2, str3);
        } else {
            mLogger.e(str2, str, i3, str3);
        }
    }

    public static void i(String str, int i3, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.i(str, i3, str2, str3);
        } else {
            mLogger.i(str2, str, i3, str3);
        }
    }

    public static void setLogListener(int i3, ITPDLProxyLogListener iTPDLProxyLogListener) {
        mServiceType = i3;
        mLogListener = iTPDLProxyLogListener;
    }

    public static void w(String str, int i3, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.w(str, i3, str2, str3);
        } else {
            mLogger.w(str2, str, i3, str3);
        }
    }
}

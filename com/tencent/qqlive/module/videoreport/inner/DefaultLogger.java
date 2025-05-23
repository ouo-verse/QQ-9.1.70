package com.tencent.qqlive.module.videoreport.inner;

import android.util.Log;
import com.tencent.qqlive.module.videoreport.ILogger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultLogger implements ILogger {
    private static final String PRE_FIX = "DT#";

    @Override // com.tencent.qqlive.module.videoreport.ILogger
    public void d(String str, String str2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(PRE_FIX + str, str2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.ILogger
    public void e(String str, String str2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.e(PRE_FIX + str, str2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.ILogger
    public void i(String str, String str2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(PRE_FIX + str, str2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.ILogger
    public void v(String str, String str2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.v(PRE_FIX + str, str2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.ILogger
    public void w(String str, String str2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.w(PRE_FIX + str, str2);
        }
    }
}

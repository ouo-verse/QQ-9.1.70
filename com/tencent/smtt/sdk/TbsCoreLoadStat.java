package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsCoreLoadStat {
    public static final int ERROR_CODE_INIT = -1;

    /* renamed from: a, reason: collision with root package name */
    private static TbsCoreLoadStat f369085a = null;
    public static String mErrorMessage = "";
    public static volatile int mLoadErrorCode = -1;

    TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        if (f369085a == null) {
            f369085a = new TbsCoreLoadStat();
        }
        return f369085a;
    }

    public static int getLoadErrorCode() {
        return mLoadErrorCode;
    }

    public static String getLoadErrorMessage() {
        return mErrorMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i3) {
        TbsLog.e(TbsListener.tag_load_error, "" + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Context context, int i3, Throwable th5) {
        TbsLog.e("TbsCoreLoadStat", "[loadError] errorCode: " + i3 + ", details:" + String.valueOf(th5));
        if (th5 != null) {
            if (mLoadErrorCode == -1) {
                mLoadErrorCode = i3;
                mErrorMessage = String.valueOf(th5);
                TbsLogReport.getInstance(context).setLoadErrorCode(i3, th5);
                TbsLog.i("TbsCoreLoadStat", mLoadErrorCode + " report success!");
            } else {
                TbsLog.i("TbsCoreLoadStat", mLoadErrorCode + " is reported, others will be saved in local TbsLog!");
            }
        }
    }
}

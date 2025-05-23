package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;

/* compiled from: P */
/* loaded from: classes23.dex */
public class e {
    public static boolean a(Context context) {
        boolean z16;
        int tbsVersion = QbSdk.getTbsVersion(context);
        int tmpDirTbsVersion = QbSdk.getTmpDirTbsVersion(context);
        if (tbsVersion <= 0 && tmpDirTbsVersion <= 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        QMLog.i("Mini-X5Helper", "isInstalled: " + z16 + ", tbsVersion: " + tbsVersion + ", tmpTbsVersion: " + tmpDirTbsVersion);
        return z16;
    }
}

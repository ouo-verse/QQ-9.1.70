package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {
    public static boolean a(@Nullable Context context, String str) {
        String str2;
        String str3;
        boolean z16 = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("GdtAppOpenUtil", 2, " packageName:" + str);
            }
            DownloadInfo O = DownloadManagerV2.V().O(str);
            if (O == null) {
                QLog.e("GdtAppOpenUtil", 2, " DownloadInfo == null");
                return false;
            }
            if (!TextUtils.isEmpty(O.L)) {
                str3 = O.L;
            } else {
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
                String str4 = "";
                if (O.J == 0) {
                    TMAssistantDownloadTaskInfo Y = DownloadManagerV2.V().Y(O.f341186f);
                    if (Y != null && Y.mState == 4) {
                        str4 = Y.mSavePath;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        tMAssistantDownloadTaskInfo = DownloadManagerV2.V().X(O);
                    }
                } else {
                    TMAssistantDownloadTaskInfo X = DownloadManagerV2.V().X(O);
                    if (X != null && X.mState == 4) {
                        str4 = X.mSavePath;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        tMAssistantDownloadTaskInfo = DownloadManagerV2.V().Y(O.f341186f);
                    }
                }
                if (tMAssistantDownloadTaskInfo != null && tMAssistantDownloadTaskInfo.mState == 4) {
                    str2 = tMAssistantDownloadTaskInfo.mSavePath;
                } else {
                    str2 = str4;
                }
                if (!TextUtils.isEmpty(str2)) {
                    O.L = str2;
                    O.k(4);
                    DownloadManagerV2.V().u(O);
                }
                str3 = str2;
            }
            if (!TextUtils.isEmpty(str3) && new File(str3).exists()) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GdtAppOpenUtil", 2, "isPkgExist(" + z16 + ")  packageName:" + str + ", path:" + str3);
            }
        }
        return z16;
    }
}

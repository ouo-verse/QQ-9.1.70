package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;

/* loaded from: classes33.dex */
public class DangerousPersonToastUtils {
    private static final String TAG = "DangerousPersonToastUtils";

    public static void openErrorToast(Context context, long j3, String str) {
        openErrorToast(context, j3, str, 1);
    }

    public static void shareErrorToast(Context context, long j3, String str) {
        shareErrorToast(context, j3, str, 1);
    }

    public static void openErrorToast(final Context context, final long j3, final String str, final int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            openErrorToastView(context, j3, str, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    DangerousPersonToastUtils.openErrorToastView(context, j3, str, i3);
                }
            });
        }
    }

    public static void shareErrorToast(final Context context, final long j3, final String str, final int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            shareErrorToastView(context, j3, str, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    DangerousPersonToastUtils.shareErrorToastView(context, j3, str, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void openErrorToastView(Context context, long j3, String str, int i3) {
        if (j3 == EventListener.VERSION_NOT_EXIST) {
            QQToast.makeText(context, 0, "" + str, i3).show();
        } else {
            QQToast.makeText(context, 1, "" + str, i3).show();
        }
        QLog.e(TAG, 1, "OpenErrorToastView ErrCode:" + j3 + " errMsg" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shareErrorToastView(Context context, long j3, String str, int i3) {
        if (j3 == -100070016) {
            QQToast.makeText(context, 0, str, i3).show();
        } else {
            QQToast.makeText(context, 1, str, i3).show();
        }
        QLog.e(TAG, 1, "ShareErrorToastView ErrCode:" + j3 + " errMsg" + str);
    }
}

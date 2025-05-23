package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppToastUtil {
    private static final String TAG = "MiniAppToastUtil";
    private static final int VALID_INTERVAL_TIME = 1000;
    private static long sLastShowTime;

    private static boolean isFastShowToast() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - sLastShowTime >= 1000) {
            sLastShowTime = uptimeMillis;
            return false;
        }
        QLog.d(TAG, 1, "isFastShow");
        return true;
    }

    public static void show(Context context, int i3, int i16) {
        show(context, i3, context.getString(i16), 0);
    }

    public static void show(Context context, int i3, int i16, int i17) {
        show(context, i3, context.getString(i16), i17);
    }

    public static void show(Context context, int i3, String str) {
        show(context, i3, str, 0);
    }

    public static void show(final Context context, final int i3, final String str, final int i16) {
        if (isFastShowToast()) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            QQToast.makeText(context, i3, str, i16).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.util.MiniAppToastUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, i3, str, i16).show();
                }
            });
        }
        QLog.d(TAG, 1, "show toastMsg\uff1a" + str);
    }
}

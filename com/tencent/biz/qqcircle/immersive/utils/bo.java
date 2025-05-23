package com.tencent.biz.qqcircle.immersive.utils;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bo {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str) {
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).preloadWebView(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(final String str) {
        QLog.d("QFSWebUtils", 1, "preloadWebProcess " + str);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.bn
            @Override // java.lang.Runnable
            public final void run() {
                bo.c(str);
            }
        });
        return false;
    }

    public static void e(final String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("https://")) {
            return;
        }
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            QLog.d("QFSWebUtils", 1, "preloadWebProcess but is low device");
        } else {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.biz.qqcircle.immersive.utils.bm
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean d16;
                    d16 = bo.d(str);
                    return d16;
                }
            });
        }
    }
}

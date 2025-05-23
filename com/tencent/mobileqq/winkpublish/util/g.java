package com.tencent.mobileqq.winkpublish.util;

import android.os.Looper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes35.dex */
public class g {
    public static Looper a() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).getLooper();
    }

    public static Looper b() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper();
    }

    public static void c(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(runnable);
    }

    public static void d(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(runnable);
    }
}

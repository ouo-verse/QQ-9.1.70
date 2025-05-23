package com.tencent.biz.qqcircle.immersive.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Vibrator;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bc {
    @SuppressLint({"MissingPermission"})
    public static void a(long j3) {
        Vibrator vibrator;
        Application application = RFWApplication.getApplication();
        if (application == null || (vibrator = (Vibrator) application.getSystemService("vibrator")) == null) {
            return;
        }
        vibrator.vibrate(j3);
    }
}

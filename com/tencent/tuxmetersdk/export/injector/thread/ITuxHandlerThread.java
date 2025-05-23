package com.tencent.tuxmetersdk.export.injector.thread;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxHandlerThread {
    Looper getDeliveryLooper();

    Looper getSDKDataReadyLooper();

    Looper getSurveyEventLooper();

    Looper getTriggerLooper();
}

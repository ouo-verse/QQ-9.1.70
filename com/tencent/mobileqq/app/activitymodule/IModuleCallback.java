package com.tencent.mobileqq.app.activitymodule;

import android.content.BroadcastReceiver;
import com.tencent.mobileqq.app.ShakeListener;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IModuleCallback {
    BroadcastReceiver newScreenReceiverInstance();

    ShakeListener newShakeListener();
}

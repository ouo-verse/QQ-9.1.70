package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SVSD {
    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    int onStartCommand(Intent intent, int i3, int i16);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i3);

    boolean onUnbind(Intent intent);
}

package com.tencent.shadow.core.runtime;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class ShadowService extends ShadowContext {
    public final ShadowApplication getApplication() {
        return this.mShadowApplication;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i3, int i16) {
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public final void setHostContextAsBase(Context context) {
        attachBaseContext(context);
    }

    public final void stopForeground(int i3) {
    }

    public final void stopSelf() {
        stopService(new Intent(this, getClass()));
    }

    public final boolean stopSelfResult(int i3) {
        stopSelf();
        return true;
    }

    public final void stopForeground(boolean z16) {
    }

    public final void stopSelf(int i3) {
        stopSelf();
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onLowMemory() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onRebind(Intent intent) {
    }

    public void onTaskRemoved(Intent intent) {
    }

    public void onTrimMemory(int i3) {
    }

    @Deprecated
    public final void setForeground(boolean z16) {
    }

    @Deprecated
    public void onStart(Intent intent, int i3) {
    }

    public final void startForeground(int i3, Notification notification) {
    }
}

package com.tencent.minibox.dynamic.api;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class BaseServiceDelegate implements IServiceDelegate {
    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void dump(@Nullable FileDescriptor fileDescriptor, @Nullable PrintWriter printWriter, @Nullable String[] strArr) {
        if (printWriter != null) {
            printWriter.println("nothing to dump");
        }
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public int onStartCommand(@Nullable Intent intent, int i3, int i16) {
        return 1;
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public boolean onUnbind(@Nullable Intent intent) {
        return false;
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void attachBaseContext(@Nullable Context context) {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onConfigurationChanged(@NotNull Configuration configuration) {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onCreate() {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onDestroy() {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onLowMemory() {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onRebind(@Nullable Intent intent) {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onTaskRemoved(@Nullable Intent intent) {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onTrimMemory(int i3) {
    }

    @Override // com.tencent.minibox.dynamic.api.IServiceDelegate
    public void onStart(@Nullable Intent intent, int i3) {
    }
}

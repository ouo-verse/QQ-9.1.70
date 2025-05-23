package com.tencent.mobileqq.teamwork.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.IRemoteRenderService;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes18.dex */
public class TDocForegroundService implements IRemoteRenderService {
    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    @Nullable
    public IBinder onBind(@NonNull Service service, @NonNull Intent intent) {
        return null;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onDestroy(@NonNull Service service) {
        QLog.d("TDocForegroundService", 1, "tDoc_local_edit onDestroy");
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public int onStartCommand(@NonNull Service service, @NonNull Intent intent, int i3, int i16) {
        QLog.d("TDocForegroundService", 1, "tDoc_local_edit onStartCommand");
        return 2;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onLowMemory(@NonNull Service service) {
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onTaskRemoved(@NonNull Service service, @Nullable Intent intent) {
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onTrimMemory(@NonNull Service service, int i3) {
    }
}

package com.tencent.qcircle.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

/* loaded from: classes22.dex */
public class QCirclePreloadService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        return super.onStartCommand(intent, i3, i16);
    }
}

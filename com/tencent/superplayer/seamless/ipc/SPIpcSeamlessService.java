package com.tencent.superplayer.seamless.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.superplayer.seamless.ipc.b;

/* loaded from: classes26.dex */
public class SPIpcSeamlessService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private Context f373962d;

    /* renamed from: e, reason: collision with root package name */
    private IBinder f373963e = new a();

    /* loaded from: classes26.dex */
    class a extends b.a {
        a() {
        }

        @Override // com.tencent.superplayer.seamless.ipc.b
        public boolean S3(Bundle bundle) {
            return j.c(SPIpcSeamlessService.this.f373962d).b(bundle);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.f373963e;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f373962d = this;
    }
}

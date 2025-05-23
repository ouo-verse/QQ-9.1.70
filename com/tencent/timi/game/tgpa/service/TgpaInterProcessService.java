package com.tencent.timi.game.tgpa.service;

import a3.b;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.tencent.timi.game.utils.l;

/* loaded from: classes26.dex */
public class TgpaInterProcessService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private b.a f379968d = new a();

    /* loaded from: classes26.dex */
    class a extends b.a {
        a() {
        }

        private String v() {
            PackageManager packageManager;
            Context applicationContext = TgpaInterProcessService.this.getApplicationContext();
            if (applicationContext != null) {
                packageManager = applicationContext.getPackageManager();
            } else {
                packageManager = null;
            }
            if (packageManager != null) {
                return packageManager.getNameForUid(Binder.getCallingUid());
            }
            return "";
        }

        @Override // a3.b
        public void M3(String str) throws RemoteException {
            String v3 = v();
            l.i("TgpaInterProcessService", v3 + "## updateGameInfo-" + str);
            jn4.a.c().g(v3, str);
        }

        @Override // a3.b
        public void i1(a3.a aVar) throws RemoteException {
            String v3 = v();
            l.i("TgpaInterProcessService", v3 + "## registerGameCallback-" + aVar);
            jn4.a.c().j(v3, aVar);
        }
    }

    public static void a(Context context) {
        l.i("TgpaInterProcessService", "sendBindServiceRequestWhenLaunch " + context);
        context.sendBroadcast(new Intent("com.ihoc.mgpa.ACTION_DATAFORWARD_REQUEST"));
        l.i("TgpaInterProcessService", "sendBindServiceRequestWhenLaunch END");
    }

    public static void b(Context context, boolean z16) {
        l.i("TgpaInterProcessService", "startTgpaService " + context + " - " + z16);
    }

    public static void c(Context context) {
        l.i("TgpaInterProcessService", "stopTgpaService " + context);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        l.i("TgpaInterProcessService", "onBind " + intent);
        jn4.a.c().e();
        return this.f379968d;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        l.i("TgpaInterProcessService", "onStartCommand - flags: " + i3 + " startId: " + i16 + " " + intent);
        a(eh4.a.b());
        return super.onStartCommand(intent, i3, i16);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        l.i("TgpaInterProcessService", "onUnbind " + intent);
        jn4.a.c().f();
        a(eh4.a.b());
        return super.onUnbind(intent);
    }
}

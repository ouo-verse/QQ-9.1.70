package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.vivo.push.restructure.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CommandService extends Service {
    protected boolean a(String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        u.c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        u.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        Context context = ContextDelegate.getContext(getApplicationContext());
        a.a().a(context);
        com.vivo.push.sdk.a.a().a(context);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        u.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (!a(intent.getAction())) {
            u.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
            stopSelf();
            return 2;
        }
        try {
            com.vivo.push.sdk.a.a().a(getClass().getName());
            com.vivo.push.sdk.a.a().a(intent);
        } catch (Exception e16) {
            u.a("CommandService", "onStartCommand -- error", e16);
        }
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

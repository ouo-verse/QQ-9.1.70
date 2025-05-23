package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public Messenger f36386a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f36387b;

    /* renamed from: c, reason: collision with root package name */
    public Context f36388c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("MessengerSrvConnection", "onServiceConnected");
        this.f36386a = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f36387b);
        try {
            this.f36386a.send(obtain);
        } catch (Exception e16) {
            e16.getMessage();
        }
        Log.i("MessengerSrvConnection", "start unbind service.");
        try {
            this.f36388c.unbindService(this);
            Log.i("MessengerSrvConnection", "unbind service end.");
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("MessengerSrvConnection", "onServiceDisconnected");
        this.f36386a = null;
        this.f36387b = null;
        this.f36388c = null;
    }
}

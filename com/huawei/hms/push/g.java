package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f37432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f37433b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f37434c;

    public g(h hVar, Bundle bundle, Context context) {
        this.f37434c = hVar;
        this.f37432a = bundle;
        this.f37433b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        Messenger messenger;
        HMSLog.i("RemoteService", "remote service onConnected");
        this.f37434c.f37436b = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f37432a);
        try {
            messenger = this.f37434c.f37436b;
            messenger.send(obtain);
        } catch (RemoteException unused) {
            HMSLog.i("RemoteService", "remote service message send failed");
        }
        HMSLog.i("RemoteService", "remote service unbindservice");
        Context context = this.f37433b;
        serviceConnection = this.f37434c.f37435a;
        context.unbindService(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("RemoteService", "remote service onDisconnected");
        this.f37434c.f37436b = null;
    }
}

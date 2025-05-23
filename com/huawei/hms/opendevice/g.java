package com.huawei.hms.opendevice;

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
    public final /* synthetic */ Bundle f37345a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f37346b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f37347c;

    public g(h hVar, Bundle bundle, Context context) {
        this.f37347c = hVar;
        this.f37345a = bundle;
        this.f37346b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        Messenger messenger;
        HMSLog.i("RemoteService", "remote service onConnected");
        this.f37347c.f37349b = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f37345a);
        try {
            messenger = this.f37347c.f37349b;
            messenger.send(obtain);
        } catch (RemoteException unused) {
            HMSLog.i("RemoteService", "remote service message send failed");
        }
        HMSLog.i("RemoteService", "remote service unbindservice");
        Context context = this.f37346b;
        serviceConnection = this.f37347c.f37348a;
        context.unbindService(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("RemoteService", "remote service onDisconnected");
        this.f37347c.f37349b = null;
    }
}

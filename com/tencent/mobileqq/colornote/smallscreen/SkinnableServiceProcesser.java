package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;

/* loaded from: classes5.dex */
public class SkinnableServiceProcesser extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final Service f201664a;

    /* renamed from: b, reason: collision with root package name */
    private final a f201665b;

    /* loaded from: classes5.dex */
    public interface a {
        void onPostThemeChanged();
    }

    public SkinnableServiceProcesser(Service service, a aVar) {
        this.f201664a = service;
        this.f201665b = aVar;
        try {
            service.registerReceiver(this, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        } catch (Exception unused) {
        }
    }

    public void a() {
        try {
            this.f201664a.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
            return;
        }
        QLog.d(SkinEngine.TAG, 1, "SkinnableActivityProcesser on pre theme changed");
        a aVar = this.f201665b;
        if (aVar != null) {
            aVar.onPostThemeChanged();
        }
        QLog.d(SkinEngine.TAG, 1, "SkinnableActivityProcesser on post theme changed");
    }
}

package com.tencent.mobileqq.guild.media.core.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.media.core.f f228355a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f228358d;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f228356b = -1;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f228357c = -1;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f228359e = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && b.this.f228358d) {
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("state", -1);
                    QLog.i("QGMC.AudioRouter", 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", Integer.valueOf(intExtra)));
                    if (intExtra == 0) {
                        b.this.f(3);
                    } else if (intExtra == 1) {
                        b.this.e(3);
                    }
                }
                if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                    int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                    QLog.i("QGMC.AudioRouter", 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra2)));
                    if (intExtra2 == 2) {
                        b.this.e(2);
                        return;
                    } else {
                        if (intExtra2 == 0) {
                            b.this.f(2);
                            return;
                        }
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    QLog.i("QGMC.AudioRouter", 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra3)));
                    if (intExtra3 == 10 || intExtra3 == 13) {
                        b.this.f(2);
                    }
                }
            }
        }
    }

    public b(com.tencent.mobileqq.guild.media.core.f fVar) {
        this.f228355a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3) {
        QLog.i("QGMC.AudioRouter", 1, "onDeviceConnect route=" + i3);
        if (this.f228356b != 2 && this.f228356b != 3) {
            this.f228357c = this.f228356b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3) {
        QLog.i("QGMC.AudioRouter", 1, "onDeviceLoss device=" + i3);
        if (this.f228357c != -1) {
            this.f228355a.J().setAudioRoute(this.f228357c);
            this.f228357c = -1;
        } else if (i3 != 1) {
            this.f228355a.J().setAudioRoute(1);
        }
    }

    public int d() {
        return this.f228356b;
    }

    public void g() {
        if (this.f228358d) {
            return;
        }
        this.f228358d = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.f228355a.getAppContext().registerReceiver(this.f228359e, intentFilter);
    }

    public void h() {
        if (!this.f228358d) {
            return;
        }
        this.f228358d = false;
        try {
            this.f228355a.getAppContext().unregisterReceiver(this.f228359e);
        } catch (Exception e16) {
            QLog.e("QGMC.AudioRouter", 1, "unregisterReceiver " + e16.getMessage());
        }
        this.f228356b = -1;
        this.f228357c = -1;
    }
}

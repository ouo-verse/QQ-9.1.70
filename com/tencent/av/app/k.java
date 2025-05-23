package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    private static String f73175d = "GBatteryMonitor";

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f73176a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f73177b;

    /* renamed from: c, reason: collision with root package name */
    BroadcastReceiver f73178c = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("level", 0);
            if (k.this.f73176a != null && k.this.f73176a.f73126m != null) {
                ((VideoNodeReporter) k.this.f73176a.B(4)).A(intExtra);
            }
        }
    }

    public k(VideoAppInterface videoAppInterface) {
        this.f73176a = videoAppInterface;
    }

    public void b() {
        if (this.f73176a.getApplication().registerReceiver(this.f73178c, new IntentFilter("android.intent.action.BATTERY_CHANGED")) != null) {
            this.f73177b = true;
        }
    }

    public void c() {
        try {
            if (this.f73177b) {
                this.f73176a.getApplication().unregisterReceiver(this.f73178c);
                this.f73177b = false;
            }
        } catch (IllegalArgumentException e16) {
            QLog.d(f73175d, 1, "video exit IllegalArgumentException ", e16);
        }
    }
}

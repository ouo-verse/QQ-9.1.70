package com.tencent.mobileqq.wink.pubcover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkCoverExportVideoReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private boolean f325456a = false;

    /* renamed from: b, reason: collision with root package name */
    private a f325457b;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void g9();
    }

    public WinkCoverExportVideoReceiver(a aVar) {
        this.f325457b = aVar;
    }

    private IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("wink_export_completed_action");
        return intentFilter;
    }

    public void b(@NonNull Context context) {
        if (!this.f325456a && context != null) {
            context.registerReceiver(this, a());
            this.f325456a = true;
        }
    }

    public void c(@NonNull Context context) {
        if (this.f325456a && context != null) {
            context.unregisterReceiver(this);
            this.f325456a = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            ms.a.c("WinkCoverExportVideoReceiver", "[onReceive] : action is null");
            return;
        }
        ms.a.f("WinkCoverExportVideoReceiver", "[onReceive] action :" + action);
        if ("wink_export_completed_action".equals(action)) {
            this.f325457b.g9();
        }
    }
}

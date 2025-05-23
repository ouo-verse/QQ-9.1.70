package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f73188a;

    /* renamed from: b, reason: collision with root package name */
    private a f73189b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_ON");
                return;
            }
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_OFF");
                return;
            }
            if (action.equals("android.intent.action.USER_PRESENT")) {
                QLog.d("GScreenActionMonitor", 1, "avideACTION_USER_PRESENT");
                return;
            }
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                QLog.d("GScreenActionMonitor", 1, "avideo ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + intent.getStringExtra("reason") + "]");
            }
        }
    }

    public n(VideoAppInterface videoAppInterface) {
        this.f73188a = videoAppInterface;
    }

    public void a() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            this.f73189b = new a();
            VideoAppInterface videoAppInterface = this.f73188a;
            if (videoAppInterface != null) {
                videoAppInterface.getApplication().getApplicationContext().registerReceiver(this.f73189b, intentFilter);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void b() {
        try {
            VideoAppInterface videoAppInterface = this.f73188a;
            if (videoAppInterface != null && this.f73189b != null) {
                videoAppInterface.getApplication().getApplicationContext().unregisterReceiver(this.f73189b);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}

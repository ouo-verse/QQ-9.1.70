package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class GAccountMonitor {

    /* renamed from: d, reason: collision with root package name */
    public static String f72966d = "AccountReceiver";

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f72967a;

    /* renamed from: b, reason: collision with root package name */
    boolean f72968b = false;

    /* renamed from: c, reason: collision with root package name */
    AccountReceiver f72969c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AccountReceiver extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        public static String f72970b = "AccountReceiver";

        /* renamed from: a, reason: collision with root package name */
        VideoAppInterface f72971a;

        public AccountReceiver(VideoAppInterface videoAppInterface) {
            this.f72971a = videoAppInterface;
        }

        private void a(final String str) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.av.app.GAccountMonitor.AccountReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d(AccountReceiver.f72970b, 1, "do kill process from : " + str);
                    SystemMethodProxy.killProcess(Process.myPid());
                }
            }, 16, null, false, 500L);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && this.f72971a != null) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(f72970b, 2, "recv account broadcast: " + intent.getAction());
                    }
                    if (intent.getAction().equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
                        this.f72971a.v(1001);
                        if (com.tencent.av.r.h0() != null) {
                            com.tencent.av.r.h0().r1();
                        }
                        a(intent.getAction());
                        return;
                    }
                    if (intent.getAction().equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                        this.f72971a.v(1003);
                        if (com.tencent.av.r.h0() != null) {
                            com.tencent.av.r.h0().r1();
                        }
                        a(intent.getAction());
                        return;
                    }
                    if (intent.getAction().equals(NewIntent.ACTION_LOGOUT)) {
                        this.f72971a.v(1002);
                        if (com.tencent.av.r.h0() != null) {
                            com.tencent.av.r.h0().r1();
                        }
                        a(intent.getAction());
                        return;
                    }
                    if (intent.getAction().equals("mqq.intent.action.EXIT_" + this.f72971a.getApp().getPackageName())) {
                        this.f72971a.v(1005);
                        if (com.tencent.av.r.h0() != null) {
                            com.tencent.av.r.h0().r1();
                        }
                        a(intent.getAction());
                        return;
                    }
                    if (NewIntent.ACTION_ACCOUNT_CHANGED.equals(intent.getAction())) {
                        if (com.tencent.av.r.h0() == null) {
                            return;
                        }
                        if (com.tencent.av.r.h0().W0()) {
                            com.tencent.av.r.h0().a2(com.tencent.av.r.h0().b0(), com.tencent.av.r.h0().X(), 74);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e(f72970b, 2, "ACTION_ACCOUNT_CHANGED, video process exit!");
                        }
                        this.f72971a.v(1004);
                        com.tencent.av.r.h0().r1();
                        a(intent.getAction());
                        return;
                    }
                    if ("tencent.video.q2v.membersChange".equals(intent.getAction())) {
                        long longExtra = intent.getLongExtra("relationId", -1L);
                        int intExtra = intent.getIntExtra("relationType", 0);
                        if (longExtra == -1) {
                            if (QLog.isColorLevel()) {
                                QLog.e(f72970b, 2, "can not get the right value");
                                return;
                            }
                            return;
                        }
                        boolean booleanExtra = intent.getBooleanExtra("Exit", false);
                        int intExtra2 = intent.getIntExtra("avtype", 0);
                        this.f72971a.k0(new Object[]{79, Long.valueOf(longExtra), Boolean.valueOf(booleanExtra), Integer.valueOf(intExtra2)});
                        if (booleanExtra && intExtra2 != 2) {
                            com.tencent.av.r.h0().A1(intExtra, longExtra);
                        }
                    }
                } catch (RuntimeException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(f72970b, 2, "RuntimeException", e16);
                    }
                }
            }
        }
    }

    public GAccountMonitor(VideoAppInterface videoAppInterface) {
        this.f72967a = videoAppInterface;
        this.f72969c = new AccountReceiver(videoAppInterface);
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.d(f72966d, 2, "regist QQ Account Receiver, Declare permissions");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction("mqq.intent.action.EXIT_" + this.f72967a.getApplication().getPackageName());
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction("tencent.video.q2v.membersChange");
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        if (this.f72967a.getApplication().registerReceiver(this.f72969c, intentFilter, "com.tencent.msg.permission.pushnotify", null) != null) {
            this.f72968b = true;
        }
    }

    public void b() {
        if (this.f72968b) {
            this.f72967a.getApplication().unregisterReceiver(this.f72969c);
            this.f72968b = false;
        }
    }
}

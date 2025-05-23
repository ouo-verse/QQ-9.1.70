package com.tencent.trackrecordlib.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381140a;

    /* renamed from: b, reason: collision with root package name */
    private static BroadcastReceiver f381141b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381140a = f.class.getSimpleName();
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        f381141b = new a(null);
        context.registerReceiver(f381141b, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    public static void b(Context context) {
        BroadcastReceiver broadcastReceiver;
        if (context != null && (broadcastReceiver = f381141b) != null) {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final String f381142a;

        /* renamed from: b, reason: collision with root package name */
        final String f381143b;

        /* renamed from: c, reason: collision with root package name */
        final String f381144c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f381142a = "reason";
            this.f381143b = GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_RECENT_APPS;
            this.f381144c = GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("reason")) != null) {
                if (stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    com.tencent.trackrecordlib.core.c.a().d();
                } else {
                    stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_RECENT_APPS);
                }
            }
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }
}

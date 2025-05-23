package com.tencent.mobileqq.app.parser.jumpcontroller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f196482a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f196482a = true;
            }
        }
    }

    Boolean a(JumpActivity jumpActivity, Uri uri);

    void b(JumpActivity jumpActivity, Intent intent);

    void c(Context context);

    boolean d(JumpActivity jumpActivity, Intent intent);

    void e(JumpActivity jumpActivity, long j3, String str);

    void f(JumpActivity jumpActivity, long j3, String str);

    boolean g(JumpActivity jumpActivity, String str);

    void h(JumpActivity jumpActivity, Intent intent);

    boolean i(JumpActivity jumpActivity, Intent intent, a aVar);

    void j(Intent intent, JumpActivity jumpActivity);

    void k(QBaseActivity qBaseActivity);

    String l(Context context);

    void m(JumpActivity jumpActivity, Intent intent, int i3);

    void n(JumpActivity jumpActivity, boolean z16, Intent intent);

    boolean o(JumpActivity jumpActivity, Intent intent);

    void p(JumpActivity jumpActivity, Intent intent);

    void q(JumpActivity jumpActivity, boolean z16);

    void r(Context context);

    void s(JumpActivity jumpActivity, Intent intent);
}

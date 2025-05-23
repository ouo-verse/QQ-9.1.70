package com.tencent.could.huiyansdk.fragments;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.enums.HuiYanAuthTipsEvent;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.view.LoadingFrontAnimatorView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e implements com.tencent.could.huiyansdk.callback.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100091a;

    public e(AuthingFragment authingFragment) {
        this.f100091a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    public void a(Context context, int i3, final HuiYanAuthTipsEvent huiYanAuthTipsEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), huiYanAuthTipsEvent);
            return;
        }
        if (context == null) {
            k.a.f100197a.a(2, "AuthingFragment", "context is null!");
            return;
        }
        if (this.f100091a.f100063r) {
            return;
        }
        if (-1 == i3) {
            AuthingFragment authingFragment = this.f100091a;
            int i16 = authingFragment.f100066u;
            if (i16 < 20) {
                authingFragment.f100066u = i16 + 1;
                return;
            }
            authingFragment.f100066u = 0;
        }
        final String string = i3 == -1 ? "" : this.f100091a.c().getString(i3);
        this.f100091a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ad
            @Override // java.lang.Runnable
            public final void run() {
                e.this.a(huiYanAuthTipsEvent, string);
            }
        });
    }

    public void b(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f100091a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ae
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.a(i3);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public void a(final String str, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f100091a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ac
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.a(i3, str);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        TextView textView = this.f100091a.f100049d;
        if (textView != null) {
            textView.setTextColor(i3);
            this.f100091a.f100049d.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(HuiYanAuthTipsEvent huiYanAuthTipsEvent, String str) {
        if (this.f100091a.f100050e == null) {
            return;
        }
        HuiYanSdkImp.getInstance().doAuthTipsEvent(huiYanAuthTipsEvent, true);
        this.f100091a.f100059n.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        Paint paint;
        AuthingFragment authingFragment = this.f100091a;
        if (authingFragment.f100054i == null || authingFragment.f100067v) {
            return;
        }
        LoadingFrontAnimatorView loadingFrontAnimatorView = this.f100091a.f100054i;
        if (i3 == loadingFrontAnimatorView.f100348g || (paint = loadingFrontAnimatorView.f100351j) == null) {
            return;
        }
        loadingFrontAnimatorView.f100348g = i3;
        paint.setColor(i3);
        loadingFrontAnimatorView.invalidate();
    }
}

package com.tencent.creatorad.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.creatorad.data.DataManager;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static e f100399a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements com.tencent.creatorad.data.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f100400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f100401b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f100402c;

        a(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.f100400a = str;
            this.f100401b = viewGroup;
            this.f100402c = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, viewGroup, layoutParams);
            }
        }

        @Override // com.tencent.creatorad.data.a
        public void a(boolean z16, CreatorReader$ShareAD creatorReader$ShareAD) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), creatorReader$ShareAD);
                return;
            }
            if (z16 && com.tencent.creatorad.utils.c.g(creatorReader$ShareAD)) {
                e.this.c(this.f100400a, this.f100401b, this.f100402c, creatorReader$ShareAD);
                return;
            }
            QLog.e("CREATOR_AD.PresenterManager", 1, "onGetShareAD with result=" + z16 + " shardAD=" + creatorReader$ShareAD);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final ViewGroup viewGroup, @Nullable final ViewGroup.LayoutParams layoutParams, final CreatorReader$ShareAD creatorReader$ShareAD) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.creatorad.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.g(viewGroup, creatorReader$ShareAD, str, layoutParams);
            }
        });
    }

    private b d(View view) {
        Object tag = view.getTag(R.id.f1194576w);
        if (tag == null) {
            return null;
        }
        return (b) tag;
    }

    public static e e() {
        if (f100399a == null) {
            synchronized (e.class) {
                if (f100399a == null) {
                    f100399a = new e();
                }
            }
        }
        return f100399a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ViewGroup viewGroup, CreatorReader$ShareAD creatorReader$ShareAD, String str, ViewGroup.LayoutParams layoutParams) {
        boolean z16;
        if (viewGroup.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        b i3 = i(viewGroup, c.c(creatorReader$ShareAD.display.ad_template.get(), z16, creatorReader$ShareAD.display.ad_style.get()));
        if (i3 != null) {
            i3.f(str, viewGroup, layoutParams);
            i3.b(creatorReader$ShareAD);
        }
    }

    private b i(View view, int i3) {
        b d16 = d(view);
        if (d16 != null && d16.c() != i3) {
            d16.o();
            d16 = null;
        }
        if (d16 == null) {
            b a16 = c.b().a(i3);
            j(view, a16);
            return a16;
        }
        return d16;
    }

    private void j(View view, b bVar) {
        view.setTag(R.id.f1194576w, bVar);
    }

    public void f(String str, int i3, ViewGroup viewGroup, @Nullable ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), viewGroup, layoutParams);
            return;
        }
        b d16 = d(viewGroup);
        if (d16 != null) {
            d16.p(4);
        }
        DataManager.d().b(str, i3, new a(str, viewGroup, layoutParams));
    }

    public void h(ViewGroup viewGroup, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, viewGroup, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        b d16 = d(viewGroup);
        if (d16 != null && d16.c() != i3) {
            if (i16 == 0) {
                d16.m();
            }
            if (i16 == 1) {
                d16.l();
            }
        }
    }
}

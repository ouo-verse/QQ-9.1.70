package com.tencent.trackrecordlib.d;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trackrecordlib.core.RecordManager;
import com.tencent.trackrecordlib.d.a.d;
import com.tencent.trackrecordlib.d.a.e;
import com.tencent.trackrecordlib.d.c;
import com.tencent.trackrecordlib.g.i;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f381085a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.trackrecordlib.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C10018a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f381088a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11302);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            a aVar = new a(null);
            f381088a = aVar;
            aVar.c();
        }

        C10018a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    private boolean b(@Nullable com.tencent.trackrecordlib.d.a.b bVar) {
        return bVar == null || TextUtils.isEmpty(com.tencent.trackrecordlib.d.a.c.a(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
    }

    private boolean d(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.isShown() || !view.getGlobalVisibleRect(rect) || !i.h(view)) {
            return false;
        }
        return true;
    }

    private boolean e(View view) {
        return !this.f381085a.b(view);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f381085a = c.a.a();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private boolean b(View view) {
        return e(view) && d(view);
    }

    private boolean c(View view) {
        String str;
        return (view == null || (str = (String) e.d(view, d.f381096b)) == null || !str.equals(com.tencent.trackrecordlib.g.b.b())) ? false : true;
    }

    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        if (RecordManager.getInstance().isEnableExposure() && a(com.tencent.trackrecordlib.d.a.a.a(view)) && b(view)) {
            e.b(view, d.f381097c, Long.valueOf(System.currentTimeMillis()));
            e.b(view, d.f381096b, com.tencent.trackrecordlib.g.b.b());
            e.b(view, d.f381095a, com.tencent.trackrecordlib.g.b.c());
            this.f381085a.a(view);
        }
    }

    public static a b() {
        return C10018a.f381088a;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!RecordManager.getInstance().isEnableExposure() || this.f381085a.d().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (View view : this.f381085a.d()) {
            if (!c(view) || !d(view)) {
                arrayList.add(view);
                long currentTimeMillis = System.currentTimeMillis();
                int longValue = (int) (currentTimeMillis - ((Long) e.d(view, d.f381097c)).longValue());
                e.b(view, d.f381098d, Long.valueOf(currentTimeMillis));
                e.b(view, d.f381099e, Integer.valueOf(longValue));
                com.tencent.trackrecordlib.core.c.a().a(view, longValue, (String) e.d(view, d.f381096b), (String) e.d(view, d.f381095a));
            }
        }
        this.f381085a.a(arrayList);
    }

    public boolean a(@Nullable com.tencent.trackrecordlib.d.a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? !b(bVar) : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar)).booleanValue();
    }
}

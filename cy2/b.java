package cy2;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenChangedEvent;
import com.tencent.qphone.base.util.QLog;
import px2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Handler f392396a;

    /* renamed from: c, reason: collision with root package name */
    private View f392398c;

    /* renamed from: d, reason: collision with root package name */
    private View f392399d;

    /* renamed from: e, reason: collision with root package name */
    private View f392400e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f392401f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f392402g;

    /* renamed from: h, reason: collision with root package name */
    private int f392403h;

    /* renamed from: i, reason: collision with root package name */
    private int f392404i;

    /* renamed from: b, reason: collision with root package name */
    private int f392397b = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f392405j = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends e.a {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cy2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C10145b extends e.a {
        C10145b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public static b f392408a = new b();
    }

    b() {
        j();
    }

    private void C() {
        D(true);
    }

    private void D(boolean z16) {
        View view;
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoScreenChangedEvent(0));
        if (this.f392405j) {
            view = this.f392398c;
        } else {
            view = null;
        }
        e.l(view, this.f392400e, this.f392399d, new a());
        if (z16) {
            E();
        }
    }

    private void E() {
        if (this.f392396a == null) {
            j();
        }
        this.f392396a.removeCallbacks(this.f392401f);
        this.f392396a.postDelayed(this.f392401f, 5000L);
    }

    private void F() {
        if (this.f392396a == null) {
            j();
        }
        this.f392396a.removeCallbacks(this.f392401f);
    }

    public static b e() {
        return c.f392408a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void m() {
        View view;
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoScreenChangedEvent(1));
        if (this.f392405j) {
            view = this.f392398c;
        } else {
            view = null;
        }
        e.m(view, this.f392400e, this.f392399d, new C10145b());
    }

    private void j() {
        this.f392396a = new Handler(Looper.getMainLooper());
        this.f392401f = new Runnable() { // from class: cy2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.m();
            }
        };
    }

    private boolean l() {
        return this.f392402g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        QLog.i("PlayerLandscapeUIStateManager", 1, "onHideEnd");
        this.f392397b = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f392397b = 0;
    }

    public void A(boolean z16) {
        this.f392402g = z16;
    }

    public void B() {
        View view;
        if (this.f392397b == 1 && (view = this.f392399d) != null) {
            view.setTranslationY(0.0f);
        }
    }

    public int d() {
        if (this.f392403h != 2 || this.f392398c == null || !k()) {
            return 0;
        }
        if (this.f392404i == 0) {
            this.f392404i = e.g(R.dimen.f159609dh0) + e.i();
        }
        return this.f392404i;
    }

    public int f() {
        return this.f392397b;
    }

    public void g() {
        if (this.f392399d == null) {
            return;
        }
        this.f392399d.setTranslationY(e.g(R.dimen.dh5));
    }

    public void i(View view, View view2, boolean z16) {
        this.f392400e = view;
        this.f392399d = view2;
        this.f392405j = z16;
    }

    public boolean k() {
        if (this.f392397b == 1) {
            return true;
        }
        return false;
    }

    public void n(View view, View view2) {
        if (k()) {
            view.setTranslationY(0.0f);
            view2.setTranslationY(e.g(R.dimen.dh5));
        } else {
            view.setTranslationY(0.0f);
            view2.setTranslationY(0.0f);
        }
    }

    public void o() {
        if (this.f392397b == 0) {
            m();
        } else {
            C();
        }
    }

    public void p(int i3) {
        this.f392403h = i3;
        if (i3 == 2) {
            C();
        }
    }

    public void q(View view, View view2, boolean z16) {
        i(view, view2, z16);
        n(view, view2);
        E();
    }

    public void t() {
        A(false);
        D(false);
    }

    public void u() {
        QLog.i("PlayerLandscapeUIStateManager", 1, "onShowTips");
        m();
    }

    public void v() {
        View view = this.f392399d;
        if (view == null) {
            return;
        }
        if (this.f392397b == 1) {
            g();
        } else {
            view.setTranslationY(0.0f);
        }
    }

    public void w(int i3) {
        if (i3 == 0) {
            F();
        } else if (!k() && l()) {
            E();
        }
    }

    public void x() {
        this.f392397b = 0;
        Handler handler = this.f392396a;
        if (handler != null) {
            handler.removeCallbacks(this.f392401f);
        }
        this.f392398c = null;
        this.f392399d = null;
        this.f392400e = null;
        this.f392401f = null;
        this.f392396a = null;
    }

    public void y() {
        if (this.f392397b == 0) {
            if (this.f392396a == null) {
                j();
            }
            this.f392396a.removeCallbacks(this.f392401f);
            this.f392396a.postDelayed(this.f392401f, 5000L);
        }
    }

    public void z(View view) {
        this.f392398c = view;
    }
}

package jk0;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ecommerce.richtext.ui.view.lottie.VLottieView;
import com.tencent.ecommerce.richtext.utils.e;
import ik0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends ik0.c<View> {

    /* renamed from: k, reason: collision with root package name */
    private String f410312k;

    /* renamed from: l, reason: collision with root package name */
    private Animator.AnimatorListener f410313l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: jk0.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C10593b implements c {
        C10593b() {
        }

        @Override // jk0.b.c
        public void onResult(boolean z16) {
            try {
                if (b.this.f407893d != null && e.f(b.this.f407893d.Z().get("isAutoPlay"))) {
                    b.this.R();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void onResult(boolean z16);
    }

    public b(fk0.c cVar, lk0.b bVar, d dVar) {
        super(cVar, bVar, dVar);
        this.f410313l = new a();
    }

    @Override // ik0.c
    protected boolean M(String str, Object obj) {
        str.hashCode();
        if (!str.equals("src")) {
            if (!str.equals("loop")) {
                return super.M(str, obj);
            }
            S(e.f(obj));
            return true;
        }
        T(e.p(obj, ""));
        return true;
    }

    public nk0.a Q() {
        if (n() instanceof nk0.a) {
            return (nk0.a) n();
        }
        return null;
    }

    public void R() {
        if (!TextUtils.isEmpty(this.f410312k) && Q() != null) {
            Q().g();
        }
    }

    public void S(boolean z16) {
        if (Q() != null) {
            Q().c(z16);
        }
    }

    public void T(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(this.f410312k, str) && Q() != null) {
            this.f410312k = str;
            Q().d(this.f410312k, new C10593b());
        }
    }

    @Override // ik0.c
    protected View q(@NonNull Context context) {
        VLottieView vLottieView = new VLottieView(context);
        vLottieView.c(true);
        vLottieView.a(this.f410313l);
        return vLottieView.b();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends mk0.a {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // mk0.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // mk0.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

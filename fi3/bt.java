package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bt implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399149a;

    /* renamed from: b, reason: collision with root package name */
    public final Guideline f399150b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f399151c;

    /* renamed from: d, reason: collision with root package name */
    public final LottieAnimationView f399152d;

    bt(ConstraintLayout constraintLayout, Guideline guideline, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView) {
        this.f399149a = constraintLayout;
        this.f399150b = guideline;
        this.f399151c = constraintLayout2;
        this.f399152d = lottieAnimationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399149a;
    }

    public static bt g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bt e(View view) {
        int i3 = R.id.f163413q02;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.f163413q02);
        if (guideline != null) {
            i3 = R.id.q6r;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.q6r);
            if (constraintLayout != null) {
                i3 = R.id.qsl;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.qsl);
                if (lottieAnimationView != null) {
                    return new bt((ConstraintLayout) view, guideline, constraintLayout, lottieAnimationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bt h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.deo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

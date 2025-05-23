package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class au implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f398939a;

    /* renamed from: b, reason: collision with root package name */
    public final QUSHalfScreenFloatingView f398940b;

    au(RelativeLayout relativeLayout, QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
        this.f398939a = relativeLayout;
        this.f398940b = qUSHalfScreenFloatingView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f398939a;
    }

    public static au g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static au e(View view) {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) ViewBindings.findChildViewById(view, R.id.r3w);
        if (qUSHalfScreenFloatingView != null) {
            return new au((RelativeLayout) view, qUSHalfScreenFloatingView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.r3w)));
    }

    public static au h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167439db3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

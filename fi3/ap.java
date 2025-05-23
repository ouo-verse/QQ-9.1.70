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
public final class ap implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f398883a;

    /* renamed from: b, reason: collision with root package name */
    public final QUSHalfScreenFloatingView f398884b;

    ap(RelativeLayout relativeLayout, QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
        this.f398883a = relativeLayout;
        this.f398884b = qUSHalfScreenFloatingView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f398883a;
    }

    public static ap e(View view) {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) ViewBindings.findChildViewById(view, R.id.qfe);
        if (qUSHalfScreenFloatingView != null) {
            return new ap((RelativeLayout) view, qUSHalfScreenFloatingView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qfe)));
    }

    public static ap g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dah, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

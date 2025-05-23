package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.color.list.CircleColorView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class da implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419196a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f419197b;

    /* renamed from: c, reason: collision with root package name */
    public final CircleColorView f419198c;

    /* renamed from: d, reason: collision with root package name */
    public final View f419199d;

    /* renamed from: e, reason: collision with root package name */
    public final View f419200e;

    da(FrameLayout frameLayout, FrameLayout frameLayout2, CircleColorView circleColorView, View view, View view2) {
        this.f419196a = frameLayout;
        this.f419197b = frameLayout2;
        this.f419198c = circleColorView;
        this.f419199d = view;
        this.f419200e = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419196a;
    }

    public static da e(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i3 = R.id.pku;
        CircleColorView circleColorView = (CircleColorView) ViewBindings.findChildViewById(view, R.id.pku);
        if (circleColorView != null) {
            i3 = R.id.pkv;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.pkv);
            if (findChildViewById != null) {
                i3 = R.id.qjq;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.qjq);
                if (findChildViewById2 != null) {
                    return new da(frameLayout, frameLayout, circleColorView, findChildViewById, findChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static da g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static da h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dfg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

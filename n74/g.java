package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContainerView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419337a;

    /* renamed from: b, reason: collision with root package name */
    public final View f419338b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419339c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f419340d;

    /* renamed from: e, reason: collision with root package name */
    public final ZPlanTabContainerView f419341e;

    g(FrameLayout frameLayout, View view, FrameLayout frameLayout2, FrameLayout frameLayout3, ZPlanTabContainerView zPlanTabContainerView) {
        this.f419337a = frameLayout;
        this.f419338b = view;
        this.f419339c = frameLayout2;
        this.f419340d = frameLayout3;
        this.f419341e = zPlanTabContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419337a;
    }

    public static g g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static g e(View view) {
        int i3 = R.id.f163332pk1;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163332pk1);
        if (findChildViewById != null) {
            i3 = R.id.pto;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pto);
            if (frameLayout != null) {
                i3 = R.id.qbc;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qbc);
                if (frameLayout2 != null) {
                    i3 = R.id.qp8;
                    ZPlanTabContainerView zPlanTabContainerView = (ZPlanTabContainerView) ViewBindings.findChildViewById(view, R.id.qp8);
                    if (zPlanTabContainerView != null) {
                        return new g((FrameLayout) view, findChildViewById, frameLayout, frameLayout2, zPlanTabContainerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static g h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d9o, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

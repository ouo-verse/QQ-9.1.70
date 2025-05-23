package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.dialog.SmallHomeDataTabTitleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399292a;

    /* renamed from: b, reason: collision with root package name */
    public final SmallHomeDataTabTitleView f399293b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager f399294c;

    k(ConstraintLayout constraintLayout, SmallHomeDataTabTitleView smallHomeDataTabTitleView, ViewPager viewPager) {
        this.f399292a = constraintLayout;
        this.f399293b = smallHomeDataTabTitleView;
        this.f399294c = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399292a;
    }

    public static k g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static k e(View view) {
        int i3 = R.id.qpb;
        SmallHomeDataTabTitleView smallHomeDataTabTitleView = (SmallHomeDataTabTitleView) ViewBindings.findChildViewById(view, R.id.qpb);
        if (smallHomeDataTabTitleView != null) {
            i3 = R.id.qyg;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.qyg);
            if (viewPager != null) {
                return new k((ConstraintLayout) view, smallHomeDataTabTitleView, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static k h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

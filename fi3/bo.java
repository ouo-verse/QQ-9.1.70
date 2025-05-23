package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.aio.panel.tab.view.AioTabLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bo implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399133a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f399134b;

    /* renamed from: c, reason: collision with root package name */
    public final AioTabLayout f399135c;

    bo(ConstraintLayout constraintLayout, ViewPager2 viewPager2, AioTabLayout aioTabLayout) {
        this.f399133a = constraintLayout;
        this.f399134b = viewPager2;
        this.f399135c = aioTabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399133a;
    }

    public static bo e(View view) {
        int i3 = R.id.pa_;
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.pa_);
        if (viewPager2 != null) {
            i3 = R.id.paa;
            AioTabLayout aioTabLayout = (AioTabLayout) ViewBindings.findChildViewById(view, R.id.paa);
            if (aioTabLayout != null) {
                return new bo((ConstraintLayout) view, viewPager2, aioTabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bo g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

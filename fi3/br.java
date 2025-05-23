package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.aio.panel.tab.view.SpaceTabLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class br implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399142a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f399143b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager2 f399144c;

    /* renamed from: d, reason: collision with root package name */
    public final SpaceTabLayout f399145d;

    br(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ViewPager2 viewPager2, SpaceTabLayout spaceTabLayout) {
        this.f399142a = constraintLayout;
        this.f399143b = constraintLayout2;
        this.f399144c = viewPager2;
        this.f399145d = spaceTabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399142a;
    }

    public static br e(View view) {
        int i3 = R.id.qmo;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.qmo);
        if (constraintLayout != null) {
            i3 = R.id.qmp;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.qmp);
            if (viewPager2 != null) {
                i3 = R.id.qmq;
                SpaceTabLayout spaceTabLayout = (SpaceTabLayout) ViewBindings.findChildViewById(view, R.id.qmq);
                if (spaceTabLayout != null) {
                    return new br((ConstraintLayout) view, constraintLayout, viewPager2, spaceTabLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static br g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

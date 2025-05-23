package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentBtmTitle;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class co implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419045a;

    /* renamed from: b, reason: collision with root package name */
    public final SelectPublishContentBtmTitle f419046b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager f419047c;

    co(ConstraintLayout constraintLayout, SelectPublishContentBtmTitle selectPublishContentBtmTitle, ViewPager viewPager) {
        this.f419045a = constraintLayout;
        this.f419046b = selectPublishContentBtmTitle;
        this.f419047c = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f419045a;
    }

    public static co e(View view) {
        int i3 = R.id.f163307pf1;
        SelectPublishContentBtmTitle selectPublishContentBtmTitle = (SelectPublishContentBtmTitle) ViewBindings.findChildViewById(view, R.id.f163307pf1);
        if (selectPublishContentBtmTitle != null) {
            i3 = R.id.qye;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.qye);
            if (viewPager != null) {
                return new co((ConstraintLayout) view, selectPublishContentBtmTitle, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static co g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dez, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

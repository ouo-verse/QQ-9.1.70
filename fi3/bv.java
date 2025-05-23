package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.group.guide.SmallHomeCoverGuideIndicator;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bv implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399166a;

    /* renamed from: b, reason: collision with root package name */
    public final CheckBox f399167b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399168c;

    /* renamed from: d, reason: collision with root package name */
    public final SmallHomeCoverGuideIndicator f399169d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewPager f399170e;

    bv(LinearLayout linearLayout, CheckBox checkBox, TextView textView, SmallHomeCoverGuideIndicator smallHomeCoverGuideIndicator, ViewPager viewPager) {
        this.f399166a = linearLayout;
        this.f399167b = checkBox;
        this.f399168c = textView;
        this.f399169d = smallHomeCoverGuideIndicator;
        this.f399170e = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399166a;
    }

    public static bv e(View view) {
        int i3 = R.id.pj6;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.pj6);
        if (checkBox != null) {
            i3 = R.id.pwz;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pwz);
            if (textView != null) {
                i3 = R.id.q1v;
                SmallHomeCoverGuideIndicator smallHomeCoverGuideIndicator = (SmallHomeCoverGuideIndicator) ViewBindings.findChildViewById(view, R.id.q1v);
                if (smallHomeCoverGuideIndicator != null) {
                    i3 = R.id.qyh;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.qyh);
                    if (viewPager != null) {
                        return new bv((LinearLayout) view, checkBox, textView, smallHomeCoverGuideIndicator, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bv g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dfj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

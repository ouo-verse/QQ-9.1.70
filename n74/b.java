package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418779a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaPullRefreshLayout f418780b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaLoadFailView f418781c;

    /* renamed from: d, reason: collision with root package name */
    public final ShimmerLinearLayout f418782d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f418783e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f418784f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f418785g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f418786h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f418787i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f418788j;

    b(FrameLayout frameLayout, ZootopiaPullRefreshLayout zootopiaPullRefreshLayout, ZootopiaLoadFailView zootopiaLoadFailView, ShimmerLinearLayout shimmerLinearLayout, RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.f418779a = frameLayout;
        this.f418780b = zootopiaPullRefreshLayout;
        this.f418781c = zootopiaLoadFailView;
        this.f418782d = shimmerLinearLayout;
        this.f418783e = relativeLayout;
        this.f418784f = imageView;
        this.f418785g = linearLayout;
        this.f418786h = textView;
        this.f418787i = frameLayout2;
        this.f418788j = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418779a;
    }

    public static b e(View view) {
        int i3 = R.id.pl9;
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = (ZootopiaPullRefreshLayout) ViewBindings.findChildViewById(view, R.id.pl9);
        if (zootopiaPullRefreshLayout != null) {
            i3 = R.id.pl_;
            ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.pl_);
            if (zootopiaLoadFailView != null) {
                i3 = R.id.pla;
                ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.pla);
                if (shimmerLinearLayout != null) {
                    i3 = R.id.plb;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.plb);
                    if (relativeLayout != null) {
                        i3 = R.id.plc;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.plc);
                        if (imageView != null) {
                            i3 = R.id.pld;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pld);
                            if (linearLayout != null) {
                                i3 = R.id.ple;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ple);
                                if (textView != null) {
                                    i3 = R.id.pm8;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pm8);
                                    if (frameLayout != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) view;
                                        return new b(frameLayout2, zootopiaPullRefreshLayout, zootopiaLoadFailView, shimmerLinearLayout, relativeLayout, imageView, linearLayout, textView, frameLayout, frameLayout2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static b g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d76, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

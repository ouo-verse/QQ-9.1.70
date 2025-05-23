package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.recommend.common.ZplanCardFeedsListView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399254a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f399255b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399256c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399257d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f399258e;

    /* renamed from: f, reason: collision with root package name */
    public final ZplanCardFeedsListView f399259f;

    /* renamed from: g, reason: collision with root package name */
    public final ZootopiaLoadFailView f399260g;

    /* renamed from: h, reason: collision with root package name */
    public final ShimmerLinearLayout f399261h;

    f(FrameLayout frameLayout, RelativeLayout relativeLayout, ImageView imageView, TextView textView, FrameLayout frameLayout2, ZplanCardFeedsListView zplanCardFeedsListView, ZootopiaLoadFailView zootopiaLoadFailView, ShimmerLinearLayout shimmerLinearLayout) {
        this.f399254a = frameLayout;
        this.f399255b = relativeLayout;
        this.f399256c = imageView;
        this.f399257d = textView;
        this.f399258e = frameLayout2;
        this.f399259f = zplanCardFeedsListView;
        this.f399260g = zootopiaLoadFailView;
        this.f399261h = shimmerLinearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399254a;
    }

    public static f e(View view) {
        int i3 = R.id.plb;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.plb);
        if (relativeLayout != null) {
            i3 = R.id.plc;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.plc);
            if (imageView != null) {
                i3 = R.id.ple;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ple);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i3 = R.id.r0l;
                    ZplanCardFeedsListView zplanCardFeedsListView = (ZplanCardFeedsListView) ViewBindings.findChildViewById(view, R.id.r0l);
                    if (zplanCardFeedsListView != null) {
                        i3 = R.id.r0x;
                        ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.r0x);
                        if (zootopiaLoadFailView != null) {
                            i3 = R.id.r0y;
                            ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.r0y);
                            if (shimmerLinearLayout != null) {
                                return new f(frameLayout, relativeLayout, imageView, textView, frameLayout, zplanCardFeedsListView, zootopiaLoadFailView, shimmerLinearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static f g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

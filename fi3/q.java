package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399323a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399324b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f399325c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399326d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f399327e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399328f;

    /* renamed from: g, reason: collision with root package name */
    public final ZootopiaDetailFloatBar f399329g;

    /* renamed from: h, reason: collision with root package name */
    public final ZootopiaPullRefreshLayout f399330h;

    /* renamed from: i, reason: collision with root package name */
    public final ShimmerLinearLayout f399331i;

    /* renamed from: j, reason: collision with root package name */
    public final ZootopiaLoadFailView f399332j;

    q(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, TextView textView, ImageView imageView2, ImageView imageView3, ZootopiaDetailFloatBar zootopiaDetailFloatBar, ZootopiaPullRefreshLayout zootopiaPullRefreshLayout, ShimmerLinearLayout shimmerLinearLayout, ZootopiaLoadFailView zootopiaLoadFailView) {
        this.f399323a = frameLayout;
        this.f399324b = imageView;
        this.f399325c = frameLayout2;
        this.f399326d = textView;
        this.f399327e = imageView2;
        this.f399328f = imageView3;
        this.f399329g = zootopiaDetailFloatBar;
        this.f399330h = zootopiaPullRefreshLayout;
        this.f399331i = shimmerLinearLayout;
        this.f399332j = zootopiaLoadFailView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399323a;
    }

    public static q e(View view) {
        int i3 = R.id.pfa;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pfa);
        if (imageView != null) {
            i3 = R.id.pfw;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pfw);
            if (frameLayout != null) {
                i3 = R.id.pfx;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pfx);
                if (textView != null) {
                    i3 = R.id.pfy;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pfy);
                    if (imageView2 != null) {
                        i3 = R.id.pfz;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pfz);
                        if (imageView3 != null) {
                            i3 = R.id.puk;
                            ZootopiaDetailFloatBar zootopiaDetailFloatBar = (ZootopiaDetailFloatBar) ViewBindings.findChildViewById(view, R.id.puk);
                            if (zootopiaDetailFloatBar != null) {
                                i3 = R.id.f163504qh2;
                                ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = (ZootopiaPullRefreshLayout) ViewBindings.findChildViewById(view, R.id.f163504qh2);
                                if (zootopiaPullRefreshLayout != null) {
                                    i3 = R.id.f163505qh3;
                                    ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.f163505qh3);
                                    if (shimmerLinearLayout != null) {
                                        i3 = R.id.r0x;
                                        ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.r0x);
                                        if (zootopiaLoadFailView != null) {
                                            return new q((FrameLayout) view, imageView, frameLayout, textView, imageView2, imageView3, zootopiaDetailFloatBar, zootopiaPullRefreshLayout, shimmerLinearLayout, zootopiaLoadFailView);
                                        }
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

    public static q g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167425d84, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

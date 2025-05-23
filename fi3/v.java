package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaMaskView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399403a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaDownloadButton f399404b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaPlayerView f399405c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399406d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f399407e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f399408f;

    /* renamed from: g, reason: collision with root package name */
    public final HorizontalScrollView f399409g;

    /* renamed from: h, reason: collision with root package name */
    public final ZootopiaMaskView f399410h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f399411i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f399412j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f399413k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f399414l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f399415m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f399416n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f399417o;

    /* renamed from: p, reason: collision with root package name */
    public final ShimmerLinearLayout f399418p;

    /* renamed from: q, reason: collision with root package name */
    public final n74.bk f399419q;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f399403a;
    }

    v(View view, ZootopiaDownloadButton zootopiaDownloadButton, ZootopiaPlayerView zootopiaPlayerView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView, ZootopiaMaskView zootopiaMaskView, RelativeLayout relativeLayout, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ShimmerLinearLayout shimmerLinearLayout, n74.bk bkVar) {
        this.f399403a = view;
        this.f399404b = zootopiaDownloadButton;
        this.f399405c = zootopiaPlayerView;
        this.f399406d = imageView;
        this.f399407e = imageView2;
        this.f399408f = linearLayout;
        this.f399409g = horizontalScrollView;
        this.f399410h = zootopiaMaskView;
        this.f399411i = relativeLayout;
        this.f399412j = frameLayout;
        this.f399413k = textView;
        this.f399414l = textView2;
        this.f399415m = textView3;
        this.f399416n = textView4;
        this.f399417o = textView5;
        this.f399418p = shimmerLinearLayout;
        this.f399419q = bkVar;
    }

    public static v e(View view) {
        int i3 = R.id.f163312pg1;
        ZootopiaDownloadButton zootopiaDownloadButton = (ZootopiaDownloadButton) ViewBindings.findChildViewById(view, R.id.f163312pg1);
        if (zootopiaDownloadButton != null) {
            i3 = R.id.q1m;
            ZootopiaPlayerView zootopiaPlayerView = (ZootopiaPlayerView) ViewBindings.findChildViewById(view, R.id.q1m);
            if (zootopiaPlayerView != null) {
                i3 = R.id.q1p;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q1p);
                if (imageView != null) {
                    i3 = R.id.q46;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q46);
                    if (imageView2 != null) {
                        i3 = R.id.q5s;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q5s);
                        if (linearLayout != null) {
                            i3 = R.id.q5t;
                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.q5t);
                            if (horizontalScrollView != null) {
                                i3 = R.id.q7x;
                                ZootopiaMaskView zootopiaMaskView = (ZootopiaMaskView) ViewBindings.findChildViewById(view, R.id.q7x);
                                if (zootopiaMaskView != null) {
                                    i3 = R.id.qi5;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qi5);
                                    if (relativeLayout != null) {
                                        i3 = R.id.qi_;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qi_);
                                        if (frameLayout != null) {
                                            i3 = R.id.qts;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qts);
                                            if (textView != null) {
                                                i3 = R.id.qtz;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qtz);
                                                if (textView2 != null) {
                                                    i3 = R.id.que;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.que);
                                                    if (textView3 != null) {
                                                        i3 = R.id.quf;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.quf);
                                                        if (textView4 != null) {
                                                            i3 = R.id.qul;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qul);
                                                            if (textView5 != null) {
                                                                i3 = R.id.r0i;
                                                                ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.r0i);
                                                                if (shimmerLinearLayout != null) {
                                                                    i3 = R.id.r5c;
                                                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.r5c);
                                                                    if (findChildViewById != null) {
                                                                        return new v(view, zootopiaDownloadButton, zootopiaPlayerView, imageView, imageView2, linearLayout, horizontalScrollView, zootopiaMaskView, relativeLayout, frameLayout, textView, textView2, textView3, textView4, textView5, shimmerLinearLayout, n74.bk.e(findChildViewById));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static v f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d8_, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

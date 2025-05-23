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
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailImageGallery;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaExpandTextView;
import com.tencent.mobileqq.zootopia.view.ZootopiaUserView;
import com.tencent.mobileqq.zootopia.view.ZootopiaVersionView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaMaskView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399333a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaDownloadButton f399334b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaPlayerView f399335c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399336d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f399337e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f399338f;

    /* renamed from: g, reason: collision with root package name */
    public final HorizontalScrollView f399339g;

    /* renamed from: h, reason: collision with root package name */
    public final ZootopiaMaskView f399340h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f399341i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f399342j;

    /* renamed from: k, reason: collision with root package name */
    public final ZootopiaExpandTextView f399343k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f399344l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f399345m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f399346n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f399347o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f399348p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f399349q;

    /* renamed from: r, reason: collision with root package name */
    public final ZootopiaDetailImageGallery f399350r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f399351s;

    /* renamed from: t, reason: collision with root package name */
    public final ShimmerLinearLayout f399352t;

    /* renamed from: u, reason: collision with root package name */
    public final ZootopiaVersionView f399353u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f399354v;

    /* renamed from: w, reason: collision with root package name */
    public final ZootopiaUserView f399355w;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f399333a;
    }

    r(View view, ZootopiaDownloadButton zootopiaDownloadButton, ZootopiaPlayerView zootopiaPlayerView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView, ZootopiaMaskView zootopiaMaskView, RelativeLayout relativeLayout, FrameLayout frameLayout, ZootopiaExpandTextView zootopiaExpandTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ZootopiaDetailImageGallery zootopiaDetailImageGallery, TextView textView7, ShimmerLinearLayout shimmerLinearLayout, ZootopiaVersionView zootopiaVersionView, TextView textView8, ZootopiaUserView zootopiaUserView) {
        this.f399333a = view;
        this.f399334b = zootopiaDownloadButton;
        this.f399335c = zootopiaPlayerView;
        this.f399336d = imageView;
        this.f399337e = imageView2;
        this.f399338f = linearLayout;
        this.f399339g = horizontalScrollView;
        this.f399340h = zootopiaMaskView;
        this.f399341i = relativeLayout;
        this.f399342j = frameLayout;
        this.f399343k = zootopiaExpandTextView;
        this.f399344l = textView;
        this.f399345m = textView2;
        this.f399346n = textView3;
        this.f399347o = textView4;
        this.f399348p = textView5;
        this.f399349q = textView6;
        this.f399350r = zootopiaDetailImageGallery;
        this.f399351s = textView7;
        this.f399352t = shimmerLinearLayout;
        this.f399353u = zootopiaVersionView;
        this.f399354v = textView8;
        this.f399355w = zootopiaUserView;
    }

    public static r e(View view) {
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
                                            i3 = R.id.qtd;
                                            ZootopiaExpandTextView zootopiaExpandTextView = (ZootopiaExpandTextView) ViewBindings.findChildViewById(view, R.id.qtd);
                                            if (zootopiaExpandTextView != null) {
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
                                                                    i3 = R.id.qze;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qze);
                                                                    if (textView6 != null) {
                                                                        i3 = R.id.qzj;
                                                                        ZootopiaDetailImageGallery zootopiaDetailImageGallery = (ZootopiaDetailImageGallery) ViewBindings.findChildViewById(view, R.id.qzj);
                                                                        if (zootopiaDetailImageGallery != null) {
                                                                            i3 = R.id.qzm;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.qzm);
                                                                            if (textView7 != null) {
                                                                                i3 = R.id.r0i;
                                                                                ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.r0i);
                                                                                if (shimmerLinearLayout != null) {
                                                                                    i3 = R.id.r2c;
                                                                                    ZootopiaVersionView zootopiaVersionView = (ZootopiaVersionView) ViewBindings.findChildViewById(view, R.id.r2c);
                                                                                    if (zootopiaVersionView != null) {
                                                                                        i3 = R.id.r2f;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.r2f);
                                                                                        if (textView8 != null) {
                                                                                            i3 = R.id.r2g;
                                                                                            ZootopiaUserView zootopiaUserView = (ZootopiaUserView) ViewBindings.findChildViewById(view, R.id.r2g);
                                                                                            if (zootopiaUserView != null) {
                                                                                                return new r(view, zootopiaDownloadButton, zootopiaPlayerView, imageView, imageView2, linearLayout, horizontalScrollView, zootopiaMaskView, relativeLayout, frameLayout, zootopiaExpandTextView, textView, textView2, textView3, textView4, textView5, textView6, zootopiaDetailImageGallery, textView7, shimmerLinearLayout, zootopiaVersionView, textView8, zootopiaUserView);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static r f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d86, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

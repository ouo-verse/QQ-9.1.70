package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.avatar.loading.anim.ZPlanLoadingAnimView;
import com.tencent.sqshow.zootopia.nativeui.view.control.LoadingPanelControlView;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class am implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f398843a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f398844b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f398845c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f398846d;

    /* renamed from: e, reason: collision with root package name */
    public final URLImageView f398847e;

    /* renamed from: f, reason: collision with root package name */
    public final View f398848f;

    /* renamed from: g, reason: collision with root package name */
    public final ZPlanLoadingAnimView f398849g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f398850h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f398851i;

    /* renamed from: j, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f398852j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f398853k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f398854l;

    /* renamed from: m, reason: collision with root package name */
    public final ProgressBar f398855m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f398856n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f398857o;

    /* renamed from: p, reason: collision with root package name */
    public final View f398858p;

    /* renamed from: q, reason: collision with root package name */
    public final LoadingPanelControlView f398859q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f398860r;

    /* renamed from: s, reason: collision with root package name */
    public final ImageView f398861s;

    /* renamed from: t, reason: collision with root package name */
    public final View f398862t;

    /* renamed from: u, reason: collision with root package name */
    public final View f398863u;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f398843a;
    }

    am(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ImageView imageView2, URLImageView uRLImageView, View view, ZPlanLoadingAnimView zPlanLoadingAnimView, ImageView imageView3, LinearLayout linearLayout, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, LinearLayout linearLayout2, TextView textView, ProgressBar progressBar, TextView textView2, TextView textView3, View view2, LoadingPanelControlView loadingPanelControlView, FrameLayout frameLayout3, ImageView imageView4, View view3, View view4) {
        this.f398843a = frameLayout;
        this.f398844b = imageView;
        this.f398845c = frameLayout2;
        this.f398846d = imageView2;
        this.f398847e = uRLImageView;
        this.f398848f = view;
        this.f398849g = zPlanLoadingAnimView;
        this.f398850h = imageView3;
        this.f398851i = linearLayout;
        this.f398852j = zplanExcludeFontPaddingTextView;
        this.f398853k = linearLayout2;
        this.f398854l = textView;
        this.f398855m = progressBar;
        this.f398856n = textView2;
        this.f398857o = textView3;
        this.f398858p = view2;
        this.f398859q = loadingPanelControlView;
        this.f398860r = frameLayout3;
        this.f398861s = imageView4;
        this.f398862t = view3;
        this.f398863u = view4;
    }

    public static am g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.da9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static am e(View view) {
        int i3 = R.id.pao;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pao);
        if (imageView != null) {
            i3 = R.id.pay;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pay);
            if (frameLayout != null) {
                i3 = R.id.paz;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.paz);
                if (imageView2 != null) {
                    i3 = R.id.pb6;
                    URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.pb6);
                    if (uRLImageView != null) {
                        i3 = R.id.pem;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pem);
                        if (findChildViewById != null) {
                            i3 = R.id.f163447q60;
                            ZPlanLoadingAnimView zPlanLoadingAnimView = (ZPlanLoadingAnimView) ViewBindings.findChildViewById(view, R.id.f163447q60);
                            if (zPlanLoadingAnimView != null) {
                                i3 = R.id.f163449q62;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163449q62);
                                if (imageView3 != null) {
                                    i3 = R.id.q68;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q68);
                                    if (linearLayout != null) {
                                        i3 = R.id.q6c;
                                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.q6c);
                                        if (zplanExcludeFontPaddingTextView != null) {
                                            i3 = R.id.q6f;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q6f);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.q6g;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.q6g);
                                                if (textView != null) {
                                                    i3 = R.id.q6h;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.q6h);
                                                    if (progressBar != null) {
                                                        i3 = R.id.q6k;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.q6k);
                                                        if (textView2 != null) {
                                                            i3 = R.id.q6l;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.q6l);
                                                            if (textView3 != null) {
                                                                i3 = R.id.q6n;
                                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q6n);
                                                                if (findChildViewById2 != null) {
                                                                    i3 = R.id.qbh;
                                                                    LoadingPanelControlView loadingPanelControlView = (LoadingPanelControlView) ViewBindings.findChildViewById(view, R.id.qbh);
                                                                    if (loadingPanelControlView != null) {
                                                                        i3 = R.id.qhq;
                                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qhq);
                                                                        if (frameLayout2 != null) {
                                                                            i3 = R.id.qmj;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qmj);
                                                                            if (imageView4 != null) {
                                                                                i3 = R.id.qs8;
                                                                                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.qs8);
                                                                                if (findChildViewById3 != null) {
                                                                                    i3 = R.id.qs_;
                                                                                    View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.qs_);
                                                                                    if (findChildViewById4 != null) {
                                                                                        return new am((FrameLayout) view, imageView, frameLayout, imageView2, uRLImageView, findChildViewById, zPlanLoadingAnimView, imageView3, linearLayout, zplanExcludeFontPaddingTextView, linearLayout2, textView, progressBar, textView2, textView3, findChildViewById2, loadingPanelControlView, frameLayout2, imageView4, findChildViewById3, findChildViewById4);
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
}

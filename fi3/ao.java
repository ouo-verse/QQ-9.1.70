package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ao implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollView f398866a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f398867b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaDownloadButton f398868c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f398869d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398870e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f398871f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f398872g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f398873h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f398874i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f398875j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f398876k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f398877l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f398878m;

    /* renamed from: n, reason: collision with root package name */
    public final RoundRelativeLayout f398879n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f398880o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f398881p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f398882q;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f398866a;
    }

    ao(ScrollView scrollView, ImageView imageView, ZootopiaDownloadButton zootopiaDownloadButton, LinearLayout linearLayout, TextView textView, ImageView imageView2, LinearLayout linearLayout2, ImageView imageView3, TextView textView2, ImageView imageView4, TextView textView3, TextView textView4, ImageView imageView5, RoundRelativeLayout roundRelativeLayout, ImageView imageView6, ImageView imageView7, TextView textView5) {
        this.f398866a = scrollView;
        this.f398867b = imageView;
        this.f398868c = zootopiaDownloadButton;
        this.f398869d = linearLayout;
        this.f398870e = textView;
        this.f398871f = imageView2;
        this.f398872g = linearLayout2;
        this.f398873h = imageView3;
        this.f398874i = textView2;
        this.f398875j = imageView4;
        this.f398876k = textView3;
        this.f398877l = textView4;
        this.f398878m = imageView5;
        this.f398879n = roundRelativeLayout;
        this.f398880o = imageView6;
        this.f398881p = imageView7;
        this.f398882q = textView5;
    }

    public static ao g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dag, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static ao e(View view) {
        int i3 = R.id.paf;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.paf);
        if (imageView != null) {
            i3 = R.id.pfv;
            ZootopiaDownloadButton zootopiaDownloadButton = (ZootopiaDownloadButton) ViewBindings.findChildViewById(view, R.id.pfv);
            if (zootopiaDownloadButton != null) {
                i3 = R.id.f163423q20;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163423q20);
                if (linearLayout != null) {
                    i3 = R.id.qyi;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qyi);
                    if (textView != null) {
                        i3 = R.id.qyk;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qyk);
                        if (imageView2 != null) {
                            i3 = R.id.qyl;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qyl);
                            if (linearLayout2 != null) {
                                i3 = R.id.qym;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qym);
                                if (imageView3 != null) {
                                    i3 = R.id.r2z;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.r2z);
                                    if (textView2 != null) {
                                        i3 = R.id.f163615r30;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163615r30);
                                        if (imageView4 != null) {
                                            i3 = R.id.f163626r45;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f163626r45);
                                            if (textView3 != null) {
                                                i3 = R.id.r4u;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.r4u);
                                                if (textView4 != null) {
                                                    i3 = R.id.r4v;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.r4v);
                                                    if (imageView5 != null) {
                                                        i3 = R.id.r8y;
                                                        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) ViewBindings.findChildViewById(view, R.id.r8y);
                                                        if (roundRelativeLayout != null) {
                                                            i3 = R.id.r8z;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.r8z);
                                                            if (imageView6 != null) {
                                                                i3 = R.id.f163648r90;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163648r90);
                                                                if (imageView7 != null) {
                                                                    i3 = R.id.f163649r91;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f163649r91);
                                                                    if (textView5 != null) {
                                                                        return new ao((ScrollView) view, imageView, zootopiaDownloadButton, linearLayout, textView, imageView2, linearLayout2, imageView3, textView2, imageView4, textView3, textView4, imageView5, roundRelativeLayout, imageView6, imageView7, textView5);
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

package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.taskcenter.header.progress.ProgressIconLayout;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class as implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RoundCorneredRelativeLayout f418716a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f418717b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418718c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f418719d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f418720e;

    /* renamed from: f, reason: collision with root package name */
    public final RelativeLayout f418721f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f418722g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f418723h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f418724i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f418725j;

    /* renamed from: k, reason: collision with root package name */
    public final ZPlanMediaView f418726k;

    /* renamed from: l, reason: collision with root package name */
    public final ZPlanMediaView f418727l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f418728m;

    /* renamed from: n, reason: collision with root package name */
    public final ProgressIconLayout f418729n;

    /* renamed from: o, reason: collision with root package name */
    public final RelativeLayout f418730o;

    /* renamed from: p, reason: collision with root package name */
    public final View f418731p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f418732q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f418733r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f418734s;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RoundCorneredRelativeLayout getRoot() {
        return this.f418716a;
    }

    as(RoundCorneredRelativeLayout roundCorneredRelativeLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ImageView imageView2, ImageView imageView3, ImageView imageView4, ZPlanMediaView zPlanMediaView, ZPlanMediaView zPlanMediaView2, TextView textView3, ProgressIconLayout progressIconLayout, RelativeLayout relativeLayout4, View view, TextView textView4, TextView textView5, TextView textView6) {
        this.f418716a = roundCorneredRelativeLayout;
        this.f418717b = textView;
        this.f418718c = textView2;
        this.f418719d = relativeLayout;
        this.f418720e = imageView;
        this.f418721f = relativeLayout2;
        this.f418722g = relativeLayout3;
        this.f418723h = imageView2;
        this.f418724i = imageView3;
        this.f418725j = imageView4;
        this.f418726k = zPlanMediaView;
        this.f418727l = zPlanMediaView2;
        this.f418728m = textView3;
        this.f418729n = progressIconLayout;
        this.f418730o = relativeLayout4;
        this.f418731p = view;
        this.f418732q = textView4;
        this.f418733r = textView5;
        this.f418734s = textView6;
    }

    public static as g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static as h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dba, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static as e(View view) {
        int i3 = R.id.pdx;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pdx);
        if (textView != null) {
            i3 = R.id.pdy;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pdy);
            if (textView2 != null) {
                i3 = R.id.f163303pe2;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163303pe2);
                if (relativeLayout != null) {
                    i3 = R.id.pka;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pka);
                    if (imageView != null) {
                        i3 = R.id.pkc;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pkc);
                        if (relativeLayout2 != null) {
                            i3 = R.id.pob;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pob);
                            if (relativeLayout3 != null) {
                                i3 = R.id.f163406pz0;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163406pz0);
                                if (imageView2 != null) {
                                    i3 = R.id.f163408pz2;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163408pz2);
                                    if (imageView3 != null) {
                                        i3 = R.id.f163409pz3;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163409pz3);
                                        if (imageView4 != null) {
                                            i3 = R.id.q3b;
                                            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.q3b);
                                            if (zPlanMediaView != null) {
                                                i3 = R.id.q7n;
                                                ZPlanMediaView zPlanMediaView2 = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.q7n);
                                                if (zPlanMediaView2 != null) {
                                                    i3 = R.id.q7o;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.q7o);
                                                    if (textView3 != null) {
                                                        i3 = R.id.qe8;
                                                        ProgressIconLayout progressIconLayout = (ProgressIconLayout) ViewBindings.findChildViewById(view, R.id.qe8);
                                                        if (progressIconLayout != null) {
                                                            i3 = R.id.qpo;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qpo);
                                                            if (relativeLayout4 != null) {
                                                                i3 = R.id.qpp;
                                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.qpp);
                                                                if (findChildViewById != null) {
                                                                    i3 = R.id.qpq;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qpq);
                                                                    if (textView4 != null) {
                                                                        i3 = R.id.qpr;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qpr);
                                                                        if (textView5 != null) {
                                                                            i3 = R.id.qps;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qps);
                                                                            if (textView6 != null) {
                                                                                return new as((RoundCorneredRelativeLayout) view, textView, textView2, relativeLayout, imageView, relativeLayout2, relativeLayout3, imageView2, imageView3, imageView4, zPlanMediaView, zPlanMediaView2, textView3, progressIconLayout, relativeLayout4, findChildViewById, textView4, textView5, textView6);
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

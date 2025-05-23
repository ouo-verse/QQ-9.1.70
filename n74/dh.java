package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class dh implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419246a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419247b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419248c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419249d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f419250e;

    /* renamed from: f, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419251f;

    /* renamed from: g, reason: collision with root package name */
    public final ProgressBar f419252g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayout f419253h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f419254i;

    /* renamed from: j, reason: collision with root package name */
    public final ZPlanMediaView f419255j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f419256k;

    /* renamed from: l, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419257l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f419258m;

    /* renamed from: n, reason: collision with root package name */
    public final FrameLayout f419259n;

    /* renamed from: o, reason: collision with root package name */
    public final FrameLayout f419260o;

    /* renamed from: p, reason: collision with root package name */
    public final View f419261p;

    /* renamed from: q, reason: collision with root package name */
    public final LinearLayout f419262q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f419263r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f419264s;

    /* renamed from: t, reason: collision with root package name */
    public final FrameLayout f419265t;

    /* renamed from: u, reason: collision with root package name */
    public final FrameLayout f419266u;

    /* renamed from: v, reason: collision with root package name */
    public final ProgressBar f419267v;

    /* renamed from: w, reason: collision with root package name */
    public final ZPlanVideoProgressBar f419268w;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f419246a;
    }

    dh(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, TextView textView, ConstraintLayout constraintLayout2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ProgressBar progressBar, LinearLayout linearLayout, LinearLayout linearLayout2, ZPlanMediaView zPlanMediaView, TextView textView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3, View view, LinearLayout linearLayout3, TextView textView3, TextView textView4, FrameLayout frameLayout4, FrameLayout frameLayout5, ProgressBar progressBar2, ZPlanVideoProgressBar zPlanVideoProgressBar) {
        this.f419246a = constraintLayout;
        this.f419247b = imageView;
        this.f419248c = frameLayout;
        this.f419249d = textView;
        this.f419250e = constraintLayout2;
        this.f419251f = zplanExcludeFontPaddingTextView;
        this.f419252g = progressBar;
        this.f419253h = linearLayout;
        this.f419254i = linearLayout2;
        this.f419255j = zPlanMediaView;
        this.f419256k = textView2;
        this.f419257l = zplanExcludeFontPaddingTextView2;
        this.f419258m = imageView2;
        this.f419259n = frameLayout2;
        this.f419260o = frameLayout3;
        this.f419261p = view;
        this.f419262q = linearLayout3;
        this.f419263r = textView3;
        this.f419264s = textView4;
        this.f419265t = frameLayout4;
        this.f419266u = frameLayout5;
        this.f419267v = progressBar2;
        this.f419268w = zPlanVideoProgressBar;
    }

    public static dh g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static dh e(View view) {
        int i3 = R.id.f163299pd3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163299pd3);
        if (imageView != null) {
            i3 = R.id.pd8;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pd8);
            if (frameLayout != null) {
                i3 = R.id.pdm;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pdm);
                if (textView != null) {
                    i3 = R.id.pez;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pez);
                    if (constraintLayout != null) {
                        i3 = R.id.pmw;
                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.pmw);
                        if (zplanExcludeFontPaddingTextView != null) {
                            i3 = R.id.pmx;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pmx);
                            if (progressBar != null) {
                                i3 = R.id.pn5;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pn5);
                                if (linearLayout != null) {
                                    i3 = R.id.f163372ps1;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163372ps1);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.f163374ps3;
                                        ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.f163374ps3);
                                        if (zPlanMediaView != null) {
                                            i3 = R.id.ps7;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ps7);
                                            if (textView2 != null) {
                                                i3 = R.id.ps8;
                                                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.ps8);
                                                if (zplanExcludeFontPaddingTextView2 != null) {
                                                    i3 = R.id.f163485qd3;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163485qd3);
                                                    if (imageView2 != null) {
                                                        i3 = R.id.qdi;
                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qdi);
                                                        if (frameLayout2 != null) {
                                                            i3 = R.id.qdj;
                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qdj);
                                                            if (frameLayout3 != null) {
                                                                i3 = R.id.f163487qe0;
                                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163487qe0);
                                                                if (findChildViewById != null) {
                                                                    i3 = R.id.qq8;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qq8);
                                                                    if (linearLayout3 != null) {
                                                                        i3 = R.id.qq9;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qq9);
                                                                        if (textView3 != null) {
                                                                            i3 = R.id.qq_;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qq_);
                                                                            if (textView4 != null) {
                                                                                i3 = R.id.qqn;
                                                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qqn);
                                                                                if (frameLayout4 != null) {
                                                                                    i3 = R.id.qqo;
                                                                                    FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qqo);
                                                                                    if (frameLayout5 != null) {
                                                                                        i3 = R.id.qy8;
                                                                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.qy8);
                                                                                        if (progressBar2 != null) {
                                                                                            i3 = R.id.qy9;
                                                                                            ZPlanVideoProgressBar zPlanVideoProgressBar = (ZPlanVideoProgressBar) ViewBindings.findChildViewById(view, R.id.qy9);
                                                                                            if (zPlanVideoProgressBar != null) {
                                                                                                return new dh((ConstraintLayout) view, imageView, frameLayout, textView, constraintLayout, zplanExcludeFontPaddingTextView, progressBar, linearLayout, linearLayout2, zPlanMediaView, textView2, zplanExcludeFontPaddingTextView2, imageView2, frameLayout2, frameLayout3, findChildViewById, linearLayout3, textView3, textView4, frameLayout4, frameLayout5, progressBar2, zPlanVideoProgressBar);
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
}

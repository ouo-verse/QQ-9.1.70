package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsSimpleInfoView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f419439a;

    /* renamed from: b, reason: collision with root package name */
    public final View f419440b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419441c;

    /* renamed from: d, reason: collision with root package name */
    public final Guideline f419442d;

    /* renamed from: e, reason: collision with root package name */
    public final Guideline f419443e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f419444f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419445g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f419446h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f419447i;

    /* renamed from: j, reason: collision with root package name */
    public final NativePanelLoadingIgv f419448j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f419449k;

    /* renamed from: l, reason: collision with root package name */
    public final GoodsSimpleInfoView f419450l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f419451m;

    /* renamed from: n, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419452n;

    /* renamed from: o, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419453o;

    /* renamed from: p, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419454p;

    /* renamed from: q, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419455q;

    /* renamed from: r, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419456r;

    v(RelativeLayout relativeLayout, View view, TextView textView, Guideline guideline, Guideline guideline2, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, NativePanelLoadingIgv nativePanelLoadingIgv, LinearLayout linearLayout, GoodsSimpleInfoView goodsSimpleInfoView, TextView textView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5) {
        this.f419439a = relativeLayout;
        this.f419440b = view;
        this.f419441c = textView;
        this.f419442d = guideline;
        this.f419443e = guideline2;
        this.f419444f = constraintLayout;
        this.f419445g = imageView;
        this.f419446h = imageView2;
        this.f419447i = imageView3;
        this.f419448j = nativePanelLoadingIgv;
        this.f419449k = linearLayout;
        this.f419450l = goodsSimpleInfoView;
        this.f419451m = textView2;
        this.f419452n = zplanExcludeFontPaddingTextView;
        this.f419453o = zplanExcludeFontPaddingTextView2;
        this.f419454p = zplanExcludeFontPaddingTextView3;
        this.f419455q = zplanExcludeFontPaddingTextView4;
        this.f419456r = zplanExcludeFontPaddingTextView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f419439a;
    }

    public static v g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static v h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_j, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static v e(View view) {
        int i3 = R.id.pep;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pep);
        if (findChildViewById != null) {
            i3 = R.id.peu;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.peu);
            if (textView != null) {
                i3 = R.id.piu;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.piu);
                if (guideline != null) {
                    i3 = R.id.piv;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.piv);
                    if (guideline2 != null) {
                        i3 = R.id.plw;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.plw);
                        if (constraintLayout != null) {
                            i3 = R.id.q0w;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q0w);
                            if (imageView != null) {
                                i3 = R.id.q0x;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q0x);
                                if (imageView2 != null) {
                                    i3 = R.id.f163417q10;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163417q10);
                                    if (imageView3 != null) {
                                        i3 = R.id.f163452q70;
                                        NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.f163452q70);
                                        if (nativePanelLoadingIgv != null) {
                                            i3 = R.id.qal;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qal);
                                            if (linearLayout != null) {
                                                i3 = R.id.qly;
                                                GoodsSimpleInfoView goodsSimpleInfoView = (GoodsSimpleInfoView) ViewBindings.findChildViewById(view, R.id.qly);
                                                if (goodsSimpleInfoView != null) {
                                                    i3 = R.id.qns;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qns);
                                                    if (textView2 != null) {
                                                        i3 = R.id.f163567qu0;
                                                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163567qu0);
                                                        if (zplanExcludeFontPaddingTextView != null) {
                                                            i3 = R.id.f163568qu1;
                                                            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163568qu1);
                                                            if (zplanExcludeFontPaddingTextView2 != null) {
                                                                i3 = R.id.f163569qu2;
                                                                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163569qu2);
                                                                if (zplanExcludeFontPaddingTextView3 != null) {
                                                                    i3 = R.id.qu8;
                                                                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qu8);
                                                                    if (zplanExcludeFontPaddingTextView4 != null) {
                                                                        i3 = R.id.qu_;
                                                                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qu_);
                                                                        if (zplanExcludeFontPaddingTextView5 != null) {
                                                                            return new v((RelativeLayout) view, findChildViewById, textView, guideline, guideline2, constraintLayout, imageView, imageView2, imageView3, nativePanelLoadingIgv, linearLayout, goodsSimpleInfoView, textView2, zplanExcludeFontPaddingTextView, zplanExcludeFontPaddingTextView2, zplanExcludeFontPaddingTextView3, zplanExcludeFontPaddingTextView4, zplanExcludeFontPaddingTextView5);
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

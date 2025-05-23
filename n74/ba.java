package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.widget.AlphaClickableLinearLayout;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.widget.AlphaClickableRelativeLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ba implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418789a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f418790b;

    /* renamed from: c, reason: collision with root package name */
    public final AlphaClickableRelativeLayout f418791c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418792d;

    /* renamed from: e, reason: collision with root package name */
    public final ZPlanPAGView f418793e;

    /* renamed from: f, reason: collision with root package name */
    public final URLImageView f418794f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f418795g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f418796h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f418797i;

    /* renamed from: j, reason: collision with root package name */
    public final ZPlanMediaView f418798j;

    /* renamed from: k, reason: collision with root package name */
    public final AlphaClickableLinearLayout f418799k;

    /* renamed from: l, reason: collision with root package name */
    public final ZPlanPAGView f418800l;

    /* renamed from: m, reason: collision with root package name */
    public final RelativeLayout f418801m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f418802n;

    /* renamed from: o, reason: collision with root package name */
    public final AlphaClickableLinearLayout f418803o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f418804p;

    /* renamed from: q, reason: collision with root package name */
    public final AlphaClickableLinearLayout f418805q;

    /* renamed from: r, reason: collision with root package name */
    public final RoundCornerImageView f418806r;

    /* renamed from: s, reason: collision with root package name */
    public final RelativeLayout f418807s;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getMRv() {
        return this.f418789a;
    }

    ba(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, AlphaClickableRelativeLayout alphaClickableRelativeLayout, ImageView imageView, ZPlanPAGView zPlanPAGView, URLImageView uRLImageView, ImageView imageView2, ImageView imageView3, TextView textView, ZPlanMediaView zPlanMediaView, AlphaClickableLinearLayout alphaClickableLinearLayout, ZPlanPAGView zPlanPAGView2, RelativeLayout relativeLayout3, TextView textView2, AlphaClickableLinearLayout alphaClickableLinearLayout2, TextView textView3, AlphaClickableLinearLayout alphaClickableLinearLayout3, RoundCornerImageView roundCornerImageView, RelativeLayout relativeLayout4) {
        this.f418789a = relativeLayout;
        this.f418790b = relativeLayout2;
        this.f418791c = alphaClickableRelativeLayout;
        this.f418792d = imageView;
        this.f418793e = zPlanPAGView;
        this.f418794f = uRLImageView;
        this.f418795g = imageView2;
        this.f418796h = imageView3;
        this.f418797i = textView;
        this.f418798j = zPlanMediaView;
        this.f418799k = alphaClickableLinearLayout;
        this.f418800l = zPlanPAGView2;
        this.f418801m = relativeLayout3;
        this.f418802n = textView2;
        this.f418803o = alphaClickableLinearLayout2;
        this.f418804p = textView3;
        this.f418805q = alphaClickableLinearLayout3;
        this.f418806r = roundCornerImageView;
        this.f418807s = relativeLayout4;
    }

    public static ba g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ba h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static ba e(View view) {
        int i3 = R.id.pat;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pat);
        if (relativeLayout != null) {
            i3 = R.id.pau;
            AlphaClickableRelativeLayout alphaClickableRelativeLayout = (AlphaClickableRelativeLayout) ViewBindings.findChildViewById(view, R.id.pau);
            if (alphaClickableRelativeLayout != null) {
                i3 = R.id.pav;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pav);
                if (imageView != null) {
                    i3 = R.id.paw;
                    ZPlanPAGView zPlanPAGView = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.paw);
                    if (zPlanPAGView != null) {
                        i3 = R.id.pbj;
                        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.pbj);
                        if (uRLImageView != null) {
                            i3 = R.id.pon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pon);
                            if (imageView2 != null) {
                                i3 = R.id.pop;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pop);
                                if (imageView3 != null) {
                                    i3 = R.id.f163446q55;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163446q55);
                                    if (textView != null) {
                                        i3 = R.id.q57;
                                        ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.q57);
                                        if (zPlanMediaView != null) {
                                            i3 = R.id.q59;
                                            AlphaClickableLinearLayout alphaClickableLinearLayout = (AlphaClickableLinearLayout) ViewBindings.findChildViewById(view, R.id.q59);
                                            if (alphaClickableLinearLayout != null) {
                                                i3 = R.id.q5g;
                                                ZPlanPAGView zPlanPAGView2 = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.q5g);
                                                if (zPlanPAGView2 != null) {
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                                    i3 = R.id.qkx;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qkx);
                                                    if (textView2 != null) {
                                                        i3 = R.id.qkz;
                                                        AlphaClickableLinearLayout alphaClickableLinearLayout2 = (AlphaClickableLinearLayout) ViewBindings.findChildViewById(view, R.id.qkz);
                                                        if (alphaClickableLinearLayout2 != null) {
                                                            i3 = R.id.qsv;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qsv);
                                                            if (textView3 != null) {
                                                                i3 = R.id.qsw;
                                                                AlphaClickableLinearLayout alphaClickableLinearLayout3 = (AlphaClickableLinearLayout) ViewBindings.findChildViewById(view, R.id.qsw);
                                                                if (alphaClickableLinearLayout3 != null) {
                                                                    i3 = R.id.qwa;
                                                                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.qwa);
                                                                    if (roundCornerImageView != null) {
                                                                        i3 = R.id.qwf;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qwf);
                                                                        if (relativeLayout3 != null) {
                                                                            return new ba(relativeLayout2, relativeLayout, alphaClickableRelativeLayout, imageView, zPlanPAGView, uRLImageView, imageView2, imageView3, textView, zPlanMediaView, alphaClickableLinearLayout, zPlanPAGView2, relativeLayout2, textView2, alphaClickableLinearLayout2, textView3, alphaClickableLinearLayout3, roundCornerImageView, relativeLayout3);
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

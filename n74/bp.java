package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bp implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f418875a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418876b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f418877c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f418878d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f418879e;

    /* renamed from: f, reason: collision with root package name */
    public final URLImageView f418880f;

    /* renamed from: g, reason: collision with root package name */
    public final URLImageView f418881g;

    /* renamed from: h, reason: collision with root package name */
    public final URLImageView f418882h;

    /* renamed from: i, reason: collision with root package name */
    public final URLImageView f418883i;

    /* renamed from: j, reason: collision with root package name */
    public final URLImageView f418884j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f418885k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f418886l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f418887m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f418888n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f418889o;

    /* renamed from: p, reason: collision with root package name */
    public final LinearLayout f418890p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f418891q;

    /* renamed from: r, reason: collision with root package name */
    public final RelativeLayout f418892r;

    /* renamed from: s, reason: collision with root package name */
    public final ImageView f418893s;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f418875a;
    }

    bp(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, URLImageView uRLImageView, URLImageView uRLImageView2, URLImageView uRLImageView3, URLImageView uRLImageView4, URLImageView uRLImageView5, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, TextView textView4, RelativeLayout relativeLayout2, ImageView imageView3) {
        this.f418875a = constraintLayout;
        this.f418876b = imageView;
        this.f418877c = imageView2;
        this.f418878d = constraintLayout2;
        this.f418879e = relativeLayout;
        this.f418880f = uRLImageView;
        this.f418881g = uRLImageView2;
        this.f418882h = uRLImageView3;
        this.f418883i = uRLImageView4;
        this.f418884j = uRLImageView5;
        this.f418885k = textView;
        this.f418886l = linearLayout;
        this.f418887m = textView2;
        this.f418888n = linearLayout2;
        this.f418889o = textView3;
        this.f418890p = linearLayout3;
        this.f418891q = textView4;
        this.f418892r = relativeLayout2;
        this.f418893s = imageView3;
    }

    public static bp g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bp h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dds, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static bp e(View view) {
        int i3 = R.id.q4f;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q4f);
        if (imageView != null) {
            i3 = R.id.q_f;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q_f);
            if (imageView2 != null) {
                i3 = R.id.qbi;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.qbi);
                if (constraintLayout != null) {
                    i3 = R.id.qck;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qck);
                    if (relativeLayout != null) {
                        i3 = R.id.qcl;
                        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.qcl);
                        if (uRLImageView != null) {
                            i3 = R.id.qcm;
                            URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.qcm);
                            if (uRLImageView2 != null) {
                                i3 = R.id.qcn;
                                URLImageView uRLImageView3 = (URLImageView) ViewBindings.findChildViewById(view, R.id.qcn);
                                if (uRLImageView3 != null) {
                                    i3 = R.id.qco;
                                    URLImageView uRLImageView4 = (URLImageView) ViewBindings.findChildViewById(view, R.id.qco);
                                    if (uRLImageView4 != null) {
                                        i3 = R.id.qcp;
                                        URLImageView uRLImageView5 = (URLImageView) ViewBindings.findChildViewById(view, R.id.qcp);
                                        if (uRLImageView5 != null) {
                                            i3 = R.id.qj5;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qj5);
                                            if (textView != null) {
                                                i3 = R.id.qlm;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qlm);
                                                if (linearLayout != null) {
                                                    i3 = R.id.qln;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qln);
                                                    if (textView2 != null) {
                                                        i3 = R.id.qlo;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qlo);
                                                        if (linearLayout2 != null) {
                                                            i3 = R.id.qlp;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qlp);
                                                            if (textView3 != null) {
                                                                i3 = R.id.qmh;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qmh);
                                                                if (linearLayout3 != null) {
                                                                    i3 = R.id.qqy;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qqy);
                                                                    if (textView4 != null) {
                                                                        i3 = R.id.qqz;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qqz);
                                                                        if (relativeLayout2 != null) {
                                                                            i3 = R.id.qr8;
                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qr8);
                                                                            if (imageView3 != null) {
                                                                                return new bp((ConstraintLayout) view, imageView, imageView2, constraintLayout, relativeLayout, uRLImageView, uRLImageView2, uRLImageView3, uRLImageView4, uRLImageView5, textView, linearLayout, textView2, linearLayout2, textView3, linearLayout3, textView4, relativeLayout2, imageView3);
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

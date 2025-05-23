package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class av implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f398941a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f398942b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f398943c;

    /* renamed from: d, reason: collision with root package name */
    public final az f398944d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f398945e;

    /* renamed from: f, reason: collision with root package name */
    public final RelativeLayout f398946f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f398947g;

    /* renamed from: h, reason: collision with root package name */
    public final View f398948h;

    /* renamed from: i, reason: collision with root package name */
    public final QUIButton f398949i;

    /* renamed from: j, reason: collision with root package name */
    public final View f398950j;

    /* renamed from: k, reason: collision with root package name */
    public final View f398951k;

    /* renamed from: l, reason: collision with root package name */
    public final RelativeLayout f398952l;

    /* renamed from: m, reason: collision with root package name */
    public final RelativeLayout f398953m;

    /* renamed from: n, reason: collision with root package name */
    public final View f398954n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f398955o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f398956p;

    /* renamed from: q, reason: collision with root package name */
    public final View f398957q;

    /* renamed from: r, reason: collision with root package name */
    public final RelativeLayout f398958r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f398959s;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f398941a;
    }

    av(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, az azVar, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, View view, QUIButton qUIButton, View view2, View view3, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, View view4, ImageView imageView3, ImageView imageView4, View view5, RelativeLayout relativeLayout5, TextView textView) {
        this.f398941a = constraintLayout;
        this.f398942b = imageView;
        this.f398943c = constraintLayout2;
        this.f398944d = azVar;
        this.f398945e = imageView2;
        this.f398946f = relativeLayout;
        this.f398947g = relativeLayout2;
        this.f398948h = view;
        this.f398949i = qUIButton;
        this.f398950j = view2;
        this.f398951k = view3;
        this.f398952l = relativeLayout3;
        this.f398953m = relativeLayout4;
        this.f398954n = view4;
        this.f398955o = imageView3;
        this.f398956p = imageView4;
        this.f398957q = view5;
        this.f398958r = relativeLayout5;
        this.f398959s = textView;
    }

    public static av g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static av h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167440db4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static av e(View view) {
        int i3 = R.id.pcz;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pcz);
        if (imageView != null) {
            i3 = R.id.pjh;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pjh);
            if (constraintLayout != null) {
                i3 = R.id.pji;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.pji);
                if (findChildViewById != null) {
                    az e16 = az.e(findChildViewById);
                    i3 = R.id.pmt;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pmt);
                    if (imageView2 != null) {
                        i3 = R.id.ppe;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ppe);
                        if (relativeLayout != null) {
                            i3 = R.id.pqw;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pqw);
                            if (relativeLayout2 != null) {
                                i3 = R.id.pqx;
                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.pqx);
                                if (findChildViewById2 != null) {
                                    i3 = R.id.pu6;
                                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.pu6);
                                    if (qUIButton != null) {
                                        i3 = R.id.pxq;
                                        View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.pxq);
                                        if (findChildViewById3 != null) {
                                            i3 = R.id.pxr;
                                            View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.pxr);
                                            if (findChildViewById4 != null) {
                                                i3 = R.id.qdk;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qdk);
                                                if (relativeLayout3 != null) {
                                                    i3 = R.id.qgz;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qgz);
                                                    if (relativeLayout4 != null) {
                                                        i3 = R.id.f163502qh0;
                                                        View findChildViewById5 = ViewBindings.findChildViewById(view, R.id.f163502qh0);
                                                        if (findChildViewById5 != null) {
                                                            i3 = R.id.f163503qh1;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163503qh1);
                                                            if (imageView3 != null) {
                                                                i3 = R.id.qh7;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qh7);
                                                                if (imageView4 != null) {
                                                                    i3 = R.id.qng;
                                                                    View findChildViewById6 = ViewBindings.findChildViewById(view, R.id.qng);
                                                                    if (findChildViewById6 != null) {
                                                                        i3 = R.id.qrf;
                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qrf);
                                                                        if (relativeLayout5 != null) {
                                                                            i3 = R.id.qrk;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qrk);
                                                                            if (textView != null) {
                                                                                return new av((ConstraintLayout) view, imageView, constraintLayout, e16, imageView2, relativeLayout, relativeLayout2, findChildViewById2, qUIButton, findChildViewById3, findChildViewById4, relativeLayout3, relativeLayout4, findChildViewById5, imageView3, imageView4, findChildViewById6, relativeLayout5, textView);
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

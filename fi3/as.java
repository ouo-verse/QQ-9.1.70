package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class as implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f398914a;

    /* renamed from: b, reason: collision with root package name */
    public final View f398915b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f398916c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f398917d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f398918e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f398919f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f398920g;

    /* renamed from: h, reason: collision with root package name */
    public final View f398921h;

    /* renamed from: i, reason: collision with root package name */
    public final AvatarGlobalLoadingView f398922i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f398923j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f398924k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f398925l;

    /* renamed from: m, reason: collision with root package name */
    public final RelativeLayout f398926m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f398927n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f398928o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f398929p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f398930q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f398931r;

    /* renamed from: s, reason: collision with root package name */
    public final LinearLayout f398932s;

    /* renamed from: t, reason: collision with root package name */
    public final RelativeLayout f398933t;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f398914a;
    }

    as(RelativeLayout relativeLayout, View view, TextView textView, LinearLayout linearLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView2, View view2, AvatarGlobalLoadingView avatarGlobalLoadingView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout3, ImageView imageView5, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout2, RelativeLayout relativeLayout4) {
        this.f398914a = relativeLayout;
        this.f398915b = view;
        this.f398916c = textView;
        this.f398917d = linearLayout;
        this.f398918e = relativeLayout2;
        this.f398919f = imageView;
        this.f398920g = textView2;
        this.f398921h = view2;
        this.f398922i = avatarGlobalLoadingView;
        this.f398923j = imageView2;
        this.f398924k = imageView3;
        this.f398925l = imageView4;
        this.f398926m = relativeLayout3;
        this.f398927n = imageView5;
        this.f398928o = textView3;
        this.f398929p = textView4;
        this.f398930q = textView5;
        this.f398931r = textView6;
        this.f398932s = linearLayout2;
        this.f398933t = relativeLayout4;
    }

    public static as g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static as h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167437db1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static as e(View view) {
        int i3 = R.id.pda;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pda);
        if (findChildViewById != null) {
            i3 = R.id.phn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.phn);
            if (textView != null) {
                i3 = R.id.pio;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pio);
                if (linearLayout != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.pph;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pph);
                    if (imageView != null) {
                        i3 = R.id.ppp;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ppp);
                        if (textView2 != null) {
                            i3 = R.id.ppz;
                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.ppz);
                            if (findChildViewById2 != null) {
                                i3 = R.id.pwx;
                                AvatarGlobalLoadingView avatarGlobalLoadingView = (AvatarGlobalLoadingView) ViewBindings.findChildViewById(view, R.id.pwx);
                                if (avatarGlobalLoadingView != null) {
                                    i3 = R.id.f163400px4;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163400px4);
                                    if (imageView2 != null) {
                                        i3 = R.id.px6;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.px6);
                                        if (imageView3 != null) {
                                            i3 = R.id.px_;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.px_);
                                            if (imageView4 != null) {
                                                i3 = R.id.pxa;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pxa);
                                                if (relativeLayout2 != null) {
                                                    i3 = R.id.pxb;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.pxb);
                                                    if (imageView5 != null) {
                                                        i3 = R.id.pxc;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pxc);
                                                        if (textView3 != null) {
                                                            i3 = R.id.pxd;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.pxd);
                                                            if (textView4 != null) {
                                                                i3 = R.id.q_3;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.q_3);
                                                                if (textView5 != null) {
                                                                    i3 = R.id.q_4;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.q_4);
                                                                    if (textView6 != null) {
                                                                        i3 = R.id.qdo;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qdo);
                                                                        if (linearLayout2 != null) {
                                                                            i3 = R.id.qrf;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qrf);
                                                                            if (relativeLayout3 != null) {
                                                                                return new as(relativeLayout, findChildViewById, textView, linearLayout, relativeLayout, imageView, textView2, findChildViewById2, avatarGlobalLoadingView, imageView2, imageView3, imageView4, relativeLayout2, imageView5, textView3, textView4, textView5, textView6, linearLayout2, relativeLayout3);
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

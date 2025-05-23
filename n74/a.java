package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.friendsdressup.widget.OverBoundLayout;
import com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements ViewBinding {
    public final ImageView A;
    public final ImageView B;
    public final RelativeLayout C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f418556a;

    /* renamed from: b, reason: collision with root package name */
    public final View f418557b;

    /* renamed from: c, reason: collision with root package name */
    public final View f418558c;

    /* renamed from: d, reason: collision with root package name */
    public final View f418559d;

    /* renamed from: e, reason: collision with root package name */
    public final OverBoundLayout f418560e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f418561f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f418562g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f418563h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f418564i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f418565j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f418566k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f418567l;

    /* renamed from: m, reason: collision with root package name */
    public final FrameLayout f418568m;

    /* renamed from: n, reason: collision with root package name */
    public final FrameLayout f418569n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f418570o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f418571p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f418572q;

    /* renamed from: r, reason: collision with root package name */
    public final RelativeLayout f418573r;

    /* renamed from: s, reason: collision with root package name */
    public final RelativeLayout f418574s;

    /* renamed from: t, reason: collision with root package name */
    public final RelativeLayout f418575t;

    /* renamed from: u, reason: collision with root package name */
    public final RelativeLayout f418576u;

    /* renamed from: v, reason: collision with root package name */
    public final RelativeLayout f418577v;

    /* renamed from: w, reason: collision with root package name */
    public final RelativeLayout f418578w;

    /* renamed from: x, reason: collision with root package name */
    public final RollingFrameViewGroup f418579x;

    /* renamed from: y, reason: collision with root package name */
    public final View f418580y;

    /* renamed from: z, reason: collision with root package name */
    public final RecyclerView f418581z;

    a(ConstraintLayout constraintLayout, View view, View view2, View view3, OverBoundLayout overBoundLayout, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, FrameLayout frameLayout7, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RollingFrameViewGroup rollingFrameViewGroup, View view4, RecyclerView recyclerView, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f418556a = constraintLayout;
        this.f418557b = view;
        this.f418558c = view2;
        this.f418559d = view3;
        this.f418560e = overBoundLayout;
        this.f418561f = imageView;
        this.f418562g = linearLayout;
        this.f418563h = frameLayout;
        this.f418564i = frameLayout2;
        this.f418565j = frameLayout3;
        this.f418566k = frameLayout4;
        this.f418567l = frameLayout5;
        this.f418568m = frameLayout6;
        this.f418569n = frameLayout7;
        this.f418570o = imageView2;
        this.f418571p = imageView3;
        this.f418572q = imageView4;
        this.f418573r = relativeLayout;
        this.f418574s = relativeLayout2;
        this.f418575t = relativeLayout3;
        this.f418576u = relativeLayout4;
        this.f418577v = relativeLayout5;
        this.f418578w = relativeLayout6;
        this.f418579x = rollingFrameViewGroup;
        this.f418580y = view4;
        this.f418581z = recyclerView;
        this.A = imageView5;
        this.B = imageView6;
        this.C = relativeLayout7;
        this.D = textView;
        this.E = textView2;
        this.F = textView3;
        this.G = textView4;
        this.H = textView5;
        this.I = textView6;
        this.J = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f418556a;
    }

    public static a g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d2k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static a e(View view) {
        int i3 = R.id.pac;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pac);
        if (findChildViewById != null) {
            i3 = R.id.pad;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.pad);
            if (findChildViewById2 != null) {
                i3 = R.id.pae;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.pae);
                if (findChildViewById3 != null) {
                    i3 = R.id.pb9;
                    OverBoundLayout overBoundLayout = (OverBoundLayout) ViewBindings.findChildViewById(view, R.id.pb9);
                    if (overBoundLayout != null) {
                        i3 = R.id.f163299pd3;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163299pd3);
                        if (imageView != null) {
                            i3 = R.id.pqr;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pqr);
                            if (linearLayout != null) {
                                i3 = R.id.ptz;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ptz);
                                if (frameLayout != null) {
                                    i3 = R.id.pue;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pue);
                                    if (frameLayout2 != null) {
                                        i3 = R.id.q0r;
                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q0r);
                                        if (frameLayout3 != null) {
                                            i3 = R.id.q0s;
                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q0s);
                                            if (frameLayout4 != null) {
                                                i3 = R.id.q0y;
                                                FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q0y);
                                                if (frameLayout5 != null) {
                                                    i3 = R.id.q0z;
                                                    FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q0z);
                                                    if (frameLayout6 != null) {
                                                        i3 = R.id.f163418q11;
                                                        FrameLayout frameLayout7 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163418q11);
                                                        if (frameLayout7 != null) {
                                                            i3 = R.id.f163438q43;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163438q43);
                                                            if (imageView2 != null) {
                                                                i3 = R.id.f163466q94;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163466q94);
                                                                if (imageView3 != null) {
                                                                    i3 = R.id.qhy;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qhy);
                                                                    if (imageView4 != null) {
                                                                        i3 = R.id.f163509qi2;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163509qi2);
                                                                        if (relativeLayout != null) {
                                                                            i3 = R.id.f163507qi0;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163507qi0);
                                                                            if (relativeLayout2 != null) {
                                                                                i3 = R.id.f163511qi4;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163511qi4);
                                                                                if (relativeLayout3 != null) {
                                                                                    i3 = R.id.qi6;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qi6);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i3 = R.id.qi7;
                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qi7);
                                                                                        if (relativeLayout5 != null) {
                                                                                            i3 = R.id.qi8;
                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qi8);
                                                                                            if (relativeLayout6 != null) {
                                                                                                i3 = R.id.qil;
                                                                                                RollingFrameViewGroup rollingFrameViewGroup = (RollingFrameViewGroup) ViewBindings.findChildViewById(view, R.id.qil);
                                                                                                if (rollingFrameViewGroup != null) {
                                                                                                    i3 = R.id.qim;
                                                                                                    View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.qim);
                                                                                                    if (findChildViewById4 != null) {
                                                                                                        i3 = R.id.qiu;
                                                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qiu);
                                                                                                        if (recyclerView != null) {
                                                                                                            i3 = R.id.qiy;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.qiy);
                                                                                                            if (imageView5 != null) {
                                                                                                                i3 = R.id.qmk;
                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.qmk);
                                                                                                                if (imageView6 != null) {
                                                                                                                    i3 = R.id.qr6;
                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qr6);
                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                        i3 = R.id.qrg;
                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qrg);
                                                                                                                        if (textView != null) {
                                                                                                                            i3 = R.id.qt9;
                                                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qt9);
                                                                                                                            if (textView2 != null) {
                                                                                                                                i3 = R.id.qto;
                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qto);
                                                                                                                                if (textView3 != null) {
                                                                                                                                    i3 = R.id.qtt;
                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qtt);
                                                                                                                                    if (textView4 != null) {
                                                                                                                                        i3 = R.id.qtu;
                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qtu);
                                                                                                                                        if (textView5 != null) {
                                                                                                                                            i3 = R.id.qu6;
                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qu6);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                i3 = R.id.qu9;
                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.qu9);
                                                                                                                                                if (textView7 != null) {
                                                                                                                                                    return new a((ConstraintLayout) view, findChildViewById, findChildViewById2, findChildViewById3, overBoundLayout, imageView, linearLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7, imageView2, imageView3, imageView4, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, rollingFrameViewGroup, findChildViewById4, recyclerView, imageView5, imageView6, relativeLayout7, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

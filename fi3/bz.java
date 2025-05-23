package fi3;

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
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bz implements ViewBinding {
    public final ImageView A;
    public final ImageView B;
    public final LinearLayout C;
    public final ImageView D;
    public final TextView E;
    public final ImageView F;
    public final LinearLayout G;
    public final ImageView H;
    public final ConstraintLayout I;
    public final LinearLayout J;
    public final ConstraintLayout K;

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399186a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f399187b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399188c;

    /* renamed from: d, reason: collision with root package name */
    public final RoundRectImageView f399189d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f399190e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f399191f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f399192g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f399193h;

    /* renamed from: i, reason: collision with root package name */
    public final AvatarGlobalLoadingView f399194i;

    /* renamed from: j, reason: collision with root package name */
    public final RelativeLayout f399195j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f399196k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f399197l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f399198m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f399199n;

    /* renamed from: o, reason: collision with root package name */
    public final LinearLayout f399200o;

    /* renamed from: p, reason: collision with root package name */
    public final LinearLayout f399201p;

    /* renamed from: q, reason: collision with root package name */
    public final LinearLayout f399202q;

    /* renamed from: r, reason: collision with root package name */
    public final LinearLayout f399203r;

    /* renamed from: s, reason: collision with root package name */
    public final LinearLayout f399204s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f399205t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f399206u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f399207v;

    /* renamed from: w, reason: collision with root package name */
    public final RecyclerView f399208w;

    /* renamed from: x, reason: collision with root package name */
    public final SuitPagView f399209x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f399210y;

    /* renamed from: z, reason: collision with root package name */
    public final ConstraintLayout f399211z;

    bz(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, RoundRectImageView roundRectImageView, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, AvatarGlobalLoadingView avatarGlobalLoadingView, RelativeLayout relativeLayout, TextView textView2, TextView textView3, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView4, TextView textView5, TextView textView6, RecyclerView recyclerView, SuitPagView suitPagView, TextView textView7, ConstraintLayout constraintLayout2, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout7, ImageView imageView6, TextView textView8, ImageView imageView7, LinearLayout linearLayout8, ImageView imageView8, ConstraintLayout constraintLayout3, LinearLayout linearLayout9, ConstraintLayout constraintLayout4) {
        this.f399186a = constraintLayout;
        this.f399187b = linearLayout;
        this.f399188c = textView;
        this.f399189d = roundRectImageView;
        this.f399190e = imageView;
        this.f399191f = frameLayout;
        this.f399192g = frameLayout2;
        this.f399193h = frameLayout3;
        this.f399194i = avatarGlobalLoadingView;
        this.f399195j = relativeLayout;
        this.f399196k = textView2;
        this.f399197l = textView3;
        this.f399198m = imageView2;
        this.f399199n = imageView3;
        this.f399200o = linearLayout2;
        this.f399201p = linearLayout3;
        this.f399202q = linearLayout4;
        this.f399203r = linearLayout5;
        this.f399204s = linearLayout6;
        this.f399205t = textView4;
        this.f399206u = textView5;
        this.f399207v = textView6;
        this.f399208w = recyclerView;
        this.f399209x = suitPagView;
        this.f399210y = textView7;
        this.f399211z = constraintLayout2;
        this.A = imageView4;
        this.B = imageView5;
        this.C = linearLayout7;
        this.D = imageView6;
        this.E = textView8;
        this.F = imageView7;
        this.G = linearLayout8;
        this.H = imageView8;
        this.I = constraintLayout3;
        this.J = linearLayout9;
        this.K = constraintLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399186a;
    }

    public static bz g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dg9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static bz e(View view) {
        int i3 = R.id.p_m;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.p_m);
        if (linearLayout != null) {
            i3 = R.id.p_n;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.p_n);
            if (textView != null) {
                i3 = R.id.p_o;
                RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.p_o);
                if (roundRectImageView != null) {
                    i3 = R.id.pcx;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pcx);
                    if (imageView != null) {
                        i3 = R.id.piy;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.piy);
                        if (frameLayout != null) {
                            i3 = R.id.piz;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.piz);
                            if (frameLayout2 != null) {
                                i3 = R.id.pjg;
                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pjg);
                                if (frameLayout3 != null) {
                                    i3 = R.id.pwx;
                                    AvatarGlobalLoadingView avatarGlobalLoadingView = (AvatarGlobalLoadingView) ViewBindings.findChildViewById(view, R.id.pwx);
                                    if (avatarGlobalLoadingView != null) {
                                        i3 = R.id.py5;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.py5);
                                        if (relativeLayout != null) {
                                            i3 = R.id.f163407pz1;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163407pz1);
                                            if (textView2 != null) {
                                                i3 = R.id.q0_;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.q0_);
                                                if (textView3 != null) {
                                                    i3 = R.id.q1x;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q1x);
                                                    if (imageView2 != null) {
                                                        i3 = R.id.q57;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.q57);
                                                        if (imageView3 != null) {
                                                            i3 = R.id.q5b;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q5b);
                                                            if (linearLayout2 != null) {
                                                                i3 = R.id.f163457q80;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163457q80);
                                                                if (linearLayout3 != null) {
                                                                    i3 = R.id.q9i;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q9i);
                                                                    if (linearLayout4 != null) {
                                                                        i3 = R.id.qau;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qau);
                                                                        if (linearLayout5 != null) {
                                                                            i3 = R.id.qav;
                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qav);
                                                                            if (linearLayout6 != null) {
                                                                                i3 = R.id.qaw;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qaw);
                                                                                if (textView4 != null) {
                                                                                    i3 = R.id.qax;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qax);
                                                                                    if (textView5 != null) {
                                                                                        i3 = R.id.qay;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qay);
                                                                                        if (textView6 != null) {
                                                                                            i3 = R.id.qaz;
                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qaz);
                                                                                            if (recyclerView != null) {
                                                                                                i3 = R.id.f163472qb0;
                                                                                                SuitPagView suitPagView = (SuitPagView) ViewBindings.findChildViewById(view, R.id.f163472qb0);
                                                                                                if (suitPagView != null) {
                                                                                                    i3 = R.id.f163473qb1;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f163473qb1);
                                                                                                    if (textView7 != null) {
                                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                                        i3 = R.id.qbq;
                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qbq);
                                                                                                        if (imageView4 != null) {
                                                                                                            i3 = R.id.qbr;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.qbr);
                                                                                                            if (imageView5 != null) {
                                                                                                                i3 = R.id.qel;
                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qel);
                                                                                                                if (linearLayout7 != null) {
                                                                                                                    i3 = R.id.qem;
                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.qem);
                                                                                                                    if (imageView6 != null) {
                                                                                                                        i3 = R.id.qen;
                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.qen);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i3 = R.id.qja;
                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.qja);
                                                                                                                            if (imageView7 != null) {
                                                                                                                                i3 = R.id.f163522ql0;
                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163522ql0);
                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                    i3 = R.id.ql7;
                                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.ql7);
                                                                                                                                    if (imageView8 != null) {
                                                                                                                                        i3 = R.id.qsa;
                                                                                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.qsa);
                                                                                                                                        if (constraintLayout2 != null) {
                                                                                                                                            i3 = R.id.qsx;
                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qsx);
                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                i3 = R.id.r6w;
                                                                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.r6w);
                                                                                                                                                if (constraintLayout3 != null) {
                                                                                                                                                    return new bz(constraintLayout, linearLayout, textView, roundRectImageView, imageView, frameLayout, frameLayout2, frameLayout3, avatarGlobalLoadingView, relativeLayout, textView2, textView3, imageView2, imageView3, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView4, textView5, textView6, recyclerView, suitPagView, textView7, constraintLayout, imageView4, imageView5, linearLayout7, imageView6, textView8, imageView7, linearLayout8, imageView8, constraintLayout2, linearLayout9, constraintLayout3);
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

package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cr implements ViewBinding {
    public final TextView A;

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419095a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419096b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419097c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f419098d;

    /* renamed from: e, reason: collision with root package name */
    public final CurrencyView f419099e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419100f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f419101g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f419102h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f419103i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419104j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f419105k;

    /* renamed from: l, reason: collision with root package name */
    public final View f419106l;

    /* renamed from: m, reason: collision with root package name */
    public final AvatarGlobalLoadingView f419107m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f419108n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f419109o;

    /* renamed from: p, reason: collision with root package name */
    public final RecyclerView f419110p;

    /* renamed from: q, reason: collision with root package name */
    public final AvatarPanelErrorView f419111q;

    /* renamed from: r, reason: collision with root package name */
    public final cy f419112r;

    /* renamed from: s, reason: collision with root package name */
    public final FrameLayout f419113s;

    /* renamed from: t, reason: collision with root package name */
    public final FrameLayout f419114t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f419115u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f419116v;

    /* renamed from: w, reason: collision with root package name */
    public final LinearLayout f419117w;

    /* renamed from: x, reason: collision with root package name */
    public final LinearLayout f419118x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f419119y;

    /* renamed from: z, reason: collision with root package name */
    public final ImageView f419120z;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getMRv() {
        return this.f419095a;
    }

    cr(LinearLayout linearLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, CurrencyView currencyView, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3, View view, AvatarGlobalLoadingView avatarGlobalLoadingView, ImageView imageView4, TextView textView4, RecyclerView recyclerView, AvatarPanelErrorView avatarPanelErrorView, cy cyVar, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView5, TextView textView5, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView6, ImageView imageView6, TextView textView7) {
        this.f419095a = linearLayout;
        this.f419096b = imageView;
        this.f419097c = textView;
        this.f419098d = constraintLayout;
        this.f419099e = currencyView;
        this.f419100f = linearLayout2;
        this.f419101g = linearLayout3;
        this.f419102h = imageView2;
        this.f419103i = imageView3;
        this.f419104j = textView2;
        this.f419105k = textView3;
        this.f419106l = view;
        this.f419107m = avatarGlobalLoadingView;
        this.f419108n = imageView4;
        this.f419109o = textView4;
        this.f419110p = recyclerView;
        this.f419111q = avatarPanelErrorView;
        this.f419112r = cyVar;
        this.f419113s = frameLayout;
        this.f419114t = frameLayout2;
        this.f419115u = imageView5;
        this.f419116v = textView5;
        this.f419117w = linearLayout4;
        this.f419118x = linearLayout5;
        this.f419119y = textView6;
        this.f419120z = imageView6;
        this.A = textView7;
    }

    public static cr g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cr h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.df5, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static cr e(View view) {
        int i3 = R.id.p_a;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_a);
        if (imageView != null) {
            i3 = R.id.ph8;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ph8);
            if (textView != null) {
                i3 = R.id.pio;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pio);
                if (constraintLayout != null) {
                    i3 = R.id.pkn;
                    CurrencyView currencyView = (CurrencyView) ViewBindings.findChildViewById(view, R.id.pkn);
                    if (currencyView != null) {
                        i3 = R.id.png;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.png);
                        if (linearLayout != null) {
                            i3 = R.id.pni;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pni);
                            if (linearLayout2 != null) {
                                i3 = R.id.pph;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pph);
                                if (imageView2 != null) {
                                    i3 = R.id.ppj;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.ppj);
                                    if (imageView3 != null) {
                                        i3 = R.id.ppk;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ppk);
                                        if (textView2 != null) {
                                            i3 = R.id.ppp;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ppp);
                                            if (textView3 != null) {
                                                i3 = R.id.ppz;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.ppz);
                                                if (findChildViewById != null) {
                                                    i3 = R.id.pwx;
                                                    AvatarGlobalLoadingView avatarGlobalLoadingView = (AvatarGlobalLoadingView) ViewBindings.findChildViewById(view, R.id.pwx);
                                                    if (avatarGlobalLoadingView != null) {
                                                        i3 = R.id.f163397px1;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163397px1);
                                                        if (imageView4 != null) {
                                                            i3 = R.id.f163398px2;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f163398px2);
                                                            if (textView4 != null) {
                                                                i3 = R.id.pxn;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.pxn);
                                                                if (recyclerView != null) {
                                                                    i3 = R.id.q5u;
                                                                    AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.q5u);
                                                                    if (avatarPanelErrorView != null) {
                                                                        i3 = R.id.q6i;
                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q6i);
                                                                        if (findChildViewById2 != null) {
                                                                            cy e16 = cy.e(findChildViewById2);
                                                                            i3 = R.id.q6j;
                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q6j);
                                                                            if (frameLayout != null) {
                                                                                i3 = R.id.qcv;
                                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qcv);
                                                                                if (frameLayout2 != null) {
                                                                                    i3 = R.id.qls;
                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.qls);
                                                                                    if (imageView5 != null) {
                                                                                        i3 = R.id.qlu;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qlu);
                                                                                        if (textView5 != null) {
                                                                                            i3 = R.id.qr_;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qr_);
                                                                                            if (linearLayout3 != null) {
                                                                                                LinearLayout linearLayout4 = (LinearLayout) view;
                                                                                                i3 = R.id.qsj;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qsj);
                                                                                                if (textView6 != null) {
                                                                                                    i3 = R.id.r2m;
                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.r2m);
                                                                                                    if (imageView6 != null) {
                                                                                                        i3 = R.id.r2n;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.r2n);
                                                                                                        if (textView7 != null) {
                                                                                                            return new cr(linearLayout4, imageView, textView, constraintLayout, currencyView, linearLayout, linearLayout2, imageView2, imageView3, textView2, textView3, findChildViewById, avatarGlobalLoadingView, imageView4, textView4, recyclerView, avatarPanelErrorView, e16, frameLayout, frameLayout2, imageView5, textView5, linearLayout3, linearLayout4, textView6, imageView6, textView7);
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

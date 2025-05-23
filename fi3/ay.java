package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditBuyAndSaveButton;
import com.tencent.sqshow.zootopia.card.view.widget.PortalStoreCurrencyView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ay implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f398975a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f398976b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f398977c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f398978d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f398979e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f398980f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f398981g;

    /* renamed from: h, reason: collision with root package name */
    public final PortalStoreCurrencyView f398982h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f398983i;

    /* renamed from: j, reason: collision with root package name */
    public final RelativeLayout f398984j;

    /* renamed from: k, reason: collision with root package name */
    public final RelativeLayout f398985k;

    /* renamed from: l, reason: collision with root package name */
    public final View f398986l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f398987m;

    /* renamed from: n, reason: collision with root package name */
    public final MiniHomeEditBuyAndSaveButton f398988n;

    /* renamed from: o, reason: collision with root package name */
    public final ConstraintLayout f398989o;

    /* renamed from: p, reason: collision with root package name */
    public final View f398990p;

    /* renamed from: q, reason: collision with root package name */
    public final View f398991q;

    /* renamed from: r, reason: collision with root package name */
    public final View f398992r;

    /* renamed from: s, reason: collision with root package name */
    public final RelativeLayout f398993s;

    /* renamed from: t, reason: collision with root package name */
    public final RecyclerView f398994t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f398995u;

    /* renamed from: v, reason: collision with root package name */
    public final az f398996v;

    /* renamed from: w, reason: collision with root package name */
    public final View f398997w;

    /* renamed from: x, reason: collision with root package name */
    public final RelativeLayout f398998x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f398999y;

    ay(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout2, TextView textView3, TextView textView4, PortalStoreCurrencyView portalStoreCurrencyView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, View view, LinearLayout linearLayout, MiniHomeEditBuyAndSaveButton miniHomeEditBuyAndSaveButton, ConstraintLayout constraintLayout3, View view2, View view3, View view4, RelativeLayout relativeLayout3, RecyclerView recyclerView, ImageView imageView3, az azVar, View view5, RelativeLayout relativeLayout4, TextView textView5) {
        this.f398975a = constraintLayout;
        this.f398976b = textView;
        this.f398977c = imageView;
        this.f398978d = textView2;
        this.f398979e = constraintLayout2;
        this.f398980f = textView3;
        this.f398981g = textView4;
        this.f398982h = portalStoreCurrencyView;
        this.f398983i = imageView2;
        this.f398984j = relativeLayout;
        this.f398985k = relativeLayout2;
        this.f398986l = view;
        this.f398987m = linearLayout;
        this.f398988n = miniHomeEditBuyAndSaveButton;
        this.f398989o = constraintLayout3;
        this.f398990p = view2;
        this.f398991q = view3;
        this.f398992r = view4;
        this.f398993s = relativeLayout3;
        this.f398994t = recyclerView;
        this.f398995u = imageView3;
        this.f398996v = azVar;
        this.f398997w = view5;
        this.f398998x = relativeLayout4;
        this.f398999y = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f398975a;
    }

    public static ay g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ay h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbu, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static ay e(View view) {
        int i3 = R.id.p_f;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.p_f);
        if (textView != null) {
            i3 = R.id.pcz;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pcz);
            if (imageView != null) {
                i3 = R.id.pi5;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pi5);
                if (textView2 != null) {
                    i3 = R.id.pjh;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pjh);
                    if (constraintLayout != null) {
                        i3 = R.id.pjj;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pjj);
                        if (textView3 != null) {
                            i3 = R.id.pjk;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.pjk);
                            if (textView4 != null) {
                                i3 = R.id.pkn;
                                PortalStoreCurrencyView portalStoreCurrencyView = (PortalStoreCurrencyView) ViewBindings.findChildViewById(view, R.id.pkn);
                                if (portalStoreCurrencyView != null) {
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
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.pqx);
                                                if (findChildViewById != null) {
                                                    i3 = R.id.prs;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.prs);
                                                    if (linearLayout != null) {
                                                        i3 = R.id.pu6;
                                                        MiniHomeEditBuyAndSaveButton miniHomeEditBuyAndSaveButton = (MiniHomeEditBuyAndSaveButton) ViewBindings.findChildViewById(view, R.id.pu6);
                                                        if (miniHomeEditBuyAndSaveButton != null) {
                                                            i3 = R.id.pwl;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pwl);
                                                            if (constraintLayout2 != null) {
                                                                i3 = R.id.pxq;
                                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.pxq);
                                                                if (findChildViewById2 != null) {
                                                                    i3 = R.id.pxr;
                                                                    View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.pxr);
                                                                    if (findChildViewById3 != null) {
                                                                        i3 = R.id.pxs;
                                                                        View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.pxs);
                                                                        if (findChildViewById4 != null) {
                                                                            i3 = R.id.qdk;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qdk);
                                                                            if (relativeLayout3 != null) {
                                                                                i3 = R.id.qgo;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qgo);
                                                                                if (recyclerView != null) {
                                                                                    i3 = R.id.qh7;
                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qh7);
                                                                                    if (imageView3 != null) {
                                                                                        i3 = R.id.f163514qj2;
                                                                                        View findChildViewById5 = ViewBindings.findChildViewById(view, R.id.f163514qj2);
                                                                                        if (findChildViewById5 != null) {
                                                                                            az e16 = az.e(findChildViewById5);
                                                                                            i3 = R.id.qng;
                                                                                            View findChildViewById6 = ViewBindings.findChildViewById(view, R.id.qng);
                                                                                            if (findChildViewById6 != null) {
                                                                                                i3 = R.id.qrf;
                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qrf);
                                                                                                if (relativeLayout4 != null) {
                                                                                                    i3 = R.id.qrk;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qrk);
                                                                                                    if (textView5 != null) {
                                                                                                        return new ay((ConstraintLayout) view, textView, imageView, textView2, constraintLayout, textView3, textView4, portalStoreCurrencyView, imageView2, relativeLayout, relativeLayout2, findChildViewById, linearLayout, miniHomeEditBuyAndSaveButton, constraintLayout2, findChildViewById2, findChildViewById3, findChildViewById4, relativeLayout3, recyclerView, imageView3, e16, findChildViewById6, relativeLayout4, textView5);
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

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
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cs implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419121a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419122b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419123c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f419124d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f419125e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419126f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419127g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f419128h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f419129i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419130j;

    /* renamed from: k, reason: collision with root package name */
    public final View f419131k;

    /* renamed from: l, reason: collision with root package name */
    public final AvatarGlobalLoadingView f419132l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f419133m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f419134n;

    /* renamed from: o, reason: collision with root package name */
    public final RecyclerView f419135o;

    /* renamed from: p, reason: collision with root package name */
    public final AvatarPanelErrorView f419136p;

    /* renamed from: q, reason: collision with root package name */
    public final cy f419137q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f419138r;

    /* renamed from: s, reason: collision with root package name */
    public final ImageView f419139s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f419140t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f419141u;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMContainer() {
        return this.f419121a;
    }

    cs(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3, View view, AvatarGlobalLoadingView avatarGlobalLoadingView, ImageView imageView4, TextView textView4, RecyclerView recyclerView, AvatarPanelErrorView avatarPanelErrorView, cy cyVar, FrameLayout frameLayout, ImageView imageView5, TextView textView5, TextView textView6) {
        this.f419121a = constraintLayout;
        this.f419122b = imageView;
        this.f419123c = textView;
        this.f419124d = constraintLayout2;
        this.f419125e = linearLayout;
        this.f419126f = linearLayout2;
        this.f419127g = imageView2;
        this.f419128h = imageView3;
        this.f419129i = textView2;
        this.f419130j = textView3;
        this.f419131k = view;
        this.f419132l = avatarGlobalLoadingView;
        this.f419133m = imageView4;
        this.f419134n = textView4;
        this.f419135o = recyclerView;
        this.f419136p = avatarPanelErrorView;
        this.f419137q = cyVar;
        this.f419138r = frameLayout;
        this.f419139s = imageView5;
        this.f419140t = textView5;
        this.f419141u = textView6;
    }

    public static cs g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cs h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.df6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static cs e(View view) {
        int i3 = R.id.p_a;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_a);
        if (imageView != null) {
            i3 = R.id.ph8;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ph8);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
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
                                                                        i3 = R.id.qls;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.qls);
                                                                        if (imageView5 != null) {
                                                                            i3 = R.id.qlu;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qlu);
                                                                            if (textView5 != null) {
                                                                                i3 = R.id.qsj;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qsj);
                                                                                if (textView6 != null) {
                                                                                    return new cs(constraintLayout, imageView, textView, constraintLayout, linearLayout, linearLayout2, imageView2, imageView3, textView2, textView3, findChildViewById, avatarGlobalLoadingView, imageView4, textView4, recyclerView, avatarPanelErrorView, e16, frameLayout, imageView5, textView5, textView6);
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

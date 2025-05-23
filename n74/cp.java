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
public final class cp implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419048a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419049b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419050c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f419051d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f419052e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419053f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419054g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f419055h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f419056i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419057j;

    /* renamed from: k, reason: collision with root package name */
    public final View f419058k;

    /* renamed from: l, reason: collision with root package name */
    public final AvatarGlobalLoadingView f419059l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f419060m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f419061n;

    /* renamed from: o, reason: collision with root package name */
    public final RecyclerView f419062o;

    /* renamed from: p, reason: collision with root package name */
    public final AvatarPanelErrorView f419063p;

    /* renamed from: q, reason: collision with root package name */
    public final cy f419064q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f419065r;

    /* renamed from: s, reason: collision with root package name */
    public final ImageView f419066s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f419067t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f419068u;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMContainer() {
        return this.f419048a;
    }

    cp(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3, View view, AvatarGlobalLoadingView avatarGlobalLoadingView, ImageView imageView4, TextView textView4, RecyclerView recyclerView, AvatarPanelErrorView avatarPanelErrorView, cy cyVar, FrameLayout frameLayout, ImageView imageView5, TextView textView5, TextView textView6) {
        this.f419048a = constraintLayout;
        this.f419049b = imageView;
        this.f419050c = textView;
        this.f419051d = constraintLayout2;
        this.f419052e = linearLayout;
        this.f419053f = linearLayout2;
        this.f419054g = imageView2;
        this.f419055h = imageView3;
        this.f419056i = textView2;
        this.f419057j = textView3;
        this.f419058k = view;
        this.f419059l = avatarGlobalLoadingView;
        this.f419060m = imageView4;
        this.f419061n = textView4;
        this.f419062o = recyclerView;
        this.f419063p = avatarPanelErrorView;
        this.f419064q = cyVar;
        this.f419065r = frameLayout;
        this.f419066s = imageView5;
        this.f419067t = textView5;
        this.f419068u = textView6;
    }

    public static cp g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cp h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167459df3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static cp e(View view) {
        int i3 = R.id.p_a;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_a);
        if (imageView != null) {
            i3 = R.id.phn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.phn);
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
                                                                                    return new cp(constraintLayout, imageView, textView, constraintLayout, linearLayout, linearLayout2, imageView2, imageView3, textView2, textView3, findChildViewById, avatarGlobalLoadingView, imageView4, textView4, recyclerView, avatarPanelErrorView, e16, frameLayout, imageView5, textView5, textView6);
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

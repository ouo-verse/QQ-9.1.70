package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418978a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418979b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418980c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f418981d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f418982e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f418983f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f418984g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f418985h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f418986i;

    /* renamed from: j, reason: collision with root package name */
    public final View f418987j;

    /* renamed from: k, reason: collision with root package name */
    public final AvatarGlobalLoadingView f418988k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f418989l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f418990m;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f418991n;

    /* renamed from: o, reason: collision with root package name */
    public final Guideline f418992o;

    /* renamed from: p, reason: collision with root package name */
    public final AvatarPanelErrorView f418993p;

    /* renamed from: q, reason: collision with root package name */
    public final cz f418994q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f418995r;

    /* renamed from: s, reason: collision with root package name */
    public final FrameLayout f418996s;

    /* renamed from: t, reason: collision with root package name */
    public final ImageView f418997t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f418998u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f418999v;

    cd(LinearLayout linearLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, TextView textView2, TextView textView3, View view, AvatarGlobalLoadingView avatarGlobalLoadingView, ImageView imageView3, TextView textView4, RecyclerView recyclerView, Guideline guideline, AvatarPanelErrorView avatarPanelErrorView, cz czVar, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView4, TextView textView5, TextView textView6) {
        this.f418978a = linearLayout;
        this.f418979b = imageView;
        this.f418980c = textView;
        this.f418981d = constraintLayout;
        this.f418982e = linearLayout2;
        this.f418983f = linearLayout3;
        this.f418984g = imageView2;
        this.f418985h = textView2;
        this.f418986i = textView3;
        this.f418987j = view;
        this.f418988k = avatarGlobalLoadingView;
        this.f418989l = imageView3;
        this.f418990m = textView4;
        this.f418991n = recyclerView;
        this.f418992o = guideline;
        this.f418993p = avatarPanelErrorView;
        this.f418994q = czVar;
        this.f418995r = frameLayout;
        this.f418996s = frameLayout2;
        this.f418997t = imageView4;
        this.f418998u = textView5;
        this.f418999v = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getMContainer() {
        return this.f418978a;
    }

    public static cd g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cd h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.def, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static cd e(View view) {
        int i3 = R.id.p_a;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_a);
        if (imageView != null) {
            i3 = R.id.phn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.phn);
            if (textView != null) {
                i3 = R.id.pio;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pio);
                if (constraintLayout != null) {
                    i3 = R.id.png;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.png);
                    if (linearLayout != null) {
                        i3 = R.id.pni;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pni);
                        if (linearLayout2 != null) {
                            i3 = R.id.ppj;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ppj);
                            if (imageView2 != null) {
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
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163397px1);
                                                if (imageView3 != null) {
                                                    i3 = R.id.f163398px2;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f163398px2);
                                                    if (textView4 != null) {
                                                        i3 = R.id.pxn;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.pxn);
                                                        if (recyclerView != null) {
                                                            i3 = R.id.pyq;
                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.pyq);
                                                            if (guideline != null) {
                                                                i3 = R.id.q5u;
                                                                AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.q5u);
                                                                if (avatarPanelErrorView != null) {
                                                                    i3 = R.id.q6i;
                                                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q6i);
                                                                    if (findChildViewById2 != null) {
                                                                        cz e16 = cz.e(findChildViewById2);
                                                                        i3 = R.id.q6j;
                                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q6j);
                                                                        if (frameLayout != null) {
                                                                            i3 = R.id.qcv;
                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qcv);
                                                                            if (frameLayout2 != null) {
                                                                                i3 = R.id.qls;
                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qls);
                                                                                if (imageView4 != null) {
                                                                                    i3 = R.id.qlu;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qlu);
                                                                                    if (textView5 != null) {
                                                                                        i3 = R.id.qsj;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.qsj);
                                                                                        if (textView6 != null) {
                                                                                            return new cd((LinearLayout) view, imageView, textView, constraintLayout, linearLayout, linearLayout2, imageView2, textView2, textView3, findChildViewById, avatarGlobalLoadingView, imageView3, textView4, recyclerView, guideline, avatarPanelErrorView, e16, frameLayout, frameLayout2, imageView4, textView5, textView6);
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

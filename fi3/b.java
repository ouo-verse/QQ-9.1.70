package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399005a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f399006b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399007c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399008d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399009e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399010f;

    /* renamed from: g, reason: collision with root package name */
    public final View f399011g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f399012h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f399013i;

    /* renamed from: j, reason: collision with root package name */
    public final RoundCorneredRelativeLayout f399014j;

    /* renamed from: k, reason: collision with root package name */
    public final View f399015k;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f399016l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f399017m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f399018n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f399019o;

    b(RelativeLayout relativeLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, ImageView imageView3, View view, FrameLayout frameLayout, ImageView imageView4, RoundCorneredRelativeLayout roundCorneredRelativeLayout, View view2, RecyclerView recyclerView, ImageView imageView5, ImageView imageView6, ImageView imageView7) {
        this.f399005a = relativeLayout;
        this.f399006b = textView;
        this.f399007c = imageView;
        this.f399008d = imageView2;
        this.f399009e = textView2;
        this.f399010f = imageView3;
        this.f399011g = view;
        this.f399012h = frameLayout;
        this.f399013i = imageView4;
        this.f399014j = roundCorneredRelativeLayout;
        this.f399015k = view2;
        this.f399016l = recyclerView;
        this.f399017m = imageView5;
        this.f399018n = imageView6;
        this.f399019o = imageView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399005a;
    }

    public static b g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d36, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static b e(View view) {
        int i3 = R.id.f163290pb4;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163290pb4);
        if (textView != null) {
            i3 = R.id.pb8;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pb8);
            if (imageView != null) {
                i3 = R.id.pba;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pba);
                if (imageView2 != null) {
                    i3 = R.id.pbb;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pbb);
                    if (textView2 != null) {
                        i3 = R.id.pcx;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pcx);
                        if (imageView3 != null) {
                            i3 = R.id.pej;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.pej);
                            if (findChildViewById != null) {
                                i3 = R.id.ppx;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ppx);
                                if (frameLayout != null) {
                                    i3 = R.id.ppy;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.ppy);
                                    if (imageView4 != null) {
                                        i3 = R.id.q5m;
                                        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) ViewBindings.findChildViewById(view, R.id.q5m);
                                        if (roundCorneredRelativeLayout != null) {
                                            i3 = R.id.q7v;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q7v);
                                            if (findChildViewById2 != null) {
                                                i3 = R.id.qgo;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qgo);
                                                if (recyclerView != null) {
                                                    i3 = R.id.qgt;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.qgt);
                                                    if (imageView5 != null) {
                                                        i3 = R.id.qkb;
                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.qkb);
                                                        if (imageView6 != null) {
                                                            i3 = R.id.qrd;
                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.qrd);
                                                            if (imageView7 != null) {
                                                                return new b((RelativeLayout) view, textView, imageView, imageView2, textView2, imageView3, findChildViewById, frameLayout, imageView4, roundCorneredRelativeLayout, findChildViewById2, recyclerView, imageView5, imageView6, imageView7);
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

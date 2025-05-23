package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class dd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f419210a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f419211b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419212c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f419213d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419214e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f419215f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419216g;

    /* renamed from: h, reason: collision with root package name */
    public final ZPlanMediaView f419217h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f419218i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f419219j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f419220k;

    /* renamed from: l, reason: collision with root package name */
    public final RelativeLayout f419221l;

    /* renamed from: m, reason: collision with root package name */
    public final RelativeLayout f419222m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f419223n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f419224o;

    /* renamed from: p, reason: collision with root package name */
    public final GridView f419225p;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f419210a;
    }

    dd(RelativeLayout relativeLayout, TextView textView, ImageView imageView, RelativeLayout relativeLayout2, TextView textView2, ImageView imageView2, ImageView imageView3, ZPlanMediaView zPlanMediaView, RelativeLayout relativeLayout3, ImageView imageView4, ImageView imageView5, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TextView textView3, ImageView imageView6, GridView gridView) {
        this.f419210a = relativeLayout;
        this.f419211b = textView;
        this.f419212c = imageView;
        this.f419213d = relativeLayout2;
        this.f419214e = textView2;
        this.f419215f = imageView2;
        this.f419216g = imageView3;
        this.f419217h = zPlanMediaView;
        this.f419218i = relativeLayout3;
        this.f419219j = imageView4;
        this.f419220k = imageView5;
        this.f419221l = relativeLayout4;
        this.f419222m = relativeLayout5;
        this.f419223n = textView3;
        this.f419224o = imageView6;
        this.f419225p = gridView;
    }

    public static dd g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static dd h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static dd e(View view) {
        int i3 = R.id.f163301pe0;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163301pe0);
        if (textView != null) {
            i3 = R.id.f163304pe3;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163304pe3);
            if (imageView != null) {
                i3 = R.id.pe6;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pe6);
                if (relativeLayout != null) {
                    i3 = R.id.pe8;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pe8);
                    if (textView2 != null) {
                        i3 = R.id.pe9;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pe9);
                        if (imageView2 != null) {
                            i3 = R.id.pe_;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pe_);
                            if (imageView3 != null) {
                                i3 = R.id.pea;
                                ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.pea);
                                if (zPlanMediaView != null) {
                                    i3 = R.id.peb;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.peb);
                                    if (relativeLayout2 != null) {
                                        i3 = R.id.pec;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.pec);
                                        if (imageView4 != null) {
                                            i3 = R.id.pkb;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.pkb);
                                            if (imageView5 != null) {
                                                i3 = R.id.pma;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pma);
                                                if (relativeLayout3 != null) {
                                                    i3 = R.id.psu;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.psu);
                                                    if (relativeLayout4 != null) {
                                                        i3 = R.id.psv;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.psv);
                                                        if (textView3 != null) {
                                                            i3 = R.id.q6u;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.q6u);
                                                            if (imageView6 != null) {
                                                                i3 = R.id.qhm;
                                                                GridView gridView = (GridView) ViewBindings.findChildViewById(view, R.id.qhm);
                                                                if (gridView != null) {
                                                                    return new dd((RelativeLayout) view, textView, imageView, relativeLayout, textView2, imageView2, imageView3, zPlanMediaView, relativeLayout2, imageView4, imageView5, relativeLayout3, relativeLayout4, textView3, imageView6, gridView);
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

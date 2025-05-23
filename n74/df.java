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
import com.tencent.sqshow.widget.pag.ZPlanPAGView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class df implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f419228a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanPAGView f419229b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanPAGView f419230c;

    /* renamed from: d, reason: collision with root package name */
    public final ZPlanPAGView f419231d;

    /* renamed from: e, reason: collision with root package name */
    public final ZPlanPAGView f419232e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f419233f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419234g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f419235h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f419236i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419237j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f419238k;

    /* renamed from: l, reason: collision with root package name */
    public final GridView f419239l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f419240m;

    /* renamed from: n, reason: collision with root package name */
    public final RelativeLayout f419241n;

    df(RelativeLayout relativeLayout, ZPlanPAGView zPlanPAGView, ZPlanPAGView zPlanPAGView2, ZPlanPAGView zPlanPAGView3, ZPlanPAGView zPlanPAGView4, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, TextView textView, TextView textView2, GridView gridView, ImageView imageView4, RelativeLayout relativeLayout3) {
        this.f419228a = relativeLayout;
        this.f419229b = zPlanPAGView;
        this.f419230c = zPlanPAGView2;
        this.f419231d = zPlanPAGView3;
        this.f419232e = zPlanPAGView4;
        this.f419233f = imageView;
        this.f419234g = imageView2;
        this.f419235h = imageView3;
        this.f419236i = relativeLayout2;
        this.f419237j = textView;
        this.f419238k = textView2;
        this.f419239l = gridView;
        this.f419240m = imageView4;
        this.f419241n = relativeLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f419228a;
    }

    public static df g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static df h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static df e(View view) {
        int i3 = R.id.pdw;
        ZPlanPAGView zPlanPAGView = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.pdw);
        if (zPlanPAGView != null) {
            i3 = R.id.f163305pe4;
            ZPlanPAGView zPlanPAGView2 = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.f163305pe4);
            if (zPlanPAGView2 != null) {
                i3 = R.id.plt;
                ZPlanPAGView zPlanPAGView3 = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.plt);
                if (zPlanPAGView3 != null) {
                    i3 = R.id.plu;
                    ZPlanPAGView zPlanPAGView4 = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.plu);
                    if (zPlanPAGView4 != null) {
                        i3 = R.id.plv;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.plv);
                        if (imageView != null) {
                            i3 = R.id.pon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pon);
                            if (imageView2 != null) {
                                i3 = R.id.q6u;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.q6u);
                                if (imageView3 != null) {
                                    i3 = R.id.qhg;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qhg);
                                    if (relativeLayout != null) {
                                        i3 = R.id.qhh;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qhh);
                                        if (textView != null) {
                                            i3 = R.id.qhi;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qhi);
                                            if (textView2 != null) {
                                                i3 = R.id.qhj;
                                                GridView gridView = (GridView) ViewBindings.findChildViewById(view, R.id.qhj);
                                                if (gridView != null) {
                                                    i3 = R.id.qhk;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qhk);
                                                    if (imageView4 != null) {
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                                        return new df(relativeLayout2, zPlanPAGView, zPlanPAGView2, zPlanPAGView3, zPlanPAGView4, imageView, imageView2, imageView3, relativeLayout, textView, textView2, gridView, imageView4, relativeLayout2);
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

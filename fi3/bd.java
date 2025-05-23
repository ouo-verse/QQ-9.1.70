package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaListMapListView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399061a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f399062b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaLoadFailView f399063c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f399064d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399065e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399066f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f399067g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f399068h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f399069i;

    /* renamed from: j, reason: collision with root package name */
    public final ShimmerLinearLayout f399070j;

    /* renamed from: k, reason: collision with root package name */
    public final ZootopiaListMapListView f399071k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f399072l;

    /* renamed from: m, reason: collision with root package name */
    public final View f399073m;

    bd(LinearLayout linearLayout, RelativeLayout relativeLayout, ZootopiaLoadFailView zootopiaLoadFailView, RelativeLayout relativeLayout2, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout3, ShimmerLinearLayout shimmerLinearLayout, ZootopiaListMapListView zootopiaListMapListView, LinearLayout linearLayout2, View view) {
        this.f399061a = linearLayout;
        this.f399062b = relativeLayout;
        this.f399063c = zootopiaLoadFailView;
        this.f399064d = relativeLayout2;
        this.f399065e = textView;
        this.f399066f = imageView;
        this.f399067g = imageView2;
        this.f399068h = imageView3;
        this.f399069i = relativeLayout3;
        this.f399070j = shimmerLinearLayout;
        this.f399071k = zootopiaListMapListView;
        this.f399072l = linearLayout2;
        this.f399073m = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399061a;
    }

    public static bd g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dcx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static bd e(View view) {
        int i3 = R.id.r0w;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.r0w);
        if (relativeLayout != null) {
            i3 = R.id.r0x;
            ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.r0x);
            if (zootopiaLoadFailView != null) {
                i3 = R.id.r2h;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.r2h);
                if (relativeLayout2 != null) {
                    i3 = R.id.r47;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r47);
                    if (textView != null) {
                        i3 = R.id.r5f;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.r5f);
                        if (imageView != null) {
                            i3 = R.id.r5g;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.r5g);
                            if (imageView2 != null) {
                                i3 = R.id.r5h;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.r5h);
                                if (imageView3 != null) {
                                    i3 = R.id.r5i;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.r5i);
                                    if (relativeLayout3 != null) {
                                        i3 = R.id.r6m;
                                        ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.r6m);
                                        if (shimmerLinearLayout != null) {
                                            i3 = R.id.r6n;
                                            ZootopiaListMapListView zootopiaListMapListView = (ZootopiaListMapListView) ViewBindings.findChildViewById(view, R.id.r6n);
                                            if (zootopiaListMapListView != null) {
                                                LinearLayout linearLayout = (LinearLayout) view;
                                                i3 = R.id.r8f;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.r8f);
                                                if (findChildViewById != null) {
                                                    return new bd(linearLayout, relativeLayout, zootopiaLoadFailView, relativeLayout2, textView, imageView, imageView2, imageView3, relativeLayout3, shimmerLinearLayout, zootopiaListMapListView, linearLayout, findChildViewById);
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

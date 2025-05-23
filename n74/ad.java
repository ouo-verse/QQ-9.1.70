package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ad implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418590a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewStub f418591b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f418592c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f418593d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewStub f418594e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewStub f418595f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewStub f418596g;

    /* renamed from: h, reason: collision with root package name */
    public final bo f418597h;

    /* renamed from: i, reason: collision with root package name */
    public final RoundCornerImageView f418598i;

    /* renamed from: j, reason: collision with root package name */
    public final ViewStub f418599j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewStub f418600k;

    /* renamed from: l, reason: collision with root package name */
    public final ZPlanRedDotView f418601l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewStub f418602m;

    /* renamed from: n, reason: collision with root package name */
    public final ViewStub f418603n;

    ad(FrameLayout frameLayout, ViewStub viewStub, ImageView imageView, FrameLayout frameLayout2, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4, bo boVar, RoundCornerImageView roundCornerImageView, ViewStub viewStub5, ViewStub viewStub6, ZPlanRedDotView zPlanRedDotView, ViewStub viewStub7, ViewStub viewStub8) {
        this.f418590a = frameLayout;
        this.f418591b = viewStub;
        this.f418592c = imageView;
        this.f418593d = frameLayout2;
        this.f418594e = viewStub2;
        this.f418595f = viewStub3;
        this.f418596g = viewStub4;
        this.f418597h = boVar;
        this.f418598i = roundCornerImageView;
        this.f418599j = viewStub5;
        this.f418600k = viewStub6;
        this.f418601l = zPlanRedDotView;
        this.f418602m = viewStub7;
        this.f418603n = viewStub8;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418590a;
    }

    public static ad g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ad h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_r, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static ad e(View view) {
        int i3 = R.id.p_9;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.p_9);
        if (viewStub != null) {
            i3 = R.id.pd_;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pd_);
            if (imageView != null) {
                i3 = R.id.pdp;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pdp);
                if (frameLayout != null) {
                    i3 = R.id.peo;
                    ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.peo);
                    if (viewStub2 != null) {
                        i3 = R.id.pkq;
                        ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.pkq);
                        if (viewStub3 != null) {
                            i3 = R.id.poh;
                            ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, R.id.poh);
                            if (viewStub4 != null) {
                                i3 = R.id.pze;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.pze);
                                if (findChildViewById != null) {
                                    bo e16 = bo.e(findChildViewById);
                                    i3 = R.id.q2w;
                                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.q2w);
                                    if (roundCornerImageView != null) {
                                        i3 = R.id.q4q;
                                        ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, R.id.q4q);
                                        if (viewStub5 != null) {
                                            i3 = R.id.q66;
                                            ViewStub viewStub6 = (ViewStub) ViewBindings.findChildViewById(view, R.id.q66);
                                            if (viewStub6 != null) {
                                                i3 = R.id.qgv;
                                                ZPlanRedDotView zPlanRedDotView = (ZPlanRedDotView) ViewBindings.findChildViewById(view, R.id.qgv);
                                                if (zPlanRedDotView != null) {
                                                    i3 = R.id.qht;
                                                    ViewStub viewStub7 = (ViewStub) ViewBindings.findChildViewById(view, R.id.qht);
                                                    if (viewStub7 != null) {
                                                        i3 = R.id.qnt;
                                                        ViewStub viewStub8 = (ViewStub) ViewBindings.findChildViewById(view, R.id.qnt);
                                                        if (viewStub8 != null) {
                                                            return new ad((FrameLayout) view, viewStub, imageView, frameLayout, viewStub2, viewStub3, viewStub4, e16, roundCornerImageView, viewStub5, viewStub6, zPlanRedDotView, viewStub7, viewStub8);
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

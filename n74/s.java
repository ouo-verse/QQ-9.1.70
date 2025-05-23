package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419402a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419403b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419404c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419405d;

    /* renamed from: e, reason: collision with root package name */
    public final URLImageView f419406e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f419407f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f419408g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f419409h;

    /* renamed from: i, reason: collision with root package name */
    public final NativePanelLoadingIgv f419410i;

    /* renamed from: j, reason: collision with root package name */
    public final RoundCornerImageView f419411j;

    /* renamed from: k, reason: collision with root package name */
    public final ZPlanRedDotView f419412k;

    s(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, URLImageView uRLImageView, TextView textView2, TextView textView3, TextView textView4, NativePanelLoadingIgv nativePanelLoadingIgv, RoundCornerImageView roundCornerImageView, ZPlanRedDotView zPlanRedDotView) {
        this.f419402a = frameLayout;
        this.f419403b = imageView;
        this.f419404c = linearLayout;
        this.f419405d = textView;
        this.f419406e = uRLImageView;
        this.f419407f = textView2;
        this.f419408g = textView3;
        this.f419409h = textView4;
        this.f419410i = nativePanelLoadingIgv;
        this.f419411j = roundCornerImageView;
        this.f419412k = zPlanRedDotView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419402a;
    }

    public static s g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static s e(View view) {
        int i3 = R.id.pd9;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pd9);
        if (imageView != null) {
            i3 = R.id.pqn;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pqn);
            if (linearLayout != null) {
                i3 = R.id.pqo;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pqo);
                if (textView != null) {
                    i3 = R.id.pqp;
                    URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.pqp);
                    if (uRLImageView != null) {
                        i3 = R.id.pqq;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pqq);
                        if (textView2 != null) {
                            i3 = R.id.pqs;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pqs);
                            if (textView3 != null) {
                                i3 = R.id.pqt;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.pqt);
                                if (textView4 != null) {
                                    i3 = R.id.q65;
                                    NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.q65);
                                    if (nativePanelLoadingIgv != null) {
                                        i3 = R.id.q7g;
                                        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.q7g);
                                        if (roundCornerImageView != null) {
                                            i3 = R.id.qgv;
                                            ZPlanRedDotView zPlanRedDotView = (ZPlanRedDotView) ViewBindings.findChildViewById(view, R.id.qgv);
                                            if (zPlanRedDotView != null) {
                                                return new s((FrameLayout) view, imageView, linearLayout, textView, uRLImageView, textView2, textView3, textView4, nativePanelLoadingIgv, roundCornerImageView, zPlanRedDotView);
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

    public static s h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

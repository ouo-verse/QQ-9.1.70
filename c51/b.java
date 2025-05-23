package c51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f30336a;

    /* renamed from: b, reason: collision with root package name */
    public final LottieAnimationView f30337b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f30338c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f30339d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f30340e;

    /* renamed from: f, reason: collision with root package name */
    public final View f30341f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f30342g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f30343h;

    b(View view, LottieAnimationView lottieAnimationView, LinearLayout linearLayout, TextView textView, ImageView imageView, View view2, ImageView imageView2, TextView textView2) {
        this.f30336a = view;
        this.f30337b = lottieAnimationView;
        this.f30338c = linearLayout;
        this.f30339d = textView;
        this.f30340e = imageView;
        this.f30341f = view2;
        this.f30342g = imageView2;
        this.f30343h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f30336a;
    }

    public static b e(View view) {
        int i3 = R.id.olt;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.olt);
        if (lottieAnimationView != null) {
            i3 = R.id.oqj;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.oqj);
            if (linearLayout != null) {
                i3 = R.id.oqk;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.oqk);
                if (textView != null) {
                    i3 = R.id.oql;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.oql);
                    if (imageView != null) {
                        i3 = R.id.oqm;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.oqm);
                        if (findChildViewById != null) {
                            i3 = R.id.oqn;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.oqn);
                            if (imageView2 != null) {
                                i3 = R.id.oqo;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.oqo);
                                if (textView2 != null) {
                                    return new b(view, lottieAnimationView, linearLayout, textView, imageView, findChildViewById, imageView2, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static b f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.cwq, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

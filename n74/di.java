package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class di implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419269a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419270b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419271c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f419272d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419273e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419274f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419275g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f419276h;

    di(View view, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView, LinearLayout linearLayout2, ImageView imageView3, TextView textView2) {
        this.f419269a = view;
        this.f419270b = imageView;
        this.f419271c = linearLayout;
        this.f419272d = imageView2;
        this.f419273e = textView;
        this.f419274f = linearLayout2;
        this.f419275g = imageView3;
        this.f419276h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419269a;
    }

    public static di e(View view) {
        int i3 = R.id.p__;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p__);
        if (imageView != null) {
            i3 = R.id.f163399px3;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163399px3);
            if (linearLayout != null) {
                i3 = R.id.px5;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.px5);
                if (imageView2 != null) {
                    i3 = R.id.px7;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.px7);
                    if (textView != null) {
                        i3 = R.id.qlr;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qlr);
                        if (linearLayout2 != null) {
                            i3 = R.id.qlt;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qlt);
                            if (imageView3 != null) {
                                i3 = R.id.qlv;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qlv);
                                if (textView2 != null) {
                                    return new di(view, imageView, linearLayout, imageView2, textView, linearLayout2, imageView3, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static di f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dgw, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

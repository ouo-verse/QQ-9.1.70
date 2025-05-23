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
public final class dj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419277a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419278b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419279c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419280d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f419281e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419282f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419283g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f419284h;

    dj(View view, ImageView imageView, ImageView imageView2, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, TextView textView2) {
        this.f419277a = view;
        this.f419278b = imageView;
        this.f419279c = imageView2;
        this.f419280d = textView;
        this.f419281e = linearLayout;
        this.f419282f = linearLayout2;
        this.f419283g = imageView3;
        this.f419284h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419277a;
    }

    public static dj e(View view) {
        int i3 = R.id.p__;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p__);
        if (imageView != null) {
            i3 = R.id.px5;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.px5);
            if (imageView2 != null) {
                i3 = R.id.px7;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.px7);
                if (textView != null) {
                    i3 = R.id.px8;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.px8);
                    if (linearLayout != null) {
                        i3 = R.id.qlr;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qlr);
                        if (linearLayout2 != null) {
                            i3 = R.id.qlt;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qlt);
                            if (imageView3 != null) {
                                i3 = R.id.qlv;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qlv);
                                if (textView2 != null) {
                                    return new dj(view, imageView, imageView2, textView, linearLayout, linearLayout2, imageView3, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static dj f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dgx, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

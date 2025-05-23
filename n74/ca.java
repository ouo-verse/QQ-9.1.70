package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ca implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418963a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418964b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f418965c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418966d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f418967e;

    ca(View view, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2) {
        this.f418963a = view;
        this.f418964b = imageView;
        this.f418965c = linearLayout;
        this.f418966d = imageView2;
        this.f418967e = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418963a;
    }

    public static ca e(View view) {
        int i3 = R.id.p_e;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_e);
        if (imageView != null) {
            i3 = R.id.pm6;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pm6);
            if (linearLayout != null) {
                i3 = R.id.q7h;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q7h);
                if (imageView2 != null) {
                    i3 = R.id.q7i;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q7i);
                    if (linearLayout2 != null) {
                        return new ca(view, imageView, linearLayout, imageView2, linearLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ca f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dea, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

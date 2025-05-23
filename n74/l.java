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
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419367a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f419368b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419369c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f419370d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f419371e;

    l(View view, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.f419367a = view;
        this.f419368b = linearLayout;
        this.f419369c = imageView;
        this.f419370d = imageView2;
        this.f419371e = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419367a;
    }

    public static l e(View view) {
        int i3 = R.id.pzn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pzn);
        if (linearLayout != null) {
            i3 = R.id.q4f;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q4f);
            if (imageView != null) {
                i3 = R.id.q_f;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q_f);
                if (imageView2 != null) {
                    i3 = R.id.qhb;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qhb);
                    if (imageView3 != null) {
                        return new l(view, linearLayout, imageView, imageView2, imageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static l f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d_6, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

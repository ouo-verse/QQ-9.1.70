package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419023a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419024b;

    cj(View view, ImageView imageView) {
        this.f419023a = view;
        this.f419024b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419023a;
    }

    public static cj e(View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qek);
        if (imageView != null) {
            return new cj(view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qek)));
    }

    public static cj f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dem, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

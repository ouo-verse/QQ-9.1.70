package n74;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ai implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ShimmerLinearLayout f418624a;

    /* renamed from: b, reason: collision with root package name */
    public final ShimmerLinearLayout f418625b;

    ai(ShimmerLinearLayout shimmerLinearLayout, ShimmerLinearLayout shimmerLinearLayout2) {
        this.f418624a = shimmerLinearLayout;
        this.f418625b = shimmerLinearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ShimmerLinearLayout getRoot() {
        return this.f418624a;
    }

    public static ai e(View view) {
        if (view != null) {
            ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) view;
            return new ai(shimmerLinearLayout, shimmerLinearLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}

package n74;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cz implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ShimmerLinearLayout f419189a;

    /* renamed from: b, reason: collision with root package name */
    public final ShimmerLinearLayout f419190b;

    cz(ShimmerLinearLayout shimmerLinearLayout, ShimmerLinearLayout shimmerLinearLayout2) {
        this.f419189a = shimmerLinearLayout;
        this.f419190b = shimmerLinearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ShimmerLinearLayout getRoot() {
        return this.f419189a;
    }

    public static cz e(View view) {
        if (view != null) {
            ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) view;
            return new cz(shimmerLinearLayout, shimmerLinearLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}

package n74;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class dk implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ShimmerLinearLayout f419285a;

    /* renamed from: b, reason: collision with root package name */
    public final RoundCornerImageView f419286b;

    /* renamed from: c, reason: collision with root package name */
    public final ShimmerLinearLayout f419287c;

    dk(ShimmerLinearLayout shimmerLinearLayout, RoundCornerImageView roundCornerImageView, ShimmerLinearLayout shimmerLinearLayout2) {
        this.f419285a = shimmerLinearLayout;
        this.f419286b = roundCornerImageView;
        this.f419287c = shimmerLinearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ShimmerLinearLayout getRoot() {
        return this.f419285a;
    }

    public static dk e(View view) {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.pdq);
        if (roundCornerImageView != null) {
            ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) view;
            return new dk(shimmerLinearLayout, roundCornerImageView, shimmerLinearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.pdq)));
    }
}

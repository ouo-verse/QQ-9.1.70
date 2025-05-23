package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421096a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f421097b;

    n(@NonNull View view, @NonNull RoundCornerImageView roundCornerImageView) {
        this.f421096a = view;
        this.f421097b = roundCornerImageView;
    }

    @NonNull
    public static n e(@NonNull View view) {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.zzp);
        if (roundCornerImageView != null) {
            return new n(view, roundCornerImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zzp)));
    }

    @NonNull
    public static n f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.htd, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421096a;
    }
}

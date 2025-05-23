package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.ui.widget.TimiArkView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ap implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420853a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TimiArkView f420854b;

    ap(@NonNull View view, @NonNull TimiArkView timiArkView) {
        this.f420853a = view;
        this.f420854b = timiArkView;
    }

    @NonNull
    public static ap e(@NonNull View view) {
        TimiArkView timiArkView = (TimiArkView) ViewBindings.findChildViewById(view, R.id.y_);
        if (timiArkView != null) {
            return new ap(view, timiArkView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.y_)));
    }

    @NonNull
    public static ap f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hvz, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420853a;
    }
}

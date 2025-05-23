package hp2;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class al implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405600a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405601b;

    al(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.f405600a = constraintLayout;
        this.f405601b = constraintLayout2;
    }

    @NonNull
    public static al e(@NonNull View view) {
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new al(constraintLayout, constraintLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405600a;
    }
}

package hp2;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f405748a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f405749b;

    t(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.f405748a = frameLayout;
        this.f405749b = frameLayout2;
    }

    @NonNull
    public static t e(@NonNull View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new t(frameLayout, frameLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f405748a;
    }
}

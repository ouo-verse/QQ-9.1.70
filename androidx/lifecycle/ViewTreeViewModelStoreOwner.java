package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    ViewTreeViewModelStoreOwner() {
    }

    @Nullable
    public static ViewModelStoreOwner get(@NonNull View view) {
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) view.getTag(R.id.f11958779);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        Object parent = view.getParent();
        while (viewModelStoreOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            viewModelStoreOwner = (ViewModelStoreOwner) view2.getTag(R.id.f11958779);
            parent = view2.getParent();
        }
        return viewModelStoreOwner;
    }

    public static void set(@NonNull View view, @Nullable ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R.id.f11958779, viewModelStoreOwner);
    }
}

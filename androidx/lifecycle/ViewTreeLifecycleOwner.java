package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    ViewTreeLifecycleOwner() {
    }

    @Nullable
    public static LifecycleOwner get(@NonNull View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) view.getTag(R.id.f11956777);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Object parent = view.getParent();
        while (lifecycleOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            lifecycleOwner = (LifecycleOwner) view2.getTag(R.id.f11956777);
            parent = view2.getParent();
        }
        return lifecycleOwner;
    }

    public static void set(@NonNull View view, @Nullable LifecycleOwner lifecycleOwner) {
        view.setTag(R.id.f11956777, lifecycleOwner);
    }
}

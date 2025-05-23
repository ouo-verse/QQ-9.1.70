package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class DialogCompat {
    DialogCompat() {
    }

    @NonNull
    public static View requireViewById(@NonNull Dialog dialog, int i3) {
        View requireViewById;
        if (Build.VERSION.SDK_INT >= 28) {
            requireViewById = dialog.requireViewById(i3);
            return requireViewById;
        }
        View findViewById = dialog.findViewById(i3);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}

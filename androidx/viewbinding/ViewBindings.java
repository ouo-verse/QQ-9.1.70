package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class ViewBindings {
    ViewBindings() {
    }

    @Nullable
    public static <T extends View> T findChildViewById(View view, @IdRes int i3) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            T t16 = (T) viewGroup.getChildAt(i16).findViewById(i3);
            if (t16 != null) {
                return t16;
            }
        }
        return null;
    }
}

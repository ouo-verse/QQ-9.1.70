package androidx.appcompat.widget;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface FitWindowsViewGroup {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}

package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(22)
/* loaded from: classes.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View view, int i3, int i16, int i17, int i18) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                view.setLeftTopRightBottom(i3, i16, i17, i18);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}

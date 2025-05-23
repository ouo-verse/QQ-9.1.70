package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z16) {
        popupWindow.setOverlapAnchor(z16);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i3) {
        popupWindow.setWindowLayoutType(i3);
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i3, int i16, int i17) {
        popupWindow.showAsDropDown(view, i3, i16, i17);
    }
}

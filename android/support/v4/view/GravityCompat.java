package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    GravityCompat() {
    }

    public static void apply(int i3, int i16, int i17, Rect rect, Rect rect2, int i18) {
        Gravity.apply(i3, i16, i17, rect, rect2, i18);
    }

    public static void applyDisplay(int i3, Rect rect, Rect rect2, int i16) {
        Gravity.applyDisplay(i3, rect, rect2, i16);
    }

    public static int getAbsoluteGravity(int i3, int i16) {
        return Gravity.getAbsoluteGravity(i3, i16);
    }

    public static void apply(int i3, int i16, int i17, Rect rect, int i18, int i19, Rect rect2, int i26) {
        Gravity.apply(i3, i16, i17, rect, i18, i19, rect2, i26);
    }
}

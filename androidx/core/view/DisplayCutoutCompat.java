package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final Object mDisplayCutout;

    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null);
    }

    private static DisplayCutout constructDisplayCutout(@NonNull Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull Insets insets2) {
        if (BuildCompat.isAtLeastR()) {
            return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        }
        if (i3 >= 28) {
            Rect rect5 = new Rect(insets.left, insets.top, insets.right, insets.bottom);
            ArrayList arrayList = new ArrayList();
            if (rect != null) {
                arrayList.add(rect);
            }
            if (rect2 != null) {
                arrayList.add(rect2);
            }
            if (rect3 != null) {
                arrayList.add(rect3);
            }
            if (rect4 != null) {
                arrayList.add(rect4);
            }
            return new DisplayCutout(rect5, arrayList);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayCutoutCompat wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new DisplayCutoutCompat(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DisplayCutoutCompat.class == obj.getClass()) {
            return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) obj).mDisplayCutout);
        }
        return false;
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        List<Rect> boundingRects;
        if (Build.VERSION.SDK_INT >= 28) {
            boundingRects = ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
            return boundingRects;
        }
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        int safeInsetBottom;
        if (Build.VERSION.SDK_INT >= 28) {
            safeInsetBottom = ((DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
            return safeInsetBottom;
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        int safeInsetLeft;
        if (Build.VERSION.SDK_INT >= 28) {
            safeInsetLeft = ((DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
            return safeInsetLeft;
        }
        return 0;
    }

    public int getSafeInsetRight() {
        int safeInsetRight;
        if (Build.VERSION.SDK_INT >= 28) {
            safeInsetRight = ((DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
            return safeInsetRight;
        }
        return 0;
    }

    public int getSafeInsetTop() {
        int safeInsetTop;
        if (Build.VERSION.SDK_INT >= 28) {
            safeInsetTop = ((DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
            return safeInsetTop;
        }
        return 0;
    }

    @NonNull
    public Insets getWaterfallInsets() {
        android.graphics.Insets waterfallInsets;
        if (BuildCompat.isAtLeastR()) {
            waterfallInsets = ((DisplayCutout) this.mDisplayCutout).getWaterfallInsets();
            return Insets.toCompatInsets(waterfallInsets);
        }
        return Insets.NONE;
    }

    public int hashCode() {
        Object obj = this.mDisplayCutout;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 28)
    public DisplayCutout unwrap() {
        return (DisplayCutout) this.mDisplayCutout;
    }

    public DisplayCutoutCompat(@NonNull Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull Insets insets2) {
        this(constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
    }

    DisplayCutoutCompat(Object obj) {
        this.mDisplayCutout = obj;
    }
}

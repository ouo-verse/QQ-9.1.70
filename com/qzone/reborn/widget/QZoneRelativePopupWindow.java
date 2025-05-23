package com.qzone.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.PopupWindow;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes37.dex */
public class QZoneRelativePopupWindow extends PopupWindow {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes37.dex */
    public @interface HorizontalPosition {
        public static final int ALIGN_LEFT = 3;
        public static final int ALIGN_RIGHT = 4;
        public static final int CENTER = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes37.dex */
    public @interface VerticalPosition {
        public static final int ABOVE = 1;
        public static final int ALIGN_BOTTOM = 4;
        public static final int ALIGN_TOP = 3;
        public static final int BELOW = 2;
        public static final int CENTER = 0;
    }

    public QZoneRelativePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QZoneRelativePopupWindow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public QZoneRelativePopupWindow() {
    }
}

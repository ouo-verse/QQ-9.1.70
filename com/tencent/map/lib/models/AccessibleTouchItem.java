package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class AccessibleTouchItem implements Comparable<AccessibleTouchItem> {
    public static final String MAP_DEFAULT_CONTENT_DESCRIPTION = "\u5730\u56fe";
    public static final int MIN_TOUCH_RADIUS = 20;
    public static final String MY_LOCATION_PREFIX = "\u6211\u7684\u4f4d\u7f6e";

    public abstract Rect getBounds();

    public abstract String getContentDescription();

    public abstract void onClick();

    @Override // java.lang.Comparable
    public int compareTo(@NonNull AccessibleTouchItem accessibleTouchItem) {
        Rect bounds = getBounds();
        Rect bounds2 = accessibleTouchItem.getBounds();
        int i3 = bounds.top;
        int i16 = bounds2.top;
        return i3 != i16 ? i3 - i16 : bounds.left - bounds2.left;
    }
}

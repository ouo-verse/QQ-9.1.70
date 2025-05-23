package com.tencent.tencentmap.mapsdk.maps.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface OverlayLevel {
    public static final int OverlayLevelAboveBuildings = 1;
    public static final int OverlayLevelAboveLabels = 2;
    public static final int OverlayLevelAboveRoads = 0;
}

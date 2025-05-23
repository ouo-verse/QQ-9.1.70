package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CameraZoomLevelTracker {
    public Float curZoom;
    public final Function0<Unit> onZoomLevelIntChange;

    public CameraZoomLevelTracker(Function0<Unit> function0) {
        this.onZoomLevelIntChange = function0;
    }
}

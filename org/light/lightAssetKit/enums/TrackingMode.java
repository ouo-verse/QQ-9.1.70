package org.light.lightAssetKit.enums;

import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum TrackingMode {
    AR_TRACKER_SURFACE(0, ComponentFactory.ComponentType.SURFACE),
    AR_TRACKER_WORLD(1, "World"),
    AR_TRACKER_GROUND(2, "Ground"),
    AR_TRACKER_ROTATION(6, "Rotation");

    public String name;
    public int value;

    TrackingMode(int i3, String str) {
        this.value = i3;
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class CameraPosition {
    public static final Companion Companion = new Companion();
    public final NBPLatLng bottomLeftPosition;
    public final NBPLatLng bottomRightPosition;
    public final NBPLatLng target;
    public final NBPLatLng topLeftPosition;
    public final NBPLatLng topRightPosition;
    public final float zoomLevel;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final CameraPosition emptyCameraPosition() {
            return new CameraPosition(new NBPLatLng(0.0d, 0.0d, 3, null), -1.0f, new NBPLatLng(0.0d, 0.0d, 3, null), new NBPLatLng(0.0d, 0.0d, 3, null), new NBPLatLng(0.0d, 0.0d, 3, null), new NBPLatLng(0.0d, 0.0d, 3, null));
        }
    }

    public CameraPosition(NBPLatLng nBPLatLng, float f16, NBPLatLng nBPLatLng2, NBPLatLng nBPLatLng3, NBPLatLng nBPLatLng4, NBPLatLng nBPLatLng5) {
        this.target = nBPLatLng;
        this.zoomLevel = f16;
        this.topLeftPosition = nBPLatLng2;
        this.topRightPosition = nBPLatLng3;
        this.bottomLeftPosition = nBPLatLng4;
        this.bottomRightPosition = nBPLatLng5;
    }

    public final int hashCode() {
        return this.bottomRightPosition.hashCode() + ((this.bottomLeftPosition.hashCode() + ((this.topRightPosition.hashCode() + ((this.topLeftPosition.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.zoomLevel, this.target.hashCode() * 31, 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CameraPosition(target=");
        m3.append(this.target);
        m3.append(", zoomLevel=");
        m3.append(this.zoomLevel);
        m3.append(", topLeftPosition=");
        m3.append(this.topLeftPosition);
        m3.append(", topRightPosition=");
        m3.append(this.topRightPosition);
        m3.append(", bottomLeftPosition=");
        m3.append(this.bottomLeftPosition);
        m3.append(", bottomRightPosition=");
        m3.append(this.bottomRightPosition);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return Intrinsics.areEqual(this.target, cameraPosition.target) && Float.compare(this.zoomLevel, cameraPosition.zoomLevel) == 0 && Intrinsics.areEqual(this.topLeftPosition, cameraPosition.topLeftPosition) && Intrinsics.areEqual(this.topRightPosition, cameraPosition.topRightPosition) && Intrinsics.areEqual(this.bottomLeftPosition, cameraPosition.bottomLeftPosition) && Intrinsics.areEqual(this.bottomRightPosition, cameraPosition.bottomRightPosition);
    }
}

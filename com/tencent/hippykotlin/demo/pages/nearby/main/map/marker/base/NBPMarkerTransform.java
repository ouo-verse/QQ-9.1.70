package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMarkerTransform {
    public final a anchor;
    public final u scale;
    public final y translate;

    public /* synthetic */ NBPMarkerTransform(y yVar, u uVar) {
        this(yVar, uVar, a.INSTANCE.a());
    }

    public final int hashCode() {
        return this.anchor.hashCode() + ((this.scale.hashCode() + (this.translate.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPMarkerTransform(translate=");
        m3.append(this.translate);
        m3.append(", scale=");
        m3.append(this.scale);
        m3.append(", anchor=");
        m3.append(this.anchor);
        m3.append(')');
        return m3.toString();
    }

    public NBPMarkerTransform(y yVar, u uVar, a aVar) {
        this.translate = yVar;
        this.scale = uVar;
        this.anchor = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPMarkerTransform)) {
            return false;
        }
        NBPMarkerTransform nBPMarkerTransform = (NBPMarkerTransform) obj;
        return Intrinsics.areEqual(this.translate, nBPMarkerTransform.translate) && Intrinsics.areEqual(this.scale, nBPMarkerTransform.scale) && Intrinsics.areEqual(this.anchor, nBPMarkerTransform.anchor);
    }
}

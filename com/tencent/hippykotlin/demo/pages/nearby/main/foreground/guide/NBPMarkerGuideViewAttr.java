package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPMarkerGuideViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkerGuideViewAttr.class, "tag", "getTag()Lkuikly/com/tencent/trpcprotocol/qqstranger/common/tag/Tag;", 0)};
    public NBPMapMarker marker;
    public final ReadWriteProperty tag$delegate = c.a(null);

    public final NBPMapMarker getMarker() {
        NBPMapMarker nBPMapMarker = this.marker;
        if (nBPMapMarker != null) {
            return nBPMapMarker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("marker");
        return null;
    }
}

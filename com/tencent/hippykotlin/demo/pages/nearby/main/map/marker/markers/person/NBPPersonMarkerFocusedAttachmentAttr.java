package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerStatus;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPPersonMarkerFocusedAttachmentAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPersonMarkerFocusedAttachmentAttr.class, "markerStatus", "getMarkerStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/main/map/marker/base/NBPMarkerStatus;", 0)};
    public final ReadWriteProperty markerStatus$delegate = c.a(NBPMarkerStatus.Normal);
    public List<String> tags;

    public NBPPersonMarkerFocusedAttachmentAttr() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.tags = emptyList;
    }
}

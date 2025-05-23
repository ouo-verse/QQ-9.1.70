package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPPublishCategoryData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishCategoryData.class, "hasRedDot", "getHasRedDot()Z", 0)};
    public final ReadWriteProperty hasRedDot$delegate;

    /* renamed from: id, reason: collision with root package name */
    public final String f114208id;
    public final String name;
    public final String redDotStatusIdListStr;
    public final List<NBPPublishStatusData> statusList;

    public NBPPublishCategoryData() {
        this(null, null, null, null, 15, null);
    }

    public final int hashCode() {
        return this.redDotStatusIdListStr.hashCode() + ((this.statusList.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114208id.hashCode() * 31, 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPPublishCategoryData(id=");
        m3.append(this.f114208id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", statusList=");
        m3.append(this.statusList);
        m3.append(", redDotStatusIdListStr=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.redDotStatusIdListStr, ')');
    }

    public NBPPublishCategoryData(String str, String str2, List<NBPPublishStatusData> list, String str3) {
        this.f114208id = str;
        this.name = str2;
        this.statusList = list;
        this.redDotStatusIdListStr = str3;
        this.hasRedDot$delegate = c.a(Boolean.FALSE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPPublishCategoryData)) {
            return false;
        }
        NBPPublishCategoryData nBPPublishCategoryData = (NBPPublishCategoryData) obj;
        return Intrinsics.areEqual(this.f114208id, nBPPublishCategoryData.f114208id) && Intrinsics.areEqual(this.name, nBPPublishCategoryData.name) && Intrinsics.areEqual(this.statusList, nBPPublishCategoryData.statusList) && Intrinsics.areEqual(this.redDotStatusIdListStr, nBPPublishCategoryData.redDotStatusIdListStr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NBPPublishCategoryData(String str, String str2, List list, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", r2, "");
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
    }
}

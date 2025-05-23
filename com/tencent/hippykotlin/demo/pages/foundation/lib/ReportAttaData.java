package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ReportAttaData {
    public final int cacheMode;
    public final Map<String, String> extMap;
    public final long firstScreen;
    public final String interAct;
    public final int loadMode;
    public final String page;
    public final String attaid = "06f00076856";
    public final String token = "4916318627";
    public final String business = "qqvip";

    public ReportAttaData(String str, long j3, String str2, int i3, Map map, int i16) {
        this.page = str;
        this.firstScreen = j3;
        this.interAct = str2;
        this.cacheMode = i3;
        this.extMap = map;
        this.loadMode = i16;
    }

    public final int hashCode() {
        int ordinal = (BoxType$EnumUnboxingSharedUtility.ordinal(this.cacheMode) + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.interAct, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.firstScreen, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.page, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.business, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.token, this.attaid.hashCode() * 31, 31), 31), 31), 31), 31)) * 31;
        Map<String, String> map = this.extMap;
        int hashCode = (ordinal + (map == null ? 0 : map.hashCode())) * 31;
        int i3 = this.loadMode;
        return hashCode + (i3 != 0 ? BoxType$EnumUnboxingSharedUtility.ordinal(i3) : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ReportAttaData(attaid=");
        m3.append(this.attaid);
        m3.append(", token=");
        m3.append(this.token);
        m3.append(", business=");
        m3.append(this.business);
        m3.append(", page=");
        m3.append(this.page);
        m3.append(", firstScreen=");
        m3.append(this.firstScreen);
        m3.append(", interAct=");
        m3.append(this.interAct);
        m3.append(", cacheMode=");
        m3.append(EnumCacheMode$EnumUnboxingLocalUtility.stringValueOf(this.cacheMode));
        m3.append(", extMap=");
        m3.append(this.extMap);
        m3.append(", loadMode=");
        m3.append(EnumLoadMode$EnumUnboxingLocalUtility.stringValueOf(this.loadMode));
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportAttaData)) {
            return false;
        }
        ReportAttaData reportAttaData = (ReportAttaData) obj;
        return Intrinsics.areEqual(this.attaid, reportAttaData.attaid) && Intrinsics.areEqual(this.token, reportAttaData.token) && Intrinsics.areEqual(this.business, reportAttaData.business) && Intrinsics.areEqual(this.page, reportAttaData.page) && this.firstScreen == reportAttaData.firstScreen && Intrinsics.areEqual(this.interAct, reportAttaData.interAct) && this.cacheMode == reportAttaData.cacheMode && Intrinsics.areEqual(this.extMap, reportAttaData.extMap) && this.loadMode == reportAttaData.loadMode;
    }
}

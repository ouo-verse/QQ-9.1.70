package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Tracker {
    public String appId;
    public e busiInfo;
    public int clickActionId;
    public boolean expose;
    public String itemId;
    public String itemType;
    public String moduleId;
    public String pageId;
    public String positionId;
    public e ruleInfo;
    public final Lazy stayAttr$delegate;
    public String subModuleId;
    public TraceInfo traceInfo;

    public Tracker() {
        this(null, null, null, null, null, null, false, null, null, null, null, 0, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.itemType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.itemId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.subModuleId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.moduleId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.pageId, this.appId.hashCode() * 31, 31), 31), 31), 31), 31);
        boolean z16 = this.expose;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode = (this.busiInfo.hashCode() + ((m3 + i3) * 31)) * 31;
        TraceInfo traceInfo = this.traceInfo;
        return this.clickActionId + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.positionId, (this.ruleInfo.hashCode() + ((hashCode + (traceInfo == null ? 0 : traceInfo.hashCode())) * 31)) * 31, 31);
    }

    public final String toString() {
        return "Tracker(appId=" + this.appId + ", pageId=" + this.pageId + ", moduleId=" + this.moduleId + ", subModuleId=" + this.subModuleId + ", itemId=" + this.itemId + ", itemType=" + this.itemType + ", expose=" + this.expose + ", busiInfo=" + this.busiInfo + ", traceInfo=" + this.traceInfo + ", ruleInfo=" + this.ruleInfo + ", positionId=" + this.positionId + ", clickActionId=" + this.clickActionId + ')';
    }

    public Tracker(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, e eVar, TraceInfo traceInfo, e eVar2, String str7, int i3) {
        Lazy lazy;
        this.appId = str;
        this.pageId = str2;
        this.moduleId = str3;
        this.subModuleId = str4;
        this.itemId = str5;
        this.itemType = str6;
        this.expose = z16;
        this.busiInfo = eVar;
        this.traceInfo = traceInfo;
        this.ruleInfo = eVar2;
        this.positionId = str7;
        this.clickActionId = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.Tracker$stayAttr$2
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(Random.INSTANCE.nextInt(99999));
            }
        });
        this.stayAttr$delegate = lazy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tracker)) {
            return false;
        }
        Tracker tracker = (Tracker) obj;
        return Intrinsics.areEqual(this.appId, tracker.appId) && Intrinsics.areEqual(this.pageId, tracker.pageId) && Intrinsics.areEqual(this.moduleId, tracker.moduleId) && Intrinsics.areEqual(this.subModuleId, tracker.subModuleId) && Intrinsics.areEqual(this.itemId, tracker.itemId) && Intrinsics.areEqual(this.itemType, tracker.itemType) && this.expose == tracker.expose && Intrinsics.areEqual(this.busiInfo, tracker.busiInfo) && Intrinsics.areEqual(this.traceInfo, tracker.traceInfo) && Intrinsics.areEqual(this.ruleInfo, tracker.ruleInfo) && Intrinsics.areEqual(this.positionId, tracker.positionId) && this.clickActionId == tracker.clickActionId;
    }

    public /* synthetic */ Tracker(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, e eVar, TraceInfo traceInfo, e eVar2, String str7, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) != 0 ? "" : str5, (i16 & 32) != 0 ? "" : str6, (i16 & 64) != 0 ? false : z16, (i16 & 128) != 0 ? new e() : eVar, (i16 & 256) != 0 ? null : traceInfo, (i16 & 512) != 0 ? new e() : eVar2, (i16 & 1024) == 0 ? str7 : "", (i16 & 2048) != 0 ? 102 : 0);
    }
}

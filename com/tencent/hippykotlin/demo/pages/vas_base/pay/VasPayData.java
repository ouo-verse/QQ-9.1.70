package com.tencent.hippykotlin.demo.pages.vas_base.pay;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class VasPayData {
    public String aid;
    public List<String> businessType;
    public boolean disableActivity;
    public boolean disablePayResult;
    public boolean isAnimated;
    public boolean isHalfPay;
    public String month;
    public b policyId;
    public String provideUin;
    public String referrer;
    public e traceInfo;
    public String type;

    public VasPayData(String str, String str2, List<String> list, b bVar, String str3, e eVar, String str4, boolean z16, boolean z17, boolean z18, String str5, boolean z19) {
        this.aid = str;
        this.type = str2;
        this.businessType = list;
        this.policyId = bVar;
        this.month = str3;
        this.traceInfo = eVar;
        this.referrer = str4;
        this.isAnimated = z16;
        this.disableActivity = z17;
        this.isHalfPay = z18;
        this.provideUin = str5;
        this.disablePayResult = z19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.businessType.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.type, this.aid.hashCode() * 31, 31)) * 31;
        b bVar = this.policyId;
        int hashCode2 = (hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
        String str = this.month;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        e eVar = this.traceInfo;
        int hashCode4 = (hashCode3 + (eVar == null ? 0 : eVar.hashCode())) * 31;
        String str2 = this.referrer;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.isAnimated;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode5 + i3) * 31;
        boolean z17 = this.disableActivity;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.isHalfPay;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.provideUin, (i18 + i19) * 31, 31);
        boolean z19 = this.disablePayResult;
        return m3 + (z19 ? 1 : z19 ? 1 : 0);
    }

    public final String toString() {
        return "VasPayData(aid=" + this.aid + ", type=" + this.type + ", businessType=" + this.businessType + ", policyId=" + this.policyId + ", month=" + this.month + ", traceInfo=" + this.traceInfo + ", referrer=" + this.referrer + ", isAnimated=" + this.isAnimated + ", disableActivity=" + this.disableActivity + ", isHalfPay=" + this.isHalfPay + ", provideUin=" + this.provideUin + ", disablePayResult=" + this.disablePayResult + ')';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VasPayData)) {
            return false;
        }
        VasPayData vasPayData = (VasPayData) obj;
        return Intrinsics.areEqual(this.aid, vasPayData.aid) && Intrinsics.areEqual(this.type, vasPayData.type) && Intrinsics.areEqual(this.businessType, vasPayData.businessType) && Intrinsics.areEqual(this.policyId, vasPayData.policyId) && Intrinsics.areEqual(this.month, vasPayData.month) && Intrinsics.areEqual(this.traceInfo, vasPayData.traceInfo) && Intrinsics.areEqual(this.referrer, vasPayData.referrer) && this.isAnimated == vasPayData.isAnimated && this.disableActivity == vasPayData.disableActivity && this.isHalfPay == vasPayData.isHalfPay && Intrinsics.areEqual(this.provideUin, vasPayData.provideUin) && this.disablePayResult == vasPayData.disablePayResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ VasPayData(String str, List list, String str2, e eVar, int i3) {
        this(str, "svip", r3, null, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : eVar, (i3 & 64) != 0 ? "" : null, (i3 & 128) != 0, false, (i3 & 512) == 0, (i3 & 1024) != 0 ? "" : null, false);
        List list2;
        List listOf;
        if ((i3 & 4) != 0) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"svip", "vip"});
            list2 = listOf;
        } else {
            list2 = list;
        }
    }
}

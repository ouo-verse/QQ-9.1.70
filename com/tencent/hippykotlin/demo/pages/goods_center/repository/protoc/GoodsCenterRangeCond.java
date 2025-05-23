package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterRangeCond implements ISSOModel {
    public final String errToast;
    public long lower;
    public final String lowerTxt;
    public final long maxLimit;
    public final long minLimit;
    public final String name;
    public final int type;
    public final String unit;
    public long upper;
    public final String upperTxt;

    public GoodsCenterRangeCond() {
        this(0, null, 0L, null, 0L, null, null, 0L, 0L, null, 1023, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        eVar.v("name", this.name);
        eVar.u("lower", this.lower);
        eVar.v("lower_txt", this.lowerTxt);
        eVar.u("upper", this.upper);
        eVar.v("upper_txt", this.upperTxt);
        eVar.v("unit", this.unit);
        eVar.u("min_limit", this.minLimit);
        eVar.u("max_limit", this.maxLimit);
        eVar.v("err_toast", this.errToast);
        return eVar;
    }

    public final int hashCode() {
        return this.errToast.hashCode() + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.maxLimit, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.minLimit, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.unit, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.upperTxt, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.upper, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.lowerTxt, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.lower, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.type * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterRangeCond(type=");
        m3.append(this.type);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", lower=");
        m3.append(this.lower);
        m3.append(", lowerTxt=");
        m3.append(this.lowerTxt);
        m3.append(", upper=");
        m3.append(this.upper);
        m3.append(", upperTxt=");
        m3.append(this.upperTxt);
        m3.append(", unit=");
        m3.append(this.unit);
        m3.append(", minLimit=");
        m3.append(this.minLimit);
        m3.append(", maxLimit=");
        m3.append(this.maxLimit);
        m3.append(", errToast=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.errToast, ')');
    }

    public GoodsCenterRangeCond(int i3, String str, long j3, String str2, long j16, String str3, String str4, long j17, long j18, String str5) {
        this.type = i3;
        this.name = str;
        this.lower = j3;
        this.lowerTxt = str2;
        this.upper = j16;
        this.upperTxt = str3;
        this.unit = str4;
        this.minLimit = j17;
        this.maxLimit = j18;
        this.errToast = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterRangeCond)) {
            return false;
        }
        GoodsCenterRangeCond goodsCenterRangeCond = (GoodsCenterRangeCond) obj;
        return this.type == goodsCenterRangeCond.type && Intrinsics.areEqual(this.name, goodsCenterRangeCond.name) && this.lower == goodsCenterRangeCond.lower && Intrinsics.areEqual(this.lowerTxt, goodsCenterRangeCond.lowerTxt) && this.upper == goodsCenterRangeCond.upper && Intrinsics.areEqual(this.upperTxt, goodsCenterRangeCond.upperTxt) && Intrinsics.areEqual(this.unit, goodsCenterRangeCond.unit) && this.minLimit == goodsCenterRangeCond.minLimit && this.maxLimit == goodsCenterRangeCond.maxLimit && Intrinsics.areEqual(this.errToast, goodsCenterRangeCond.errToast);
    }

    public static GoodsCenterRangeCond copy$default(GoodsCenterRangeCond goodsCenterRangeCond, long j3, long j16, int i3) {
        int i16;
        long j17;
        int i17 = (i3 & 1) != 0 ? goodsCenterRangeCond.type : 0;
        String str = (i3 & 2) != 0 ? goodsCenterRangeCond.name : null;
        long j18 = (i3 & 4) != 0 ? goodsCenterRangeCond.lower : j3;
        String str2 = (i3 & 8) != 0 ? goodsCenterRangeCond.lowerTxt : null;
        long j19 = (i3 & 16) != 0 ? goodsCenterRangeCond.upper : j16;
        String str3 = (i3 & 32) != 0 ? goodsCenterRangeCond.upperTxt : null;
        String str4 = (i3 & 64) != 0 ? goodsCenterRangeCond.unit : null;
        long j26 = (i3 & 128) != 0 ? goodsCenterRangeCond.minLimit : 0L;
        if ((i3 & 256) != 0) {
            i16 = i17;
            j17 = goodsCenterRangeCond.maxLimit;
        } else {
            i16 = i17;
            j17 = 0;
        }
        String str5 = (i3 & 512) != 0 ? goodsCenterRangeCond.errToast : null;
        goodsCenterRangeCond.getClass();
        return new GoodsCenterRangeCond(i16, str, j18, str2, j19, str3, str4, j26, j17, str5);
    }

    public /* synthetic */ GoodsCenterRangeCond(int i3, String str, long j3, String str2, long j16, String str3, String str4, long j17, long j18, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", -1L, "", -1L, "", "", 0L, 0L, "");
    }
}

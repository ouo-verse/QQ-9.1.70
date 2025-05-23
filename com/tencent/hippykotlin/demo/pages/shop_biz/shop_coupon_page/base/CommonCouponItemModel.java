package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CommonCouponItemModel {
    public final String couponTypeName;
    public final String discountStr;
    public final String discountThresholdRule;

    /* renamed from: id, reason: collision with root package name */
    public final String f114301id;
    public final boolean isEnabled;
    public final String issuerId;
    public final String issuerName;
    public final int issuerType;
    public final String usableRange;
    public final String useRule;
    public final String validTime;

    public CommonCouponItemModel(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, boolean z16, String str9) {
        this.f114301id = str;
        this.couponTypeName = str2;
        this.discountStr = str3;
        this.discountThresholdRule = str4;
        this.issuerName = str5;
        this.issuerId = str6;
        this.issuerType = i3;
        this.usableRange = str7;
        this.validTime = str8;
        this.isEnabled = z16;
        this.useRule = str9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.validTime, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.usableRange, QQAudioParams$$ExternalSyntheticOutline0.m(this.issuerType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.issuerId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.issuerName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountThresholdRule, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountStr, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponTypeName, this.f114301id.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
        boolean z16 = this.isEnabled;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m3 + i3) * 31;
        String str = this.useRule;
        return i16 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "CommonCouponItemModel(id=" + this.f114301id + ", couponTypeName=" + this.couponTypeName + ", discountStr=" + this.discountStr + ", discountThresholdRule=" + this.discountThresholdRule + ", issuerName=" + this.issuerName + ", issuerId=" + this.issuerId + ", issuerType=" + this.issuerType + ", usableRange=" + this.usableRange + ", validTime=" + this.validTime + ", isEnabled=" + this.isEnabled + ", useRule=" + this.useRule + ')';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonCouponItemModel)) {
            return false;
        }
        CommonCouponItemModel commonCouponItemModel = (CommonCouponItemModel) obj;
        return Intrinsics.areEqual(this.f114301id, commonCouponItemModel.f114301id) && Intrinsics.areEqual(this.couponTypeName, commonCouponItemModel.couponTypeName) && Intrinsics.areEqual(this.discountStr, commonCouponItemModel.discountStr) && Intrinsics.areEqual(this.discountThresholdRule, commonCouponItemModel.discountThresholdRule) && Intrinsics.areEqual(this.issuerName, commonCouponItemModel.issuerName) && Intrinsics.areEqual(this.issuerId, commonCouponItemModel.issuerId) && this.issuerType == commonCouponItemModel.issuerType && Intrinsics.areEqual(this.usableRange, commonCouponItemModel.usableRange) && Intrinsics.areEqual(this.validTime, commonCouponItemModel.validTime) && this.isEnabled == commonCouponItemModel.isEnabled && Intrinsics.areEqual(this.useRule, commonCouponItemModel.useRule);
    }

    public /* synthetic */ CommonCouponItemModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16) {
        this(str, str2, str3, str4, str5, "", -1, str6, str7, z16, null);
    }
}

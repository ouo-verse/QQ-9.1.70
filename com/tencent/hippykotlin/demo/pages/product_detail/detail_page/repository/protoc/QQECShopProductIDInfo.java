package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QQECShopProductIDInfo implements ISSOModel {
    public final String productID;
    public final String sub_type;
    public final int type;

    public QQECShopProductIDInfo() {
        this(0, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("id", this.type);
        eVar.v("name", this.productID);
        eVar.v("desc", this.sub_type);
        return eVar;
    }

    public final int hashCode() {
        return this.sub_type.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.productID, this.type * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQECShopProductIDInfo(type=");
        m3.append(this.type);
        m3.append(", productID=");
        m3.append(this.productID);
        m3.append(", sub_type=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.sub_type, ')');
    }

    public QQECShopProductIDInfo(int i3, String str, String str2) {
        this.type = i3;
        this.productID = str;
        this.sub_type = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QQECShopProductIDInfo)) {
            return false;
        }
        QQECShopProductIDInfo qQECShopProductIDInfo = (QQECShopProductIDInfo) obj;
        return this.type == qQECShopProductIDInfo.type && Intrinsics.areEqual(this.productID, qQECShopProductIDInfo.productID) && Intrinsics.areEqual(this.sub_type, qQECShopProductIDInfo.sub_type);
    }

    public /* synthetic */ QQECShopProductIDInfo(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "");
    }
}

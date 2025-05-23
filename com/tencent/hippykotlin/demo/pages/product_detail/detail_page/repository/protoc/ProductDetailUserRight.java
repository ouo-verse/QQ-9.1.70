package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailUserRight implements ISSOModel {
    public final String roleDesc;
    public final int roleId;
    public final String roleName;

    public ProductDetailUserRight() {
        this(0, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("role_id", this.roleId);
        eVar.v("role_name", this.roleName);
        eVar.v("role_desc", this.roleDesc);
        return eVar;
    }

    public final int hashCode() {
        return this.roleDesc.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.roleName, this.roleId * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailUserRight(roleId=");
        m3.append(this.roleId);
        m3.append(", roleName=");
        m3.append(this.roleName);
        m3.append(", roleDesc=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.roleDesc, ')');
    }

    public ProductDetailUserRight(int i3, String str, String str2) {
        this.roleId = i3;
        this.roleName = str;
        this.roleDesc = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailUserRight)) {
            return false;
        }
        ProductDetailUserRight productDetailUserRight = (ProductDetailUserRight) obj;
        return this.roleId == productDetailUserRight.roleId && Intrinsics.areEqual(this.roleName, productDetailUserRight.roleName) && Intrinsics.areEqual(this.roleDesc, productDetailUserRight.roleDesc);
    }

    public /* synthetic */ ProductDetailUserRight(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "");
    }
}

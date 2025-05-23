package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.xweb.FileReaderHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailBulletin implements ISSOModel {
    public final String icon;
    public final String txt;

    public ProductDetailBulletin() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v(FileReaderHelper.TXT_EXT, this.txt);
        eVar.v("icon", this.icon);
        return eVar;
    }

    public final int hashCode() {
        return this.icon.hashCode() + (this.txt.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailBulletin(txt=");
        m3.append(this.txt);
        m3.append(", icon=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.icon, ')');
    }

    public ProductDetailBulletin(String str, String str2) {
        this.txt = str;
        this.icon = str2;
    }

    public /* synthetic */ ProductDetailBulletin(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailBulletin)) {
            return false;
        }
        ProductDetailBulletin productDetailBulletin = (ProductDetailBulletin) obj;
        return Intrinsics.areEqual(this.txt, productDetailBulletin.txt) && Intrinsics.areEqual(this.icon, productDetailBulletin.icon);
    }
}

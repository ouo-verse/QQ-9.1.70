package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.xweb.FileReaderHelper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailButtonItem implements ISSOModel {
    public final int buttonType;
    public final String desc;
    public final String icon;
    public final String jumpUrl;
    public final String txt;

    public ProductDetailButtonItem() {
        this(null, 31);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("button_type", this.buttonType);
        eVar.v(FileReaderHelper.TXT_EXT, this.txt);
        eVar.v("jump_url", this.jumpUrl);
        eVar.v("icon", this.icon);
        eVar.v("desc", this.desc);
        return eVar;
    }

    public final int hashCode() {
        return this.desc.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.jumpUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.txt, this.buttonType * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailButtonItem(buttonType=");
        m3.append(this.buttonType);
        m3.append(", txt=");
        m3.append(this.txt);
        m3.append(", jumpUrl=");
        m3.append(this.jumpUrl);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", desc=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.desc, ')');
    }

    public ProductDetailButtonItem(int i3, String str, String str2, String str3, String str4) {
        this.buttonType = i3;
        this.txt = str;
        this.jumpUrl = str2;
        this.icon = str3;
        this.desc = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailButtonItem)) {
            return false;
        }
        ProductDetailButtonItem productDetailButtonItem = (ProductDetailButtonItem) obj;
        return this.buttonType == productDetailButtonItem.buttonType && Intrinsics.areEqual(this.txt, productDetailButtonItem.txt) && Intrinsics.areEqual(this.jumpUrl, productDetailButtonItem.jumpUrl) && Intrinsics.areEqual(this.icon, productDetailButtonItem.icon) && Intrinsics.areEqual(this.desc, productDetailButtonItem.desc);
    }

    public /* synthetic */ ProductDetailButtonItem(String str, int i3) {
        this(0, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : null, (i3 & 8) != 0 ? "" : null, (i3 & 16) != 0 ? "" : null);
    }
}

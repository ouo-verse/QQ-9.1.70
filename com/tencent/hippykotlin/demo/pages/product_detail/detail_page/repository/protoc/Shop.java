package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Shop implements ISSOModel {
    public final ButtonItem button;
    public final ShopDynamic dynamic;
    public final String icon;

    /* renamed from: id, reason: collision with root package name */
    public final String f114245id;
    public final String name;

    public Shop() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114245id);
        eVar.v("name", this.name);
        eVar.v("icon", this.icon);
        ButtonItem buttonItem = this.button;
        if (buttonItem != null) {
            eVar.v("button", buttonItem.encode());
        }
        ShopDynamic shopDynamic = this.dynamic;
        if (shopDynamic != null) {
            eVar.v(TabPreloadItem.TAB_NAME_DYNAMIC, shopDynamic.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114245id.hashCode() * 31, 31), 31);
        ButtonItem buttonItem = this.button;
        int hashCode = (m3 + (buttonItem == null ? 0 : buttonItem.hashCode())) * 31;
        ShopDynamic shopDynamic = this.dynamic;
        return hashCode + (shopDynamic != null ? shopDynamic.sales.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Shop(id=");
        m3.append(this.f114245id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", button=");
        m3.append(this.button);
        m3.append(", dynamic=");
        m3.append(this.dynamic);
        m3.append(')');
        return m3.toString();
    }

    public Shop(String str, String str2, String str3, ButtonItem buttonItem, ShopDynamic shopDynamic) {
        this.f114245id = str;
        this.name = str2;
        this.icon = str3;
        this.button = buttonItem;
        this.dynamic = shopDynamic;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shop)) {
            return false;
        }
        Shop shop = (Shop) obj;
        return Intrinsics.areEqual(this.f114245id, shop.f114245id) && Intrinsics.areEqual(this.name, shop.name) && Intrinsics.areEqual(this.icon, shop.icon) && Intrinsics.areEqual(this.button, shop.button) && Intrinsics.areEqual(this.dynamic, shop.dynamic);
    }

    public /* synthetic */ Shop(String str, String str2, String str3, ButtonItem buttonItem, ShopDynamic shopDynamic, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", null, null);
    }
}

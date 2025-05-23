package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailSpecInfo implements ISSOModel {
    public final ArrayList<ProductDetailSpecItem> items;

    public ProductDetailSpecInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ProductDetailSpecItem> arrayList = this.items;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ProductDetailSpecItem) it.next()).encode());
            }
        }
        eVar.v("items", bVar);
        return eVar;
    }

    public final int hashCode() {
        ArrayList<ProductDetailSpecItem> arrayList = this.items;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailSpecInfo(items=");
        m3.append(this.items);
        m3.append(')');
        return m3.toString();
    }

    public ProductDetailSpecInfo(ArrayList<ProductDetailSpecItem> arrayList) {
        this.items = arrayList;
    }

    public /* synthetic */ ProductDetailSpecInfo(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductDetailSpecInfo) && Intrinsics.areEqual(this.items, ((ProductDetailSpecInfo) obj).items);
    }
}

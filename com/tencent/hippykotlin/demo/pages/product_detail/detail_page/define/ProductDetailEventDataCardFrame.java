package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.layout.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailEventDataCardFrame {
    public final d frame;

    public ProductDetailEventDataCardFrame(d dVar) {
        this.frame = dVar;
    }

    public final int hashCode() {
        return this.frame.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailEventDataCardFrame(frame=");
        m3.append(this.frame);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductDetailEventDataCardFrame) && Intrinsics.areEqual(this.frame, ((ProductDetailEventDataCardFrame) obj).frame);
    }
}

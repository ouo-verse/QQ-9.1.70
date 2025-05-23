package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQECShopCoupon implements ISSOModel {
    public final String desc;

    /* renamed from: id, reason: collision with root package name */
    public final String f114244id;
    public final String name;

    public QQECShopCoupon() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114244id);
        eVar.v("name", this.name);
        eVar.v("desc", this.desc);
        return eVar;
    }

    public final int hashCode() {
        return this.desc.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114244id.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQECShopCoupon(id=");
        m3.append(this.f114244id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", desc=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.desc, ')');
    }

    public QQECShopCoupon(String str, String str2, String str3) {
        this.f114244id = str;
        this.name = str2;
        this.desc = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QQECShopCoupon)) {
            return false;
        }
        QQECShopCoupon qQECShopCoupon = (QQECShopCoupon) obj;
        return Intrinsics.areEqual(this.f114244id, qQECShopCoupon.f114244id) && Intrinsics.areEqual(this.name, qQECShopCoupon.name) && Intrinsics.areEqual(this.desc, qQECShopCoupon.desc);
    }

    public /* synthetic */ QQECShopCoupon(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }
}

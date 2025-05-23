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
public final class Category implements ISSOModel {
    public final String fifthCatId;
    public final String fifthCatName;
    public final String firstCatId;
    public final String firstCatName;
    public final String forthCatId;
    public final String forthCatName;
    public final String secondCatId;
    public final String secondCatName;
    public final String thirdCatId;
    public final String thirdCatName;

    public Category() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("first_cat_id", this.firstCatId);
        eVar.v("first_cat_name", this.firstCatName);
        eVar.v("second_cat_id", this.secondCatId);
        eVar.v("second_cat_name", this.secondCatName);
        eVar.v("third_cat_id", this.thirdCatId);
        eVar.v("third_cat_name", this.thirdCatName);
        eVar.v("forth_cat_id", this.forthCatId);
        eVar.v("forth_cat_name", this.forthCatName);
        eVar.v("fifth_cat_id", this.fifthCatId);
        eVar.v("fifth_cat_name", this.fifthCatName);
        return eVar;
    }

    public final int hashCode() {
        return this.fifthCatName.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.fifthCatId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.forthCatName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.forthCatId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.thirdCatName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.thirdCatId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.secondCatName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.secondCatId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.firstCatName, this.firstCatId.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Category(firstCatId=");
        m3.append(this.firstCatId);
        m3.append(", firstCatName=");
        m3.append(this.firstCatName);
        m3.append(", secondCatId=");
        m3.append(this.secondCatId);
        m3.append(", secondCatName=");
        m3.append(this.secondCatName);
        m3.append(", thirdCatId=");
        m3.append(this.thirdCatId);
        m3.append(", thirdCatName=");
        m3.append(this.thirdCatName);
        m3.append(", forthCatId=");
        m3.append(this.forthCatId);
        m3.append(", forthCatName=");
        m3.append(this.forthCatName);
        m3.append(", fifthCatId=");
        m3.append(this.fifthCatId);
        m3.append(", fifthCatName=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.fifthCatName, ')');
    }

    public Category(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.firstCatId = str;
        this.firstCatName = str2;
        this.secondCatId = str3;
        this.secondCatName = str4;
        this.thirdCatId = str5;
        this.thirdCatName = str6;
        this.forthCatId = str7;
        this.forthCatName = str8;
        this.fifthCatId = str9;
        this.fifthCatName = str10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return Intrinsics.areEqual(this.firstCatId, category.firstCatId) && Intrinsics.areEqual(this.firstCatName, category.firstCatName) && Intrinsics.areEqual(this.secondCatId, category.secondCatId) && Intrinsics.areEqual(this.secondCatName, category.secondCatName) && Intrinsics.areEqual(this.thirdCatId, category.thirdCatId) && Intrinsics.areEqual(this.thirdCatName, category.thirdCatName) && Intrinsics.areEqual(this.forthCatId, category.forthCatId) && Intrinsics.areEqual(this.forthCatName, category.forthCatName) && Intrinsics.areEqual(this.fifthCatId, category.fifthCatId) && Intrinsics.areEqual(this.fifthCatName, category.fifthCatName);
    }

    public /* synthetic */ Category(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", "", "", "", "", "");
    }
}

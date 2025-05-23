package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewAtData implements ISSOModel {
    public final String avatar;
    public final String content;
    public final String homepage;
    public final String nickName;
    public final String uid;

    public ProductReviewAtData() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("uid", this.uid);
        eVar.v(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, this.nickName);
        eVar.v("avatar", this.avatar);
        eVar.v("homepage", this.homepage);
        eVar.v("content", this.content);
        return eVar;
    }

    public final int hashCode() {
        return this.content.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.homepage, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.avatar, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.nickName, this.uid.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductReviewAtData(uid=");
        m3.append(this.uid);
        m3.append(", nickName=");
        m3.append(this.nickName);
        m3.append(", avatar=");
        m3.append(this.avatar);
        m3.append(", homepage=");
        m3.append(this.homepage);
        m3.append(", content=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.content, ')');
    }

    public ProductReviewAtData(String str, String str2, String str3, String str4, String str5) {
        this.uid = str;
        this.nickName = str2;
        this.avatar = str3;
        this.homepage = str4;
        this.content = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductReviewAtData)) {
            return false;
        }
        ProductReviewAtData productReviewAtData = (ProductReviewAtData) obj;
        return Intrinsics.areEqual(this.uid, productReviewAtData.uid) && Intrinsics.areEqual(this.nickName, productReviewAtData.nickName) && Intrinsics.areEqual(this.avatar, productReviewAtData.avatar) && Intrinsics.areEqual(this.homepage, productReviewAtData.homepage) && Intrinsics.areEqual(this.content, productReviewAtData.content);
    }

    public /* synthetic */ ProductReviewAtData(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "");
    }
}

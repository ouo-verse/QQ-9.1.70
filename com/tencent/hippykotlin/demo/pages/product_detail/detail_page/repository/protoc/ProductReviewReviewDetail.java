package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewRptData;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewReviewDetail implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final long createTime;
    public final int logisticsQualityScore;
    public final String orderId;
    public final ArrayList<String> pictureUrls;
    public final ProductReviewReviewProductID productId;
    public final int productQualityScore;
    public final String productSpecification;
    public final ArrayList<ProductReviewRptData> reviewContent;
    public final String reviewId;
    public final int reviewType;
    public final int shopQualityScore;
    public final ArrayList<String> thumbPictureUrls;
    public final String userIcon;
    public final String userId;
    public final String userNick;

    public ProductReviewReviewDetail() {
        this(null, null, null, 0, null, null, null, null, null, null, null, 0L, 0, 0, 0, 32767, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("review_id", this.reviewId);
        ProductReviewReviewProductID productReviewReviewProductID = this.productId;
        if (productReviewReviewProductID != null) {
            eVar.v(ReportDataBuilder.KEY_PRODUCT_ID, productReviewReviewProductID.encode());
        }
        eVar.v("order_id", this.orderId);
        eVar.t("review_type", this.reviewType);
        eVar.v("user_id", this.userId);
        eVar.v("user_nick", this.userNick);
        b a16 = o.a(eVar, "user_icon", this.userIcon);
        ArrayList<ProductReviewRptData> arrayList = this.reviewContent;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((ProductReviewRptData) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "review_content", a16);
        ArrayList<String> arrayList2 = this.pictureUrls;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t((String) it5.next());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "picture_urls", m3);
        ArrayList<String> arrayList3 = this.thumbPictureUrls;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t((String) it6.next());
            }
        }
        eVar.v("thumb_picture_urls", m16);
        eVar.v("product_specification", this.productSpecification);
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        eVar.t("product_quality_score", this.productQualityScore);
        eVar.t("logistics_quality_score", this.logisticsQualityScore);
        eVar.t("shop_quality_score", this.shopQualityScore);
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.reviewId.hashCode() * 31;
        ProductReviewReviewProductID productReviewReviewProductID = this.productId;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userIcon, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userNick, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userId, QQAudioParams$$ExternalSyntheticOutline0.m(this.reviewType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.orderId, (hashCode + (productReviewReviewProductID == null ? 0 : productReviewReviewProductID.hashCode())) * 31, 31), 31), 31), 31), 31);
        ArrayList<ProductReviewRptData> arrayList = this.reviewContent;
        int hashCode2 = (m3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<String> arrayList2 = this.pictureUrls;
        int hashCode3 = (hashCode2 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<String> arrayList3 = this.thumbPictureUrls;
        return this.shopQualityScore + QQAudioParams$$ExternalSyntheticOutline0.m(this.logisticsQualityScore, QQAudioParams$$ExternalSyntheticOutline0.m(this.productQualityScore, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.createTime, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.productSpecification, (hashCode3 + (arrayList3 != null ? arrayList3.hashCode() : 0)) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "ProductReviewReviewDetail(reviewId=" + this.reviewId + ", productId=" + this.productId + ", orderId=" + this.orderId + ", reviewType=" + this.reviewType + ", userId=" + this.userId + ", userNick=" + this.userNick + ", userIcon=" + this.userIcon + ", reviewContent=" + this.reviewContent + ", pictureUrls=" + this.pictureUrls + ", thumbPictureUrls=" + this.thumbPictureUrls + ", productSpecification=" + this.productSpecification + ", createTime=" + this.createTime + ", productQualityScore=" + this.productQualityScore + ", logisticsQualityScore=" + this.logisticsQualityScore + ", shopQualityScore=" + this.shopQualityScore + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ProductReviewReviewDetail decode(e eVar) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            String q16 = eVar.q("review_id", "");
            e m3 = eVar.m(ReportDataBuilder.KEY_PRODUCT_ID);
            ProductReviewReviewProductID productReviewReviewProductID = m3 != null ? new ProductReviewReviewProductID(m3.q("spu_id", ""), m3.q("sku_id", "")) : null;
            String q17 = eVar.q("order_id", "");
            int k3 = eVar.k("review_type", 0);
            String q18 = eVar.q("user_id", "");
            String q19 = eVar.q("user_nick", "");
            String q26 = eVar.q("user_icon", "");
            b l3 = eVar.l("review_content");
            if (l3 != null) {
                ArrayList arrayList4 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        ProductReviewRptData.Companion companion = ProductReviewRptData.Companion;
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList4.add(companion.decode((e) d16));
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            b l16 = eVar.l("picture_urls");
            if (l16 != null) {
                ArrayList arrayList5 = new ArrayList();
                int c17 = l16.c();
                for (int i16 = 0; i16 < c17; i16++) {
                    String o16 = l16.o(i16);
                    if (o16 != null) {
                        arrayList5.add(o16);
                    }
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = null;
            }
            b l17 = eVar.l("thumb_picture_urls");
            if (l17 != null) {
                ArrayList arrayList6 = new ArrayList();
                int c18 = l17.c();
                for (int i17 = 0; i17 < c18; i17++) {
                    String o17 = l17.o(i17);
                    if (o17 != null) {
                        arrayList6.add(o17);
                    }
                }
                arrayList3 = arrayList6;
            } else {
                arrayList3 = null;
            }
            return new ProductReviewReviewDetail(q16, productReviewReviewProductID, q17, k3, q18, q19, q26, arrayList, arrayList2, arrayList3, eVar.q("product_specification", ""), eVar.o(AlbumCacheData.CREATE_TIME, 0L), eVar.k("product_quality_score", 0), eVar.k("logistics_quality_score", 0), eVar.k("shop_quality_score", 0));
        }
    }

    public ProductReviewReviewDetail(String str, ProductReviewReviewProductID productReviewReviewProductID, String str2, int i3, String str3, String str4, String str5, ArrayList<ProductReviewRptData> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str6, long j3, int i16, int i17, int i18) {
        this.reviewId = str;
        this.productId = productReviewReviewProductID;
        this.orderId = str2;
        this.reviewType = i3;
        this.userId = str3;
        this.userNick = str4;
        this.userIcon = str5;
        this.reviewContent = arrayList;
        this.pictureUrls = arrayList2;
        this.thumbPictureUrls = arrayList3;
        this.productSpecification = str6;
        this.createTime = j3;
        this.productQualityScore = i16;
        this.logisticsQualityScore = i17;
        this.shopQualityScore = i18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductReviewReviewDetail)) {
            return false;
        }
        ProductReviewReviewDetail productReviewReviewDetail = (ProductReviewReviewDetail) obj;
        return Intrinsics.areEqual(this.reviewId, productReviewReviewDetail.reviewId) && Intrinsics.areEqual(this.productId, productReviewReviewDetail.productId) && Intrinsics.areEqual(this.orderId, productReviewReviewDetail.orderId) && this.reviewType == productReviewReviewDetail.reviewType && Intrinsics.areEqual(this.userId, productReviewReviewDetail.userId) && Intrinsics.areEqual(this.userNick, productReviewReviewDetail.userNick) && Intrinsics.areEqual(this.userIcon, productReviewReviewDetail.userIcon) && Intrinsics.areEqual(this.reviewContent, productReviewReviewDetail.reviewContent) && Intrinsics.areEqual(this.pictureUrls, productReviewReviewDetail.pictureUrls) && Intrinsics.areEqual(this.thumbPictureUrls, productReviewReviewDetail.thumbPictureUrls) && Intrinsics.areEqual(this.productSpecification, productReviewReviewDetail.productSpecification) && this.createTime == productReviewReviewDetail.createTime && this.productQualityScore == productReviewReviewDetail.productQualityScore && this.logisticsQualityScore == productReviewReviewDetail.logisticsQualityScore && this.shopQualityScore == productReviewReviewDetail.shopQualityScore;
    }

    public /* synthetic */ ProductReviewReviewDetail(String str, ProductReviewReviewProductID productReviewReviewProductID, String str2, int i3, String str3, String str4, String str5, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, String str6, long j3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "", 0, "", "", "", null, null, null, "", 0L, 0, 0, 0);
    }
}

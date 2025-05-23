package com.tencent.ecommerce.repo.comment;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b#\u0010$Jk\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0017\u0010\u000e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\u001e\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/a;", "", "Lcom/tencent/ecommerce/repo/comment/g;", "productInfo", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "Lcom/tencent/ecommerce/repo/comment/h;", "commentTextList", "imageUrls", "productSpecification", "", "produceQualityScore", "logisticsServiceScore", "shopServiceScore", "a", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/comment/g;", "b", "Ljava/lang/String;", "c", "Ljava/util/List;", "()Ljava/util/List;", "d", "e", "f", UserInfo.SEX_FEMALE, "g", tl.h.F, "()F", "<init>", "(Lcom/tencent/ecommerce/repo/comment/g;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;FFF)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.comment.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECQShopOrderCommentInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ProductInfo productInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<h> commentTextList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> imageUrls;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> productSpecification;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final float produceQualityScore;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final float logisticsServiceScore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final float shopServiceScore;

    /* JADX WARN: Multi-variable type inference failed */
    public ECQShopOrderCommentInfo(ProductInfo productInfo, String str, List<? extends h> list, List<String> list2, List<String> list3, float f16, float f17, float f18) {
        this.productInfo = productInfo;
        this.orderId = str;
        this.commentTextList = list;
        this.imageUrls = list2;
        this.productSpecification = list3;
        this.produceQualityScore = f16;
        this.logisticsServiceScore = f17;
        this.shopServiceScore = f18;
    }

    public final ECQShopOrderCommentInfo a(ProductInfo productInfo, String orderId, List<? extends h> commentTextList, List<String> imageUrls, List<String> productSpecification, float produceQualityScore, float logisticsServiceScore, float shopServiceScore) {
        return new ECQShopOrderCommentInfo(productInfo, orderId, commentTextList, imageUrls, productSpecification, produceQualityScore, logisticsServiceScore, shopServiceScore);
    }

    public final List<h> c() {
        return this.commentTextList;
    }

    public final List<String> d() {
        return this.imageUrls;
    }

    public final List<String> e() {
        return this.productSpecification;
    }

    /* renamed from: f, reason: from getter */
    public final float getShopServiceScore() {
        return this.shopServiceScore;
    }

    public int hashCode() {
        ProductInfo productInfo = this.productInfo;
        int hashCode = (productInfo != null ? productInfo.hashCode() : 0) * 31;
        String str = this.orderId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<h> list = this.commentTextList;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.imageUrls;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.productSpecification;
        return ((((((hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31) + Float.floatToIntBits(this.produceQualityScore)) * 31) + Float.floatToIntBits(this.logisticsServiceScore)) * 31) + Float.floatToIntBits(this.shopServiceScore);
    }

    public String toString() {
        return "ECQShopOrderCommentInfo(productInfo=" + this.productInfo + ", orderId=" + this.orderId + ", commentTextList=" + this.commentTextList + ", imageUrls=" + this.imageUrls + ", productSpecification=" + this.productSpecification + ", produceQualityScore=" + this.produceQualityScore + ", logisticsServiceScore=" + this.logisticsServiceScore + ", shopServiceScore=" + this.shopServiceScore + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECQShopOrderCommentInfo)) {
            return false;
        }
        ECQShopOrderCommentInfo eCQShopOrderCommentInfo = (ECQShopOrderCommentInfo) other;
        return Intrinsics.areEqual(this.productInfo, eCQShopOrderCommentInfo.productInfo) && Intrinsics.areEqual(this.orderId, eCQShopOrderCommentInfo.orderId) && Intrinsics.areEqual(this.commentTextList, eCQShopOrderCommentInfo.commentTextList) && Intrinsics.areEqual(this.imageUrls, eCQShopOrderCommentInfo.imageUrls) && Intrinsics.areEqual(this.productSpecification, eCQShopOrderCommentInfo.productSpecification) && Float.compare(this.produceQualityScore, eCQShopOrderCommentInfo.produceQualityScore) == 0 && Float.compare(this.logisticsServiceScore, eCQShopOrderCommentInfo.logisticsServiceScore) == 0 && Float.compare(this.shopServiceScore, eCQShopOrderCommentInfo.shopServiceScore) == 0;
    }
}

package com.tencent.ecommerce.repo.comment;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u0010/\u001a\u00020\u0004\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u001dR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\f\u0010\u001dR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u0010\u0010\u001dR\u0014\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\nR\u0014\u0010(\u001a\u00020%8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010,\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u0017R\u0017\u0010/\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u0017\u001a\u0004\b\u000e\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "nickName", "b", "userId", "c", "userIconUrl", "d", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "e", "spuId", "f", "skuId", "g", "I", "reviewType", "", "Lcom/tencent/ecommerce/repo/comment/h;", tl.h.F, "Ljava/util/List;", "()Ljava/util/List;", "commentTextList", "i", "imageUrls", "j", "thumbnailImageUrls", "k", "productSpecification", "", "l", "J", "createTimeMs", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "productQualityScore", DomainData.DOMAIN_NAME, "logisticsQualityScore", "o", "()I", "shopQualityScore", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;JIII)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.comment.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECQShopOrderReviewCommentInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String nickName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String userId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String userIconUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String skuId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final int reviewType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<h> commentTextList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> imageUrls;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> thumbnailImageUrls;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productSpecification;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final long createTimeMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final int productQualityScore;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final int logisticsQualityScore;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final int shopQualityScore;

    public final List<h> a() {
        return this.commentTextList;
    }

    public final List<String> b() {
        return this.imageUrls;
    }

    /* renamed from: c, reason: from getter */
    public final int getShopQualityScore() {
        return this.shopQualityScore;
    }

    public final List<String> d() {
        return this.thumbnailImageUrls;
    }

    public int hashCode() {
        String str = this.nickName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.userIconUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.orderId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.spuId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.skuId;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.reviewType) * 31;
        List<h> list = this.commentTextList;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.imageUrls;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.thumbnailImageUrls;
        int hashCode9 = (hashCode8 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str7 = this.productSpecification;
        return ((((((((hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.createTimeMs)) * 31) + this.productQualityScore) * 31) + this.logisticsQualityScore) * 31) + this.shopQualityScore;
    }

    public String toString() {
        return "ECQShopOrderReviewCommentInfo(nickName=" + this.nickName + ", userId=" + this.userId + ", userIconUrl=" + this.userIconUrl + ", orderId=" + this.orderId + ", spuId=" + this.spuId + ", skuId=" + this.skuId + ", reviewType=" + this.reviewType + ", commentTextList=" + this.commentTextList + ", imageUrls=" + this.imageUrls + ", thumbnailImageUrls=" + this.thumbnailImageUrls + ", productSpecification=" + this.productSpecification + ", createTimeMs=" + this.createTimeMs + ", productQualityScore=" + this.productQualityScore + ", logisticsQualityScore=" + this.logisticsQualityScore + ", shopQualityScore=" + this.shopQualityScore + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECQShopOrderReviewCommentInfo(String str, String str2, String str3, String str4, String str5, String str6, int i3, List<? extends h> list, List<String> list2, List<String> list3, String str7, long j3, int i16, int i17, int i18) {
        this.nickName = str;
        this.userId = str2;
        this.userIconUrl = str3;
        this.orderId = str4;
        this.spuId = str5;
        this.skuId = str6;
        this.reviewType = i3;
        this.commentTextList = list;
        this.imageUrls = list2;
        this.thumbnailImageUrls = list3;
        this.productSpecification = str7;
        this.createTimeMs = j3;
        this.productQualityScore = i16;
        this.logisticsQualityScore = i17;
        this.shopQualityScore = i18;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECQShopOrderReviewCommentInfo)) {
            return false;
        }
        ECQShopOrderReviewCommentInfo eCQShopOrderReviewCommentInfo = (ECQShopOrderReviewCommentInfo) other;
        return Intrinsics.areEqual(this.nickName, eCQShopOrderReviewCommentInfo.nickName) && Intrinsics.areEqual(this.userId, eCQShopOrderReviewCommentInfo.userId) && Intrinsics.areEqual(this.userIconUrl, eCQShopOrderReviewCommentInfo.userIconUrl) && Intrinsics.areEqual(this.orderId, eCQShopOrderReviewCommentInfo.orderId) && Intrinsics.areEqual(this.spuId, eCQShopOrderReviewCommentInfo.spuId) && Intrinsics.areEqual(this.skuId, eCQShopOrderReviewCommentInfo.skuId) && this.reviewType == eCQShopOrderReviewCommentInfo.reviewType && Intrinsics.areEqual(this.commentTextList, eCQShopOrderReviewCommentInfo.commentTextList) && Intrinsics.areEqual(this.imageUrls, eCQShopOrderReviewCommentInfo.imageUrls) && Intrinsics.areEqual(this.thumbnailImageUrls, eCQShopOrderReviewCommentInfo.thumbnailImageUrls) && Intrinsics.areEqual(this.productSpecification, eCQShopOrderReviewCommentInfo.productSpecification) && this.createTimeMs == eCQShopOrderReviewCommentInfo.createTimeMs && this.productQualityScore == eCQShopOrderReviewCommentInfo.productQualityScore && this.logisticsQualityScore == eCQShopOrderReviewCommentInfo.logisticsQualityScore && this.shopQualityScore == eCQShopOrderReviewCommentInfo.shopQualityScore;
    }
}

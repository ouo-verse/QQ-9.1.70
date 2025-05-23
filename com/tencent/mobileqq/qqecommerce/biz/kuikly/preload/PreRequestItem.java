package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\n\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType;", "a", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType;", "b", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType;", "requestType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/g;", "c", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/g;", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/g;", "ssoRequestData", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/c;", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/c;", "httpRequestItem", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestType;Ljava/lang/String;Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/g;Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/c;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.e, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class PreRequestItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final RequestType requestType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uniqueId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final g ssoRequestData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final HttpRequestItem httpRequestItem;

    public PreRequestItem(RequestType requestType, String uniqueId, g gVar, HttpRequestItem httpRequestItem) {
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        this.requestType = requestType;
        this.uniqueId = uniqueId;
        this.ssoRequestData = gVar;
        this.httpRequestItem = httpRequestItem;
    }

    /* renamed from: a, reason: from getter */
    public final HttpRequestItem getHttpRequestItem() {
        return this.httpRequestItem;
    }

    /* renamed from: b, reason: from getter */
    public final RequestType getRequestType() {
        return this.requestType;
    }

    /* renamed from: c, reason: from getter */
    public final g getSsoRequestData() {
        return this.ssoRequestData;
    }

    /* renamed from: d, reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    public int hashCode() {
        int hashCode = ((this.requestType.hashCode() * 31) + this.uniqueId.hashCode()) * 31;
        g gVar = this.ssoRequestData;
        int hashCode2 = (hashCode + (gVar == null ? 0 : gVar.hashCode())) * 31;
        HttpRequestItem httpRequestItem = this.httpRequestItem;
        return hashCode2 + (httpRequestItem != null ? httpRequestItem.hashCode() : 0);
    }

    public String toString() {
        return "PreRequestItem(requestType=" + this.requestType + ", uniqueId=" + this.uniqueId + ", ssoRequestData=" + this.ssoRequestData + ", httpRequestItem=" + this.httpRequestItem + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreRequestItem)) {
            return false;
        }
        PreRequestItem preRequestItem = (PreRequestItem) other;
        return this.requestType == preRequestItem.requestType && Intrinsics.areEqual(this.uniqueId, preRequestItem.uniqueId) && Intrinsics.areEqual(this.ssoRequestData, preRequestItem.ssoRequestData) && Intrinsics.areEqual(this.httpRequestItem, preRequestItem.httpRequestItem);
    }
}

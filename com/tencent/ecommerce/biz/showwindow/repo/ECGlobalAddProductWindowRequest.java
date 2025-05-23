package com.tencent.ecommerce.biz.showwindow.repo;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\t\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setSaasTypeStr", "(Ljava/lang/String;)V", "saasTypeStr", "b", "setSaasProductId", "saasProductId", "I", "()I", "setGoodsType", "(I)V", "goodsType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.showwindow.repo.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECGlobalAddProductWindowRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasTypeStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int goodsType;

    public ECGlobalAddProductWindowRequest() {
        this(null, null, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: b, reason: from getter */
    public final String getSaasProductId() {
        return this.saasProductId;
    }

    /* renamed from: c, reason: from getter */
    public final String getSaasTypeStr() {
        return this.saasTypeStr;
    }

    public int hashCode() {
        String str = this.saasTypeStr;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.saasProductId;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.goodsType;
    }

    public String toString() {
        return "ECGlobalAddProductWindowRequest(saasTypeStr=" + this.saasTypeStr + ", saasProductId=" + this.saasProductId + ", goodsType=" + this.goodsType + ")";
    }

    public ECGlobalAddProductWindowRequest(String str, String str2, int i3) {
        this.saasTypeStr = str;
        this.saasProductId = str2;
        this.goodsType = i3;
    }

    public /* synthetic */ ECGlobalAddProductWindowRequest(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 1 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECGlobalAddProductWindowRequest)) {
            return false;
        }
        ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest = (ECGlobalAddProductWindowRequest) other;
        return Intrinsics.areEqual(this.saasTypeStr, eCGlobalAddProductWindowRequest.saasTypeStr) && Intrinsics.areEqual(this.saasProductId, eCGlobalAddProductWindowRequest.saasProductId) && this.goodsType == eCGlobalAddProductWindowRequest.goodsType;
    }
}

package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.ecommerce.base.list.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/c;", "Lcom/tencent/ecommerce/base/list/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "keyword", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "d", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "queryType", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.sampleorder.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECApplySampleOrderListRequest extends f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String keyword;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECApplySampleQueryType queryType;

    public ECApplySampleOrderListRequest(String str, ECApplySampleQueryType eCApplySampleQueryType) {
        this.keyword = str;
        this.queryType = eCApplySampleQueryType;
    }

    public int hashCode() {
        String str = this.keyword;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ECApplySampleQueryType eCApplySampleQueryType = this.queryType;
        return hashCode + (eCApplySampleQueryType != null ? eCApplySampleQueryType.hashCode() : 0);
    }

    public String toString() {
        return "ECApplySampleOrderListRequest(keyword=" + this.keyword + ", queryType=" + this.queryType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECApplySampleOrderListRequest)) {
            return false;
        }
        ECApplySampleOrderListRequest eCApplySampleOrderListRequest = (ECApplySampleOrderListRequest) other;
        return Intrinsics.areEqual(this.keyword, eCApplySampleOrderListRequest.keyword) && Intrinsics.areEqual(this.queryType, eCApplySampleOrderListRequest.queryType);
    }
}

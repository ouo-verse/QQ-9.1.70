package com.tencent.kuikly.core.module;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/module/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "a", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "()Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "headerFields", "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "<init>", "(Lcom/tencent/kuikly/core/nvi/serialization/json/e;Ljava/lang/Integer;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.module.j, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class NetworkResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final com.tencent.kuikly.core.nvi.serialization.json.e headerFields;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer statusCode;

    public NetworkResponse(com.tencent.kuikly.core.nvi.serialization.json.e headerFields, Integer num) {
        Intrinsics.checkNotNullParameter(headerFields, "headerFields");
        this.headerFields = headerFields;
        this.statusCode = num;
    }

    /* renamed from: a, reason: from getter */
    public final com.tencent.kuikly.core.nvi.serialization.json.e getHeaderFields() {
        return this.headerFields;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        int hashCode = this.headerFields.hashCode() * 31;
        Integer num = this.statusCode;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "NetworkResponse(headerFields=" + this.headerFields + ", statusCode=" + this.statusCode + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) other;
        return Intrinsics.areEqual(this.headerFields, networkResponse.headerFields) && Intrinsics.areEqual(this.statusCode, networkResponse.statusCode);
    }
}

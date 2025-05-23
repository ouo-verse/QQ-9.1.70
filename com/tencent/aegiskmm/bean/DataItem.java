package com.tencent.aegiskmm.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aegiskmm/bean/d;", "Lcom/tencent/aegiskmm/bean/e;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "", "J", "getTimestamp", "()J", "timestamp", "c", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "d", "getFields", "fields", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.aegiskmm.bean.d, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class DataItem extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timestamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String message;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String fields;

    public DataItem(long j3, String message, String fields) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.timestamp = j3;
        this.message = message;
        this.fields = fields;
    }

    public com.tencent.kuikly.core.nvi.serialization.json.e b() {
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().u("timestamp", this.timestamp);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("message", this.message);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("fields", this.fields);
        return getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
    }

    public int hashCode() {
        int a16 = com.tencent.aegiskmm.d.a(this.timestamp) * 31;
        String str = this.message;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fields;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DataItem(timestamp=" + this.timestamp + ", message=" + this.message + ", fields=" + this.fields + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataItem)) {
            return false;
        }
        DataItem dataItem = (DataItem) other;
        return this.timestamp == dataItem.timestamp && Intrinsics.areEqual(this.message, dataItem.message) && Intrinsics.areEqual(this.fields, dataItem.fields);
    }
}

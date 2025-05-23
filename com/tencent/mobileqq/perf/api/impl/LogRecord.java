package com.tencent.mobileqq.perf.api.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/perf/api/impl/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "timestamp", "Ljava/lang/String;", "()Ljava/lang/String;", "tag", "<init>", "(JLjava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.perf.api.impl.c, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class LogRecord {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timestamp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String tag;

    public LogRecord(long j3, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.timestamp = j3;
        this.tag = tag;
    }

    /* renamed from: a, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: b, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (b.a(this.timestamp) * 31) + this.tag.hashCode();
    }

    public String toString() {
        return "LogRecord(timestamp=" + this.timestamp + ", tag=" + this.tag + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogRecord)) {
            return false;
        }
        LogRecord logRecord = (LogRecord) other;
        return this.timestamp == logRecord.timestamp && Intrinsics.areEqual(this.tag, logRecord.tag);
    }
}

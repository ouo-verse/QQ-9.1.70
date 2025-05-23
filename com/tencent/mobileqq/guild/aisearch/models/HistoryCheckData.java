package com.tencent.mobileqq.guild.aisearch.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "totalCount", "checkCount", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.g, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class HistoryCheckData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int checkCount;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HistoryCheckData() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: a, reason: from getter */
    public final int getCheckCount() {
        return this.checkCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryCheckData)) {
            return false;
        }
        HistoryCheckData historyCheckData = (HistoryCheckData) other;
        if (this.totalCount == historyCheckData.totalCount && this.checkCount == historyCheckData.checkCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.totalCount * 31) + this.checkCount;
    }

    @NotNull
    public String toString() {
        return "HistoryCheckData(totalCount=" + this.totalCount + ", checkCount=" + this.checkCount + ")";
    }

    public HistoryCheckData(int i3, int i16) {
        this.totalCount = i3;
        this.checkCount = i16;
    }

    public /* synthetic */ HistoryCheckData(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
    }
}

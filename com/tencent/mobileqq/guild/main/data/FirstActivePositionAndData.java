package com.tencent.mobileqq.guild.main.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/main/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "position", "Lcom/tencent/mobileqq/guild/main/data/d;", "Lcom/tencent/mobileqq/guild/main/data/d;", "()Lcom/tencent/mobileqq/guild/main/data/d;", "data", "<init>", "(ILcom/tencent/mobileqq/guild/main/data/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.main.data.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class FirstActivePositionAndData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int position;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final d data;

    public FirstActivePositionAndData(int i3, @Nullable d dVar) {
        this.position = i3;
        this.data = dVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final d getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirstActivePositionAndData)) {
            return false;
        }
        FirstActivePositionAndData firstActivePositionAndData = (FirstActivePositionAndData) other;
        if (this.position == firstActivePositionAndData.position && Intrinsics.areEqual(this.data, firstActivePositionAndData.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.position * 31;
        d dVar = this.data;
        if (dVar == null) {
            hashCode = 0;
        } else {
            hashCode = dVar.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "FirstActivePositionAndData(position=" + this.position + ", data=" + this.data + ")";
    }
}

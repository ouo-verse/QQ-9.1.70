package com.tencent.qqperf.tools;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqperf/tools/g;", "", "", "a", "", "b", "", "c", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "I", "getTotalSize", "()I", "totalSize", "Ljava/util/List;", "getSubTrees", "()Ljava/util/List;", "subTrees", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqperf.tools.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SizeTree {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<SizeTree> subTrees;

    public SizeTree(@NotNull String key, int i3, @NotNull List<SizeTree> subTrees) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(subTrees, "subTrees");
        this.key = key;
        this.totalSize = i3;
        this.subTrees = subTrees;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotalSize() {
        return this.totalSize;
    }

    @NotNull
    public final List<SizeTree> c() {
        return this.subTrees;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeTree)) {
            return false;
        }
        SizeTree sizeTree = (SizeTree) other;
        if (Intrinsics.areEqual(this.key, sizeTree.key) && this.totalSize == sizeTree.totalSize && Intrinsics.areEqual(this.subTrees, sizeTree.subTrees)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.totalSize) * 31) + this.subTrees.hashCode();
    }

    @NotNull
    public String toString() {
        return "SizeTree(key=" + this.key + ", totalSize=" + this.totalSize + ", subTrees=" + this.subTrees + ')';
    }
}

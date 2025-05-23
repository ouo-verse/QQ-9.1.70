package com.tencent.mobileqq.wink.magicstudio.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "a", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "b", "()Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "generateInfo", "I", "()I", "count", "", "c", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/model/c;ILjava/lang/Throwable;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.model.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GenerateFlowInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GenerateInfo generateInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Throwable throwable;

    public GenerateFlowInfo(@Nullable GenerateInfo generateInfo, int i3, @Nullable Throwable th5) {
        this.generateInfo = generateInfo;
        this.count = i3;
        this.throwable = th5;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final GenerateInfo getGenerateInfo() {
        return this.generateInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateFlowInfo)) {
            return false;
        }
        GenerateFlowInfo generateFlowInfo = (GenerateFlowInfo) other;
        if (Intrinsics.areEqual(this.generateInfo, generateFlowInfo.generateInfo) && this.count == generateFlowInfo.count && Intrinsics.areEqual(this.throwable, generateFlowInfo.throwable)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        GenerateInfo generateInfo = this.generateInfo;
        int i3 = 0;
        if (generateInfo == null) {
            hashCode = 0;
        } else {
            hashCode = generateInfo.hashCode();
        }
        int i16 = ((hashCode * 31) + this.count) * 31;
        Throwable th5 = this.throwable;
        if (th5 != null) {
            i3 = th5.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "GenerateFlowInfo(generateInfo=" + this.generateInfo + ", count=" + this.count + ", throwable=" + this.throwable + ")";
    }
}

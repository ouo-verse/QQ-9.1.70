package com.tencent.mobileqq.guild.aisearch.models.operators;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "d", "(Z)V", "hasEmitFirstReason", "c", "hasEmitFirstContent", "<init>", "(ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.c, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class EmitStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasEmitFirstReason;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasEmitFirstContent;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EmitStatus() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasEmitFirstContent() {
        return this.hasEmitFirstContent;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasEmitFirstReason() {
        return this.hasEmitFirstReason;
    }

    public final void c(boolean z16) {
        this.hasEmitFirstContent = z16;
    }

    public final void d(boolean z16) {
        this.hasEmitFirstReason = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmitStatus)) {
            return false;
        }
        EmitStatus emitStatus = (EmitStatus) other;
        if (this.hasEmitFirstReason == emitStatus.hasEmitFirstReason && this.hasEmitFirstContent == emitStatus.hasEmitFirstContent) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.hasEmitFirstReason;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.hasEmitFirstContent;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "EmitStatus(hasEmitFirstReason=" + this.hasEmitFirstReason + ", hasEmitFirstContent=" + this.hasEmitFirstContent + ")";
    }

    public EmitStatus(boolean z16, boolean z17) {
        this.hasEmitFirstReason = z16;
        this.hasEmitFirstContent = z17;
    }

    public /* synthetic */ EmitStatus(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
    }
}

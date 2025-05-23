package com.tencent.mobileqq.guild.aisearch.models.operators;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001b\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "reasonContentDiff", "b", "contentDiff", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "c", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "()Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "emitSpeed", "", "J", "()J", "delayDuration", "e", "reserveCount", "f", "totalCount", "<init>", "(IILcom/tencent/mobileqq/guild/aisearch/models/operators/b;JI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.e, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class StepResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int reasonContentDiff;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int contentDiff;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final EmitSpeed emitSpeed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long delayDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int reserveCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int totalCount;

    public StepResult(int i3, int i16, @NotNull EmitSpeed emitSpeed, long j3, int i17) {
        Intrinsics.checkNotNullParameter(emitSpeed, "emitSpeed");
        this.reasonContentDiff = i3;
        this.contentDiff = i16;
        this.emitSpeed = emitSpeed;
        this.delayDuration = j3;
        this.reserveCount = i17;
        this.totalCount = i3 + i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getContentDiff() {
        return this.contentDiff;
    }

    /* renamed from: b, reason: from getter */
    public final long getDelayDuration() {
        return this.delayDuration;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final EmitSpeed getEmitSpeed() {
        return this.emitSpeed;
    }

    /* renamed from: d, reason: from getter */
    public final int getReasonContentDiff() {
        return this.reasonContentDiff;
    }

    /* renamed from: e, reason: from getter */
    public final int getReserveCount() {
        return this.reserveCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepResult)) {
            return false;
        }
        StepResult stepResult = (StepResult) other;
        if (this.reasonContentDiff == stepResult.reasonContentDiff && this.contentDiff == stepResult.contentDiff && Intrinsics.areEqual(this.emitSpeed, stepResult.emitSpeed) && this.delayDuration == stepResult.delayDuration && this.reserveCount == stepResult.reserveCount) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return (((((((this.reasonContentDiff * 31) + this.contentDiff) * 31) + this.emitSpeed.hashCode()) * 31) + androidx.fragment.app.a.a(this.delayDuration)) * 31) + this.reserveCount;
    }

    @NotNull
    public String toString() {
        return "StepResult(reasonContentDiff=" + this.reasonContentDiff + ", contentDiff=" + this.contentDiff + ", emitSpeed=" + this.emitSpeed + ", delayDuration=" + this.delayDuration + ", reserveCount=" + this.reserveCount + ")";
    }

    public /* synthetic */ StepResult(int i3, int i16, EmitSpeed emitSpeed, long j3, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, emitSpeed, (i18 & 8) != 0 ? 0L : j3, (i18 & 16) != 0 ? 0 : i17);
    }
}

package com.tencent.mobileqq.qwallet.pet.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "subActionType", "b", "e", "subActionUrl", "c", "I", "()I", "beginTime", "endTime", "elapseAnimTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subActionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subActionUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int beginTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int endTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int elapseAnimTime;

    public k(@NotNull String subActionType, @NotNull String subActionUrl, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(subActionType, "subActionType");
        Intrinsics.checkNotNullParameter(subActionUrl, "subActionUrl");
        this.subActionType = subActionType;
        this.subActionUrl = subActionUrl;
        this.beginTime = i3;
        this.endTime = i16;
        this.elapseAnimTime = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getBeginTime() {
        return this.beginTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getElapseAnimTime() {
        return this.elapseAnimTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getEndTime() {
        return this.endTime;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSubActionType() {
        return this.subActionType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSubActionUrl() {
        return this.subActionUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (Intrinsics.areEqual(this.subActionType, kVar.subActionType) && Intrinsics.areEqual(this.subActionUrl, kVar.subActionUrl) && this.beginTime == kVar.beginTime && this.endTime == kVar.endTime && this.elapseAnimTime == kVar.elapseAnimTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.subActionType.hashCode() * 31) + this.subActionUrl.hashCode()) * 31) + this.beginTime) * 31) + this.endTime) * 31) + this.elapseAnimTime;
    }

    @NotNull
    public String toString() {
        return this.subActionType + " beginTime=" + this.beginTime + " endTime=" + this.endTime + " elapseAnimTime=" + this.elapseAnimTime;
    }
}

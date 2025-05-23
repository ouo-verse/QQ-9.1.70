package com.tencent.mobileqq.vas.aio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "seq", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "url", "c", "I", "d", "()I", "type", "startTime", "endTime", "<init>", "(JLjava/lang/String;III)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.aio.i, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasZplanCycleIcon {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long seq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endTime;

    public VasZplanCycleIcon() {
        this(0L, null, 0, 0, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getEndTime() {
        return this.endTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    /* renamed from: c, reason: from getter */
    public final int getStartTime() {
        return this.startTime;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasZplanCycleIcon)) {
            return false;
        }
        VasZplanCycleIcon vasZplanCycleIcon = (VasZplanCycleIcon) other;
        if (this.seq == vasZplanCycleIcon.seq && Intrinsics.areEqual(this.url, vasZplanCycleIcon.url) && this.type == vasZplanCycleIcon.type && this.startTime == vasZplanCycleIcon.startTime && this.endTime == vasZplanCycleIcon.endTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((androidx.fragment.app.a.a(this.seq) * 31) + this.url.hashCode()) * 31) + this.type) * 31) + this.startTime) * 31) + this.endTime;
    }

    @NotNull
    public String toString() {
        return "VasZplanCycleIcon(seq=" + this.seq + ", url=" + this.url + ", type=" + this.type + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public VasZplanCycleIcon(long j3, @NotNull String url, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.seq = j3;
        this.url = url;
        this.type = i3;
        this.startTime = i16;
        this.endTime = i17;
    }

    public /* synthetic */ VasZplanCycleIcon(long j3, String str, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0L : j3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0 : i17);
    }
}

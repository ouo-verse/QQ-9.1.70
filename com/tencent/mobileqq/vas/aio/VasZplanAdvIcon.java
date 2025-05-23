package com.tencent.mobileqq.vas.aio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "seq", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "I", "()I", "type", "<init>", "(JLjava/lang/String;I)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.aio.e, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasZplanAdvIcon {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long seq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public VasZplanAdvIcon() {
        this(0L, null, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasZplanAdvIcon)) {
            return false;
        }
        VasZplanAdvIcon vasZplanAdvIcon = (VasZplanAdvIcon) other;
        if (this.seq == vasZplanAdvIcon.seq && Intrinsics.areEqual(this.url, vasZplanAdvIcon.url) && this.type == vasZplanAdvIcon.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.seq) * 31) + this.url.hashCode()) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "VasZplanAdvIcon(seq=" + this.seq + ", url=" + this.url + ", type=" + this.type + ')';
    }

    public VasZplanAdvIcon(long j3, @NotNull String url, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.seq = j3;
        this.url = url;
        this.type = i3;
    }

    public /* synthetic */ VasZplanAdvIcon(long j3, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0 : i3);
    }
}

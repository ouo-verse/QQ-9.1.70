package com.tencent.gdtad.basics.motivebrowsing;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B#\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/v;", "", "", "a", "", "b", "c", "toString", "hashCode", "other", "", "equals", "I", "getEvent", "()I", "event", "Ljava/lang/String;", "getScript", "()Ljava/lang/String;", "script", "getLeftSecond", "leftSecond", "<init>", "(ILjava/lang/String;I)V", "d", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.gdtad.basics.motivebrowsing.v, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class MotiveBrowsingData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int event;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String script;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int leftSecond;

    public MotiveBrowsingData(int i3, @NotNull String script, int i16) {
        Intrinsics.checkNotNullParameter(script, "script");
        this.event = i3;
        this.script = script;
        this.leftSecond = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getEvent() {
        return this.event;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getScript() {
        return this.script;
    }

    /* renamed from: c, reason: from getter */
    public final int getLeftSecond() {
        return this.leftSecond;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MotiveBrowsingData)) {
            return false;
        }
        MotiveBrowsingData motiveBrowsingData = (MotiveBrowsingData) other;
        if (this.event == motiveBrowsingData.event && Intrinsics.areEqual(this.script, motiveBrowsingData.script) && this.leftSecond == motiveBrowsingData.leftSecond) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.event * 31) + this.script.hashCode()) * 31) + this.leftSecond;
    }

    @NotNull
    public String toString() {
        return "MotiveBrowsingData(event=" + this.event + ", script=" + this.script + ", leftSecond=" + this.leftSecond + ")";
    }

    public /* synthetic */ MotiveBrowsingData(int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? 0 : i16);
    }
}

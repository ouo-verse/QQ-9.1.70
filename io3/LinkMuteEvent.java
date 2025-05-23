package io3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lio3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "b", "Z", "()Z", "isMute", "<init>", "(Ljava/lang/String;Z)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: io3.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class LinkMuteEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMute;

    public LinkMuteEvent(@NotNull String uin, boolean z16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.isMute = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsMute() {
        return this.isMute;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkMuteEvent)) {
            return false;
        }
        LinkMuteEvent linkMuteEvent = (LinkMuteEvent) other;
        if (Intrinsics.areEqual(this.uin, linkMuteEvent.uin) && this.isMute == linkMuteEvent.isMute) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.uin.hashCode() * 31;
        boolean z16 = this.isMute;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "LinkMuteEvent(uin='" + this.uin + "', isMute=" + this.isMute + ")";
    }
}

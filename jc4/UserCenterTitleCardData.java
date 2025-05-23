package jc4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0013"}, d2 = {"Ljc4/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lpv4/u;", "a", "Lpv4/u;", "getTitle", "()Lpv4/u;", "title", "b", "more", "<init>", "(Lpv4/u;Lpv4/u;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jc4.g, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class UserCenterTitleCardData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final u title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final u more;

    public UserCenterTitleCardData(u title, u more) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(more, "more");
        this.title = title;
        this.more = more;
    }

    /* renamed from: a, reason: from getter */
    public final u getMore() {
        return this.more;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.more.hashCode();
    }

    public String toString() {
        return "UserCenterTitleCardData(title=" + this.title + ", more=" + this.more + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCenterTitleCardData)) {
            return false;
        }
        UserCenterTitleCardData userCenterTitleCardData = (UserCenterTitleCardData) other;
        return Intrinsics.areEqual(this.title, userCenterTitleCardData.title) && Intrinsics.areEqual(this.more, userCenterTitleCardData.more);
    }
}

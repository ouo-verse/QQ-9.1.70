package a52;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"La52/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "shareUID", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "shareUserName", "<init>", "(JLjava/lang/String;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: a52.c, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class ShareUserInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long shareUID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareUserName;

    public ShareUserInfo() {
        this(0L, null, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getShareUID() {
        return this.shareUID;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getShareUserName() {
        return this.shareUserName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareUserInfo)) {
            return false;
        }
        ShareUserInfo shareUserInfo = (ShareUserInfo) other;
        if (this.shareUID == shareUserInfo.shareUID && Intrinsics.areEqual(this.shareUserName, shareUserInfo.shareUserName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.shareUID) * 31) + this.shareUserName.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShareUserInfo(shareUID=" + this.shareUID + ", shareUserName=" + this.shareUserName + ')';
    }

    public ShareUserInfo(long j3, @NotNull String shareUserName) {
        Intrinsics.checkNotNullParameter(shareUserName, "shareUserName");
        this.shareUID = j3;
        this.shareUserName = shareUserName;
    }

    public /* synthetic */ ShareUserInfo(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str);
    }
}

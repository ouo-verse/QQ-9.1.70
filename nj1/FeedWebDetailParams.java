package nj1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\r\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lnj1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "maxLength", "b", "Z", "c", "()Z", "e", "(Z)V", "supportAt", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "troopName", "placeHolder", "<init>", "(IZLjava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: nj1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedWebDetailParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxLength;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean supportAt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String troopName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String placeHolder;

    public FeedWebDetailParams() {
        this(0, false, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxLength() {
        return this.maxLength;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSupportAt() {
        return this.supportAt;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTroopName() {
        return this.troopName;
    }

    public final void e(boolean z16) {
        this.supportAt = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedWebDetailParams)) {
            return false;
        }
        FeedWebDetailParams feedWebDetailParams = (FeedWebDetailParams) other;
        if (this.maxLength == feedWebDetailParams.maxLength && this.supportAt == feedWebDetailParams.supportAt && Intrinsics.areEqual(this.troopName, feedWebDetailParams.troopName) && Intrinsics.areEqual(this.placeHolder, feedWebDetailParams.placeHolder)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.maxLength * 31;
        boolean z16 = this.supportAt;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((i3 + i16) * 31) + this.troopName.hashCode()) * 31) + this.placeHolder.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedWebDetailParams(maxLength=" + this.maxLength + ", supportAt=" + this.supportAt + ", troopName=" + this.troopName + ", placeHolder=" + this.placeHolder + ")";
    }

    public FeedWebDetailParams(int i3, boolean z16, @NotNull String troopName, @NotNull String placeHolder) {
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(placeHolder, "placeHolder");
        this.maxLength = i3;
        this.supportAt = z16;
        this.troopName = troopName;
        this.placeHolder = placeHolder;
    }

    public /* synthetic */ FeedWebDetailParams(int i3, boolean z16, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 500 : i3, (i16 & 2) != 0 ? true : z16, (i16 & 4) != 0 ? "" : str, (i16 & 8) != 0 ? "" : str2);
    }
}

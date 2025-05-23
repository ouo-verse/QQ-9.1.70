package fh1;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\tB)\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lfh1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", PhotoCategorySummaryInfo.AVATAR_URL, "c", "gender", "tinyId", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fh1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class AvatarInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    public AvatarInfo(int i3, @NotNull String avatarUrl, int i16, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.type = i3;
        this.avatarUrl = avatarUrl;
        this.gender = i16;
        this.tinyId = tinyId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: b, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarInfo)) {
            return false;
        }
        AvatarInfo avatarInfo = (AvatarInfo) other;
        if (this.type == avatarInfo.type && Intrinsics.areEqual(this.avatarUrl, avatarInfo.avatarUrl) && this.gender == avatarInfo.gender && Intrinsics.areEqual(this.tinyId, avatarInfo.tinyId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.avatarUrl.hashCode()) * 31) + this.gender) * 31) + this.tinyId.hashCode();
    }

    @NotNull
    public String toString() {
        return "AvatarInfo(type=" + this.type + ", avatarUrl=" + this.avatarUrl + ", gender=" + this.gender + ", tinyId=" + this.tinyId + ")";
    }

    public /* synthetic */ AvatarInfo(int i3, String str, int i16, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, (i17 & 8) != 0 ? "" : str2);
    }
}

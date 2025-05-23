package jb2;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Ljb2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "tinyId", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "nickName", PhotoCategorySummaryInfo.AVATAR_URL, "avatarDressBorderUrl", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jb2.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class UserProfileData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarDressBorderUrl;

    public UserProfileData(long j3, @NotNull String nickName, @NotNull String avatarUrl, @NotNull String avatarDressBorderUrl) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(avatarDressBorderUrl, "avatarDressBorderUrl");
        this.tinyId = j3;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.avatarDressBorderUrl = avatarDressBorderUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarDressBorderUrl() {
        return this.avatarDressBorderUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: d, reason: from getter */
    public final long getTinyId() {
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileData)) {
            return false;
        }
        UserProfileData userProfileData = (UserProfileData) other;
        if (this.tinyId == userProfileData.tinyId && Intrinsics.areEqual(this.nickName, userProfileData.nickName) && Intrinsics.areEqual(this.avatarUrl, userProfileData.avatarUrl) && Intrinsics.areEqual(this.avatarDressBorderUrl, userProfileData.avatarDressBorderUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.tinyId) * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.avatarDressBorderUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserProfileData(tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", avatarDressBorderUrl=" + this.avatarDressBorderUrl + ")";
    }

    public /* synthetic */ UserProfileData(long j3, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, str2, (i3 & 8) != 0 ? "" : str3);
    }
}

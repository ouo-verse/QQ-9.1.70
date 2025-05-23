package pf4;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.timi.game.api.live.playtogether.Gender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lpf4/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", PhotoCategorySummaryInfo.AVATAR_URL, "b", "c", "nickName", "I", "()I", "gender", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pf4.i, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class PlayTogetherUserShowInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gender;

    public PlayTogetherUserShowInfo(@NotNull String avatarUrl, @NotNull String nickName, @Gender int i3) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        this.avatarUrl = avatarUrl;
        this.nickName = nickName;
        this.gender = i3;
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
    public final String getNickName() {
        return this.nickName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayTogetherUserShowInfo)) {
            return false;
        }
        PlayTogetherUserShowInfo playTogetherUserShowInfo = (PlayTogetherUserShowInfo) other;
        if (Intrinsics.areEqual(this.avatarUrl, playTogetherUserShowInfo.avatarUrl) && Intrinsics.areEqual(this.nickName, playTogetherUserShowInfo.nickName) && this.gender == playTogetherUserShowInfo.gender) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.avatarUrl.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.gender;
    }

    @NotNull
    public String toString() {
        return "PlayTogetherUserShowInfo(avatarUrl=" + this.avatarUrl + ", nickName=" + this.nickName + ", gender=" + this.gender + ')';
    }
}

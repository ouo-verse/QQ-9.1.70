package nn3;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import jr4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011\u00a8\u0006'"}, d2 = {"Lnn3/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getGameId", "()I", VirtualAppProxy.KEY_GAME_ID, "b", "Ljava/lang/String;", "getGameName", "()Ljava/lang/String;", "gameName", "Ljr4/f;", "c", "Ljr4/f;", "getTrtcInfo", "()Ljr4/f;", "trtcInfo", "Lkr4/a;", "d", "Lkr4/a;", "getRoomStageInfo", "()Lkr4/a;", "roomStageInfo", "e", "getAnnouncementTopic", "announcementTopic", "f", "getAnnouncement", "announcement", "<init>", "(ILjava/lang/String;Ljr4/f;Lkr4/a;Ljava/lang/String;Ljava/lang/String;)V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: nn3.c, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class GameExtraInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gameId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String gameName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final f trtcInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final kr4.a roomStageInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String announcementTopic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String announcement;

    public GameExtraInfo(int i3, @Nullable String str, @Nullable f fVar, @Nullable kr4.a aVar, @Nullable String str2, @Nullable String str3) {
        this.gameId = i3;
        this.gameName = str;
        this.trtcInfo = fVar;
        this.roomStageInfo = aVar;
        this.announcementTopic = str2;
        this.announcement = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameExtraInfo)) {
            return false;
        }
        GameExtraInfo gameExtraInfo = (GameExtraInfo) other;
        if (this.gameId == gameExtraInfo.gameId && Intrinsics.areEqual(this.gameName, gameExtraInfo.gameName) && Intrinsics.areEqual(this.trtcInfo, gameExtraInfo.trtcInfo) && Intrinsics.areEqual(this.roomStageInfo, gameExtraInfo.roomStageInfo) && Intrinsics.areEqual(this.announcementTopic, gameExtraInfo.announcementTopic) && Intrinsics.areEqual(this.announcement, gameExtraInfo.announcement)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i3 = this.gameId * 31;
        String str = this.gameName;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        f fVar = this.trtcInfo;
        if (fVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = fVar.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        kr4.a aVar = this.roomStageInfo;
        if (aVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = aVar.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        String str2 = this.announcementTopic;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i26 = (i19 + hashCode4) * 31;
        String str3 = this.announcement;
        if (str3 != null) {
            i16 = str3.hashCode();
        }
        return i26 + i16;
    }

    @NotNull
    public String toString() {
        return "GameExtraInfo(gameId=" + this.gameId + ", gameName=" + this.gameName + ", trtcInfo=" + this.trtcInfo + ", roomStageInfo=" + this.roomStageInfo + ", announcementTopic=" + this.announcementTopic + ", announcement=" + this.announcement + ')';
    }
}

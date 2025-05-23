package pf4;

import com.tencent.timi.game.api.live.playtogether.PlayTogetherTeamStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lpf4/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "status", "b", "modeMaxPlayerCount", "c", "currentPlayerCount", "Ljava/lang/String;", "()Ljava/lang/String;", "modeName", "<init>", "(IIILjava/lang/String;)V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pf4.h, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class PlayTogetherTeamInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int modeMaxPlayerCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int currentPlayerCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modeName;

    public PlayTogetherTeamInfo(@PlayTogetherTeamStatus int i3, int i16, int i17, @NotNull String modeName) {
        Intrinsics.checkNotNullParameter(modeName, "modeName");
        this.status = i3;
        this.modeMaxPlayerCount = i16;
        this.currentPlayerCount = i17;
        this.modeName = modeName;
    }

    /* renamed from: a, reason: from getter */
    public final int getCurrentPlayerCount() {
        return this.currentPlayerCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getModeMaxPlayerCount() {
        return this.modeMaxPlayerCount;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getModeName() {
        return this.modeName;
    }

    /* renamed from: d, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayTogetherTeamInfo)) {
            return false;
        }
        PlayTogetherTeamInfo playTogetherTeamInfo = (PlayTogetherTeamInfo) other;
        if (this.status == playTogetherTeamInfo.status && this.modeMaxPlayerCount == playTogetherTeamInfo.modeMaxPlayerCount && this.currentPlayerCount == playTogetherTeamInfo.currentPlayerCount && Intrinsics.areEqual(this.modeName, playTogetherTeamInfo.modeName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.status * 31) + this.modeMaxPlayerCount) * 31) + this.currentPlayerCount) * 31) + this.modeName.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlayTogetherTeamInfo(status=" + this.status + ", modeMaxPlayerCount=" + this.modeMaxPlayerCount + ", currentPlayerCount=" + this.currentPlayerCount + ", modeName=" + this.modeName + ')';
    }
}

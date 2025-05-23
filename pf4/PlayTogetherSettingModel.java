package pf4;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lpf4/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", VirtualAppProxy.KEY_GAME_ID, "Lpf4/i;", "b", "Lpf4/i;", "c", "()Lpf4/i;", "showInfo", "Lpf4/f;", "Lpf4/f;", "()Lpf4/f;", "guildSettingModel", "<init>", "(ILpf4/i;Lpf4/f;)V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pf4.g, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class PlayTogetherSettingModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gameId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PlayTogetherUserShowInfo showInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PlayTogetherGuildSettingModel guildSettingModel;

    public PlayTogetherSettingModel(int i3, @NotNull PlayTogetherUserShowInfo showInfo, @NotNull PlayTogetherGuildSettingModel guildSettingModel) {
        Intrinsics.checkNotNullParameter(showInfo, "showInfo");
        Intrinsics.checkNotNullParameter(guildSettingModel, "guildSettingModel");
        this.gameId = i3;
        this.showInfo = showInfo;
        this.guildSettingModel = guildSettingModel;
    }

    /* renamed from: a, reason: from getter */
    public final int getGameId() {
        return this.gameId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final PlayTogetherGuildSettingModel getGuildSettingModel() {
        return this.guildSettingModel;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final PlayTogetherUserShowInfo getShowInfo() {
        return this.showInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayTogetherSettingModel)) {
            return false;
        }
        PlayTogetherSettingModel playTogetherSettingModel = (PlayTogetherSettingModel) other;
        if (this.gameId == playTogetherSettingModel.gameId && Intrinsics.areEqual(this.showInfo, playTogetherSettingModel.showInfo) && Intrinsics.areEqual(this.guildSettingModel, playTogetherSettingModel.guildSettingModel)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.gameId * 31) + this.showInfo.hashCode()) * 31) + this.guildSettingModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlayTogetherSettingModel(gameId=" + this.gameId + ", showInfo=" + this.showInfo + ", guildSettingModel=" + this.guildSettingModel + ')';
    }

    public /* synthetic */ PlayTogetherSettingModel(int i3, PlayTogetherUserShowInfo playTogetherUserShowInfo, PlayTogetherGuildSettingModel playTogetherGuildSettingModel, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 101 : i3, playTogetherUserShowInfo, playTogetherGuildSettingModel);
    }
}

package pf4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lpf4/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkf4/a;", "a", "Lkf4/a;", "()Lkf4/a;", "guildInfo", "<init>", "(Lkf4/a;)V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pf4.f, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class PlayTogetherGuildSettingModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final kf4.a guildInfo;

    public PlayTogetherGuildSettingModel(@NotNull kf4.a guildInfo) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        this.guildInfo = guildInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final kf4.a getGuildInfo() {
        return this.guildInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof PlayTogetherGuildSettingModel) && Intrinsics.areEqual(this.guildInfo, ((PlayTogetherGuildSettingModel) other).guildInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.guildInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlayTogetherGuildSettingModel(guildInfo=" + this.guildInfo + ')';
    }
}

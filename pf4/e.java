package pf4;

import com.tencent.timi.game.api.live.playtogether.PlayTogetherStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lpf4/e;", "", "Lpf4/h;", "teamInfo", "", "b", "", "status", "a", "<init>", "()V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class e {
    public void b(@NotNull PlayTogetherTeamInfo teamInfo) {
        Intrinsics.checkNotNullParameter(teamInfo, "teamInfo");
    }

    public void a(@PlayTogetherStatus int status) {
    }
}

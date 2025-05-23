package com.tencent.timi.game.api.live.playtogether;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/api/live/playtogether/PlayTogetherTeamStatus;", "", "Companion", "a", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public @interface PlayTogetherTeamStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f376300a;
    public static final int IDLE = 0;
    public static final int IN_GAME = 2;
    public static final int IN_TEAM = 1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/api/live/playtogether/PlayTogetherTeamStatus$a;", "", "<init>", "()V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.api.live.playtogether.PlayTogetherTeamStatus$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f376300a = new Companion();

        Companion() {
        }
    }
}

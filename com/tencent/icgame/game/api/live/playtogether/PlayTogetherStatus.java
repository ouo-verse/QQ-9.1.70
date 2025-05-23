package com.tencent.icgame.game.api.live.playtogether;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/icgame/game/api/live/playtogether/PlayTogetherStatus;", "", "Companion", "a", "ic-game-timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public @interface PlayTogetherStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f114888a;
    public static final int DEFAULT = -1;
    public static final int OFF = 0;
    public static final int ON = 1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/icgame/game/api/live/playtogether/PlayTogetherStatus$a;", "", "<init>", "()V", "ic-game-timi-game-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.api.live.playtogether.PlayTogetherStatus$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f114888a = new Companion();

        Companion() {
        }
    }
}

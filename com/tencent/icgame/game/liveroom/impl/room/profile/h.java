package com.tencent.icgame.game.liveroom.impl.room.profile;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/h;", "", "Lhx0/a;", "a", "Lhx0/a;", "getLiveUserInfo", "()Lhx0/a;", "liveUserInfo", "", "b", "J", "getRoomId", "()J", "roomId", "Landroid/view/View;", "c", "Landroid/view/View;", "getBlurBackgroundView", "()Landroid/view/View;", "blurBackgroundView", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/i;", "d", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/i;", "getReprotInfo", "()Lcom/tencent/icgame/game/liveroom/impl/room/profile/i;", "reprotInfo", "", "e", "Z", "getOpenByAnchor", "()Z", "openByAnchor", "Lpw0/b;", "f", "Lpw0/b;", "getAnchorJudgeStrategy", "()Lpw0/b;", "anchorJudgeStrategy", "<init>", "(Lhx0/a;JLandroid/view/View;Lcom/tencent/icgame/game/liveroom/impl/room/profile/i;ZLpw0/b;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hx0.a liveUserInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View blurBackgroundView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final i reprotInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean openByAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pw0.b anchorJudgeStrategy;

    public h(@NotNull hx0.a liveUserInfo, long j3, @Nullable View view, @Nullable i iVar, boolean z16, @NotNull pw0.b anchorJudgeStrategy) {
        Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
        Intrinsics.checkNotNullParameter(anchorJudgeStrategy, "anchorJudgeStrategy");
        this.liveUserInfo = liveUserInfo;
        this.roomId = j3;
        this.blurBackgroundView = view;
        this.reprotInfo = iVar;
        this.openByAnchor = z16;
        this.anchorJudgeStrategy = anchorJudgeStrategy;
    }
}

package com.tencent.mobileqq.guild.media.qcircle;

import com.tencent.mobileqq.guild.media.core.notify.am;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.r;
import com.tencent.mobileqq.guild.media.game.memberlist.GuildGameMemberView;
import com.tencent.mobileqq.guild.media.game.widget.GameContentView;
import com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard;
import com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0002\u0019\u001c\u0018\u0000 !2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/b;", "", "", "b", "c", "", "roomState", "f", "d", "e", "Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "a", "Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "getContent", "()Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "content", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "teamCard", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "gameInfoBar", "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "gameMemberView", "com/tencent/mobileqq/guild/media/qcircle/b$c", "Lcom/tencent/mobileqq/guild/media/qcircle/b$c;", "gameRoomStateObserver", "com/tencent/mobileqq/guild/media/qcircle/b$b", "Lcom/tencent/mobileqq/guild/media/qcircle/b$b;", "gameRoomEnterObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;)V", "g", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GameContentView content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildGameTeamCard teamCard;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaGameTeamBar gameInfoBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildGameMemberView gameMemberView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c gameRoomStateObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7836b gameRoomEnterObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/b$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/r;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.qcircle.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7836b implements o<r> {
        C7836b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull r event) {
            Intrinsics.checkNotNullParameter(event, "event");
            b.this.teamCard.j0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/b$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/am;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<am> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull am event) {
            Intrinsics.checkNotNullParameter(event, "event");
            int roomState = event.getRoomInfo().getRoomState();
            QLog.d("QGMC.QCircle.GameCirclePresenter", 4, "RoomStateEvent " + roomState);
            b.this.f(roomState);
        }
    }

    public b(@NotNull GameContentView content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.teamCard = content.getTeamCard();
        this.gameInfoBar = content.getGameInfoBar();
        this.gameMemberView = content.getGameMemberView();
        this.gameRoomStateObserver = new c();
        this.gameRoomEnterObserver = new C7836b();
    }

    public final void b() {
        com.tencent.mobileqq.guild.media.core.j.d().V(am.class, this.gameRoomStateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(r.class, this.gameRoomEnterObserver);
    }

    public final void c() {
        this.teamCard.x();
        this.gameInfoBar.r();
        this.gameMemberView.c();
        if (com.tencent.mobileqq.guild.media.core.j.c().o()) {
            IGProVoiceSmobaGameRoomStateInfo roomInfo = com.tencent.mobileqq.guild.media.core.j.c().n().getRoomInfo();
            Intrinsics.checkNotNull(roomInfo);
            if (roomInfo.getRoomState() != 0) {
                this.gameInfoBar.setVisibility(8);
                this.teamCard.setVisibility(0);
                this.teamCard.j0();
            }
        }
    }

    public final void d() {
        e();
        this.gameMemberView.onDestroy();
        this.teamCard.y();
    }

    public final void e() {
        com.tencent.mobileqq.guild.media.core.j.d().j(am.class, this.gameRoomStateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(r.class, this.gameRoomEnterObserver);
    }

    public final void f(int roomState) {
        if (roomState == 0) {
            ys1.c.c(this.teamCard);
            ys1.c.a(this.gameInfoBar);
        } else {
            ys1.c.c(this.gameInfoBar);
            ys1.c.a(this.teamCard);
            this.teamCard.j0();
        }
    }
}

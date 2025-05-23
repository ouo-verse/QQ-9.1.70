package com.tencent.mobileqq.guild.media.game.widget;

import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.al;
import com.tencent.mobileqq.guild.media.core.notify.am;
import com.tencent.mobileqq.guild.media.game.memberlist.GuildGameMemberView;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\rB'\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/a;", "", "", "f", "Lbt1/h;", "roomVM", "j", "i", "Landroid/content/res/Configuration;", "newConfig", tl.h.F, "g", "Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "a", "Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "e", "()Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "contentView", "Landroidx/lifecycle/LifecycleOwner;", "b", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lmqq/util/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "c", "Lmqq/util/WeakReference;", "activityRef", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "d", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "teamCard", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "gameInfoBar", "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "gameMemberView", "Lbt1/h;", "roomViewModel", "<init>", "(Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;Landroidx/lifecycle/LifecycleOwner;Lmqq/util/WeakReference;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GameContentView contentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FragmentActivity> activityRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildGameTeamCard teamCard;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaGameTeamBar gameInfoBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildGameMemberView gameMemberView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private bt1.h roomViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        public b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(SwitchThemeEvent event) {
            if (event.getNewThemeType() != 2) {
                bt1.h hVar = a.this.roomViewModel;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                    hVar = null;
                }
                hVar.x2();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.f> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.f event) {
            FragmentActivity fragmentActivity;
            com.tencent.mobileqq.guild.media.core.notify.f fVar = event;
            QLog.d("QGMC.GameContentViewPresenter", 1, "onEventReceive CreateOrDisMissRoomEvent " + fVar.getGameInfo().getResult());
            bt1.h hVar = null;
            if (fVar.getGameInfo().getResult() == 1) {
                String selfTinyId = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
                bt1.h hVar2 = a.this.roomViewModel;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                    hVar2 = null;
                }
                HashSet<Long> b16 = hVar2.e2().b();
                Intrinsics.checkNotNullExpressionValue(selfTinyId, "selfTinyId");
                if (!b16.contains(Long.valueOf(Long.parseLong(selfTinyId))) && (fragmentActivity = (FragmentActivity) a.this.activityRef.get()) != null) {
                    GuildGameInviteDialog guildGameInviteDialog = new GuildGameInviteDialog();
                    FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it1.supportFragmentManager");
                    com.tencent.mobileqq.guild.base.extension.d.a(guildGameInviteDialog, supportFragmentManager, "GameInvite");
                }
            }
            if (fVar.getGameInfo().getResult() == 2) {
                bt1.h hVar3 = a.this.roomViewModel;
                if (hVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                } else {
                    hVar = hVar3;
                }
                hVar.x2();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<am> {
        public d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(am event) {
            QLog.d("QGMC.GameContentViewPresenter", 4, "RoomStateEvent");
            if (event.getRoomInfo().getRoomState() == 0) {
                ys1.c.c(a.this.teamCard);
                ys1.c.a(a.this.gameInfoBar);
            } else {
                ys1.c.c(a.this.gameInfoBar);
                ys1.c.a(a.this.teamCard);
                a.this.teamCard.j0();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.r> {
        public e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.r event) {
            a.this.teamCard.j0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.i> {
        public f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.i event) {
            if (Intrinsics.areEqual(String.valueOf(event.getTinyId()), com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a)) {
                QQToast.makeText(a.this.getContentView().getContext(), R.string.f14933120, 0).show();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<al> {
        public g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(al event) {
            bt1.h hVar = a.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.z2();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/a$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.k> {
        public h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.k event) {
            GuildGameTeamCard guildGameTeamCard = a.this.teamCard;
            String str = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "getDataHub().selfUserInfo.id");
            guildGameTeamCard.d0(str);
        }
    }

    public a(@NotNull GameContentView contentView, @NotNull LifecycleOwner viewLifecycleOwner, @NotNull WeakReference<FragmentActivity> activityRef) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        this.contentView = contentView;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.activityRef = activityRef;
        this.teamCard = contentView.getTeamCard();
        this.gameInfoBar = contentView.getGameInfoBar();
        this.gameMemberView = contentView.getGameMemberView();
    }

    private final void f() {
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, SwitchThemeEvent.class, new b());
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.f.class, new c());
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, am.class, new d());
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.r.class, new e());
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.i.class, new f());
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, al.class, new g());
        com.tencent.mobileqq.guild.media.core.j.d().k0(this.viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.k.class, new h());
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GameContentView getContentView() {
        return this.contentView;
    }

    public final void g() {
        this.gameMemberView.onDestroy();
        this.gameInfoBar.onDestroy();
        this.teamCard.onDestroy();
        bt1.h hVar = this.roomViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        hVar.x2();
    }

    public final void h(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.gameMemberView.g(newConfig);
        this.teamCard.T(newConfig);
        this.gameInfoBar.F(newConfig);
    }

    public final void i() {
        GuildGameTeamCard guildGameTeamCard = this.teamCard;
        bt1.h hVar = this.roomViewModel;
        bt1.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        guildGameTeamCard.S(hVar, this.viewLifecycleOwner);
        GuildMediaGameTeamBar guildMediaGameTeamBar = this.gameInfoBar;
        bt1.h hVar3 = this.roomViewModel;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
        } else {
            hVar2 = hVar3;
        }
        guildMediaGameTeamBar.E(hVar2, this.viewLifecycleOwner, this.activityRef);
        this.gameMemberView.onCreate(this.viewLifecycleOwner);
        if (com.tencent.mobileqq.guild.media.core.j.c().o()) {
            IGProVoiceSmobaGameRoomStateInfo roomInfo = com.tencent.mobileqq.guild.media.core.j.c().n().getRoomInfo();
            Intrinsics.checkNotNull(roomInfo);
            if (roomInfo.getRoomState() != 0) {
                this.gameInfoBar.setVisibility(8);
                this.teamCard.setVisibility(0);
                this.teamCard.j0();
            }
        }
        this.gameMemberView.d();
        this.gameMemberView.h();
        f();
    }

    public final void j(@NotNull bt1.h roomVM) {
        Intrinsics.checkNotNullParameter(roomVM, "roomVM");
        this.roomViewModel = roomVM;
    }
}

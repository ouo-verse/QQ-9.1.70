package com.tencent.timi.game.liveroom.impl.room.playtogether;

import android.app.Activity;
import com.tencent.timi.game.api.live.playtogether.PlayTogetherStatus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf4.PlayTogetherSettingModel;
import pf4.PlayTogetherTeamInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamPlayerInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u001cj\b\u0012\u0004\u0012\u00020\n`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/w;", "Lpf4/a;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;", "rsp", "", "i", "", "g", "Lpf4/h;", tl.h.F, "Lpf4/e;", "l", "a", "b", "Landroid/app/Activity;", "ctx", "Lpf4/b;", "playTogetherPanelListener", "d", "c", "e", "destroy", "Lpf4/g;", "Lpf4/g;", "settingModel", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/g;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/g;", "mPresenter", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mListenerPool", "Lsi4/b;", "Lsi4/b;", "mListener", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;", "mCurrentRsp", "<init>", "(Lpf4/g;)V", "f", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class w implements pf4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlayTogetherSettingModel settingModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.g mPresenter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<pf4.e> mListenerPool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final si4.b mListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp mCurrentRsp;

    public w(@NotNull PlayTogetherSettingModel settingModel) {
        Intrinsics.checkNotNullParameter(settingModel, "settingModel");
        this.settingModel = settingModel;
        com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.g gVar = new com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.g(settingModel);
        this.mPresenter = gVar;
        this.mListenerPool = new HashSet<>();
        si4.b bVar = new si4.b() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.v
            @Override // si4.b
            public final void a(PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp) {
                w.j(w.this, premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
            }
        };
        this.mListener = bVar;
        this.mCurrentRsp = new PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp();
        ((ni4.a) mm4.b.b(ni4.a.class)).l2().j(settingModel.getGuildSettingModel().getGuildInfo(), bVar);
        PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp h16 = ((ni4.a) mm4.b.b(ni4.a.class)).l2().h(settingModel.getGuildSettingModel().getGuildInfo());
        if (h16 != null) {
            this.mCurrentRsp = h16;
            com.tencent.timi.game.utils.l.h("PlayTogetherManagerImpl_", 1, "this:" + this + ", settingModel:" + settingModel + ", cache valid");
        }
        com.tencent.timi.game.utils.l.h("PlayTogetherManagerImpl_", 1, "settingModel:" + settingModel.getGameId() + " init finish!");
        gVar.f();
    }

    @PlayTogetherStatus
    private final int g() {
        return this.mPresenter.J() ? 1 : 0;
    }

    private final PlayTogetherTeamInfo h() {
        boolean z16;
        if (!this.mCurrentRsp.live_team_info.has()) {
            com.tencent.timi.game.utils.l.c("PlayTogetherManagerImpl_", 1, "getCurrentTeamInfo live_team_info is empty");
            return new PlayTogetherTeamInfo(0, 0, 0, "");
        }
        int i3 = this.mCurrentRsp.live_team_info.game_route_info.game_status.get();
        int i16 = 2;
        if (i3 != 2) {
            if (i3 != 3) {
                i16 = 0;
            }
        } else {
            i16 = 1;
        }
        List<YoloTeamOuterClass$YoloTeamPlayerInfo> totalPlayer = this.mCurrentRsp.live_team_info.team_player_info_list.player_list.get();
        int size = totalPlayer.size();
        Intrinsics.checkNotNullExpressionValue(totalPlayer, "totalPlayer");
        ArrayList arrayList = new ArrayList();
        for (Object obj : totalPlayer) {
            if (((YoloTeamOuterClass$YoloTeamPlayerInfo) obj).status.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        String modelName = this.mCurrentRsp.live_team_info.game_data_info.common_game_data_info.mode_name.get();
        com.tencent.timi.game.utils.l.h("PlayTogetherManagerImpl_", 1, "getCurrentTeamInfo status:" + i16 + ", maxPlayerNum:" + size + ", currentPlayerNum:" + size2 + ", modelName:" + modelName);
        Intrinsics.checkNotNullExpressionValue(modelName, "modelName");
        return new PlayTogetherTeamInfo(i16, size, size2, modelName);
    }

    private final void i(PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp rsp) {
        this.mCurrentRsp = rsp;
        this.mPresenter.O(rsp.live_team_info.get());
        for (pf4.e eVar : this.mListenerPool) {
            eVar.a(g());
            eVar.b(h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(w this$0, PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.i(it);
    }

    @Override // pf4.a
    public void a(@NotNull pf4.e l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.add(l3);
    }

    @Override // pf4.a
    public void b(@NotNull pf4.e l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.remove(l3);
    }

    @Override // pf4.a
    @NotNull
    public PlayTogetherTeamInfo c() {
        return h();
    }

    @Override // pf4.a
    public void d(@NotNull Activity ctx, @Nullable pf4.b playTogetherPanelListener) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        s.INSTANCE.a(ctx, this.mPresenter, -1, playTogetherPanelListener);
    }

    @Override // pf4.a
    public void destroy() {
        ((ni4.a) mm4.b.b(ni4.a.class)).l2().f(this.mListener);
        this.mPresenter.Z();
    }

    @Override // pf4.a
    public int e() {
        return g();
    }
}

package com.tencent.timi.game.liveroom.impl.room.playtogether.presenter;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.room.playtogether.u;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf4.PlayTogetherSettingModel;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;
import trpc.yes.common.YoloTeamOuterClass$YoloLiveTeamInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamJoinBattleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/g;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter;", "", "dialogOpenFlag", "", h.F, "condition", "Landroid/content/Context;", "ctx", "Y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", HippyTKDListViewAdapter.X, "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "L", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamJoinBattleRsp;", "result", ExifInterface.LATITUDE_SOUTH, "Lpf4/g;", "U", "Lpf4/g;", "settingModel", "V", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "<init>", "(Lpf4/g;)V", "W", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g extends BasePlayTogetherJoinPresenter {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final PlayTogetherSettingModel settingModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final LiveUserInfo userInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/g$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f378328b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f378329c;

        b(int i3, Context context) {
            this.f378328b = i3;
            this.f378329c = context;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp result) {
            if (result == null) {
                l.e("GuildAudienceJoinTeamPresenter", "tryJoinTeam rsp is null");
                return;
            }
            YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = result.live_team_info;
            if (yoloTeamOuterClass$YoloLiveTeamInfo == null) {
                return;
            }
            g.this.k(this.f378328b, this.f378329c, yoloTeamOuterClass$YoloLiveTeamInfo);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.e("GuildAudienceJoinTeamPresenter", "tryJoinTeam errorCode:" + errorCode + ", errorMessage:" + errorMessage);
        }
    }

    public g(@NotNull PlayTogetherSettingModel settingModel) {
        Intrinsics.checkNotNullParameter(settingModel, "settingModel");
        this.settingModel = settingModel;
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.headUrl = settingModel.getShowInfo().getAvatarUrl();
        liveUserInfo.sex = settingModel.getShowInfo().getGender();
        liveUserInfo.nick = settingModel.getShowInfo().getNickName();
        this.userInfo = liveUserInfo;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    public long B() {
        return 0L;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    @NotNull
    /* renamed from: G, reason: from getter */
    protected LiveUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    public boolean L() {
        return J();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    public void S(@NotNull YoloTeamOuterClass$YoloTeamJoinBattleRsp result) {
        Intrinsics.checkNotNullParameter(result, "result");
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = result.team_info;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("yes_game_is_anchor", "1");
            hashMap.put("yes_launch_id", String.valueOf(yoloTeamOuterClass$YoloLiveTeamInfo.game_route_info.common_game_route_info.base_info.yolo_battle_id.get()));
            hashMap.put("yes_game_id", String.valueOf(yoloTeamOuterClass$YoloLiveTeamInfo.game_id.get()));
            hashMap.put("yes_team_id", String.valueOf(yoloTeamOuterClass$YoloLiveTeamInfo.team_id.get()));
            hashMap.put("yes_team_rank", YoloRoomUtil.z(yoloTeamOuterClass$YoloLiveTeamInfo.game_data_info.common_game_data_info.grade_list.get()));
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_yes_game_launch_success", hashMap);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    protected void Y(int condition, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ((ni4.a) mm4.b.b(ni4.a.class)).l2().i(this.settingModel.getGuildSettingModel().getGuildInfo(), new b(condition, ctx));
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    public void h(int dialogOpenFlag) {
        PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo;
        if (dialogOpenFlag >= -1) {
            W(dialogOpenFlag);
        }
        PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp h16 = ((ni4.a) mm4.b.b(ni4.a.class)).l2().h(this.settingModel.getGuildSettingModel().getGuildInfo());
        if (h16 != null) {
            premadesTeamServerOuterClass$AnchorGameInfo = h16.game_info;
        } else {
            premadesTeamServerOuterClass$AnchorGameInfo = null;
        }
        U(premadesTeamServerOuterClass$AnchorGameInfo);
        u dialog = getDialog();
        if (dialog != null) {
            dialog.showDialog();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    public void m() {
        pf4.b playTogetherPanelListener = getPlayTogetherPanelListener();
        if (playTogetherPanelListener != null) {
            playTogetherPanelListener.a(0);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    protected long q() {
        return 0L;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    protected int s() {
        return 2;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    protected int u() {
        return this.settingModel.getGameId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter
    @NotNull
    public LiveRoomExtraInfo x() {
        LiveRoomExtraInfo liveRoomExtraInfo = new LiveRoomExtraInfo();
        liveRoomExtraInfo.f376294h = u();
        return liveRoomExtraInfo;
    }
}

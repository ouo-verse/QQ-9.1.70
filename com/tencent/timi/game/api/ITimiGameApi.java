package com.tencent.timi.game.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import jf4.a;
import kotlin.Metadata;
import nf4.b;
import nf4.d;
import nf4.e;
import nf4.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H&J$\u0010\u0015\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH&J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH&J$\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH&J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010'\u001a\u00020&H&J\b\u0010)\u001a\u00020(H&J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\r2\u0006\u0010,\u001a\u00020+H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H&J\b\u00101\u001a\u00020\u0004H&J\b\u00103\u001a\u000202H&J\u0010\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0016H&J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H&J\b\u0010:\u001a\u000209H&J\b\u0010<\u001a\u00020;H&J\u0010\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H&\u00a8\u0006@"}, d2 = {"Lcom/tencent/timi/game/api/ITimiGameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "loginOrReconnect", "", "doWhenQQLogin", "doWhenQQLogout", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "expandHallOpenParam", "openExpandHall", "openTimiGameTestPage", "", "testParam", "openTimiGameTmpDebugTestPage", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "getExpandHallFragment", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "listener", "createExpandHallFragment", "", "jumpLink", "buildLaunchParamFromLink", "initLiveModule", "Lcom/tencent/mobileqq/qqlive/data/anchor/camera/QQLiveAnchorStreamRecordType;", "type", "Lnf4/b;", "startGameLive", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "resumeRoomInfo", "reConnectObsPushRoom", "", "roomId", "programId", "resumeGameLive", "openAnchorRoomPage", "Lnf4/e;", "oneKeyLiveHandler", "Lnf4/d;", "getLiveReportUtil", "subSceneId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "openGiftPanelFragmentFromActivity", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "roomExtraInfo", "recordLiveRoomExtraData", "registerTGLiveQIPCModule", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getTimiApiProvider", "moduleName", "isTimiModule", "Lqf4/a;", "param", "openNearbyProfile", "Lnf4/h;", "getTimiLiveApi", "Ljf4/a;", "getGameRoomHandler", "Lcom/tencent/timi/game/api/auth/AuthScene;", "authScene", "needRealNameAuth", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface ITimiGameApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ QPublicBaseFragment createExpandHallFragment$default(ITimiGameApi iTimiGameApi, Context context, ExpandHallLaunchParam expandHallLaunchParam, ExpandHallListener expandHallListener, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    expandHallListener = null;
                }
                return iTimiGameApi.createExpandHallFragment(context, expandHallLaunchParam, expandHallListener);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createExpandHallFragment");
        }
    }

    @NotNull
    ExpandHallLaunchParam buildLaunchParamFromLink(@NotNull Context context, @NotNull String jumpLink);

    @NotNull
    QPublicBaseFragment createExpandHallFragment(@NotNull Context context, @NotNull ExpandHallLaunchParam expandHallOpenParam, @Nullable ExpandHallListener listener);

    void doWhenQQLogin(boolean loginOrReconnect);

    void doWhenQQLogout();

    @NotNull
    Class<? extends QPublicBaseFragment> getExpandHallFragment();

    @NotNull
    a getGameRoomHandler();

    @NotNull
    d getLiveReportUtil();

    @NotNull
    HippyAPIProvider getTimiApiProvider();

    @NotNull
    h getTimiLiveApi();

    void initLiveModule(@NotNull Context context);

    boolean isTimiModule(@NotNull String moduleName);

    boolean needRealNameAuth(@NotNull AuthScene authScene);

    @NotNull
    e oneKeyLiveHandler();

    void openAnchorRoomPage(@NotNull Context context);

    void openExpandHall(@NotNull Context context, @NotNull ExpandHallLaunchParam expandHallOpenParam);

    void openGiftPanelFragmentFromActivity(int subSceneId, @NotNull Activity activity);

    void openNearbyProfile(@NotNull qf4.a param);

    void openTimiGameTestPage();

    void openTimiGameTmpDebugTestPage(int testParam);

    void reConnectObsPushRoom(@Nullable QQLiveAnchorRoomInfo resumeRoomInfo, @Nullable b listener);

    void recordLiveRoomExtraData(@NotNull LiveRoomExtraInfo roomExtraInfo);

    void registerTGLiveQIPCModule();

    void resumeGameLive(long roomId, @Nullable String programId, @Nullable b listener);

    void startGameLive(@NotNull QQLiveAnchorStreamRecordType type, @Nullable b listener);
}

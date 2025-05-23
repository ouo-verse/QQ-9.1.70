package com.tencent.icgame.api;

import android.app.Activity;
import android.content.Context;
import au0.a;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0004H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&J6\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0002H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rH&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rH&\u00a8\u0006!"}, d2 = {"Lcom/tencent/icgame/api/ITimiGameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "loginOrReconnect", "", "doWhenQQLogin", "doWhenQQLogout", "Landroid/content/Context;", "context", "initLiveModule", "destroyLiveModule", "Lau0/a;", "getLiveReportUtil", "", "subSceneId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "openGiftPanelFragmentFromActivity", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "roomExtraInfo", "recordLiveRoomExtraData", "registerTGLiveQIPCModule", "", "moduleName", "isTimiModule", "businessId", "panelType", "gameType", "anchorId", "needPanelRes", "preloadGiftRes", "initGiftSdk", "destroySdk", "ic-game-timi-game-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface ITimiGameApi extends QRouteApi {
    void destroyLiveModule();

    void destroySdk(int businessId);

    void doWhenQQLogin(boolean loginOrReconnect);

    void doWhenQQLogout();

    @NotNull
    a getLiveReportUtil();

    void initGiftSdk(int businessId);

    void initLiveModule(@NotNull Context context);

    boolean isTimiModule(@NotNull String moduleName);

    void openGiftPanelFragmentFromActivity(int subSceneId, @NotNull Activity activity);

    void preloadGiftRes(int businessId, int panelType, @NotNull String gameType, @NotNull String anchorId, boolean needPanelRes);

    void recordLiveRoomExtraData(@NotNull LiveRoomExtraInfo roomExtraInfo);

    void registerTGLiveQIPCModule();
}

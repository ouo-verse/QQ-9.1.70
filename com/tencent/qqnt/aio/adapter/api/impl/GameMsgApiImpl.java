package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aio.data.AIOParam;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gamecenter.api.IGameCenterSgameApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGameMsgApi;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GameMsgApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGameMsgApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "startWangZheGameTeaming", "startMetaDreamGameTeaming", "", "isShowMetaDreamTeamingIcon", "isShowWangZheTeamingIcon", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "onSendMsgIntercept", "startGameTeaming", "isShowGameTeamingIcon", "mIsGetMetaDreamTeamingLink", "Z", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GameMsgApiImpl implements IGameMsgApi {
    private static final long ERROR_CODE_GET_META_DREAM_TEAMING_LINK_CHAT_FORBIDDEN = 700006;
    private static final String META_DREAM_APP_ID = "1112198072";
    private static final String TAG = "GameMsgApiImpl";
    private static final String WANGZHE_APP_ID = "1104466820";
    private boolean mIsGetMetaDreamTeamingLink;

    private final boolean isShowMetaDreamTeamingIcon() {
        boolean isSwitchOn = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAMEPLAT_META_DREAM_GAME_TEAMING_SWITCH_CONFIG);
        QLog.d(TAG, 1, "isMetaDreamGameTeamingEntranceVisible isVisible: " + isSwitchOn);
        if (isSwitchOn) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(META_DREAM_APP_ID, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92044", "915688", "", "", "8", "");
        }
        return isSwitchOn;
    }

    private final boolean isShowWangZheTeamingIcon() {
        boolean isSwitchOn = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAME_CENTER_HONORKING_PARTNER_TEAMING_SWITCH_CONFIG);
        QLog.d(TAG, 1, "isShowWangZheTeamingIcon isVisible: " + isSwitchOn);
        return isSwitchOn;
    }

    private final void startMetaDreamGameTeaming(final Activity activity, AIOParam aioParam) {
        Bundle l3 = aioParam.l();
        String string = l3.getString("key_peerId", "");
        String string2 = l3.getString(AppConstants.Key.KEY_GAME_MSG_SESSION);
        QLog.d(TAG, 1, "startMetaDreamGameTeaming mIsGetMetaDreamTeamingLink: " + this.mIsGetMetaDreamTeamingLink);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || this.mIsGetMetaDreamTeamingLink) {
            return;
        }
        this.mIsGetMetaDreamTeamingLink = true;
        TempChatGameSession gameSessionFromPeerUidOrJson = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUidOrJson(string, string2);
        String str = gameSessionFromPeerUidOrJson.peerOpenId;
        if (!(str == null || str.length() == 0)) {
            String str2 = gameSessionFromPeerUidOrJson.peerRoleId;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = gameSessionFromPeerUidOrJson.selfRoleId;
                if (!(str3 == null || str3.length() == 0)) {
                    IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IMetaDreamService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
                    final IMetaDreamService iMetaDreamService = (IMetaDreamService) runtimeService;
                    final Dialog showLoadingDialog = DialogUtil.showLoadingDialog(activity, activity.getResources().getString(R.string.f1374806z), false);
                    Intrinsics.checkNotNullExpressionValue(showLoadingDialog, "showLoadingDialog(activi\u2026ding),\n            false)");
                    try {
                        showLoadingDialog.show();
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "startMetaDreamGameTeaming show dialog exception=", e16);
                    }
                    iMetaDreamService.getMetaDreamGameTeamingLink(gameSessionFromPeerUidOrJson.peerOpenId, gameSessionFromPeerUidOrJson.peerRoleId, gameSessionFromPeerUidOrJson.selfRoleId, new sd1.c() { // from class: com.tencent.qqnt.aio.adapter.api.impl.al
                        @Override // sd1.c
                        public final void a(boolean z16, long j3, String str4) {
                            GameMsgApiImpl.startMetaDreamGameTeaming$lambda$3(activity, iMetaDreamService, this, showLoadingDialog, z16, j3, str4);
                        }
                    });
                    ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(META_DREAM_APP_ID, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92044", "915689", "", "", "20", "");
                    return;
                }
            }
        }
        QLog.d(TAG, 1, "startMetaDreamGameTeaming invalid param");
        this.mIsGetMetaDreamTeamingLink = false;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ak
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgApiImpl.startMetaDreamGameTeaming$lambda$0(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMetaDreamGameTeaming$lambda$0(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QQToast.makeText(activity.getApplicationContext(), R.string.f1374706y, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMetaDreamGameTeaming$lambda$3(final Activity activity, IMetaDreamService metaDreamService, GameMsgApiImpl this$0, final Dialog loadingDialog, boolean z16, final long j3, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(metaDreamService, "$metaDreamService");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loadingDialog, "$loadingDialog");
        QLog.d(TAG, 1, "getMetaDreamGameTeamingLink success:" + z16 + ", errorCode:" + j3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.am
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgApiImpl.startMetaDreamGameTeaming$lambda$3$lambda$1(loadingDialog);
            }
        });
        if (z16) {
            if (!(str == null || str.length() == 0)) {
                QLog.d(TAG, 1, "getMetaDreamGameTeamingLink open link");
                Intent intent = new Intent();
                intent.putExtra("url", str);
                intent.putExtra(QQTranslucentBrowserActivity.FLAG_HIDE_FLOAT_BAR, true);
                RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER);
                metaDreamService.removeMetaDreamGetGameTeamingLinkCallback();
                this$0.mIsGetMetaDreamTeamingLink = false;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.an
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgApiImpl.startMetaDreamGameTeaming$lambda$3$lambda$2(j3, activity);
            }
        });
        metaDreamService.removeMetaDreamGetGameTeamingLinkCallback();
        this$0.mIsGetMetaDreamTeamingLink = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMetaDreamGameTeaming$lambda$3$lambda$1(Dialog loadingDialog) {
        Intrinsics.checkNotNullParameter(loadingDialog, "$loadingDialog");
        try {
            loadingDialog.dismiss();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startMetaDreamGameTeaming dialog dismiss exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMetaDreamGameTeaming$lambda$3$lambda$2(long j3, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QQToast.makeText(activity.getApplicationContext(), j3 == ERROR_CODE_GET_META_DREAM_TEAMING_LINK_CHAT_FORBIDDEN ? R.string.f13749070 : R.string.f1374606x, 1).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGameMsgApi
    public boolean isShowGameTeamingIcon() {
        String enterGameMsgAIOAppId = ((IGameMsgBoxRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getEnterGameMsgAIOAppId();
        QLog.d(TAG, 1, "isShowGameTeamingIcon appid: " + enterGameMsgAIOAppId);
        if (Intrinsics.areEqual(enterGameMsgAIOAppId, META_DREAM_APP_ID)) {
            return isShowMetaDreamTeamingIcon();
        }
        if (Intrinsics.areEqual(enterGameMsgAIOAppId, "1104466820")) {
            return isShowWangZheTeamingIcon();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGameMsgApi
    public com.tencent.qqnt.aio.interceptor.sendmsg.d onSendMsgIntercept(com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper) {
        Intrinsics.checkNotNullParameter(paramWrapper, "paramWrapper");
        Bundle b16 = paramWrapper.b();
        return new com.tencent.qqnt.aio.interceptor.sendmsg.d(((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).onSendMsgIntercept(b16 != null ? b16.getCharSequence("input_text") : null), false, 2, null);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGameMsgApi
    public void startGameTeaming(Activity activity, AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        String enterGameMsgAIOAppId = ((IGameMsgBoxRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getEnterGameMsgAIOAppId();
        QLog.d(TAG, 1, "startGameTeaming appid: " + enterGameMsgAIOAppId);
        if (Intrinsics.areEqual(enterGameMsgAIOAppId, META_DREAM_APP_ID)) {
            startMetaDreamGameTeaming(activity, aioParam);
        } else if (Intrinsics.areEqual(enterGameMsgAIOAppId, "1104466820")) {
            startWangZheGameTeaming(activity, aioParam);
        } else {
            QLog.d(TAG, 1, "startGameTeaming don't match game");
        }
    }

    private final void startWangZheGameTeaming(Activity activity, AIOParam aioParam) {
        QLog.d(TAG, 1, "startWangZheGameTeaming");
        ((IGameCenterSgameApi) QRoute.api(IGameCenterSgameApi.class)).createSgameTeam(activity, aioParam);
    }
}

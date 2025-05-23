package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterSgameApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterSgameApiImpl implements IGameCenterSgameApi {
    private static final String TAG = "GameCenterSgameApiImpl";
    private static volatile boolean gIsCreatingSgameTeam = false;
    private static Dialog gLoadingDialog;

    private void dismissLoadingDialog() {
        try {
            Dialog dialog = gLoadingDialog;
            if (dialog != null && dialog.isShowing()) {
                gLoadingDialog.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "dismissLoadingDialog exception=", th5);
        }
        gLoadingDialog = null;
    }

    private TempChatGameSession getGameSession(AIOParam aIOParam) {
        Bundle l3 = aIOParam.l();
        TempChatGameSession gameSessionFromPeerUidOrJson = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUidOrJson(l3.getString("key_peerId", ""), l3.getString(AppConstants.Key.KEY_GAME_MSG_SESSION));
        if (gameSessionFromPeerUidOrJson != null && gameSessionFromPeerUidOrJson.gameAppId != 0 && !TextUtils.isEmpty(gameSessionFromPeerUidOrJson.peerRoleId) && !TextUtils.isEmpty(gameSessionFromPeerUidOrJson.selfRoleId) && !TextUtils.isEmpty(gameSessionFromPeerUidOrJson.peerOpenId) && !TextUtils.isEmpty(gameSessionFromPeerUidOrJson.selfOpenId)) {
            return gameSessionFromPeerUidOrJson;
        }
        return null;
    }

    private void gotoBrowserActivity(String str) {
        try {
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            Intent intent = new Intent(applicationContext, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.addFlags(268435456);
            applicationContext.startActivity(intent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "gotoBrowserActivity exception=", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onGetUrlForCreatingSgameTeam$1() {
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), R.string.f1374606x, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onGetUrlForCreatingSgameTeam, reason: merged with bridge method [inline-methods] */
    public void lambda$handleUrlForCreatingSgameTeam$0(String str) {
        gIsCreatingSgameTeam = false;
        dismissLoadingDialog();
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "onGetUrlForCreatingSgameTeam url is empty");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.v
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterSgameApiImpl.lambda$onGetUrlForCreatingSgameTeam$1();
                }
            });
        } else if (HttpUtil.isValidUrl(str)) {
            gotoBrowserActivity(str);
        } else {
            openUrlScheme(str);
        }
    }

    private void openUrlScheme(String str) {
        try {
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.addFlags(268435456);
            intent.setPackage("com.tencent.mobileqq");
            intent.setData(Uri.parse(str));
            applicationContext.startActivity(intent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "openUrlScheme exception=", th5);
        }
    }

    private void showLoadingDialog(Activity activity) {
        try {
            Dialog showLoadingDialog = DialogUtil.showLoadingDialog(activity, activity.getResources().getString(R.string.f1374806z), false);
            gLoadingDialog = showLoadingDialog;
            showLoadingDialog.show();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "showLoadingDialog exception=", th5);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterSgameApi
    public void createSgameTeam(Activity activity, AIOParam aIOParam) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && activity != null && aIOParam != null) {
            if (gIsCreatingSgameTeam) {
                QLog.e(TAG, 1, "createSgameTeam is creating SgameTeam, return");
                return;
            }
            gIsCreatingSgameTeam = true;
            TempChatGameSession gameSession = getGameSession(aIOParam);
            if (gameSession == null) {
                gIsCreatingSgameTeam = false;
                QLog.d(TAG, 1, "createSgameTeam invalid session");
                QQToast.makeText(peekAppRuntime.getApplicationContext(), R.string.f1374706y, 0).show();
                return;
            }
            dismissLoadingDialog();
            showLoadingDialog(activity);
            GameCenterUnissoHandler.N2().w3(gameSession);
            if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerContact(gameSession)) {
                str = "92050";
            } else {
                str = "92005";
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(String.valueOf(gameSession.gameAppId), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str, "928870", gameSession.peerOpenId, "", "20", "");
            return;
        }
        QLog.e(TAG, 1, "createSgameTeam appRuntime, activity or aioParam is null");
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterSgameApi
    public void handleUrlForCreatingSgameTeam(final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.u
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterSgameApiImpl.this.lambda$handleUrlForCreatingSgameTeam$0(str);
            }
        });
    }
}

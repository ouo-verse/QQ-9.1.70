package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TempApiImpl implements ITempApi {
    public static final String TAG = "TempApiImpl";

    private static Intent getClickNotifyHippyIntent(AppInterface appInterface, Context context) {
        if (appInterface == null || context == null) {
            return null;
        }
        if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippySwitch()) {
            QLog.e(TAG, 1, "[getClickNotifyHippyIntent] hippy switch is off, ail to open by hippy");
            return null;
        }
        QLog.i(TAG, 1, "getClickNotifyHippyIntent success.");
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(IGameMsgHelperApi.HIPPY_SCHEMA_URL));
        return intent;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void addTinySessionKey(String str, String str2, byte[] bArr) {
        QQAppInterface qQAppInterface = getQQAppInterface();
        if (qQAppInterface == null) {
            QLog.i(TAG, 1, "[addTinySessionKey] fail to get QQAppInterface");
        } else {
            qQAppInterface.getMsgCache().P(str, str2, bArr);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public boolean canNotDisturb() {
        return FriendsStatusUtil.c(BaseApplication.getContext());
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public Intent getIntentFromMsg(Context context, Message message, AppInterface appInterface) {
        boolean z16;
        GameCenterSessionInfo sessionInfoByUin;
        GameSwitchConfig findGameSwitchConfig;
        ConversationInfo tinyConvInfo;
        if (((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab() && appInterface != null && (tinyConvInfo = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getTinyConvInfo(message.frienduin, 10007)) != null && tinyConvInfo.tinyInfo != null) {
            Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
            intent.putExtra("uin", message.frienduin);
            intent.putExtra("uintype", 10007);
            TinyInfo tinyInfo = tinyConvInfo.tinyInfo;
            String str = tinyInfo.fromRoleId;
            String str2 = tinyInfo.toRoleId;
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, str);
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, str2);
            return intent;
        }
        Intent clickNotifyHippyIntent = getClickNotifyHippyIntent(appInterface, context);
        if (clickNotifyHippyIntent != null) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).report(appInterface, message.frienduin, 10006, 2);
            return clickNotifyHippyIntent;
        }
        Intent intent2 = new Intent(context, (Class<?>) GameCenterActivity.class);
        String str3 = message.frienduin;
        intent2.putExtra("uin", str3);
        intent2.putExtra("uintype", 10007);
        if (appInterface != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getIntentFromMsg is called!.");
                }
                ConversationInfo tinyConvInfo2 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getTinyConvInfo(str3, 10007);
                if (tinyConvInfo2 != null) {
                    TinyInfo tinyInfo2 = tinyConvInfo2.tinyInfo;
                    String str4 = tinyInfo2.fromRoleId;
                    String str5 = tinyInfo2.toRoleId;
                    QLog.i(TAG, 1, "[getIntentFromMsg], uin:" + str3 + ",fRoleId:" + str4 + ",mRoleId:" + str5);
                    IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
                    gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(str5);
                    if (singleGameDetail != null && (findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(singleGameDetail.f401939c)) != null && findGameSwitchConfig.mSyncSwitch != 1) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    String gameMsgListUrl = iGameMsgManagerService.getGameMsgListUrl();
                    if (!z16 && (sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(str3)) != null) {
                        gameMsgListUrl = gameMsgListUrl + "&&gameId=" + sessionInfoByUin.m() + "&gameName=" + sessionInfoByUin.n() + "&sessionId=" + sessionInfoByUin.w() + "&requestCount=" + sessionInfoByUin.u();
                    }
                    intent2.putExtra("url", gameMsgListUrl);
                    intent2.addFlags(268435456);
                    intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                    intent2.putExtra("big_brother_source_key", "biz_src_zf_games");
                    intent2.putExtra(AppConstants.Key.KEY_GAME_MSG_ENTER_FROM, 1);
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getIntentFromMsg is called!. error", th5);
            }
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).report(appInterface, message.frienduin, 10006, 2);
        return intent2;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public Intent getIntentFromMsgNt(Context context, RecentContactInfo recentContactInfo, AppInterface appInterface, Intent intent) {
        boolean z16;
        GameCenterSessionInfo sessionInfoByUin;
        GameSwitchConfig findGameSwitchConfig;
        TempChatGameSession gameSessionFromContact = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromContact(recentContactInfo);
        if (gameSessionFromContact == null) {
            QLog.e(TAG, 1, "[getIntentFromMsg] gameSession is null");
            return null;
        }
        if (((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab() && intent != null) {
            return ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).createJumpIntent(context, gameSessionFromContact, intent);
        }
        String createConvertUinFromTinyId = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createConvertUinFromTinyId(gameSessionFromContact.getSelfTinyId(), gameSessionFromContact.getPeerTinyId());
        Intent clickNotifyHippyIntent = getClickNotifyHippyIntent(appInterface, context);
        if (clickNotifyHippyIntent != null) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).report(appInterface, createConvertUinFromTinyId, 10006, 2);
            return clickNotifyHippyIntent;
        }
        Intent intent2 = new Intent(context, (Class<?>) GameCenterActivity.class);
        intent2.putExtra("uin", createConvertUinFromTinyId);
        intent2.putExtra("uintype", 10007);
        if (appInterface != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getIntentFromMsg is called!.");
                }
                String peerRoleId = gameSessionFromContact.getPeerRoleId();
                String selfRoleId = gameSessionFromContact.getSelfRoleId();
                QLog.i(TAG, 1, "[getIntentFromMsg], uin:" + createConvertUinFromTinyId + ",fRoleId:" + peerRoleId + ",mRoleId:" + selfRoleId);
                IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
                gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(selfRoleId);
                if (singleGameDetail != null && (findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(singleGameDetail.f401939c)) != null && findGameSwitchConfig.mSyncSwitch != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                String gameMsgListUrl = iGameMsgManagerService.getGameMsgListUrl();
                if (!z16 && (sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(createConvertUinFromTinyId)) != null) {
                    gameMsgListUrl = gameMsgListUrl + "&&gameId=" + sessionInfoByUin.m() + "&gameName=" + sessionInfoByUin.n() + "&sessionId=" + sessionInfoByUin.w() + "&requestCount=" + sessionInfoByUin.u();
                }
                intent2.putExtra("url", gameMsgListUrl);
                intent2.addFlags(268435456);
                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent2.putExtra("big_brother_source_key", "biz_src_zf_games");
                intent2.putExtra(AppConstants.Key.KEY_GAME_MSG_ENTER_FROM, 1);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getIntentFromMsg is called!. error", th5);
            }
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).report(appInterface, createConvertUinFromTinyId, 10006, 2);
        return intent2;
    }

    public QQAppInterface getQQAppInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public byte[] getTinySessionKey(String str, String str2) {
        QQAppInterface qQAppInterface = getQQAppInterface();
        if (qQAppInterface == null) {
            QLog.i(TAG, 1, "[addTinySessionKey] fail to get QQAppInterface");
            return null;
        }
        return qQAppInterface.getMsgCache().b1(str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public boolean isSplashActivity(Activity activity) {
        return activity instanceof SplashActivity;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void openGameMsgBox(Activity activity) {
        RecentUtil.v0(activity, 0L);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void refreshAppBadge(AppInterface appInterface) {
        if ((appInterface instanceof QQAppInterface) && appInterface.isLogin()) {
            ((IAppBadgeService) ((QQAppInterface) appInterface).getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void startGame(String str, String str2, String str3, Context context) {
        AppInterface appInterface;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && context != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                return;
            }
            String str4 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=";
            if (!str3.startsWith(ContainerUtils.FIELD_DELIMITER)) {
                str4 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=" + ContainerUtils.FIELD_DELIMITER;
            }
            new eq2.a().d(appInterface, context, str, str4 + str3, str2, 536870912);
            ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportGameAchievement(str, appInterface.getCurrentAccountUin(), 1);
            return;
        }
        QLog.i(TAG, 1, "[startGame] error appId:" + str + ",packageName:" + str2 + ",ticket:" + str3 + ",context:" + context);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void startGameForDistributeBtn(String str, String str2, boolean z16, Context context) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && context != null) {
            AppInterface appInterface = HippyUtils.getAppInterface();
            if (appInterface == null) {
                QLog.i(TAG, 1, "[startGameForDistributeBtn] appInterface is null");
                return;
            }
            if (!z16) {
                str3 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&openid=$OPID$&gamedata=&platformdata=";
            } else {
                str3 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&openid=$OPID$&gamedata=&platformdata=&launchfrom=sq_gamecenter";
            }
            new eq2.a().d(appInterface, context, str, str3, str2, 805306368);
            return;
        }
        QLog.i(TAG, 1, "[startGame] error appId:" + str + ",packageName:" + str2 + ",context:" + context);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void updateRecentList(AppInterface appInterface) {
        MqqHandler handler = appInterface.getHandler(Conversation.class);
        handler.sendMessage(handler.obtainMessage(1009));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[updateRecentList] send update list msg.");
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ITempApi
    public void openGameMsgBox(Activity activity, int i3) {
        if (i3 != 0 && i3 != 1) {
            QLog.e(TAG, 1, "openGameMsgBox invalid tab:", 0);
            i3 = 0;
        }
        RecentUtil.w0(activity, 0L, i3);
    }
}

package ed1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    public static void a(QQAppInterface qQAppInterface, Message message, MsgSummary msgSummary, RecentItemPublicAccountChatMsgData recentItemPublicAccountChatMsgData) {
        RecentUserProxy recentUserProxy;
        RecentUserProxy recentUserProxy2;
        RecentUser findRecentUserByUin;
        RecentUser findRecentUserByUin2;
        MessageRecord x16 = qQAppInterface.getMessageFacade().x1("2747277822", 1008);
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (!iGameMsgManagerService.isGrayOpen()) {
            return;
        }
        iGameMsgManagerService.setMsgShowOnList(false);
        iGameMsgManagerService.setNeedPopMsgView(false);
        iGameMsgManagerService.setShowReqMsgUnread(false);
        RecentUserProxy recentUserProxy3 = qQAppInterface.getRecentUserProxy();
        RecentUser findRecentUserByUin3 = recentUserProxy3.findRecentUserByUin("2747277822", 1008);
        recentItemPublicAccountChatMsgData.mUnreadNum += iGameMsgManagerService.getUnshowedUnreadCnt();
        if (d(qQAppInterface, x16)) {
            return;
        }
        GameCenterSessionInfo lastSessionInfoExceptDelSession = iGameMsgManagerService.getLastSessionInfoExceptDelSession();
        int i3 = 1;
        if (lastSessionInfoExceptDelSession == null) {
            if (!((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(x16) && (findRecentUserByUin2 = recentUserProxy3.findRecentUserByUin("2747277822", 1008)) != null) {
                recentUserProxy3.delRecentUser(findRecentUserByUin2);
                MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
                if (handler != null) {
                    handler.sendEmptyMessage(1009);
                }
                QLog.i("GameMsgUtil", 1, "del pubacc from recent session.");
                return;
            }
            return;
        }
        if (((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(x16)) {
            recentUserProxy = recentUserProxy3;
            if (x16 != null && x16.time > lastSessionInfoExceptDelSession.q()) {
                return;
            }
            if (!iGameMsgManagerService.getHasUnreadMsg() && lastSessionInfoExceptDelSession.x() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("GameMsgUtil", 2, "[buildMessageBody] show operating msg.return.");
                    return;
                }
                return;
            }
        } else {
            recentUserProxy = recentUserProxy3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameMsgUtil", 2, "[buildMessageBody] last info:" + lastSessionInfoExceptDelSession + ",  msg:" + x16);
        }
        if (lastSessionInfoExceptDelSession.q() == 0) {
            if (!((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(x16) && (findRecentUserByUin = (recentUserProxy2 = recentUserProxy).findRecentUserByUin("2747277822", 1008)) != null) {
                recentUserProxy2.delRecentUser(findRecentUserByUin);
                return;
            }
            return;
        }
        if (lastSessionInfoExceptDelSession.z() > 0 || x16 == null || lastSessionInfoExceptDelSession.q() > x16.time) {
            if (lastSessionInfoExceptDelSession.x() == 0) {
                msgSummary.strContent = new QQText("[" + lastSessionInfoExceptDelSession.u() + "\u4f4d\u597d\u53cb\u8bf7\u6c42] \u6765\u81ea" + lastSessionInfoExceptDelSession.n(), 3, 16, -1);
                long lastTopReqMsgTime = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getLastTopReqMsgTime(qQAppInterface);
                recentItemPublicAccountChatMsgData.mDisplayTime = lastSessionInfoExceptDelSession.q();
                if (iGameMsgManagerService.getReqMsgCnt() == 1 || (!((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isToday(lastTopReqMsgTime) && ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isToday(lastSessionInfoExceptDelSession.q() * 1000))) {
                    findRecentUserByUin3.lastmsgtime = lastSessionInfoExceptDelSession.q();
                    recentItemPublicAccountChatMsgData.mDisplayTime = lastSessionInfoExceptDelSession.q();
                    BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).edit().putLong(IGameMsgHelperApi.SP_KEY_TOP_TIME + qQAppInterface.getCurrentAccountUin(), System.currentTimeMillis()).commit();
                }
            } else {
                b(lastSessionInfoExceptDelSession, iGameMsgManagerService, msgSummary, findRecentUserByUin3, recentItemPublicAccountChatMsgData);
            }
            iGameMsgManagerService.setMsgShowOnList(true);
            if (iGameMsgManagerService.getUnshowedUnreadCnt() != 0) {
                iGameMsgManagerService.setNeedPopMsgView(true);
                if (iGameMsgManagerService.getUnreadCnt(false) == 0) {
                    iGameMsgManagerService.setShowReqMsgUnread(true);
                }
                i3 = 0;
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(lastSessionInfoExceptDelSession.m(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92003", "206345", i3 + "", lastSessionInfoExceptDelSession.x() + "", "0", "8", "0", "", "");
            QLog.isColorLevel();
            if (!TextUtils.isEmpty(msgSummary.strContent)) {
                SharedPreferences sharedPreferences = qQAppInterface.getApplication().getSharedPreferences("sp_gamebox_public_summary_".concat(qQAppInterface.getCurrentUin()), 0);
                StringBuilder sb5 = new StringBuilder(msgSummary.strContent.length());
                sb5.append(msgSummary.strContent);
                sharedPreferences.edit().putString("lastPublicContentStr", sb5.toString()).putInt("lastPublicPicFlag", msgSummary.mEmojiFlag).putInt("lastPublicState", msgSummary.nState).apply();
            }
        }
    }

    private static void b(GameCenterSessionInfo gameCenterSessionInfo, IGameMsgManagerService iGameMsgManagerService, MsgSummary msgSummary, RecentUser recentUser, RecentItemPublicAccountChatMsgData recentItemPublicAccountChatMsgData) {
        String s16 = gameCenterSessionInfo.s();
        String gamePrefix = iGameMsgManagerService.getGamePrefix();
        if (!TextUtils.isEmpty(gamePrefix)) {
            try {
                int indexOf = gamePrefix.indexOf("<");
                int indexOf2 = gamePrefix.indexOf(">");
                if (indexOf2 >= 0 && indexOf >= 0) {
                    String substring = gamePrefix.substring(indexOf, indexOf2 + 1);
                    int parseInt = Integer.parseInt(substring.substring(1, substring.length() - 1));
                    String[] strArr = IGameMsgHelperApi.S_EMOJI_LIST;
                    if (parseInt >= strArr.length) {
                        parseInt = 0;
                    }
                    gamePrefix = gamePrefix.replace(substring, strArr[parseInt]);
                }
            } catch (Exception e16) {
                QLog.e("GameMsgUtil", 2, e16, new Object[0]);
                gamePrefix = IGameMsgHelperApi.PREFIX;
            }
        }
        msgSummary.strContent = new QQText(gamePrefix + " " + s16 + MsgSummary.STR_COLON + gameCenterSessionInfo.p(), 3, 16, -1);
        recentUser.lastmsgtime = gameCenterSessionInfo.q();
        recentItemPublicAccountChatMsgData.mDisplayTime = gameCenterSessionInfo.q();
    }

    public static boolean c(IGameMsgManagerService iGameMsgManagerService, IGameMsgBoxManager iGameMsgBoxManager, String str, QQAppInterface qQAppInterface, MsgSummary msgSummary, RecentItemPublicAccountChatMsgData recentItemPublicAccountChatMsgData) {
        MessageRecord x16 = qQAppInterface.getMessageFacade().x1("2747277822", 1008);
        GameCenterSessionInfo lastSessionInfoExceptDelSession = iGameMsgManagerService.getLastSessionInfoExceptDelSession();
        boolean z16 = false;
        if (lastSessionInfoExceptDelSession != null && x16 != null) {
            if (iGameMsgManagerService.isShowInMsgBox() && iGameMsgBoxManager.isGameInGameBox(str) && lastSessionInfoExceptDelSession.q() > x16.time) {
                z16 = true;
            }
            if (z16) {
                e(iGameMsgManagerService, qQAppInterface, msgSummary, recentItemPublicAccountChatMsgData, lastSessionInfoExceptDelSession);
            }
            return z16;
        }
        QLog.e("GameMsgUtil", 1, "info||realLastMsg = null!");
        return false;
    }

    private static boolean d(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        long gamePubLastReadTime = ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getGamePubLastReadTime();
        QLog.i("GameMsgUtil", 1, "[isHasUnreadGamePublicMsg]");
        if (qQAppInterface != null && messageRecord != null && ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(messageRecord)) {
            QLog.i("GameMsgUtil", 1, "pubLastReadTime:" + gamePubLastReadTime + ",recent Msg time:" + messageRecord.time);
            if (gamePubLastReadTime > 0 && gamePubLastReadTime < messageRecord.time) {
                QLog.i("GameMsgUtil", 1, "HAS unread game public msg. case 1");
                return true;
            }
            int unreadCount = ((IConversationFacade) qQAppInterface.getRuntimeService(IConversationFacade.class)).getUnreadCount("2747277822", 1008);
            if (unreadCount <= 0) {
                return false;
            }
            QLog.i("GameMsgUtil", 1, "HAS unread game public msg. case 2, num:" + unreadCount);
            return true;
        }
        QLog.w("GameMsgUtil", 1, "invalid param or invalid public msg");
        return false;
    }

    public static void e(IGameMsgManagerService iGameMsgManagerService, QQAppInterface qQAppInterface, MsgSummary msgSummary, RecentItemPublicAccountChatMsgData recentItemPublicAccountChatMsgData, GameCenterSessionInfo gameCenterSessionInfo) {
        recentItemPublicAccountChatMsgData.mUnreadNum += iGameMsgManagerService.getUnshowedUnreadCnt();
        MessageRecord x16 = qQAppInterface.getMessageFacade().x1("2747277822", 1008);
        if (d(qQAppInterface, x16)) {
            return;
        }
        if (((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(x16)) {
            if (x16.time > gameCenterSessionInfo.q()) {
                return;
            }
            if (!iGameMsgManagerService.getHasUnreadMsg() && gameCenterSessionInfo.x() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("GameMsgUtil", 2, "[buildMessageBody] show operating msg.return.");
                    return;
                }
                return;
            }
        }
        if (msgSummary != null && TextUtils.isEmpty(msgSummary.strContent)) {
            iGameMsgManagerService.setMsgShowOnList(false);
            iGameMsgManagerService.setNeedPopMsgView(false);
            iGameMsgManagerService.setShowReqMsgUnread(false);
            SharedPreferences sharedPreferences = qQAppInterface.getApplication().getSharedPreferences("sp_gamebox_public_summary_".concat(qQAppInterface.getCurrentUin()), 0);
            String string = sharedPreferences.getString("lastPublicContentStr", "");
            if (!TextUtils.isEmpty(string)) {
                msgSummary.strContent = new QQText(string, 3, 16, -1);
                msgSummary.mEmojiFlag = sharedPreferences.getInt("lastPublicPicFlag", 0);
                msgSummary.nState = sharedPreferences.getInt("lastPublicState", 0);
            }
        }
    }
}

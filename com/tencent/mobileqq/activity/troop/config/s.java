package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ay;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class s extends com.tencent.mobileqq.troop.api.config.r {
    static IPatchRedirector $redirector_;

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_FILE_NEW, String.valueOf(j3), aVar.f301847d);
    }

    private void d(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_ACTIVITY_NEW, String.valueOf(j3), aVar.f301847d);
    }

    private void e(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (aVar.f301847d == -1) {
            ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM, aVar.f301845b, true);
        } else {
            ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).removeGroupTIMFileNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM, aVar.f301845b);
        }
    }

    private void f(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 troop mini app entrance.");
        }
        if (aVar.f301847d != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setAIOTroopMiniAppEntranceRedPoint(appInterface, aVar.f301845b, z16);
        ((qt2.a) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).b(com.tencent.mobileqq.troop.observer.i.f298026h, true, new Object[]{aVar.f301845b, Boolean.valueOf(z16)});
    }

    private void h(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.f301847d > 0) {
            ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp((QQAppInterface) appInterface, aVar.f301845b, true);
            ((qt2.a) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).b(com.tencent.mobileqq.troop.observer.i.f298027i, true, new Object[]{aVar.f301845b});
        } else {
            ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp((QQAppInterface) appInterface, aVar.f301845b, false);
        }
    }

    private void i(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("hw_troop", 2, "handle_oidb_0x8c9_2_response, troopUin=" + aVar.f301845b + ", nNewNum=" + aVar.f301847d);
        }
        ((IHWTroopUtilsApi) QRoute.api(IHWTroopUtilsApi.class)).setAIOHomeworkBtnRedPoint((QQAppInterface) appInterface, aVar.f301845b, aVar.f301847d);
        ((qt2.a) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).b(com.tencent.mobileqq.troop.observer.i.f298024e, true, new Object[]{String.valueOf(j3), String.valueOf(1104445552), Boolean.FALSE});
    }

    private void j(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (aVar.f301847d == -1 && ((ay) appInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)) != null) {
            String.valueOf(j3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopRedDotHandlerProcessorQ.hotchat.aio_post_red_point", 2, "handle_oidb_0x8c9_2_response, msgInfo.nUnreadMsgNum:" + aVar.f301846c);
        }
    }

    private void k(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_ALBUM_NEW_PHOTOES, String.valueOf(j3), aVar.f301847d);
        ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(appInterface, String.valueOf(j3), "troop", 2, aVar.f301847d);
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_ALBUM_MESSAGE, String.valueOf(j3), aVar.f301846c);
    }

    private void l(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 remindAddTroopAppGrayTips.");
        }
        TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) appInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
        troopShortcutBarManager.v(j3, aVar.f301847d);
        troopShortcutBarManager.e(String.valueOf(j3));
    }

    private void m(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 troopAppTroopMgr.");
        }
        ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(appInterface, String.valueOf(j3), "troop", 5, aVar.f301847d);
    }

    private void n(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) appInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        if (aVar.f301847d > 0 && troopBatchAddFriendMgr != null) {
            troopBatchAddFriendMgr.I(aVar.f301845b);
        }
    }

    private void o(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        int i3 = aVar.f301847d;
        if (i3 != -1 && i3 <= 0) {
            if (i3 == 0) {
                ChatActivityUtils.V((QQAppInterface) appInterface, aVar.f301845b, 0);
            }
        } else {
            ChatActivityUtils.V((QQAppInterface) appInterface, aVar.f301845b, -1);
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "handle_oidb_0x8c9_2_response, troopUin=" + aVar.f301845b + ", nNewNum=" + aVar.f301847d);
        }
    }

    private void p(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(appInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_TROOP_NOTIFICATION_NEW, String.valueOf(j3), aVar.f301847d);
    }

    @Override // com.tencent.mobileqq.troop.api.config.r
    public void a(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        } else if (appInterface instanceof QQAppInterface) {
            ChatActivityUtils.V((QQAppInterface) appInterface, str, 0);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.r
    public void b(@NonNull AppInterface appInterface, long j3, @NonNull com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3), aVar);
            return;
        }
        long j16 = aVar.f301844a;
        if (j16 == 1105933138) {
            j(appInterface, j3, aVar);
            return;
        }
        if (j16 == 2) {
            k(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1) {
            c(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1101236949) {
            p(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1101484419) {
            d(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1102858908) {
            o(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1104445552) {
            i(appInterface, j3, aVar);
            return;
        }
        if (j16 == 101509131) {
            n(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1106588005) {
            g(appInterface, j3, aVar);
            return;
        }
        if (j16 == 1106664488) {
            e(appInterface, j3, aVar);
            return;
        }
        if (j16 == 101618516) {
            f(appInterface, j3, aVar);
            return;
        }
        if (j16 == 101872323) {
            h(appInterface, j3, aVar);
            return;
        }
        if (j16 == 101896870) {
            l(appInterface, j3, aVar);
            return;
        }
        if (j16 == 101913298) {
            m(appInterface, j3, aVar);
        } else if (((tt2.a) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SURVEY_HANDLER)).e2(aVar, null, 1) && QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handle_oidb_0x8c9_2_response() msginfo handled by Oidb0xb36");
        }
    }

    private void g(@NonNull AppInterface appInterface, long j3, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
    }
}

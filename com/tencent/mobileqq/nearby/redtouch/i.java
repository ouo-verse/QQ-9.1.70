package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.bk;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class i {
    public static boolean a(QQAppInterface qQAppInterface) {
        return ((bk) qQAppInterface.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER)).c();
    }

    public static boolean b(QQAppInterface qQAppInterface) {
        boolean z16 = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + qQAppInterface.getCurrentAccountUin(), 4).getBoolean("medal_switch_disable", false);
        if (QLog.isColorLevel()) {
            QLog.d("Q.redtouch.util", 2, "card.medalSwitchDisable=" + z16);
        }
        boolean z17 = ea.x0(qQAppInterface.getApplication(), qQAppInterface.getCurrentAccountUin()) != 1;
        if (z17 && QLog.isColorLevel()) {
            QLog.d("Q.redtouch.util", 2, "medal config off");
        }
        return (z16 || z17) ? false : true;
    }

    public static void c(QQAppInterface qQAppInterface, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.redtouch.util", 2, "onLikeRankListConfigChanged configOn:" + z16 + " refresh parents");
        }
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
        if (localRedTouchManager.e(j3)) {
            j3.isClosed = z16;
            localRedTouchManager.t(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
        }
    }

    public static void d(QQAppInterface qQAppInterface, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.redtouch.util", 2, "onMedalConfigChanged configOn:" + z16 + " refresh parents");
        }
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(10016);
        if (localRedTouchManager.e(j3)) {
            j3.isClosed = z16;
            localRedTouchManager.t(10016);
        }
        RedTouchItem j16 = localRedTouchManager.j(10015);
        if (localRedTouchManager.e(j16)) {
            j16.isClosed = z16;
            localRedTouchManager.t(10015);
        }
    }
}

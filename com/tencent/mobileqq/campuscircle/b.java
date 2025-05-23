package com.tencent.mobileqq.campuscircle;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.g;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static b f201027d;

    b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static b b() {
        if (f201027d == null) {
            synchronized (b.class) {
                if (f201027d == null) {
                    f201027d = new b("CampusCircleIpcServer_Model");
                }
            }
        }
        return f201027d;
    }

    private EIPCResult c(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface = null;
        if (!"action_get_red_point".equals(str) || bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle2;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("CampusCircleIpcServer", 2, "getRedPoint, app is null");
            }
            bundle2.putBoolean("hasRedTouch", false);
            bundle2.putInt("type", -1);
            bundle2.putInt("count", 0);
            bundle2.putLong("seq", -1L);
            bundle2.putInt("code", -1);
            eIPCResult.code = -1;
        } else {
            RedTouchItem j3 = ((LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).j(103421);
            if (j3 != null) {
                bundle2.putBoolean("hasRedTouch", j3.unReadFlag);
                bundle2.putInt("type", j3.redtouchType);
                bundle2.putInt("count", j3.count);
                bundle2.putLong("seq", j3.curSeq);
                bundle2.putInt("code", 0);
                eIPCResult.code = 0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("CampusCircleIpcServer", 2, "getRedPoint, unreadMsg is null");
                }
                bundle2.putBoolean("hasRedTouch", false);
                bundle2.putInt("type", -1);
                bundle2.putInt("count", 0);
                bundle2.putLong("seq", -1L);
                bundle2.putInt("code", -1);
                eIPCResult.code = -1;
            }
        }
        return eIPCResult;
    }

    private EIPCResult d(String str, Bundle bundle, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "getTroopMembers action: %s", str));
        }
        Object[] d16 = g.d(bundle.getString("troopUin"));
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = new Bundle();
        if (d16 != null && d16.length == 3) {
            eIPCResult.code = 0;
            boolean booleanValue = ((Boolean) d16[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) d16[1]).booleanValue();
            ArrayList arrayList = (ArrayList) d16[2];
            if (arrayList != null) {
                eIPCResult.data.putSerializable("troopUin", arrayList);
            }
            eIPCResult.data.putBoolean("isAdmin", booleanValue);
            eIPCResult.data.putBoolean("enableMemInvite", booleanValue2);
        } else {
            eIPCResult.code = -1;
        }
        return eIPCResult;
    }

    private EIPCResult e(String str, Bundle bundle) {
        QQAppInterface qQAppInterface;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("CampusCircleIpcServer", 2, "isInTroopAIO, app is null");
            }
            return null;
        }
        boolean g16 = g.g(qQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, "isInTroopAIO, isInAIO " + g16);
        }
        EIPCResult eIPCResult = new EIPCResult();
        Bundle bundle2 = new Bundle();
        eIPCResult.data = bundle2;
        bundle2.putBoolean("isInTroopAIO", g16);
        return eIPCResult;
    }

    private EIPCResult f(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        if (QLog.isDevelopLevel()) {
            QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "reportConfessRedPoint action: %s", str));
        }
        if (!"action_confess_clear_red_point".equals(str)) {
            return null;
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MedalWallMng", 2, "reportRedPoint_confess, app is null");
            }
            return null;
        }
        if ("frd_rec_confess".equals(bundle.getString("tag"))) {
            ConfessMsgUtil.i(qQAppInterface, false);
        }
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        eIPCResult.code = 0;
        super.callbackResult(i3, eIPCResult);
        return null;
    }

    private EIPCResult g(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "reportMedalRedPoint action: %s", str));
        }
        if (!"action_report_medal_red_point".equals(str)) {
            return null;
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MedalWallMng", 2, "reportMedalRedPoint, app is null");
            }
            return null;
        }
        ((MedalWallMng) qQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).u(2, null);
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        eIPCResult.code = 0;
        super.callbackResult(i3, eIPCResult);
        return null;
    }

    private EIPCResult h(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        String str2;
        long j3;
        RedTouchItem redTouchItem;
        if (!"action_report_red_point".equals(str) || bundle == null) {
            return null;
        }
        long j16 = bundle.getLong("seq", -1L);
        if (j16 < 0) {
            QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, webSeq < 0:" + j16);
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, app is null");
            }
            return null;
        }
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j17 = localRedTouchManager.j(103421);
        if (j17 == null) {
            QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, unReadMsg is null, return");
            EIPCResult eIPCResult = new EIPCResult();
            eIPCResult.data = null;
            eIPCResult.code = -1;
            super.callbackResult(i3, eIPCResult);
            return null;
        }
        long j18 = j17.curSeq;
        if (j16 >= j18) {
            localRedTouchManager.u(103421);
            redTouchItem = j17;
            str2 = "CampusCircleIpcServer";
            j3 = j18;
        } else {
            j17.count = (int) Math.abs(j18 - j16);
            if (QLog.isColorLevel()) {
                QLog.d("CampusCircleIpcServer", 2, "unreadmsg.coung set to " + j17.count);
            }
            str2 = "CampusCircleIpcServer";
            j3 = j18;
            redTouchItem = j17;
            localRedTouchManager.w(103421, true, j16, true, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d(str2, 2, "reportRedPoint, localSeq=" + j3 + ", webSeq=" + j16 + ", unreadMsg=" + redTouchItem);
        }
        ((IRedTouchServer) qQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(qQAppInterface);
        EIPCResult eIPCResult2 = new EIPCResult();
        eIPCResult2.data = bundle;
        eIPCResult2.code = 0;
        super.callbackResult(i3, eIPCResult2);
        return null;
    }

    private EIPCResult i(String str, Bundle bundle) {
        QQAppInterface qQAppInterface;
        if (QLog.isDevelopLevel()) {
            QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "updateConfessSwitch action: %s", str));
        }
        if (!"action_confess_update_switch".equals(str)) {
            return null;
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("CampusCircleIpcServer", 2, "updateConfessSwitch, app is null");
            }
            return null;
        }
        int i3 = bundle.getInt("nSwitchValue");
        CTEntryMng cTEntryMng = (CTEntryMng) qQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG);
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = cTEntryMng.l(1);
        cTEntryMng.N(l3, (short) i3);
        cTEntryMng.u(l3);
        EIPCResult eIPCResult = new EIPCResult();
        Bundle bundle2 = new Bundle();
        eIPCResult.data = bundle2;
        bundle2.putInt("ret", 0);
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcServer", 2, "updateConfessSwitch, nSwitchValue: " + i3);
        }
        return eIPCResult;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        if (bundle == null) {
            QLog.d("CampusCircleIpcServer", 1, "onCall, param is null, action=" + str + ", callBackId=" + i3);
            return null;
        }
        if ("action_get_red_point".equals(str)) {
            return c(str, bundle, i3);
        }
        if ("action_report_red_point".equals(str)) {
            return h(str, bundle, i3);
        }
        if ("action_report_medal_red_point".equals(str)) {
            return g(str, bundle, i3);
        }
        if ("action_allpeoplevote_getredpoint".equals(str)) {
            return com.tencent.mobileqq.wholepeople.a.b(str, bundle, i3);
        }
        if ("action_allpeoplevote_clearredpoint".equals(str)) {
            return com.tencent.mobileqq.wholepeople.a.a(str, bundle, i3);
        }
        if ("action_confess_clear_red_point".equals(str)) {
            return f(str, bundle, i3);
        }
        if ("action_confess_get_troop_members".equals(str)) {
            return d(str, bundle, i3);
        }
        if ("action_confess_is_in_troop_aio".equals(str)) {
            return e(str, bundle);
        }
        if ("action_confess_update_switch".equals(str)) {
            return i(str, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcServer", 1, "onCall, invalid action:" + str);
        }
        return null;
    }
}

package com.tencent.mobileqq.service.qzone;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZonePadApi;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static boolean a(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(1018);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            return true;
        }
        return false;
    }

    public static boolean b(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        ArrayList<QZoneCountUserInfo> arrayList;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(6);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo == null || (arrayList = qZoneCountInfo.friendList) == null || arrayList.size() <= 0 || qZoneCountInfo.friendList.get(0).uin <= 0 || qZoneCountInfo.uCount <= 0) {
            return false;
        }
        return true;
    }

    public static boolean c(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(1017);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            return true;
        }
        return false;
    }

    public static boolean d(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(74);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            return true;
        }
        return false;
    }

    public static boolean e(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(67);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null && !((IQZonePadApi) QRoute.api(IQZonePadApi.class)).isMomentSwitchClosed()) {
            return true;
        }
        return false;
    }

    public static boolean f(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(2);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null && qZoneCountInfo.uCount > 0 && qZoneManagerImp.l() != null && qZoneManagerImp.l().size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean g(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        ArrayList<QZoneCountUserInfo> arrayList;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(61);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo == null || (arrayList = qZoneCountInfo.friendList) == null || arrayList.size() <= 0 || qZoneCountInfo.friendList.get(0).uin <= 0 || qZoneCountInfo.uCount <= 0) {
            return false;
        }
        return true;
    }

    private static int h(QZoneManagerImp qZoneManagerImp) {
        if (b(qZoneManagerImp)) {
            return 6;
        }
        if (c(qZoneManagerImp)) {
            return 1017;
        }
        if (k(qZoneManagerImp)) {
            return 1013;
        }
        if (a(qZoneManagerImp)) {
            return 1018;
        }
        if (g(qZoneManagerImp)) {
            return 61;
        }
        return 0;
    }

    public static List<Integer> i(QZoneManagerImp qZoneManagerImp) {
        ArrayList arrayList = new ArrayList();
        if (qZoneManagerImp == null) {
            QLog.e("QZoneRedDotManager", 1, "manager impl is null");
            return arrayList;
        }
        if (qZoneManagerImp.j(1) > 0) {
            arrayList.add(1);
        }
        if (qZoneManagerImp.j(73) > 0) {
            arrayList.add(73);
        }
        if (qZoneManagerImp.j(66) > 0) {
            arrayList.add(66);
        }
        return arrayList;
    }

    public static int j(QZoneManagerImp qZoneManagerImp, boolean z16) {
        if (qZoneManagerImp == null) {
            QLog.e("QZoneRedDotManager", 1, "manager impl is null");
            return 0;
        }
        if (f(qZoneManagerImp)) {
            return 2;
        }
        if (d(qZoneManagerImp)) {
            return 74;
        }
        if (e(qZoneManagerImp)) {
            return 67;
        }
        if (l(qZoneManagerImp)) {
            return 3;
        }
        if (!z16) {
            return 0;
        }
        return h(qZoneManagerImp);
    }

    public static boolean k(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(1013);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null && !TextUtils.isEmpty(qZoneCountInfo.strShowMsg) && qZoneCountInfo.uCount > 0) {
            return true;
        }
        return false;
    }

    public static boolean l(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo qZoneCountInfo;
        ArrayList<QZoneCountUserInfo> arrayList;
        if (qZoneManagerImp != null) {
            qZoneCountInfo = qZoneManagerImp.k(3);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo == null || (arrayList = qZoneCountInfo.friendList) == null || arrayList.size() <= 0 || qZoneCountInfo.uCount <= 0) {
            return false;
        }
        return true;
    }
}

package com.tencent.mobileqq.c2cshortcutbar;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51$AioQuickAppData;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static boolean a(QQAppInterface qQAppInterface, String str, int i3) {
        if (i3 == 1) {
            if (!g() || !d(qQAppInterface) || !c(str)) {
                return false;
            }
            return true;
        }
        if (i3 == 2) {
            return e();
        }
        QLog.d("C2CShortcutBarSwitcher", 1, "isC2CShortcutAppEnabled() unknown aioType:", Integer.valueOf(i3));
        return false;
    }

    public static boolean b(PBBytesField pBBytesField) {
        byte[] byteArray = pBBytesField.get().toByteArray();
        Oidb_0xd51$AioQuickAppData oidb_0xd51$AioQuickAppData = new Oidb_0xd51$AioQuickAppData();
        try {
            oidb_0xd51$AioQuickAppData.mergeFrom(byteArray);
            int i3 = oidb_0xd51$AioQuickAppData.uint32_switch.get();
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarSwitcher", 2, "isC2CShortcutBarOpen: invoked status =", Integer.valueOf(i3));
            }
            if (i3 != 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("C2CShortcutBarSwitcher", 1, "isC2CShortcutBarOpen: failed. ", e16);
            return false;
        }
    }

    public static boolean c(String str) {
        boolean z16;
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "C2CShortcutBarSwitcher");
        if (otherSimpleInfoWithUid != null) {
            z16 = otherSimpleInfoWithUid.k().booleanValue();
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarSwitcher", 2, "isC2CSwitcherOpen extensionInfo is null");
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "mAppInterface, type:" + str + " friendUin: isC2CShortcutBarOpen:" + z16);
        }
        return z16;
    }

    public static boolean d(QQAppInterface qQAppInterface) {
        boolean c16;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_c2c_shortcut_bar", 4);
        String str = "switcher_in_assistant_" + qQAppInterface.getCurrentUin();
        if (sharedPreferences.getBoolean("has_set_switcher_in_assistant_" + qQAppInterface.getCurrentUin(), false)) {
            c16 = sharedPreferences.getBoolean(str, true);
        } else {
            c16 = C2CShortcutBarConfProcessor.a().c();
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "isGlobalSwitcherOpen() switcherOpen = ", Boolean.valueOf(c16));
        }
        return c16;
    }

    public static boolean e() {
        d a16 = C2CShortcutBarConfProcessor.a();
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "isKuoLieEnable() isKuoLieEnable = ", Boolean.valueOf(a16.b()));
        }
        return a16.b();
    }

    public static boolean f(QQAppInterface qQAppInterface) {
        if (g() && d(qQAppInterface)) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        d a16 = C2CShortcutBarConfProcessor.a();
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "isShowGlobalEntrance() isShowAssistantEntrance = ", Boolean.valueOf(a16.c()));
        }
        return a16.c();
    }

    public static void h(QQAppInterface qQAppInterface, boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "saveC2CSwitcherStatus() isChecked = ", Boolean.valueOf(z16), " friendUin = ", str);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(uidFromUin, str);
        cVar.m();
        cVar.n(Boolean.valueOf(z16));
        iOtherInfoService.accurateUpdateNTOtherSimpleInfo(new ArrayList<>(Collections.singletonList(cVar)), "C2CShortcutBarSwitcher", (hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
    }

    public static void i(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("sp_c2c_shortcut_bar", 4).edit();
        String str = "switcher_in_assistant_" + qQAppInterface.getCurrentUin();
        edit.putBoolean("has_set_switcher_in_assistant_" + qQAppInterface.getCurrentUin(), true);
        edit.putBoolean(str, z16);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "saveGlobalSwitcherStatus() isChecked = ", Boolean.valueOf(z16));
        }
    }
}

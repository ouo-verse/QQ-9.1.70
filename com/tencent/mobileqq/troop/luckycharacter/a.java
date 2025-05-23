package com.tencent.mobileqq.troop.luckycharacter;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(String str) {
        return BaseApplication.getContext().getSharedPreferences(str, 0).getBoolean(str + "self_troop_lucky_character_switch", true);
    }

    public static boolean b(int i3, int i16) {
        boolean z16;
        boolean z17;
        if ((i16 & 32768) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((i3 & 32768) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 != z17) {
            return true;
        }
        return false;
    }

    public static void c(QQAppInterface qQAppInterface, boolean z16) {
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (a(currentAccountUin) != z16) {
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(currentAccountUin, 0).edit();
            edit.putBoolean(currentAccountUin + "self_troop_lucky_character_switch", z16);
            edit.apply();
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(s.f353245a);
        }
    }
}

package com.tencent.mobileqq.vip;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static Object f313039c;

    /* renamed from: d, reason: collision with root package name */
    private static o f313040d;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, String> f313041a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f313042b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f313039c = new Object();
            f313040d = null;
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        this.f313041a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f313042b = hashMap2;
        hashMap.put(2, "key_svip_item_my_vip_");
        hashMap.put(3, "key_svip_item_makup_");
        hashMap.put(4, "key_svip_item_my_love_zone_");
        hashMap.put(5, "key_svip_item_cu_king_card_");
        hashMap2.put(2, "d_vip_identity");
        hashMap2.put(3, "d_decoration");
        hashMap2.put(5, "d_vip_card");
    }

    public static o a() {
        if (f313040d == null) {
            synchronized (f313039c) {
                if (f313040d == null) {
                    f313040d = new o();
                }
            }
        }
        return f313040d;
    }

    private int e(@NonNull QQAppInterface qQAppInterface, int i3) {
        int i16 = VipMMKV.getSVipQQSettingMe(qQAppInterface.getApplicationContext(), "sp_svip_qqsetting_me").getInt("key_svip_items_flag_" + qQAppInterface.getCurrentAccountUin(), i3);
        if (QLog.isColorLevel()) {
            QLog.d("QSetting.ConfigManager", 1, "get sp key:key_svip_items_flag_" + qQAppInterface.getCurrentAccountUin() + " value=" + i16);
        }
        return i16;
    }

    private void i(SharedPreferences sharedPreferences, String str, int i3) {
        if (i3 < 0) {
            sharedPreferences.edit().putInt(str, i3);
            if (QLog.isColorLevel()) {
                QLog.d("QSetting.ConfigManager", 1, "set sp key:" + str + " value=" + i3);
                return;
            }
            return;
        }
        sharedPreferences.edit().putInt(str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("QSetting.ConfigManager", 1, "set sp key:" + str + " value=0");
        }
    }

    private void k(SharedPreferences sharedPreferences, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            sharedPreferences.edit().putString(str, str2);
            if (QLog.isDevelopLevel()) {
                QLog.d("QSetting.ConfigManager", 1, "set sp key:" + str + " value=" + str2);
                return;
            }
            return;
        }
        sharedPreferences.edit().putString(str, null);
        if (QLog.isDevelopLevel()) {
            QLog.d("QSetting.ConfigManager", 1, "set sp key:" + str + " value=null");
        }
    }

    private void l(@NonNull QQAppInterface qQAppInterface, int i3) {
        SharedPreferences sVipQQSettingMe = VipMMKV.getSVipQQSettingMe(qQAppInterface.getApplicationContext(), "sp_svip_qqsetting_me");
        String str = "key_svip_items_flag_" + qQAppInterface.getCurrentAccountUin();
        sVipQQSettingMe.edit().putInt(str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("QSetting.ConfigManager", 1, "set sp key:" + str + " value=" + i3);
        }
    }

    public int b(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) num)).intValue();
        }
        return 1 << num.intValue();
    }

    public MenumItem c(@NonNull QQAppInterface qQAppInterface, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MenumItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface, (Object) str);
        }
        MenumItem menumItem = new MenumItem();
        SharedPreferences sVipQQSettingMe = VipMMKV.getSVipQQSettingMe(qQAppInterface.getApplicationContext(), "sp_svip_qqsetting_me");
        menumItem.title = sVipQQSettingMe.getString(str + "key_title_" + qQAppInterface.getCurrentAccountUin(), "");
        menumItem.icon = sVipQQSettingMe.getString(str + "key_icon_" + qQAppInterface.getCurrentAccountUin(), "");
        menumItem.jumpurl = sVipQQSettingMe.getString(str + "key_jumpurl_" + qQAppInterface.getCurrentAccountUin(), "");
        menumItem.user_group = sVipQQSettingMe.getInt(str + "key_user_group_" + qQAppInterface.getCurrentAccountUin(), 0);
        menumItem.jumpurl_tab_expid = sVipQQSettingMe.getString(str + "key_jumpurl_tab_" + qQAppInterface.getCurrentAccountUin(), "");
        if (QLog.isColorLevel()) {
            QLog.d("QSetting.ConfigManager", 1, "get sp itemKey:" + str + " icon = " + menumItem.icon + " title = " + menumItem.title);
        }
        return menumItem;
    }

    public Map<Integer, MenumItem> d(@NonNull QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
        }
        HashMap hashMap = new HashMap();
        int e16 = e(qQAppInterface, 0);
        for (Integer num : this.f313041a.keySet()) {
            if (((1 << num.intValue()) & e16) != 0) {
                hashMap.put(num, c(qQAppInterface, this.f313041a.get(num)));
            } else if (2 != num.intValue() && 5 != num.intValue()) {
                hashMap.put(num, null);
            }
        }
        return hashMap;
    }

    public String f(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) num);
        }
        String str = this.f313042b.get(num);
        if (str == null) {
            QLog.d("QSetting.ConfigManager", 1, "\u6ce8\u518c\u8868 : QQSettingConfigManager.jceIDWithItemIdMap : itemId " + num + "\u4e0d\u5b58\u5728");
            return "";
        }
        return str;
    }

    public void g(@NonNull QQAppInterface qQAppInterface, Map<Integer, MenumItem> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) map);
            return;
        }
        if (map == null) {
            return;
        }
        int i3 = 0;
        for (Integer num : map.keySet()) {
            String str = this.f313041a.get(num);
            i3 |= b(num);
            if (!TextUtils.isEmpty(str)) {
                j(qQAppInterface, str, map.get(num));
                if (!TextUtils.isEmpty(map.get(num).icon)) {
                    VasApngUtil.getApngURLDrawable(map.get(num).icon, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
                }
            }
        }
        l(qQAppInterface, i3);
    }

    public boolean h(@NonNull QQAppInterface qQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQAppInterface, i3)).booleanValue();
        }
        int e16 = e(qQAppInterface, 0);
        if (4 == i3 && (e16 & 4) == 0) {
            return false;
        }
        if (32 == i3 && (e16 & 32) == 0) {
            return false;
        }
        Iterator<Integer> it = this.f313041a.keySet().iterator();
        while (it.hasNext()) {
            if (b(it.next()) == i3) {
                return true;
            }
        }
        return false;
    }

    public void j(@NonNull QQAppInterface qQAppInterface, @NonNull String str, MenumItem menumItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, str, menumItem);
            return;
        }
        SharedPreferences sVipQQSettingMe = VipMMKV.getSVipQQSettingMe(qQAppInterface.getApplicationContext(), "sp_svip_qqsetting_me");
        k(sVipQQSettingMe, str + "key_icon_" + qQAppInterface.getCurrentAccountUin(), menumItem.icon);
        k(sVipQQSettingMe, str + "key_title_" + qQAppInterface.getCurrentAccountUin(), menumItem.title);
        i(sVipQQSettingMe, str + "key_user_group_" + qQAppInterface.getCurrentAccountUin(), menumItem.user_group);
        k(sVipQQSettingMe, str + "key_jumpurl_" + qQAppInterface.getCurrentAccountUin(), menumItem.jumpurl);
        k(sVipQQSettingMe, str + "key_jumpurl_tab_" + qQAppInterface.getCurrentAccountUin(), menumItem.jumpurl_tab_expid);
    }
}

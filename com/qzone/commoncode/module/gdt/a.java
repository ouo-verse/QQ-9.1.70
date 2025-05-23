package com.qzone.commoncode.module.gdt;

import NS_MOBILE_FEEDS.cnst.GDT_ADV_COOKIE;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static String a() {
        SharedPreferences cachePreference = PreferenceManager.getCachePreference(BaseApplication.getContext(), LoginData.getInstance().getUin());
        if (cachePreference == null) {
            return null;
        }
        return cachePreference.getString(GDT_ADV_COOKIE.value, null);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str) || PreferenceManager.getCachePreference(BaseApplication.getContext(), LoginData.getInstance().getUin()) == null) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getCachePreference(BaseApplication.getContext(), LoginData.getInstance().getUin()).edit();
        edit.putString(GDT_ADV_COOKIE.value, str);
        edit.commit();
    }
}

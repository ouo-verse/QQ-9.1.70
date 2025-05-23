package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
public class at {
    public static void a(String str) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(AppConstants.HISTORY_CHAT_MSG_SEARCH_KEY_PREF, 0).edit();
        edit.remove(b(str));
        edit.commit();
    }

    private static String b(String str) {
        return str;
    }
}

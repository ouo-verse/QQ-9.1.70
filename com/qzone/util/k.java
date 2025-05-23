package com.qzone.util;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes37.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final SharedPreferences f59825a = BaseApplicationImpl.sApplication.getSharedPreferences("qzone_detail_game_sp", 0);

    public static boolean a(String str) {
        SharedPreferences sharedPreferences = f59825a;
        if (!sharedPreferences.getBoolean(str, true)) {
            return false;
        }
        sharedPreferences.edit().putBoolean(str, false).apply();
        return true;
    }
}

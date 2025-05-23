package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;

/* compiled from: P */
/* loaded from: classes20.dex */
public class j {
    public static void a() {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("BuglySdkInfos", 0);
        if (!sharedPreferences.contains("c87e09e876")) {
            String qua3 = QUA.getQUA3();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("c87e09e876", qua3);
            edit.apply();
        }
    }
}

package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cb extends com.tencent.mobileqq.troop.api.config.a {
    @Override // com.tencent.mobileqq.troop.api.config.a
    public void a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return;
        }
        arrayList.add(AppConstants.RoamingMapPath.C2C_ROAMING_MSG);
        arrayList.add(AppConstants.RoamingMapPath.ALL_RING);
        arrayList.add(AppConstants.RoamingMapPath.ALL_VIBRATE);
        arrayList.add(AppConstants.RoamingMapPath.SPECIAL_CARE_RING);
    }

    @Override // com.tencent.mobileqq.troop.api.config.a
    public int b(String str) {
        if (str.contains(AppConstants.RoamingMapPath.ALL_RING)) {
            return 4;
        }
        if (str.contains(AppConstants.RoamingMapPath.ALL_VIBRATE)) {
            return 5;
        }
        if (str.contains(AppConstants.RoamingMapPath.C2C_ROAMING_MSG)) {
            return 6;
        }
        if (str.contains(AppConstants.RoamingMapPath.SPECIAL_CARE_RING)) {
            return 7;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.troop.api.config.a
    public String c(int i3) {
        if (i3 == 4 || i3 == 5) {
            return "";
        }
        if (i3 == 6) {
            return String.valueOf(1);
        }
        if (i3 == 7) {
            return String.valueOf(0);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.config.a
    public void d(String str, String str2) {
        if (AppConstants.RoamingMapPath.ALL_RING.equals(str) || AppConstants.RoamingMapPath.ALL_VIBRATE.equals(str) || AppConstants.RoamingMapPath.SPECIAL_CARE_RING.equals(str)) {
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), 0).edit();
            try {
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}

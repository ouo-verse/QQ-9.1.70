package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class aq {
    static IPatchRedirector $redirector_;

    public static Bundle a(int i3, String str, String str2, String str3, String str4, String str5, byte b16, long j3, short s16, String str6, String str7, int i16, String str8, String str9, boolean z16, String str10, long j16, long j17, int i17) {
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", str);
        bundle.putInt(AppConstants.Key.TROOP_INFO_FROM, i3);
        bundle.putInt(AppConstants.Key.TROOP_INFO_FROM_EX, i17);
        bundle.putString(AppConstants.Key.TROOP_CODE, str2);
        bundle.putString(AppConstants.Key.TROOP_INFO_NAME, str3);
        bundle.putString(AppConstants.Key.TROOP_INFO_OWNER, str4);
        bundle.putString(AppConstants.Key.TROOP_INFO_ADMI, str5);
        bundle.putByte(AppConstants.Key.TROOP_INFO_OPT, b16);
        bundle.putLong(AppConstants.Key.TROOP_INFO_CLASSEXT, j3);
        bundle.putShort(AppConstants.Key.TROOP_INFO_FACEID, s16);
        bundle.putString(AppConstants.Key.TROOP_INFO_FINGERMEMO, str6);
        bundle.putString(AppConstants.Key.TROOP_INFO_SCHOOL_LOCATION, str7);
        bundle.putString(AppConstants.Key.TROOP_INFO_SCHOOL_SCHOOLID, str8);
        bundle.putInt(AppConstants.Key.TROOP_INFO_SCHOOL_GRADE, i16);
        bundle.putString(AppConstants.Key.TROOP_INFO_LOCA, str9);
        bundle.putBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER, z16);
        bundle.putString("param_return_addr", str10);
        bundle.putLong(AppConstants.Key.TROOP_INFO_FLAG_EXT, j16);
        bundle.putLong(AppConstants.Key.TROOP_INFO_AUTH_TYPE, j17);
        return bundle;
    }

    public static Bundle b(String str, int i3) {
        return d(str, "", i3);
    }

    public static Bundle c(String str, int i3, int i16, int i17, int i18, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", str);
        bundle.putInt(AppConstants.Key.TROOP_INFO_FROM, i3);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(AppConstants.Key.TROOP_INFO_LOCA, str2);
        }
        bundle.putInt(AppConstants.Key.TROOP_INFO_LAT, i16);
        bundle.putInt(AppConstants.Key.TROOP_INFO_LON, i17);
        bundle.putInt(AppConstants.Key.TROOP_INFO_CITYID, i18);
        return bundle;
    }

    public static Bundle d(String str, String str2, int i3) {
        return e(str, str2, i3, null);
    }

    public static Bundle e(String str, String str2, int i3, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", str);
        bundle.putInt(AppConstants.Key.TROOP_INFO_FROM, i3);
        bundle.putString("authSig", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString("param_scene_target_id", str3);
        }
        return bundle;
    }
}

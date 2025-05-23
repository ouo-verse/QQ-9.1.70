package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.g;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f204252a = 300;

    public static String a(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            return AppConstants.SDCARD_IMG_CAMERA_EMO + g.d(str2) + str;
        }
        return "";
    }

    public static String b(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split.length <= 2) {
            return "";
        }
        return split[1];
    }
}

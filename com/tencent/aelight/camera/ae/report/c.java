package com.tencent.aelight.camera.ae.report;

import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {
    public static String a() {
        return new SimpleDateFormat(ZPlanBubbleRedDotController.DismissType.TIME_FORMAT).format(new Date());
    }

    public static boolean c() {
        return AECameraPrefsUtil.f().g("AEKIT_CAMERA_FIRST_LAUNCH", 0, 0) == 0;
    }

    public static boolean d() {
        if (AECameraPrefsUtil.f().a("sp_key_ae_camera_launch_mark", 0)) {
            return false;
        }
        AECameraPrefsUtil.f().l("sp_key_ae_camera_launch_mark", true, 0);
        return true;
    }

    public static String e(Long l3) {
        return new DecimalFormat("0.00").format(((float) l3.longValue()) / 1000.0f);
    }

    public static void f() {
        AECameraPrefsUtil.f().n("AEKIT_CAMERA_FIRST_LAUNCH", 1, 0);
    }

    public static HashMap<String, String> g(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap<String, String> hashMap3 = new HashMap<>(hashMap);
            for (String str : hashMap2.keySet()) {
                hashMap3.put(str, hashMap2.get(str));
            }
            return hashMap3;
        } catch (Exception unused) {
            return hashMap;
        }
    }

    public static String b(int i3) {
        if (i3 == 1) {
            return "1";
        }
        return "2";
    }
}

package com.tencent.aelight.camera.ae.flashshow.util;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    public static int b(int i3) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("PTV.NewFlowCameraActivity", 4);
        long j3 = sharedPreferences.getLong("key_open_camera_time_new", 0L);
        return (j3 == 0 || System.currentTimeMillis() - j3 >= MiniBoxNoticeInfo.MIN_5) ? i3 : sharedPreferences.getInt("camera_new", i3);
    }

    public static boolean c() {
        return BaseApplication.getContext().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getBoolean("camera_flash_on_new", false);
    }

    public static void d(boolean z16) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
        edit.putBoolean("camera_flash_on_new", z16);
        edit.apply();
    }

    public static void e(int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
        edit.putInt("camera_new", i3);
        edit.putLong("key_open_camera_time_new", System.currentTimeMillis());
        edit.apply();
    }

    public static int a() {
        return b(2);
    }
}

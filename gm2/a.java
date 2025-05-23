package gm2;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static int a() {
        return b(2);
    }

    public static int b(int i3) {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4);
        long j3 = sharedPreferences.getLong("key_open_camera_time", 0L);
        if (j3 != 0 && System.currentTimeMillis() - j3 < MiniBoxNoticeInfo.MIN_5) {
            return sharedPreferences.getInt("camera", i3);
        }
        return i3;
    }

    public static boolean c() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).contains("camera");
    }

    public static void d(int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
        edit.putInt("camera", i3);
        edit.putLong("key_open_camera_time", System.currentTimeMillis());
        edit.apply();
    }

    public static void e() {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
        edit.putLong("key_open_camera_time", System.currentTimeMillis());
        edit.apply();
    }
}

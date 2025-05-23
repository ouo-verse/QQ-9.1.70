package com.tencent.av.camera;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavCameraUsage {

    /* renamed from: a, reason: collision with root package name */
    public static String f73493a;

    public static boolean a(Context context) {
        return b(context, true);
    }

    public static boolean b(final Context context, boolean z16) {
        boolean z17;
        boolean z18 = false;
        if (context == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            z17 = false;
            while (it.hasNext()) {
                if (it.next().processName.equals(Constants.Process.VIDEO_PROCESS)) {
                    z17 = true;
                }
            }
        } else {
            z17 = false;
        }
        if (z17) {
            z18 = d(context);
        }
        if (z18 && z16) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.av.camera.QavCameraUsage.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    QQToast.makeText(context2, context2.getString(R.string.z_l), 0).show();
                }
            });
        }
        return z18;
    }

    public static void c(Context context, String str) {
        if (context == null) {
            return;
        }
        QLog.w("QavCameraUsage", 1, "clearCameraUsageState, cameraIsUsing[" + f73493a + "], type[" + str + "]");
        f73493a = null;
        SharedPreferences.Editor edit = context.getSharedPreferences("qav_camera_usage_sp", 4).edit();
        edit.remove("camera_used_desc");
        edit.putBoolean("camera_used", false);
        edit.commit();
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        String string = context.getSharedPreferences("qav_camera_usage_sp", 4).getString("camera_used_desc", null);
        QLog.w("QavCameraUsage", 1, "getCameraUsageState, cameraIsUsing[" + string + "]");
        if (string == null) {
            return false;
        }
        return true;
    }

    public static void e(Context context, String str) {
        if (context == null) {
            return;
        }
        String str2 = f73493a;
        String str3 = str + "_" + System.currentTimeMillis();
        QLog.w("QavCameraUsage", 1, "setCameraUsageState, last[" + str2 + "], cur[" + str3 + "]");
        f73493a = str3;
        SharedPreferences.Editor edit = context.getSharedPreferences("qav_camera_usage_sp", 4).edit();
        edit.putString("camera_used_desc", str3);
        edit.putBoolean("camera_used", true);
        edit.commit();
    }
}

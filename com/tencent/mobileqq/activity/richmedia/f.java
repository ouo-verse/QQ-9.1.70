package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.r;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static long f185851a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, r> f185852b = new ConcurrentHashMap();

    private static void a(String str, String str2, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
            QLog.d(IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, 2, str);
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put("MANUFACTURER", Build.MANUFACTURER);
        hashMap2.put("MODEL", DeviceInfoMonitor.getModel());
        hashMap2.put("DEVICE_TYPE_NAME", com.tencent.mobileqq.camera.adapter.b.c().b());
        b(hashMap2, IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, str2);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, str2, true, 0L, 0L, hashMap2, null);
    }

    private static void b(Map<String, String> map, String str, String str2) {
        String str3 = "\u4e8b\u4ef6Code : " + str2 + "   \u4e0a\u62a5\u5185\u5bb9 ----------  \n";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str3 = (((str3 + entry.getKey()) + "   :   ") + entry.getValue()) + "\n";
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str3);
        }
    }

    public static void c(String str) {
        d(str, f185851a);
    }

    public static void d(String str, long j3) {
        if (QLog.isColorLevel()) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d("PTV.NewFlowCameraActivity.photo", 2, str + ";" + (currentTimeMillis - j3));
            f185851a = currentTimeMillis;
        }
    }

    public static void e(Intent intent) {
        intent.putExtra("start_intent_time", f185851a);
    }

    public static void f() {
        a("album photo send in minute", StatisticCollector.PHOTO_SEND_FROM_ALBUM_IN_MINUTE, null);
    }

    public static void g() {
        a("enter system camera", StatisticCollector.ENTER_SYSTEM_CAMERA, null);
    }

    public static void h(Camera.Parameters parameters, String str) {
        String str2;
        if (parameters == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, 2, str + "   model compatibility");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("camera_type", str);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String str3 = "";
        if (supportedFlashModes == null || supportedFlashModes.size() <= 0) {
            str2 = "";
        } else {
            str2 = supportedFlashModes.get(0);
            for (int i3 = 1; i3 < supportedFlashModes.size(); i3++) {
                str2 = (str2 + "#") + supportedFlashModes.get(i3);
            }
        }
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.size() > 0) {
            str3 = supportedFocusModes.get(0);
            for (int i16 = 1; i16 < supportedFocusModes.size(); i16++) {
                str3 = (str3 + "#") + supportedFocusModes.get(i16);
            }
        }
        hashMap.put("supported_focus_mode", str3);
        hashMap.put("supported_flash_mode", str2);
        a(null, StatisticCollector.MODEL_COMPATIBILITY, hashMap);
    }

    public static void i() {
        a("photo send from album", StatisticCollector.PHOTO_SEND_FROM_ALBUM, null);
    }

    public static void j(int i3, int i16, int i17, int i18, int i19) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put("previewWidth", "" + i18);
        hashMap.put("previewHeight", "" + i19);
        hashMap.put("wantedWidth", "" + i16);
        hashMap.put("wantedHeight", "" + i17);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, StatisticCollector.SET_PREVIEW_SIZE_WAY, false, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.e("NewFlowCameraReporter", 2, "[reportPreviewSizeWay] STEP=" + i3);
        }
    }

    public static void k(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status", i3 + "");
        if (QLog.isColorLevel()) {
            QLog.d("NewFlowCameraReporter", 2, "reportQQFilterDownload :  " + hashMap.toString());
        }
        b(hashMap, IPtvFilterUtil.DynamicAdjustmentTag, StatisticCollector.QQ_FILTER_DOWNLOAD);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.QQ_FILTER_DOWNLOAD, true, 0L, 0L, hashMap, null);
    }

    public static void l(List<String> list) {
        String str;
        if (list == null || list.size() != 1 || (str = list.get(0)) == null) {
            return;
        }
        if (!str.contains("DCIM/Camera")) {
            if (QLog.isColorLevel()) {
                QLog.d(IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, 2, "not a album path : " + str);
                return;
            }
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        i();
        long j3 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getLong("sv_latest_taken_photo_time", -1L);
        if (j3 == -1) {
            return;
        }
        long lastModified = (file.lastModified() - j3) / 1000;
        if (lastModified > 0 && lastModified < 60) {
            f();
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, 2, "album time diff : " + lastModified);
        }
    }

    public static void m(boolean z16, int i3, int i16, int i17, int i18) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("previewWidth", "" + i3);
        hashMap.put("previewHeight", "" + i16);
        hashMap.put("photoWidth", "" + i17);
        hashMap.put("photoHeight", "" + i18);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SET_PHOTO_CLIP_SIZE, z16, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.e("NewFlowCameraReporter", 2, "[reportSetShootSizeClip] result=" + z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(boolean z16, int i3, int i16, int i17, int i18, boolean z17, int i19, boolean z18) {
        int i26;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            if (z17) {
                i26 = 10;
            } else if (i19 != 0) {
                i26 = 20;
            } else if (z18) {
                i26 = 30;
            }
            hashMap.put("param_FailCode", String.valueOf(i26));
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            hashMap.put("previewWidth", "" + i3);
            hashMap.put("previewHeight", "" + i16);
            hashMap.put("photoWidth", "" + i17);
            hashMap.put("photoHeight", "" + i18);
            hashMap.put(BasicAnimation.KeyPath.ROTATION, "" + i19);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SHOOT_PHOTO_CLIP, z16 ^ true, 0L, 0L, hashMap, "");
            if (!QLog.isColorLevel()) {
                QLog.e("NewFlowCameraReporter", 2, "[reportShootPhotoClip] result=" + z16 + "ratioNeedClip " + z17 + " rotation" + i19 + " needFlip" + z18);
                return;
            }
            return;
        }
        i26 = 0;
        hashMap.put("param_FailCode", String.valueOf(i26));
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("previewWidth", "" + i3);
        hashMap.put("previewHeight", "" + i16);
        hashMap.put("photoWidth", "" + i17);
        hashMap.put("photoHeight", "" + i18);
        hashMap.put(BasicAnimation.KeyPath.ROTATION, "" + i19);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SHOOT_PHOTO_CLIP, z16 ^ true, 0L, 0L, hashMap, "");
        if (!QLog.isColorLevel()) {
        }
    }
}

package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.qq.taf.jce.HexUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static void a() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        defaultSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times_fast", defaultSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0) + 1).apply();
    }

    public static void b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        defaultSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times", defaultSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0) + 1).commit();
    }

    public static void c(Intent intent, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("StatisticConstants", 4, "incrementStatisticParam(" + str);
        }
        if (intent != null) {
            intent.putExtra(str, intent.getIntExtra(str, 0) + 1);
        }
    }

    public static void d(long j3, int i3) {
        int i16;
        HashMap<String, String> hashMap = new HashMap<>();
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            i16 = 1002;
        } else {
            i16 = 1001;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        int u16 = ah.u();
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.I0, systemNetwork + "");
        hashMap.put("param_phone_type", u16 + "");
        hashMap.put("param_userType", i16 + "");
        hashMap.put("param_WasteSize", j3 + "");
        hashMap.put("param_cancelType", i3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSWaste", false, 0L, 0L, hashMap, "", false);
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportActPSWaste,size = " + j3 + ",cancelType = " + i3);
        }
    }

    public static void e(Intent intent, int i3) {
        if (!intent.hasExtra(QAlbumConstants.PARAM_INITTIME)) {
            return;
        }
        long longExtra = intent.getLongExtra(QAlbumConstants.PARAM_INITTIME, 0L);
        if (longExtra == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("StatisticConstants", 2, "reportActPScancelSend,initTime == 0,return!");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - longExtra;
        if (currentTimeMillis > 86400000) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.I0, NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
        hashMap.put("param_selNum", i3 + "");
        hashMap.put("param_residentTime", currentTimeMillis + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPScancelSend", false, 0L, 0L, hashMap, "", false);
        intent.removeExtra(QAlbumConstants.PARAM_INITTIME);
        intent.removeExtra("param_cancelSelNum");
        intent.removeExtra("param_totalSelNum");
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportActPScancelSend,param_residentTime =" + currentTimeMillis + ",param_selNum = " + i3);
        }
    }

    public static void f(Intent intent) {
        HashMap<String, String> hashMap = new HashMap<>();
        long j3 = 0;
        long longExtra = intent.getLongExtra("param_compressInitTime", 0L);
        if (longExtra == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("StatisticConstants", 2, "reportActPScompressPic,initTime == 0,return!");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - longExtra;
        if (currentTimeMillis > 86400000) {
            return;
        }
        int intExtra = intent.getIntExtra("param_selNum", 0);
        if (intExtra == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_selNum == 0,return!");
                return;
            }
            return;
        }
        if (intExtra > 0) {
            j3 = currentTimeMillis / intExtra;
        }
        long j16 = j3;
        hashMap.put("param_consumTime", currentTimeMillis + "");
        hashMap.put("param_selNum", intExtra + "");
        hashMap.put("param_averageTime", j16 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPScompressPic", false, 0L, 0L, hashMap, "", false);
        intent.removeExtra("param_compressInitTime");
        intent.removeExtra("param_selNum");
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_consumTime =" + currentTimeMillis + ",param_selNum = " + intExtra + ",param_averageTime = " + j16);
        }
    }

    public static void g(long j3) {
        int i3;
        if (j3 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,size <= 0,return! size = " + j3);
                return;
            }
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        int u16 = ah.u();
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.I0, systemNetwork + "");
        hashMap.put("param_phone_type", u16 + "");
        hashMap.put("param_userType", i3 + "");
        hashMap.put("param_WasteSize", j3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSdayWastedSize", false, 0L, 0L, hashMap, "", false);
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,WastedSize =" + j3);
        }
    }

    public static void h(long j3, int i3, boolean z16) {
        int i16;
        HashMap<String, String> hashMap = new HashMap<>();
        if (j3 != 0 && i3 != 0 && j3 <= 86400000) {
            long j16 = j3 / i3;
            int u16 = ah.u();
            if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
                i16 = 1002;
            } else {
                i16 = 1001;
            }
            hashMap.put("param_userType", i16 + "");
            hashMap.put("param_phone_type", u16 + "");
            hashMap.put("param_consumTime", j3 + "");
            hashMap.put("param_selNum", i3 + "");
            hashMap.put("param_showing_progress", z16 + "");
            hashMap.put("param_averageTime", j16 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSdonecompressPic", false, 0L, 0L, hashMap, "", false);
            if (QLog.isColorLevel()) {
                QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,param_consumTime =" + j3 + ",param_selNum = " + i3 + ",param_averageTime = " + j16 + ",isShowing = " + z16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,invalid arg,return!");
        }
    }

    public static void i(Intent intent, int i3, int i16) {
        long j3 = 0;
        long longExtra = intent.getLongExtra(QAlbumConstants.PARAM_INITTIME, 0L);
        if (longExtra == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,initTime == 0,return!");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - longExtra;
        if (currentTimeMillis > 86400000) {
            return;
        }
        if (i3 > 0) {
            j3 = currentTimeMillis / i3;
        }
        int intExtra = intent.getIntExtra("param_cancelSelNum", 0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.I0, NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
        hashMap.put("param_type", i16 + "");
        hashMap.put("param_cancelSelNum", intExtra + "");
        hashMap.put("param_consumTime", currentTimeMillis + "");
        hashMap.put("param_selNum", i3 + "");
        hashMap.put("param_averageTime", j3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSselectSendPic", false, 0L, 0L, hashMap, "", false);
        intent.removeExtra(QAlbumConstants.PARAM_INITTIME);
        intent.removeExtra("param_cancelSelNum");
        intent.removeExtra("param_totalSelNum");
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,param_type =" + i16 + ",param_cancelSelNum = " + intExtra + ",param_consumTime = " + currentTimeMillis + ",param_selNum = " + i3 + ",param_averageTime = " + j3);
        }
    }

    public static void j() {
        int i3;
        HashMap<String, String> hashMap = new HashMap<>();
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        int u16 = ah.u();
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.I0, systemNetwork + "");
        hashMap.put("param_phone_type", u16 + "");
        hashMap.put("param_userType", i3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSCompressTimeOut", false, 0L, 0L, hashMap, "", false);
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "reportPresendCompressTimeOut");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x011a, code lost:
    
        if (com.tencent.mobileqq.statistics.i.a(r7) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011c, code lost:
    
        r16 = r16 + 1;
        r10 = 1007;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0120, code lost:
    
        r17 = r17 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01eb, code lost:
    
        if (com.tencent.mobileqq.statistics.i.a(r7) != false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(String[] strArr, int i3, boolean z16, boolean z17, int i16, QQAppInterface qQAppInterface) {
        int i17;
        int i18;
        int i19;
        String str;
        int i26;
        if (strArr == null) {
            return;
        }
        com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) qQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        int length = strArr.length;
        if (bVar != null) {
            int b16 = bVar.b();
            i18 = bVar.getSelfGender();
            i17 = b16;
        } else {
            i17 = -1;
            i18 = -1;
        }
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            i19 = 1002;
        } else {
            i19 = 1001;
        }
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        int i49 = 0;
        int i56 = 0;
        int i57 = 0;
        for (String str2 : strArr) {
            if (str2 != null) {
                String lowerCase = str2.toLowerCase(Locale.US);
                String k3 = q.k(lowerCase);
                try {
                    str = new File(lowerCase).getParentFile().getName();
                } catch (Exception unused) {
                    str = null;
                }
                if (k3 != null && str != null) {
                    int i58 = 1008;
                    if (k3.contains("/tencent/")) {
                        if (k3.contains("/qq_collection/")) {
                            i38++;
                            i58 = 1001;
                        } else if (!str.equals("qq_images") && !k3.contains("/mobileqq/photo") && !k3.contains("/mobileqq/diskcache") && !k3.contains("/AIO_FORWARD/")) {
                            if (str.equals("qqfile_recv")) {
                                i46++;
                                i26 = 1003;
                            } else if (str.equals("qq_favorite")) {
                                i48++;
                                i26 = 1004;
                            } else if (k3.contains("/zebra/cache")) {
                                i47++;
                                i26 = 1005;
                            } else if (!str.equals("weixin") && !str.equals("wechat") && !str.equals("micromsg")) {
                                if (k3.contains("/qqinput/exp/")) {
                                    i57++;
                                    i26 = 1013;
                                }
                            } else {
                                i49++;
                                i26 = 1006;
                            }
                            i58 = i26;
                        } else {
                            i39++;
                            i58 = 1002;
                        }
                    } else {
                        if (str.equals("qq_screenshot")) {
                            i28++;
                            i26 = 1009;
                        } else if (!k3.contains("screenshot") && !k3.contains(HardCodeUtil.qqStr(R.string.tpb)) && !k3.contains(HardCodeUtil.qqStr(R.string.tpe)) && !k3.equals("screen_cap") && !k3.equals("ScreenCapture")) {
                            if (!str.contains("camera") && !str.equals("dcim") && !str.equals("100MEDIA") && !str.equals("100ANDRO") && !str.contains(HardCodeUtil.qqStr(R.string.tpa)) && !str.contains(HardCodeUtil.qqStr(R.string.tpd)) && !str.contains(HardCodeUtil.qqStr(R.string.tpc))) {
                                if (k3.contains("/sogou/.expression/")) {
                                    i56++;
                                    i26 = 1012;
                                }
                            } else {
                                i27++;
                                i26 = 1011;
                            }
                        } else {
                            i29++;
                            i26 = 1010;
                        }
                        i58 = i26;
                    }
                    int i59 = i49;
                    int i65 = i56;
                    int i66 = i57;
                    int i67 = i46;
                    int i68 = i47;
                    int i69 = i48;
                    int i75 = i37;
                    int i76 = i38;
                    int i77 = i39;
                    int i78 = i28;
                    int i79 = i29;
                    int i85 = i36;
                    int i86 = i27;
                    r(str2, i3, z16, z17, i16, i17, i18, i19, i58, length);
                    i27 = i86;
                    i28 = i78;
                    i29 = i79;
                    i36 = i85;
                    i37 = i75;
                    i38 = i76;
                    i39 = i77;
                    i46 = i67;
                    i47 = i68;
                    i48 = i69;
                    i49 = i59;
                    i56 = i65;
                    i57 = i66;
                } else {
                    return;
                }
            }
        }
        o(i27, i28, i29, i36, i37, i38, i39, i46, i47, i48, i49, i56, i57, i17, i18, i19);
    }

    public static void l() {
        if (QLog.isDevelopLevel()) {
            QLog.d("StatisticConstants", 4, "sendFastImageCameraPreviewStatistic ");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        long j3 = defaultSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate_fast", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = defaultSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times_fast", 0) + 1;
        if (currentTimeMillis - j3 > 86400000) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_sendCount", i3 + "");
            int i16 = defaultSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
            hashMap.put("param_browseCount", i16 + "");
            if (i16 > 0) {
                hashMap.put("param_sendPercent", (i3 / i16) + "");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSdayQuickSend", false, 0L, 0L, hashMap, "", false);
            defaultSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate_fast", currentTimeMillis).putInt("PhotoConst.camerapreviewactivity_send_times_fast", 0).putInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0).apply();
            return;
        }
        defaultSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times_fast", i3).apply();
    }

    public static void m() {
        if (QLog.isDevelopLevel()) {
            QLog.d("StatisticConstants", 4, "sendNomalCameraPreviewStatistic ");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        long j3 = defaultSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = defaultSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times", 0) + 1;
        if (currentTimeMillis - j3 > 86400000) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_sendCount", i3 + "");
            int i16 = defaultSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
            hashMap.put("param_cameraCount", i16 + "");
            if (i16 > 0) {
                hashMap.put("param_sendPercent", (i3 / i16) + "");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSdayCameraSend", false, 0L, 0L, hashMap, "", false);
            defaultSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate", currentTimeMillis).putInt("PhotoConst.camerapreviewactivity_send_times", 0).putInt("PhotoConst.camerapreviewactivity_enter_times", 0).commit();
            return;
        }
        defaultSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times", i3).commit();
    }

    public static void n(Intent intent, int i3) {
        String str;
        if (QLog.isDevelopLevel()) {
            QLog.d("StatisticConstants", 4, "sendPhotoListSelectRateStatistic (" + i3 + ")");
        }
        int intExtra = intent.getIntExtra("param_totalSelNum", 0);
        if (i3 > 0 && intExtra > 0) {
            BaseApplication context = BaseApplication.getContext();
            if (Build.VERSION.SDK_INT >= 24) {
                str = PreferenceManager.getDefaultSharedPreferencesName(context);
            } else {
                str = context.getPackageName() + "_preferences";
            }
            SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations");
            long j3 = fromSpAdapter.getLong("PhotoConst.last_send_select_rate_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            int i16 = fromSpAdapter.getInt("PhotoConst.photolistactivity_pic_count", 0) + i3;
            int i17 = fromSpAdapter.getInt("PhotoConst.photolistactivity_pic_total_count", 0) + intExtra;
            if (currentTimeMillis - j3 > 86400000) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_sendCount", i16 + "");
                hashMap.put("param_selCount", i17 + "");
                hashMap.put("param_sendPercent", (((float) i16) / ((float) i17)) + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSdaySelSend", false, 0L, 0L, hashMap, "", false);
                fromSpAdapter.edit().putLong("PhotoConst.last_send_select_rate_time", currentTimeMillis).putInt("PhotoConst.photolistactivity_pic_count", 0).putInt("PhotoConst.photolistactivity_pic_total_count", 0).commit();
                return;
            }
            fromSpAdapter.edit().putInt("PhotoConst.photolistactivity_pic_count", i16).putInt("PhotoConst.photolistactivity_pic_total_count", i17).commit();
        }
    }

    public static void o(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48) {
        if (QLog.isDevelopLevel()) {
            QLog.d("StatisticConstants", 4, "sendPhotoListSourceTypeStatistic (" + i3 + "," + i16 + "," + i17 + "," + i18 + "," + i19 + "," + i26 + "," + i27 + "," + i28 + "," + i29 + "," + i36 + "," + i37 + "," + i38 + "," + i39 + "),age = " + i46 + ",gender = " + i47 + ",userType = " + i48);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        long j3 = defaultSharedPreferences.getLong("PhotoConst.last_send_pic_source_type", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        int i49 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_systemalbum_send_count", 0) + i3;
        int i56 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0) + i16;
        int i57 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0) + i17;
        int i58 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_other_send_count", 0) + i19;
        int i59 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_app_send_count", 0) + i18;
        int i65 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_qq_collection_send_count", 0) + i26;
        int i66 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_qq_image_send_count", 0) + i27;
        int i67 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0) + i28;
        int i68 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0) + i29;
        int i69 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0) + i36;
        int i75 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_weixin_send_count", 0) + i37;
        int i76 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_sougou_send_count", 0) + i38;
        int i77 = defaultSharedPreferences.getInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0) + i39;
        if (currentTimeMillis - j3 > 86400000) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_systemAlbumSendCount", i49 + "");
            hashMap.put("param_screnshotQQSendCount", i56 + "");
            hashMap.put("param_screnshotOtherSendCount", i57 + "");
            hashMap.put("param_otherSendCount", i58 + "");
            hashMap.put("param_appSendCount", i59 + "");
            hashMap.put("param_qq_collection_SendCount", i65 + "");
            hashMap.put("param_qq_image_SendCount", i66 + "");
            hashMap.put("param_qq_filerecv_SendCount", i67 + "");
            hashMap.put("param_qq_zebra_SendCount", i68 + "");
            hashMap.put("param_qq_favorite_SendCount", i69 + "");
            hashMap.put("param_weixinSendCount", i75 + "");
            hashMap.put("param_sougouSendCount", i76 + "");
            hashMap.put("param_qqpinyinSendCount", i77 + "");
            hashMap.put("param_age", i46 + "");
            hashMap.put("param_gender", i47 + "");
            hashMap.put("param_userType", i48 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actDaySendPicSourceType", false, 0L, 0L, hashMap, "", false);
            defaultSharedPreferences.edit().putLong("PhotoConst.last_send_pic_source_type", currentTimeMillis).putInt("PhotoConst.photolistactivity_systemalbum_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0).putInt("PhotoConst.photolistactivity_other_send_count", 0).putInt("PhotoConst.photolistactivity_app_send_count", 0).putInt("PhotoConst.photolistactivity_qq_collection_send_count", 0).putInt("PhotoConst.photolistactivity_qq_image_send_count", 0).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0).putInt("PhotoConst.photolistactivity_weixin_send_count", 0).putInt("PhotoConst.photolistactivity_sougou_send_count", 0).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0).commit();
            return;
        }
        defaultSharedPreferences.edit().putInt("PhotoConst.photolistactivity_systemalbum_send_count", i49).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", i56).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", i57).putInt("PhotoConst.photolistactivity_other_send_count", i58).putInt("PhotoConst.photolistactivity_app_send_count", i59).putInt("PhotoConst.photolistactivity_qq_collection_send_count", i65).putInt("PhotoConst.photolistactivity_qq_image_send_count", i66).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", i67).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", i68).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", i69).putInt("PhotoConst.photolistactivity_weixin_send_count", i75).putInt("PhotoConst.photolistactivity_sougou_send_count", i76).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", i77).commit();
    }

    public static void p(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("StatisticConstants", 2, "sendPhotoPreviewSelectRateStatistic (" + i3 + " ," + i16 + ")");
        }
        if (i3 > 0 && i16 > 0) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            long j3 = defaultSharedPreferences.getLong("PhotoConst.last_send_select_rate_time_preview", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            int i17 = defaultSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_count", 0) + i3;
            int i18 = defaultSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0) + i16;
            if (currentTimeMillis - j3 > 86400000) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("PhotoConst.photopreviewactivity_send_pic_count", i17 + "");
                hashMap.put("PhotoConst.photopreviewactivity_send_pic_rate", (((float) i17) / ((float) i18)) + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "PhotoConst.photopreviewactivity_send", false, 0L, 0L, hashMap, "", false);
                defaultSharedPreferences.edit().putLong("PhotoConst.last_send_select_rate_time_preview", currentTimeMillis).putInt("PhotoConst.photopreviewactivity_send_pic_count", 0).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0).apply();
                return;
            }
            defaultSharedPreferences.edit().putInt("PhotoConst.photopreviewactivity_send_pic_count", i17).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", i18).apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void q(String str, int i3, QQAppInterface qQAppInterface) {
        int i16;
        int i17;
        Throwable th5;
        FileInputStream fileInputStream;
        int i18;
        long j3;
        long currentTimeMillis;
        byte[] hexStr2Bytes;
        int i19 = i3;
        if (str == null) {
            return;
        }
        com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) qQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        if (bVar != null) {
            i16 = bVar.b();
            i17 = bVar.getSelfGender();
        } else {
            i16 = -1;
            i17 = -1;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BaseImageUtil.decodeFileWithBufferedStream(str, options);
        int i26 = options.outWidth;
        int i27 = options.outHeight;
        if (i19 != 0 && i19 != 1 && i19 != 3000) {
            i19 = 5;
        }
        int i28 = i19;
        String str2 = null;
        str2 = null;
        str2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    try {
                        try {
                            hexStr2Bytes = MD5.toMD5Byte(fileInputStream, new File(str).length());
                        } catch (Throwable th6) {
                            th5 = th6;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    throw th5;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (IOException unused) {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        String estimateFileType = FileUtils.estimateFileType(str);
                        int i29 = !estimateFileType.toLowerCase().equals("gif") ? 1 : 0;
                        int i36 = Calendar.getInstance().get(11);
                        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
                        }
                        if (QLog.isDevelopLevel()) {
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(QQNotificationManager.PARAM_UINTYPE, i28 + "");
                        hashMap.put("param_age", i16 + "");
                        hashMap.put("param_gender", i17 + "");
                        hashMap.put("param_userType", i18 + "");
                        hashMap.put("param_picMD5", str2);
                        hashMap.put("param_picSuffixType", i29 + "");
                        hashMap.put("param_picReportHour", i36 + "");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actAIOPhotoSave", false, 0L, 0L, hashMap, "", false);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
                        j3 = defaultSharedPreferences.getLong("PhotoConst.last_total_save_count", 0L);
                        currentTimeMillis = System.currentTimeMillis();
                        int i37 = defaultSharedPreferences.getInt("PhotoConst.total_save_count", 0) + 1;
                        if (currentTimeMillis - j3 > 86400000) {
                        }
                    }
                } catch (UnsatisfiedLinkError unused2) {
                    File file = new File(str);
                    if (file.exists()) {
                        try {
                            String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                            if (d16 == null) {
                                d16 = "";
                            }
                            hexStr2Bytes = HexUtil.hexStr2Bytes(d16);
                        } catch (IOException unused3) {
                            hexStr2Bytes = null;
                            str2 = HexUtil.bytes2HexStr(hexStr2Bytes);
                            fileInputStream.close();
                            String estimateFileType2 = FileUtils.estimateFileType(str);
                            int i292 = !estimateFileType2.toLowerCase().equals("gif") ? 1 : 0;
                            int i362 = Calendar.getInstance().get(11);
                            if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
                            }
                            if (QLog.isDevelopLevel()) {
                            }
                            HashMap<String, String> hashMap2 = new HashMap<>();
                            hashMap2.put(QQNotificationManager.PARAM_UINTYPE, i28 + "");
                            hashMap2.put("param_age", i16 + "");
                            hashMap2.put("param_gender", i17 + "");
                            hashMap2.put("param_userType", i18 + "");
                            hashMap2.put("param_picMD5", str2);
                            hashMap2.put("param_picSuffixType", i292 + "");
                            hashMap2.put("param_picReportHour", i362 + "");
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actAIOPhotoSave", false, 0L, 0L, hashMap2, "", false);
                            SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
                            j3 = defaultSharedPreferences2.getLong("PhotoConst.last_total_save_count", 0L);
                            currentTimeMillis = System.currentTimeMillis();
                            int i372 = defaultSharedPreferences2.getInt("PhotoConst.total_save_count", 0) + 1;
                            if (currentTimeMillis - j3 > 86400000) {
                            }
                        }
                    }
                    hexStr2Bytes = null;
                }
                str2 = HexUtil.bytes2HexStr(hexStr2Bytes);
                fileInputStream.close();
            } catch (IOException unused4) {
                fileInputStream = null;
            } catch (Throwable th7) {
                th5 = th7;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        String estimateFileType22 = FileUtils.estimateFileType(str);
        int i2922 = !estimateFileType22.toLowerCase().equals("gif") ? 1 : 0;
        int i3622 = Calendar.getInstance().get(11);
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            i18 = 1002;
        } else {
            i18 = 1001;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("StatisticConstants", 4, "sendPhotoSaveStatistic url=" + str + ",uinType = " + i28 + ",age = " + i16 + ",gender = " + i17 + ",reprotHour = " + i3622 + ",md5 = " + str2 + ",suffixType = " + i2922 + ",suffix = " + estimateFileType22 + ",formal_md5 = " + MD5.toMD5(str) + ",width = " + i26 + ",height = " + i27 + ",userType = " + i18);
        }
        HashMap<String, String> hashMap22 = new HashMap<>();
        hashMap22.put(QQNotificationManager.PARAM_UINTYPE, i28 + "");
        hashMap22.put("param_age", i16 + "");
        hashMap22.put("param_gender", i17 + "");
        hashMap22.put("param_userType", i18 + "");
        hashMap22.put("param_picMD5", str2);
        hashMap22.put("param_picSuffixType", i2922 + "");
        hashMap22.put("param_picReportHour", i3622 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actAIOPhotoSave", false, 0L, 0L, hashMap22, "", false);
        SharedPreferences defaultSharedPreferences22 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        j3 = defaultSharedPreferences22.getLong("PhotoConst.last_total_save_count", 0L);
        currentTimeMillis = System.currentTimeMillis();
        int i3722 = defaultSharedPreferences22.getInt("PhotoConst.total_save_count", 0) + 1;
        if (currentTimeMillis - j3 > 86400000) {
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("param_age", i16 + "");
            hashMap3.put("param_gender", i17 + "");
            hashMap3.put("param_userType", i18 + "");
            hashMap3.put("param_saveCount", i3722 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actDayTotalSave", false, 0L, 0L, hashMap3, "", false);
            defaultSharedPreferences22.edit().putLong("PhotoConst.last_total_save_count", currentTimeMillis).putInt("PhotoConst.total_save_count", 0).commit();
            return;
        }
        defaultSharedPreferences22.edit().putInt("PhotoConst.total_save_count", i3722).commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bf  */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void r(String str, int i3, boolean z16, boolean z17, int i16, int i17, int i18, int i19, int i26, int i27) {
        String str2;
        boolean z18;
        int i28;
        int i29;
        ?? r142;
        int i36;
        int i37 = i3;
        int i38 = i16;
        int i39 = i19;
        if (str == null) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (!str.contains(AppConstants.SDCARD_AIO_FORWARD)) {
            try {
                BaseImageUtil.decodeFileWithBufferedStream(str, options);
            } catch (OutOfMemoryError unused) {
                QLog.e("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic OutOfMemoryError ");
            }
        }
        int i46 = options.outWidth;
        int i47 = options.outHeight;
        if (i37 != 0 && i37 != 1 && i37 != 3000) {
            i37 = 5;
        }
        if (i38 != 0 && i38 != 1 && i38 != 3000) {
            i38 = 5;
        }
        try {
            String file = Environment.getExternalStorageDirectory().toString();
            String replace = (file == null || !str.contains(file)) ? str : str.replace(file, "");
            int lastIndexOf = replace.lastIndexOf("/");
            int i48 = -1;
            if (lastIndexOf != -1) {
                replace = replace.substring(0, lastIndexOf);
            }
            String replace2 = replace.replace("/", "//");
            int i49 = Calendar.getInstance().get(11);
            File file2 = new File(str);
            if (z17 || !file2.exists()) {
                str2 = "StatisticConstants";
            } else {
                str2 = "StatisticConstants";
                i48 = (int) ((System.currentTimeMillis() - file2.lastModified()) / 60000);
                if (i48 == 0) {
                    i48 = 1;
                }
            }
            boolean z19 = !str.toLowerCase(Locale.US).contains("gif");
            if (str.contains(AppConstants.SDCARD_AIO_FORWARD)) {
                String[] split = str.split("#");
                z18 = z19;
                if (split.length >= 4) {
                    int parseInt = Integer.parseInt(split[1]);
                    int parseInt2 = Integer.parseInt(split[2]);
                    i29 = parseInt;
                    r142 = Integer.parseInt(split[3]) != 3;
                    i28 = parseInt2;
                    int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                    if (QLog.isDevelopLevel()) {
                        i36 = i26;
                    } else {
                        ?? sb5 = new StringBuilder();
                        sb5.append("sendPhotoSourceDetailUrlStatistic url=");
                        sb5.append(replace2);
                        sb5.append(",uinType = ");
                        sb5.append(i37);
                        sb5.append(",batchCnt = ");
                        sb5.append(i27);
                        sb5.append(",isRAW = ");
                        sb5.append(z16);
                        sb5.append(",isForward = ");
                        sb5.append(z17);
                        sb5.append(",age = ");
                        sb5.append(i17);
                        sb5.append(",gender = ");
                        sb5.append(i18);
                        sb5.append(",reprotHour = ");
                        sb5.append(i49);
                        sb5.append(",width = ");
                        sb5.append(i29);
                        sb5.append(",height = ");
                        sb5.append(i28);
                        sb5.append(",interval = ");
                        sb5.append(i48);
                        sb5.append(",suffixType = ");
                        sb5.append(r142);
                        sb5.append(",nettype = ");
                        sb5.append(systemNetwork);
                        sb5.append(",forwardSourceUinType = ");
                        sb5.append(i38);
                        sb5.append(",urlType = ");
                        i36 = i26;
                        sb5.append(i36);
                        sb5.append(",userType = ");
                        i39 = i19;
                        sb5.append(i39);
                        sb5.append(",fileName = ");
                        sb5.append(file2.getName());
                        QLog.d(str2, 4, sb5.toString());
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_sourceDetailUrl", replace2);
                    hashMap.put(QQNotificationManager.PARAM_UINTYPE, i37 + "");
                    hashMap.put("param_forwardSourceUinType", i38 + "");
                    hashMap.put("param_isForward", z17 + "");
                    hashMap.put("param_age", i17 + "");
                    hashMap.put("param_gender", i18 + "");
                    hashMap.put("param_userType", i39 + "");
                    hashMap.put("param_picReportHour", i49 + "");
                    hashMap.put("param_picInterval", i48 + "");
                    hashMap.put("param_isRAWPic", z16 + "");
                    hashMap.put("param_fileName", file2.getName());
                    hashMap.put("param_picSuffixType", r142 + "");
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.I0, systemNetwork + "");
                    hashMap.put("param_urlType", i36 + "");
                    hashMap.put("param_picBatchCount", i27 + "");
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPhotoSourceDetailUrl", false, 0L, 0L, hashMap, "", false);
                }
            } else {
                z18 = z19;
            }
            i28 = i47;
            i29 = i46;
            r142 = z18;
            int systemNetwork2 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            if (QLog.isDevelopLevel()) {
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("param_sourceDetailUrl", replace2);
            hashMap2.put(QQNotificationManager.PARAM_UINTYPE, i37 + "");
            hashMap2.put("param_forwardSourceUinType", i38 + "");
            hashMap2.put("param_isForward", z17 + "");
            hashMap2.put("param_age", i17 + "");
            hashMap2.put("param_gender", i18 + "");
            hashMap2.put("param_userType", i39 + "");
            hashMap2.put("param_picReportHour", i49 + "");
            hashMap2.put("param_picInterval", i48 + "");
            hashMap2.put("param_isRAWPic", z16 + "");
            hashMap2.put("param_fileName", file2.getName());
            hashMap2.put("param_picSuffixType", r142 + "");
            hashMap2.put(com.tencent.mobileqq.msf.core.c0.j.I0, systemNetwork2 + "");
            hashMap2.put("param_urlType", i36 + "");
            hashMap2.put("param_picBatchCount", i27 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPhotoSourceDetailUrl", false, 0L, 0L, hashMap2, "", false);
        } catch (Exception unused2) {
        }
    }
}

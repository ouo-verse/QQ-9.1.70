package com.tencent.mobileqq.kandian.base.video;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoDeviceInfoHelper {

    /* renamed from: c, reason: collision with root package name */
    private static volatile JSONObject f239088c;

    /* renamed from: a, reason: collision with root package name */
    public static final String f239086a = LogTag.TAG_READINJOY_VIDEO + VideoDeviceInfoHelper.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private static int f239087b = -1;

    /* renamed from: d, reason: collision with root package name */
    private static float f239089d = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements TMSManager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.vip.TMSManager.a
        public void a(boolean z16, boolean z17, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoDeviceInfoHelper.f239086a, 2, "queryKingCardType()#callback postQuery, sucess=" + z16 + " isKingCard=" + z17 + " product=" + i3);
            }
            if (z16) {
                VideoDeviceInfoHelper.f239087b = i3;
                synchronized (VideoDeviceInfoHelper.class) {
                    if (VideoDeviceInfoHelper.f239088c != null) {
                        try {
                            VideoDeviceInfoHelper.f239088c.put("simCardType", VideoDeviceInfoHelper.f239087b);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.e(VideoDeviceInfoHelper.f239086a, 2, "queryKingCardType()#callback postQuery, update json error ", e16);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(VideoDeviceInfoHelper.f239086a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
                        }
                    }
                }
            }
        }
    }

    private static void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper.1
            @Override // java.lang.Runnable
            public void run() {
                VideoDeviceInfoHelper.m();
            }
        }, 16, null, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
    
        if (r3 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String f() {
        String str;
        BufferedReader bufferedReader;
        int indexOf;
        str = "Unknown";
        InputStreamReader inputStreamReader = null;
        String str2 = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.startsWith("Hardware") && (indexOf = readLine.indexOf(58)) > 1) {
                                str2 = readLine.substring(indexOf + 1).trim().replace(" ", "");
                                if (!TextUtils.isEmpty(str2)) {
                                    break;
                                }
                            }
                        } catch (Throwable unused) {
                            inputStreamReader = inputStreamReader2;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                        }
                    }
                    str = TextUtils.isEmpty(str2) ? "Unknown" : str2;
                    inputStreamReader2.close();
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return str;
    }

    private static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "CPU_OTHER";
        }
        try {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.contains("exynos") && !lowerCase.contains("smdk") && !lowerCase.contains("s5l8900") && !lowerCase.contains("s5pc100")) {
                if (!lowerCase.contains("kirin") && !lowerCase.contains("k3v")) {
                    if (!lowerCase.contains("msm") && !lowerCase.contains("apq") && !lowerCase.contains("qsd")) {
                        if (!lowerCase.contains("mt6")) {
                            return "CPU_OTHER";
                        }
                        return "CPU_MTK";
                    }
                    return "CPU_QUALCOMM";
                }
                return "CPU_HISI";
            }
            return "CPU_SUMSUNG";
        } catch (Throwable unused) {
            return "CPU_OTHER";
        }
    }

    public static String i(String str) {
        if (f239088c == null) {
            synchronized (VideoDeviceInfoHelper.class) {
                if (f239088c == null) {
                    f239088c = k();
                    if (f239087b == -1) {
                        e();
                    }
                }
            }
        }
        if (f239088c != null) {
            try {
                synchronized (VideoDeviceInfoHelper.class) {
                    if (!TextUtils.isEmpty(str)) {
                        f239088c.put("RecommBitrate", str);
                    } else {
                        f239088c.remove("RecommBitrate");
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return f239088c.toString();
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float j() {
        float f16;
        float f17;
        Method method;
        int i3;
        int i16;
        float f18 = f239089d;
        float f19 = 0.0f;
        if (f18 > 0.0f) {
            return f18;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        float decodeFloat = from.decodeFloat("KEY_MMKV_HW_CODEC_LEVEL", -1.0f);
        f239089d = decodeFloat;
        if (decodeFloat > 0.0f) {
            return decodeFloat;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecList");
            int i17 = 0;
            Method declaredMethod = cls.getDeclaredMethod("getCodecCount", new Class[0]);
            int i18 = 1;
            Method declaredMethod2 = cls.getDeclaredMethod("getCodecInfoAt", Integer.TYPE);
            Class<?> cls2 = Class.forName("android.media.MediaCodecInfo");
            Method declaredMethod3 = cls2.getDeclaredMethod("getSupportedTypes", new Class[0]);
            cls2.getDeclaredMethod("getName", new Class[0]);
            Method declaredMethod4 = cls2.getDeclaredMethod("isEncoder", new Class[0]);
            Method declaredMethod5 = cls2.getDeclaredMethod("getCapabilitiesForType", String.class);
            Field declaredField = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
            Field declaredField2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getDeclaredField("level");
            Object obj = null;
            int intValue = ((Integer) declaredMethod.invoke(null, new Object[0])).intValue();
            int i19 = -1;
            int i26 = 0;
            while (i26 < intValue) {
                try {
                    Object[] objArr = new Object[i18];
                    objArr[i17] = Integer.valueOf(i26);
                    Object invoke = declaredMethod2.invoke(obj, objArr);
                    if (!((Boolean) declaredMethod4.invoke(invoke, new Object[i17])).booleanValue()) {
                        String[] strArr = (String[]) declaredMethod3.invoke(invoke, new Object[i17]);
                        int length = strArr.length;
                        int i27 = 0;
                        while (true) {
                            if (i27 >= length) {
                                method = declaredMethod2;
                                i3 = 1;
                                i16 = 0;
                                break;
                            }
                            method = declaredMethod2;
                            if (strArr[i27].equalsIgnoreCase("video/hevc")) {
                                i3 = 1;
                                i16 = 0;
                                for (Object obj2 : (Object[]) declaredField.get(declaredMethod5.invoke(invoke, "video/hevc"))) {
                                    int intValue2 = ((Integer) declaredField2.get(obj2)).intValue();
                                    if (intValue2 > i19) {
                                        i19 = intValue2;
                                    }
                                }
                                f239089d = l(i19);
                            } else {
                                i27++;
                                declaredMethod2 = method;
                            }
                        }
                    } else {
                        method = declaredMethod2;
                        i16 = i17;
                        i3 = i18;
                    }
                    i26++;
                    i18 = i3;
                    i17 = i16;
                    declaredMethod2 = method;
                    f19 = 0.0f;
                    obj = null;
                } catch (Exception unused) {
                    f16 = 0.0f;
                    f239089d = f16;
                    f17 = f239089d;
                    if (f17 > f16) {
                    }
                    return f239089d;
                }
            }
            f16 = f19;
        } catch (Exception unused2) {
            f16 = 0.0f;
        }
        f17 = f239089d;
        if (f17 > f16) {
            from.encodeFloat("KEY_MMKV_HW_CODEC_LEVEL", f17);
        }
        return f239089d;
    }

    private static float l(int i3) {
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            HashMap hashMap = new HashMap();
            hashMap.put("HEVCHighTierLevel1", Float.valueOf(1.0f));
            hashMap.put("HEVCHighTierLevel2", Float.valueOf(2.0f));
            hashMap.put("HEVCHighTierLevel21", Float.valueOf(2.1f));
            hashMap.put("HEVCHighTierLevel3", Float.valueOf(3.0f));
            hashMap.put("HEVCHighTierLevel31", Float.valueOf(3.1f));
            hashMap.put("HEVCHighTierLevel4", Float.valueOf(4.0f));
            hashMap.put("HEVCHighTierLevel41", Float.valueOf(4.1f));
            hashMap.put("HEVCHighTierLevel5", Float.valueOf(5.0f));
            hashMap.put("HEVCHighTierLevel51", Float.valueOf(5.1f));
            hashMap.put("HEVCHighTierLevel52", Float.valueOf(5.2f));
            hashMap.put("HEVCHighTierLevel6", Float.valueOf(6.0f));
            hashMap.put("HEVCHighTierLevel61", Float.valueOf(6.1f));
            hashMap.put("HEVCHighTierLevel62", Float.valueOf(6.2f));
            hashMap.put("HEVCMainTierLevel1", Float.valueOf(1.0f));
            hashMap.put("HEVCMainTierLevel2", Float.valueOf(2.0f));
            hashMap.put("HEVCMainTierLevel21", Float.valueOf(2.1f));
            hashMap.put("HEVCMainTierLevel3", Float.valueOf(3.0f));
            hashMap.put("HEVCMainTierLevel31", Float.valueOf(3.1f));
            hashMap.put("HEVCMainTierLevel4", Float.valueOf(4.0f));
            hashMap.put("HEVCMainTierLevel41", Float.valueOf(4.1f));
            hashMap.put("HEVCMainTierLevel5", Float.valueOf(5.0f));
            hashMap.put("HEVCMainTierLevel51", Float.valueOf(5.1f));
            hashMap.put("HEVCMainTierLevel52", Float.valueOf(5.2f));
            hashMap.put("HEVCMainTierLevel6", Float.valueOf(6.0f));
            hashMap.put("HEVCMainTierLevel61", Float.valueOf(6.1f));
            hashMap.put("HEVCMainTierLevel62", Float.valueOf(6.2f));
            for (Map.Entry entry : hashMap.entrySet()) {
                if (i3 == ((Integer) cls.getField((String) entry.getKey()).get(null)).intValue()) {
                    return ((Float) entry.getValue()).floatValue();
                }
            }
            return 0.0f;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 0.0f;
            }
            QLog.e(f239086a, 2, "innerCalculateRealLevel ERROR = " + e16.getMessage());
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        if (TMSManager.e().d()) {
            if (NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 0) {
                TMSManager.e().l(new a(), false);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w(f239086a, 2, "queryKingCardType(), can only query in mobile connection");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(f239086a, 2, "queryKingCardType(), so not ready");
        }
    }

    public static String h() {
        return i(null);
    }

    private static JSONObject k() {
        JSONObject jSONObject;
        Throwable th5;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable th6) {
            jSONObject = null;
            th5 = th6;
        }
        try {
            jSONObject.put("CpuFrequency", ah.l());
            jSONObject.put("CpuNum", ah.n());
            jSONObject.put("OsInfo", ah.K());
            jSONObject.put(QCircleVideoDeviceInfoUtils.STRATEGY_DEVICE_MODEL, ah.s());
            jSONObject.put("DeviceOS", ah.t());
            jSONObject.put("ManufactureInfo", ah.C());
            jSONObject.put("Sdkversion", Build.VERSION.SDK_INT);
            jSONObject.put("QQVersion", ah.P());
            jSONObject.put("TotalRam", m.c());
            jSONObject.put("AvailRam", ah.X());
            long[] T = ah.T();
            int i3 = 0;
            jSONObject.put("TotalRom", T[0]);
            jSONObject.put("AvailRom", T[1]);
            jSONObject.put("platform", 1);
            String f16 = f();
            jSONObject.put("CpuModel", f16);
            jSONObject.put("CpuProducer", g(f16));
            int i16 = f239087b;
            if (i16 != -1) {
                i3 = i16;
            }
            jSONObject.put("simCardType", i3);
            jSONObject.put("HWCodecLevel", String.valueOf(j()));
            return jSONObject;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(f239086a, 2, "initJsonInfo ERROR = " + th5.getMessage());
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }
}

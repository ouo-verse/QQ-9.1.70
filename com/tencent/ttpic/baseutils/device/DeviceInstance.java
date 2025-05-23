package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import common.config.service.QzoneConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DeviceInstance {
    public static final String BRAND_MEIZU = "MEIZU";
    public static final String BRAND_VIVO = "VIVO";
    public static final String BRAND_XIAOMI = "XIAOMI";
    public static final String MODEL_COOLPAD_8150 = "8150";
    public static final String MODEL_K_TOUCH_W619 = "K-Touch W619";
    public static final String MODEL_NEXUS_6 = "MOTOROLA_Nexus_6";
    public static final String MODEL_NEXUS_6P = "HUAWEI_Nexus_6P";
    public static final String MODEL_OPPO_X909 = "OPPO_X909";
    public static final String MODEL_VIVO_Y23L = "VIVO_vivo_Y23L";
    public static final String NUBIA_NX511J = "NUBIA_NX511J";
    private String mDeviceName;
    private ConcurrentHashMap<String, String> mModelMap;
    private ConcurrentHashMap<String, String> mSocMap;
    public static final String PHONE_BRAND = Build.BRAND;
    public static final String PHONE_MODEL = DeviceInfoMonitor.getModel();
    private static String TAG = DeviceInstance.class.getSimpleName();
    private static String sPhoneManufacturer = null;
    private static int sPhoneSDKIntVersion = -1;
    private static String sPhoneDevice = null;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class BrandNames {
        public Map<String, String> BRAND_NAMES;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum DEVICE_DETECT_FACE {
        VIVO_PAD_2373("vivo_pa2373", 480),
        VIVO_V2314A("vivo_v2314a", 480),
        OPPO_PJV110("oppo_pjv110", 640),
        OPPO_PJH110("oppo_pjh110", 640),
        VIVO_V2245A("vivo_v2245a", 640);

        public final String device;
        public final int faceDetectSize;

        DEVICE_DETECT_FACE(String str, int i3) {
            this.device = str;
            this.faceDetectSize = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum DEVICE_GENERAL_SIZE {
        OPPO_PJH110("oppo_pjh110", 640),
        VIVO_V2245A("vivo_v2245a", 640),
        OPPO_PJV110("oppo_pjv110", 640);

        public final String device;
        public final int size;

        DEVICE_GENERAL_SIZE(String str, int i3) {
            this.device = str;
            this.size = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private enum DEVICE_MEM {
        GN9010("GN9010", 81920),
        vivo_Y23L("vivo_Y23L", 81920),
        vivo_Y27("vivo_Y27", 81920),
        HUAWEI_PLK("HUAWEI_PLK-AL10", 81920);

        private final String device;
        private final int sizeInKB;

        DEVICE_MEM(String str, int i3) {
            this.device = str;
            this.sizeInKB = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class InstanceHolder {
        private static final DeviceInstance INSTANCE = new DeviceInstance();

        InstanceHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SOCPhones {
        public Map<String, String> SOC_SCORE;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum SOC_CLASS {
        NULL(-1, -1, "Class_Null"),
        V_HIGH(0, 6000, "Class_V_High"),
        HIGH(1, g.V0, "Class_High"),
        NORMAL(2, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, "Class_Normal"),
        LOW(3, 2100, "Class_Low"),
        V_LOW(4, 0, "Class_V_Low");

        public String desc;
        public int score;
        public int value;

        SOC_CLASS(int i3, int i16, String str) {
            this.value = i3;
            this.score = i16;
            this.desc = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SOC_CLASS{value=" + this.value + ", score=" + this.score + ", desc=" + this.desc + '}';
        }
    }

    public static DeviceInstance getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static String getPhoneDevice() {
        if (sPhoneDevice == null) {
            sPhoneDevice = Build.DEVICE;
        }
        return sPhoneDevice;
    }

    public static String getPhoneManufacturer() {
        if (sPhoneManufacturer == null) {
            sPhoneManufacturer = Build.MANUFACTURER;
        }
        return sPhoneManufacturer;
    }

    public static int getSDKVersion() {
        if (sPhoneSDKIntVersion < 0) {
            sPhoneSDKIntVersion = Build.VERSION.SDK_INT;
        }
        return sPhoneSDKIntVersion;
    }

    private void initModels(Context context) {
        BrandNames brandNames;
        Map<String, String> map;
        try {
            brandNames = (BrandNames) new Gson().fromJson(FileUtils.load(context, "assets://brand_name.json"), BrandNames.class);
        } catch (NoSuchMethodError e16) {
            LogUtils.e(TAG, e16.toString());
            brandNames = null;
        }
        if (brandNames == null || (map = brandNames.BRAND_NAMES) == null || (r4 = map.entrySet().iterator()) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.mModelMap.put(entry.getKey().toUpperCase(), entry.getValue());
        }
    }

    private void initSOCs(Context context) {
        Map<String, String> map;
        SOCPhones sOCPhones = (SOCPhones) new Gson().fromJson(FileUtils.load(context, "assets://score_phone.json"), SOCPhones.class);
        if (sOCPhones != null && (map = sOCPhones.SOC_SCORE) != null) {
            this.mSocMap.putAll(map);
        }
    }

    public String getDeviceName() {
        if (TextUtils.isEmpty(this.mDeviceName)) {
            String str = PHONE_MODEL;
            if (str.equalsIgnoreCase("K-Touch W619")) {
                this.mDeviceName = this.mModelMap.get("TIANYU") + " " + str;
            } else if (str.equalsIgnoreCase("8150") && PHONE_BRAND.equalsIgnoreCase("COOLPAD")) {
                this.mDeviceName = this.mModelMap.get("COOLPAD") + " " + str;
            } else {
                String str2 = this.mModelMap.get(getPhoneManufacturer().toUpperCase());
                if (TextUtils.isEmpty(str2) || "null".equalsIgnoreCase(str2)) {
                    str2 = getPhoneManufacturer().toUpperCase();
                }
                if (TextUtils.isEmpty(str2) || "null".equalsIgnoreCase(str2)) {
                    str2 = PHONE_BRAND.toUpperCase();
                }
                this.mDeviceName = str2 + " " + str;
            }
            this.mDeviceName = this.mDeviceName.replace(" ", "_").replace(Marker.ANY_NON_NULL_MARKER, "").replace("(t)", "");
        }
        return this.mDeviceName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        if (r4 > r1.score) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SOC_CLASS getDeviceSocClass(String str) {
        String str2;
        ConcurrentHashMap<String, String> concurrentHashMap;
        LogUtils.d(TAG, "[getDeviceSocClass] + BEGIN, socInfo = " + str);
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.mSocMap) != null && concurrentHashMap.containsKey(str)) {
            str2 = this.mSocMap.get(str);
        } else {
            str2 = "";
        }
        LogUtils.d(TAG, "[getDeviceSocClass] scoreValue = " + str2);
        SOC_CLASS soc_class = SOC_CLASS.NULL;
        if (!TextUtils.isEmpty(str2)) {
            int parseInt = Integer.parseInt(str2);
            SOC_CLASS soc_class2 = SOC_CLASS.V_HIGH;
            if (parseInt < soc_class2.score) {
                soc_class2 = SOC_CLASS.HIGH;
                if (parseInt < soc_class2.score) {
                    soc_class2 = SOC_CLASS.NORMAL;
                    if (parseInt < soc_class2.score) {
                        soc_class2 = SOC_CLASS.LOW;
                        if (parseInt < soc_class2.score) {
                            soc_class2 = SOC_CLASS.V_LOW;
                        }
                    }
                }
            }
            soc_class = soc_class2;
        }
        LogUtils.d(TAG, "[getDeviceSocClass] + END, socClass = " + soc_class);
        return soc_class;
    }

    public int getMaxMemorySizeInKB() {
        String trim = getDeviceName().toLowerCase().trim();
        for (DEVICE_MEM device_mem : DEVICE_MEM.values()) {
            if (trim.endsWith(device_mem.device.toLowerCase())) {
                return device_mem.sizeInKB;
            }
        }
        return Integer.MAX_VALUE;
    }

    public void initSettings(Context context) {
        if (this.mModelMap.size() == 0) {
            initModels(context);
        }
        if (this.mSocMap.size() == 0) {
            initSOCs(context);
        }
        showDeviceInfo();
    }

    public boolean isMeiZuDevice() {
        boolean z16;
        LogUtils.d(TAG, "[isMeiZuDevice] + BEGIN");
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("MEIZU")) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.d(TAG, "[isMeiZuDevice] + END, isMeizu = " + z16);
        return z16;
    }

    public boolean isOppoX909Device() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.equals("OPPO_X909")) {
            return true;
        }
        return false;
    }

    public boolean isViVoDevice() {
        boolean z16;
        LogUtils.d(TAG, "[isViVoDevice] + BEGIN");
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("VIVO")) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.d(TAG, "[isViVoDevice] + END, isViVo = " + z16);
        return z16;
    }

    public boolean isVivoY23LDevice() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.equals("VIVO_vivo_Y23L")) {
            return true;
        }
        return false;
    }

    public boolean isXiaoMiDevice() {
        boolean z16;
        LogUtils.d(TAG, "[isXiaoMiDevice] + BEGIN");
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("XIAOMI")) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.d(TAG, "[isXiaoMiDevice] + END, isXiaomi = " + z16);
        return z16;
    }

    public boolean isXiaoMiMixDevice() {
        boolean z16;
        LogUtils.d(TAG, "[isXiaoMiMixDevice] + BEGIN");
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.equals("XIAOMI_MIX")) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.d(TAG, "[isXiaoMiMixDevice] + END, isXiaoMiMix = " + z16);
        return z16;
    }

    public boolean isXiaoMiRedmi6Device() {
        boolean z16;
        LogUtils.d(TAG, "[isXiaoMiRedmi6Device] + BEGIN");
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.contains("Redmi_6")) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.d(TAG, "[isXiaoMiRedmi6Device] + END, isRedmi6 = " + z16);
        return z16;
    }

    DeviceInstance() {
        this.mModelMap = new ConcurrentHashMap<>();
        this.mSocMap = new ConcurrentHashMap<>();
        this.mDeviceName = "";
        showDeviceInfo();
    }

    @Deprecated
    private void showDeviceInfo() {
    }
}

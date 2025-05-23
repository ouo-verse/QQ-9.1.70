package org.light.device;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.msf.core.c0.g;
import common.config.service.QzoneConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.light.utils.FileUtils;
import org.light.utils.LightLogUtil;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DeviceInstance {
    public static final String BRAND_HUAWEI = "HUAWEI";
    public static final String BRAND_MEIZU = "MEIZU";
    public static final String BRAND_OPPO = "OPPO";
    public static final String BRAND_VIVO = "VIVO";
    public static final String BRAND_XIAOMI = "XIAOMI";
    public static final String MODEL_COOLPAD_8150 = "8150";
    public static final String MODEL_K_TOUCH_W619 = "K-Touch W619";
    public static final String MODEL_NEXUS_6 = "MOTOROLA_Nexus_6";
    public static final String MODEL_NEXUS_6P = "HUAWEI_Nexus_6P";
    public static final String MODEL_OPPO_X909 = "OPPO_X909";
    public static final String MODEL_VIVO_Y23L = "VIVO_vivo_Y23L";
    public static final String NUBIA_NX511J = "NUBIA_NX511J";
    private static String TAG = "DeviceInstance";
    private String deviceId;
    private String mDeviceName;
    private String mDeviceVersion;
    private ConcurrentHashMap<String, String> mModelMap;
    private ConcurrentHashMap<String, String> mSocMap;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BrandNames {
        public Map<String, String> BRAND_NAMES;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
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
    /* loaded from: classes29.dex */
    public static class InstanceHolder {
        private static final DeviceInstance INSTANCE = new DeviceInstance();

        InstanceHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SOCPhones {
        public Map<String, String> SOC_SCORE;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
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

    private String getHuaweiEMUIVersion() {
        return getOSVersion("ro.build.version.emui");
    }

    public static DeviceInstance getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private String getOSVersion(String str) {
        try {
            return (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, str);
        } catch (Exception unused) {
            return "";
        }
    }

    private String getOppoColorOSVersion() {
        return getOSVersion("ro.build.version.opporom");
    }

    private String getVivoOSVersion() {
        return getOSVersion("ro.vivo.os.version");
    }

    private String getXiaomiMIUIVersion() {
        return getOSVersion("ro.miui.ui.version.name");
    }

    private void initModels(Context context, String str) {
        BrandNames brandNames;
        Map<String, String> map;
        String str2 = FileUtils.genSeperateFileDir(str) + "brand_name.json";
        if (!FileUtils.isFileExist(str2)) {
            str2 = FileUtils.load(context, "assets://brand_name.json");
            if (!FileUtils.isFileExist(str2)) {
                return;
            }
        }
        try {
            brandNames = (BrandNames) new Gson().fromJson(FileUtils.load(context, str2), BrandNames.class);
        } catch (NoSuchMethodError e16) {
            LightLogUtil.e(TAG, e16.toString());
            brandNames = null;
        }
        if (brandNames == null || (map = brandNames.BRAND_NAMES) == null || (r3 = map.entrySet().iterator()) == null) {
            return;
        }
        this.mModelMap.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.mModelMap.put(entry.getKey().toUpperCase(), entry.getValue());
        }
    }

    private void initSOCs(Context context, String str) {
        Map<String, String> map;
        String str2 = FileUtils.genSeperateFileDir(str) + "score_phone.json";
        if (!FileUtils.isFileExist(str2)) {
            str2 = FileUtils.load(context, "assets://score_phone.json");
            if (!FileUtils.isFileExist(str2)) {
                return;
            }
        }
        SOCPhones sOCPhones = (SOCPhones) new Gson().fromJson(FileUtils.load(context, str2), SOCPhones.class);
        this.mSocMap.clear();
        if (sOCPhones != null && (map = sOCPhones.SOC_SCORE) != null) {
            this.mSocMap.putAll(map);
        }
    }

    public static String staticGetDeviceId() {
        return getInstance().getDeviceId();
    }

    public static String staticGetDeviceName() {
        return getInstance().getDeviceName();
    }

    public static String staticGetDeviceVersion() {
        return getInstance().getDeviceVersion();
    }

    public String getDeviceId() {
        if (this.deviceId == null) {
            this.deviceId = LightDeviceProperty.getStringProp(0);
        }
        return this.deviceId;
    }

    public String getDeviceName() {
        if (TextUtils.isEmpty(this.mDeviceName)) {
            String stringProp = LightDeviceProperty.getStringProp(1);
            String stringProp2 = LightDeviceProperty.getStringProp(3);
            String stringProp3 = LightDeviceProperty.getStringProp(2);
            if (stringProp.equalsIgnoreCase("K-Touch W619")) {
                this.mDeviceName = this.mModelMap.get("TIANYU") + " " + stringProp;
            } else if (stringProp.equalsIgnoreCase("8150") && stringProp2.equalsIgnoreCase("COOLPAD")) {
                this.mDeviceName = this.mModelMap.get("COOLPAD") + " " + stringProp;
            } else {
                String str = this.mModelMap.get(stringProp3.toUpperCase());
                if (TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                    str = stringProp3.toUpperCase();
                }
                if (TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                    str = stringProp2.toUpperCase();
                }
                this.mDeviceName = str + " " + stringProp;
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
        LightLogUtil.d(TAG, "[getDeviceSocClass] + BEGIN, socInfo = " + str);
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.mSocMap) != null && concurrentHashMap.containsKey(str)) {
            str2 = this.mSocMap.get(str);
        } else {
            str2 = "";
        }
        LightLogUtil.d(TAG, "[getDeviceSocClass] scoreValue = " + str2);
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
        LightLogUtil.d(TAG, "[getDeviceSocClass] + END, socClass = " + soc_class);
        return soc_class;
    }

    public String getDeviceVersion() {
        if (TextUtils.isEmpty(this.mDeviceVersion)) {
            if (isHuaweiDevice()) {
                this.mDeviceVersion = getHuaweiEMUIVersion();
            } else if (isOppoDevice()) {
                this.mDeviceVersion = "ColorOS_" + getOppoColorOSVersion();
            } else if (isXiaoMiDevice()) {
                this.mDeviceVersion = "MIUI_" + getXiaomiMIUIVersion();
            } else if (isViVoDevice()) {
                this.mDeviceVersion = "VivoOS_" + getVivoOSVersion();
            }
        }
        return this.mDeviceVersion;
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

    public void initSettings(Context context, String str) {
        initModels(context, str);
        initSOCs(context, str);
    }

    public boolean isHuaweiDevice() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("HUAWEI")) {
            return true;
        }
        return false;
    }

    public boolean isMeiZuDevice() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("MEIZU")) {
            return true;
        }
        return false;
    }

    public boolean isOppoDevice() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("OPPO")) {
            return true;
        }
        return false;
    }

    public boolean isViVoDevice() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("VIVO")) {
            return true;
        }
        return false;
    }

    public boolean isXiaoMiDevice() {
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith("XIAOMI")) {
            return true;
        }
        return false;
    }

    DeviceInstance() {
        this.mModelMap = new ConcurrentHashMap<>();
        this.mSocMap = new ConcurrentHashMap<>();
        this.mDeviceVersion = "";
        this.mDeviceName = "";
        this.deviceId = null;
    }
}

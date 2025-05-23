package org.light.device;

import android.content.Context;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import cooperation.photoplus.sticker.Sticker;
import java.util.Map;
import org.light.bean.PhoneType;
import org.light.utils.GsonUtils;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OfflineConfig {
    private static final String BENCHMARK_CPU_INFOS_PATH = "benchmark/cpu_infos.json";
    private static final String BENCHMARK_DEVICE_MODELS_DIR = "benchmark/device_models/";
    private static final float BENCHMARK_LEVEL_HIGH = 1.0f;
    private static final float BENCHMARK_LEVEL_UNKNOWN = -1.0f;
    private static final String BENCHMARK_SOC_MODELS_PATH = "benchmark/soc_models.json";
    private static final String BENCHMARK_STRATEGY_CPU_MAX_FREQ = "CpuMaxFreq";
    private static final String BENCHMARK_STRATEGY_CPU_PART = "CpuPart";
    private static final String BENCHMARK_STRATEGY_CPU_PART_AND_MAX_FREQ = "CpuPartAndMaxFreq";
    private static final String BENCHMARK_STRATEGY_DEFAULT_VALUE = "DefaultValue";
    private static final String BENCHMARK_STRATEGY_DEVICE_MODEL = "DeviceModel";
    private static final String BENCHMARK_STRATEGY_SOC_NAME = "SocName";
    public static final int DEVICE_PERF_LEVEL_HIGH = 4;
    public static final int DEVICE_PERF_LEVEL_LOW = 2;
    public static final int DEVICE_PERF_LEVEL_MIDDLE = 3;
    public static final int DEVICE_PERF_LEVEL_UNKNOWN = -1;
    public static final int DEVICE_PERF_LEVEL_VERYHIGH = 5;
    public static final int DEVICE_PERF_LEVEL_VERYLOW = 1;
    private static final String TAG = "OfflineConfig";
    private static String benchmarkStrategy = "DefaultValue";
    protected static float sGauLowMaxSize = 360.0f;
    protected static int sGauLowPhoneYear = 2014;
    protected static float sGauMidMaxSize = 480.0f;
    protected static int sGauMidderPhoneYear = 2015;
    protected static float sGauSuperMaxSzie = 540.0f;
    protected static int sGauSuperPhoneYear = 2017;
    protected static int sGaussMaxSize = -1;
    protected static float sGaussScale = -1.0f;
    protected static boolean sIsGaussResize = true;
    protected static int sIsPagEncodeBgStaus = 0;
    protected static int sLowDevYearPag = 2015;
    protected static int sLowDevYearRapidnet = 2015;
    protected static boolean sNeedSoftDecoder = false;
    protected static boolean sNotSupportRealTimePag = false;
    protected static int sPagNeedScaleStatus = 0;
    protected static float sPagScaleVaue = 0.5f;
    protected static int sRapidnetSkipMode = 0;
    private static final String sSocNameKirin = "kirin";
    protected static boolean sUpdateGaussSetting = false;
    public static int useCutoutVersion = CutOutVersion.NEW.value;
    private static int sPhonePerfLevel = -1;
    private static String sAssetsPath = "";

    /* compiled from: P */
    /* renamed from: org.light.device.OfflineConfig$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$light$bean$PhoneType;

        static {
            int[] iArr = new int[PhoneType.values().length];
            $SwitchMap$org$light$bean$PhoneType = iArr;
            try {
                iArr[PhoneType.SUPER_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$light$bean$PhoneType[PhoneType.MIDDER_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$light$bean$PhoneType[PhoneType.LOW_PHONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum CutOutVersion {
        OLD(1),
        NEW(2);

        public final int value;

        CutOutVersion(int i3) {
            this.value = i3;
        }
    }

    private static int convertBenchmarkLevelToPerfLevel(int i3) {
        int i16 = (5 - i3) + 1;
        if (i16 < 1) {
            return 1;
        }
        if (i16 > 5) {
            return 5;
        }
        return i16;
    }

    private static float getBenchmarkLevelByCpuFreq(JsonObject jsonObject) {
        JsonObject asJsonObject;
        int maxCpuFreq = LightDeviceUtils.getMaxCpuFreq();
        LightLogUtil.e(TAG, "getBenchmarkLevelByCpuFreq cpuFreqKhz:" + maxCpuFreq);
        if (maxCpuFreq <= 0 || (asJsonObject = jsonObject.getAsJsonObject("cpuFreq")) == null) {
            return -1.0f;
        }
        float f16 = (float) (maxCpuFreq * 1.0E-6d);
        float f17 = 0.0f;
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            String[] split = entry.getKey().replaceAll("[]\\s\\(]+", "").split(",");
            if (split.length == 2) {
                float parseFloat = Float.parseFloat(split[0]);
                float parseFloat2 = Float.parseFloat(split[1]);
                if (parseFloat < f16 && f16 <= parseFloat2) {
                    return entry.getValue().getAsFloat();
                }
                f17 = parseFloat2;
            }
        }
        if (f16 <= f17) {
            return -1.0f;
        }
        return 1.0f;
    }

    private static float getBenchmarkLevelByCpuPart(JsonObject jsonObject) {
        JsonObject asJsonObject;
        String lowerCase = LightDeviceUtils.getLastCpuPart().toLowerCase();
        LightLogUtil.e(TAG, "getBenchmarkLevelByCpuPart cpuPart:" + lowerCase);
        if (lowerCase.isEmpty() || (asJsonObject = jsonObject.getAsJsonObject("cpuPart")) == null || !asJsonObject.has(lowerCase)) {
            return -1.0f;
        }
        return asJsonObject.get(lowerCase).getAsFloat();
    }

    public static String getBenchmarkStrategy() {
        return benchmarkStrategy;
    }

    public static int getGauMaxSize() {
        return sGaussMaxSize;
    }

    public static PhoneType getGauPhoneType(int i3) {
        if (i3 >= sGauSuperPhoneYear) {
            return PhoneType.SUPER_PHONE;
        }
        if (i3 >= sGauMidderPhoneYear) {
            return PhoneType.MIDDER_PHONE;
        }
        return PhoneType.LOW_PHONE;
    }

    public static float getGauScaleFromPhoneYear(int i3) {
        int i16 = AnonymousClass1.$SwitchMap$org$light$bean$PhoneType[getGauPhoneType(i3).ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    return -1.0f;
                }
                return sGauLowMaxSize;
            }
            return sGauMidMaxSize;
        }
        return sGauSuperMaxSzie;
    }

    public static float getGauScaleValue() {
        return sGaussScale;
    }

    private static JsonObject getJsonObjectFromBenchmarkFile(Context context, String str) {
        String str2;
        if (sAssetsPath.isEmpty()) {
            str2 = FileOfflineUtil.readStringFromAssets(context, str);
        } else {
            String readJsonStringFromFile = FileOfflineUtil.readJsonStringFromFile(sAssetsPath + str);
            if (readJsonStringFromFile == null) {
                str2 = FileOfflineUtil.readStringFromAssets(context, str);
            } else {
                str2 = readJsonStringFromFile;
            }
        }
        if (str2 == null) {
            return null;
        }
        return GsonUtils.json2JsonObject(str2);
    }

    public static int getPagLowDeviceYear() {
        return sLowDevYearPag;
    }

    public static int getPagNeedScaleStatus() {
        return sPagNeedScaleStatus;
    }

    public static float getPagPlayScale() {
        return sPagScaleVaue;
    }

    private static int getPerfLevelByCpuInfo(Context context) {
        JsonObject jsonObjectFromBenchmarkFile = getJsonObjectFromBenchmarkFile(context, BENCHMARK_CPU_INFOS_PATH);
        if (jsonObjectFromBenchmarkFile == null) {
            LightLogUtil.e(TAG, "getPerfLevelByCpuInfo error: cpuInfos empty");
            return -1;
        }
        float benchmarkLevelByCpuPart = getBenchmarkLevelByCpuPart(jsonObjectFromBenchmarkFile);
        float benchmarkLevelByCpuFreq = getBenchmarkLevelByCpuFreq(jsonObjectFromBenchmarkFile);
        if (benchmarkLevelByCpuPart < 0.0f && benchmarkLevelByCpuFreq < 0.0f) {
            LightLogUtil.e(TAG, "getPerfLevelByCpuInfo error: cpuPartLevel and cpuFreqLevel < 0");
            return -1;
        }
        if (benchmarkLevelByCpuFreq < 0.0f) {
            benchmarkStrategy = BENCHMARK_STRATEGY_CPU_PART;
            sPhonePerfLevel = convertBenchmarkLevelToPerfLevel(Math.round(benchmarkLevelByCpuPart));
            LightLogUtil.e(TAG, "getPerfLevelByCpuInfo match with cpuPartLevel:" + benchmarkLevelByCpuPart);
            return sPhonePerfLevel;
        }
        if (benchmarkLevelByCpuPart < 0.0f) {
            benchmarkStrategy = BENCHMARK_STRATEGY_CPU_MAX_FREQ;
            sPhonePerfLevel = convertBenchmarkLevelToPerfLevel(Math.round(benchmarkLevelByCpuFreq));
            LightLogUtil.e(TAG, "getPerfLevelByCpuInfo match with cpuFreqLevel:" + benchmarkLevelByCpuFreq);
            return sPhonePerfLevel;
        }
        benchmarkStrategy = BENCHMARK_STRATEGY_CPU_PART_AND_MAX_FREQ;
        float asFloat = jsonObjectFromBenchmarkFile.get("cpuPartRatio").getAsFloat();
        int round = Math.round((benchmarkLevelByCpuPart * asFloat) + ((1.0f - asFloat) * benchmarkLevelByCpuFreq));
        LightLogUtil.e(TAG, "getPerfLevelByCpuInfo match with cpuPartLevel:" + benchmarkLevelByCpuPart + " and cpuFreqLevel:" + benchmarkLevelByCpuFreq + " and cpuPartRatio:" + asFloat);
        int convertBenchmarkLevelToPerfLevel = convertBenchmarkLevelToPerfLevel(round);
        sPhonePerfLevel = convertBenchmarkLevelToPerfLevel;
        return convertBenchmarkLevelToPerfLevel;
    }

    private static int getPerfLevelByDeviceModel(Context context) {
        String lowerCase = LightDeviceUtils.getBuildModel().trim().toLowerCase();
        if (lowerCase.isEmpty()) {
            LightLogUtil.e(TAG, "getPerfLevelByDeviceModel error: deviceModel empty");
            return -1;
        }
        LightLogUtil.e(TAG, "getPerfLevelByDeviceModel: deviceModel:" + lowerCase);
        JsonObject jsonObjectFromBenchmarkFile = getJsonObjectFromBenchmarkFile(context, BENCHMARK_DEVICE_MODELS_DIR + lowerCase.charAt(0) + Sticker.JSON_SUFFIX);
        if (jsonObjectFromBenchmarkFile != null && jsonObjectFromBenchmarkFile.has(lowerCase)) {
            benchmarkStrategy = "DeviceModel";
            int convertBenchmarkLevelToPerfLevel = convertBenchmarkLevelToPerfLevel(jsonObjectFromBenchmarkFile.get(lowerCase).getAsInt());
            sPhonePerfLevel = convertBenchmarkLevelToPerfLevel;
            return convertBenchmarkLevelToPerfLevel;
        }
        LightLogUtil.e(TAG, "getPerfLevelByDeviceModel error: deviceModel not exist");
        return -1;
    }

    private static int getPerfLevelBySocModel(Context context) {
        String lowerCase = LightDeviceUtils.getSocName().toLowerCase();
        if (lowerCase.isEmpty()) {
            LightLogUtil.e(TAG, "getPerfLevelBySocModel error: socName empty");
            return -1;
        }
        LightLogUtil.e(TAG, "getPerfLevelBySocModel: socName:" + lowerCase);
        JsonObject jsonObjectFromBenchmarkFile = getJsonObjectFromBenchmarkFile(context, BENCHMARK_SOC_MODELS_PATH);
        if (jsonObjectFromBenchmarkFile == null) {
            LightLogUtil.e(TAG, "getPerfLevelBySocModel error: socModels empty");
            return -1;
        }
        for (Map.Entry<String, JsonElement> entry : jsonObjectFromBenchmarkFile.entrySet()) {
            if (lowerCase.contains(entry.getKey())) {
                benchmarkStrategy = BENCHMARK_STRATEGY_SOC_NAME;
                int convertBenchmarkLevelToPerfLevel = convertBenchmarkLevelToPerfLevel(entry.getValue().getAsInt());
                sPhonePerfLevel = convertBenchmarkLevelToPerfLevel;
                return convertBenchmarkLevelToPerfLevel;
            }
        }
        if (!lowerCase.startsWith(sSocNameKirin)) {
            return -1;
        }
        LightLogUtil.e(TAG, "getPerfLevelBySocModel: match kirin, return VERYHIGH");
        benchmarkStrategy = BENCHMARK_STRATEGY_SOC_NAME;
        sPhonePerfLevel = 5;
        return 5;
    }

    public static int getPhonePerfLevel(Context context) {
        int i3 = sPhonePerfLevel;
        if (i3 != -1) {
            return i3;
        }
        if (context == null) {
            LightLogUtil.e(TAG, "getPhonePerfLevel: context is null");
            sPhonePerfLevel = 3;
            return 3;
        }
        if (getPerfLevelByDeviceModel(context) != -1) {
            LightLogUtil.e(TAG, "getPhonePerfLevel: match with model:" + sPhonePerfLevel);
            return sPhonePerfLevel;
        }
        if (getPerfLevelBySocModel(context) != -1) {
            LightLogUtil.e(TAG, "getPhonePerfLevel: match with soc:" + sPhonePerfLevel);
            return sPhonePerfLevel;
        }
        if (getPerfLevelByCpuInfo(context) != -1) {
            LightLogUtil.e(TAG, "getPhonePerfLevel: match with cpu:" + sPhonePerfLevel);
            return sPhonePerfLevel;
        }
        sPhonePerfLevel = 3;
        return 3;
    }

    public static int getPhoneType(int i3) {
        if (i3 >= sGauSuperPhoneYear) {
            return 5;
        }
        if (i3 >= sGauMidderPhoneYear) {
            return 3;
        }
        if (i3 >= sGauLowPhoneYear) {
            return 2;
        }
        return 1;
    }

    public static int isEncodeBackGround() {
        return sIsPagEncodeBgStaus;
    }

    public static boolean isGausResize() {
        return sIsGaussResize;
    }

    public static boolean isGaussSettingUpdate() {
        return sUpdateGaussSetting;
    }

    public static boolean isNeedScale() {
        if ((sPagNeedScaleStatus == 0 && YearClass.get(null) <= sLowDevYearPag) || sPagNeedScaleStatus == 1) {
            return true;
        }
        return false;
    }

    public static boolean isNeedSkipRapidnet(Context context) {
        if ((sRapidnetSkipMode == 0 && YearClass.get(context) <= sLowDevYearRapidnet) || sRapidnetSkipMode == 1) {
            return true;
        }
        return false;
    }

    public static boolean isNeedSoftDecode() {
        return sNeedSoftDecoder;
    }

    public static boolean isNotSuptPagRealTime() {
        return sNotSupportRealTimePag;
    }

    public static void setAssetsPath(String str) {
        if (!str.endsWith("/")) {
            sAssetsPath = str + "/";
            return;
        }
        sAssetsPath = str;
    }
}

package com.tencent.state.report;

import com.tencent.state.square.data.SquareDeviceInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/report/PerformanceReportConst;", "", "()V", "covertDeviceInfo", "", "", "info", "Lcom/tencent/state/square/data/SquareDeviceInfo;", "CustomEventId", "Key", "Param", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PerformanceReportConst {
    public static final PerformanceReportConst INSTANCE = new PerformanceReportConst();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/report/PerformanceReportConst$CustomEventId;", "", "()V", "EVENT_ID_PERFORMANCE_HARDWARE_INFO", "", "EVENT_ID_PERFORMANCE_REPORT", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class CustomEventId {
        public static final String EVENT_ID_PERFORMANCE_HARDWARE_INFO = "ev_zplan_square_performance_device_info";
        public static final String EVENT_ID_PERFORMANCE_REPORT = "ev_zplan_square_performance_report";
        public static final CustomEventId INSTANCE = new CustomEventId();

        CustomEventId() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/report/PerformanceReportConst$Key;", "", "()V", "KEY_PERFORMANCE_APP_MEMORY", "", "KEY_PERFORMANCE_CPU_USAGE", "KEY_PERFORMANCE_DURATION_AFTER_SCENE_INIT", "KEY_PERFORMANCE_FILAMENT_INDEX", "KEY_PERFORMANCE_FIRST_EXPOSURE_BASE_LOAD", "KEY_PERFORMANCE_FIRST_EXPOSURE_DATA_LOAD", "KEY_PERFORMANCE_FIRST_EXPOSURE_MAP_BASE_INIT", "KEY_PERFORMANCE_FIRST_EXPOSURE_TIME", "KEY_PERFORMANCE_FIRST_EXPOSURE_USE_CACHE", "KEY_PERFORMANCE_FIRST_REPORT", "KEY_PERFORMANCE_FPS", "KEY_PERFORMANCE_HI_BRAND", "KEY_PERFORMANCE_HI_CPU_CORE", "KEY_PERFORMANCE_HI_CPU_CORE_COUNT", "KEY_PERFORMANCE_HI_CPU_FREQ", "KEY_PERFORMANCE_HI_CPU_NAME", "KEY_PERFORMANCE_HI_DENSITY", "KEY_PERFORMANCE_HI_DEVICE", "KEY_PERFORMANCE_HI_GLES", "KEY_PERFORMANCE_HI_GPU_NAME", "KEY_PERFORMANCE_HI_HEIGHT", "KEY_PERFORMANCE_HI_INSTRUCTION_SET", "KEY_PERFORMANCE_HI_IS_ARM64", "KEY_PERFORMANCE_HI_MANUFACTURER", "KEY_PERFORMANCE_HI_MODEL", "KEY_PERFORMANCE_HI_OS", "KEY_PERFORMANCE_HI_OS_VERSION", "KEY_PERFORMANCE_HI_RAM", "KEY_PERFORMANCE_HI_UDID", "KEY_PERFORMANCE_HI_WIDTH", "KEY_PERFORMANCE_LEFT_MEMORY", "KEY_PERFORMANCE_MEMORY_DELTA", "KEY_PERFORMANCE_PLAY_COUNT", "KEY_PERFORMANCE_REFRESH_RATE", "KEY_PERFORMANCE_SCENE", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Key {
        public static final Key INSTANCE = new Key();
        public static final String KEY_PERFORMANCE_APP_MEMORY = "zplan_square_performance_appmemory";
        public static final String KEY_PERFORMANCE_CPU_USAGE = "zplan_square_performance_cpu";
        public static final String KEY_PERFORMANCE_DURATION_AFTER_SCENE_INIT = "zplan_square_performance_duration_after_scene_init";
        public static final String KEY_PERFORMANCE_FILAMENT_INDEX = "zplan_square_performance_filament_index";
        public static final String KEY_PERFORMANCE_FIRST_EXPOSURE_BASE_LOAD = "zplan_square_performance_first_exposure_base_load";
        public static final String KEY_PERFORMANCE_FIRST_EXPOSURE_DATA_LOAD = "zplan_square_performance_first_exposure_data_load";
        public static final String KEY_PERFORMANCE_FIRST_EXPOSURE_MAP_BASE_INIT = "zplan_square_performance_first_exposure_map_base_init";
        public static final String KEY_PERFORMANCE_FIRST_EXPOSURE_TIME = "zplan_square_performance_first_exposure_time";
        public static final String KEY_PERFORMANCE_FIRST_EXPOSURE_USE_CACHE = "zplan_square_performance_first_exposure_use_cache";
        public static final String KEY_PERFORMANCE_FIRST_REPORT = "zplan_square_performance_first_report";
        public static final String KEY_PERFORMANCE_FPS = "zplan_square_performance_fps";
        public static final String KEY_PERFORMANCE_HI_BRAND = "zplan_square_hi_brand";
        public static final String KEY_PERFORMANCE_HI_CPU_CORE = "zplan_square_hi_core_name";
        public static final String KEY_PERFORMANCE_HI_CPU_CORE_COUNT = "zplan_square_hi_cpu_core_count";
        public static final String KEY_PERFORMANCE_HI_CPU_FREQ = "zplan_square_hi_cpu_freq";
        public static final String KEY_PERFORMANCE_HI_CPU_NAME = "zplan_square_hi_cpu_name";
        public static final String KEY_PERFORMANCE_HI_DENSITY = "zplan_square_hi_density";
        public static final String KEY_PERFORMANCE_HI_DEVICE = "zplan_square_hi_device";
        public static final String KEY_PERFORMANCE_HI_GLES = "zplan_square_hi_gles";
        public static final String KEY_PERFORMANCE_HI_GPU_NAME = "zplan_square_hi_gpu_name";
        public static final String KEY_PERFORMANCE_HI_HEIGHT = "zplan_square_hi_height";
        public static final String KEY_PERFORMANCE_HI_INSTRUCTION_SET = "zplan_square_hi_instruction_set";
        public static final String KEY_PERFORMANCE_HI_IS_ARM64 = "zplan_square_hi_is_arm64";
        public static final String KEY_PERFORMANCE_HI_MANUFACTURER = "zplan_square_hi_manufacturer";
        public static final String KEY_PERFORMANCE_HI_MODEL = "zplan_square_hi_model";
        public static final String KEY_PERFORMANCE_HI_OS = "zplan_square_hi_os";
        public static final String KEY_PERFORMANCE_HI_OS_VERSION = "zplan_square_hi_os_version";
        public static final String KEY_PERFORMANCE_HI_RAM = "zplan_square_hi_ram";
        public static final String KEY_PERFORMANCE_HI_UDID = "zplan_square_hi_udid";
        public static final String KEY_PERFORMANCE_HI_WIDTH = "zplan_square_hi_width";
        public static final String KEY_PERFORMANCE_LEFT_MEMORY = "zplan_square_performance_leftmemory";
        public static final String KEY_PERFORMANCE_MEMORY_DELTA = "zplan_square_performance_memorydelta";
        public static final String KEY_PERFORMANCE_PLAY_COUNT = "zplan_square_performance_playcount";
        public static final String KEY_PERFORMANCE_REFRESH_RATE = "zplan_square_performance_refreshrate";
        public static final String KEY_PERFORMANCE_SCENE = "zplan_square_performance_scene";

        Key() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/report/PerformanceReportConst$Param;", "", "()V", "EM_SCENE_GUEST_STATUS", "", "EM_SCENE_HOST_STATUS", "EM_SCENE_MAP", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Param {
        public static final String EM_SCENE_GUEST_STATUS = "zplan_square_scene_gueststatus";
        public static final String EM_SCENE_HOST_STATUS = "zplan_square_scene_hoststatus";
        public static final String EM_SCENE_MAP = "zplan_square_scene_map";
        public static final Param INSTANCE = new Param();

        Param() {
        }
    }

    PerformanceReportConst() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> covertDeviceInfo(SquareDeviceInfo info) {
        boolean z16;
        Map<String, Object> mutableMapOf;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(info, "info");
        String cpuName = info.getCpuName();
        if (cpuName != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(cpuName);
            if (!isBlank2) {
                z16 = false;
                if (z16) {
                    String gpuName = info.getGpuName();
                    if (gpuName != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(gpuName);
                        if (!isBlank) {
                            z17 = false;
                            if (z17) {
                                return new LinkedHashMap();
                            }
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(Key.KEY_PERFORMANCE_HI_GLES, info.getGlesVersion()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_OS, info.getOsName()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_OS_VERSION, info.getOsVersion()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_MANUFACTURER, info.getManufacturer()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_INSTRUCTION_SET, info.getInstrumentationSet()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_CORE, info.getCpuCore()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_NAME, info.getCpuName()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_IS_ARM64, info.getIsArm64()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_GPU_NAME, info.getGpuName()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_MODEL, info.getModel()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_UDID, info.getUdid()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_BRAND, info.getBrand()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_DEVICE, info.getDevice()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_RAM, info.getRamSize()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_WIDTH, info.getDisplayWidth()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_HEIGHT, info.getDisplayHeight()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_DENSITY, info.getDisplayDensity()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_CORE_COUNT, info.getCpuCoreCount()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_FREQ, info.getCpuFreq()));
                return mutableMapOf;
            }
        }
        z16 = true;
        if (z16) {
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(Key.KEY_PERFORMANCE_HI_GLES, info.getGlesVersion()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_OS, info.getOsName()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_OS_VERSION, info.getOsVersion()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_MANUFACTURER, info.getManufacturer()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_INSTRUCTION_SET, info.getInstrumentationSet()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_CORE, info.getCpuCore()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_NAME, info.getCpuName()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_IS_ARM64, info.getIsArm64()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_GPU_NAME, info.getGpuName()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_MODEL, info.getModel()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_UDID, info.getUdid()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_BRAND, info.getBrand()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_DEVICE, info.getDevice()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_RAM, info.getRamSize()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_WIDTH, info.getDisplayWidth()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_HEIGHT, info.getDisplayHeight()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_DENSITY, info.getDisplayDensity()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_CORE_COUNT, info.getCpuCoreCount()), TuplesKt.to(Key.KEY_PERFORMANCE_HI_CPU_FREQ, info.getCpuFreq()));
        return mutableMapOf;
    }
}

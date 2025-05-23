package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0002J0\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010!\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010\"R\u0014\u0010*\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00106\u00a8\u00069"}, d2 = {"Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWLowDeviceStatusMonitorManager;", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$IMonitorListener;", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceMonitorIntervalOption;", "getIntervalOption", "", "realCpuUsage", "", "cpuUsageExceededLimit", "", "getCpuMax", "getFileDescriptorMax", "getThreadMax", "getMemoryUsageMax", "livingThreadCount", "threadUsageExceedLimit", "memoryUsage", "memoryUsageExceedLimit", "fileDescriptorCount", "fileDescriptorUsageExceedLimit", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceStatus;", "status", "cpuExceededLimit", "memoryExceededLimit", "threadExceededLimit", "fileDescriptorExceededLimit", "Lorg/json/JSONObject;", "getLocalEnvReportJSONObject", "", "startMonitor", "stopMonitor", "canPrerender", "statusChanged", "", "REPORT_KEY_CPU_USAGE", "Ljava/lang/String;", "REPORT_KEY_MEMORY_USAGE", "REPORT_KEY_THREAD_COUNT", "REPORT_KEY_FILE_DESCRIPTOR_COUNT", "REPORT_KEY_CPU_EXCEEDED_LIMIT", "REPORT_KEY_MEMORY_EXCEEDED_LIMIT", "REPORT_KEY_THREAD_EXCEEDED_LIMIT", "REPORT_KEY_FILE_DESCRIPTOR_EXCEEDED_LIMIT", "EVENT_ID_LOCAL_ENV_NOT_AVAILABLE", "MAX_CPU_USAGE", "I", "DEFAULT_MEMORY_USAGE_PERSENTAGE_MAX", "DEFAULT_FILE_DESCRIPTOR_MAX", "DEFAULT_THREAD_COUNT_MAX", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor;", "monitor$delegate", "Lkotlin/Lazy;", "getMonitor", "()Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor;", "monitor", "Z", "<init>", "()V", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWLowDeviceStatusMonitorManager implements RFWDeviceStatusMonitor.IMonitorListener {
    private static volatile boolean canPrerender;

    /* renamed from: monitor$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy monitor;

    @NotNull
    public static final RFWLowDeviceStatusMonitorManager INSTANCE = new RFWLowDeviceStatusMonitorManager();

    @NotNull
    private static final String REPORT_KEY_CPU_USAGE = "cpuUsage";

    @NotNull
    private static final String REPORT_KEY_MEMORY_USAGE = "memoryUsage";

    @NotNull
    private static final String REPORT_KEY_THREAD_COUNT = "threadCount";

    @NotNull
    private static final String REPORT_KEY_FILE_DESCRIPTOR_COUNT = "fileDescriptorCount";

    @NotNull
    private static final String REPORT_KEY_CPU_EXCEEDED_LIMIT = "cpuExeededLimit";

    @NotNull
    private static final String REPORT_KEY_MEMORY_EXCEEDED_LIMIT = "memoryExeededLimit";

    @NotNull
    private static final String REPORT_KEY_THREAD_EXCEEDED_LIMIT = "threadExeededLimit";

    @NotNull
    private static final String REPORT_KEY_FILE_DESCRIPTOR_EXCEEDED_LIMIT = "fileDescriptorExeededLimit";

    @NotNull
    private static final String EVENT_ID_LOCAL_ENV_NOT_AVAILABLE = "low_device_local_env_not_available";
    private static final int MAX_CPU_USAGE = 50;
    private static final int DEFAULT_MEMORY_USAGE_PERSENTAGE_MAX = 85;
    private static final int DEFAULT_FILE_DESCRIPTOR_MAX = FSUploadConst.ERR_FILE_NOT_EXIST;
    private static final int DEFAULT_THREAD_COUNT_MAX = 600;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<RFWDeviceStatusMonitor>() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWLowDeviceStatusMonitorManager$monitor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWDeviceStatusMonitor invoke() {
                return new RFWDeviceStatusMonitor(RFWLowDeviceStatusMonitorManager.INSTANCE);
            }
        });
        monitor = lazy;
        canPrerender = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enalbe_low_device_render_local_condition_default", true);
    }

    RFWLowDeviceStatusMonitorManager() {
    }

    private final boolean cpuUsageExceededLimit(float realCpuUsage) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_cpu_limit", true)) {
            QLog.d("RFWDeviceStatusMonitorManager", 1, "hitExpB cpuUsage limit not enabled");
            return false;
        }
        QLog.d("RFWDeviceStatusMonitorManager", 1, "hitExpB cpuUsage \uff1a" + realCpuUsage);
        if (realCpuUsage * 100 < getCpuMax()) {
            return false;
        }
        QLog.d("RFWDeviceStatusMonitorManager", 1, "hitExpB cpuUsage too max");
        return true;
    }

    private final boolean fileDescriptorUsageExceedLimit(int fileDescriptorCount) {
        boolean z16 = false;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_file_descriptor_limit", true)) {
            RFWLog.d("RFWDeviceStatusMonitorManager", RFWLog.USR, "hitExpB fileDescriptorCount limit not enabled");
            return false;
        }
        QLog.d("RFWDeviceStatusMonitorManager", 1, "hitExpB fileDescriptorCount \uff1a" + fileDescriptorCount);
        if (fileDescriptorCount >= getFileDescriptorMax()) {
            z16 = true;
        }
        if (z16) {
            QLog.d("RFWDeviceStatusMonitorManager", 1, "hitExpB fileDescriptorCount too max");
        }
        return z16;
    }

    private final int getCpuMax() {
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        int i3 = MAX_CPU_USAGE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String loadAsString = iUnitedConfigManager.loadAsString("qqcircle_low_device_render_cpu_usage_max", sb5.toString());
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("RFWDeviceStatusMonitorManager", 1, "[getCpuMax] error: " + e16 + ",serverConfig:" + loadAsString);
            return MAX_CPU_USAGE;
        }
    }

    private final int getFileDescriptorMax() {
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        int i3 = DEFAULT_FILE_DESCRIPTOR_MAX;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String loadAsString = iUnitedConfigManager.loadAsString("qqcircle_low_device_render_file_descriptor_max", sb5.toString());
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("RFWDeviceStatusMonitorManager", 1, "[getMaxFileDescriptor] error: " + e16 + ",serverConfig:" + loadAsString);
            return DEFAULT_FILE_DESCRIPTOR_MAX;
        }
    }

    private final RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption getIntervalOption() {
        return new RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption(RFWStringsKt.toLongOrDefault$default(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_cpu_monitor_interval", "5000"), 5000L, 0, 2, null), RFWStringsKt.toLongOrDefault$default(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_memory_monitor_interval", "5000"), 5000L, 0, 2, null), RFWStringsKt.toLongOrDefault$default(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_file_descriptor_monitor_interval", "5000"), 5000L, 0, 2, null));
    }

    private final JSONObject getLocalEnvReportJSONObject(RFWDeviceStatusMonitor.RFWDeviceStatus status, boolean cpuExceededLimit, boolean memoryExceededLimit, boolean threadExceededLimit, boolean fileDescriptorExceededLimit) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(REPORT_KEY_CPU_USAGE, status.getCpuUsage());
            jSONObject.put(REPORT_KEY_MEMORY_USAGE, status.getMemoryUsage());
            jSONObject.put(REPORT_KEY_THREAD_COUNT, status.getThreadCount());
            jSONObject.put(REPORT_KEY_FILE_DESCRIPTOR_COUNT, status.getFileDescriptorCount());
            jSONObject.put(REPORT_KEY_CPU_EXCEEDED_LIMIT, cpuExceededLimit);
            jSONObject.put(REPORT_KEY_MEMORY_EXCEEDED_LIMIT, memoryExceededLimit);
            jSONObject.put(REPORT_KEY_THREAD_EXCEEDED_LIMIT, threadExceededLimit);
            jSONObject.put(REPORT_KEY_FILE_DESCRIPTOR_EXCEEDED_LIMIT, fileDescriptorExceededLimit);
        } catch (JSONException e16) {
            RFWLog.e("RFWDeviceStatusMonitorManager", RFWLog.USR, e16);
        }
        return jSONObject;
    }

    private final float getMemoryUsageMax() {
        int i3;
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        int i16 = DEFAULT_MEMORY_USAGE_PERSENTAGE_MAX;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i16);
        String loadAsString = iUnitedConfigManager.loadAsString("qqcircle_low_device_render_memory_usage_persentage_max", sb5.toString());
        try {
            i3 = Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("RFWDeviceStatusMonitorManager", 1, "[getMemoryUsageMax] error: " + e16 + ",serverConfig:" + loadAsString);
            i3 = DEFAULT_MEMORY_USAGE_PERSENTAGE_MAX;
        }
        return i3 / 100.0f;
    }

    private final RFWDeviceStatusMonitor getMonitor() {
        return (RFWDeviceStatusMonitor) monitor.getValue();
    }

    private final int getThreadMax() {
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        int i3 = DEFAULT_THREAD_COUNT_MAX;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String loadAsString = iUnitedConfigManager.loadAsString("qqcircle_low_device_render_thread_max", sb5.toString());
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("RFWDeviceStatusMonitorManager", 1, "[getThreadMax] error: " + e16 + ",serverConfig:" + loadAsString);
            return DEFAULT_THREAD_COUNT_MAX;
        }
    }

    private final boolean memoryUsageExceedLimit(float memoryUsage) {
        boolean z16;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_memory_limit", true)) {
            RFWLog.d("RFWDeviceStatusMonitorManager", RFWLog.USR, "hitExpB memoryUsage limit not enabled");
            return false;
        }
        if (memoryUsage >= getMemoryUsageMax()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RFWLog.d("RFWDeviceStatusMonitorManager", RFWLog.USR, "hitExpB memoryUsage too max " + memoryUsage);
        }
        return z16;
    }

    private final boolean threadUsageExceedLimit(int livingThreadCount) {
        boolean z16;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_thread_limit", true)) {
            RFWLog.d("RFWDeviceStatusMonitorManager", RFWLog.USR, "hitExpB thread limit not enabled");
            return false;
        }
        RFWLog.d("RFWDeviceStatusMonitorManager", 1, "hitExpB active threadCount living thread count = " + livingThreadCount);
        if (livingThreadCount >= getThreadMax()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RFWLog.d("RFWDeviceStatusMonitorManager", RFWLog.USR, "hitExpB threadCount too max");
        }
        return z16;
    }

    public final boolean canPrerender() {
        return canPrerender;
    }

    public final void startMonitor() {
        if (!QCircleVideoDeviceInfoUtils.isLowDevice()) {
            RFWLog.d("RFWDeviceStatusMonitorManager", 1, "not low device, skip start monitor");
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_render_new", true);
        RFWLog.d("RFWDeviceStatusMonitorManager", 1, "hit low device pre render exp:" + isSwitchOn);
        if (!isSwitchOn) {
            RFWLog.d("RFWDeviceStatusMonitorManager", 1, "not hit low device pre render exp, skip start monitor");
            return;
        }
        RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption intervalOption = getIntervalOption();
        RFWLog.d("RFWDeviceStatusMonitorManager", 1, "starting monitor: " + intervalOption);
        getMonitor().startMonitor(intervalOption);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor.IMonitorListener
    public void statusChanged(@NotNull RFWDeviceStatusMonitor.RFWDeviceStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        boolean cpuUsageExceededLimit = cpuUsageExceededLimit(status.getCpuUsage());
        boolean memoryUsageExceedLimit = memoryUsageExceedLimit(status.getMemoryUsage());
        boolean threadUsageExceedLimit = threadUsageExceedLimit(status.getThreadCount());
        boolean fileDescriptorUsageExceedLimit = fileDescriptorUsageExceedLimit(status.getFileDescriptorCount());
        JSONObject localEnvReportJSONObject = getLocalEnvReportJSONObject(status, cpuUsageExceededLimit, memoryUsageExceedLimit, threadUsageExceedLimit, fileDescriptorUsageExceedLimit);
        boolean z16 = true;
        if (cpuUsageExceededLimit || memoryUsageExceedLimit || threadUsageExceedLimit || fileDescriptorUsageExceedLimit) {
            QLog.d("RFWDeviceStatusMonitorManager", 1, "limit by cpu or memory ");
            QCircleQualityReporter.reportQualityEvent(EVENT_ID_LOCAL_ENV_NOT_AVAILABLE, Arrays.asList(QCircleReportHelper.newEntry("attach_info", localEnvReportJSONObject.toString())), false);
            z16 = false;
        }
        canPrerender = z16;
    }

    public final void stopMonitor() {
        RFWLog.d("RFWDeviceStatusMonitorManager", 1, "stopping monitor");
        getMonitor().stopMonitor$qq_video_kit_release(null);
    }
}

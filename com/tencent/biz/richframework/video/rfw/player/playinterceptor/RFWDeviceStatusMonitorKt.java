package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002\u00a8\u0006\u0003"}, d2 = {"getMinInterval", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceMonitorIntervalOption;", "", "qq-video-kit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWDeviceStatusMonitorKt {
    @NotNull
    public static final RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption getMinInterval(@NotNull List<RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return new RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption(0L, 0L, 0L, 7, null);
        }
        long j3 = Long.MAX_VALUE;
        long j16 = Long.MAX_VALUE;
        long j17 = Long.MAX_VALUE;
        for (RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption : list) {
            if (rFWDeviceMonitorIntervalOption.getCpuMonitorIntervalMs() < j3) {
                j3 = rFWDeviceMonitorIntervalOption.getCpuMonitorIntervalMs();
            }
            if (rFWDeviceMonitorIntervalOption.getMemoryMonitorIntervalMs() < j16) {
                j16 = rFWDeviceMonitorIntervalOption.getMemoryMonitorIntervalMs();
            }
            if (rFWDeviceMonitorIntervalOption.getFileDescriptorMonitorIntervalMs() < j17) {
                j17 = rFWDeviceMonitorIntervalOption.getFileDescriptorMonitorIntervalMs();
            }
        }
        return new RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption(j3, j16, j17);
    }
}

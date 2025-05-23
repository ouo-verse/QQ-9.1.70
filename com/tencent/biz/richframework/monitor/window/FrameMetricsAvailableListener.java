package com.tencent.biz.richframework.monitor.window;

import android.os.Build;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RequiresApi(24)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001aR\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010!R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001aR\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001aR\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001aR\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001aR\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010!R<\u0010/\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0-0,j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0-`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001aR\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001aR\"\u00103\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0012\u0012\u0004\u0012\u0002080,j\b\u0012\u0004\u0012\u000208`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00100\u00a8\u0006="}, d2 = {"Lcom/tencent/biz/richframework/monitor/window/FrameMetricsAvailableListener;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "Landroid/view/FrameMetrics;", "frameMetrics", "", "getFrameCombination", "", "getCurrentVsync", "", "calculateFps", "Landroid/view/Window;", "window", "getNormalFrameInterval", "", "getFluency", "", "dropCount", "getRangeIndex", "", WidgetCacheConstellationData.NUM, "convert2Float", "dropCountSinceLastInvocation", "onFrameMetricsAvailable", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "getWindowPerformanceData", "frameDuration", "J", "refresh", UserInfo.SEX_FEMALE, "frameCount", "I", "vsyncIntervalMs", "dropTimes", "[J", "", "dropDurationArray", "[F", "maxFrameTime", "maxFrameCombination", "firstMonitorTime", "firstVsyncTime", "lastVsyncTime", "firstDrawTime", "firstDrawTimeCombination", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "fps", "Ljava/util/ArrayList;", "totalCount", "lastVsyncStartTime", "addTime", "getAddTime", "()J", "setAddTime", "(J)V", "", "errorList", "<init>", "()V", "Companion", "monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class FrameMetricsAvailableListener implements Window.OnFrameMetricsAvailableListener {
    private static final boolean isOpenErrorReport = RFWConfig.getConfigValue("frame_metrics_open_error_report", true);
    private long addTime;
    private long firstDrawTime;
    private long[] firstDrawTimeCombination;
    private long firstMonitorTime;
    private long firstVsyncTime;
    private int frameCount;
    private long frameDuration;
    private long lastVsyncStartTime;
    private long lastVsyncTime;
    private long[] maxFrameCombination;
    private long maxFrameTime;
    private float refresh;
    private long totalCount;
    private float vsyncIntervalMs;
    private long[] dropTimes = new long[6];
    private float[] dropDurationArray = new float[6];
    private final ArrayList<Pair<Integer, Float>> fps = new ArrayList<>();
    private final ArrayList<String> errorList = new ArrayList<>();

    private final void calculateFps() {
        int i3 = this.frameCount;
        if (i3 == 0) {
            return;
        }
        long j3 = this.lastVsyncTime - this.firstVsyncTime;
        if (j3 <= 0) {
            return;
        }
        float f16 = ((i3 * 1000) * 1000000) / ((float) j3);
        if (f16 > this.refresh * 2 && isOpenErrorReport && this.errorList.size() < 10) {
            ArrayList<String> arrayList = this.errorList;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.frameCount);
            sb5.append('/');
            sb5.append(j3);
            arrayList.add(sb5.toString());
        }
        this.fps.add(TuplesKt.to(Integer.valueOf(this.frameCount), Float.valueOf(Math.min(f16, this.refresh))));
        this.totalCount += this.frameCount;
        this.frameCount = 0;
        this.firstVsyncTime = 0L;
        this.lastVsyncTime = 0L;
    }

    private final float convert2Float(double num) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(num * 10);
        return roundToInt / 10;
    }

    private final long getCurrentVsync(FrameMetrics frameMetrics) {
        long metric;
        if (Build.VERSION.SDK_INT >= 26) {
            metric = frameMetrics.getMetric(11);
            return metric;
        }
        return System.nanoTime();
    }

    private final float getFluency() {
        float f16;
        long j3 = 0;
        int i3 = 0;
        for (int i16 = 0; i16 < 6; i16++) {
            long j16 = this.dropTimes[i16];
            float f17 = (float) j16;
            float[] fArr = this.dropDurationArray;
            if (fArr != null) {
                f16 = fArr[i16];
            } else {
                f16 = 1.0f;
            }
            j3 += f17 * f16;
            i3 += (int) j16;
        }
        float f18 = i3 * this.vsyncIntervalMs;
        if (j3 != 0) {
            return convert2Float((f18 / j3) * 100);
        }
        return 0.0f;
    }

    private final long[] getFrameCombination(FrameMetrics frameMetrics) {
        long metric;
        long metric2;
        long metric3;
        long metric4;
        long metric5;
        long metric6;
        metric = frameMetrics.getMetric(0);
        metric2 = frameMetrics.getMetric(1);
        metric3 = frameMetrics.getMetric(2);
        metric4 = frameMetrics.getMetric(3);
        metric5 = frameMetrics.getMetric(4);
        metric6 = frameMetrics.getMetric(5);
        return new long[]{metric, metric2, metric3, metric4, metric5, metric6};
    }

    private final long getNormalFrameInterval(Window window) {
        if (this.frameDuration <= 0) {
            float refresh = WindowUtilsKt.getRefresh(window);
            this.refresh = refresh;
            float f16 = 1000 / refresh;
            this.vsyncIntervalMs = f16;
            this.frameDuration = 1000000 * f16;
            this.dropDurationArray = new float[]{f16, 1.5f * f16, 3.0f * f16, 6.0f * f16, 11.5f * f16, f16 * 15.0f};
        }
        return this.frameDuration;
    }

    private final int getRangeIndex(int dropCount) {
        if (dropCount <= 0) {
            return 0;
        }
        int i3 = 1;
        if (dropCount != 1) {
            i3 = 4;
            if (dropCount <= 4) {
                return 2;
            }
            if (dropCount <= 8) {
                return 3;
            }
            if (dropCount > 15) {
                return 5;
            }
        }
        return i3;
    }

    @Nullable
    public final WindowPerformanceData getWindowPerformanceData() {
        calculateFps();
        if (this.totalCount <= 10) {
            return null;
        }
        WindowPerformanceData windowPerformanceData = new WindowPerformanceData((int) this.refresh);
        windowPerformanceData.setTotalCount(this.totalCount);
        windowPerformanceData.getFps().addAll(this.fps);
        windowPerformanceData.setMaxFrameCombination(this.maxFrameCombination);
        windowPerformanceData.setMaxFrameTime(this.maxFrameTime);
        windowPerformanceData.setFirstDrawTime(this.firstDrawTime);
        windowPerformanceData.setFirstDrawTimeCombination(this.firstDrawTimeCombination);
        windowPerformanceData.setMonitorDuration(System.currentTimeMillis() - this.firstMonitorTime);
        windowPerformanceData.setFluency(getFluency());
        if (!this.errorList.isEmpty()) {
            windowPerformanceData.getExtMap().put("error_msg", this.errorList);
        }
        return windowPerformanceData;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    @WorkerThread
    public void onFrameMetricsAvailable(@NotNull Window window, @NotNull FrameMetrics frameMetrics, int dropCountSinceLastInvocation) {
        long metric;
        long metric2;
        long metric3;
        long metric4;
        long metric5;
        long metric6;
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        if (this.firstMonitorTime == 0) {
            this.firstMonitorTime = System.currentTimeMillis();
        }
        metric = frameMetrics.getMetric(0);
        metric2 = frameMetrics.getMetric(1);
        long j3 = metric + metric2;
        metric3 = frameMetrics.getMetric(2);
        long j16 = j3 + metric3;
        metric4 = frameMetrics.getMetric(3);
        long j17 = j16 + metric4;
        metric5 = frameMetrics.getMetric(4);
        long j18 = j17 + metric5;
        metric6 = frameMetrics.getMetric(5);
        long j19 = j18 + metric6;
        long currentVsync = getCurrentVsync(frameMetrics);
        if (this.lastVsyncStartTime < currentVsync && currentVsync >= this.addTime) {
            if (this.firstDrawTime == 0) {
                this.firstDrawTime = j19;
                this.firstDrawTimeCombination = getFrameCombination(frameMetrics);
                return;
            }
            long normalFrameInterval = getNormalFrameInterval(window);
            if (this.firstVsyncTime == 0) {
                this.firstVsyncTime = currentVsync;
                this.lastVsyncTime = Math.max(j19, normalFrameInterval) + currentVsync;
            } else if (this.lastVsyncTime + normalFrameInterval > currentVsync) {
                this.lastVsyncTime = Math.max(j19, normalFrameInterval) + currentVsync;
            } else {
                calculateFps();
                this.firstVsyncTime = currentVsync;
                this.lastVsyncTime = Math.max(j19, normalFrameInterval) + currentVsync;
            }
            this.frameCount++;
            if (j19 > normalFrameInterval) {
                if (this.maxFrameTime < j19) {
                    this.maxFrameTime = j19;
                    this.maxFrameCombination = getFrameCombination(frameMetrics);
                }
                long[] jArr = this.dropTimes;
                int rangeIndex = getRangeIndex((int) ((j19 - normalFrameInterval) / normalFrameInterval));
                jArr[rangeIndex] = jArr[rangeIndex] + 1;
            } else {
                long[] jArr2 = this.dropTimes;
                jArr2[0] = jArr2[0] + 1;
            }
            this.lastVsyncStartTime = currentVsync;
            return;
        }
        calculateFps();
    }

    public final void setAddTime(long j3) {
        this.addTime = j3;
    }
}

package com.tencent.state.perf;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.map.MapData;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.api.ISquareFPSMonitorObserver;
import com.tencent.state.square.api.ISquareMonitorService;
import com.tencent.state.square.components.ISquareServiceProvider;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J,\u0010$\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\nH\u0016J \u0010*\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/state/perf/PerfMonitor;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/square/api/ISquareFPSMonitorObserver;", "scene", "", "serviceProvider", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/components/ISquareServiceProvider;", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "currentFps", "", "fragmentDestroyed", "", "monitorTask", "Ljava/lang/Runnable;", "performanceReportCount", "", "sceneInitTime", "", "startUpMemory", "", "vm", "Lcom/tencent/state/square/SquareMapViewModel;", "exposureStep", "", "key", "getMonitorService", "Lcom/tencent/state/square/api/ISquareMonitorService;", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onFragmentViewCreated", "v", "Landroid/view/View;", "onInfo", "fpsTime", "fps", "reportMonitor", "isFirstReport", "duration", "startPerformanceReport", "delayTime", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class PerfMonitor extends VasBaseFragmentComponent implements ISquareFPSMonitorObserver {
    public static final int PERFORMANCE_REPORT_COUNT = 2;
    public static final String TAG = "PerfMonitor";
    private double currentFps;
    private boolean fragmentDestroyed;
    private Runnable monitorTask;
    private int performanceReportCount;
    private final String scene;
    private long sceneInitTime;
    private final WeakReference<ISquareServiceProvider> serviceProvider;
    private float startUpMemory;
    private SquareMapViewModel vm;

    public PerfMonitor(String scene, WeakReference<ISquareServiceProvider> serviceProvider) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        this.scene = scene;
        this.serviceProvider = serviceProvider;
        this.sceneInitTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISquareMonitorService getMonitorService() {
        ISquareServiceProvider iSquareServiceProvider = this.serviceProvider.get();
        if (iSquareServiceProvider != null) {
            return iSquareServiceProvider.getMonitorService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportMonitor(String scene, boolean isFirstReport, long duration) {
        Map<String, Object> mutableMapOf;
        WindowManager windowManager;
        ISquareMonitorService monitorService = getMonitorService();
        float phoneLeftMemory = monitorService != null ? monitorService.getPhoneLeftMemory() : 0.0f;
        ISquareMonitorService monitorService2 = getMonitorService();
        float pssMemory = monitorService2 != null ? monitorService2.getPssMemory() : 0.0f;
        ISquareMonitorService monitorService3 = getMonitorService();
        float cpuUsage = monitorService3 != null ? monitorService3.getCpuUsage() : 0.0f;
        double d16 = this.currentFps;
        int playCountIncludeMe = Square.INSTANCE.getConfig().getCommonUtils().getPlayCountIncludeMe();
        float f16 = pssMemory - this.startUpMemory;
        QBaseActivity activity = getActivity();
        Display defaultDisplay = (activity == null || (windowManager = activity.getWindowManager()) == null) ? null : windowManager.getDefaultDisplay();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_FPS, Double.valueOf(d16)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_SCENE, scene), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_PLAY_COUNT, Integer.valueOf(playCountIncludeMe)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_CPU_USAGE, Float.valueOf(cpuUsage)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_LEFT_MEMORY, Float.valueOf(phoneLeftMemory)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_APP_MEMORY, Float.valueOf(pssMemory)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_MEMORY_DELTA, Float.valueOf(f16)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_REFRESH_RATE, Float.valueOf(defaultDisplay != null ? defaultDisplay.getRefreshRate() : 0.0f)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_FIRST_REPORT, Boolean.valueOf(isFirstReport)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_DURATION_AFTER_SCENE_INIT, Long.valueOf(duration)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_FILAMENT_INDEX, Boolean.valueOf(SquareSwitchUtils.INSTANCE.enableFilamentIndex())));
        SquareBaseKt.getSquareReporter().reportEvent(PerformanceReportConst.CustomEventId.EVENT_ID_PERFORMANCE_REPORT, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPerformanceReport(final String scene, long delayTime) {
        int i3;
        if (this.fragmentDestroyed || (i3 = this.performanceReportCount) >= 2) {
            return;
        }
        this.performanceReportCount = i3 + 1;
        this.monitorTask = SquareBaseKt.getSquareThread().postOnSubThreadDelay(new Function0<Unit>() { // from class: com.tencent.state.perf.PerfMonitor$startPerformanceReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i16;
                long j3;
                long currentTimeMillis = System.currentTimeMillis();
                PerfMonitor perfMonitor = PerfMonitor.this;
                String str = scene;
                i16 = perfMonitor.performanceReportCount;
                boolean z16 = i16 <= 1;
                j3 = PerfMonitor.this.sceneInitTime;
                perfMonitor.reportMonitor(str, z16, currentTimeMillis - j3);
                PerfMonitor.this.startPerformanceReport(scene, RandomKt.Random(currentTimeMillis).nextLong(2000L, 5000L));
            }
        }, delayTime);
    }

    public final void exposureStep(final String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.perf.PerfMonitor$exposureStep$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareMapViewModel squareMapViewModel;
                long j3;
                Map<String, Object> mutableMapOf;
                LiveData<MapData> data;
                MapData value;
                squareMapViewModel = PerfMonitor.this.vm;
                int i3 = (squareMapViewModel == null || (data = squareMapViewModel.getData()) == null || (value = data.getValue()) == null || !value.getFromCache()) ? 0 : 1;
                long currentTimeMillis = System.currentTimeMillis();
                j3 = PerfMonitor.this.sceneInitTime;
                long j16 = currentTimeMillis - j3;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(key, Long.valueOf(j16)), TuplesKt.to(PerformanceReportConst.Key.KEY_PERFORMANCE_FIRST_EXPOSURE_USE_CACHE, Integer.valueOf(i3)));
                SquareBaseKt.getSquareLog().i(PerfMonitor.TAG, "exposureStep: " + j16 + " ," + i3 + ", " + key);
                SquareBaseKt.getSquareReporter().reportEvent(PerformanceReportConst.CustomEventId.EVENT_ID_PERFORMANCE_REPORT, mutableMapOf);
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        LiveData<MapData> data;
        Intrinsics.checkNotNullParameter(f16, "f");
        ISquareMonitorService monitorService = getMonitorService();
        if (monitorService != null) {
            monitorService.addFPSMonitorObserver(this);
        }
        SquareMapViewModel squareMapViewModel = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(f16, SquareMapViewModel.class);
        this.vm = squareMapViewModel;
        if (squareMapViewModel == null || (data = squareMapViewModel.getData()) == null) {
            return;
        }
        data.observe(f16, new Observer<MapData>() { // from class: com.tencent.state.perf.PerfMonitor$onFragmentCreated$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(MapData mapData) {
                PerfMonitor.this.exposureStep(PerformanceReportConst.Key.KEY_PERFORMANCE_FIRST_EXPOSURE_DATA_LOAD);
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.fragmentDestroyed = true;
        Runnable runnable = this.monitorTask;
        if (runnable != null) {
            SquareBaseKt.getSquareThread().removeTask(runnable);
        }
        ISquareMonitorService monitorService = getMonitorService();
        if (monitorService != null) {
            monitorService.removeFPSMonitorObserver(this);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.perf.PerfMonitor$onFragmentViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquareMonitorService monitorService;
                PerfMonitor perfMonitor = PerfMonitor.this;
                monitorService = perfMonitor.getMonitorService();
                perfMonitor.startUpMemory = monitorService != null ? monitorService.getPssMemory() : 0.0f;
            }
        });
        startPerformanceReport(this.scene, 2000L);
    }

    @Override // com.tencent.state.square.api.ISquareFPSMonitorObserver
    public void onInfo(long fpsTime, double fps) {
        this.currentFps = new BigDecimal(fps).setScale(2, 4).doubleValue();
    }
}

package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.app.ActivityManager;
import android.app.Application;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0004,-./B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0014J\b\u0010&\u001a\u00020\u0018H\u0002J\u0017\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u0014H\u0000\u00a2\u0006\u0002\b)J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020(H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor;", "", "listener", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$IMonitorListener;", "(Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$IMonitorListener;)V", "cpuUsage", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "fileDescriptorCount", "", "ignoredThreadCountPhoneModels", "", "", "intervalOptions", "", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceMonitorIntervalOption;", "memoryUsage", "minInterval", "monitorJob", "Lkotlinx/coroutines/Job;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "mutex$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "threadCount", "getMemoryUsage", "isAppForeground", "", "startMonitor", "option", "startMonitorInner", "stopMonitor", "", "stopMonitor$qq_video_kit_release", "stopMonitorInner", "updateMinIntervals", "Companion", "IMonitorListener", "RFWDeviceMonitorIntervalOption", "RFWDeviceStatus", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWDeviceStatusMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> DEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS;
    private volatile float cpuUsage;

    /* renamed from: dispatcher$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dispatcher;
    private volatile int fileDescriptorCount;

    @NotNull
    private final List<String> ignoredThreadCountPhoneModels;

    @NotNull
    private final List<RFWDeviceMonitorIntervalOption> intervalOptions;

    @NotNull
    private final IMonitorListener listener;
    private volatile float memoryUsage;

    @NotNull
    private volatile RFWDeviceMonitorIntervalOption minInterval;

    @Nullable
    private Job monitorJob;

    /* renamed from: mutex$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mutex;

    @NotNull
    private final CoroutineScope scope;
    private volatile int threadCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$Companion;", "", "()V", "DEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS", "", "", "getDEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS", "()Ljava/util/List;", "TAG", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> getDEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS() {
            return RFWDeviceStatusMonitor.DEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$IMonitorListener;", "", "statusChanged", "", "status", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceStatus;", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface IMonitorListener {
        void statusChanged(@NotNull RFWDeviceStatus status);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceMonitorIntervalOption;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "cpuMonitorIntervalMs", "J", "getCpuMonitorIntervalMs", "()J", "memoryMonitorIntervalMs", "getMemoryMonitorIntervalMs", "fileDescriptorMonitorIntervalMs", "getFileDescriptorMonitorIntervalMs", "<init>", "(JJJ)V", "Companion", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final /* data */ class RFWDeviceMonitorIntervalOption {

        @NotNull
        private static final RFWDeviceMonitorIntervalOption DISABLE_ALL = new RFWDeviceMonitorIntervalOption(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
        private final long cpuMonitorIntervalMs;
        private final long fileDescriptorMonitorIntervalMs;
        private final long memoryMonitorIntervalMs;

        public RFWDeviceMonitorIntervalOption() {
            this(0L, 0L, 0L, 7, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RFWDeviceMonitorIntervalOption)) {
                return false;
            }
            RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption = (RFWDeviceMonitorIntervalOption) other;
            if (this.cpuMonitorIntervalMs == rFWDeviceMonitorIntervalOption.cpuMonitorIntervalMs && this.memoryMonitorIntervalMs == rFWDeviceMonitorIntervalOption.memoryMonitorIntervalMs && this.fileDescriptorMonitorIntervalMs == rFWDeviceMonitorIntervalOption.fileDescriptorMonitorIntervalMs) {
                return true;
            }
            return false;
        }

        public final long getCpuMonitorIntervalMs() {
            return this.cpuMonitorIntervalMs;
        }

        public final long getFileDescriptorMonitorIntervalMs() {
            return this.fileDescriptorMonitorIntervalMs;
        }

        public final long getMemoryMonitorIntervalMs() {
            return this.memoryMonitorIntervalMs;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(this.cpuMonitorIntervalMs) * 31) + androidx.fragment.app.a.a(this.memoryMonitorIntervalMs)) * 31) + androidx.fragment.app.a.a(this.fileDescriptorMonitorIntervalMs);
        }

        @NotNull
        public String toString() {
            return "RFWDeviceMonitorIntervalOption(cpuMonitorIntervalMs=" + this.cpuMonitorIntervalMs + ", memoryMonitorIntervalMs=" + this.memoryMonitorIntervalMs + ", fileDescriptorMonitorIntervalMs=" + this.fileDescriptorMonitorIntervalMs + ")";
        }

        public RFWDeviceMonitorIntervalOption(long j3, long j16, long j17) {
            this.cpuMonitorIntervalMs = j3;
            this.memoryMonitorIntervalMs = j16;
            this.fileDescriptorMonitorIntervalMs = j17;
        }

        public /* synthetic */ RFWDeviceMonitorIntervalOption(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? Long.MAX_VALUE : j3, (i3 & 2) != 0 ? Long.MAX_VALUE : j16, (i3 & 4) != 0 ? Long.MAX_VALUE : j17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWDeviceStatusMonitor$RFWDeviceStatus;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "cpuUsage", UserInfo.SEX_FEMALE, "getCpuUsage", "()F", "memoryUsage", "getMemoryUsage", "threadCount", "I", "getThreadCount", "()I", "fileDescriptorCount", "getFileDescriptorCount", "<init>", "(FFII)V", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final /* data */ class RFWDeviceStatus {
        private final float cpuUsage;
        private final int fileDescriptorCount;
        private final float memoryUsage;
        private final int threadCount;

        public RFWDeviceStatus(float f16, float f17, int i3, int i16) {
            this.cpuUsage = f16;
            this.memoryUsage = f17;
            this.threadCount = i3;
            this.fileDescriptorCount = i16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RFWDeviceStatus)) {
                return false;
            }
            RFWDeviceStatus rFWDeviceStatus = (RFWDeviceStatus) other;
            if (Float.compare(this.cpuUsage, rFWDeviceStatus.cpuUsage) == 0 && Float.compare(this.memoryUsage, rFWDeviceStatus.memoryUsage) == 0 && this.threadCount == rFWDeviceStatus.threadCount && this.fileDescriptorCount == rFWDeviceStatus.fileDescriptorCount) {
                return true;
            }
            return false;
        }

        public final float getCpuUsage() {
            return this.cpuUsage;
        }

        public final int getFileDescriptorCount() {
            return this.fileDescriptorCount;
        }

        public final float getMemoryUsage() {
            return this.memoryUsage;
        }

        public final int getThreadCount() {
            return this.threadCount;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.cpuUsage) * 31) + Float.floatToIntBits(this.memoryUsage)) * 31) + this.threadCount) * 31) + this.fileDescriptorCount;
        }

        @NotNull
        public String toString() {
            return "RFWDeviceStatus(cpuUsage=" + this.cpuUsage + ", memoryUsage=" + this.memoryUsage + ", threadCount=" + this.threadCount + ", fileDescriptorCount=" + this.fileDescriptorCount + ")";
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("VNE-AN00");
        DEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS = listOf;
    }

    public RFWDeviceStatusMonitor(@NotNull IMonitorListener listener) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CoroutineDispatcher>() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$dispatcher$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new Executor() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$dispatcher$2.1
                    @Override // java.util.concurrent.Executor
                    public void execute(@Nullable Runnable command) {
                        ThreadManagerV2.excute(command, 16, null, false);
                    }
                });
            }
        });
        this.dispatcher = lazy;
        this.cpuUsage = 1.0f;
        this.memoryUsage = 1.0f;
        this.threadCount = Integer.MAX_VALUE;
        this.fileDescriptorCount = Integer.MAX_VALUE;
        this.ignoredThreadCountPhoneModels = DEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(getDispatcher()).plus(new RFWDeviceStatusMonitor$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE)));
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Mutex>() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$mutex$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Mutex invoke() {
                return MutexKt.Mutex$default(false, 1, null);
            }
        });
        this.mutex = lazy2;
        this.intervalOptions = new ArrayList();
        this.minInterval = new RFWDeviceMonitorIntervalOption(0L, 0L, 0L, 7, null);
    }

    private final CoroutineDispatcher getDispatcher() {
        return (CoroutineDispatcher) this.dispatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMemoryUsage() {
        Application application = RFWApplication.getApplication();
        if (application == null) {
            return 0.0f;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        long j3 = memoryInfo.totalMem;
        return ((float) (j3 - memoryInfo.availMem)) / ((float) j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Mutex getMutex() {
        return (Mutex) this.mutex.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAppForeground() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return false;
        }
        return guardManager.isApplicationForeground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job startMonitorInner() {
        Job launch$default;
        RFWLog.d("RFWDeviceStatusMonitor", 1, "starting monitor inner " + this.minInterval);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RFWDeviceStatusMonitor$startMonitorInner$1(this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job stopMonitorInner() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RFWDeviceStatusMonitor$stopMonitorInner$1(this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMinIntervals() {
        this.minInterval = RFWDeviceStatusMonitorKt.getMinInterval(this.intervalOptions);
    }

    @NotNull
    public final Job startMonitor(@NotNull RFWDeviceMonitorIntervalOption option) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(option, "option");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RFWDeviceStatusMonitor$startMonitor$1(option, this, null), 3, null);
        return launch$default;
    }

    public final void stopMonitor$qq_video_kit_release(@Nullable RFWDeviceMonitorIntervalOption option) {
        RFWLog.d("RFWDeviceStatusMonitor", 1, "stopping monitor: " + option);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RFWDeviceStatusMonitor$stopMonitor$1(this, option, null), 3, null);
    }
}

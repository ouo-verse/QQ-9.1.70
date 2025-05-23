package kotlinx.atomicfu;

import androidx.lifecycle.c;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002@AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\"\u001a\u00020\u00052\n\u0010#\u001a\u00060\u001bR\u00020\u0000H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0012\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\u0014\u0010\u0010\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u001e\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00052\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0014\u00100\u001a\u00020\u00132\n\u0010#\u001a\u00060\u001bR\u00020\u0000H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0003H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0002J\r\u00106\u001a\u00020\u0013H\u0000\u00a2\u0006\u0002\b7JK\u00108\u001a\u00060\u001bR\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032+\u00109\u001a'\b\u0001\u0012\b\u0012\u00060\u001bR\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130;\u0012\u0006\u0012\u0004\u0018\u00010\u00010:\u00a2\u0006\u0002\b<\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001bR\u00020\u00000\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001bR\u00020\u00000\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"Lkotlinx/atomicfu/LockFreedomTestEnvironment;", "", "name", "", "allowSuspendedThreads", "", "(Ljava/lang/String;I)V", "completed", "", "globalPauseProgress", "Ljava/util/concurrent/atomic/AtomicInteger;", "interceptor", "Lkotlinx/atomicfu/LockFreedomTestEnvironment$Interceptor;", "isActive", "isCompleted", "()Z", "onCompletion", "", "Lkotlin/Function0;", "", "performedOps", "Ljava/util/concurrent/atomic/LongAdder;", "performedResumes", "started", "status", "suspendedThreads", "Ljava/util/ArrayList;", "Lkotlinx/atomicfu/LockFreedomTestEnvironment$TestThread;", "threads", "ueh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "uncaughtException", "Ljava/util/concurrent/atomic/AtomicReference;", "", "addSuspended", MosaicConstants$JsProperty.PROP_THREAD, "checkStalled", "complete", "composeThreadName", "threadName", "dumpThreadsError", "", "message", "getPausedEpoch", "block", "performTest", "seconds", "progress", "removeSuspended", "resumeImpl", "resumeStr", "shutdown", "shutdownDeadline", "", "step", "step$atomicfu", "testThread", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lkotlinx/atomicfu/LockFreedomTestEnvironment$TestThread;", "waitUntil", "nextTime", "Interceptor", "TestThread", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public class LockFreedomTestEnvironment {
    private final int allowSuspendedThreads;
    private volatile boolean completed;
    private final AtomicInteger globalPauseProgress;
    private final LockFreedomTestEnvironment interceptor;
    private volatile boolean isActive;
    private final String name;
    private final List<Function0<Unit>> onCompletion;
    private final LongAdder performedOps;
    private int performedResumes;
    private boolean started;
    private final AtomicInteger status;
    private final ArrayList<TestThread> suspendedThreads;
    private final List<TestThread> threads;
    private final Thread.UncaughtExceptionHandler ueh;
    private final AtomicReference<Throwable> uncaughtException;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J1\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u0007\u001a\u0002H\f2\u0006\u0010\t\u001a\u0002H\fH\u0016\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0016J)\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\t\u001a\u0002H\fH\u0016\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/atomicfu/LockFreedomTestEnvironment$Interceptor;", "Lkotlinx/atomicfu/AtomicOperationInterceptor;", "(Lkotlinx/atomicfu/LockFreedomTestEnvironment;)V", "afterRMW", "", "ref", "Lkotlinx/atomicfu/AtomicInt;", "oldValue", "", "newValue", "Lkotlinx/atomicfu/AtomicLong;", "", "T", "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Ljava/lang/Object;Ljava/lang/Object;)V", "afterSet", "(Lkotlinx/atomicfu/AtomicRef;Ljava/lang/Object;)V", "beforeUpdate", "toString", "", "atomicfu"}, k = 1, mv = {1, 4, 3})
    /* renamed from: kotlinx.atomicfu.LockFreedomTestEnvironment$Interceptor, reason: from toString */
    /* loaded from: classes28.dex */
    public final class LockFreedomTestEnvironment extends AtomicOperationInterceptor {
        public LockFreedomTestEnvironment() {
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public <T> void afterRMW(@NotNull AtomicRef<T> ref, T oldValue, T newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public <T> void afterSet(@NotNull AtomicRef<T> ref, T newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public <T> void beforeUpdate(@NotNull AtomicRef<T> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @NotNull
        public String toString() {
            return "LockFreedomTestEnvironment(" + LockFreedomTestEnvironment.this.name + ')';
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterRMW(@NotNull AtomicInt ref, int oldValue, int newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterSet(@NotNull AtomicInt ref, int newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void beforeUpdate(@NotNull AtomicInt ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterRMW(@NotNull AtomicLong ref, long oldValue, long newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterSet(@NotNull AtomicLong ref, long newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void beforeUpdate(@NotNull AtomicLong ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001BA\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012+\u0010\u0004\u001a'\b\u0001\u0012\b\u0012\u00060\u0000R\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005\u00a2\u0006\u0002\b\n\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010(\u001a\u00020\bJ\b\u0010)\u001a\u00020\bH\u0001J\b\u0010*\u001a\u00020\bH\u0001J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\bH\u0002J%\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/01H\u0086\b\u00f8\u0001\u0003\u00a2\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\b5J\r\u00106\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b7J\u0006\u00108\u001a\u00020\bJ2\u00109\u001a\u00020\b2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0$2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\bH\u0016J\r\u0010<\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b=J\u0012\u0010>\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H\u0002J \u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0$H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\b@\u0010AJ\b\u0010B\u001a\u00020\bH\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R8\u0010\u0004\u001a'\b\u0001\u0012\b\u0012\u00060\u0000R\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005\u00a2\u0006\u0002\b\nX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010$X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001\u00a8\u0006C"}, d2 = {"Lkotlinx/atomicfu/LockFreedomTestEnvironment$TestThread;", "Ljava/lang/Thread;", "name", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lkotlin/Function2;", "Lkotlinx/atomicfu/LockFreedomTestEnvironment;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/atomicfu/LockFreedomTestEnvironment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "completion", "continuation", "index", "", "getIndex$atomicfu", "()I", "interceptor", "Lkotlin/coroutines/CoroutineContext;", "lastOpTime", "", "getLastOpTime$atomicfu", "()J", "setLastOpTime$atomicfu", "(J)V", "Lkotlin/jvm/functions/Function2;", "operationEpoch", "pausedEpoch", "getPausedEpoch$atomicfu", "setPausedEpoch$atomicfu", "(I)V", "progressEpoch", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Ljava/util/Random;", "result", "Lkotlin/Result;", "runningOperation", "", "sink", "abortWait", "afterLockFreeOperation", "beforeLockFreeOperation", "beginRunningOperation", "callOperation", "doneRunningOperation", "intermission", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "makeProgress", "epoch", "makeProgress$atomicfu", "pauseImpl", "pauseImpl$atomicfu", "randomSpinWaitIntermission", "resumeWith", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", TencentLocation.RUN_MODE, "stepImpl", "stepImpl$atomicfu", "takeContinuation", "waitForResult", "waitForResult-d1pmJ48", "()Ljava/lang/Object;", "waitUntilCompletion", "atomicfu"}, k = 1, mv = {1, 4, 3})
    /* loaded from: classes28.dex */
    public final class TestThread extends BaseThread {
        private final Continuation<Unit> completion;
        private Continuation<Object> continuation;
        private final int index;
        private final CoroutineContext interceptor;
        private volatile long lastOpTime;
        private final Function2<TestThread, Continuation<? super Unit>, Object> operation;
        private int operationEpoch;
        private volatile int pausedEpoch;
        private int progressEpoch;
        private final Random random;
        private Result<? extends Object> result;
        private boolean runningOperation;
        private int sink;
        final /* synthetic */ LockFreedomTestEnvironment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TestThread(@Nullable LockFreedomTestEnvironment lockFreedomTestEnvironment, @NotNull String str, Function2<? super TestThread, ? super Continuation<? super Unit>, ? extends Object> operation) {
            super(lockFreedomTestEnvironment.composeThreadName(str));
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.this$0 = lockFreedomTestEnvironment;
            this.operation = operation;
            this.pausedEpoch = -1;
            this.random = new Random();
            this.operationEpoch = -1;
            this.progressEpoch = -1;
            if (!lockFreedomTestEnvironment.started) {
                this.index = lockFreedomTestEnvironment.threads.size();
                lockFreedomTestEnvironment.threads.add(this);
                final LockFreedomTestEnvironment$TestThread$interceptor$1 lockFreedomTestEnvironment$TestThread$interceptor$1 = new LockFreedomTestEnvironment$TestThread$interceptor$1(this, ContinuationInterceptor.INSTANCE);
                this.interceptor = lockFreedomTestEnvironment$TestThread$interceptor$1;
                this.completion = new Continuation<Unit>() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment$TestThread$$special$$inlined$Continuation$1
                    @Override // kotlin.coroutines.Continuation
                    @NotNull
                    /* renamed from: getContext, reason: from getter */
                    public CoroutineContext get$context() {
                        return CoroutineContext.this;
                    }

                    @Override // kotlin.coroutines.Continuation
                    public void resumeWith(@NotNull Object result) {
                        this.resumeWith(result, null);
                    }
                };
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        private final void beginRunningOperation() {
            this.runningOperation = true;
            this.result = null;
            this.continuation = null;
        }

        private final void callOperation() {
            Object coroutine_suspended;
            beforeLockFreeOperation();
            beginRunningOperation();
            Function2<TestThread, Continuation<? super Unit>, Object> function2 = this.operation;
            Continuation<Unit> continuation = this.completion;
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this, continuation);
                if (invoke != Unit.INSTANCE) {
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (invoke == coroutine_suspended) {
                        waitUntilCompletion();
                    } else {
                        throw new IllegalStateException(("Unexpected result of operation: " + invoke).toString());
                    }
                } else {
                    afterLockFreeOperation();
                }
                try {
                    doneRunningOperation();
                    return;
                } catch (IllegalStateException e16) {
                    throw new IllegalStateException(e16.getMessage() + "; original start result=" + invoke, e16);
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }

        private final synchronized void doneRunningOperation() {
            boolean z16;
            if (this.runningOperation) {
                if (this.result == null && this.continuation == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.runningOperation = false;
                } else {
                    throw new IllegalStateException(("Callback invoked with result=" + this.result + ", continuation=" + this.continuation).toString());
                }
            } else {
                throw new IllegalStateException("Should be running operation".toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void resumeWith(Object result, Continuation<Object> continuation) {
            boolean z16;
            if (this.runningOperation) {
                if (this.result == null && this.continuation == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.result = Result.m475boximpl(result);
                    this.continuation = continuation;
                    notifyAll();
                } else {
                    throw new IllegalStateException(("Resumed again with result=" + Result.m484toStringimpl(result) + ", continuation=" + continuation + ", when this: result=" + this.result + ", continuation=" + this.continuation).toString());
                }
            } else {
                throw new IllegalStateException("Should be running operation".toString());
            }
        }

        private final synchronized Continuation<Object> takeContinuation() {
            Continuation<Object> continuation;
            continuation = this.continuation;
            this.result = null;
            this.continuation = null;
            return continuation;
        }

        /* renamed from: waitForResult-d1pmJ48, reason: not valid java name */
        private final synchronized Object m1982waitForResultd1pmJ48() {
            Result<? extends Object> result;
            while (true) {
                result = this.result;
                if (result != null) {
                } else {
                    if (this.this$0.addSuspended(this) < this.this$0.allowSuspendedThreads) {
                        makeProgress$atomicfu(this.this$0.getPausedEpoch());
                    }
                    wait(10L);
                }
            }
            return result.getValue();
        }

        private final void waitUntilCompletion() {
            Object m1982waitForResultd1pmJ48;
            boolean z16;
            while (true) {
                try {
                    afterLockFreeOperation();
                    m1982waitForResultd1pmJ48 = m1982waitForResultd1pmJ48();
                    Continuation<Object> takeContinuation = takeContinuation();
                    if (takeContinuation == null) {
                        break;
                    }
                    this.this$0.removeSuspended(this);
                    beforeLockFreeOperation();
                    takeContinuation.resumeWith(m1982waitForResultd1pmJ48);
                } finally {
                    this.this$0.removeSuspended(this);
                }
            }
            ResultKt.throwOnFailure(m1982waitForResultd1pmJ48);
            if (m1982waitForResultd1pmJ48 == Unit.INSTANCE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final synchronized void abortWait() {
            Result.Companion companion = Result.INSTANCE;
            this.result = Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("Aborted at the end of test"))));
            notifyAll();
        }

        @PublishedApi
        public final void afterLockFreeOperation() {
            makeProgress$atomicfu(this.operationEpoch);
            this.lastOpTime = System.currentTimeMillis();
            this.this$0.performedOps.add(1L);
        }

        @PublishedApi
        public final void beforeLockFreeOperation() {
            this.operationEpoch = this.this$0.getPausedEpoch();
        }

        /* renamed from: getIndex$atomicfu, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: getLastOpTime$atomicfu, reason: from getter */
        public final long getLastOpTime() {
            return this.lastOpTime;
        }

        /* renamed from: getPausedEpoch$atomicfu, reason: from getter */
        public final int getPausedEpoch() {
            return this.pausedEpoch;
        }

        public final <T> T intermission(@NotNull Function0<? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            afterLockFreeOperation();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                beforeLockFreeOperation();
                InlineMarker.finallyEnd(1);
            }
        }

        public final void makeProgress$atomicfu(int epoch) {
            boolean z16;
            if (epoch <= this.progressEpoch) {
                return;
            }
            this.progressEpoch = epoch;
            int incrementAndGet = this.this$0.globalPauseProgress.incrementAndGet();
            if (incrementAndGet >= this.this$0.threads.size() - 1) {
                if (incrementAndGet == this.this$0.threads.size() - 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.this$0.globalPauseProgress.compareAndSet(this.this$0.threads.size() - 1, 0)) {
                        this.this$0.resumeImpl();
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final void pauseImpl$atomicfu() {
            int i3;
            int i16;
            do {
                i3 = this.this$0.status.get();
                if (i3 >= 0 && i3 != Integer.MAX_VALUE) {
                    this.pausedEpoch = i3 + 1;
                    i16 = ~this.index;
                } else {
                    return;
                }
            } while (!this.this$0.status.compareAndSet(i3, i16));
            while (this.this$0.status.get() == i16) {
                LockSupport.parkNanos(1000000L);
            }
        }

        public final void randomSpinWaitIntermission() {
            int nextInt;
            afterLockFreeOperation();
            try {
                if (this.random.nextInt(100) < 95) {
                    return;
                }
                do {
                    nextInt = this.random.nextInt(100);
                    for (int i3 = 0; i3 < nextInt; i3++) {
                        this.sink += i3;
                    }
                } while (nextInt >= 90);
                Unit unit = Unit.INSTANCE;
            } finally {
                beforeLockFreeOperation();
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.this$0.isActive) {
                callOperation();
            }
        }

        public final void setLastOpTime$atomicfu(long j3) {
            this.lastOpTime = j3;
        }

        public final void setPausedEpoch$atomicfu(int i3) {
            this.pausedEpoch = i3;
        }

        public final void stepImpl$atomicfu() {
            if (this.random.nextInt(1000) == 0) {
                pauseImpl$atomicfu();
            }
        }
    }

    public LockFreedomTestEnvironment(@NotNull String name, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.allowSuspendedThreads = i3;
        this.interceptor = new LockFreedomTestEnvironment();
        this.threads = new ArrayList();
        this.performedOps = new LongAdder();
        this.uncaughtException = new AtomicReference<>();
        this.onCompletion = new ArrayList();
        this.ueh = new Thread.UncaughtExceptionHandler() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment$ueh$1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th5) {
                AtomicReference atomicReference;
                PrintStream printStream = System.out;
                Intrinsics.checkNotNullExpressionValue(printStream, "System.out");
                synchronized (printStream) {
                    System.out.println((Object) ("Uncaught exception in thread " + thread));
                    th5.printStackTrace(System.out);
                    atomicReference = LockFreedomTestEnvironment.this.uncaughtException;
                    c.a(atomicReference, null, th5);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.status = new AtomicInteger();
        this.globalPauseProgress = new AtomicInteger();
        this.suspendedThreads = new ArrayList<>();
        this.isActive = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized int addSuspended(TestThread thread) {
        int indexOf = this.suspendedThreads.indexOf(thread);
        if (indexOf >= 0) {
            return indexOf;
        }
        this.suspendedThreads.add(thread);
        return this.suspendedThreads.size() - 1;
    }

    private final void checkStalled() {
        int collectionSizeOrDefault;
        long currentTimeMillis = System.currentTimeMillis() - 15000;
        List<TestThread> list = this.threads;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((TestThread) next).getLastOpTime() >= currentTimeMillis) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Progress stalled in threads ");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(((TestThread) it5.next()).getName());
            }
            sb5.append(arrayList2);
            dumpThreadsError(sb5.toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void complete() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long currentTimeMillis = System.currentTimeMillis() + 15000;
        try {
            this.completed = true;
            Iterator<T> it = this.onCompletion.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            this.isActive = false;
            while (System.currentTimeMillis() < currentTimeMillis) {
                linkedHashMap.clear();
                for (TestThread testThread : this.threads) {
                    if (!testThread.isAlive()) {
                        testThread.makeProgress$atomicfu(getPausedEpoch());
                    } else if ((~testThread.getIndex()) != this.status.get()) {
                        StackTraceElement[] stackTrace = testThread.getStackTrace();
                        if (testThread.isAlive()) {
                            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                            linkedHashMap.put(testThread, stackTrace);
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    break;
                }
                checkStalled();
                LockMethodProxy.sleep(10L);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                TestThread testThread2 = (TestThread) entry.getKey();
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                System.out.println((Object) ("=== " + testThread2 + " had failed to shutdown in time"));
                int length = stackTraceElementArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    System.out.println((Object) ("\tat " + stackTraceElementArr[i3]));
                }
            }
            shutdown(currentTimeMillis);
            if (!linkedHashMap.isEmpty()) {
                throw new IllegalStateException("Some threads had failed to shutdown in time".toString());
            }
        } catch (Throwable th5) {
            shutdown(currentTimeMillis);
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String composeThreadName(String threadName) {
        if (threadName != null) {
            return this.name + '-' + threadName;
        }
        return this.name + '-' + (this.threads.size() + 1);
    }

    private final Void dumpThreadsError(String message) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        boolean z16;
        List<TestThread> list = this.threads;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (TestThread testThread : list) {
            Pair pair = TuplesKt.to(testThread, testThread.getStackTrace());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        System.out.println((Object) ("!!! " + message));
        System.out.println((Object) "=== Dumping live thread stack traces");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            TestThread testThread2 = (TestThread) entry.getKey();
            StackTraceElement[] trace = (StackTraceElement[]) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(trace, "trace");
            if (trace.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                System.out.println((Object) ("Thread \"" + testThread2.getName() + "\" " + testThread2.getState()));
                for (StackTraceElement t16 : trace) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\tat ");
                    Intrinsics.checkNotNullExpressionValue(t16, "t");
                    sb5.append(t16.getClassName());
                    sb5.append('.');
                    sb5.append(t16.getMethodName());
                    sb5.append('(');
                    sb5.append(t16.getFileName());
                    sb5.append(':');
                    sb5.append(t16.getLineNumber());
                    sb5.append(')');
                    System.out.println((Object) sb5.toString());
                }
                System.out.println();
            }
        }
        System.out.println((Object) "===");
        throw new IllegalStateException(message.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPausedEpoch() {
        int i3;
        int pausedEpoch;
        do {
            i3 = this.status.get();
            if (i3 >= 0) {
                return -1;
            }
            pausedEpoch = this.threads.get(~i3).getPausedEpoch();
        } while (i3 != this.status.get());
        return pausedEpoch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void performTest$default(LockFreedomTestEnvironment lockFreedomTestEnvironment, int i3, Function0 function0, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                function0 = new Function0<Unit>() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment$performTest$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                };
            }
            lockFreedomTestEnvironment.performTest(i3, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performTest");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void removeSuspended(TestThread thread) {
        this.suspendedThreads.remove(thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeImpl() {
        int i3;
        boolean z16;
        TestThread testThread;
        do {
            i3 = this.status.get();
            if (i3 == Integer.MAX_VALUE) {
                return;
            }
            if (i3 < 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                testThread = this.threads.get(~i3);
                this.performedResumes = testThread.getPausedEpoch();
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        } while (!this.status.compareAndSet(i3, testThread.getPausedEpoch()));
        LockSupport.unpark(testThread);
    }

    private final String resumeStr() {
        int i3 = this.performedResumes;
        if (i3 == 0) {
            return "";
        }
        return " (pause/resumes " + i3 + ')';
    }

    private final void shutdown(long shutdownDeadline) {
        Object obj;
        int andSet = this.status.getAndSet(Integer.MAX_VALUE);
        if (andSet < 0) {
            LockSupport.unpark(this.threads.get(~andSet));
        }
        for (TestThread testThread : this.threads) {
            long currentTimeMillis = shutdownDeadline - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                testThread.join(currentTimeMillis);
            }
        }
        Iterator<T> it = this.threads.iterator();
        while (it.hasNext()) {
            ((TestThread) it.next()).abortWait();
        }
        InterceptorKt.unlockAndResetInterceptor(this.interceptor);
        Throwable th5 = this.uncaughtException.get();
        if (th5 == null) {
            Iterator<T> it5 = this.threads.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((TestThread) obj).isAlive()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            TestThread testThread2 = (TestThread) obj;
            if (testThread2 == null) {
                return;
            }
            dumpThreadsError("A thread is still alive: " + testThread2);
            throw new KotlinNothingValueException();
        }
        throw th5;
    }

    public static /* synthetic */ TestThread testThread$default(LockFreedomTestEnvironment lockFreedomTestEnvironment, String str, Function2 function2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                str = null;
            }
            return lockFreedomTestEnvironment.testThread(str, function2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: testThread");
    }

    private final void waitUntil(long nextTime) {
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= nextTime) {
                return;
            } else {
                LockMethodProxy.sleep(nextTime - currentTimeMillis);
            }
        }
    }

    /* renamed from: isCompleted, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    public final void onCompletion(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onCompletion.add(block);
    }

    public final void performTest(int seconds, @NotNull Function0<Unit> progress) {
        boolean z16;
        long sum;
        long sum2;
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (this.isActive) {
            System.out.println((Object) ("=== " + this.name));
            int i3 = this.allowSuspendedThreads + 2;
            int i16 = 0;
            if (this.threads.size() >= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                InterceptorKt.lockAndSetInterceptor(this.interceptor);
                this.started = true;
                long currentTimeMillis = System.currentTimeMillis();
                for (TestThread testThread : this.threads) {
                    testThread.setUncaughtExceptionHandler(this.ueh);
                    testThread.setLastOpTime$atomicfu(currentTimeMillis);
                    testThread.start();
                }
                while (this.uncaughtException.get() == null) {
                    try {
                        waitUntil(currentTimeMillis);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("--- ");
                        sb5.append(i16);
                        sb5.append(": Performed ");
                        sum2 = this.performedOps.sum();
                        sb5.append(sum2);
                        sb5.append(" operations");
                        sb5.append(resumeStr());
                        System.out.println((Object) sb5.toString());
                        progress.invoke();
                        checkStalled();
                        i16++;
                        if (i16 > seconds) {
                            break;
                        } else {
                            currentTimeMillis += 1000;
                        }
                    } catch (Throwable th5) {
                        complete();
                        throw th5;
                    }
                }
                complete();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("------ Done with ");
                sum = this.performedOps.sum();
                sb6.append(sum);
                sb6.append(" operations");
                sb6.append(resumeStr());
                System.out.println((Object) sb6.toString());
                progress.invoke();
                return;
            }
            throw new IllegalStateException(("Must define at least " + i3 + " test threads").toString());
        }
        throw new IllegalStateException("Can perform test at most once on this instance".toString());
    }

    public final void step$atomicfu() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof TestThread)) {
            currentThread = null;
        }
        TestThread testThread = (TestThread) currentThread;
        if (testThread != null) {
            testThread.stepImpl$atomicfu();
        }
    }

    @NotNull
    public final TestThread testThread(@Nullable String name, @NotNull Function2<? super TestThread, ? super Continuation<? super Unit>, ? extends Object> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new TestThread(this, name, operation);
    }

    public /* synthetic */ LockFreedomTestEnvironment(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3);
    }
}

package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeClass(namespace = Consts.JNI_NAMESPACE)
@NativeProxy(allFields = false, allMethods = false, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent;", "", "nativeInstancePointer", "", "gameThreadExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "jankTraceLevelHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "getTraceInfoHolder", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "(JLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "getTraceInfo", "", "callback", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class JankCanaryAgent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Executor gameThreadExecutor;
    private final Executor mainThreadExecutor;

    @NativeFieldProxy(setter = false)
    private final long nativeInstancePointer;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0083 \u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0083 J\f\u0010\u000e\u001a\u00020\r*\u00020\u000fH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent$Companion;", "", "()V", "nativeGetBriefTraceInfo", "", "nativeInstancePointer", "", "objClass", "Ljava/lang/Class;", "(JLjava/lang/Class;)[Ljava/lang/Object;", "nativeSetJankTraceLevel", "", "jankTraceLevel", "", "toNative", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: classes19.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[JankTraceLevel.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[JankTraceLevel.NONE.ordinal()] = 1;
                iArr[JankTraceLevel.BRIEF.ordinal()] = 2;
                iArr[JankTraceLevel.DETAIL.ordinal()] = 3;
            }
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Object[] nativeGetBriefTraceInfo(long nativeInstancePointer, Class<Object> objClass) {
            return JankCanaryAgent.nativeGetBriefTraceInfo(nativeInstancePointer, objClass);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeSetJankTraceLevel(long nativeInstancePointer, int jankTraceLevel) {
            JankCanaryAgent.nativeSetJankTraceLevel(nativeInstancePointer, jankTraceLevel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int toNative(@NotNull JankTraceLevel jankTraceLevel) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[jankTraceLevel.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return 1;
                }
                if (i3 == 3) {
                    return 2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public JankCanaryAgent(long j3, @NotNull Executor gameThreadExecutor, @NotNull Executor mainThreadExecutor, @NotNull ValueHolder<JankTraceLevel> jankTraceLevelHolder, @NotNull final ValueHolder<GetTraceInfoCallback> getTraceInfoHolder) {
        Intrinsics.checkParameterIsNotNull(gameThreadExecutor, "gameThreadExecutor");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(jankTraceLevelHolder, "jankTraceLevelHolder");
        Intrinsics.checkParameterIsNotNull(getTraceInfoHolder, "getTraceInfoHolder");
        this.nativeInstancePointer = j3;
        this.gameThreadExecutor = gameThreadExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
        if (j3 != 0) {
            jankTraceLevelHolder.observe(new Function1<JankTraceLevel, Unit>() { // from class: com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JankTraceLevel jankTraceLevel) {
                    invoke2(jankTraceLevel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull JankTraceLevel it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    Companion companion = JankCanaryAgent.INSTANCE;
                    companion.nativeSetJankTraceLevel(JankCanaryAgent.this.nativeInstancePointer, companion.toNative(it));
                }
            });
            getTraceInfoHolder.observe(new Function1<GetTraceInfoCallback, Unit>() { // from class: com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetTraceInfoCallback getTraceInfoCallback) {
                    invoke2(getTraceInfoCallback);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable GetTraceInfoCallback getTraceInfoCallback) {
                    if (getTraceInfoCallback != null) {
                        getTraceInfoHolder.setValue(null);
                        JankCanaryAgent.this.getTraceInfo(getTraceInfoCallback);
                    }
                }
            });
        } else {
            throw new TritonInitException("pointer JankCanaryAgent::nativeInstancePointer is nullptr", ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getTraceInfo(final GetTraceInfoCallback callback) {
        this.gameThreadExecutor.execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent$getTraceInfo$1
            @Override // java.lang.Runnable
            public final void run() {
                Object[] nativeGetBriefTraceInfo;
                final TraceStatistics traceStatistics;
                List emptyList;
                Executor executor;
                IntRange indices;
                int collectionSizeOrDefault;
                nativeGetBriefTraceInfo = JankCanaryAgent.INSTANCE.nativeGetBriefTraceInfo(JankCanaryAgent.this.nativeInstancePointer, Object.class);
                if (nativeGetBriefTraceInfo == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    traceStatistics = new TraceStatistics(emptyList);
                } else {
                    Object obj = nativeGetBriefTraceInfo[0];
                    if (obj != null) {
                        Object[] objArr = (Object[]) obj;
                        Object obj2 = nativeGetBriefTraceInfo[1];
                        if (obj2 != null) {
                            long[] jArr = (long[]) obj2;
                            indices = ArraysKt___ArraysKt.getIndices(objArr);
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            Iterator<Integer> it = indices.iterator();
                            while (it.hasNext()) {
                                int nextInt = ((IntIterator) it).nextInt();
                                Object obj3 = objArr[nextInt];
                                if (obj3 != null) {
                                    arrayList.add(new TraceStatistics.Record((String) obj3, jArr[nextInt]));
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                                }
                            }
                            traceStatistics = new TraceStatistics(arrayList);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.LongArray");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                    }
                }
                executor = JankCanaryAgent.this.mainThreadExecutor;
                executor.execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent$getTraceInfo$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onGetTraceInfo(traceStatistics);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Object[] nativeGetBriefTraceInfo(long j3, Class<Object> cls);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeSetJankTraceLevel(long j3, int i3);
}

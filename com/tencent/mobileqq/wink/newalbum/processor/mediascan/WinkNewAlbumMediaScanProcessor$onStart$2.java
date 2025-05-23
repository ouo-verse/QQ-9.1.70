package com.tencent.mobileqq.wink.newalbum.processor.mediascan;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorDebugInstance;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {322}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkNewAlbumMediaScanProcessor$onStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $insertDbCount;
    final /* synthetic */ WinkAlbumScanReportData $reportData;
    final /* synthetic */ Ref.IntRef $transferCount;
    final /* synthetic */ Ref.IntRef $transferImageCount;
    final /* synthetic */ Ref.IntRef $transferVideoCount;
    int label;
    final /* synthetic */ WinkNewAlbumMediaScanProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "it", "Lkotlinx/coroutines/flow/Flow;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$1", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends LocalMediaInfo>, Continuation<? super Flow<? extends LocalMediaInfo>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return FlowKt.asFlow((List) this.L$0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull List<? extends LocalMediaInfo> list, @Nullable Continuation<? super Flow<? extends LocalMediaInfo>> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "contexts", "Lkotlinx/coroutines/flow/Flow;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$4", f = "WinkNewAlbumMediaScanProcessor.kt", i = {0, 0}, l = {108}, m = "invokeSuspend", n = {"contexts", "startTime"}, s = {"L$0", "J$0"})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$4, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<List<? extends WinkNewAlbumContext>, Continuation<? super Flow<? extends WinkNewAlbumContext>>, Object> {
        final /* synthetic */ Ref.IntRef $insertDbCount;
        long J$0;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WinkNewAlbumMediaScanProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, Ref.IntRef intRef, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = winkNewAlbumMediaScanProcessor;
            this.$insertDbCount = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, this.$insertDbCount, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends WinkNewAlbumContext> list, Continuation<? super Flow<? extends WinkNewAlbumContext>> continuation) {
            return invoke2((List<WinkNewAlbumContext>) list, (Continuation<? super Flow<WinkNewAlbumContext>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            List list;
            int collectionSizeOrDefault;
            long j3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    j3 = this.J$0;
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                list = (List) this.L$0;
                long currentTimeMillis = System.currentTimeMillis();
                WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor = this.this$0;
                List list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((WinkNewAlbumContext) it.next()).getMetaData());
                }
                this.L$0 = list;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = winkNewAlbumMediaScanProcessor.u(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis;
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            long currentTimeMillis2 = System.currentTimeMillis() - j3;
            this.$insertDbCount.element += list.size();
            if (QLog.isColorLevel()) {
                QLog.d(this.this$0.b(), 1, "onStart, insertSuccess:" + booleanValue + ", insertDbCount:" + this.$insertDbCount.element + ", cost:" + currentTimeMillis2);
            }
            if (booleanValue) {
                return FlowKt.asFlow(list);
            }
            return FlowKt.emptyFlow();
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull List<WinkNewAlbumContext> list, @Nullable Continuation<? super Flow<WinkNewAlbumContext>> continuation) {
            return ((AnonymousClass4) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$5", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$5, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements Function3<FlowCollector<? super WinkNewAlbumContext>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $insertDbCount;
        final /* synthetic */ WinkAlbumScanReportData $reportData;
        final /* synthetic */ Ref.IntRef $transferCount;
        final /* synthetic */ Ref.IntRef $transferImageCount;
        final /* synthetic */ Ref.IntRef $transferVideoCount;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ WinkNewAlbumMediaScanProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.IntRef intRef4, WinkAlbumScanReportData winkAlbumScanReportData, Continuation<? super AnonymousClass5> continuation) {
            super(3, continuation);
            this.this$0 = winkNewAlbumMediaScanProcessor;
            this.$transferCount = intRef;
            this.$transferImageCount = intRef2;
            this.$transferVideoCount = intRef3;
            this.$insertDbCount = intRef4;
            this.$reportData = winkAlbumScanReportData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th5 = (Throwable) this.L$1;
                QLog.e(this.this$0.b(), 1, "onStart, onCompletion, transferCount:" + this.$transferCount.element + " (image:" + this.$transferImageCount.element + ", video:" + this.$transferVideoCount.element + "), insertDbCount:" + this.$insertDbCount.element + ", timeCost:" + (System.currentTimeMillis() - this.this$0.getStartTime()), th5);
                WinkNewAlbumContext winkNewAlbumContext = new WinkNewAlbumContext(null, null, null, null, true, 0L, 0L, 0L, false, 0L, false, 0.0f, null, 8175, null);
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(winkNewAlbumContext, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.$reportData.g(this.$transferCount.element);
            this.$reportData.f(this.$transferImageCount.element);
            this.$reportData.i(this.$transferVideoCount.element);
            this.this$0.v(this.$reportData);
            WinkNewAlbumCollectorDebugInstance.f324014a.B(System.currentTimeMillis() - this.this$0.getStartTime());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super WinkNewAlbumContext> flowCollector, @Nullable Throwable th5, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.this$0, this.$transferCount, this.$transferImageCount, this.$transferVideoCount, this.$insertDbCount, this.$reportData, continuation);
            anonymousClass5.L$0 = flowCollector;
            anonymousClass5.L$1 = th5;
            return anonymousClass5.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$6", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$6, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass6 extends SuspendLambda implements Function3<FlowCollector<? super WinkNewAlbumContext>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ WinkNewAlbumMediaScanProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, Continuation<? super AnonymousClass6> continuation) {
            super(3, continuation);
            this.this$0 = winkNewAlbumMediaScanProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                QLog.e(this.this$0.b(), 1, "onStart, catch exception", (Throwable) this.L$1);
                WinkNewAlbumContext winkNewAlbumContext = new WinkNewAlbumContext(null, null, null, null, true, 0L, 0L, 0L, false, 0L, false, 0.0f, null, 8175, null);
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(winkNewAlbumContext, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super WinkNewAlbumContext> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.this$0, continuation);
            anonymousClass6.L$0 = flowCollector;
            anonymousClass6.L$1 = th5;
            return anonymousClass6.invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<WinkNewAlbumContext> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkNewAlbumMediaScanProcessor f324281d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f324282e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f324283f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f324284h;

        public a(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3) {
            this.f324281d = winkNewAlbumMediaScanProcessor;
            this.f324282e = intRef;
            this.f324283f = intRef2;
            this.f324284h = intRef3;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(WinkNewAlbumContext winkNewAlbumContext, @NotNull Continuation<? super Unit> continuation) {
            WinkNewAlbumContext winkNewAlbumContext2 = winkNewAlbumContext;
            this.f324281d.i(winkNewAlbumContext2);
            this.f324282e.element++;
            if (winkNewAlbumContext2.getMetaData().C()) {
                this.f324283f.element++;
            } else if (winkNewAlbumContext2.getMetaData().D()) {
                this.f324284h.element++;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumMediaScanProcessor$onStart$2(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, WinkAlbumScanReportData winkAlbumScanReportData, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.IntRef intRef4, Continuation<? super WinkNewAlbumMediaScanProcessor$onStart$2> continuation) {
        super(2, continuation);
        this.this$0 = winkNewAlbumMediaScanProcessor;
        this.$reportData = winkAlbumScanReportData;
        this.$insertDbCount = intRef;
        this.$transferCount = intRef2;
        this.$transferImageCount = intRef3;
        this.$transferVideoCount = intRef4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkNewAlbumMediaScanProcessor$onStart$2(this.this$0, this.$reportData, this.$insertDbCount, this.$transferCount, this.$transferImageCount, this.$transferVideoCount, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Flow w3;
        int d16;
        Flow buffer$default;
        int c16;
        Flow s16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor = this.this$0;
            w3 = winkNewAlbumMediaScanProcessor.w();
            final Flow flatMapConcat = FlowKt.flatMapConcat(w3, new AnonymousClass1(null));
            final WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor2 = this.this$0;
            final WinkAlbumScanReportData winkAlbumScanReportData = this.$reportData;
            final Flow<LocalMediaInfo> flow = new Flow<LocalMediaInfo>() { // from class: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$filter$1

                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes21.dex */
                public static final class AnonymousClass2 implements FlowCollector<LocalMediaInfo> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f324272d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ WinkNewAlbumMediaScanProcessor f324273e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ WinkAlbumScanReportData f324274f;

                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$filter$1$2", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    /* loaded from: classes21.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, WinkAlbumScanReportData winkAlbumScanReportData) {
                        this.f324272d = flowCollector;
                        this.f324273e = winkNewAlbumMediaScanProcessor;
                        this.f324274f = winkAlbumScanReportData;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(LocalMediaInfo localMediaInfo, @NotNull Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended;
                        int i3;
                        boolean t16;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i16 = anonymousClass1.label;
                            if ((i16 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                Object obj = anonymousClass1.result;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i3 = anonymousClass1.label;
                                if (i3 == 0) {
                                    if (i3 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    FlowCollector flowCollector = this.f324272d;
                                    t16 = this.f324273e.t(localMediaInfo, this.f324274f);
                                    if (t16) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(localMediaInfo, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj2 = anonymousClass1.result;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i3 = anonymousClass1.label;
                        if (i3 == 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super LocalMediaInfo> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, winkNewAlbumMediaScanProcessor2, winkAlbumScanReportData), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            final WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor3 = this.this$0;
            Flow<WinkNewAlbumContext> flow2 = new Flow<WinkNewAlbumContext>() { // from class: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$map$1

                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes21.dex */
                public static final class AnonymousClass2 implements FlowCollector<LocalMediaInfo> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f324277d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ WinkNewAlbumMediaScanProcessor f324278e;

                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$map$1$2", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$onStart$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes21.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor) {
                        this.f324277d = flowCollector;
                        this.f324278e = winkNewAlbumMediaScanProcessor;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(LocalMediaInfo localMediaInfo, @NotNull Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended;
                        int i3;
                        z83.a x16;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i16 = anonymousClass1.label;
                            if ((i16 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                Object obj = anonymousClass1.result;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i3 = anonymousClass1.label;
                                if (i3 == 0) {
                                    if (i3 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    FlowCollector flowCollector = this.f324277d;
                                    x16 = this.f324278e.x(localMediaInfo);
                                    WinkNewAlbumContext winkNewAlbumContext = new WinkNewAlbumContext(x16, null, null, null, false, 0L, 0L, 0L, false, 0L, false, 0.0f, null, 8190, null);
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(winkNewAlbumContext, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj2 = anonymousClass1.result;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i3 = anonymousClass1.label;
                        if (i3 == 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super WinkNewAlbumContext> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, winkNewAlbumMediaScanProcessor3), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            WinkNewAlbumMediaScanProcessor.Companion companion = WinkNewAlbumMediaScanProcessor.INSTANCE;
            d16 = companion.d();
            buffer$default = FlowKt__ContextKt.buffer$default(flow2, d16, null, 2, null);
            c16 = companion.c();
            s16 = winkNewAlbumMediaScanProcessor.s(buffer$default, c16);
            Flow m2026catch = FlowKt.m2026catch(FlowKt.onCompletion(FlowKt.flatMapConcat(s16, new AnonymousClass4(this.this$0, this.$insertDbCount, null)), new AnonymousClass5(this.this$0, this.$transferCount, this.$transferImageCount, this.$transferVideoCount, this.$insertDbCount, this.$reportData, null)), new AnonymousClass6(this.this$0, null));
            a aVar = new a(this.this$0, this.$transferCount, this.$transferImageCount, this.$transferVideoCount);
            this.label = 1;
            if (m2026catch.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumMediaScanProcessor$onStart$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

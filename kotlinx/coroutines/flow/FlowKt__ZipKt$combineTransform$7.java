package kotlinx.coroutines.flow;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object>[] $flowArray;
    final /* synthetic */ Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001H\n"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<Object[]> {
        final /* synthetic */ Flow<Object>[] $flowArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow<Object>[] flowArr) {
            super(0);
            this.$flowArray = flowArr;
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object[] invoke() {
            int length = this.$flowArray.length;
            Intrinsics.reifiedOperationMarker(0, "T?");
            return new Object[length];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$transform = function3;
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
                FlowCollector<Object> flowCollector = (FlowCollector) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> function3 = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (function3.invoke(flowCollector, objArr, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            this.$transform.invoke((FlowCollector) this.L$0, (Object[]) this.L$1, this);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = objArr;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransform$7(Flow<Object>[] flowArr, Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$7> continuation) {
        super(2, continuation);
        this.$flowArray = flowArr;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.$flowArray, this.$transform, continuation);
        flowKt__ZipKt$combineTransform$7.L$0 = obj;
        return flowKt__ZipKt$combineTransform$7;
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
            Flow<Object>[] flowArr = this.$flowArray;
            Intrinsics.needClassReification();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            this.label = 1;
            if (CombineKt.combineInternal(flowCollector, flowArr, anonymousClass1, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Flow<Object>[] flowArr = this.$flowArray;
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, anonymousClass1, anonymousClass2, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransform$7) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.ecommerce.biz.live.ui;

import android.graphics.drawable.Drawable;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1", f = "ECLiveWindowSubFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubFragment$configUIForMasterEditable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECLiveWindowSubFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1$1", f = "ECLiveWindowSubFragment.kt", i = {}, l = {674}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $size;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.IntRef intRef, Continuation continuation) {
            super(2, continuation);
            this.$size = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$size, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io5 = Dispatchers.getIO();
                ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1 eCLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1 = new ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1(this, null);
                this.label = 1;
                obj = BuildersKt.withContext(io5, eCLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ECLiveWindowSubFragment.Vh(ECLiveWindowSubFragment$configUIForMasterEditable$1.this.this$0).setCompoundDrawables((Drawable) obj, null, null, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1$2", f = "ECLiveWindowSubFragment.kt", i = {}, l = {LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1$2, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $size;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.IntRef intRef, Continuation continuation) {
            super(2, continuation);
            this.$size = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$size, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io5 = Dispatchers.getIO();
                ECLiveWindowSubFragment$configUIForMasterEditable$1$2$setTopDrawable$1 eCLiveWindowSubFragment$configUIForMasterEditable$1$2$setTopDrawable$1 = new ECLiveWindowSubFragment$configUIForMasterEditable$1$2$setTopDrawable$1(this, null);
                this.label = 1;
                obj = BuildersKt.withContext(io5, eCLiveWindowSubFragment$configUIForMasterEditable$1$2$setTopDrawable$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ECLiveWindowSubFragment.hi(ECLiveWindowSubFragment$configUIForMasterEditable$1.this.this$0).setCompoundDrawables((Drawable) obj, null, null, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSubFragment$configUIForMasterEditable$1(ECLiveWindowSubFragment eCLiveWindowSubFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCLiveWindowSubFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECLiveWindowSubFragment$configUIForMasterEditable$1 eCLiveWindowSubFragment$configUIForMasterEditable$1 = new ECLiveWindowSubFragment$configUIForMasterEditable$1(this.this$0, continuation);
        eCLiveWindowSubFragment$configUIForMasterEditable$1.L$0 = obj;
        return eCLiveWindowSubFragment$configUIForMasterEditable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECLiveWindowSubFragment$configUIForMasterEditable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = ECLiveWindowSubFragment.INSTANCE.b();
            BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(intRef, null), 3, null);
            BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass2(intRef, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

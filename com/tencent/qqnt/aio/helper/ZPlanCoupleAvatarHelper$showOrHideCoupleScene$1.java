package com.tencent.qqnt.aio.helper;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1", f = "ZPlanCoupleAvatarHelper.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ZPlanCoupleAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1$1", f = "ZPlanCoupleAvatarHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $coupleAvatarSceneOpen;
        int label;
        final /* synthetic */ ZPlanCoupleAvatarHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z16, ZPlanCoupleAvatarHelper zPlanCoupleAvatarHelper, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$coupleAvatarSceneOpen = z16;
            this.this$0 = zPlanCoupleAvatarHelper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$coupleAvatarSceneOpen, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$coupleAvatarSceneOpen) {
                    this.this$0.y();
                    this.this$0.E();
                    this.this$0.H();
                } else {
                    this.this$0.x();
                    this.this$0.B();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1(ZPlanCoupleAvatarHelper zPlanCoupleAvatarHelper, Continuation<? super ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanCoupleAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        String b16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            aVar = this.this$0.mAIOContext;
            if (aVar != null && (g16 = aVar.g()) != null && (b16 = su3.c.b(g16)) != null) {
                QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
                boolean coupleAvatarSwitchState = ((IZPlanCoupleSceneHelper) api).getCoupleAvatarSwitchState(b16);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(coupleAvatarSwitchState, this.this$0, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

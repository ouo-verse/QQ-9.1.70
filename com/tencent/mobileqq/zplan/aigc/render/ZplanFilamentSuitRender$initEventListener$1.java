package com.tencent.mobileqq.zplan.aigc.render;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender$initEventListener$1", f = "ZplanFilamentSuitRender.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZplanFilamentSuitRender$initEventListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZplanFilamentSuitRender.c $listener;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZplanFilamentSuitRender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender$initEventListener$1$1", f = "ZplanFilamentSuitRender.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender$initEventListener$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $firstFrameJob;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$firstFrameJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$firstFrameJob, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$firstFrameJob;
                this.label = 1;
                if (job.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFilamentSuitRender$initEventListener$1(ZplanFilamentSuitRender zplanFilamentSuitRender, ZplanFilamentSuitRender.c cVar, Continuation<? super ZplanFilamentSuitRender$initEventListener$1> continuation) {
        super(2, continuation);
        this.this$0 = zplanFilamentSuitRender;
        this.$listener = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZplanFilamentSuitRender$initEventListener$1 zplanFilamentSuitRender$initEventListener$1 = new ZplanFilamentSuitRender$initEventListener$1(this.this$0, this.$listener, continuation);
        zplanFilamentSuitRender$initEventListener$1.L$0 = obj;
        return zplanFilamentSuitRender$initEventListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Job launch$default;
        boolean z16;
        FilamentTouchHelper touchHelper;
        PortalAnimHelper animHelper;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new ZplanFilamentSuitRender$initEventListener$1$firstFrameJob$1(this.$listener, null), 3, null);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(launch$default, null);
            this.label = 1;
            if (TimeoutKt.withTimeoutOrNull(10000L, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z16 = this.this$0.isFirstFrame;
        if (!z16) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender$initEventListener$1.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
                }
            });
            QLog.i(ZplanFilamentSuitRender.f330449l, 1, "FIRST_FRAME time out");
        }
        AigcPreviewBusinessScene scene = this.this$0.getScene();
        if (scene != null && (animHelper = scene.getAnimHelper()) != null) {
            animHelper.n1();
        }
        AigcPreviewBusinessScene scene2 = this.this$0.getScene();
        if (scene2 != null && (touchHelper = scene2.getTouchHelper()) != null) {
            touchHelper.k(this.this$0.k().getWidth(), this.this$0.k().getHeight());
        }
        QLog.i(ZplanFilamentSuitRender.f330449l, 1, "initLoading end");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZplanFilamentSuitRender$initEventListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.zplan.aigc.logic;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.PatternImage;
import com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic;
import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import u45.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic$processSingleRenderTask2$1", f = "CreatedClothShowLogic.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CreatedClothShowLogic$processSingleRenderTask2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreatedClothShowLogic.b $callback;
    final /* synthetic */ AIGCModelRenderTask $renderTask;
    final /* synthetic */ long $ugcId;
    final /* synthetic */ AIGCWhiteModel $whiteModel;
    int label;
    final /* synthetic */ CreatedClothShowLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatedClothShowLogic$processSingleRenderTask2$1(long j3, AIGCModelRenderTask aIGCModelRenderTask, CreatedClothShowLogic createdClothShowLogic, AIGCWhiteModel aIGCWhiteModel, CreatedClothShowLogic.b bVar, Continuation<? super CreatedClothShowLogic$processSingleRenderTask2$1> continuation) {
        super(2, continuation);
        this.$ugcId = j3;
        this.$renderTask = aIGCModelRenderTask;
        this.this$0 = createdClothShowLogic;
        this.$whiteModel = aIGCWhiteModel;
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreatedClothShowLogic$processSingleRenderTask2$1(this.$ugcId, this.$renderTask, this.this$0, this.$whiteModel, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.i("CreatedClothShowLogic", 1, "batchRequestImageryRecommendPicsAsync, " + this.$ugcId + ", " + this.$renderTask.getPatternImage().getImageryId() + ", " + this.$renderTask.getPatternImage().getImageryDesc());
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                long j3 = this.$ugcId;
                int safeReqId = this.this$0.getSafeReqId();
                int imageryId = this.$renderTask.getPatternImage().getImageryId();
                String imageryDesc = this.$renderTask.getPatternImage().getImageryDesc();
                if (imageryDesc == null) {
                    imageryDesc = "";
                }
                this.label = 1;
                obj = zPlanAIGCRequest.a(j3, safeReqId, imageryId, imageryDesc, 1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) obj;
            if (!list.isEmpty()) {
                final h hVar = (h) list.get(0);
                final int i16 = hVar.f438237c;
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final AIGCModelRenderTask aIGCModelRenderTask = this.$renderTask;
                final CreatedClothShowLogic createdClothShowLogic = this.this$0;
                final AIGCWhiteModel aIGCWhiteModel = this.$whiteModel;
                final CreatedClothShowLogic.b bVar = this.$callback;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.logic.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        CreatedClothShowLogic$processSingleRenderTask2$1.d(i16, aIGCModelRenderTask, hVar, createdClothShowLogic, aIGCWhiteModel, bVar);
                    }
                });
            } else {
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final CreatedClothShowLogic.b bVar2 = this.$callback;
                final AIGCModelRenderTask aIGCModelRenderTask2 = this.$renderTask;
                uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.logic.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        CreatedClothShowLogic$processSingleRenderTask2$1.e(CreatedClothShowLogic.b.this, aIGCModelRenderTask2);
                    }
                });
            }
            return Unit.INSTANCE;
        } catch (Throwable unused) {
            Handler uIHandlerV23 = ThreadManagerV2.getUIHandlerV2();
            final CreatedClothShowLogic.b bVar3 = this.$callback;
            final AIGCModelRenderTask aIGCModelRenderTask3 = this.$renderTask;
            uIHandlerV23.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.logic.c
                @Override // java.lang.Runnable
                public final void run() {
                    CreatedClothShowLogic$processSingleRenderTask2$1.f(CreatedClothShowLogic.b.this, aIGCModelRenderTask3);
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CreatedClothShowLogic.b bVar, AIGCModelRenderTask aIGCModelRenderTask) {
        QLog.e("CreatedClothShowLogic", 1, "processSingleRenderTask2 picRspList is null error");
        if (bVar != null) {
            bVar.c(aIGCModelRenderTask, -111);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CreatedClothShowLogic.b bVar, AIGCModelRenderTask aIGCModelRenderTask) {
        QLog.e("CreatedClothShowLogic", 1, "processSingleRenderTask2 batchRequestImageryRecommendPicsAsync error");
        if (bVar != null) {
            bVar.c(aIGCModelRenderTask, -111);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreatedClothShowLogic$processSingleRenderTask2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, AIGCModelRenderTask aIGCModelRenderTask, h hVar, CreatedClothShowLogic createdClothShowLogic, AIGCWhiteModel aIGCWhiteModel, CreatedClothShowLogic.b bVar) {
        if (i3 == 0) {
            aIGCModelRenderTask.getPatternImage().k(hVar.f438235a[0]);
            PatternImage patternImage = aIGCModelRenderTask.getPatternImage();
            String str = hVar.f438239e;
            Intrinsics.checkNotNullExpressionValue(str, "picResp.prompt");
            patternImage.i(str);
            createdClothShowLogic.d(aIGCModelRenderTask, aIGCWhiteModel, bVar);
            return;
        }
        QLog.e("CreatedClothShowLogic", 1, "batchRequestImageryRecommendPicsAsync error " + i3);
        if (bVar != null) {
            bVar.c(aIGCModelRenderTask, i3);
        }
    }
}

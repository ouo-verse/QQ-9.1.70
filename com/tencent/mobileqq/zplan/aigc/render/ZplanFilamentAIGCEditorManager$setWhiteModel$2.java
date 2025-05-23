package com.tencent.mobileqq.zplan.aigc.render;

import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$setWhiteModel$2", f = "ZplanFilamentAIGCEditorManager.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZplanFilamentAIGCEditorManager$setWhiteModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $listener;
    final /* synthetic */ AIGCWhiteModel $model;
    int label;
    final /* synthetic */ ZplanFilamentAIGCEditorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFilamentAIGCEditorManager$setWhiteModel$2(AIGCWhiteModel aIGCWhiteModel, ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, g gVar, Continuation<? super ZplanFilamentAIGCEditorManager$setWhiteModel$2> continuation) {
        super(2, continuation);
        this.$model = aIGCWhiteModel;
        this.this$0 = zplanFilamentAIGCEditorManager;
        this.$listener = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZplanFilamentAIGCEditorManager$setWhiteModel$2(this.$model, this.this$0, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                AIGCHelper aIGCHelper = AIGCHelper.f330685a;
                long slotID = this.$model.getSlotID();
                long itemID = this.$model.getItemID();
                this.label = 1;
                obj = aIGCHelper.j(slotID, itemID, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str10 = (String) obj;
            ZplanFilamentAIGCEditorManager.b bVar = ZplanFilamentAIGCEditorManager.b.f330432a;
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.this$0;
            AIGCWhiteModel aIGCWhiteModel = this.$model;
            g gVar = this.$listener;
            synchronized (bVar) {
                if (!Intrinsics.areEqual(zplanFilamentAIGCEditorManager.currentSlotID, String.valueOf(aIGCWhiteModel.getSlotID()))) {
                    if (gVar != null) {
                        gVar.e(false, aIGCWhiteModel);
                    }
                    return Unit.INSTANCE;
                }
                Unit unit = Unit.INSTANCE;
                ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager2 = this.this$0;
                zplanFilamentAIGCEditorManager2.curSetupConfig = AIGCHelper.f330685a.o(zplanFilamentAIGCEditorManager2.currentSlotID, str10);
                GYFZPlanController gYFZPlanController = this.this$0.filamentController;
                if (gYFZPlanController != null) {
                    gYFZPlanController.t0();
                }
                GYFZPlanController gYFZPlanController2 = this.this$0.filamentController;
                if (gYFZPlanController2 != null) {
                    gYFZPlanController2.f0();
                }
                str = this.this$0.baseTemplate;
                if (str.length() > 0) {
                    str4 = this.this$0.exportTemplate;
                    if (str4.length() > 0) {
                        FLog fLog = FLog.INSTANCE;
                        str5 = this.this$0.iblPath;
                        fLog.i("ZplanFilamentAIGCManager", "setBaseTemplateInfo with ibl path: " + str5);
                        GYFZPlanController gYFZPlanController3 = this.this$0.filamentController;
                        if (gYFZPlanController3 != null) {
                            str8 = this.this$0.baseTemplate;
                            str9 = this.this$0.iblPath;
                            gYFZPlanController3.l0(str8, str9);
                        }
                        GYFZPlanController gYFZPlanController4 = this.this$0.offScreenController;
                        if (gYFZPlanController4 != null) {
                            str6 = this.this$0.exportTemplate;
                            str7 = this.this$0.iblPath;
                            gYFZPlanController4.l0(str6, str7);
                        }
                    }
                }
                GYFZPlanController gYFZPlanController5 = this.this$0.filamentController;
                if (gYFZPlanController5 != null) {
                    str3 = this.this$0.curSetupConfig;
                    gYFZPlanController5.s0(str3, "");
                }
                GYFZPlanController gYFZPlanController6 = this.this$0.filamentController;
                if (gYFZPlanController6 != null) {
                    GYFZPlanController.i0(gYFZPlanController6, "{}", "", this.this$0.currentSetModelRequest, null, 8, null);
                }
                GYFZPlanController gYFZPlanController7 = this.this$0.offScreenController;
                if (gYFZPlanController7 != null) {
                    str2 = this.this$0.curSetupConfig;
                    gYFZPlanController7.s0(str2, "");
                }
                GYFZPlanController gYFZPlanController8 = this.this$0.offScreenController;
                if (gYFZPlanController8 != null) {
                    GYFZPlanController.i0(gYFZPlanController8, "{}", "", this.this$0.currentSetModelRequest, null, 8, null);
                }
                g gVar2 = this.$listener;
                if (gVar2 != null) {
                    gVar2.e(true, this.$model);
                }
                return Unit.INSTANCE;
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.w("ZplanFilamentAIGCManager", th5.toString());
            g gVar3 = this.$listener;
            if (gVar3 != null) {
                gVar3.e(false, this.$model);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZplanFilamentAIGCEditorManager$setWhiteModel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

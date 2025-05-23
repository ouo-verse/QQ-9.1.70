package com.tencent.mobileqq.zplan.aigc.render;

import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1", f = "ZplanFilamentAIGCEditorManager.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $listener;
    Object L$0;
    int label;
    final /* synthetic */ ZplanFilamentAIGCEditorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1(ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, g gVar, Continuation<? super ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1> continuation) {
        super(2, continuation);
        this.this$0 = zplanFilamentAIGCEditorManager;
        this.$listener = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1(this.this$0, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager2 = this.this$0;
            AIGCHelper aIGCHelper = AIGCHelper.f330685a;
            this.L$0 = zplanFilamentAIGCEditorManager2;
            this.label = 1;
            Object i16 = aIGCHelper.i(this);
            if (i16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            zplanFilamentAIGCEditorManager = zplanFilamentAIGCEditorManager2;
            obj = i16;
        } else if (i3 == 1) {
            zplanFilamentAIGCEditorManager = (ZplanFilamentAIGCEditorManager) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        zplanFilamentAIGCEditorManager.iblPath = (String) obj;
        str = this.this$0.iblPath;
        if (str.length() == 0) {
            g gVar = this.$listener;
            if (gVar != null) {
                gVar.f(-305);
            }
            return Unit.INSTANCE;
        }
        FLog.INSTANCE.d("ZplanFilamentAIGCManager", "setAvatarWithAvatarInfoAndFaceJson init");
        this.this$0.currentSetModelRequest = 0;
        GYFZPlanController gYFZPlanController = this.this$0.filamentController;
        if (gYFZPlanController != null) {
            GYFZPlanController.i0(gYFZPlanController, "{}", "", 0, null, 8, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$loadCompleteAction$2", f = "AigcPreviewBusinessScene.kt", i = {0}, l = {298}, m = "invokeSuspend", n = {"gender"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class AigcPreviewBusinessScene$loadCompleteAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AigcPreviewBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcPreviewBusinessScene$loadCompleteAction$2(AigcPreviewBusinessScene aigcPreviewBusinessScene, Continuation<? super AigcPreviewBusinessScene$loadCompleteAction$2> continuation) {
        super(2, continuation);
        this.this$0 = aigcPreviewBusinessScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AigcPreviewBusinessScene$loadCompleteAction$2 aigcPreviewBusinessScene$loadCompleteAction$2 = new AigcPreviewBusinessScene$loadCompleteAction$2(this.this$0, continuation);
        aigcPreviewBusinessScene$loadCompleteAction$2.L$0 = obj;
        return aigcPreviewBusinessScene$loadCompleteAction$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        UEAvatarGender uEAvatarGender;
        EnumUserGender enumUserGender;
        ZPlanAvatarService service;
        Deferred async$default;
        final EnumUserGender enumUserGender2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            uEAvatarGender = this.this$0.ueGender;
            if (uEAvatarGender != null && (enumUserGender = uEAvatarGender.toEnumUserGender()) != null) {
                service = this.this$0.getService();
                if (service != null) {
                    coroutineScope = this.this$0.getScope();
                }
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1(this.this$0, enumUserGender, null), 3, null);
                this.L$0 = enumUserGender;
                this.label = 1;
                obj = async$default.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                enumUserGender2 = enumUserGender;
            } else {
                return Unit.INSTANCE;
            }
        } else if (i3 == 1) {
            enumUserGender2 = (EnumUserGender) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ZPlanAction[] zPlanActionArr = (ZPlanAction[]) obj;
        final AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0;
        aigcPreviewBusinessScene.runOnViewerThread("loadAIGCAnimation", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$loadCompleteAction$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16 = EnumUserGender.this == EnumUserGender.GENDER_FEMALE;
                PortalAnimHelper animHelper = aigcPreviewBusinessScene.getAnimHelper();
                FilamentViewerV2 viewerV2 = aigcPreviewBusinessScene.getViewerV2();
                Intrinsics.checkNotNull(viewerV2);
                animHelper.s0(viewerV2, zPlanActionArr[0], false, z16);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AigcPreviewBusinessScene$loadCompleteAction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

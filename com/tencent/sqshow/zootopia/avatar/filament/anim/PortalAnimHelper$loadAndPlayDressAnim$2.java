package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadAndPlayDressAnim$2", f = "PortalAnimHelper.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadAndPlayDressAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZPlanAction $animAction;
    final /* synthetic */ boolean $isLoop;
    final /* synthetic */ FilamentViewerV2 $viewer;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadAndPlayDressAnim$2(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, ZPlanAction zPlanAction, boolean z16, Continuation<? super PortalAnimHelper$loadAndPlayDressAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$viewer = filamentViewerV2;
        this.$animAction = zPlanAction;
        this.$isLoop = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadAndPlayDressAnim$2(this.this$0, this.$viewer, this.$animAction, this.$isLoop, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object x06;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PortalAnimHelper portalAnimHelper = this.this$0;
            FilamentViewerV2 filamentViewerV2 = this.$viewer;
            ZPlanAction zPlanAction = this.$animAction;
            boolean z16 = this.$isLoop;
            this.label = 1;
            x06 = portalAnimHelper.x0(filamentViewerV2, zPlanAction, z16, this);
            if (x06 == coroutine_suspended) {
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
        return ((PortalAnimHelper$loadAndPlayDressAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

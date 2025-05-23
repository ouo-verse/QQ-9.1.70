package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.sqshow.zootopia.avatar.filament.anim.g;
import com.tencent.zplan.zplantracing.c;
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
@DebugMetadata(c = "com.tencent.sqshow.sharedengine.anim.state.PortalInitAnimState$fetchAnim$1", f = "PortalInitAnimState.kt", i = {}, l = {33, 35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class PortalInitAnimState$fetchAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ a $listener;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ c $zplanSpanContext;
    Object L$0;
    int label;
    final /* synthetic */ PortalInitAnimState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalInitAnimState$fetchAnim$1(EnumUserGender enumUserGender, PortalInitAnimState portalInitAnimState, c cVar, FilamentUrlTemplate filamentUrlTemplate, a aVar, Continuation<? super PortalInitAnimState$fetchAnim$1> continuation) {
        super(2, continuation);
        this.$gender = enumUserGender;
        this.this$0 = portalInitAnimState;
        this.$zplanSpanContext = cVar;
        this.$urlTemplate = filamentUrlTemplate;
        this.$listener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalInitAnimState$fetchAnim$1(this.$gender, this.this$0, this.$zplanSpanContext, this.$urlTemplate, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        PortalInitAnimState portalInitAnimState;
        PortalInitAnimState portalInitAnimState2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            EnumUserGender enumUserGender = this.$gender;
            if (enumUserGender == EnumUserGender.GENDER_FEMALE) {
                PortalInitAnimState portalInitAnimState3 = this.this$0;
                c cVar = this.$zplanSpanContext;
                g gVar = g.f370004a;
                String head = gVar.a().getHead();
                String body = gVar.a().getBody();
                FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
                this.L$0 = portalInitAnimState3;
                this.label = 1;
                Object e16 = portalInitAnimState3.e(cVar, enumUserGender, head, body, filamentUrlTemplate, this);
                if (e16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                portalInitAnimState2 = portalInitAnimState3;
                obj = e16;
                portalInitAnimState2.k((com.tencent.filament.zplan.animation.b) obj);
            } else {
                PortalInitAnimState portalInitAnimState4 = this.this$0;
                c cVar2 = this.$zplanSpanContext;
                g gVar2 = g.f370004a;
                String head2 = gVar2.b().getHead();
                String body2 = gVar2.b().getBody();
                FilamentUrlTemplate filamentUrlTemplate2 = this.$urlTemplate;
                this.L$0 = portalInitAnimState4;
                this.label = 2;
                Object e17 = portalInitAnimState4.e(cVar2, enumUserGender, head2, body2, filamentUrlTemplate2, this);
                if (e17 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                portalInitAnimState = portalInitAnimState4;
                obj = e17;
                portalInitAnimState.l((com.tencent.filament.zplan.animation.b) obj);
            }
        } else if (i3 == 1) {
            portalInitAnimState2 = (PortalInitAnimState) this.L$0;
            ResultKt.throwOnFailure(obj);
            portalInitAnimState2.k((com.tencent.filament.zplan.animation.b) obj);
        } else if (i3 == 2) {
            portalInitAnimState = (PortalInitAnimState) this.L$0;
            ResultKt.throwOnFailure(obj);
            portalInitAnimState.l((com.tencent.filament.zplan.animation.b) obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a aVar = this.$listener;
        if (aVar != null) {
            aVar.onResult(true);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalInitAnimState$fetchAnim$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

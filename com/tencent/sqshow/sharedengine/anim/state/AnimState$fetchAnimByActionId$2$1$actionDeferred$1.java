package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.animation.FilamentAnimationHelper;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.sharedengine.anim.state.AnimState$fetchAnimByActionId$2$1$actionDeferred$1", f = "AnimState.kt", i = {0}, l = {114, 120}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
/* loaded from: classes34.dex */
final class AnimState$fetchAnimByActionId$2$1$actionDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ int $actionId;
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnimState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimState$fetchAnimByActionId$2$1$actionDeferred$1(AnimState animState, EnumUserGender enumUserGender, int i3, c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super AnimState$fetchAnimByActionId$2$1$actionDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = animState;
        this.$gender = enumUserGender;
        this.$actionId = i3;
        this.$zplanSpanContext = cVar;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimState$fetchAnimByActionId$2$1$actionDeferred$1 animState$fetchAnimByActionId$2$1$actionDeferred$1 = new AnimState$fetchAnimByActionId$2$1$actionDeferred$1(this.this$0, this.$gender, this.$actionId, this.$zplanSpanContext, this.$urlTemplate, continuation);
        animState$fetchAnimByActionId$2$1$actionDeferred$1.L$0 = obj;
        return animState$fetchAnimByActionId$2$1$actionDeferred$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0063 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ZPlanAvatarService service = this.this$0.getParams().getService();
            if (service != null) {
                EnumUserGender enumUserGender = this.$gender;
                int i16 = this.$actionId;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = FilamentAnimationHelper.f105573a.a(service, enumUserGender, i16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            c cVar = this.$zplanSpanContext;
            EnumUserGender enumUserGender2 = this.$gender;
            int i17 = this.$actionId;
            FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            this.L$0 = null;
            this.label = 2;
            obj = zPlanAvatarResourceHelper.z(cVar, enumUserGender2, i17, filamentUrlTemplate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (ZPlanAction) obj;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                return (ZPlanAction) obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ZPlanAction zPlanAction = (ZPlanAction) obj;
        if (zPlanAction != null) {
            return zPlanAction;
        }
        c cVar2 = this.$zplanSpanContext;
        EnumUserGender enumUserGender22 = this.$gender;
        int i172 = this.$actionId;
        FilamentUrlTemplate filamentUrlTemplate2 = this.$urlTemplate;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
        this.L$0 = null;
        this.label = 2;
        obj = zPlanAvatarResourceHelper2.z(cVar2, enumUserGender22, i172, filamentUrlTemplate2, this);
        if (obj == coroutine_suspended) {
        }
        return (ZPlanAction) obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((AnimState$fetchAnimByActionId$2$1$actionDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.sqshow.zootopia.avatar.filament.anim;

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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadInitHandHeldAnim$1", f = "PortalAnimHelper.kt", i = {}, l = {655, 656}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadInitHandHeldAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentViewerV2 $viewer;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadInitHandHeldAnim$1(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super PortalAnimHelper$loadInitHandHeldAnim$1> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$viewer = filamentViewerV2;
        this.$avatarPbJson = jSONObject;
        this.$zplanSpanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadInitHandHeldAnim$1(this.this$0, this.$viewer, this.$avatarPbJson, this.$zplanSpanContext, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object G0;
        Object A0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PortalAnimHelper portalAnimHelper = this.this$0;
            FilamentViewerV2 filamentViewerV2 = this.$viewer;
            JSONObject jSONObject = this.$avatarPbJson;
            com.tencent.zplan.zplantracing.c cVar = this.$zplanSpanContext;
            this.label = 1;
            G0 = portalAnimHelper.G0(filamentViewerV2, jSONObject, cVar, this);
            if (G0 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PortalAnimHelper portalAnimHelper2 = this.this$0;
        FilamentViewerV2 filamentViewerV22 = this.$viewer;
        JSONObject jSONObject2 = this.$avatarPbJson;
        com.tencent.zplan.zplantracing.c cVar2 = this.$zplanSpanContext;
        this.label = 2;
        A0 = portalAnimHelper2.A0(filamentViewerV22, jSONObject2, cVar2, this);
        if (A0 == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadInitHandHeldAnim$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.engine.FilamentViewerV2;
import cooperation.qzone.report.lp.LpReportInfoConfig;
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
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadOthersAnim$1", f = "PortalAnimHelper.kt", i = {}, l = {682, LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, com.tencent.luggage.wxa.yf.d.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadOthersAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentViewerV2 $viewer;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadOthersAnim$1(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super PortalAnimHelper$loadOthersAnim$1> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$viewer = filamentViewerV2;
        this.$avatarPbJson = jSONObject;
        this.$zplanSpanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadOthersAnim$1(this.this$0, this.$viewer, this.$avatarPbJson, this.$zplanSpanContext, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object I0;
        Object C0;
        Object J0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PortalAnimHelper portalAnimHelper = this.this$0;
            FilamentViewerV2 filamentViewerV2 = this.$viewer;
            JSONObject jSONObject = this.$avatarPbJson;
            com.tencent.zplan.zplantracing.c cVar = this.$zplanSpanContext;
            this.label = 1;
            I0 = portalAnimHelper.I0(filamentViewerV2, jSONObject, cVar, this);
            if (I0 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PortalAnimHelper portalAnimHelper2 = this.this$0;
                FilamentViewerV2 filamentViewerV22 = this.$viewer;
                JSONObject jSONObject2 = this.$avatarPbJson;
                this.label = 3;
                J0 = portalAnimHelper2.J0(filamentViewerV22, jSONObject2, this);
                if (J0 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        PortalAnimHelper portalAnimHelper3 = this.this$0;
        FilamentViewerV2 filamentViewerV23 = this.$viewer;
        JSONObject jSONObject3 = this.$avatarPbJson;
        com.tencent.zplan.zplantracing.c cVar2 = this.$zplanSpanContext;
        this.label = 2;
        C0 = portalAnimHelper3.C0(filamentViewerV23, jSONObject3, cVar2, this);
        if (C0 == coroutine_suspended) {
            return coroutine_suspended;
        }
        PortalAnimHelper portalAnimHelper22 = this.this$0;
        FilamentViewerV2 filamentViewerV222 = this.$viewer;
        JSONObject jSONObject22 = this.$avatarPbJson;
        this.label = 3;
        J0 = portalAnimHelper22.J0(filamentViewerV222, jSONObject22, this);
        if (J0 == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadOthersAnim$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

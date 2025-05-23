package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadMaleInitHandHeldAnim$2", f = "PortalAnimHelper.kt", i = {0, 0}, l = {949}, m = "invokeSuspend", n = {"loadMaleInitHandHeldAnimSpan", "errorMsg"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadMaleInitHandHeldAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentViewerV2 $viewer;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadMaleInitHandHeldAnim$2(PortalAnimHelper portalAnimHelper, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, FilamentViewerV2 filamentViewerV2, Continuation<? super PortalAnimHelper$loadMaleInitHandHeldAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$avatarPbJson = jSONObject;
        this.$zplanSpanContext = cVar;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PortalAnimHelper$loadMaleInitHandHeldAnim$2 portalAnimHelper$loadMaleInitHandHeldAnim$2 = new PortalAnimHelper$loadMaleInitHandHeldAnim$2(this.this$0, this.$avatarPbJson, this.$zplanSpanContext, this.$viewer, continuation);
        portalAnimHelper$loadMaleInitHandHeldAnim$2.L$0 = obj;
        return portalAnimHelper$loadMaleInitHandHeldAnim$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HandHeldItem f06;
        com.tencent.zplan.zplantracing.b startSpan;
        Deferred async$default;
        final Ref.ObjectRef objectRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            f06 = this.this$0.f0(this.$avatarPbJson);
            if (f06 == null) {
                QLog.i("PortalAnimHelper_", 1, "loadMaleInitHandHeldAnim do not contains hand held item.");
                return Unit.INSTANCE;
            }
            startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadMaleInitHandHeldAnim", this.$zplanSpanContext);
            QLog.i("PortalAnimHelper_", 1, "loadMaleInitHandHeldAnim start");
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PortalAnimHelper$loadMaleInitHandHeldAnim$2$initAnimHandHeldMaleActionJob$1(this.this$0, startSpan, f06, objectRef2, null), 3, null);
            this.L$0 = startSpan;
            this.L$1 = objectRef2;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            obj = await;
        } else if (i3 == 1) {
            Ref.ObjectRef objectRef3 = (Ref.ObjectRef) this.L$1;
            startSpan = (com.tencent.zplan.zplantracing.b) this.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef = objectRef3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final com.tencent.zplan.zplantracing.b bVar = startSpan;
        final ZPlanAction zPlanAction = (ZPlanAction) obj;
        i mTaskExecutor = this.this$0.getMTaskExecutor();
        if (mTaskExecutor != null) {
            final PortalAnimHelper portalAnimHelper = this.this$0;
            final FilamentViewerV2 filamentViewerV2 = this.$viewer;
            mTaskExecutor.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadMaleInitHandHeldAnim$2.1
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
                    ZPlanAction zPlanAction2 = ZPlanAction.this;
                    if (zPlanAction2 == null) {
                        com.tencent.zplan.zplantracing.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(objectRef.element);
                        }
                        portalAnimHelper.Q0(objectRef.element);
                    } else {
                        PortalAnimHelper portalAnimHelper2 = portalAnimHelper;
                        FilamentViewerV2 filamentViewerV22 = filamentViewerV2;
                        ZPlanAction[] zPlanActionArr = {zPlanAction2};
                        com.tencent.zplan.zplantracing.b bVar3 = bVar;
                        portalAnimHelper2.mInitHandHeldAnimMale = portalAnimHelper2.q1(filamentViewerV22, zPlanActionArr, bVar3 != null ? bVar3.c() : null);
                        com.tencent.zplan.zplantracing.b bVar4 = bVar;
                        if (bVar4 != null) {
                            bVar4.b();
                        }
                    }
                    portalAnimHelper.U();
                    QLog.i("PortalAnimHelper_", 1, "loadMaleInitHandHeldAnim end");
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadMaleInitHandHeldAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

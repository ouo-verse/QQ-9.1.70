package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1", f = "PortalAnimHelper.kt", i = {}, l = {gdt_analysis_event.EVENT_GET_MANUFACTURER}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ AnimPath $it;
    final /* synthetic */ com.tencent.zplan.zplantracing.b $loadFemaleInitHandHeldAnimSpan;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1(PortalAnimHelper portalAnimHelper, com.tencent.zplan.zplantracing.b bVar, AnimPath animPath, Continuation<? super PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$loadFemaleInitHandHeldAnimSpan = bVar;
        this.$it = animPath;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1(this.this$0, this.$loadFemaleInitHandHeldAnimSpan, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                PortalAnimHelper portalAnimHelper = this.this$0;
                com.tencent.zplan.zplantracing.b bVar = this.$loadFemaleInitHandHeldAnimSpan;
                com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
                EnumUserGender enumUserGender = EnumUserGender.GENDER_FEMALE;
                String head = this.$it.getHead();
                String body = this.$it.getBody();
                FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
                this.label = 1;
                obj = portalAnimHelper.d0(c16, enumUserGender, head, body, urlTemplate, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (ZPlanAction) obj;
        } catch (Throwable th5) {
            QLog.e("PortalAnimHelper_", 1, "loadFemaleRandomAnim failed", th5);
            return null;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

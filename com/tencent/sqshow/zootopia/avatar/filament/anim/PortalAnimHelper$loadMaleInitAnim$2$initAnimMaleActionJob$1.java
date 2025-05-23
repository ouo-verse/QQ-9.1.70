package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.litetransfersdk.LiteTransferType;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1", f = "PortalAnimHelper.kt", i = {}, l = {LiteTransferType.MsgBodyType.MsgType_0x345}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class PortalAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $errorMsg;
    final /* synthetic */ com.tencent.zplan.zplantracing.b $loadMaleInitAnimSpan;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1(PortalAnimHelper portalAnimHelper, com.tencent.zplan.zplantracing.b bVar, Ref.ObjectRef<String> objectRef, Continuation<? super PortalAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$loadMaleInitAnimSpan = bVar;
        this.$errorMsg = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1(this.this$0, this.$loadMaleInitAnimSpan, this.$errorMsg, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                PortalAnimHelper portalAnimHelper = this.this$0;
                com.tencent.zplan.zplantracing.b bVar = this.$loadMaleInitAnimSpan;
                com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
                EnumUserGender enumUserGender = EnumUserGender.GENDER_MALE;
                g gVar = g.f370004a;
                String head = gVar.b().getHead();
                String body = gVar.b().getBody();
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
            QLog.e("PortalAnimHelper_", 1, "loadMaleInitAnim failed async", th5);
            Ref.ObjectRef<String> objectRef = this.$errorMsg;
            String message = th5.getMessage();
            T t16 = message;
            if (message == null) {
                t16 = "";
            }
            objectRef.element = t16;
            return null;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((PortalAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

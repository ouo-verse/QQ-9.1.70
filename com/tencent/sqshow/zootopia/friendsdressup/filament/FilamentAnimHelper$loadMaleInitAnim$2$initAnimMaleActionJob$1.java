package com.tencent.sqshow.zootopia.friendsdressup.filament;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1", f = "FriendsDressUpAnimHelper.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class FilamentAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $errorMsg;
    int label;
    final /* synthetic */ FilamentAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1(FilamentAnimHelper filamentAnimHelper, Ref.ObjectRef<String> objectRef, Continuation<? super FilamentAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1> continuation) {
        super(2, continuation);
        this.this$0 = filamentAnimHelper;
        this.$errorMsg = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilamentAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1(this.this$0, this.$errorMsg, continuation);
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
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                EnumUserGender enumUserGender = EnumUserGender.GENDER_MALE;
                com.tencent.sqshow.zootopia.avatar.filament.anim.g gVar = com.tencent.sqshow.zootopia.avatar.filament.anim.g.f370004a;
                String head = gVar.b().getHead();
                String body = gVar.b().getBody();
                FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
                this.label = 1;
                obj = zPlanAvatarResourceHelper.B(null, enumUserGender, head, body, urlTemplate, this);
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
            QLog.e("FilamentAnimHelper_", 1, "loadFemaleInitAnim failed", th5);
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
        return ((FilamentAnimHelper$loadMaleInitAnim$2$initAnimMaleActionJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.av.zplan;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.av.zplan.AvatarResDownUtil$requestZPlanAnimationRes$1", f = "AvatarResDownUtil.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class AvatarResDownUtil$requestZPlanAnimationRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bodyActionPath;
    final /* synthetic */ String $faceActionPath;
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ a $listener;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarResDownUtil$requestZPlanAnimationRes$1(EnumUserGender enumUserGender, String str, String str2, a aVar, Continuation<? super AvatarResDownUtil$requestZPlanAnimationRes$1> continuation) {
        super(2, continuation);
        this.$gender = enumUserGender;
        this.$faceActionPath = str;
        this.$bodyActionPath = str2;
        this.$listener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AvatarResDownUtil$requestZPlanAnimationRes$1(this.$gender, this.$faceActionPath, this.$bodyActionPath, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ZPlanAction zPlanAction;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                EnumUserGender enumUserGender = this.$gender;
                String str = this.$faceActionPath;
                String str2 = this.$bodyActionPath;
                FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
                this.label = 1;
                obj = zPlanAvatarResourceHelper.B(null, enumUserGender, str, str2, F, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            zPlanAction = (ZPlanAction) obj;
        } catch (Throwable th5) {
            QLog.e("AvatarResDownUtil", 1, "fetchActionWithPath exception", th5);
            zPlanAction = new ZPlanAction("", "", "", "");
        }
        this.$listener.onSuccess(zPlanAction.getFaceAnimationGltfPath(), zPlanAction.getBodyAnimationGltfPath());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AvatarResDownUtil$requestZPlanAnimationRes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

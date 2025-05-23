package com.tencent.av.zplan;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.AvatarResourceModel;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
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
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.av.zplan.AvatarResDownUtil$requestAvatarRes$1", f = "AvatarResDownUtil.kt", i = {2}, l = {22, 24, 28}, m = "invokeSuspend", n = {"jsonStr"}, s = {"L$0"})
/* loaded from: classes3.dex */
final class AvatarResDownUtil$requestAvatarRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSelf;
    final /* synthetic */ b $listener;
    final /* synthetic */ String $uin;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarResDownUtil$requestAvatarRes$1(boolean z16, String str, b bVar, Continuation<? super AvatarResDownUtil$requestAvatarRes$1> continuation) {
        super(2, continuation);
        this.$isSelf = z16;
        this.$uin = str;
        this.$listener = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AvatarResDownUtil$requestAvatarRes$1(this.$isSelf, this.$uin, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Throwable th5;
        Object D;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        AvatarResourceModel avatarResourceModel = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        jSONObject2 = (JSONObject) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            avatarResourceModel = (AvatarResourceModel) obj;
                        } catch (Throwable th6) {
                            th5 = th6;
                            QLog.e("AvatarResDownUtil", 1, "fetchAvatarResource exception", th5);
                            jSONObject = jSONObject2;
                            this.$listener.a(String.valueOf(jSONObject), avatarResourceModel);
                            return Unit.INSTANCE;
                        }
                        jSONObject = jSONObject2;
                        this.$listener.a(String.valueOf(jSONObject), avatarResourceModel);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                jSONObject = (JSONObject) obj;
            } else {
                ResultKt.throwOnFailure(obj);
                jSONObject = (JSONObject) obj;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$isSelf) {
                IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                this.label = 1;
                obj = iZPlanAvatarInfoHelper.fetchMyAvatarInfo(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jSONObject = (JSONObject) obj;
            } else {
                IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper2 = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                String str = this.$uin;
                this.label = 2;
                obj = iZPlanAvatarInfoHelper2.fetchOtherAvatarInfoWithUin(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jSONObject = (JSONObject) obj;
            }
        }
        if (jSONObject != null) {
            try {
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
                this.L$0 = jSONObject;
                this.label = 3;
                D = zPlanAvatarResourceHelper.D(null, jSONObject, F, this);
            } catch (Throwable th7) {
                jSONObject2 = jSONObject;
                th5 = th7;
                QLog.e("AvatarResDownUtil", 1, "fetchAvatarResource exception", th5);
                jSONObject = jSONObject2;
                this.$listener.a(String.valueOf(jSONObject), avatarResourceModel);
                return Unit.INSTANCE;
            }
            if (D == coroutine_suspended) {
                return coroutine_suspended;
            }
            jSONObject2 = jSONObject;
            obj = D;
            avatarResourceModel = (AvatarResourceModel) obj;
            jSONObject = jSONObject2;
        }
        this.$listener.a(String.valueOf(jSONObject), avatarResourceModel);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AvatarResDownUtil$requestAvatarRes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

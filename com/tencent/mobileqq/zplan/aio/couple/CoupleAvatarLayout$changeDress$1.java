package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$changeDress$1", f = "CoupleAvatarLayout.kt", i = {1, 1}, l = {294, 299}, m = "invokeSuspend", n = {"leftAvatarInfo", "newLeftGender"}, s = {"L$0", "L$1"})
/* loaded from: classes35.dex */
public final class CoupleAvatarLayout$changeDress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CoupleAvatarLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout$changeDress$1(CoupleAvatarLayout coupleAvatarLayout, Continuation<? super CoupleAvatarLayout$changeDress$1> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarLayout$changeDress$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x008e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        JSONObject jSONObject;
        EnumUserGender enumUserGender;
        JSONObject jSONObject2;
        EnumUserGender enumUserGender2;
        EnumUserGender enumUserGender3;
        com.tencent.zplan.zplantracing.b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
            String peerUin = this.this$0.getPeerUin();
            this.label = 1;
            obj = iZPlanAvatarInfoHelper.fetchOtherAvatarInfoWithUin(peerUin, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    enumUserGender = (EnumUserGender) this.L$1;
                    jSONObject = (JSONObject) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    jSONObject2 = (JSONObject) obj;
                    if (jSONObject2 == null) {
                        this.this$0.F(jSONObject2);
                    } else {
                        jSONObject2 = null;
                    }
                    EnumUserGender a16 = jSONObject2 == null ? EnumUserGender.INSTANCE.a(jSONObject2.optInt("gender")) : null;
                    enumUserGender2 = this.this$0.leftGender;
                    if (enumUserGender == enumUserGender2) {
                        enumUserGender3 = this.this$0.rightGender;
                        if (a16 == enumUserGender3) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.toString(), jSONObject);
                            jSONObject3.put(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.toString(), jSONObject2);
                            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.this$0.nativeApp;
                            if (iFilamentNativeAppV2305 != null) {
                                bVar = this.this$0.rootSpan;
                                iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, "CoupleAvatarScene.ChangeDress", jSONObject3.toString());
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    CoupleAvatarLayout coupleAvatarLayout = this.this$0;
                    coupleAvatarLayout.f0(coupleAvatarLayout.getCurSceneId());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            this.this$0.peerDressKey = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.this$0.getPeerUin()).appearanceKey;
            EnumUserGender a17 = EnumUserGender.INSTANCE.a(jSONObject.optInt("gender"));
            this.this$0.F(jSONObject);
            IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper2 = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
            this.L$0 = jSONObject;
            this.L$1 = a17;
            this.label = 2;
            Object fetchMyAvatarInfo = iZPlanAvatarInfoHelper2.fetchMyAvatarInfo(this);
            if (fetchMyAvatarInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            enumUserGender = a17;
            obj = fetchMyAvatarInfo;
            jSONObject2 = (JSONObject) obj;
            if (jSONObject2 == null) {
            }
            if (jSONObject2 == null) {
            }
            enumUserGender2 = this.this$0.leftGender;
            if (enumUserGender == enumUserGender2) {
            }
            CoupleAvatarLayout coupleAvatarLayout2 = this.this$0;
            coupleAvatarLayout2.f0(coupleAvatarLayout2.getCurSceneId());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarLayout$changeDress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

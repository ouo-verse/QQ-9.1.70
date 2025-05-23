package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$runAPP$1", f = "CoupleAvatarLayout.kt", i = {}, l = {480}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CoupleAvatarLayout$runAPP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $sceneId;
    int label;
    final /* synthetic */ CoupleAvatarLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout$runAPP$1(CoupleAvatarLayout coupleAvatarLayout, int i3, Continuation<? super CoupleAvatarLayout$runAPP$1> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarLayout;
        this.$sceneId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarLayout$runAPP$1(this.this$0, this.$sceneId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.zplan.zplantracing.b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoupleAvatarLayout coupleAvatarLayout = this.this$0;
                int i16 = this.$sceneId;
                this.label = 1;
                obj = coupleAvatarLayout.K(i16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            JSONObject jSONObject = (JSONObject) obj;
            this.this$0.dataReadyTimeStamp = System.currentTimeMillis();
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.this$0.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                bVar = this.this$0.rootSpan;
                iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, "CoupleAvatarScene.LoadScene", jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("CoupleAvatarLayout", 1, "runAPP failed t:" + th5);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarLayout$runAPP$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

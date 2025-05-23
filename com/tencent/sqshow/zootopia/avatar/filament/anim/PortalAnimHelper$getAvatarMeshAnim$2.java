package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$getAvatarMeshAnim$2", f = "PortalAnimHelper.kt", i = {}, l = {759}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$getAvatarMeshAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ZPlanAction>>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$getAvatarMeshAnim$2(JSONObject jSONObject, PortalAnimHelper portalAnimHelper, Continuation<? super PortalAnimHelper$getAvatarMeshAnim$2> continuation) {
        super(2, continuation);
        this.$avatarPbJson = jSONObject;
        this.this$0 = portalAnimHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PortalAnimHelper$getAvatarMeshAnim$2 portalAnimHelper$getAvatarMeshAnim$2 = new PortalAnimHelper$getAvatarMeshAnim$2(this.$avatarPbJson, this.this$0, continuation);
        portalAnimHelper$getAvatarMeshAnim$2.L$0 = obj;
        return portalAnimHelper$getAvatarMeshAnim$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ZPlanAction>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ZPlanAction>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            JSONObject optJSONObject = this.$avatarPbJson.optJSONObject("avatar_info");
            JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("slot_arr") : null;
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
                if (optJSONObject2 != null) {
                    optJSONObject2.optInt(MiniAppReportManager2.KEY_SLOT_ID, -1);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("item_data");
                    if (optJSONObject3 != null) {
                        String animationBp = optJSONObject3.optString("animation_bp");
                        if (!(animationBp == null || animationBp.length() == 0)) {
                            QLog.i("PortalAnimHelper_", 1, "getAvatarMeshAnim add path=" + animationBp);
                            Intrinsics.checkNotNullExpressionValue(animationBp, "animationBp");
                            arrayList.add(animationBp);
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            PortalAnimHelper portalAnimHelper = this.this$0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PortalAnimHelper$getAvatarMeshAnim$2$1$actionJob$1(portalAnimHelper, portalAnimHelper.p1((String) it.next()), null), 3, null);
                arrayList2.add(async$default);
            }
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ZPlanAction>> continuation) {
        return ((PortalAnimHelper$getAvatarMeshAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

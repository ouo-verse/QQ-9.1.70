package com.tencent.filament.zplan.business.impl;

import al0.a;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$onLaunch$2", f = "AbsBusinessScene.kt", i = {0, 0, 0, 0, 2}, l = {193, 215, 220}, m = "invokeSuspend", n = {"launchSpan", "fetchAvatarInfoSpan", "avatarInfoStep", "this_$iv", "launchSpan"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$onLaunch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $zplanSpanContext;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$onLaunch$2(AbsBusinessScene absBusinessScene, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$zplanSpanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$onLaunch$2(this.this$0, this.$zplanSpanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbsBusinessScene$onLaunch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0181  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        b startSpan;
        c cVar;
        al0.a aVar;
        Object fetchAvatarInfo;
        b bVar;
        al0.a aVar2;
        c cVar2;
        Object fetchAvatarResourceWithCpp;
        b bVar2;
        c cVar3;
        a aVar3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        c cVar4 = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        bVar2 = (b) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        fetchAvatarResourceWithCpp = obj;
                        aVar3 = (a) fetchAvatarResourceWithCpp;
                        if (aVar3 == null) {
                            this.this$0.setCameraAndLight(aVar3.getIndirectLightPath());
                            AbsBusinessScene absBusinessScene = this.this$0;
                            if (bVar2 != null) {
                                cVar4 = bVar2.c();
                            }
                            absBusinessScene.loadAvatarAndAnim(cVar4, aVar3.getAvatarString(), aVar3.getActionArray());
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            aVar2 = (al0.a) this.L$3;
            al0.a aVar4 = (al0.a) this.L$2;
            b bVar3 = (b) this.L$1;
            b bVar4 = (b) this.L$0;
            ResultKt.throwOnFailure(obj);
            aVar = aVar4;
            fetchAvatarInfo = obj;
            bVar = bVar3;
            startSpan = bVar4;
        } else {
            ResultKt.throwOnFailure(obj);
            FLog.INSTANCE.i(AbsBusinessScene.TAG, "onLaunch start");
            ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
            startSpan = zPlanSpanFactory.startSpan("onLaunch", this.$zplanSpanContext);
            if (startSpan != null) {
                cVar = startSpan.c();
            } else {
                cVar = null;
            }
            b startSpan2 = zPlanSpanFactory.startSpan("fetchAvatarInfo", cVar);
            aVar = r15;
            al0.a aVar5 = new al0.a(0L, 0L, false, 0, null, 31, null);
            aVar.l(al0.a.INSTANCE.b());
            AbsBusinessScene absBusinessScene2 = this.this$0;
            AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom = AbsBusinessScene.FetchAvatarInfoFrom.ON_LAUNCH;
            this.L$0 = startSpan;
            this.L$1 = startSpan2;
            this.L$2 = aVar;
            this.L$3 = aVar;
            this.label = 1;
            fetchAvatarInfo = absBusinessScene2.fetchAvatarInfo(fetchAvatarInfoFrom, this);
            if (fetchAvatarInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = startSpan2;
            aVar2 = aVar;
        }
        JSONObject jSONObject = (JSONObject) fetchAvatarInfo;
        a.Companion companion = al0.a.INSTANCE;
        aVar2.i(companion.b());
        EnumUserGender a16 = EnumUserGender.INSTANCE.a(jSONObject.optInt("gender", 0));
        this.this$0.setBodyTypeName(ZPlanAvatarResourceHelper.f105660o.l0(jSONObject));
        if (a16 == EnumUserGender.GENDER_UNINIT) {
            if (bVar != null) {
                bVar.a("gender error");
            }
            al0.a.h(aVar, 201015, null, 2, null);
            FilamentEventDispatcher dispatcher = this.this$0.getDispatcher();
            if (dispatcher != null) {
                String jSONObject2 = companion.c(aVar).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "avatarInfoStep.toJSON().toString()");
                dispatcher.onEvent("onFilamentRenderFail", jSONObject2);
            }
            return Unit.INSTANCE;
        }
        if (bVar != null) {
            bVar.b();
        }
        FilamentEventDispatcher dispatcher2 = this.this$0.getDispatcher();
        if (dispatcher2 != null) {
            String jSONObject3 = companion.c(aVar).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "avatarInfoStep.toJSON().toString()");
            dispatcher2.onEvent("onAvatarInfoReady", jSONObject3);
        }
        FLog.INSTANCE.e(AbsBusinessScene.TAG, "onLaunch avatarInfo:" + jSONObject);
        if (this.this$0.getService() == null) {
            AbsBusinessScene absBusinessScene3 = this.this$0;
            if (startSpan != null) {
                cVar3 = startSpan.c();
            } else {
                cVar3 = null;
            }
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (absBusinessScene3.loadAvatarResource(cVar3, jSONObject, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        AbsBusinessScene absBusinessScene4 = this.this$0;
        if (startSpan != null) {
            cVar2 = startSpan.c();
        } else {
            cVar2 = null;
        }
        ZPlanAvatarService service = this.this$0.getService();
        this.L$0 = startSpan;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        fetchAvatarResourceWithCpp = absBusinessScene4.fetchAvatarResourceWithCpp(cVar2, service, jSONObject, this);
        if (fetchAvatarResourceWithCpp == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar2 = startSpan;
        aVar3 = (a) fetchAvatarResourceWithCpp;
        if (aVar3 == null) {
        }
    }
}

package com.tencent.filament.zplan.business.impl;

import al0.a;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.download.ZPlanAvatarCheckResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.download.ZPlanAvatarServiceException;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/business/impl/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchAvatarResourceWithCpp$2", f = "AbsBusinessScene.kt", i = {0, 0, 0, 0, 0}, l = {388}, m = "invokeSuspend", n = {"loadAvatarResourceSpan", "fetchAllResourceStatic", "checkBootResult", "checkAvatarResult", "checkIndirectLightResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchAvatarResourceWithCpp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
    final /* synthetic */ JSONObject $avatarInfo;
    final /* synthetic */ ZPlanAvatarService $avatarService;
    final /* synthetic */ c $spanContext;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchAvatarResourceWithCpp$2(AbsBusinessScene absBusinessScene, c cVar, JSONObject jSONObject, ZPlanAvatarService zPlanAvatarService, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$spanContext = cVar;
        this.$avatarInfo = jSONObject;
        this.$avatarService = zPlanAvatarService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$fetchAvatarResourceWithCpp$2(this.this$0, this.$spanContext, this.$avatarInfo, this.$avatarService, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super a> continuation) {
        return ((AbsBusinessScene$fetchAvatarResourceWithCpp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.util.List] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List listOf;
        b startSpan;
        al0.a aVar;
        List arrayList;
        ArrayList arrayList2;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Deferred async$default4;
        List listOf2;
        Object awaitAll;
        List list;
        List plus;
        List plus2;
        Object obj2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    list = (List) this.L$4;
                    ?? r26 = (List) this.L$3;
                    arrayList = (List) this.L$2;
                    aVar = (al0.a) this.L$1;
                    startSpan = (b) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList2 = r26;
                    awaitAll = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadAvatarResource", this.$spanContext);
                EnumUserGender a16 = EnumUserGender.INSTANCE.a(this.$avatarInfo.optInt("gender", 0));
                aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                aVar.l(al0.a.INSTANCE.b());
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                async$default = BuildersKt__Builders_commonKt.async$default(this.this$0.getScope(), null, null, new AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$1(this, arrayList, null), 3, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(this.this$0.getScope(), null, null, new AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$2(this, arrayList2, null), 3, null);
                async$default3 = BuildersKt__Builders_commonKt.async$default(this.this$0.getScope(), null, null, new AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$3(this, a16, null), 3, null);
                async$default4 = BuildersKt__Builders_commonKt.async$default(this.this$0.getScope(), null, null, new AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$4(this, arrayList3, null), 3, null);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{async$default, async$default2, async$default3, async$default4});
                this.L$0 = startSpan;
                this.L$1 = aVar;
                this.L$2 = arrayList;
                this.L$3 = arrayList2;
                this.L$4 = arrayList3;
                this.label = 1;
                awaitAll = AwaitKt.awaitAll(listOf2, this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = arrayList3;
            }
            List list2 = (List) awaitAll;
            if (startSpan != null) {
                startSpan.b();
            }
            if (list2.size() != 4) {
                FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAllResource fail. allResult.size != 3");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", 400000);
                jSONObject.put("errorMessage", "allResult.size != 3");
                FilamentEventDispatcher dispatcher = this.this$0.getDispatcher();
                if (dispatcher != null) {
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "errorData.toString()");
                    dispatcher.onEvent("onFilamentRenderFail", jSONObject2);
                }
                return null;
            }
            Object obj3 = list2.get(0);
            Object obj4 = list2.get(1);
            Object obj5 = list2.get(2);
            Object obj6 = list2.get(3);
            if ((obj3 instanceof ZPlanAvatarInterfaceResult) && (obj4 instanceof ZPlanAvatarInterfaceResult) && (obj5 instanceof Object[]) && (obj6 instanceof ZPlanAvatarInterfaceResult)) {
                AbsBusinessScene absBusinessScene = this.this$0;
                plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
                plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) list);
                absBusinessScene.reportCppCheckResult(plus2);
                a.Companion companion = al0.a.INSTANCE;
                aVar.i(companion.b());
                FilamentEventDispatcher dispatcher2 = this.this$0.getDispatcher();
                if (dispatcher2 != null) {
                    String jSONObject3 = companion.c(aVar).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "fetchAllResourceStatic.toJSON().toString()");
                    dispatcher2.onEvent("onAllResourceReady", jSONObject3);
                }
                String result = ((ZPlanAvatarInterfaceResult) obj3).getResult();
                String result2 = ((ZPlanAvatarInterfaceResult) obj4).getResult();
                if (!(obj5 instanceof ZPlanAction[])) {
                    obj2 = null;
                } else {
                    obj2 = obj5;
                }
                ZPlanAction[] zPlanActionArr = (ZPlanAction[]) obj2;
                if (zPlanActionArr == null) {
                    zPlanActionArr = new ZPlanAction[0];
                }
                return new a(result, result2, zPlanActionArr, ((ZPlanAvatarInterfaceResult) obj6).getResult());
            }
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAllResource fail. return value is wrong");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("errorCode", 400000);
            jSONObject4.put("errorMessage", "return value is wrong");
            FilamentEventDispatcher dispatcher3 = this.this$0.getDispatcher();
            if (dispatcher3 != null) {
                String jSONObject5 = jSONObject4.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "errorData.toString()");
                dispatcher3.onEvent("onFilamentRenderFail", jSONObject5);
                return null;
            }
            return null;
        } catch (ZPlanAvatarServiceException e16) {
            ZPlanAvatarCheckResult checkResult = e16.getError().getCheckResult();
            if (checkResult != null) {
                AbsBusinessScene absBusinessScene2 = this.this$0;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(checkResult);
                absBusinessScene2.reportCppCheckResult(listOf);
            }
            if (startSpan != null) {
                startSpan.a(e16.toString());
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("errorCode", e16.getError().getErrorCode().getValue() + 400000);
            if (e16.getError().getCheckResult() == null) {
                jSONObject6.put("errorMessage", e16.getError().getErrorMsg());
            } else {
                jSONObject6.put("errorMessage", "errMsg:" + e16.getError().getErrorMsg() + ", checkResult:" + e16.getError().getCheckResult());
            }
            FilamentEventDispatcher dispatcher4 = this.this$0.getDispatcher();
            if (dispatcher4 != null) {
                String jSONObject7 = jSONObject6.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject7, "errorData.toString()");
                dispatcher4.onEvent("onFilamentRenderFail", jSONObject7);
                return null;
            }
            return null;
        }
    }
}

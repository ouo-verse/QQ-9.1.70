package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.download.ZPlanAvatarServiceException;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.ArrayList;
import java.util.Collection;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wx4.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchActionArrayWithCpp$2", f = "AbsBusinessScene.kt", i = {0, 0}, l = {931}, m = "invokeSuspend", n = {"statistic", "this_$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchActionArrayWithCpp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction[]>, Object> {
    final /* synthetic */ ZPlanAvatarService $avatarService;
    final /* synthetic */ EnumUserGender $gender;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchActionArrayWithCpp$2(AbsBusinessScene absBusinessScene, EnumUserGender enumUserGender, ZPlanAvatarService zPlanAvatarService, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$gender = enumUserGender;
        this.$avatarService = zPlanAvatarService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        AbsBusinessScene$fetchActionArrayWithCpp$2 absBusinessScene$fetchActionArrayWithCpp$2 = new AbsBusinessScene$fetchActionArrayWithCpp$2(this.this$0, this.$gender, this.$avatarService, completion);
        absBusinessScene$fetchActionArrayWithCpp$2.L$0 = obj;
        return absBusinessScene$fetchActionArrayWithCpp$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction[]> continuation) {
        return ((AbsBusinessScene$fetchActionArrayWithCpp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        al0.a aVar;
        Object awaitAll;
        al0.a aVar2;
        int i3;
        int i16;
        FetchActionData[] fetchActionDataArr;
        ArrayList arrayList;
        al0.a aVar3;
        ArrayList arrayList2;
        al0.a aVar4;
        Deferred async$default;
        Deferred async$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        try {
            if (i17 != 0) {
                if (i17 == 1) {
                    aVar2 = (al0.a) this.L$1;
                    al0.a aVar5 = (al0.a) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    aVar = aVar5;
                    awaitAll = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                al0.a aVar6 = new al0.a(0L, 0L, false, 0, null, 31, null);
                ArrayList arrayList3 = new ArrayList();
                FetchActionData[] actionDataArray = this.this$0.getActionDataArray(this.$gender);
                if (actionDataArray != null) {
                    int length = actionDataArray.length;
                    int i18 = 0;
                    while (i18 < length) {
                        FetchActionData fetchActionData = actionDataArray[i18];
                        if (fetchActionData.isActionIdValid$zplan_android_release()) {
                            arrayList = arrayList3;
                            i3 = i18;
                            i16 = length;
                            fetchActionDataArr = actionDataArray;
                            aVar3 = aVar6;
                            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$1(fetchActionData, null, this, coroutineScope, arrayList), 3, null);
                            arrayList.add(async$default2);
                        } else {
                            i3 = i18;
                            i16 = length;
                            fetchActionDataArr = actionDataArray;
                            arrayList = arrayList3;
                            aVar3 = aVar6;
                            if (fetchActionData.isActionPathValid$zplan_android_release()) {
                                AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2 absBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2 = new AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2(fetchActionData, null, this, coroutineScope, arrayList);
                                arrayList2 = arrayList;
                                aVar4 = aVar3;
                                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, absBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2, 3, null);
                                arrayList2.add(async$default);
                                i18 = i3 + 1;
                                arrayList3 = arrayList2;
                                aVar6 = aVar4;
                                length = i16;
                                actionDataArray = fetchActionDataArr;
                            }
                        }
                        aVar4 = aVar3;
                        arrayList2 = arrayList;
                        i18 = i3 + 1;
                        arrayList3 = arrayList2;
                        aVar6 = aVar4;
                        length = i16;
                        actionDataArray = fetchActionDataArr;
                    }
                }
                ArrayList arrayList4 = arrayList3;
                aVar = aVar6;
                aVar.l(al0.a.INSTANCE.b());
                this.L$0 = aVar;
                this.L$1 = aVar;
                this.label = 1;
                awaitAll = AwaitKt.awaitAll(arrayList4, this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar2 = aVar;
            }
            Object[] array = ((Collection) awaitAll).toArray(new ZPlanAction[0]);
            if (array != null) {
                ZPlanAction[] zPlanActionArr = (ZPlanAction[]) array;
                aVar2.i(al0.a.INSTANCE.b());
                boolean z16 = false;
                for (ZPlanAction zPlanAction : zPlanActionArr) {
                    if (zPlanAction.getDownloadFromNet()) {
                        z16 = true;
                    }
                }
                FLog.INSTANCE.i(AbsBusinessScene.TAG, "fetchActionResource, downloadFromNet: " + z16 + ", statistic:" + aVar);
                JSONObject c16 = al0.a.INSTANCE.c(aVar);
                c16.put("downloadFromNet", d.INSTANCE.b(z16));
                FilamentEventDispatcher dispatcher = this.this$0.getDispatcher();
                if (dispatcher != null) {
                    String jSONObject = c16.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
                    dispatcher.onEvent("onAnimationResourceReady", jSONObject);
                }
                return zPlanActionArr;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchActionArray fail. " + e16);
            throw e16;
        }
    }
}

package com.tencent.filament.zplan.scene.square;

import al0.a;
import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$reloadRenderObjects$2", f = "SquareMapObjectAvatar.kt", i = {0, 0}, l = {com.tencent.luggage.wxa.ci.a.CTRL_INDEX, 337}, m = "invokeSuspend", n = {"loadResourceStep", "this_$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class SquareMapObjectAvatar$reloadRenderObjects$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SquareMapObjectAvatar this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMapObjectAvatar$reloadRenderObjects$2(SquareMapObjectAvatar squareMapObjectAvatar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = squareMapObjectAvatar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        SquareMapObjectAvatar$reloadRenderObjects$2 squareMapObjectAvatar$reloadRenderObjects$2 = new SquareMapObjectAvatar$reloadRenderObjects$2(this.this$0, completion);
        squareMapObjectAvatar$reloadRenderObjects$2.L$0 = obj;
        return squareMapObjectAvatar$reloadRenderObjects$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareMapObjectAvatar$reloadRenderObjects$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FilamentUrlTemplate urlTemplate;
        SquareAvatarData squareAvatarData;
        SquareAvatarData squareAvatarData2;
        String str;
        List listOfNotNull;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        al0.a aVar;
        Object awaitAll;
        al0.a aVar2;
        Deferred async$default;
        boolean z16;
        boolean z17;
        final FilamentViewerV2305 b16;
        Object orNull;
        Object orNull2;
        Continuation intercepted;
        Object coroutine_suspended2;
        FilamentThreadHandler c16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                al0.a aVar3 = (al0.a) this.L$1;
                aVar2 = (al0.a) this.L$0;
                ResultKt.throwOnFailure(obj);
                aVar = aVar3;
                awaitAll = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                e eVar = (e) this.this$0.com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String.get();
                if (eVar != null && (urlTemplate = eVar.getUrlTemplate()) != null) {
                    al0.a aVar4 = new al0.a(0L, 0L, false, 0, null, 31, null);
                    aVar4.l(al0.a.INSTANCE.b());
                    String[] strArr = new String[2];
                    squareAvatarData = this.this$0.avatarData;
                    strArr[0] = squareAvatarData.getHost().getAvatarInfoStr();
                    squareAvatarData2 = this.this$0.avatarData;
                    SquareAvatarData.AvatarData guest = squareAvatarData2.getGuest();
                    if (guest != null) {
                        str = guest.getAvatarInfoStr();
                    } else {
                        str = null;
                    }
                    strArr[1] = str;
                    listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr);
                    List list = listOfNotNull;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.tencent.zplan.common.utils.h.f385294a.b((String) it.next()));
                    }
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        ArrayList arrayList3 = arrayList2;
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SquareMapObjectAvatar$reloadRenderObjects$2$invokeSuspend$$inlined$measure$lambda$1((JSONObject) it5.next(), null, this, coroutineScope, urlTemplate), 3, null);
                        arrayList3.add(async$default);
                        arrayList2 = arrayList3;
                        aVar4 = aVar4;
                    }
                    aVar = aVar4;
                    this.L$0 = aVar;
                    this.L$1 = aVar;
                    this.label = 1;
                    awaitAll = AwaitKt.awaitAll(arrayList2, this);
                    if (awaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar2 = aVar;
                } else {
                    return Unit.INSTANCE;
                }
            }
            List list2 = (List) awaitAll;
            aVar.i(al0.a.INSTANCE.b());
            this.this$0.statistics.setLoadAvatarResourceCost(aVar2.f());
            SquareLoadObjectStatistics squareLoadObjectStatistics = this.this$0.statistics;
            List<ReloadAvatarResourceModel> list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                for (ReloadAvatarResourceModel reloadAvatarResourceModel : list3) {
                    if (reloadAvatarResourceModel != null && reloadAvatarResourceModel.getDownloadFromNet()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (Boxing.boxBoolean(z16).booleanValue()) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            squareLoadObjectStatistics.setLoadAvatarResourceFromNet(z17);
            e eVar2 = (e) this.this$0.com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String.get();
            if (eVar2 != null && (b16 = eVar2.b()) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
                final ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) orNull;
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 1);
                final ReloadAvatarResourceModel reloadAvatarResourceModel3 = (ReloadAvatarResourceModel) orNull2;
                this.L$0 = b16;
                this.L$1 = reloadAvatarResourceModel2;
                this.L$2 = reloadAvatarResourceModel3;
                this.L$3 = this;
                this.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                e eVar3 = (e) this.this$0.com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String.get();
                if (eVar3 != null && (c16 = eVar3.c()) != null) {
                    c16.d("SquareMapObjectAvatar.reloadRenderObjects", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$reloadRenderObjects$2$invokeSuspend$$inlined$suspendCoroutine$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AvatarRenderObject avatarRenderObject;
                            AvatarRenderObject avatarRenderObject2;
                            ExtraRenderObject extraRenderObject;
                            com.tencent.zplan.zplantracing.c cVar;
                            SquareAvatarData squareAvatarData3;
                            Location location;
                            Size size;
                            com.tencent.zplan.zplantracing.c cVar2;
                            SquareAvatarData squareAvatarData4;
                            Location location2;
                            Size size2;
                            com.tencent.zplan.zplantracing.c cVar3;
                            SquareAvatarData squareAvatarData5;
                            Location location3;
                            Size size3;
                            AvatarRenderObject avatarRenderObject3;
                            ExtraRenderObject extraRenderObject2;
                            AvatarRenderObject avatarRenderObject4;
                            AvatarRenderObject avatarRenderObject5;
                            ExtraRenderObject extraRenderObject3;
                            List listOfNotNull2;
                            AtomicBoolean atomicBoolean;
                            SquareMapObjectAvatar squareMapObjectAvatar = this.this$0;
                            FilamentViewerV2305 filamentViewerV2305 = b16;
                            avatarRenderObject = squareMapObjectAvatar.hostObject;
                            avatarRenderObject2 = this.this$0.guestObject;
                            extraRenderObject = this.this$0.extraObject;
                            squareMapObjectAvatar.L(null, filamentViewerV2305, avatarRenderObject, avatarRenderObject2, extraRenderObject);
                            al0.a aVar5 = new al0.a(0L, 0L, false, 0, null, 31, null);
                            a.Companion companion = al0.a.INSTANCE;
                            aVar5.l(companion.b());
                            SquareMapObjectAvatar squareMapObjectAvatar2 = this.this$0;
                            cVar = squareMapObjectAvatar2.spanContext;
                            FilamentViewerV2305 filamentViewerV23052 = b16;
                            squareAvatarData3 = this.this$0.avatarData;
                            SquareAvatarData.AvatarData host = squareAvatarData3.getHost();
                            ReloadAvatarResourceModel reloadAvatarResourceModel4 = reloadAvatarResourceModel2;
                            location = this.this$0.location;
                            size = this.this$0.size;
                            squareMapObjectAvatar2.hostObject = squareMapObjectAvatar2.M(cVar, filamentViewerV23052, host, reloadAvatarResourceModel4, location, size);
                            SquareMapObjectAvatar squareMapObjectAvatar3 = this.this$0;
                            cVar2 = squareMapObjectAvatar3.spanContext;
                            FilamentViewerV2305 filamentViewerV23053 = b16;
                            squareAvatarData4 = this.this$0.avatarData;
                            SquareAvatarData.AvatarData guest2 = squareAvatarData4.getGuest();
                            ReloadAvatarResourceModel reloadAvatarResourceModel5 = reloadAvatarResourceModel3;
                            location2 = this.this$0.location;
                            size2 = this.this$0.size;
                            squareMapObjectAvatar3.guestObject = squareMapObjectAvatar3.M(cVar2, filamentViewerV23053, guest2, reloadAvatarResourceModel5, location2, size2);
                            SquareMapObjectAvatar squareMapObjectAvatar4 = this.this$0;
                            cVar3 = squareMapObjectAvatar4.spanContext;
                            FilamentViewerV2305 filamentViewerV23054 = b16;
                            squareAvatarData5 = this.this$0.avatarData;
                            SquareAvatarData.ExtraActorData extra = squareAvatarData5.getExtra();
                            location3 = this.this$0.location;
                            size3 = this.this$0.size;
                            squareMapObjectAvatar4.extraObject = squareMapObjectAvatar4.N(cVar3, filamentViewerV23054, extra, location3, size3);
                            Unit unit = Unit.INSTANCE;
                            aVar5.i(companion.b());
                            this.this$0.statistics.setCreateObjectCost(aVar5.f());
                            SquareLoadObjectStatistics squareLoadObjectStatistics2 = this.this$0.statistics;
                            avatarRenderObject3 = this.this$0.guestObject;
                            squareLoadObjectStatistics2.setHasGuest(avatarRenderObject3 != null);
                            SquareLoadObjectStatistics squareLoadObjectStatistics3 = this.this$0.statistics;
                            extraRenderObject2 = this.this$0.extraObject;
                            squareLoadObjectStatistics3.setHasExtra(extraRenderObject2 != null);
                            al0.a aVar6 = new al0.a(0L, 0L, false, 0, null, 31, null);
                            aVar6.l(companion.b());
                            Long[] lArr = new Long[3];
                            avatarRenderObject4 = this.this$0.hostObject;
                            lArr[0] = avatarRenderObject4 != null ? Long.valueOf(avatarRenderObject4.d()) : null;
                            avatarRenderObject5 = this.this$0.guestObject;
                            lArr[1] = avatarRenderObject5 != null ? Long.valueOf(avatarRenderObject5.d()) : null;
                            extraRenderObject3 = this.this$0.extraObject;
                            lArr[2] = extraRenderObject3 != null ? Long.valueOf(extraRenderObject3.d()) : null;
                            listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) lArr);
                            Iterator it6 = listOfNotNull2.iterator();
                            while (it6.hasNext()) {
                                b16.applyAnimation(((Number) it6.next()).longValue(), 0.0d);
                            }
                            Unit unit2 = Unit.INSTANCE;
                            aVar6.i(al0.a.INSTANCE.b());
                            this.this$0.statistics.setApplyAnimationCost(aVar6.f());
                            this.this$0.animationBeginTime = 0L;
                            atomicBoolean = this.this$0.ready;
                            atomicBoolean.set(true);
                            FLog.INSTANCE.d("SquareMapObjectAvatar", "reloadRenderObjects done");
                            Continuation.this.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                        }
                    });
                }
                Object orThrow = safeContinuation.getOrThrow();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (orThrow == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(this);
                }
                if (orThrow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } catch (Exception e16) {
            FLog.INSTANCE.e("SquareMapObjectAvatar", "fetchReloadAvatarResource failed", e16);
            return Unit.INSTANCE;
        }
    }
}

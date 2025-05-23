package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadFemaleRandomHandHeldAnim$2", f = "PortalAnimHelper.kt", i = {0}, l = {1221}, m = "invokeSuspend", n = {"loadFemaleRandomHandHeldAnimSpan"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadFemaleRandomHandHeldAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentViewerV2 $viewer;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadFemaleRandomHandHeldAnim$2(PortalAnimHelper portalAnimHelper, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, FilamentViewerV2 filamentViewerV2, Continuation<? super PortalAnimHelper$loadFemaleRandomHandHeldAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$avatarPbJson = jSONObject;
        this.$zplanSpanContext = cVar;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PortalAnimHelper$loadFemaleRandomHandHeldAnim$2 portalAnimHelper$loadFemaleRandomHandHeldAnim$2 = new PortalAnimHelper$loadFemaleRandomHandHeldAnim$2(this.this$0, this.$avatarPbJson, this.$zplanSpanContext, this.$viewer, continuation);
        portalAnimHelper$loadFemaleRandomHandHeldAnim$2.L$0 = obj;
        return portalAnimHelper$loadFemaleRandomHandHeldAnim$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HandHeldItem f06;
        boolean z16;
        List list;
        final com.tencent.zplan.zplantracing.b bVar;
        Deferred async$default;
        CopyOnWriteArrayList copyOnWriteArrayList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            f06 = this.this$0.f0(this.$avatarPbJson);
            QLog.i("PortalAnimHelper_", 1, "loadFemaleRandomHandHeldAnim start");
            if (f06 != null) {
                z16 = this.this$0.mHasHandHeldRandomAnim;
                if (z16) {
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadFemaleRandomHandHeldAnim", this.$zplanSpanContext);
                    ArrayList arrayList = new ArrayList();
                    this.this$0.mRandomHandHeldAnimPathFemale = f06.e();
                    list = this.this$0.mRandomHandHeldAnimPathFemale;
                    Intrinsics.checkNotNull(list);
                    PortalAnimHelper portalAnimHelper = this.this$0;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PortalAnimHelper$loadFemaleRandomHandHeldAnim$2$1$randomFemaleActionJob$1(portalAnimHelper, startSpan, (AnimPath) it.next(), null), 3, null);
                        arrayList.add(async$default);
                    }
                    this.L$0 = startSpan;
                    this.label = 1;
                    obj = AwaitKt.awaitAll(arrayList, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bVar = startSpan;
                }
            }
            QLog.i("PortalAnimHelper_", 1, "do not contains handHeldItem female item or do not has hand held random anim");
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            bVar = (com.tencent.zplan.zplantracing.b) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object[] array = ((Collection) obj).toArray(new ZPlanAction[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final ArrayList arrayList2 = new ArrayList();
        for (ZPlanAction zPlanAction : (ZPlanAction[]) array) {
            if (zPlanAction != null) {
                arrayList2.add(zPlanAction);
            }
        }
        if (arrayList2.isEmpty()) {
            copyOnWriteArrayList = this.this$0.mRandomHandHeldAnimFemaleList;
            copyOnWriteArrayList.clear();
            if (bVar != null) {
                bVar.a("validActionList is empty");
            }
            return Unit.INSTANCE;
        }
        i mTaskExecutor = this.this$0.getMTaskExecutor();
        if (mTaskExecutor != null) {
            final PortalAnimHelper portalAnimHelper2 = this.this$0;
            final FilamentViewerV2 filamentViewerV2 = this.$viewer;
            mTaskExecutor.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadFemaleRandomHandHeldAnim$2.2
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
                    CopyOnWriteArrayList copyOnWriteArrayList2;
                    CopyOnWriteArrayList copyOnWriteArrayList3;
                    PortalAnimHelper portalAnimHelper3 = PortalAnimHelper.this;
                    FilamentViewerV2 filamentViewerV22 = filamentViewerV2;
                    Object[] array2 = arrayList2.toArray(new ZPlanAction[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    ZPlanAction[] zPlanActionArr = (ZPlanAction[]) array2;
                    com.tencent.zplan.zplantracing.b bVar2 = bVar;
                    com.tencent.filament.zplan.animation.b q16 = portalAnimHelper3.q1(filamentViewerV22, zPlanActionArr, bVar2 != null ? bVar2.c() : null);
                    copyOnWriteArrayList2 = PortalAnimHelper.this.mRandomHandHeldAnimFemaleList;
                    copyOnWriteArrayList2.clear();
                    copyOnWriteArrayList3 = PortalAnimHelper.this.mRandomHandHeldAnimFemaleList;
                    copyOnWriteArrayList3.add(q16);
                    QLog.i("PortalAnimHelper_", 1, "loadFemaleRandomHandHeldAnim end");
                    com.tencent.zplan.zplantracing.b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.b();
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadFemaleRandomHandHeldAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

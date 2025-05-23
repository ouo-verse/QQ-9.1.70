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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadFemaleRandomAnim$2", f = "PortalAnimHelper.kt", i = {0}, l = {1174}, m = "invokeSuspend", n = {"loadFemaleInitHandHeldAnimSpan"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadFemaleRandomAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilamentViewerV2 $viewer;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadFemaleRandomAnim$2(PortalAnimHelper portalAnimHelper, com.tencent.zplan.zplantracing.c cVar, FilamentViewerV2 filamentViewerV2, Continuation<? super PortalAnimHelper$loadFemaleRandomAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$zplanSpanContext = cVar;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PortalAnimHelper$loadFemaleRandomAnim$2 portalAnimHelper$loadFemaleRandomAnim$2 = new PortalAnimHelper$loadFemaleRandomAnim$2(this.this$0, this.$zplanSpanContext, this.$viewer, continuation);
        portalAnimHelper$loadFemaleRandomAnim$2.L$0 = obj;
        return portalAnimHelper$loadFemaleRandomAnim$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        final com.tencent.zplan.zplantracing.b bVar;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            arrayList = this.this$0.mDefaultRandomAnimFemaleList;
            int size = arrayList.size();
            QLog.i("PortalAnimHelper_", 1, "loadFemaleRandomAnim start size:" + size);
            if (size > 0) {
                return Unit.INSTANCE;
            }
            com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadFemaleRandomAnim", this.$zplanSpanContext);
            ArrayList arrayList2 = new ArrayList();
            List<AnimPath> c16 = g.f370004a.c();
            PortalAnimHelper portalAnimHelper = this.this$0;
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PortalAnimHelper$loadFemaleRandomAnim$2$1$randomFemaleActionJob$1(portalAnimHelper, startSpan, (AnimPath) it.next(), null), 3, null);
                arrayList2.add(async$default);
            }
            this.L$0 = startSpan;
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = startSpan;
        } else if (i3 == 1) {
            bVar = (com.tencent.zplan.zplantracing.b) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object[] array = ((Collection) obj).toArray(new ZPlanAction[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final ArrayList arrayList3 = new ArrayList();
        for (ZPlanAction zPlanAction : (ZPlanAction[]) array) {
            if (zPlanAction != null) {
                arrayList3.add(zPlanAction);
            }
        }
        if (arrayList3.isEmpty()) {
            if (bVar != null) {
                bVar.a("validActionList is empty");
            }
            return Unit.INSTANCE;
        }
        i mTaskExecutor = this.this$0.getMTaskExecutor();
        if (mTaskExecutor != null) {
            final PortalAnimHelper portalAnimHelper2 = this.this$0;
            final FilamentViewerV2 filamentViewerV2 = this.$viewer;
            mTaskExecutor.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadFemaleRandomAnim$2.2
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
                    ArrayList arrayList4;
                    PortalAnimHelper portalAnimHelper3 = PortalAnimHelper.this;
                    FilamentViewerV2 filamentViewerV22 = filamentViewerV2;
                    Object[] array2 = arrayList3.toArray(new ZPlanAction[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    ZPlanAction[] zPlanActionArr = (ZPlanAction[]) array2;
                    com.tencent.zplan.zplantracing.b bVar2 = bVar;
                    com.tencent.filament.zplan.animation.b q16 = portalAnimHelper3.q1(filamentViewerV22, zPlanActionArr, bVar2 != null ? bVar2.c() : null);
                    arrayList4 = PortalAnimHelper.this.mDefaultRandomAnimFemaleList;
                    arrayList4.add(q16);
                    QLog.i("PortalAnimHelper_", 1, "loadFemaleRandomAnim end");
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
        return ((PortalAnimHelper$loadFemaleRandomAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

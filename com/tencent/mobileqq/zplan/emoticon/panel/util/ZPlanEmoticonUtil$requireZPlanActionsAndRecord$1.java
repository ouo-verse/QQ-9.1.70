package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1", f = "ZPlanEmoticonUtil.kt", i = {}, l = {1009}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseApplication $context;
    final /* synthetic */ Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> $job;
    final /* synthetic */ int $limit;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FlowCollector<Panel> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f333229d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f333230e;

        public a(int i3, Ref.ObjectRef objectRef) {
            this.f333229d = i3;
            this.f333230e = objectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Panel panel, Continuation<? super Unit> continuation) {
            List<ZPlanActionInfo> v3;
            Object coroutine_suspended;
            Panel panel2 = panel;
            com.tencent.mobileqq.zplan.aio.panel.page.a a16 = com.tencent.mobileqq.zplan.aio.panel.page.a.INSTANCE.a(panel2);
            if (a16 != null && (v3 = a16.v()) != null) {
                QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "requireZPlanActionsAndRecord onResp, dataSource=" + panel2.getDataSource() + ", size=" + v3.size());
                int i3 = this.f333229d;
                if (i3 > 0) {
                    v3 = CollectionsKt___CollectionsKt.take(v3, i3);
                }
                if (v3.isEmpty()) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    Object i16 = CorountineFunKt.i(i.a.f261779e, null, null, new ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1(v3, this.f333230e, null), continuation, 6, null);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (i16 == coroutine_suspended) {
                        return i16;
                    }
                }
            } else {
                Unit unit2 = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1(CoroutineScope coroutineScope, BaseApplication baseApplication, int i3, Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> objectRef, Continuation<? super ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$context = baseApplication;
        this.$limit = i3;
        this.$job = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1(this.$scope, this.$context, this.$limit, this.$job, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Panel.Companion companion = Panel.INSTANCE;
            CoroutineScope coroutineScope = this.$scope;
            BaseApplication baseApplication = this.$context;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmoticonPageBuilder(this.$scope, this.$context, null, 4, null));
            StateFlow h16 = Panel.Companion.h(companion, coroutineScope, baseApplication, listOf, false, null, 16, null);
            a aVar = new a(this.$limit, this.$job);
            this.label = 1;
            if (h16.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

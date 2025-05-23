package com.tencent.mobileqq.zplan.emoticon.tab.manager;

import com.tencent.image.URLImageView;
import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.a;
import com.tencent.mobileqq.zplan.aio.panel.panel.DataSource;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.utils.FlowUtilKt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1", f = "ZPlanEmoticonTabAvatarManager.kt", i = {}, l = {244, 267}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> $qJob;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ WeakReference<URLImageView> $tabImageViewRef;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1$2", f = "ZPlanEmoticonTabAvatarManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Panel>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getZPlanEmoticonActionUpdateStatus getZPlanActions onCompletion");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super Panel> flowCollector, Throwable th5, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1(CoroutineScope coroutineScope, WeakReference<URLImageView> weakReference, Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> objectRef, Continuation<? super ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$tabImageViewRef = weakReference;
        this.$qJob = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1(this.$scope, this.$tabImageViewRef, this.$qJob, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            BaseApplication context = BaseApplication.context;
            Panel.Companion companion = Panel.INSTANCE;
            CoroutineScope coroutineScope = this.$scope;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmoticonPageBuilder(this.$scope, context, null, 4, null));
            StateFlow h16 = Panel.Companion.h(companion, coroutineScope, context, listOf, true, null, 16, null);
            final WeakReference<URLImageView> weakReference = this.$tabImageViewRef;
            final Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> objectRef = this.$qJob;
            Function2<Panel, Panel, Unit> function2 = new Function2<Panel, Panel, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Panel panel, Panel panel2) {
                    invoke2(panel, panel2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Panel old, Panel panel) {
                    com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
                    Job f16;
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(panel, "new");
                    a.Companion companion2 = com.tencent.mobileqq.zplan.aio.panel.page.a.INSTANCE;
                    com.tencent.mobileqq.zplan.aio.panel.page.a a16 = companion2.a(old);
                    com.tencent.mobileqq.zplan.aio.panel.page.a a17 = companion2.a(panel);
                    QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "source onChange, old: " + old.getDataSource() + " -> " + (a16 != null ? a16.getSequence() : null) + ", new: " + panel.getDataSource() + " -> " + (a17 != null ? a17.getSequence() : null));
                    DataSource dataSource = panel.getDataSource();
                    DataSource dataSource2 = DataSource.Backend;
                    if (dataSource == dataSource2 && a17 != null) {
                        if (!Intrinsics.areEqual(a17.getSequence(), a16 != null ? a16.getSequence() : null)) {
                            QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "mark need shake and try shaking");
                            ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager = ZPlanEmoticonTabAvatarManager.f333345a;
                            zPlanEmoticonTabAvatarManager.S(true);
                            URLImageView uRLImageView = weakReference.get();
                            if (uRLImageView != null && uRLImageView.getDrawable() != null && ZPlanEmoticonUtil.f333176e.H()) {
                                zPlanEmoticonTabAvatarManager.P(uRLImageView);
                            } else {
                                QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "try shaking but tabImageView is null or panel is hide");
                            }
                        }
                    }
                    if (panel.getDataSource() != dataSource2 || (bVar = objectRef.element) == null || (f16 = bVar.f()) == null) {
                        return;
                    }
                    Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
                }
            };
            this.label = 1;
            obj = FlowUtilKt.b(h16, function2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Flow onCompletion = FlowKt.onCompletion((Flow) obj, new AnonymousClass2(null));
        this.label = 2;
        if (FlowKt.collect(onCompletion, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

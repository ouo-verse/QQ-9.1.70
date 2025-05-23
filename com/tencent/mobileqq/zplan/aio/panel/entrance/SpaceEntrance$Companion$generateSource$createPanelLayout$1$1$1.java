package com.tencent.mobileqq.zplan.aio.panel.entrance;

import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter;
import com.tencent.mobileqq.zplan.utils.FlowUtilKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1", f = "SpaceEntrance.kt", i = {}, l = {61, 162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PanelAdapter $adapter;
    final /* synthetic */ StateFlow<Panel> $source;
    int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements FlowCollector<Panel> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PanelAdapter f331117d;

        public a(PanelAdapter panelAdapter) {
            this.f331117d = panelAdapter;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Panel panel, Continuation<? super Unit> continuation) {
            this.f331117d.notifyDataSetChanged();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1(StateFlow<Panel> stateFlow, PanelAdapter panelAdapter, Continuation<? super SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1> continuation) {
        super(2, continuation);
        this.$source = stateFlow;
        this.$adapter = panelAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1(this.$source, this.$adapter, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<Panel> stateFlow = this.$source;
            AnonymousClass1 anonymousClass1 = new Function2<Panel, Panel, Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Panel panel, Panel panel2) {
                    invoke2(panel, panel2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Panel old, Panel panel) {
                    Object orNull;
                    Object orNull2;
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(panel, "new");
                    int i16 = 0;
                    for (Object obj2 : panel.b()) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        Page page = (Page) obj2;
                        orNull = CollectionsKt___CollectionsKt.getOrNull(old.b(), i16);
                        Page page2 = (Page) orNull;
                        page.u(page2 != null ? page2.getIsTabSelected() : false);
                        orNull2 = CollectionsKt___CollectionsKt.getOrNull(old.b(), i16);
                        Page page3 = (Page) orNull2;
                        page.t(page3 != null ? page3.n() : false);
                        i16 = i17;
                    }
                }
            };
            this.label = 1;
            obj = FlowUtilKt.b(stateFlow, anonymousClass1, this);
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
        a aVar = new a(this.$adapter);
        this.label = 2;
        if (((Flow) obj).collect(aVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpaceEntrance$Companion$generateSource$createPanelLayout$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

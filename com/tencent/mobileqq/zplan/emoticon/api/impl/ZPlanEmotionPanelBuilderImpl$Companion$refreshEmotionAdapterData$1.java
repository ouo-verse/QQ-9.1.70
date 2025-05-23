package com.tencent.mobileqq.zplan.emoticon.api.impl;

import android.content.Context;
import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter;
import com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager;
import com.tencent.mobileqq.zplan.emoticon.tab.model.ZPlanEmoticonAvatarIconStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.api.impl.ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1", f = "ZPlanEmotionPanelBuilderImpl.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WeakReference<ZPlanEmoticonAdapter> $adapterRef;
    final /* synthetic */ Context $context;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FlowCollector<Panel> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f333106d;

        public a(WeakReference weakReference) {
            this.f333106d = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Panel panel, Continuation<? super Unit> continuation) {
            Panel panel2 = panel;
            ZPlanEmoticonAdapter zPlanEmoticonAdapter = (ZPlanEmoticonAdapter) this.f333106d.get();
            if (zPlanEmoticonAdapter != null) {
                Intrinsics.checkNotNullExpressionValue(zPlanEmoticonAdapter, "adapterRef.get() ?: return@collect");
                com.tencent.mobileqq.zplan.aio.panel.page.a a16 = com.tencent.mobileqq.zplan.aio.panel.page.a.INSTANCE.a(panel2);
                if (a16 != null && (!a16.v().isEmpty())) {
                    zPlanEmoticonAdapter.M(a16.v());
                    zPlanEmoticonAdapter.notifyDataSetChanged();
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1(CoroutineScope coroutineScope, Context context, WeakReference<ZPlanEmoticonAdapter> weakReference, Continuation<? super ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$context = context;
        this.$adapterRef = weakReference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1(this.$scope, this.$context, this.$adapterRef, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z16 = ZPlanEmoticonTabAvatarManager.f333345a.D(false) != ZPlanEmoticonAvatarIconStatus.AvatarIconWithShaking;
            Panel.Companion companion = Panel.INSTANCE;
            CoroutineScope coroutineScope = this.$scope;
            Context context = this.$context;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmoticonPageBuilder(this.$scope, this.$context, null, 4, null));
            StateFlow h16 = Panel.Companion.h(companion, coroutineScope, context, listOf, z16, null, 16, null);
            a aVar = new a(this.$adapterRef);
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
}

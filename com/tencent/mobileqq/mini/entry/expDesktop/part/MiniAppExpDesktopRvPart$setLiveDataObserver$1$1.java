package com.tencent.mobileqq.mini.entry.expDesktop.part;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopIntent;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setLiveDataObserver$1$1", f = "MiniAppExpDesktopRvPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRvPart$setLiveDataObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppExpDesktopRvPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppExpDesktopRvPart$setLiveDataObserver$1$1(MiniAppExpDesktopRvPart miniAppExpDesktopRvPart, Continuation<? super MiniAppExpDesktopRvPart$setLiveDataObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppExpDesktopRvPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppExpDesktopRvPart$setLiveDataObserver$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<GetAppListV2Scene> isPreloadInfo = this.this$0.getMMiniAppDesktopViewModel().isPreloadInfo();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppExpDesktopRvPart miniAppExpDesktopRvPart = this.this$0;
            final Function1<GetAppListV2Scene, Unit> function1 = new Function1<GetAppListV2Scene, Unit>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setLiveDataObserver$1$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetAppListV2Scene getAppListV2Scene) {
                    invoke2(getAppListV2Scene);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GetAppListV2Scene it) {
                    MiniAppExpDesktopRvPart miniAppExpDesktopRvPart2 = MiniAppExpDesktopRvPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    miniAppExpDesktopRvPart2.preloadMiniAppInfo(it);
                }
            };
            isPreloadInfo.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            LiveData<Boolean> isDesktopOpen = this.this$0.getMMiniAppDesktopViewModel().isDesktopOpen();
            LifecycleOwner lifecycleOwner2 = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppExpDesktopRvPart miniAppExpDesktopRvPart2 = this.this$0;
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setLiveDataObserver$1$1.2

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setLiveDataObserver$1$1$2$1", f = "MiniAppExpDesktopRvPart.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setLiveDataObserver$1$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ MiniAppExpDesktopRvPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MiniAppExpDesktopRvPart miniAppExpDesktopRvPart, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = miniAppExpDesktopRvPart;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            MiniAppExpDesktopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
                            MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData getMiniAppDesktopNetworkData = new MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData(false, GetAppListV2Scene.DROP_DOWN);
                            this.label = 1;
                            if (mMiniAppDesktopViewModel.sendUserIntent(getMiniAppDesktopNetworkData, this) == coroutine_suspended) {
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
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final Boolean bool) {
                    RFWConcatAdapter rFWConcatAdapter;
                    QLog.d(MiniAppExpDesktopRvPart.this.getTAG(), 1, "DesktopOpen:" + bool);
                    rFWConcatAdapter = MiniAppExpDesktopRvPart.this.mRvConcatAdapter;
                    if (rFWConcatAdapter == null) {
                        QLog.d(MiniAppExpDesktopRvPart.this.getTAG(), 1, "mRvConcatAdapter == null, not init finish");
                    }
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        MiniAppExpDesktopRvPart.this.firstOpenDesktopPreLoad();
                        MiniAppExpDesktopRvPart.this.doDelayRefreshRv();
                        LifecycleOwner lifecycleOwner3 = MiniAppExpDesktopRvPart.this.getPartHost().getLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner3), null, null, new AnonymousClass1(MiniAppExpDesktopRvPart.this, null), 3, null);
                        MiniAppExpDesktopRvPart.this.teenagerTipViewModuleExpDtReport();
                    }
                    MiniAppExpDesktopRvPart.this.getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart.setLiveDataObserver.1.1.2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppExpDesktopEffect invoke() {
                            Boolean it = bool;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            return new MiniAppExpDesktopEffect.DesktopOpenChanged(it.booleanValue());
                        }
                    });
                }
            };
            isDesktopOpen.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            QLog.i(this.this$0.getTAG(), 1, "setLiveDataObserver()");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppExpDesktopRvPart$setLiveDataObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

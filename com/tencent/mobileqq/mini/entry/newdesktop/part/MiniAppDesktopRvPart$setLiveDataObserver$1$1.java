package com.tencent.mobileqq.mini.entry.newdesktop.part;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1", f = "MiniAppDesktopRvPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopRvPart$setLiveDataObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppDesktopRvPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ MiniAppDesktopRvPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MiniAppDesktopRvPart miniAppDesktopRvPart) {
            super(1);
            this.this$0 = miniAppDesktopRvPart;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(MiniAppDesktopRvPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniAppOnce();
            MiniAppDragHelper.INSTANCE.preloadDragHelperClass();
            this$0.preloadMiniAppSearchHistoryKey();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            QLog.d(this.this$0.getTAG(), 1, "StartAppFirstOpenDesktop:" + bool);
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                final MiniAppDesktopRvPart miniAppDesktopRvPart = this.this$0;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppDesktopRvPart$setLiveDataObserver$1$1.AnonymousClass1.invoke$lambda$0(MiniAppDesktopRvPart.this);
                    }
                }, 16, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopRvPart$setLiveDataObserver$1$1(MiniAppDesktopRvPart miniAppDesktopRvPart, Continuation<? super MiniAppDesktopRvPart$setLiveDataObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopRvPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopRvPart$setLiveDataObserver$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<Boolean> isStartAppFirstOpenDesktop = this.this$0.getMMiniAppDesktopViewModel().isStartAppFirstOpenDesktop();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            isStartAppFirstOpenDesktop.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            LiveData<Boolean> isUserAccountFirstOpen = this.this$0.getMMiniAppDesktopViewModel().isUserAccountFirstOpen();
            LifecycleOwner lifecycleOwner2 = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopRvPart miniAppDesktopRvPart = this.this$0;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1.2

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1$2$1", f = "MiniAppDesktopRvPart.kt", i = {}, l = {109, 110}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ MiniAppDesktopRvPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MiniAppDesktopRvPart miniAppDesktopRvPart, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = miniAppDesktopRvPart;
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
                            MiniAppDeskTopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
                            MiniAppDeskTopIntent.GetMiniAppDesktopLocalData getMiniAppDesktopLocalData = MiniAppDeskTopIntent.GetMiniAppDesktopLocalData.INSTANCE;
                            this.label = 1;
                            if (mMiniAppDesktopViewModel.sendUserIntent(getMiniAppDesktopLocalData, this) == coroutine_suspended) {
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
                        MiniAppDeskTopViewModel mMiniAppDesktopViewModel2 = this.this$0.getMMiniAppDesktopViewModel();
                        MiniAppDeskTopIntent.RegisterMiniAppRedDotObserverEvent registerMiniAppRedDotObserverEvent = MiniAppDeskTopIntent.RegisterMiniAppRedDotObserverEvent.INSTANCE;
                        this.label = 2;
                        if (mMiniAppDesktopViewModel2.sendUserIntent(registerMiniAppRedDotObserverEvent, this) == coroutine_suspended) {
                            return coroutine_suspended;
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
                public final void invoke2(Boolean bool) {
                    RFWConcatAdapter rFWConcatAdapter;
                    RFWConcatAdapter rFWConcatAdapter2;
                    QLog.d(MiniAppDesktopRvPart.this.getTAG(), 1, "UserAccountFirstOpen:" + bool);
                    rFWConcatAdapter = MiniAppDesktopRvPart.this.mRvConcatAdapter;
                    if (rFWConcatAdapter == null) {
                        QLog.d(MiniAppDesktopRvPart.this.getTAG(), 1, "mRvConcatAdapter == null, not init finish");
                    }
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        rFWConcatAdapter2 = MiniAppDesktopRvPart.this.mRvConcatAdapter;
                        if (rFWConcatAdapter2 != null) {
                            LifecycleOwner lifecycleOwner3 = MiniAppDesktopRvPart.this.getPartHost().getLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner3), null, null, new AnonymousClass1(MiniAppDesktopRvPart.this, null), 3, null);
                        }
                    }
                }
            };
            isUserAccountFirstOpen.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            LiveData<Boolean> isDesktopOpen = this.this$0.getMMiniAppDesktopViewModel().isDesktopOpen();
            LifecycleOwner lifecycleOwner3 = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopRvPart miniAppDesktopRvPart2 = this.this$0;
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1.3

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1$3$1", f = "MiniAppDesktopRvPart.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1$3$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ MiniAppDesktopRvPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MiniAppDesktopRvPart miniAppDesktopRvPart, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = miniAppDesktopRvPart;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        boolean z16;
                        GetAppListV2Scene getAppListV2Scene;
                        boolean z17;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            z16 = this.this$0.mIsAccountChanged;
                            if (z16) {
                                getAppListV2Scene = GetAppListV2Scene.ACCOUNT_CHANGE;
                            } else {
                                getAppListV2Scene = GetAppListV2Scene.DROP_DOWN;
                            }
                            MiniAppDeskTopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
                            z17 = this.this$0.mIsNeedForceRequest;
                            MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData getMiniAppDesktopNetworkData = new MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData(z17, getAppListV2Scene);
                            this.label = 1;
                            if (mMiniAppDesktopViewModel.sendUserIntent(getMiniAppDesktopNetworkData, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        this.this$0.mIsNeedForceRequest = false;
                        this.this$0.getMMiniAppDesktopViewModel().setAccountChange(false);
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
                public final void invoke2(Boolean bool) {
                    RFWConcatAdapter rFWConcatAdapter;
                    RFWConcatAdapter rFWConcatAdapter2;
                    QLog.d(MiniAppDesktopRvPart.this.getTAG(), 1, "DesktopOpen:" + bool);
                    rFWConcatAdapter = MiniAppDesktopRvPart.this.mRvConcatAdapter;
                    if (rFWConcatAdapter == null) {
                        QLog.d(MiniAppDesktopRvPart.this.getTAG(), 1, "mRvConcatAdapter == null, not init finish");
                    }
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        rFWConcatAdapter2 = MiniAppDesktopRvPart.this.mRvConcatAdapter;
                        if (rFWConcatAdapter2 != null) {
                            LifecycleOwner lifecycleOwner4 = MiniAppDesktopRvPart.this.getPartHost().getLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "partHost.hostLifecycleOwner");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner4), null, null, new AnonymousClass1(MiniAppDesktopRvPart.this, null), 3, null);
                        }
                    }
                }
            };
            isDesktopOpen.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            LiveData<Boolean> isAccountChange = this.this$0.getMMiniAppDesktopViewModel().isAccountChange();
            LifecycleOwner lifecycleOwner4 = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopRvPart miniAppDesktopRvPart3 = this.this$0;
            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setLiveDataObserver$1$1.4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    MiniAppDesktopRvPart.this.mIsAccountChanged = Intrinsics.areEqual(bool, Boolean.TRUE);
                }
            };
            isAccountChange.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.x
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
        return ((MiniAppDesktopRvPart$setLiveDataObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

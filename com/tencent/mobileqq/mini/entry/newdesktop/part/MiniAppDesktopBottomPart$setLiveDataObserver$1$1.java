package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$setLiveDataObserver$1$1", f = "MiniAppDesktopBottomPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopBottomPart$setLiveDataObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppDesktopBottomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopBottomPart$setLiveDataObserver$1$1(MiniAppDesktopBottomPart miniAppDesktopBottomPart, Continuation<? super MiniAppDesktopBottomPart$setLiveDataObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopBottomPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopBottomPart$setLiveDataObserver$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<Boolean> isStartAppFirstOpenDesktop = this.this$0.getMMiniAppDesktopViewModel().isStartAppFirstOpenDesktop();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopBottomPart miniAppDesktopBottomPart = this.this$0;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$setLiveDataObserver$1$1.1
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
                    QLog.d(MiniAppDesktopBottomPart.this.getTAG(), 1, "StartAppFirstOpenDesktop:" + bool);
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        MiniAppDesktopBottomPart.this.initCollapseDesktopBlurView();
                    }
                }
            };
            isStartAppFirstOpenDesktop.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            LiveData<Boolean> isDesktopOpen = this.this$0.getMMiniAppDesktopViewModel().isDesktopOpen();
            LifecycleOwner lifecycleOwner2 = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopBottomPart miniAppDesktopBottomPart2 = this.this$0;
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$setLiveDataObserver$1$1.2
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
                    if (SimpleModeHelper.C() && (MiniAppDesktopBottomPart.this.getPartHost() instanceof MiniAppDesktopPartHost)) {
                        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                            IPartHost partHost = MiniAppDesktopBottomPart.this.getPartHost();
                            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
                            View tabHostDivider = ((MiniAppDesktopPartHost) partHost).getTabHostDivider();
                            if (tabHostDivider == null) {
                                return;
                            }
                            tabHostDivider.setVisibility(8);
                            return;
                        }
                        IPartHost partHost2 = MiniAppDesktopBottomPart.this.getPartHost();
                        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
                        View tabHostDivider2 = ((MiniAppDesktopPartHost) partHost2).getTabHostDivider();
                        if (tabHostDivider2 == null) {
                            return;
                        }
                        tabHostDivider2.setVisibility(0);
                        return;
                    }
                    QLog.d(MiniAppDesktopBottomPart.this.getTAG(), 1, "not need show tab host divider!");
                }
            };
            isDesktopOpen.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            QLog.i(this.this$0.getTAG(), 1, "setLiveDataObserver");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppDesktopBottomPart$setLiveDataObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.mini.entry.newdesktop.part;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
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
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1", f = "MiniAppDesktopSubLayoutPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppDesktopSubLayoutPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1(MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart, Continuation<? super MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopSubLayoutPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<Boolean> isUserAccountFirstOpen = this.this$0.getMMiniAppDesktopViewModel().isUserAccountFirstOpen();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart = this.this$0;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1.1
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
                    QLog.d(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, "UserAccountFirstOpen:" + bool);
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        MiniAppDesktopSubLayoutPart.this.initMiniAppSubPageUI();
                    }
                }
            };
            isUserAccountFirstOpen.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ac
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
        return ((MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

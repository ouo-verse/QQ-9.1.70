package com.tencent.mobileqq.mini.entry.newdesktop.part;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopTitlePart$setLiveDataObserver$1$1;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopTitlePart$setLiveDataObserver$1$1", f = "MiniAppDesktopTitlePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopTitlePart$setLiveDataObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppDesktopTitlePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopTitlePart$setLiveDataObserver$1$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ MiniAppDesktopTitlePart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MiniAppDesktopTitlePart miniAppDesktopTitlePart) {
            super(1);
            this.this$0 = miniAppDesktopTitlePart;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(MiniAppDesktopTitlePart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setNotificationRedDotListener();
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
                final MiniAppDesktopTitlePart miniAppDesktopTitlePart = this.this$0;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ai
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppDesktopTitlePart$setLiveDataObserver$1$1.AnonymousClass1.invoke$lambda$0(MiniAppDesktopTitlePart.this);
                    }
                }, 16, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopTitlePart$setLiveDataObserver$1$1(MiniAppDesktopTitlePart miniAppDesktopTitlePart, Continuation<? super MiniAppDesktopTitlePart$setLiveDataObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopTitlePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopTitlePart$setLiveDataObserver$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<Boolean> isStartAppFirstOpenDesktop = this.this$0.getMMiniAppDesktopViewModel().isStartAppFirstOpenDesktop();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            isStartAppFirstOpenDesktop.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ag
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            LiveData<Boolean> isUserAccountFirstOpen = this.this$0.getMMiniAppDesktopViewModel().isUserAccountFirstOpen();
            LifecycleOwner lifecycleOwner2 = this.this$0.getPartHost().getLifecycleOwner();
            final MiniAppDesktopTitlePart miniAppDesktopTitlePart = this.this$0;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopTitlePart$setLiveDataObserver$1$1.2
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
                    QLog.d(MiniAppDesktopTitlePart.this.getTAG(), 1, "UserAccountFirstOpen:" + bool);
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        MiniAppDesktopTitlePart.this.setTitleViewInfo();
                    }
                }
            };
            isUserAccountFirstOpen.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ah
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
        return ((MiniAppDesktopTitlePart$setLiveDataObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel", f = "MiniAppDesktopBaseViewModel.kt", i = {0}, l = {63}, m = "sendUserIntent", n = {"this"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class MiniAppDesktopBaseViewModel$sendUserIntent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniAppDesktopBaseViewModel<S, I> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopBaseViewModel$sendUserIntent$1(MiniAppDesktopBaseViewModel<S, I> miniAppDesktopBaseViewModel, Continuation<? super MiniAppDesktopBaseViewModel$sendUserIntent$1> continuation) {
        super(continuation);
        this.this$0 = miniAppDesktopBaseViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendUserIntent(null, this);
    }
}

package com.tencent.mobileqq.qwallet.pet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup", f = "QWalletPetStartup.kt", i = {1, 1, 4}, l = {78, 84, 89, 92, 95, 96, 99, 102}, m = "nextStep", n = {"this", "currentStep", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes16.dex */
public final class QWalletPetStartup$nextStep$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QWalletPetStartup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletPetStartup$nextStep$1(QWalletPetStartup qWalletPetStartup, Continuation<? super QWalletPetStartup$nextStep$1> continuation) {
        super(continuation);
        this.this$0 = qWalletPetStartup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object e16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e16 = this.this$0.e(null, false, null, this);
        return e16;
    }
}

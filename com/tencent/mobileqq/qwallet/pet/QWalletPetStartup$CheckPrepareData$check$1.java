package com.tencent.mobileqq.qwallet.pet;

import com.tencent.mobileqq.qwallet.pet.QWalletPetStartup;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$CheckPrepareData", f = "QWalletPetStartup.kt", i = {0}, l = {199}, m = "check", n = {"this"}, s = {"L$0"})
/* loaded from: classes16.dex */
public final class QWalletPetStartup$CheckPrepareData$check$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QWalletPetStartup.CheckPrepareData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletPetStartup$CheckPrepareData$check$1(QWalletPetStartup.CheckPrepareData checkPrepareData, Continuation<? super QWalletPetStartup$CheckPrepareData$check$1> continuation) {
        super(continuation);
        this.this$0 = checkPrepareData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}

package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSProfileTroopViewModel", f = "QFSProfileTroopViewModel.kt", i = {}, l = {170}, m = "checkTroopBindPermission", n = {}, s = {})
/* loaded from: classes4.dex */
public final class QFSProfileTroopViewModel$checkTroopBindPermission$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QFSProfileTroopViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSProfileTroopViewModel$checkTroopBindPermission$1(QFSProfileTroopViewModel qFSProfileTroopViewModel, Continuation<? super QFSProfileTroopViewModel$checkTroopBindPermission$1> continuation) {
        super(continuation);
        this.this$0 = qFSProfileTroopViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object b26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        b26 = this.this$0.b2(null, 0, this);
        return b26;
    }
}

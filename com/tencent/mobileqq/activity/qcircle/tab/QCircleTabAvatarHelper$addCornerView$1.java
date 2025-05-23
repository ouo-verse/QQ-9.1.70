package com.tencent.mobileqq.activity.qcircle.tab;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper", f = "QCircleTabAvatarHelper.kt", i = {0, 0, 0, 0}, l = {382, 394}, m = "addCornerView", n = {"this", "$this$addCornerView", "redCornerInfo", "withAnimation"}, s = {"L$0", "L$1", "L$2", "Z$0"})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$addCornerView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QCircleTabAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabAvatarHelper$addCornerView$1(QCircleTabAvatarHelper qCircleTabAvatarHelper, Continuation<? super QCircleTabAvatarHelper$addCornerView$1> continuation) {
        super(continuation);
        this.this$0 = qCircleTabAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object t16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        t16 = this.this$0.t(null, null, false, false, this);
        return t16;
    }
}

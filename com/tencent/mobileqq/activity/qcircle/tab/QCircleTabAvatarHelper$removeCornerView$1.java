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
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper", f = "QCircleTabAvatarHelper.kt", i = {0, 0}, l = {367}, m = "removeCornerView", n = {"$this$removeCornerView", "lastCornerView"}, s = {"L$0", "L$1"})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$removeCornerView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QCircleTabAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabAvatarHelper$removeCornerView$1(QCircleTabAvatarHelper qCircleTabAvatarHelper, Continuation<? super QCircleTabAvatarHelper$removeCornerView$1> continuation) {
        super(continuation);
        this.this$0 = qCircleTabAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object G;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        G = this.this$0.G(null, false, this);
        return G;
    }
}

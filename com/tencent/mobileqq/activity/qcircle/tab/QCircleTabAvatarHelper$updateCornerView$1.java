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
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper", f = "QCircleTabAvatarHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {230, 231, 232}, m = "updateCornerView", n = {"this", "qCircleTab", "redPointInfo", "isAllowBubbleDemotion", "this", "qCircleTab", "redPointInfo", "isAllowBubbleDemotion"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$updateCornerView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QCircleTabAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabAvatarHelper$updateCornerView$1(QCircleTabAvatarHelper qCircleTabAvatarHelper, Continuation<? super QCircleTabAvatarHelper$updateCornerView$1> continuation) {
        super(continuation);
        this.this$0 = qCircleTabAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object M;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        M = this.this$0.M(null, null, false, null, this);
        return M;
    }
}

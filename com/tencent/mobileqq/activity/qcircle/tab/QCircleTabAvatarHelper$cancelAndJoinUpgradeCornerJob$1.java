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
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper", f = "QCircleTabAvatarHelper.kt", i = {}, l = {250}, m = "cancelAndJoinUpgradeCornerJob", n = {}, s = {})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QCircleTabAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1(QCircleTabAvatarHelper qCircleTabAvatarHelper, Continuation<? super QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1> continuation) {
        super(continuation);
        this.this$0 = qCircleTabAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        A = this.this$0.A(this);
        return A;
    }
}

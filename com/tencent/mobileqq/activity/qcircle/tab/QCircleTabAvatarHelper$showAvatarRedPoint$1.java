package com.tencent.mobileqq.activity.qcircle.tab;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper", f = "QCircleTabAvatarHelper.kt", i = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 7, 7, 7}, l = {168, 180, 182, 185, 189, 192, 193, 200, 201, 209}, m = "showAvatarRedPoint", n = {"this", "redPointInfo", "qCircleTab", "redDisplayInfo", "isAllowBubbleDemotion", "this", "redPointInfo", "qCircleTab", "redDisplayInfo", "isAllowBubbleDemotion", "this", "redPointInfo", "qCircleTab", "redDisplayInfo", "this", "redPointInfo", "qCircleTab", "this", "redPointInfo", "qCircleTab", "this", "redPointInfo", "qCircleTab"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$showAvatarRedPoint$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QCircleTabAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabAvatarHelper$showAvatarRedPoint$1(QCircleTabAvatarHelper qCircleTabAvatarHelper, Continuation<? super QCircleTabAvatarHelper$showAvatarRedPoint$1> continuation) {
        super(continuation);
        this.this$0 = qCircleTabAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object I;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        I = this.this$0.I(null, this);
        return I;
    }
}

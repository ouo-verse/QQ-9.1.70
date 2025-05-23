package com.tencent.robot.discoveryv2.common.recommend.content;

import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class RecommendContentViewModel$registerNotification$1 extends AdaptedFunctionReference implements Function2<List<? extends ListNode>, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecommendContentViewModel$registerNotification$1(Object obj) {
        super(2, obj, RecommendContentViewModel.class, "onCategoryTabListChanged", "onCategoryTabListChanged(Ljava/util/List;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends ListNode> list, Continuation<? super Unit> continuation) {
        return invoke2((List<ListNode>) list, continuation);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull List<ListNode> list, @NotNull Continuation<? super Unit> continuation) {
        Object X1;
        X1 = RecommendContentViewModel.X1((RecommendContentViewModel) this.receiver, list, continuation);
        return X1;
    }
}

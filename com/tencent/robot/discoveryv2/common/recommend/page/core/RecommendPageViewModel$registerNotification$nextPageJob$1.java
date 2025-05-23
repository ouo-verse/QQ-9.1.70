package com.tencent.robot.discoveryv2.common.recommend.page.core;

import com.tencent.robot.discoveryv2.common.data.SingleCategoryNextPageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class RecommendPageViewModel$registerNotification$nextPageJob$1 extends AdaptedFunctionReference implements Function2<SingleCategoryNextPageData, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecommendPageViewModel$registerNotification$nextPageJob$1(Object obj) {
        super(2, obj, RecommendPageViewModel.class, "haveNextPageDataChanged", "haveNextPageDataChanged(Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryNextPageData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SingleCategoryNextPageData singleCategoryNextPageData, @NotNull Continuation<? super Unit> continuation) {
        Object i26;
        i26 = RecommendPageViewModel.i2((RecommendPageViewModel) this.receiver, singleCategoryNextPageData, continuation);
        return i26;
    }
}

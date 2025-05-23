package com.tencent.mobileqq.guild.aisearch.parts;

import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
/* synthetic */ class EmptyPagePart$onInitView$2 extends FunctionReferenceImpl implements Function1<AISearchRecommendRepository.RecommendItem.RecommendWord, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EmptyPagePart$onInitView$2(Object obj) {
        super(1, obj, EmptyPagePart.class, "onRecommendClick", "onRecommendClick(Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AISearchRecommendRepository.RecommendItem.RecommendWord recommendWord) {
        invoke2(recommendWord);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull AISearchRecommendRepository.RecommendItem.RecommendWord p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((EmptyPagePart) this.receiver).H9(p06);
    }
}

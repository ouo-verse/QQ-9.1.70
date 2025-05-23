package com.tencent.mobileqq.guild.aisearch.parts;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B*\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fR2\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "I", "Lkotlin/jvm/functions/Function1;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<Object> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function1<AISearchRecommendRepository.RecommendItem.RecommendWord, Unit> onItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super AISearchRecommendRepository.RecommendItem.RecommendWord, Unit> onItemClick) {
        super(d.a());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
        this.f236209m.c(new TitleItemDelegate());
        this.f236209m.c(new RecommendItemDelegate(onItemClick));
    }
}

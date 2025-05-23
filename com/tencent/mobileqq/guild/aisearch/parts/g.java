package com.tencent.mobileqq.guild.aisearch.parts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\r\u001a\u00020\f\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "E", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "text", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onItemClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AISearchRecommendRepository.RecommendItem.RecommendWord item;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView, @NotNull final Function1<? super AISearchRecommendRepository.RecommendItem.RecommendWord, Unit> onItemClick) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        View childAt = ((ViewGroup) itemView).getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
        this.text = (TextView) childAt;
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.parts.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.m(g.this, onItemClick, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(g this$0, Function1 onItemClick, View view) {
        AISearchRecommendRepository.RecommendItem.RecommendWord recommendWord;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        if (!o.c("fastClickGuard") && (recommendWord = this$0.item) != null) {
            onItemClick.invoke(recommendWord);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void n(@NotNull AISearchRecommendRepository.RecommendItem.RecommendWord item) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(item, "item");
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        String valueOf = String.valueOf(item.getIndex());
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_word", item.getContent()), TuplesKt.to("sgrp_rank", String.valueOf(item.getIndex())));
        if1.a.b(itemView, "em_sgrp_guide_word", valueOf, mapOf, null, null, null, null, null, 248, null);
        this.item = item;
        this.text.setText(item.getContent());
    }
}

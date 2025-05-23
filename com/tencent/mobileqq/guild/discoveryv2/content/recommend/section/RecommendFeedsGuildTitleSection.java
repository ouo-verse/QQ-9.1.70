package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsGuildTitleSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedsGuildData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "", "attached", "onAttachedChanged", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents;", "components", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedsGuildTitleSection extends ar<RecommendFeedsGuildData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendGuildTitleComponents components = new RecommendGuildTitleComponents(new a());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsGuildTitleSection$a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$b;", "Lkotlin/Pair;", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements RecommendGuildTitleComponents.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents.b
        @NotNull
        public Pair<String, String> b() {
            return RecommendFeedsGuildTitleSection.this.r().b(((RecommendFeedsGuildData) ((Section) RecommendFeedsGuildTitleSection.this).mData).getItemType());
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents.b
        public boolean c() {
            return RecommendGuildTitleComponents.b.a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wfp};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        this.components.q(attached);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable final View containerView) {
        if (containerView == null) {
            return;
        }
        this.components.t(containerView);
        final long j3 = 200;
        containerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsGuildTitleSection$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                RecommendGuildTitleComponents recommendGuildTitleComponents;
                EventCollector.getInstance().onViewClickedBefore(it);
                containerView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                recommendGuildTitleComponents = this.components;
                recommendGuildTitleComponents.v();
                final View view = containerView;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsGuildTitleSection$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendFeedsGuildData data, int position, @Nullable List<? extends Object> payload) {
        Object firstOrNull;
        IGProFeedGuildInfo guildInfo;
        IGProContentRecommendGuild b16;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<IGProContentRecommendFeed> feeds = ((RecommendFeedsGuildData) this.mData).getFeeds();
        Intrinsics.checkNotNullExpressionValue(feeds, "mData.feeds");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) feeds);
        IGProContentRecommendFeed iGProContentRecommendFeed = (IGProContentRecommendFeed) firstOrNull;
        if (iGProContentRecommendFeed == null || (guildInfo = iGProContentRecommendFeed.getGuildInfo()) == null) {
            return;
        }
        RecommendGuildTitleComponents recommendGuildTitleComponents = this.components;
        ArrayList<IGProGuildLabel> tags = iGProContentRecommendFeed.getTags();
        Intrinsics.checkNotNullExpressionValue(tags, "feed.tags");
        b16 = RecommendFeedsGuildTitleSectionKt.b(guildInfo, tags);
        recommendGuildTitleComponents.r(b16, "em_sgrp_channel_and_forum_module_join");
    }
}

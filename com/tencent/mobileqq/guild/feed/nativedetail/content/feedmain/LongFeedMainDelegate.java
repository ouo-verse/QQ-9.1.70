package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedBusinessCardSection;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedSourceCardSection;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.LongFeedMainTextSection;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.k;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.m;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J4\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00160\tH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/LongFeedMainDelegate;", "Lhl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "Lhl1/g;", "", "firstFrameTime", "", "f", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "e", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "initSection", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedMainDelegate extends hl1.a<FeedDetailMainData, hl1.g> {
    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final long firstFrameTime) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.f
            @Override // java.lang.Runnable
            public final void run() {
                LongFeedMainDelegate.g(LongFeedMainDelegate.this, firstFrameTime);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LongFeedMainDelegate this$0, long j3) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            rl1.a aVar = (rl1.a) this$0.b(rl1.a.class);
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_feed_id", aVar.getFeedId()), TuplesKt.to("sgrp_first_frame_time", Long.valueOf(j3)));
            Long startTime = aVar.getStartTime();
            if (startTime != null) {
                long longValue = j3 - startTime.longValue();
                hashMapOf.put("sgrp_cost_time", Long.valueOf(longValue));
                QLog.i("LongFeedMainDelegate", 1, "reportOnPreDraw cost: " + longValue + ", feedId: " + aVar.getFeedId());
            }
            VideoReport.reportEvent("ev_sgrp_forum_detail_first_frame_finish", hashMapOf);
        } catch (Exception e16) {
            QLog.e("LongFeedMainDelegate", 1, "reportOnPreDraw exception: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull hl1.g item, @NotNull List<hl1.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.getItemType() == 12) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.exd;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<FeedDetailMainData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(k.class);
        sections.add(LongFeedMainTextSection.class);
        sections.add(FeedSourceCardSection.class);
        sections.add(com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.g.class);
        sections.add(m.class);
        sections.add(FeedBusinessCardSection.class);
        sections.add(com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.d.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // hl1.a, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SectionViewHolder<?> onCreateViewHolder = super.onCreateViewHolder(parent);
        final View view = onCreateViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(view, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.LongFeedMainDelegate$onCreateViewHolder$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                this.f(System.currentTimeMillis());
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        return onCreateViewHolder;
    }
}

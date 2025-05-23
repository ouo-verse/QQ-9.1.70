package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedMainTextSection;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedMainVideoSection;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.l;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J4\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00160\tH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedMainDelegate;", "Lhl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "Lhl1/g;", "", "firstFrameTime", "", "f", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "e", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "initSection", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMainDelegate extends hl1.a<FeedDetailMainData, hl1.g> {
    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final long firstFrameTime) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.d
            @Override // java.lang.Runnable
            public final void run() {
                FeedMainDelegate.g(FeedMainDelegate.this, firstFrameTime);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedMainDelegate this$0, long j3) {
        long j16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            rl1.a aVar = (rl1.a) this$0.b(rl1.a.class);
            if (aVar == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_feed_id", aVar.getFeedId());
            hashMap.put("sgrp_first_frame_time", Long.valueOf(j3));
            Long startTime = aVar.getStartTime();
            if (startTime != null) {
                j16 = startTime.longValue();
            } else {
                j16 = 0;
            }
            if (j16 > 0) {
                hashMap.put("sgrp_cost_time", Long.valueOf(j3 - j16));
            }
            QLog.i("FeedMainDelegate", 1, "reportOnPreDraw cost: " + (j3 - j16) + ", feedId: " + aVar.getFeedId());
            VideoReport.reportEvent("ev_sgrp_forum_detail_first_frame_finish", hashMap);
        } catch (Exception e16) {
            QLog.e("FeedMainDelegate", 1, "reportOnPreDraw exception: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull hl1.g item, @NotNull List<hl1.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.getItemType() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.ena;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<FeedDetailMainData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.d.class);
        sections.add(FeedMainVideoSection.class);
        sections.add(FeedMainTextSection.class);
        sections.add(com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.b.class);
        sections.add(l.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // hl1.a, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SectionViewHolder<?> onCreateViewHolder = super.onCreateViewHolder(parent);
        ViewTreeObserver viewTreeObserver = onCreateViewHolder.itemView.getViewTreeObserver();
        View view = onCreateViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        viewTreeObserver.addOnPreDrawListener(new yl1.c(view, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedMainDelegate$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FeedMainDelegate.this.f(System.currentTimeMillis());
            }
        }));
        return onCreateViewHolder;
    }
}

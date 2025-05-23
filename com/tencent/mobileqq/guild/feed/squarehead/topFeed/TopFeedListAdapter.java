package com.tencent.mobileqq.guild.feed.squarehead.topFeed;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListAdapter;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedTopItemLayout;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import ij1.h;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0014\u0010\u000f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lij1/h;", "Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListAdapter$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "", "dataList", "m0", "Lsn1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lsn1/a;", "display", "<init>", "(Lsn1/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopFeedListAdapter extends ListAdapter<h, c> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final sn1.a display;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lij1/h;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends DiffUtil.ItemCallback<h> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull h oldItem, @NotNull h newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            String str = oldItem.C;
            if (TextUtils.equals(str, str) && TextUtils.equals(oldItem.P, newItem.P) && oldItem.K == newItem.K) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull h oldItem, @NotNull h newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "position", "listSize", "Lij1/h;", "feedTopData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "totalSize", "", "isFold", "l", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        private final void m(View view, int position, int listSize, h feedTopData) {
            HashMap hashMap = new HashMap();
            int i3 = 1;
            hashMap.put("sgrp_rank", Integer.valueOf(position + 1));
            hashMap.put("sgrp_forum_toppost_num", Integer.valueOf(listSize));
            hashMap.put("sgrp_content_id", feedTopData.f407814h);
            hashMap.put("sgrp_feed_id", feedTopData.f407814h);
            if (!feedTopData.L) {
                i3 = 2;
            }
            hashMap.put("sgrp_remind_type", Integer.valueOf(i3));
            com.tencent.mobileqq.guild.feed.report.d.d(view, "em_sgrp_forum_toppost", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, hashMap);
        }

        public final void l(@NotNull h feedTopData, int position, int totalSize, boolean isFold) {
            Intrinsics.checkNotNullParameter(feedTopData, "feedTopData");
            View view = this.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.widget.GuildFeedTopItemLayout");
            GuildFeedTopItemLayout guildFeedTopItemLayout = (GuildFeedTopItemLayout) view;
            guildFeedTopItemLayout.h(feedTopData, position, totalSize, isFold);
            m(guildFeedTopItemLayout, position, totalSize, feedTopData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFeedListAdapter(@NotNull sn1.a display) {
        super(new b());
        Intrinsics.checkNotNullParameter(display, "display");
        this.display = display;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(final c holder) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        View view = holder.itemView;
        if (view != null) {
            dq0.b.INSTANCE.c(view, 900L, 1, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListAdapter$onBindViewHolder$1$1$1
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
                    View view2 = TopFeedListAdapter.c.this.itemView;
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.widget.GuildFeedTopItemLayout");
                    ((GuildFeedTopItemLayout) view2).f();
                    TopFeedListAdapter.c.this.itemView.setBackgroundResource(R.drawable.guild_feed_top_item_bg_selector);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final c holder, int position) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        h feedTopData = getItem(position);
        Intrinsics.checkNotNullExpressionValue(feedTopData, "feedTopData");
        holder.l(feedTopData, position, this.display.totalSize(), this.display.k());
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.widget.GuildFeedTopItemLayout");
        ((GuildFeedTopItemLayout) view).setOnItemClickListener(this.display.j0());
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(f16);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        if (this.display.I() && position == 0 && feedTopData.h() && feedTopData.G != j3) {
            if (!ch.j0(String.valueOf(feedTopData.H))) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TopFeedListAdapter.k0(TopFeedListAdapter.c.this);
                    }
                }, 800L);
            }
            feedTopData.K = System.currentTimeMillis();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ero, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new c(itemView);
    }

    public final void m0(@NotNull List<? extends h> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        submitList(dataList);
    }
}

package com.tencent.mobileqq.guild.channelcard.delegate;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channelcard.delegate.ChannelTextCardAdapterDelegate;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.guild.discovery.widget.SmallUserAvatarList;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dg1.ChannelTextCardItemData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelTextCardAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Ldg1/g;", "Ldg1/b;", "Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelTextCardAdapterDelegate$a;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Lcg1/b;", "d", "Lcg1/b;", "channelCardControl", "<init>", "(Lcg1/b;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelTextCardAdapterDelegate extends AbsListItemAdapterDelegate<ChannelTextCardItemData, dg1.b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cg1.b channelCardControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelTextCardAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/main/a;", "", "enableAnimate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ldg1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", "d", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "channelNameView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "memberIcon", "G", "memberCount", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "H", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "downToUpViewSwitcher", "Lcom/tencent/mobileqq/guild/discovery/widget/SmallUserAvatarList;", "I", "Lcom/tencent/mobileqq/guild/discovery/widget/SmallUserAvatarList;", "avatarListView", "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/f;", "J", "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/f;", "msgListAdapter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.main.a {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView channelNameView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView memberIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView memberCount;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final DownToUpViewSwitcher downToUpViewSwitcher;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final SmallUserAvatarList avatarListView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private com.tencent.mobileqq.guild.main.topchannel.adapter.f msgListAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.channel_name)");
            this.channelNameView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.z1x);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.member_icon)");
            this.memberIcon = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.eom);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.member_count)");
            this.memberCount = (TextView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.ukx);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026down_to_up_view_switcher)");
            DownToUpViewSwitcher downToUpViewSwitcher = (DownToUpViewSwitcher) findViewById4;
            this.downToUpViewSwitcher = downToUpViewSwitcher;
            View findViewById5 = view.findViewById(R.id.t1l);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.avatar_list)");
            this.avatarListView = (SmallUserAvatarList) findViewById5;
            this.msgListAdapter = new com.tencent.mobileqq.guild.main.topchannel.adapter.f();
            downToUpViewSwitcher.setItemMargin(bi.a(6.0f));
            downToUpViewSwitcher.setAdapter(this.msgListAdapter);
            downToUpViewSwitcher.setScrollDurationPerItem(250L);
            downToUpViewSwitcher.setAutoScrollInterval(1500L);
        }

        private final void m(final boolean enableAnimate) {
            final int m3 = this.downToUpViewSwitcher.m();
            this.downToUpViewSwitcher.post(new Runnable() { // from class: com.tencent.mobileqq.guild.channelcard.delegate.g
                @Override // java.lang.Runnable
                public final void run() {
                    ChannelTextCardAdapterDelegate.a.n(ChannelTextCardAdapterDelegate.a.this, m3, enableAnimate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.downToUpViewSwitcher.o() == 0) {
                this$0.downToUpViewSwitcher.setCurrentItem(i3, false);
            }
            this$0.downToUpViewSwitcher.setAutoScroll(z16);
        }

        @Override // com.tencent.mobileqq.guild.main.a
        public void d(boolean enableAnimate) {
            m(enableAnimate);
        }

        public final void o(@NotNull ChannelTextCardItemData item, boolean enableAnimate) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(R.id.w1p, item);
            this.channelNameView.setText(item.getChannelName());
            if (item.h().isEmpty()) {
                this.avatarListView.setVisibility(8);
            } else {
                this.avatarListView.setVisibility(0);
                this.avatarListView.f(item.h());
            }
            if (TextUtils.isEmpty(item.getMemberCount())) {
                this.memberIcon.setVisibility(8);
                this.memberCount.setVisibility(8);
            } else {
                this.memberIcon.setVisibility(0);
                this.memberCount.setVisibility(0);
                this.memberCount.setText(item.getMemberCount());
            }
            this.msgListAdapter.l0(String.valueOf(item.getGuildId()), item.i());
            this.msgListAdapter.notifyDataSetChanged();
            m(enableAnimate);
        }
    }

    public ChannelTextCardAdapterDelegate(@NotNull cg1.b channelCardControl) {
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.channelCardControl = channelCardControl;
    }

    private final void p(View view) {
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag(R.id.w1p);
            if (!(tag instanceof ChannelTextCardItemData)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onClick invalid, data:" + tag;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.featured.FeaturedGuildTextAdapterDelegate", 1, (String) it.next(), null);
                }
                return;
            }
            ChannelTextCardItemData channelTextCardItemData = (ChannelTextCardItemData) tag;
            this.channelCardControl.z0(String.valueOf(channelTextCardItemData.getChannelId()), channelTextCardItemData.getChannelType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ChannelTextCardAdapterDelegate this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull dg1.b item, @NotNull List<dg1.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof ChannelTextCardItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull ChannelTextCardItemData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        cg1.b bVar = this.channelCardControl;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        bVar.s1(view, holder.getAdapterPosition(), item);
        if (payloads.isEmpty()) {
            holder.o(item, this.channelCardControl.a());
            cg1.b bVar2 = this.channelCardControl;
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            bVar2.A0(view2);
            return;
        }
        if (payloads.contains(1)) {
            cg1.b bVar3 = this.channelCardControl;
            View view3 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
            bVar3.A0(view3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.eir, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        com.tencent.mobileqq.guild.component.token.c.c(itemView, null, 2, null);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channelcard.delegate.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelTextCardAdapterDelegate.t(ChannelTextCardAdapterDelegate.this, view);
            }
        });
        return new a(itemView);
    }
}

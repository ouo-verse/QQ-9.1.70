package com.tencent.mobileqq.guild.channellist.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.b;
import com.tencent.mobileqq.guild.channellist.AppChannelData;
import com.tencent.mobileqq.guild.channellist.c;
import com.tencent.mobileqq.guild.main.view.GuildSummaryView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u00012B\u0017\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010/\u001a\u00020(\u00a2\u0006\u0004\b0\u00101J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J&\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\tH\u0014J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001fH\u0016R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/delegate/AppChannelAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/channellist/a;", "Lcom/tencent/mobileqq/guild/channellist/c;", "Lcom/tencent/mobileqq/guild/channellist/delegate/AppChannelAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "channelApp", "holder", "", "", "payloadList", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "w", "p", "", "hasSummaryAndShow", "t", "r", "items", "position", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "v", "", "payloads", "u", "Landroid/view/View;", NodeProps.ON_CLICK, NodeProps.ON_LONG_CLICK, "Lcom/tencent/mobileqq/activity/recent/cur/b;", "d", "Lcom/tencent/mobileqq/activity/recent/cur/b;", "getDragHost", "()Lcom/tencent/mobileqq/activity/recent/cur/b;", "dragHost", "Leg1/a;", "e", "Leg1/a;", "getEventHandler", "()Leg1/a;", "setEventHandler", "(Leg1/a;)V", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/activity/recent/cur/b;Leg1/a;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AppChannelAdapterDelegate extends AbsListItemAdapterDelegate<AppChannelData, c, a> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b dragHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private eg1.a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/delegate/AppChannelAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "l", "()Landroid/widget/LinearLayout;", "bottomContainer", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setChannelName", "(Landroid/widget/TextView;)V", "channelName", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "G", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "setUnreadMsg", "(Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;)V", "unreadMsg", "Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "H", "Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "p", "()Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "setSummaryView", "(Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;)V", "summaryView", "I", "getLastTime", "setLastTime", "lastTime", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "setChannelIcon", "(Landroid/widget/ImageView;)V", "channelIcon", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout bottomContainer;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView channelName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private GuildDragTextView unreadMsg;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private GuildSummaryView summaryView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView lastTime;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private ImageView channelIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.acl);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.bottom_container)");
            this.bottomContainer = (LinearLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.channel_name)");
            this.channelName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f114296sy);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.unread_msg)");
            this.unreadMsg = (GuildDragTextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.j8_);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.summary)");
            this.summaryView = (GuildSummaryView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.ycw);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.last_time)");
            this.lastTime = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.trz);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.channel_icon)");
            this.channelIcon = (ImageView) findViewById6;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final LinearLayout getBottomContainer() {
            return this.bottomContainer;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getChannelIcon() {
            return this.channelIcon;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getChannelName() {
            return this.channelName;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final GuildSummaryView getSummaryView() {
            return this.summaryView;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final GuildDragTextView getUnreadMsg() {
            return this.unreadMsg;
        }
    }

    public AppChannelAdapterDelegate(@NotNull b dragHost, @NotNull eg1.a eventHandler) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.dragHost = dragHost;
        this.eventHandler = eventHandler;
    }

    private final void o(AppChannelData channelApp, a holder, List<Integer> payloadList) {
        if (payloadList.contains(1)) {
            p(channelApp, holder);
        }
    }

    private final void p(AppChannelData channelApp, a holder) {
        boolean z16;
        w(channelApp, holder);
        GuildSummaryUIData summaryUIData = channelApp.getMsgData().getSummaryUIData();
        boolean z17 = true;
        if (summaryUIData == null || summaryUIData.h()) {
            String channelTips = channelApp.getChannelTips();
            if (channelTips != null && channelTips.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String channelTips2 = channelApp.getChannelTips();
                Intrinsics.checkNotNull(channelTips2);
                summaryUIData = com.tencent.mobileqq.guild.summary.c.b(channelTips2);
            } else {
                z17 = false;
            }
        }
        if (summaryUIData != null && !summaryUIData.h()) {
            holder.getSummaryView().setTextColor(er1.a.e(), er1.a.f());
            holder.getSummaryView().setSummaryData(summaryUIData);
        }
        t(z17, holder);
        r(holder, channelApp);
    }

    private final void q(AppChannelData channelApp, a holder) {
        View view = holder.itemView;
        view.setBackground(ResourcesCompat.getDrawable(view.getResources(), er1.a.c(), null));
        holder.getChannelName().setTextColor(AppCompatResources.getColorStateList(holder.itemView.getContext(), er1.a.b()));
        holder.getChannelName().setText(channelApp.getChannelName());
        p(channelApp, holder);
    }

    private final void r(a holder, AppChannelData channelApp) {
        boolean z16;
        int msgShowType = channelApp.getMsgData().getMsgShowType();
        if (msgShowType != 0) {
            if (msgShowType != 4) {
                if (channelApp.getMsgData().getMsgShowType() != 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                er1.a.j(holder.getUnreadMsg(), channelApp.getMsgData().getMsgCnt(), z16);
                holder.getUnreadMsg().setDragViewType(10, holder.itemView);
                holder.getUnreadMsg().setTag(channelApp);
            } else {
                er1.a.k(holder.getUnreadMsg());
                holder.getUnreadMsg().setDragViewType(10, holder.itemView);
                holder.getUnreadMsg().setTag(channelApp);
            }
        } else {
            holder.getUnreadMsg().setVisibility(8);
        }
        holder.getUnreadMsg().setOnModeChangeListener(this.dragHost);
    }

    private final void t(boolean hasSummaryAndShow, a holder) {
        int i3;
        LinearLayout bottomContainer = holder.getBottomContainer();
        if (hasSummaryAndShow) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        bottomContainer.setVisibility(i3);
        if (hasSummaryAndShow) {
            View view = holder.itemView;
            view.setPadding(view.getPaddingLeft(), QQGuildUIUtil.f(13.0f), holder.itemView.getPaddingRight(), QQGuildUIUtil.f(9.0f));
        } else {
            View view2 = holder.itemView;
            view2.setPadding(view2.getPaddingLeft(), QQGuildUIUtil.f(16.0f), holder.itemView.getPaddingRight(), QQGuildUIUtil.f(16.0f));
        }
    }

    private final void w(AppChannelData item, a holder) {
        boolean z16;
        if (item.getMsgData().getMsgCnt() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageView channelIcon = holder.getChannelIcon();
        Context context = holder.getChannelIcon().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.channelIcon.context");
        Context context2 = holder.getChannelIcon().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "holder.channelIcon.context");
        channelIcon.setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_channel_app_p, er1.a.a(context2, z16)));
        holder.getChannelIcon().setBackground(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        this.eventHandler.b().invoke(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        boolean booleanValue = this.eventHandler.c().invoke(v3).booleanValue();
        EventCollector.getInstance().onViewLongClicked(v3);
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull c item, @NotNull List<? extends c> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof AppChannelData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull AppChannelData channelApp, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(channelApp, "channelApp");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(R.id.w1p, channelApp);
        List<Integer> payloadList = com.tencent.mobileqq.guild.main.data.b.a(payloads);
        Intrinsics.checkNotNullExpressionValue(payloadList, "payloadList");
        if (!payloadList.isEmpty()) {
            o(channelApp, holder, payloadList);
        } else {
            q(channelApp, holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168044ei1, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026nnel_item, parent, false)");
        a aVar = new a(inflate);
        aVar.itemView.setOnClickListener(this);
        aVar.itemView.setOnLongClickListener(this);
        return aVar;
    }
}

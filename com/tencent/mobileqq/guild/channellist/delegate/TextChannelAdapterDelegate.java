package com.tencent.mobileqq.guild.channellist.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.b;
import com.tencent.mobileqq.guild.channellist.TextChannelData;
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
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0001/B\u0017\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010,\u001a\u00020%\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J(\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000bH\u0014J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0019H\u0014J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/delegate/TextChannelAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/channellist/t;", "Lcom/tencent/mobileqq/guild/channellist/c;", "Lcom/tencent/mobileqq/guild/channellist/delegate/TextChannelAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "p", "", "", "payloadList", "o", "items", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "", "payloads", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", h.F, "Landroid/view/View;", "v", NodeProps.ON_CLICK, NodeProps.ON_LONG_CLICK, "Lcom/tencent/mobileqq/activity/recent/cur/b;", "d", "Lcom/tencent/mobileqq/activity/recent/cur/b;", "getDragHost", "()Lcom/tencent/mobileqq/activity/recent/cur/b;", "dragHost", "Leg1/a;", "e", "Leg1/a;", "getEventHandler", "()Leg1/a;", "setEventHandler", "(Leg1/a;)V", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/activity/recent/cur/b;Leg1/a;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class TextChannelAdapterDelegate extends AbsListItemAdapterDelegate<TextChannelData, c, a> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b dragHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private eg1.a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\"\u0010\t\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/delegate/TextChannelAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "p", "Lcom/tencent/mobileqq/guild/channellist/t;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "", "channelName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "Lcom/tencent/mobileqq/guild/summary/b;", "summaryUIData", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getChannelName", "()Landroid/widget/TextView;", "setChannelName", "(Landroid/widget/TextView;)V", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "o", "()Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "setUnreadMsg", "(Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;)V", "unreadMsg", "Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "G", "Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "getSummaryView", "()Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "setSummaryView", "(Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;)V", "summaryView", "H", "getLastTime", "setLastTime", "lastTime", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "getChannelIcon", "()Landroid/widget/ImageView;", "setChannelIcon", "(Landroid/widget/ImageView;)V", "channelIcon", "J", "getIconBlockMsg", "setIconBlockMsg", "iconBlockMsg", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView channelName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private GuildDragTextView unreadMsg;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private GuildSummaryView summaryView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private TextView lastTime;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private ImageView channelIcon;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private ImageView iconBlockMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.channel_name)");
            this.channelName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f114296sy);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.unread_msg)");
            this.unreadMsg = (GuildDragTextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.j8_);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.summary)");
            this.summaryView = (GuildSummaryView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.ycw);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.last_time)");
            this.lastTime = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.trz);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.channel_icon)");
            this.channelIcon = (ImageView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.xdg);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.icon_block_msg)");
            this.iconBlockMsg = (ImageView) findViewById6;
        }

        private final void p() {
            View view = this.itemView;
            view.setBackground(ResourcesCompat.getDrawable(view.getResources(), er1.a.c(), null));
            this.channelName.setTextColor(AppCompatResources.getColorStateList(this.itemView.getContext(), er1.a.b()));
            this.lastTime.setTextColor(AppCompatResources.getColorStateList(this.itemView.getContext(), er1.a.d()));
        }

        private final void q(TextChannelData item) {
            boolean z16;
            int msgShowType = item.getMsgData().getMsgShowType();
            if (msgShowType != 0) {
                if (msgShowType != 4) {
                    if (item.getMsgData().getMsgShowType() != 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    er1.a.j(this.unreadMsg, item.getMsgData().getMsgCnt(), z16);
                    this.unreadMsg.setDragViewType(10, this.itemView);
                    this.unreadMsg.setTag(item);
                    return;
                }
                er1.a.k(this.unreadMsg);
                this.unreadMsg.setDragViewType(10, this.itemView);
                this.unreadMsg.setTag(item);
                return;
            }
            this.unreadMsg.setVisibility(8);
        }

        public final void l(@NotNull TextChannelData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.channelName.setText(item.getChannelName());
            m(item, item.getChannelName());
            p();
        }

        public final void m(@NotNull TextChannelData item, @Nullable String channelName) {
            Intrinsics.checkNotNullParameter(item, "item");
            GuildSummaryUIData summaryUIData = item.getMsgData().getSummaryUIData();
            if (summaryUIData == null || summaryUIData.h()) {
                String welcomeTips = QQGuildUIUtil.s(R.string.f142290iz, channelName);
                Intrinsics.checkNotNullExpressionValue(welcomeTips, "welcomeTips");
                summaryUIData = com.tencent.mobileqq.guild.summary.c.b(welcomeTips);
            }
            this.summaryView.setTextColor(er1.a.e(), er1.a.f());
            this.summaryView.setSummaryData(summaryUIData);
            q(item);
            s(summaryUIData);
            r(item);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final GuildDragTextView getUnreadMsg() {
            return this.unreadMsg;
        }

        public final void r(@NotNull TextChannelData item) {
            boolean z16;
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.getMsgData().getMsgCnt() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ImageView imageView = this.channelIcon;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            er1.a aVar = er1.a.f397046a;
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            imageView.setBackground(GuildUIUtils.y(context, R.drawable.guild_channel_text_icon_bg, aVar.g(context2, z16)));
            ImageView imageView2 = this.channelIcon;
            Context context3 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
            Context context4 = this.channelIcon.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "channelIcon.context");
            imageView2.setImageDrawable(GuildUIUtils.y(context3, R.drawable.guild_channel_text_icon_src, er1.a.a(context4, z16)));
        }

        public final void s(@NotNull GuildSummaryUIData summaryUIData) {
            Intrinsics.checkNotNullParameter(summaryUIData, "summaryUIData");
            if (summaryUIData.getLastTime() > 0) {
                this.lastTime.setVisibility(0);
                this.lastTime.setText(gr1.b.f403085a.a(summaryUIData.getLastTime()));
                return;
            }
            this.lastTime.setVisibility(8);
        }
    }

    public TextChannelAdapterDelegate(@NotNull b dragHost, @NotNull eg1.a eventHandler) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.dragHost = dragHost;
        this.eventHandler = eventHandler;
    }

    private final void o(TextChannelData item, a holder, List<Integer> payloadList) {
        GuildSummaryUIData summaryUIData;
        if (payloadList.contains(1)) {
            holder.m(item, item.getChannelName());
        }
        if (payloadList.contains(7) && (summaryUIData = item.getMsgData().getSummaryUIData()) != null) {
            holder.s(summaryUIData);
        }
    }

    private final void p(TextChannelData item, a holder) {
        holder.l(item);
        holder.getUnreadMsg().setOnModeChangeListener(this.dragHost);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof com.tencent.mobileqq.guild.main.a) {
            ((com.tencent.mobileqq.guild.main.a) holder).d(false);
        }
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
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull c item, @NotNull List<? extends c> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof TextChannelData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull TextChannelData item, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(R.id.w1p, item);
        List<Integer> payloadList = com.tencent.mobileqq.guild.main.data.b.a(payloads);
        Intrinsics.checkNotNullExpressionValue(payloadList, "payloadList");
        if (!payloadList.isEmpty()) {
            o(item, holder, payloadList);
        } else {
            p(item, holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
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

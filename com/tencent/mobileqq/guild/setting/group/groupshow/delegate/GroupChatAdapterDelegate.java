package com.tencent.mobileqq.guild.setting.group.groupshow.delegate;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import az1.GroupChatShowData;
import az1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quitagview.QUITagIcon;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.groupshow.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u00012\u00020\u0005:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0014\u0010\u000f\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0014J*\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00022\n\u0010\u0011\u001a\u00060\u0004R\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0014J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/GroupChatAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Laz1/c;", "Laz1/a;", "Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/GroupChatAdapterDelegate$b;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "data", "holder", "", "payloads", "", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lbz1/a;", "d", "Lbz1/a;", "callback", "<init>", "(Lbz1/a;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GroupChatAdapterDelegate extends AbsListItemAdapterDelegate<GroupChatShowData, a, b> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bz1.a callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/GroupChatAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "E", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "setGroupAvatar", "(Lcom/tencent/mobileqq/proavatar/QQProAvatarView;)V", "groupAvatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setGroupName", "(Landroid/widget/TextView;)V", "groupName", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setGroupBanTips", "groupBanTips", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/LinearLayout;", "setTagLly", "(Landroid/widget/LinearLayout;)V", "tagLly", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "I", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "r", "()Lcom/tencent/biz/qui/quitagview/QUITagView;", "setTagOne", "(Lcom/tencent/biz/qui/quitagview/QUITagView;)V", "tagOne", "J", ReportConstant.COSTREPORT_PREFIX, "setTagTwo", "tagTwo", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "K", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "p", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setGroupStatus", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "groupStatus", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/GroupChatAdapterDelegate;Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private QQProAvatarView groupAvatar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView groupName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView groupBanTips;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private LinearLayout tagLly;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private QUITagView tagOne;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private QUITagView tagTwo;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private QUIButton groupStatus;
        final /* synthetic */ GroupChatAdapterDelegate L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull GroupChatAdapterDelegate groupChatAdapterDelegate, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.L = groupChatAdapterDelegate;
            View findViewById = itemView.findViewById(R.id.vts);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.group_icon)");
            this.groupAvatar = (QQProAvatarView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.group_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.group_name)");
            this.groupName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.vt9);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.group_ban_tips)");
            this.groupBanTips = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f922557d);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tag_lly)");
            this.tagLly = (LinearLayout) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f923057i);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tag_one)");
            this.tagOne = (QUITagView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f923857q);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tag_two)");
            this.tagTwo = (QUITagView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.vuk);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.group_status)");
            this.groupStatus = (QUIButton) findViewById7;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QQProAvatarView getGroupAvatar() {
            return this.groupAvatar;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getGroupBanTips() {
            return this.groupBanTips;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getGroupName() {
            return this.groupName;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final QUIButton getGroupStatus() {
            return this.groupStatus;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final LinearLayout getTagLly() {
            return this.tagLly;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final QUITagView getTagOne() {
            return this.tagOne;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final QUITagView getTagTwo() {
            return this.tagTwo;
        }
    }

    public GroupChatAdapterDelegate(@NotNull bz1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GroupChatShowData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            Object tag = v3.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.group.groupshow.data.GroupChatShowData");
            GroupChatShowData groupChatShowData = (GroupChatShowData) tag;
            int id5 = v3.getId();
            if (id5 == R.id.b_7) {
                g.INSTANCE.f(v3, groupChatShowData);
                if (groupChatShowData.getIsGroupMember()) {
                    this.callback.b(String.valueOf(groupChatShowData.getGroupCode()), groupChatShowData.getGroupName());
                } else {
                    this.callback.a(String.valueOf(groupChatShowData.getGroupCode()), groupChatShowData.getSignature());
                }
            } else if (id5 == R.id.vuk) {
                g.INSTANCE.d(v3, groupChatShowData);
                if (groupChatShowData.getIsGroupMember()) {
                    this.callback.b(String.valueOf(groupChatShowData.getGroupCode()), groupChatShowData.getGroupName());
                } else {
                    this.callback.c(String.valueOf(groupChatShowData.getGroupCode()), groupChatShowData.getSignature(), groupChatShowData.getGroupName());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GroupChatShowData data, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        g.Companion companion = g.INSTANCE;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        companion.i(view, data);
        holder.itemView.setTag(data);
        holder.getGroupStatus().setTag(data);
        if (com.tencent.mobileqq.guild.main.data.b.a(payloads).contains(6)) {
            return;
        }
        holder.getGroupName().setText(data.getGroupName());
        holder.getGroupAvatar().x(4, String.valueOf(data.getGroupCode()), null);
        if (data.getIsBanned()) {
            holder.getGroupBanTips().setVisibility(0);
            holder.getTagLly().setVisibility(8);
            holder.getGroupStatus().setVisibility(8);
        } else {
            holder.getGroupBanTips().setVisibility(8);
            holder.getTagLly().setVisibility(0);
            holder.getGroupStatus().setVisibility(0);
            if (data.getGroupMemberSize() > 0) {
                holder.getTagOne().setVisibility(0);
                holder.getTagOne().setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, new QUITagIcon(R.drawable.qui_user, null, false, 6, null), String.valueOf(data.getGroupMemberSize())));
            } else {
                holder.getTagOne().setVisibility(8);
            }
            if (TextUtils.isEmpty(data.getOnlineMemberSize())) {
                holder.getTagTwo().setVisibility(8);
            } else {
                holder.getTagTwo().setVisibility(0);
                holder.getTagTwo().setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, data.getOnlineMemberSize()));
            }
            if (data.getIsGroupMember()) {
                holder.getGroupStatus().setText("\u53d1\u6d88\u606f");
                holder.getGroupStatus().setType(1);
            } else {
                holder.getGroupStatus().setText("\u52a0\u5165");
                holder.getGroupStatus().setType(0);
            }
        }
        Logger.f235387a.d().i("Guild.GroupChatShow.GroupChatAdapterDelegate", 1, "onBindGroupChatData: isBanned:" + data.getIsBanned() + ", isGroupMember:" + data.getIsGroupMember() + ", memberSize:" + data.getGroupMemberSize() + ", onlineGroupMemberSize:" + data.getOnlineMemberSize());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.esw, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026chat_item, parent, false)");
        b bVar = new b(this, inflate);
        bVar.getGroupStatus().setPadding(0, 0, 0, 0);
        bVar.itemView.setOnClickListener(this);
        bVar.getGroupStatus().setOnClickListener(this);
        return bVar;
    }
}

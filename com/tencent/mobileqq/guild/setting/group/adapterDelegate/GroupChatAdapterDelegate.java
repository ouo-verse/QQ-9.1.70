package com.tencent.mobileqq.guild.setting.group.adapterDelegate;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.GroupChatData;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.GroupChatAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.y;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/GroupChatAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/setting/group/p;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/GroupChatAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "d", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GroupChatAdapterDelegate extends AbsListItemAdapterDelegate<GroupChatData, com.tencent.mobileqq.guild.setting.group.a, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildBindGroupSettingFragment.a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010#\u001a\u00020\u0013\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/GroupChatAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/setting/group/p;", "data", "", "t", "o", "p", "u", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "E", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "eventHandler", "Lcom/tencent/biz/qui/quibutton/QUIButton;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "r", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "groupButton", "Landroid/view/View;", "G", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/view/View;", "sortView", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "H", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "groupAvatar", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "groupName", "J", "groupBanTips", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final GuildBindGroupSettingFragment.a eventHandler;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final QUIButton groupButton;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final View sortView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final QQProAvatarView groupAvatar;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView groupName;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView groupBanTips;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @NotNull GuildBindGroupSettingFragment.a eventHandler) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
            this.eventHandler = eventHandler;
            View findViewById = itemView.findViewById(R.id.vta);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.group_button)");
            this.groupButton = (QUIButton) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f86944t1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.sort_view)");
            this.sortView = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.cxk);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.group_avatar)");
            this.groupAvatar = (QQProAvatarView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.group_name);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.group_name)");
            this.groupName = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.vt9);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.group_ban_tips)");
            this.groupBanTips = (TextView) findViewById5;
            findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: yy1.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean n3;
                    n3 = GroupChatAdapterDelegate.a.n(GroupChatAdapterDelegate.a.this, view);
                    return n3;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean n(a this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!(view.getTag() instanceof GroupChatData)) {
                return false;
            }
            this$0.eventHandler.f().invoke(this$0);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(a this$0, GroupChatData data) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.t(data);
        }

        private final void t(GroupChatData data) {
            TextPaint paint = this.groupName.getPaint();
            CharSequence ellipsize = TextUtils.ellipsize(data.getGroupData().getGroupName(), paint, this.groupName.getWidth() - paint.measureText("(" + data.getGroupData().getGroupMemberSize() + ")"), TextUtils.TruncateAt.END);
            this.groupName.setText(((Object) ellipsize) + "(" + data.getGroupData().getGroupMemberSize() + ")");
        }

        public final void o(@NotNull GroupChatData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.itemView.setTag(data);
            this.groupButton.setTag(data);
            this.sortView.setTag(data);
        }

        public final void p(@NotNull final GroupChatData data) {
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(data, "data");
            o(data);
            u(data);
            QUIButton qUIButton = this.groupButton;
            if (!data.getIsSorting()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qUIButton.setVisibility(i3);
            if (data.getIsBindGroup()) {
                this.groupButton.setType(1);
                this.groupButton.setText("\u79fb\u51fa");
            } else {
                this.groupButton.setType(0);
                this.groupButton.setText("\u5c55\u793a");
            }
            if (data.getIsBindLimited()) {
                this.groupButton.setBackgroundDisabled();
            } else {
                this.groupButton.o();
            }
            View view = this.sortView;
            if (data.getIsSorting()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            view.setVisibility(i16);
            this.groupName.post(new Runnable() { // from class: yy1.c
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatAdapterDelegate.a.q(GroupChatAdapterDelegate.a.this, data);
                }
            });
            this.groupAvatar.x(4, String.valueOf(data.getGroupData().getGroupCode()), null);
            if ((data.getGroupData().getGroupFlag() & 128) > 0) {
                TextView textView = this.groupName;
                textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
                this.groupBanTips.setVisibility(0);
                this.groupAvatar.setAlpha(0.5f);
                return;
            }
            TextView textView2 = this.groupName;
            textView2.setTextColor(textView2.getResources().getColor(R.color.qui_common_text_primary));
            this.groupBanTips.setVisibility(8);
            this.groupAvatar.setAlpha(1.0f);
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final QUIButton getGroupButton() {
            return this.groupButton;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final View getSortView() {
            return this.sortView;
        }

        public final void u(@NotNull GroupChatData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            y yVar = y.f233563a;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            yVar.b(itemView, data.getPositionType());
        }
    }

    public GroupChatAdapterDelegate(@NotNull GuildBindGroupSettingFragment.a eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.setting.group.a item, @NotNull List<? extends com.tencent.mobileqq.guild.setting.group.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GroupChatData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if ((tag instanceof GroupChatData) && !QQGuildUIUtil.v()) {
            if (v3.getId() == R.id.b_7) {
                this.eventHandler.c().invoke(tag);
            } else if (v3.getId() == R.id.vta) {
                this.eventHandler.g().invoke(tag);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GroupChatData item, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            holder.p(item);
        } else if (payloads.contains(5)) {
            holder.u(item);
        } else {
            holder.o(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.egu, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026tent_view, parent, false)");
        a aVar = new a(inflate, this.eventHandler);
        aVar.itemView.setOnClickListener(this);
        aVar.getGroupButton().setOnClickListener(this);
        return aVar;
    }
}

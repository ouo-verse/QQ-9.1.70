package com.tencent.mobileqq.guild.setting.group.adapterDelegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.setting.group.BindGroupGroupData;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.UnbindGroupAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.y;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J(\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rH\u0014J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/UnbindGroupAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/setting/group/b;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/UnbindGroupAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", "holder", "", "isCollapse", "", ReportConstant.COSTREPORT_PREFIX, "u", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "", "payloads", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "d", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class UnbindGroupAdapterDelegate extends AbsListItemAdapterDelegate<BindGroupGroupData, com.tencent.mobileqq.guild.setting.group.a, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildBindGroupSettingFragment.a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/UnbindGroupAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "collapseIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "groupName", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView collapseIcon;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView groupName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.u0i);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.collapse_icon)");
            this.collapseIcon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.group_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.group_name)");
            this.groupName = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getCollapseIcon() {
            return this.collapseIcon;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getGroupName() {
            return this.groupName;
        }
    }

    public UnbindGroupAdapterDelegate(@NotNull GuildBindGroupSettingFragment.a eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    private final void s(final a holder, final boolean isCollapse) {
        u(holder, isCollapse);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: yy1.e
            @Override // java.lang.Runnable
            public final void run() {
                UnbindGroupAdapterDelegate.t(UnbindGroupAdapterDelegate.a.this, this, isCollapse);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(a holder, UnbindGroupAdapterDelegate this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = holder.getCollapseIcon().getTag();
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return;
        }
        this$0.u(holder, z16);
    }

    private final void u(a holder, boolean isCollapse) {
        float f16;
        GuildUIUtils.d(holder.getCollapseIcon(), R.drawable.guild_bind_group_icon, Integer.valueOf(R.color.qui_common_icon_secondary));
        ImageView collapseIcon = holder.getCollapseIcon();
        if (isCollapse) {
            f16 = 0.0f;
        } else {
            f16 = 90.0f;
        }
        collapseIcon.setRotation(f16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if ((tag instanceof BindGroupGroupData) && v3.getId() == R.id.b_7) {
            this.eventHandler.e().invoke(((BindGroupGroupData) tag).getGroupType());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.setting.group.a item, @NotNull List<? extends com.tencent.mobileqq.guild.setting.group.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof BindGroupGroupData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull BindGroupGroupData item, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(item);
        if (!payloads.contains(6) && !payloads.contains(7)) {
            u(holder, item.getIsCollapse());
        } else {
            s(holder, item.getIsCollapse());
        }
        holder.getGroupName().setText(item.g());
        y yVar = y.f233563a;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        yVar.b(view, item.getPositionType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.egw, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026roup_item, parent, false)");
        a aVar = new a(inflate);
        aVar.itemView.setOnClickListener(this);
        return aVar;
    }
}

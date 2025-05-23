package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GroupSelectType;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskGroupData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskGroupAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001f B\u001b\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\nH\u0014R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/delegate/GuildRiskGroupAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/delegate/GuildRiskGroupAdapterDelegate$b;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "d", "Lkotlin/jvm/functions/Function1;", NodeProps.ON_CLICK, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRiskGroupAdapterDelegate extends AbsListItemAdapterDelegate<GuildRiskGroupData, e, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<GroupSelectType, Unit> onClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/delegate/GuildRiskGroupAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setGroupName", "(Landroid/widget/TextView;)V", "groupName", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setSelectType", "selectType", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView groupName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView selectType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.group_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.group_name)");
            this.groupName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f82474gz);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.select_type)");
            this.selectType = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getGroupName() {
            return this.groupName;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getSelectType() {
            return this.selectType;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildRiskGroupAdapterDelegate(@NotNull Function1<? super GroupSelectType, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(View view) {
        Map<String, ? extends Object> mapOf;
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag();
            if (!(tag instanceof GroupSelectType)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onClick invalid, data:" + tag;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildRiskGroupAdapterDelegate", 1, (String) it.next(), null);
                }
                return;
            }
            g gVar = g.f234195a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_name", ((GroupSelectType) tag).getText()));
            gVar.a(view, "clck", "em_sgrp_select_or_cancel_all", mapOf);
            this.onClick.invoke(tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildRiskGroupAdapterDelegate this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull e item, @NotNull List<? extends e> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildRiskGroupData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildRiskGroupData item, @NotNull b holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.getGroupName().setText(item.getGroupName());
        holder.getSelectType().setText(item.getSelectType().getText());
        holder.getSelectType().setTag(item.getSelectType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f4o, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026roup_item, parent, false)");
        b bVar = new b(inflate);
        bVar.getSelectType().setOnClickListener(new View.OnClickListener() { // from class: oz1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRiskGroupAdapterDelegate.t(GuildRiskGroupAdapterDelegate.this, view);
            }
        });
        return bVar;
    }
}

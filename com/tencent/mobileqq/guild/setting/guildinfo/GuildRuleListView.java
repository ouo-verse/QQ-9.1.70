package com.tencent.mobileqq.guild.setting.guildinfo;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\n\u001a\u00060\u0007R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "rules", "", "setRules", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView$b;", "f", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView$b;", "myAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRuleListView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b myAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView$b$a;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView;", "", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "newData", "", "updateData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "data", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b extends RecyclerView.Adapter<a> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<ProfileRuleData> data = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020\t\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001f\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "data", "", "position", "", "l", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "E", "Landroid/view/View;", "getRuleTitleContainer", "()Landroid/view/View;", "ruleTitleContainer", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "getOrderNumber", "()Landroid/widget/TextView;", "orderNumber", "G", "getRuleTitle", "ruleTitle", "H", "getRuleTitleLeftExpand", "ruleTitleLeftExpand", "I", "getRuleDesc", "ruleDesc", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "getExpandView", "()Landroid/widget/ImageView;", "expandView", "itemView", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView$b;Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public final class a extends RecyclerView.ViewHolder implements View.OnClickListener {

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final View ruleTitleContainer;

            /* renamed from: F, reason: from kotlin metadata */
            @NotNull
            private final TextView orderNumber;

            /* renamed from: G, reason: from kotlin metadata */
            @NotNull
            private final TextView ruleTitle;

            /* renamed from: H, reason: from kotlin metadata */
            @NotNull
            private final TextView ruleTitleLeftExpand;

            /* renamed from: I, reason: from kotlin metadata */
            @NotNull
            private final TextView ruleDesc;

            /* renamed from: J, reason: from kotlin metadata */
            @NotNull
            private final ImageView expandView;
            final /* synthetic */ b K;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.K = bVar;
                View findViewById = itemView.findViewById(R.id.f787247u);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.rule_title_container)");
                this.ruleTitleContainer = findViewById;
                View findViewById2 = itemView.findViewById(R.id.f2146013);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.order_number)");
                TextView textView = (TextView) findViewById2;
                this.orderNumber = textView;
                View findViewById3 = itemView.findViewById(R.id.f787147t);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.rule_title)");
                this.ruleTitle = (TextView) findViewById3;
                View findViewById4 = itemView.findViewById(R.id.f787347v);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.rule_title_left_expand)");
                this.ruleTitleLeftExpand = (TextView) findViewById4;
                View findViewById5 = itemView.findViewById(R.id.f786647o);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.rule_desc)");
                this.ruleDesc = (TextView) findViewById5;
                View findViewById6 = itemView.findViewById(R.id.uyd);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.expand_view)");
                ImageView imageView = (ImageView) findViewById6;
                this.expandView = imageView;
                imageView.setOnClickListener(this);
                findViewById.setOnClickListener(this);
                textView.setTypeface(u.f234280a.a());
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void l(@NotNull ProfileRuleData data, int position) {
                int i3;
                String desc;
                boolean z16;
                boolean z17;
                Intrinsics.checkNotNullParameter(data, "data");
                this.expandView.setTag(data);
                this.ruleTitleContainer.setTag(data);
                this.orderNumber.setText(String.valueOf(position + 1));
                TextView textView = this.ruleDesc;
                if (data.getIsExpand()) {
                    String desc2 = data.getDesc();
                    if (desc2 != null && desc2.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        i3 = 0;
                        textView.setVisibility(i3);
                        desc = data.getDesc();
                        if (desc == null && desc.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            this.ruleTitleContainer.setClickable(false);
                            this.expandView.setVisibility(8);
                            this.ruleTitleLeftExpand.setVisibility(8);
                            this.ruleDesc.setVisibility(8);
                            this.ruleTitle.setVisibility(0);
                            this.ruleTitle.setText(data.getTitle());
                            return;
                        }
                        this.ruleTitleContainer.setClickable(true);
                        this.expandView.setVisibility(0);
                        this.ruleTitleLeftExpand.setVisibility(0);
                        this.ruleTitleLeftExpand.setText(data.getTitle());
                        this.ruleTitle.setVisibility(8);
                        if (data.getIsExpand()) {
                            this.ruleDesc.setVisibility(0);
                            this.ruleDesc.setText(data.getDesc());
                            GuildUIUtils.d(this.expandView, R.drawable.qui_chevron_up, Integer.valueOf(R.color.qui_common_icon_secondary));
                            return;
                        } else {
                            this.ruleDesc.setVisibility(8);
                            GuildUIUtils.d(this.expandView, R.drawable.qui_chevron_down, Integer.valueOf(R.color.qui_common_icon_secondary));
                            return;
                        }
                    }
                }
                i3 = 8;
                textView.setVisibility(i3);
                desc = data.getDesc();
                if (desc == null) {
                }
                z16 = true;
                if (!z16) {
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(@NotNull View v3) {
                EventCollector.getInstance().onViewClickedBefore(v3);
                Intrinsics.checkNotNullParameter(v3, "v");
                if (!com.tencent.mobileqq.guild.util.o.d("GuildRuleListView", 100L)) {
                    Object tag = v3.getTag();
                    if (tag instanceof ProfileRuleData) {
                        bt.h(bt.f235484a, v3, "em_sgrp_channel_rule", "clck", null, 8, null);
                        ((ProfileRuleData) tag).c(!r0.getIsExpand());
                        this.K.notifyDataSetChanged();
                    }
                }
                EventCollector.getInstance().onViewClicked(v3);
            }
        }

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.data.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull a holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            ProfileRuleData profileRuleData = this.data.get(position);
            Intrinsics.checkNotNullExpressionValue(profileRuleData, "data[position]");
            holder.l(profileRuleData, position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(GuildRuleListView.this.getContext()).inflate(R.layout.f2u, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026                   false)");
            return new a(this, inflate);
        }

        public final void updateData(@NotNull List<ProfileRuleData> newData) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            this.data.clear();
            this.data.addAll(newData);
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRuleListView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setRules(@NotNull List<ProfileRuleData> rules) {
        Intrinsics.checkNotNullParameter(rules, "rules");
        this.myAdapter.updateData(rules);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRuleListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildRuleListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildRuleListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.b(8));
        gradientDrawable.setStroke(bi.a(0.5f), getResources().getColor(R.color.qui_common_border_standard));
        setBackground(gradientDrawable);
        setPadding(0, QQGuildUIUtil.f(16.0f), 0, QQGuildUIUtil.f(16.0f));
        setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        setLayoutManager(linearLayoutManager);
        b bVar = new b();
        this.myAdapter = bVar;
        setAdapter(bVar);
        addItemDecoration(new com.tencent.mobileqq.guild.widget.q(QQGuildUIUtil.f(20.0f), 0, 2, null));
    }
}

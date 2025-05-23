package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskMemberData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0002#$B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0004\b \u0010!J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bH\u0014J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0014\u0010\u001c\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/delegate/GuildRiskMemberAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/f;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/delegate/GuildRiskMemberAdapterDelegate$b;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroid/widget/CompoundButton;", "buttonView", "isChecked", "onCheckedChanged", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;", "d", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRiskMemberAdapterDelegate extends AbsListItemAdapterDelegate<GuildRiskMemberData, e, b> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e onClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/delegate/GuildRiskMemberAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "E", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "o", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setSelectBox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "selectBox", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setMemberName", "(Landroid/widget/TextView;)V", "memberName", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "G", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "l", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "setAvatarView", "(Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;)V", "avatarView", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "setSetting", "(Landroid/widget/ImageView;)V", "setting", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private QUICheckBox selectBox;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView memberName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private GuildUserAvatarView avatarView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private ImageView setting;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f82074fw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.select_checkbox)");
            this.selectBox = (QUICheckBox) findViewById;
            View findViewById2 = itemView.findViewById(R.id.eos);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.member_name)");
            this.memberName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.xsl);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.item_avatar_image_view)");
            this.avatarView = (GuildUserAvatarView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f83754ke);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.setting_icon)");
            this.setting = (ImageView) findViewById4;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final GuildUserAvatarView getAvatarView() {
            return this.avatarView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getMemberName() {
            return this.memberName;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final QUICheckBox getSelectBox() {
            return this.selectBox;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final ImageView getSetting() {
            return this.setting;
        }
    }

    public GuildRiskMemberAdapterDelegate(@NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull e item, @NotNull List<? extends e> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildRiskMemberData;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@NotNull CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        Object tag = buttonView.getTag();
        if (!(tag instanceof GuildRiskMemberData)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onClick invalid, data:" + tag;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildRiskMemberAdapterDelegate", 1, (String) it.next(), null);
            }
        } else {
            this.onClick.c(((GuildRiskMemberData) tag).getTinyId(), isChecked);
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        Map<String, ? extends Object> mapOf;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if (!(tag instanceof GuildRiskMemberData)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onClick invalid, data:" + tag + ", id:" + v3.getId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildRiskMemberAdapterDelegate", 1, (String) it.next(), null);
            }
        } else if (v3.getId() == R.id.f83754ke) {
            GuildRiskMemberData guildRiskMemberData = (GuildRiskMemberData) tag;
            this.onClick.d(guildRiskMemberData.getTinyId(), guildRiskMemberData.getNickName());
            g gVar = g.f234195a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_to_user_id", String.valueOf(guildRiskMemberData.getTinyId())));
            gVar.a(v3, "clck", "em_sgrp_more_action", mapOf);
        } else if (v3.getId() == R.id.b_7) {
            GuildRiskMemberData guildRiskMemberData2 = (GuildRiskMemberData) tag;
            if (guildRiskMemberData2.getIsEditMode()) {
                this.onClick.c(guildRiskMemberData2.getTinyId(), !guildRiskMemberData2.getIsSelect());
            } else {
                this.onClick.a(guildRiskMemberData2.getGuildId(), guildRiskMemberData2.getTinyId());
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildRiskMemberData item, @NotNull b holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.getSetting().setTag(item);
        holder.getSelectBox().setTag(item);
        holder.itemView.setTag(item);
        holder.getAvatarView().setAvatarMeta(item.getGuildId(), String.valueOf(item.getTinyId()), item.getAvatarUrl());
        holder.getMemberName().setText(item.getNickName());
        if (item.getIsEditMode()) {
            holder.getSelectBox().setVisibility(0);
            holder.getSelectBox().setOnCheckedChangeListener(null);
            holder.getSelectBox().setChecked(item.getIsSelect());
            holder.getSelectBox().setOnCheckedChangeListener(this);
            holder.getSetting().setVisibility(8);
            return;
        }
        holder.getSelectBox().setVisibility(8);
        holder.getSelectBox().setOnCheckedChangeListener(null);
        holder.getSetting().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f4r, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026mber_item, parent, false)");
        b bVar = new b(inflate);
        bVar.getSetting().setOnClickListener(this);
        bVar.itemView.setOnClickListener(this);
        return bVar;
    }
}

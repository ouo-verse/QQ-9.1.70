package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.ba;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/y;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/f;", "defaultSettingItemData", "", "p", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "l", "Lvp1/t;", "E", "Lvp1/t;", "binding", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "eventHandler", "<init>", "(Lvp1/t;Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class y extends p {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final vp1.t binding;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final g eventHandler;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y(@NotNull vp1.t binding, @NotNull g eventHandler) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        ConstraintLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(y this$0, b data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Function2<View, b, Unit> a16 = this$0.eventHandler.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            a16.invoke(it, data);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final String p(GuildCategoryChannelDefaultSettingItemData defaultSettingItemData) {
        iz1.a aVar;
        IGProJumpToCategoryInfo jumpToCategory;
        if (defaultSettingItemData.getCategoryChannel().getCategoryType() != 1 || (aVar = (iz1.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102934")) == null || !aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String() || (jumpToCategory = ((IGPSService) ch.S0(IGPSService.class, "")).getJumpToCategory(String.valueOf(defaultSettingItemData.getGuildId()))) == null) {
            return "";
        }
        ba.Companion companion = ba.INSTANCE;
        return companion.b(companion.c(aVar, jumpToCategory));
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.p
    public void l(@NotNull final b data) {
        boolean z16;
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof GuildCategoryChannelDefaultSettingItemData)) {
            return;
        }
        GuildCategoryChannelDefaultSettingItemData guildCategoryChannelDefaultSettingItemData = (GuildCategoryChannelDefaultSettingItemData) data;
        this.itemView.setBackgroundResource(m(guildCategoryChannelDefaultSettingItemData.getPositionType()));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.o(y.this, data, view);
            }
        });
        this.binding.f443098c.setText(guildCategoryChannelDefaultSettingItemData.getDefaultSettingTitle());
        String p16 = p(guildCategoryChannelDefaultSettingItemData);
        TextView textView = this.binding.f443097b;
        if (p16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = guildCategoryChannelDefaultSettingItemData.getCategoryChannel().getCategoryAlias();
        } else {
            str = guildCategoryChannelDefaultSettingItemData.getCategoryChannel().getCategoryAlias() + " - " + p16;
        }
        textView.setText(str);
        View view = this.itemView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_tab_zone_type", Integer.valueOf(guildCategoryChannelDefaultSettingItemData.getCategoryChannel().getCategoryType())));
        ch.W0(view, "em_sgrp_user_default_jump_zone", mapOf);
    }
}

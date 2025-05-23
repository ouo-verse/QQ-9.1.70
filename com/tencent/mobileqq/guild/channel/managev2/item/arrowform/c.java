package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.view.View;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.channel.manage.QQGuildChannelNameSettingFragment;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/c;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Landroid/view/View;", "view", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "p", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends h {
    private final void s(View view) {
        ChannelSettingUtils.j(view, "em_sgrp_channel_set_name", null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull View view) {
        List emptyList;
        Boolean bool;
        Pair pair;
        Intrinsics.checkNotNullParameter(view, "view");
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType() == 7) {
            String guildId = ((ChannelSettingMviContext) getMContext()).getParams().getGuildId();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(guildId);
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            String str = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            } else {
                bool = null;
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str2 = guildDebugUtils.e().get(guildId);
            if (str2 != null) {
                str = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(guildId, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                ChannelSettingUtils.j(view, "em_sgrp_section_name_set", null, 4, null);
                QQGuildChannelNameSettingFragment.Oh(((ChannelSettingMviContext) getMContext()).c().getContext(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo());
            }
        }
        s(view);
        QQGuildChannelNameSettingFragment.Oh(((ChannelSettingMviContext) getMContext()).c().getContext(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo());
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void q(@NotNull ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String channelName = context.getParams().getChannelInfo().getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "context.params.channelInfo.channelName");
        updateUI(new ChannelSettingUIState.SettingItemDescUIState(channelName));
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(permissionInfo.a(20003)));
    }
}

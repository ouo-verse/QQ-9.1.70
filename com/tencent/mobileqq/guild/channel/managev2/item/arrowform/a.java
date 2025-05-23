package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.manage.QQGuildChannelChooseCategoryFragment;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/a;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Landroid/view/View;", "view", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "p", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends h {
    private final void s(View view) {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        ChannelSettingUtils.i(view, "em_sgrp_channel_set_type", emptyMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull View view) {
        long j3;
        Intrinsics.checkNotNullParameter(view, "view");
        s(view);
        Context context = ((ChannelSettingMviContext) getMContext()).c().getContext();
        String guildId = ((ChannelSettingMviContext) getMContext()).getParams().getGuildId();
        String channelId = ((ChannelSettingMviContext) getMContext()).getParams().getChannelId();
        cy b16 = ChannelSettingUtils.b(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo());
        if (b16 != null) {
            j3 = b16.getCategoryId();
        } else {
            j3 = 0;
        }
        QQGuildChannelChooseCategoryFragment.Ih(context, guildId, channelId, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        if (r3 != null) goto L15;
     */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(@NotNull ChannelSettingMviContext context) {
        String qqStr;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        cy b16 = ChannelSettingUtils.b(context.getParams().getChannelInfo());
        if (b16 != null && (qqStr = b16.getCategoryName()) != null) {
            if (qqStr.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                qqStr = HardCodeUtil.qqStr(R.string.f141790hm);
            }
        }
        qqStr = HardCodeUtil.qqStr(R.string.f141790hm);
        Intrinsics.checkNotNullExpressionValue(qqStr, "ChannelSettingUtils.getC\u2026ld_channel_none_category)");
        updateUI(new ChannelSettingUIState.SettingItemDescUIState(qqStr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        String guildId = ((ChannelSettingMviContext) getMContext()).getParams().getGuildId();
        boolean z17 = false;
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getIsCategoryAdmin() == 1) {
            ArrayList<Long> guildUserChannelCategoryAdminList = iGPSService.getGuildUserChannelCategoryAdminList(guildId, iGPSService.getSelfTinyId());
            if (guildUserChannelCategoryAdminList != null) {
                i3 = guildUserChannelCategoryAdminList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 1) {
                z16 = true;
                if (!ch.t0(((ChannelSettingMviContext) getMContext()).getParams().getGuildInfo()) || z16) {
                    z17 = true;
                }
                updateUI(new ChannelSettingUIState.SettingItemEnableUIState(z17));
            }
        }
        z16 = false;
        if (!ch.t0(((ChannelSettingMviContext) getMContext()).getParams().getGuildInfo())) {
        }
        z17 = true;
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(z17));
    }
}

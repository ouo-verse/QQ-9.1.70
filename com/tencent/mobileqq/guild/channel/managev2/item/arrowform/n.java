package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.widget.GuildRoleModifyTalkModeFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/n;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Landroid/view/View;", "view", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "p", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n extends h {
    /* JADX WARN: Multi-variable type inference failed */
    private final void s(View view) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_speakmode_set", Integer.valueOf(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getVoiceSpeakModeCfg().getSpeakMode())));
        ChannelSettingUtils.i(view, "em_sgrp_channel_set_speakmode", mapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        s(view);
        bw.j1(true);
        updateUI(new ChannelSettingUIState.SettingItemRedDotUIState(false));
        if (ChannelSettingUtils.c(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId())) {
            QQToastUtil.showQQToast(R.string.f157581na);
            Logger.f235387a.d().w("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, "SpeakModeClick, but isMiniGameChannelState. return.");
        } else {
            GuildRoleModifyTalkModeFragment.Companion companion = GuildRoleModifyTalkModeFragment.INSTANCE;
            FragmentActivity requireActivity = ((ChannelSettingMviContext) getMContext()).c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
            companion.b(requireActivity, ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo());
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void q(@NotNull ChannelSettingMviContext context) {
        String qqStr;
        Intrinsics.checkNotNullParameter(context, "context");
        int n3 = MediaChannelUtils.f228046a.n(context.getParams().getChannelId());
        if (n3 != 2) {
            if (n3 != 4) {
                qqStr = HardCodeUtil.qqStr(R.string.f140400dv);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f140420dx);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f140440dz);
        }
        Intrinsics.checkNotNullExpressionValue(qqStr, "when (MediaChannelUtils.\u2026speech)\n                }");
        updateUI(new ChannelSettingUIState.SettingItemDescUIState(qqStr));
        updateUI(new ChannelSettingUIState.SettingItemRedDotUIState(!bw.n0()));
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(permissionInfo.a(20012)));
    }
}

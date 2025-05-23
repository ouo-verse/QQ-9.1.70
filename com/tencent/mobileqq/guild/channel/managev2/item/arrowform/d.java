package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/d;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "Landroid/view/View;", "view", "p", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends h {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getLiveRoomId() > 0) {
            QQToastUtil.showQQToast(R.string.f1519118z);
            return;
        }
        Context context = ((ChannelSettingMviContext) getMContext()).c().getContext();
        if (context != null) {
            GuildOpenBindPermissionUtils.u(context, ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo());
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void q(@NotNull ChannelSettingMviContext context) {
        String desc;
        Intrinsics.checkNotNullParameter(context, "context");
        int channelLiveableType = context.getParams().getChannelInfo().getChannelLiveableType();
        if (channelLiveableType != 0) {
            if (channelLiveableType != 1) {
                desc = "";
            } else {
                desc = HardCodeUtil.qqStr(R.string.f139560bl);
            }
        } else {
            desc = HardCodeUtil.qqStr(R.string.f156951ll);
        }
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        updateUI(new ChannelSettingUIState.SettingItemDescUIState(desc));
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(permissionInfo.a(20012)));
    }
}

package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.guild.mainframe.i f227458a;

    public h(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227458a = iVar;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    public void a(Bundle bundle) {
        if (this.f227458a != null && bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString("guildId", "");
            String string2 = bundle.getString("channelId", "");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                IGPSService iGPSService = (IGPSService) this.f227458a.getApp().getRuntimeService(IGPSService.class, "");
                IGProChannelInfo channelInfo = iGPSService.getChannelInfo(string2);
                IGProGuildInfo guildInfo = iGPSService.getGuildInfo(string);
                if (guildInfo != null && channelInfo != null) {
                    if (channelInfo.getType() != 8) {
                        GuildAppReportSourceInfo f06 = this.f227458a.f0();
                        String string3 = bundle.getString("sgrp_stream_pgin_source_name");
                        if (bundle.getInt("openGuildFrom") == 1) {
                            f06.addReportItem("sgrp_stream_pgin_source_name", "qq_push");
                        } else if (!TextUtils.isEmpty(string3)) {
                            f06.addReportItem("sgrp_stream_pgin_source_name", string3);
                        }
                        bundle.putParcelable("GuildAppReportSourceInfo", f06);
                        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(BaseApplication.getContext(), guildInfo, channelInfo, bundle);
                        return;
                    }
                    return;
                }
                QLog.i("Guild.jump.OpenAudioChannelJumper", 1, "handleAction: guild info or channel info is null");
                return;
            }
            QLog.i("Guild.jump.OpenAudioChannelJumper", 1, "handleAction: guildId or channelId is null");
        }
    }
}

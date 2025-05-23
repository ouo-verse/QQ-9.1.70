package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m implements c {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.mainframe.i f227463a;

    public m(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227463a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        GuildCenterPanelController Z0;
        com.tencent.mobileqq.guild.mainframe.i iVar = this.f227463a;
        if (iVar != null && (Z0 = iVar.Z0()) != null) {
            Z0.z(1);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    public void a(Bundle bundle) {
        String str;
        int i3;
        int i16;
        IGPSService iGPSService = (IGPSService) this.f227463a.getApp().getRuntimeService(IGPSService.class, "");
        Intent intent = this.f227463a.getActivity().getIntent();
        String stringExtra = intent.getStringExtra("guild_id");
        String stringExtra2 = intent.getStringExtra("uin");
        String stringExtra3 = intent.getStringExtra("uinname");
        IGProAppChnnPreInfo appChnnPreInfo = iGPSService.getAppChnnPreInfo(stringExtra, stringExtra2);
        if (appChnnPreInfo != null) {
            i16 = (int) appChnnPreInfo.getAppid();
            str = appChnnPreInfo.getJumpUrl();
            i3 = appChnnPreInfo.getJumpType();
        } else {
            str = null;
            i3 = 0;
            i16 = IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE;
        }
        Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra != null) {
            String string = bundleExtra.getString(WadlProxyConsts.KEY_JUMP_URL);
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            i3 = bundleExtra.getInt("schemaType");
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.jump.OpenGuildScheduleJumper", 1, "OpenGuildScheduleJumper guild:" + stringExtra + ",channelId:" + stringExtra2 + ",jumpUrl:" + str + ",type:" + i3);
        }
        kg1.a.d(this.f227463a.getActivity(), new GuildClientParams().a(i16).e0(stringExtra).f(stringExtra2).g(stringExtra3).i0(i3).j0(str).e());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c();
            }
        }, 0L);
    }
}

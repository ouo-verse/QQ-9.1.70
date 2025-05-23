package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k implements c {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.mainframe.i f227461a;

    public k(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227461a = iVar;
    }

    private void b(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("guild_id", str);
        bundle2.putString("channelId", str2);
        bundle2.putAll(bundle);
        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedSquareFragment(this.f227461a.getActivity(), bundle2);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    public void a(Bundle bundle) {
        int i3;
        if (bundle != null && this.f227461a != null) {
            String string = bundle.getString("guildid");
            String string2 = bundle.getString("channelid");
            String string3 = bundle.getString("from");
            boolean z16 = bundle.getBoolean("openFeedSquare", false);
            GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
            QLog.i("Guild.jump.OpenGuildChannelJumper", 1, "handle jump action |guildId=" + string + " |channelId=" + string2 + " |from=" + string3 + " |openFeedSquare=" + z16 + " |jumpSourceExtra=" + guildAppReportSourceInfo);
            if (ch.j0(string)) {
                QLog.e("Guild.jump.OpenGuildChannelJumper", 1, "not member can't jump |guildId=", string, " |channelId=" + string2);
                QQToastUtil.showQQToast(0, R.string.f144340oi);
                return;
            }
            if (guildAppReportSourceInfo != null) {
                this.f227461a.R(guildAppReportSourceInfo);
            }
            this.f227461a.h(1, string, guildAppReportSourceInfo);
            this.f227461a.Z0().r();
            if (z16) {
                b(string, string2, bundle);
                return;
            }
            if (GuildMainFrameUtils.q(string2)) {
                return;
            }
            if (ch.C(this.f227461a.getApp(), string, string2) == null) {
                QLog.w("Guild.jump.OpenGuildChannelJumper", 1, "can't find channelInfo with |guildId=" + string + " |channelId=" + string2);
                QQToastUtil.showQQToast(0, R.string.f157411mu);
                return;
            }
            if (o02.a.c()) {
                i3 = o02.a.b();
            } else {
                i3 = 7;
            }
            Bundle a16 = o02.a.a(i3);
            a16.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
            gr1.a.c(this.f227461a, string, string2, a16);
            return;
        }
        QLog.e("Guild.jump.OpenGuildChannelJumper", 1, "handleAction params error extra:", bundle);
    }
}

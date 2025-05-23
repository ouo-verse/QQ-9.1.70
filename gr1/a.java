package gr1;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.e;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import dq1.k;
import yq1.j;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static boolean a(FacadeArgsData facadeArgsData) {
        if (facadeArgsData != null && facadeArgsData.f227655d == 0) {
            return true;
        }
        return false;
    }

    public static void b(com.tencent.mobileqq.guild.mainframe.a aVar, String str, String str2, Bundle bundle) {
        if (aVar instanceof e) {
            c(((e) aVar).b(), str, str2, bundle);
            return;
        }
        QBaseActivity activity = aVar.getActivity();
        if (activity == null) {
            s.e("Guild.MF.GuildMainChannelHelper", "openChannel activity is null", new NullPointerException());
        } else {
            k.b(str, str2, bundle).jump(activity);
        }
    }

    public static void c(i iVar, String str, String str2, Bundle bundle) {
        QBaseActivity activity = iVar.getActivity();
        IGPSService iGPSService = (IGPSService) iVar.getApp().getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str2);
        if (guildInfo != null && channelInfo != null) {
            QLog.d("Guild.MF.GuildMainChannelHelper", 1, "open channel, guildName: " + guildInfo.getGuildName() + ", channel: " + channelInfo.getChannelName() + ", type: " + channelInfo.getType());
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).closeGuildSearchPageIfNeed();
            int type = channelInfo.getType();
            j a16 = yq1.a.b().a(type);
            if (a16 == null) {
                ch.f1(activity.getString(R.string.f158101op));
                QLog.e("Guild.MF.GuildMainChannelHelper", 1, "openChannel error param. channelType=" + type);
                return;
            }
            a16.a(iVar, channelInfo, bundle);
            return;
        }
        QLog.e("Guild.MF.GuildMainChannelHelper", 1, "openChannel error param");
        ch.f1(activity.getString(R.string.f155231gy));
    }
}

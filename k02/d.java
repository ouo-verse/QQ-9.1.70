package k02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.mobileqq.guild.nt.misc.api.IContactUtilsApi;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements b.InterfaceC7909b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildMiniAppShareData f411364a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f411365b;

        a(GuildMiniAppShareData guildMiniAppShareData, IGProChannelInfo iGProChannelInfo) {
            this.f411364a = guildMiniAppShareData;
            this.f411365b = iGProChannelInfo;
        }

        @Override // com.tencent.mobileqq.guild.usecases.b.InterfaceC7909b
        public void a(@NonNull ri1.a aVar, @Nullable b.c cVar) {
            int i3 = aVar.f431477a;
            if (i3 == 0 && cVar != null) {
                this.f411364a.shareUrlInfo = new GuildMiniAppShareData.a(cVar.f235319a, cVar.f235320b, cVar.f235321c, cVar.f235322d);
            } else {
                GuildMiniAppShareData guildMiniAppShareData = this.f411364a;
                guildMiniAppShareData.fetchShareInfoErrorCode = i3;
                guildMiniAppShareData.fetchShareInfoErrorWhat = (IGProSecurityResult) aVar.f431479c;
                guildMiniAppShareData.fetchShareInfoErrorMessage = aVar.f431478b;
            }
            bw.z1(this.f411365b.getChannelUin(), new Gson().toJson(this.f411364a));
        }
    }

    public static void a(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, boolean z16) {
        GuildMiniAppShareData guildMiniAppShareData = new GuildMiniAppShareData(iGProGuildInfo, iGProChannelInfo);
        guildMiniAppShareData.creatorName = ((IGPSService) ch.S0(IGPSService.class, "")).getSelfGuildMemberName(iGProGuildInfo.getGuildID());
        guildMiniAppShareData.selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        guildMiniAppShareData.invitorName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(ch.l().getAccount(), false);
        guildMiniAppShareData.isGuest = z16;
        com.tencent.mobileqq.guild.usecases.b.g(iGProGuildInfo, iGProChannelInfo, 0, new a(guildMiniAppShareData, iGProChannelInfo));
    }
}

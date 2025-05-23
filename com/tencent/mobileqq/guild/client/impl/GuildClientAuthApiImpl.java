package com.tencent.mobileqq.guild.client.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.IGuildClientAuthApi;
import com.tencent.mobileqq.guild.client.auth.GuildAIOClientAuthorizationDialogFragment;
import com.tencent.mobileqq.guild.client.auth.GuildClientAuthDialogParams;
import com.tencent.mobileqq.guild.config.y;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dy;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import com.tencent.qphone.base.util.QLog;
import jg1.b;
import mqq.app.AppActivity;
import vh2.be;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientAuthApiImpl implements IGuildClientAuthApi {
    public static final String TAG = "Guild.client.QQGuildAppAuthApiImpl";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements be {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f215387a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppActivity f215388b;

        a(String str, AppActivity appActivity) {
            this.f215387a = str;
            this.f215388b = appActivity;
        }

        @Override // vh2.be
        public void a(int i3, String str, String str2, int i16, boolean z16, dy dyVar, ej ejVar) {
            if (i3 != 0) {
                QLog.w(GuildClientAuthApiImpl.TAG, 1, "onGetAppAuthorizationInfo failed result=" + i3 + " error=" + str);
                return;
            }
            if (!z16 && dyVar != null) {
                GuildAIOClientAuthorizationDialogFragment.yh(this.f215388b, new GuildClientAuthDialogParams(new GuildClientParams().l(str2).e0(this.f215387a).l0(2).e()).a(dyVar.a()).b(dyVar.b()).k(dyVar.getPicUrl()).c());
                return;
            }
            QLog.w(GuildClientAuthApiImpl.TAG, 1, "onGetAppAuthorizationInfo failed result=" + i3 + " error=" + str);
        }
    }

    private void checkClientAuthorizationForAIOPlus(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        String generateJumpUrl = generateJumpUrl(qBaseActivity, guildClientParams);
        if (!TextUtils.isEmpty(generateJumpUrl)) {
            guildClientParams.j0(generateJumpUrl);
            b.c(qBaseActivity, null, guildClientParams);
        }
    }

    private void checkShowClientGuideAuthDialog(AppActivity appActivity, String str, String str2) {
        IGPSService iGPSService;
        IGProChannelInfo channelInfo;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "checkShowAuthDialog start");
        }
        if (!bx.d(str)) {
            bx.q(str);
            return;
        }
        y E = ch.E();
        if (E != null && E.f216267p) {
            return;
        }
        String clientId = getClientId(appActivity, str);
        if (!TextUtils.isEmpty(clientId) && (channelInfo = (iGPSService = (IGPSService) appActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(str2)) != null && !TextUtils.isEmpty(clientId) && !TextUtils.equals("0", clientId) && channelInfo.getType() == 1 && !getAppAuthFlag(clientId) && !bx.a(clientId)) {
            iGPSService.getAppAuthorizationInfo(clientId, 2, new a(str, appActivity));
        }
    }

    private String generateJumpUrl(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        IGPSService iGPSService = (IGPSService) qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildClientParams.G());
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(guildClientParams.u());
        if (guildInfo != null && channelInfo != null) {
            return "mqqapi://esports/team/create?guildid=" + guildInfo.getGuildID() + "&channelname=" + channelInfo.getChannelName() + "&channelid=" + channelInfo.getChannelUin();
        }
        QLog.w(TAG, 1, "generateJumpUrl guildInfo or channelInfo is null");
        return "";
    }

    private boolean getAppAuthFlag(String str) {
        return bx.j(str);
    }

    private String getClientId(AppActivity appActivity, String str) {
        IGProGuildInfo guildInfo = ((IGPSService) appActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
        if (guildInfo == null) {
            QLog.w(TAG, 1, "checkShowAuthDialog guildInfo is null");
            return "";
        }
        return guildInfo.getClientId();
    }

    @Override // com.tencent.mobileqq.guild.client.IGuildClientAuthApi
    public void clientAuthorizationForAIOPlus(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        checkClientAuthorizationForAIOPlus(qBaseActivity, guildClientParams);
    }

    @Override // com.tencent.mobileqq.guild.client.IGuildClientAuthApi
    public void openClientAuthorizationDialog(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        b.c(qBaseActivity, null, guildClientParams);
    }

    @Override // com.tencent.mobileqq.guild.client.IGuildClientAuthApi
    public void showClientGuideAuthDialog(AppActivity appActivity, String str, String str2) {
        checkShowClientGuideAuthDialog(appActivity, str, str2);
    }

    @Override // com.tencent.mobileqq.guild.client.IGuildClientAuthApi
    public void tryToRequestClientAccountList(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        b.h(qBaseActivity, null, guildClientParams);
    }
}

package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
@AbsIpcMethod.IpcMethod(singleton = false)
/* loaded from: classes13.dex */
public class as extends AbsIpcMethod {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f226319a;

    /* renamed from: b, reason: collision with root package name */
    private IGProGuildInfo f226320b;

    /* renamed from: c, reason: collision with root package name */
    private List<IGProChannelInfo> f226321c;

    /* renamed from: d, reason: collision with root package name */
    private IGPSService f226322d;

    /* renamed from: e, reason: collision with root package name */
    private AbsIpcMethod.a f226323e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements vh2.v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226324a;

        a(String str) {
            this.f226324a = str;
        }

        @Override // vh2.v
        public void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
            if (i3 == 0) {
                as.this.f226320b = iGProGuildInfo;
                as asVar = as.this;
                asVar.f226321c = asVar.f226322d.getChannelList(this.f226324a);
                if (as.this.n()) {
                    as.this.f226323e.b(null);
                    return;
                } else {
                    QLog.e("OpenGuildAIOIpcMethod", 1, "openAIO error, onFetchGuild Success but cann't openAIO");
                    as.this.f226323e.a(-203, as.this.c("\u65e0\u6548\u9891\u9053"));
                    return;
                }
            }
            QLog.e("OpenGuildAIOIpcMethod", 1, "onFetchGuildInfo error, result=", Integer.valueOf(i3), ", errMsg=", str);
            as.this.f226323e.a(i3, as.this.c(str));
        }
    }

    private void j(String str) {
        this.f226322d.fetchGuildInfoWithSource(str, 102, new a(str));
    }

    private boolean k(IGProGuildInfo iGProGuildInfo, List<IGProChannelInfo> list) {
        if (iGProGuildInfo != null && list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(IGProChannelInfo iGProChannelInfo) {
        if (!((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome() && ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(QBaseActivity.sTopActivity, new LaunchGuildChatPieParam().l(this.f226320b.getGuildID()).b(iGProChannelInfo.getChannelUin()).k(this.f226319a).r(false).o(1).a());
            return;
        }
        com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(this.f226320b.getGuildID()).b(iGProChannelInfo.getChannelUin()).d(com.tencent.guild.aio.factory.a.class.getName()).a();
        if (AppSetting.t(QBaseActivity.sTopActivity)) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(QBaseActivity.sTopActivity, a16);
        } else {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(QBaseActivity.sTopActivity, a16);
        }
    }

    private Bundle m(String str) {
        if (!TextUtils.isEmpty(str)) {
            QQGuildOpenData guildOpenDataFromApp = ((IGuildOpenApi) ch.S0(IGuildOpenApi.class, "")).getGuildOpenDataFromApp(str);
            if (guildOpenDataFromApp != null) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.Key.GUILD_FROM, "guildOpenCreate");
                bundle.putString(AppConstants.Key.GUILD_FROM_APP_NAME, guildOpenDataFromApp.appName);
                return bundle;
            }
            QLog.e("OpenGuildAIOIpcMethod", 1, "launchGuildChatPie packageId:", str, ", but dataFromApp is null");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        if (!k(this.f226320b, this.f226321c)) {
            QLog.e("OpenGuildAIOIpcMethod", 1, "tryOpenGuildAIO " + this.f226320b + "/" + this.f226321c + " isNotValid", new IllegalStateException());
            return false;
        }
        final IGProChannelInfo R = ch.R(this.f226321c);
        if (R == null) {
            QLog.e("OpenGuildAIOIpcMethod", 1, "tryOpenGuildAIO " + this.f226321c + " hasNoChannel", new NullPointerException());
            return false;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.guild.ipc.methods.ar
            @Override // java.lang.Runnable
            public final void run() {
                as.this.l(R);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.d("OpenGuildAIOIpcMethod", 2, "doInvoke: ", Arrays.toString(objArr), " hash: ", Integer.valueOf(System.identityHashCode(this)));
        }
        if (!ca.a()) {
            aVar.a(-204, c("TAB\u672a\u663e\u793a"));
            return null;
        }
        String str2 = (String) objArr[0];
        String str3 = (String) objArr[1];
        if (TextUtils.isEmpty(str2)) {
            aVar.a(-203, c("\u65e0\u6548\u9891\u9053"));
            return null;
        }
        this.f226323e = aVar;
        this.f226319a = m(str3);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        this.f226322d = iGPSService;
        this.f226320b = iGPSService.getGuildInfo(str2);
        this.f226321c = this.f226322d.getChannelList(str2);
        if (n()) {
            aVar.b(null);
            return null;
        }
        j(str2);
        return null;
    }
}

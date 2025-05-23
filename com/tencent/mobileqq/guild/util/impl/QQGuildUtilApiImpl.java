package com.tencent.mobileqq.guild.util.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.GuildToggles;
import com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.ipc.methods.g;
import com.tencent.mobileqq.guild.ipc.methods.h;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.manager.PanelState;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryAttributes;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ao;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.impl.QQGuildUtilApiImpl;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.util.y;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import eipc.EIPCResult;
import f12.f;
import f12.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import y02.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildUtilApiImpl implements IQQGuildUtilApi {
    private static final long PRELOAD_INTERVAL_NANOS = 120000000;
    private static final String TAG = "QQGuildUtilApiImpl";
    private long lastWebPreloadTime = 0;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements u {
        a() {
        }

        @Override // com.tencent.mobileqq.webview.util.u
        public void onResult(boolean z16) {
            QLog.d("QQGuildUtilApiImpl", 1, "IWebProcessManagerService startWebProcess, onResult: " + z16);
            if (!z16) {
                Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) WebProcessReceiver.class);
                intent.setAction("action_preload_guild_feed_detail");
                try {
                    BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
                } catch (Exception e16) {
                    QLog.e("QQGuildUtilApiImpl", 2, "preloadSonicSession, sendBroadcast exception, e = ", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f235566e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z16, View view) {
            super(z16);
            this.f235566e = view;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            boolean z16;
            if (loadState != null && loadState.isFinish() && option != null) {
                Bitmap resultBitMap = option.getResultBitMap();
                if (loadState == LoadState.STATE_SUCCESS && resultBitMap != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.f235566e.setBackground(new BitmapDrawable(resultBitMap));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preloadWebProcess$0() {
        if (WebAccelerateHelper.preloadBrowserView == null) {
            QLog.i("QQGuildUtilApiImpl", 1, "preloadWebProcess-preInflaterBrowserView");
            WebAccelerateHelper.preInflaterBrowserView();
        }
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    @NonNull
    public String accountUin() {
        return ch.g();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public Context appContext() {
        return ch.i();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    @NonNull
    public AppInterface appInterface() {
        return ch.l();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    @NonNull
    public AppRuntime appRuntime() {
        return ch.m();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean canSpeakInChannel(IGProChannelInfo iGProChannelInfo) {
        return ao.a(iGProChannelInfo);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean checkSecurityValid(IGProSecurityResult iGProSecurityResult) {
        return ch.p(iGProSecurityResult);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public long generateMsgUniqueId() {
        Long j06;
        w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (msgService != null && (j06 = msgService.j0(4)) != null && j06.longValue() > 0) {
            return j06.longValue();
        }
        return (((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt());
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public Fragment getGProWaitLogicFragment() {
        return new GProWaitLogicFragment();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public String getGuildAvatarUrlIPC(String str, int i3) {
        EIPCResult g16 = y.g(g.class, str, Integer.valueOf(i3));
        if (!g16.isSuccess()) {
            return "";
        }
        return g16.data.getString("get_guild_avatar_url");
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public Drawable getGuildFaceIcon(String str, int i3, Drawable drawable, boolean z16) {
        return ch.J(str, i3, drawable, z16);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public IGProChannelInfo getSubChannel(String str) {
        return ch.B(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void gotoChannelDirectly(String str, String str2, Bundle bundle) {
        y.g(h.class, str, str2, bundle);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void handleJoinGuildError(Context context, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        com.tencent.mobileqq.guild.channel.joinchannel.h.c(context, i3, str, iGProSecurityResult);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public Boolean hasTargetSecondaryPermission(int i3, String str, String str2) {
        boolean z16;
        IRoleGroupListRepository a16 = s.a();
        if (!a16.getGuildPermission(str).a(i3) && !a16.getChannelPermission(str, str2).a(i3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isAdminUser(IGProUserInfo iGProUserInfo) {
        return ch.f0(iGProUserInfo);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isChannelLevelAdmin(String str) {
        return ch.h0(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isEnableMarkdown() {
        return !QQGuildMCParser.INSTANCE.a("100568", "disableMarkdownVersion").contains(AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isGProNotReady() {
        if (((IGProSession) ch.R0(IGProSession.class)).getGproStartCountDownLatch().getCount() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isGuildAIOVisible() {
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isLiveChannelOpen() || GuildMainFrameManager.g() == PanelState.AIO_SHOWING) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isGuildOrChannelManager(String str, String str2) {
        if (!ch.m0(str) && !ch.h0(str2)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isInNightTheme() {
        return GuildThemeManager.f235286a.b();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isManageReportEnabled() {
        return q.g();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isPerformanceReportEnabled() {
        return q.h();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isQQGuildManager(IGProGuildInfo iGProGuildInfo) {
        return ch.t0(iGProGuildInfo);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isRecentChannelHeadExperiment() {
        return c.a();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isShowSetGlobalTop() {
        return ch.z0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public boolean isTroopGuildUpgradeSwitchOn() {
        return QQGuildMCParser.INSTANCE.c("100530", "GroupGuildUpgradeFetchSwitch", false);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void loadBackgroundImage(String str, View view) {
        Option url = Option.obtain().setUrl(str);
        if (view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            url.setRequestWidth(layoutParams.width).setRequestHeight(layoutParams.height);
        }
        e.a().f(url, new b(true, view));
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void loadImage(String str, ImageView imageView) {
        v.i(str, imageView);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void loadImageWithLoading(String str, ImageView imageView, Drawable drawable) {
        v.k(str, imageView, drawable);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void noteTextChannelStatus(boolean z16) {
        f.f397616a.g("text_channel", z16);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void notifyDirectMsgSwitchStatus(boolean z16) {
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).c3(z16);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void notifyForwardFinish() {
        com.tencent.mobileqq.guild.message.serversendarkmsg.b.a();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void preloadWebProcess() {
        if (MobileQQ.sProcessId != 1) {
            QLog.e("QQGuildUtilApiImpl", 1, "preloadWebProcess can only be called in main process!!");
            return;
        }
        if (GuildToggles.d()) {
            QLog.i("QQGuildUtilApiImpl", 1, "preloadWebProcess, disabled");
            return;
        }
        if (System.nanoTime() - this.lastWebPreloadTime < PRELOAD_INTERVAL_NANOS) {
            QLog.i("QQGuildUtilApiImpl", 1, "preloadWebProcess, just preloaded, skip");
            return;
        }
        this.lastWebPreloadTime = System.nanoTime();
        QLog.i("QQGuildUtilApiImpl", 1, "preloadWebProcess start " + this.lastWebPreloadTime);
        IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) runtimeService(IWebProcessManagerService.class, "");
        if (iWebProcessManagerService != null) {
            iWebProcessManagerService.startWebProcess(8, new a());
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: c12.b
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildUtilApiImpl.lambda$preloadWebProcess$0();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public <T extends IRuntimeService> T runtimeService(@NonNull Class<T> cls, String str) {
        return (T) ch.S0(cls, str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void setMetricDefaultAttributes(Map<String, String> map) {
        q.m(map);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void startH5Activity(Activity activity, String str) {
        ch.i1(activity, str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void telemetryReport(GuildTelemetryTask guildTelemetryTask, Map<GuildTelemetryAttributes, String> map) {
        HashMap hashMap = new HashMap();
        for (GuildTelemetryAttributes guildTelemetryAttributes : map.keySet()) {
            hashMap.put(guildTelemetryAttributes.getAttrName(), map.get(guildTelemetryAttributes));
        }
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent(guildTelemetryTask.getTaskName(), hashMap);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public void toastError(@NonNull Activity activity, int i3, String str) {
        ch.q1(activity, i3, str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUtilApi
    public <T extends IRuntimeService> T runtimeService(@NonNull Class<T> cls) {
        return (T) ch.R0(cls);
    }
}

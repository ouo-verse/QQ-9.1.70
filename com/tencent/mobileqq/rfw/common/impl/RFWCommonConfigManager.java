package com.tencent.mobileqq.rfw.common.impl;

import android.os.Handler;
import com.google.gson.Gson;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.IpPortMappingConfig;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rfw.common.impl.request.RFWCommonConfigRequest;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudDomainip$DomainIPInfo;
import feedcloud.FeedCloudDomainip$DomainIPRsp;
import feedcloud.FeedCloudDomainip$IP;
import feedcloud.FeedCloudSwitch$SwitchRsp;
import feedcloud.FeedCloudUsersettings$Entry;
import feedcloud.FeedCloudUsersettings$GetUsersettingsRsp;
import feedcloud.FeedCloudUsersettings$Interval;
import feedcloud.FeedCloudUsersettings$SettingsInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/rfw/common/impl/RFWCommonConfigManager;", "", "", "visitScene", "", "p", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "success", "", "retCode", "Lfeedcloud/FeedCloudUsersettings$GetUsersettingsRsp;", "rsp", "i", DomainData.DOMAIN_NAME, "l", "Lfeedcloud/FeedCloudUsersettings$Interval;", WidgetCacheConstellationData.INTERVAL, h.F, "", "Lfeedcloud/FeedCloudUsersettings$Entry;", "attachInfo", "f", "Lfeedcloud/FeedCloudUsersettings$SettingsInfo;", "infoList", "g", "info", "k", "e", "o", "a", "J", "homeInterval", "b", "pollingInterval", "c", "lastHomeTime", "d", "lastPollingTime", "Ljava/util/List;", "", "Ljava/lang/String;", "lastUin", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "pollingTask", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "rfw-common-config-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RFWCommonConfigManager {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Lazy<RFWCommonConfigManager> f281300j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long homeInterval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long pollingInterval;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastHomeTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastPollingTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<FeedCloudUsersettings$Entry> attachInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable pollingTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/rfw/common/impl/RFWCommonConfigManager$a;", "", "Lcom/tencent/mobileqq/rfw/common/impl/RFWCommonConfigManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/rfw/common/impl/RFWCommonConfigManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rfw-common-config-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.rfw.common.impl.RFWCommonConfigManager$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final RFWCommonConfigManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RFWCommonConfigManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (RFWCommonConfigManager) RFWCommonConfigManager.f281300j.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<RFWCommonConfigManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) RFWCommonConfigManager$Companion$instance$2.INSTANCE);
        f281300j = lazy;
    }

    public /* synthetic */ RFWCommonConfigManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    private final void e(FeedCloudUsersettings$SettingsInfo info) {
        FeedCloudDomainip$DomainIPRsp feedCloudDomainip$DomainIPRsp = new FeedCloudDomainip$DomainIPRsp();
        try {
            feedCloudDomainip$DomainIPRsp.mergeFrom(info.bizData.get().toByteArray());
            if (feedCloudDomainip$DomainIPRsp.infos.get().isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (FeedCloudDomainip$DomainIPInfo feedCloudDomainip$DomainIPInfo : feedCloudDomainip$DomainIPRsp.infos.get()) {
                ArrayList arrayList2 = new ArrayList();
                for (FeedCloudDomainip$IP feedCloudDomainip$IP : feedCloudDomainip$DomainIPInfo.ips.get()) {
                    String str = feedCloudDomainip$IP.f398430ip.get();
                    Intrinsics.checkNotNullExpressionValue(str, "ip.ip.get()");
                    arrayList2.add(new IpPortMappingConfig(str, feedCloudDomainip$IP.port.get()));
                }
                String str2 = feedCloudDomainip$DomainIPInfo.domain.get();
                Intrinsics.checkNotNullExpressionValue(str2, "ipInfo.domain.get()");
                arrayList.add(new IpConnectConfig(str2, arrayList2));
            }
            com.tencent.mobileqq.rfw.common.api.b.c("rfw_ip_config", new Gson().toJson(arrayList));
        } catch (InvalidProtocolBufferMicroException e16) {
            throw new RuntimeException(e16);
        }
    }

    private final void f(List<FeedCloudUsersettings$Entry> attachInfo) {
        if (attachInfo.isEmpty()) {
            return;
        }
        this.attachInfo = attachInfo;
    }

    private final void g(List<FeedCloudUsersettings$SettingsInfo> infoList) {
        for (FeedCloudUsersettings$SettingsInfo feedCloudUsersettings$SettingsInfo : infoList) {
            if (feedCloudUsersettings$SettingsInfo.mainType.get() == 101) {
                k(feedCloudUsersettings$SettingsInfo);
            } else if (feedCloudUsersettings$SettingsInfo.mainType.get() == 102) {
                e(feedCloudUsersettings$SettingsInfo);
            }
        }
    }

    private final void h(FeedCloudUsersettings$Interval interval) {
        if (interval.homeSwitch.get() != 0) {
            this.homeInterval = interval.homeSwitch.get() * 1000;
        }
        if (interval.polling.get() != 0) {
            this.pollingInterval = interval.polling.get() * 1000;
        }
        QLog.d("RFWCommonConfigManager", 1, "handleInterval homeInterval:" + this.homeInterval + " pollingInterval:" + this.pollingInterval);
    }

    private final void i(BaseRequest request, boolean success, long retCode, final FeedCloudUsersettings$GetUsersettingsRsp rsp) {
        if (!success || retCode != 0 || !(request instanceof VSBaseRequest)) {
            return;
        }
        VSBaseRequest vSBaseRequest = (VSBaseRequest) request;
        if (vSBaseRequest.getTrpcRspRetCode() == 0 && vSBaseRequest.getTrpcRspFuncRetCode() == 0) {
            if (rsp == null) {
                return;
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.rfw.common.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    RFWCommonConfigManager.j(RFWCommonConfigManager.this, rsp);
                }
            });
            return;
        }
        QLog.e("RFWCommonConfigManager", 1, "handleResponse trpcRspRetCode:" + vSBaseRequest.getTrpcRspRetCode() + " trpcRspFuncRetCode:" + vSBaseRequest.getTrpcRspFuncRetCode() + " trpcFailMsg:" + vSBaseRequest.getTrpcFailMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(RFWCommonConfigManager this$0, FeedCloudUsersettings$GetUsersettingsRsp userRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userRsp, "$userRsp");
        FeedCloudUsersettings$Interval feedCloudUsersettings$Interval = userRsp.interval.get();
        Intrinsics.checkNotNullExpressionValue(feedCloudUsersettings$Interval, "userRsp.interval.get()");
        this$0.h(feedCloudUsersettings$Interval);
        List<FeedCloudUsersettings$Entry> list = userRsp.attachInfos.get();
        Intrinsics.checkNotNullExpressionValue(list, "userRsp.attachInfos.get()");
        this$0.f(list);
        List<FeedCloudUsersettings$SettingsInfo> list2 = userRsp.msgs.get();
        Intrinsics.checkNotNullExpressionValue(list2, "userRsp.msgs.get()");
        this$0.g(list2);
    }

    private final void k(FeedCloudUsersettings$SettingsInfo info) {
        FeedCloudSwitch$SwitchRsp feedCloudSwitch$SwitchRsp = new FeedCloudSwitch$SwitchRsp();
        try {
            feedCloudSwitch$SwitchRsp.mergeFrom(info.bizData.get().toByteArray());
            List<FeedCloudUsersettings$Entry> list = feedCloudSwitch$SwitchRsp.switchs.get();
            if (list.isEmpty()) {
                return;
            }
            QLog.d("RFWCommonConfigManager", 1, "handleSetting switch size:" + list.size());
            for (FeedCloudUsersettings$Entry feedCloudUsersettings$Entry : list) {
                com.tencent.mobileqq.rfw.common.api.b.c(feedCloudUsersettings$Entry.key.get(), feedCloudUsersettings$Entry.value.get().toStringUtf8());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            throw new RuntimeException(e16);
        }
    }

    private final boolean l() {
        return MobileQQ.sMobileQQ.peekAppRuntime().isBackgroundPause;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        INSTANCE.a().o(999);
    }

    private final void n() {
        if (l()) {
            return;
        }
        this.handler.removeCallbacks(this.pollingTask);
        this.handler.postDelayed(this.pollingTask, this.pollingInterval);
    }

    private final void p(int visitScene) {
        RFWCommonConfigRequest rFWCommonConfigRequest = new RFWCommonConfigRequest(1, visitScene);
        rFWCommonConfigRequest.setAttachInfo(this.attachInfo);
        VSNetworkHelper.getInstance().sendRequest(rFWCommonConfigRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.rfw.common.impl.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                RFWCommonConfigManager.q(RFWCommonConfigManager.this, baseRequest, z16, j3, str, (FeedCloudUsersettings$GetUsersettingsRsp) obj);
            }
        });
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(RFWCommonConfigManager this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudUsersettings$GetUsersettingsRsp feedCloudUsersettings$GetUsersettingsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(baseRequest, z16, j3, feedCloudUsersettings$GetUsersettingsRsp);
    }

    public final void o(int visitScene) {
        List<FeedCloudUsersettings$Entry> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, visitScene);
            return;
        }
        if (visitScene != 2) {
            if (visitScene != 3) {
                if (visitScene == 999) {
                    if (System.currentTimeMillis() - this.lastPollingTime < this.pollingInterval) {
                        n();
                        return;
                    }
                    this.lastPollingTime = System.currentTimeMillis();
                }
            } else {
                String currentUin = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
                if (!Intrinsics.areEqual(this.lastUin, currentUin)) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    this.attachInfo = emptyList;
                    Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
                    this.lastUin = currentUin;
                }
            }
        } else if (System.currentTimeMillis() - this.lastHomeTime < this.homeInterval) {
            return;
        } else {
            this.lastHomeTime = System.currentTimeMillis();
        }
        p(visitScene);
    }

    RFWCommonConfigManager() {
        List<FeedCloudUsersettings$Entry> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.homeInterval = 5000L;
        this.pollingInterval = MiniBoxNoticeInfo.MIN_5;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.attachInfo = emptyList;
        this.lastUin = "";
        this.pollingTask = new Runnable() { // from class: com.tencent.mobileqq.rfw.common.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWCommonConfigManager.m();
            }
        };
        this.handler = new Handler(RFWHandlerThreadManager.INSTANCE.a().getLooper());
    }
}

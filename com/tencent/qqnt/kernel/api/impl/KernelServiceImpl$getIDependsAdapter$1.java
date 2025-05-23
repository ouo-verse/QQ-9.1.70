package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.impl.KernelServiceImpl;
import com.tencent.qqnt.kernel.msf.b;
import com.tencent.qqnt.kernel.nativeinterface.BatteryStatus;
import com.tencent.qqnt.kernel.nativeinterface.BigDataTicket;
import com.tencent.qqnt.kernel.nativeinterface.DeviceInfo;
import com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter;
import com.tencent.qqnt.kernel.nativeinterface.IGetA2TicketCallback;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.OnLineBusinessInfo;
import com.tencent.qqnt.kernel.nativeinterface.RegisterInfo;
import com.tencent.qqnt.kernel.nativeinterface.RegisterRes;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import com.tencent.qqnt.kernel.nativeinterface.SessionTicket;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import com.tencent.qqnt.wtlogin.api.ITicketRuntimeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.request.Ticket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J/\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0084\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00142&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\u001f\u0010\u001f\u001a\u00020\u00172\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\"\u001a\u00020!H\u0016J\u001a\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u000f\u0010+\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b+\u0010,J,\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\n2\b\u0010-\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u00100\u001a\u00020/H\u0016J$\u00105\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u000103H\u0016Jf\u0010<\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\b\u00107\u001a\u0004\u0018\u00010)2\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u00010\u00102&\u0010;\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020)\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020)\u0018\u0001`\u0014H\u0016JV\u0010?\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010\u00102\b\u00107\u001a\u0004\u0018\u00010)2\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u00010\u00102\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020)\u0018\u00010\u00132\u0006\u0010>\u001a\u00020\u0017H\u0016J\u0012\u0010B\u001a\u0004\u0018\u00010\u00102\u0006\u0010A\u001a\u00020@H\u0016\u00a8\u0006C"}, d2 = {"com/tencent/qqnt/kernel/api/impl/KernelServiceImpl$getIDependsAdapter$1", "Lcom/tencent/qqnt/kernel/nativeinterface/IDependsAdapter;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "getBigDataCustomEnvIpList", "", "isHttps", "Lcom/tencent/qqnt/kernel/nativeinterface/IpType;", "ipType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBigDataIpList", "Lcom/tencent/qqnt/kernel/nativeinterface/BigDataTicket;", "getBigDataTicket", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "httpMethod", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "heads", "params", "", "retryCnt", "timeout", "", "onSendNetRequest", "cmd", "registerMSFPushCmd", "commands", "registerABatchOfMSFPushCommands", "(Ljava/util/ArrayList;)Ljava/lang/Integer;", "Lcom/tencent/qqnt/kernel/nativeinterface/SessionTicket;", "getLoginTicket", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetA2TicketCallback;", "cb", "getA2Ticket", "Lcom/tencent/qqnt/kernel/nativeinterface/BatteryStatus;", "getBatteryStatus", "", "getQFixConfigReqBodyBytes", "getGroupCode", "()Ljava/lang/Long;", "domain", "getIpDirectList", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterInfo;", "getRegisterProxyOnlineReqParam", "result", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterRes;", "registerRes", "onRegisterProxyOnlineResp", "serviceType", "pbBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/SendRequestParam;", "param", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "transInfoMap", "onSendOidbRequest", "ssoCmd", "cmdType", "onSendSSORequest", "Lcom/tencent/qqnt/kernel/nativeinterface/UIConfig;", "cfg", "getConfigFromUI", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KernelServiceImpl$getIDependsAdapter$1 implements IDependsAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.qqnt.kernel.api.impl.bigData.a f357250a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ KernelServiceImpl f357251b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KernelServiceImpl$getIDependsAdapter$1(KernelServiceImpl kernelServiceImpl) {
        this.f357251b = kernelServiceImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) kernelServiceImpl);
        } else {
            this.f357250a = new com.tencent.qqnt.kernel.api.impl.bigData.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(KernelServiceImpl this$0, long j3, String str, String str2, HashMap hashMap, HashMap hashMap2, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dx3.g sSenderModule = this$0.getSSenderModule();
        if (sSenderModule != null) {
            sSenderModule.onSendNetRequest(j3, str, str2, hashMap, hashMap2, i3, i16);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    public void getA2Ticket(long uin, @Nullable IGetA2TicketCallback cb5) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(uin), cb5);
            return;
        }
        dx3.g sSenderModule = this.f357251b.getSSenderModule();
        if (sSenderModule != null && (b16 = sSenderModule.b(String.valueOf(uin))) != null && cb5 != null) {
            cb5.onResult(0, "", b16);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    public BatteryStatus getBatteryStatus() {
        BatteryStatus batteryStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BatteryStatus) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        dx3.g sSenderModule = this.f357251b.getSSenderModule();
        if (sSenderModule == null || (batteryStatus = sSenderModule.getBatteryStatus()) == null) {
            return new BatteryStatus();
        }
        return batteryStatus;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @Nullable
    public ServerAddress getBigDataCustomEnvIpList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ServerAddress) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f357250a.b();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @Nullable
    public ArrayList<ServerAddress> getBigDataIpList(boolean isHttps, @Nullable IpType ipType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isHttps), ipType);
        }
        return this.f357250a.c(isHttps, ipType);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @Nullable
    public BigDataTicket getBigDataTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BigDataTicket) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f357250a.d();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @Nullable
    public String getConfigFromUI(@NotNull UIConfig cfg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) cfg);
        }
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        return com.tencent.qqnt.kernel.processor.c.f359251a.a(cfg);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    public Long getGroupCode() {
        long highPriorityGroupUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            highPriorityGroupUin = this.f357251b.getHighPriorityGroupUin();
            QLog.i("KernelService", 1, "getGroupCode: " + highPriorityGroupUin);
            return Long.valueOf(highPriorityGroupUin);
        }
        return (Long) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    public ArrayList<ServerAddress> getIpDirectList(@Nullable String domain, @Nullable IpType ipType) {
        ArrayList<ServerAddress> ipDirectList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this, (Object) domain, (Object) ipType);
        }
        dx3.g sSenderModule = this.f357251b.getSSenderModule();
        if (sSenderModule == null || (ipDirectList = sSenderModule.getIpDirectList(domain, ipType)) == null) {
            return new ArrayList<>();
        }
        return ipDirectList;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    public SessionTicket getLoginTicket() {
        String str;
        byte[] _sig_key;
        byte[] _sig;
        SessionTicket loginTicket;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SessionTicket) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        dx3.g sSenderModule = this.f357251b.getSSenderModule();
        if (sSenderModule != null && (loginTicket = sSenderModule.getLoginTicket()) != null) {
            return loginTicket;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        try {
            ITicketRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITicketRuntimeService.class, "");
            Ticket localTicket = runtimeService.getLocalTicket(peekAppRuntime.getAccount(), 262144);
            KernelServiceImpl.Companion companion = KernelServiceImpl.INSTANCE;
            String j3 = companion.j(runtimeService.getA2(peekAppRuntime.getCurrentUin()));
            String str2 = null;
            if (localTicket != null && (_sig = localTicket._sig) != null) {
                Intrinsics.checkNotNullExpressionValue(_sig, "_sig");
                str = companion.i(_sig);
            } else {
                str = null;
            }
            String j16 = companion.j(str);
            if (localTicket != null && (_sig_key = localTicket._sig_key) != null) {
                Intrinsics.checkNotNullExpressionValue(_sig_key, "_sig_key");
                str2 = companion.i(_sig_key);
            }
            return new SessionTicket(j3, j16, companion.j(str2));
        } catch (Exception unused) {
            return new SessionTicket();
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    public byte[] getQFixConfigReqBodyBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        QLog.i("getQFixConfigReqBodyBytes", 1, "getQFixConfigReqBodyBytes invoke");
        byte[] pullConfigRequest = MsfPullConfigUtil.pullConfigRequest(true);
        Intrinsics.checkNotNullExpressionValue(pullConfigRequest, "pullConfigRequest(true)");
        return pullConfigRequest;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r5 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r7 == null) goto L19;
     */
    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RegisterInfo getRegisterProxyOnlineReqParam() {
        DeviceInfo deviceInfo;
        OnLineBusinessInfo onLineBusinessInfo;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (RegisterInfo) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        try {
            AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
            KernelServiceImpl.Companion companion = KernelServiceImpl.INSTANCE;
            dx3.a f16 = companion.f();
            if (f16 != null) {
                Intrinsics.checkNotNullExpressionValue(app, "app");
                deviceInfo = f16.e(app);
            }
            deviceInfo = new DeviceInfo();
            dx3.a f17 = companion.f();
            if (f17 != null) {
                Intrinsics.checkNotNullExpressionValue(app, "app");
                onLineBusinessInfo = f17.b(app);
            }
            onLineBusinessInfo = new OnLineBusinessInfo(0, 0, 0);
            dx3.a f18 = companion.f();
            if (f18 != null) {
                Intrinsics.checkNotNullExpressionValue(app, "app");
                z16 = f18.d(app);
            } else {
                z16 = true;
            }
            String str = deviceInfo.guid;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            deviceInfo.guid = str;
            String str3 = deviceInfo.buildVer;
            if (str3 == null) {
                str3 = "";
            }
            deviceInfo.buildVer = str3;
            String str4 = deviceInfo.devName;
            if (str4 == null) {
                str4 = "";
            }
            deviceInfo.devName = str4;
            String str5 = deviceInfo.devType;
            if (str5 == null) {
                str5 = "";
            }
            deviceInfo.devType = str5;
            String str6 = deviceInfo.vendorName;
            if (str6 == null) {
                str6 = "";
            }
            deviceInfo.vendorName = str6;
            String str7 = deviceInfo.osVer;
            if (str7 == null) {
                str7 = "";
            }
            deviceInfo.osVer = str7;
            String str8 = deviceInfo.vendorOsName;
            if (str8 != null) {
                str2 = str8;
            }
            deviceInfo.vendorOsName = str2;
            RegisterInfo registerInfo = new RegisterInfo(z16, deviceInfo, onLineBusinessInfo);
            QLog.i("KernelService", 1, "KernelServiceImpl, registerInfo=" + registerInfo);
            return registerInfo;
        } catch (Throwable th5) {
            QLog.w("KernelService", 1, "KernelServiceImpl getRegisterParam catch th: ", th5);
            return new RegisterInfo(true, new DeviceInfo("", "", 2052, "", "", "", "", "", false, 0), new OnLineBusinessInfo(0, 0, 0));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    public void onRegisterProxyOnlineResp(int result, @Nullable String errMsg, @Nullable RegisterRes registerRes) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(result), errMsg, registerRes);
            return;
        }
        QLog.d("KernelServiceImpl", 1, "onRegisterProxyOnlineResp: " + result + ", err: " + errMsg);
        arrayList = this.f357251b.onlineCallback;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.kernel.api.v) it.next()).onUserOnlineResult(result, errMsg, registerRes);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    public void onSendNetRequest(final long requestId, @Nullable final String httpMethod, @Nullable final String url, @Nullable final HashMap<String, String> heads, @Nullable final HashMap<String, String> params, final int retryCnt, final int timeout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(requestId), httpMethod, url, heads, params, Integer.valueOf(retryCnt), Integer.valueOf(timeout));
        } else {
            final KernelServiceImpl kernelServiceImpl = this.f357251b;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.io
                @Override // java.lang.Runnable
                public final void run() {
                    KernelServiceImpl$getIDependsAdapter$1.b(KernelServiceImpl.this, requestId, httpMethod, url, heads, params, retryCnt, timeout);
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    public void onSendOidbRequest(long requestId, int serviceType, int cmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(requestId), Integer.valueOf(serviceType), Integer.valueOf(cmd), pbBuffer, param, traceInfo, transInfoMap);
        } else {
            KernelServiceImpl kernelServiceImpl = this.f357251b;
            kernelServiceImpl.check("onSendOidbRequest", new KernelServiceImpl$getIDependsAdapter$1$onSendOidbRequest$1(cmd, kernelServiceImpl, requestId, serviceType, pbBuffer, param, traceInfo, transInfoMap));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    public void onSendSSORequest(long requestId, @Nullable String ssoCmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap, int cmdType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(requestId), ssoCmd, pbBuffer, param, traceInfo, transInfoMap, Integer.valueOf(cmdType));
        } else {
            KernelServiceImpl kernelServiceImpl = this.f357251b;
            kernelServiceImpl.check("onSendSSORequest", new KernelServiceImpl$getIDependsAdapter$1$onSendSSORequest$1(ssoCmd, kernelServiceImpl, requestId, pbBuffer, param, traceInfo, transInfoMap));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    @NotNull
    public Integer registerABatchOfMSFPushCommands(@Nullable ArrayList<String> commands) {
        String[] strArr;
        Set plus;
        Set set;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) commands);
        }
        if (commands != null) {
            final KernelServiceImpl kernelServiceImpl = this.f357251b;
            CopyOnWriteArraySet<String> b16 = com.tencent.qqnt.kernel.msf.b.INSTANCE.b();
            dx3.g sSenderModule = kernelServiceImpl.getSSenderModule();
            if (sSenderModule == null || (strArr = sSenderModule.c()) == null) {
                strArr = new String[0];
            }
            plus = SetsKt___SetsKt.plus((Set) b16, (Object[]) strArr);
            set = CollectionsKt___CollectionsKt.toSet(commands);
            if (plus.containsAll(set)) {
                Iterator<T> it = commands.iterator();
                while (it.hasNext()) {
                    com.tencent.qqnt.kernel.msf.b.INSTANCE.a((String) it.next());
                }
                com.tencent.qqnt.kernel.msf.b.INSTANCE.e(kernelServiceImpl.wrapperSession);
                com.tencent.qqnt.kernel.utils.o.f359277a.a("startServlet-KMsgServlet", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$getIDependsAdapter$1$registerABatchOfMSFPushCommands$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Unit invoke() {
                        py pyVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        pyVar = KernelServiceImpl.this.serviceContent;
                        if (pyVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                            pyVar = null;
                        }
                        AppRuntime c16 = pyVar.c();
                        if (c16 == null) {
                            return null;
                        }
                        c16.startServlet(new NewIntent(MobileQQ.sMobileQQ, com.tencent.qqnt.kernel.msf.b.class));
                        return Unit.INSTANCE;
                    }
                });
                QLog.i("KernelServiceImpl", 1, "commands: " + commands + " all has register");
                return 0;
            }
            Iterator<T> it5 = commands.iterator();
            while (it5.hasNext()) {
                com.tencent.qqnt.kernel.msf.b.INSTANCE.a((String) it5.next());
            }
            com.tencent.qqnt.kernel.msf.b.INSTANCE.e(kernelServiceImpl.wrapperSession);
        }
        return 0;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter
    public void registerMSFPushCmd(@Nullable String cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cmd);
            return;
        }
        if (cmd != null) {
            final KernelServiceImpl kernelServiceImpl = this.f357251b;
            b.Companion companion = com.tencent.qqnt.kernel.msf.b.INSTANCE;
            companion.a(cmd);
            companion.e(kernelServiceImpl.wrapperSession);
        }
    }
}

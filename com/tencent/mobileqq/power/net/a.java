package com.tencent.mobileqq.power.net;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.power.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.pb.performance.ClientPerformance$SsoHighPowerConsumptionReportRequest;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.debug.report.PerfProblemBusinessHandler;
import com.tencent.util.AppSetting;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/power/net/a;", "", "", "tag", "url", "path", "", "e", "", "Lcom/tencent/mobileqq/power/b;", "data", "d", "", "b", "I", "c", "()I", "tickTimes", "", "Z", "needReport", "<init>", "()V", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f259462a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int tickTimes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean needReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/power/net/a$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.power.net.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8232a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        C8232a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.needReport = false;
                com.tencent.mobileqq.perf.log.a.c("HP_NET", "needReport: " + a.needReport);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, tick);
                return;
            }
            if (tick >= a.f259462a.c()) {
                a.needReport = true;
                com.tencent.mobileqq.perf.log.a.c("HP_NET", "needReport: " + a.needReport);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, isEnabled);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f259462a = new a();
        tickTimes = 2;
        GuardManagerCallbackDispatcher.registerCallBack(new C8232a());
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return tickTimes;
    }

    public final void d(@NotNull List<? extends b> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.d("HP_NET", 4, "reportHighPower is not AppInterface, don't report");
            return;
        }
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(PerfProblemBusinessHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.qqperf.debug.report.PerfProblemBusinessHandler");
        PerfProblemBusinessHandler perfProblemBusinessHandler = (PerfProblemBusinessHandler) businessHandler;
        ToServiceMsg createToServiceMsg = perfProblemBusinessHandler.createToServiceMsg("trpc.ep.client_performance.CollectorService.SsoHighPowerConsumptionReport");
        ClientPerformance$SsoHighPowerConsumptionReportRequest clientPerformance$SsoHighPowerConsumptionReportRequest = new ClientPerformance$SsoHighPowerConsumptionReportRequest();
        if (clientPerformance$SsoHighPowerConsumptionReportRequest.branch_name.get().equals("")) {
            clientPerformance$SsoHighPowerConsumptionReportRequest.branch_name.set(AppSetting.getBranchName());
        }
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(clientPerformance$SsoHighPowerConsumptionReportRequest);
        }
        createToServiceMsg.putWupBuffer(clientPerformance$SsoHighPowerConsumptionReportRequest.toByteArray());
        perfProblemBusinessHandler.sendPbReq(createToServiceMsg);
        com.tencent.mobileqq.perf.log.a.c("HP_NET", "reportFlow size: " + data.size());
    }

    public final void e(@Nullable String tag, @Nullable String url, @Nullable String path) {
        String str;
        SimpleAccount firstSimpleAccount;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tag, url, path);
            return;
        }
        if (needReport) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (tag != null) {
                hashMap.put("qqtag", tag);
            }
            if (url != null) {
                hashMap.put("qqurl", url);
            }
            if (path != null) {
                hashMap.put("qqpath", path);
            }
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (firstSimpleAccount = mobileQQ.getFirstSimpleAccount()) != null) {
                str = firstSimpleAccount.getUin();
            } else {
                str = null;
            }
            if (str != null) {
                hashMap.put("qquin", str);
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, "df.format(Date())");
            hashMap.put("qqtime", format);
            com.tencent.mobileqq.perf.log.a.c("HP_NET", "report,tag: " + tag + "\uff0curl: " + url + "\uff0cpath:" + path + ",date: " + format + ",uin:" + str);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "high_power_net", true, 0L, 0L, hashMap, "");
        }
    }
}

package com.tencent.qqnt.trace;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.tracer.RFWTraceStream;
import com.tencent.richframework.tracer.RFWTraceStreamResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/trace/h;", "Lcom/tencent/richframework/tracer/RFWTraceStream$IStreamResultHandler;", "Lcom/tencent/richframework/tracer/RFWTraceStreamResult;", "streamResult", "", "e", "", "c", "d", "", "b", "onStreamFinish", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h implements RFWTraceStream.IStreamResultHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static IMsgPushMonitorHandler f362344b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/trace/h$a", "Lcom/tencent/mobileqq/msf/sdk/handler/IMsgPushMonitorHandler;", "", "onMSFServiceInit", "onRegisterMSFService", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "fromServiceMsg", "onMSFStartConnect", "onMSFConnectSuccess", "onSendRegisterProxyReq", "onRegisterProxyRsp", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements IMsgPushMonitorHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler
        public void onMSFConnectSuccess(@Nullable FromServiceMsg fromServiceMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) fromServiceMsg);
            } else {
                j.f362346a.h();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler
        public void onMSFServiceInit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                j.f362346a.l();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler
        public void onMSFStartConnect(@Nullable FromServiceMsg fromServiceMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) fromServiceMsg);
                return;
            }
            if (fromServiceMsg == null) {
                return;
            }
            Object attribute = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, 0L);
            Intrinsics.checkNotNullExpressionValue(attribute, "fromServiceMsg.getAttrib\u2026TE_SERVICE_INIT_TIME, 0L)");
            long longValue = ((Number) attribute).longValue();
            Object attribute2 = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, 0L);
            Intrinsics.checkNotNullExpressionValue(attribute2, "fromServiceMsg.getAttrib\u2026E_SERVICE_READY_TIME, 0L)");
            j.f362346a.i(longValue, ((Number) attribute2).longValue());
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler
        public void onRegisterMSFService() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                j.f362346a.o();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler
        public void onRegisterProxyRsp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                j.f362346a.j();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler
        public void onSendRegisterProxyReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                j.f362346a.k();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/trace/h$b;", "", "", "initTIme", "", "b", "Lcom/tencent/mobileqq/msf/sdk/handler/IMsgPushMonitorHandler;", "msgPushMonitorHandler", "Lcom/tencent/mobileqq/msf/sdk/handler/IMsgPushMonitorHandler;", "a", "()Lcom/tencent/mobileqq/msf/sdk/handler/IMsgPushMonitorHandler;", "setMsgPushMonitorHandler", "(Lcom/tencent/mobileqq/msf/sdk/handler/IMsgPushMonitorHandler;)V", "", "ATTACH_CONTEXT_MSG_PUSH_COST", "Ljava/lang/String;", "MSF_INIT_OPTIMIZE_SWITCH", "MSF_NEW_DISPATCH_SWITCH", "MSF_PROCESS_INIT_TIME", "PUSH_REPORT_EVENT_NAME", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.trace.h$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final IMsgPushMonitorHandler a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return h.f362344b;
            }
            return (IMsgPushMonitorHandler) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void b(long initTIme) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, initTIme);
            } else {
                QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong("msf_process_init_time", initTIme);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64155);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f362344b = new a();
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long b() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong("msf_process_init_time", 0L);
    }

    private final boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("msf_init_optimize", false);
    }

    private final boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(com.tencent.mobileqq.msf.core.x.m.f250346o, false);
    }

    private final void e(RFWTraceStreamResult streamResult) {
        String str;
        int mapCapacity;
        int mapCapacity2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Map<String, Long> costMap = streamResult.getCostMap();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(costMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = costMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), String.valueOf(((Number) entry.getValue()).longValue()));
        }
        hashMap.putAll(linkedHashMap);
        Map<String, Object> extraParam = streamResult.getExtraParam();
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(extraParam.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
        Iterator<T> it5 = extraParam.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it5.next();
            linkedHashMap2.put(entry2.getKey(), entry2.getValue().toString());
        }
        hashMap.putAll(linkedHashMap2);
        long j3 = com.tencent.mobileqq.startup.a.f289661b;
        j jVar = j.f362346a;
        hashMap.put("ATTACH_TO_CLICK_PUSH_COST", String.valueOf(j3 - jVar.b()));
        hashMap.put("msf_process_init_time", String.valueOf(b() - jVar.b()));
        hashMap.put("msf_init_optimize", String.valueOf(c()));
        hashMap.put(com.tencent.mobileqq.msf.core.x.m.f250346o, String.valueOf(d()));
        if (!hashMap.containsKey("MSF_INIT_START")) {
            hashMap.put("MSF_INIT_START", String.valueOf(NetConnInfoCenter.getMSFServiceInitTime() - jVar.b()));
        }
        if (!hashMap.containsKey("MSF_INIT_END")) {
            hashMap.put("MSF_INIT_END", String.valueOf(NetConnInfoCenter.getMSFServiceReadyTime() - jVar.b()));
        }
        QLog.d("MSFMsgPushReportHandler", 1, hashMap);
        QQBeaconReport.report(str, "msf_msg_push_report", hashMap);
    }

    @Override // com.tencent.richframework.tracer.RFWTraceStream.IStreamResultHandler
    public void onStreamFinish(@NotNull RFWTraceStreamResult streamResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) streamResult);
            return;
        }
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        try {
            QLog.d("MSFMsgPushReportHandler", 1, streamResult.toString());
            e(streamResult);
        } catch (Exception e16) {
            QLog.e("MSFMsgPushReportHandler", 1, "reportStreamInfo error.", e16);
        }
    }
}

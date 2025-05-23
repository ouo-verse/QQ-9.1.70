package com.tencent.mobileqq.injector;

import com.tencent.guild.api.transfile.IGuildTransFileApi;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.BatteryStatus;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import com.tencent.qqnt.kernel.nativeinterface.SessionTicket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J0\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0084\u0001\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00162&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016Jf\u0010%\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u00032&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0016H\u0016J`\u0010'\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u00032&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0016H\u0016J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0016\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020\u0003H\u0016\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/injector/ag;", "Ldx3/g;", "", "", "d", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SessionTicket;", "getLoginTicket", "Lcom/tencent/qqnt/kernel/nativeinterface/BatteryStatus;", "getBatteryStatus", "domain", "Lcom/tencent/qqnt/kernel/nativeinterface/IpType;", "ipType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "Lkotlin/collections/ArrayList;", "getIpDirectList", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "httpMethod", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "heads", "params", "", "retryCnt", "timeout", "", "onSendNetRequest", "serviceType", "cmd", "pbBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/SendRequestParam;", "param", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "transInfoMap", "onSendOidbRequest", "ssoCmd", "a", "", "c", "()[Ljava/lang/String;", "uin", "b", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ag implements dx3.g {
    static IPatchRedirector $redirector_;

    public ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb5.append(hexString);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    private final String e(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // dx3.g
    public void a(long requestId, @Nullable String ssoCmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(requestId), ssoCmd, pbBuffer, param, traceInfo, transInfoMap);
        }
    }

    @Override // dx3.g
    @Nullable
    public String b(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        return ((TicketManager) manager).getA2(uin);
    }

    @Override // dx3.g
    @NotNull
    public String[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String[] messagePushSSOCommands = MobileQQ.sMobileQQ.peekAppRuntime().getMessagePushSSOCommands();
        Intrinsics.checkNotNullExpressionValue(messagePushSSOCommands, "app.messagePushSSOCommands");
        return messagePushSSOCommands;
    }

    @Override // dx3.g
    @NotNull
    public BatteryStatus getBatteryStatus() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BatteryStatus) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) runtimeService;
        int batteryCapacity = iOnlineStatusService.getBatteryCapacity();
        if (iOnlineStatusService.getPowerConnect() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new BatteryStatus(batteryCapacity, z16);
    }

    @Override // dx3.g
    @Nullable
    public ArrayList<ServerAddress> getIpDirectList(@Nullable String domain, @Nullable IpType ipType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) domain, (Object) ipType);
        }
        return ((IGuildTransFileApi) QRoute.api(IGuildTransFileApi.class)).getIpDirectList(domain, ipType);
    }

    @Override // dx3.g
    @Nullable
    public SessionTicket getLoginTicket() {
        String str;
        byte[] bArr;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SessionTicket) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = peekAppRuntime.getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        TicketManager ticketManager = (TicketManager) manager;
        String account = peekAppRuntime.getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "runtime.account");
        String a26 = ticketManager.getA2(account);
        Ticket d2Ticket = ticketManager.getD2Ticket(account);
        String str2 = null;
        if (d2Ticket != null && (bArr2 = d2Ticket._sig) != null) {
            str = d(bArr2);
        } else {
            str = null;
        }
        String e16 = e(str);
        if (d2Ticket != null && (bArr = d2Ticket._sig_key) != null) {
            str2 = d(bArr);
        }
        return new SessionTicket(a26, e16, e(str2));
    }

    @Override // dx3.g
    public void onSendNetRequest(long requestId, @Nullable String httpMethod, @Nullable String url, @Nullable HashMap<String, String> heads, @Nullable HashMap<String, String> params, int retryCnt, int timeout) {
        boolean z16;
        Request build;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(requestId), httpMethod, url, heads, params, Integer.valueOf(retryCnt), Integer.valueOf(timeout));
            return;
        }
        IQQNTWrapperSession wrapperSession = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getWrapperSession();
        try {
            Request.Builder builder = new Request.Builder();
            if (heads != null) {
                for (Map.Entry<String, String> entry : heads.entrySet()) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (Intrinsics.areEqual("GET", httpMethod)) {
                Intrinsics.checkNotNull(url);
                build = builder.url(url).get().build();
            } else {
                JSONObject jSONObject = new JSONObject();
                if (params != null) {
                    for (Map.Entry<String, String> entry2 : params.entrySet()) {
                        jSONObject.put(entry2.getKey(), entry2.getValue());
                    }
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                MediaType parse = MediaType.INSTANCE.parse("application/json; charset=utf-8");
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                RequestBody create = companion.create(parse, jSONObject2);
                Request.Builder builder2 = new Request.Builder();
                Intrinsics.checkNotNull(url);
                build = builder2.url(url).post(create).build();
            }
            OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
            long j3 = timeout;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Response execute = newBuilder.connectTimeout(j3, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j3, timeUnit).connectionPool(new ConnectionPool(0, 10L, TimeUnit.SECONDS)).build().newCall(build).execute();
            int code = execute.code();
            QLog.i("SenderModuleInjector", 4, "onSendHttpRequest connection.getResponseCode =" + code);
            try {
                if (code == 200) {
                    ResponseBody body = execute.body();
                    if (body == null || (bArr = body.bytes()) == null) {
                        bArr = new byte[0];
                    }
                    if (wrapperSession != null) {
                        wrapperSession.onNetReply(requestId, 0, "", bArr);
                    }
                } else {
                    if (retryCnt > 0) {
                        int i3 = retryCnt - 1;
                        QLog.i("SenderModuleInjector", 1, "onSendHttpRequest retry=" + i3);
                        onSendNetRequest(requestId, httpMethod, url, heads, params, i3, timeout);
                        return;
                    }
                    String message = execute.message();
                    QLog.i("SenderModuleInjector", 1, "onSendHttpRequest responseMessage=" + message);
                    if (wrapperSession != null) {
                        wrapperSession.onNetReply(requestId, code, message, new byte[0]);
                    }
                }
            } catch (Exception e16) {
                e = e16;
                z16 = true;
                QLog.i("SenderModuleInjector", 1, "onSendHttpRequest Exception =" + e.getMessage());
                if (!z16 && wrapperSession != null) {
                    wrapperSession.onNetReply(requestId, -1, e.getMessage(), new byte[0]);
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
    }

    @Override // dx3.g
    public void onSendOidbRequest(long requestId, int serviceType, int cmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(requestId), Integer.valueOf(serviceType), Integer.valueOf(cmd), pbBuffer, param, traceInfo, transInfoMap);
        }
    }
}

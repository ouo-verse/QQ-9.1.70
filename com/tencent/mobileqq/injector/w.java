package com.tencent.mobileqq.injector;

import android.os.Bundle;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.MsfRspInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/injector/w;", "Ldx3/e;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "type", "result", "", "errorMsg", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "e", "ssoSeq", "c", "a", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class w implements dx3.e {
    static IPatchRedirector $redirector_;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(final int ssoSeq, final int result, final String errorMsg, final long requestId) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.injector.v
            @Override // java.lang.Runnable
            public final void run() {
                w.d(ssoSeq, result, errorMsg, requestId);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, int i16, String errorMsg, long j3) {
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        try {
            String networkName = ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).getNetworkName();
            HashMap hashMap = new HashMap();
            hashMap.put("req_seq", String.valueOf(i3));
            hashMap.put("result", String.valueOf(i16));
            hashMap.put("err_msg", errorMsg);
            hashMap.put("network", networkName);
            String valueOf = String.valueOf(j3);
            hashMap.put("source", "gpro_cssender_abnormal");
            com.tencent.mobileqq.qqguildsdk.tianjige.j.i(valueOf, hashMap);
            com.tencent.mobileqq.qqguildsdk.tianjige.j.j(valueOf, i16);
            com.tencent.mobileqq.qqguildsdk.tianjige.j.b(valueOf);
        } catch (Exception e16) {
            QLog.i("SenderModuleInjector", 1, "doOpenTelemetryReport Exception =" + e16.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(long requestId, int type, int result, String errorMsg, boolean isSuccess, Bundle bundle) {
        IKernelService iKernelService;
        IQQNTWrapperSession wrapperSession;
        String str;
        int i3;
        MsfRspInfo msfRspInfo;
        int businessFailCode;
        String str2;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (wrapperSession = iKernelService.getWrapperSession()) != null && bundle != null) {
            FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("from_service_msg_info");
            byte[] byteArray = bundle.getByteArray("bytes_bodybuffer");
            if (byteArray == null) {
                byteArray = new byte[0];
            }
            Intrinsics.checkNotNullExpressionValue(byteArray, "bundle.getByteArray(KSer\u2026DYBUFFER) ?: ByteArray(0)");
            if (result == -101) {
                QLog.e("KernelSendObserver", 1, "onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(requestId)), "error_network_not_support");
                msfRspInfo = new MsfRspInfo();
                str = "KernelSendObserver";
            } else {
                if (fromServiceMsg == null) {
                    str = "KernelSendObserver";
                    i3 = 0;
                    QLog.e(str, 1, "onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(requestId)), "fromServiceMsg is empty");
                    msfRspInfo = new MsfRspInfo();
                    Integer num = null;
                    if (bundle.getInt("type", i3) != 0) {
                        int i16 = bundle.getInt("cmd_int", i3);
                        HashMap<String, byte[]> hashMap = msfRspInfo.transInfoMap;
                        if (hashMap != null) {
                            num = Integer.valueOf(hashMap.size());
                        }
                        QLog.i(str, 1, "onReceive requestId " + requestId + " cmd " + i16 + " isSuccess " + isSuccess + " result " + result + " errorMsg " + errorMsg + ", transInfo: " + num);
                        wrapperSession.onSendOidbReply(requestId, i16, result, errorMsg, msfRspInfo);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String string = bundle.getString("cmd");
                    HashMap<String, byte[]> hashMap2 = msfRspInfo.transInfoMap;
                    if (hashMap2 != null) {
                        num = Integer.valueOf(hashMap2.size());
                    }
                    QLog.i(str, 1, "onReceive requestId " + requestId + " ssoCmd " + string + " isSuccess " + isSuccess + " result " + result + " errorMsg " + errorMsg + ", transInfo: " + num);
                    wrapperSession.onSendSSOReply(requestId, string, result, errorMsg, msfRspInfo);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 >= 100) {
                        QLog.i(str, 1, "onReceive onSendSSOReply method cost: " + currentTimeMillis2);
                        return;
                    }
                    return;
                }
                if (fromServiceMsg.getBusinessFailCode() == 1000) {
                    businessFailCode = 0;
                } else {
                    businessFailCode = fromServiceMsg.getBusinessFailCode();
                }
                if (fromServiceMsg.getTrpcRspErrorMsg() != null) {
                    byte[] trpcRspErrorMsg = fromServiceMsg.getTrpcRspErrorMsg();
                    Intrinsics.checkNotNullExpressionValue(trpcRspErrorMsg, "fromServiceMsg.trpcRspErrorMsg");
                    if (trpcRspErrorMsg.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        byte[] trpcRspErrorMsg2 = fromServiceMsg.getTrpcRspErrorMsg();
                        Intrinsics.checkNotNullExpressionValue(trpcRspErrorMsg2, "fromServiceMsg.trpcRspErrorMsg");
                        str2 = new String(trpcRspErrorMsg2, Charsets.UTF_8);
                        int trpcRspRetCode = fromServiceMsg.getTrpcRspRetCode();
                        int trpcRspFuncRetCode = fromServiceMsg.getTrpcRspFuncRetCode();
                        HashMap<String, byte[]> transInfo = fromServiceMsg.getTransInfo();
                        str = "KernelSendObserver";
                        msfRspInfo = new MsfRspInfo(businessFailCode, trpcRspRetCode, trpcRspFuncRetCode, str2, byteArray, transInfo);
                    }
                }
                str2 = "";
                int trpcRspRetCode2 = fromServiceMsg.getTrpcRspRetCode();
                int trpcRspFuncRetCode2 = fromServiceMsg.getTrpcRspFuncRetCode();
                HashMap<String, byte[]> transInfo2 = fromServiceMsg.getTransInfo();
                str = "KernelSendObserver";
                msfRspInfo = new MsfRspInfo(businessFailCode, trpcRspRetCode2, trpcRspFuncRetCode2, str2, byteArray, transInfo2);
            }
            i3 = 0;
            Integer num2 = null;
            if (bundle.getInt("type", i3) != 0) {
            }
        }
    }

    @Override // dx3.e
    public void a(long requestId, int type, int result, @NotNull String errorMsg, boolean isSuccess, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(requestId), Integer.valueOf(type), Integer.valueOf(result), errorMsg, Boolean.valueOf(isSuccess), bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        e(requestId, type, result, errorMsg, isSuccess, bundle);
        Intrinsics.checkNotNull(bundle);
        c(bundle.getInt("sso_seq"), result, errorMsg, requestId);
    }
}

package com.tencent.mobileqq.qqguildsdk.util;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes17.dex */
public class GProNonGuildServlet extends MSFServlet {

    /* renamed from: d, reason: collision with root package name */
    private static int f268539d;

    /* loaded from: classes17.dex */
    public interface a {
        void a(int i3, int i16, String str, byte[] bArr);
    }

    /* loaded from: classes17.dex */
    static class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private a f268545d;

        public b(a aVar) {
            this.f268545d = aVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (this.f268545d == null) {
                return;
            }
            this.f268545d.a(bundle.getInt("reqCmd"), bundle.getInt("errCode"), bundle.getString("errMsg"), bundle.getByteArray("rspData"));
        }
    }

    private void a(final int i3, final int i16, final String str, final String str2) {
        final IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.util.GProNonGuildServlet.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
                    HashMap hashMap = new HashMap();
                    hashMap.put("req_seq", String.valueOf(i3));
                    hashMap.put("result", String.valueOf(i16));
                    hashMap.put("err_msg", str);
                    hashMap.put("network", c16);
                    hashMap.put("source", "gpro_cssender");
                    iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(str2, hashMap);
                    iQQOpenTelemetryReportApi.setStatusCode(str2, i16);
                    iQQOpenTelemetryReportApi.endOpenTelemetryTask(str2);
                } catch (Exception e16) {
                    QLog.e("GProNonGuildServlet", 1, DownloadInfo.spKey_Config, e16.toString());
                }
            }
        }, 16, null, false);
    }

    public static void b(AppRuntime appRuntime, byte[] bArr, int i3, int i16, a aVar) {
        if (appRuntime == null) {
            return;
        }
        String format = String.format("OidbSvcTrpcTcp.0x%1$x_%2$d", Integer.valueOf(i3), Integer.valueOf(i16));
        int i17 = f268539d + 1;
        f268539d = i17;
        String valueOf = String.valueOf(i17);
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask(format, valueOf);
        if (startOpenTelemetryTask != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("request_id", valueOf);
            hashMap.put("cmd", String.valueOf(i3));
            hashMap.put("service_type", String.valueOf(i16));
            iQQOpenTelemetryReportApi.reportOpenTelemetryTask(startOpenTelemetryTask, "start");
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(startOpenTelemetryTask, hashMap);
        }
        String traceInfo = iQQOpenTelemetryReportApi.getTraceInfo(startOpenTelemetryTask);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), GProNonGuildServlet.class);
        newIntent.setObserver(new b(aVar));
        newIntent.putExtra("reqCmd", i3);
        newIntent.putExtra("reqCmdStr", format);
        newIntent.putExtra("reqData", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("taskKey", startOpenTelemetryTask);
        newIntent.putExtra("trace_info", traceInfo);
        newIntent.putExtra("type", 0);
        appRuntime.startServlet(newIntent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        int i3;
        if (intent == null) {
            QLog.e("GProNonGuildServlet", 1, "onReceive, request is null");
            return;
        }
        if (fromServiceMsg == null) {
            QLog.e("GProNonGuildServlet", 1, "onReceive, response is null");
            return;
        }
        Bundle bundle = new Bundle();
        int intExtra = intent.getIntExtra("reqCmd", 0);
        String stringExtra = intent.getStringExtra("reqCmdStr");
        String stringExtra2 = intent.getStringExtra("taskKey");
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        if (fromServiceMsg.isSuccess()) {
            byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
            if (a16 != null && a16.length != 0) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    oidb_sso_oidbssopkg.mergeFrom(a16);
                    i3 = oidb_sso_oidbssopkg.uint32_result.get();
                } catch (InvalidProtocolBufferMicroException unused) {
                    businessFailMsg = "onReceive, decode rspData error";
                    QLog.e("GProNonGuildServlet", 1, "onReceive, decode rspData error");
                }
                if (i3 != 0) {
                    h.v("GProNonGuildServlet", "fetchGuildInfoByInviteCode", "oidb head error code: " + i3);
                    String str = oidb_sso_oidbssopkg.str_error_msg.get();
                    if (str != null) {
                        businessFailMsg = str;
                    }
                    businessFailCode = i3;
                } else {
                    bArr = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    bundle.putInt("reqCmd", intExtra);
                    bundle.putInt("errCode", businessFailCode);
                    bundle.putString("errMsg", businessFailMsg);
                    bundle.putByteArray("rspData", bArr);
                    QLog.d("GProNonGuildServlet", 1, String.format("onReceive, cmd=%s, errCode=%d, errMsg=%s", stringExtra, Integer.valueOf(businessFailCode), businessFailMsg));
                    notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
                    a(fromServiceMsg.getRequestSsoSeq(), businessFailCode, businessFailMsg, stringExtra2);
                }
            } else {
                businessFailMsg = "onReceive, rspData is empty";
                QLog.e("GProNonGuildServlet", 1, "onReceive, rspData is empty");
            }
            businessFailCode = -1;
        }
        bArr = null;
        bundle.putInt("reqCmd", intExtra);
        bundle.putInt("errCode", businessFailCode);
        bundle.putString("errMsg", businessFailMsg);
        bundle.putByteArray("rspData", bArr);
        QLog.d("GProNonGuildServlet", 1, String.format("onReceive, cmd=%s, errCode=%d, errMsg=%s", stringExtra, Integer.valueOf(businessFailCode), businessFailMsg));
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
        a(fromServiceMsg.getRequestSsoSeq(), businessFailCode, businessFailMsg, stringExtra2);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("reqData");
        String stringExtra = intent.getStringExtra("reqCmdStr");
        String stringExtra2 = intent.getStringExtra("trace_info");
        QLog.d("GProNonGuildServlet", 1, String.format("onSend, cmd=%s", stringExtra));
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(byteArrayExtra));
        packet.setTraceInfo(stringExtra2);
    }
}

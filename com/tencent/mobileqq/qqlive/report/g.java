package com.tencent.mobileqq.qqlive.report;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.report.tianjige.b;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g implements com.tencent.mobileqq.qqlive.report.tianjige.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f271437d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f271438e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f271439f;

    /* renamed from: h, reason: collision with root package name */
    private volatile QQLiveSDKConfig f271440h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.report.tianjige.g f271441i;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<b.a> f271442m;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271437d = 0;
        this.f271438e = false;
        this.f271439f = false;
        this.f271442m = new ArrayList<>();
    }

    private void n(String str, int i3, String str2, int i16) {
        boolean z16;
        try {
            QLog.i("QQLiveProtocolsReportApiImpl", 1, "doEndOpenTelemetryReport taskKey = " + str + " resultCode = " + i3 + " errMsg = " + str2 + " seq = " + i16);
            String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
            HashMap hashMap = new HashMap();
            hashMap.put("req_seq", String.valueOf(i16));
            hashMap.put("result", String.valueOf(i3));
            hashMap.put("err_msg", str2);
            hashMap.put("network", c16);
            com.tencent.mobileqq.qqlive.report.tianjige.g gVar = this.f271441i;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            hashMap.put("source", gVar.c(str, z16, "qls_request_succeed", "qls_request_error"));
            this.f271441i.e(str, hashMap);
            this.f271441i.f(str, i3);
            this.f271441i.b(str);
        } catch (Exception e16) {
            QLog.e("QQLiveProtocolsReportApiImpl", 1, "doEndOpenTelemetryReport:", e16);
        }
    }

    private String o(ToServiceMsg toServiceMsg) {
        Bundle bundle = toServiceMsg.extraData;
        if (bundle != null) {
            Object obj = bundle.get("live_cmd");
            if (obj instanceof String) {
                return (String) obj;
            }
            return "";
        }
        return "";
    }

    private String p(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return null;
        }
        return toServiceMsg.extraData.getString("qqlive_msg_send_pb_report");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(boolean z16) {
        QLog.i("QQLiveProtocolsReportApiImpl", 1, "init sdk result:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        Iterator<b.a> it = this.f271442m.iterator();
        while (it.hasNext()) {
            it.next().a(true);
        }
        this.f271442m.clear();
        this.f271438e = true;
        this.f271439f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.f271441i = new com.tencent.mobileqq.qqlive.report.tianjige.g(new com.tencent.mobileqq.qqlive.report.tianjige.e("now", new b()));
        ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.qqlive.report.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.t();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad A[Catch: Exception -> 0x00b1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b1, blocks: (B:16:0x002c, B:19:0x0051, B:22:0x0058, B:23:0x008f, B:25:0x00ad, B:28:0x0074), top: B:15:0x002c }] */
    @Override // com.tencent.mobileqq.qqlive.report.tianjige.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(ToServiceMsg toServiceMsg, String str, String str2) {
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, toServiceMsg, str, str2);
        }
        if (!this.f271438e) {
            return "";
        }
        if (toServiceMsg == null) {
            QLog.i("QQLiveProtocolsReportApiImpl", 1, "startQQLiveMsgProtocolReport toServiceMsg null!");
            return "";
        }
        try {
            String str3 = str + "_" + str2;
            String g16 = this.f271441i.g(str3, null);
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(g16)) {
                QLog.i("QQLiveProtocolsReportApiImpl", 1, "startQQLiveMsgProtocolReport serviceCmd = " + str3 + " taskKey = " + g16);
                this.f271441i.e(g16, new HashMap());
                toServiceMsg.extraData.putString("qqlive_msg_send_pb_report", g16);
                d16 = this.f271441i.d(g16);
                if (!TextUtils.isEmpty(d16)) {
                    toServiceMsg.setTraceInfo(d16);
                }
                return d16;
            }
            QLog.i("QQLiveProtocolsReportApiImpl", 1, "serviceCmd error || taskKey error serviceCmd = " + str3 + " taskKey = " + g16);
            this.f271441i.e(g16, new HashMap());
            toServiceMsg.extraData.putString("qqlive_msg_send_pb_report", g16);
            d16 = this.f271441i.d(g16);
            if (!TextUtils.isEmpty(d16)) {
            }
            return d16;
        } catch (Exception e16) {
            QLog.e("QQLiveProtocolsReportApiImpl", 1, "startQQLiveMsgProtocolReport:", e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.b
    public String c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (!this.f271438e) {
            return "";
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String p16 = p(toServiceMsg);
            toServiceMsg.getServiceCmd();
            String traceInfo = toServiceMsg.getTraceInfo();
            if (TextUtils.isEmpty(p16)) {
                QLog.i("QQLiveProtocolsReportApiImpl", 1, "endQQLiveMsgProtocolReport taskKey error!");
                return "";
            }
            QLog.i("QQLiveProtocolsReportApiImpl", 1, "endQQLiveMsgProtocolReport taskKey = " + p16 + " realCmd = " + o(toServiceMsg) + " traceInfo:" + traceInfo);
            n(p16, fromServiceMsg.getResultCode(), fromServiceMsg.getBusinessFailMsg(), fromServiceMsg.getAppSeq());
            return traceInfo;
        }
        QLog.i("QQLiveProtocolsReportApiImpl", 1, "endQQLiveMsgProtocolReport args error!");
        return "";
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void s(final b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        if (!q()) {
            aVar.a(false);
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.report.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.s(aVar);
                }
            });
            return;
        }
        if (this.f271438e) {
            aVar.a(true);
            return;
        }
        if (this.f271440h == null) {
            QLog.i("QQLiveProtocolsReportApiImpl", 1, "init sdk fail,because sdkConfig is null");
            aVar.a(false);
            return;
        }
        this.f271442m.add(aVar);
        if (this.f271439f) {
            QLog.i("QQLiveProtocolsReportApiImpl", 1, "sdk is in initing!!!");
        } else {
            this.f271439f = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.report.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.u();
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.f271440h = iQQLiveSDK.getSDKConfig();
            s(new b.a() { // from class: com.tencent.mobileqq.qqlive.report.c
                @Override // com.tencent.mobileqq.qqlive.report.tianjige.b.a
                public final void a(boolean z16) {
                    g.r(z16);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.b
    public boolean isInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f271438e;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f271437d == 0) {
            if (VasToggle.MINISDK_TIANJIGE.isEnable(true)) {
                this.f271437d = 1;
            } else {
                this.f271437d = -1;
            }
        }
        if (this.f271437d == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }
}

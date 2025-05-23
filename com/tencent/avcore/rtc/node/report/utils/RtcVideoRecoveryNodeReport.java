package com.tencent.avcore.rtc.node.report.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.avcore.rtc.node.report.data.EndState;
import com.tencent.avcore.rtc.node.report.data.NodeModel$CallType;
import com.tencent.avcore.rtc.node.report.data.StartState;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class RtcVideoRecoveryNodeReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private CommonNodeData f77538a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.avcore.rtc.node.report.data.a f77539b;

    /* renamed from: c, reason: collision with root package name */
    private String f77540c;

    /* renamed from: d, reason: collision with root package name */
    private String f77541d;

    public RtcVideoRecoveryNodeReport(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3));
            return;
        }
        this.f77538a = new CommonNodeData();
        this.f77539b = new com.tencent.avcore.rtc.node.report.data.a();
        this.f77540c = "";
        this.f77541d = "";
        this.f77538a.callType = NodeModel$CallType.K_SINGLE_PERSON.ordinal();
        CommonNodeData commonNodeData = this.f77538a;
        commonNodeData.selfAccout = str;
        commonNodeData.peerAccout = str2;
        commonNodeData.traceId = str3;
        commonNodeData.businessType = 0;
        commonNodeData.accoutType = 0;
        commonNodeData.deviceType = DeviceInfoMonitor.getModel();
        CommonNodeData commonNodeData2 = this.f77538a;
        commonNodeData2.platform = "Android";
        commonNodeData2.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        com.tencent.avcore.rtc.node.report.data.a aVar = this.f77539b;
        aVar.f77529a = i3;
        aVar.f77531c = String.valueOf(i3);
        com.tencent.avcore.rtc.node.report.data.a aVar2 = this.f77539b;
        aVar2.f77530b = 0;
        aVar2.f77532d = -1;
        aVar2.f77534f = new StartState();
        this.f77539b.f77534f.startTime = System.currentTimeMillis();
        com.tencent.avcore.rtc.node.report.data.a aVar3 = this.f77539b;
        EndState endState = aVar3.f77535g;
        endState.reason = 0;
        endState.statusCode = 0;
        aVar3.f77533e = this.f77538a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("self_accout", String.valueOf(this.f77538a.selfAccout));
        hashMap.put("peer_accout", String.valueOf(this.f77538a.peerAccout));
        hashMap.put("accout_type", String.valueOf(this.f77538a.accoutType));
        hashMap.put("platform", String.valueOf(this.f77538a.platform));
        hashMap.put("device_type", String.valueOf(this.f77538a.deviceType));
        hashMap.put("os_version", String.valueOf(this.f77538a.osVersion));
        hashMap.put("call_type", String.valueOf(this.f77538a.callType));
        hashMap.put("business_type", String.valueOf(this.f77538a.businessType));
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f77538a.roomId));
        hashMap.put("trace_id", String.valueOf(this.f77538a.traceId));
        hashMap.put("msg_link_type", String.valueOf(this.f77538a.msgLinkType));
        hashMap.put("local_sdk_version", String.valueOf(this.f77538a.sdkVersion));
        hashMap.put("node_id", String.valueOf(this.f77539b.f77529a));
        hashMap.put("node_type", String.valueOf(this.f77539b.f77530b));
        hashMap.put("node_name", String.valueOf(this.f77539b.f77531c));
        hashMap.put("parent_node", String.valueOf(this.f77539b.f77532d));
        hashMap.put("start_source", String.valueOf(this.f77539b.f77534f.source));
        hashMap.put("start_time", String.valueOf(this.f77539b.f77534f.startTime));
        if (!TextUtils.isEmpty(this.f77540c) && !TextUtils.isEmpty(this.f77541d)) {
            hashMap.put("event_0_id", this.f77540c);
            hashMap.put("event_0_param_0", this.f77541d);
        }
        hashMap.put("end_status_code", String.valueOf(this.f77539b.f77535g.statusCode));
        hashMap.put("end_reason", String.valueOf(this.f77539b.f77535g.reason));
        a.b("0DOU0EDF8O4GDAXD", "rtc_node_report", hashMap);
        QLog.d("RtcVideoRecoveryNodeReport", 1, "node_id=" + this.f77539b.f77529a + ",traceId=" + this.f77538a.traceId);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.avcore.rtc.node.report.utils.RtcVideoRecoveryNodeReport.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RtcVideoRecoveryNodeReport.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        RtcVideoRecoveryNodeReport.this.b();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 128, null, true);
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f77539b.f77535g.reason = i3;
        }
    }

    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f77540c = str;
            this.f77541d = str2;
        }
    }
}

package com.tencent.avcore.rtc.node.report;

import android.os.Build;
import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.avcore.rtc.node.report.data.EndState;
import com.tencent.avcore.rtc.node.report.data.NodeModel$BusinessType;
import com.tencent.avcore.rtc.node.report.data.NodeModel$CallType;
import com.tencent.avcore.rtc.node.report.data.NodeModel$EndStatusCode;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.data.StartState;
import com.tencent.avcore.rtc.node.report.data.a;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class RtcNodeReportMainProcessTask implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<String> f77486i;

    /* renamed from: d, reason: collision with root package name */
    private final String f77487d;

    /* renamed from: e, reason: collision with root package name */
    private final String f77488e;

    /* renamed from: f, reason: collision with root package name */
    private CommonNodeData f77489f;

    /* renamed from: h, reason: collision with root package name */
    private a f77490h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33226);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f77486i = new ConcurrentLinkedQueue<>();
        }
    }

    public RtcNodeReportMainProcessTask(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4);
            return;
        }
        this.f77487d = "\u53d1\u8d77\u65b9\u4e3b\u8fdb\u7a0b\u9080\u8bf7(AND\u4e13\u6709)";
        this.f77489f = new CommonNodeData();
        this.f77490h = new a();
        this.f77488e = str3;
        this.f77489f.callType = NodeModel$CallType.K_SINGLE_PERSON.ordinal();
        CommonNodeData commonNodeData = this.f77489f;
        commonNodeData.selfAccout = str;
        commonNodeData.peerAccout = str2;
        commonNodeData.traceId = str3;
        commonNodeData.businessType = 0;
        commonNodeData.accoutType = 0;
        commonNodeData.deviceType = DeviceInfoMonitor.getModel();
        CommonNodeData commonNodeData2 = this.f77489f;
        commonNodeData2.platform = "android";
        commonNodeData2.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        a aVar = this.f77490h;
        aVar.f77529a = 100;
        aVar.f77531c = "\u53d1\u8d77\u65b9\u4e3b\u8fdb\u7a0b\u9080\u8bf7(AND\u4e13\u6709)";
        aVar.f77530b = 0;
        aVar.f77532d = -1;
        aVar.f77534f = new StartState();
        this.f77490h.f77534f.startTime = System.currentTimeMillis();
        this.f77490h.f77534f.source = Integer.parseInt(str4);
        this.f77490h.f77533e = this.f77489f;
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = f77486i;
        if (concurrentLinkedQueue.size() > 5) {
            concurrentLinkedQueue.poll();
        }
        concurrentLinkedQueue.offer(str3);
    }

    public static void a(String str) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = f77486i;
        if (concurrentLinkedQueue.size() > 5) {
            concurrentLinkedQueue.poll();
        }
        concurrentLinkedQueue.remove(str);
    }

    private void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("self_accout", String.valueOf(this.f77489f.selfAccout));
        hashMap.put("peer_accout", String.valueOf(this.f77489f.peerAccout));
        hashMap.put("accout_type", String.valueOf(this.f77489f.accoutType));
        hashMap.put("platform", String.valueOf(this.f77489f.platform));
        hashMap.put("device_type", String.valueOf(this.f77489f.deviceType));
        hashMap.put("os_version", String.valueOf(this.f77489f.osVersion));
        hashMap.put("call_type", String.valueOf(this.f77489f.callType));
        hashMap.put("business_type", String.valueOf(this.f77489f.businessType));
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f77489f.roomId));
        hashMap.put("trace_id", String.valueOf(this.f77489f.traceId));
        hashMap.put("msg_link_type", String.valueOf(this.f77489f.msgLinkType));
        hashMap.put("local_sdk_version", String.valueOf(this.f77489f.sdkVersion));
        hashMap.put("node_id", String.valueOf(this.f77490h.f77529a));
        hashMap.put("node_type", String.valueOf(this.f77490h.f77530b));
        hashMap.put("node_name", String.valueOf(this.f77490h.f77531c));
        hashMap.put("parent_node", String.valueOf(this.f77490h.f77532d));
        hashMap.put("start_source", String.valueOf(this.f77490h.f77534f.source));
        hashMap.put("start_time", String.valueOf(this.f77490h.f77534f.startTime));
        hashMap.put("end_status_code", String.valueOf(this.f77490h.f77535g.statusCode));
        hashMap.put("end_reason", String.valueOf(this.f77490h.f77535g.reason));
        com.tencent.avcore.rtc.node.report.utils.a.b("0DOU0EDF8O4GDAXD", "rtc_node_report", hashMap);
    }

    public void b(boolean z16) {
        NodeModel$BusinessType nodeModel$BusinessType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        CommonNodeData commonNodeData = this.f77489f;
        if (z16) {
            nodeModel$BusinessType = NodeModel$BusinessType.K_AUDIO;
        } else {
            nodeModel$BusinessType = NodeModel$BusinessType.K_VIDEO;
        }
        commonNodeData.businessType = nodeModel$BusinessType.ordinal();
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f77489f.accoutType = i3;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f77490h.f77535g = new EndState();
        this.f77490h.f77535g.endTime = System.currentTimeMillis();
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = f77486i;
        if (concurrentLinkedQueue.contains(this.f77488e)) {
            this.f77490h.f77535g.statusCode = NodeModel$EndStatusCode.K_NORMAL.ordinal();
            this.f77490h.f77535g.reason = NodeModel$NodeEndReason.K_INTERRUPTION.ordinal();
            concurrentLinkedQueue.remove(this.f77488e);
        } else {
            this.f77490h.f77535g.statusCode = NodeModel$EndStatusCode.K_ABNORMAL.ordinal();
            this.f77490h.f77535g.reason = NodeModel$NodeEndReason.K_NORMAL.ordinal();
        }
        e();
    }
}

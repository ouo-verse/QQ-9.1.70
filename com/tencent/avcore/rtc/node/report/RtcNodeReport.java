package com.tencent.avcore.rtc.node.report;

import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.avcore.rtc.node.report.data.EndState;
import com.tencent.avcore.rtc.node.report.data.NodeEvent;
import com.tencent.avcore.rtc.node.report.data.NodeInfo;
import com.tencent.avcore.rtc.node.report.data.StartState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RtcNodeReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f77485a;

    RtcNodeReport(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.f77485a = j3;
        }
    }

    public static synchronized RtcNodeReport e() {
        RtcNodeReport rtcNodeReport;
        synchronized (RtcNodeReport.class) {
            rtcNodeReport = new RtcNodeReport(0L);
        }
        return rtcNodeReport;
    }

    private native void nativeAddNodeEvent(long j3, String str, int i3, NodeEvent nodeEvent);

    private native void nativeCleanAllNodeReport(long j3);

    private native void nativeCleanNodeReport(long j3, String str);

    private static native long nativeCreate();

    private native void nativeDestroy(long j3);

    private native void nativeEndNode(long j3, String str, int i3, EndState endState);

    private native void nativeReport(long j3, String str, int i3);

    private native void nativeReportInterrupt(long j3, int i3, long j16);

    private native void nativeSetCallback(long j3, RtcNodeReportManager rtcNodeReportManager, String str);

    private native void nativeSetNodeCommonData(long j3, String str, CommonNodeData commonNodeData);

    private native void nativeStartNode(long j3, String str, int i3, StartState startState, NodeInfo nodeInfo);

    public void a(String str, int i3, NodeEvent nodeEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), nodeEvent);
        } else {
            nativeAddNodeEvent(this.f77485a, str, i3, nodeEvent);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            nativeCleanAllNodeReport(this.f77485a);
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            nativeCleanNodeReport(this.f77485a, str);
        }
    }

    public void d(String str, int i3, EndState endState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), endState);
        } else {
            nativeEndNode(this.f77485a, str, i3, endState);
        }
    }

    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        } else {
            nativeReport(this.f77485a, str, i3);
        }
    }

    public void g(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            nativeReportInterrupt(this.f77485a, i3, j3);
        }
    }

    public void h(RtcNodeReportManager rtcNodeReportManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rtcNodeReportManager);
            return;
        }
        nativeSetCallback(this.f77485a, rtcNodeReportManager, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/rtc_node_report.cfg");
    }

    public void i(String str, CommonNodeData commonNodeData, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, commonNodeData, str2);
        } else {
            nativeSetNodeCommonData(this.f77485a, str, commonNodeData);
        }
    }

    public void j(String str, int i3, StartState startState, NodeInfo nodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), startState, nodeInfo);
        } else {
            nativeStartNode(this.f77485a, str, i3, startState, nodeInfo);
        }
    }
}

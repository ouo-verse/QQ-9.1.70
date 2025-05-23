package com.tencent.avcore.rtc.node.report.utils;

import android.os.Build;
import com.tencent.avcore.rtc.node.report.RtcNodeReportManager;
import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.avcore.rtc.node.report.data.EndState;
import com.tencent.avcore.rtc.node.report.data.NodeEvent;
import com.tencent.avcore.rtc.node.report.data.NodeInfo;
import com.tencent.avcore.rtc.node.report.data.NodeModel$BusinessType;
import com.tencent.avcore.rtc.node.report.data.NodeModel$CallType;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.data.StartState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RtcNodeReportReceiverHelper {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper cleanNode failed");
            return;
        }
        RtcNodeReportManager.getInstance().cleanNodeReport(str);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper cleanNode [" + str + "]");
    }

    public static void b(String str) {
        r(str, 0, 0);
        m(str);
        l(str, 0, 0);
        v(str);
        s(str, 1, 0);
        q(str);
        p(str, 0, 0);
        o(str);
        n(str, 0, 0);
    }

    public static void c(String str, int i3, int i16) {
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper dealCloseSession");
        k(str);
        j(str, i3, i16);
        a(str);
    }

    public static void d(int i3, String str) {
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper dealHandleInviteEventRsp");
        if (i3 == 12) {
            NodeModel$NodeEndReason nodeModel$NodeEndReason = NodeModel$NodeEndReason.K_NORMAL;
            r(str, 0, nodeModel$NodeEndReason.ordinal());
            m(str);
            l(str, 0, nodeModel$NodeEndReason.ordinal());
            return;
        }
        r(str, i3, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
    }

    public static void e(String str) {
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper dealOnAutoAcceptInvite");
        NodeModel$NodeEndReason nodeModel$NodeEndReason = NodeModel$NodeEndReason.K_NORMAL;
        l(str, 0, nodeModel$NodeEndReason.ordinal());
        v(str);
        s(str, 1, nodeModel$NodeEndReason.ordinal());
    }

    public static void f(String str, String str2) {
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper dealOnPeerRelaySvrInfoChange");
        CommonNodeData commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str);
        if (commonNodeData == null) {
            commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str2);
        }
        if (commonNodeData != null) {
            commonNodeData.traceId = str2;
        }
        k(str);
        j(str, 0, 0);
        a(str);
        RtcNodeReportManager.getInstance().setNodeCommonData(str2, commonNodeData, "");
    }

    public static void g(String str, String str2) {
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper dealOnPeerSwitchTerminal");
        CommonNodeData commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str);
        if (commonNodeData == null) {
            commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str2);
        } else {
            commonNodeData.traceId = str2;
        }
        RtcNodeReportManager.getInstance().setNodeCommonData(str2, commonNodeData, "");
        k(str);
        j(str, 0, 0);
        a(str);
        b(str2);
    }

    public static void h(String str) {
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper dealOnReceivePeerRelaySvrInfo");
        q(str);
        p(str, 0, NodeModel$NodeEndReason.K_NORMAL.ordinal());
        o(str);
    }

    public static void i(String str, int i3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper modifyUinType failed");
            return;
        }
        CommonNodeData commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str);
        if (commonNodeData != null) {
            commonNodeData.accoutType = i3;
            RtcNodeReportManager.getInstance().setNodeCommonData(str, commonNodeData, "");
        }
    }

    public static void j(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportFinishCallTalkEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 1200, endState);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportFinishCallTalkEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void k(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportFinishCallTalkStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(1200);
        aVar.m("kAVChatEnd");
        aVar.n(0);
        aVar.j(true);
        RtcNodeReportManager.getInstance().startNode(str, 1200, startState, aVar.i());
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportFinishCallTalkStartNode [" + str + "]");
    }

    public static void l(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverCallInPageExposureEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 800, endState);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverCallInPageExposureEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void m(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverCallInPageExposureStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(800);
        aVar.m("kAVCallInPageExposure");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 800, startState, aVar.i());
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverCallInPageExposureStartNode [" + str + "]");
    }

    public static void n(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatConnectEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 1100, endState);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatConnectEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void o(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatConnectStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(1100);
        aVar.m("kAVChatConnection");
        aVar.n(0);
        aVar.k(true);
        RtcNodeReportManager.getInstance().startNode(str, 1100, startState, aVar.i());
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatConnectStartNode [" + str + "]");
    }

    public static void p(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatPageExposureEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 1000, endState);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatPageExposureEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void q(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatPageExposureStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(1000);
        aVar.m("kAVChatPageExposure");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 1000, startState, aVar.i());
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverChatPageExposureStartNode [" + str + "]");
    }

    public static void r(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 700, endState);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void s(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 900, endState);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void t(String str, long j3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleEvent failed " + j3);
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = "rtc_receiver_page_exposure_cost_time_ms";
        nodeEvent.attributes = "cost_time_ms=" + j3 + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 900, nodeEvent);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleEvent [" + str + "][" + j3 + "]");
    }

    public static void u(String str, String str2, long j3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleEvent failed " + j3);
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = str2;
        nodeEvent.attributes = "cost_time_ms=" + j3 + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 900, nodeEvent);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleEvent [" + str + "][" + str2 + "][" + j3 + "]");
    }

    public static void v(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(900);
        aVar.m("kAVInviteHandle");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 900, startState, aVar.i());
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteHandleStartNode [" + str + "]");
    }

    public static void w(String str, int i3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        startState.source = i3;
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(700);
        aVar.m("kAVRecvInvite");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 700, startState, aVar.i());
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper reportReceiverInviteStartNode [" + str + "," + i3 + "]");
    }

    public static void x(String str) {
        RtcNodeReportManager.getInstance().postDelayRunnable(new Runnable(str) { // from class: com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f77537d;

            {
                this.f77537d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    RtcNodeReportReceiverHelper.r(this.f77537d, 1, NodeModel$NodeEndReason.K_TIME_OUT.ordinal());
                }
            }
        }, 2000L);
    }

    public static void y(String str, String str2, String str3, boolean z16, long j3) {
        String str4;
        NodeModel$BusinessType nodeModel$BusinessType;
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper setReceiverCommonNodeReport failed");
            return;
        }
        CommonNodeData commonNodeData = new CommonNodeData();
        commonNodeData.callType = NodeModel$CallType.K_SINGLE_PERSON.ordinal();
        if (str2 == null) {
            str2 = "";
        }
        commonNodeData.selfAccout = str2;
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        commonNodeData.peerAccout = str4;
        commonNodeData.traceId = str;
        commonNodeData.accoutType = 0;
        commonNodeData.deviceType = "phone";
        commonNodeData.platform = "android";
        commonNodeData.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        if (z16) {
            nodeModel$BusinessType = NodeModel$BusinessType.K_AUDIO;
        } else {
            nodeModel$BusinessType = NodeModel$BusinessType.K_VIDEO;
        }
        commonNodeData.businessType = nodeModel$BusinessType.ordinal();
        commonNodeData.roomId = j3;
        RtcNodeReportManager.getInstance().setNodeCommonData(str, commonNodeData, "");
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper setReceiverCommonNodeReport [" + str + "," + str3 + "]");
    }

    public static void z(String str, long j3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper setReceiverInviteNodeCallResponseEvent failed");
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = "send_invite_response_time_ms";
        nodeEvent.attributes = "cost_time_ms=" + j3 + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 700, nodeEvent);
        QLog.d("RtcNodeReportReceiverHelper", 1, "RtcNodeReportReceiverHelper setReceiverInviteNodeCallResponseEvent [" + str + "," + j3 + "]");
    }
}

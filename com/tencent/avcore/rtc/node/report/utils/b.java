package com.tencent.avcore.rtc.node.report.utils;

import android.os.Build;
import com.tencent.avcore.rtc.node.report.RtcNodeReportManager;
import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.avcore.rtc.node.report.data.EndState;
import com.tencent.avcore.rtc.node.report.data.NodeEvent;
import com.tencent.avcore.rtc.node.report.data.NodeInfo;
import com.tencent.avcore.rtc.node.report.data.NodeModel$BusinessType;
import com.tencent.avcore.rtc.node.report.data.NodeModel$CallType;
import com.tencent.avcore.rtc.node.report.data.NodeModel$EndStatusCode;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.data.StartState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper cleanNode failed");
            return;
        }
        RtcNodeReportManager.getInstance().cleanNodeReport(str);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper cleanNode [" + str + "]");
    }

    public static void b(boolean z16, String str, int i3, int i16) {
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper dealCloseSession peerTerminalSwitch:=" + z16);
        if (!z16) {
            s(str);
            r(str, i3, i16);
            a(str);
            return;
        }
        RtcNodeReportReceiverHelper.c(str, i3, i16);
    }

    public static void c(int i3, String str) {
        int i16;
        int i17;
        int i18 = 1;
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper dealCreateRoomFailed errorCode:=" + i3);
        if (i3 == 1) {
            i17 = 6;
        } else {
            i16 = 7;
            if (i3 == 3) {
                i3 = 2;
            } else {
                i18 = 5;
                if (i3 == 5) {
                    i16 = 8;
                    i3 = 3;
                } else if (i3 == 7) {
                    i17 = 9;
                } else {
                    i16 = i3;
                }
            }
            NodeModel$NodeEndReason nodeModel$NodeEndReason = NodeModel$NodeEndReason.K_INTERRUPTION;
            v(str, i3, nodeModel$NodeEndReason.ordinal());
            m(str, false);
            i(str, i16, nodeModel$NodeEndReason.ordinal());
        }
        i16 = i17;
        i3 = i18;
        NodeModel$NodeEndReason nodeModel$NodeEndReason2 = NodeModel$NodeEndReason.K_INTERRUPTION;
        v(str, i3, nodeModel$NodeEndReason2.ordinal());
        m(str, false);
        i(str, i16, nodeModel$NodeEndReason2.ordinal());
    }

    public static void d(String str) {
        m(str, true);
        i(str, 0, 0);
        p(str);
        q(str, 0, 0);
        o(str);
        n(str, 0, 0);
        s(str);
        r(str, 0, 0);
        a(str);
    }

    public static void e(String str) {
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper dealOnOtherTerminalChattingStatus");
        m(str, true);
        NodeModel$NodeEndReason nodeModel$NodeEndReason = NodeModel$NodeEndReason.K_NORMAL;
        i(str, 0, nodeModel$NodeEndReason.ordinal());
        p(str);
        q(str, NodeModel$EndStatusCode.K_NORMAL.ordinal(), nodeModel$NodeEndReason.ordinal());
        o(str);
        n(str, 0, 0);
    }

    public static void f(boolean z16, String str, String str2) {
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper dealOnPeerRelaySvrInfoChange");
        CommonNodeData commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str);
        if (commonNodeData != null) {
            commonNodeData.traceId = str2;
        } else {
            commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str2);
        }
        if (z16) {
            v(str, 0, 0);
            m(str, true);
            i(str, 0, 0);
            p(str);
            q(str, 0, 0);
            o(str);
            n(str, 0, 0);
        }
        s(str);
        r(str, 0, 0);
        a(str);
        RtcNodeReportManager.getInstance().setNodeCommonData(str2, commonNodeData, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/rtc_node_report.cfg");
    }

    public static void g(String str, String str2) {
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper dealOnPeerSwitchTerminal");
        CommonNodeData commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str);
        if (commonNodeData != null) {
            commonNodeData.traceId = str2;
        }
        s(str);
        r(str, 0, 0);
        a(str);
        RtcNodeReportReceiverHelper.b(str2);
        RtcNodeReportManager.getInstance().setNodeCommonData(str2, commonNodeData, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/rtc_node_report.cfg");
    }

    public static void h(boolean z16, String str) {
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper dealOnReceivePeerRelaySvrInfo");
        if (z16) {
            u(str, "5");
            t(str, 0, 0);
            w(str, "5");
            v(str, 0, 0);
            k(str);
        }
        m(str, true);
        NodeModel$NodeEndReason nodeModel$NodeEndReason = NodeModel$NodeEndReason.K_NORMAL;
        i(str, 0, nodeModel$NodeEndReason.ordinal());
        p(str);
        q(str, NodeModel$EndStatusCode.K_NORMAL.ordinal(), nodeModel$NodeEndReason.ordinal());
        o(str);
    }

    public static void i(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 300, endState);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void j(String str, long j3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureKeyEvent failed");
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = "rtc_caller_page_exposure_cost_time_ms";
        nodeEvent.attributes = "cost_time_ms=" + j3 + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 300, nodeEvent);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureKeyEvent [" + str + "," + j3 + "]");
    }

    public static void k(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(300);
        aVar.m("kAVCallOutPageExposure");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 300, startState, aVar.i());
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureStartNode [" + str + "]");
    }

    public static void l(String str, String str2, long j3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureTabEvent failed");
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = str2;
        nodeEvent.attributes = "cost_time_ms=" + j3 + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 300, nodeEvent);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageExposureTabEvent [" + str + "," + j3 + "]");
    }

    public static void m(String str, boolean z16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageInviteStatus failed");
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = "rtc_receiver_page_exposure_on_reached";
        nodeEvent.attributes = "param_key=" + (z16 ? 1 : 0) + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 300, nodeEvent);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallOutPageInviteStatus [" + str + "," + z16 + "]");
    }

    public static void n(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalkConnectEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 500, endState);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalkConnectEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void o(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalkConnectStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(500);
        aVar.m("kAVChatConnection");
        aVar.n(0);
        aVar.k(true);
        RtcNodeReportManager.getInstance().startNode(str, 500, startState, aVar.i());
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalkConnectStartNode [" + str + "]");
    }

    public static void p(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalkPageExposureStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(400);
        aVar.m("kAVCallOutPageExposure");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 400, startState, aVar.i());
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalkPageExposureStartNode [" + str + "]");
    }

    public static void q(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalktPageExposureEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 400, endState);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportCallTalktPageExposureEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void r(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportFinishCallTalkStartNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 600, endState);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportFinishCallTalkEndNode [" + str + "," + i16 + "," + i3 + "]");
    }

    public static void s(String str) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportFinishCallTalkStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(600);
        aVar.m("kAVChatEnd");
        aVar.n(0);
        aVar.j(true);
        RtcNodeReportManager.getInstance().startNode(str, 600, startState, aVar.i());
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportFinishCallTalkStartNode [" + str + "]");
    }

    public static void t(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteAndroidEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 100, endState);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteAndroidEndNode [" + str + "," + i3 + "]");
    }

    public static void u(String str, String str2) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteAndroidStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        startState.source = Integer.parseInt(str2);
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(100);
        aVar.m("kAVSendInviteForAndroid");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 100, startState, aVar.i());
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteAndroidStartNode [" + str + "," + str2 + "]");
    }

    public static void v(String str, int i3, int i16) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteEndNode failed");
            return;
        }
        EndState endState = new EndState();
        endState.endTime = System.currentTimeMillis();
        endState.reason = i16;
        endState.statusCode = i3;
        RtcNodeReportManager.getInstance().endNode(str, 200, endState);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteEndNode [" + str + "," + i16 + "]");
    }

    public static void w(String str, String str2) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteStartNode failed");
            return;
        }
        StartState startState = new StartState();
        startState.startTime = System.currentTimeMillis();
        startState.source = Integer.parseInt(str2);
        NodeInfo.a aVar = new NodeInfo.a();
        aVar.l(200);
        aVar.m("reportSendInviteStartNode");
        aVar.n(0);
        RtcNodeReportManager.getInstance().startNode(str, 200, startState, aVar.i());
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper reportSendInviteStartNode [" + str + "," + str2 + "]");
    }

    public static void x(String str, String str2, String str3, boolean z16, long j3) {
        NodeModel$BusinessType nodeModel$BusinessType;
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper setReceiverCommonNodeReport failed");
            return;
        }
        CommonNodeData commonNodeData = new CommonNodeData();
        commonNodeData.callType = NodeModel$CallType.K_SINGLE_PERSON.ordinal();
        String str4 = "";
        if (str2 == null) {
            str2 = "";
        }
        commonNodeData.selfAccout = str2;
        if (str3 != null) {
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
        RtcNodeReportManager.getInstance().setNodeCommonData(str, commonNodeData, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/rtc_node_report.cfg");
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper setSendCommonNodeReport [" + str + "," + str3 + "]");
    }

    public static void y(String str, long j3) {
        if (!c.a(str)) {
            QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper setSendInviteNodeCallResponseEvent failed");
            return;
        }
        NodeEvent nodeEvent = new NodeEvent();
        nodeEvent.eventTime = System.currentTimeMillis();
        nodeEvent.eventId = "rtc_caller_page_msg_send_cost_time_ms";
        nodeEvent.attributes = "cost_time_ms=" + j3 + ";";
        RtcNodeReportManager.getInstance().addNodeEvent(str, 200, nodeEvent);
        QLog.d("RtcNodeReportCallHelper", 1, "RtcNodeReportCallHelper setSendInviteNodeCallResponseEvent [" + str + "," + j3 + "]");
    }
}

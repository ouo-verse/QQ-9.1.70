package com.tencent.av.business.manager.report;

import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static final String a(int i3) {
        if (i3 != 0) {
            switch (i3) {
                case 9:
                    return "roomid";
                case 10:
                    return "self_uin";
                case 11:
                    return ProtocolDownloaderConstants.HEADER_FRIEND_UIN;
                case 12:
                    return "role";
                case 13:
                    return "business_type";
                case 14:
                    return "business_id";
                case 15:
                    return "session_type";
                case 16:
                    return "process_exit_reason";
                case 17:
                    return "current_node";
                case 18:
                    return "battery";
                case 19:
                    return "is_lock_screen";
                case 20:
                    return j.P0;
                case 21:
                    return "memory_total";
                case 22:
                    return "memory_left";
                case 23:
                    return "memory_usage";
                case 24:
                    return "duration";
                case 25:
                    return "node_entrance";
                case 26:
                    return "node_ui_init";
                case 27:
                    return "node_process_create";
                case 28:
                    return "node_sdk_req";
                case 29:
                    return "node_ui_call";
                case 30:
                    return "node_sdk_connect";
                case 31:
                    return "node_ui_talk";
                case 32:
                    return "node_ui_small";
                case 33:
                    return "node_session_close";
                case 34:
                    return "node_intent_recv";
                case 35:
                    return "node_msf_recv";
                case 36:
                    return "node_sdk_recv";
                case 37:
                    return "node_action_accept";
                case 38:
                    return "node_action_reject";
                case 39:
                    return "node_action_timeout";
                case 40:
                    return "report_version";
                case 41:
                    return "memory_level";
                case 42:
                    return "memory_remain_percen";
                case 43:
                    return "is_effects";
                case 44:
                    return "is_camera_self_open";
                case 45:
                    return "is_camera_peer_open";
                case 46:
                    return "is_mic_self_open";
                case 47:
                    return "is_mic_peer_open";
                default:
                    return i3 + "";
            }
        }
        return VRReportDefine$ReportParam.REPORT_STATUS;
    }
}

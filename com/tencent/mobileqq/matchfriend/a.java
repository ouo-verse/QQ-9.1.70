package com.tencent.mobileqq.matchfriend;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(AppInterface appInterface, msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq, String str, long j3) {
        if (j3 != 0 && appInterface != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MatchFriendMsgReportsendReadConfirm_PB", 2, "createMsgReadConfirm is called curFriendUin = " + str);
            }
            if (appInterface.getCurrentAccountUin() == null) {
                return;
            }
            msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
            uinPairReadInfo.peer_uin.set(Long.parseLong(str));
            uinPairReadInfo.last_read_time.set((int) j3);
            uinPairReadInfo.aio_type.set(4);
            msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
            msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
            byte[] F0 = ((e) appInterface.getMsgCache()).F0();
            if (F0 != null) {
                msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
            }
            if (msg_svc_pbmsgreadedreportreq == null) {
                msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
            }
            msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
        }
    }
}

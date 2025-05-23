package com.tencent.mobileqq.app;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BusinessHandlerUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int MM_APP_ID = 1000277;

    public BusinessHandlerUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkReportErrorToMM(FromServiceMsg fromServiceMsg, String str) {
        if (reportErrorToMM(fromServiceMsg)) {
            if (QLog.isColorLevel()) {
                QLog.d("msgCmdFilter", 2, "report MM:cmd=" + fromServiceMsg.getServiceCmd() + ", error code=" + fromServiceMsg.getBusinessFailCode() + ", uin=" + str);
            }
            ReportCenter.f().r(fromServiceMsg.getServiceCmd(), 100, fromServiceMsg.getBusinessFailCode(), str, 1000277, HardCodeUtil.qqStr(R.string.k5b) + fromServiceMsg.getServiceCmd(), true);
        }
    }

    public static <T extends MessageMicro<T>> T decodeOIDB(String str, byte[] bArr, Class<T> cls) {
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
            if (mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                try {
                    T newInstance = cls.newInstance();
                    newInstance.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    return newInstance;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(str, 2, "rspBody merge fail " + e16.toString());
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e(str, 2, "sso check fail " + mergeFrom.uint32_result.get());
            }
            return null;
        } catch (InvalidProtocolBufferMicroException e17) {
            if (QLog.isColorLevel()) {
                QLog.e(str, 2, "merge fail " + e17.toString());
            }
            return null;
        }
    }

    protected static boolean reportErrorToMM(FromServiceMsg fromServiceMsg) {
        if (!fromServiceMsg.isSuccess() && (fromServiceMsg.getServiceCmd().equals("RoamClientSvr.GetQualify") || fromServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetPoint"))) {
            return true;
        }
        return false;
    }
}

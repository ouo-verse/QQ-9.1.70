package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x9db.cmd0x9db$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        long j3;
        int i16;
        boolean z16;
        if ("OidbSvc.0x9db".equals(fromServiceMsg.getServiceCmd())) {
            cmd0x9db$RspBody cmd0x9db_rspbody = new cmd0x9db$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x9db_rspbody);
            if (cmd0x9db_rspbody.int32_result.has()) {
                i3 = cmd0x9db_rspbody.int32_result.get();
            } else {
                i3 = -1;
            }
            String str = null;
            if (parseOIDBPkg == 0 && i3 == 0) {
                if (cmd0x9db_rspbody.rpt_uint64_uin.has()) {
                    List<Long> list = cmd0x9db_rspbody.rpt_uint64_uin.get();
                    if (list.size() > 0) {
                        j3 = list.get(0).longValue();
                        if (!cmd0x9db_rspbody.uint32_sequence.has()) {
                            i16 = cmd0x9db_rspbody.uint32_sequence.get();
                            z16 = true;
                        } else {
                            z16 = true;
                            i16 = 0;
                        }
                    }
                }
                j3 = 0;
                if (!cmd0x9db_rspbody.uint32_sequence.has()) {
                }
            } else {
                if (cmd0x9db_rspbody.str_errormessage.has()) {
                    str = cmd0x9db_rspbody.str_errormessage.get();
                }
                j3 = 0;
                i16 = 0;
                z16 = false;
            }
            int i17 = toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE);
            if (z16 && j3 > 0) {
                messageHandler.H2(Long.toString(j3));
                long j16 = toServiceMsg.extraData.getLong("insertTinnyid");
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "handleInsertBlackList success, tinnyid:" + j16);
                }
                messageHandler.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB, true, new Object[]{Integer.valueOf(i17), Long.valueOf(j16), Long.toString(j3), Integer.valueOf(i16)});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleInsertBlackList failed :" + str + " code:" + i3);
            }
            messageHandler.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB, false, new Object[]{Integer.valueOf(i17), Integer.valueOf(i3), str});
        }
    }
}

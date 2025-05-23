package com.tencent.mobileqq.app;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NumRedMsgHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f194887d;

    protected NumRedMsgHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194887d = qQAppInterface;
        }
    }

    protected void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        NumRedMsgManager numRedMsgManager = (NumRedMsgManager) this.f194887d.getManager(QQManagerFactory.NUMREDMSG_MANAGER);
        if (z16) {
            NumRedMsg.NumMsgRspBody numMsgRspBody = new NumRedMsg.NumMsgRspBody();
            try {
                numMsgRspBody.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("NumRedMsgHandler", 2, "mergeFrom failed");
                }
            }
            if (numMsgRspBody.i_retcode.get() == 0) {
                numRedMsgManager.e(numMsgRspBody, toServiceMsg, true);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NumRedMsgHandler", 2, "rsp code != 0 , error msg == " + numMsgRspBody.str_errmsg.get());
            }
            numRedMsgManager.e(numMsgRspBody, toServiceMsg, false);
            return;
        }
        numRedMsgManager.e(null, toServiceMsg, false);
    }

    public void E2(List<NumRedMsg.NumMsgBusi> list, int i3, String str, long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, Integer.valueOf(i3), str, jArr);
            return;
        }
        NumRedMsg.NumMsgReqBody numMsgReqBody = new NumRedMsg.NumMsgReqBody();
        numMsgReqBody.i_proto_ver.set(1);
        numMsgReqBody.ui_plat_id.set(109);
        numMsgReqBody.str_client_ver.set(AppSetting.f99554n);
        numMsgReqBody.ui64_uin.set(Long.parseLong(this.f194887d.getCurrentAccountUin()));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        numMsgReqBody.rpt_num_msg.set(arrayList);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194887d.getCurrentAccountUin(), "red_touch_num_svr.get_num_msg");
        toServiceMsg.putWupBuffer(numMsgReqBody.toByteArray());
        toServiceMsg.extraData.putInt("NumMsgListenerKey", i3);
        toServiceMsg.extraData.putLongArray("NumMsgIDList", jArr);
        toServiceMsg.extraData.putString("NumMsgListenerCmd", str);
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i("NumRedMsgHandler", 2, "sendPbReq called.");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("red_touch_num_svr.get_num_msg".equals(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.i("NumRedMsgHandler", 2, "onReceive called.");
            }
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}

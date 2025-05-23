package com.tencent.mobileqq.troop.trooptodo.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.trooptodo.g;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xf90.oidb_0xf90$ReqBody;
import tencent.im.oidb.cmd0xf90.oidb_0xf90$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopToDoHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    public TroopToDoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, int i3) {
        Integer num;
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopToDoHandler", 2, "handle 0xf90 Response | oidb_sso parseFrom byte " + e16.toString());
                }
            }
            int i16 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i16 == 0) {
                if (i3 == 1) {
                    if (J2(i3, oidb_sso_oidbssopkg)) {
                        return;
                    }
                } else {
                    notifyUI(i3, true, Integer.valueOf(i16));
                    return;
                }
            } else {
                notifyUI(i3, true, Integer.valueOf(i16));
                QLog.e("TroopToDoHandler", 1, "serviceType: " + i3 + ", oidb result: " + i16);
                return;
            }
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("serviceType: ");
            sb5.append(i3);
            sb5.append(", FromServiceMsg: ");
            if (fromServiceMsg != null) {
                num = Integer.valueOf(fromServiceMsg.getResultCode());
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(", data:");
            sb5.append(obj);
            QLog.e("TroopToDoHandler", 1, sb5.toString());
        }
        notifyUI(i3, false, null);
    }

    private boolean J2(int i3, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_0xf90$RspBody oidb_0xf90_rspbody = new oidb_0xf90$RspBody();
            try {
                oidb_0xf90_rspbody.mergeFrom(byteArray);
                notifyUI(i3, true, oidb_0xf90_rspbody.info.get());
                return true;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i("TroopToDoHandler", 4, "parseData : InvalidProtocolBufferMicroException :" + e16.toString());
                return false;
            }
        }
        return false;
    }

    private void L2(long j3, long j16, long j17, int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopToDoHandler", 2, "sendToDoStatusRequest \u2014\u2014 serviceType:" + i3 + ", requestCmd:" + str + ", groupCode:" + j3 + ", seq:" + j16 + ", random:" + j17);
        }
        oidb_0xf90$ReqBody oidb_0xf90_reqbody = new oidb_0xf90$ReqBody();
        oidb_0xf90_reqbody.group_code.set(j3);
        oidb_0xf90_reqbody.seq.set(j16);
        oidb_0xf90_reqbody.random.set(j17);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3984);
        oidb_sso_oidbssopkg.uint32_service_type.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xf90_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(str);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void F2(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            L2(j3, j16, j17, 1, "OidbSvcTrpcTcp.0xf90_1");
        }
    }

    public void G2(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            L2(j3, j16, j17, 4, "OidbSvcTrpcTcp.0xf90_4");
        }
    }

    public void H2(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            L2(j3, j16, j17, 2, "OidbSvcTrpcTcp.0xf90_2");
        }
    }

    public void K2(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            L2(j3, j16, j17, 3, "OidbSvcTrpcTcp.0xf90_3");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xf90_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_2");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_4");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_3");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "TroopToDoHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return g.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvcTrpcTcp.0xf90_1".equals(toServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj, 1);
            return;
        }
        if ("OidbSvcTrpcTcp.0xf90_2".equals(toServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj, 2);
        } else if ("OidbSvcTrpcTcp.0xf90_3".equals(toServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj, 3);
        } else if ("OidbSvcTrpcTcp.0xf90_4".equals(toServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj, 4);
        }
    }
}

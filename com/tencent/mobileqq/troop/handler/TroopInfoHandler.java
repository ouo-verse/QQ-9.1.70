package com.tencent.mobileqq.troop.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.troop.api.handler.c;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopInfoHandler extends TroopBaseHandler implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<Long, byte[]> f296238e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f296238e = new HashMap<>();
        }
    }

    public TroopInfoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopInfoHandler", 2, "handGetTroopAuth");
            }
            long j3 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TROOP_CODE);
            String string = toServiceMsg.extraData.getString("subCmd", "");
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (i3 != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopInfoHandler", 2, "0x580 cResult=" + i3);
                    }
                    notifyUI(e.TYPE_GET_TROOP_AUTH, false, new Object[]{Long.valueOf(j3), string});
                    return;
                }
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                    dataInputStream.readInt();
                    dataInputStream.readInt();
                    dataInputStream.readInt();
                    dataInputStream.readInt();
                    dataInputStream.skip(16L);
                    dataInputStream.readInt();
                    dataInputStream.readInt();
                    dataInputStream.skip(4L);
                    byte[] bArr2 = new byte[dataInputStream.readShort()];
                    dataInputStream.read(bArr2);
                    f296238e.put(Long.valueOf(j3), bArr2);
                    dataInputStream.close();
                    byteArrayInputStream.close();
                    notifyUI(e.TYPE_GET_TROOP_AUTH, true, new Object[]{Long.valueOf(j3), string, bArr2});
                    return;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopInfoHandler", 2, e17.getMessage());
                    }
                    notifyUI(e.TYPE_GET_TROOP_AUTH, false, new Object[]{Long.valueOf(j3), string});
                    return;
                }
            }
            notifyUI(e.TYPE_GET_TROOP_AUTH, false, new Object[]{Long.valueOf(j3), string});
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.c
    public byte[] I0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        HashMap<Long, byte[]> hashMap = f296238e;
        if (hashMap != null && hashMap.containsKey(Long.valueOf(j3))) {
            return f296238e.get(Long.valueOf(j3));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.handler.c
    public void P0(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoHandler", 2, "getTroopAuth0x580");
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x580_1");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt((int) j3);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            byteArrayOutputStream.close();
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1408);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(1);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(byteArray));
            toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopInfoHandler", 2, e16.getMessage());
            }
        }
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j3);
        toServiceMsg.extraData.putString("subCmd", str);
        toServiceMsg.extraData.putString("REQ_TAG", getTag());
        this.appRuntime.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x580_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopInfoHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopInfoHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopInfoHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x580_1".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.c
    public void t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        HashMap<Long, byte[]> hashMap = f296238e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

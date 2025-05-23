package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TroopFileHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f195133d;

    TroopFileHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f195133d = appInterface;
        }
    }

    public void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            if (!"GroupFileAppSvr.GetFileInfo".equals(fromServiceMsg.getServiceCmd())) {
                return;
            }
            notifyUI(39, true, obj);
        }
    }

    public void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            if (!"GroupFileAppSvr.GetFileSearch".equals(fromServiceMsg.getServiceCmd())) {
                return;
            }
            notifyUI(40, true, obj);
        }
    }

    public void F2(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        } else {
            notifyUI(9, true, obj);
        }
    }

    public void G2(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
        } else {
            notifyUI(20, true, obj);
        }
    }

    public void H2(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj);
        } else {
            notifyUI(41, true, obj);
        }
    }

    public void I2(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        } else {
            notifyUI(13, true, obj);
        }
    }

    public void J2(String str, byte[] bArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, bArr, bundle);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195133d.getCurrentAccountUin(), str);
        toServiceMsg.putWupBuffer(bArr);
        if (bundle != null) {
            toServiceMsg.extraData = bundle;
        }
        sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("GroupFileAppSvr.DelFile");
            this.allowCmdSet.add("GroupFileAppSvr.GetFileList");
            this.allowCmdSet.add("GroupFileAppSvr.GetFileListV2");
            this.allowCmdSet.add("GroupFileAppSvr.GetFileInfo");
            this.allowCmdSet.add("GroupFileAppSvr.GetFileSearch");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileHandler", 4, "onReceive");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileHandler", 4, "res.getServiceCmd():" + fromServiceMsg.getServiceCmd());
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopFileHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        D2(toServiceMsg, fromServiceMsg, obj);
        E2(toServiceMsg, fromServiceMsg, obj);
    }
}

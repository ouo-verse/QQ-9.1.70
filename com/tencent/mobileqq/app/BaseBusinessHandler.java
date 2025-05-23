package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class BaseBusinessHandler extends OidbWrapper {
    static IPatchRedirector $redirector_;
    public static final String SEQ_KEY;
    protected Set<String> allowCmdSet;
    protected AppInterface appRuntime;
    protected final Map<Long, BusinessObserver> bgObserverMap;
    protected long seq;
    protected final Map<Long, BusinessObserver> uiObserverMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            SEQ_KEY = BaseBusinessHandler.class.getName();
        }
    }

    public BaseBusinessHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uiObserverMap = new HashMap();
            this.bgObserverMap = new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.OidbWrapper
    public void addBusinessObserver(ToServiceMsg toServiceMsg, BusinessObserver businessObserver, boolean z16) {
        Map<Long, BusinessObserver> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, businessObserver, Boolean.valueOf(z16));
            return;
        }
        if (businessObserver != null) {
            if (z16) {
                map = this.bgObserverMap;
            } else {
                map = this.uiObserverMap;
            }
            synchronized (map) {
                map.put(Long.valueOf(this.seq), businessObserver);
                Bundle bundle = toServiceMsg.extraData;
                String str = SEQ_KEY;
                long j3 = this.seq;
                this.seq = 1 + j3;
                bundle.putLong(str, j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.OidbWrapper
    public ToServiceMsg createToServiceMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), str) : (ToServiceMsg) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
    }

    public final <T> T decodePacket(byte[] bArr, String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (T) iPatchRedirector.redirect((short) 11, this, bArr, str, t16);
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (Exception unused) {
            return null;
        }
    }

    protected abstract Set<String> getCommandList();

    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appRuntime.getAccount();
    }

    protected abstract Set<String> getPushCommandList();

    protected abstract Set<String> getPushPBCommandList();

    public final boolean isPbReq(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (toServiceMsg != null) {
            return ((Boolean) toServiceMsg.getAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean msgCmdFilter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (this.allowCmdSet == null) {
            this.allowCmdSet = getCommandList();
        }
        Set<String> set = this.allowCmdSet;
        if (set == null || set.contains(str)) {
            return false;
        }
        return true;
    }

    public abstract void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    public void send(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
        } else {
            this.appRuntime.sendToService(toServiceMsg);
        }
    }

    public void sendPbReq(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
        } else if (toServiceMsg != null) {
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            this.appRuntime.sendToService(toServiceMsg);
        }
    }

    public ToServiceMsg createToServiceMsg(String str, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? createToServiceMsg(str, businessObserver, false) : (ToServiceMsg) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) businessObserver);
    }

    public ToServiceMsg createToServiceMsg(String str, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 9, this, str, businessObserver, Boolean.valueOf(z16));
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(str);
        if (businessObserver != null) {
            Map<Long, BusinessObserver> map = z16 ? this.bgObserverMap : this.uiObserverMap;
            synchronized (map) {
                map.put(Long.valueOf(this.seq), businessObserver);
                Bundle bundle = createToServiceMsg.extraData;
                String str2 = SEQ_KEY;
                long j3 = this.seq;
                this.seq = 1 + j3;
                bundle.putLong(str2, j3);
            }
        }
        return createToServiceMsg;
    }
}

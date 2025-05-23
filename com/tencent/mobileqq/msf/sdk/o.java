package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static CommandCallbackerInfo a(ToServiceMsg toServiceMsg) {
        JceInputStream jceInputStream = new JceInputStream((byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_PUSH_CMDCALLBACKERINFO));
        CommandCallbackerInfo commandCallbackerInfo = new CommandCallbackerInfo();
        commandCallbackerInfo.readFrom(jceInputStream);
        return commandCallbackerInfo;
    }

    public static NotifyRegisterInfo b(ToServiceMsg toServiceMsg) {
        JceInputStream jceInputStream = new JceInputStream((byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_PUSH_NOTIFYREGISTERINFO));
        NotifyRegisterInfo notifyRegisterInfo = new NotifyRegisterInfo();
        notifyRegisterInfo.readFrom(jceInputStream);
        return notifyRegisterInfo;
    }

    public static n c(ToServiceMsg toServiceMsg) {
        JceInputStream jceInputStream = new JceInputStream((byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_PUSH_PROXYREGISTERINFO));
        n nVar = new n();
        nVar.readFrom(jceInputStream);
        return nVar;
    }

    public static PushRegisterInfo d(ToServiceMsg toServiceMsg) {
        JceInputStream jceInputStream = new JceInputStream((byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_PUSH_PUSHREGISTERINFO));
        PushRegisterInfo pushRegisterInfo = new PushRegisterInfo();
        pushRegisterInfo.readFrom(jceInputStream);
        return pushRegisterInfo;
    }

    public static void a(ToServiceMsg toServiceMsg, CommandCallbackerInfo commandCallbackerInfo) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        commandCallbackerInfo.writeTo(jceOutputStream);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_PUSH_CMDCALLBACKERINFO, jceOutputStream.toByteArray());
    }

    public static void a(ToServiceMsg toServiceMsg, PushRegisterInfo pushRegisterInfo) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        pushRegisterInfo.writeTo(jceOutputStream);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_PUSH_PUSHREGISTERINFO, jceOutputStream.toByteArray());
    }

    public static void a(ToServiceMsg toServiceMsg, NotifyRegisterInfo notifyRegisterInfo) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        notifyRegisterInfo.writeTo(jceOutputStream);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_PUSH_NOTIFYREGISTERINFO, jceOutputStream.toByteArray());
    }

    public static void a(ToServiceMsg toServiceMsg, n nVar) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        nVar.writeTo(jceOutputStream);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_PUSH_PROXYREGISTERINFO, jceOutputStream.toByteArray());
    }
}

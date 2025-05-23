package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.api.ProcessConstant;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class NodeModel$MsgLinkType {
    private static final /* synthetic */ NodeModel$MsgLinkType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NodeModel$MsgLinkType APNS;
    public static final NodeModel$MsgLinkType MSF;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NodeModel$MsgLinkType nodeModel$MsgLinkType = new NodeModel$MsgLinkType("APNS", 0);
        APNS = nodeModel$MsgLinkType;
        NodeModel$MsgLinkType nodeModel$MsgLinkType2 = new NodeModel$MsgLinkType(ProcessConstant.MSF, 1);
        MSF = nodeModel$MsgLinkType2;
        $VALUES = new NodeModel$MsgLinkType[]{nodeModel$MsgLinkType, nodeModel$MsgLinkType2};
    }

    NodeModel$MsgLinkType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NodeModel$MsgLinkType valueOf(String str) {
        return (NodeModel$MsgLinkType) Enum.valueOf(NodeModel$MsgLinkType.class, str);
    }

    public static NodeModel$MsgLinkType[] values() {
        return (NodeModel$MsgLinkType[]) $VALUES.clone();
    }
}

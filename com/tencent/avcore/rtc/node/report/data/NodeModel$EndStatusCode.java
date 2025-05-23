package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class NodeModel$EndStatusCode {
    private static final /* synthetic */ NodeModel$EndStatusCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NodeModel$EndStatusCode K_ABNORMAL;
    public static final NodeModel$EndStatusCode K_INVITE_TIME_OUT;
    public static final NodeModel$EndStatusCode K_NORMAL;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NodeModel$EndStatusCode nodeModel$EndStatusCode = new NodeModel$EndStatusCode("K_NORMAL", 0);
        K_NORMAL = nodeModel$EndStatusCode;
        NodeModel$EndStatusCode nodeModel$EndStatusCode2 = new NodeModel$EndStatusCode("K_ABNORMAL", 1);
        K_ABNORMAL = nodeModel$EndStatusCode2;
        NodeModel$EndStatusCode nodeModel$EndStatusCode3 = new NodeModel$EndStatusCode("K_INVITE_TIME_OUT", 2);
        K_INVITE_TIME_OUT = nodeModel$EndStatusCode3;
        $VALUES = new NodeModel$EndStatusCode[]{nodeModel$EndStatusCode, nodeModel$EndStatusCode2, nodeModel$EndStatusCode3};
    }

    NodeModel$EndStatusCode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NodeModel$EndStatusCode valueOf(String str) {
        return (NodeModel$EndStatusCode) Enum.valueOf(NodeModel$EndStatusCode.class, str);
    }

    public static NodeModel$EndStatusCode[] values() {
        return (NodeModel$EndStatusCode[]) $VALUES.clone();
    }
}

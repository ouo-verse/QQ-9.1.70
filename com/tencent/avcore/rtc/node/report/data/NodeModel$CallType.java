package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class NodeModel$CallType {
    private static final /* synthetic */ NodeModel$CallType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NodeModel$CallType K_DEFAULT;
    public static final NodeModel$CallType K_MULTI_PERSON;
    public static final NodeModel$CallType K_SINGLE_PERSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33378);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NodeModel$CallType nodeModel$CallType = new NodeModel$CallType("K_DEFAULT", 0);
        K_DEFAULT = nodeModel$CallType;
        NodeModel$CallType nodeModel$CallType2 = new NodeModel$CallType("K_SINGLE_PERSON", 1);
        K_SINGLE_PERSON = nodeModel$CallType2;
        NodeModel$CallType nodeModel$CallType3 = new NodeModel$CallType("K_MULTI_PERSON", 2);
        K_MULTI_PERSON = nodeModel$CallType3;
        $VALUES = new NodeModel$CallType[]{nodeModel$CallType, nodeModel$CallType2, nodeModel$CallType3};
    }

    NodeModel$CallType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NodeModel$CallType valueOf(String str) {
        return (NodeModel$CallType) Enum.valueOf(NodeModel$CallType.class, str);
    }

    public static NodeModel$CallType[] values() {
        return (NodeModel$CallType[]) $VALUES.clone();
    }
}

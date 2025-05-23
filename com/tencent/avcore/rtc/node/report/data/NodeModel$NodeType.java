package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class NodeModel$NodeType {
    private static final /* synthetic */ NodeModel$NodeType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NodeModel$NodeType MASTER_NODE;
    public static final NodeModel$NodeType SECONDARY_MODE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33422);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NodeModel$NodeType nodeModel$NodeType = new NodeModel$NodeType("MASTER_NODE", 0);
        MASTER_NODE = nodeModel$NodeType;
        NodeModel$NodeType nodeModel$NodeType2 = new NodeModel$NodeType("SECONDARY_MODE", 1);
        SECONDARY_MODE = nodeModel$NodeType2;
        $VALUES = new NodeModel$NodeType[]{nodeModel$NodeType, nodeModel$NodeType2};
    }

    NodeModel$NodeType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NodeModel$NodeType valueOf(String str) {
        return (NodeModel$NodeType) Enum.valueOf(NodeModel$NodeType.class, str);
    }

    public static NodeModel$NodeType[] values() {
        return (NodeModel$NodeType[]) $VALUES.clone();
    }
}

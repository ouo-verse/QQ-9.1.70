package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class NodeModel$NodeEndReason {
    private static final /* synthetic */ NodeModel$NodeEndReason[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NodeModel$NodeEndReason K_CRASH;
    public static final NodeModel$NodeEndReason K_DEAD_LOCK;
    public static final NodeModel$NodeEndReason K_INTERRUPTION;
    public static final NodeModel$NodeEndReason K_NORMAL;
    public static final NodeModel$NodeEndReason K_POST_NODE_REPORT;
    public static final NodeModel$NodeEndReason K_TIME_OUT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NodeModel$NodeEndReason nodeModel$NodeEndReason = new NodeModel$NodeEndReason("K_NORMAL", 0);
        K_NORMAL = nodeModel$NodeEndReason;
        NodeModel$NodeEndReason nodeModel$NodeEndReason2 = new NodeModel$NodeEndReason("K_TIME_OUT", 1);
        K_TIME_OUT = nodeModel$NodeEndReason2;
        NodeModel$NodeEndReason nodeModel$NodeEndReason3 = new NodeModel$NodeEndReason("K_INTERRUPTION", 2);
        K_INTERRUPTION = nodeModel$NodeEndReason3;
        NodeModel$NodeEndReason nodeModel$NodeEndReason4 = new NodeModel$NodeEndReason("K_POST_NODE_REPORT", 3);
        K_POST_NODE_REPORT = nodeModel$NodeEndReason4;
        NodeModel$NodeEndReason nodeModel$NodeEndReason5 = new NodeModel$NodeEndReason("K_CRASH", 4);
        K_CRASH = nodeModel$NodeEndReason5;
        NodeModel$NodeEndReason nodeModel$NodeEndReason6 = new NodeModel$NodeEndReason("K_DEAD_LOCK", 5);
        K_DEAD_LOCK = nodeModel$NodeEndReason6;
        $VALUES = new NodeModel$NodeEndReason[]{nodeModel$NodeEndReason, nodeModel$NodeEndReason2, nodeModel$NodeEndReason3, nodeModel$NodeEndReason4, nodeModel$NodeEndReason5, nodeModel$NodeEndReason6};
    }

    NodeModel$NodeEndReason(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NodeModel$NodeEndReason valueOf(String str) {
        return (NodeModel$NodeEndReason) Enum.valueOf(NodeModel$NodeEndReason.class, str);
    }

    public static NodeModel$NodeEndReason[] values() {
        return (NodeModel$NodeEndReason[]) $VALUES.clone();
    }
}

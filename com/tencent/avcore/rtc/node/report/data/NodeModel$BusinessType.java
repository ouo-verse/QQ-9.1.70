package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class NodeModel$BusinessType {
    private static final /* synthetic */ NodeModel$BusinessType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NodeModel$BusinessType K_AUDIO;
    public static final NodeModel$BusinessType K_VIDEO;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33372);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NodeModel$BusinessType nodeModel$BusinessType = new NodeModel$BusinessType("K_AUDIO", 0);
        K_AUDIO = nodeModel$BusinessType;
        NodeModel$BusinessType nodeModel$BusinessType2 = new NodeModel$BusinessType("K_VIDEO", 1);
        K_VIDEO = nodeModel$BusinessType2;
        $VALUES = new NodeModel$BusinessType[]{nodeModel$BusinessType, nodeModel$BusinessType2};
    }

    NodeModel$BusinessType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NodeModel$BusinessType valueOf(String str) {
        return (NodeModel$BusinessType) Enum.valueOf(NodeModel$BusinessType.class, str);
    }

    public static NodeModel$BusinessType[] values() {
        return (NodeModel$BusinessType[]) $VALUES.clone();
    }
}

package com.tencent.mobileqq.dpc.enumname;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class DPCAccountNames {
    private static final /* synthetic */ DPCAccountNames[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DPCAccountNames msg_revoke_switch;
    public static final DPCAccountNames picpredownload_whitelist;
    public static final DPCAccountNames picpresend_whitelist;
    public static final DPCAccountNames qq_audio_play_fix;
    public static final DPCAccountNames shortvideo_forward_switch;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DPCAccountNames dPCAccountNames = new DPCAccountNames("picpredownload_whitelist", 0);
        picpredownload_whitelist = dPCAccountNames;
        DPCAccountNames dPCAccountNames2 = new DPCAccountNames("qq_audio_play_fix", 1);
        qq_audio_play_fix = dPCAccountNames2;
        DPCAccountNames dPCAccountNames3 = new DPCAccountNames("picpresend_whitelist", 2);
        picpresend_whitelist = dPCAccountNames3;
        DPCAccountNames dPCAccountNames4 = new DPCAccountNames("shortvideo_forward_switch", 3);
        shortvideo_forward_switch = dPCAccountNames4;
        DPCAccountNames dPCAccountNames5 = new DPCAccountNames("msg_revoke_switch", 4);
        msg_revoke_switch = dPCAccountNames5;
        $VALUES = new DPCAccountNames[]{dPCAccountNames, dPCAccountNames2, dPCAccountNames3, dPCAccountNames4, dPCAccountNames5};
    }

    DPCAccountNames(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DPCAccountNames valueOf(String str) {
        return (DPCAccountNames) Enum.valueOf(DPCAccountNames.class, str);
    }

    public static DPCAccountNames[] values() {
        return (DPCAccountNames[]) $VALUES.clone();
    }
}

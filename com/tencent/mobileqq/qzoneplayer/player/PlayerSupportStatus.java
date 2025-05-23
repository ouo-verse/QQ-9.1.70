package com.tencent.mobileqq.qzoneplayer.player;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes16.dex */
public final class PlayerSupportStatus {
    private static final /* synthetic */ PlayerSupportStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PlayerSupportStatus NOTSURE;
    public static final PlayerSupportStatus SUPPORTED;
    public static final PlayerSupportStatus UNSUPPORT_CLASS_NOTFOUND;
    public static final PlayerSupportStatus UNSUPPORT_DECODER;
    public static final PlayerSupportStatus UNSUPPORT_DISABLED;
    public static final PlayerSupportStatus UNSUPPORT_HARDWARE_MODE;
    public static final PlayerSupportStatus UNSUPPORT_SDK_VERSION;
    public static final PlayerSupportStatus UNSUPPORT_STREAM;
    public static final PlayerSupportStatus UNSUPPORT_UNKNOWN;
    private String mReason;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12001);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        PlayerSupportStatus playerSupportStatus = new PlayerSupportStatus("SUPPORTED", 0);
        SUPPORTED = playerSupportStatus;
        PlayerSupportStatus playerSupportStatus2 = new PlayerSupportStatus("UNSUPPORT_CLASS_NOTFOUND", 1, "class not found");
        UNSUPPORT_CLASS_NOTFOUND = playerSupportStatus2;
        PlayerSupportStatus playerSupportStatus3 = new PlayerSupportStatus("UNSUPPORT_SDK_VERSION", 2, "sdk version limit");
        UNSUPPORT_SDK_VERSION = playerSupportStatus3;
        PlayerSupportStatus playerSupportStatus4 = new PlayerSupportStatus("UNSUPPORT_HARDWARE_MODE", 3, "hardware model limit");
        UNSUPPORT_HARDWARE_MODE = playerSupportStatus4;
        PlayerSupportStatus playerSupportStatus5 = new PlayerSupportStatus("UNSUPPORT_STREAM", 4, "stream not support");
        UNSUPPORT_STREAM = playerSupportStatus5;
        PlayerSupportStatus playerSupportStatus6 = new PlayerSupportStatus("UNSUPPORT_DECODER", 5, "decoder not support");
        UNSUPPORT_DECODER = playerSupportStatus6;
        PlayerSupportStatus playerSupportStatus7 = new PlayerSupportStatus("UNSUPPORT_UNKNOWN", 6, "unknown reason");
        UNSUPPORT_UNKNOWN = playerSupportStatus7;
        PlayerSupportStatus playerSupportStatus8 = new PlayerSupportStatus("UNSUPPORT_DISABLED", 7, "temporary disabled");
        UNSUPPORT_DISABLED = playerSupportStatus8;
        PlayerSupportStatus playerSupportStatus9 = new PlayerSupportStatus("NOTSURE", 8, "not sure");
        NOTSURE = playerSupportStatus9;
        $VALUES = new PlayerSupportStatus[]{playerSupportStatus, playerSupportStatus2, playerSupportStatus3, playerSupportStatus4, playerSupportStatus5, playerSupportStatus6, playerSupportStatus7, playerSupportStatus8, playerSupportStatus9};
    }

    PlayerSupportStatus(String str, int i3) {
        this(str, i3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
    }

    public static PlayerSupportStatus valueOf(String str) {
        return (PlayerSupportStatus) Enum.valueOf(PlayerSupportStatus.class, str);
    }

    public static PlayerSupportStatus[] values() {
        return (PlayerSupportStatus[]) $VALUES.clone();
    }

    public String getReason() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mReason;
    }

    PlayerSupportStatus(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            return;
        }
        this.mReason = "";
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mReason = str2;
    }
}

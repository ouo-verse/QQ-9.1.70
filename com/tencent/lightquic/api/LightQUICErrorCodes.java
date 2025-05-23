package com.tencent.lightquic.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICErrorCodes;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "QUIC_NO_ERROR", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICErrorCodes {
    private static final /* synthetic */ LightQUICErrorCodes[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LightQUICErrorCodes QUIC_NO_ERROR;
    private final int value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        LightQUICErrorCodes lightQUICErrorCodes = new LightQUICErrorCodes("QUIC_NO_ERROR", 0, 0);
        QUIC_NO_ERROR = lightQUICErrorCodes;
        $VALUES = new LightQUICErrorCodes[]{lightQUICErrorCodes};
    }

    LightQUICErrorCodes(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static LightQUICErrorCodes valueOf(String str) {
        return (LightQUICErrorCodes) Enum.valueOf(LightQUICErrorCodes.class, str);
    }

    public static LightQUICErrorCodes[] values() {
        return (LightQUICErrorCodes[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}

package com.tencent.mobileqq.tianjige.ntkernel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "GRAY_FULL", "GRAY_MANAGE", "GRAY_NONE", "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
final class GraySampleRate {
    private static final /* synthetic */ GraySampleRate[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final GraySampleRate GRAY_FULL;
    public static final GraySampleRate GRAY_MANAGE;
    public static final GraySampleRate GRAY_NONE;
    private final int value;

    private static final /* synthetic */ GraySampleRate[] $values() {
        return new GraySampleRate[]{GRAY_FULL, GRAY_MANAGE, GRAY_NONE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34566);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        GRAY_FULL = new GraySampleRate("GRAY_FULL", 0, 0);
        GRAY_MANAGE = new GraySampleRate("GRAY_MANAGE", 1, 1);
        GRAY_NONE = new GraySampleRate("GRAY_NONE", 2, 2);
        $VALUES = $values();
    }

    GraySampleRate(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static GraySampleRate valueOf(String str) {
        return (GraySampleRate) Enum.valueOf(GraySampleRate.class, str);
    }

    public static GraySampleRate[] values() {
        return (GraySampleRate[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}

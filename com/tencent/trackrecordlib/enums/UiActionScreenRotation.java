package com.tencent.trackrecordlib.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class UiActionScreenRotation {
    static IPatchRedirector $redirector_;
    public static final UiActionScreenRotation LEFT;
    public static final UiActionScreenRotation NATURAL;
    public static final UiActionScreenRotation RIGHT;
    public static final UiActionScreenRotation ROLLBACK;

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ UiActionScreenRotation[] f381119a;
    private int seq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        UiActionScreenRotation uiActionScreenRotation = new UiActionScreenRotation("NATURAL", 0, 1);
        NATURAL = uiActionScreenRotation;
        UiActionScreenRotation uiActionScreenRotation2 = new UiActionScreenRotation("LEFT", 1, 2);
        LEFT = uiActionScreenRotation2;
        UiActionScreenRotation uiActionScreenRotation3 = new UiActionScreenRotation("RIGHT", 2, 3);
        RIGHT = uiActionScreenRotation3;
        UiActionScreenRotation uiActionScreenRotation4 = new UiActionScreenRotation("ROLLBACK", 3, 4);
        ROLLBACK = uiActionScreenRotation4;
        f381119a = new UiActionScreenRotation[]{uiActionScreenRotation, uiActionScreenRotation2, uiActionScreenRotation3, uiActionScreenRotation4};
    }

    UiActionScreenRotation(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.seq = i16;
        }
    }

    public static UiActionScreenRotation valueOf(String str) {
        return (UiActionScreenRotation) Enum.valueOf(UiActionScreenRotation.class, str);
    }

    public static UiActionScreenRotation[] values() {
        return (UiActionScreenRotation[]) f381119a.clone();
    }

    public int getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.seq;
    }

    public void setSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.seq = i3;
        }
    }
}

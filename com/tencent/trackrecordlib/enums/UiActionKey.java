package com.tencent.trackrecordlib.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class UiActionKey {
    static IPatchRedirector $redirector_;
    public static final UiActionKey BACK;
    public static final UiActionKey HOME;
    public static final UiActionKey LOCK;
    public static final UiActionKey VOLUME_PLUS;
    public static final UiActionKey VOLUME_SUB;

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ UiActionKey[] f381118a;
    private int seq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        UiActionKey uiActionKey = new UiActionKey("HOME", 0, 1000);
        HOME = uiActionKey;
        UiActionKey uiActionKey2 = new UiActionKey("LOCK", 1, 1001);
        LOCK = uiActionKey2;
        UiActionKey uiActionKey3 = new UiActionKey("VOLUME_PLUS", 2, 1002);
        VOLUME_PLUS = uiActionKey3;
        UiActionKey uiActionKey4 = new UiActionKey("VOLUME_SUB", 3, 1003);
        VOLUME_SUB = uiActionKey4;
        UiActionKey uiActionKey5 = new UiActionKey("BACK", 4, 1004);
        BACK = uiActionKey5;
        f381118a = new UiActionKey[]{uiActionKey, uiActionKey2, uiActionKey3, uiActionKey4, uiActionKey5};
    }

    UiActionKey(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.seq = i16;
        }
    }

    public static UiActionKey valueOf(String str) {
        return (UiActionKey) Enum.valueOf(UiActionKey.class, str);
    }

    public static UiActionKey[] values() {
        return (UiActionKey[]) f381118a.clone();
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

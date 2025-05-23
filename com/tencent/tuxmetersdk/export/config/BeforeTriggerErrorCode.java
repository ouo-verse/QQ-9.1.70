package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class BeforeTriggerErrorCode {
    private static final /* synthetic */ BeforeTriggerErrorCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final BeforeTriggerErrorCode FAIL;
    public static final BeforeTriggerErrorCode SUCCESS;
    private int code;

    /* renamed from: msg, reason: collision with root package name */
    private String f383466msg;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        BeforeTriggerErrorCode beforeTriggerErrorCode = new BeforeTriggerErrorCode("SUCCESS", 0, 0, "\u6210\u529f");
        SUCCESS = beforeTriggerErrorCode;
        BeforeTriggerErrorCode beforeTriggerErrorCode2 = new BeforeTriggerErrorCode(Tracker.FAIL, 1, -999, "\u5931\u8d25");
        FAIL = beforeTriggerErrorCode2;
        $VALUES = new BeforeTriggerErrorCode[]{beforeTriggerErrorCode, beforeTriggerErrorCode2};
    }

    BeforeTriggerErrorCode(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else {
            this.code = i16;
            this.f383466msg = str2;
        }
    }

    public static BeforeTriggerErrorCode valueOf(String str) {
        return (BeforeTriggerErrorCode) Enum.valueOf(BeforeTriggerErrorCode.class, str);
    }

    public static BeforeTriggerErrorCode[] values() {
        return (BeforeTriggerErrorCode[]) $VALUES.clone();
    }

    public int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.code;
    }

    public String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f383466msg;
    }
}

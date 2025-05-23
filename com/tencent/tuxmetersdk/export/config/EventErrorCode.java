package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class EventErrorCode {
    private static final /* synthetic */ EventErrorCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final EventErrorCode EVENT_EXCEPTION;
    public static final EventErrorCode EVENT_EXPOSED;
    public static final EventErrorCode EVENT_FAIL;
    public static final EventErrorCode EVENT_GET_SURVEY_ERROR;
    public static final EventErrorCode EVENT_IN_SILENT;
    public static final EventErrorCode EVENT_NOT_CONTAIN;
    public static final EventErrorCode EVENT_SATISFIED_FAILED;
    public static final EventErrorCode EVENT_WAIT_FOR_RSP;
    private int code;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        EventErrorCode eventErrorCode = new EventErrorCode("EVENT_EXCEPTION", 0, -1);
        EVENT_EXCEPTION = eventErrorCode;
        EventErrorCode eventErrorCode2 = new EventErrorCode("EVENT_EXPOSED", 1, -2);
        EVENT_EXPOSED = eventErrorCode2;
        EventErrorCode eventErrorCode3 = new EventErrorCode("EVENT_WAIT_FOR_RSP", 2, -3);
        EVENT_WAIT_FOR_RSP = eventErrorCode3;
        EventErrorCode eventErrorCode4 = new EventErrorCode("EVENT_GET_SURVEY_ERROR", 3, -4);
        EVENT_GET_SURVEY_ERROR = eventErrorCode4;
        EventErrorCode eventErrorCode5 = new EventErrorCode("EVENT_SATISFIED_FAILED", 4, -5);
        EVENT_SATISFIED_FAILED = eventErrorCode5;
        EventErrorCode eventErrorCode6 = new EventErrorCode("EVENT_IN_SILENT", 5, -6);
        EVENT_IN_SILENT = eventErrorCode6;
        EventErrorCode eventErrorCode7 = new EventErrorCode("EVENT_NOT_CONTAIN", 6, -7);
        EVENT_NOT_CONTAIN = eventErrorCode7;
        EventErrorCode eventErrorCode8 = new EventErrorCode("EVENT_FAIL", 7, -999);
        EVENT_FAIL = eventErrorCode8;
        $VALUES = new EventErrorCode[]{eventErrorCode, eventErrorCode2, eventErrorCode3, eventErrorCode4, eventErrorCode5, eventErrorCode6, eventErrorCode7, eventErrorCode8};
    }

    EventErrorCode(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.code = i16;
        }
    }

    public static EventErrorCode valueOf(String str) {
        return (EventErrorCode) Enum.valueOf(EventErrorCode.class, str);
    }

    public static EventErrorCode[] values() {
        return (EventErrorCode[]) $VALUES.clone();
    }

    public int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.code;
    }
}

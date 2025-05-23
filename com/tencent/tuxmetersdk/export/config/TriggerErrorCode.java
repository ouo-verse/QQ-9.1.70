package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class TriggerErrorCode {
    private static final /* synthetic */ TriggerErrorCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TriggerErrorCode FAIL;
    public static final TriggerErrorCode FREQUENCY_CONTROL;
    public static final TriggerErrorCode PRIORITY;
    public static final TriggerErrorCode SCENE_DESTROY;
    public static final TriggerErrorCode SCENE_ID_NOT_MATCH;
    public static final TriggerErrorCode SCENE_LOCATION_INVALID;
    public static final TriggerErrorCode SLIDE;
    public static final TriggerErrorCode SUCCESS;
    public static final TriggerErrorCode SURVEY_INVALID;
    private int code;

    /* renamed from: msg, reason: collision with root package name */
    private String f383468msg;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        TriggerErrorCode triggerErrorCode = new TriggerErrorCode("SUCCESS", 0, 0, "\u6210\u529f");
        SUCCESS = triggerErrorCode;
        TriggerErrorCode triggerErrorCode2 = new TriggerErrorCode("SCENE_ID_NOT_MATCH", 1, -1, "\u573a\u666fid\u4e0d\u5339\u914d");
        SCENE_ID_NOT_MATCH = triggerErrorCode2;
        TriggerErrorCode triggerErrorCode3 = new TriggerErrorCode("PRIORITY", 2, -2, "\u56e0\u4f18\u5148\u7ea7\u5bfc\u81f4\u95ee\u5377\u6ca1\u6709\u5f39\u51fa");
        PRIORITY = triggerErrorCode3;
        TriggerErrorCode triggerErrorCode4 = new TriggerErrorCode("SLIDE", 3, -3, "\u7528\u6237\u5728\u6ed1\u52a8\u8fc7\u7a0b\u4e2d\uff0c\u4e0d\u5c55\u793a\u95ee\u5377\u5f39\u7a97");
        SLIDE = triggerErrorCode4;
        TriggerErrorCode triggerErrorCode5 = new TriggerErrorCode("SURVEY_INVALID", 4, -4, "\u95ee\u5377\u5185\u5bb9\u6821\u9a8c\u5931\u8d25");
        SURVEY_INVALID = triggerErrorCode5;
        TriggerErrorCode triggerErrorCode6 = new TriggerErrorCode("SCENE_DESTROY", 5, -5, "\u573a\u666f\u9500\u6bc1");
        SCENE_DESTROY = triggerErrorCode6;
        TriggerErrorCode triggerErrorCode7 = new TriggerErrorCode("SCENE_LOCATION_INVALID", 6, -6, "\u573a\u666f\u4f4d\u7f6e\u53c2\u6570\u6821\u9a8c\u5931\u8d25");
        SCENE_LOCATION_INVALID = triggerErrorCode7;
        TriggerErrorCode triggerErrorCode8 = new TriggerErrorCode("FREQUENCY_CONTROL", 7, -7, "\u56e0\u9891\u63a7\u5bfc\u81f4\u6ca1\u6709\u95ee\u5377\u5f39\u51fa");
        FREQUENCY_CONTROL = triggerErrorCode8;
        TriggerErrorCode triggerErrorCode9 = new TriggerErrorCode(Tracker.FAIL, 8, -999, "\u5931\u8d25");
        FAIL = triggerErrorCode9;
        $VALUES = new TriggerErrorCode[]{triggerErrorCode, triggerErrorCode2, triggerErrorCode3, triggerErrorCode4, triggerErrorCode5, triggerErrorCode6, triggerErrorCode7, triggerErrorCode8, triggerErrorCode9};
    }

    TriggerErrorCode(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else {
            this.code = i16;
            this.f383468msg = str2;
        }
    }

    public static TriggerErrorCode valueOf(String str) {
        return (TriggerErrorCode) Enum.valueOf(TriggerErrorCode.class, str);
    }

    public static TriggerErrorCode[] values() {
        return (TriggerErrorCode[]) $VALUES.clone();
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
        return this.f383468msg;
    }
}

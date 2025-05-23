package com.tencent.tuxmetersdk.impl.ruleengine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class JsonRuleType {
    private static final /* synthetic */ JsonRuleType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final JsonRuleType EVENT;
    public static final JsonRuleType TIMER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        JsonRuleType jsonRuleType = new JsonRuleType("EVENT", 0);
        EVENT = jsonRuleType;
        JsonRuleType jsonRuleType2 = new JsonRuleType("TIMER", 1);
        TIMER = jsonRuleType2;
        $VALUES = new JsonRuleType[]{jsonRuleType, jsonRuleType2};
    }

    JsonRuleType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static JsonRuleType valueOf(String str) {
        return (JsonRuleType) Enum.valueOf(JsonRuleType.class, str);
    }

    public static JsonRuleType[] values() {
        return (JsonRuleType[]) $VALUES.clone();
    }
}

package com.tencent.halley.common;

import com.tencent.halley.NotProguard;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@NotProguard
/* loaded from: classes6.dex */
public final class ParseDnsServerType {
    private static final /* synthetic */ ParseDnsServerType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ParseDnsServerType HALLEY;
    public static final ParseDnsServerType HTTP_DNS;
    public static final ParseDnsServerType LOCAL_DNS;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13200);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ParseDnsServerType parseDnsServerType = new ParseDnsServerType("HTTP_DNS", 0);
        HTTP_DNS = parseDnsServerType;
        ParseDnsServerType parseDnsServerType2 = new ParseDnsServerType("HALLEY", 1);
        HALLEY = parseDnsServerType2;
        ParseDnsServerType parseDnsServerType3 = new ParseDnsServerType("LOCAL_DNS", 2);
        LOCAL_DNS = parseDnsServerType3;
        $VALUES = new ParseDnsServerType[]{parseDnsServerType, parseDnsServerType2, parseDnsServerType3};
    }

    ParseDnsServerType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ParseDnsServerType valueOf(String str) {
        return (ParseDnsServerType) Enum.valueOf(ParseDnsServerType.class, str);
    }

    public static ParseDnsServerType[] values() {
        return (ParseDnsServerType[]) $VALUES.clone();
    }
}

package com.tencent.mobileqq.qne.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qne/api/SRLevel;", "", "(Ljava/lang/String;I)V", "HIGH", "MEDIUM", "LOW", "qne-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class SRLevel {
    private static final /* synthetic */ SRLevel[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SRLevel HIGH;
    public static final SRLevel LOW;
    public static final SRLevel MEDIUM;

    private static final /* synthetic */ SRLevel[] $values() {
        return new SRLevel[]{HIGH, MEDIUM, LOW};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HIGH = new SRLevel("HIGH", 0);
        MEDIUM = new SRLevel("MEDIUM", 1);
        LOW = new SRLevel("LOW", 2);
        $VALUES = $values();
    }

    SRLevel(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static SRLevel valueOf(String str) {
        return (SRLevel) Enum.valueOf(SRLevel.class, str);
    }

    public static SRLevel[] values() {
        return (SRLevel[]) $VALUES.clone();
    }
}

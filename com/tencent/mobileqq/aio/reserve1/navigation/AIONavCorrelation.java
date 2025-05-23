package com.tencent.mobileqq.aio.reserve1.navigation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavCorrelation;", "", "(Ljava/lang/String;I)V", "STRONG", "WEAK", "UNKNOWN", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIONavCorrelation {
    private static final /* synthetic */ AIONavCorrelation[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AIONavCorrelation STRONG;
    public static final AIONavCorrelation UNKNOWN;
    public static final AIONavCorrelation WEAK;

    private static final /* synthetic */ AIONavCorrelation[] $values() {
        return new AIONavCorrelation[]{STRONG, WEAK, UNKNOWN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        STRONG = new AIONavCorrelation("STRONG", 0);
        WEAK = new AIONavCorrelation("WEAK", 1);
        UNKNOWN = new AIONavCorrelation("UNKNOWN", 2);
        $VALUES = $values();
    }

    AIONavCorrelation(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AIONavCorrelation valueOf(String str) {
        return (AIONavCorrelation) Enum.valueOf(AIONavCorrelation.class, str);
    }

    public static AIONavCorrelation[] values() {
        return (AIONavCorrelation[]) $VALUES.clone();
    }
}

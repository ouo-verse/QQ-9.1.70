package com.tencent.mobileqq.qqlive.api.config.qmanage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/config/qmanage/GreyHitStatus;", "", "(Ljava/lang/String;I)V", "HIT", "NOT_HIT", "UNKNOWN", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class GreyHitStatus {
    private static final /* synthetic */ GreyHitStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final GreyHitStatus HIT;
    public static final GreyHitStatus NOT_HIT;
    public static final GreyHitStatus UNKNOWN;

    private static final /* synthetic */ GreyHitStatus[] $values() {
        return new GreyHitStatus[]{HIT, NOT_HIT, UNKNOWN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HIT = new GreyHitStatus("HIT", 0);
        NOT_HIT = new GreyHitStatus("NOT_HIT", 1);
        UNKNOWN = new GreyHitStatus("UNKNOWN", 2);
        $VALUES = $values();
    }

    GreyHitStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static GreyHitStatus valueOf(String str) {
        return (GreyHitStatus) Enum.valueOf(GreyHitStatus.class, str);
    }

    public static GreyHitStatus[] values() {
        return (GreyHitStatus[]) $VALUES.clone();
    }
}

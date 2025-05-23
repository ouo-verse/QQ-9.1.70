package com.tencent.mobileqq.flock.share;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/share/RequestState;", "", "(Ljava/lang/String;I)V", "NONE", "REQUESTING", "SUCCEED", "FAILED", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class RequestState {
    private static final /* synthetic */ RequestState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RequestState FAILED;
    public static final RequestState NONE;
    public static final RequestState REQUESTING;
    public static final RequestState SUCCEED;

    private static final /* synthetic */ RequestState[] $values() {
        return new RequestState[]{NONE, REQUESTING, SUCCEED, FAILED};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NONE = new RequestState("NONE", 0);
        REQUESTING = new RequestState("REQUESTING", 1);
        SUCCEED = new RequestState("SUCCEED", 2);
        FAILED = new RequestState("FAILED", 3);
        $VALUES = $values();
    }

    RequestState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RequestState valueOf(String str) {
        return (RequestState) Enum.valueOf(RequestState.class, str);
    }

    public static RequestState[] values() {
        return (RequestState[]) $VALUES.clone();
    }
}

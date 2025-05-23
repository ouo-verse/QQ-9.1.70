package com.tencent.mobileqq.aio.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/RefreshType;", "", "(Ljava/lang/String;I)V", "REFRESH_WITH_UIN", "REFRESH_WITH_UID", "REFRESH_WITH_MSGID", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class RefreshType {
    private static final /* synthetic */ RefreshType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RefreshType REFRESH_WITH_MSGID;
    public static final RefreshType REFRESH_WITH_UID;
    public static final RefreshType REFRESH_WITH_UIN;

    private static final /* synthetic */ RefreshType[] $values() {
        return new RefreshType[]{REFRESH_WITH_UIN, REFRESH_WITH_UID, REFRESH_WITH_MSGID};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        REFRESH_WITH_UIN = new RefreshType("REFRESH_WITH_UIN", 0);
        REFRESH_WITH_UID = new RefreshType("REFRESH_WITH_UID", 1);
        REFRESH_WITH_MSGID = new RefreshType("REFRESH_WITH_MSGID", 2);
        $VALUES = $values();
    }

    RefreshType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RefreshType valueOf(String str) {
        return (RefreshType) Enum.valueOf(RefreshType.class, str);
    }

    public static RefreshType[] values() {
        return (RefreshType[]) $VALUES.clone();
    }
}

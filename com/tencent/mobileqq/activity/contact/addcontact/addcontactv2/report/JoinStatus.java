package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/JoinStatus;", "", "(Ljava/lang/String;I)V", "JOINED", "JOINING", "NOT_JOIN", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class JoinStatus {
    private static final /* synthetic */ JoinStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final JoinStatus JOINED;
    public static final JoinStatus JOINING;
    public static final JoinStatus NOT_JOIN;

    private static final /* synthetic */ JoinStatus[] $values() {
        return new JoinStatus[]{JOINED, JOINING, NOT_JOIN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        JOINED = new JoinStatus("JOINED", 0);
        JOINING = new JoinStatus("JOINING", 1);
        NOT_JOIN = new JoinStatus("NOT_JOIN", 2);
        $VALUES = $values();
    }

    JoinStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static JoinStatus valueOf(String str) {
        return (JoinStatus) Enum.valueOf(JoinStatus.class, str);
    }

    public static JoinStatus[] values() {
        return (JoinStatus[]) $VALUES.clone();
    }
}

package com.tencent.mobileqq.troop.homework.notice.remind.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/data/RemindStatus;", "", "(Ljava/lang/String;I)V", "STATUS_HAD_REMINDED", "STATUS_UNCHECKED", "STATUS_CHECKED", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class RemindStatus {
    private static final /* synthetic */ RemindStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RemindStatus STATUS_CHECKED;
    public static final RemindStatus STATUS_HAD_REMINDED;
    public static final RemindStatus STATUS_UNCHECKED;

    private static final /* synthetic */ RemindStatus[] $values() {
        return new RemindStatus[]{STATUS_HAD_REMINDED, STATUS_UNCHECKED, STATUS_CHECKED};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        STATUS_HAD_REMINDED = new RemindStatus("STATUS_HAD_REMINDED", 0);
        STATUS_UNCHECKED = new RemindStatus("STATUS_UNCHECKED", 1);
        STATUS_CHECKED = new RemindStatus("STATUS_CHECKED", 2);
        $VALUES = $values();
    }

    RemindStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RemindStatus valueOf(String str) {
        return (RemindStatus) Enum.valueOf(RemindStatus.class, str);
    }

    public static RemindStatus[] values() {
        return (RemindStatus[]) $VALUES.clone();
    }
}

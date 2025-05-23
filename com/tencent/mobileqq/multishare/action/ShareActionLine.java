package com.tencent.mobileqq.multishare.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multishare/action/ShareActionLine;", "", "(Ljava/lang/String;I)V", "NONE", "FIRST", "SECOND", "THIRD", "qqmultishare-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ShareActionLine {
    private static final /* synthetic */ ShareActionLine[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ShareActionLine FIRST;
    public static final ShareActionLine NONE;
    public static final ShareActionLine SECOND;
    public static final ShareActionLine THIRD;

    private static final /* synthetic */ ShareActionLine[] $values() {
        return new ShareActionLine[]{NONE, FIRST, SECOND, THIRD};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NONE = new ShareActionLine("NONE", 0);
        FIRST = new ShareActionLine("FIRST", 1);
        SECOND = new ShareActionLine("SECOND", 2);
        THIRD = new ShareActionLine("THIRD", 3);
        $VALUES = $values();
    }

    ShareActionLine(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ShareActionLine valueOf(String str) {
        return (ShareActionLine) Enum.valueOf(ShareActionLine.class, str);
    }

    public static ShareActionLine[] values() {
        return (ShareActionLine[]) $VALUES.clone();
    }
}

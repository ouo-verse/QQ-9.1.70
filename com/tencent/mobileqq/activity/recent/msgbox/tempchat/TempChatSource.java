package com.tencent.mobileqq.activity.recent.msgbox.tempchat;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes10.dex */
public final class TempChatSource {
    private static final /* synthetic */ TempChatSource[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TempChatSource SOURCE_FROM_AIO;
    public static final TempChatSource SOURCE_FROM_MAG_TAB;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33985);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TempChatSource tempChatSource = new TempChatSource("SOURCE_FROM_MAG_TAB", 0);
        SOURCE_FROM_MAG_TAB = tempChatSource;
        TempChatSource tempChatSource2 = new TempChatSource("SOURCE_FROM_AIO", 1);
        SOURCE_FROM_AIO = tempChatSource2;
        $VALUES = new TempChatSource[]{tempChatSource, tempChatSource2};
    }

    TempChatSource(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TempChatSource valueOf(String str) {
        return (TempChatSource) Enum.valueOf(TempChatSource.class, str);
    }

    public static TempChatSource[] values() {
        return (TempChatSource[]) $VALUES.clone();
    }
}

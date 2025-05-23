package com.tencent.cache.core.manager.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/cache/core/manager/api/ClearMode;", "", "(Ljava/lang/String;I)V", "LowMemory", "Background", "PageChanged", "UserEvictAction", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class ClearMode {
    private static final /* synthetic */ ClearMode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ClearMode Background;
    public static final ClearMode LowMemory;
    public static final ClearMode PageChanged;
    public static final ClearMode UserEvictAction;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ClearMode clearMode = new ClearMode("LowMemory", 0);
        LowMemory = clearMode;
        ClearMode clearMode2 = new ClearMode("Background", 1);
        Background = clearMode2;
        ClearMode clearMode3 = new ClearMode("PageChanged", 2);
        PageChanged = clearMode3;
        ClearMode clearMode4 = new ClearMode("UserEvictAction", 3);
        UserEvictAction = clearMode4;
        $VALUES = new ClearMode[]{clearMode, clearMode2, clearMode3, clearMode4};
    }

    ClearMode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static ClearMode valueOf(String str) {
        return (ClearMode) Enum.valueOf(ClearMode.class, str);
    }

    public static ClearMode[] values() {
        return (ClearMode[]) $VALUES.clone();
    }
}

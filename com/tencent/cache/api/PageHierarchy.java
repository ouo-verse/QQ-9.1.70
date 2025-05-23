package com.tencent.cache.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/cache/api/PageHierarchy;", "", "(Ljava/lang/String;I)V", "MainPage", "NonMainPage", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class PageHierarchy {
    private static final /* synthetic */ PageHierarchy[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PageHierarchy MainPage;
    public static final PageHierarchy NonMainPage;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        PageHierarchy pageHierarchy = new PageHierarchy("MainPage", 0);
        MainPage = pageHierarchy;
        PageHierarchy pageHierarchy2 = new PageHierarchy("NonMainPage", 1);
        NonMainPage = pageHierarchy2;
        $VALUES = new PageHierarchy[]{pageHierarchy, pageHierarchy2};
    }

    PageHierarchy(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static PageHierarchy valueOf(String str) {
        return (PageHierarchy) Enum.valueOf(PageHierarchy.class, str);
    }

    public static PageHierarchy[] values() {
        return (PageHierarchy[]) $VALUES.clone();
    }
}

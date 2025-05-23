package com.tencent.mobileqq.qqlive.framework.page;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/PageStatus;", "", "(Ljava/lang/String;I)V", "NONE", "INIT_CONFIG", "INIT_COMPONENT", "UN_INIT", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class PageStatus {
    private static final /* synthetic */ PageStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PageStatus INIT_COMPONENT;
    public static final PageStatus INIT_CONFIG;
    public static final PageStatus NONE;
    public static final PageStatus UN_INIT;

    private static final /* synthetic */ PageStatus[] $values() {
        return new PageStatus[]{NONE, INIT_CONFIG, INIT_COMPONENT, UN_INIT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NONE = new PageStatus("NONE", 0);
        INIT_CONFIG = new PageStatus("INIT_CONFIG", 1);
        INIT_COMPONENT = new PageStatus("INIT_COMPONENT", 2);
        UN_INIT = new PageStatus("UN_INIT", 3);
        $VALUES = $values();
    }

    PageStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PageStatus valueOf(String str) {
        return (PageStatus) Enum.valueOf(PageStatus.class, str);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) $VALUES.clone();
    }
}

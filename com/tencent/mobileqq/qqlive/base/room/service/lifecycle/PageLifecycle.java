package com.tencent.mobileqq.qqlive.base.room.service.lifecycle;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;", "", "(Ljava/lang/String;I)V", "NONE", "PAGE_CREATE", "PAGE_VIEW_CREATED", "PAGE_ON_NEW_INTENT", "PAGE_START", "PAGE_RESUME", "PAGE_PAUSE", "PAGE_STOP", "PAGE_DESTROY", "DESTROY", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class PageLifecycle {
    private static final /* synthetic */ PageLifecycle[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PageLifecycle DESTROY;
    public static final PageLifecycle NONE;
    public static final PageLifecycle PAGE_CREATE;
    public static final PageLifecycle PAGE_DESTROY;
    public static final PageLifecycle PAGE_ON_NEW_INTENT;
    public static final PageLifecycle PAGE_PAUSE;
    public static final PageLifecycle PAGE_RESUME;
    public static final PageLifecycle PAGE_START;
    public static final PageLifecycle PAGE_STOP;
    public static final PageLifecycle PAGE_VIEW_CREATED;

    private static final /* synthetic */ PageLifecycle[] $values() {
        return new PageLifecycle[]{NONE, PAGE_CREATE, PAGE_VIEW_CREATED, PAGE_ON_NEW_INTENT, PAGE_START, PAGE_RESUME, PAGE_PAUSE, PAGE_STOP, PAGE_DESTROY, DESTROY};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NONE = new PageLifecycle("NONE", 0);
        PAGE_CREATE = new PageLifecycle("PAGE_CREATE", 1);
        PAGE_VIEW_CREATED = new PageLifecycle("PAGE_VIEW_CREATED", 2);
        PAGE_ON_NEW_INTENT = new PageLifecycle("PAGE_ON_NEW_INTENT", 3);
        PAGE_START = new PageLifecycle("PAGE_START", 4);
        PAGE_RESUME = new PageLifecycle("PAGE_RESUME", 5);
        PAGE_PAUSE = new PageLifecycle("PAGE_PAUSE", 6);
        PAGE_STOP = new PageLifecycle("PAGE_STOP", 7);
        PAGE_DESTROY = new PageLifecycle("PAGE_DESTROY", 8);
        DESTROY = new PageLifecycle("DESTROY", 9);
        $VALUES = $values();
    }

    PageLifecycle(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PageLifecycle valueOf(String str) {
        return (PageLifecycle) Enum.valueOf(PageLifecycle.class, str);
    }

    public static PageLifecycle[] values() {
        return (PageLifecycle[]) $VALUES.clone();
    }
}

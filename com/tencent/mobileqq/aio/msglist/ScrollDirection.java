package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/ScrollDirection;", "", "(Ljava/lang/String;I)V", "IDLE", "UP", "DOWN", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class ScrollDirection {
    private static final /* synthetic */ ScrollDirection[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ScrollDirection DOWN;
    public static final ScrollDirection IDLE;
    public static final ScrollDirection UP;

    private static final /* synthetic */ ScrollDirection[] $values() {
        return new ScrollDirection[]{IDLE, UP, DOWN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        IDLE = new ScrollDirection("IDLE", 0);
        UP = new ScrollDirection("UP", 1);
        DOWN = new ScrollDirection("DOWN", 2);
        $VALUES = $values();
    }

    ScrollDirection(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ScrollDirection valueOf(String str) {
        return (ScrollDirection) Enum.valueOf(ScrollDirection.class, str);
    }

    public static ScrollDirection[] values() {
        return (ScrollDirection[]) $VALUES.clone();
    }
}

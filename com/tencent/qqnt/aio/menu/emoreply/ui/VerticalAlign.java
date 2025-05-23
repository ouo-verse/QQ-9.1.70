package com.tencent.qqnt.aio.menu.emoreply.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/VerticalAlign;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class VerticalAlign {
    private static final /* synthetic */ VerticalAlign[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final VerticalAlign BOTTOM;
    public static final VerticalAlign TOP;

    private static final /* synthetic */ VerticalAlign[] $values() {
        return new VerticalAlign[]{TOP, BOTTOM};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TOP = new VerticalAlign("TOP", 0);
        BOTTOM = new VerticalAlign("BOTTOM", 1);
        $VALUES = $values();
    }

    VerticalAlign(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static VerticalAlign valueOf(String str) {
        return (VerticalAlign) Enum.valueOf(VerticalAlign.class, str);
    }

    public static VerticalAlign[] values() {
        return (VerticalAlign[]) $VALUES.clone();
    }
}

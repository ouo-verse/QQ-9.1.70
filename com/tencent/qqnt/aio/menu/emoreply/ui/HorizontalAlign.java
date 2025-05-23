package com.tencent.qqnt.aio.menu.emoreply.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/HorizontalAlign;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class HorizontalAlign {
    private static final /* synthetic */ HorizontalAlign[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HorizontalAlign LEFT;
    public static final HorizontalAlign RIGHT;

    private static final /* synthetic */ HorizontalAlign[] $values() {
        return new HorizontalAlign[]{LEFT, RIGHT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33733);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LEFT = new HorizontalAlign("LEFT", 0);
        RIGHT = new HorizontalAlign("RIGHT", 1);
        $VALUES = $values();
    }

    HorizontalAlign(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HorizontalAlign valueOf(String str) {
        return (HorizontalAlign) Enum.valueOf(HorizontalAlign.class, str);
    }

    public static HorizontalAlign[] values() {
        return (HorizontalAlign[]) $VALUES.clone();
    }
}

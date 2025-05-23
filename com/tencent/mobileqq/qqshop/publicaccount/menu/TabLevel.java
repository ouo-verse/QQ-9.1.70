package com.tencent.mobileqq.qqshop.publicaccount.menu;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/TabLevel;", "", "(Ljava/lang/String;I)V", "TAB", "SHEET", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class TabLevel {
    private static final /* synthetic */ TabLevel[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TabLevel SHEET;
    public static final TabLevel TAB;

    private static final /* synthetic */ TabLevel[] $values() {
        return new TabLevel[]{TAB, SHEET};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAB = new TabLevel("TAB", 0);
        SHEET = new TabLevel("SHEET", 1);
        $VALUES = $values();
    }

    TabLevel(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TabLevel valueOf(String str) {
        return (TabLevel) Enum.valueOf(TabLevel.class, str);
    }

    public static TabLevel[] values() {
        return (TabLevel[]) $VALUES.clone();
    }
}

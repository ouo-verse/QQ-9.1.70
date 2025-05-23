package com.tencent.mobileqq.troop.homework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/HWPageType;", "", "type", "", "(Ljava/lang/String;II)V", "PAGE_TYPE_NOTICE", "PAGE_TYPE_CLOCK_IN", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class HWPageType {
    private static final /* synthetic */ HWPageType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HWPageType PAGE_TYPE_CLOCK_IN;
    public static final HWPageType PAGE_TYPE_NOTICE;

    private static final /* synthetic */ HWPageType[] $values() {
        return new HWPageType[]{PAGE_TYPE_NOTICE, PAGE_TYPE_CLOCK_IN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        PAGE_TYPE_NOTICE = new HWPageType("PAGE_TYPE_NOTICE", 0, 1);
        PAGE_TYPE_CLOCK_IN = new HWPageType("PAGE_TYPE_CLOCK_IN", 1, 2);
        $VALUES = $values();
    }

    HWPageType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static HWPageType valueOf(String str) {
        return (HWPageType) Enum.valueOf(HWPageType.class, str);
    }

    public static HWPageType[] values() {
        return (HWPageType[]) $VALUES.clone();
    }
}

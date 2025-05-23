package com.tencent.qqnt.qbasealbum.query;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/FromType;", "", "(Ljava/lang/String;I)V", "FROM_PREVIEW", "FROM_PICKER", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class FromType {
    private static final /* synthetic */ FromType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final FromType FROM_PICKER;
    public static final FromType FROM_PREVIEW;

    private static final /* synthetic */ FromType[] $values() {
        return new FromType[]{FROM_PREVIEW, FROM_PICKER};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44604);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FROM_PREVIEW = new FromType("FROM_PREVIEW", 0);
        FROM_PICKER = new FromType("FROM_PICKER", 1);
        $VALUES = $values();
    }

    FromType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static FromType valueOf(String str) {
        return (FromType) Enum.valueOf(FromType.class, str);
    }

    public static FromType[] values() {
        return (FromType[]) $VALUES.clone();
    }
}

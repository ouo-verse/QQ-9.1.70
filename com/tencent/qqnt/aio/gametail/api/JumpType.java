package com.tencent.qqnt.aio.gametail.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/gametail/api/JumpType;", "", "(Ljava/lang/String;I)V", "SCHEMA", "HTTP", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class JumpType {
    private static final /* synthetic */ JumpType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final JumpType HTTP;
    public static final JumpType SCHEMA;

    private static final /* synthetic */ JumpType[] $values() {
        return new JumpType[]{SCHEMA, HTTP};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SCHEMA = new JumpType("SCHEMA", 0);
        HTTP = new JumpType("HTTP", 1);
        $VALUES = $values();
    }

    JumpType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static JumpType valueOf(String str) {
        return (JumpType) Enum.valueOf(JumpType.class, str);
    }

    public static JumpType[] values() {
        return (JumpType[]) $VALUES.clone();
    }
}

package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.logs.data.Body;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
final class EmptyBody implements Body {
    private static final /* synthetic */ EmptyBody[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final EmptyBody INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        EmptyBody emptyBody = new EmptyBody("INSTANCE", 0);
        INSTANCE = emptyBody;
        $VALUES = new EmptyBody[]{emptyBody};
    }

    EmptyBody(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static EmptyBody valueOf(String str) {
        return (EmptyBody) Enum.valueOf(EmptyBody.class, str);
    }

    public static EmptyBody[] values() {
        return (EmptyBody[]) $VALUES.clone();
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.Body
    public String asString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.Body
    public Body.Type getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Body.Type) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Body.Type.EMPTY;
    }
}

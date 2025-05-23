package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class SpanKind {
    private static final /* synthetic */ SpanKind[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SpanKind CLIENT;
    public static final SpanKind CONSUMER;
    public static final SpanKind INTERNAL;
    public static final SpanKind PRODUCER;
    public static final SpanKind SERVER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SpanKind spanKind = new SpanKind("INTERNAL", 0);
        INTERNAL = spanKind;
        SpanKind spanKind2 = new SpanKind("SERVER", 1);
        SERVER = spanKind2;
        SpanKind spanKind3 = new SpanKind("CLIENT", 2);
        CLIENT = spanKind3;
        SpanKind spanKind4 = new SpanKind("PRODUCER", 3);
        PRODUCER = spanKind4;
        SpanKind spanKind5 = new SpanKind("CONSUMER", 4);
        CONSUMER = spanKind5;
        $VALUES = new SpanKind[]{spanKind, spanKind2, spanKind3, spanKind4, spanKind5};
    }

    SpanKind(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static SpanKind valueOf(String str) {
        return (SpanKind) Enum.valueOf(SpanKind.class, str);
    }

    public static SpanKind[] values() {
        return (SpanKind[]) $VALUES.clone();
    }
}

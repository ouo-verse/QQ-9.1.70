package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
final class ImmutableTraceFlags implements TraceFlags {
    static IPatchRedirector $redirector_ = null;
    static final ImmutableTraceFlags DEFAULT;
    static final int HEX_LENGTH = 2;
    private static final ImmutableTraceFlags[] INSTANCES;
    static final ImmutableTraceFlags SAMPLED;
    private static final byte SAMPLED_BIT = 1;
    private final byte byteRep;
    private final String hexRep;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCES = buildInstances();
        DEFAULT = fromByte((byte) 0);
        SAMPLED = fromByte((byte) 1);
    }

    ImmutableTraceFlags(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Byte.valueOf(b16));
            return;
        }
        char[] cArr = new char[2];
        OtelEncodingUtils.byteToBase16(b16, cArr, 0);
        this.hexRep = new String(cArr);
        this.byteRep = b16;
    }

    private static ImmutableTraceFlags[] buildInstances() {
        ImmutableTraceFlags[] immutableTraceFlagsArr = new ImmutableTraceFlags[256];
        for (int i3 = 0; i3 < 256; i3++) {
            immutableTraceFlagsArr[i3] = new ImmutableTraceFlags((byte) i3);
        }
        return immutableTraceFlagsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableTraceFlags fromByte(byte b16) {
        return INSTANCES[b16 & 255];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableTraceFlags fromHex(CharSequence charSequence, int i3) {
        Objects.requireNonNull(charSequence, "src");
        return fromByte(OtelEncodingUtils.byteFromBase16(charSequence.charAt(i3), charSequence.charAt(i3 + 1)));
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceFlags
    public byte asByte() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Byte) iPatchRedirector.redirect((short) 4, (Object) this)).byteValue();
        }
        return this.byteRep;
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceFlags
    public String asHex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.hexRep;
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceFlags
    public boolean isSampled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ((this.byteRep & 1) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return asHex();
    }
}

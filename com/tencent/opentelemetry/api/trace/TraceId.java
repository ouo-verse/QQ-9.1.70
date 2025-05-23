package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;
import com.tencent.opentelemetry.api.internal.TemporaryBuffers;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class TraceId {
    static IPatchRedirector $redirector_ = null;
    private static final int BYTES_LENGTH = 16;
    private static final int HEX_LENGTH = 32;
    private static final String INVALID = "00000000000000000000000000000000";

    TraceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String fromBytes(byte[] bArr) {
        if (bArr != null && bArr.length >= 16) {
            char[] chars = TemporaryBuffers.chars(32);
            OtelEncodingUtils.bytesToBase16(bArr, chars, 16);
            return new String(chars, 0, 32);
        }
        return INVALID;
    }

    public static String fromLongs(long j3, long j16) {
        if (j3 == 0 && j16 == 0) {
            return getInvalid();
        }
        char[] chars = TemporaryBuffers.chars(32);
        OtelEncodingUtils.longToBase16String(j3, chars, 0);
        OtelEncodingUtils.longToBase16String(j16, chars, 16);
        return new String(chars, 0, 32);
    }

    public static String getInvalid() {
        return INVALID;
    }

    public static int getLength() {
        return 32;
    }

    public static boolean isValid(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() == 32 && !INVALID.contentEquals(charSequence) && OtelEncodingUtils.isValidBase16String(charSequence)) {
            return true;
        }
        return false;
    }
}

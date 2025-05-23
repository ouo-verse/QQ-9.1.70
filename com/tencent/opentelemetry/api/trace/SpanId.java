package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;
import com.tencent.opentelemetry.api.internal.TemporaryBuffers;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class SpanId {
    static IPatchRedirector $redirector_ = null;
    private static final int BYTES_LENGTH = 8;
    private static final int HEX_LENGTH = 16;
    private static final String INVALID = "0000000000000000";

    SpanId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String fromBytes(byte[] bArr) {
        if (bArr != null && bArr.length >= 8) {
            char[] chars = TemporaryBuffers.chars(16);
            OtelEncodingUtils.bytesToBase16(bArr, chars, 8);
            return new String(chars, 0, 16);
        }
        return INVALID;
    }

    public static String fromLong(long j3) {
        if (j3 == 0) {
            return getInvalid();
        }
        char[] chars = TemporaryBuffers.chars(16);
        OtelEncodingUtils.longToBase16String(j3, chars, 0);
        return new String(chars, 0, 16);
    }

    public static String getInvalid() {
        return INVALID;
    }

    public static int getLength() {
        return 16;
    }

    public static boolean isValid(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() == 16 && !INVALID.contentEquals(charSequence) && OtelEncodingUtils.isValidBase16String(charSequence)) {
            return true;
        }
        return false;
    }
}

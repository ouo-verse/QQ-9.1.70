package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class Soundex implements StringEncoder {
    public static final Soundex US_ENGLISH = null;
    public static final char[] US_ENGLISH_MAPPING = null;
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";

    public Soundex() {
        throw new RuntimeException("Stub!");
    }

    public int difference(String str, String str2) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public int getMaxLength() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public void setMaxLength(int i3) {
        throw new RuntimeException("Stub!");
    }

    public String soundex(String str) {
        throw new RuntimeException("Stub!");
    }

    public Soundex(char[] cArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        throw new RuntimeException("Stub!");
    }
}

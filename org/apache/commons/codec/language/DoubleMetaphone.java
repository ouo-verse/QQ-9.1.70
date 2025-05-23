package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class DoubleMetaphone implements StringEncoder {
    protected int maxCodeLen;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class DoubleMetaphoneResult {
        public DoubleMetaphoneResult(int i3) {
            throw new RuntimeException("Stub!");
        }

        public void append(char c16) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(char c16) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(char c16) {
            throw new RuntimeException("Stub!");
        }

        public String getAlternate() {
            throw new RuntimeException("Stub!");
        }

        public String getPrimary() {
            throw new RuntimeException("Stub!");
        }

        public boolean isComplete() {
            throw new RuntimeException("Stub!");
        }

        public void append(char c16, char c17) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(String str) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(String str) {
            throw new RuntimeException("Stub!");
        }

        public void append(String str) {
            throw new RuntimeException("Stub!");
        }

        public void append(String str, String str2) {
            throw new RuntimeException("Stub!");
        }
    }

    public DoubleMetaphone() {
        throw new RuntimeException("Stub!");
    }

    protected static boolean contains(String str, int i3, int i16, String[] strArr) {
        throw new RuntimeException("Stub!");
    }

    protected char charAt(String str, int i3) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    public int getMaxCodeLen() {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxCodeLen(int i3) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String str, boolean z16) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z16) {
        throw new RuntimeException("Stub!");
    }
}

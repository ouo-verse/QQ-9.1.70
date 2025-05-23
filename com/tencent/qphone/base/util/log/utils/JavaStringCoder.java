package com.tencent.qphone.base.util.log.utils;

import com.tencent.qphone.base.util.log.processor.ProcessByteData;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JavaStringCoder {
    ProcessByteData data = new ProcessByteData();
    JavaStringCoderCallback javaStringCoderCallback;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface JavaStringCoderCallback {
        void onBufferFull(ProcessByteData processByteData);
    }

    public JavaStringCoder(JavaStringCoderCallback javaStringCoderCallback) {
        this.javaStringCoderCallback = javaStringCoderCallback;
    }

    public void feedIn(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt < '\u0080') {
                ProcessByteData processByteData = this.data;
                byte[] bArr = processByteData.bytes;
                int i16 = processByteData.offset;
                processByteData.offset = i16 + 1;
                bArr[i16] = (byte) charAt;
                processByteData.length++;
            } else if (charAt < '\u0800') {
                ProcessByteData processByteData2 = this.data;
                byte[] bArr2 = processByteData2.bytes;
                int i17 = processByteData2.offset;
                int i18 = i17 + 1;
                bArr2[i17] = (byte) ((charAt >>> 6) | 192);
                processByteData2.offset = i18 + 1;
                bArr2[i18] = (byte) ((charAt & '?') | 128);
                processByteData2.length += 2;
            } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                i3++;
                int codePoint = i3 < length ? Character.toCodePoint(charAt, str.charAt(i3)) : 0;
                if (codePoint >= 65536 && codePoint < 2097152) {
                    ProcessByteData processByteData3 = this.data;
                    byte[] bArr3 = processByteData3.bytes;
                    int i19 = processByteData3.offset;
                    int i26 = i19 + 1;
                    bArr3[i19] = (byte) ((codePoint >>> 18) | 240);
                    int i27 = i26 + 1;
                    bArr3[i26] = (byte) (((codePoint >>> 12) & 63) | 128);
                    int i28 = i27 + 1;
                    bArr3[i27] = (byte) ((63 & (codePoint >>> 6)) | 128);
                    processByteData3.offset = i28 + 1;
                    bArr3[i28] = (byte) ((codePoint & 63) | 128);
                    processByteData3.length += 4;
                } else {
                    ProcessByteData processByteData4 = this.data;
                    byte[] bArr4 = processByteData4.bytes;
                    int i29 = processByteData4.offset;
                    processByteData4.offset = i29 + 1;
                    bArr4[i29] = 63;
                    processByteData4.length++;
                }
            } else {
                ProcessByteData processByteData5 = this.data;
                byte[] bArr5 = processByteData5.bytes;
                int i36 = processByteData5.offset;
                int i37 = i36 + 1;
                bArr5[i36] = (byte) ((charAt >>> '\f') | 224);
                int i38 = i37 + 1;
                bArr5[i37] = (byte) ((63 & (charAt >>> 6)) | 128);
                processByteData5.offset = i38 + 1;
                bArr5[i38] = (byte) ((charAt & '?') | 128);
                processByteData5.length += 3;
            }
            if (this.data.offset >= r3.capacity - 4) {
                flush();
            }
            i3++;
        }
    }

    public void flush() {
        ProcessByteData processByteData = this.data;
        processByteData.offset = 0;
        this.javaStringCoderCallback.onBufferFull(processByteData);
        this.data.clear();
    }

    public void feedIn(char[] cArr, int i3, int i16) {
        int i17 = i16 + i3;
        while (i3 < i17) {
            char c16 = cArr[i3];
            if (c16 < '\u0080') {
                ProcessByteData processByteData = this.data;
                byte[] bArr = processByteData.bytes;
                int i18 = processByteData.offset;
                processByteData.offset = i18 + 1;
                bArr[i18] = (byte) c16;
                processByteData.length++;
            } else if (c16 < '\u0800') {
                ProcessByteData processByteData2 = this.data;
                byte[] bArr2 = processByteData2.bytes;
                int i19 = processByteData2.offset;
                int i26 = i19 + 1;
                bArr2[i19] = (byte) ((c16 >>> 6) | 192);
                processByteData2.offset = i26 + 1;
                bArr2[i26] = (byte) ((c16 & '?') | 128);
                processByteData2.length += 2;
            } else if (c16 >= '\ud800' && c16 <= '\udfff') {
                i3++;
                int codePoint = i3 < i17 ? Character.toCodePoint(c16, cArr[i3]) : 0;
                if (codePoint >= 65536 && codePoint < 2097152) {
                    ProcessByteData processByteData3 = this.data;
                    byte[] bArr3 = processByteData3.bytes;
                    int i27 = processByteData3.offset;
                    int i28 = i27 + 1;
                    bArr3[i27] = (byte) ((codePoint >>> 18) | 240);
                    int i29 = i28 + 1;
                    bArr3[i28] = (byte) (((codePoint >>> 12) & 63) | 128);
                    int i36 = i29 + 1;
                    bArr3[i29] = (byte) ((63 & (codePoint >>> 6)) | 128);
                    processByteData3.offset = i36 + 1;
                    bArr3[i36] = (byte) ((codePoint & 63) | 128);
                    processByteData3.length += 4;
                } else {
                    ProcessByteData processByteData4 = this.data;
                    byte[] bArr4 = processByteData4.bytes;
                    int i37 = processByteData4.offset;
                    processByteData4.offset = i37 + 1;
                    bArr4[i37] = 63;
                    processByteData4.length++;
                }
            } else {
                ProcessByteData processByteData5 = this.data;
                byte[] bArr5 = processByteData5.bytes;
                int i38 = processByteData5.offset;
                int i39 = i38 + 1;
                bArr5[i38] = (byte) ((c16 >>> '\f') | 224);
                int i46 = i39 + 1;
                bArr5[i39] = (byte) ((63 & (c16 >>> 6)) | 128);
                processByteData5.offset = i46 + 1;
                bArr5[i46] = (byte) ((c16 & '?') | 128);
                processByteData5.length += 3;
            }
            if (this.data.offset >= r0.capacity - 4) {
                flush();
            }
            i3++;
        }
    }

    public void feedIn(byte[] bArr, int i3, int i16) {
        ProcessByteData processByteData = this.data;
        int i17 = processByteData.capacity;
        if (i16 <= i17) {
            if (i17 - processByteData.length < i16) {
                flush();
            }
            this.data.append(bArr, i3, i16);
            if (this.data.offset >= r3.capacity - 4) {
                flush();
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void feedIn(int i3) {
        char c16 = (char) i3;
        if (c16 < '\u0080') {
            ProcessByteData processByteData = this.data;
            byte[] bArr = processByteData.bytes;
            int i16 = processByteData.offset;
            processByteData.offset = i16 + 1;
            bArr[i16] = (byte) c16;
            processByteData.length++;
        } else if (c16 < '\u0800') {
            ProcessByteData processByteData2 = this.data;
            byte[] bArr2 = processByteData2.bytes;
            int i17 = processByteData2.offset;
            int i18 = i17 + 1;
            bArr2[i17] = (byte) ((c16 >>> 6) | 192);
            processByteData2.offset = i18 + 1;
            bArr2[i18] = (byte) ((c16 & '?') | 128);
            processByteData2.length += 2;
        } else {
            if (c16 >= '\ud800' && c16 <= '\udfff') {
                throw new RuntimeException("not supported char " + i3);
            }
            ProcessByteData processByteData3 = this.data;
            byte[] bArr3 = processByteData3.bytes;
            int i19 = processByteData3.offset;
            int i26 = i19 + 1;
            bArr3[i19] = (byte) ((c16 >>> '\f') | 224);
            int i27 = i26 + 1;
            bArr3[i26] = (byte) (((c16 >>> 6) & 63) | 128);
            processByteData3.offset = i27 + 1;
            bArr3[i27] = (byte) ((c16 & '?') | 128);
            processByteData3.length += 3;
        }
        if (this.data.offset >= r7.capacity - 4) {
            flush();
        }
    }
}

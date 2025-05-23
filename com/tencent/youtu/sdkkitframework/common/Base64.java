package com.tencent.youtu.sdkkitframework.common;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Base64 {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DecInputStream extends InputStream {
        static IPatchRedirector $redirector_;
        private final int[] base64;
        private int bits;
        private boolean closed;
        private boolean eof;

        /* renamed from: is, reason: collision with root package name */
        private final InputStream f385198is;
        private final boolean isMIME;
        private int nextin;
        private int nextout;
        private byte[] sbBuf;

        public DecInputStream(InputStream inputStream, int[] iArr, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, inputStream, iArr, Boolean.valueOf(z16));
                return;
            }
            this.bits = 0;
            this.nextin = 18;
            this.nextout = -8;
            this.eof = false;
            this.closed = false;
            this.sbBuf = new byte[1];
            this.f385198is = inputStream;
            this.base64 = iArr;
            this.isMIME = z16;
        }

        @Override // java.io.InputStream
        public int available() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            if (!this.closed) {
                return this.f385198is.available();
            }
            throw new IOException("Stream is closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else if (!this.closed) {
                this.closed = true;
                this.f385198is.close();
            }
        }

        @Override // java.io.InputStream
        public int read() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (read(this.sbBuf, 0, 1) == -1) {
                return -1;
            }
            return this.sbBuf[0] & 255;
        }

        /* JADX WARN: Code restructure failed: missing block: B:81:0x0157, code lost:
        
            return r4 - r11;
         */
        @Override // java.io.InputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int read(byte[] bArr, int i3, int i16) {
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            if (!this.closed) {
                if (this.eof && this.nextout < 0) {
                    return -1;
                }
                if (i3 >= 0 && i16 >= 0 && i16 <= bArr.length - i3) {
                    if (this.nextout >= 0) {
                        int i18 = i3;
                        while (i16 != 0) {
                            i17 = i18 + 1;
                            int i19 = this.bits;
                            int i26 = this.nextout;
                            bArr[i18] = (byte) (i19 >> i26);
                            i16--;
                            int i27 = i26 - 8;
                            this.nextout = i27;
                            if (i27 < 0) {
                                this.bits = 0;
                            } else {
                                i18 = i17;
                            }
                        }
                        return i18 - i3;
                    }
                    i17 = i3;
                    while (true) {
                        if (i16 <= 0) {
                            break;
                        }
                        int read = this.f385198is.read();
                        if (read == -1) {
                            this.eof = true;
                            int i28 = this.nextin;
                            if (i28 != 18) {
                                if (i28 != 12) {
                                    int i29 = i17 + 1;
                                    int i36 = this.bits;
                                    bArr[i17] = (byte) (i36 >> 16);
                                    int i37 = i16 - 1;
                                    if (i28 == 0) {
                                        if (i37 == 0) {
                                            this.bits = i36 >> 8;
                                            this.nextout = 0;
                                        } else {
                                            i17 = i29 + 1;
                                            bArr[i29] = (byte) (i36 >> 8);
                                        }
                                    }
                                    i17 = i29;
                                } else {
                                    throw new IOException("Base64 stream has one un-decoded dangling byte.");
                                }
                            }
                            if (i17 == i3) {
                                return -1;
                            }
                            return i17 - i3;
                        }
                        if (read == 61) {
                            int i38 = this.nextin;
                            if (i38 != 18 && i38 != 12 && (i38 != 6 || this.f385198is.read() == 61)) {
                                int i39 = i17 + 1;
                                int i46 = this.bits;
                                bArr[i17] = (byte) (i46 >> 16);
                                int i47 = i16 - 1;
                                if (this.nextin == 0) {
                                    if (i47 == 0) {
                                        this.bits = i46 >> 8;
                                        this.nextout = 0;
                                    } else {
                                        bArr[i39] = (byte) (i46 >> 8);
                                        i17 = i39 + 1;
                                        this.eof = true;
                                    }
                                }
                                i17 = i39;
                                this.eof = true;
                            } else {
                                throw new IOException("Illegal base64 ending sequence:" + this.nextin);
                            }
                        } else {
                            int i48 = this.base64[read];
                            if (i48 == -1) {
                                if (!this.isMIME) {
                                    throw new IOException("Illegal base64 character " + Integer.toString(i48, 16));
                                }
                            } else {
                                int i49 = this.bits;
                                int i56 = this.nextin;
                                this.bits = (i48 << i56) | i49;
                                if (i56 == 0) {
                                    this.nextin = 18;
                                    this.nextout = 16;
                                    while (true) {
                                        int i57 = this.nextout;
                                        if (i57 >= 0) {
                                            int i58 = i17 + 1;
                                            bArr[i17] = (byte) (this.bits >> i57);
                                            i16--;
                                            int i59 = i57 - 8;
                                            this.nextout = i59;
                                            if (i16 == 0 && i59 >= 0) {
                                                return i58 - i3;
                                            }
                                            i17 = i58;
                                        } else {
                                            this.bits = 0;
                                            break;
                                        }
                                    }
                                } else {
                                    this.nextin = i56 - 6;
                                }
                            }
                        }
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } else {
                throw new IOException("Stream is closed");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class EncOutputStream extends FilterOutputStream {
        static IPatchRedirector $redirector_;

        /* renamed from: b0, reason: collision with root package name */
        private int f385199b0;

        /* renamed from: b1, reason: collision with root package name */
        private int f385200b1;

        /* renamed from: b2, reason: collision with root package name */
        private int f385201b2;
        private final char[] base64;
        private boolean closed;
        private final boolean doPadding;
        private int leftover;
        private final int linemax;
        private int linepos;
        private final byte[] newline;

        public EncOutputStream(OutputStream outputStream, char[] cArr, byte[] bArr, int i3, boolean z16) {
            super(outputStream);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, outputStream, cArr, bArr, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.leftover = 0;
            this.closed = false;
            this.linepos = 0;
            this.base64 = cArr;
            this.newline = bArr;
            this.linemax = i3;
            this.doPadding = z16;
        }

        private void checkNewline() {
            if (this.linepos == this.linemax) {
                ((FilterOutputStream) this).out.write(this.newline);
                this.linepos = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (!this.closed) {
                this.closed = true;
                int i3 = this.leftover;
                if (i3 == 1) {
                    checkNewline();
                    ((FilterOutputStream) this).out.write(this.base64[this.f385199b0 >> 2]);
                    ((FilterOutputStream) this).out.write(this.base64[(this.f385199b0 << 4) & 63]);
                    if (this.doPadding) {
                        ((FilterOutputStream) this).out.write(61);
                        ((FilterOutputStream) this).out.write(61);
                    }
                } else if (i3 == 2) {
                    checkNewline();
                    ((FilterOutputStream) this).out.write(this.base64[this.f385199b0 >> 2]);
                    ((FilterOutputStream) this).out.write(this.base64[(this.f385200b1 >> 4) | ((this.f385199b0 << 4) & 63)]);
                    ((FilterOutputStream) this).out.write(this.base64[(this.f385200b1 << 2) & 63]);
                    if (this.doPadding) {
                        ((FilterOutputStream) this).out.write(61);
                    }
                }
                this.leftover = 0;
                ((FilterOutputStream) this).out.close();
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                write(new byte[]{(byte) (i3 & 255)}, 0, 1);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (!this.closed) {
                if (i3 < 0 || i16 < 0 || i16 > bArr.length - i3) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                if (i16 == 0) {
                    return;
                }
                int i17 = this.leftover;
                if (i17 != 0) {
                    if (i17 == 1) {
                        int i18 = i3 + 1;
                        this.f385200b1 = bArr[i3] & 255;
                        i16--;
                        if (i16 == 0) {
                            this.leftover = i17 + 1;
                            return;
                        }
                        i3 = i18;
                    }
                    this.f385201b2 = bArr[i3] & 255;
                    i16--;
                    checkNewline();
                    ((FilterOutputStream) this).out.write(this.base64[this.f385199b0 >> 2]);
                    ((FilterOutputStream) this).out.write(this.base64[((this.f385199b0 << 4) & 63) | (this.f385200b1 >> 4)]);
                    ((FilterOutputStream) this).out.write(this.base64[((this.f385200b1 << 2) & 63) | (this.f385201b2 >> 6)]);
                    ((FilterOutputStream) this).out.write(this.base64[this.f385201b2 & 63]);
                    this.linepos += 4;
                    i3++;
                }
                int i19 = i16 / 3;
                this.leftover = i16 - (i19 * 3);
                while (true) {
                    int i26 = i19 - 1;
                    if (i19 <= 0) {
                        break;
                    }
                    checkNewline();
                    int i27 = i3 + 1;
                    int i28 = i27 + 1;
                    int i29 = ((bArr[i3] & 255) << 16) | ((bArr[i27] & 255) << 8) | (bArr[i28] & 255);
                    ((FilterOutputStream) this).out.write(this.base64[(i29 >>> 18) & 63]);
                    ((FilterOutputStream) this).out.write(this.base64[(i29 >>> 12) & 63]);
                    ((FilterOutputStream) this).out.write(this.base64[(i29 >>> 6) & 63]);
                    ((FilterOutputStream) this).out.write(this.base64[i29 & 63]);
                    this.linepos += 4;
                    i3 = i28 + 1;
                    i19 = i26;
                }
                int i36 = this.leftover;
                if (i36 == 1) {
                    this.f385199b0 = bArr[i3] & 255;
                    return;
                } else {
                    if (i36 == 2) {
                        this.f385199b0 = bArr[i3] & 255;
                        this.f385200b1 = bArr[i3 + 1] & 255;
                        return;
                    }
                    return;
                }
            }
            throw new IOException("Stream is closed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Encoder {
        static IPatchRedirector $redirector_ = null;
        private static final byte[] CRLF;
        private static final int MIMELINEMAX = 76;
        public static final Encoder RFC2045;
        public static final Encoder RFC4648;
        public static final Encoder RFC4648_URLSAFE;
        private static final char[] toBase64;
        private static final char[] toBase64URL;
        private final boolean doPadding;
        private final boolean isURL;
        private final int linemax;
        private final byte[] newline;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12928);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            toBase64 = new char[]{EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
            toBase64URL = new char[]{EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', util.base64_pad_url};
            byte[] bArr = {13, 10};
            CRLF = bArr;
            RFC4648 = new Encoder(false, null, -1, true);
            RFC4648_URLSAFE = new Encoder(true, null, -1, true);
            RFC2045 = new Encoder(false, bArr, 76, true);
        }

        public /* synthetic */ Encoder(boolean z16, byte[] bArr, int i3, boolean z17, AnonymousClass1 anonymousClass1) {
            this(z16, bArr, i3, z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bArr, Integer.valueOf(i3), Boolean.valueOf(z17), anonymousClass1);
        }

        private int encode0(byte[] bArr, int i3, int i16, byte[] bArr2) {
            char[] cArr;
            int i17;
            if (this.isURL) {
                cArr = toBase64URL;
            } else {
                cArr = toBase64;
            }
            int i18 = ((i16 - i3) / 3) * 3;
            int i19 = i3 + i18;
            int i26 = this.linemax;
            if (i26 > 0 && i18 > (i17 = (i26 / 4) * 3)) {
                i18 = i17;
            }
            int i27 = 0;
            while (i3 < i19) {
                int min = Math.min(i3 + i18, i19);
                int i28 = i3;
                int i29 = i27;
                while (i28 < min) {
                    int i36 = i28 + 1;
                    int i37 = i36 + 1;
                    int i38 = ((bArr[i28] & 255) << 16) | ((bArr[i36] & 255) << 8);
                    int i39 = i37 + 1;
                    int i46 = i38 | (bArr[i37] & 255);
                    int i47 = i29 + 1;
                    bArr2[i29] = (byte) cArr[(i46 >>> 18) & 63];
                    int i48 = i47 + 1;
                    bArr2[i47] = (byte) cArr[(i46 >>> 12) & 63];
                    int i49 = i48 + 1;
                    bArr2[i48] = (byte) cArr[(i46 >>> 6) & 63];
                    i29 = i49 + 1;
                    bArr2[i49] = (byte) cArr[i46 & 63];
                    i28 = i39;
                }
                int i56 = ((min - i3) / 3) * 4;
                i27 += i56;
                if (i56 == this.linemax && min < i16) {
                    byte[] bArr3 = this.newline;
                    int length = bArr3.length;
                    int i57 = 0;
                    while (i57 < length) {
                        bArr2[i27] = bArr3[i57];
                        i57++;
                        i27++;
                    }
                }
                i3 = min;
            }
            if (i3 < i16) {
                int i58 = i3 + 1;
                int i59 = bArr[i3] & 255;
                int i65 = i27 + 1;
                bArr2[i27] = (byte) cArr[i59 >> 2];
                if (i58 == i16) {
                    i27 = i65 + 1;
                    bArr2[i65] = (byte) cArr[(i59 << 4) & 63];
                    if (this.doPadding) {
                        int i66 = i27 + 1;
                        bArr2[i27] = 61;
                        int i67 = i66 + 1;
                        bArr2[i66] = 61;
                        return i67;
                    }
                } else {
                    int i68 = bArr[i58] & 255;
                    int i69 = i65 + 1;
                    bArr2[i65] = (byte) cArr[((i59 << 4) & 63) | (i68 >> 4)];
                    i27 = i69 + 1;
                    bArr2[i69] = (byte) cArr[(i68 << 2) & 63];
                    if (this.doPadding) {
                        int i75 = i27 + 1;
                        bArr2[i27] = 61;
                        return i75;
                    }
                }
            }
            return i27;
        }

        private final int outLength(int i3) {
            int i16;
            int i17;
            if (this.doPadding) {
                i17 = ((i3 + 2) / 3) * 4;
            } else {
                int i18 = i3 % 3;
                int i19 = (i3 / 3) * 4;
                if (i18 == 0) {
                    i16 = 0;
                } else {
                    i16 = i18 + 1;
                }
                i17 = i19 + i16;
            }
            int i26 = this.linemax;
            if (i26 > 0) {
                return i17 + (((i17 - 1) / i26) * this.newline.length);
            }
            return i17;
        }

        public byte[] encode(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            }
            int outLength = outLength(bArr.length);
            byte[] bArr2 = new byte[outLength];
            int encode0 = encode0(bArr, 0, bArr.length, bArr2);
            return encode0 != outLength ? Arrays.copyOf(bArr2, encode0) : bArr2;
        }

        public String encodeToString(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
            }
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }

        public Encoder withoutPadding() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Encoder) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            if (!this.doPadding) {
                return this;
            }
            return new Encoder(this.isURL, this.newline, this.linemax, false);
        }

        public OutputStream wrap(OutputStream outputStream) {
            char[] cArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (OutputStream) iPatchRedirector.redirect((short) 8, (Object) this, (Object) outputStream);
            }
            Objects.requireNonNull(outputStream);
            if (this.isURL) {
                cArr = toBase64URL;
            } else {
                cArr = toBase64;
            }
            return new EncOutputStream(outputStream, cArr, this.newline, this.linemax, this.doPadding);
        }

        Encoder(boolean z16, byte[] bArr, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), bArr, Integer.valueOf(i3), Boolean.valueOf(z17));
                return;
            }
            this.isURL = z16;
            this.newline = bArr;
            this.linemax = i3;
            this.doPadding = z17;
        }

        public int encode(byte[] bArr, byte[] bArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr, (Object) bArr2)).intValue();
            }
            if (bArr2.length >= outLength(bArr.length)) {
                return encode0(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for encoding all input bytes");
        }

        public ByteBuffer encode(ByteBuffer byteBuffer) {
            int encode0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ByteBuffer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) byteBuffer);
            }
            int outLength = outLength(byteBuffer.remaining());
            byte[] bArr = new byte[outLength];
            if (byteBuffer.hasArray()) {
                encode0 = encode0(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.arrayOffset() + byteBuffer.limit(), bArr);
                byteBuffer.position(byteBuffer.limit());
            } else {
                int remaining = byteBuffer.remaining();
                byte[] bArr2 = new byte[remaining];
                byteBuffer.get(bArr2);
                encode0 = encode0(bArr2, 0, remaining, bArr);
            }
            if (encode0 != outLength) {
                bArr = Arrays.copyOf(bArr, encode0);
            }
            return ByteBuffer.wrap(bArr);
        }
    }

    Base64() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Decoder getDecoder() {
        return Decoder.RFC4648;
    }

    public static Encoder getEncoder() {
        return Encoder.RFC4648;
    }

    public static Decoder getMimeDecoder() {
        return Decoder.RFC2045;
    }

    public static Encoder getMimeEncoder() {
        return Encoder.RFC2045;
    }

    public static Decoder getUrlDecoder() {
        return Decoder.RFC4648_URLSAFE;
    }

    public static Encoder getUrlEncoder() {
        return Encoder.RFC4648_URLSAFE;
    }

    public static Encoder getMimeEncoder(int i3, byte[] bArr) {
        Objects.requireNonNull(bArr);
        int[] iArr = Decoder.fromBase64;
        for (byte b16 : bArr) {
            if (iArr[b16 & 255] != -1) {
                throw new IllegalArgumentException("Illegal base64 line separator character 0x" + Integer.toString(b16, 16));
            }
        }
        if (i3 <= 0) {
            return Encoder.RFC4648;
        }
        return new Encoder(false, bArr, (i3 >> 2) << 2, true, null);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Decoder {
        static IPatchRedirector $redirector_;
        public static final Decoder RFC2045;
        public static final Decoder RFC4648;
        public static final Decoder RFC4648_URLSAFE;
        private static final int[] fromBase64;
        private static final int[] fromBase64URL;
        private final boolean isMIME;
        private final boolean isURL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20349);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            int[] iArr = new int[256];
            fromBase64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i3 = 0; i3 < Encoder.toBase64.length; i3++) {
                fromBase64[Encoder.toBase64[i3]] = i3;
            }
            fromBase64[61] = -2;
            int[] iArr2 = new int[256];
            fromBase64URL = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i16 = 0; i16 < Encoder.toBase64URL.length; i16++) {
                fromBase64URL[Encoder.toBase64URL[i16]] = i16;
            }
            fromBase64URL[61] = -2;
            RFC4648 = new Decoder(false, false);
            RFC4648_URLSAFE = new Decoder(true, false);
            RFC2045 = new Decoder(false, true);
        }

        Decoder(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.isURL = z16;
                this.isMIME = z17;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x002b, code lost:
        
            if (r11[r8] == 61) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
        
            if (r4 != 18) goto L32;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int decode0(byte[] bArr, int i3, int i16, byte[] bArr2) {
            int[] iArr;
            if (this.isURL) {
                iArr = fromBase64URL;
            } else {
                iArr = fromBase64;
            }
            int i17 = 18;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (i3 >= i16) {
                    break;
                }
                int i26 = i3 + 1;
                int i27 = iArr[bArr[i3] & 255];
                if (i27 < 0) {
                    if (i27 == -2) {
                        if (i17 == 6) {
                            if (i26 != i16) {
                                i3 = i26 + 1;
                            }
                            throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                        }
                        i3 = i26;
                    } else if (!this.isMIME) {
                        throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i26 - 1], 16));
                    }
                } else {
                    i18 |= i27 << i17;
                    i17 -= 6;
                    if (i17 < 0) {
                        int i28 = i19 + 1;
                        bArr2[i19] = (byte) (i18 >> 16);
                        int i29 = i28 + 1;
                        bArr2[i28] = (byte) (i18 >> 8);
                        i19 = i29 + 1;
                        bArr2[i29] = (byte) i18;
                        i17 = 18;
                        i18 = 0;
                    }
                }
                i3 = i26;
            }
            if (i17 == 6) {
                bArr2[i19] = (byte) (i18 >> 16);
                i19++;
            } else if (i17 == 0) {
                int i36 = i19 + 1;
                bArr2[i19] = (byte) (i18 >> 16);
                i19 = i36 + 1;
                bArr2[i36] = (byte) (i18 >> 8);
            } else if (i17 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i3 < i16) {
                if (this.isMIME) {
                    int i37 = i3 + 1;
                    if (iArr[bArr[i3]] < 0) {
                        i3 = i37;
                    } else {
                        i3 = i37;
                    }
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i3);
            }
            return i19;
        }

        private int outLength(byte[] bArr, int i3, int i16) {
            int[] iArr;
            int i17;
            if (this.isURL) {
                iArr = fromBase64URL;
            } else {
                iArr = fromBase64;
            }
            int i18 = i16 - i3;
            int i19 = 0;
            if (i18 == 0) {
                return 0;
            }
            if (i18 < 2) {
                if (this.isMIME && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int i26 = 0;
                while (true) {
                    if (i3 >= i16) {
                        break;
                    }
                    int i27 = i3 + 1;
                    int i28 = bArr[i3] & 255;
                    if (i28 == 61) {
                        i18 -= (i16 - i27) + 1;
                        break;
                    }
                    if (iArr[i28] == -1) {
                        i26++;
                    }
                    i3 = i27;
                }
                i18 -= i26;
            } else if (bArr[i16 - 1] == 61) {
                i19 = bArr[i16 - 2] == 61 ? 2 : 1;
            }
            if (i19 == 0 && (i17 = i18 & 3) != 0) {
                i19 = 4 - i17;
            }
            return (((i18 + 3) / 4) * 3) - i19;
        }

        public byte[] decode(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            }
            int outLength = outLength(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[outLength];
            int decode0 = decode0(bArr, 0, bArr.length, bArr2);
            return decode0 != outLength ? Arrays.copyOf(bArr2, decode0) : bArr2;
        }

        public InputStream wrap(InputStream inputStream) {
            int[] iArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (InputStream) iPatchRedirector.redirect((short) 7, (Object) this, (Object) inputStream);
            }
            Objects.requireNonNull(inputStream);
            if (this.isURL) {
                iArr = fromBase64URL;
            } else {
                iArr = fromBase64;
            }
            return new DecInputStream(inputStream, iArr, this.isMIME);
        }

        @SuppressLint({"NewApi"})
        public byte[] decode(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? decode(str.getBytes(StandardCharsets.ISO_8859_1)) : (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }

        public int decode(byte[] bArr, byte[] bArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr, (Object) bArr2)).intValue();
            }
            if (bArr2.length >= outLength(bArr, 0, bArr.length)) {
                return decode0(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for decoding all input bytes");
        }

        public ByteBuffer decode(ByteBuffer byteBuffer) {
            int remaining;
            byte[] bArr;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ByteBuffer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) byteBuffer);
            }
            int position = byteBuffer.position();
            try {
                if (byteBuffer.hasArray()) {
                    bArr = byteBuffer.array();
                    i3 = byteBuffer.arrayOffset() + byteBuffer.position();
                    remaining = byteBuffer.arrayOffset() + byteBuffer.limit();
                    byteBuffer.position(byteBuffer.limit());
                } else {
                    remaining = byteBuffer.remaining();
                    bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    i3 = 0;
                }
                byte[] bArr2 = new byte[outLength(bArr, i3, remaining)];
                return ByteBuffer.wrap(bArr2, 0, decode0(bArr, i3, remaining, bArr2));
            } catch (IllegalArgumentException e16) {
                byteBuffer.position(position);
                throw e16;
            }
        }
    }
}

package com.tencent.mtt.hippy.d;

import android.util.Log;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: m, reason: collision with root package name */
    private static final List<Integer> f337187m = Arrays.asList(0, 1, 2, 8, 9, 10);

    /* renamed from: n, reason: collision with root package name */
    private static final List<Integer> f337188n = Arrays.asList(0, 1, 2);

    /* renamed from: a, reason: collision with root package name */
    private final d f337189a;

    /* renamed from: b, reason: collision with root package name */
    private int f337190b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f337191c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f337192d;

    /* renamed from: e, reason: collision with root package name */
    private int f337193e;

    /* renamed from: f, reason: collision with root package name */
    private int f337194f;

    /* renamed from: g, reason: collision with root package name */
    private int f337195g;

    /* renamed from: h, reason: collision with root package name */
    private int f337196h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f337197i = new byte[0];

    /* renamed from: j, reason: collision with root package name */
    private byte[] f337198j = new byte[0];

    /* renamed from: k, reason: collision with root package name */
    private boolean f337199k = false;

    /* renamed from: l, reason: collision with root package name */
    private final ByteArrayOutputStream f337200l = new ByteArrayOutputStream();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends DataInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        public byte[] a(int i3) throws IOException {
            byte[] bArr = new byte[i3];
            int i16 = 0;
            while (i16 < i3) {
                int read = read(bArr, i16, i3 - i16);
                if (read == -1) {
                    break;
                }
                i16 += read;
            }
            if (i16 == i3) {
                return bArr;
            }
            throw new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", Integer.valueOf(i16), Integer.valueOf(i3)));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C9225b extends IOException {
        public C9225b(String str) {
            super(str);
        }
    }

    public b(d dVar) {
        this.f337189a = dVar;
    }

    private void a() throws IOException {
        byte[] a16 = a(this.f337198j, this.f337197i, 0);
        int i3 = this.f337193e;
        if (i3 == 0) {
            if (this.f337196h == 0) {
                throw new C9225b("Mode was not set.");
            }
            this.f337200l.write(a16);
            if (this.f337191c) {
                byte[] byteArray = this.f337200l.toByteArray();
                if (this.f337196h == 1) {
                    this.f337189a.d().b(b(byteArray));
                } else {
                    this.f337189a.d().a(byteArray);
                }
                b();
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (this.f337191c) {
                this.f337189a.d().b(b(a16));
                return;
            }
            this.f337196h = 1;
        } else {
            if (i3 != 2) {
                if (i3 == 8) {
                    int i16 = a16.length >= 2 ? a16[1] + (a16[0] * 256) : 0;
                    String b16 = a16.length > 2 ? b(a(a16, 2)) : null;
                    Log.d("HybiParser", "Got close op! " + i16 + " " + b16);
                    this.f337189a.d().b(i16, b16);
                    return;
                }
                if (i3 == 9) {
                    if (a16.length > 125) {
                        throw new C9225b("Ping payload too large");
                    }
                    Log.d("HybiParser", "Sending pong!!");
                    this.f337189a.b(a(a16, 10, -1));
                    return;
                }
                if (i3 == 10) {
                    Log.d("HybiParser", "Got pong! " + b(a16));
                    return;
                }
                return;
            }
            if (this.f337191c) {
                this.f337189a.d().a(a16);
                return;
            }
            this.f337196h = 2;
        }
        this.f337200l.write(a16);
    }

    private String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException(e16);
        }
    }

    private int c(byte[] bArr) throws C9225b {
        long c16 = c(bArr, 0, bArr.length);
        if (c16 >= 0 && c16 <= TTL.MAX_VALUE) {
            return (int) c16;
        }
        throw new C9225b("Bad integer: " + c16);
    }

    private void a(byte b16) throws C9225b {
        boolean z16 = (b16 & MaskType.MASK_TYPE_EXTERNAL) == 64;
        boolean z17 = (b16 & 32) == 32;
        boolean z18 = (b16 & RegisterType.UNINIT_REF) == 16;
        if (z16 || z17 || z18) {
            throw new C9225b("RSV not zero");
        }
        this.f337191c = (b16 & 128) == 128;
        int i3 = b16 & RegisterType.DOUBLE_HI;
        this.f337193e = i3;
        this.f337197i = new byte[0];
        this.f337198j = new byte[0];
        if (!f337187m.contains(Integer.valueOf(i3))) {
            throw new C9225b("Bad opcode");
        }
        if (!f337188n.contains(Integer.valueOf(this.f337193e)) && !this.f337191c) {
            throw new C9225b("Expected non-final packet");
        }
        this.f337190b = 1;
    }

    private void b() {
        this.f337196h = 0;
        this.f337200l.reset();
    }

    private static long c(byte[] bArr, int i3, int i16) {
        if (bArr.length < i16) {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long j3 = 0;
        for (int i17 = 0; i17 < i16; i17++) {
            j3 += (bArr[i17 + i3] & 255) << (((i16 - 1) - i17) * 8);
        }
        return j3;
    }

    private void b(byte b16) {
        boolean z16 = (b16 & 128) == 128;
        this.f337192d = z16;
        int i3 = b16 & Byte.MAX_VALUE;
        this.f337195g = i3;
        if (i3 <= 125) {
            this.f337190b = z16 ? 3 : 4;
        } else {
            this.f337194f = i3 == 126 ? 2 : 8;
            this.f337190b = 2;
        }
    }

    public void a(int i3, String str) {
        if (this.f337199k) {
            return;
        }
        this.f337189a.a(a(str, 8, i3));
        this.f337199k = true;
    }

    private byte[] b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void a(a aVar) throws IOException {
        while (aVar.available() != -1) {
            int i3 = this.f337190b;
            if (i3 == 0) {
                a(aVar.readByte());
            } else if (i3 == 1) {
                b(aVar.readByte());
            } else if (i3 == 2) {
                a(aVar.a(this.f337194f));
            } else if (i3 == 3) {
                this.f337197i = aVar.a(4);
                this.f337190b = 4;
            } else if (i3 == 4) {
                this.f337198j = aVar.a(this.f337195g);
                a();
                this.f337190b = 0;
            }
        }
        this.f337189a.d().b(0, "EOF");
    }

    private void a(byte[] bArr) throws C9225b {
        this.f337195g = c(bArr);
        this.f337190b = this.f337192d ? 3 : 4;
    }

    private static byte[] b(byte[] bArr, int i3, int i16) {
        if (i3 > i16) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i3 < 0 || i3 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i17 = i16 - i3;
        int min = Math.min(i17, length - i3);
        byte[] bArr2 = new byte[i17];
        System.arraycopy(bArr, i3, bArr2, 0, min);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(Object obj, int i3, int i16) {
        int i17;
        int i18;
        if (this.f337199k) {
            return null;
        }
        Log.d("HybiParser", "Creating frame for: " + obj + " op: " + i3 + " err: " + i16);
        byte[] b16 = obj instanceof String ? b((String) obj) : (byte[]) obj;
        int i19 = i16 > 0 ? 2 : 0;
        int length = b16.length + i19;
        int i26 = length <= 125 ? 2 : length <= 65535 ? 4 : 10;
        int i27 = i26 + 4;
        byte[] bArr = new byte[length + i27];
        bArr[0] = (byte) (((byte) i3) | Byte.MIN_VALUE);
        if (length <= 125) {
            bArr[1] = (byte) (length | 128);
        } else {
            if (length > 65535) {
                bArr[1] = (byte) 255;
                double d16 = length;
                i17 = i26;
                bArr[2] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 56.0d))) & 255);
                bArr[3] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 48.0d))) & 255);
                bArr[4] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 40.0d))) & 255);
                bArr[5] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 32.0d))) & 255);
                bArr[6] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 24.0d))) & 255);
                bArr[7] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 16.0d))) & 255);
                bArr[8] = (byte) (((int) Math.floor(d16 / Math.pow(2.0d, 8.0d))) & 255);
                bArr[9] = (byte) (length & 255);
                i18 = i16;
                if (i18 > 0) {
                    bArr[i27] = (byte) (((int) Math.floor(i18 / 256.0f)) & 255);
                    bArr[i27 + 1] = (byte) (i18 & 255);
                }
                System.arraycopy(b16, 0, bArr, i19 + i27, b16.length);
                byte[] bArr2 = {(byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d)};
                System.arraycopy(bArr2, 0, bArr, i17, 4);
                a(bArr, bArr2, i27);
                return bArr;
            }
            bArr[1] = (byte) 254;
            bArr[2] = (byte) Math.floor(length / 256.0f);
            bArr[3] = (byte) (length & 255);
        }
        i18 = i16;
        i17 = i26;
        if (i18 > 0) {
        }
        System.arraycopy(b16, 0, bArr, i19 + i27, b16.length);
        byte[] bArr22 = {(byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d)};
        System.arraycopy(bArr22, 0, bArr, i17, 4);
        a(bArr, bArr22, i27);
        return bArr;
    }

    public byte[] a(String str) {
        return a(str, 1, -1);
    }

    private byte[] a(String str, int i3, int i16) {
        return a((Object) str, i3, i16);
    }

    private byte[] a(byte[] bArr, int i3) {
        return b(bArr, i3, bArr.length);
    }

    private byte[] a(byte[] bArr, int i3, int i16) {
        return a((Object) bArr, i3, i16);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, int i3) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i16 = 0; i16 < bArr.length - i3; i16++) {
            int i17 = i3 + i16;
            bArr[i17] = (byte) (bArr[i17] ^ bArr2[i16 % 4]);
        }
        return bArr;
    }
}

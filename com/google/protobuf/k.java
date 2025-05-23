package com.google.protobuf;

import com.google.protobuf.au;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    int f35865a;

    /* renamed from: b, reason: collision with root package name */
    int f35866b;

    /* renamed from: c, reason: collision with root package name */
    int f35867c;

    /* renamed from: d, reason: collision with root package name */
    l f35868d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f35869e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends k {

        /* renamed from: f, reason: collision with root package name */
        private final byte[] f35870f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f35871g;

        /* renamed from: h, reason: collision with root package name */
        private int f35872h;

        /* renamed from: i, reason: collision with root package name */
        private int f35873i;

        /* renamed from: j, reason: collision with root package name */
        private int f35874j;

        /* renamed from: k, reason: collision with root package name */
        private int f35875k;

        /* renamed from: l, reason: collision with root package name */
        private int f35876l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f35877m;

        /* renamed from: n, reason: collision with root package name */
        private int f35878n;

        private void U() {
            int i3 = this.f35872h + this.f35873i;
            this.f35872h = i3;
            int i16 = i3 - this.f35875k;
            int i17 = this.f35878n;
            if (i16 > i17) {
                int i18 = i16 - i17;
                this.f35873i = i18;
                this.f35872h = i3 - i18;
                return;
            }
            this.f35873i = 0;
        }

        private void X() throws IOException {
            if (this.f35872h - this.f35874j >= 10) {
                Y();
            } else {
                Z();
            }
        }

        private void Y() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.f35870f;
                int i16 = this.f35874j;
                this.f35874j = i16 + 1;
                if (bArr[i16] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void Z() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (O() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.k
        public void A(au.a aVar, t tVar) throws IOException {
            int B = B();
            if (this.f35865a < this.f35866b) {
                int o16 = o(B);
                this.f35865a++;
                aVar.mergeFrom(this, tVar);
                a(0);
                this.f35865a--;
                n(o16);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int B() throws IOException {
            int i3;
            int i16 = this.f35874j;
            int i17 = this.f35872h;
            if (i17 != i16) {
                byte[] bArr = this.f35870f;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f35874j = i18;
                    return b16;
                }
                if (i17 - i18 >= 9) {
                    int i19 = i18 + 1;
                    int i26 = b16 ^ (bArr[i18] << 7);
                    if (i26 < 0) {
                        i3 = i26 ^ (-128);
                    } else {
                        int i27 = i19 + 1;
                        int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                        if (i28 >= 0) {
                            i3 = i28 ^ 16256;
                        } else {
                            i19 = i27 + 1;
                            int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                            if (i29 < 0) {
                                i3 = i29 ^ (-2080896);
                            } else {
                                i27 = i19 + 1;
                                byte b17 = bArr[i19];
                                i3 = (i29 ^ (b17 << 28)) ^ 266354560;
                                if (b17 < 0) {
                                    i19 = i27 + 1;
                                    if (bArr[i27] < 0) {
                                        i27 = i19 + 1;
                                        if (bArr[i19] < 0) {
                                            i19 = i27 + 1;
                                            if (bArr[i27] < 0) {
                                                i27 = i19 + 1;
                                                if (bArr[i19] < 0) {
                                                    i19 = i27 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i19 = i27;
                    }
                    this.f35874j = i19;
                    return i3;
                }
            }
            return (int) T();
        }

        @Override // com.google.protobuf.k
        public int D() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.k
        public long E() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.k
        public int F() throws IOException {
            return k.b(B());
        }

        @Override // com.google.protobuf.k
        public long G() throws IOException {
            return k.c(S());
        }

        @Override // com.google.protobuf.k
        public String H() throws IOException {
            int B = B();
            if (B > 0) {
                int i3 = this.f35872h;
                int i16 = this.f35874j;
                if (B <= i3 - i16) {
                    String str = new String(this.f35870f, i16, B, ad.f35640a);
                    this.f35874j += B;
                    return str;
                }
            }
            if (B == 0) {
                return "";
            }
            if (B < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.k
        public String I() throws IOException {
            int B = B();
            if (B > 0) {
                int i3 = this.f35872h;
                int i16 = this.f35874j;
                if (B <= i3 - i16) {
                    String h16 = Utf8.h(this.f35870f, i16, B);
                    this.f35874j += B;
                    return h16;
                }
            }
            if (B == 0) {
                return "";
            }
            if (B <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.k
        public int J() throws IOException {
            if (f()) {
                this.f35876l = 0;
                return 0;
            }
            int B = B();
            this.f35876l = B;
            if (WireFormat.a(B) != 0) {
                return this.f35876l;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.k
        public int K() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public long L() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.k
        public boolean N(int i3) throws IOException {
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 != 4) {
                                if (b16 == 5) {
                                    W(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.invalidWireType();
                            }
                            return false;
                        }
                        V();
                        a(WireFormat.c(WireFormat.a(i3), 4));
                        return true;
                    }
                    W(B());
                    return true;
                }
                W(8);
                return true;
            }
            X();
            return true;
        }

        public byte O() throws IOException {
            int i3 = this.f35874j;
            if (i3 != this.f35872h) {
                byte[] bArr = this.f35870f;
                this.f35874j = i3 + 1;
                return bArr[i3];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] P(int i3) throws IOException {
            if (i3 > 0) {
                int i16 = this.f35872h;
                int i17 = this.f35874j;
                if (i3 <= i16 - i17) {
                    int i18 = i3 + i17;
                    this.f35874j = i18;
                    return Arrays.copyOfRange(this.f35870f, i17, i18);
                }
            }
            if (i3 <= 0) {
                if (i3 == 0) {
                    return ad.f35642c;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int Q() throws IOException {
            int i3 = this.f35874j;
            if (this.f35872h - i3 >= 4) {
                byte[] bArr = this.f35870f;
                this.f35874j = i3 + 4;
                return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long R() throws IOException {
            int i3 = this.f35874j;
            if (this.f35872h - i3 >= 8) {
                byte[] bArr = this.f35870f;
                this.f35874j = i3 + 8;
                return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long S() throws IOException {
            long j3;
            long j16;
            long j17;
            int i3;
            int i16 = this.f35874j;
            int i17 = this.f35872h;
            if (i17 != i16) {
                byte[] bArr = this.f35870f;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f35874j = i18;
                    return b16;
                }
                if (i17 - i18 >= 9) {
                    int i19 = i18 + 1;
                    int i26 = b16 ^ (bArr[i18] << 7);
                    if (i26 < 0) {
                        i3 = i26 ^ (-128);
                    } else {
                        int i27 = i19 + 1;
                        int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                        if (i28 >= 0) {
                            i19 = i27;
                            j3 = i28 ^ 16256;
                        } else {
                            i19 = i27 + 1;
                            int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                            if (i29 < 0) {
                                i3 = i29 ^ (-2080896);
                            } else {
                                long j18 = i29;
                                int i36 = i19 + 1;
                                long j19 = j18 ^ (bArr[i19] << 28);
                                if (j19 >= 0) {
                                    j17 = 266354560;
                                } else {
                                    i19 = i36 + 1;
                                    long j26 = j19 ^ (bArr[i36] << 35);
                                    if (j26 < 0) {
                                        j16 = -34093383808L;
                                    } else {
                                        i36 = i19 + 1;
                                        j19 = j26 ^ (bArr[i19] << 42);
                                        if (j19 >= 0) {
                                            j17 = 4363953127296L;
                                        } else {
                                            i19 = i36 + 1;
                                            j26 = j19 ^ (bArr[i36] << 49);
                                            if (j26 < 0) {
                                                j16 = -558586000294016L;
                                            } else {
                                                int i37 = i19 + 1;
                                                long j27 = (j26 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                                if (j27 < 0) {
                                                    i19 = i37 + 1;
                                                } else {
                                                    i19 = i37;
                                                }
                                                j3 = j27;
                                            }
                                        }
                                    }
                                    j3 = j26 ^ j16;
                                }
                                j3 = j19 ^ j17;
                                i19 = i36;
                            }
                        }
                        this.f35874j = i19;
                        return j3;
                    }
                    j3 = i3;
                    this.f35874j = i19;
                    return j3;
                }
            }
            return T();
        }

        long T() throws IOException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Byte.MAX_VALUE) << i3;
                if ((O() & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void V() throws IOException {
            int J;
            do {
                J = J();
                if (J == 0) {
                    return;
                }
            } while (N(J));
        }

        public void W(int i3) throws IOException {
            if (i3 >= 0) {
                int i16 = this.f35872h;
                int i17 = this.f35874j;
                if (i3 <= i16 - i17) {
                    this.f35874j = i17 + i3;
                    return;
                }
            }
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.k
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f35876l == i3) {
            } else {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.k
        public int d() {
            int i3 = this.f35878n;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - e();
        }

        @Override // com.google.protobuf.k
        public int e() {
            return this.f35874j - this.f35875k;
        }

        @Override // com.google.protobuf.k
        public boolean f() throws IOException {
            if (this.f35874j == this.f35872h) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.k
        public void n(int i3) {
            this.f35878n = i3;
            U();
        }

        @Override // com.google.protobuf.k
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0) {
                int e16 = i3 + e();
                int i16 = this.f35878n;
                if (e16 <= i16) {
                    this.f35878n = e16;
                    U();
                    return i16;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.k
        public boolean p() throws IOException {
            if (S() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.k
        public ByteString q() throws IOException {
            ByteString copyFrom;
            int B = B();
            if (B > 0) {
                int i3 = this.f35872h;
                int i16 = this.f35874j;
                if (B <= i3 - i16) {
                    if (this.f35871g && this.f35877m) {
                        copyFrom = ByteString.wrap(this.f35870f, i16, B);
                    } else {
                        copyFrom = ByteString.copyFrom(this.f35870f, i16, B);
                    }
                    this.f35874j += B;
                    return copyFrom;
                }
            }
            if (B == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(P(B));
        }

        @Override // com.google.protobuf.k
        public double r() throws IOException {
            return Double.longBitsToDouble(R());
        }

        @Override // com.google.protobuf.k
        public int s() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public int t() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.k
        public long u() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.k
        public float v() throws IOException {
            return Float.intBitsToFloat(Q());
        }

        @Override // com.google.protobuf.k
        public void w(int i3, au.a aVar, t tVar) throws IOException {
            int i16 = this.f35865a;
            if (i16 < this.f35866b) {
                this.f35865a = i16 + 1;
                aVar.mergeFrom(this, tVar);
                a(WireFormat.c(i3, 4));
                this.f35865a--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.k
        public int x() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public long y() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.k
        public <T extends au> T z(bg<T> bgVar, t tVar) throws IOException {
            int B = B();
            if (this.f35865a < this.f35866b) {
                int o16 = o(B);
                this.f35865a++;
                T g16 = bgVar.g(this, tVar);
                a(0);
                this.f35865a--;
                n(o16);
                return g16;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        b(byte[] bArr, int i3, int i16, boolean z16) {
            super();
            this.f35878n = Integer.MAX_VALUE;
            this.f35870f = bArr;
            this.f35872h = i16 + i3;
            this.f35874j = i3;
            this.f35875k = i3;
            this.f35871g = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c extends k {

        /* renamed from: f, reason: collision with root package name */
        private final InputStream f35879f;

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f35880g;

        /* renamed from: h, reason: collision with root package name */
        private int f35881h;

        /* renamed from: i, reason: collision with root package name */
        private int f35882i;

        /* renamed from: j, reason: collision with root package name */
        private int f35883j;

        /* renamed from: k, reason: collision with root package name */
        private int f35884k;

        /* renamed from: l, reason: collision with root package name */
        private int f35885l;

        /* renamed from: m, reason: collision with root package name */
        private int f35886m;

        private ByteString O(int i3) throws IOException {
            byte[] R = R(i3);
            if (R != null) {
                return ByteString.copyFrom(R);
            }
            int i16 = this.f35883j;
            int i17 = this.f35881h;
            int i18 = i17 - i16;
            this.f35885l += i17;
            this.f35883j = 0;
            this.f35881h = 0;
            List<byte[]> S = S(i3 - i18);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f35880g, i16, bArr, 0, i18);
            for (byte[] bArr2 : S) {
                System.arraycopy(bArr2, 0, bArr, i18, bArr2.length);
                i18 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] Q(int i3, boolean z16) throws IOException {
            byte[] R = R(i3);
            if (R != null) {
                if (z16) {
                    return (byte[]) R.clone();
                }
                return R;
            }
            int i16 = this.f35883j;
            int i17 = this.f35881h;
            int i18 = i17 - i16;
            this.f35885l += i17;
            this.f35883j = 0;
            this.f35881h = 0;
            List<byte[]> S = S(i3 - i18);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f35880g, i16, bArr, 0, i18);
            for (byte[] bArr2 : S) {
                System.arraycopy(bArr2, 0, bArr, i18, bArr2.length);
                i18 += bArr2.length;
            }
            return bArr;
        }

        private byte[] R(int i3) throws IOException {
            if (i3 == 0) {
                return ad.f35642c;
            }
            if (i3 >= 0) {
                int i16 = this.f35885l;
                int i17 = this.f35883j;
                int i18 = i16 + i17 + i3;
                if (i18 - this.f35867c <= 0) {
                    int i19 = this.f35886m;
                    if (i18 <= i19) {
                        int i26 = this.f35881h - i17;
                        int i27 = i3 - i26;
                        if (i27 >= 4096 && i27 > this.f35879f.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i3];
                        System.arraycopy(this.f35880g, this.f35883j, bArr, 0, i26);
                        this.f35885l += this.f35881h;
                        this.f35883j = 0;
                        this.f35881h = 0;
                        while (i26 < i3) {
                            int read = this.f35879f.read(bArr, i26, i3 - i26);
                            if (read != -1) {
                                this.f35885l += read;
                                i26 += read;
                            } else {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    a0((i19 - i16) - i17);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private List<byte[]> S(int i3) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i3 > 0) {
                int min = Math.min(i3, 4096);
                byte[] bArr = new byte[min];
                int i16 = 0;
                while (i16 < min) {
                    int read = this.f35879f.read(bArr, i16, min - i16);
                    if (read != -1) {
                        this.f35885l += read;
                        i16 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i3 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void X() {
            int i3 = this.f35881h + this.f35882i;
            this.f35881h = i3;
            int i16 = this.f35885l + i3;
            int i17 = this.f35886m;
            if (i16 > i17) {
                int i18 = i16 - i17;
                this.f35882i = i18;
                this.f35881h = i3 - i18;
                return;
            }
            this.f35882i = 0;
        }

        private void Y(int i3) throws IOException {
            if (!f0(i3)) {
                if (i3 > (this.f35867c - this.f35885l) - this.f35883j) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void b0(int i3) throws IOException {
            if (i3 >= 0) {
                int i16 = this.f35885l;
                int i17 = this.f35883j;
                int i18 = i16 + i17 + i3;
                int i19 = this.f35886m;
                if (i18 <= i19) {
                    this.f35885l = i16 + i17;
                    int i26 = this.f35881h - i17;
                    this.f35881h = 0;
                    this.f35883j = 0;
                    while (i26 < i3) {
                        try {
                            long j3 = i3 - i26;
                            long skip = this.f35879f.skip(j3);
                            if (skip >= 0 && skip <= j3) {
                                if (skip == 0) {
                                    break;
                                } else {
                                    i26 += (int) skip;
                                }
                            } else {
                                throw new IllegalStateException(this.f35879f.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                            }
                        } finally {
                            this.f35885l += i26;
                            X();
                        }
                    }
                    if (i26 < i3) {
                        int i27 = this.f35881h;
                        int i28 = i27 - this.f35883j;
                        this.f35883j = i27;
                        Y(1);
                        while (true) {
                            int i29 = i3 - i28;
                            int i36 = this.f35881h;
                            if (i29 > i36) {
                                i28 += i36;
                                this.f35883j = i36;
                                Y(1);
                            } else {
                                this.f35883j = i29;
                                return;
                            }
                        }
                    }
                } else {
                    a0((i19 - i16) - i17);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private void c0() throws IOException {
            if (this.f35881h - this.f35883j >= 10) {
                d0();
            } else {
                e0();
            }
        }

        private void d0() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.f35880g;
                int i16 = this.f35883j;
                this.f35883j = i16 + 1;
                if (bArr[i16] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void e0() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (P() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean f0(int i3) throws IOException {
            int i16 = this.f35883j;
            int i17 = i16 + i3;
            int i18 = this.f35881h;
            if (i17 > i18) {
                int i19 = this.f35867c;
                int i26 = this.f35885l;
                if (i3 > (i19 - i26) - i16 || i26 + i16 + i3 > this.f35886m) {
                    return false;
                }
                if (i16 > 0) {
                    if (i18 > i16) {
                        byte[] bArr = this.f35880g;
                        System.arraycopy(bArr, i16, bArr, 0, i18 - i16);
                    }
                    this.f35885l += i16;
                    this.f35881h -= i16;
                    this.f35883j = 0;
                }
                InputStream inputStream = this.f35879f;
                byte[] bArr2 = this.f35880g;
                int i27 = this.f35881h;
                int read = inputStream.read(bArr2, i27, Math.min(bArr2.length - i27, (this.f35867c - this.f35885l) - i27));
                if (read != 0 && read >= -1 && read <= this.f35880g.length) {
                    if (read <= 0) {
                        return false;
                    }
                    this.f35881h += read;
                    X();
                    if (this.f35881h >= i3) {
                        return true;
                    }
                    return f0(i3);
                }
                throw new IllegalStateException(this.f35879f.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.k
        public void A(au.a aVar, t tVar) throws IOException {
            int B = B();
            if (this.f35865a < this.f35866b) {
                int o16 = o(B);
                this.f35865a++;
                aVar.mergeFrom(this, tVar);
                a(0);
                this.f35865a--;
                n(o16);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int B() throws IOException {
            int i3;
            int i16 = this.f35883j;
            int i17 = this.f35881h;
            if (i17 != i16) {
                byte[] bArr = this.f35880g;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f35883j = i18;
                    return b16;
                }
                if (i17 - i18 >= 9) {
                    int i19 = i18 + 1;
                    int i26 = b16 ^ (bArr[i18] << 7);
                    if (i26 < 0) {
                        i3 = i26 ^ (-128);
                    } else {
                        int i27 = i19 + 1;
                        int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                        if (i28 >= 0) {
                            i3 = i28 ^ 16256;
                        } else {
                            i19 = i27 + 1;
                            int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                            if (i29 < 0) {
                                i3 = i29 ^ (-2080896);
                            } else {
                                i27 = i19 + 1;
                                byte b17 = bArr[i19];
                                i3 = (i29 ^ (b17 << 28)) ^ 266354560;
                                if (b17 < 0) {
                                    i19 = i27 + 1;
                                    if (bArr[i27] < 0) {
                                        i27 = i19 + 1;
                                        if (bArr[i19] < 0) {
                                            i19 = i27 + 1;
                                            if (bArr[i27] < 0) {
                                                i27 = i19 + 1;
                                                if (bArr[i19] < 0) {
                                                    i19 = i27 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i19 = i27;
                    }
                    this.f35883j = i19;
                    return i3;
                }
            }
            return (int) W();
        }

        @Override // com.google.protobuf.k
        public int D() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.k
        public long E() throws IOException {
            return U();
        }

        @Override // com.google.protobuf.k
        public int F() throws IOException {
            return k.b(B());
        }

        @Override // com.google.protobuf.k
        public long G() throws IOException {
            return k.c(V());
        }

        @Override // com.google.protobuf.k
        public String H() throws IOException {
            int B = B();
            if (B > 0) {
                int i3 = this.f35881h;
                int i16 = this.f35883j;
                if (B <= i3 - i16) {
                    String str = new String(this.f35880g, i16, B, ad.f35640a);
                    this.f35883j += B;
                    return str;
                }
            }
            if (B == 0) {
                return "";
            }
            if (B <= this.f35881h) {
                Y(B);
                String str2 = new String(this.f35880g, this.f35883j, B, ad.f35640a);
                this.f35883j += B;
                return str2;
            }
            return new String(Q(B, false), ad.f35640a);
        }

        @Override // com.google.protobuf.k
        public String I() throws IOException {
            byte[] Q;
            int B = B();
            int i3 = this.f35883j;
            int i16 = this.f35881h;
            if (B <= i16 - i3 && B > 0) {
                Q = this.f35880g;
                this.f35883j = i3 + B;
            } else {
                if (B == 0) {
                    return "";
                }
                i3 = 0;
                if (B <= i16) {
                    Y(B);
                    Q = this.f35880g;
                    this.f35883j = B + 0;
                } else {
                    Q = Q(B, false);
                }
            }
            return Utf8.h(Q, i3, B);
        }

        @Override // com.google.protobuf.k
        public int J() throws IOException {
            if (f()) {
                this.f35884k = 0;
                return 0;
            }
            int B = B();
            this.f35884k = B;
            if (WireFormat.a(B) != 0) {
                return this.f35884k;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.k
        public int K() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public long L() throws IOException {
            return V();
        }

        @Override // com.google.protobuf.k
        public boolean N(int i3) throws IOException {
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 != 4) {
                                if (b16 == 5) {
                                    a0(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.invalidWireType();
                            }
                            return false;
                        }
                        Z();
                        a(WireFormat.c(WireFormat.a(i3), 4));
                        return true;
                    }
                    a0(B());
                    return true;
                }
                a0(8);
                return true;
            }
            c0();
            return true;
        }

        public byte P() throws IOException {
            if (this.f35883j == this.f35881h) {
                Y(1);
            }
            byte[] bArr = this.f35880g;
            int i3 = this.f35883j;
            this.f35883j = i3 + 1;
            return bArr[i3];
        }

        public int T() throws IOException {
            int i3 = this.f35883j;
            if (this.f35881h - i3 < 4) {
                Y(4);
                i3 = this.f35883j;
            }
            byte[] bArr = this.f35880g;
            this.f35883j = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        public long U() throws IOException {
            int i3 = this.f35883j;
            if (this.f35881h - i3 < 8) {
                Y(8);
                i3 = this.f35883j;
            }
            byte[] bArr = this.f35880g;
            this.f35883j = i3 + 8;
            return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long V() throws IOException {
            long j3;
            long j16;
            long j17;
            int i3;
            int i16 = this.f35883j;
            int i17 = this.f35881h;
            if (i17 != i16) {
                byte[] bArr = this.f35880g;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f35883j = i18;
                    return b16;
                }
                if (i17 - i18 >= 9) {
                    int i19 = i18 + 1;
                    int i26 = b16 ^ (bArr[i18] << 7);
                    if (i26 < 0) {
                        i3 = i26 ^ (-128);
                    } else {
                        int i27 = i19 + 1;
                        int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                        if (i28 >= 0) {
                            i19 = i27;
                            j3 = i28 ^ 16256;
                        } else {
                            i19 = i27 + 1;
                            int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                            if (i29 < 0) {
                                i3 = i29 ^ (-2080896);
                            } else {
                                long j18 = i29;
                                int i36 = i19 + 1;
                                long j19 = j18 ^ (bArr[i19] << 28);
                                if (j19 >= 0) {
                                    j17 = 266354560;
                                } else {
                                    i19 = i36 + 1;
                                    long j26 = j19 ^ (bArr[i36] << 35);
                                    if (j26 < 0) {
                                        j16 = -34093383808L;
                                    } else {
                                        i36 = i19 + 1;
                                        j19 = j26 ^ (bArr[i19] << 42);
                                        if (j19 >= 0) {
                                            j17 = 4363953127296L;
                                        } else {
                                            i19 = i36 + 1;
                                            j26 = j19 ^ (bArr[i36] << 49);
                                            if (j26 < 0) {
                                                j16 = -558586000294016L;
                                            } else {
                                                int i37 = i19 + 1;
                                                long j27 = (j26 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                                if (j27 < 0) {
                                                    i19 = i37 + 1;
                                                } else {
                                                    i19 = i37;
                                                }
                                                j3 = j27;
                                            }
                                        }
                                    }
                                    j3 = j26 ^ j16;
                                }
                                j3 = j19 ^ j17;
                                i19 = i36;
                            }
                        }
                        this.f35883j = i19;
                        return j3;
                    }
                    j3 = i3;
                    this.f35883j = i19;
                    return j3;
                }
            }
            return W();
        }

        long W() throws IOException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Byte.MAX_VALUE) << i3;
                if ((P() & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void Z() throws IOException {
            int J;
            do {
                J = J();
                if (J == 0) {
                    return;
                }
            } while (N(J));
        }

        @Override // com.google.protobuf.k
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f35884k == i3) {
            } else {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void a0(int i3) throws IOException {
            int i16 = this.f35881h;
            int i17 = this.f35883j;
            if (i3 <= i16 - i17 && i3 >= 0) {
                this.f35883j = i17 + i3;
            } else {
                b0(i3);
            }
        }

        @Override // com.google.protobuf.k
        public int d() {
            int i3 = this.f35886m;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - (this.f35885l + this.f35883j);
        }

        @Override // com.google.protobuf.k
        public int e() {
            return this.f35885l + this.f35883j;
        }

        @Override // com.google.protobuf.k
        public boolean f() throws IOException {
            if (this.f35883j == this.f35881h && !f0(1)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.k
        public void n(int i3) {
            this.f35886m = i3;
            X();
        }

        @Override // com.google.protobuf.k
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0) {
                int i16 = i3 + this.f35885l + this.f35883j;
                int i17 = this.f35886m;
                if (i16 <= i17) {
                    this.f35886m = i16;
                    X();
                    return i17;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.k
        public boolean p() throws IOException {
            if (V() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.k
        public ByteString q() throws IOException {
            int B = B();
            int i3 = this.f35881h;
            int i16 = this.f35883j;
            if (B <= i3 - i16 && B > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f35880g, i16, B);
                this.f35883j += B;
                return copyFrom;
            }
            if (B == 0) {
                return ByteString.EMPTY;
            }
            return O(B);
        }

        @Override // com.google.protobuf.k
        public double r() throws IOException {
            return Double.longBitsToDouble(U());
        }

        @Override // com.google.protobuf.k
        public int s() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public int t() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.k
        public long u() throws IOException {
            return U();
        }

        @Override // com.google.protobuf.k
        public float v() throws IOException {
            return Float.intBitsToFloat(T());
        }

        @Override // com.google.protobuf.k
        public void w(int i3, au.a aVar, t tVar) throws IOException {
            int i16 = this.f35865a;
            if (i16 < this.f35866b) {
                this.f35865a = i16 + 1;
                aVar.mergeFrom(this, tVar);
                a(WireFormat.c(i3, 4));
                this.f35865a--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.k
        public int x() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public long y() throws IOException {
            return V();
        }

        @Override // com.google.protobuf.k
        public <T extends au> T z(bg<T> bgVar, t tVar) throws IOException {
            int B = B();
            if (this.f35865a < this.f35866b) {
                int o16 = o(B);
                this.f35865a++;
                T g16 = bgVar.g(this, tVar);
                a(0);
                this.f35865a--;
                n(o16);
                return g16;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        c(InputStream inputStream, int i3) {
            super();
            this.f35886m = Integer.MAX_VALUE;
            ad.b(inputStream, "input");
            this.f35879f = inputStream;
            this.f35880g = new byte[i3];
            this.f35881h = 0;
            this.f35883j = 0;
            this.f35885l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d extends k {

        /* renamed from: f, reason: collision with root package name */
        private final ByteBuffer f35887f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f35888g;

        /* renamed from: h, reason: collision with root package name */
        private final long f35889h;

        /* renamed from: i, reason: collision with root package name */
        private long f35890i;

        /* renamed from: j, reason: collision with root package name */
        private long f35891j;

        /* renamed from: k, reason: collision with root package name */
        private long f35892k;

        /* renamed from: l, reason: collision with root package name */
        private int f35893l;

        /* renamed from: m, reason: collision with root package name */
        private int f35894m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f35895n;

        /* renamed from: o, reason: collision with root package name */
        private int f35896o;

        private int O(long j3) {
            return (int) (j3 - this.f35889h);
        }

        static boolean P() {
            return ch.I();
        }

        private void V() {
            long j3 = this.f35890i + this.f35893l;
            this.f35890i = j3;
            int i3 = (int) (j3 - this.f35892k);
            int i16 = this.f35896o;
            if (i3 > i16) {
                int i17 = i3 - i16;
                this.f35893l = i17;
                this.f35890i = j3 - i17;
                return;
            }
            this.f35893l = 0;
        }

        private int W() {
            return (int) (this.f35890i - this.f35891j);
        }

        private void Z() throws IOException {
            if (W() >= 10) {
                a0();
            } else {
                b0();
            }
        }

        private void a0() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                long j3 = this.f35891j;
                this.f35891j = 1 + j3;
                if (ch.u(j3) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void b0() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (Q() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer c0(long j3, long j16) throws IOException {
            int position = this.f35887f.position();
            int limit = this.f35887f.limit();
            try {
                try {
                    this.f35887f.position(O(j3));
                    this.f35887f.limit(O(j16));
                    return this.f35887f.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                this.f35887f.position(position);
                this.f35887f.limit(limit);
            }
        }

        @Override // com.google.protobuf.k
        public void A(au.a aVar, t tVar) throws IOException {
            int B = B();
            if (this.f35865a < this.f35866b) {
                int o16 = o(B);
                this.f35865a++;
                aVar.mergeFrom(this, tVar);
                a(0);
                this.f35865a--;
                n(o16);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        
            if (com.google.protobuf.ch.u(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int B() throws IOException {
            int i3;
            long j3 = this.f35891j;
            if (this.f35890i != j3) {
                long j16 = j3 + 1;
                byte u16 = ch.u(j3);
                if (u16 >= 0) {
                    this.f35891j = j16;
                    return u16;
                }
                if (this.f35890i - j16 >= 9) {
                    long j17 = j16 + 1;
                    int u17 = u16 ^ (ch.u(j16) << 7);
                    if (u17 < 0) {
                        i3 = u17 ^ (-128);
                    } else {
                        long j18 = j17 + 1;
                        int u18 = u17 ^ (ch.u(j17) << RegisterType.DOUBLE_LO);
                        if (u18 >= 0) {
                            i3 = u18 ^ 16256;
                        } else {
                            j17 = j18 + 1;
                            int u19 = u18 ^ (ch.u(j18) << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                            if (u19 < 0) {
                                i3 = u19 ^ (-2080896);
                            } else {
                                j18 = j17 + 1;
                                byte u26 = ch.u(j17);
                                i3 = (u19 ^ (u26 << 28)) ^ 266354560;
                                if (u26 < 0) {
                                    j17 = j18 + 1;
                                    if (ch.u(j18) < 0) {
                                        j18 = j17 + 1;
                                        if (ch.u(j17) < 0) {
                                            j17 = j18 + 1;
                                            if (ch.u(j18) < 0) {
                                                j18 = j17 + 1;
                                                if (ch.u(j17) < 0) {
                                                    j17 = j18 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j17 = j18;
                    }
                    this.f35891j = j17;
                    return i3;
                }
            }
            return (int) U();
        }

        @Override // com.google.protobuf.k
        public int D() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.k
        public long E() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.k
        public int F() throws IOException {
            return k.b(B());
        }

        @Override // com.google.protobuf.k
        public long G() throws IOException {
            return k.c(T());
        }

        @Override // com.google.protobuf.k
        public String H() throws IOException {
            int B = B();
            if (B > 0 && B <= W()) {
                byte[] bArr = new byte[B];
                long j3 = B;
                ch.n(this.f35891j, bArr, 0L, j3);
                String str = new String(bArr, ad.f35640a);
                this.f35891j += j3;
                return str;
            }
            if (B == 0) {
                return "";
            }
            if (B < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.k
        public String I() throws IOException {
            int B = B();
            if (B > 0 && B <= W()) {
                String g16 = Utf8.g(this.f35887f, O(this.f35891j), B);
                this.f35891j += B;
                return g16;
            }
            if (B == 0) {
                return "";
            }
            if (B <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.k
        public int J() throws IOException {
            if (f()) {
                this.f35894m = 0;
                return 0;
            }
            int B = B();
            this.f35894m = B;
            if (WireFormat.a(B) != 0) {
                return this.f35894m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.k
        public int K() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public long L() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.k
        public boolean N(int i3) throws IOException {
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 != 4) {
                                if (b16 == 5) {
                                    Y(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.invalidWireType();
                            }
                            return false;
                        }
                        X();
                        a(WireFormat.c(WireFormat.a(i3), 4));
                        return true;
                    }
                    Y(B());
                    return true;
                }
                Y(8);
                return true;
            }
            Z();
            return true;
        }

        public byte Q() throws IOException {
            long j3 = this.f35891j;
            if (j3 != this.f35890i) {
                this.f35891j = 1 + j3;
                return ch.u(j3);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int R() throws IOException {
            long j3 = this.f35891j;
            if (this.f35890i - j3 >= 4) {
                this.f35891j = 4 + j3;
                return ((ch.u(j3 + 3) & 255) << 24) | (ch.u(j3) & 255) | ((ch.u(1 + j3) & 255) << 8) | ((ch.u(2 + j3) & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long S() throws IOException {
            long j3 = this.f35891j;
            if (this.f35890i - j3 >= 8) {
                this.f35891j = 8 + j3;
                return ((ch.u(j3 + 7) & 255) << 56) | (ch.u(j3) & 255) | ((ch.u(1 + j3) & 255) << 8) | ((ch.u(2 + j3) & 255) << 16) | ((ch.u(3 + j3) & 255) << 24) | ((ch.u(4 + j3) & 255) << 32) | ((ch.u(5 + j3) & 255) << 40) | ((ch.u(6 + j3) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long T() throws IOException {
            long u16;
            long j3;
            long j16;
            int i3;
            long j17 = this.f35891j;
            if (this.f35890i != j17) {
                long j18 = j17 + 1;
                byte u17 = ch.u(j17);
                if (u17 >= 0) {
                    this.f35891j = j18;
                    return u17;
                }
                if (this.f35890i - j18 >= 9) {
                    long j19 = j18 + 1;
                    int u18 = u17 ^ (ch.u(j18) << 7);
                    if (u18 < 0) {
                        i3 = u18 ^ (-128);
                    } else {
                        long j26 = j19 + 1;
                        int u19 = u18 ^ (ch.u(j19) << RegisterType.DOUBLE_LO);
                        if (u19 >= 0) {
                            u16 = u19 ^ 16256;
                        } else {
                            j19 = j26 + 1;
                            int u26 = u19 ^ (ch.u(j26) << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                            if (u26 < 0) {
                                i3 = u26 ^ (-2080896);
                            } else {
                                j26 = j19 + 1;
                                long u27 = u26 ^ (ch.u(j19) << 28);
                                if (u27 >= 0) {
                                    j16 = 266354560;
                                } else {
                                    long j27 = j26 + 1;
                                    long u28 = u27 ^ (ch.u(j26) << 35);
                                    if (u28 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j26 = j27 + 1;
                                        u27 = u28 ^ (ch.u(j27) << 42);
                                        if (u27 >= 0) {
                                            j16 = 4363953127296L;
                                        } else {
                                            j27 = j26 + 1;
                                            u28 = u27 ^ (ch.u(j26) << 49);
                                            if (u28 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j26 = j27 + 1;
                                                u16 = (u28 ^ (ch.u(j27) << 56)) ^ 71499008037633920L;
                                                if (u16 < 0) {
                                                    long j28 = 1 + j26;
                                                    if (ch.u(j26) >= 0) {
                                                        j19 = j28;
                                                        this.f35891j = j19;
                                                        return u16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    u16 = u28 ^ j3;
                                    j19 = j27;
                                    this.f35891j = j19;
                                    return u16;
                                }
                                u16 = u27 ^ j16;
                            }
                        }
                        j19 = j26;
                        this.f35891j = j19;
                        return u16;
                    }
                    u16 = i3;
                    this.f35891j = j19;
                    return u16;
                }
            }
            return U();
        }

        long U() throws IOException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Byte.MAX_VALUE) << i3;
                if ((Q() & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void X() throws IOException {
            int J;
            do {
                J = J();
                if (J == 0) {
                    return;
                }
            } while (N(J));
        }

        public void Y(int i3) throws IOException {
            if (i3 >= 0 && i3 <= W()) {
                this.f35891j += i3;
            } else {
                if (i3 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.k
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f35894m == i3) {
            } else {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.k
        public int d() {
            int i3 = this.f35896o;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - e();
        }

        @Override // com.google.protobuf.k
        public int e() {
            return (int) (this.f35891j - this.f35892k);
        }

        @Override // com.google.protobuf.k
        public boolean f() throws IOException {
            if (this.f35891j == this.f35890i) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.k
        public void n(int i3) {
            this.f35896o = i3;
            V();
        }

        @Override // com.google.protobuf.k
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0) {
                int e16 = i3 + e();
                int i16 = this.f35896o;
                if (e16 <= i16) {
                    this.f35896o = e16;
                    V();
                    return i16;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.k
        public boolean p() throws IOException {
            if (T() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.k
        public ByteString q() throws IOException {
            int B = B();
            if (B > 0 && B <= W()) {
                if (this.f35888g && this.f35895n) {
                    long j3 = this.f35891j;
                    long j16 = B;
                    ByteBuffer c06 = c0(j3, j3 + j16);
                    this.f35891j += j16;
                    return ByteString.wrap(c06);
                }
                byte[] bArr = new byte[B];
                long j17 = B;
                ch.n(this.f35891j, bArr, 0L, j17);
                this.f35891j += j17;
                return ByteString.wrap(bArr);
            }
            if (B == 0) {
                return ByteString.EMPTY;
            }
            if (B < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.k
        public double r() throws IOException {
            return Double.longBitsToDouble(S());
        }

        @Override // com.google.protobuf.k
        public int s() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public int t() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.k
        public long u() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.k
        public float v() throws IOException {
            return Float.intBitsToFloat(R());
        }

        @Override // com.google.protobuf.k
        public void w(int i3, au.a aVar, t tVar) throws IOException {
            int i16 = this.f35865a;
            if (i16 < this.f35866b) {
                this.f35865a = i16 + 1;
                aVar.mergeFrom(this, tVar);
                a(WireFormat.c(i3, 4));
                this.f35865a--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.k
        public int x() throws IOException {
            return B();
        }

        @Override // com.google.protobuf.k
        public long y() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.k
        public <T extends au> T z(bg<T> bgVar, t tVar) throws IOException {
            int B = B();
            if (this.f35865a < this.f35866b) {
                int o16 = o(B);
                this.f35865a++;
                T g16 = bgVar.g(this, tVar);
                a(0);
                this.f35865a--;
                n(o16);
                return g16;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        d(ByteBuffer byteBuffer, boolean z16) {
            super();
            this.f35896o = Integer.MAX_VALUE;
            this.f35887f = byteBuffer;
            long i3 = ch.i(byteBuffer);
            this.f35889h = i3;
            this.f35890i = byteBuffer.limit() + i3;
            long position = i3 + byteBuffer.position();
            this.f35891j = position;
            this.f35892k = position;
            this.f35888g = z16;
        }
    }

    public static int C(int i3, InputStream inputStream) throws IOException {
        if ((i3 & 128) == 0) {
            return i3;
        }
        int i16 = i3 & 127;
        int i17 = 7;
        while (i17 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i16 |= (read & 127) << i17;
                if ((read & 128) == 0) {
                    return i16;
                }
                i17 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        while (i17 < 64) {
            int read2 = inputStream.read();
            if (read2 != -1) {
                if ((read2 & 128) == 0) {
                    return i16;
                }
                i17 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public static int b(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long c(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    public static k g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static k h(InputStream inputStream, int i3) {
        if (i3 > 0) {
            if (inputStream == null) {
                return k(ad.f35642c);
            }
            return new c(inputStream, i3);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static k i(ByteBuffer byteBuffer) {
        return j(byteBuffer, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k j(ByteBuffer byteBuffer, boolean z16) {
        if (byteBuffer.hasArray()) {
            return m(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z16);
        }
        if (byteBuffer.isDirect() && d.P()) {
            return new d(byteBuffer, z16);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return m(bArr, 0, remaining, true);
    }

    public static k k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static k l(byte[] bArr, int i3, int i16) {
        return m(bArr, i3, i16, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k m(byte[] bArr, int i3, int i16, boolean z16) {
        b bVar = new b(bArr, i3, i16, z16);
        try {
            bVar.o(i16);
            return bVar;
        } catch (InvalidProtocolBufferException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public abstract void A(au.a aVar, t tVar) throws IOException;

    public abstract int B() throws IOException;

    public abstract int D() throws IOException;

    public abstract long E() throws IOException;

    public abstract int F() throws IOException;

    public abstract long G() throws IOException;

    public abstract String H() throws IOException;

    public abstract String I() throws IOException;

    public abstract int J() throws IOException;

    public abstract int K() throws IOException;

    public abstract long L() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean M() {
        return this.f35869e;
    }

    public abstract boolean N(int i3) throws IOException;

    public abstract void a(int i3) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract int e();

    public abstract boolean f() throws IOException;

    public abstract void n(int i3);

    public abstract int o(int i3) throws InvalidProtocolBufferException;

    public abstract boolean p() throws IOException;

    public abstract ByteString q() throws IOException;

    public abstract double r() throws IOException;

    public abstract int s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract float v() throws IOException;

    public abstract void w(int i3, au.a aVar, t tVar) throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public abstract <T extends au> T z(bg<T> bgVar, t tVar) throws IOException;

    k() {
        this.f35866b = 100;
        this.f35867c = Integer.MAX_VALUE;
        this.f35869e = false;
    }
}

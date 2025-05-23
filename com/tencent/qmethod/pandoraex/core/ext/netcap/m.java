package com.tencent.qmethod.pandoraex.core.ext.netcap;

import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.util.Arrays;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class m {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class b extends m {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f344102a;

        /* renamed from: b, reason: collision with root package name */
        private int f344103b;

        /* renamed from: c, reason: collision with root package name */
        private int f344104c;

        /* renamed from: d, reason: collision with root package name */
        private int f344105d;

        /* renamed from: e, reason: collision with root package name */
        private int f344106e;

        /* renamed from: f, reason: collision with root package name */
        private int f344107f;

        /* renamed from: g, reason: collision with root package name */
        private int f344108g;

        private int k() {
            return this.f344105d - this.f344106e;
        }

        private boolean l() throws IOException {
            if (this.f344105d == this.f344103b) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int m(int i3) throws PBInvalidProtocolBufferException {
            if (i3 >= 0) {
                int k3 = i3 + k();
                if (k3 >= 0) {
                    int i16 = this.f344108g;
                    if (k3 <= i16) {
                        this.f344108g = k3;
                        s();
                        return i16;
                    }
                    throw PBInvalidProtocolBufferException.truncatedMessage();
                }
                throw PBInvalidProtocolBufferException.parseFailure();
            }
            throw PBInvalidProtocolBufferException.negativeSize();
        }

        private byte n() throws IOException {
            int i3 = this.f344105d;
            if (i3 != this.f344103b) {
                byte[] bArr = this.f344102a;
                this.f344105d = i3 + 1;
                return bArr[i3];
            }
            throw PBInvalidProtocolBufferException.truncatedMessage();
        }

        private int o() throws IOException {
            int i3 = this.f344105d;
            if (this.f344103b - i3 >= 4) {
                byte[] bArr = this.f344102a;
                this.f344105d = i3 + 4;
                return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
            }
            throw PBInvalidProtocolBufferException.truncatedMessage();
        }

        private long p() throws IOException {
            int i3 = this.f344105d;
            if (this.f344103b - i3 >= 8) {
                byte[] bArr = this.f344102a;
                this.f344105d = i3 + 8;
                return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
            }
            throw PBInvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int q() throws IOException {
            int i3;
            int i16 = this.f344105d;
            int i17 = this.f344103b;
            if (i17 != i16) {
                byte[] bArr = this.f344102a;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f344105d = i18;
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
                    this.f344105d = i19;
                    return i3;
                }
            }
            return (int) r();
        }

        private long r() throws IOException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Byte.MAX_VALUE) << i3;
                if ((n() & 128) == 0) {
                    return j3;
                }
            }
            throw PBInvalidProtocolBufferException.malformedVarint();
        }

        private void s() {
            int i3 = this.f344103b + this.f344104c;
            this.f344103b = i3;
            int i16 = i3 - this.f344106e;
            int i17 = this.f344108g;
            if (i16 > i17) {
                int i18 = i16 - i17;
                this.f344104c = i18;
                this.f344103b = i3 - i18;
                return;
            }
            this.f344104c = 0;
        }

        @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.m
        public int d() throws IOException {
            return o();
        }

        @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.m
        public long e() throws IOException {
            return p();
        }

        @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.m
        public int f() throws IOException {
            return q();
        }

        @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.m
        public byte[] g(int i3) throws IOException {
            if (i3 > 0) {
                int i16 = this.f344103b;
                int i17 = this.f344105d;
                if (i3 <= i16 - i17) {
                    int i18 = i3 + i17;
                    this.f344105d = i18;
                    return Arrays.copyOfRange(this.f344102a, i17, i18);
                }
            }
            if (i3 <= 0) {
                if (i3 == 0) {
                    return new byte[0];
                }
                throw PBInvalidProtocolBufferException.negativeSize();
            }
            throw PBInvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.m
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long h() throws IOException {
            long j3;
            long j16;
            long j17;
            int i3;
            int i16 = this.f344105d;
            int i17 = this.f344103b;
            if (i17 != i16) {
                byte[] bArr = this.f344102a;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f344105d = i18;
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
                        this.f344105d = i19;
                        return j3;
                    }
                    j3 = i3;
                    this.f344105d = i19;
                    return j3;
                }
            }
            return r();
        }

        @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.m
        public int i() throws IOException {
            if (l()) {
                this.f344107f = 0;
                return 0;
            }
            int q16 = q();
            this.f344107f = q16;
            if (n.a(q16) != 0) {
                return this.f344107f;
            }
            throw PBInvalidProtocolBufferException.invalidTag();
        }

        b(byte[] bArr, int i3, int i16) {
            super();
            this.f344108g = Integer.MAX_VALUE;
            this.f344102a = bArr;
            this.f344103b = i16 + i3;
            this.f344105d = i3;
            this.f344106e = i3;
        }
    }

    public static m a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static m b(byte[] bArr, int i3, int i16) {
        return c(bArr, i3, i16, false);
    }

    static m c(byte[] bArr, int i3, int i16, boolean z16) {
        b bVar = new b(bArr, i3, i16);
        try {
            bVar.m(i16);
            return bVar;
        } catch (PBInvalidProtocolBufferException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public abstract int d() throws IOException;

    public abstract long e() throws IOException;

    public abstract int f() throws IOException;

    public abstract byte[] g(int i3) throws IOException;

    public abstract long h() throws IOException;

    public abstract int i() throws IOException;

    m() {
    }
}

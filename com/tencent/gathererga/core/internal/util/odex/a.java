package com.tencent.gathererga.core.internal.util.odex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gathererga.core.internal.util.odex.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1143a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f108293b;

        /* renamed from: c, reason: collision with root package name */
        int f108294c;

        /* renamed from: d, reason: collision with root package name */
        private c f108295d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f108296e;

        /* compiled from: P */
        /* renamed from: com.tencent.gathererga.core.internal.util.odex.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C1144a implements com.tencent.gathererga.core.internal.util.odex.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private short f108297a;

            /* renamed from: b, reason: collision with root package name */
            private short f108298b;

            /* renamed from: c, reason: collision with root package name */
            private int f108299c;

            /* renamed from: d, reason: collision with root package name */
            private short f108300d;

            /* renamed from: e, reason: collision with root package name */
            private short f108301e;

            /* renamed from: f, reason: collision with root package name */
            private short f108302f;

            /* renamed from: g, reason: collision with root package name */
            private f[] f108303g;

            /* compiled from: P */
            /* renamed from: com.tencent.gathererga.core.internal.util.odex.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C1145a extends f {
                static IPatchRedirector $redirector_;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ C1143a f108305c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f108306d;

                C1145a(C1143a c1143a, int i3) {
                    this.f108305c = c1143a;
                    this.f108306d = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, C1144a.this, c1143a, Integer.valueOf(i3));
                    }
                }

                @Override // com.tencent.gathererga.core.internal.util.odex.f
                public Object a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return new b(this.f108306d);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.gathererga.core.internal.util.odex.a$a$a$b */
            /* loaded from: classes6.dex */
            class b implements d {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                private int f108308a;

                /* renamed from: b, reason: collision with root package name */
                private int f108309b;

                /* renamed from: c, reason: collision with root package name */
                private int f108310c;

                /* renamed from: d, reason: collision with root package name */
                private int f108311d;

                /* renamed from: e, reason: collision with root package name */
                private int f108312e;

                /* renamed from: f, reason: collision with root package name */
                private f[] f108313f;

                /* renamed from: g, reason: collision with root package name */
                private f f108314g;

                /* compiled from: P */
                /* renamed from: com.tencent.gathererga.core.internal.util.odex.a$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                class C1146a extends f {
                    static IPatchRedirector $redirector_;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ C1144a f108316c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f108317d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f108318e;

                    C1146a(C1144a c1144a, int i3, int i16) {
                        this.f108316c = c1144a;
                        this.f108317d = i3;
                        this.f108318e = i16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, b.this, c1144a, Integer.valueOf(i3), Integer.valueOf(i16));
                        }
                    }

                    @Override // com.tencent.gathererga.core.internal.util.odex.f
                    public Object a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return new c(this.f108317d, this.f108318e);
                    }
                }

                b(int i3) throws ELFException {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) C1144a.this, i3);
                        return;
                    }
                    C1144a.this.k(i3);
                    this.f108308a = C1144a.this.h();
                    this.f108309b = C1144a.this.h();
                    C1144a.this.k(C1144a.this.j() + 8);
                    this.f108310c = C1144a.this.h();
                    this.f108311d = C1144a.this.h();
                    this.f108312e = C1144a.this.h();
                    C1144a.this.k(C1144a.this.j() + 12);
                    int i16 = this.f108309b;
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 11) {
                                return;
                            }
                        } else {
                            this.f108314g = new C1146a(C1144a.this, this.f108310c, this.f108311d);
                            return;
                        }
                    }
                    this.f108313f = new f[this.f108311d / this.f108312e];
                }

                @Override // com.tencent.gathererga.core.internal.util.odex.d
                public e a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (e) iPatchRedirector.redirect((short) 3, (Object) this);
                    }
                    f fVar = this.f108314g;
                    if (fVar != null) {
                        return (e) fVar.b();
                    }
                    return null;
                }

                @Override // com.tencent.gathererga.core.internal.util.odex.d
                public String getName() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                    }
                    if (this.f108308a == 0) {
                        return null;
                    }
                    return C1143a.this.getHeader().a().get(this.f108308a);
                }

                @Override // com.tencent.gathererga.core.internal.util.odex.d
                public int getOffset() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
                    }
                    return this.f108310c;
                }

                @Override // com.tencent.gathererga.core.internal.util.odex.d
                public int getSize() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                    }
                    return this.f108311d;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.gathererga.core.internal.util.odex.a$a$a$c */
            /* loaded from: classes6.dex */
            class c implements e {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                private byte[] f108320a;

                /* renamed from: b, reason: collision with root package name */
                private int f108321b;

                c(int i3, int i16) throws ELFException {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    int i17 = 0;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, C1144a.this, Integer.valueOf(i3), Integer.valueOf(i16));
                        return;
                    }
                    C1144a.this.k(i3);
                    byte[] bArr = new byte[i16];
                    this.f108320a = bArr;
                    int g16 = C1144a.this.g(bArr);
                    if (g16 == i16) {
                        this.f108321b = 0;
                        while (true) {
                            byte[] bArr2 = this.f108320a;
                            if (i17 < bArr2.length) {
                                if (bArr2[i17] == 0) {
                                    this.f108321b++;
                                }
                                i17++;
                            } else {
                                return;
                            }
                        }
                    } else {
                        throw new ELFException("Error reading string table (read " + g16 + "bytes, expected to read " + this.f108320a.length + "bytes).");
                    }
                }

                @Override // com.tencent.gathererga.core.internal.util.odex.e
                public String get(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    }
                    int i16 = i3;
                    while (true) {
                        byte[] bArr = this.f108320a;
                        if (bArr[i16] != 0) {
                            i16++;
                        } else {
                            return new String(bArr, i3, i16 - i3);
                        }
                    }
                }
            }

            C1144a() throws ELFException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C1143a.this);
                    return;
                }
                this.f108297a = i();
                this.f108298b = i();
                k(j() + 12);
                this.f108299c = h();
                k(j() + 4 + 6);
                this.f108300d = i();
                this.f108301e = i();
                this.f108302f = i();
                this.f108303g = new f[this.f108301e];
                for (int i3 = 0; i3 < this.f108301e; i3++) {
                    com.tencent.gathererga.core.internal.util.d.a("i: " + i3 + ", sh_offset:" + this.f108299c + ", sh_entry_size:" + ((int) this.f108300d));
                    this.f108303g[i3] = new C1145a(C1143a.this, this.f108299c + (this.f108300d * i3));
                }
            }

            private int c(byte[] bArr, ByteOrder byteOrder) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(byteOrder);
                return wrap.getInt();
            }

            @Override // com.tencent.gathererga.core.internal.util.odex.c
            public e a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (e) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return f(this.f108302f).a();
            }

            @Override // com.tencent.gathererga.core.internal.util.odex.c
            public byte[] b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                byte[] bArr = new byte[0];
                for (int i3 = 1; i3 < e(); i3++) {
                    d f16 = f(i3);
                    if (".rodata".equals(f16.getName())) {
                        int offset = f16.getOffset();
                        int size = f16.getSize();
                        byte[] bArr2 = new byte[size];
                        System.arraycopy(C1143a.this.f108293b, offset, bArr2, 0, size);
                        bArr = bArr2;
                    }
                }
                return bArr;
            }

            public short d(byte[] bArr, ByteOrder byteOrder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Short) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr, (Object) byteOrder)).shortValue();
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(byteOrder);
                return wrap.getShort();
            }

            public short e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Short) iPatchRedirector.redirect((short) 2, (Object) this)).shortValue();
                }
                return this.f108301e;
            }

            public d f(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (d) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return (d) this.f108303g[i3].b();
            }

            int g(byte[] bArr) {
                int length = C1143a.this.f108293b.length - C1143a.this.f108294c;
                if (length < 1) {
                    return length;
                }
                int min = Math.min(length, bArr.length);
                System.arraycopy(C1143a.this.f108293b, C1143a.this.f108294c, bArr, 0, min);
                C1143a.this.f108294c += min;
                return min;
            }

            int h() {
                byte[] bArr = new byte[4];
                g(bArr);
                return c(bArr, ByteOrder.LITTLE_ENDIAN);
            }

            short i() {
                byte[] bArr = new byte[2];
                g(bArr);
                return d(bArr, ByteOrder.LITTLE_ENDIAN);
            }

            int j() {
                return C1143a.this.f108294c;
            }

            void k(int i3) {
                int length = C1143a.this.f108293b.length;
                C1143a.this.f108294c = i3;
            }
        }

        C1143a(byte[] bArr) throws ELFException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
                return;
            }
            byte[] bArr2 = new byte[16];
            this.f108296e = bArr2;
            this.f108293b = bArr;
            this.f108294c = 0;
            int c16 = c(bArr2);
            if (c16 == this.f108296e.length) {
                if (Arrays.equals(b(), b.f108323a)) {
                    this.f108295d = new C1144a();
                    return;
                }
                throw new ELFException("Bad magic number for file.");
            }
            throw new ELFException("Error reading elf header (read " + c16 + "bytes, expected to read " + this.f108296e.length + "bytes).");
        }

        public byte[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            byte[] bArr = this.f108296e;
            return new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]};
        }

        int c(byte[] bArr) {
            int min = Math.min(this.f108293b.length - this.f108294c, bArr.length);
            System.arraycopy(this.f108293b, this.f108294c, bArr, 0, min);
            this.f108294c += min;
            return min;
        }

        @Override // com.tencent.gathererga.core.internal.util.odex.b
        public c getHeader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f108295d;
        }
    }

    public static b a(byte[] bArr) throws ELFException {
        return new C1143a(bArr);
    }
}

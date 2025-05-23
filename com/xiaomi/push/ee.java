package com.xiaomi.push;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class ee {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f388667a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f388668b = ByteBuffer.allocate(4);

    /* renamed from: c, reason: collision with root package name */
    private Adler32 f388669c = new Adler32();

    /* renamed from: d, reason: collision with root package name */
    private eh f388670d = new eh();

    /* renamed from: e, reason: collision with root package name */
    private InputStream f388671e;

    /* renamed from: f, reason: collision with root package name */
    private ey f388672f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f388673g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f388674h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(InputStream inputStream, ey eyVar) {
        this.f388671e = new BufferedInputStream(inputStream);
        this.f388672f = eyVar;
    }

    private ByteBuffer b() {
        this.f388667a.clear();
        d(this.f388667a, 8);
        short s16 = this.f388667a.getShort(0);
        short s17 = this.f388667a.getShort(2);
        if (s16 == -15618 && s17 == 5) {
            int i3 = this.f388667a.getInt(4);
            int position = this.f388667a.position();
            if (i3 <= 32768) {
                if (i3 + 4 > this.f388667a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(i3 + 2048);
                    allocate.put(this.f388667a.array(), 0, this.f388667a.arrayOffset() + this.f388667a.position());
                    this.f388667a = allocate;
                } else if (this.f388667a.capacity() > 4096 && i3 < 2048) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                    allocate2.put(this.f388667a.array(), 0, this.f388667a.arrayOffset() + this.f388667a.position());
                    this.f388667a = allocate2;
                }
                d(this.f388667a, i3);
                this.f388668b.clear();
                d(this.f388668b, 4);
                this.f388668b.position(0);
                int i16 = this.f388668b.getInt();
                this.f388669c.reset();
                this.f388669c.update(this.f388667a.array(), 0, this.f388667a.position());
                if (i16 == ((int) this.f388669c.getValue())) {
                    byte[] bArr = this.f388674h;
                    if (bArr != null) {
                        com.xiaomi.push.service.aa.j(bArr, this.f388667a.array(), true, position, i3);
                    }
                    return this.f388667a;
                }
                jz4.c.m("CRC = " + ((int) this.f388669c.getValue()) + " and " + i16);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    private void d(ByteBuffer byteBuffer, int i3) {
        int position = byteBuffer.position();
        do {
            int read = this.f388671e.read(byteBuffer.array(), position, i3);
            if (read != -1) {
                i3 -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i3 > 0);
        byteBuffer.position(position);
    }

    private void f() {
        boolean z16 = false;
        this.f388673g = false;
        eb a16 = a();
        if ("CONN".equals(a16.e())) {
            cu n3 = cu.n(a16.p());
            if (n3.p()) {
                this.f388672f.n(n3.o());
                z16 = true;
            }
            if (n3.t()) {
                cp j3 = n3.j();
                eb ebVar = new eb();
                ebVar.l("SYNC", "CONF");
                ebVar.n(j3.h(), null);
                this.f388672f.W(ebVar);
            }
            jz4.c.m("[Slim] CONN: host = " + n3.r());
        }
        if (z16) {
            this.f388674h = this.f388672f.X();
            while (!this.f388673g) {
                eb a17 = a();
                long currentTimeMillis = System.currentTimeMillis();
                this.f388672f.C();
                short g16 = a17.g();
                if (g16 != 1) {
                    if (g16 != 2) {
                        if (g16 != 3) {
                            jz4.c.m("[Slim] unknow blob type " + ((int) a17.g()));
                        } else {
                            try {
                                this.f388672f.Y(this.f388670d.a(a17.p(), this.f388672f));
                            } catch (Exception e16) {
                                jz4.c.m("[Slim] Parse packet from Blob chid=" + a17.a() + "; Id=" + a17.D() + " failure:" + e16.getMessage());
                            }
                        }
                    } else if ("SECMSG".equals(a17.e()) && ((a17.a() == 2 || a17.a() == 3) && TextUtils.isEmpty(a17.t()))) {
                        try {
                            fc a18 = this.f388670d.a(a17.q(com.xiaomi.push.service.am.c().b(Integer.valueOf(a17.a()).toString(), a17.F()).f389613i), this.f388672f);
                            a18.f388830j = currentTimeMillis;
                            this.f388672f.Y(a18);
                        } catch (Exception e17) {
                            jz4.c.m("[Slim] Parse packet from Blob chid=" + a17.a() + "; Id=" + a17.D() + " failure:" + e17.getMessage());
                        }
                    } else {
                        this.f388672f.W(a17);
                    }
                } else {
                    this.f388672f.W(a17);
                }
            }
            return;
        }
        jz4.c.m("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
    }

    eb a() {
        int i3;
        eb d16;
        try {
            ByteBuffer b16 = b();
            i3 = b16.position();
            try {
                b16.flip();
                b16.position(8);
                if (i3 == 8) {
                    d16 = new em();
                } else {
                    d16 = eb.d(b16.slice());
                }
                jz4.c.z("[Slim] Read {cmd=" + d16.e() + ";chid=" + d16.a() + ";len=" + i3 + "}");
                return d16;
            } catch (IOException e16) {
                e = e16;
                if (i3 == 0) {
                    i3 = this.f388667a.position();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[Slim] read Blob [");
                byte[] array = this.f388667a.array();
                if (i3 > 128) {
                    i3 = 128;
                }
                sb5.append(e.a(array, 0, i3));
                sb5.append("] Err:");
                sb5.append(e.getMessage());
                jz4.c.m(sb5.toString());
                throw e;
            }
        } catch (IOException e17) {
            e = e17;
            i3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        try {
            f();
        } catch (IOException e16) {
            if (this.f388673g) {
            } else {
                throw e16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f388673g = true;
    }
}

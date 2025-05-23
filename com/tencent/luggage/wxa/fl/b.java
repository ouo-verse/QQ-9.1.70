package com.tencent.luggage.wxa.fl;

import com.tencent.luggage.wxa.fl.d;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends e implements a {

    /* renamed from: h, reason: collision with root package name */
    public static final ByteBuffer f126240h = ByteBuffer.allocate(0);

    /* renamed from: f, reason: collision with root package name */
    public int f126241f;

    /* renamed from: g, reason: collision with root package name */
    public String f126242g;

    public b() {
        super(d.a.CLOSING);
        a(true);
    }

    public final void a(int i3, String str) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i3 == 1015) {
            i3 = 1005;
        } else {
            str2 = str;
        }
        if (i3 == 1005) {
            if (str2.length() > 0) {
                throw new com.tencent.luggage.wxa.el.b(1002, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] b16 = com.tencent.luggage.wxa.hl.b.b(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i3);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(b16.length + 2);
        allocate2.put(allocate);
        allocate2.put(b16);
        allocate2.rewind();
        a(allocate2);
    }

    @Override // com.tencent.luggage.wxa.fl.a
    public int e() {
        return this.f126241f;
    }

    @Override // com.tencent.luggage.wxa.fl.e, com.tencent.luggage.wxa.fl.d
    public ByteBuffer f() {
        if (this.f126241f == 1005) {
            return f126240h;
        }
        return super.f();
    }

    public final void g() {
        this.f126241f = 1005;
        ByteBuffer f16 = super.f();
        f16.mark();
        if (f16.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(f16.getShort());
            allocate.position(0);
            int i3 = allocate.getInt();
            this.f126241f = i3;
            if (i3 == 1006 || i3 == 1015 || i3 == 1005 || i3 > 4999 || i3 < 1000 || i3 == 1004) {
                throw new com.tencent.luggage.wxa.el.c("closecode must not be sent over the wire: " + this.f126241f);
            }
        }
        f16.reset();
    }

    public final void h() {
        if (this.f126241f == 1005) {
            this.f126242g = com.tencent.luggage.wxa.hl.b.a(super.f());
            return;
        }
        ByteBuffer f16 = super.f();
        int position = f16.position();
        try {
            try {
                f16.position(f16.position() + 2);
                this.f126242g = com.tencent.luggage.wxa.hl.b.a(f16);
            } catch (IllegalArgumentException e16) {
                throw new com.tencent.luggage.wxa.el.c(e16);
            }
        } finally {
            f16.position(position);
        }
    }

    @Override // com.tencent.luggage.wxa.fl.e
    public String toString() {
        return super.toString() + "code: " + this.f126241f;
    }

    public b(int i3, String str) {
        super(d.a.CLOSING);
        a(true);
        a(i3, str);
    }

    @Override // com.tencent.luggage.wxa.fl.a
    public String a() {
        return this.f126242g;
    }

    @Override // com.tencent.luggage.wxa.fl.e, com.tencent.luggage.wxa.fl.c
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        g();
        h();
    }
}

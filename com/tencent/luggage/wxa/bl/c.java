package com.tencent.luggage.wxa.bl;

import com.tencent.luggage.wxa.bl.a;
import com.tencent.luggage.wxa.dl.a;
import com.tencent.luggage.wxa.el.e;
import com.tencent.luggage.wxa.fl.d;
import com.tencent.luggage.wxa.gl.f;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.tn.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements a {
    public static int G = 16384;
    public static boolean H = false;
    public static final List I;

    /* renamed from: a, reason: collision with root package name */
    public SelectionKey f123040a;

    /* renamed from: b, reason: collision with root package name */
    public ByteChannel f123041b;

    /* renamed from: c, reason: collision with root package name */
    public final BlockingQueue f123042c;

    /* renamed from: d, reason: collision with root package name */
    public final BlockingQueue f123043d;

    /* renamed from: g, reason: collision with root package name */
    public final d f123046g;

    /* renamed from: h, reason: collision with root package name */
    public List f123047h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.dl.a f123048i;

    /* renamed from: j, reason: collision with root package name */
    public a.b f123049j;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f123044e = false;

    /* renamed from: f, reason: collision with root package name */
    public a.EnumC6082a f123045f = a.EnumC6082a.NOT_YET_CONNECTED;

    /* renamed from: k, reason: collision with root package name */
    public d.a f123050k = null;

    /* renamed from: l, reason: collision with root package name */
    public ByteBuffer f123051l = ByteBuffer.allocate(0);

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.gl.a f123052m = null;
    public String C = null;
    public Integer D = null;
    public Boolean E = null;
    public String F = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        I = arrayList;
        arrayList.add(new com.tencent.luggage.wxa.dl.c());
        arrayList.add(new com.tencent.luggage.wxa.dl.b());
        arrayList.add(new com.tencent.luggage.wxa.dl.d());
    }

    public c(d dVar, com.tencent.luggage.wxa.dl.a aVar) {
        this.f123048i = null;
        if (dVar != null && (aVar != null || this.f123049j != a.b.SERVER)) {
            this.f123042c = new LinkedBlockingQueue();
            this.f123043d = new LinkedBlockingQueue();
            this.f123046g = dVar;
            this.f123049j = a.b.CLIENT;
            if (aVar != null) {
                this.f123048i = aVar.a();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    public void a(ByteBuffer byteBuffer) {
        if (H) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.f123045f != a.EnumC6082a.NOT_YET_CONNECTED) {
            if (b() == a.EnumC6082a.OPEN) {
                b(byteBuffer);
            }
        } else {
            if (!c(byteBuffer) || e() || d()) {
                return;
            }
            if (byteBuffer.hasRemaining()) {
                b(byteBuffer);
            } else if (this.f123051l.hasRemaining()) {
                b(this.f123051l);
            }
        }
    }

    public final void b(ByteBuffer byteBuffer) {
        int i3;
        String str;
        try {
        } catch (com.tencent.luggage.wxa.el.b e16) {
            w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e16.toString());
            this.f123046g.a(this, e16);
            a(e16);
            return;
        }
        for (com.tencent.luggage.wxa.fl.d dVar : this.f123048i.c(byteBuffer)) {
            if (H) {
                w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + dVar);
            }
            d.a c16 = dVar.c();
            boolean d16 = dVar.d();
            if (c16 == d.a.CLOSING) {
                if (dVar instanceof com.tencent.luggage.wxa.fl.a) {
                    com.tencent.luggage.wxa.fl.a aVar = (com.tencent.luggage.wxa.fl.a) dVar;
                    i3 = aVar.e();
                    str = aVar.a();
                } else {
                    i3 = 1005;
                    str = "";
                }
                if (this.f123045f == a.EnumC6082a.CLOSING) {
                    b(i3, str, true);
                } else if (this.f123048i.b() == a.EnumC6142a.TWOWAY) {
                    a(i3, str, true);
                } else {
                    c(i3, str, false);
                }
            } else if (c16 == d.a.PING) {
                this.f123046g.a(this, dVar);
            } else if (c16 == d.a.PONG) {
                this.f123046g.c(this, dVar);
            } else {
                if (d16 && c16 != d.a.CONTINUOUS) {
                    if (this.f123050k == null) {
                        if (c16 == d.a.TEXT) {
                            try {
                                this.f123046g.a(this, com.tencent.luggage.wxa.hl.b.a(dVar.f()));
                            } catch (RuntimeException e17) {
                                this.f123046g.a(this, e17);
                            }
                        } else if (c16 == d.a.BINARY) {
                            try {
                                this.f123046g.a(this, dVar.f());
                            } catch (RuntimeException e18) {
                                this.f123046g.a(this, e18);
                            }
                        } else {
                            throw new com.tencent.luggage.wxa.el.b(1002, "non control or continious frame expected");
                        }
                        w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e16.toString());
                        this.f123046g.a(this, e16);
                        a(e16);
                        return;
                    }
                    throw new com.tencent.luggage.wxa.el.b(1002, "Continuous frame sequence not completed.");
                }
                if (c16 != d.a.CONTINUOUS) {
                    if (this.f123050k == null) {
                        this.f123050k = c16;
                    } else {
                        throw new com.tencent.luggage.wxa.el.b(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (d16) {
                    if (this.f123050k != null) {
                        this.f123050k = null;
                    } else {
                        throw new com.tencent.luggage.wxa.el.b(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.f123050k == null) {
                    throw new com.tencent.luggage.wxa.el.b(1002, "Continuous frame sequence was not started.");
                }
                try {
                    this.f123046g.b(this, dVar);
                } catch (RuntimeException e19) {
                    this.f123046g.a(this, e19);
                }
            }
        }
    }

    public final boolean c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        a.b bVar;
        f d16;
        if (this.f123051l.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.f123051l.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.f123051l.capacity() + byteBuffer.remaining());
                this.f123051l.flip();
                allocate.put(this.f123051l);
                this.f123051l = allocate;
            }
            this.f123051l.put(byteBuffer);
            this.f123051l.flip();
            byteBuffer2 = this.f123051l;
        }
        byteBuffer2.mark();
        try {
            try {
                bVar = this.f123049j;
            } catch (com.tencent.luggage.wxa.el.d e16) {
                w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e16.toString());
                a(e16);
            }
        } catch (com.tencent.luggage.wxa.el.a e17) {
            w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e17.toString());
            if (this.f123051l.capacity() == 0) {
                byteBuffer2.reset();
                int a16 = e17.a();
                if (a16 == 0) {
                    a16 = byteBuffer2.capacity() + 16;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(a16);
                this.f123051l = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.f123051l;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.f123051l;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (bVar == a.b.SERVER) {
            com.tencent.luggage.wxa.dl.a aVar = this.f123048i;
            if (aVar == null) {
                Iterator it = this.f123047h.iterator();
                while (it.hasNext()) {
                    com.tencent.luggage.wxa.dl.a a17 = ((com.tencent.luggage.wxa.dl.a) it.next()).a();
                    try {
                        a17.a(this.f123049j);
                        byteBuffer2.reset();
                        d16 = a17.d(byteBuffer2);
                    } catch (com.tencent.luggage.wxa.el.d e18) {
                        w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e18.toString());
                    }
                    if (!(d16 instanceof com.tencent.luggage.wxa.gl.a)) {
                        c(1002, "wrong http function", false);
                        return false;
                    }
                    com.tencent.luggage.wxa.gl.a aVar2 = (com.tencent.luggage.wxa.gl.a) d16;
                    if (a17.a(aVar2) == a.b.MATCHED) {
                        this.F = aVar2.c();
                        try {
                            a(a17.a(a17.a(aVar2, this.f123046g.a(this, a17, aVar2)), this.f123049j));
                            this.f123048i = a17;
                            a(aVar2);
                            return true;
                        } catch (com.tencent.luggage.wxa.el.b e19) {
                            c(e19.a(), e19.getMessage(), false);
                            return false;
                        } catch (RuntimeException e26) {
                            this.f123046g.a(this, e26);
                            c(-1, e26.getMessage(), false);
                            return false;
                        }
                    }
                }
                if (this.f123048i == null) {
                    a(1002, "no draft matches");
                }
                return false;
            }
            f d17 = aVar.d(byteBuffer2);
            if (!(d17 instanceof com.tencent.luggage.wxa.gl.a)) {
                c(1002, "wrong http function", false);
                return false;
            }
            com.tencent.luggage.wxa.gl.a aVar3 = (com.tencent.luggage.wxa.gl.a) d17;
            if (this.f123048i.a(aVar3) == a.b.MATCHED) {
                a(aVar3);
                return true;
            }
            a(1002, "the handshake did finaly not match");
            return false;
        }
        if (bVar == a.b.CLIENT) {
            this.f123048i.a(bVar);
            f d18 = this.f123048i.d(byteBuffer2);
            if (!(d18 instanceof h)) {
                c(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) d18;
            if (this.f123048i.a(this.f123052m, hVar) == a.b.MATCHED) {
                try {
                    this.f123046g.a(this, this.f123052m, hVar);
                    a(hVar);
                    return true;
                } catch (com.tencent.luggage.wxa.el.b e27) {
                    w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e27.toString());
                    c(e27.a(), e27.getMessage(), false);
                    return false;
                } catch (RuntimeException e28) {
                    w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e28.toString());
                    this.f123046g.a(this, e28);
                    c(-1, e28.getMessage(), false);
                    return false;
                }
            }
            a(1002, "draft refuses handshake " + ((int) hVar.a()) + " " + hVar.b());
        }
        return false;
    }

    public void d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            a((Collection) this.f123048i.a(byteBuffer, this.f123049j == a.b.CLIENT));
        }
    }

    public final void e(ByteBuffer byteBuffer) {
        if (H) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.f123042c.add(byteBuffer);
        this.f123046g.a(this);
    }

    public boolean f() {
        if (this.f123045f == a.EnumC6082a.OPEN) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public boolean d() {
        return this.f123045f == a.EnumC6082a.CLOSED;
    }

    public boolean e() {
        return this.f123045f == a.EnumC6082a.CLOSING;
    }

    public final void a(int i3, String str, boolean z16) {
        a.EnumC6082a enumC6082a = this.f123045f;
        a.EnumC6082a enumC6082a2 = a.EnumC6082a.CLOSING;
        if (enumC6082a == enumC6082a2 || enumC6082a == a.EnumC6082a.CLOSED) {
            return;
        }
        if (enumC6082a == a.EnumC6082a.OPEN) {
            if (i3 == 1006) {
                this.f123045f = enumC6082a2;
                c(i3, str, false);
                return;
            }
            if (this.f123048i.b() != a.EnumC6142a.NONE) {
                if (!z16) {
                    try {
                        try {
                            this.f123046g.a(this, i3, str);
                        } catch (RuntimeException e16) {
                            w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e16.toString());
                            this.f123046g.a(this, e16);
                        }
                    } catch (com.tencent.luggage.wxa.el.b e17) {
                        w.b("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e17.toString());
                        this.f123046g.a(this, e17);
                        c(1006, "generated frame is invalid", false);
                    }
                }
                a(new com.tencent.luggage.wxa.fl.b(i3, str));
            }
            c(i3, str, z16);
        } else if (i3 == -3) {
            c(-3, str, true);
        } else {
            c(-1, str, false);
        }
        if (i3 == 1002) {
            c(i3, str, z16);
        }
        this.f123045f = a.EnumC6082a.CLOSING;
        this.f123051l = null;
    }

    public void a(int i3, String str) {
        a(i3, str, false);
    }

    public void a(int i3, boolean z16) {
        b(i3, "", z16);
    }

    public void a() {
        if (b() == a.EnumC6082a.NOT_YET_CONNECTED) {
            a(-1, true);
            return;
        }
        if (this.f123044e) {
            b(this.D.intValue(), this.C, this.E.booleanValue());
            return;
        }
        if (this.f123048i.b() == a.EnumC6142a.NONE) {
            a(1000, true);
            return;
        }
        if (this.f123048i.b() == a.EnumC6142a.ONEWAY) {
            if (this.f123049j == a.b.SERVER) {
                a(1006, true);
                return;
            } else {
                a(1000, true);
                return;
            }
        }
        a(1006, true);
    }

    public void a(int i3) {
        a(i3, "", false);
    }

    public void a(com.tencent.luggage.wxa.el.b bVar) {
        a(bVar.a(), bVar.getMessage(), false);
    }

    public void a(String str) {
        if (str == null) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            a((Collection) this.f123048i.a(str, this.f123049j == a.b.CLIENT));
        }
    }

    public synchronized void b(int i3, String str, boolean z16) {
        if (this.f123045f == a.EnumC6082a.CLOSED) {
            return;
        }
        SelectionKey selectionKey = this.f123040a;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.f123041b;
        if (byteChannel != null) {
            try {
                byteChannel.close();
            } catch (IOException e16) {
                this.f123046g.a(this, e16);
            }
        }
        try {
            this.f123046g.a(this, i3, str, z16);
        } catch (RuntimeException e17) {
            this.f123046g.a(this, e17);
        }
        com.tencent.luggage.wxa.dl.a aVar = this.f123048i;
        if (aVar != null) {
            aVar.c();
        }
        this.f123052m = null;
        this.f123045f = a.EnumC6082a.CLOSED;
        this.f123042c.clear();
    }

    public final void a(Collection collection) {
        if (f()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                a((com.tencent.luggage.wxa.fl.d) it.next());
            }
            return;
        }
        throw new e();
    }

    @Override // com.tencent.luggage.wxa.bl.a
    public void a(com.tencent.luggage.wxa.fl.d dVar) {
        if (H) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        e(this.f123048i.a(dVar));
    }

    public void a(com.tencent.luggage.wxa.gl.b bVar) {
        this.f123052m = this.f123048i.a(bVar);
        String c16 = bVar.c();
        this.F = c16;
        if (c16 == null) {
            return;
        }
        try {
            this.f123046g.a((a) this, this.f123052m);
            a(this.f123048i.a(this.f123052m, this.f123049j));
        } catch (com.tencent.luggage.wxa.el.b unused) {
            throw new com.tencent.luggage.wxa.el.d("Handshake data rejected by client.");
        } catch (RuntimeException e16) {
            this.f123046g.a(this, e16);
            throw new com.tencent.luggage.wxa.el.d("rejected because of" + e16);
        }
    }

    public void b(int i3, String str) {
        b(i3, str, false);
    }

    public a.EnumC6082a b() {
        return this.f123045f;
    }

    public final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e((ByteBuffer) it.next());
        }
    }

    public final void a(f fVar) {
        if (H) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.f123048i.getClass().getSimpleName());
        }
        this.f123045f = a.EnumC6082a.OPEN;
        try {
            this.f123046g.a(this, fVar);
        } catch (RuntimeException e16) {
            this.f123046g.a(this, e16);
        }
    }

    public synchronized void c(int i3, String str, boolean z16) {
        if (this.f123044e) {
            return;
        }
        this.D = Integer.valueOf(i3);
        this.C = str;
        this.E = Boolean.valueOf(z16);
        this.f123044e = true;
        this.f123046g.a(this);
        try {
            this.f123046g.b(this, i3, str, z16);
        } catch (RuntimeException e16) {
            this.f123046g.a(this, e16);
        }
        com.tencent.luggage.wxa.dl.a aVar = this.f123048i;
        if (aVar != null) {
            aVar.c();
        }
        this.f123052m = null;
    }

    public boolean c() {
        return !this.f123042c.isEmpty();
    }
}

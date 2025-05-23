package com.tencent.luggage.wxa.dl;

import com.tencent.luggage.wxa.bl.a;
import com.tencent.luggage.wxa.fl.d;
import com.tencent.luggage.wxa.gl.e;
import com.tencent.luggage.wxa.gl.f;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f124312c = com.tencent.luggage.wxa.hl.b.b("<policy-file-request/>\u0000");

    /* renamed from: a, reason: collision with root package name */
    public a.b f124313a = null;

    /* renamed from: b, reason: collision with root package name */
    public d.a f124314b = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.dl.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6142a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b16 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b17 = byteBuffer.get();
            allocate.put(b17);
            if (b16 == 13 && b17 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b16 = b17;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        ByteBuffer a16 = a(byteBuffer);
        if (a16 == null) {
            return null;
        }
        return com.tencent.luggage.wxa.hl.b.a(a16.array(), 0, a16.limit());
    }

    public abstract b a(com.tencent.luggage.wxa.gl.a aVar);

    public abstract b a(com.tencent.luggage.wxa.gl.a aVar, h hVar);

    public abstract a a();

    public abstract com.tencent.luggage.wxa.gl.b a(com.tencent.luggage.wxa.gl.b bVar);

    public abstract com.tencent.luggage.wxa.gl.c a(com.tencent.luggage.wxa.gl.a aVar, i iVar);

    public abstract ByteBuffer a(com.tencent.luggage.wxa.fl.d dVar);

    public abstract List a(String str, boolean z16);

    public abstract List a(ByteBuffer byteBuffer, boolean z16);

    public abstract EnumC6142a b();

    public abstract List c(ByteBuffer byteBuffer);

    public abstract void c();

    public f d(ByteBuffer byteBuffer) {
        return a(byteBuffer, this.f124313a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.tencent.luggage.wxa.gl.e, com.tencent.luggage.wxa.gl.i] */
    public static com.tencent.luggage.wxa.gl.c a(ByteBuffer byteBuffer, a.b bVar) {
        com.tencent.luggage.wxa.gl.d dVar;
        String b16 = b(byteBuffer);
        if (b16 != null) {
            String[] split = b16.split(" ", 3);
            if (split.length == 3) {
                if (bVar == a.b.CLIENT) {
                    ?? eVar = new e();
                    eVar.a(Short.parseShort(split[1]));
                    eVar.c(split[2]);
                    dVar = eVar;
                } else {
                    com.tencent.luggage.wxa.gl.d dVar2 = new com.tencent.luggage.wxa.gl.d();
                    dVar2.b(split[1]);
                    dVar = dVar2;
                }
                String b17 = b(byteBuffer);
                while (b17 != null && b17.length() > 0) {
                    String[] split2 = b17.split(":", 2);
                    if (split2.length == 2) {
                        dVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
                        b17 = b(byteBuffer);
                    } else {
                        throw new com.tencent.luggage.wxa.el.d("not an http header");
                    }
                }
                if (b17 != null) {
                    return dVar;
                }
                throw new com.tencent.luggage.wxa.el.a();
            }
            throw new com.tencent.luggage.wxa.el.d();
        }
        throw new com.tencent.luggage.wxa.el.a(byteBuffer.capacity() + 128);
    }

    public boolean a(f fVar) {
        return fVar.d(HttpHeaders.UPGRADE).equalsIgnoreCase("websocket") && fVar.d("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List a(f fVar, a.b bVar) {
        return a(fVar, bVar, true);
    }

    public List a(f fVar, a.b bVar, boolean z16) {
        StringBuilder sb5 = new StringBuilder(100);
        if (fVar instanceof com.tencent.luggage.wxa.gl.a) {
            sb5.append("GET ");
            sb5.append(((com.tencent.luggage.wxa.gl.a) fVar).c());
            sb5.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            sb5.append("HTTP/1.1 101 " + ((h) fVar).b());
        } else {
            sb5.append("GET ");
            sb5.append(((com.tencent.luggage.wxa.gl.a) fVar).c());
            sb5.append(" HTTP/1.1");
            w.b("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        sb5.append("\r\n");
        Iterator d16 = fVar.d();
        while (d16.hasNext()) {
            String str = (String) d16.next();
            String d17 = fVar.d(str);
            sb5.append(str);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(d17);
            sb5.append("\r\n");
        }
        sb5.append("\r\n");
        byte[] a16 = com.tencent.luggage.wxa.hl.b.a(sb5.toString());
        byte[] content = z16 ? fVar.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + a16.length);
        allocate.put(a16);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public int a(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new com.tencent.luggage.wxa.el.b(1002, "Negative count");
    }

    public void a(a.b bVar) {
        this.f124313a = bVar;
    }
}

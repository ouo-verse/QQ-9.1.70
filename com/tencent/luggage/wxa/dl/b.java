package com.tencent.luggage.wxa.dl;

import com.tencent.luggage.wxa.bl.a;
import com.tencent.luggage.wxa.dl.a;
import com.tencent.luggage.wxa.fl.d;
import com.tencent.luggage.wxa.fl.e;
import com.tencent.luggage.wxa.gl.f;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.httpcore.HttpHeaders;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.dl.a {

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f124322d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fl.d f124323e = null;

    /* renamed from: f, reason: collision with root package name */
    public final Random f124324f = new Random();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Throwable {

        /* renamed from: a, reason: collision with root package name */
        public int f124325a;

        public a(int i3) {
            this.f124325a = i3;
        }

        public int a() {
            return this.f124325a;
        }
    }

    public static int b(f fVar) {
        String d16 = fVar.d("Sec-WebSocket-Version");
        if (d16.length() > 0) {
            try {
                return new Integer(d16.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public a.b a(com.tencent.luggage.wxa.gl.a aVar, h hVar) {
        String d16 = aVar.d("Sec-WebSocket-Protocol");
        String d17 = hVar.d("Sec-WebSocket-Protocol");
        if (!w0.c(d16) && !w0.c(d17)) {
            boolean z16 = true;
            w.a("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", d17);
            String[] split = d16.split(", ");
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = false;
                    break;
                }
                if (d17.equals(split[i3])) {
                    break;
                }
                i3++;
            }
            if (!z16) {
                return a.b.NOT_MATCHED;
            }
        }
        if (aVar.a("Sec-WebSocket-Key") && hVar.a("Sec-WebSocket-Accept")) {
            if (a(aVar.d("Sec-WebSocket-Key")).equals(hVar.d("Sec-WebSocket-Accept"))) {
                return a.b.MATCHED;
            }
            return a.b.NOT_MATCHED;
        }
        return a.b.NOT_MATCHED;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public List c(ByteBuffer byteBuffer) {
        LinkedList linkedList = new LinkedList();
        if (this.f124322d != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f124322d.remaining();
                if (remaining2 > remaining) {
                    this.f124322d.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f124322d.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.f124322d.duplicate().position(0)));
                this.f124322d = null;
            } catch (a e16) {
                this.f124322d.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e16.a()));
                this.f124322d.rewind();
                allocate.put(this.f124322d);
                this.f124322d = allocate;
                return c(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(e(byteBuffer));
            } catch (a e17) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(a(e17.a()));
                this.f124322d = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public com.tencent.luggage.wxa.fl.d e(ByteBuffer byteBuffer) {
        boolean z16;
        boolean z17;
        int i3;
        com.tencent.luggage.wxa.fl.c eVar;
        int remaining = byteBuffer.remaining();
        int i16 = 2;
        if (remaining >= 2) {
            byte b16 = byteBuffer.get();
            if ((b16 >> 8) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            byte b17 = (byte) ((b16 & Byte.MAX_VALUE) >> 4);
            if (b17 == 0) {
                byte b18 = byteBuffer.get();
                if ((b18 & Byte.MIN_VALUE) != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int i17 = (byte) (b18 & Byte.MAX_VALUE);
                d.a a16 = a((byte) (b16 & RegisterType.DOUBLE_HI));
                if (!z16 && (a16 == d.a.PING || a16 == d.a.PONG || a16 == d.a.CLOSING)) {
                    throw new com.tencent.luggage.wxa.el.c("control frames may no be fragmented");
                }
                if (i17 < 0 || i17 > 125) {
                    if (a16 != d.a.PING && a16 != d.a.PONG && a16 != d.a.CLOSING) {
                        if (i17 == 126) {
                            if (remaining >= 4) {
                                i17 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                                i16 = 4;
                            } else {
                                throw new a(4);
                            }
                        } else {
                            i16 = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i18 = 0; i18 < 8; i18++) {
                                    bArr[i18] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue > TTL.MAX_VALUE) {
                                    w.b("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                                } else {
                                    i17 = (int) longValue;
                                }
                            } else {
                                throw new a(10);
                            }
                        }
                    } else {
                        throw new com.tencent.luggage.wxa.el.c("more than 125 octets");
                    }
                }
                if (z17) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                int i19 = i16 + i3 + i17;
                if (remaining >= i19) {
                    ByteBuffer allocate = ByteBuffer.allocate(a(i17));
                    if (z17) {
                        byte[] bArr2 = new byte[4];
                        byteBuffer.get(bArr2);
                        for (int i26 = 0; i26 < i17; i26++) {
                            allocate.put((byte) (byteBuffer.get() ^ bArr2[i26 % 4]));
                        }
                    } else {
                        allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                        byteBuffer.position(byteBuffer.position() + allocate.limit());
                    }
                    if (a16 == d.a.CLOSING) {
                        eVar = new com.tencent.luggage.wxa.fl.b();
                    } else {
                        eVar = new e();
                        eVar.a(z16);
                        eVar.a(a16);
                    }
                    allocate.flip();
                    eVar.a(allocate);
                    return eVar;
                }
                throw new a(i19);
            }
            throw new com.tencent.luggage.wxa.el.c("bad rsv " + ((int) b17));
        }
        throw new a(2);
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public a.EnumC6142a b() {
        return a.EnumC6142a.TWOWAY;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public a.b a(com.tencent.luggage.wxa.gl.a aVar) {
        int b16 = b(aVar);
        if (b16 == 7 || b16 == 8) {
            return a((f) aVar) ? a.b.MATCHED : a.b.NOT_MATCHED;
        }
        return a.b.NOT_MATCHED;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public ByteBuffer a(com.tencent.luggage.wxa.fl.d dVar) {
        ByteBuffer f16 = dVar.f();
        int i3 = 0;
        boolean z16 = this.f124313a == a.b.CLIENT;
        int i16 = f16.remaining() <= 125 ? 1 : f16.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i16 > 1 ? i16 + 1 : i16) + 1 + (z16 ? 4 : 0) + f16.remaining());
        allocate.put((byte) (((byte) (dVar.d() ? -128 : 0)) | a(dVar.c())));
        byte[] a16 = a(f16.remaining(), i16);
        if (i16 == 1) {
            allocate.put((byte) (a16[0] | (z16 ? Byte.MIN_VALUE : (byte) 0)));
        } else if (i16 == 2) {
            allocate.put((byte) ((z16 ? Byte.MIN_VALUE : (byte) 0) | 126));
            allocate.put(a16);
        } else if (i16 == 8) {
            allocate.put((byte) ((z16 ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
            allocate.put(a16);
        } else {
            w.b("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (z16) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.f124324f.nextInt());
            allocate.put(allocate2.array());
            while (f16.hasRemaining()) {
                allocate.put((byte) (f16.get() ^ allocate2.get(i3 % 4)));
                i3++;
            }
        } else {
            allocate.put(f16);
        }
        allocate.flip();
        return allocate;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public void c() {
        this.f124322d = null;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public List a(ByteBuffer byteBuffer, boolean z16) {
        e eVar = new e();
        try {
            eVar.a(byteBuffer);
        } catch (com.tencent.luggage.wxa.el.b e16) {
            w.b("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e16.toString());
        }
        eVar.a(true);
        eVar.a(d.a.BINARY);
        eVar.b(z16);
        return Collections.singletonList(eVar);
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public List a(String str, boolean z16) {
        e eVar = new e();
        try {
            eVar.a(ByteBuffer.wrap(com.tencent.luggage.wxa.hl.b.b(str)));
        } catch (com.tencent.luggage.wxa.el.b e16) {
            w.b("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e16.toString());
        }
        eVar.a(true);
        eVar.a(d.a.TEXT);
        eVar.b(z16);
        return Collections.singletonList(eVar);
    }

    public final byte a(d.a aVar) {
        if (aVar == d.a.CONTINUOUS) {
            return (byte) 0;
        }
        if (aVar == d.a.TEXT) {
            return (byte) 1;
        }
        if (aVar == d.a.BINARY) {
            return (byte) 2;
        }
        if (aVar == d.a.CLOSING) {
            return (byte) 8;
        }
        if (aVar == d.a.PING) {
            return (byte) 9;
        }
        if (aVar == d.a.PONG) {
            return (byte) 10;
        }
        w.b("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + aVar.toString());
        return (byte) 8;
    }

    public final String a(String str) {
        try {
            return com.tencent.luggage.wxa.hl.a.a(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e16) {
            w.b("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e16.toString());
            return "";
        }
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public com.tencent.luggage.wxa.gl.b a(com.tencent.luggage.wxa.gl.b bVar) {
        bVar.a(HttpHeaders.UPGRADE, "websocket");
        bVar.a("Connection", HttpHeaders.UPGRADE);
        bVar.a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.f124324f.nextBytes(bArr);
        bVar.a("Sec-WebSocket-Key", com.tencent.luggage.wxa.hl.a.a(bArr));
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public com.tencent.luggage.wxa.gl.c a(com.tencent.luggage.wxa.gl.a aVar, i iVar) {
        iVar.a(HttpHeaders.UPGRADE, "websocket");
        iVar.a("Connection", aVar.d("Connection"));
        iVar.c("Switching Protocols");
        String d16 = aVar.d("Sec-WebSocket-Key");
        if (d16 != null) {
            iVar.a("Sec-WebSocket-Accept", a(d16));
            return iVar;
        }
        throw new com.tencent.luggage.wxa.el.d("missing Sec-WebSocket-Key");
    }

    public final byte[] a(long j3, int i3) {
        byte[] bArr = new byte[i3];
        int i16 = (i3 * 8) - 8;
        for (int i17 = 0; i17 < i3; i17++) {
            bArr[i17] = (byte) (j3 >>> (i16 - (i17 * 8)));
        }
        return bArr;
    }

    public final d.a a(byte b16) {
        if (b16 == 0) {
            return d.a.CONTINUOUS;
        }
        if (b16 == 1) {
            return d.a.TEXT;
        }
        if (b16 != 2) {
            switch (b16) {
                case 8:
                    return d.a.CLOSING;
                case 9:
                    return d.a.PING;
                case 10:
                    return d.a.PONG;
                default:
                    throw new com.tencent.luggage.wxa.el.c("unknow optcode " + ((int) b16));
            }
        }
        return d.a.BINARY;
    }

    @Override // com.tencent.luggage.wxa.dl.a
    public com.tencent.luggage.wxa.dl.a a() {
        return new b();
    }
}

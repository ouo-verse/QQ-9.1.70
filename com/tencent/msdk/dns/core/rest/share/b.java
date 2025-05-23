package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.n;
import com.tencent.msdk.dns.core.o;
import com.tencent.msdk.dns.core.rest.share.a;
import com.tencent.tbs.reader.ITbsReaderTool;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class b extends com.tencent.msdk.dns.core.rest.share.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected final int f336336b;

    /* renamed from: c, reason: collision with root package name */
    protected final com.tencent.msdk.dns.core.f f336337c;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private class a extends a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        private SocketChannel f336338i;

        /* renamed from: j, reason: collision with root package name */
        private SocketAddress f336339j;

        /* renamed from: k, reason: collision with root package name */
        private ByteBuffer f336340k;

        /* renamed from: l, reason: collision with root package name */
        private StringBuilder f336341l;

        /* renamed from: m, reason: collision with root package name */
        private ByteBuffer f336342m;

        /* renamed from: n, reason: collision with root package name */
        private final i.b.a f336343n;

        /* compiled from: P */
        /* renamed from: com.tencent.msdk.dns.core.rest.share.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        class C9220a extends a.b.C9219a {
            static IPatchRedirector $redirector_;

            C9220a() {
                super();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.msdk.dns.core.rest.share.a.b.C9219a, com.tencent.msdk.dns.core.i.b.a
            public boolean b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                if (a.this.f336338i != null) {
                    com.tencent.msdk.dns.base.log.c.c(b.this.i() + ", channel isConnected:" + a.this.f336338i.isConnected() + ", writable:" + super.b(), new Object[0]);
                    if (!a.this.f336338i.isConnected() || !super.b()) {
                        return false;
                    }
                    return true;
                }
                return super.b();
            }

            @Override // com.tencent.msdk.dns.core.rest.share.a.b.C9219a, com.tencent.msdk.dns.core.i.b.a
            public boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                if (a.this.f336338i != null) {
                    if (a.this.f336338i.isConnected() && super.c()) {
                        return true;
                    }
                    return false;
                }
                return super.c();
            }

            @Override // com.tencent.msdk.dns.core.i.b.a
            public boolean e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (a.this.f336338i != null) {
                    try {
                        if (a.this.f336338i.isConnected()) {
                            return true;
                        }
                        boolean finishConnect = a.this.f336338i.finishConnect();
                        if (finishConnect) {
                            com.tencent.msdk.dns.base.log.c.c(b.this.i() + "tryFinishConnect connect success", new Object[0]);
                            a.this.f336330d.interestOps(5);
                        }
                        return finishConnect;
                    } catch (Exception e16) {
                        com.tencent.msdk.dns.base.log.c.d(e16, b.this.i() + "tryFinishConnect connect failed", new Object[0]);
                        a.this.d();
                        a.C9218a c9218a = a.this.f336331e;
                        c9218a.f336319e = 11001;
                        c9218a.f336320f = e16.getMessage();
                    }
                }
                return false;
            }
        }

        a(n<g> nVar, i iVar, a.b bVar) {
            super(nVar, iVar, bVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, nVar, iVar, bVar);
                return;
            }
            this.f336338i = null;
            this.f336339j = null;
            this.f336340k = null;
            this.f336341l = null;
            this.f336342m = null;
            this.f336343n = new C9220a();
            if (3 == this.f336327a) {
                return;
            }
            Selector y16 = this.f336328b.y();
            try {
                if (y16 != null) {
                    try {
                        this.f336338i = SocketChannel.open();
                        com.tencent.msdk.dns.base.log.c.c(b.this.i() + "%s opened", this.f336338i);
                        try {
                            this.f336338i.configureBlocking(false);
                            try {
                                SelectionKey register = this.f336338i.register(y16, 13);
                                this.f336330d = register;
                                register.attach(this.f336338i);
                                this.f336327a = 1;
                                SocketAddress g16 = b.this.g(this.f336328b.q(), b.this.f336336b);
                                this.f336339j = g16;
                                if (g16 == null) {
                                    com.tencent.msdk.dns.base.log.c.c(b.this.i() + "get target socket address failed", new Object[0]);
                                    this.f336331e.f336319e = 1006;
                                    d();
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                a.C9218a c9218a = this.f336331e;
                                c9218a.f336319e = 1005;
                                c9218a.f336320f = e16.getMessage();
                                throw e16;
                            }
                        } catch (Exception e17) {
                            a.C9218a c9218a2 = this.f336331e;
                            c9218a2.f336319e = 1004;
                            c9218a2.f336320f = e17.getMessage();
                            throw e17;
                        }
                    } catch (Exception e18) {
                        a.C9218a c9218a3 = this.f336331e;
                        c9218a3.f336319e = 1001;
                        c9218a3.f336320f = e18.getMessage();
                        throw e18;
                    }
                }
                throw new IllegalArgumentException("selector".concat(" can not be null"));
            } catch (Exception e19) {
                com.tencent.msdk.dns.base.log.c.d(e19, b.this.i() + "create socket channel failed", new Object[0]);
                d();
            }
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public i.b.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (i.b.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f336343n;
        }

        @Override // com.tencent.msdk.dns.core.rest.share.a.b
        protected int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            try {
                com.tencent.msdk.dns.base.log.c.c(b.this.i() + "connect start", new Object[0]);
                this.f336338i.connect(this.f336339j);
                return 0;
            } catch (Exception e16) {
                com.tencent.msdk.dns.base.log.c.d(e16, b.this.i() + "connect failed", new Object[0]);
                d();
                a.C9218a c9218a = this.f336331e;
                c9218a.f336319e = 11001;
                c9218a.f336320f = e16.getMessage();
                return 1;
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.a.b
        protected a.b k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a.b) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new a(this.f336328b, this.f336329c, this);
        }

        @Override // com.tencent.msdk.dns.core.rest.share.a.b
        protected void l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            com.tencent.msdk.dns.c.e.a.d(this.f336338i);
            this.f336342m = null;
            this.f336340k = null;
            this.f336341l = null;
        }

        @Override // com.tencent.msdk.dns.core.rest.share.a.b
        protected int m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            String f16 = b.this.f(this.f336328b.q(), this.f336328b.u(), this.f336328b.w());
            if (TextUtils.isEmpty(f16)) {
                this.f336331e.f336319e = 1007;
                d();
                return 1;
            }
            String e16 = com.tencent.msdk.dns.c.e.b.e(f16);
            if (TextUtils.isEmpty(e16)) {
                this.f336331e.f336319e = 1008;
                d();
                return 1;
            }
            try {
                com.tencent.msdk.dns.base.log.c.g(b.this.i() + "send httpReq:{\n%s}", e16);
                com.tencent.msdk.dns.base.log.c.c(b.this.i() + "lookup send byUrl: %s", f16);
                if (this.f336342m == null) {
                    this.f336342m = ByteBuffer.wrap(e16.getBytes("UTF-8"));
                }
                ByteBuffer byteBuffer = this.f336342m;
                int i3 = 0;
                while (byteBuffer.hasRemaining()) {
                    int write = this.f336338i.write(byteBuffer);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(b.this.i());
                    sb5.append("send request count:");
                    i3++;
                    sb5.append(i3);
                    sb5.append(", res:");
                    sb5.append(write);
                    com.tencent.msdk.dns.base.log.c.c(sb5.toString(), new Object[0]);
                    if (write <= 0) {
                        break;
                    }
                }
                if (byteBuffer.hasRemaining()) {
                    com.tencent.msdk.dns.base.log.c.c(b.this.i() + "send request has remaining, try again", new Object[0]);
                    return 2;
                }
                this.f336342m = null;
                this.f336330d.interestOps(1);
                com.tencent.msdk.dns.base.log.c.c(b.this.i() + "send request finish", new Object[0]);
                return 0;
            } catch (Exception e17) {
                com.tencent.msdk.dns.base.log.c.d(e17, b.this.i() + "send request failed, for exception", new Object[0]);
                d();
                a.C9218a c9218a = this.f336331e;
                c9218a.f336319e = 21001;
                c9218a.f336320f = e17.getMessage();
                return 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00f5 A[EDGE_INSN: B:24:0x00f5->B:25:0x00f5 BREAK  A[LOOP:0: B:15:0x0054->B:45:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:0: B:15:0x0054->B:45:?, LOOP_END, SYNTHETIC] */
        @Override // com.tencent.msdk.dns.core.rest.share.a.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected com.tencent.msdk.dns.core.rest.share.h.a n() {
            int read;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.msdk.dns.core.rest.share.h.a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive responseInternal call", new Object[0]);
            g w3 = this.f336328b.w();
            if (this.f336340k == null) {
                this.f336340k = ByteBuffer.allocate(1024);
            }
            if (this.f336341l == null) {
                this.f336341l = new StringBuilder();
            }
            ByteBuffer byteBuffer = this.f336340k;
            StringBuilder sb5 = this.f336341l;
            int i3 = 0;
            while (true) {
                try {
                    read = this.f336338i.read(byteBuffer);
                    com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive response get len:%d, lastLen:%d", Integer.valueOf(read), Integer.valueOf(i3));
                    if (read > 0) {
                        i3 += read;
                        byteBuffer.flip();
                        read = byteBuffer.limit();
                        byte[] bArr = new byte[read];
                        byteBuffer.get(bArr, 0, read);
                        String str2 = new String(bArr, Charset.forName("UTF-8"));
                        sb5.append(str2);
                        if (com.tencent.msdk.dns.c.e.b.c(str2)) {
                            com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive response check http rsp finished:%d, so break", Integer.valueOf(read));
                            break;
                        }
                        byteBuffer.clear();
                        if (read >= 0) {
                            break;
                        }
                    } else {
                        if (read == 0) {
                            com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive response get len:0, and break", new Object[0]);
                            break;
                        }
                        if (read >= 0) {
                        }
                    }
                } catch (Exception e16) {
                    com.tencent.msdk.dns.base.log.c.d(e16, b.this.i() + "receive response failed, for exception", new Object[0]);
                    a.C9218a c9218a = this.f336331e;
                    c9218a.f336377b = true;
                    c9218a.f336319e = ITbsReaderTool.CALL_READER_API;
                    c9218a.f336320f = e16.getMessage();
                    return com.tencent.msdk.dns.core.rest.share.h.a.f336369d;
                }
            }
            com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive response get total len:%d", Integer.valueOf(i3));
            if (read == 0) {
                com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive response failed, need continue, for total len:%d", Integer.valueOf(i3));
                this.f336331e.f336319e = ITbsReaderTool.CALL_HOST_API;
                return com.tencent.msdk.dns.core.rest.share.h.a.f336370e;
            }
            if (i3 <= 0) {
                com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive response failed, for total len:%d", Integer.valueOf(i3));
                a.C9218a c9218a2 = this.f336331e;
                c9218a2.f336377b = true;
                c9218a2.f336319e = ITbsReaderTool.CALL_READER_API;
                return com.tencent.msdk.dns.core.rest.share.h.a.f336369d;
            }
            String sb6 = sb5.toString();
            com.tencent.msdk.dns.base.log.c.g(b.this.i() + "receive rspHttpRsp:{\n%s}", sb6);
            String f16 = com.tencent.msdk.dns.c.e.b.f(sb6);
            String e17 = b.this.e(f16, w3.f336367c);
            com.tencent.msdk.dns.base.log.c.c(b.this.i() + "receive rawLen:%d, raw:[%s], rsp body content:[%s]", Integer.valueOf(i3), f16, e17);
            if (TextUtils.isEmpty(e17)) {
                a.C9218a c9218a3 = this.f336331e;
                c9218a3.f336377b = true;
                c9218a3.f336319e = 41001;
                return com.tencent.msdk.dns.core.rest.share.h.a.f336369d;
            }
            com.tencent.msdk.dns.core.rest.share.h.a a16 = com.tencent.msdk.dns.core.rest.share.h.b.a(b.this.f336336b, e17);
            if (a16.f336372b == com.tencent.msdk.dns.core.e.f336253a) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(b.this.i());
                sb7.append("receive success, but no ");
                if (2 == b.this.f336336b) {
                    str = "INET6";
                } else {
                    str = "INET";
                }
                sb7.append(str);
                sb7.append(" record");
                com.tencent.msdk.dns.base.log.c.c(sb7.toString(), new Object[0]);
                a.C9218a c9218a4 = this.f336331e;
                c9218a4.f336377b = true;
                c9218a4.f336319e = 3;
                return com.tencent.msdk.dns.core.rest.share.h.a.f336369d;
            }
            return a16;
        }
    }

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        i3 = 2 != i3 ? 1 : i3;
        this.f336336b = i3;
        this.f336337c = new com.tencent.msdk.dns.core.f(h(), i3);
    }

    @Override // com.tencent.msdk.dns.core.i
    public com.tencent.msdk.dns.core.f a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f336337c : (com.tencent.msdk.dns.core.f) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.msdk.dns.core.i
    public com.tencent.msdk.dns.core.d b(o<g> oVar) {
        String f16;
        com.tencent.msdk.dns.core.rest.share.h.a a16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.msdk.dns.core.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar);
        }
        if (oVar != null) {
            String str2 = oVar.f336287b;
            int i3 = oVar.f336288c;
            String str3 = oVar.f336289d;
            g gVar = oVar.f336290e;
            a.C9218a c9218a = new a.C9218a();
            c9218a.f336323i = oVar.f336297l;
            c9218a.f336325k = oVar.f336296k;
            c9218a.f336326l = oVar.f336298m;
            c9218a.h();
            if (d(oVar, c9218a)) {
                c9218a.g();
                return new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
            }
            BufferedReader bufferedReader = null;
            try {
                try {
                    f16 = f(str3, str2, gVar);
                } catch (Exception e16) {
                    e = e16;
                }
                if (TextUtils.isEmpty(f16)) {
                    c9218a.f336319e = 1007;
                    com.tencent.msdk.dns.core.d dVar = new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
                    com.tencent.msdk.dns.c.e.a.d(null);
                    c9218a.g();
                    return dVar;
                }
                try {
                    URLConnection openConnection = new URL(f16).openConnection();
                    openConnection.setConnectTimeout(i3);
                    openConnection.setReadTimeout(i3);
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(openConnection.getInputStream(), "UTF-8"));
                    String str4 = "";
                    String str5 = "";
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                str5 = str5 + (readLine + '\n');
                            } catch (Exception e17) {
                                e = e17;
                                c9218a.f336319e = ITbsReaderTool.CALL_READER_API;
                                c9218a.f336320f = e.getMessage();
                                throw e;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            com.tencent.msdk.dns.c.e.a.d(bufferedReader);
                            c9218a.g();
                            throw th;
                        }
                    }
                    if (str5.length() > 0) {
                        str4 = str5.substring(0, str5.length() - 2);
                    }
                    bufferedReader2.close();
                    try {
                        String e18 = e(str4, gVar.f336367c);
                        com.tencent.msdk.dns.base.log.c.c(i() + "lookup byUrl: %s, rsp:[%s]", f16, e18);
                        if (TextUtils.isEmpty(e18)) {
                            c9218a.f336377b = true;
                            c9218a.f336319e = 41001;
                        }
                        a16 = com.tencent.msdk.dns.core.rest.share.h.b.a(this.f336336b, e18);
                        com.tencent.msdk.dns.base.log.c.c(i() + "lookup response: ====> %s", a16.toString());
                    } catch (Exception e19) {
                        e = e19;
                        bufferedReader = bufferedReader2;
                        com.tencent.msdk.dns.base.log.c.d(e, i() + "lookup failed", new Object[0]);
                        bufferedReader2 = bufferedReader;
                        com.tencent.msdk.dns.c.e.a.d(bufferedReader2);
                        c9218a.g();
                        return new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
                    }
                    if (a16 == com.tencent.msdk.dns.core.rest.share.h.a.f336369d) {
                        c9218a.f336377b = true;
                        c9218a.f336319e = 41002;
                        com.tencent.msdk.dns.core.d dVar2 = new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
                        com.tencent.msdk.dns.c.e.a.d(bufferedReader2);
                        c9218a.g();
                        return dVar2;
                    }
                    if (a16.f336372b == com.tencent.msdk.dns.core.e.f336253a) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(i());
                        sb5.append("receive success, but no ");
                        if (2 == this.f336336b) {
                            str = "INET6";
                        } else {
                            str = "INET";
                        }
                        sb5.append(str);
                        sb5.append(" record");
                        com.tencent.msdk.dns.base.log.c.c(sb5.toString(), new Object[0]);
                        c9218a.f336377b = true;
                        c9218a.f336319e = 3;
                        com.tencent.msdk.dns.core.d dVar3 = new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
                        com.tencent.msdk.dns.c.e.a.d(bufferedReader2);
                        c9218a.g();
                        return dVar3;
                    }
                    this.f336317a.d(oVar, a16);
                    c9218a.f336319e = 0;
                    c9218a.f336321g = a16.f336371a;
                    c9218a.f336322h = a16.f336373c;
                    c9218a.f336376a = a16.f336372b;
                    com.tencent.msdk.dns.c.e.a.d(bufferedReader2);
                    c9218a.g();
                    return new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
        }
    }

    public abstract String e(String str, String str2);

    public abstract String f(String str, String str2, g gVar);

    public abstract SocketAddress g(String str, int i3);

    public abstract String h();

    public abstract String i();

    @Override // com.tencent.msdk.dns.core.i
    public i.b a(n<g> nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new a(nVar, this, null) : (i.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) nVar);
    }
}

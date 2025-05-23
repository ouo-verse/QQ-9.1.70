package com.google.protobuf;

/* compiled from: P */
/* loaded from: classes2.dex */
public class af {

    /* renamed from: e, reason: collision with root package name */
    private static final t f35650e = t.b();

    /* renamed from: a, reason: collision with root package name */
    private ByteString f35651a;

    /* renamed from: b, reason: collision with root package name */
    private t f35652b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile au f35653c;

    /* renamed from: d, reason: collision with root package name */
    private volatile ByteString f35654d;

    public af(t tVar, ByteString byteString) {
        a(tVar, byteString);
        this.f35652b = tVar;
        this.f35651a = byteString;
    }

    private static void a(t tVar, ByteString byteString) {
        if (tVar != null) {
            if (byteString != null) {
                return;
            } else {
                throw new NullPointerException("found null ByteString");
            }
        }
        throw new NullPointerException("found null ExtensionRegistry");
    }

    protected void b(au auVar) {
        if (this.f35653c != null) {
            return;
        }
        synchronized (this) {
            if (this.f35653c != null) {
                return;
            }
            try {
                if (this.f35651a != null) {
                    this.f35653c = auVar.getParserForType().a(this.f35651a, this.f35652b);
                    this.f35654d = this.f35651a;
                } else {
                    this.f35653c = auVar;
                    this.f35654d = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f35653c = auVar;
                this.f35654d = ByteString.EMPTY;
            }
        }
    }

    public int c() {
        if (this.f35654d != null) {
            return this.f35654d.size();
        }
        ByteString byteString = this.f35651a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f35653c != null) {
            return this.f35653c.getSerializedSize();
        }
        return 0;
    }

    public au d(au auVar) {
        b(auVar);
        return this.f35653c;
    }

    public au e(au auVar) {
        au auVar2 = this.f35653c;
        this.f35651a = null;
        this.f35654d = null;
        this.f35653c = auVar;
        return auVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof af)) {
            return false;
        }
        af afVar = (af) obj;
        au auVar = this.f35653c;
        au auVar2 = afVar.f35653c;
        if (auVar == null && auVar2 == null) {
            return f().equals(afVar.f());
        }
        if (auVar != null && auVar2 != null) {
            return auVar.equals(auVar2);
        }
        if (auVar != null) {
            return auVar.equals(afVar.d(auVar.getDefaultInstanceForType()));
        }
        return d(auVar2.getDefaultInstanceForType()).equals(auVar2);
    }

    public ByteString f() {
        if (this.f35654d != null) {
            return this.f35654d;
        }
        ByteString byteString = this.f35651a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f35654d != null) {
                return this.f35654d;
            }
            if (this.f35653c == null) {
                this.f35654d = ByteString.EMPTY;
            } else {
                this.f35654d = this.f35653c.toByteString();
            }
            return this.f35654d;
        }
    }

    public int hashCode() {
        return 1;
    }

    public af() {
    }
}

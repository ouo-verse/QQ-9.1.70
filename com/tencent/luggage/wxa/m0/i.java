package com.tencent.luggage.wxa.m0;

import com.tencent.luggage.wxa.m0.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f133991a;

    /* renamed from: b, reason: collision with root package name */
    public final String f133992b;

    /* renamed from: c, reason: collision with root package name */
    public final TreeSet f133993c;

    /* renamed from: d, reason: collision with root package name */
    public long f133994d;

    public i(DataInputStream dataInputStream) {
        this(dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readLong());
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.f133991a);
        dataOutputStream.writeUTF(this.f133992b);
        dataOutputStream.writeLong(this.f133994d);
    }

    public void b(long j3) {
        this.f133994d = j3;
    }

    public int c() {
        int hashCode = ((this.f133991a * 31) + this.f133992b.hashCode()) * 31;
        long j3 = this.f133994d;
        return hashCode + ((int) (j3 ^ (j3 >>> 32)));
    }

    public boolean d() {
        return this.f133993c.isEmpty();
    }

    public i(int i3, String str, long j3) {
        this.f133991a = i3;
        this.f133992b = str;
        this.f133994d = j3;
        this.f133993c = new TreeSet();
    }

    public TreeSet b() {
        return this.f133993c;
    }

    public n b(n nVar) {
        com.tencent.luggage.wxa.n0.a.b(this.f133993c.remove(nVar));
        n a16 = nVar.a(this.f133991a);
        if (nVar.f133989e.renameTo(a16.f133989e)) {
            this.f133993c.add(a16);
            return a16;
        }
        throw new a.C6454a("Renaming of " + nVar.f133989e + " to " + a16.f133989e + " failed.");
    }

    public long a() {
        return this.f133994d;
    }

    public void a(n nVar) {
        this.f133993c.add(nVar);
    }

    public n a(long j3) {
        n a16 = n.a(this.f133992b, j3);
        n nVar = (n) this.f133993c.floor(a16);
        if (nVar != null && nVar.f133986b + nVar.f133987c > j3) {
            return nVar;
        }
        n nVar2 = (n) this.f133993c.ceiling(a16);
        if (nVar2 == null) {
            return n.b(this.f133992b, j3);
        }
        return n.a(this.f133992b, j3, nVar2.f133986b - j3);
    }

    public long a(long j3, long j16) {
        n a16 = a(j3);
        if (a16.a()) {
            return -Math.min(a16.b() ? Long.MAX_VALUE : a16.f133987c, j16);
        }
        long j17 = j3 + j16;
        long j18 = a16.f133986b + a16.f133987c;
        if (j18 < j17) {
            for (n nVar : this.f133993c.tailSet(a16, false)) {
                long j19 = nVar.f133986b;
                if (j19 > j18) {
                    break;
                }
                j18 = Math.max(j18, j19 + nVar.f133987c);
                if (j18 >= j17) {
                    break;
                }
            }
        }
        return Math.min(j18 - j3, j16);
    }

    public boolean a(g gVar) {
        if (!this.f133993c.remove(gVar)) {
            return false;
        }
        gVar.f133989e.delete();
        return true;
    }
}

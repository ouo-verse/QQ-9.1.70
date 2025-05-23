package com.tencent.luggage.wxa.cp;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.dp.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f extends com.tencent.luggage.wxa.cp.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements a.InterfaceC6145a, c.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f123746a;

        /* renamed from: b, reason: collision with root package name */
        public final HashSet f123747b = new HashSet();

        public a(String str) {
            this.f123746a = str;
        }

        @Override // com.tencent.luggage.wxa.dp.a.InterfaceC6145a
        public Iterable a(k.a aVar) {
            return aVar.e(this.f123746a);
        }

        @Override // com.tencent.luggage.wxa.dp.c.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return iVar == null || !this.f123747b.add(iVar.f123765a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements a.InterfaceC6145a, c.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f123748a;

        /* renamed from: b, reason: collision with root package name */
        public final HashSet f123749b = new HashSet();

        public b(String str) {
            this.f123748a = str;
        }

        @Override // com.tencent.luggage.wxa.dp.a.InterfaceC6145a
        public Iterable a(k.a aVar) {
            return aVar.f(this.f123748a);
        }

        @Override // com.tencent.luggage.wxa.dp.c.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(String str) {
            return str == null || !this.f123749b.add(str);
        }
    }

    public f(k kVar, Map map) {
        super(kVar, map);
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public int a() {
        return a("", 0).a();
    }

    public abstract k.a a(String str, int i3);

    public Iterable b(String str, int i3) {
        return c();
    }

    @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
    public WritableByteChannel c(String str, boolean z16) {
        k.a a16 = a(str, z16 ? 3 : 2);
        if (a16 != null) {
            if (!z16 && c().size() > 1) {
                try {
                    return a16.c(str, false);
                } catch (FileNotFoundException e16) {
                    if (e(str, false)) {
                        return a16.c(str, false);
                    }
                    throw e16;
                }
            }
            return a16.c(str, z16);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    public abstract List c();

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean d(String str) {
        k.a a16 = a(str, 2);
        return a16 != null && a16.d(str);
    }

    public final boolean e(String str, boolean z16) {
        i c16;
        String b16 = c0.b(str);
        if (b16 == null) {
            return false;
        }
        k.a a16 = a(b16, 2);
        while (z16 && (a16 instanceof f)) {
            a16 = ((f) a16).a(b16, 2);
        }
        k.a a17 = a(b16, 1);
        while (z16 && (a17 instanceof f)) {
            a17 = ((f) a17).a(b16, 1);
        }
        if (a16 == a17 || a16.i(b16) || (c16 = a17.c(b16)) == null || !c16.f123770f) {
            return false;
        }
        return a16.d(b16);
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public Iterable f(String str) {
        List a16 = c0.a(b(str, 4));
        int size = a16.size();
        if (size == 1) {
            return ((k.a) a16.get(0)).f(str);
        }
        if (size == 0) {
            return null;
        }
        b bVar = new b(str);
        return new com.tencent.luggage.wxa.dp.c(new com.tencent.luggage.wxa.dp.a(a16, bVar), bVar);
    }

    @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
    public ReadableByteChannel g(String str) {
        k.a a16 = a(str, 1);
        if (a16 != null) {
            return a16.g(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean i(String str) {
        k.a a16 = a(str, 1);
        if (a16 != null && a16.i(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean b(String str) {
        Iterator it = b(str, 5).iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= ((k.a) it.next()).b(str);
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public InputStream a(String str) {
        k.a a16 = a(str, 1);
        if (a16 != null) {
            return a16.a(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public String d(String str, boolean z16) {
        k.a a16 = a(str, z16 ? 2 : 1);
        if (a16 == null) {
            return null;
        }
        return a16.d(str, z16);
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean b(String str, boolean z16) {
        Iterator it = b(str, 5).iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            z17 |= ((k.a) it.next()).b(str, z16);
        }
        return z17;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public OutputStream a(String str, boolean z16) {
        k.a a16 = a(str, z16 ? 3 : 2);
        if (a16 != null) {
            if (!z16 && c().size() > 1) {
                try {
                    return a16.a(str, false);
                } catch (FileNotFoundException e16) {
                    if (e(str, false)) {
                        return a16.a(str, false);
                    }
                    throw e16;
                }
            }
            return a16.a(str, z16);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.luggage.wxa.cp.b
    public final boolean b(String str, k.a aVar, String str2) {
        throw new AssertionError();
    }

    @Override // com.tencent.luggage.wxa.cp.b
    public final long b(String str, k.a aVar, String str2, boolean z16) {
        throw new AssertionError();
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public i c(String str) {
        k.a a16 = a(str, 1);
        if (a16 == null) {
            return null;
        }
        return a16.c(str);
    }

    @Override // com.tencent.luggage.wxa.cp.b
    public boolean c(String str, k.a aVar, String str2) {
        throw new AssertionError();
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public Iterable e(String str) {
        List a16 = c0.a(b(str, 4));
        int size = a16.size();
        if (size == 1) {
            return ((k.a) a16.get(0)).e(str);
        }
        if (size == 0) {
            return null;
        }
        a aVar = new a(str);
        return new com.tencent.luggage.wxa.dp.c(new com.tencent.luggage.wxa.dp.a(a16, aVar), aVar);
    }

    @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
    public ParcelFileDescriptor a(String str, String str2) {
        int i3;
        if (str2.contains("rw")) {
            i3 = 3;
        } else {
            i3 = str2.contains("w") ? 2 : 1;
        }
        k.a a16 = a(str, i3);
        if (a16 != null) {
            return a16.a(str, str2);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
    public boolean a(String str, k.a aVar, String str2) {
        if (str.equals(str2) && equals(aVar)) {
            return false;
        }
        boolean a16 = super.a(str, aVar, str2);
        return (a16 || !e(str, true)) ? a16 : super.a(str, aVar, str2);
    }

    @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
    public long a(String str, k.a aVar, String str2, boolean z16) {
        if (str.equals(str2) && equals(aVar)) {
            throw new IOException("Copying within the same filesystem is not allowed: " + str + " -> " + this);
        }
        try {
            return super.a(str, aVar, str2, z16);
        } catch (FileNotFoundException e16) {
            if (e(str, true)) {
                return super.a(str, aVar, str2, z16);
            }
            throw e16;
        }
    }

    @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
    public void a(CancellationSignal cancellationSignal) {
        for (k.a aVar : c()) {
            cancellationSignal.throwIfCanceled();
            aVar.a(cancellationSignal);
        }
    }
}

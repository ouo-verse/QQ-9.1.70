package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements com.android.volley.f {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    protected final g f31393a;

    /* renamed from: b, reason: collision with root package name */
    private final a f31394b;

    /* renamed from: c, reason: collision with root package name */
    protected final c f31395c;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    @Override // com.android.volley.f
    public com.android.volley.g a(Request<?> request) throws VolleyError {
        IOException iOException;
        f fVar;
        byte[] bArr;
        f a16;
        int d16;
        List<com.android.volley.e> c16;
        byte[] bArr2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                a16 = this.f31394b.a(request, e.c(request.getCacheEntry()));
                try {
                    d16 = a16.d();
                    c16 = a16.c();
                    break;
                } catch (IOException e16) {
                    bArr = null;
                    fVar = a16;
                    iOException = e16;
                }
            } catch (IOException e17) {
                iOException = e17;
                fVar = null;
                bArr = null;
            }
            j.a(request, j.e(request, iOException, elapsedRealtime, fVar, bArr));
        }
        if (d16 == 304) {
            return j.b(request, SystemClock.elapsedRealtime() - elapsedRealtime, c16);
        }
        InputStream a17 = a16.a();
        if (a17 != null) {
            bArr2 = j.c(a17, a16.b(), this.f31395c);
        } else {
            bArr2 = new byte[0];
        }
        j.d(SystemClock.elapsedRealtime() - elapsedRealtime, request, bArr2, d16);
        if (d16 >= 200 && d16 <= 299) {
            return new com.android.volley.g(d16, bArr2, false, SystemClock.elapsedRealtime() - elapsedRealtime, c16);
        }
        throw new IOException();
    }

    public b(a aVar, c cVar) {
        this.f31394b = aVar;
        this.f31393a = aVar;
        this.f31395c = cVar;
    }
}

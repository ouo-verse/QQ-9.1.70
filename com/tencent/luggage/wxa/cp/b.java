package com.tencent.luggage.wxa.cp;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements k.a {
    public b() {
    }

    public void a(int i3, Object... objArr) {
    }

    public boolean b(String str, k.a aVar, String str2) {
        return false;
    }

    public boolean c(String str, k.a aVar, String str2) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public ReadableByteChannel g(String str) {
        return Channels.newChannel(a(str));
    }

    public String toString() {
        return "State -> " + b();
    }

    public b(k kVar, Map map) {
        if (kVar instanceof a) {
            ((a) kVar).getClass();
        }
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public void a(CancellationSignal cancellationSignal) {
    }

    public long b(String str, k.a aVar, String str2, boolean z16) {
        return c0.a(aVar, str2, this, str);
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public WritableByteChannel c(String str, boolean z16) {
        return Channels.newChannel(a(str, z16));
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public ParcelFileDescriptor a(String str, String str2) {
        throw new FileNotFoundException("Not supported by the filesystem.");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean a(String str, k.a aVar, String str2) {
        k.a a16 = c0.a(this, str, 2);
        k.a a17 = c0.a(aVar, str2, 1);
        if (a16 != null && a17 != null) {
            if ((a17 instanceof b) && !((b) a17).c(str2, a16, str)) {
                return false;
            }
            if (a16 instanceof b) {
                return ((b) a16).b(str, a17, str2);
            }
            return a16.a(str, a17, str2);
        }
        throw new IOException("Cannot resolve delegate filesystem.");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public long a(String str, k.a aVar, String str2, boolean z16) {
        k.a a16 = c0.a(this, str, 2);
        k.a a17 = c0.a(aVar, str2, 1);
        if (a16 != null && a17 != null) {
            if (a16 instanceof b) {
                return ((b) a16).b(str, a17, str2, z16);
            }
            return a16.a(str, a17, str2, z16);
        }
        throw new IOException("Cannot resolve delegate filesystem.");
    }
}

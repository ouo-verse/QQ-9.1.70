package com.tencent.luggage.wxa.cp;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.k;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o implements k.a {
    @Override // com.tencent.luggage.wxa.cp.k.a
    public int a() {
        return 28;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean b(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public i c(String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public String d(String str, boolean z16) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public Iterable e(String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public Iterable f(String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public ReadableByteChannel g(String str) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean i(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public void a(CancellationSignal cancellationSignal) {
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean b(String str, boolean z16) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public WritableByteChannel c(String str, boolean z16) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean d(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public boolean a(String str, k.a aVar, String str2) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public InputStream a(String str) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public OutputStream a(String str, boolean z16) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public ParcelFileDescriptor a(String str, String str2) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.luggage.wxa.cp.k.a
    public long a(String str, k.a aVar, String str2, boolean z16) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }
}

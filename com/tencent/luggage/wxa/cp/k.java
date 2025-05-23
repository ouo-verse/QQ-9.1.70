package com.tencent.luggage.wxa.cp;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface k extends Parcelable, d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        int a();

        long a(String str, a aVar, String str2, boolean z16);

        ParcelFileDescriptor a(String str, String str2);

        InputStream a(String str);

        OutputStream a(String str, boolean z16);

        void a(CancellationSignal cancellationSignal);

        boolean a(String str, a aVar, String str2);

        k b();

        boolean b(String str);

        boolean b(String str, boolean z16);

        i c(String str);

        WritableByteChannel c(String str, boolean z16);

        String d(String str, boolean z16);

        boolean d(String str);

        Iterable e(String str);

        Iterable f(String str);

        ReadableByteChannel g(String str);

        boolean i(String str);
    }
}

package com.tencent.luggage.wxa.b;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, com.tencent.luggage.wxa.b.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        String a(String str);

        String[] a();

        String b(String str);

        void c(String str);

        void loadLibrary(String str);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6025c {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(String str);
    }

    public static com.tencent.luggage.wxa.b.d a(d dVar) {
        return new com.tencent.luggage.wxa.b.d().a(dVar);
    }
}

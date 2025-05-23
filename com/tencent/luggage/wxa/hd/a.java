package com.tencent.luggage.wxa.hd;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.io.InputStream;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends com.tencent.luggage.wxa.h1.b {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.hd.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6261a {
        Bitmap a(String str, Rect rect, b bVar);

        void a(String str, Map map, c cVar);

        boolean a(String str);

        String b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(InputStream inputStream);
    }

    void a(String str, Map map, c cVar);

    Bitmap b(String str, Rect rect, b bVar);
}

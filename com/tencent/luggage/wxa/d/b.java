package com.tencent.luggage.wxa.d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.LegacyBitmap;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.d.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Map f123866a = new HashMap(3);

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f123867b = new SparseArray();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.f.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.f.b
        public boolean a(InputStream inputStream, Bitmap.Config config, com.tencent.luggage.wxa.f.c cVar) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.f.b
        public IBitmap a() {
            return new c.b();
        }

        @Override // com.tencent.luggage.wxa.f.b
        public void destroy() {
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6123b implements com.tencent.luggage.wxa.f.b {
        public C6123b() {
        }

        @Override // com.tencent.luggage.wxa.f.b
        public boolean a(InputStream inputStream, Bitmap.Config config, com.tencent.luggage.wxa.f.c cVar) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.f.b
        public IBitmap a() {
            return new LegacyBitmap();
        }

        @Override // com.tencent.luggage.wxa.f.b
        public void destroy() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.f.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.f.b
        public boolean a(InputStream inputStream, Bitmap.Config config, com.tencent.luggage.wxa.f.c cVar) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.f.b
        public IBitmap a() {
            return new c.a();
        }

        @Override // com.tencent.luggage.wxa.f.b
        public void destroy() {
        }
    }

    public b() {
        this.f123866a.put(BitmapType.Native, new a());
        this.f123866a.put(BitmapType.Legacy, new C6123b());
        this.f123866a.put(BitmapType.Undefined, new c());
    }

    public final void a(Map map) {
        if (map == null) {
            return;
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxa.f.b) it.next()).destroy();
        }
    }

    public IBitmap b() {
        return ((com.tencent.luggage.wxa.f.b) this.f123866a.get(BitmapType.Legacy)).a();
    }

    public void a() {
        for (int i3 = 0; i3 < this.f123867b.size(); i3++) {
            a((Map) this.f123867b.get(this.f123867b.keyAt(i3)));
        }
        a(this.f123866a);
    }

    public void a(BitmapType bitmapType, com.tencent.luggage.wxa.f.b bVar) {
        this.f123866a.put(bitmapType, bVar);
    }

    public void a(int i3, BitmapType bitmapType, com.tencent.luggage.wxa.f.b bVar) {
        Map map = (Map) this.f123867b.get(i3);
        if (map == null) {
            map = new HashMap(2);
        }
        map.put(bitmapType, bVar);
        this.f123867b.append(i3, map);
    }

    public IBitmap a(int i3, InputStream inputStream, Bitmap.Config config, com.tencent.luggage.wxa.f.c cVar) {
        Map map = (Map) this.f123867b.get(i3);
        IBitmap a16 = map != null ? a(inputStream, config, cVar, map) : null;
        return a16 == null ? a(inputStream, config, cVar, this.f123866a) : a16;
    }

    public IBitmap a(int i3, BitmapType bitmapType) {
        Map map = (Map) this.f123867b.get(i3);
        if (map != null && map.get(bitmapType) != null) {
            return ((com.tencent.luggage.wxa.f.b) map.get(bitmapType)).a();
        }
        if (this.f123866a.get(bitmapType) != null) {
            return ((com.tencent.luggage.wxa.f.b) this.f123866a.get(bitmapType)).a();
        }
        return null;
    }

    public final IBitmap a(InputStream inputStream, Bitmap.Config config, com.tencent.luggage.wxa.f.c cVar, Map map) {
        BitmapType bitmapType = BitmapType.Native;
        if (((com.tencent.luggage.wxa.f.b) map.get(bitmapType)).a(inputStream, config, cVar)) {
            return ((com.tencent.luggage.wxa.f.b) map.get(bitmapType)).a();
        }
        BitmapType bitmapType2 = BitmapType.Legacy;
        if (((com.tencent.luggage.wxa.f.b) map.get(bitmapType2)).a(inputStream, config, cVar)) {
            return ((com.tencent.luggage.wxa.f.b) map.get(bitmapType2)).a();
        }
        return ((com.tencent.luggage.wxa.f.b) map.get(BitmapType.Undefined)).a();
    }
}

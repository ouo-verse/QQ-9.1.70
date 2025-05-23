package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private static int f308433a = 57600;

    /* renamed from: b, reason: collision with root package name */
    private static int f308434b = -1;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f308435a;

        /* renamed from: b, reason: collision with root package name */
        public long f308436b;

        /* renamed from: c, reason: collision with root package name */
        public long f308437c;

        /* renamed from: d, reason: collision with root package name */
        public int f308438d;

        /* renamed from: e, reason: collision with root package name */
        public byte f308439e;

        /* renamed from: f, reason: collision with root package name */
        public int f308440f;

        /* renamed from: g, reason: collision with root package name */
        public SparseArray<a> f308441g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f308442h = false;

        public static a a() {
            return new a();
        }

        public static a b(int i3, byte b16) {
            a aVar = new a();
            aVar.f308440f = i3;
            aVar.f308439e = b16;
            return aVar;
        }

        public int c() {
            return Color.rgb((int) this.f308435a, (int) this.f308436b, (int) this.f308437c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: b, reason: collision with root package name */
        public List<a> f308444b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public SparseArray<List<a>> f308445c = new SparseArray<>();

        /* renamed from: a, reason: collision with root package name */
        a f308443a = a.a();

        public a a(int i3) {
            int i16;
            int i17;
            int i18;
            a aVar = this.f308443a;
            int red = Color.red(i3);
            int green = Color.green(i3);
            int blue = Color.blue(i3);
            int i19 = 128;
            byte b16 = 1;
            while (true) {
                if (b16 > 8) {
                    break;
                }
                boolean z16 = false;
                if ((red & i19) == 0) {
                    i16 = 0;
                } else {
                    i16 = 1;
                }
                int i26 = i16 * 4;
                if ((green & i19) == 0) {
                    i17 = 0;
                } else {
                    i17 = 1;
                }
                int i27 = i17 * 2;
                if ((blue & i19) == 0) {
                    i18 = 0;
                } else {
                    i18 = 1;
                }
                int i28 = i26 + i27 + i18;
                if (aVar.f308441g == null) {
                    aVar.f308441g = new SparseArray<>();
                }
                if (aVar.f308441g.get(i28) == null) {
                    a b17 = a.b(i28, b16);
                    aVar.f308441g.put(i28, b17);
                    if (b16 == 8) {
                        z16 = true;
                    }
                    b17.f308442h = z16;
                    if (z16) {
                        this.f308444b.add(b17);
                    } else {
                        if (this.f308445c.get(b16) == null) {
                            this.f308445c.put(b16, new ArrayList());
                        }
                        this.f308445c.get(b16).add(b17);
                    }
                }
                aVar = aVar.f308441g.get(i28);
                if (aVar.f308442h) {
                    aVar.f308435a += red;
                    aVar.f308436b += green;
                    aVar.f308437c += blue;
                    aVar.f308438d++;
                    break;
                }
                b16 = (byte) (b16 + 1);
                i19 >>= 1;
            }
            return aVar;
        }

        public void b() {
            int i3 = 7;
            while (i3 > 0 && this.f308445c.get(i3).isEmpty()) {
                i3--;
            }
            List<a> list = this.f308445c.get(i3);
            if (list != null && !list.isEmpty()) {
                a aVar = list.get(list.size() - 1);
                list.remove(aVar);
                for (int i16 = 0; i16 < 8; i16++) {
                    a aVar2 = aVar.f308441g.get(i16);
                    if (aVar2 != null) {
                        aVar.f308435a += aVar2.f308435a;
                        aVar.f308436b += aVar2.f308436b;
                        aVar.f308437c += aVar2.f308437c;
                        aVar.f308438d += aVar2.f308438d;
                        this.f308444b.remove(aVar2);
                    }
                }
                aVar.f308441g.clear();
                aVar.f308441g = null;
                aVar.f308442h = true;
                this.f308444b.add(aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        private static final Comparator<a> f308446b = new a();

        /* renamed from: a, reason: collision with root package name */
        private List<a> f308447a;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements Comparator<a> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(a aVar, a aVar2) {
                return aVar2.f308438d - aVar.f308438d;
            }
        }

        public void a(int[] iArr, int i3) {
            b bVar = new b();
            for (int i16 : iArr) {
                bVar.a(i16);
                while (bVar.f308444b.size() > i3) {
                    bVar.b();
                }
            }
            this.f308447a = new ArrayList();
            for (a aVar : bVar.f308444b) {
                float f16 = (float) aVar.f308435a;
                int i17 = aVar.f308438d;
                aVar.f308435a = (int) (f16 / i17);
                aVar.f308436b = (int) (((float) aVar.f308436b) / i17);
                aVar.f308437c = (int) (((float) aVar.f308437c) / i17);
                this.f308447a.add(aVar);
            }
            Collections.sort(this.f308447a, f308446b);
        }

        public List<a> b() {
            List<a> list = this.f308447a;
            if (list == null) {
                return null;
            }
            return Collections.unmodifiableList(list);
        }
    }

    public static List<a> a(Bitmap bitmap) {
        Bitmap c16;
        if (bitmap != null && (c16 = c(bitmap)) != null && !c16.isRecycled()) {
            c cVar = new c();
            try {
                cVar.a(b(c16), 16);
            } catch (OutOfMemoryError e16) {
                QLog.e("VasPalette", 1, e16.getMessage());
            }
            c16.recycle();
            return cVar.b();
        }
        return null;
    }

    private static int[] b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    private static Bitmap c(Bitmap bitmap) {
        int max;
        int i3;
        double d16 = -1.0d;
        if (f308433a > 0) {
            int width = bitmap.getWidth() * bitmap.getHeight();
            int i16 = f308433a;
            if (width > i16) {
                d16 = Math.sqrt(i16 / width);
            }
        } else if (f308434b > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i3 = f308434b)) {
            d16 = i3 / max;
        }
        if (d16 <= 0.0d) {
            return bitmap;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d16), (int) Math.ceil(bitmap.getHeight() * d16), false);
        } catch (OutOfMemoryError e16) {
            QLog.e("VasPalette", 1, "scaleBitmapDown failed.", e16);
            return null;
        }
    }
}

package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ll;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ki extends ka {

    /* renamed from: a, reason: collision with root package name */
    public static final int f148972a = 10;

    /* renamed from: h, reason: collision with root package name */
    private static final ll.a f148973h;

    /* renamed from: i, reason: collision with root package name */
    private static final ll.g<ll.i<Bitmap>> f148974i;

    /* renamed from: c, reason: collision with root package name */
    protected Bitmap f148976c;

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f148977d;

    /* renamed from: e, reason: collision with root package name */
    public int f148978e;

    /* renamed from: f, reason: collision with root package name */
    public String f148979f;

    /* renamed from: b, reason: collision with root package name */
    protected final AtomicInteger f148975b = new AtomicInteger();

    /* renamed from: g, reason: collision with root package name */
    protected final Object f148980g = new Object();

    static {
        ll.a aVar = new ll.a(Bitmap.Config.ARGB_8888);
        f148973h = aVar;
        f148974i = ll.a(aVar);
    }

    public ki() {
    }

    public static void a(ll.a aVar) {
        ll.a aVar2 = f148973h;
        if (aVar != null) {
            aVar2.f149208a = aVar.f149208a;
            aVar2.f149209b = aVar.f149209b;
            aVar2.f149210c = aVar.f149210c;
        }
    }

    private void h() {
        byte[] bArr;
        Bitmap bitmap = this.f148976c;
        if (bitmap == null && (bArr = this.f148977d) != null) {
            this.f148978e = bArr.length;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            synchronized (this.f148980g) {
                this.f148978e = this.f148976c.getAllocationByteCount();
            }
        }
    }

    private void i() {
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && !bitmap.isRecycled()) {
            synchronized (this.f148980g) {
                this.f148979f = hn.a(this.f148976c);
            }
        }
    }

    private String j() {
        return this.f148979f;
    }

    @Override // com.tencent.mapsdk.internal.ka
    public final byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th5;
        byte[] bArr = this.f148977d;
        if (bArr != null) {
            return bArr;
        }
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && !bitmap.isRecycled()) {
            synchronized (this.f148980g) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th6) {
                    byteArrayOutputStream = null;
                    th5 = th6;
                }
                try {
                    if (this.f148976c.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        ku.a(byteArrayOutputStream);
                        return byteArray;
                    }
                    ku.a(byteArrayOutputStream);
                } catch (Throwable th7) {
                    th5 = th7;
                    ku.a(byteArrayOutputStream);
                    throw th5;
                }
            }
        }
        return new byte[0];
    }

    public final synchronized Bitmap c() {
        if (this.f148976c == null) {
            a(this.f148977d);
        }
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && bitmap.isRecycled()) {
            return null;
        }
        return this.f148976c;
    }

    public final void d() {
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && !bitmap.isRecycled()) {
            int decrementAndGet = this.f148975b.decrementAndGet();
            lc.a(ky.f149113s).a("decrement refCount:" + decrementAndGet + " id = " + this.f148979f);
        }
    }

    public final void e() {
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && !bitmap.isRecycled()) {
            int incrementAndGet = this.f148975b.incrementAndGet();
            lc.a(ky.f149113s).a("increment refCount:" + incrementAndGet + " id = " + this.f148979f);
        }
    }

    public boolean f() {
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && !bitmap.isRecycled() && this.f148975b.decrementAndGet() <= 0) {
            synchronized (this.f148980g) {
                this.f148976c.recycle();
            }
            lc.a(ky.f149113s).a("recycle out");
        }
        this.f148977d = null;
        Bitmap bitmap2 = this.f148976c;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        boolean isRecycled;
        if (this.f148976c != null) {
            synchronized (this.f148980g) {
                isRecycled = this.f148976c.isRecycled();
            }
            return isRecycled;
        }
        byte[] bArr = this.f148977d;
        if (bArr != null && bArr.length != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "BitmapData{id='" + this.f148979f + "'}";
    }

    public ki(Bitmap bitmap) {
        this.f148976c = bitmap;
        i();
        h();
    }

    @Override // com.tencent.mapsdk.internal.ka
    public final int a() {
        return this.f148978e;
    }

    @Override // com.tencent.mapsdk.internal.ka
    public final void a(byte[] bArr) {
        int i3;
        f();
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        this.f148977d = bArr;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Exception e16) {
            LogUtil.a(ky.f149113s, "BitmapData testOpts decodingByteArray exception: ", e16.fillInStackTrace());
        }
        int i16 = options.outWidth;
        if (i16 <= 0 || (i3 = options.outHeight) <= 0) {
            return;
        }
        ll.a aVar = f148973h;
        aVar.f149208a = i16;
        aVar.f149209b = i3;
        boolean z16 = false;
        Bitmap bitmap = null;
        for (int i17 = 0; !z16 && i17 < 20; i17++) {
            ll.i<Bitmap> a16 = f148974i.a();
            if (a16 != null) {
                bitmap = a16.f149217a;
                if (!bitmap.isRecycled() && bitmap.getWidth() == options.outWidth && bitmap.getHeight() == options.outHeight) {
                    z16 = true;
                }
            }
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        if (z16) {
            options2.inBitmap = bitmap;
        }
        options2.inSampleSize = 1;
        options2.inMutable = true;
        try {
            synchronized (this.f148980g) {
                this.f148976c = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
            }
        } catch (Exception e17) {
            LogUtil.a(ky.f149113s, "BitmapData opts decodingByteArray exception: ", e17.fillInStackTrace());
        }
        this.f148977d = null;
        i();
        h();
    }

    public ki(byte[] bArr) {
        this.f148977d = bArr;
        if (bArr != null) {
            a(bArr);
        }
    }
}

package a11;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.libra.util.apng.decode.e;
import com.tencent.libra.util.apng.decode.f;
import com.tencent.libra.util.apng.decode.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends com.tencent.libra.base.animation.decode.a<h11.a, b11.a> {

    /* renamed from: l, reason: collision with root package name */
    private static final byte[] f25339l = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: m, reason: collision with root package name */
    private static final byte[] f25340m = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, Constants.VIRTUAL_GAMEPAD_SDK_DATA, -126};

    /* renamed from: n, reason: collision with root package name */
    private static final ThreadLocal<CRC32> f25341n = new ThreadLocal<>();

    /* renamed from: g, reason: collision with root package name */
    public final byte f25342g;

    /* renamed from: h, reason: collision with root package name */
    public final byte f25343h;

    /* renamed from: i, reason: collision with root package name */
    byte[] f25344i;

    /* renamed from: j, reason: collision with root package name */
    List<com.tencent.libra.util.apng.decode.b> f25345j;

    /* renamed from: k, reason: collision with root package name */
    List<com.tencent.libra.util.apng.decode.b> f25346k;

    public b(h11.a aVar, com.tencent.libra.util.apng.decode.c cVar) {
        super(aVar);
        this.f25345j = new ArrayList();
        this.f25346k = new ArrayList();
        this.f25342g = cVar.f118830m;
        this.f25343h = cVar.f118829l;
        int i3 = cVar.f118827j * 1000;
        short s16 = cVar.f118828k;
        int i16 = i3 / (s16 == 0 ? (short) 100 : s16);
        this.f118622f = i16;
        if (i16 < 10) {
            this.f118622f = 100;
        }
        this.f118618b = cVar.f118823f;
        this.f118619c = cVar.f118824g;
        this.f118620d = cVar.f118825h;
        this.f118621e = cVar.f118826i;
    }

    private int c(b11.a aVar) throws IOException {
        int i3;
        Iterator<com.tencent.libra.util.apng.decode.b> it = this.f25346k.iterator();
        int i16 = 33;
        while (it.hasNext()) {
            i16 += it.next().f118817a + 12;
        }
        for (com.tencent.libra.util.apng.decode.b bVar : this.f25345j) {
            if (bVar instanceof e) {
                i3 = bVar.f118817a + 12;
            } else if (bVar instanceof com.tencent.libra.util.apng.decode.d) {
                i3 = bVar.f118817a + 8;
            }
            i16 += i3;
        }
        int length = i16 + f25340m.length;
        aVar.d(length);
        aVar.c(f25339l);
        aVar.h(13);
        int a16 = aVar.a();
        aVar.g(g.f118835h);
        aVar.h(this.f118618b);
        aVar.h(this.f118619c);
        aVar.c(this.f25344i);
        CRC32 d16 = d();
        d16.reset();
        d16.update(aVar.f(), a16, 17);
        aVar.h((int) d16.getValue());
        for (com.tencent.libra.util.apng.decode.b bVar2 : this.f25346k) {
            if (!(bVar2 instanceof f)) {
                ((h11.a) this.f118617a).reset();
                ((h11.a) this.f118617a).skip(bVar2.f118820d);
                ((h11.a) this.f118617a).read(aVar.f(), aVar.a(), bVar2.f118817a + 12);
                aVar.e(bVar2.f118817a + 12);
            }
        }
        for (com.tencent.libra.util.apng.decode.b bVar3 : this.f25345j) {
            if (bVar3 instanceof e) {
                ((h11.a) this.f118617a).reset();
                ((h11.a) this.f118617a).skip(bVar3.f118820d);
                ((h11.a) this.f118617a).read(aVar.f(), aVar.a(), bVar3.f118817a + 12);
                aVar.e(bVar3.f118817a + 12);
            } else if (bVar3 instanceof com.tencent.libra.util.apng.decode.d) {
                aVar.h(bVar3.f118817a - 4);
                int a17 = aVar.a();
                aVar.g(e.f118833e);
                ((h11.a) this.f118617a).reset();
                ((h11.a) this.f118617a).skip(bVar3.f118820d + 4 + 4 + 4);
                ((h11.a) this.f118617a).read(aVar.f(), aVar.a(), bVar3.f118817a - 4);
                aVar.e(bVar3.f118817a - 4);
                d16.reset();
                d16.update(aVar.f(), a17, bVar3.f118817a);
                aVar.h((int) d16.getValue());
            }
        }
        aVar.c(f25340m);
        return length;
    }

    private CRC32 d() {
        ThreadLocal<CRC32> threadLocal = f25341n;
        CRC32 crc32 = threadLocal.get();
        if (crc32 == null) {
            CRC32 crc322 = new CRC32();
            threadLocal.set(crc322);
            return crc322;
        }
        return crc32;
    }

    @Override // com.tencent.libra.base.animation.decode.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap a(Canvas canvas, Paint paint, int i3, Bitmap bitmap, b11.a aVar) {
        Bitmap bitmap2;
        try {
            int c16 = c(aVar);
            com.tencent.libra.a aVar2 = com.tencent.libra.a.f118582b;
            BitmapFactory.Options a16 = aVar2.a();
            a16.inJustDecodeBounds = false;
            a16.inSampleSize = i3;
            a16.inMutable = true;
            a16.inBitmap = bitmap;
            byte[] f16 = aVar.f();
            try {
                bitmap2 = BitmapFactory.decodeByteArray(f16, 0, c16, a16);
                aVar2.b(a16);
            } catch (IllegalArgumentException unused) {
                com.tencent.libra.a aVar3 = com.tencent.libra.a.f118582b;
                BitmapFactory.Options a17 = aVar3.a();
                a17.inJustDecodeBounds = false;
                a17.inSampleSize = i3;
                a17.inMutable = true;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(f16, 0, c16, a17);
                aVar3.b(a17);
                bitmap2 = decodeByteArray;
            }
            float f17 = i3;
            canvas.drawBitmap(bitmap2, this.f118620d / f17, this.f118621e / f17, paint);
            return bitmap2;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}

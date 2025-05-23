package a11;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d extends com.tencent.libra.base.animation.decode.a<h11.a, b11.a> {
    public d(h11.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.libra.base.animation.decode.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap a(Canvas canvas, Paint paint, int i3, Bitmap bitmap, b11.a aVar) {
        Bitmap decodeStream;
        com.tencent.libra.a aVar2 = com.tencent.libra.a.f118582b;
        BitmapFactory.Options a16 = aVar2.a();
        a16.inJustDecodeBounds = false;
        a16.inSampleSize = i3;
        a16.inMutable = true;
        a16.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            try {
                ((h11.a) this.f118617a).reset();
                try {
                    decodeStream = BitmapFactory.decodeStream(((h11.a) this.f118617a).toInputStream(), null, a16);
                    try {
                        aVar2.b(a16);
                    } catch (IllegalArgumentException unused) {
                        com.tencent.libra.a aVar3 = com.tencent.libra.a.f118582b;
                        BitmapFactory.Options a17 = aVar3.a();
                        a17.inJustDecodeBounds = false;
                        a17.inSampleSize = i3;
                        a17.inMutable = true;
                        decodeStream = BitmapFactory.decodeStream(((h11.a) this.f118617a).toInputStream(), null, a17);
                        aVar3.b(a17);
                        paint.setXfermode(null);
                        canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
                        return decodeStream;
                    }
                } catch (IllegalArgumentException unused2) {
                }
                paint.setXfermode(null);
                canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
                return decodeStream;
            } catch (IOException e16) {
                e = e16;
                bitmap2 = decodeStream;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (IOException e17) {
            e = e17;
            e.printStackTrace();
            return bitmap2;
        }
    }
}

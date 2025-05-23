package f6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.qzone.reborn.util.h;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.utils.ImageManagerLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends ImageProcessor {

    /* renamed from: a, reason: collision with root package name */
    private float[] f397883a;

    /* renamed from: b, reason: collision with root package name */
    private float f397884b = -1.0f;

    public c(float f16) {
        setRadius(f16);
    }

    public BitmapReference getRoundedCornerBitmap(BitmapReference bitmapReference, float[] fArr) {
        BitmapReference bitmap;
        try {
            bitmap = ImageManager.getInstance().getBitmap(bitmapReference.getWidth(), bitmapReference.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            ImageManagerLog.e("RoundCornerProcessor", "OOM," + e16.toString());
            bitmap = ImageManager.getInstance().getBitmap(bitmapReference.getWidth(), bitmapReference.getHeight(), Bitmap.Config.ARGB_4444);
        }
        Canvas canvas = new Canvas(bitmap.getBitmap());
        RectF rectF = new RectF(0.0f, 0.0f, bitmapReference.getWidth(), bitmapReference.getHeight());
        Path path = new Path();
        Paint paint = new Paint();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapReference.getBitmap(), (Rect) null, rectF, paint);
        return bitmap;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 2;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        BitmapReference a16;
        ImageProcessor imageProcessor = this.mPreProcessor;
        if (imageProcessor != null) {
            drawable = imageProcessor.process(drawable);
        }
        if (this.f397883a == null || (a16 = h.a(drawable)) == null) {
            return drawable;
        }
        BitmapReference roundedCornerBitmap = getRoundedCornerBitmap(a16, this.f397883a);
        if (roundedCornerBitmap == null) {
            return null;
        }
        return new SpecifiedBitmapDrawable(roundedCornerBitmap);
    }

    public void setRadius(float f16) {
        this.f397884b = f16;
        this.f397883a = new float[8];
        int i3 = 0;
        while (true) {
            float[] fArr = this.f397883a;
            if (i3 >= fArr.length / 2) {
                return;
            }
            fArr[i3] = f16;
            i3++;
        }
    }
}

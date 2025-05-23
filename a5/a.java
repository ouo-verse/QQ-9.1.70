package a5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends ImageProcessor {

    /* renamed from: a, reason: collision with root package name */
    private int f25526a;

    /* renamed from: b, reason: collision with root package name */
    private int f25527b;

    /* renamed from: c, reason: collision with root package name */
    private int f25528c;

    public a(int i3, int i16, int i17) {
        this.f25526a = i16;
        this.f25527b = i17;
        this.f25528c = i3;
    }

    private BitmapReference a(Drawable drawable) {
        if (drawable instanceof BitmapImageDrawable) {
            return ((BitmapImageDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof SpecifiedBitmapDrawable) {
            return ((SpecifiedBitmapDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof BitmapRefDrawable) {
            return ((BitmapRefDrawable) drawable).getBitmapRef();
        }
        return null;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        BitmapReference a16;
        int width;
        int height;
        int i3;
        int i16;
        if (drawable == null || (a16 = a(drawable)) == null || (width = a16.getWidth()) < (height = a16.getHeight())) {
            return drawable;
        }
        int i17 = this.f25527b;
        int i18 = i17 / height;
        int i19 = this.f25526a;
        if (i18 >= i19 / width) {
            i16 = (i19 * height) / i17;
            i3 = height;
        } else {
            i3 = 0;
            i16 = 0;
        }
        Bitmap bitmap = null;
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            bitmap = Bitmap.createBitmap(this.f25526a, this.f25527b, Bitmap.Config.RGB_565);
            int i26 = width - i16;
            int i27 = width + i16;
            Rect rect = new Rect(i26 / 2, 0, i27 / 2, (i3 - i16) / 2);
            Rect rect2 = new Rect(i26 / 2, (i3 + i16) / 2, i27 / 2, height);
            Canvas canvas = new Canvas(bitmap);
            Rect rect3 = new Rect(0, 0, this.f25526a, (this.f25527b - this.f25528c) / 2);
            int i28 = this.f25527b;
            Rect rect4 = new Rect(0, (this.f25528c + i28) / 2, this.f25526a, i28);
            canvas.drawBitmap(a16.getBitmap(), rect, rect3, paint);
            canvas.drawBitmap(a16.getBitmap(), rect2, rect4, paint);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#99000000"));
            canvas.drawRect(0.0f, 0.0f, this.f25526a, this.f25527b, paint);
        } catch (OutOfMemoryError e16) {
            j.d(QZLog.TO_DEVICE_TAG, "Bitmap Blur Effect: OutofMemory!!!", e16);
        }
        return bitmap != null ? new BitmapDrawable(bitmap) : drawable;
    }
}

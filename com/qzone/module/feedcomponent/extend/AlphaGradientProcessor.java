package com.qzone.module.feedcomponent.extend;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.component.media.image.ImageProcessor;

/* loaded from: classes39.dex */
public class AlphaGradientProcessor extends ImageProcessor {
    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
        Paint paint = new Paint();
        paint.setShader(null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint.setShader(new LinearGradient(0.0f, drawable.getIntrinsicHeight(), 0.0f, 0.0f, 0, Color.parseColor("#3E000000"), Shader.TileMode.CLAMP));
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        canvas.drawPaint(paint);
        return new BitmapDrawable(FeedGlobalEnv.getContext().getResources(), createBitmap);
    }
}

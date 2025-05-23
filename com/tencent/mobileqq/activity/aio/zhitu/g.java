package com.tencent.mobileqq.activity.aio.zhitu;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import com.tencent.mobileqq.emosm.emosearch.CompositeDrawTextParam;
import com.tencent.mobileqq.emoticon.api.IEmoticonGifUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f180409a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f180410b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f180411c;

        /* renamed from: d, reason: collision with root package name */
        public final Paint f180412d;

        /* renamed from: e, reason: collision with root package name */
        public PointF[] f180413e;

        public a(float[] fArr, String[] strArr, Paint paint, Paint paint2) {
            this.f180409a = fArr;
            this.f180410b = strArr;
            this.f180411c = paint;
            this.f180412d = paint2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static g f180414a = new g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        String a();

        File b(String str);
    }

    g() {
        QRoute.api(IEmoticonGifUtils.class);
    }

    private void a(Canvas canvas, Paint paint, String str, Rect rect, int i3) {
        if (i3 != 0 && i3 != 3) {
            boolean z16 = true;
            if (i3 == 1) {
                if (rect.exactCenterY() >= canvas.getHeight() / 2) {
                    z16 = false;
                }
                if (z16) {
                    c(canvas, paint, str, rect, rect.top - paint.ascent(), f(paint));
                    return;
                } else {
                    c(canvas, paint, str, rect, rect.bottom - paint.descent(), f(paint));
                    return;
                }
            }
            return;
        }
        canvas.drawText(str, rect.exactCenterX(), rect.exactCenterY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
    }

    private void b(Canvas canvas, Paint paint, String str, String str2, Rect rect, int i3) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (i3 != 0 && i3 != 3) {
            boolean z16 = true;
            if (i3 == 1) {
                if (rect.exactCenterY() >= canvas.getHeight() / 2) {
                    z16 = false;
                }
                if (z16) {
                    Paint f16 = f(paint);
                    float f17 = rect.top - fontMetrics.ascent;
                    c(canvas, paint, str, rect, f17, f16);
                    c(canvas, paint, str2, rect, (f17 + fontMetrics.descent) - fontMetrics.ascent, f16);
                    return;
                }
                Paint f18 = f(paint);
                float f19 = rect.bottom - fontMetrics.descent;
                c(canvas, paint, str2, rect, f19, f18);
                c(canvas, paint, str, rect, (f19 - fontMetrics.descent) + fontMetrics.ascent, f18);
                return;
            }
            return;
        }
        canvas.drawText(str, rect.exactCenterX(), rect.exactCenterY() - fontMetrics.descent, paint);
        canvas.drawText(str2, rect.exactCenterX(), rect.exactCenterY() - fontMetrics.ascent, paint);
    }

    private void c(Canvas canvas, Paint paint, String str, Rect rect, float f16, Paint paint2) {
        canvas.drawText(str, rect.exactCenterX(), f16, paint2);
        canvas.drawText(str, rect.exactCenterX(), f16, paint);
    }

    @NonNull
    private Paint f(Paint paint) {
        Paint paint2 = new Paint(paint);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-1);
        paint2.setStrokeWidth(4.0f);
        return paint2;
    }

    private float[] j(int i3, Paint paint, Rect rect, int i16) {
        boolean z16;
        if (i16 != 0 && i16 != 3) {
            if (i16 == 1) {
                if (rect.exactCenterY() < i3 / 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return new float[]{rect.top - paint.ascent()};
                }
                return new float[]{rect.bottom - paint.descent()};
            }
            return new float[]{0.0f};
        }
        return new float[]{rect.exactCenterY() - ((paint.descent() + paint.ascent()) / 2.0f)};
    }

    private float[] k(int i3, Paint paint, Rect rect, int i16) {
        boolean z16;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float[] fArr = new float[2];
        if (i16 != 0 && i16 != 3) {
            if (i16 == 1) {
                if (rect.exactCenterY() < i3 / 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    float f16 = rect.top;
                    float f17 = fontMetrics.ascent;
                    float f18 = f16 - f17;
                    fArr[0] = f18;
                    fArr[1] = (f18 + fontMetrics.descent) - f17;
                } else {
                    float f19 = rect.bottom;
                    float f26 = fontMetrics.descent;
                    float f27 = f19 - f26;
                    fArr[1] = f27;
                    fArr[0] = (f27 - f26) + fontMetrics.ascent;
                }
            }
        } else {
            fArr[0] = rect.exactCenterY() - fontMetrics.descent;
            fArr[1] = rect.exactCenterY() - fontMetrics.ascent;
        }
        return fArr;
    }

    public static g l() {
        return b.f180414a;
    }

    private boolean n(String str, int i3, Paint paint) {
        float f16 = i3;
        paint.setTextSize(f16 / 8.0f);
        if (paint.measureText(str) <= f16 * 0.9f) {
            return true;
        }
        return false;
    }

    private boolean o(float f16, float f17, Rect rect) {
        if (f16 < rect.width() * 0.9d && f17 < rect.height()) {
            return true;
        }
        return false;
    }

    private void p(String str, Rect rect, Paint paint) {
        float f16 = 6.5f;
        do {
            paint.setTextSize(rect.width() / f16);
            float measureText = paint.measureText(str);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            f16 += 0.5f;
            if (o(measureText, fontMetrics.bottom - fontMetrics.top, rect)) {
                return;
            }
        } while (f16 < 8.1f);
    }

    private void q(String str, String str2, Rect rect, Paint paint) {
        float measureText;
        float f16;
        float measureText2;
        Paint.FontMetrics fontMetrics;
        Rect rect2 = new Rect(rect);
        int i3 = rect2.top;
        rect2.bottom = i3 + ((rect2.bottom - i3) / 2);
        float f17 = 6.5f;
        do {
            paint.setTextSize(rect.width() / f17);
            measureText = paint.measureText(str);
            Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
            f16 = fontMetrics2.bottom - fontMetrics2.top;
            measureText2 = paint.measureText(str2);
            fontMetrics = paint.getFontMetrics();
            f17 += 0.5f;
        } while (!o(Math.max(measureText, measureText2), Math.max(f16, fontMetrics.bottom - fontMetrics.top), rect2));
    }

    @NonNull
    private Pair<String, String> r(String str, List<String> list) {
        int length = str.length();
        StringBuilder sb5 = new StringBuilder(length);
        StringBuilder sb6 = new StringBuilder(length);
        int i3 = (length + 1) / 2;
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (sb5.length() <= i3) {
                sb5.append(list.get(i16));
            } else {
                sb6.append(list.get(i16));
            }
        }
        return new Pair<>(sb5.toString(), sb6.toString());
    }

    @Nullable
    public String d(@NonNull String str, @NonNull a aVar, @NonNull File file) {
        if (!((IEmoticonGifUtils) QRoute.api(IEmoticonGifUtils.class)).isSoLoaded()) {
            QLog.e("ZhituManager", 1, "so load fail");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(str);
        if (file.exists()) {
            file.delete();
        }
        GifEncoder gifEncoder = new GifEncoder();
        try {
            com.tencent.mobileqq.activity.aio.zhitu.a aVar2 = new com.tencent.mobileqq.activity.aio.zhitu.a(file2, false, 0.0f);
            if (aVar2.getHeight() > 0 && aVar2.getWidth() > 0) {
                aVar2.f(aVar);
                int currentFrameIndex = aVar2.getCurrentFrameIndex();
                int frameCount = aVar2.getFrameCount();
                if (currentFrameIndex >= 0 && frameCount >= 1) {
                    gifEncoder.c(aVar2.getWidth(), aVar2.getHeight(), file.getAbsolutePath(), 0);
                    Bitmap A0 = ZhituManager.A0(aVar2.getWidth(), aVar2.getHeight());
                    if (A0 == null) {
                        QLog.e("ZhituManager", 1, "generateCompositeGif safeCreateBitmap error fileName:" + file.getName());
                        return null;
                    }
                    Canvas canvas = new Canvas(A0);
                    Paint paint = new Paint();
                    while (currentFrameIndex < frameCount) {
                        canvas.drawBitmap(aVar2.a(), 0.0f, 0.0f, paint);
                        aVar2.c(canvas);
                        gifEncoder.b(A0, aVar2.getFrameDelay());
                        canvas.clipRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        aVar2.b();
                        currentFrameIndex = aVar2.getCurrentFrameIndex();
                        if (currentFrameIndex == 0) {
                            break;
                        }
                    }
                    gifEncoder.a();
                    QLog.i("ZhituManager", 1, "generateCompositeGif fileName:" + file.getName() + ", take time:" + (System.currentTimeMillis() - currentTimeMillis));
                    return file.getAbsolutePath();
                }
                return null;
            }
            QLog.i("ZhituManager", 1, "generateCompositeGif gif with invalid height or width return");
            return null;
        } catch (IOException e16) {
            QLog.e("ZhituManager", 1, "generateCompositeGif failed, fileName:" + file.getName(), e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e("ZhituManager", 1, "generateCompositeGif catch oom, fileName:" + file.getName(), e17);
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(e17, "generateCompositeGif catch oom");
            return null;
        } finally {
            gifEncoder.a();
        }
    }

    @Nullable
    public String e(@NonNull String str, @NonNull CompositeDrawTextParam compositeDrawTextParam, int i3, int i16, @NonNull File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap A0 = ZhituManager.A0(i3, i16);
        if (A0 == null) {
            QLog.e("ZhituManager", 1, "generateCompositeGif safeCreateBitmap error fileName:" + file.getName());
            return null;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (decodeFile == null) {
                QLog.e("ZhituManager", 1, "generateCompositeImage originBitmap is null, originPath:" + str);
                return null;
            }
            Canvas canvas = new Canvas(A0);
            canvas.drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
            for (int i17 = 0; i17 < compositeDrawTextParam.getTextArray().length; i17++) {
                PointF pointF = compositeDrawTextParam.getPointFArray()[i17];
                canvas.drawText(compositeDrawTextParam.getTextArray()[i17], pointF.x, pointF.y, compositeDrawTextParam.getStrokePaint());
                canvas.drawText(compositeDrawTextParam.getTextArray()[i17], pointF.x, pointF.y, compositeDrawTextParam.getPaint());
            }
            if (FileUtils.saveBitmapToFile(A0, file.getAbsolutePath())) {
                QLog.i("ZhituManager", 1, "generateCompositeImage fileName:" + file.getName() + ", take time:" + (System.currentTimeMillis() - currentTimeMillis));
                return file.getAbsolutePath();
            }
            QLog.i("ZhituManager", 1, "generateCompositeImage saveBitmapToFile failed, fileName:" + file.getName());
            return null;
        } catch (OutOfMemoryError unused) {
            QLog.e("ZhituManager", 1, "generateCompositeImage decode originBitmap file but oom");
            return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    @Nullable
    public Bitmap g(String str, String str2, List<String> list, String str3, Rect rect, int i3, String str4, int i16, Typeface typeface) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (decodeFile == null) {
                QLog.e("ZhituManager", 1, ZhituManager.w(str4, "generateZhitu", i16, "decode bitmap fail"));
                return null;
            }
            Bitmap h16 = h(decodeFile, str2, list, str3, rect, i3, str4, i16, typeface);
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, ZhituManager.x(str4, "generateZhitu", "take time " + Long.toString(System.currentTimeMillis() - currentTimeMillis)));
            }
            return h16;
        } catch (OutOfMemoryError unused) {
            QLog.e("ZhituManager", 1, "decode origin file but oom");
            return null;
        }
    }

    @Nullable
    public Bitmap h(Bitmap bitmap, String str, List<String> list, String str2, Rect rect, int i3, String str3, int i16, @Nullable Typeface typeface) {
        Canvas canvas = new Canvas();
        Bitmap A0 = ZhituManager.A0(bitmap.getWidth(), bitmap.getHeight());
        if (A0 == null) {
            return null;
        }
        A0.setDensity(bitmap.getDensity());
        canvas.setBitmap(A0);
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.parseColor(str2));
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, textPaint);
        if (n(str, bitmap.getWidth(), textPaint)) {
            p(str, rect, textPaint);
            a(canvas, textPaint, str, rect, i3);
        } else {
            Pair<String, String> r16 = r(str, list);
            q(r16.first, r16.second, rect, textPaint);
            b(canvas, textPaint, r16.first, r16.second, rect, i3);
        }
        return A0;
    }

    @Nullable
    public String i(@NonNull String str, @NonNull a aVar, @NonNull String str2, int i3, @NonNull c cVar) {
        com.tencent.mobileqq.activity.aio.zhitu.a aVar2;
        if (!((IEmoticonGifUtils) QRoute.api(IEmoticonGifUtils.class)).isSoLoaded()) {
            QLog.e("ZhituManager", 1, "So load fail");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (cVar.a() == null) {
            QLog.e("ZhituManager", 1, "create dest dir fail");
            return null;
        }
        File file = new File(str);
        File b16 = cVar.b(str);
        if (b16.exists()) {
            b16.delete();
        }
        GifEncoder gifEncoder = new GifEncoder();
        try {
            try {
                aVar2 = new com.tencent.mobileqq.activity.aio.zhitu.a(file, false, 0.0f);
            } catch (IOException e16) {
                QLog.e("ZhituManager", 1, ZhituManager.w(str2, "generateZhituGif", i3, "generate gif file to send fail, " + e16));
            } catch (OutOfMemoryError e17) {
                com.tencent.qqperf.monitor.crash.catchedexception.a.c(e17, "ZhituGenerateCatchedExceptionoom when encode gif");
            }
            if (aVar2.getHeight() > 0 && aVar2.getWidth() > 0) {
                aVar2.f(aVar);
                int currentFrameIndex = aVar2.getCurrentFrameIndex();
                int frameCount = aVar2.getFrameCount();
                if (currentFrameIndex >= 0 && frameCount >= 1) {
                    gifEncoder.c(aVar2.getWidth(), aVar2.getHeight(), b16.getAbsolutePath(), 0);
                    Bitmap A0 = ZhituManager.A0(aVar2.getWidth(), aVar2.getHeight());
                    if (A0 == null) {
                        return null;
                    }
                    Canvas canvas = new Canvas(A0);
                    Paint paint = new Paint();
                    while (currentFrameIndex < frameCount) {
                        canvas.drawBitmap(aVar2.a(), 0.0f, 0.0f, paint);
                        aVar2.c(canvas);
                        gifEncoder.b(A0, aVar2.getFrameDelay());
                        canvas.clipRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        aVar2.b();
                        currentFrameIndex = aVar2.getCurrentFrameIndex();
                        if (currentFrameIndex == 0) {
                            break;
                        }
                    }
                    gifEncoder.a();
                    if (QLog.isColorLevel()) {
                        QLog.d("ZhituManager", 2, ZhituManager.w(str2, "generateZhituGif", i3, "take time: " + Long.toString(System.currentTimeMillis() - currentTimeMillis)));
                    }
                    return b16.getAbsolutePath();
                }
                gifEncoder.a();
                return null;
            }
            QLog.e("ZhituManager", 1, "gif image with invalid height or width return ");
            gifEncoder.a();
            return null;
        } finally {
            gifEncoder.a();
        }
    }

    public a m(int i3, int i16, String str, List<String> list, String str2, Rect rect, int i17, String str3, int i18, Typeface typeface) {
        String[] strArr;
        float[] k3;
        Paint paint;
        if (str.length() <= 24) {
            QLog.d("ghostdebug", 2, "get param: " + i18 + " / " + i3);
            long currentTimeMillis = System.currentTimeMillis();
            TextPaint textPaint = new TextPaint();
            textPaint.setSubpixelText(true);
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setColor(Color.parseColor(str2));
            if (typeface != null) {
                textPaint.setTypeface(typeface);
            }
            boolean n3 = n(str, i3, textPaint);
            if (n3) {
                strArr = new String[]{str};
            } else {
                Pair<String, String> r16 = r(str, list);
                strArr = new String[]{r16.first, r16.second};
            }
            if (n3) {
                p(str, rect, textPaint);
                k3 = j(i16, textPaint, rect, i17);
            } else {
                q(strArr[0], strArr[1], rect, textPaint);
                k3 = k(i16, textPaint, rect, i17);
            }
            if (i17 == 1) {
                paint = f(textPaint);
            } else {
                paint = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, ZhituManager.w(str3, "getParamToDrawText", i18, "take time: " + Long.toString(System.currentTimeMillis() - currentTimeMillis)));
            }
            return new a(k3, strArr, textPaint, paint);
        }
        throw new IllegalArgumentException("length of the text to draw is over 24");
    }
}

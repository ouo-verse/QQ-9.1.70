package com.qzone.preview.photodanmaku.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.ar;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n8.a;

/* loaded from: classes39.dex */
public class PhotoDanmakuDrawer {

    /* renamed from: i, reason: collision with root package name */
    private static final RectF f49917i = new RectF();

    /* renamed from: j, reason: collision with root package name */
    private static final TextPaint f49918j = new TextPaint();

    /* renamed from: k, reason: collision with root package name */
    private static final Map<Float, Float> f49919k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private static LinkedHashMap<String, Paint> f49920l = new LinkedHashMap<String, Paint>() { // from class: com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Paint> entry) {
            return size() > 48;
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private static final Rect f49921m = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final n8.a f49925d;

    /* renamed from: e, reason: collision with root package name */
    private final n8.c f49926e;

    /* renamed from: g, reason: collision with root package name */
    private Canvas f49928g;

    /* renamed from: h, reason: collision with root package name */
    private Context f49929h;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f49922a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Rect f49923b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private boolean f49924c = false;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f49927f = new Paint();

    /* loaded from: classes39.dex */
    public enum PaintType {
        Normal,
        Hint,
        StaticLayout,
        Measure
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Canvas f49948a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbsDanmaku f49949b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f49950c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f49951d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f49952e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f49953f;

        c(Canvas canvas, AbsDanmaku absDanmaku, float f16, float f17, float f18, float f19) {
            this.f49948a = canvas;
            this.f49949b = absDanmaku;
            this.f49950c = f16;
            this.f49951d = f17;
            this.f49952e = f18;
            this.f49953f = f19;
        }

        @Override // com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer.e
        public void a() {
            j.c("PhotoDanmakuDrawer", "drawDanmaku - drawBgFailed");
        }

        @Override // com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer.e
        public void b() {
            PhotoDanmakuDrawer.this.o(this.f49948a, this.f49949b, this.f49950c, this.f49951d, this.f49952e, this.f49953f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f49955a;

        static {
            int[] iArr = new int[PaintType.values().length];
            f49955a = iArr;
            try {
                iArr[PaintType.Hint.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49955a[PaintType.Measure.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49955a[PaintType.StaticLayout.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49955a[PaintType.Normal.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public interface e {
        void a();

        void b();
    }

    public PhotoDanmakuDrawer(Context context, n8.a aVar, n8.c cVar) {
        this.f49925d = aVar;
        this.f49926e = cVar;
        this.f49929h = context;
    }

    public static String j(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            Matcher matcher = Pattern.compile("@\\{uin:\\d+?,nick:(.+?),who:\\d+?\\}").matcher(str);
            StringBuilder sb5 = new StringBuilder(str.length());
            int i3 = 0;
            while (matcher.find()) {
                sb5.append(str.substring(i3, matcher.start()));
                sb5.append("@" + matcher.group(1));
                i3 = matcher.end();
            }
            sb5.append(str.substring(i3));
            return sb5.toString();
        } catch (Throwable th5) {
            j.d("PhotoDanmakuDrawer", "PhotoDanmaku - convertAtStruct", th5);
            return str;
        }
    }

    private void m(Canvas canvas, String str, float f16, float f17, float f18, float f19, float f26, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f49925d.b(str, new a(canvas, f16, f17, f18, f19, f26, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap p(Drawable drawable) {
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmap();
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public static float q(PhotoDanmakuConfig photoDanmakuConfig) {
        return u(photoDanmakuConfig.mTextSize) + (photoDanmakuConfig.mMarginVertical * 2);
    }

    private static Paint r(AbsDanmaku absDanmaku, PaintType paintType) {
        String borderPaintKey;
        Paint textPaint;
        int[] iArr = d.f49955a;
        int i3 = iArr[paintType.ordinal()];
        if (i3 == 1) {
            borderPaintKey = absDanmaku.getBorderPaintKey();
            if (borderPaintKey == null) {
                borderPaintKey = s(absDanmaku, paintType);
                absDanmaku.setBorderPaintKey(borderPaintKey);
            }
        } else if (i3 == 2) {
            borderPaintKey = s(absDanmaku, paintType);
        } else if (i3 == 3 || i3 == 4) {
            borderPaintKey = absDanmaku.getTextPaintKey();
            if (borderPaintKey == null) {
                borderPaintKey = s(absDanmaku, paintType);
                absDanmaku.setTextPaintKey(borderPaintKey);
            }
        } else {
            borderPaintKey = null;
        }
        Paint paint = f49920l.get(borderPaintKey);
        if (paint != null) {
            return paint;
        }
        if (paintType == PaintType.Hint) {
            textPaint = new Paint();
        } else {
            textPaint = new TextPaint();
        }
        if (paintType == PaintType.Measure) {
            textPaint.setTextSize(absDanmaku.getTextSize());
            return textPaint;
        }
        textPaint.setTextSize(absDanmaku.getTextSize());
        textPaint.setAlpha(absDanmaku.getAlpha());
        textPaint.setAntiAlias(absDanmaku.hasAntiAlias());
        if (iArr[paintType.ordinal()] != 1) {
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setColor(absDanmaku.getTextColor());
            textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            textPaint.clearShadowLayer();
        } else {
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setStrokeWidth(absDanmaku.getBorderWidth());
            textPaint.setColor(absDanmaku.getBorderColor());
        }
        f49920l.put(s(absDanmaku, paintType), textPaint);
        return textPaint;
    }

    private static float u(float f16) {
        TextPaint textPaint = f49918j;
        textPaint.setTextSize(f16);
        Map<Float, Float> map = f49919k;
        Float f17 = map.get(Float.valueOf(f16));
        if (f17 == null) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            f17 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(Float.valueOf(f16), f17);
        }
        return f17.floatValue();
    }

    private static float v(TextPaint textPaint) {
        float textSize = textPaint.getTextSize();
        Map<Float, Float> map = f49919k;
        Float f16 = map.get(Float.valueOf(textSize));
        if (f16 == null) {
            Paint.FontMetrics fontMetrics = f49918j.getFontMetrics();
            f16 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(Float.valueOf(textSize), f16);
        }
        return f16.floatValue();
    }

    private boolean w(char c16) {
        if (c16 != 0 && c16 != '\t' && c16 != '\n' && c16 != '\r' && ((c16 < ' ' || c16 > '\ud7ff') && (c16 < '\ue000' || c16 > '\ufffd'))) {
            return true;
        }
        return false;
    }

    public void A(Canvas canvas) {
        this.f49928g = canvas;
    }

    public void k(AbsDanmaku absDanmaku) {
        if (this.f49928g != null) {
            if (absDanmaku.isDrawCacheEnable() && PhotoDanmakuConfig.isGlobalDrawCacheEnable()) {
                Bitmap drawCache = absDanmaku.getDrawCache();
                if (drawCache == null) {
                    drawCache = this.f49926e.b((int) absDanmaku.getPaintWidth(), (int) absDanmaku.getPaintHeight());
                    absDanmaku.setDrawCache(drawCache);
                }
                if (drawCache != null) {
                    if (absDanmaku.isDrawCacheDirty()) {
                        absDanmaku.setDrawCacheDirty(false);
                        if (drawCache.getWidth() < ((int) absDanmaku.getPaintWidth()) || drawCache.getHeight() < ((int) absDanmaku.getPaintHeight())) {
                            this.f49926e.c(drawCache);
                            drawCache = this.f49926e.b((int) absDanmaku.getPaintWidth(), (int) absDanmaku.getPaintHeight());
                            absDanmaku.setDrawCache(drawCache);
                        }
                        Canvas drawCacheCanvas = absDanmaku.getDrawCacheCanvas();
                        if (drawCacheCanvas == null) {
                            drawCacheCanvas = new Canvas(drawCache);
                            absDanmaku.setDrawCacheCanvas(drawCacheCanvas);
                        } else {
                            drawCacheCanvas.setBitmap(drawCache);
                        }
                        drawCache.eraseColor(0);
                        l(drawCacheCanvas, absDanmaku, absDanmaku.getMarginHorizontal(), absDanmaku.getMarginVertical());
                    }
                    int save = this.f49928g.save();
                    this.f49922a.set(0, 0, (int) absDanmaku.getPaintWidth(), (int) absDanmaku.getPaintHeight());
                    this.f49923b.set((int) absDanmaku.getLeft(), (int) absDanmaku.getTop(), (int) absDanmaku.getRight(), (int) absDanmaku.getBottom());
                    this.f49928g.drawBitmap(drawCache, this.f49922a, this.f49923b, this.f49927f);
                    this.f49928g.restoreToCount(save);
                    return;
                }
                PhotoDanmakuConfig.setsGlobalDrawCacheEnable(false);
            }
            int save2 = this.f49928g.save();
            l(this.f49928g, absDanmaku, absDanmaku.getContentLeft(), absDanmaku.getContentTop());
            this.f49928g.restoreToCount(save2);
        }
    }

    public void y(AbsDanmaku absDanmaku) {
        PaintType paintType;
        if (absDanmaku.getText() instanceof SpannableString) {
            paintType = PaintType.StaticLayout;
        } else {
            paintType = PaintType.Measure;
        }
        h(absDanmaku, (TextPaint) r(absDanmaku, paintType));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Canvas f49935a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f49936b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f49937c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f49938d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f49939e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f49940f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f49941g;

        a(Canvas canvas, float f16, float f17, float f18, float f19, float f26, e eVar) {
            this.f49935a = canvas;
            this.f49936b = f16;
            this.f49937c = f17;
            this.f49938d = f18;
            this.f49939e = f19;
            this.f49940f = f26;
            this.f49941g = eVar;
        }

        @Override // n8.a.c
        public void b(String str) {
            j.c("PhotoDanmakuDrawer", "PhotoDanmakuDrawer - drawImage - onLoadLogoFailed:" + str);
            this.f49941g.a();
        }

        @Override // n8.a.c
        public void a(Drawable drawable) {
            if (drawable != null) {
                this.f49935a.save();
                Canvas canvas = this.f49935a;
                float f16 = this.f49936b;
                float f17 = this.f49937c;
                canvas.clipRect((int) f16, (int) f17, (int) (f16 + this.f49938d), (int) ((f17 + this.f49939e) - this.f49940f));
                Rect rect = PhotoDanmakuDrawer.f49921m;
                float f18 = this.f49936b;
                float f19 = this.f49937c;
                rect.set((int) f18, (int) f19, (int) (f18 + this.f49938d), (int) (f19 + this.f49939e));
                drawable.setBounds(PhotoDanmakuDrawer.f49921m);
                drawable.draw(this.f49935a);
                try {
                    this.f49935a.restore();
                } catch (IllegalStateException unused) {
                    j.c("PhotoDanmakuDrawer", "drawText get an IllegalStateException: canvas.restore()");
                }
                this.f49941g.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Paint f49943a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f49944b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f49945c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsDanmaku f49946d;

        b(Paint paint, float f16, float f17, AbsDanmaku absDanmaku) {
            this.f49943a = paint;
            this.f49944b = f16;
            this.f49945c = f17;
            this.f49946d = absDanmaku;
        }

        @Override // n8.a.c
        public void b(String str) {
            j.c("PhotoDanmakuDrawer", "PhotoDanmakuDrawer - drawLogo - onLoadLogoFailed:" + str);
            PhotoDanmakuDrawer.this.f49924c = true;
            this.f49943a.setAntiAlias(true);
            if (PhotoDanmakuDrawer.this.f49929h == null) {
                QLog.e("PhotoDanmakuDrawer", 1, "context is null");
                return;
            }
            Bitmap C = PhotoDanmakuDrawer.C(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(PhotoDanmakuDrawer.this.f49929h.getResources(), R.drawable.f160830com), (int) this.f49944b, (int) this.f49945c, false));
            AbsDanmaku absDanmaku = this.f49946d;
            if (absDanmaku != null) {
                absDanmaku.setLogoBitmap(C);
            }
        }

        @Override // n8.a.c
        public void a(Drawable drawable) {
            if (drawable != null) {
                PhotoDanmakuDrawer.this.f49924c = true;
                this.f49943a.setAntiAlias(true);
                Bitmap C = PhotoDanmakuDrawer.C(Bitmap.createScaledBitmap(PhotoDanmakuDrawer.this.p(drawable), (int) this.f49944b, (int) this.f49945c, false));
                AbsDanmaku absDanmaku = this.f49946d;
                if (absDanmaku != null) {
                    absDanmaku.setLogoBitmap(C);
                }
            }
        }
    }

    public void z() {
        this.f49929h = null;
    }

    private int t(String str) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length()) {
            int i17 = i3 + 1;
            i16 = str.substring(i3, i17).matches("[\u4e00-\u9fa5]") ? i16 + 2 : i16 + 1;
            i3 = i17;
        }
        return i16;
    }

    private void B(CellTextView cellTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (cellTextView == null) {
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            cellTextView.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            cellTextView.setShadowLayer(ar.e(superFontInfo.iShadowBlurRadius), ar.e(superFontInfo.iShadowOffsetX), ar.e(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            cellTextView.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        }
        if ((superFontInfo.lSparkleFlag & 4) == 0 || (arrayList = superFontInfo.vecGradientColor) == null || arrayList.size() < 2 || (arrayList2 = superFontInfo.vecGradientPosition) == null || arrayList2.size() < 2) {
            return;
        }
        int size2 = superFontInfo.vecGradientColor.size();
        int[] iArr = new int[size2];
        for (int i16 = 0; i16 < size2; i16++) {
            iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
        }
        int size3 = superFontInfo.vecGradientPosition.size();
        float[] fArr = new float[size3];
        for (int i17 = 0; i17 < size3; i17++) {
            fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
        }
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        int i18 = superFontInfo.iGradientDirection;
        if (i18 != 0) {
            if (i18 == 1) {
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            } else if (i18 == 2) {
                orientation = GradientDrawable.Orientation.TL_BR;
            } else if (i18 == 3) {
                orientation = GradientDrawable.Orientation.BL_TR;
            }
        }
        cellTextView.setGradientColor(iArr, fArr, orientation);
    }

    private String i(String str, int i3) {
        int i16 = 0;
        int i17 = 0;
        while (i16 < str.length()) {
            int i18 = i16 + 1;
            i17 = str.substring(i16, i18).matches("[\u4e00-\u9fa5]") ? i17 + 2 : i17 + 1;
            if (i17 > i3) {
                int i19 = i16 - 1;
                while (true) {
                    if (i19 >= str.length()) {
                        i19 = -1;
                        break;
                    }
                    if (!w(str.charAt(i19))) {
                        break;
                    }
                    i19++;
                }
                if (i19 == -1) {
                    return str;
                }
                return str.substring(0, i19) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            i16 = i18;
        }
        return str;
    }

    public static Bitmap C(Bitmap bitmap) {
        float f16;
        float f17;
        float f18;
        float f19;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f19 = width / 2;
            f18 = width;
            f16 = 0.0f;
            f17 = f18;
        } else {
            f16 = (width - height) / 2;
            f17 = height;
            f18 = width - f16;
            width = height;
            f19 = height / 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f16, (int) 0.0f, (int) f18, (int) f17);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f17, (int) f17);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, f19, f19, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    private void n(Canvas canvas, final Paint paint, final AbsDanmaku absDanmaku, final long j3, float f16, float f17, final float f18, final float f19) {
        if (absDanmaku != null && absDanmaku.getLogoBitmap() != null && !absDanmaku.getLogoBitmap().isRecycled() && canvas != null) {
            paint.setAntiAlias(true);
            canvas.drawBitmap(absDanmaku.getLogoBitmap(), f16, f17, paint);
        } else if (j3 > 0) {
            this.f49925d.a(String.valueOf(j3), (int) f18, new b(paint, f18, f19, absDanmaku));
            new BaseTimer().schedule(new TimerTask() { // from class: com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (PhotoDanmakuDrawer.this.f49924c) {
                        return;
                    }
                    ImageLoader.getInstance().cancel("avatar://" + String.valueOf(j3), null, null);
                    paint.setAntiAlias(true);
                    if (PhotoDanmakuDrawer.this.f49929h == null) {
                        QLog.e("PhotoDanmakuDrawer", 1, "context is null");
                        return;
                    }
                    Bitmap C = PhotoDanmakuDrawer.C(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(PhotoDanmakuDrawer.this.f49929h.getResources(), R.drawable.f160830com), (int) f18, (int) f19, false));
                    AbsDanmaku absDanmaku2 = absDanmaku;
                    if (absDanmaku2 != null) {
                        absDanmaku2.setLogoBitmap(C);
                    }
                }
            }, 1000L);
        }
    }

    public void l(Canvas canvas, AbsDanmaku absDanmaku, float f16, float f17) {
        float contentWidth = absDanmaku.getContentWidth();
        float contentHeight = absDanmaku.getContentHeight();
        String backgroundImageUrl = absDanmaku.getBackgroundImageUrl();
        if (backgroundImageUrl != null && !TextUtils.isEmpty(backgroundImageUrl)) {
            m(canvas, absDanmaku.getBackgroundImageUrl(), f16 - absDanmaku.getConfig().mBarrageEffectHorizontalPadding, f17 - absDanmaku.getConfig().mBarrageEffectVerticalPadding, contentWidth + (absDanmaku.getConfig().mBarrageEffectHorizontalPadding * 2.0f), contentHeight + (absDanmaku.getConfig().mBarrageEffectVerticalPadding * 2.0f), absDanmaku.getConfig().mBarrageEffectVerticalPadding, new c(canvas, absDanmaku, f16, f17, contentWidth, contentHeight));
        } else if (absDanmaku.getBorderWidth() > 0.0f) {
            Paint r16 = r(absDanmaku, PaintType.Hint);
            float borderRadio = absDanmaku.getBorderRadio();
            RectF rectF = f49917i;
            rectF.set(f16, f17, f16 + contentWidth, f17 + contentHeight);
            canvas.drawRoundRect(rectF, borderRadio, borderRadio, r16);
            o(canvas, absDanmaku, f16, f17, contentWidth, contentHeight);
        }
        LpReportInfo_pf00064.allReport(301, 30, 1, true);
    }

    private static String s(AbsDanmaku absDanmaku, PaintType paintType) {
        if (absDanmaku != null && paintType != null) {
            if (paintType == PaintType.Measure) {
                return String.valueOf(absDanmaku.getTextSize());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append('n');
            sb5.append(absDanmaku.getAlpha());
            sb5.append(absDanmaku.hasAntiAlias());
            if (d.f49955a[paintType.ordinal()] != 1) {
                sb5.append(paintType.ordinal());
                sb5.append(absDanmaku.getTextSize());
                sb5.append(absDanmaku.getTextColor());
            } else {
                sb5.append("b");
                sb5.append(absDanmaku.getBorderWidth());
                sb5.append(absDanmaku.getBorderColor());
            }
            return sb5.toString();
        }
        return "";
    }

    private void h(AbsDanmaku absDanmaku, TextPaint textPaint) {
        ArrayList arrayList;
        int i3;
        float v3 = v(textPaint);
        float borderWidth = absDanmaku.getBorderWidth() * 2.0f;
        float paddingHorizontal = (absDanmaku.getPaddingHorizontal() * 2.0f) + borderWidth + 0.0f;
        float paddingVertical = borderWidth + (absDanmaku.getPaddingVertical() * 2.0f) + v3;
        String charSequence = absDanmaku.getText().toString();
        String i16 = i(absDanmaku.getNickNameStr(), 16);
        String replaceEmoCode = QzoneEmotionUtils.replaceEmoCode(charSequence, "");
        int emoCount = QzoneEmotionUtils.getEmoCount(charSequence);
        String plainText = TextCellParser.toPlainText(replaceEmoCode);
        String j3 = j(charSequence);
        if (emoCount > 0 && t(plainText) + (emoCount * 2) > 30) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            j.a("DanmakuTimeCost", 1, "rawContentStr is too long");
            Matcher matcher = QzoneEmotionUtils.SMILEY_PATTERN.matcher(charSequence);
            while (matcher.find()) {
                arrayList2.add(Integer.valueOf(matcher.start()));
                arrayList3.add(Integer.valueOf(matcher.end() - 1));
            }
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                try {
                    if (i18 >= j3.length()) {
                        break;
                    }
                    if (i17 < arrayList2.size() && i18 == ((Integer) arrayList2.get(i17)).intValue()) {
                        int i26 = i19 + 2;
                        i18 = ((Integer) arrayList3.get(i17)).intValue();
                        i17++;
                        arrayList = arrayList2;
                        if (i26 >= 30) {
                            j3 = j3.substring(0, i18 + 1) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                            break;
                        }
                        i19 = i26;
                        i3 = 1;
                    } else {
                        arrayList = arrayList2;
                        int i27 = charSequence.substring(i18, i18 + 1).matches("[\u4e00-\u9fa5]") ? i19 + 2 : i19 + 1;
                        if (i27 >= 30) {
                            j3 = j3.substring(0, i18) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                            break;
                        }
                        i19 = i27;
                        i3 = 1;
                    }
                    i18 += i3;
                    arrayList2 = arrayList;
                } catch (Exception e16) {
                    j.c("PhotoDanmakuDrawer", "danmaku clip get an Exception:" + e16.toString());
                }
            }
        } else if (emoCount == 0) {
            j3 = i(plainText, 30);
        }
        if (!i16.isEmpty()) {
            i16 = i16 + "\uff1a ";
        }
        float measureText = paddingHorizontal + textPaint.measureText(TextCellParser.toPlainText(QzoneEmotionUtils.replaceEmoCode(j3, ""))) + textPaint.measureText(i16) + (QzoneEmotionUtils.getEmoCount(j3) * (textPaint.getTextSize() + textPaint.measureText(".")));
        absDanmaku.setNickNameStr(i16);
        absDanmaku.setTextStr(j3);
        absDanmaku.setTextTopModifiedValue(-textPaint.ascent());
        if (absDanmaku.getUserUin() != -10) {
            measureText += paddingVertical;
        }
        float leftImagePadding = measureText + absDanmaku.getLeftImagePadding();
        absDanmaku.setContentWidth(leftImagePadding);
        absDanmaku.setContentHeight(paddingVertical);
        absDanmaku.setPaintWidth(leftImagePadding + (absDanmaku.getMarginHorizontal() * 2));
        absDanmaku.setPaintHeight(paddingVertical + (absDanmaku.getMarginVertical() * 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Canvas canvas, final AbsDanmaku absDanmaku, float f16, float f17, float f18, float f19) {
        System.currentTimeMillis();
        float f26 = absDanmaku.getConfig().mPaddingVertical;
        TextPaint textPaint = (TextPaint) r(absDanmaku, PaintType.Normal);
        float paddingHorizontal = f16 + absDanmaku.getPaddingHorizontal();
        float f27 = paddingHorizontal + f26;
        float f28 = f17 + f26;
        if (absDanmaku.getUserUin() != -10) {
            paddingHorizontal += f19 + absDanmaku.getLeftImagePadding();
        }
        float borderWidth = paddingHorizontal + absDanmaku.getBorderWidth();
        float borderWidth2 = f17 + absDanmaku.getBorderWidth() + absDanmaku.getPaddingVertical();
        String textStr = absDanmaku.getTextStr();
        float textTopModifiedValue = borderWidth2 + absDanmaku.getTextTopModifiedValue();
        if (textStr != null) {
            textPaint.setTypeface(Typeface.DEFAULT);
            if (absDanmaku.getNickNameTextColor() == -1) {
                textPaint.setColor(absDanmaku.getTextColor());
                textPaint.setAlpha(178);
            } else {
                textPaint.setColor(absDanmaku.getNickNameTextColor());
            }
            if (absDanmaku.hasShadowLayer) {
                textPaint.setShadowLayer(absDanmaku.shadowRadius, absDanmaku.shadowDx, absDanmaku.shadowDy, absDanmaku.shadowColor);
            }
            canvas.drawText(absDanmaku.getNickNameStr(), borderWidth, textTopModifiedValue, textPaint);
            canvas.save();
            if (absDanmaku.getUserUin() == -10) {
                canvas.translate(f16 + textPaint.measureText(absDanmaku.getNickNameStr()), textTopModifiedValue - textPaint.getTextSize());
            } else {
                canvas.translate(f16 + f19 + absDanmaku.getLeftImagePadding() + textPaint.measureText(absDanmaku.getNickNameStr()), (textTopModifiedValue - textPaint.getTextSize()) - (f26 / 2.0f));
            }
            if (this.f49929h == null) {
                QLog.e("PhotoDanmakuDrawer", 1, "context is null");
                return;
            }
            CellTextView cellTextView = new CellTextView(this.f49929h);
            cellTextView.setTextSize(textPaint.getTextSize());
            cellTextView.setTextGravity(17);
            cellTextView.setTextBold(true);
            cellTextView.setRichText(absDanmaku.getTextStr());
            cellTextView.setTextColorLink(absDanmaku.getTextColor());
            cellTextView.setTextColor(absDanmaku.getTextColor());
            if (absDanmaku.hasShadowLayer) {
                cellTextView.setShadowLayer(absDanmaku.shadowRadius, absDanmaku.shadowDx, absDanmaku.shadowDy, absDanmaku.shadowColor);
            }
            cellTextView.setOuterListener(new com.qzone.proxy.feedcomponent.text.font.a() { // from class: com.qzone.preview.photodanmaku.core.b
                @Override // com.qzone.proxy.feedcomponent.text.font.a
                public final void a() {
                    AbsDanmaku.this.setDrawCacheDirty(true);
                }
            });
            cellTextView.setMaxLine(1);
            if (absDanmaku.getSuperFontInfo() != null) {
                B(cellTextView, absDanmaku.getSuperFontInfo());
            }
            if (absDanmaku.getFontId() != -1) {
                cellTextView.setFont(absDanmaku.getFontId(), absDanmaku.getFontUrl(), absDanmaku.getFontType());
            }
            cellTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            cellTextView.layout((int) borderWidth, (int) textTopModifiedValue, (int) absDanmaku.getPaintWidth(), (int) absDanmaku.getPaintHeight());
            cellTextView.draw(canvas);
            try {
                canvas.restore();
            } catch (IllegalStateException unused) {
                j.c("PhotoDanmakuDrawer", "drawText get an IllegalStateException: canvas.restore()");
            }
            if (absDanmaku.getUserUin() != -10) {
                float f29 = f19 - (f26 * 2.0f);
                n(canvas, textPaint, absDanmaku, absDanmaku.getUserUin(), f27, f28, f29, f29);
            }
        }
    }
}

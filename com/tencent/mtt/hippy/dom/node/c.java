package com.tencent.mtt.hippy.dom.node;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends ImageSpan {

    /* renamed from: a, reason: collision with root package name */
    private int f337385a;

    /* renamed from: b, reason: collision with root package name */
    private int f337386b;

    /* renamed from: c, reason: collision with root package name */
    private int f337387c;

    /* renamed from: d, reason: collision with root package name */
    private int f337388d;

    /* renamed from: e, reason: collision with root package name */
    private String f337389e;

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference<ImageNode> f337390f;

    /* renamed from: g, reason: collision with root package name */
    private int f337391g;

    /* renamed from: h, reason: collision with root package name */
    private int f337392h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReference<HippyImageLoader> f337393i;

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<HippyEngineContext> f337394j;

    /* renamed from: k, reason: collision with root package name */
    private Movie f337395k;

    /* renamed from: l, reason: collision with root package name */
    private long f337396l;

    /* renamed from: m, reason: collision with root package name */
    private long f337397m;

    /* renamed from: n, reason: collision with root package name */
    private f f337398n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends e {
        a() {
            super();
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27) {
            return i18 - i27;
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18) {
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = -i18;
            }
            return i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends a {
        b() {
            super();
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.a, com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27) {
            return super.a(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint, fontMetricsInt, i26, i27) + fontMetricsInt.descent;
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.a, com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18) {
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = fontMetricsInt.descent - i18;
            }
            return i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.dom.node.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C9227c extends b {
        C9227c() {
            super();
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.b, com.tencent.mtt.hippy.dom.node.c.a, com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27) {
            return (super.a(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint, fontMetricsInt, i26, i27) - ((fontMetricsInt.descent - fontMetricsInt.ascent) >> 1)) + (i27 >> 1);
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.b, com.tencent.mtt.hippy.dom.node.c.a, com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18) {
            if (fontMetricsInt != null) {
                int i19 = fontMetricsInt.descent;
                int i26 = fontMetricsInt.ascent;
                if (i19 - i26 < i18) {
                    int i27 = i26 + i19;
                    fontMetricsInt.ascent = (i27 - i18) >> 1;
                    fontMetricsInt.descent = (i27 + i18) >> 1;
                }
            }
            return i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d extends e {
        d() {
            super();
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27) {
            return i18 + fontMetricsInt.ascent;
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.e
        public int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18) {
            if (fontMetricsInt != null) {
                fontMetricsInt.descent = i18 + fontMetricsInt.ascent;
            }
            return i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static abstract class e implements f {

        /* renamed from: a, reason: collision with root package name */
        private int f337402a;

        /* renamed from: b, reason: collision with root package name */
        private int f337403b;

        /* renamed from: c, reason: collision with root package name */
        private float f337404c;

        /* renamed from: d, reason: collision with root package name */
        private final int[] f337405d;

        /* renamed from: e, reason: collision with root package name */
        private int f337406e;

        /* renamed from: f, reason: collision with root package name */
        private int f337407f;

        e() {
            this.f337405d = new int[2];
        }

        private static int a(int i3, int i16, int i17, int i18) {
            if (i18 + i3 > i17) {
                i3 = i17 - i18;
            }
            return i3 < i16 ? i16 : i3;
        }

        abstract int a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27);

        abstract int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18);

        @Override // com.tencent.mtt.hippy.dom.node.c.f
        public int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, Drawable drawable) {
            int i17;
            a(drawable.getBounds(), paint);
            int[] iArr = this.f337405d;
            int i18 = 0;
            int i19 = iArr[0];
            int i26 = iArr[1];
            if (fontMetricsInt != null) {
                i18 = fontMetricsInt.top - fontMetricsInt.ascent;
                i17 = fontMetricsInt.bottom - fontMetricsInt.descent;
            } else {
                i17 = 0;
            }
            int a16 = a(paint, charSequence, i3, i16, fontMetricsInt, i19, i26);
            if (fontMetricsInt != null) {
                fontMetricsInt.top = fontMetricsInt.ascent + i18;
                fontMetricsInt.bottom = fontMetricsInt.descent + i17;
            }
            return this.f337406e + a16 + this.f337407f;
        }

        @Override // com.tencent.mtt.hippy.dom.node.c.f
        public void a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Drawable drawable) {
            Rect bounds = drawable.getBounds();
            int[] iArr = this.f337405d;
            int i26 = iArr[0];
            int i27 = iArr[1];
            int a16 = a(a(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint, paint.getFontMetricsInt(), i26, i27), i17, i19, i27);
            canvas.save();
            canvas.translate(f16 + this.f337406e, a16);
            canvas.scale(i26 / bounds.right, i27 / bounds.bottom);
            drawable.draw(canvas);
            canvas.restore();
        }

        private void a(Rect rect, Paint paint) {
            int i3;
            int i16;
            if (this.f337404c > 0.0f) {
                i3 = (int) (((int) paint.getTextSize()) * this.f337404c);
                i16 = (rect.right * i3) / rect.bottom;
            } else {
                i3 = this.f337403b;
                i16 = this.f337402a;
            }
            if (i16 <= 0 || i3 <= 0) {
                i16 = rect.right;
                i3 = rect.bottom;
            }
            int[] iArr = this.f337405d;
            iArr[0] = i16;
            iArr[1] = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        int a(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, Drawable drawable);

        void a(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Drawable drawable);
    }

    public c(Drawable drawable, String str, ImageNode imageNode, HippyImageLoader hippyImageLoader, HippyEngineContext hippyEngineContext) {
        super(drawable, str, imageNode.getVerticalAlignment());
        this.f337391g = 0;
        this.f337395k = null;
        this.f337396l = 0L;
        this.f337397m = -1L;
        this.f337394j = new WeakReference<>(hippyEngineContext);
        this.f337390f = new WeakReference<>(imageNode);
        this.f337393i = new WeakReference<>(hippyImageLoader);
        b(str);
        a(imageNode.getVerticalAlignment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(this.f337389e) && this.f337389e.equals(str) && this.f337391g != 0) {
            return;
        }
        this.f337389e = str;
        this.f337391g = 0;
        a();
        HippyImageLoader hippyImageLoader = this.f337393i.get();
        if (hippyImageLoader != null) {
            if (a(this.f337389e)) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushBoolean(NodeProps.CUSTOM_PROP_ISGIF, false);
                hippyMap.pushInt("width", this.f337387c);
                hippyMap.pushInt("height", this.f337388d);
                a(this.f337389e, hippyMap, hippyImageLoader);
                return;
            }
            a(hippyImageLoader.getImage(this.f337389e, (Object) null));
        }
    }

    public void b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UIThreadUtils.isOnUiThread()) {
            c(str);
        } else {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.dom.node.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(str);
                }
            });
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        int i26;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        Movie movie = this.f337395k;
        if (movie != null) {
            int i27 = this.f337387c;
            if (i27 == 0) {
                i26 = movie.width();
            } else {
                i26 = i27;
            }
            int i28 = this.f337388d;
            if (i28 == 0) {
                i28 = this.f337395k.height();
            }
            a(canvas, f16 + this.f337385a, (((((i18 + fontMetricsInt.descent) + i18) + fontMetricsInt.ascent) / 2) - (i28 / 2)) + this.f337386b, i26, i28);
            return;
        }
        this.f337398n.a(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint, getDrawable());
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.f337395k != null) {
            return super.getSize(paint, charSequence, i3, i16, fontMetricsInt);
        }
        return this.f337398n.a(paint, charSequence, i3, i16, fontMetricsInt, getDrawable());
    }

    private void a() {
        ImageNode imageNode;
        WeakReference<ImageNode> weakReference = this.f337390f;
        if (weakReference == null || (imageNode = weakReference.get()) == null) {
            return;
        }
        int round = Math.round(imageNode.getStyleWidth());
        int round2 = Math.round(imageNode.getStyleHeight());
        float position = imageNode.getPosition(1);
        float position2 = imageNode.getPosition(0);
        int round3 = Float.isNaN(position2) ? 0 : Math.round(position2);
        int round4 = Float.isNaN(position) ? 0 : Math.round(position);
        this.f337385a = round3;
        this.f337386b = round4;
        this.f337387c = round;
        this.f337388d = round2;
        this.f337392h = imageNode.getVerticalAlignment();
    }

    private void a(int i3) {
        this.f337398n = i3 != 1 ? i3 != 2 ? i3 != 3 ? new b() : new d() : new C9227c() : new a();
    }

    private void a(long j3) {
        ImageNode imageNode;
        WeakReference<ImageNode> weakReference = this.f337390f;
        if (weakReference == null || (imageNode = weakReference.get()) == null) {
            return;
        }
        com.tencent.mtt.hippy.dom.node.b parent = imageNode.getParent();
        if (parent instanceof TextNode) {
            ((TextNode) parent).postInvalidateDelayed(j3);
        }
    }

    private void a(Canvas canvas, float f16, float f17, int i3, int i16) {
        Movie movie = this.f337395k;
        if (movie == null) {
            return;
        }
        int duration = movie.duration();
        if (duration == 0) {
            duration = 1000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f337397m;
        if (j3 != -1) {
            long j16 = this.f337396l + (currentTimeMillis - j3);
            this.f337396l = j16;
            if (j16 > duration) {
                this.f337396l = 0L;
            }
        }
        this.f337397m = currentTimeMillis;
        float width = i3 / this.f337395k.width();
        float height = i16 / this.f337395k.height();
        if (width != 0.0f) {
            f16 /= width;
        }
        if (height != 0.0f) {
            f17 /= height;
        }
        long j17 = this.f337396l;
        this.f337395k.setTime(j17 > TTL.MAX_VALUE ? 0 : (int) j17);
        canvas.save();
        canvas.scale(width, height);
        this.f337395k.draw(canvas, f16, f17);
        canvas.restore();
        a(40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HippyDrawable hippyDrawable) {
        if (hippyDrawable == null) {
            this.f337391g = 0;
            return;
        }
        Bitmap bitmap = hippyDrawable.getBitmap();
        if (bitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            int i3 = this.f337387c;
            if (i3 == 0) {
                i3 = bitmapDrawable.getIntrinsicWidth();
            }
            int i16 = this.f337388d;
            if (i16 == 0) {
                i16 = bitmapDrawable.getIntrinsicHeight();
            }
            bitmapDrawable.setBounds(0, 0, i3, i16);
            try {
                Field declaredField = ImageSpan.class.getDeclaredField("mDrawable");
                declaredField.setAccessible(true);
                declaredField.set(this, bitmapDrawable);
                Field declaredField2 = DynamicDrawableSpan.class.getDeclaredField("mDrawableRef");
                declaredField2.setAccessible(true);
                declaredField2.set(this, null);
            } catch (IllegalAccessException | NoSuchFieldException e16) {
                e16.printStackTrace();
            }
        } else {
            if (!hippyDrawable.isAnimated()) {
                this.f337391g = 0;
                a(0L);
            }
            this.f337395k = hippyDrawable.getGIF();
        }
        this.f337391g = 2;
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HippyImageView.ImageEvent imageEvent) {
        ImageNode imageNode;
        WeakReference<ImageNode> weakReference = this.f337390f;
        if (weakReference == null || (imageNode = weakReference.get()) == null) {
            return;
        }
        String str = imageEvent == HippyImageView.ImageEvent.ONLOAD ? "onLoad" : imageEvent == HippyImageView.ImageEvent.ONERROR ? "onError" : null;
        if (TextUtils.isEmpty(str) || !imageNode.isEnableImageEvent(imageEvent)) {
            return;
        }
        new HippyViewEvent(str).send(imageNode.getId(), this.f337394j.get(), null);
    }

    private void a(String str, HippyMap hippyMap, HippyImageLoader hippyImageLoader) {
        this.f337391g = 1;
        hippyImageLoader.fetchImage(str, new HippyImageLoader.Callback() { // from class: com.tencent.mtt.hippy.dom.node.c.2
            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onRequestSuccess(HippyDrawable hippyDrawable) {
                c.this.a(hippyDrawable);
                c.this.a(HippyImageView.ImageEvent.ONLOAD);
            }

            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            public void onRequestFail(Throwable th5, String str2) {
                c.this.f337391g = 0;
                c.this.a(HippyImageView.ImageEvent.ONERROR);
            }

            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onRequestStart(HippyDrawable hippyDrawable) {
            }
        }, hippyMap);
    }

    protected boolean a(String str) {
        return UrlUtils.isWebUrl(str) || UrlUtils.isFileUrl(str);
    }
}

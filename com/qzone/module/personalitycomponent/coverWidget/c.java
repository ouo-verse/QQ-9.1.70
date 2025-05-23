package com.qzone.module.personalitycomponent.coverWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityResources;
import com.qzone.proxy.personalitycomponent.model.WidgetConstellationData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends com.qzone.module.personalitycomponent.coverWidget.b {

    /* renamed from: h, reason: collision with root package name */
    private WidgetConstellationData f48936h;

    /* renamed from: i, reason: collision with root package name */
    private int f48937i;

    /* renamed from: j, reason: collision with root package name */
    private int f48938j;

    /* renamed from: k, reason: collision with root package name */
    private int f48939k;

    /* renamed from: l, reason: collision with root package name */
    private int f48940l;

    /* renamed from: m, reason: collision with root package name */
    private int f48941m;

    /* renamed from: n, reason: collision with root package name */
    private int f48942n;

    /* renamed from: o, reason: collision with root package name */
    private String f48943o;

    /* renamed from: p, reason: collision with root package name */
    private String f48944p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f48945q;

    /* renamed from: r, reason: collision with root package name */
    private ImageLoader.ImageLoadListener f48946r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f48947s;

    /* renamed from: t, reason: collision with root package name */
    private String f48948t;

    /* renamed from: u, reason: collision with root package name */
    private Bitmap f48949u;

    /* renamed from: v, reason: collision with root package name */
    private Bitmap f48950v;

    /* renamed from: w, reason: collision with root package name */
    private String f48951w;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (c.this.f48936h != null) {
                PersonalityEnv.handleScheme(PersonalityConfig.getConfig("H5Url", PersonalityConfig.SECONDARY_WIDGET_DETAIL_URL, PersonalityConfig.WIDGET_DETAIL_URL) + "&type=constella&star=" + c.this.f48936h.constellationId, c.this.f48932d, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(Context context, Handler handler) {
        super(context, handler);
        this.f48948t = null;
        this.f48929a = 2;
        this.f48932d = context;
        if (context != null) {
            this.f48937i = PersonalityEnv.dpToPx(35.0f);
            this.f48938j = PersonalityEnv.dpToPx(35.0f);
            this.f48939k = PersonalityEnv.dpToPx(5.0f);
            this.f48940l = PersonalityEnv.dpToPx(3.0f);
            this.f48941m = PersonalityEnv.dpToPx(15.0f);
            this.f48942n = PersonalityEnv.dpToPx(15.0f);
            Paint paint = new Paint();
            this.f48945q = paint;
            paint.setAntiAlias(true);
            this.f48945q.setFakeBoldText(true);
            this.f48945q.setTextSize(PersonalityEnv.dpToPx(12.0f));
            this.f48945q.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#cc000000"));
        }
    }

    private int C() {
        WidgetConstellationData widgetConstellationData;
        int i3 = 0;
        if (this.f48945q != null && (widgetConstellationData = this.f48936h) != null && !TextUtils.isEmpty(widgetConstellationData.name)) {
            i3 = (int) (0 + this.f48945q.measureText(this.f48936h.name));
        }
        return i3 + this.f48939k + (this.f48941m * 5);
    }

    private int E() {
        int i3 = this.f48937i + 0 + this.f48939k;
        if (this.f48945q != null) {
            return i3 + Math.max((int) (TextUtils.isEmpty(this.f48943o) ? 0.0f : this.f48945q.measureText(this.f48943o)), (int) (TextUtils.isEmpty(this.f48944p) ? 0.0f : this.f48945q.measureText(this.f48944p)));
        }
        return i3;
    }

    private void F() {
        if (this.f48946r == null) {
            this.f48946r = new b();
        }
    }

    protected void H() {
        WidgetConstellationData widgetConstellationData = this.f48936h;
        if (widgetConstellationData == null || this.f48932d == null) {
            return;
        }
        String D = D(widgetConstellationData.constellationId);
        if ((D != null && !D.equals(this.f48948t)) || this.f48947s == null) {
            F();
            Drawable loadImage = ImageLoader.getInstance().loadImage(D, this.f48946r);
            if (loadImage != null && (loadImage instanceof SpecifiedBitmapDrawable)) {
                this.f48947s = Bitmap.createScaledBitmap(((SpecifiedBitmapDrawable) loadImage).getBitmap(), this.f48937i, this.f48938j, false);
            }
            this.f48948t = D;
        }
        if (this.f48949u == null) {
            Context context = this.f48932d;
            int i3 = PersonalityResources.DrawableID.qzone_cover_constellation_star;
            int i16 = this.f48941m;
            Bitmap bitmapFromResource = PersonalityResources.getBitmapFromResource(context, i3, i16, i16);
            if (bitmapFromResource != null) {
                int i17 = this.f48941m;
                this.f48949u = Bitmap.createScaledBitmap(bitmapFromResource, i17, i17, false);
            }
        }
        if (this.f48950v == null) {
            Context context2 = this.f48932d;
            int i18 = PersonalityResources.DrawableID.qzone_cover_constellation_starry;
            int i19 = this.f48941m;
            Bitmap bitmapFromResource2 = PersonalityResources.getBitmapFromResource(context2, i18, i19, i19);
            if (bitmapFromResource2 != null) {
                int i26 = this.f48941m;
                this.f48950v = Bitmap.createScaledBitmap(bitmapFromResource2, i26, i26, false);
            }
        }
        this.f48943o = "\u5951\u5408: ";
        if (!TextUtils.isEmpty(this.f48936h.good)) {
            this.f48943o += this.f48936h.good;
        }
        this.f48944p = "\u63d0\u9632: ";
        if (!TextUtils.isEmpty(this.f48936h.bad)) {
            this.f48944p += this.f48936h.bad;
        }
        this.f48951w = this.f48936h.name + ":\u4eca\u65e5\u8fd0\u52bf" + this.f48936h.lucky + "\u9897\u661f," + this.f48943o + "," + this.f48944p;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public String b() {
        return this.f48951w;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public View.OnClickListener c() {
        return new a();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int d() {
        if (this.f48936h == null) {
            return 0;
        }
        int i3 = this.f48938j + 0 + this.f48940l;
        Paint paint = this.f48945q;
        return Math.max(paint != null ? (int) (paint.getFontMetrics().descent - this.f48945q.getFontMetrics().ascent) : 0, this.f48942n) + i3;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int e() {
        if (this.f48936h != null) {
            return Math.max(E(), C());
        }
        return 0;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int g() {
        return this.f48929a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements ImageLoader.ImageLoadListener {
        b() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable == null || !(drawable instanceof SpecifiedBitmapDrawable)) {
                return;
            }
            Bitmap bitmap = ((SpecifiedBitmapDrawable) drawable).getBitmap();
            c.this.f48948t = str;
            c cVar = c.this;
            cVar.f48947s = Bitmap.createScaledBitmap(bitmap, cVar.f48937i, c.this.f48938j, false);
            c.this.f48933e.sendEmptyMessage(PersonalityConfig.MSG_REQUEST_DRAW);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public boolean G(Object obj) {
        if (obj == null || !(obj instanceof WidgetConstellationData)) {
            return false;
        }
        if (this.f48936h == null) {
            return true;
        }
        return !r0.equals((WidgetConstellationData) obj);
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void l(Canvas canvas) {
        Paint paint;
        if (canvas == null || this.f48936h == null || (paint = this.f48945q) == null || this.f48932d == null) {
            return;
        }
        int i3 = (int) (paint.getFontMetrics().descent - this.f48945q.getFontMetrics().ascent);
        int i16 = 0;
        int measureText = !TextUtils.isEmpty(this.f48936h.name) ? (int) this.f48945q.measureText(this.f48936h.name) : 0;
        int max = Math.max(measureText, this.f48937i);
        Bitmap bitmap = this.f48947s;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (max - this.f48937i) / 2, 0.0f, this.f48945q);
        }
        if (measureText > 0) {
            this.f48945q.setColor(Color.parseColor("#ffcc16"));
            this.f48945q.setFakeBoldText(false);
            canvas.drawText(this.f48936h.name, (max - measureText) / 2, ((this.f48938j + this.f48940l) + Math.max(i3, this.f48942n)) - this.f48945q.getFontMetrics().descent, this.f48945q);
        }
        int i17 = max + 0 + this.f48939k;
        this.f48945q.setFakeBoldText(true);
        this.f48945q.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        if (!TextUtils.isEmpty(this.f48943o)) {
            canvas.drawText(this.f48943o, i17, i3, this.f48945q);
        }
        if (!TextUtils.isEmpty(this.f48944p)) {
            canvas.drawText(this.f48944p, i17, this.f48938j - this.f48945q.getFontMetrics().descent, this.f48945q);
        }
        int i18 = this.f48938j + this.f48940l;
        int i19 = this.f48942n;
        if (i3 > i19) {
            i18 += (i3 - i19) / 2;
        }
        if (this.f48949u == null || this.f48950v == null) {
            return;
        }
        while (i16 < this.f48936h.lucky) {
            canvas.drawBitmap(this.f48949u, i17, i18, this.f48945q);
            i17 += this.f48941m;
            i16++;
        }
        while (i16 < 5) {
            canvas.drawBitmap(this.f48950v, i17, i18, this.f48945q);
            i17 += this.f48941m;
            i16++;
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void w(Object obj) {
        if (obj != null && (obj instanceof WidgetConstellationData) && G(obj)) {
            this.f48936h = (WidgetConstellationData) obj;
            H();
        }
    }

    public static String D(int i3) {
        switch (i3) {
            case 0:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_aries.png";
            case 1:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_taurus.png";
            case 2:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_gemini.png";
            case 3:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_cancer.png";
            case 4:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_leo.png";
            case 5:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_virgo.png";
            case 6:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_libra.png";
            case 7:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_scorpio.png";
            case 8:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_sagittarius.png";
            case 9:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_capricorn.png";
            case 10:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_aquarius.png";
            case 11:
                return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_constellation_pisces.png";
            default:
                return null;
        }
    }
}

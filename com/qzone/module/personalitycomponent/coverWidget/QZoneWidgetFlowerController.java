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
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.WidgetFlowerData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneWidgetFlowerController extends com.qzone.module.personalitycomponent.coverWidget.b {

    /* renamed from: h, reason: collision with root package name */
    private WidgetFlowerData f48798h;

    /* renamed from: i, reason: collision with root package name */
    private int f48799i;

    /* renamed from: j, reason: collision with root package name */
    private int f48800j;

    /* renamed from: k, reason: collision with root package name */
    private int f48801k;

    /* renamed from: l, reason: collision with root package name */
    private int f48802l;

    /* renamed from: m, reason: collision with root package name */
    private int f48803m;

    /* renamed from: n, reason: collision with root package name */
    private int f48804n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f48805o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f48806p;

    /* renamed from: q, reason: collision with root package name */
    private ImageLoader.ImageLoadListener f48807q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f48808r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f48809s;

    /* renamed from: t, reason: collision with root package name */
    private String f48810t;

    /* renamed from: u, reason: collision with root package name */
    private Bitmap f48811u;

    /* renamed from: v, reason: collision with root package name */
    private Bitmap f48812v;

    /* renamed from: w, reason: collision with root package name */
    private Bitmap f48813w;

    /* renamed from: x, reason: collision with root package name */
    private Bitmap f48814x;

    /* renamed from: y, reason: collision with root package name */
    private String f48815y;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneWidgetFlowerController qZoneWidgetFlowerController = QZoneWidgetFlowerController.this;
            if (qZoneWidgetFlowerController.f48932d != null) {
                qZoneWidgetFlowerController.G();
                PersonalityEnv.report("1", "4", "4");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneWidgetFlowerController(Context context, Handler handler) {
        super(context, handler);
        this.f48805o = false;
        this.f48929a = 3;
        this.f48932d = context;
        if (context != null) {
            this.f48799i = PersonalityEnv.dpToPx(34.0f);
            this.f48800j = PersonalityEnv.dpToPx(34.0f);
            this.f48801k = (int) (this.f48799i * 0.84090906f);
            this.f48802l = PersonalityEnv.dpToPx(15.0f);
            this.f48803m = PersonalityEnv.dpToPx(15.0f);
            this.f48804n = PersonalityEnv.dpToPx(2.0f);
            Paint paint = new Paint();
            this.f48806p = paint;
            paint.setAntiAlias(true);
            this.f48806p.setTextSize(PersonalityEnv.dpToPx(12.0f));
            this.f48806p.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.f48806p.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#cc000000"));
        }
    }

    private void D() {
        if (this.f48807q == null) {
            this.f48807q = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        PersonalityEnv.JumpFlowerVinePage(this.f48932d);
        this.f48805o = true;
    }

    protected void F() {
        Bitmap bitmapFromResource;
        Bitmap bitmapFromResource2;
        Bitmap bitmapFromResource3;
        Bitmap bitmapFromResource4;
        Bitmap bitmapFromResource5;
        String str;
        if (this.f48798h == null || this.f48932d == null) {
            return;
        }
        this.f48815y = "\u82b1\u85e4\u7684\u6d47\u6c34\u503c:" + this.f48798h.water + ",\u9633\u5149\u503c:" + this.f48798h.sunshine + ",\u7231\u5fc3\u503c:" + this.f48798h.love + ",\u65bd\u80a5\u503c:" + this.f48798h.nutrition;
        if (this.f48809s == null || ((str = this.f48810t) != null && !str.equals(this.f48798h.icon))) {
            this.f48809s = null;
            if (!TextUtils.isEmpty(this.f48798h.icon)) {
                D();
                Drawable loadImage = ImageLoader.getInstance().loadImage(this.f48798h.icon, this.f48807q);
                if (loadImage != null && (loadImage instanceof SpecifiedBitmapDrawable)) {
                    Bitmap bitmap = ((SpecifiedBitmapDrawable) loadImage).getBitmap();
                    int width = (bitmap.getWidth() * this.f48800j) / bitmap.getHeight();
                    this.f48799i = width;
                    this.f48809s = Bitmap.createScaledBitmap(bitmap, width, this.f48800j, false);
                    this.f48810t = this.f48798h.icon;
                }
            }
        }
        if (this.f48809s == null && this.f48808r == null && (bitmapFromResource5 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_cover_widget_flower_load_fail, 100, 100)) != null) {
            int width2 = (bitmapFromResource5.getWidth() * this.f48800j) / bitmapFromResource5.getHeight();
            this.f48801k = width2;
            this.f48808r = Bitmap.createScaledBitmap(bitmapFromResource5, width2, this.f48800j, false);
        }
        if (this.f48813w == null && (bitmapFromResource4 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_flower_love, this.f48802l, this.f48803m)) != null) {
            this.f48813w = Bitmap.createScaledBitmap(bitmapFromResource4, this.f48802l, this.f48803m, false);
        }
        if (this.f48814x == null && (bitmapFromResource3 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_flower_nutrition, this.f48802l, this.f48803m)) != null) {
            this.f48814x = Bitmap.createScaledBitmap(bitmapFromResource3, this.f48802l, this.f48803m, false);
        }
        if (this.f48812v == null && (bitmapFromResource2 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_flower_sunshine, this.f48802l, this.f48803m)) != null) {
            this.f48812v = Bitmap.createScaledBitmap(bitmapFromResource2, this.f48802l, this.f48803m, false);
        }
        if (this.f48811u != null || (bitmapFromResource = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_flower_water, this.f48802l, this.f48803m)) == null) {
            return;
        }
        this.f48811u = Bitmap.createScaledBitmap(bitmapFromResource, this.f48802l, this.f48803m, false);
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public String b() {
        return this.f48815y;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public View.OnClickListener c() {
        return new b();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int d() {
        if (this.f48798h != null) {
            return 0 + this.f48800j;
        }
        return 0;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int e() {
        int i3;
        if (this.f48798h == null) {
            return 0;
        }
        if (this.f48809s != null) {
            i3 = this.f48799i;
        } else {
            i3 = this.f48801k;
        }
        int i16 = i3 + 0;
        int i17 = (this.f48802l * 2) + (this.f48804n * 6);
        Paint paint = this.f48806p;
        if (paint != null) {
            i17 = (int) (((int) (i17 + paint.measureText(this.f48798h.water + ""))) + this.f48806p.measureText(this.f48798h.love + ""));
        }
        int i18 = (this.f48802l * 2) + (this.f48804n * 6);
        Paint paint2 = this.f48806p;
        if (paint2 != null) {
            i18 = (int) (((int) (i18 + paint2.measureText(this.f48798h.sunshine + ""))) + this.f48806p.measureText(this.f48798h.nutrition + ""));
        }
        return Math.max(i17, i18) + i16;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int g() {
        return this.f48929a;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void u() {
        if (this.f48805o) {
            if (this.f48933e != null) {
                PersonalityEnv.getBackgroundThreadHandler().post(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetFlowerController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QzoneWidgetService.shouldShowWidget(QZoneWidgetFlowerController.this.f48932d, PersonalityEnv.getLoginUin())) {
                            QzoneWidgetService.getInstance().refreshWidgetInfo(null, QzoneWidgetService.getWidgetType(QZoneWidgetFlowerController.this.f48932d, PersonalityEnv.getLoginUin()));
                        }
                    }
                });
            }
            this.f48805o = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable == null || !(drawable instanceof SpecifiedBitmapDrawable)) {
                return;
            }
            Bitmap bitmap = ((SpecifiedBitmapDrawable) drawable).getBitmap();
            QZoneWidgetFlowerController.this.f48810t = str;
            QZoneWidgetFlowerController.this.f48799i = (bitmap.getWidth() * QZoneWidgetFlowerController.this.f48800j) / bitmap.getHeight();
            QZoneWidgetFlowerController qZoneWidgetFlowerController = QZoneWidgetFlowerController.this;
            qZoneWidgetFlowerController.f48809s = Bitmap.createScaledBitmap(bitmap, qZoneWidgetFlowerController.f48799i, QZoneWidgetFlowerController.this.f48800j, false);
            QZoneWidgetFlowerController.this.f48933e.sendEmptyMessage(PersonalityConfig.MSG_REQUEST_DRAW);
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

    public boolean E(Object obj) {
        if (obj == null || !(obj instanceof WidgetFlowerData)) {
            return false;
        }
        if (this.f48798h == null) {
            return true;
        }
        return !r0.equals((WidgetFlowerData) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(Canvas canvas) {
        Paint paint;
        int i3;
        int i16;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        if (canvas == null || this.f48798h == null || (paint = this.f48806p) == null || this.f48932d == null) {
            return;
        }
        Bitmap bitmap5 = this.f48809s;
        if (bitmap5 != null) {
            canvas.drawBitmap(bitmap5, 0.0f, 0.0f, paint);
            i16 = this.f48799i;
        } else {
            Bitmap bitmap6 = this.f48808r;
            if (bitmap6 != null) {
                canvas.drawBitmap(bitmap6, 0.0f, 0.0f, paint);
                i16 = this.f48801k;
            } else {
                i3 = 0;
                int i17 = i3 + this.f48804n;
                int i18 = this.f48800j;
                int i19 = this.f48803m;
                int i26 = i18 > i19 * 2 ? (i18 - (i19 * 2)) / 4 : 0;
                bitmap = this.f48811u;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, i17, i26, this.f48806p);
                }
                bitmap2 = this.f48812v;
                if (bitmap2 != null) {
                    canvas.drawBitmap(bitmap2, i17, (this.f48800j - this.f48803m) - i26, this.f48806p);
                }
                int i27 = i17 + this.f48802l + this.f48804n;
                float f16 = i27;
                float f17 = ((int) (this.f48806p.getFontMetrics().descent - this.f48806p.getFontMetrics().ascent)) + i26;
                canvas.drawText(this.f48798h.water + "", f16, f17, this.f48806p);
                float f18 = i26;
                canvas.drawText(this.f48798h.sunshine + "", f16, (this.f48800j - this.f48806p.getFontMetrics().descent) - f18, this.f48806p);
                int max = ((int) (f16 + Math.max(this.f48806p.measureText(this.f48798h.water + ""), this.f48806p.measureText(this.f48798h.sunshine + "")))) + (this.f48804n * 3);
                bitmap3 = this.f48813w;
                if (bitmap3 != null) {
                    canvas.drawBitmap(bitmap3, max, f18, this.f48806p);
                }
                bitmap4 = this.f48814x;
                if (bitmap4 != null) {
                    canvas.drawBitmap(bitmap4, max, (this.f48800j - this.f48803m) - i26, this.f48806p);
                }
                float f19 = max + this.f48802l + this.f48804n;
                canvas.drawText(this.f48798h.love + "", f19, f17, this.f48806p);
                canvas.drawText(this.f48798h.nutrition + "", f19, (this.f48800j - this.f48806p.getFontMetrics().descent) - f18, this.f48806p);
            }
        }
        i3 = i16 + 0;
        int i172 = i3 + this.f48804n;
        int i182 = this.f48800j;
        int i192 = this.f48803m;
        if (i182 > i192 * 2) {
        }
        bitmap = this.f48811u;
        if (bitmap != null) {
        }
        bitmap2 = this.f48812v;
        if (bitmap2 != null) {
        }
        int i272 = i172 + this.f48802l + this.f48804n;
        float f162 = i272;
        float f172 = ((int) (this.f48806p.getFontMetrics().descent - this.f48806p.getFontMetrics().ascent)) + i26;
        canvas.drawText(this.f48798h.water + "", f162, f172, this.f48806p);
        float f182 = i26;
        canvas.drawText(this.f48798h.sunshine + "", f162, (this.f48800j - this.f48806p.getFontMetrics().descent) - f182, this.f48806p);
        int max2 = ((int) (f162 + Math.max(this.f48806p.measureText(this.f48798h.water + ""), this.f48806p.measureText(this.f48798h.sunshine + "")))) + (this.f48804n * 3);
        bitmap3 = this.f48813w;
        if (bitmap3 != null) {
        }
        bitmap4 = this.f48814x;
        if (bitmap4 != null) {
        }
        float f192 = max2 + this.f48802l + this.f48804n;
        canvas.drawText(this.f48798h.love + "", f192, f172, this.f48806p);
        canvas.drawText(this.f48798h.nutrition + "", f192, (this.f48800j - this.f48806p.getFontMetrics().descent) - f182, this.f48806p);
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void w(Object obj) {
        if (obj != null && (obj instanceof WidgetFlowerData) && E(obj)) {
            this.f48798h = (WidgetFlowerData) obj;
            F();
        }
    }
}

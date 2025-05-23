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
import com.qzone.proxy.personalitycomponent.adapter.PLog;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityResources;
import com.qzone.proxy.personalitycomponent.model.WidgetLunarData;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneWidgetLunarController extends b {
    private String A;
    private cooperation.vip.vipcomponent.util.e B;

    /* renamed from: h, reason: collision with root package name */
    private WidgetLunarData f48818h;

    /* renamed from: i, reason: collision with root package name */
    private int f48819i;

    /* renamed from: j, reason: collision with root package name */
    private int f48820j;

    /* renamed from: k, reason: collision with root package name */
    private int f48821k;

    /* renamed from: l, reason: collision with root package name */
    private int f48822l;

    /* renamed from: m, reason: collision with root package name */
    private int f48823m;

    /* renamed from: n, reason: collision with root package name */
    private int f48824n;

    /* renamed from: o, reason: collision with root package name */
    private int f48825o;

    /* renamed from: p, reason: collision with root package name */
    private int f48826p;

    /* renamed from: q, reason: collision with root package name */
    private int f48827q;

    /* renamed from: r, reason: collision with root package name */
    private String f48828r;

    /* renamed from: s, reason: collision with root package name */
    private Paint f48829s;

    /* renamed from: t, reason: collision with root package name */
    private volatile Bitmap f48830t;

    /* renamed from: u, reason: collision with root package name */
    private volatile Bitmap f48831u;

    /* renamed from: v, reason: collision with root package name */
    private volatile Bitmap f48832v;

    /* renamed from: w, reason: collision with root package name */
    private String f48833w;

    /* renamed from: x, reason: collision with root package name */
    private String f48834x;

    /* renamed from: y, reason: collision with root package name */
    private volatile Bitmap f48835y;

    /* renamed from: z, reason: collision with root package name */
    private volatile Bitmap f48836z;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PersonalityEnv.handleScheme(PersonalityConfig.getConfig("H5Url", PersonalityConfig.SECONDARY_WIDGET_DETAIL_URL, PersonalityConfig.WIDGET_DETAIL_URL) + "&type=almanac&zone=" + (TimeZone.getDefault().getRawOffset() / 36000), QZoneWidgetLunarController.this.f48932d, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneWidgetLunarController(Context context, Handler handler) {
        super(context, handler);
        this.B = new cooperation.vip.vipcomponent.util.e() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetLunarController.3
            @Override // cooperation.vip.vipcomponent.util.e
            public void onDownloaded(String str, int i3, String str2, Drawable drawable) {
                if (PLog.isColorLevel()) {
                    PLog.d("CoverWidget ", PLog.CLR, "ResDownload Failed, type=" + i3 + ", resName=" + str2);
                }
                VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetLunarController.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneWidgetLunarController.this.A();
                        QZoneWidgetLunarController.this.s();
                    }
                });
            }

            @Override // cooperation.vip.vipcomponent.util.e
            public void onFailed(String str, int i3, String str2) {
                PLog.w("CoverWidget ", "ResDownload Failed, type=" + i3 + ", resName=" + str2);
            }
        };
        this.f48929a = 1;
        this.f48932d = context;
        if (context != null) {
            this.f48819i = PersonalityEnv.dpToPx(45.0f);
            this.f48820j = PersonalityEnv.dpToPx(45.0f);
            this.f48821k = PersonalityEnv.dpToPx(6.0f);
            this.f48822l = PersonalityEnv.dpToPx(13.0f);
            this.f48823m = PersonalityEnv.dpToPx(13.0f);
            this.f48824n = PersonalityEnv.dpToPx(1.0f);
            this.f48825o = PersonalityEnv.dpToPx(17.0f);
            this.f48826p = PersonalityEnv.dpToPx(17.0f);
            this.f48827q = PersonalityEnv.dpToPx(6.0f);
            Paint paint = new Paint();
            this.f48829s = paint;
            paint.setAntiAlias(true);
            this.f48829s.setFakeBoldText(true);
            this.f48829s.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.f48829s.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#cc000000"));
        }
    }

    private String x(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("\u521d")) {
                return "qzone_cover_lunar_first";
            }
            if (str.startsWith("\u5341")) {
                return "qzone_cover_lunar_ten";
            }
            if (str.startsWith("\u5eff")) {
                return "qzone_cover_lunar_twenty";
            }
            if (str.startsWith("\u4e09")) {
                return "qzone_cover_lunar_three";
            }
            if (str.startsWith("\u4e8c")) {
                return "qzone_cover_lunar_two";
            }
        }
        return null;
    }

    private String y(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.endsWith("\u4e00")) {
                return "qzone_cover_lunar_one";
            }
            if (str.endsWith("\u4e8c")) {
                return "qzone_cover_lunar_two";
            }
            if (str.endsWith("\u4e09")) {
                return "qzone_cover_lunar_three";
            }
            if (str.endsWith("\u56db")) {
                return "qzone_cover_lunar_four";
            }
            if (str.endsWith("\u4e94")) {
                return "qzone_cover_lunar_five";
            }
            if (str.endsWith("\u516d")) {
                return "qzone_cover_lunar_six";
            }
            if (str.endsWith("\u4e03")) {
                return "qzone_cover_lunar_seven";
            }
            if (str.endsWith("\u516b")) {
                return "qzone_cover_lunar_eight";
            }
            if (str.endsWith("\u4e5d")) {
                return "qzone_cover_lunar_nine";
            }
            if (str.endsWith("\u5341")) {
                return "qzone_cover_lunar_ten";
            }
        }
        return null;
    }

    protected void A() {
        Bitmap coverWidgetLunarZipBitmap;
        Bitmap coverWidgetLunarZipBitmap2;
        Bitmap coverWidgetLunarZipBitmap3;
        Bitmap coverWidgetLunarZipBitmap4;
        Bitmap coverWidgetLunarZipBitmap5;
        if (this.f48818h == null || this.f48932d == null) {
            return;
        }
        if (this.f48830t == null && (coverWidgetLunarZipBitmap5 = PersonalityResources.getCoverWidgetLunarZipBitmap(-1, "qzone_cover_lunar_calendar", this.B)) != null) {
            this.f48830t = Bitmap.createScaledBitmap(coverWidgetLunarZipBitmap5, this.f48819i, this.f48820j, false);
        }
        String x16 = x(this.f48818h.lunar_d);
        if (TextUtils.isEmpty(x16)) {
            this.f48831u = null;
        } else if ((!x16.equals(this.f48833w) || this.f48831u == null) && (coverWidgetLunarZipBitmap = PersonalityResources.getCoverWidgetLunarZipBitmap(-1, x16, this.B)) != null) {
            this.f48831u = Bitmap.createScaledBitmap(coverWidgetLunarZipBitmap, this.f48822l, this.f48823m, false);
            this.f48833w = x16;
        }
        String y16 = y(this.f48818h.lunar_d);
        if (TextUtils.isEmpty(y16)) {
            this.f48832v = null;
        } else if ((!y16.equals(this.f48834x) || this.f48832v == null) && (coverWidgetLunarZipBitmap2 = PersonalityResources.getCoverWidgetLunarZipBitmap(-1, y16, this.B)) != null) {
            this.f48832v = Bitmap.createScaledBitmap(coverWidgetLunarZipBitmap2, this.f48822l, this.f48823m, false);
            this.f48834x = y16;
        }
        if (this.f48835y == null && (coverWidgetLunarZipBitmap4 = PersonalityResources.getCoverWidgetLunarZipBitmap(-1, "qzone_cover_lunar_suitable", this.B)) != null) {
            this.f48835y = Bitmap.createScaledBitmap(coverWidgetLunarZipBitmap4, this.f48825o, this.f48826p, false);
        }
        if (this.f48836z == null && (coverWidgetLunarZipBitmap3 = PersonalityResources.getCoverWidgetLunarZipBitmap(-1, "qzone_cover_lunar_avoid", this.B)) != null) {
            this.f48836z = Bitmap.createScaledBitmap(coverWidgetLunarZipBitmap3, this.f48825o, this.f48826p, false);
        }
        this.f48828r = "\u519c\u5386";
        if (!TextUtils.isEmpty(this.f48818h.lunar_m) && !TextUtils.isDigitsOnly(this.f48818h.lunar_m)) {
            this.f48828r += this.f48818h.lunar_m;
        }
        this.A = this.f48828r + this.f48818h.lunar_d + ",\u5b9c:" + this.f48818h.f50991yi + ",\u5fcc:" + this.f48818h.f50990ji;
        t();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public String b() {
        return this.A;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public View.OnClickListener c() {
        return new a();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int d() {
        if (this.f48818h != null) {
            return 0 + this.f48820j;
        }
        return 0;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int e() {
        if (this.f48932d == null || this.f48818h == null) {
            return 0;
        }
        int i3 = this.f48819i + 0 + this.f48821k + this.f48825o + this.f48827q;
        Paint paint = this.f48829s;
        if (paint == null) {
            return i3;
        }
        paint.setTextSize(PersonalityEnv.dpToPx(12.0f));
        return Math.max(!TextUtils.isEmpty(this.f48818h.f50991yi) ? (int) this.f48829s.measureText(this.f48818h.f50991yi) : 0, TextUtils.isEmpty(this.f48818h.f50990ji) ? 0 : (int) this.f48829s.measureText(this.f48818h.f50990ji)) + i3;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int g() {
        return this.f48929a;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void l(Canvas canvas) {
        if (canvas == null || this.f48818h == null || this.f48829s == null || this.f48932d == null || this.f48830t == null || this.f48831u == null || this.f48832v == null || this.f48835y == null || this.f48836z == null) {
            return;
        }
        if (this.f48830t != null) {
            canvas.drawBitmap(this.f48830t, 0.0f, 0.0f, this.f48829s);
        }
        if (!TextUtils.isEmpty(this.f48828r)) {
            this.f48829s.setTextSize(PersonalityEnv.dpToPx(7.0f));
            canvas.drawText(this.f48828r, ((int) this.f48829s.measureText(this.f48828r)) < this.f48819i ? (r3 - r0) / 2 : 0, (this.f48820j * 0.3888889f) - this.f48829s.getFontMetrics().descent, this.f48829s);
        }
        int i3 = (int) ((this.f48820j * 0.3888889f) + ((((int) (r0 * 0.6111111f)) - this.f48823m) / 2));
        int i16 = ((this.f48819i - (this.f48822l * 2)) - this.f48824n) / 2;
        if (this.f48831u != null) {
            canvas.drawBitmap(this.f48831u, i16, i3, this.f48829s);
        }
        int i17 = i16 + this.f48822l + this.f48824n;
        if (this.f48832v != null) {
            canvas.drawBitmap(this.f48832v, i17, i3, this.f48829s);
        }
        int i18 = this.f48819i + this.f48821k;
        int i19 = this.f48820j;
        int i26 = this.f48826p;
        int i27 = i19 > i26 * 2 ? (i19 - (i26 * 2)) / 4 : 0;
        if (this.f48835y != null) {
            canvas.drawBitmap(this.f48835y, i18, i27, this.f48829s);
        }
        int i28 = (this.f48820j - this.f48826p) - i27;
        if (this.f48836z != null) {
            canvas.drawBitmap(this.f48836z, i18, i28, this.f48829s);
        }
        int i29 = i18 + this.f48825o + this.f48827q;
        this.f48829s.setTextSize(PersonalityEnv.dpToPx(12.0f));
        int i36 = (int) (this.f48829s.getFontMetrics().descent - this.f48829s.getFontMetrics().ascent);
        int i37 = this.f48826p;
        int i38 = i37 > i36 ? (i37 - i36) / 2 : 0;
        if (!TextUtils.isEmpty(this.f48818h.f50991yi)) {
            canvas.drawText(this.f48818h.f50991yi, i29, (int) (((this.f48826p - this.f48829s.getFontMetrics().descent) - i38) + i27), this.f48829s);
        }
        if (TextUtils.isEmpty(this.f48818h.f50990ji)) {
            return;
        }
        canvas.drawText(this.f48818h.f50990ji, i29, (int) (((this.f48820j - this.f48829s.getFontMetrics().descent) - i38) - i27), this.f48829s);
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void w(Object obj) {
        if (obj != null && (obj instanceof WidgetLunarData) && z(obj)) {
            this.f48818h = (WidgetLunarData) obj;
            PersonalityEnv.getBackgroundThreadHandler().post(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetLunarController.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneWidgetLunarController.this.A();
                }
            });
        }
    }

    public boolean z(Object obj) {
        if (obj == null || !(obj instanceof WidgetLunarData)) {
            return false;
        }
        if (this.f48818h == null) {
            return true;
        }
        return !r0.equals((WidgetLunarData) obj);
    }
}

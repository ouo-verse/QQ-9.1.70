package com.qzone.module.personalitycomponent.coverWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qzone.proxy.personalitycomponent.adapter.PLog;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityResources;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneWidgetWeatherController extends b {
    private String A;
    private String[] B;
    private boolean C;
    private String D;
    private cooperation.vip.vipcomponent.util.e E;

    /* renamed from: h, reason: collision with root package name */
    private WidgetWeatherData f48898h;

    /* renamed from: i, reason: collision with root package name */
    private int f48899i;

    /* renamed from: j, reason: collision with root package name */
    private int f48900j;

    /* renamed from: k, reason: collision with root package name */
    private int f48901k;

    /* renamed from: l, reason: collision with root package name */
    private int f48902l;

    /* renamed from: m, reason: collision with root package name */
    private int f48903m;

    /* renamed from: n, reason: collision with root package name */
    private int f48904n;

    /* renamed from: o, reason: collision with root package name */
    private int f48905o;

    /* renamed from: p, reason: collision with root package name */
    private int f48906p;

    /* renamed from: q, reason: collision with root package name */
    private int f48907q;

    /* renamed from: r, reason: collision with root package name */
    private int f48908r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f48909s;

    /* renamed from: t, reason: collision with root package name */
    private String f48910t;

    /* renamed from: u, reason: collision with root package name */
    private Paint f48911u;

    /* renamed from: v, reason: collision with root package name */
    private volatile Bitmap f48912v;

    /* renamed from: w, reason: collision with root package name */
    private volatile Bitmap f48913w;

    /* renamed from: x, reason: collision with root package name */
    private volatile Bitmap[] f48914x;

    /* renamed from: y, reason: collision with root package name */
    private volatile Bitmap f48915y;

    /* renamed from: z, reason: collision with root package name */
    private String f48916z;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HashMap hashMap = new HashMap();
            hashMap.put("pendant_type", 1);
            fo.c.e("em_qz_pendant", "pg_bas_social_updates", view, hashMap);
            Pair<Integer, Integer> gpsLocation = PersonalityEnv.getGpsLocation();
            if (gpsLocation != null) {
                PersonalityEnv.handleScheme(PersonalityConfig.getConfig("H5Url", PersonalityConfig.SECONDARY_WIDGET_DETAIL_URL, PersonalityConfig.WIDGET_DETAIL_URL) + "&type=weather&lat=" + gpsLocation.first + "&lon=" + gpsLocation.second, QZoneWidgetWeatherController.this.f48932d, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneWidgetWeatherController(Context context, Handler handler) {
        super(context, handler);
        this.f48907q = 0;
        this.f48908r = 0;
        this.f48909s = false;
        this.B = new String[]{"\u6674", "\u591a\u4e91", "\u9634", "\u96e8", "\u96e8\u52a0\u96ea", "\u96f7\u9635\u96e8", "\u96ea", "\u96fe", "\u6c99", "\u98ce"};
        this.C = true;
        this.D = "";
        this.E = new cooperation.vip.vipcomponent.util.e() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetWeatherController.3
            @Override // cooperation.vip.vipcomponent.util.e
            public void onDownloaded(String str, int i3, String str2, Drawable drawable) {
                if (PLog.isColorLevel()) {
                    PLog.d("CoverWidget ", PLog.CLR, "ResDownload Failed, type=" + i3 + ", resName=" + str2);
                }
                VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetWeatherController.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneWidgetWeatherController.this.C();
                    }
                });
            }

            @Override // cooperation.vip.vipcomponent.util.e
            public void onFailed(String str, int i3, String str2) {
                PLog.w("CoverWidget ", "ResDownload Failed, type=" + i3 + ", resName=" + str2);
            }
        };
        this.f48929a = 0;
        this.f48932d = context;
        if (context != null) {
            this.f48899i = PersonalityEnv.dpToPx(43.0f);
            this.f48900j = PersonalityEnv.dpToPx(32.0f);
            this.f48901k = PersonalityEnv.dpToPx(17.0f);
            this.f48902l = PersonalityEnv.dpToPx(11.0f);
            this.f48903m = PersonalityEnv.dpToPx(10.0f);
            this.f48904n = PersonalityEnv.dpToPx(6.0f);
            this.f48905o = PersonalityEnv.dpToPx(4.0f);
            this.f48906p = PersonalityEnv.dpToPx(20.0f);
            Paint paint = new Paint();
            this.f48911u = paint;
            paint.setAntiAlias(true);
            this.f48911u.setFakeBoldText(true);
            this.f48911u.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.f48911u.setShadowLayer(6.0f, 0.0f, 0.0f, Color.parseColor("#59000000"));
        }
    }

    private void x(Canvas canvas) {
        int i3;
        int i16;
        if (this.f48912v != null) {
            canvas.drawBitmap(this.f48912v, 0, 0.0f, this.f48911u);
        }
        int i17 = 0 + this.f48899i;
        if (this.f48907q >= 0 && this.f48914x != null && this.f48907q < this.f48914x.length && this.f48914x[this.f48907q] != null) {
            canvas.drawBitmap(this.f48914x[this.f48907q], i17, 0.0f, this.f48911u);
            if (this.f48907q == 1) {
                i16 = this.f48902l;
            } else {
                i16 = this.f48901k;
            }
            i17 += i16;
        }
        if (this.f48908r >= 0 && this.f48914x != null && this.f48908r < this.f48914x.length && this.f48914x[this.f48908r] != null) {
            canvas.drawBitmap(this.f48914x[this.f48908r], i17, 0.0f, this.f48911u);
            if (this.f48908r == 1) {
                i3 = this.f48902l;
            } else {
                i3 = this.f48901k;
            }
            i17 += i3;
        }
        if (this.f48915y != null) {
            canvas.drawBitmap(this.f48915y, i17, 0.0f, this.f48911u);
        }
        if (TextUtils.isEmpty(this.D)) {
            return;
        }
        this.f48911u.setTextSize(PersonalityEnv.dpToPx(8.0f));
        Paint.FontMetrics fontMetrics = this.f48911u.getFontMetrics();
        canvas.drawText(this.D, 0.0f, this.f48900j + ((int) (fontMetrics.descent - fontMetrics.ascent)), this.f48911u);
    }

    private String y() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(2) + 1) + "\u6708" + calendar.get(5) + "\u65e5";
    }

    protected void C() {
        Bitmap coverWidgetWeatherZipBitmap;
        Bitmap coverWidgetWeatherZipBitmap2;
        int i3;
        Bitmap coverWidgetWeatherZipBitmap3;
        int i16;
        Bitmap coverWidgetWeatherZipBitmap4;
        if (this.f48898h == null || this.f48932d == null) {
            return;
        }
        this.A = this.f48898h.iTempCurr + "\u6444\u6c0f\u5ea6" + this.f48898h.strCityName + "PM 2.5 " + this.f48898h.iPM2p5;
        WidgetWeatherData widgetWeatherData = this.f48898h;
        String A = A(widgetWeatherData.iWeather, widgetWeatherData.iDayTime);
        if (!TextUtils.isEmpty(A) && (!A.equals(this.f48916z) || this.f48912v == null)) {
            Bitmap coverWidgetWeatherZipBitmap5 = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, A, this.E);
            if (coverWidgetWeatherZipBitmap5 != null) {
                this.f48912v = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap5, this.f48899i, this.f48900j, false);
            }
            this.f48916z = A;
        }
        int i17 = this.f48898h.iTempCurr;
        this.f48909s = i17 < 0;
        if (i17 < 0 && this.f48913w == null && (coverWidgetWeatherZipBitmap4 = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, "qzone_cover_weather_belowzero", this.E)) != null) {
            this.f48913w = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap4, this.f48903m, this.f48900j, false);
        }
        if (this.f48914x == null) {
            this.f48914x = new Bitmap[10];
        }
        int abs = Math.abs(this.f48898h.iTempCurr);
        int i18 = abs / 10;
        this.f48907q = i18;
        if (i18 >= 10) {
            this.f48907q = i18 % 10;
        }
        if (this.f48907q > 0) {
            Bitmap[] bitmapArr = this.f48914x;
            int i19 = this.f48907q;
            if (bitmapArr[i19] == null && (coverWidgetWeatherZipBitmap3 = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, z(i19), this.E)) != null) {
                Bitmap[] bitmapArr2 = this.f48914x;
                int i26 = this.f48907q;
                if (i26 == 1) {
                    i16 = this.f48902l;
                } else {
                    i16 = this.f48901k;
                }
                bitmapArr2[i26] = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap3, i16, this.f48900j, false);
            }
        }
        this.f48908r = abs % 10;
        Bitmap[] bitmapArr3 = this.f48914x;
        int i27 = this.f48908r;
        if (bitmapArr3[i27] == null && (coverWidgetWeatherZipBitmap2 = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, z(i27), this.E)) != null) {
            Bitmap[] bitmapArr4 = this.f48914x;
            int i28 = this.f48908r;
            if (i28 == 1) {
                i3 = this.f48902l;
            } else {
                i3 = this.f48901k;
            }
            bitmapArr4[i28] = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap2, i3, this.f48900j, false);
        }
        if (this.f48915y == null && (coverWidgetWeatherZipBitmap = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, "qzone_cover_weather_degreescelsius", this.E)) != null) {
            this.f48915y = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap, this.f48904n, this.f48900j, false);
        }
        WidgetWeatherData widgetWeatherData2 = this.f48898h;
        if (widgetWeatherData2.iPM2p5 != -1) {
            this.f48910t = "PM2.5   " + this.f48898h.iPM2p5;
        } else if (!TextUtils.isEmpty(widgetWeatherData2.strDate)) {
            this.f48910t = this.f48898h.strDate;
        } else {
            this.f48910t = y();
        }
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
        if (this.f48898h != null) {
            return this.f48900j;
        }
        if (this.C || TextUtils.isEmpty(this.D)) {
            return 0;
        }
        return this.f48900j + this.f48906p;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int e() {
        int i3;
        int i16;
        int i17;
        WidgetWeatherData widgetWeatherData = this.f48898h;
        int i18 = 0;
        if (widgetWeatherData != null && this.f48932d != null) {
            int i19 = this.f48899i + 0;
            if (this.f48909s) {
                i19 += this.f48903m;
            }
            int i26 = this.f48907q;
            if (i26 > 0) {
                if (i26 == 1) {
                    i17 = this.f48902l;
                } else {
                    i17 = this.f48901k;
                }
                i19 += i17;
            }
            if (this.f48908r == 1) {
                i3 = this.f48902l;
            } else {
                i3 = this.f48901k;
            }
            int i27 = i19 + i3 + this.f48904n + this.f48905o;
            if (this.f48911u == null) {
                return i27;
            }
            if (TextUtils.isEmpty(widgetWeatherData.strCityName)) {
                i16 = 0;
            } else {
                this.f48911u.setTextSize(PersonalityEnv.dpToPx(12.0f));
                i16 = (int) this.f48911u.measureText(this.f48898h.strCityName);
            }
            if (!TextUtils.isEmpty(this.f48910t)) {
                this.f48911u.setTextSize(PersonalityEnv.dpToPx(10.0f));
                i18 = (int) this.f48911u.measureText(this.f48910t);
            }
            return i27 + Math.max(i16, i18);
        }
        if (this.C || TextUtils.isEmpty(this.D)) {
            return 0;
        }
        int i28 = this.f48899i + 0;
        int i29 = this.f48901k;
        return this.f48905o + i28 + i29 + i29 + this.f48904n;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int g() {
        return this.f48929a;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public boolean j() {
        return !this.C;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void m(String str) {
        Bitmap coverWidgetWeatherZipBitmap;
        Bitmap coverWidgetWeatherZipBitmap2;
        int i3;
        super.m(str);
        this.C = false;
        this.D = str;
        String A = A(1, 1);
        if (!TextUtils.isEmpty(A) && (!A.equals(this.f48916z) || this.f48912v == null)) {
            Bitmap coverWidgetWeatherZipBitmap3 = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, A, this.E);
            if (coverWidgetWeatherZipBitmap3 != null) {
                this.f48912v = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap3, this.f48899i, this.f48900j, false);
            }
            this.f48916z = A;
        }
        this.f48907q = 0;
        this.f48908r = 0;
        if (this.f48914x == null) {
            this.f48914x = new Bitmap[10];
        }
        Bitmap[] bitmapArr = this.f48914x;
        int i16 = this.f48907q;
        if (bitmapArr[i16] == null && (coverWidgetWeatherZipBitmap2 = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, z(i16), this.E)) != null) {
            Bitmap[] bitmapArr2 = this.f48914x;
            int i17 = this.f48907q;
            if (i17 == 1) {
                i3 = this.f48902l;
            } else {
                i3 = this.f48901k;
            }
            bitmapArr2[i17] = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap2, i3, this.f48900j, false);
        }
        if (this.f48915y == null && (coverWidgetWeatherZipBitmap = PersonalityResources.getCoverWidgetWeatherZipBitmap(-1, "qzone_cover_weather_degreescelsius", this.E)) != null) {
            this.f48915y = Bitmap.createScaledBitmap(coverWidgetWeatherZipBitmap, this.f48904n, this.f48900j, false);
        }
        t();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void o() {
        super.o();
        this.C = true;
        this.D = "";
        t();
    }

    public boolean B(Object obj) {
        if (obj == null || !(obj instanceof WidgetWeatherData)) {
            return false;
        }
        if (this.f48898h == null) {
            return true;
        }
        return !r0.equals((WidgetWeatherData) obj);
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void l(Canvas canvas) {
        int i3;
        int i16;
        if (canvas != null && !this.C && !TextUtils.isEmpty(this.D)) {
            x(canvas);
            return;
        }
        if (canvas == null || this.f48898h == null || this.f48911u == null || this.f48912v == null || this.f48914x == null || this.f48915y == null) {
            return;
        }
        if (this.f48907q <= 0 || this.f48914x == null || this.f48907q >= this.f48914x.length || this.f48914x[this.f48907q] != null) {
            if (this.f48908r < 0 || this.f48914x == null || this.f48908r >= this.f48914x.length || this.f48914x[this.f48908r] != null) {
                if (this.f48909s && this.f48913w == null) {
                    return;
                }
                if (this.f48912v != null) {
                    canvas.drawBitmap(this.f48912v, 0, 0.0f, this.f48911u);
                }
                int i17 = 0 + this.f48899i;
                if (this.f48909s && this.f48913w != null) {
                    canvas.drawBitmap(this.f48913w, i17, 0.0f, this.f48911u);
                    i17 += this.f48903m;
                }
                if (this.f48907q > 0 && this.f48914x != null && this.f48907q < this.f48914x.length && this.f48914x[this.f48907q] != null) {
                    canvas.drawBitmap(this.f48914x[this.f48907q], i17, 0.0f, this.f48911u);
                    if (this.f48907q == 1) {
                        i16 = this.f48902l;
                    } else {
                        i16 = this.f48901k;
                    }
                    i17 += i16;
                }
                if (this.f48908r >= 0 && this.f48914x != null && this.f48908r < this.f48914x.length && this.f48914x[this.f48908r] != null) {
                    canvas.drawBitmap(this.f48914x[this.f48908r], i17, 0.0f, this.f48911u);
                    if (this.f48908r == 1) {
                        i3 = this.f48902l;
                    } else {
                        i3 = this.f48901k;
                    }
                    i17 += i3;
                }
                if (this.f48915y != null) {
                    canvas.drawBitmap(this.f48915y, i17, 0.0f, this.f48911u);
                    i17 += this.f48904n;
                }
                int i18 = i17 + this.f48905o;
                if (!TextUtils.isEmpty(this.f48898h.strCityName)) {
                    this.f48911u.setTextSize(PersonalityEnv.dpToPx(12.0f));
                    Paint.FontMetrics fontMetrics = this.f48911u.getFontMetrics();
                    canvas.drawText(this.f48898h.strCityName, i18, (int) (fontMetrics.descent - fontMetrics.ascent), this.f48911u);
                }
                if (TextUtils.isEmpty(this.f48910t)) {
                    return;
                }
                this.f48911u.setTextSize(PersonalityEnv.dpToPx(10.0f));
                canvas.drawText(this.f48910t, i18, this.f48900j - this.f48911u.getFontMetrics().descent, this.f48911u);
            }
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void w(Object obj) {
        if (obj == null || !(obj instanceof WidgetWeatherData)) {
            return;
        }
        this.C = true;
        this.D = "";
        if (B(obj)) {
            this.f48898h = (WidgetWeatherData) obj;
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetWeatherController.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneWidgetWeatherController.this.C();
                }
            });
        }
    }

    public static String z(int i3) {
        while (i3 >= 10) {
            i3 /= 10;
        }
        switch (i3) {
            case 0:
                return "qzone_cover_weather_0";
            case 1:
                return "qzone_cover_weather_1";
            case 2:
                return "qzone_cover_weather_2";
            case 3:
                return "qzone_cover_weather_3";
            case 4:
                return "qzone_cover_weather_4";
            case 5:
                return "qzone_cover_weather_5";
            case 6:
                return "qzone_cover_weather_6";
            case 7:
                return "qzone_cover_weather_7";
            case 8:
                return "qzone_cover_weather_8";
            case 9:
                return "qzone_cover_weather_9";
            default:
                return null;
        }
    }

    public static String A(int i3, int i16) {
        switch (i3) {
            case 0:
                if (i16 == 0) {
                    return "qzone_cover_weather_moon";
                }
                return "qzone_cover_weather_sun";
            case 1:
                if (i16 == 0) {
                    return "qzone_cover_weather_mostlycloudymoon";
                }
                return "qzone_cover_weather_mostlycloudysun";
            case 2:
                return "qzone_cover_weather_cloudyday";
            case 3:
                return "qzone_cover_weather_rain";
            case 4:
                return "qzone_cover_weather_snow";
            case 5:
                return "qzone_cover_weather_fog";
            case 6:
                return "qzone_cover_weather_sleet";
            case 7:
                return "qzone_cover_weather_thunderstorms";
            case 8:
                return "qzone_cover_weather_sand";
            case 9:
                return "qzone_cover_weather_wind";
            default:
                return null;
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void u() {
    }
}

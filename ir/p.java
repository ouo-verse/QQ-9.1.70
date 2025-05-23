package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class p extends i {
    private int A;
    private Rect B;
    private int C;
    private int D;
    private int E;
    private String F;
    private String G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private Rect P;
    private boolean Q;
    private int R;
    private boolean S;
    private String T;
    private Paint U;
    private int V;
    private int W;
    private float X;

    /* renamed from: i, reason: collision with root package name */
    private int f408399i;

    /* renamed from: j, reason: collision with root package name */
    private String f408400j;

    /* renamed from: k, reason: collision with root package name */
    private String f408401k;

    /* renamed from: l, reason: collision with root package name */
    private String f408402l;

    /* renamed from: m, reason: collision with root package name */
    private String f408403m;

    /* renamed from: n, reason: collision with root package name */
    private String f408404n;

    /* renamed from: o, reason: collision with root package name */
    private Paint f408405o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f408406p;

    /* renamed from: q, reason: collision with root package name */
    private String[] f408407q;

    /* renamed from: r, reason: collision with root package name */
    private a f408408r;

    /* renamed from: s, reason: collision with root package name */
    private GifDecoder f408409s;

    /* renamed from: t, reason: collision with root package name */
    private long f408410t;

    /* renamed from: u, reason: collision with root package name */
    private Bitmap f408411u;

    /* renamed from: v, reason: collision with root package name */
    private Rect f408412v;

    /* renamed from: w, reason: collision with root package name */
    private Bitmap f408413w;

    /* renamed from: x, reason: collision with root package name */
    private Rect f408414x;

    /* renamed from: y, reason: collision with root package name */
    private Bitmap f408415y;

    /* renamed from: z, reason: collision with root package name */
    private int f408416z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<p> f408417a;

        public a(WeakReference<p> weakReference) {
            this.f408417a = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f408417a.get() != null) {
                this.f408417a.get().p();
            }
        }
    }

    public p(Context context, String str) {
        super(context, str);
        this.f408407q = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        this.P = new Rect();
        k(str);
        n();
        b();
    }

    public static String m(int i3, int i16, String str, String str2, String str3, String str4, String str5, boolean z16) {
        String str6;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("temperature", i16);
            jSONObject.put("weather_icon_path", str);
            jSONObject.put("weather_desc", str2);
            jSONObject.put("weather_symbol_icon_path", str3);
            jSONObject.put("weather_font_path", str4);
            jSONObject.put("weather_line_path", str5);
            jSONObject.put("weather_line_path", str5);
            jSONObject.put(TabPreloadItem.TAB_NAME_DYNAMIC, z16);
            str6 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("WeatherStickerDrawable", 2, e16, new Object[0]);
            }
            str6 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WeatherStickerDrawable", 2, str6);
        }
        return str6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.Q) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f408410t == 0) {
            this.f408410t = currentTimeMillis;
        }
        long j3 = currentTimeMillis - this.f408410t;
        this.f408408r.sendEmptyMessageDelayed(0, 40L);
        GifDecoder gifDecoder = this.f408409s;
        Bitmap nextGifFrame = gifDecoder != null ? gifDecoder.getNextGifFrame(j3 * 1000 * 1000) : null;
        if (nextGifFrame != this.f408411u) {
            this.f408411u = nextGifFrame;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.i
    public void b() {
        super.b();
        if (this.f408409s == null || !this.S) {
            return;
        }
        this.f408408r.sendEmptyMessage(0);
    }

    @Override // ir.i
    public Bitmap f(long j3) {
        Bitmap d16 = d();
        Canvas canvas = new Canvas(d16);
        ArrayList<Integer> f16 = this.f408323a.f(j3);
        GifDecoder gifDecoder = this.f408409s;
        if (gifDecoder != null) {
            this.f408411u = gifDecoder.getNextGifFrame(j3 * 1000 * 1000);
        }
        j(canvas, f16);
        return d16;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.D;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.E;
    }

    @Override // ir.i
    public Bitmap h() {
        Bitmap d16 = d();
        Canvas canvas = new Canvas(d16);
        ir.a aVar = this.f408323a;
        ArrayList<Integer> f16 = aVar.f(aVar.c());
        if (this.f408400j != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_4444;
            this.f408411u = BitmapFactory.decodeFile(this.f408400j.replace(".apng", ".bpng"), options);
        }
        j(canvas, f16);
        return d16;
    }

    @Override // ir.i
    public String[] k(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.f408327e = jSONObject.optInt("type", 0);
            this.f408399i = jSONObject.optInt("temperature");
            this.f408400j = jSONObject.optString("weather_icon_path", "");
            this.f408401k = jSONObject.optString("weather_desc", "");
            this.f408402l = jSONObject.optString("weather_symbol_icon_path", "");
            this.f408403m = jSONObject.optString("weather_font_path", "");
            this.f408404n = jSONObject.optString("weather_line_path", "");
            this.S = jSONObject.optBoolean(TabPreloadItem.TAB_NAME_DYNAMIC, true);
        }
        return new String[]{this.f408400j, this.f408401k, this.f408402l, this.f408403m, this.f408404n};
    }

    public void o() {
        this.Q = true;
        a aVar = this.f408408r;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    protected void n() {
        Typeface typeface;
        int i3;
        this.f408408r = new a(new WeakReference(this));
        if (new File(this.f408403m).exists()) {
            try {
                typeface = Typeface.createFromFile(this.f408403m);
            } catch (Exception unused) {
                typeface = Typeface.DEFAULT;
            }
        } else {
            typeface = Typeface.DEFAULT;
        }
        int i16 = this.f408399i;
        if (i16 == -999) {
            this.T = "--";
        } else {
            this.T = String.format("%02d", Integer.valueOf(i16));
        }
        Paint paint = new Paint();
        this.f408405o = paint;
        paint.setAntiAlias(true);
        this.f408405o.setDither(true);
        this.f408405o.setColor(-1);
        this.f408405o.setTextSize(i.c(40.0f, this.f408325c.getResources()));
        this.f408405o.setFakeBoldText(true);
        this.f408405o.setTypeface(typeface);
        Paint.FontMetrics fontMetrics = this.f408405o.getFontMetrics();
        int i17 = (int) (fontMetrics.bottom - fontMetrics.top);
        int measureText = (int) this.f408405o.measureText(this.T);
        Paint paint2 = new Paint();
        this.f408406p = paint2;
        paint2.setAntiAlias(true);
        this.f408406p.setDither(true);
        this.f408406p.setColor(-1);
        this.f408406p.setTypeface(typeface);
        this.W = i.c(11.0f, this.f408325c.getResources());
        String str = this.f408401k;
        if (str != null && str.length() > 2) {
            this.V = i.c(9.5f, this.f408325c.getResources());
        }
        this.f408406p.setTextSize(this.W);
        this.f408406p.setFakeBoldText(true);
        Paint.FontMetrics fontMetrics2 = this.f408406p.getFontMetrics();
        this.U = new Paint(1);
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(2);
        String[] strArr = this.f408407q;
        if (i18 < strArr.length) {
            this.F = strArr[i18];
        } else {
            this.F = "";
        }
        this.G = String.format("%02d", Integer.valueOf(calendar.get(5)));
        if (new File(this.f408402l).exists()) {
            ApngDecodeWrapper apngDecodeWrapper = new ApngDecodeWrapper(this.f408400j);
            this.f408409s = apngDecodeWrapper;
            apngDecodeWrapper.init();
        }
        if (new File(this.f408402l).exists()) {
            this.f408413w = BitmapFactory.decodeFile(this.f408402l);
        }
        if (new File(this.f408404n).exists()) {
            this.f408415y = BitmapFactory.decodeFile(this.f408404n);
        }
        this.R = i.c(90.0f, this.f408325c.getResources());
        int i19 = this.R;
        this.f408412v = new Rect(0, 0, i19, i19);
        this.X = i.c(16.0f, this.f408325c.getResources()) - fontMetrics.top;
        int c16 = i.c(1.0f, this.f408325c.getResources());
        int c17 = i.c(1.0f, this.f408325c.getResources());
        int round = Math.round(c17 * 0.5f);
        int i26 = c17 * 2;
        int i27 = c17 * 4;
        int i28 = c17 * 5;
        int i29 = this.R;
        this.f408416z = i29 + c17;
        this.A = i29 + (c17 * 3);
        int c18 = i.c(55.5f, this.f408325c.getResources());
        int c19 = i.c(22.0f, this.f408325c.getResources());
        int i36 = this.f408416z + measureText + i27;
        int c26 = i.c(31.0f, this.f408325c.getResources());
        int c27 = i.c(23.5f, this.f408325c.getResources());
        int i37 = c19 + i36;
        int i38 = this.f408416z;
        if (c18 < i37 - i38) {
            c18 = i37 - i38;
        }
        int i39 = c26 + c27;
        this.f408414x = new Rect(i36, c27, i37, i39);
        int i46 = i39 + i27;
        int i47 = this.f408416z + c17;
        this.B = new Rect(i47, i46, i47 + c18, c16 + i46);
        this.C = (int) (((int) ((r3 + i17) + round)) - fontMetrics2.top);
        int measureText2 = (int) this.f408406p.measureText(this.F);
        int measureText3 = (int) this.f408406p.measureText(this.G);
        int i48 = this.V;
        if (i48 != 0) {
            this.f408406p.setTextSize(i48);
            i3 = i26;
        } else {
            i3 = i28;
        }
        int i49 = this.A + measureText2 + i3;
        this.H = i49;
        this.I = i49 + measureText3 + i3;
        this.E = (int) (this.R + (c18 * 1.2d));
        this.D = this.f408412v.bottom;
        int i56 = (int) ((-c18) * 0.3d);
        this.J = this.f408323a.a("offsetX", 0L, 650L, i56, 0, new n());
        this.K = this.f408323a.a("offsetX", 100L, 650L, i56, 0, new n());
        this.L = this.f408323a.a("offsetX", 200L, 650L, i56, 0, new n());
        this.M = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, 0L, 370L, 0, 255, new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
        this.N = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, 100L, 370L, 0, 255, new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
        this.O = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, 200L, 370L, 0, 255, new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = 255;
        if (arrayList != null) {
            i3 = e(arrayList, this.J, 0);
            i16 = e(arrayList, this.K, 0);
            i17 = e(arrayList, this.L, 0);
            int e16 = e(arrayList, this.M, 255);
            i19 = e(arrayList, this.N, 255);
            i18 = e(arrayList, this.O, 255);
            i26 = e16;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 255;
            i19 = 255;
        }
        Bitmap bitmap = this.f408411u;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f408412v, (Paint) null);
        }
        this.f408405o.setAlpha(i26);
        String str = this.T;
        if (str != null) {
            canvas.drawText(str, this.f408416z + i3, this.X, this.f408405o);
        }
        this.U.setAlpha(i26);
        if (this.f408413w != null) {
            this.P.set(this.f408414x);
            this.P.offset(i3, 0);
            canvas.drawBitmap(this.f408413w, (Rect) null, this.P, this.U);
        }
        this.U.setAlpha(i19);
        if (this.f408415y != null) {
            this.P.set(this.B);
            this.P.offset(i16, 0);
            canvas.drawBitmap(this.f408415y, (Rect) null, this.P, this.U);
        }
        this.f408406p.setAlpha(i18);
        this.f408406p.setTextSize(this.W);
        String str2 = this.F;
        if (str2 != null) {
            canvas.drawText(str2, this.A + i17, this.C, this.f408406p);
        }
        String str3 = this.G;
        if (str3 != null) {
            canvas.drawText(str3, this.H + i17, this.C, this.f408406p);
        }
        if (this.f408401k != null) {
            int i27 = this.V;
            if (i27 != 0) {
                this.f408406p.setTextSize(i27);
            }
            canvas.drawText(this.f408401k, this.I + i17, this.C, this.f408406p);
        }
    }
}

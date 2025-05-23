package com.qzone.widget.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.qzone.widget.particle.d;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.reflect.Array;

/* loaded from: classes37.dex */
public class ParticleManager implements Handler.Callback {

    /* renamed from: c0, reason: collision with root package name */
    private static final boolean f60916c0 = VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true);

    /* renamed from: d0, reason: collision with root package name */
    private static boolean f60917d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private static boolean f60918e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private static boolean f60919f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private static boolean f60920g0 = false;
    private Paint C;
    private Path D;
    private Paint E;
    private Paint F;
    private int[] G;
    private float[] H;
    private int I;
    private int J;
    private int K;
    private Bitmap L;
    private int P;
    private int Q;
    private double R;
    private Handler V;
    private a X;

    /* renamed from: d, reason: collision with root package name */
    private Context f60923d;

    /* renamed from: i, reason: collision with root package name */
    private int f60927i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f60928m;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.widget.particle.b[] f60924e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60925f = false;

    /* renamed from: h, reason: collision with root package name */
    private int f60926h = 0;
    private int M = -1;
    private int N = -1;
    private com.qzone.widget.particle.a S = null;
    private long T = 20;
    private float U = 6.0f;
    private Handler W = new Handler(Looper.getMainLooper());
    private boolean Y = false;
    private boolean Z = true;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f60921a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private b f60922b0 = null;

    /* loaded from: classes37.dex */
    public interface a {
        void setCallbackVisibility(int i3);

        void update();
    }

    /* loaded from: classes37.dex */
    public interface b {
        Bitmap getBitmap();

        int getLineHeight();

        int getParticleHeight();

        int getParticleTextVisibility();

        int getParticleWidth();

        void setParticleTextVisibility(int i3);
    }

    public ParticleManager(Context context) {
        Looper looper;
        this.f60923d = context;
        Paint paint = new Paint();
        this.f60928m = paint;
        paint.setColor(-1);
        this.f60928m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.D = new Path();
        Paint paint2 = new Paint();
        this.C = paint2;
        paint2.setColor(-1);
        this.C.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint3 = new Paint();
        this.E = paint3;
        paint3.setAntiAlias(false);
        this.E.setStyle(Paint.Style.FILL);
        this.E.setTextAlign(Paint.Align.CENTER);
        this.E.setTextSize(70.0f);
        Paint paint4 = new Paint();
        this.F = paint4;
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.G = new int[]{-1, -1, Color.parseColor("#11FFFFFF")};
        this.H = new float[]{0.0f, 0.7f, 1.0f};
        N(new d.a().a());
        if (f60916c0) {
            looper = ThreadManagerV2.getQQCommonThreadLooper();
        } else {
            looper = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ParticleThread).getLooper();
        }
        this.V = new Handler(looper, this);
    }

    private void B() {
        boolean z16 = this.f60925f;
        if (z16) {
            return;
        }
        this.f60925f = !z16;
        this.V.removeMessages(1);
    }

    private void E() {
        boolean z16 = this.f60925f;
        if (z16) {
            this.f60925f = !z16;
            if (this.f60926h != 0) {
                this.V.removeMessages(1);
                this.V.sendEmptyMessageDelayed(1, this.T);
            }
        }
    }

    public static void K(Context context, boolean z16) {
        PreferenceManager.getDefaultPreference(context, LoginData.getInstance().getUin()).edit().putBoolean("guide_feed_particle", z16).apply();
    }

    public static void L(Context context, boolean z16) {
        PreferenceManager.getDefaultPreference(context, LoginData.getInstance().getUin()).edit().putBoolean("guide_effect", z16).apply();
    }

    public static void M(Context context, boolean z16) {
        PreferenceManager.getDefaultPreference(context, LoginData.getInstance().getUin()).edit().putBoolean("guide_particle", z16).apply();
    }

    private void R() {
        a aVar = this.X;
        if (aVar != null) {
            aVar.update();
        }
    }

    private int[][] g(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap bitmap = bVar.getBitmap();
            this.L = bitmap;
            if (bitmap == null) {
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            int[] iArr = new int[this.L.getWidth() * this.L.getHeight()];
            Bitmap bitmap2 = this.L;
            bitmap2.getPixels(iArr, 0, bitmap2.getWidth(), 0, 0, this.L.getWidth(), this.L.getHeight());
            int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, this.L.getWidth(), this.L.getHeight());
            for (int i3 = 0; i3 < this.L.getWidth(); i3++) {
                for (int i16 = 0; i16 < this.L.getHeight(); i16++) {
                    iArr2[i3][i16] = iArr[(this.L.getWidth() * i16) + i3];
                }
            }
            j.c("ParticleManager", " bitmapTime " + currentTimeMillis2 + " getcolorArrayTime " + (System.currentTimeMillis() - currentTimeMillis));
            Log.d("Bitmap Transition", "Run");
            return iArr2;
        } catch (Error e16) {
            j.c("ParticleManager", "Error " + e16);
            return null;
        } catch (Exception e17) {
            j.c("ParticleManager", "exception " + e17);
            return null;
        }
    }

    public static boolean h(Context context) {
        return false;
    }

    public static boolean i(Context context) {
        return PreferenceManager.getDefaultPreference(context, LoginData.getInstance().getUin()).getBoolean("guide_feed_particle", true);
    }

    public static boolean j(Context context) {
        return false;
    }

    private void o() {
        if (this.f60922b0 != null) {
            this.W.postDelayed(new Runnable() { // from class: com.qzone.widget.particle.ParticleManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ParticleManager.this.f60922b0 != null) {
                        ParticleManager.this.Y = false;
                        ParticleManager.this.V.sendEmptyMessage(9);
                        if (ParticleManager.this.f60922b0.getParticleTextVisibility() != 0) {
                            ParticleManager.this.f60922b0.setParticleTextVisibility(0);
                        }
                        if (ParticleManager.this.X != null) {
                            ParticleManager.this.X.setCallbackVisibility(4);
                        }
                    }
                }
            }, this.T);
        }
    }

    private void s() {
        b bVar = this.f60922b0;
        if (bVar == null || bVar.getParticleTextVisibility() == 4) {
            return;
        }
        this.W.postDelayed(new Runnable() { // from class: com.qzone.widget.particle.ParticleManager.3
            @Override // java.lang.Runnable
            public void run() {
                ParticleManager.this.Y = true;
                if (ParticleManager.this.f60922b0 == null || ParticleManager.this.f60922b0.getParticleTextVisibility() == 4) {
                    return;
                }
                ParticleManager.this.f60922b0.setParticleTextVisibility(4);
                if (ParticleManager.this.X != null) {
                    ParticleManager.this.X.setCallbackVisibility(0);
                }
            }
        }, 20L);
    }

    public static boolean t() {
        if (QZoneHelper.isInParticleEffectBestPerformBlacklist()) {
            return false;
        }
        if (!f60919f0) {
            f60920g0 = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 2);
            f60919f0 = true;
        }
        return f60920g0;
    }

    public static boolean u() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PARTICLE_EFFECT, 1, false) > 0 && v();
    }

    public static boolean v() {
        if (QZoneHelper.isInParticleEffectBlacklist()) {
            return false;
        }
        if (!f60917d0) {
            f60918e0 = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
            f60917d0 = true;
        }
        return f60918e0;
    }

    public void C() {
        this.V.sendEmptyMessage(5);
    }

    public void F() {
        this.V.sendEmptyMessage(6);
    }

    public void H(final int i3, final int i16) {
        this.V.post(new Runnable() { // from class: com.qzone.widget.particle.ParticleManager.2
            @Override // java.lang.Runnable
            public void run() {
                ParticleManager.this.M = i3;
                ParticleManager.this.N = i16;
            }
        });
    }

    public void I() {
        if (this.X != null) {
            x();
            this.X.update();
        }
    }

    public void J(a aVar) {
        this.X = aVar;
    }

    public void P(b bVar) {
        this.V.removeMessages(10);
        this.V.removeMessages(2);
        this.f60925f = false;
        Message message = new Message();
        message.what = 2;
        message.obj = bVar;
        this.V.sendMessageDelayed(message, 100L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        return true;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.X != null) {
                    x();
                    this.X.update();
                }
                this.V.removeMessages(1);
                this.V.sendEmptyMessageDelayed(1, this.T);
                break;
            case 2:
                Object obj = message.obj;
                if (obj != null && (obj instanceof b)) {
                    G((b) obj);
                    break;
                }
                break;
            case 3:
                k();
                break;
            case 4:
                p();
                break;
            case 5:
                B();
                break;
            case 6:
                E();
                break;
            case 7:
                R();
                break;
            case 8:
                Q();
                break;
            case 9:
                y();
                break;
            case 10:
                D();
                break;
        }
    }

    public void l() {
        Handler handler = this.V;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.X = null;
    }

    public void m(Canvas canvas) {
        if (this.L != null) {
            if (this.f60927i > 0) {
                this.F.setShader(new RadialGradient(this.M, this.N, this.f60927i, this.G, this.H, Shader.TileMode.CLAMP));
            }
            canvas.drawBitmap(this.L, 0.0f, 0.0f, (Paint) null);
            int i3 = this.f60927i;
            if (i3 > 0) {
                canvas.drawCircle(this.M, this.N, i3, this.F);
            }
        }
        if (this.Y || r() == 3) {
            return;
        }
        s();
    }

    public void n(Canvas canvas) {
        this.D.reset();
        this.D.moveTo(0.0f, 0.0f);
        this.D.addCircle(this.M, this.N, this.f60927i, Path.Direction.CW);
        this.D.moveTo(this.I, this.J);
        this.D.setFillType(Path.FillType.INVERSE_WINDING);
        canvas.drawPath(this.D, this.C);
    }

    public void q() {
        this.V.sendEmptyMessage(4);
    }

    public int r() {
        return this.f60926h;
    }

    public void w(Canvas canvas) {
        com.qzone.widget.particle.b bVar;
        int i3 = this.f60926h;
        if (i3 == 0) {
            return;
        }
        int saveLayer = (i3 == 1 || i3 == 3) ? canvas.saveLayer(0.0f, 0.0f, this.I, this.J, null, 31) : -1;
        int i16 = 0;
        while (true) {
            com.qzone.widget.particle.b[] bVarArr = this.f60924e;
            if (i16 >= bVarArr.length || (bVar = bVarArr[i16]) == null) {
                break;
            }
            bVar.a(canvas, this.E);
            if (!this.f60925f) {
                this.S.c(this.f60924e[i16]);
            }
            i16 += 2;
        }
        int i17 = this.f60926h;
        if (i17 == 1 || i17 == 3) {
            canvas.drawCircle(this.M, this.N, this.f60927i, this.f60928m);
            canvas.restoreToCount(saveLayer);
        }
        if (this.f60926h != 2 || this.Y) {
            return;
        }
        s();
    }

    public void x() {
        if (this.f60925f) {
            return;
        }
        int i3 = this.f60926h;
        if (i3 == 1 || i3 == 3) {
            if (i3 == 1) {
                if (t() && !this.f60921a0 && this.L != null) {
                    this.f60927i -= this.I / 15;
                } else {
                    this.f60927i -= this.I;
                }
                if (this.f60927i <= 0) {
                    Q();
                    return;
                }
                return;
            }
            if (i3 != 3) {
                return;
            }
            if (t() && !this.f60921a0 && this.L != null) {
                this.f60927i += this.I / 15;
            } else {
                this.f60927i += this.I;
            }
            int i16 = this.f60927i;
            int i17 = this.M;
            if (i16 < i17 || i16 < this.I - i17) {
                return;
            }
            o();
        }
    }

    public void z() {
        this.V.sendEmptyMessage(7);
    }

    private void D() {
        this.f60926h = 0;
        this.Z = false;
        this.M = -1;
        this.N = -1;
        R();
        this.V.removeCallbacksAndMessages(null);
    }

    private void Q() {
        this.f60926h = 2;
        this.f60927i = 0;
        this.V.removeMessages(1);
        this.V.sendEmptyMessage(1);
    }

    private void p() {
        this.f60926h = 3;
    }

    private void y() {
        this.f60926h = 4;
        R();
        this.V.removeMessages(1);
        this.V.sendEmptyMessageDelayed(3, 3000L);
    }

    public void A() {
        this.Y = false;
        this.V.sendEmptyMessage(10);
    }

    public void G(b bVar) {
        this.f60926h = 0;
        O(bVar);
        if (this.M == -1) {
            this.M = this.f60927i;
        }
        if (this.N == -1) {
            this.N = this.J / 2;
        }
        this.V.removeCallbacksAndMessages(null);
        this.V.sendEmptyMessage(8);
    }

    public void k() {
        this.f60926h = 1;
        int i3 = this.K / 2;
        this.f60927i = i3;
        if (this.M == -1) {
            this.M = i3;
        }
        if (this.N == -1) {
            this.N = this.J / 2;
        }
        this.V.removeMessages(1);
        this.V.sendEmptyMessage(1);
    }

    private void O(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f60922b0 = bVar;
        int[][] g16 = g(bVar);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (g16 != null) {
            this.I = g16.length;
            int[] iArr = g16[0];
            this.J = iArr.length;
            this.f60924e = new com.qzone.widget.particle.b[((g16.length / this.Q) * iArr.length) / this.P];
            int lineHeight = this.f60922b0.getLineHeight();
            if (lineHeight <= 0) {
                lineHeight = ar.e(14.0f);
            }
            if (g16[0].length > ar.l()) {
                this.f60921a0 = true;
            } else {
                this.f60921a0 = false;
            }
            boolean z16 = false;
            int i3 = 0;
            for (int i16 = 0; i16 < g16[0].length; i16++) {
                int i17 = 0;
                while (true) {
                    if (i17 >= g16.length / 2) {
                        break;
                    }
                    if (Color.alpha(g16[i17][i16]) != 0) {
                        i3 = i16;
                        z16 = true;
                        break;
                    }
                    i17++;
                }
                if (z16) {
                    break;
                }
            }
            boolean z17 = false;
            for (int length = g16.length - 1; length > 0; length--) {
                for (int i18 = 0; i18 < g16[0].length / 2; i18++) {
                    if (Color.alpha(g16[length][i18]) != 0) {
                        this.K = length;
                        z17 = true;
                    }
                }
                if (z17) {
                    break;
                }
            }
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i19 < g16[i27].length; i27 = 0) {
                int i28 = (((i19 - i3) / lineHeight) * lineHeight) + i3;
                int i29 = i28 + lineHeight;
                int i36 = i27;
                while (i36 < g16.length) {
                    if (Color.alpha(g16[i36][i19]) != 0) {
                        com.qzone.widget.particle.b[] bVarArr = this.f60924e;
                        if (i26 < bVarArr.length) {
                            bVarArr[i26] = new c(g16[i36][i19]);
                            this.f60924e[i26].u(i28);
                            this.f60924e[i26].t(i29);
                            this.f60924e[i26].s(this.U);
                            this.S.a(this.f60924e[i26], i36, i19);
                            this.S.d(this.f60924e[i26]);
                            i26++;
                        }
                    }
                    i36 += this.Q;
                }
                i19 += this.P;
            }
        } else {
            this.I = this.f60922b0.getParticleWidth();
            int particleHeight = this.f60922b0.getParticleHeight();
            this.J = particleHeight;
            int i37 = this.I;
            this.f60924e = new com.qzone.widget.particle.b[((i37 / this.Q) * particleHeight) / this.P];
            this.K = i37;
            this.f60921a0 = true;
            int lineHeight2 = this.f60922b0.getLineHeight();
            if (lineHeight2 <= 0) {
                lineHeight2 = ar.e(14.0f);
            }
            int i38 = 0;
            int i39 = 0;
            while (i38 < this.J) {
                int i46 = (((i38 - 20) / lineHeight2) * lineHeight2) + 20;
                int i47 = i46 + lineHeight2;
                int i48 = 0;
                while (i48 < this.I) {
                    com.qzone.widget.particle.b[] bVarArr2 = this.f60924e;
                    if (i39 < bVarArr2.length) {
                        bVarArr2[i39] = new c(-16777216);
                        this.f60924e[i39].u(i46);
                        this.f60924e[i39].t(i47);
                        this.f60924e[i39].s(this.U);
                        this.S.a(this.f60924e[i39], i48, i38);
                        this.S.d(this.f60924e[i39]);
                        i39++;
                        i48 += this.Q;
                    }
                }
                i38 += this.P;
            }
        }
        j.c("test", "finish time " + (System.currentTimeMillis() - currentTimeMillis) + "  bitmap time " + (currentTimeMillis2 - currentTimeMillis));
    }

    public void N(d dVar) {
        if (dVar != null) {
            this.P = dVar.b();
            this.Q = dVar.f();
            this.R = dVar.e();
            this.S = dVar.d();
            this.T = dVar.c();
            this.S.b(this.R);
            this.U = dVar.a();
            return;
        }
        Log.e("CONFIGERROR", "ParticleTextView Config is Null");
    }
}

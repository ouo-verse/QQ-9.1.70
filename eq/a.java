package eq;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f396953f = false;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f396954g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f396955h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f396956i = false;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f396957j = false;

    /* renamed from: k, reason: collision with root package name */
    public static String f396958k = "aetest/test.png";

    /* renamed from: l, reason: collision with root package name */
    public static boolean f396959l = false;

    /* renamed from: m, reason: collision with root package name */
    private static String f396960m;

    /* renamed from: a, reason: collision with root package name */
    private int f396961a;

    /* renamed from: b, reason: collision with root package name */
    private int f396962b;

    /* renamed from: c, reason: collision with root package name */
    private int f396963c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f396964d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f396965e = false;

    public a() {
        f396953f = false;
    }

    public static String d() {
        String str = f396960m;
        if (str != null) {
            return str;
        }
        if (g("/sdcard/testVideoForQQ.mov")) {
            f396960m = "/sdcard/testVideoForQQ.mov";
        } else if (g("/sdcard/testVideoForQQ.mp4")) {
            f396960m = "/sdcard/testVideoForQQ.mp4";
        }
        return f396960m;
    }

    private static boolean g(String str) {
        return new File(str).exists();
    }

    public static boolean i() {
        if (f396954g && !f396955h) {
            if (d() == null) {
                f396954g = false;
            }
            f396955h = true;
        }
        return f396954g;
    }

    public static void l(boolean z16, String str) {
        f396954g = z16;
        if (z16) {
            if (str != null && g(str)) {
                f396960m = str;
            } else if (d() == null) {
                f396954g = false;
            }
        }
        f396955h = true;
    }

    public int b() {
        return this.f396962b;
    }

    public int c() {
        return this.f396963c;
    }

    public int e() {
        return this.f396961a;
    }

    public boolean h() {
        return this.f396964d;
    }

    @MustRunOnGLThread
    public void j() {
        boolean z16;
        Bitmap decodeSampleBitmap;
        InputStream inputStream;
        if (!this.f396965e || this.f396964d) {
            return;
        }
        if (f396956i) {
            z16 = !f396957j;
        } else {
            z16 = f396953f;
        }
        if (z16) {
            try {
                inputStream = AEModule.getContext().getAssets().open(f396958k);
            } catch (IOException e16) {
                e16.printStackTrace();
                inputStream = null;
            }
            decodeSampleBitmap = BitmapFactory.decodeStream(inputStream);
        } else {
            decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), f396958k, 1);
        }
        if (BitmapUtils.isLegal(decodeSampleBitmap)) {
            if (Math.abs((decodeSampleBitmap.getHeight() / decodeSampleBitmap.getWidth()) - 1.7777778f) > 1.0E-4d) {
                Bitmap createBitmap = Bitmap.createBitmap(decodeSampleBitmap.getWidth(), (int) ((decodeSampleBitmap.getWidth() * 16.0f) / 9.0f), Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(-1);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint(6);
                paint.setAntiAlias(true);
                canvas.drawBitmap(decodeSampleBitmap, 0.0f, (r2 - decodeSampleBitmap.getHeight()) / 2, paint);
                GlUtil.loadTexture(this.f396963c, createBitmap);
                decodeSampleBitmap.recycle();
                createBitmap.recycle();
                this.f396961a = createBitmap.getWidth();
                this.f396962b = createBitmap.getHeight();
            } else {
                GlUtil.loadTexture(this.f396963c, decodeSampleBitmap);
                decodeSampleBitmap.recycle();
                this.f396961a = decodeSampleBitmap.getWidth();
                this.f396962b = decodeSampleBitmap.getHeight();
            }
            this.f396964d = true;
        }
    }

    public void k(boolean z16) {
        this.f396964d = z16;
    }

    @MustRunOnGLThread
    public void a() {
        GLES20.glDeleteTextures(1, new int[]{this.f396963c}, 0);
        this.f396964d = false;
        this.f396965e = false;
        f396953f = false;
    }

    @MustRunOnGLThread
    public void f() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f396963c = iArr[0];
        this.f396965e = true;
    }
}

package com.tencent.aelight.camera.ae.flashshow.autotest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static String f64140f = "LSCameraDebug";

    /* renamed from: g, reason: collision with root package name */
    public static boolean f64141g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f64142h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f64143i = false;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f64144j = false;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f64145k = false;

    /* renamed from: l, reason: collision with root package name */
    public static String f64146l = "aetest/test.png";

    /* renamed from: m, reason: collision with root package name */
    public static boolean f64147m = false;

    /* renamed from: n, reason: collision with root package name */
    private static String f64148n = null;

    /* renamed from: o, reason: collision with root package name */
    private static ArrayList<LocalMediaInfo> f64149o = null;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f64150p = false;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f64151q = false;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f64152r = false;

    /* renamed from: a, reason: collision with root package name */
    private int f64153a;

    /* renamed from: b, reason: collision with root package name */
    private int f64154b;

    /* renamed from: c, reason: collision with root package name */
    private int f64155c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f64156d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f64157e = false;

    public b() {
        f64141g = false;
    }

    public static ArrayList<LocalMediaInfo> d() {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        ArrayList<LocalMediaInfo> arrayList = f64149o;
        if (arrayList != null) {
            return arrayList;
        }
        if (g("/sdcard/testVideoForQQ.mov")) {
            localMediaInfo.path = "/sdcard/testVideoForQQ.mov";
        } else if (g("/sdcard/testVideoForQQ.mp4")) {
            localMediaInfo.path = f64148n;
        }
        ArrayList<LocalMediaInfo> arrayList2 = new ArrayList<>();
        arrayList2.add(localMediaInfo);
        f64149o = arrayList2;
        return arrayList2;
    }

    private static boolean g(String str) {
        return new File(str).exists();
    }

    public static boolean h(ArrayList<LocalMediaInfo> arrayList) {
        Iterator<LocalMediaInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LocalMediaInfo next = it.next();
            if (!g(next.path)) {
                QLog.e(f64140f, 4, next.path + " is not exit.");
                return false;
            }
            QLog.d(f64140f, 4, next.path + " exit.");
        }
        return true;
    }

    public static boolean j() {
        if (f64142h && !f64143i) {
            ArrayList<LocalMediaInfo> d16 = d();
            if (d16 == null || d16.isEmpty()) {
                f64142h = false;
            }
            f64143i = true;
        }
        return f64142h;
    }

    public static void m(boolean z16, ArrayList<LocalMediaInfo> arrayList) {
        f64142h = z16;
        if (z16) {
            if (arrayList != null && h(arrayList)) {
                f64149o = arrayList;
            } else if (d() == null || d().isEmpty()) {
                f64142h = false;
            }
        }
        f64143i = true;
    }

    public int b() {
        return this.f64154b;
    }

    public int c() {
        return this.f64155c;
    }

    public int e() {
        return this.f64153a;
    }

    public boolean i() {
        return this.f64156d;
    }

    @MustRunOnGLThread
    public void k() {
        boolean z16;
        Bitmap decodeSampleBitmap;
        InputStream inputStream;
        if (!this.f64157e || this.f64156d) {
            return;
        }
        if (f64144j) {
            z16 = !f64145k;
        } else {
            z16 = f64141g;
        }
        if (f64150p ? false : z16) {
            try {
                inputStream = AEModule.getContext().getAssets().open(f64146l);
            } catch (IOException e16) {
                e16.printStackTrace();
                inputStream = null;
            }
            decodeSampleBitmap = BitmapFactory.decodeStream(inputStream);
        } else {
            decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), f64146l, 1);
        }
        if (BitmapUtils.isLegal(decodeSampleBitmap)) {
            if (Math.abs((decodeSampleBitmap.getHeight() / decodeSampleBitmap.getWidth()) - 1.7777778f) > 1.0E-4d) {
                Bitmap createBitmap = Bitmap.createBitmap(decodeSampleBitmap.getWidth(), (int) ((decodeSampleBitmap.getWidth() * 16.0f) / 9.0f), Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(-1);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint(6);
                paint.setAntiAlias(true);
                canvas.drawBitmap(decodeSampleBitmap, 0.0f, (r1 - decodeSampleBitmap.getHeight()) / 2, paint);
                GlUtil.loadTexture(this.f64155c, createBitmap);
                decodeSampleBitmap.recycle();
                createBitmap.recycle();
                this.f64153a = createBitmap.getWidth();
                this.f64154b = createBitmap.getHeight();
            } else {
                GlUtil.loadTexture(this.f64155c, decodeSampleBitmap);
                decodeSampleBitmap.recycle();
                this.f64153a = decodeSampleBitmap.getWidth();
                this.f64154b = decodeSampleBitmap.getHeight();
            }
            this.f64156d = true;
        }
    }

    public void l(boolean z16) {
        this.f64156d = z16;
    }

    @MustRunOnGLThread
    public void a() {
        GLES20.glDeleteTextures(1, new int[]{this.f64155c}, 0);
        this.f64156d = false;
        this.f64157e = false;
        f64141g = false;
    }

    @MustRunOnGLThread
    public void f() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f64155c = iArr[0];
        this.f64157e = true;
    }
}

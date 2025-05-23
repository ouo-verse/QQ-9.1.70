package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.mapsdk.internal.tk;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    private static final int f151297f = -16711681;

    /* renamed from: g, reason: collision with root package name */
    private static final int f151298g = 16711680;

    /* renamed from: h, reason: collision with root package name */
    private static final int f151299h = -256;

    /* renamed from: i, reason: collision with root package name */
    private static final int f151300i = 255;

    /* renamed from: a, reason: collision with root package name */
    public bf f151301a;

    /* renamed from: b, reason: collision with root package name */
    public oq f151302b;

    /* renamed from: c, reason: collision with root package name */
    public float f151303c;

    /* renamed from: d, reason: collision with root package name */
    public Lock f151304d = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name */
    public Lock f151305e = new ReentrantLock();

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f151306j;

    /* renamed from: k, reason: collision with root package name */
    private final om f151307k;

    /* renamed from: l, reason: collision with root package name */
    private hi f151308l;

    public w(Context context, bf bfVar, oq oqVar, om omVar) {
        this.f151303c = 1.0f;
        this.f151306j = new WeakReference<>(context);
        this.f151301a = bfVar;
        this.f151302b = oqVar;
        this.f151307k = omVar;
        this.f151303c = ht.a(context);
        if (bfVar.b() != null) {
            this.f151308l = ((tr) bfVar.b()).aC.f147918e;
        }
    }

    private static int a(int i3) {
        return (i3 & f151297f & (-256)) | ((i3 & 255) << 16) | ((16711680 & i3) >> 16);
    }

    private IconImageInfo b(String str) {
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.scale = this.f151303c;
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        iconImageInfo.bitmap = a(str, Bitmap.Config.RGB_565);
        return iconImageInfo;
    }

    private bf d() {
        return this.f151301a;
    }

    public final void c() {
        tk g16 = this.f151301a.g();
        g16.a(new tk.AnonymousClass120(""));
    }

    public final IconImageInfo a(String str) {
        hi hiVar;
        hi hiVar2;
        hi hiVar3;
        String[] split;
        Bitmap bitmap = null;
        if (this.f151307k == null) {
            return null;
        }
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        try {
            if (str.startsWith("drawRoundRect")) {
                iconImageInfo.scale = 1.0f;
                String substring = str.substring(14);
                if (!hs.a(substring) && (split = substring.split(", ")) != null && split.length >= 5) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    long parseLong = Long.parseLong(split[2]);
                    long parseLong2 = Long.parseLong(split[3]);
                    float parseFloat = Float.parseFloat(split[4]);
                    if (parseInt >= 0 && parseInt2 >= 0) {
                        Paint paint = new Paint();
                        paint.setAntiAlias(true);
                        paint.setStrokeWidth(parseFloat);
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setColor(a((int) parseLong2));
                        Bitmap createBitmap = Bitmap.createBitmap(parseInt, parseInt2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        canvas.drawColor(a((int) parseLong));
                        RectF rectF = new RectF();
                        rectF.left = 0.0f;
                        rectF.top = 0.0f;
                        rectF.right = parseInt;
                        rectF.bottom = parseInt2;
                        canvas.drawRoundRect(rectF, parseInt >> 3, parseInt2 >> 3, paint);
                        bitmap = createBitmap;
                    }
                }
                iconImageInfo.bitmap = bitmap;
                if (bitmap == null && (hiVar3 = this.f151308l) != null) {
                    hiVar3.a().a(System.currentTimeMillis(), str);
                }
                return iconImageInfo;
            }
            try {
                this.f151305e.lock();
                this.f151307k.a(str, iconImageInfo);
                this.f151305e.unlock();
                if (iconImageInfo.bitmap == null) {
                    str.equals(om.f149479a);
                }
                if (iconImageInfo.bitmap == null && (hiVar2 = this.f151308l) != null) {
                    hiVar2.a().a(System.currentTimeMillis(), str);
                }
                return iconImageInfo;
            } catch (Throwable th5) {
                this.f151305e.unlock();
                throw th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (iconImageInfo.bitmap == null && (hiVar = this.f151308l) != null) {
                hiVar.a().a(System.currentTimeMillis(), str);
            }
            return null;
        }
    }

    private static Bitmap c(String str) {
        String[] split;
        String substring = str.substring(14);
        if (!hs.a(substring) && (split = substring.split(", ")) != null && split.length >= 5) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            float parseFloat = Float.parseFloat(split[4]);
            if (parseInt >= 0 && parseInt2 >= 0) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStrokeWidth(parseFloat);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(a((int) parseLong2));
                Bitmap createBitmap = Bitmap.createBitmap(parseInt, parseInt2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(a((int) parseLong));
                RectF rectF = new RectF();
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = parseInt;
                rectF.bottom = parseInt2;
                canvas.drawRoundRect(rectF, parseInt >> 3, parseInt2 >> 3, paint);
                return createBitmap;
            }
        }
        return null;
    }

    public final void b() {
        this.f151304d.unlock();
    }

    private boolean b(String str, byte[] bArr) {
        oq oqVar = this.f151302b;
        if (oqVar == null) {
            return false;
        }
        return a(new File(oqVar.e()), str, bArr, this.f151305e);
    }

    public final void a() {
        this.f151304d.lock();
    }

    private boolean a(String str, byte[] bArr) {
        oq oqVar = this.f151302b;
        if (oqVar == null) {
            return false;
        }
        return a(new File(oqVar.c()), str, bArr, this.f151304d);
    }

    public final Bitmap a(String str, Bitmap.Config config) {
        WeakReference<Context> weakReference;
        if (new File(str).exists() && (weakReference = this.f151306j) != null && weakReference.get() != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = config;
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    public static boolean a(File file, String str, byte[] bArr, Lock lock) {
        if (!hs.a(str) && bArr != null && bArr.length != 0) {
            String str2 = str + "_" + Arrays.hashCode(bArr);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str2);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                kt.a(file2, bArr);
                try {
                    if (!Util.getMD5String(bArr).equals(li.a(file2))) {
                        return false;
                    }
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
                File file3 = new File(file, str);
                File file4 = new File(file, str + ".bak");
                if (file4.exists() && !file4.delete()) {
                    file4.deleteOnExit();
                    return false;
                }
                try {
                    lock.lock();
                    if (file3.exists() && !file3.renameTo(file4)) {
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        return false;
                    }
                    if (!file2.renameTo(file3)) {
                        file4.renameTo(file3);
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        return false;
                    }
                    if (!file4.delete()) {
                        file4.deleteOnExit();
                    }
                    lock.unlock();
                    return true;
                } finally {
                    lock.unlock();
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}

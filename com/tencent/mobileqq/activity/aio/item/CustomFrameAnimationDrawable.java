package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CustomFrameAnimationDrawable extends Drawable implements Runnable {
    private int C;
    private b D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    Resources J;
    Rect K;
    RectF L;
    private boolean M;
    Bitmap N;
    MqqHandler P;
    DecodeRunnable Q;
    private Vector<Bitmap> R;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Bitmap> f179330d;

    /* renamed from: e, reason: collision with root package name */
    public a f179331e;

    /* renamed from: f, reason: collision with root package name */
    private String f179332f;

    /* renamed from: h, reason: collision with root package name */
    private int f179333h;

    /* renamed from: i, reason: collision with root package name */
    private int f179334i;

    /* renamed from: m, reason: collision with root package name */
    private int f179335m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ CustomFrameAnimationDrawable this$0;

        @Override // java.lang.Runnable
        public void run() {
            ((IHapticManagerApi) QRoute.api(IHapticManagerApi.class)).addEffects();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class DecodeRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f179336d;

        /* renamed from: e, reason: collision with root package name */
        int f179337e;

        /* renamed from: f, reason: collision with root package name */
        String f179338f;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<Bitmap> f179339h;

        /* renamed from: i, reason: collision with root package name */
        Resources f179340i;

        /* renamed from: m, reason: collision with root package name */
        BitmapFactory.Options f179341m = new BitmapFactory.Options();

        public DecodeRunnable(int i3, String str, int i16, ArrayList<Bitmap> arrayList) {
            this.f179336d = i3;
            this.f179338f = str;
            this.f179337e = i16;
            this.f179339h = arrayList;
        }

        public void a(Resources resources) {
            this.f179340i = resources;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Bitmap decodeResourceStream;
            if (!CustomFrameAnimationDrawable.this.G) {
                BitmapFactory.Options options = this.f179341m;
                options.inSampleSize = 1;
                options.inMutable = true;
                if (CustomFrameAnimationDrawable.this.R.size() > 0) {
                    bitmap = (Bitmap) CustomFrameAnimationDrawable.this.R.remove(0);
                } else {
                    bitmap = null;
                }
                if (!CustomFrameAnimationDrawable.this.G && bitmap != null && !bitmap.isRecycled() && CustomFrameAnimationDrawable.k()) {
                    this.f179341m.inBitmap = bitmap;
                }
                int i3 = this.f179337e;
                if (i3 != 0) {
                    try {
                        decodeResourceStream = BaseImageUtil.decodeResourceStream(this.f179340i, i3);
                    } catch (OutOfMemoryError e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CustomFrameAnimationDrawable", 2, e16.toString());
                        }
                    }
                } else {
                    String str = this.f179338f;
                    if (str != null) {
                        try {
                            decodeResourceStream = BaseImageUtil.decodeFileWithBufferedStream(str, this.f179341m);
                        } catch (OutOfMemoryError e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("CustomFrameAnimationDrawable", 2, e17.toString());
                            }
                        }
                    }
                    decodeResourceStream = null;
                }
                if (decodeResourceStream != null) {
                    if (CustomFrameAnimationDrawable.this.G) {
                        ImageCacheHelper.f98636a.i(null, decodeResourceStream, Business.AIO);
                    }
                    this.f179339h.add(decodeResourceStream);
                }
                CustomFrameAnimationDrawable.this.Q = null;
                return;
            }
            CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this);
            int unused = CustomFrameAnimationDrawable.this.f179335m;
            int unused2 = CustomFrameAnimationDrawable.this.C;
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: c, reason: collision with root package name */
        int f179344c;

        /* renamed from: d, reason: collision with root package name */
        boolean f179345d;

        /* renamed from: h, reason: collision with root package name */
        boolean f179349h;

        /* renamed from: i, reason: collision with root package name */
        boolean f179350i;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<d> f179343b = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        int f179346e = 160;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<Bitmap> f179347f = new ArrayList<>();

        /* renamed from: g, reason: collision with root package name */
        boolean f179348g = false;

        /* renamed from: j, reason: collision with root package name */
        int f179351j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f179352k = 0;

        /* renamed from: a, reason: collision with root package name */
        final Paint f179342a = new Paint(6);

        public a() {
            this.f179344c = -1;
            this.f179345d = false;
            this.f179349h = true;
            this.f179350i = false;
            this.f179344c = 0;
            this.f179345d = false;
            this.f179349h = false;
            this.f179350i = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new CustomFrameAnimationDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new CustomFrameAnimationDrawable(this, resources);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void onUpdate(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f179353a;

        /* renamed from: b, reason: collision with root package name */
        public int f179354b;

        /* renamed from: c, reason: collision with root package name */
        public String f179355c;

        /* renamed from: d, reason: collision with root package name */
        public int f179356d;

        d() {
        }
    }

    public CustomFrameAnimationDrawable(Resources resources, Bitmap bitmap, MqqHandler mqqHandler) {
        this.f179334i = 160;
        this.D = null;
        this.E = false;
        this.F = true;
        this.H = true;
        this.J = null;
        this.K = new Rect();
        this.L = new RectF();
        this.Q = null;
        this.P = mqqHandler;
        this.N = bitmap;
        this.J = resources;
        this.f179330d = null;
        this.f179331e = new a();
        this.R = new Vector<>();
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            this.f179334i = i3 != 0 ? i3 : 160;
        } else {
            this.f179334i = this.f179331e.f179346e;
        }
        a aVar = this.f179331e;
        int i16 = this.f179334i;
        aVar.f179346e = i16;
        if (bitmap != null) {
            this.f179335m = bitmap.getScaledWidth(i16);
            this.C = bitmap.getScaledHeight(this.f179334i);
        } else {
            this.C = -1;
            this.f179335m = -1;
        }
    }

    static /* bridge */ /* synthetic */ c a(CustomFrameAnimationDrawable customFrameAnimationDrawable) {
        customFrameAnimationDrawable.getClass();
        return null;
    }

    private void h() {
        Bitmap bitmap;
        ArrayList<Bitmap> arrayList = this.f179330d;
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                bitmap = null;
            } else {
                bitmap = this.f179330d.get(0);
            }
            if (bitmap != null) {
                this.f179335m = bitmap.getScaledWidth(this.f179334i);
                this.C = bitmap.getScaledHeight(this.f179334i);
            } else {
                this.C = -1;
                this.f179335m = -1;
            }
        }
    }

    private void i(int i3, long j3) {
        long uptimeMillis;
        if (i3 < this.f179331e.f179343b.size()) {
            a aVar = this.f179331e;
            if (i3 - aVar.f179351j < 2) {
                d dVar = aVar.f179343b.get(i3);
                if (this.Q == null) {
                    DecodeRunnable decodeRunnable = new DecodeRunnable(i3, dVar.f179355c, dVar.f179356d, this.f179331e.f179347f);
                    this.Q = decodeRunnable;
                    decodeRunnable.a(this.J);
                    MqqHandler mqqHandler = this.P;
                    if (mqqHandler != null) {
                        mqqHandler.post(this.Q);
                    }
                    a aVar2 = this.f179331e;
                    int i16 = aVar2.f179351j + 1;
                    aVar2.f179351j = i16;
                    if (!aVar2.f179350i) {
                        aVar2.f179351j = i16 % aVar2.f179343b.size();
                    }
                }
            }
            a aVar3 = this.f179331e;
            d dVar2 = aVar3.f179343b.get(aVar3.f179344c);
            if (j3 == 0) {
                uptimeMillis = SystemClock.uptimeMillis() + dVar2.f179354b;
            } else {
                uptimeMillis = j3 + SystemClock.uptimeMillis();
            }
            scheduleSelf(this, uptimeMillis);
            if (this.f179332f != null && this.E) {
                ((IHapticManagerApi) QRoute.api(IHapticManagerApi.class)).update(this.f179333h, this.f179331e.f179344c * dVar2.f179354b);
                return;
            }
            return;
        }
        if (this.F) {
            g();
            this.f179331e.f179343b.clear();
        }
        a aVar4 = this.f179331e;
        aVar4.f179345d = false;
        aVar4.f179349h = true;
    }

    public static boolean k() {
        if (Build.VERSION.RELEASE.equals("5.0.2")) {
            if (DeviceInfoMonitor.getModel().equals("SM-A5009") || DeviceInfoMonitor.getModel().equals("SM-A7000") || DeviceInfoMonitor.getModel().equals("Redmi Note 2")) {
                return false;
            }
            return true;
        }
        return true;
    }

    private void l() {
        a aVar = this.f179331e;
        if (aVar.f179350i) {
            if (aVar.f179344c < aVar.f179343b.size()) {
                invalidateSelf();
                b bVar = this.D;
                if (bVar != null) {
                    bVar.onUpdate(this.f179331e.f179344c);
                }
                a aVar2 = this.f179331e;
                scheduleSelf(this, SystemClock.uptimeMillis() + aVar2.f179343b.get(aVar2.f179344c).f179354b);
                this.f179331e.f179344c++;
                return;
            }
            a aVar3 = this.f179331e;
            if (!aVar3.f179349h) {
                aVar3.f179345d = false;
                aVar3.f179349h = true;
                if (this.f179332f != null) {
                    if (this.E) {
                        ((IHapticManagerApi) QRoute.api(IHapticManagerApi.class)).stopEffect(this.f179333h);
                    }
                    this.f179333h = 0;
                    return;
                }
                return;
            }
            return;
        }
        aVar.f179344c %= aVar.f179343b.size();
        invalidateSelf();
        b bVar2 = this.D;
        if (bVar2 != null) {
            bVar2.onUpdate(this.f179331e.f179344c);
        }
        a aVar4 = this.f179331e;
        scheduleSelf(this, SystemClock.uptimeMillis() + aVar4.f179343b.get(aVar4.f179344c).f179354b);
        this.f179331e.f179344c++;
    }

    private void m() {
        Bitmap j3 = j();
        if (j3 != null) {
            Bitmap bitmap = this.N;
            if (!this.G && this.R.size() <= 2) {
                this.R.add(bitmap);
            }
            this.N = j3;
            a aVar = this.f179331e;
            int i3 = aVar.f179344c + 1;
            aVar.f179344c = i3;
            if (!aVar.f179350i) {
                aVar.f179344c = i3 % aVar.f179343b.size();
            }
            b bVar = this.D;
            if (bVar != null) {
                bVar.onUpdate(this.f179331e.f179344c);
            }
            invalidateSelf();
        }
        a aVar2 = this.f179331e;
        int i16 = aVar2.f179351j + 1;
        long j16 = 0;
        if (!aVar2.f179350i) {
            if (i16 >= aVar2.f179343b.size()) {
                j16 = this.I;
            }
            i16 %= this.f179331e.f179343b.size();
        }
        i(i16, j16);
    }

    private void p(Resources resources) {
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            this.f179334i = i3;
        } else {
            this.f179334i = this.f179331e.f179346e;
        }
        h();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        a aVar = this.f179331e;
        Paint paint = aVar.f179342a;
        ArrayList<Bitmap> arrayList = this.f179330d;
        Bitmap bitmap2 = null;
        if (arrayList == null && (bitmap = this.N) != null) {
            if (bitmap.isRecycled()) {
                if (QLog.isColorLevel()) {
                    QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
                }
                this.N = null;
                return;
            }
            Bitmap bitmap3 = this.N;
            if (this.f179331e.f179348g) {
                canvas.save();
                canvas.scale(-1.0f, 1.0f, this.f179335m / 2, this.C / 2);
            }
            this.K.set(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
            this.L.set(0.0f, 0.0f, this.f179335m, this.C);
            int width = canvas.getWidth();
            float height = (canvas.getHeight() * 1.0f) / this.C;
            int i3 = this.f179331e.f179352k;
            if (i3 == 1) {
                canvas.translate(((width / height) - this.f179335m) / 2.0f, 0.0f);
            } else if (i3 == 2) {
                canvas.translate(Math.abs((width / height) - this.f179335m) / 2.0f, 0.0f);
            }
            canvas.drawBitmap(bitmap3, this.K, this.L, paint);
            if (this.f179331e.f179348g) {
                canvas.restore();
                return;
            }
            return;
        }
        if (arrayList != null) {
            int i16 = aVar.f179344c;
            if (i16 >= 0) {
                if (i16 >= aVar.f179343b.size()) {
                    ArrayList<Bitmap> arrayList2 = this.f179330d;
                    ArrayList<d> arrayList3 = this.f179331e.f179343b;
                    bitmap2 = arrayList2.get(arrayList3.get(arrayList3.size() - 1).f179353a);
                } else {
                    a aVar2 = this.f179331e;
                    bitmap2 = this.f179330d.get(aVar2.f179343b.get(aVar2.f179344c).f179353a);
                }
            }
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                if (this.f179331e.f179348g) {
                    canvas.save();
                    canvas.scale(-1.0f, 1.0f, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
                }
                this.K.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                this.L.set(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight());
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
                if (this.f179331e.f179348g) {
                    canvas.restore();
                }
            }
        }
    }

    public void f(int i3, int i16, String str) {
        d dVar = new d();
        dVar.f179353a = i3;
        dVar.f179354b = i16;
        dVar.f179355c = str;
        dVar.f179356d = 0;
        this.f179331e.f179343b.add(dVar);
    }

    public void g() {
        Bitmap bitmap = this.N;
        if (bitmap != null) {
            bitmap.recycle();
            this.N = null;
        }
        ArrayList<Bitmap> arrayList = this.f179331e.f179347f;
        Iterator<Bitmap> it = arrayList.iterator();
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (next != null && !next.isRecycled()) {
                next.recycle();
            }
        }
        arrayList.clear();
        Vector<Bitmap> vector = this.R;
        if (vector != null) {
            Iterator<Bitmap> it5 = vector.iterator();
            while (it5.hasNext()) {
                Bitmap next2 = it5.next();
                if (next2 != null && !next2.isRecycled()) {
                    next2.recycle();
                }
            }
            this.R.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f179331e.f179342a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f179335m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public Bitmap j() {
        ArrayList<Bitmap> arrayList = this.f179331e.f179347f;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.f179331e.f179347f.remove(0);
    }

    public void n() {
        this.M = false;
        unscheduleSelf(this);
        this.f179331e.f179345d = true;
        scheduleSelf(this, 0L);
    }

    public void o() {
        unscheduleSelf(this);
        if (this.f179330d == null && this.N != null) {
            a aVar = this.f179331e;
            aVar.f179344c = 0;
            aVar.f179351j = 0;
            invalidateSelf();
            scheduleSelf(this, 0L);
        } else if (this.f179331e.f179343b.size() != 0) {
            if (this.f179331e.f179343b.size() != -1 && this.f179331e.f179343b.size() != 0) {
                this.f179331e.f179344c = 0;
            } else {
                this.f179331e.f179344c = -1;
            }
            scheduleSelf(this, 0L);
        }
        if (this.f179332f != null && this.E) {
            this.f179333h = ((IHapticManagerApi) QRoute.api(IHapticManagerApi.class)).playEffect(this.f179332f, 2);
        }
        a aVar2 = this.f179331e;
        aVar2.f179345d = true;
        aVar2.f179349h = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.M) {
            if (QLog.isColorLevel()) {
                QLog.i("CustomFrameAnimationDrawable", 2, "paused");
                return;
            }
            return;
        }
        if (this.f179330d == null && this.N != null) {
            a aVar = this.f179331e;
            int i3 = aVar.f179344c + 1;
            if (!aVar.f179350i) {
                i3 %= aVar.f179343b.size();
            }
            if (i3 < this.f179331e.f179343b.size()) {
                m();
                return;
            }
            if (this.F) {
                g();
                this.f179331e.f179343b.clear();
            }
            a aVar2 = this.f179331e;
            aVar2.f179345d = false;
            aVar2.f179349h = true;
            if (this.f179332f != null) {
                if (this.E) {
                    ((IHapticManagerApi) QRoute.api(IHapticManagerApi.class)).stopEffect(this.f179333h);
                }
                this.f179333h = 0;
                return;
            }
            return;
        }
        if (this.f179331e.f179343b.size() == 1) {
            invalidateSelf();
            b bVar = this.D;
            if (bVar != null) {
                bVar.onUpdate(this.f179331e.f179344c);
                return;
            }
            return;
        }
        l();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f179331e.f179342a.getAlpha()) {
            this.f179331e.f179342a.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f179331e.f179342a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    CustomFrameAnimationDrawable(a aVar, Resources resources) {
        this.f179334i = 160;
        this.D = null;
        this.E = false;
        this.F = true;
        this.H = true;
        this.J = null;
        this.K = new Rect();
        this.L = new RectF();
        this.N = null;
        this.Q = null;
        this.f179331e = aVar;
        p(resources);
    }
}

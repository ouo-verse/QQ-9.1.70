package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CustomFrameAnimationDrawable extends Drawable implements Runnable {
    static IPatchRedirector $redirector_;
    private int C;
    private c D;
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
    a S;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Bitmap> f191473d;

    /* renamed from: e, reason: collision with root package name */
    public b f191474e;

    /* renamed from: f, reason: collision with root package name */
    private String f191475f;

    /* renamed from: h, reason: collision with root package name */
    private int f191476h;

    /* renamed from: i, reason: collision with root package name */
    private int f191477i;

    /* renamed from: m, reason: collision with root package name */
    private int f191478m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class DecodeRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private boolean C;

        /* renamed from: d, reason: collision with root package name */
        int f191479d;

        /* renamed from: e, reason: collision with root package name */
        int f191480e;

        /* renamed from: f, reason: collision with root package name */
        String f191481f;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<Bitmap> f191482h;

        /* renamed from: i, reason: collision with root package name */
        Resources f191483i;

        /* renamed from: m, reason: collision with root package name */
        BitmapFactory.Options f191484m;

        public DecodeRunnable(int i3, String str, int i16, ArrayList<Bitmap> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CustomFrameAnimationDrawable.this, Integer.valueOf(i3), str, Integer.valueOf(i16), arrayList);
                return;
            }
            this.f191484m = new BitmapFactory.Options();
            this.C = false;
            this.f191479d = i3;
            this.f191481f = str;
            this.f191480e = i16;
            this.f191482h = arrayList;
        }

        public void a(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources);
            } else {
                this.f191483i = resources;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Bitmap decodeResourceStream;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (!CustomFrameAnimationDrawable.this.G) {
                BitmapFactory.Options options = this.f191484m;
                options.inSampleSize = 1;
                options.inMutable = true;
                if (CustomFrameAnimationDrawable.this.R.size() > 0) {
                    bitmap = (Bitmap) CustomFrameAnimationDrawable.this.R.remove(0);
                } else {
                    bitmap = null;
                }
                if (!CustomFrameAnimationDrawable.this.G && bitmap != null && !bitmap.isRecycled()) {
                    this.f191484m.inBitmap = bitmap;
                }
                int i3 = this.f191480e;
                if (i3 != 0) {
                    try {
                        decodeResourceStream = BaseImageUtil.decodeResourceStream(this.f191483i, i3);
                    } catch (OutOfMemoryError e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CustomFrameAnimationDrawable", 2, e16.toString());
                        }
                    }
                } else {
                    com.tencent.qqnt.aio.utils.m mVar = com.tencent.qqnt.aio.utils.m.f352305a;
                    if (mVar.f(this.f191481f)) {
                        try {
                            decodeResourceStream = BaseImageUtil.decodeFileWithBufferedStream(this.f191481f, this.f191484m);
                        } catch (OutOfMemoryError e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("CustomFrameAnimationDrawable", 2, e17.toString());
                            }
                        }
                    } else if (!this.C) {
                        this.C = true;
                        QLog.e("CustomFrameAnimation", 1, "mDrawableRes:" + this.f191480e + ", mFileName:" + this.f191481f + ", exists:" + mVar.f(this.f191481f));
                    }
                    decodeResourceStream = null;
                }
                if (decodeResourceStream != null) {
                    if (CustomFrameAnimationDrawable.this.G) {
                        ImageCacheHelper.f98636a.i(null, decodeResourceStream, Business.AIO);
                    }
                    this.f191482h.add(decodeResourceStream);
                }
                CustomFrameAnimationDrawable.this.Q = null;
                return;
            }
            CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this);
            int unused = CustomFrameAnimationDrawable.this.f191478m;
            int unused2 = CustomFrameAnimationDrawable.this.C;
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void onEnd();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class b extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final Paint f191485a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<e> f191486b;

        /* renamed from: c, reason: collision with root package name */
        int f191487c;

        /* renamed from: d, reason: collision with root package name */
        boolean f191488d;

        /* renamed from: e, reason: collision with root package name */
        int f191489e;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<Bitmap> f191490f;

        /* renamed from: g, reason: collision with root package name */
        boolean f191491g;

        /* renamed from: h, reason: collision with root package name */
        boolean f191492h;

        /* renamed from: i, reason: collision with root package name */
        boolean f191493i;

        /* renamed from: j, reason: collision with root package name */
        int f191494j;

        /* renamed from: k, reason: collision with root package name */
        int f191495k;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f191486b = new ArrayList<>();
            this.f191487c = -1;
            this.f191488d = false;
            this.f191489e = 160;
            this.f191490f = new ArrayList<>();
            this.f191491g = false;
            this.f191492h = true;
            this.f191493i = false;
            this.f191494j = 0;
            this.f191495k = 0;
            this.f191485a = new Paint(6);
            this.f191487c = 0;
            this.f191488d = false;
            this.f191492h = false;
            this.f191493i = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new CustomFrameAnimationDrawable(this, null) : (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? new CustomFrameAnimationDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 6, (Object) this, (Object) resources);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void onUpdate(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f191496a;

        /* renamed from: b, reason: collision with root package name */
        public int f191497b;

        /* renamed from: c, reason: collision with root package name */
        public String f191498c;

        /* renamed from: d, reason: collision with root package name */
        public int f191499d;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public CustomFrameAnimationDrawable(Resources resources, Bitmap bitmap, MqqHandler mqqHandler, b bVar, String str, boolean z16) {
        this(resources, bitmap, mqqHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resources, bitmap, mqqHandler, bVar, str, Boolean.valueOf(z16));
            return;
        }
        this.f191474e = bVar;
        this.f191475f = str;
        this.E = z16;
        if (str == null || !z16) {
            return;
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CustomFrameAnimationDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, null, true);
    }

    static /* bridge */ /* synthetic */ d a(CustomFrameAnimationDrawable customFrameAnimationDrawable) {
        customFrameAnimationDrawable.getClass();
        return null;
    }

    private void j() {
        Bitmap bitmap;
        ArrayList<Bitmap> arrayList = this.f191473d;
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                bitmap = null;
            } else {
                bitmap = this.f191473d.get(0);
            }
            if (bitmap != null) {
                this.f191478m = bitmap.getScaledWidth(this.f191477i);
                this.C = bitmap.getScaledHeight(this.f191477i);
            } else {
                this.C = -1;
                this.f191478m = -1;
            }
        }
    }

    private void k(int i3, long j3) {
        long uptimeMillis;
        if (i3 < this.f191474e.f191486b.size()) {
            b bVar = this.f191474e;
            if (i3 - bVar.f191494j < 2) {
                e eVar = bVar.f191486b.get(i3);
                if (this.Q == null) {
                    DecodeRunnable decodeRunnable = new DecodeRunnable(i3, eVar.f191498c, eVar.f191499d, this.f191474e.f191490f);
                    this.Q = decodeRunnable;
                    decodeRunnable.a(this.J);
                    MqqHandler mqqHandler = this.P;
                    if (mqqHandler != null) {
                        mqqHandler.post(this.Q);
                    }
                    b bVar2 = this.f191474e;
                    int i16 = bVar2.f191494j + 1;
                    bVar2.f191494j = i16;
                    if (!bVar2.f191493i) {
                        bVar2.f191494j = i16 % bVar2.f191486b.size();
                    }
                }
            }
            b bVar3 = this.f191474e;
            e eVar2 = bVar3.f191486b.get(bVar3.f191487c);
            if (j3 == 0) {
                uptimeMillis = SystemClock.uptimeMillis() + eVar2.f191497b;
            } else {
                uptimeMillis = j3 + SystemClock.uptimeMillis();
            }
            scheduleSelf(this, uptimeMillis);
            if (this.f191475f != null && this.E) {
                ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).update(this.f191476h, this.f191474e.f191487c * eVar2.f191497b);
                return;
            }
            return;
        }
        a aVar = this.S;
        if (aVar != null) {
            aVar.onEnd();
        }
        if (this.F) {
            h();
            this.f191474e.f191486b.clear();
        }
        b bVar4 = this.f191474e;
        bVar4.f191488d = false;
        bVar4.f191492h = true;
    }

    private void n() {
        b bVar = this.f191474e;
        if (bVar.f191493i) {
            if (bVar.f191487c < bVar.f191486b.size()) {
                invalidateSelf();
                c cVar = this.D;
                if (cVar != null) {
                    cVar.onUpdate(this.f191474e.f191487c);
                }
                b bVar2 = this.f191474e;
                scheduleSelf(this, SystemClock.uptimeMillis() + bVar2.f191486b.get(bVar2.f191487c).f191497b);
                this.f191474e.f191487c++;
                return;
            }
            if (!this.f191474e.f191492h) {
                a aVar = this.S;
                if (aVar != null) {
                    aVar.onEnd();
                }
                b bVar3 = this.f191474e;
                bVar3.f191488d = false;
                bVar3.f191492h = true;
                if (this.f191475f != null) {
                    if (this.E) {
                        ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).stopEffect(this.f191476h);
                    }
                    this.f191476h = 0;
                    return;
                }
                return;
            }
            return;
        }
        bVar.f191487c %= bVar.f191486b.size();
        invalidateSelf();
        c cVar2 = this.D;
        if (cVar2 != null) {
            cVar2.onUpdate(this.f191474e.f191487c);
        }
        b bVar4 = this.f191474e;
        scheduleSelf(this, SystemClock.uptimeMillis() + bVar4.f191486b.get(bVar4.f191487c).f191497b);
        this.f191474e.f191487c++;
    }

    private void o() {
        Bitmap l3 = l();
        if (l3 != null) {
            Bitmap bitmap = this.N;
            if (!this.G && this.R.size() <= 2) {
                this.R.add(bitmap);
            }
            this.N = l3;
            b bVar = this.f191474e;
            int i3 = bVar.f191487c + 1;
            bVar.f191487c = i3;
            if (!bVar.f191493i) {
                bVar.f191487c = i3 % bVar.f191486b.size();
            }
            c cVar = this.D;
            if (cVar != null) {
                cVar.onUpdate(this.f191474e.f191487c);
            }
            invalidateSelf();
        }
        b bVar2 = this.f191474e;
        int i16 = bVar2.f191494j + 1;
        long j3 = 0;
        if (!bVar2.f191493i) {
            if (i16 >= bVar2.f191486b.size()) {
                j3 = this.I;
            }
            i16 %= this.f191474e.f191486b.size();
        }
        k(i16, j3);
    }

    private void z(Resources resources) {
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            this.f191477i = i3;
        } else {
            this.f191477i = this.f191474e.f191489e;
        }
        j();
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f191474e.f191491g = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        b bVar = this.f191474e;
        Paint paint = bVar.f191485a;
        ArrayList<Bitmap> arrayList = this.f191473d;
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
            if (this.f191474e.f191491g) {
                canvas.save();
                canvas.scale(-1.0f, 1.0f, this.f191478m / 2, this.C / 2);
            }
            this.K.set(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
            this.L.set(0.0f, 0.0f, this.f191478m, this.C);
            int width = canvas.getWidth();
            float height = (canvas.getHeight() * 1.0f) / this.C;
            int i3 = this.f191474e.f191495k;
            if (i3 == 1) {
                canvas.translate(((width / height) - this.f191478m) / 2.0f, 0.0f);
            } else if (i3 == 2) {
                canvas.translate(Math.abs((width / height) - this.f191478m) / 2.0f, 0.0f);
            }
            canvas.drawBitmap(bitmap3, this.K, this.L, paint);
            if (this.f191474e.f191491g) {
                canvas.restore();
                return;
            }
            return;
        }
        if (arrayList != null) {
            int i16 = bVar.f191487c;
            if (i16 >= 0) {
                if (i16 >= bVar.f191486b.size()) {
                    ArrayList<Bitmap> arrayList2 = this.f191473d;
                    ArrayList<e> arrayList3 = this.f191474e.f191486b;
                    bitmap2 = arrayList2.get(arrayList3.get(arrayList3.size() - 1).f191496a);
                } else {
                    b bVar2 = this.f191474e;
                    bitmap2 = this.f191473d.get(bVar2.f191486b.get(bVar2.f191487c).f191496a);
                }
            }
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                if (this.f191474e.f191491g) {
                    canvas.save();
                    canvas.scale(-1.0f, 1.0f, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
                }
                this.K.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                this.L.set(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight());
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
                if (this.f191474e.f191491g) {
                    canvas.restore();
                }
            }
        }
    }

    public void f(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        e eVar = new e();
        eVar.f191496a = i3;
        eVar.f191497b = i16;
        eVar.f191499d = i17;
        eVar.f191498c = null;
        this.f191474e.f191486b.add(eVar);
    }

    public void g(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        e eVar = new e();
        eVar.f191496a = i3;
        eVar.f191497b = i16;
        eVar.f191498c = str;
        eVar.f191499d = 0;
        this.f191474e.f191486b.add(eVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f191474e.f191485a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f191478m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return -3;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        Bitmap bitmap = this.N;
        if (bitmap != null) {
            bitmap.recycle();
            this.N = null;
        }
        ArrayList<Bitmap> arrayList = this.f191474e.f191490f;
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

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        ArrayList<e> arrayList = this.f191474e.f191486b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public Bitmap l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Bitmap) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        ArrayList<Bitmap> arrayList = this.f191474e.f191490f;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.f191474e.f191490f.remove(0);
    }

    public e m(int i3) {
        ArrayList<e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (e) iPatchRedirector.redirect((short) 32, (Object) this, i3);
        }
        b bVar = this.f191474e;
        if (bVar == null || (arrayList = bVar.f191486b) == null || arrayList.size() <= 0 || i3 < 0 || i3 >= this.f191474e.f191486b.size()) {
            return null;
        }
        return this.f191474e.f191486b.get(i3);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.M = false;
        unscheduleSelf(this);
        this.f191474e.f191488d = true;
        scheduleSelf(this, 0L);
    }

    public void q(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bitmap);
        } else {
            this.N = bitmap;
        }
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        b bVar = this.f191474e;
        bVar.f191487c = i3;
        bVar.f191494j = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.M) {
            if (QLog.isColorLevel()) {
                QLog.i("CustomFrameAnimationDrawable", 2, "paused");
                return;
            }
            return;
        }
        if (this.f191473d == null && this.N != null) {
            b bVar = this.f191474e;
            int i3 = bVar.f191487c + 1;
            if (!bVar.f191493i) {
                i3 %= bVar.f191486b.size();
            }
            if (i3 < this.f191474e.f191486b.size()) {
                o();
                return;
            }
            a aVar = this.S;
            if (aVar != null) {
                aVar.onEnd();
            }
            if (this.F) {
                h();
                this.f191474e.f191486b.clear();
            }
            b bVar2 = this.f191474e;
            bVar2.f191488d = false;
            bVar2.f191492h = true;
            if (this.f191475f != null) {
                if (this.E) {
                    ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).stopEffect(this.f191476h);
                }
                this.f191476h = 0;
                return;
            }
            return;
        }
        if (this.f191474e.f191486b.size() == 1) {
            invalidateSelf();
            c cVar = this.D;
            if (cVar != null) {
                cVar.onUpdate(this.f191474e.f191487c);
                return;
            }
            return;
        }
        n();
    }

    public void s(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) cVar);
        } else {
            this.D = cVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (i3 != this.f191474e.f191485a.getAlpha()) {
            this.f191474e.f191485a.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.setBounds(i3, i16, i17, i18);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colorFilter);
        } else {
            this.f191474e.f191485a.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.f191474e.f191495k = i3;
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f191474e.f191491g = z16;
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.F = false;
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.f191474e.f191493i = true;
        }
    }

    public void x(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) aVar);
        } else {
            this.S = aVar;
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        unscheduleSelf(this);
        if (this.f191473d == null && this.N != null) {
            b bVar = this.f191474e;
            bVar.f191487c = 0;
            bVar.f191494j = 0;
            invalidateSelf();
            scheduleSelf(this, 0L);
        } else if (this.f191474e.f191486b.size() != 0) {
            if (this.f191474e.f191486b.size() != -1 && this.f191474e.f191486b.size() != 0) {
                this.f191474e.f191487c = 0;
            } else {
                this.f191474e.f191487c = -1;
            }
            scheduleSelf(this, 0L);
        }
        if (this.f191475f != null && this.E) {
            this.f191476h = ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).playEffect(this.f191475f, 2);
        }
        b bVar2 = this.f191474e;
        bVar2.f191488d = true;
        bVar2.f191492h = false;
    }

    public CustomFrameAnimationDrawable(Resources resources, Bitmap bitmap, MqqHandler mqqHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, resources, bitmap, mqqHandler);
            return;
        }
        this.f191477i = 160;
        this.D = null;
        this.E = false;
        this.F = true;
        this.H = true;
        this.J = null;
        this.K = new Rect();
        this.L = new RectF();
        this.Q = null;
        this.S = null;
        this.P = mqqHandler;
        this.N = bitmap;
        this.J = resources;
        this.f191473d = null;
        this.f191474e = new b();
        this.R = new Vector<>();
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            this.f191477i = i3 != 0 ? i3 : 160;
        } else {
            this.f191477i = this.f191474e.f191489e;
        }
        b bVar = this.f191474e;
        int i16 = this.f191477i;
        bVar.f191489e = i16;
        if (bitmap != null) {
            this.f191478m = bitmap.getScaledWidth(i16);
            this.C = bitmap.getScaledHeight(this.f191477i);
        } else {
            this.C = -1;
            this.f191478m = -1;
        }
    }

    CustomFrameAnimationDrawable(b bVar, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) resources);
            return;
        }
        this.f191477i = 160;
        this.D = null;
        this.E = false;
        this.F = true;
        this.H = true;
        this.J = null;
        this.K = new Rect();
        this.L = new RectF();
        this.N = null;
        this.Q = null;
        this.S = null;
        this.f191474e = bVar;
        z(resources);
    }
}

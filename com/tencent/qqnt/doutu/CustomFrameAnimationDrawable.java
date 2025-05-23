package com.tencent.qqnt.doutu;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes24.dex */
public class CustomFrameAnimationDrawable extends Drawable implements Runnable {
    static IPatchRedirector $redirector_;
    private static Boolean Q;
    private boolean C;
    private boolean D;
    private int E;
    Resources F;
    Rect G;
    RectF H;
    private boolean I;
    Bitmap J;
    MqqHandler K;
    DecodeRunnable L;
    private Vector<Bitmap> M;
    private final Object N;
    a P;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    ArrayList<Bitmap> f355957d;

    /* renamed from: e, reason: collision with root package name */
    public b f355958e;

    /* renamed from: f, reason: collision with root package name */
    private int f355959f;

    /* renamed from: h, reason: collision with root package name */
    private int f355960h;

    /* renamed from: i, reason: collision with root package name */
    private int f355961i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f355962m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class DecodeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f355963d;

        /* renamed from: e, reason: collision with root package name */
        int f355964e;

        /* renamed from: f, reason: collision with root package name */
        String f355965f;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<Bitmap> f355966h;

        /* renamed from: i, reason: collision with root package name */
        Resources f355967i;

        public DecodeRunnable(int i3, String str, int i16, ArrayList<Bitmap> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CustomFrameAnimationDrawable.this, Integer.valueOf(i3), str, Integer.valueOf(i16), arrayList);
                return;
            }
            this.f355963d = i3;
            this.f355965f = str;
            this.f355964e = i16;
            this.f355966h = arrayList;
        }

        public void a(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources);
            } else {
                this.f355967i = resources;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap decodeResourceStream;
            Bitmap bitmap;
            Bitmap decodeFileWithBufferedStream;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (!CustomFrameAnimationDrawable.this.C) {
                int i3 = this.f355964e;
                if (i3 != 0) {
                    try {
                        decodeResourceStream = BaseImageUtil.decodeResourceStream(this.f355967i, i3);
                    } catch (OutOfMemoryError e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CustomFrameAnimationDrawable", 2, e16.toString());
                        }
                    }
                } else {
                    if (FileUtils.fileExistsAndNotEmpty(this.f355965f)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 1;
                        options.inMutable = true;
                        synchronized (CustomFrameAnimationDrawable.this.N) {
                            if (CustomFrameAnimationDrawable.this.M.size() > 0) {
                                bitmap = (Bitmap) CustomFrameAnimationDrawable.this.M.remove(0);
                            } else {
                                bitmap = null;
                            }
                            if (!CustomFrameAnimationDrawable.this.C && bitmap != null && !bitmap.isRecycled()) {
                                options.inBitmap = bitmap;
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("CustomFrameAnimationDrawable", 2, "decode frame bitmap. filePath=", this.f355965f, ", fileSize=", Long.valueOf(new File(this.f355965f).length()));
                                }
                                if (CustomFrameAnimationDrawable.this.n()) {
                                    j.a aVar = new j.a();
                                    j.e(this.f355965f, options, aVar);
                                    int i16 = aVar.f306779b;
                                    if (i16 != 0 || (decodeFileWithBufferedStream = aVar.f306778a) == null) {
                                        QLog.e("CustomFrameAnimationDrawable", 1, "decode favorite panel thumb failed. result=", Integer.valueOf(i16));
                                        decodeFileWithBufferedStream = null;
                                    }
                                } else {
                                    decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(this.f355965f, options);
                                }
                                decodeResourceStream = decodeFileWithBufferedStream;
                            } catch (Throwable th5) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("CustomFrameAnimationDrawable", 2, th5.toString());
                                }
                                decodeResourceStream = null;
                            }
                        }
                    }
                    decodeResourceStream = null;
                }
                if (decodeResourceStream != null) {
                    if (CustomFrameAnimationDrawable.this.C) {
                        ImageCacheHelper.f98636a.i(null, decodeResourceStream, Business.AIO);
                    }
                    this.f355966h.add(decodeResourceStream);
                }
                CustomFrameAnimationDrawable.this.L = null;
                return;
            }
            CustomFrameAnimationDrawable.b(CustomFrameAnimationDrawable.this);
            int unused = CustomFrameAnimationDrawable.this.f355960h;
            int unused2 = CustomFrameAnimationDrawable.this.f355961i;
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a {
        void onEnd();
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class b extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final Paint f355968a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<d> f355969b;

        /* renamed from: c, reason: collision with root package name */
        int f355970c;

        /* renamed from: d, reason: collision with root package name */
        boolean f355971d;

        /* renamed from: e, reason: collision with root package name */
        int f355972e;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<Bitmap> f355973f;

        /* renamed from: g, reason: collision with root package name */
        boolean f355974g;

        /* renamed from: h, reason: collision with root package name */
        boolean f355975h;

        /* renamed from: i, reason: collision with root package name */
        boolean f355976i;

        /* renamed from: j, reason: collision with root package name */
        int f355977j;

        /* renamed from: k, reason: collision with root package name */
        int f355978k;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f355969b = new ArrayList<>();
            this.f355970c = -1;
            this.f355971d = false;
            this.f355972e = 160;
            this.f355973f = new ArrayList<>();
            this.f355974g = false;
            this.f355975h = true;
            this.f355976i = false;
            this.f355977j = 0;
            this.f355978k = 0;
            this.f355968a = new Paint(6);
            this.f355970c = 0;
            this.f355971d = false;
            this.f355975h = false;
            this.f355976i = false;
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
    /* loaded from: classes24.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f355979a;

        /* renamed from: b, reason: collision with root package name */
        public int f355980b;

        /* renamed from: c, reason: collision with root package name */
        public String f355981c;

        /* renamed from: d, reason: collision with root package name */
        public int f355982d;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public CustomFrameAnimationDrawable(Resources resources, Bitmap bitmap, MqqHandler mqqHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resources, bitmap, mqqHandler);
            return;
        }
        this.f355959f = 160;
        this.f355962m = true;
        this.D = true;
        this.F = null;
        this.G = new Rect();
        this.H = new RectF();
        this.L = null;
        this.N = new Object();
        this.P = null;
        this.K = mqqHandler;
        this.J = bitmap;
        this.F = resources;
        this.f355957d = null;
        this.f355958e = new b();
        this.M = new Vector<>();
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            this.f355959f = i3 != 0 ? i3 : 160;
        } else {
            this.f355959f = this.f355958e.f355972e;
        }
        b bVar = this.f355958e;
        int i16 = this.f355959f;
        bVar.f355972e = i16;
        if (bitmap != null) {
            this.f355960h = bitmap.getScaledWidth(i16);
            this.f355961i = bitmap.getScaledHeight(this.f355959f);
        } else {
            this.f355961i = -1;
            this.f355960h = -1;
        }
    }

    static /* bridge */ /* synthetic */ c b(CustomFrameAnimationDrawable customFrameAnimationDrawable) {
        customFrameAnimationDrawable.getClass();
        return null;
    }

    private void k() {
        Bitmap bitmap;
        ArrayList<Bitmap> arrayList = this.f355957d;
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                bitmap = null;
            } else {
                bitmap = this.f355957d.get(0);
            }
            if (bitmap != null) {
                this.f355960h = bitmap.getScaledWidth(this.f355959f);
                this.f355961i = bitmap.getScaledHeight(this.f355959f);
            } else {
                this.f355961i = -1;
                this.f355960h = -1;
            }
        }
    }

    private void l(int i3, long j3) {
        long uptimeMillis;
        if (i3 < this.f355958e.f355969b.size()) {
            b bVar = this.f355958e;
            if (i3 - bVar.f355977j < 2) {
                d dVar = bVar.f355969b.get(i3);
                if (this.L == null) {
                    DecodeRunnable decodeRunnable = new DecodeRunnable(i3, dVar.f355981c, dVar.f355982d, this.f355958e.f355973f);
                    this.L = decodeRunnable;
                    decodeRunnable.a(this.F);
                    MqqHandler mqqHandler = this.K;
                    if (mqqHandler != null) {
                        mqqHandler.post(this.L);
                    }
                    b bVar2 = this.f355958e;
                    int i16 = bVar2.f355977j + 1;
                    bVar2.f355977j = i16;
                    if (!bVar2.f355976i) {
                        bVar2.f355977j = i16 % bVar2.f355969b.size();
                    }
                }
            }
            b bVar3 = this.f355958e;
            d dVar2 = bVar3.f355969b.get(bVar3.f355970c);
            if (j3 == 0) {
                uptimeMillis = SystemClock.uptimeMillis() + dVar2.f355980b;
            } else {
                uptimeMillis = j3 + SystemClock.uptimeMillis();
            }
            scheduleSelf(this, uptimeMillis);
            return;
        }
        a aVar = this.P;
        if (aVar != null) {
            aVar.onEnd();
        }
        if (this.f355962m) {
            j();
            this.f355958e.f355969b.clear();
        }
        b bVar4 = this.f355958e;
        bVar4.f355971d = false;
        bVar4.f355975h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        if (Q == null) {
            Q = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("doutu_decode_replace_deprecated_api_8996_117197093", true));
        }
        return Q.booleanValue();
    }

    private void q() {
        b bVar = this.f355958e;
        if (bVar.f355976i) {
            if (bVar.f355970c < bVar.f355969b.size()) {
                invalidateSelf();
                b bVar2 = this.f355958e;
                scheduleSelf(this, SystemClock.uptimeMillis() + bVar2.f355969b.get(bVar2.f355970c).f355980b);
                this.f355958e.f355970c++;
                return;
            }
            if (!this.f355958e.f355975h) {
                a aVar = this.P;
                if (aVar != null) {
                    aVar.onEnd();
                }
                b bVar3 = this.f355958e;
                bVar3.f355971d = false;
                bVar3.f355975h = true;
                return;
            }
            return;
        }
        bVar.f355970c %= bVar.f355969b.size();
        invalidateSelf();
        b bVar4 = this.f355958e;
        scheduleSelf(this, SystemClock.uptimeMillis() + bVar4.f355969b.get(bVar4.f355970c).f355980b);
        this.f355958e.f355970c++;
    }

    private void r() {
        Bitmap m3 = m();
        if (m3 != null) {
            Bitmap bitmap = this.J;
            if (!this.C && this.M.size() <= 2) {
                this.M.add(bitmap);
            }
            this.J = m3;
            b bVar = this.f355958e;
            int i3 = bVar.f355970c + 1;
            bVar.f355970c = i3;
            if (!bVar.f355976i) {
                bVar.f355970c = i3 % bVar.f355969b.size();
            }
            invalidateSelf();
        }
        b bVar2 = this.f355958e;
        int i16 = bVar2.f355977j + 1;
        long j3 = 0;
        if (!bVar2.f355976i) {
            if (i16 >= bVar2.f355969b.size()) {
                j3 = this.E;
            }
            i16 %= this.f355958e.f355969b.size();
        }
        l(i16, j3);
    }

    private void s(final Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (Looper.myLooper() != this.K.getLooper()) {
                if (QLog.isColorLevel()) {
                    QLog.d("CustomFrameAnimationDrawable", 2, "recycle bitmap in decode thread.");
                }
                this.K.post(new Runnable() { // from class: com.tencent.qqnt.doutu.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        bitmap.recycle();
                    }
                });
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("CustomFrameAnimationDrawable", 2, "recycle bitmap.");
                }
                bitmap.recycle();
            }
        }
    }

    private void y(Resources resources) {
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            this.f355959f = i3;
        } else {
            this.f355959f = this.f355958e.f355972e;
        }
        k();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        b bVar = this.f355958e;
        Paint paint = bVar.f355968a;
        ArrayList<Bitmap> arrayList = this.f355957d;
        Bitmap bitmap2 = null;
        if (arrayList == null && (bitmap = this.J) != null) {
            if (bitmap.isRecycled()) {
                if (QLog.isColorLevel()) {
                    QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
                }
                this.J = null;
                return;
            }
            Bitmap bitmap3 = this.J;
            if (this.f355958e.f355974g) {
                canvas.save();
                canvas.scale(-1.0f, 1.0f, this.f355960h / 2, this.f355961i / 2);
            }
            this.G.set(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
            this.H.set(0.0f, 0.0f, this.f355960h, this.f355961i);
            int width = canvas.getWidth();
            float height = (canvas.getHeight() * 1.0f) / this.f355961i;
            int i3 = this.f355958e.f355978k;
            if (i3 == 1) {
                canvas.translate(((width / height) - this.f355960h) / 2.0f, 0.0f);
            } else if (i3 == 2) {
                canvas.translate(Math.abs((width / height) - this.f355960h) / 2.0f, 0.0f);
            }
            canvas.drawBitmap(bitmap3, this.G, this.H, paint);
            if (this.f355958e.f355974g) {
                canvas.restore();
                return;
            }
            return;
        }
        if (arrayList != null) {
            int i16 = bVar.f355970c;
            if (i16 >= 0) {
                if (i16 >= bVar.f355969b.size()) {
                    ArrayList<Bitmap> arrayList2 = this.f355957d;
                    ArrayList<d> arrayList3 = this.f355958e.f355969b;
                    bitmap2 = arrayList2.get(arrayList3.get(arrayList3.size() - 1).f355979a);
                } else {
                    b bVar2 = this.f355958e;
                    bitmap2 = this.f355957d.get(bVar2.f355969b.get(bVar2.f355970c).f355979a);
                }
            }
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                if (this.f355958e.f355974g) {
                    canvas.save();
                    canvas.scale(-1.0f, 1.0f, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
                }
                this.G.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                this.H.set(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight());
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
                if (this.f355958e.f355974g) {
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f355958e.f355968a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f355961i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f355960h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return -3;
    }

    public void i(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        d dVar = new d();
        dVar.f355979a = i3;
        dVar.f355980b = i16;
        dVar.f355981c = str;
        dVar.f355982d = 0;
        this.f355958e.f355969b.add(dVar);
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        QLog.d("CustomFrameAnimationDrawable", 1, "clear.");
        Bitmap bitmap = this.J;
        if (bitmap != null) {
            s(bitmap);
            this.J = null;
        }
        ArrayList<Bitmap> arrayList = this.f355958e.f355973f;
        Iterator<Bitmap> it = arrayList.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList.clear();
        synchronized (this.N) {
            Vector<Bitmap> vector = this.M;
            if (vector != null) {
                Iterator<Bitmap> it5 = vector.iterator();
                while (it5.hasNext()) {
                    s(it5.next());
                }
                this.M.clear();
            }
        }
    }

    public Bitmap m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Bitmap) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        ArrayList<Bitmap> arrayList = this.f355958e.f355973f;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.f355958e.f355973f.remove(0);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.f355958e.f355971d) {
            unscheduleSelf(this);
        }
        if (this.f355957d == null && this.J != null && this.D) {
            for (int i3 = 0; i3 < this.f355958e.f355973f.size(); i3++) {
                s(this.f355958e.f355973f.remove(0));
            }
            this.f355958e.f355973f.clear();
            b bVar = this.f355958e;
            bVar.f355977j = bVar.f355970c;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.I) {
            if (QLog.isColorLevel()) {
                QLog.i("CustomFrameAnimationDrawable", 2, "paused");
                return;
            }
            return;
        }
        if (this.f355957d == null && this.J != null) {
            b bVar = this.f355958e;
            int i3 = bVar.f355970c + 1;
            if (!bVar.f355976i) {
                i3 %= bVar.f355969b.size();
            }
            if (i3 < this.f355958e.f355969b.size()) {
                r();
                return;
            }
            a aVar = this.P;
            if (aVar != null) {
                aVar.onEnd();
            }
            if (this.f355962m) {
                j();
                this.f355958e.f355969b.clear();
            }
            b bVar2 = this.f355958e;
            bVar2.f355971d = false;
            bVar2.f355975h = true;
            return;
        }
        if (this.f355958e.f355969b.size() == 1) {
            invalidateSelf();
        } else {
            q();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else if (i3 != this.f355958e.f355968a.getAlpha()) {
            this.f355958e.f355968a.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.setBounds(i3, i16, i17, i18);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) colorFilter);
        } else {
            this.f355958e.f355968a.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (this.f355958e.f355971d) {
            unscheduleSelf(this);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.I = false;
        unscheduleSelf(this);
        this.f355958e.f355971d = true;
        scheduleSelf(this, 0L);
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f355962m = false;
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.f355958e.f355976i = true;
        }
    }

    public void w(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) aVar);
        } else {
            this.P = aVar;
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        unscheduleSelf(this);
        if (this.f355957d == null && this.J != null) {
            b bVar = this.f355958e;
            bVar.f355970c = 0;
            bVar.f355977j = 0;
            invalidateSelf();
            scheduleSelf(this, 0L);
        } else if (this.f355958e.f355969b.size() != 0) {
            if (this.f355958e.f355969b.size() != -1 && this.f355958e.f355969b.size() != 0) {
                this.f355958e.f355970c = 0;
            } else {
                this.f355958e.f355970c = -1;
            }
            scheduleSelf(this, 0L);
        }
        b bVar2 = this.f355958e;
        bVar2.f355971d = true;
        bVar2.f355975h = false;
    }

    CustomFrameAnimationDrawable(b bVar, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) resources);
            return;
        }
        this.f355959f = 160;
        this.f355962m = true;
        this.D = true;
        this.F = null;
        this.G = new Rect();
        this.H = new RectF();
        this.J = null;
        this.L = null;
        this.N = new Object();
        this.P = null;
        this.f355958e = bVar;
        y(resources);
    }
}

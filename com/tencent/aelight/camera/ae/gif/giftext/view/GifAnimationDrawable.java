package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.aelight.camera.aebase.k;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GifAnimationDrawable extends Drawable implements Animatable {
    private static Set<SoftReference<Bitmap>> M = Collections.synchronizedSet(new HashSet());
    private ArrayList<String> D;
    private long F;
    protected boolean J;
    private long K;

    /* renamed from: e, reason: collision with root package name */
    protected Context f65419e;

    /* renamed from: h, reason: collision with root package name */
    private b f65421h;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f65423m;

    /* renamed from: d, reason: collision with root package name */
    private final String f65418d = "FastAnimationDrawable@" + Integer.toHexString(hashCode());

    /* renamed from: f, reason: collision with root package name */
    private int f65420f = -1;
    protected boolean C = false;
    private boolean E = false;
    private ArrayList<a> H = new ArrayList<>();
    private Paint L = new Paint(1);

    /* renamed from: i, reason: collision with root package name */
    protected volatile boolean f65422i = false;
    private c G = new c(this);
    private Set<SoftReference<Bitmap>> I = M;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class Decoder implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final b f65424d;

        public Decoder(b bVar) {
            this.f65424d = bVar;
        }

        private BitmapDrawable a(String str) {
            if (QLog.isColorLevel()) {
                QLog.d(GifAnimationDrawable.this.f65418d, 2, "decodeBitmap() called with: path = [" + str + "]");
            }
            return new BitmapDrawable(k.e(str, 320, 320, true));
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GifAnimationDrawable.this.isRunning()) {
                if (QLog.isColorLevel()) {
                    QLog.d(GifAnimationDrawable.this.f65418d, 2, "Decoder index:" + this.f65424d.f65425a);
                }
                String str = "android.resource://main_tab_animation_" + ((String) GifAnimationDrawable.this.D.get(this.f65424d.f65425a));
                ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                Bitmap f16 = imageCacheHelper.f(str);
                if (f16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(GifAnimationDrawable.this.f65418d, 2, "Decoder hit cache :" + this.f65424d.f65425a);
                    }
                    this.f65424d.f65427c = new BitmapDrawable(f16);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f65424d.f65427c = a((String) GifAnimationDrawable.this.D.get(this.f65424d.f65425a));
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (QLog.isColorLevel()) {
                        QLog.d(GifAnimationDrawable.this.f65418d, 2, "Decoder decodeBitmap index:" + this.f65424d.f65425a + " cost:" + currentTimeMillis2 + " delay:" + GifAnimationDrawable.this.F);
                    }
                    imageCacheHelper.i(str, this.f65424d.f65427c.getBitmap(), Business.Default);
                }
                if (GifAnimationDrawable.this.isRunning()) {
                    GifAnimationDrawable.this.G.sendMessageAtTime(GifAnimationDrawable.this.G.obtainMessage(0, this.f65424d), this.f65424d.f65426b);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(Drawable drawable);

        void b(int i3);

        void c(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f65425a;

        /* renamed from: b, reason: collision with root package name */
        long f65426b;

        /* renamed from: c, reason: collision with root package name */
        BitmapDrawable f65427c;

        public b(int i3, long j3, BitmapDrawable bitmapDrawable) {
            this.f65425a = i3;
            this.f65426b = j3;
            this.f65427c = bitmapDrawable;
        }

        public String toString() {
            return "Frame{index=" + this.f65425a + ", targetTime=" + this.f65426b + ", drawable=" + this.f65427c + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GifAnimationDrawable> f65428a;

        public c(GifAnimationDrawable gifAnimationDrawable) {
            super(Looper.getMainLooper());
            this.f65428a = new WeakReference<>(gifAnimationDrawable);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GifAnimationDrawable gifAnimationDrawable;
            if (message.what == 0 && (gifAnimationDrawable = this.f65428a.get()) != null) {
                gifAnimationDrawable.m((b) message.obj);
            }
        }
    }

    public GifAnimationDrawable(Context context, ArrayList<String> arrayList, long j3) {
        this.F = 34L;
        this.f65419e = context;
        this.F = j3;
        this.D = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Log.i(this.f65418d, "dispatchAnimationEnd: ");
        Iterator<a> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    private void j() {
        Log.i(this.f65418d, "dispatchAnimationStart: ");
        Iterator<a> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void k(b bVar) {
        Iterator<a> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().b(bVar.f65425a);
        }
    }

    private void o() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f65418d, 2, "reset");
        }
        this.f65422i = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.K;
        long j16 = uptimeMillis - j3;
        if (j3 == 0) {
            j16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f65418d, 2, "draw() called diff=[" + j16 + "]");
        }
        if (this.f65421h != null) {
            if (this.f65423m) {
                this.f65423m = false;
                j();
            }
            this.f65421h.f65427c.setBounds(getBounds());
            if (QLog.isColorLevel()) {
                Bitmap bitmap = this.f65421h.f65427c.getBitmap();
                if (bitmap != null) {
                    QLog.d(this.f65418d, 2, "draw() called with: w=" + bitmap.getWidth() + ", h=" + bitmap.getHeight());
                } else {
                    QLog.e(this.f65418d, 2, "draw() called with: null bitmap");
                }
            }
            this.f65421h.f65427c.setFilterBitmap(true);
            this.f65421h.f65427c.draw(canvas);
            this.L.setColor(-16711936);
            this.L.setStyle(Paint.Style.STROKE);
            this.L.setStrokeWidth(1.0f);
        } else if (QLog.isColorLevel()) {
            QLog.d(this.f65418d, 2, "draw() called null bitmap");
        }
        this.K = SystemClock.uptimeMillis();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f65422i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (!isRunning() || this.J) {
            return;
        }
        this.J = true;
        int i3 = this.f65420f + 1;
        this.f65420f = i3;
        this.f65420f = i3 % this.D.size();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!this.f65423m) {
            uptimeMillis += this.F;
        }
        ThreadManagerV2.postImmediately(new Decoder(new b(this.f65420f, uptimeMillis, null)), null, false);
    }

    public void p(boolean z16) {
        this.C = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (QLog.isColorLevel()) {
            QLog.d(this.f65418d, 2, "setVisible changed:" + visible + " visible:" + z16 + " restart:" + z17);
        }
        if (z16) {
            if (visible) {
                start();
                if (z17) {
                    o();
                } else {
                    start();
                }
            }
        } else if (visible) {
            stop();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f65422i) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f65418d, 2, "start");
        }
        this.f65422i = true;
        this.f65423m = true;
        n();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f65418d, 2, "stop() called");
        }
        if (isRunning()) {
            this.f65422i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(b bVar) {
        this.J = false;
        if (this.f65421h != null) {
            if (ImageCacheHelper.f98636a.f("android.resource://main_tab_animation_" + this.D.get(this.f65421h.f65425a)) == null) {
                this.I.add(new SoftReference<>(this.f65421h.f65427c.getBitmap()));
            }
        }
        this.f65421h = bVar;
        if (!isRunning()) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f65418d, 2, "frameReady() isRunning = false");
                return;
            }
            return;
        }
        invalidateSelf();
        k(bVar);
        if (this.f65420f == this.D.size() - 1 && this.C) {
            this.G.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    GifAnimationDrawable.this.stop();
                    GifAnimationDrawable.this.h();
                }
            }, this.F);
        } else {
            n();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}

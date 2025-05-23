package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;
import org.libpag.c;

/* loaded from: classes29.dex */
public class PAGImageView extends View implements PAGAnimator.Listener {
    private volatile int A;
    private volatile int B;
    Paint C;
    private volatile boolean D;
    private volatile boolean E;
    private AtomicBoolean F;
    private boolean G;

    /* renamed from: a, reason: collision with root package name */
    private PAGAnimator f423723a;

    /* renamed from: b, reason: collision with root package name */
    private float f423724b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f423725c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile c.a f423726d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f423727e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Bitmap f423728f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Bitmap f423729g;

    /* renamed from: h, reason: collision with root package name */
    private volatile HardwareBuffer f423730h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Bitmap f423731i;

    /* renamed from: j, reason: collision with root package name */
    private volatile HardwareBuffer f423732j;

    /* renamed from: k, reason: collision with root package name */
    private Matrix f423733k;

    /* renamed from: l, reason: collision with root package name */
    private final ConcurrentHashMap f423734l;

    /* renamed from: m, reason: collision with root package name */
    private String f423735m;

    /* renamed from: n, reason: collision with root package name */
    private PAGComposition f423736n;

    /* renamed from: o, reason: collision with root package name */
    private int f423737o;

    /* renamed from: p, reason: collision with root package name */
    private volatile Matrix f423738p;

    /* renamed from: q, reason: collision with root package name */
    private float f423739q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f423740r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f423741s;

    /* renamed from: t, reason: collision with root package name */
    private int f423742t;

    /* renamed from: u, reason: collision with root package name */
    private int f423743u;

    /* renamed from: v, reason: collision with root package name */
    int f423744v;

    /* renamed from: w, reason: collision with root package name */
    long f423745w;

    /* renamed from: x, reason: collision with root package name */
    private final ArrayList f423746x;

    /* renamed from: y, reason: collision with root package name */
    private volatile int f423747y;

    /* renamed from: z, reason: collision with root package name */
    private volatile int f423748z;

    /* loaded from: classes29.dex */
    public interface PAGImageViewListener {
        void onAnimationCancel(PAGImageView pAGImageView);

        void onAnimationEnd(PAGImageView pAGImageView);

        void onAnimationRepeat(PAGImageView pAGImageView);

        void onAnimationStart(PAGImageView pAGImageView);

        void onAnimationUpdate(PAGImageView pAGImageView);
    }

    static {
        org.extra.tools.a.b("pag");
    }

    public PAGImageView(Context context) {
        super(context);
        this.f423724b = 30.0f;
        this.f423725c = new AtomicBoolean(false);
        this.f423726d = new c.a();
        this.f423727e = new Object();
        this.f423734l = new ConcurrentHashMap();
        this.f423737o = 2;
        this.f423739q = 1.0f;
        this.f423740r = false;
        this.f423741s = false;
        this.f423743u = 0;
        this.f423744v = -1;
        this.f423745w = 0L;
        this.f423746x = new ArrayList();
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = new AtomicBoolean(true);
        this.G = false;
        e();
    }

    private static native int ContentVersion(PAGComposition pAGComposition);

    @Deprecated
    public static long MaxDiskCache() {
        return PAGDiskCache.MaxDiskSize();
    }

    @Deprecated
    public static void SetMaxDiskCache(long j3) {
        PAGDiskCache.SetMaxDiskSize(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, float f16, PAGFile.LoadListener loadListener) {
        setPath(str, f16);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.f423736n);
        }
    }

    private void b() {
        PAGComposition pAGComposition;
        boolean z16 = true;
        boolean z17 = false;
        if (this.f423741s) {
            this.f423741s = false;
            z17 = true;
        }
        if (this.f423735m == null && (pAGComposition = this.f423736n) != null) {
            int ContentVersion = ContentVersion(pAGComposition);
            int i3 = this.f423744v;
            if (i3 < 0 || i3 == ContentVersion) {
                z16 = z17;
            }
            this.f423744v = ContentVersion;
            z17 = z16;
        }
        if (z17) {
            this.f423734l.clear();
            if (!this.f423726d.a()) {
                PAGComposition pAGComposition2 = this.f423736n;
                if (pAGComposition2 == null) {
                    pAGComposition2 = a(this.f423735m);
                }
                this.f423726d.a(pAGComposition2, this.f423747y, this.f423748z, this.f423724b);
            }
        }
    }

    private void c() {
        boolean z16;
        long j3;
        if (this.D && isShown() && d()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.G == z16) {
            return;
        }
        this.G = z16;
        if (z16) {
            PAGComposition pAGComposition = this.f423736n;
            if (pAGComposition != null) {
                j3 = pAGComposition.duration();
            } else {
                j3 = this.f423745w;
            }
            this.f423723a.setDuration(j3);
            this.f423723a.update();
            return;
        }
        this.f423723a.setDuration(0L);
    }

    private void e() {
        this.C = new Paint(6);
        this.f423723a = PAGAnimator.a(getContext(), this);
    }

    private void g() {
        int i3 = this.f423737o;
        if (i3 == 0) {
            return;
        }
        this.f423738p = c.a(i3, this.f423726d.f423781a, this.f423726d.f423782b, this.f423747y, this.f423748z);
    }

    private void h() {
        if (!this.f423726d.b() && this.f423743u == 0 && this.f423747y > 0) {
            f();
        }
        if (this.f423726d.b() & this.f423726d.a()) {
            this.f423743u = this.f423726d.c();
        }
    }

    private void i() {
        synchronized (this.f423727e) {
            this.f423728f = null;
            this.f423729g = null;
            this.f423731i = null;
            if (Build.VERSION.SDK_INT >= 26) {
                if (this.f423730h != null) {
                    this.f423730h.close();
                    this.f423730h = null;
                }
                if (this.f423732j != null) {
                    this.f423732j.close();
                    this.f423732j = null;
                }
            }
        }
    }

    private void j() {
        if (a()) {
            this.f423726d.d();
        }
    }

    public void addListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f423746x.add(pAGImageViewListener);
        }
    }

    public boolean cacheAllFramesInMemory() {
        return this.f423740r;
    }

    public int currentFrame() {
        return this.f423742t;
    }

    public Bitmap currentImage() {
        return this.f423728f;
    }

    protected void f() {
        synchronized (this.f423726d) {
            if (!this.f423726d.b()) {
                if (this.f423736n == null) {
                    this.f423736n = a(this.f423735m);
                }
                if (this.f423726d.a(this.f423736n, this.f423747y, this.f423748z, this.f423724b) && this.f423735m != null) {
                    this.f423736n = null;
                }
                if (!this.f423726d.b()) {
                    return;
                }
            }
            g();
            this.f423725c.set(false);
        }
    }

    protected void finalize() {
        super.finalize();
    }

    public boolean flush() {
        if (!this.f423726d.b()) {
            f();
            if (!this.f423726d.b()) {
                postInvalidate();
                return false;
            }
        }
        if (this.f423726d.a()) {
            this.f423743u = this.f423726d.c();
        }
        int a16 = c.a(this.f423723a.progress(), this.f423743u);
        this.f423742t = a16;
        if (!a(a16)) {
            this.E = false;
            return false;
        }
        this.E = false;
        postInvalidate();
        return true;
    }

    public PAGComposition getComposition() {
        if (this.f423735m != null) {
            return null;
        }
        return this.f423736n;
    }

    public String getPath() {
        return this.f423735m;
    }

    public boolean isPlaying() {
        return this.f423723a.isRunning();
    }

    public Matrix matrix() {
        return this.f423738p;
    }

    public int numFrames() {
        h();
        return this.f423743u;
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f423746x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationCancel(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationEnd(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f423746x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationEnd(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationRepeat(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f423746x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationRepeat(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationStart(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f423746x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationStart(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        PAGComposition pAGComposition;
        if (!this.D) {
            return;
        }
        if (this.G && (pAGComposition = this.f423736n) != null) {
            pAGAnimator.setDuration(pAGComposition.duration());
        }
        flush();
        synchronized (this) {
            arrayList = new ArrayList(this.f423746x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationUpdate(this);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.D = true;
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.D = false;
        super.onDetachedFromWindow();
        c();
        this.f423726d.e();
        if (this.f423723a.isRunning()) {
            i();
        }
        this.f423734l.clear();
        this.f423744v = -1;
        this.f423741s = false;
        this.f423725c.set(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f423725c.get() && this.f423728f != null && !this.f423728f.isRecycled()) {
            super.onDraw(canvas);
            int saveCount = canvas.getSaveCount();
            canvas.save();
            Matrix matrix = this.f423733k;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (this.f423738p != null) {
                canvas.concat(this.f423738p);
            }
            try {
                canvas.drawBitmap(this.f423728f, 0.0f, 0.0f, this.C);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            canvas.restoreToCount(saveCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f423725c.set(true);
        this.f423726d.e();
        this.A = i3;
        this.B = i16;
        this.f423747y = (int) (this.f423739q * i3);
        this.f423748z = (int) (this.f423739q * i16);
        i();
        this.E = true;
        c();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z16) {
        super.onVisibilityAggregated(z16);
        c();
    }

    public void pause() {
        this.f423723a.cancel();
    }

    public void play() {
        this.f423723a.a();
    }

    public void removeListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f423746x.remove(pAGImageViewListener);
        }
    }

    public float renderScale() {
        return this.f423739q;
    }

    public int repeatCount() {
        return this.f423723a.repeatCount();
    }

    public int scaleMode() {
        return this.f423737o;
    }

    public void setCacheAllFramesInMemory(boolean z16) {
        boolean z17;
        if (z16 != this.f423740r) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f423741s = z17;
        this.f423740r = z16;
    }

    public void setComposition(PAGComposition pAGComposition) {
        setComposition(pAGComposition, 30.0f);
    }

    public void setCurrentFrame(int i3) {
        int i16;
        h();
        if (this.f423743u == 0 || !this.f423726d.b() || i3 < 0 || i3 >= (i16 = this.f423743u)) {
            return;
        }
        this.f423742t = i3;
        this.f423723a.setProgress(c.a(i3, i16));
        this.f423723a.update();
    }

    public void setMatrix(Matrix matrix) {
        this.f423738p = matrix;
        this.f423737o = 0;
        if (d()) {
            postInvalidate();
        }
    }

    public boolean setPath(String str) {
        return setPath(str, 30.0f);
    }

    public void setPathAsync(String str, PAGFile.LoadListener loadListener) {
        setPathAsync(str, 30.0f, loadListener);
    }

    public void setRenderScale(float f16) {
        if (this.f423739q == f16) {
            return;
        }
        if (f16 < 0.0f || f16 > 1.0f) {
            f16 = 1.0f;
        }
        this.f423739q = f16;
        this.f423747y = (int) (this.A * f16);
        this.f423748z = (int) (this.B * f16);
        g();
        if (f16 < 1.0f) {
            Matrix matrix = new Matrix();
            this.f423733k = matrix;
            float f17 = 1.0f / f16;
            matrix.setScale(f17, f17);
        }
    }

    public void setRepeatCount(int i3) {
        this.f423723a.setRepeatCount(i3);
    }

    public void setScaleMode(int i3) {
        if (i3 == this.f423737o) {
            return;
        }
        this.f423737o = i3;
        if (d()) {
            g();
            postInvalidate();
        } else {
            this.f423738p = null;
        }
    }

    private boolean d() {
        return this.f423747y > 0 && this.f423748z > 0;
    }

    public void setComposition(PAGComposition pAGComposition, float f16) {
        a((String) null, pAGComposition, f16);
    }

    public boolean setPath(String str, float f16) {
        PAGComposition a16 = a(str);
        a(str, a16, f16);
        return a16 != null;
    }

    public void setPathAsync(final String str, final float f16, final PAGFile.LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.f
            @Override // java.lang.Runnable
            public final void run() {
                PAGImageView.this.a(str, f16, loadListener);
            }
        });
    }

    private PAGComposition a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("assets://")) {
            return PagViewMonitor.Load(getContext().getAssets(), str.substring(9));
        }
        return PagViewMonitor.Load(str);
    }

    private void a(String str, PAGComposition pAGComposition, float f16) {
        this.f423725c.set(true);
        this.f423726d.e();
        this.f423724b = f16;
        this.f423738p = null;
        i();
        this.f423735m = str;
        this.f423736n = pAGComposition;
        this.f423742t = 0;
        this.f423723a.setProgress(pAGComposition == null ? 0.0d : pAGComposition.getProgress());
        PAGComposition pAGComposition2 = this.f423736n;
        long duration = pAGComposition2 == null ? 0L : pAGComposition2.duration();
        this.f423745w = duration;
        if (this.G) {
            this.f423723a.setDuration(duration);
        }
        this.f423723a.update();
    }

    private boolean a() {
        if (this.f423726d.b() && this.f423726d.a()) {
            this.f423743u = this.f423726d.c();
        }
        return this.f423734l.size() == this.f423743u;
    }

    public PAGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f423724b = 30.0f;
        this.f423725c = new AtomicBoolean(false);
        this.f423726d = new c.a();
        this.f423727e = new Object();
        this.f423734l = new ConcurrentHashMap();
        this.f423737o = 2;
        this.f423739q = 1.0f;
        this.f423740r = false;
        this.f423741s = false;
        this.f423743u = 0;
        this.f423744v = -1;
        this.f423745w = 0L;
        this.f423746x = new ArrayList();
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = new AtomicBoolean(true);
        this.G = false;
        e();
    }

    private boolean a(int i3) {
        HardwareBuffer hardwareBuffer;
        Bitmap bitmap;
        if (!this.f423726d.b() || this.f423725c.get()) {
            return false;
        }
        b();
        j();
        Bitmap bitmap2 = (Bitmap) this.f423734l.get(Integer.valueOf(i3));
        if (bitmap2 != null) {
            this.f423728f = bitmap2;
            return true;
        }
        if (this.f423725c.get() || !this.f423726d.a()) {
            return false;
        }
        if (!this.E && !this.f423726d.a(i3)) {
            return true;
        }
        synchronized (this.f423727e) {
            if (this.f423729g == null || this.f423740r) {
                Pair a16 = a.a(this.f423726d.f423781a, this.f423726d.f423782b, false);
                Object obj = a16.first;
                if (obj == null) {
                    return false;
                }
                this.f423729g = (Bitmap) obj;
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f423730h = (HardwareBuffer) a16.second;
                }
            }
            if (this.f423729g == null) {
                return false;
            }
            if (!this.f423740r) {
                if (this.f423731i == null) {
                    Pair a17 = a.a(this.f423726d.f423781a, this.f423726d.f423782b, false);
                    if (a17.first == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.f423732j = (HardwareBuffer) a17.second;
                    }
                    this.f423731i = (Bitmap) a17.first;
                }
                if (this.F.get()) {
                    bitmap = this.f423729g;
                    hardwareBuffer = this.f423730h;
                } else {
                    bitmap = this.f423731i;
                    hardwareBuffer = this.f423732j;
                }
                this.F.set(!r5.get());
            } else {
                hardwareBuffer = this.f423730h;
                bitmap = this.f423729g;
            }
            if (hardwareBuffer != null) {
                if (!this.f423726d.a(i3, hardwareBuffer)) {
                    return false;
                }
            } else {
                if (!this.f423726d.a(bitmap, i3)) {
                    return false;
                }
                bitmap.prepareToDraw();
            }
            this.f423728f = bitmap;
            if (this.f423740r && this.f423728f != null) {
                this.f423734l.put(Integer.valueOf(i3), this.f423728f);
            }
            return true;
        }
    }

    public PAGImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f423724b = 30.0f;
        this.f423725c = new AtomicBoolean(false);
        this.f423726d = new c.a();
        this.f423727e = new Object();
        this.f423734l = new ConcurrentHashMap();
        this.f423737o = 2;
        this.f423739q = 1.0f;
        this.f423740r = false;
        this.f423741s = false;
        this.f423743u = 0;
        this.f423744v = -1;
        this.f423745w = 0L;
        this.f423746x = new ArrayList();
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = new AtomicBoolean(true);
        this.G = false;
        e();
    }
}

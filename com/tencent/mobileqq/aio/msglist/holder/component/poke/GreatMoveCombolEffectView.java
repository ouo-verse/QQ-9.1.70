package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GreatMoveCombolEffectView extends View implements Runnable {
    static IPatchRedirector $redirector_;
    public static boolean M;
    int C;
    private Context D;
    private Vector<Bitmap> E;
    boolean F;
    private long G;
    private View H;
    private final int[] I;
    b J;
    ArrayList<c> K;
    public ArrayList<Bitmap> L;

    /* renamed from: d, reason: collision with root package name */
    Handler f191500d;

    /* renamed from: e, reason: collision with root package name */
    Handler f191501e;

    /* renamed from: f, reason: collision with root package name */
    DecodeRunnable f191502f;

    /* renamed from: h, reason: collision with root package name */
    Bitmap f191503h;

    /* renamed from: i, reason: collision with root package name */
    Paint f191504i;

    /* renamed from: m, reason: collision with root package name */
    int f191505m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class DecodeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        BitmapFactory.Options f191506d;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<Bitmap> f191507e;

        public DecodeRunnable(ArrayList<Bitmap> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GreatMoveCombolEffectView.this, (Object) arrayList);
            } else {
                this.f191506d = new BitmapFactory.Options();
                this.f191507e = arrayList;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (this) {
                while (this.f191507e.size() < 2) {
                    GreatMoveCombolEffectView greatMoveCombolEffectView = GreatMoveCombolEffectView.this;
                    if (greatMoveCombolEffectView.C >= greatMoveCombolEffectView.K.size() || !GreatMoveCombolEffectView.M) {
                        break;
                    }
                    GreatMoveCombolEffectView greatMoveCombolEffectView2 = GreatMoveCombolEffectView.this;
                    ArrayList<c> arrayList = greatMoveCombolEffectView2.K;
                    int i3 = greatMoveCombolEffectView2.C;
                    greatMoveCombolEffectView2.C = i3 + 1;
                    c cVar = arrayList.get(i3);
                    if (cVar != null) {
                        BitmapFactory.Options options = this.f191506d;
                        options.inSampleSize = 1;
                        options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                        options.inMutable = true;
                        Bitmap bitmap2 = null;
                        if (GreatMoveCombolEffectView.this.E.size() > 0) {
                            bitmap = (Bitmap) GreatMoveCombolEffectView.this.E.remove(0);
                        } else {
                            bitmap = null;
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            this.f191506d.inBitmap = bitmap;
                        }
                        try {
                            bitmap2 = BaseImageUtil.decodeFileWithBufferedStream(cVar.f191509a, this.f191506d);
                        } catch (OutOfMemoryError e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GreatMove", 2, e16.toString());
                            }
                        }
                        if (bitmap2 != null) {
                            this.f191507e.add(bitmap2);
                        }
                    }
                }
                if (!GreatMoveCombolEffectView.M) {
                    GreatMoveCombolEffectView.this.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GreatMoveCombolEffectView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f191509a;

        /* renamed from: b, reason: collision with root package name */
        int f191510b;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GreatMoveCombolEffectView.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            M = false;
        }
    }

    public GreatMoveCombolEffectView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e() {
        String str = af.I3 + "/dazhao_caidan/dazhao_caidan_";
        int i3 = 0;
        while (i3 < 37) {
            i3++;
            if (i3 < 10) {
                f(str + "0" + i3 + ".png", 30);
            } else {
                f(str + i3 + ".png", 30);
            }
        }
    }

    private void k(Context context) {
        this.D = context;
        setOnTouchListener(new a());
        this.f191500d = new Handler(Looper.getMainLooper());
        e();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("decode");
        baseHandlerThread.start();
        this.f191501e = new Handler(baseHandlerThread.getLooper());
    }

    private void m(b bVar) {
        this.J = bVar;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.G == 0) {
            return;
        }
        this.H.getLocationOnScreen(this.I);
        int i3 = this.I[1] + (this.H.getLayoutParams().height / 2);
        super.draw(canvas);
        Bitmap bitmap = this.f191503h;
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = this.f191503h.getWidth();
            int height = this.f191503h.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            if (this.F) {
                canvas.save();
                canvas.scale(-1.0f, 1.0f, width2 / 2, height2 / 2);
            }
            canvas.translate(0.0f, -(((int) ((r5 / 2.0f) - i3)) + 50));
            canvas.drawBitmap(this.f191503h, new Rect(0, 0, width, height), new Rect(0, 0, width2, (int) (height * ((width2 * 1.0f) / width))), this.f191504i);
            if (this.F) {
                canvas.restore();
            }
        }
    }

    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        c cVar = new c();
        cVar.f191509a = str;
        cVar.f191510b = i3;
        this.K.add(cVar);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Bitmap bitmap = this.f191503h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f191503h.recycle();
            this.f191503h = null;
        }
        if (this.L.size() > 0) {
            Iterator<Bitmap> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.L.clear();
        }
        if (this.E.size() > 0) {
            Iterator<Bitmap> it5 = this.E.iterator();
            while (it5.hasNext()) {
                it5.next().recycle();
            }
            this.E.clear();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.D = null;
            i();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f191505m = 0;
        this.C = 0;
        M = false;
        this.f191500d.removeCallbacks(this);
        this.f191501e.post(this.f191502f);
        this.f191502f = null;
        setVisibility(8);
        b bVar = this.J;
        if (bVar != null) {
            bVar.a();
            this.J = null;
        }
    }

    public Bitmap j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ArrayList<Bitmap> arrayList = this.L;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.L.remove(0);
    }

    public void l(long j3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), bVar);
            return;
        }
        if (M && j3 != this.G) {
            return;
        }
        this.f191505m = 0;
        this.f191500d.removeCallbacks(this);
        this.f191500d.post(this);
        try {
            this.f191503h = BaseImageUtil.decodeFileWithBufferedStream(this.K.get(this.f191505m).f191509a, null);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GreatMoveCombolEffectView", 2, e16.toString());
            }
            this.f191503h = null;
        }
    }

    public void n(long j3, View view, boolean z16, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), view, Boolean.valueOf(z16), bVar);
            return;
        }
        if (M) {
            bVar.a();
            return;
        }
        m(bVar);
        setVisibility(0);
        this.G = j3;
        this.H = view;
        this.F = z16;
        this.f191500d.removeCallbacks(this);
        this.f191500d.post(this);
        try {
            this.f191503h = BaseImageUtil.decodeFileWithBufferedStream(this.K.get(this.f191505m).f191509a, null);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GreatMoveCombolEffectView", 2, e16.toString());
            }
            this.f191503h = null;
        }
        M = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = this.f191505m + 1;
        if (i3 < 37 && M) {
            if (this.f191502f == null) {
                this.f191502f = new DecodeRunnable(this.L);
            }
            c cVar = this.K.get(i3);
            this.f191501e.removeCallbacks(this.f191502f);
            this.f191501e.post(this.f191502f);
            this.f191505m++;
            Bitmap bitmap = this.f191503h;
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmap2 = this.f191503h;
                if (this.E.size() <= 2) {
                    this.E.add(bitmap2);
                } else {
                    bitmap2.recycle();
                }
            }
            this.f191503h = j();
            invalidate();
            this.f191500d.postDelayed(this, cVar.f191510b);
            return;
        }
        i();
    }

    public GreatMoveCombolEffectView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GreatMoveCombolEffectView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f191504i = new Paint(6);
        this.f191505m = 0;
        this.C = 0;
        this.E = new Vector<>();
        this.F = false;
        this.I = new int[2];
        this.K = new ArrayList<>();
        this.L = new ArrayList<>();
        k(context);
    }
}

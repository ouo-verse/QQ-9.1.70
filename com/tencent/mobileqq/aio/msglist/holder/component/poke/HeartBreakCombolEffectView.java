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
public class HeartBreakCombolEffectView extends View implements Runnable {
    static IPatchRedirector $redirector_;
    static boolean G;
    int C;
    int D;
    ArrayList<b> E;
    public ArrayList<Bitmap> F;

    /* renamed from: d, reason: collision with root package name */
    Handler f191512d;

    /* renamed from: e, reason: collision with root package name */
    Handler f191513e;

    /* renamed from: f, reason: collision with root package name */
    DecodeRunnable f191514f;

    /* renamed from: h, reason: collision with root package name */
    Bitmap f191515h;

    /* renamed from: i, reason: collision with root package name */
    private Vector<Bitmap> f191516i;

    /* renamed from: m, reason: collision with root package name */
    Paint f191517m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class DecodeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        BitmapFactory.Options f191518d;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<Bitmap> f191519e;

        public DecodeRunnable(ArrayList<Bitmap> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartBreakCombolEffectView.this, (Object) arrayList);
            } else {
                this.f191518d = new BitmapFactory.Options();
                this.f191519e = arrayList;
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
            while (this.f191519e.size() < 2) {
                HeartBreakCombolEffectView heartBreakCombolEffectView = HeartBreakCombolEffectView.this;
                if (heartBreakCombolEffectView.D >= heartBreakCombolEffectView.E.size() || !HeartBreakCombolEffectView.G) {
                    break;
                }
                HeartBreakCombolEffectView heartBreakCombolEffectView2 = HeartBreakCombolEffectView.this;
                ArrayList<b> arrayList = heartBreakCombolEffectView2.E;
                int i3 = heartBreakCombolEffectView2.D;
                heartBreakCombolEffectView2.D = i3 + 1;
                b bVar = arrayList.get(i3);
                if (bVar != null) {
                    BitmapFactory.Options options = this.f191518d;
                    options.inSampleSize = 1;
                    options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                    options.inMutable = true;
                    Bitmap bitmap2 = null;
                    if (HeartBreakCombolEffectView.this.f191516i.size() > 0) {
                        bitmap = (Bitmap) HeartBreakCombolEffectView.this.f191516i.remove(0);
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f191518d.inBitmap = bitmap;
                    }
                    try {
                        bitmap2 = BaseImageUtil.decodeFileWithBufferedStream(bVar.f191521a, this.f191518d);
                    } catch (OutOfMemoryError e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("HeartBreak", 2, e16.toString());
                        }
                    }
                    if (bitmap2 != null) {
                        this.f191519e.add(bitmap2);
                    }
                }
            }
            if (!HeartBreakCombolEffectView.G) {
                HeartBreakCombolEffectView.this.g();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartBreakCombolEffectView.this);
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
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f191521a;

        /* renamed from: b, reason: collision with root package name */
        int f191522b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartBreakCombolEffectView.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            G = false;
        }
    }

    public HeartBreakCombolEffectView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e() {
        String str = af.I3 + "/xinsui_caidan/xinsui_caidan_";
        int i3 = 0;
        while (i3 < 55) {
            i3++;
            if (i3 < 10) {
                f(str + "0" + i3 + ".png", 30);
            } else {
                f(str + i3 + ".png", 30);
            }
        }
    }

    private void j() {
        setOnTouchListener(new a());
        this.f191512d = new Handler(Looper.getMainLooper());
        e();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("decode");
        baseHandlerThread.start();
        this.f191513e = new Handler(baseHandlerThread.getLooper());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        Bitmap bitmap = this.f191515h;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = this.f191515h.getHeight();
            int width2 = getWidth();
            canvas.translate(0.0f, ((int) ((getHeight() / 2) - (r5 / 2.0f))) + 50);
            canvas.drawBitmap(this.f191515h, new Rect(0, 0, width, height), new Rect(0, 0, width2, (int) (height * ((width2 * 1.0f) / width))), this.f191517m);
        }
    }

    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        b bVar = new b();
        bVar.f191521a = str;
        bVar.f191522b = i3;
        this.E.add(bVar);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Bitmap bitmap = this.f191515h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f191515h.recycle();
            this.f191515h = null;
        }
        if (this.F.size() > 0) {
            Iterator<Bitmap> it = this.F.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.F.clear();
        }
        if (this.f191516i.size() > 0) {
            Iterator<Bitmap> it5 = this.f191516i.iterator();
            while (it5.hasNext()) {
                it5.next().recycle();
            }
            this.f191516i.clear();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.C = 0;
        this.D = 0;
        G = false;
        this.f191512d.removeCallbacks(this);
        this.f191513e.post(this.f191514f);
        this.f191514f = null;
        setVisibility(8);
    }

    public Bitmap i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<Bitmap> arrayList = this.F;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.F.remove(0);
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (G) {
            return;
        }
        setVisibility(0);
        this.f191512d.removeCallbacks(this);
        this.f191512d.post(this);
        this.f191515h = BaseImageUtil.decodeFileWithBufferedStream(this.E.get(this.C).f191521a, null);
        G = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int i3 = this.C + 1;
        if (i3 < 55) {
            if (this.f191514f == null) {
                this.f191514f = new DecodeRunnable(this.F);
            }
            b bVar = this.E.get(i3);
            this.f191513e.removeCallbacks(this.f191514f);
            this.f191513e.post(this.f191514f);
            this.C++;
            Bitmap bitmap = this.f191515h;
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmap2 = this.f191515h;
                if (this.f191516i.size() <= 2) {
                    this.f191516i.add(bitmap2);
                } else {
                    bitmap2.recycle();
                }
            }
            this.f191515h = i();
            invalidate();
            this.f191512d.postDelayed(this, bVar.f191522b);
            return;
        }
        h();
    }

    public HeartBreakCombolEffectView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public HeartBreakCombolEffectView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f191516i = new Vector<>();
        this.f191517m = new Paint(6);
        this.C = 0;
        this.D = 0;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        j();
    }
}

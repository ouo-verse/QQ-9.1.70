package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class HeartCombolEffectView extends View implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private long C;
    private int D;
    private int E;
    private String F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private Handler f191524d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<d> f191525e;

    /* renamed from: f, reason: collision with root package name */
    private d f191526f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f191527h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f191528i;

    /* renamed from: m, reason: collision with root package name */
    private Matrix f191529m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartCombolEffectView.this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartCombolEffectView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                super.onAnimationCancel(animator);
                HeartCombolEffectView.this.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                super.onAnimationEnd(animator);
                HeartCombolEffectView.this.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f191532d;

        c(d dVar) {
            this.f191532d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartCombolEffectView.this, (Object) dVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f191532d.f191543j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d dVar = this.f191532d;
            if (!dVar.f191548o && dVar.f191543j > 0.0f) {
                dVar.f191548o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f191534a;

        /* renamed from: b, reason: collision with root package name */
        public int f191535b;

        /* renamed from: c, reason: collision with root package name */
        public int f191536c;

        /* renamed from: d, reason: collision with root package name */
        public int f191537d;

        /* renamed from: e, reason: collision with root package name */
        public int f191538e;

        /* renamed from: f, reason: collision with root package name */
        public int f191539f;

        /* renamed from: g, reason: collision with root package name */
        public int f191540g;

        /* renamed from: h, reason: collision with root package name */
        public int f191541h;

        /* renamed from: i, reason: collision with root package name */
        public float f191542i;

        /* renamed from: j, reason: collision with root package name */
        public float f191543j;

        /* renamed from: k, reason: collision with root package name */
        public int f191544k;

        /* renamed from: l, reason: collision with root package name */
        public Scroller f191545l;

        /* renamed from: m, reason: collision with root package name */
        public Scroller f191546m;

        /* renamed from: n, reason: collision with root package name */
        public ValueAnimator f191547n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f191548o;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeartCombolEffectView.this);
            }
        }
    }

    public HeartCombolEffectView(Context context, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
            return;
        }
        this.f191529m = null;
        this.C = 0L;
        this.D = 0;
        this.E = 0;
        this.F = "chat_item_for_qqbixin_strong";
        this.I = 0;
        this.J = 0;
        this.K = true;
        this.H = z16;
        c(context);
    }

    private d b(int i3, int i16, int i17, int i18, int i19, float f16, int i26) {
        d dVar = new d();
        dVar.f191534a = false;
        dVar.f191535b = i3;
        dVar.f191536c = i16;
        dVar.f191537d = i17;
        dVar.f191538e = i18;
        dVar.f191539f = i19;
        dVar.f191542i = f16;
        dVar.f191544k = i26;
        dVar.f191548o = false;
        dVar.f191545l = new Scroller(getContext(), new DecelerateInterpolator());
        dVar.f191545l = new Scroller(getContext(), new DecelerateInterpolator());
        dVar.f191546m = new Scroller(getContext(), new AccelerateInterpolator());
        ValueAnimator ofFloat = ValueAnimator.ofFloat(dVar.f191542i, 0.0f);
        dVar.f191547n = ofFloat;
        ofFloat.setDuration(1100 - dVar.f191544k);
        dVar.f191547n.addUpdateListener(new c(dVar));
        return dVar;
    }

    public Bitmap a(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmap);
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    void c(Context context) {
        setOnTouchListener(new a());
        this.f191524d = new Handler(Looper.getMainLooper(), this);
        Bitmap decodeResourceStream = BaseImageUtil.decodeResourceStream(getResources(), R.drawable.ccy);
        this.f191527h = decodeResourceStream;
        if (decodeResourceStream != null) {
            this.f191528i = a(decodeResourceStream);
        }
        if (this.f191528i == null) {
            this.f191528i = this.f191527h;
        }
        this.f191529m = new Matrix();
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int statusBarHeight = getResources().getDisplayMetrics().heightPixels - (ImmersiveUtils.getStatusBarHeight(getContext()) * 2);
        ArrayList<d> arrayList = new ArrayList<>();
        this.f191525e = arrayList;
        int i16 = (int) (i3 * 1.2f);
        float f16 = statusBarHeight;
        arrayList.add(b(300, i16, (int) (0.37f * f16), 0, (int) (0.15f * f16), 1.0f, 500));
        this.f191525e.add(b(MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT, i16, (int) (0.42f * f16), 0, (int) (0.25f * f16), 0.95f, 500));
        double d16 = -i3;
        int i17 = (int) (0.06d * d16);
        this.f191525e.add(b(180, i16, (int) (0.46f * f16), i17, (int) (0.27f * f16), 1.42f, 500));
        this.f191525e.add(b(450, i16, (int) (0.51f * f16), 0, (int) (0.45f * f16), 0.92f, 500));
        this.f191525e.add(b(0, i16, (int) (0.56f * f16), (int) (0.1d * d16), (int) (0.6f * f16), 0.55f, 500));
        this.f191525e.add(b(620, i16, (int) (0.63f * f16), (int) (d16 * 0.04d), (int) (0.75f * f16), 1.3f, 500));
        this.f191525e.add(b(410, i16, (int) (0.71f * f16), i17, (int) (f16 * 0.89f), 0.88f, 500));
        d dVar = this.f191525e.get(1);
        this.f191526f = dVar;
        dVar.f191547n.addListener(new b());
        this.D = i3;
        this.E = statusBarHeight;
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.K = z16;
        setVisibility(0);
        this.f191524d.sendEmptyMessage(1);
        if (this.H) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.HeartCombolEffectView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HeartCombolEffectView.this);
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
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i17 = message.what;
        if (i17 != 1) {
            if (i17 == 2) {
                this.f191524d.removeMessages(2);
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.C;
                for (int i18 = 0; i18 < this.f191525e.size(); i18++) {
                    d dVar = this.f191525e.get(i18);
                    if (currentAnimationTimeMillis >= dVar.f191535b) {
                        if (!dVar.f191534a) {
                            if (this.K) {
                                int i19 = dVar.f191536c;
                                i16 = dVar.f191538e;
                                i3 = i19;
                            } else {
                                int i26 = this.D;
                                i3 = i26 - dVar.f191536c;
                                i16 = i26 - dVar.f191538e;
                            }
                            dVar.f191545l.startScroll(i3, 0, i16 - i3, 0, 1100);
                            Scroller scroller = dVar.f191546m;
                            int i27 = dVar.f191537d;
                            scroller.startScroll(0, i27, 0, dVar.f191539f - i27, 1100);
                            dVar.f191534a = true;
                        }
                        if (dVar.f191545l.computeScrollOffset()) {
                            dVar.f191546m.computeScrollOffset();
                            if (dVar.f191545l.timePassed() > dVar.f191544k && dVar.f191543j == dVar.f191542i) {
                                dVar.f191547n.start();
                            }
                            dVar.f191540g = dVar.f191545l.getCurrX();
                            dVar.f191541h = dVar.f191546m.getCurrY();
                        }
                    }
                }
                int i28 = this.D;
                d dVar2 = this.f191526f;
                int i29 = i28 - dVar2.f191538e;
                float floatValue = ((Float) dVar2.f191547n.getAnimatedValue()).floatValue();
                d dVar3 = this.f191526f;
                if (dVar3.f191534a && ((!(z16 = this.K) || dVar3.f191540g <= dVar3.f191538e) && ((z16 || dVar3.f191540g >= i29) && (!dVar3.f191548o || floatValue <= 0.001d)))) {
                    this.G = 0;
                } else {
                    postInvalidate();
                    Message obtainMessage = this.f191524d.obtainMessage();
                    obtainMessage.what = 2;
                    this.f191524d.sendMessageDelayed(obtainMessage, 25L);
                }
            }
        } else {
            this.C = AnimationUtils.currentAnimationTimeMillis();
            Iterator<d> it = this.f191525e.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f191534a = false;
                next.f191545l.abortAnimation();
                next.f191546m.abortAnimation();
                next.f191540g = next.f191536c;
                next.f191541h = next.f191537d;
                next.f191543j = next.f191542i;
            }
            this.f191524d.sendEmptyMessage(2);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        boolean z16 = this.K;
        if (z16 && this.f191527h == null) {
            return;
        }
        if (!z16 && this.f191528i == null) {
            return;
        }
        Iterator<d> it = this.f191525e.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f191534a) {
                this.f191529m.reset();
                boolean z17 = this.K;
                if (z17 && (bitmap2 = this.f191527h) != null) {
                    this.I = (int) ((bitmap2.getWidth() * next.f191543j) / 2.0f);
                    this.J = (int) ((this.f191527h.getHeight() * next.f191543j) / 2.0f);
                    this.f191529m.postTranslate(next.f191540g, next.f191541h);
                    Matrix matrix = this.f191529m;
                    float f16 = next.f191543j;
                    matrix.preScale(f16, f16);
                    canvas.drawBitmap(this.f191527h, this.f191529m, null);
                } else if (!z17 && (bitmap = this.f191528i) != null) {
                    this.I = (int) ((bitmap.getWidth() * next.f191543j) / 2.0f);
                    this.J = (int) ((this.f191528i.getHeight() * next.f191543j) / 2.0f);
                    this.f191529m.postTranslate(next.f191540g, next.f191541h);
                    Matrix matrix2 = this.f191529m;
                    float f17 = next.f191543j;
                    matrix2.preScale(f17, f17);
                    canvas.drawBitmap(this.f191528i, this.f191529m, null);
                }
            }
        }
    }

    public HeartCombolEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f191529m = null;
        this.C = 0L;
        this.D = 0;
        this.E = 0;
        this.F = "chat_item_for_qqbixin_strong";
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = true;
        c(context);
    }

    public HeartCombolEffectView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f191529m = null;
        this.C = 0L;
        this.D = 0;
        this.E = 0;
        this.F = "chat_item_for_qqbixin_strong";
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = true;
        c(context);
    }
}

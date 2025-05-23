package com.tencent.mobileqq.vasgift.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.vasgift.utils.LongClickHandler;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQVasGiftComboSendView extends FrameLayout implements com.tencent.mobileqq.vasgift.view.anim.g {
    private final LongClickHandler C;
    private final ImageView D;
    private final LinearLayout E;
    private final ImageView F;
    private final ImageView G;
    private final ImageView H;
    private final ImageView I;
    private final ImageView J;
    private BannerResManager K;
    private com.tencent.mobileqq.vasgift.view.anim.c L;
    private final h M;
    private int N;
    boolean P;
    ApngDrawable.OnPlayRepeatListener Q;
    ApngDrawable.OnPlayRepeatListener R;
    ApngDrawable.OnPlayRepeatListener S;
    ApngDrawable.OnPlayRepeatListener T;
    private ObjectAnimator U;
    private ObjectAnimator V;
    private ObjectAnimator W;

    /* renamed from: a0, reason: collision with root package name */
    private ObjectAnimator f312061a0;

    /* renamed from: d, reason: collision with root package name */
    private ph2.b f312062d;

    /* renamed from: e, reason: collision with root package name */
    private int f312063e;

    /* renamed from: f, reason: collision with root package name */
    private int f312064f;

    /* renamed from: h, reason: collision with root package name */
    private int f312065h;

    /* renamed from: i, reason: collision with root package name */
    private long f312066i;

    /* renamed from: m, reason: collision with root package name */
    private int f312067m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class DelaySendRunnable implements Runnable {
        DelaySendRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QQVasGiftComboSendView.this.A();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.vasgift.view.b {
        a(int i3) {
            super(i3);
        }

        @Override // com.tencent.mobileqq.vasgift.view.b
        public void a(View view) {
            QQVasGiftComboSendView.this.G();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements LongClickHandler.c {
        b() {
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void a(View view) {
            QQVasGiftComboSendView.this.D();
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void b(View view) {
            QQVasGiftComboSendView.this.E();
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void c(View view) {
            QQVasGiftComboSendView.this.F();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements ApngDrawable.OnPlayRepeatListener {
        c() {
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            QQVasGiftComboSendView.this.M.c(1);
            QQVasGiftComboSendView.this.x(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements ApngDrawable.OnPlayRepeatListener {
        d() {
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            QQVasGiftComboSendView.this.M.c(2);
            QQVasGiftComboSendView.this.x(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements ApngDrawable.OnPlayRepeatListener {
        e() {
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            QQVasGiftComboSendView.this.p();
            QQVasGiftComboSendView.this.M.c(3);
            QQVasGiftComboSendView.this.x(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class f implements ApngDrawable.OnPlayRepeatListener {
        f() {
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            QQVasGiftComboSendView.this.M.f312077a = false;
            QQVasGiftComboSendView.this.y();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f312077a = false;

        /* renamed from: b, reason: collision with root package name */
        private boolean f312078b = true;

        /* renamed from: c, reason: collision with root package name */
        public int f312079c = 1;

        /* renamed from: d, reason: collision with root package name */
        public volatile boolean f312080d = false;

        /* renamed from: e, reason: collision with root package name */
        public volatile boolean f312081e = false;

        /* renamed from: f, reason: collision with root package name */
        public volatile boolean f312082f = false;

        public boolean b() {
            if (!this.f312078b) {
                return false;
            }
            int i3 = this.f312079c;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return true;
                    }
                    return !this.f312082f;
                }
                return !this.f312081e;
            }
            return !this.f312080d;
        }

        public void c(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.f312082f = false;
                        return;
                    }
                    return;
                }
                this.f312081e = false;
                return;
            }
            this.f312080d = false;
        }

        public void d(int i3) {
            this.f312079c = i3;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.f312082f = true;
                        return;
                    }
                    return;
                }
                this.f312081e = true;
                return;
            }
            this.f312080d = true;
        }
    }

    public QQVasGiftComboSendView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        int i3;
        ph2.b bVar = this.f312062d;
        if (bVar != null && (i3 = this.f312067m) > 0) {
            bVar.c(i3, this.f312063e, false);
        }
        this.f312067m = 0;
    }

    private void B(boolean z16) {
        if (this.f312063e == this.f312065h) {
            if (this.P) {
                return;
            }
            this.P = true;
            ph2.b bVar = this.f312062d;
            if (bVar != null) {
                bVar.e();
            }
            x(true);
            QLog.d("QQVasGiftComboSendView", 1, "send_combo: onGetMaxNum " + this.f312063e + " " + this.f312067m);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQVasGiftComboSendView", 1, "send_combo: " + this.f312063e + " " + this.f312067m + " " + z16 + " " + this.M.f312082f + " " + this.M.f312077a);
        }
        if (this.M.f312082f) {
            if (this.M.f312077a) {
                return;
            }
            O();
            v();
            M(false);
            if (z16) {
                this.M.f312082f = false;
                p();
                I();
                return;
            }
            return;
        }
        int i3 = this.f312063e;
        if (i3 != 10 && i3 != 50 && i3 != 100) {
            O();
            v();
            if (z16) {
                M(true);
                I();
                return;
            } else {
                M(false);
                H();
                return;
            }
        }
        if (this.M.f312082f) {
            return;
        }
        N();
        J();
    }

    private void C() {
        BannerResManager bannerResManager = this.K;
        if (bannerResManager != null) {
            this.L = bannerResManager.s(this.f312064f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.M.f312078b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.M.f312078b = false;
        B(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        B(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        B(true);
    }

    private void H() {
        w(true);
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("hold", o(this.J, true, this.R), this.L.f312098b);
        m(apngURLDrawable, this.R);
        this.J.setImageDrawable(apngURLDrawable);
        this.M.d(2);
    }

    private void I() {
        w(true);
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("click", o(this.J, false, this.Q), this.L.f312097a);
        m(apngURLDrawable, this.Q);
        this.J.setImageDrawable(apngURLDrawable);
        this.M.d(1);
    }

    private void J() {
        w(true);
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("trans", o(this.J, true, this.S), this.L.f312099c);
        m(apngURLDrawable, this.S);
        this.J.setImageDrawable(apngURLDrawable);
        this.M.d(3);
    }

    private void K(ObjectAnimator objectAnimator) {
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            objectAnimator.cancel();
        }
    }

    private void M(boolean z16) {
        this.D.setVisibility(8);
        this.E.setVisibility(0);
        int i3 = this.f312063e;
        if (i3 < 10) {
            this.G.setVisibility(0);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setImageDrawable(u(this.f312063e));
        } else if (i3 < 100) {
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.I.setVisibility(8);
            this.G.setImageDrawable(u(this.f312063e / 10));
            this.H.setImageDrawable(u(this.f312063e % 10));
        } else if (i3 < 1000) {
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.I.setVisibility(0);
            this.G.setImageDrawable(u(this.f312063e / 100));
            this.H.setImageDrawable(u((this.f312063e % 100) / 10));
            this.I.setImageDrawable(u((this.f312063e % 100) % 10));
        } else {
            return;
        }
        this.F.setImageDrawable(u(10));
        if (z16) {
            r(this.E);
        } else {
            z(this.E);
        }
    }

    private void N() {
        this.E.setVisibility(8);
        this.D.setVisibility(0);
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("title", o(this.D, true, this.T), this.L.f312100d);
        m(apngURLDrawable, this.T);
        this.D.setImageDrawable(apngURLDrawable);
        this.M.f312077a = true;
    }

    private void O() {
        this.f312063e++;
        this.f312067m++;
        this.J.performHapticFeedback(0, 2);
    }

    private void m(URLDrawable uRLDrawable, ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setOnPlayRepeatListener(onPlayRepeatListener);
            }
        }
    }

    private ApngOptions o(ImageView imageView, boolean z16, ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        WeakReference weakReference = new WeakReference(imageView);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setUseCache(z16);
        apngOptions.setLoadListener(new g(onPlayRepeatListener, weakReference));
        return apngOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        int t16 = t();
        if (t16 != this.f312064f) {
            this.f312064f = t16;
            C();
        }
    }

    private void q() {
        ph2.b bVar;
        if (!this.L.a() && (bVar = this.f312062d) != null) {
            bVar.i();
            QLog.d("QQVasGiftComboSendView", 1, "send_combo: resource error\uff01\uff01\uff01 " + this.f312063e + " " + this.f312067m);
        }
    }

    private void r(LinearLayout linearLayout) {
        try {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.SCALE_X, 0.5f, 1.2f, 0.8f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.SCALE_Y, 0.5f, 1.2f, 0.8f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.TRANSLATION_Y, 40.0f, 0.0f);
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.ALPHA, 0.5f, 1.0f, 0.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, ofFloat3, ofFloat, ofFloat2);
            this.U = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(300L);
            this.U.start();
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(linearLayout, ofFloat4);
            this.V = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setDuration(2000L);
            this.V.start();
        } catch (Throwable th5) {
            QLog.e("QQVasGiftComboSendView", 1, th5, new Object[0]);
        }
    }

    private int t() {
        int i3 = this.f312063e;
        if (i3 < 10) {
            return 1;
        }
        if (i3 < 50) {
            return 2;
        }
        if (i3 < 100) {
            return 3;
        }
        return 4;
    }

    private URLDrawable u(int i3) {
        String str = this.L.f312101e.get(Integer.valueOf(i3));
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), str);
        }
        return null;
    }

    private void v() {
        ph2.b bVar = this.f312062d;
        if (bVar != null) {
            bVar.s(this.f312063e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f312063e == this.f312065h) {
            A();
        } else if (currentTimeMillis - this.f312066i > this.N) {
            this.f312066i = currentTimeMillis;
            ThreadManager.b(new DelaySendRunnable(), this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16) {
        if ((!z16 && !this.M.b()) || this.f312062d == null) {
            return;
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.QQVasGiftComboSendView.9
            @Override // java.lang.Runnable
            public void run() {
                QQVasGiftComboSendView.this.f312062d.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.QQVasGiftComboSendView.8
            @Override // java.lang.Runnable
            public void run() {
                QQVasGiftComboSendView.this.D.setVisibility(8);
            }
        });
    }

    private void z(View view) {
        try {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.SCALE_X, 0.5f, 1.0f, 0.8f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.SCALE_Y, 0.5f, 1.0f, 0.8f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.TRANSLATION_Y, 40.0f, 0.0f);
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.ALPHA, 0.5f, 1.0f, 1.0f, 0.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat3, ofFloat, ofFloat2);
            this.W = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(200L);
            this.W.start();
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat4);
            this.f312061a0 = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setDuration(1000L);
            this.f312061a0.start();
        } catch (Throwable th5) {
            QLog.e("QQVasGiftComboSendView", 1, th5, new Object[0]);
        }
    }

    public void L() {
        this.C.g();
        this.f312064f = -1;
        this.f312063e = 0;
        this.f312067m = 0;
        K(this.U);
        K(this.V);
        K(this.W);
        K(this.f312061a0);
    }

    public void P(int i3, int i16) {
        if (i3 > i16) {
            QLog.e("QQVasGiftComboSendView", 1, "initCombo > maxCombo");
            return;
        }
        this.f312063e = i3;
        this.f312065h = i16;
        this.f312067m = -1;
        this.P = false;
        p();
        B(true);
        q();
    }

    @Override // com.tencent.mobileqq.vasgift.view.anim.g
    public void a() {
        A();
        ph2.b bVar = this.f312062d;
        if (bVar != null) {
            bVar.b(this.f312063e);
        }
    }

    public void n(BannerResManager bannerResManager) {
        this.K = bannerResManager;
    }

    public int s() {
        return this.f312063e;
    }

    public void setComboListener(ph2.b bVar) {
        this.f312062d = bVar;
    }

    public void setSendDelayTime(int i3) {
        if (i3 > 0) {
            this.N = i3;
        }
    }

    public void w(boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        setVisibility(i3);
    }

    public QQVasGiftComboSendView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.f312063e = 0;
        this.f312064f = -1;
        this.f312065h = Integer.MAX_VALUE;
        this.f312066i = 0L;
        this.f312067m = 0;
        this.L = new com.tencent.mobileqq.vasgift.view.anim.c();
        this.M = new h();
        this.N = 1000;
        this.P = false;
        this.Q = new c();
        this.R = new d();
        this.S = new e();
        this.T = new f();
        LayoutInflater.from(context).inflate(R.layout.h8v, (ViewGroup) this, true);
        this.D = (ImageView) findViewById(R.id.f113356qe);
        this.E = (LinearLayout) findViewById(R.id.zvp);
        this.F = (ImageView) findViewById(R.id.xep);
        this.G = (ImageView) findViewById(R.id.zvq);
        this.H = (ImageView) findViewById(R.id.zvt);
        this.I = (ImageView) findViewById(R.id.zvs);
        this.J = (ImageView) findViewById(R.id.send_btn);
        ToggleProxy toggleProxy = VasToggle.VAS_LIVE_GIFT_TIME_CONFIG;
        if (toggleProxy.isEnable(false)) {
            String stringDataSet = toggleProxy.getStringDataSet("click_delay", String.valueOf(200));
            String stringDataSet2 = toggleProxy.getStringDataSet("request_delay", String.valueOf(1000));
            i3 = stringDataSet != null ? Integer.parseInt(stringDataSet) : 200;
            if (stringDataSet2 != null) {
                this.N = Integer.parseInt(stringDataSet2);
            }
        } else {
            i3 = 200;
        }
        View findViewById = findViewById(R.id.f83084im);
        findViewById.setOnClickListener(new a(i3));
        LongClickHandler longClickHandler = new LongClickHandler(findViewById);
        this.C = longClickHandler;
        longClickHandler.h(new b(), 200);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class g implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ApngDrawable.OnPlayRepeatListener f312074d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference f312075e;

        g(ApngDrawable.OnPlayRepeatListener onPlayRepeatListener, WeakReference weakReference) {
            this.f312074d = onPlayRepeatListener;
            this.f312075e = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setOnPlayRepeatListener(this.f312074d);
            }
            if (this.f312075e.get() != 0) {
                ((ImageView) this.f312075e.get()).setImageDrawable(uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}

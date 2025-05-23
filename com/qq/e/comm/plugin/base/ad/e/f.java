package com.qq.e.comm.plugin.base.ad.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.TGEPI;
import com.qq.e.comm.pi.TangramExposureCallback;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f implements TGEPI {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<TangramExposureCallback> f38803b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<View> f38804c;

    /* renamed from: d, reason: collision with root package name */
    private c f38805d;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f38811j;

    /* renamed from: k, reason: collision with root package name */
    private String f38812k;

    /* renamed from: a, reason: collision with root package name */
    private a f38802a = null;

    /* renamed from: e, reason: collision with root package name */
    private final long f38806e = 200;

    /* renamed from: f, reason: collision with root package name */
    private boolean f38807f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38808g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38809h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f38810i = 1;

    /* renamed from: l, reason: collision with root package name */
    private b f38813l = new b(200) { // from class: com.qq.e.comm.plugin.base.ad.e.f.5
        @Override // com.qq.e.comm.plugin.base.ad.e.f.b
        void a() {
            if ((f.this.f38804c != null && f.this.f38804c.get() != null && !h.b((View) f.this.f38804c.get()) && f.this.f38809h) || f.this.f38804c == null || f.this.f38804c.get() == null) {
                GDTLogger.d("onScrollChangedOverDuration view invisible");
                f.this.d();
            }
            if (f.this.f38804c != null && f.this.f38804c.get() != null) {
                f fVar = f.this;
                fVar.f38809h = h.b((View) fVar.f38804c.get());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private int f38821b;

        /* renamed from: c, reason: collision with root package name */
        private final int f38822c;

        /* renamed from: d, reason: collision with root package name */
        private final int f38823d;

        a() {
            this.f38821b = 0;
            this.f38822c = com.qq.e.comm.plugin.j.c.a((String) null, "exposureCheckTimes", 5);
            this.f38823d = com.qq.e.comm.plugin.j.c.a((String) null, "exposureCheckAreaPercent", 50);
        }

        private boolean a() {
            String str;
            GDTLogger.d("print check params limitTimes = " + this.f38822c + ", areaPercent = " + this.f38823d);
            if (f.this.f38811j != null && e.a().a(f.this.f38812k)) {
                GDTLogger.d("trace id is already exposured " + f.this.f38812k);
                f.this.d();
                return false;
            }
            boolean z16 = true;
            if (f.this.f38804c != null && f.this.f38804c.get() != null && !f.this.f38808g && f.this.f38807f && f.this.f38803b != null && f.this.f38803b.get() != null && f.this.f38810i == 2) {
                if (h.a((View) f.this.f38804c.get()) < this.f38823d / 100.0f) {
                    this.f38821b = 0;
                    return false;
                }
                if (this.f38821b >= this.f38822c) {
                    e a16 = e.a();
                    Context appContext = GDTADManager.getInstance().getAppContext();
                    if (f.this.f38811j != null) {
                        str = f.this.f38812k;
                    } else {
                        str = null;
                    }
                    a16.a(appContext, str);
                    ((TangramExposureCallback) f.this.f38803b.get()).onExposure(f.this.f38804c);
                    f.this.f38810i = 3;
                    f.this.d();
                }
                this.f38821b++;
                return true;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("check failed : isViewDestroyed ");
            sb5.append(f.this.f38808g);
            sb5.append(" isViewOnForeground ");
            sb5.append(f.this.f38807f);
            sb5.append(" status ");
            sb5.append(f.this.f38810i);
            sb5.append(" no callback :");
            if (f.this.f38803b != null && f.this.f38803b.get() != null) {
                z16 = false;
            }
            sb5.append(z16);
            GDTLogger.d(sb5.toString());
            f.this.d();
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            aa.a(f.this.f38802a, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public abstract class b implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a, reason: collision with root package name */
        private long f38824a;

        /* renamed from: c, reason: collision with root package name */
        private long f38826c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f38827d = new Object();

        b(long j3) {
            this.f38826c = j3;
        }

        abstract void a();

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            synchronized (this.f38827d) {
                if (this.f38824a == 0) {
                    this.f38824a = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f38824a >= this.f38826c) {
                    a();
                    this.f38824a = currentTimeMillis;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.a();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.b();
        }
    }

    public f(JSONObject jSONObject, WeakReference<TangramExposureCallback> weakReference) {
        this.f38803b = null;
        this.f38805d = null;
        this.f38811j = jSONObject;
        if (y.a(jSONObject)) {
            this.f38812k = jSONObject.optString("traceid");
        }
        this.f38803b = weakReference;
        this.f38805d = new c();
        e.a().a(GDTADManager.getInstance().getAppContext());
    }

    @Override // com.qq.e.comm.pi.TGEPI
    public void onExposureDestroy() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.f.3
            @Override // java.lang.Runnable
            public void run() {
                f.this.f38808g = true;
                f.this.c();
            }
        });
    }

    @Override // com.qq.e.comm.pi.TGEPI
    public void onExposurePause() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.f38807f = false;
                f.this.b();
            }
        });
    }

    @Override // com.qq.e.comm.pi.TGEPI
    public void onExposureResume() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.f38807f = true;
                f.this.a();
            }
        });
    }

    @Override // com.qq.e.comm.pi.TGEPI
    public void startCheck(WeakReference<View> weakReference) {
        GDTLogger.d("start check");
        this.f38804c = weakReference;
        if (weakReference != null && weakReference.get() != null && this.f38811j != null && this.f38810i != 2 && this.f38804c.get().getViewTreeObserver() != null) {
            weakReference.get().getViewTreeObserver().addOnScrollChangedListener(this.f38813l);
            weakReference.get().addOnAttachStateChangeListener(this.f38805d);
            if (this.f38802a == null) {
                this.f38802a = new a();
            }
            this.f38809h = h.b(weakReference.get());
            this.f38810i = 2;
            aa.a(this.f38802a);
            return;
        }
        GDTLogger.d("startCheck fail: " + this.f38810i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a aVar = this.f38802a;
        if (aVar != null) {
            aa.b(aVar);
            this.f38802a = null;
        }
        WeakReference<View> weakReference = this.f38804c;
        if (weakReference != null && weakReference.get() != null) {
            this.f38804c.get().removeOnAttachStateChangeListener(this.f38805d);
            this.f38804c.get().getViewTreeObserver().removeOnScrollChangedListener(this.f38813l);
        }
        this.f38810i = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        WeakReference<View> weakReference = this.f38804c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        WeakReference<View> weakReference = this.f38804c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        d();
        this.f38804c = null;
        this.f38811j = null;
        this.f38812k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        WeakReference<View> weakReference = this.f38804c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        startCheck(this.f38804c);
    }

    public static void a(final JSONObject jSONObject, final WeakReference<TangramExposureCallback> weakReference) {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.f.4
            @Override // java.lang.Runnable
            public void run() {
                WeakReference weakReference2;
                JSONObject jSONObject2;
                Context appContext = GDTADManager.getInstance().getAppContext();
                if (appContext != null && (weakReference2 = weakReference) != null && weakReference2.get() != null && (jSONObject2 = jSONObject) != null && !TextUtils.isEmpty(jSONObject2.optString("traceid"))) {
                    if (!e.a().a(jSONObject.optString("traceid"))) {
                        e.a().a(appContext, jSONObject.optString("traceid"));
                        ((TangramExposureCallback) weakReference.get()).onExposure(null);
                        return;
                    }
                    return;
                }
                GDTLogger.d("onClick error");
            }
        });
    }
}

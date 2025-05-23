package com.tencent.ams.mosaic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.ams.mosaic.load.QuickJSSoLoader;
import com.tencent.ams.mosaic.load.b;
import com.tencent.ams.mosaic.utils.DefaultVideoLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;
    private static final f C;
    private b.a A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    private c f70623a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0685f f70624b;

    /* renamed from: c, reason: collision with root package name */
    private a f70625c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f70626d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70627e;

    /* renamed from: f, reason: collision with root package name */
    private String f70628f;

    /* renamed from: g, reason: collision with root package name */
    private String f70629g;

    /* renamed from: h, reason: collision with root package name */
    private e f70630h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f70631i;

    /* renamed from: j, reason: collision with root package name */
    private float f70632j;

    /* renamed from: k, reason: collision with root package name */
    private float f70633k;

    /* renamed from: l, reason: collision with root package name */
    private String f70634l;

    /* renamed from: m, reason: collision with root package name */
    private final Map<com.tencent.ams.mosaic.jsengine.a, IMosaicDownloadManager> f70635m;

    /* renamed from: n, reason: collision with root package name */
    private IMosaicDownloadManager f70636n;

    /* renamed from: o, reason: collision with root package name */
    private String f70637o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.ams.mosaic.b f70638p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f70639q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f70640r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f70641s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f70642t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f70643u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f70644v;

    /* renamed from: w, reason: collision with root package name */
    private int f70645w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f70646x;

    /* renamed from: y, reason: collision with root package name */
    private b f70647y;

    /* renamed from: z, reason: collision with root package name */
    private Class<? extends com.tencent.ams.mosaic.jsengine.component.video.a> f70648z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void execute(Runnable runnable);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        Uri a(Context context, File file, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public interface a {
            void onLoadFinish(Object obj);

            void onLoadStart();
        }

        void loadImage(String str, a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d extends c {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public interface a extends c.a {
        }

        void a(String str, a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface e {
        void d(String str, String str2);

        void e(String str, String str2, Throwable th5);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th5);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.f$f, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0685f {

        /* compiled from: P */
        /* renamed from: com.tencent.ams.mosaic.f$f$a */
        /* loaded from: classes3.dex */
        public interface a {
            void onLoadFinish(String str);

            void onLoadStart();
        }

        void loadVideo(String str, a aVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 64)) {
            redirector.redirect((short) 64);
        } else {
            C = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70626d = false;
        this.f70627e = false;
        this.f70633k = 1.0f;
        this.f70635m = new HashMap();
        this.f70645w = -19;
        this.B = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(Runnable runnable) {
        com.tencent.ams.mosaic.utils.g.b().a().execute(runnable);
    }

    public static f k() {
        return C;
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return this.f70641s;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        return this.f70644v;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        return this.B;
    }

    public void E(String str, Class<? extends Component> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) cls);
        } else {
            ComponentFactory.a(str, cls);
        }
    }

    public synchronized void F(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) aVar);
        } else {
            this.f70635m.remove(aVar);
        }
    }

    public void G(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
        } else {
            this.f70625c = aVar;
        }
    }

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f70626d = z16;
        }
    }

    public void I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f70629g = str;
        }
    }

    public void J(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f70627e = z16;
        }
    }

    public synchronized void K(com.tencent.ams.mosaic.jsengine.a aVar, IMosaicDownloadManager iMosaicDownloadManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) aVar, (Object) iMosaicDownloadManager);
        } else {
            this.f70635m.put(aVar, iMosaicDownloadManager);
        }
    }

    public void L(IMosaicDownloadManager iMosaicDownloadManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) iMosaicDownloadManager);
        } else {
            this.f70636n = iMosaicDownloadManager;
        }
    }

    public void M(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) eVar);
        } else {
            this.f70630h = eVar;
        }
    }

    public void N(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) aVar);
        } else {
            this.A = aVar;
        }
    }

    public void O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        } else {
            this.f70634l = str;
        }
    }

    public boolean P(Context context, List<com.tencent.ams.mosaic.load.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) context, (Object) list)).booleanValue();
        }
        return QuickJSSoLoader.getInstance().setSoConfigs(context, list);
    }

    public void Q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
        } else {
            this.f70644v = z16;
        }
    }

    public void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        } else {
            this.B = z16;
        }
    }

    public a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (a) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (this.f70625c == null) {
            this.f70625c = new a() { // from class: com.tencent.ams.mosaic.e
                @Override // com.tencent.ams.mosaic.f.a
                public final void execute(Runnable runnable) {
                    f.D(runnable);
                }
            };
        }
        return this.f70625c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (TextUtils.isEmpty(this.f70629g)) {
            return DKEngine.DKModuleID.SPLASH_MOSAIC;
        }
        return this.f70629g;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f70628f;
    }

    public IMosaicDownloadManager e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (IMosaicDownloadManager) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.f70636n;
    }

    public synchronized IMosaicDownloadManager f(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (IMosaicDownloadManager) iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar);
        }
        IMosaicDownloadManager iMosaicDownloadManager = this.f70635m.get(aVar);
        if (iMosaicDownloadManager == null) {
            return this.f70636n;
        }
        return iMosaicDownloadManager;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.f70637o;
    }

    public b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (b) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.f70647y;
    }

    public Map<String, Object> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Map) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f70631i;
    }

    @NonNull
    public c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f70623a == null) {
            this.f70623a = new com.tencent.ams.mosaic.utils.e();
        }
        return this.f70623a;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Integer) iPatchRedirector.redirect((short) 61, (Object) this)).intValue();
        }
        return this.f70645w;
    }

    public e m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (e) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f70630h;
    }

    public b.a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (b.a) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        return this.A;
    }

    public com.tencent.ams.mosaic.b o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (com.tencent.ams.mosaic.b) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.f70638p;
    }

    public float p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Float) iPatchRedirector.redirect((short) 29, (Object) this)).floatValue();
        }
        return this.f70632j;
    }

    public float q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Float) iPatchRedirector.redirect((short) 31, (Object) this)).floatValue();
        }
        float f16 = this.f70633k;
        if (f16 == 0.0f) {
            return 1.0f;
        }
        return f16;
    }

    public Class<? extends com.tencent.ams.mosaic.jsengine.component.video.a> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Class) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.f70648z;
    }

    @NonNull
    public InterfaceC0685f s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (InterfaceC0685f) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f70624b == null) {
            this.f70624b = new DefaultVideoLoader();
        }
        return this.f70624b;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return this.f70639q;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f70626d;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f70627e;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.f70642t;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        return this.f70646x;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        return this.f70643u;
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.f70640r;
    }
}

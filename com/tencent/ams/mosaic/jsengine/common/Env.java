package com.tencent.ams.mosaic.jsengine.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.DisplayCutout;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.ams.mosaic.MosaicView;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.ams.mosaic.utils.g;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Env implements IEnv {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static String f70780f;

    /* renamed from: g, reason: collision with root package name */
    private static String f70781g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f70782a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.a f70783b;

    /* renamed from: c, reason: collision with root package name */
    private final MosaicView f70784c;

    /* renamed from: d, reason: collision with root package name */
    private final List<com.tencent.ams.mosaic.a> f70785d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f70786e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Env.this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.Env.d
        public void a(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            } else {
                Env.this.stopTimer(cVar.a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements com.tencent.ams.mosaic.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSValue f70794d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSValue f70795e;

        b(JSValue jSValue, JSValue jSValue2) {
            this.f70794d = jSValue;
            this.f70795e = jSValue2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Env.this, jSValue, jSValue2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends CountDownTimer {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final JSFunction f70797a;

        /* renamed from: b, reason: collision with root package name */
        private final d f70798b;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements a.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.ams.mosaic.jsengine.a.b
            public void onFail(JSFunction jSFunction) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
                } else {
                    c cVar = c.this;
                    Env.this.stopTimer(cVar.a());
                }
            }

            @Override // com.tencent.ams.mosaic.jsengine.a.b
            public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
                }
            }
        }

        public c(Env env, int i3, boolean z16, JSFunction jSFunction) {
            this(i3, z16, jSFunction, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, env, Integer.valueOf(i3), Boolean.valueOf(z16), jSFunction);
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "LoopTimer#" + Integer.toHexString(hashCode());
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            d dVar = this.f70798b;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            if (this.f70797a != null) {
                if (Env.this.f70783b.isClosed()) {
                    f.h("Env", "LoopTimer onTick: engine is closed");
                    Env.this.stopTimer(a());
                } else {
                    Env.this.f70783b.u(this.f70797a, null, new a());
                }
            }
        }

        public c(int i3, boolean z16, JSFunction jSFunction, d dVar) {
            super(z16 ? Long.MAX_VALUE : i3, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Env.this, Integer.valueOf(i3), Boolean.valueOf(z16), jSFunction, dVar);
            } else {
                this.f70797a = jSFunction;
                this.f70798b = dVar;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface d {
        void a(c cVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            f70780f = "Android";
        }
    }

    public Env(@NonNull Context context, @NonNull com.tencent.ams.mosaic.jsengine.a aVar, @NonNull MosaicView mosaicView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, mosaicView);
            return;
        }
        this.f70785d = new ArrayList();
        this.f70786e = new ConcurrentHashMap();
        this.f70782a = context;
        this.f70783b = aVar;
        this.f70784c = mosaicView;
    }

    public static void d(String str) {
        f70780f = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public void addAppLifeCycleListenerDict(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) jSObject);
            return;
        }
        if (jSObject == null) {
            f.h("Env", "addAppLifeCycleListenerDict failed: null listenerDict");
            return;
        }
        b bVar = new b(jSObject.getProperty("AppEnterForeground"), jSObject.getProperty("AppEnterBackground"));
        this.f70785d.add(bVar);
        MosaicManager.j().d(bVar);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        f.a("Env", "recycle");
        Iterator<String> it = this.f70786e.keySet().iterator();
        while (it.hasNext()) {
            stopTimer(it.next());
        }
        this.f70786e.clear();
        Iterator<com.tencent.ams.mosaic.a> it5 = this.f70785d.iterator();
        while (it5.hasNext()) {
            MosaicManager.j().m(it5.next());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public float dp2px(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16))).floatValue();
        }
        return MosaicUtils.j(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public int getAppState() {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        f.e("Env", "getAppState");
        Context i3 = MosaicManager.j().i();
        if (i3 == null) {
            return 0;
        }
        try {
            activityManager = (ActivityManager) i3.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } catch (Throwable unused) {
        }
        if (activityManager == null) {
            return 0;
        }
        String packageName = i3.getPackageName();
        if (!TextUtils.isEmpty(packageName) && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.processName.equals(packageName)) {
                    int i16 = runningAppProcessInfo.importance;
                    if (i16 != 100) {
                        if (i16 != 200 && i16 != 230) {
                            return 3;
                        }
                        return 2;
                    }
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public String getClipboardData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        f.e("Env", "getClipboardData success: " + f70781g);
        String str = f70781g;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public JSValue getGlobalInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (JSValue) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        com.tencent.ams.mosaic.jsengine.a aVar = this.f70783b;
        if (aVar == null) {
            return null;
        }
        return e.h(aVar.l(), com.tencent.ams.mosaic.f.k().i());
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public String getPlatform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (TextUtils.isEmpty(f70780f)) {
            return "Android";
        }
        return f70780f;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:13|14)|(2:16|(8:18|(7:20|22|23|24|25|26|27)(1:47)|(1:29)(2:35|36)|30|31|32|11|12))|48|(0)(0)|(0)(0)|30|31|32|11|12) */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #1 {all -> 0x00a2, blocks: (B:14:0x0024, B:16:0x0035, B:20:0x0044), top: B:13:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005d  */
    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSObject getSafeAreaInsets() {
        DisplayCutout displayCutout;
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        int safeInsetTop;
        List boundingRects;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (JSObject) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        JSObject createJSObject = this.f70783b.l().createJSObject();
        int i19 = 0;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                displayCutout = this.f70784c.getView().getRootWindowInsets().getDisplayCutout();
            } catch (Throwable unused) {
            }
            if (displayCutout != null) {
                boundingRects = displayCutout.getBoundingRects();
                if (boundingRects.size() != 0) {
                    z16 = true;
                    if (!z16) {
                        i3 = displayCutout.getSafeInsetTop();
                        try {
                            i16 = displayCutout.getSafeInsetRight();
                        } catch (Throwable unused2) {
                            i16 = 0;
                            i17 = 0;
                        }
                        try {
                            i17 = displayCutout.getSafeInsetBottom();
                        } catch (Throwable unused3) {
                            i17 = 0;
                            i18 = i17;
                            i19 = i3;
                            createJSObject.setProperty("top", this.f70783b.l().createJSNumber(i19));
                            createJSObject.setProperty("right", this.f70783b.l().createJSNumber(i16));
                            createJSObject.setProperty("bottom", this.f70783b.l().createJSNumber(i17));
                            createJSObject.setProperty("left", this.f70783b.l().createJSNumber(i18));
                            return createJSObject;
                        }
                        try {
                            i18 = displayCutout.getSafeInsetLeft();
                        } catch (Throwable unused4) {
                            i18 = 0;
                            i19 = i3;
                            createJSObject.setProperty("top", this.f70783b.l().createJSNumber(i19));
                            createJSObject.setProperty("right", this.f70783b.l().createJSNumber(i16));
                            createJSObject.setProperty("bottom", this.f70783b.l().createJSNumber(i17));
                            createJSObject.setProperty("left", this.f70783b.l().createJSNumber(i18));
                            return createJSObject;
                        }
                    } else {
                        i3 = 0;
                        i16 = 0;
                        i17 = 0;
                        i18 = 0;
                    }
                    if (displayCutout == null) {
                        try {
                            safeInsetTop = displayCutout.getSafeInsetTop();
                        } catch (Throwable unused5) {
                            i19 = i3;
                            createJSObject.setProperty("top", this.f70783b.l().createJSNumber(i19));
                            createJSObject.setProperty("right", this.f70783b.l().createJSNumber(i16));
                            createJSObject.setProperty("bottom", this.f70783b.l().createJSNumber(i17));
                            createJSObject.setProperty("left", this.f70783b.l().createJSNumber(i18));
                            return createJSObject;
                        }
                    } else {
                        safeInsetTop = 0;
                    }
                    f.a("Env", String.format(Locale.getDefault(), "is notch = %s, top = %d, right = %d, bottom = %d, left = %d", Boolean.valueOf(z16), Integer.valueOf(safeInsetTop), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
                    i19 = safeInsetTop;
                    createJSObject.setProperty("top", this.f70783b.l().createJSNumber(i19));
                    createJSObject.setProperty("right", this.f70783b.l().createJSNumber(i16));
                    createJSObject.setProperty("bottom", this.f70783b.l().createJSNumber(i17));
                    createJSObject.setProperty("left", this.f70783b.l().createJSNumber(i18));
                    return createJSObject;
                }
            }
            z16 = false;
            if (!z16) {
            }
            if (displayCutout == null) {
            }
            f.a("Env", String.format(Locale.getDefault(), "is notch = %s, top = %d, right = %d, bottom = %d, left = %d", Boolean.valueOf(z16), Integer.valueOf(safeInsetTop), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
            i19 = safeInsetTop;
            createJSObject.setProperty("top", this.f70783b.l().createJSNumber(i19));
            createJSObject.setProperty("right", this.f70783b.l().createJSNumber(i16));
            createJSObject.setProperty("bottom", this.f70783b.l().createJSNumber(i17));
            createJSObject.setProperty("left", this.f70783b.l().createJSNumber(i18));
            return createJSObject;
        }
        i16 = 0;
        i17 = 0;
        i18 = 0;
        createJSObject.setProperty("top", this.f70783b.l().createJSNumber(i19));
        createJSObject.setProperty("right", this.f70783b.l().createJSNumber(i16));
        createJSObject.setProperty("bottom", this.f70783b.l().createJSNumber(i17));
        createJSObject.setProperty("left", this.f70783b.l().createJSNumber(i18));
        return createJSObject;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public int getScreenHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        Context context = this.f70782a;
        if (context == null) {
            return 0;
        }
        return (int) MosaicUtils.E(MosaicUtils.o(context));
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public int getScreenWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        Context context = this.f70782a;
        if (context == null) {
            return 0;
        }
        return (int) MosaicUtils.E(MosaicUtils.p(context));
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public float px2dp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16))).floatValue();
        }
        return MosaicUtils.E(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    @Deprecated
    public void runOnAsyncThread(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) jSFunction);
        } else if (jSFunction != null && this.f70783b != null) {
            MosaicUtils.F(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.Env.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70792d;

                {
                    this.f70792d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Env.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        Env.this.f70783b.p(this.f70792d, null, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    @Deprecated
    public void runOnUIThread(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) jSFunction);
        } else if (jSFunction != null && this.f70783b != null) {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.Env.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70790d;

                {
                    this.f70790d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Env.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        Env.this.f70783b.p(this.f70790d, null, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    @Deprecated
    public void runOnUIThreadDelay(JSFunction jSFunction, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, jSFunction, Long.valueOf(j3));
        } else if (jSFunction != null && this.f70783b != null) {
            MosaicUtils.J(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.Env.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70791d;

                {
                    this.f70791d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Env.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        Env.this.f70783b.p(this.f70791d, null, null);
                    }
                }
            }, j3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public String scheduledTimer(int i3, boolean z16, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), jSFunction);
        }
        c cVar = new c(this, i3, z16, jSFunction);
        String a16 = cVar.a();
        f.a("Env", "scheduledTimer: " + a16 + ", intervalInMs: " + i3 + ", repeats: " + z16);
        if (a16 == null) {
            return null;
        }
        this.f70786e.put(a16, cVar);
        cVar.start();
        return a16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public String scheduledTimerDelay(int i3, int i16, boolean z16, JSFunction jSFunction) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), jSFunction);
        }
        if (this.f70783b == null) {
            return null;
        }
        if (!z16 && i16 == 0) {
            i17 = 1000;
        } else {
            i17 = i16;
        }
        c cVar = new c(i17, z16, jSFunction, new a());
        String a16 = cVar.a();
        f.a("Env", "scheduledTimerDelay: " + a16 + ", startDelayInMs: " + i3 + ", intervalInMs: " + i16 + ", repeats: " + z16);
        if (a16 == null) {
            return null;
        }
        this.f70786e.put(a16, cVar);
        this.f70783b.i(new Runnable(a16) { // from class: com.tencent.ams.mosaic.jsengine.common.Env.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f70787d;

            {
                this.f70787d = a16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Env.this, (Object) a16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Object obj = Env.this.f70786e.get(this.f70787d);
                if (obj instanceof c) {
                    ((c) obj).start();
                }
            }
        }, i3);
        return a16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public String scheduledTimerDelayInAsyncThread(int i3, int i16, boolean z16, JSFunction jSFunction) {
        ScheduledFuture<?> schedule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), jSFunction);
        }
        if (jSFunction == null || this.f70783b == null) {
            return null;
        }
        Runnable runnable = new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.Env.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ JSFunction f70788d;

            {
                this.f70788d = jSFunction;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Env.this, (Object) jSFunction);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    Env.this.f70783b.u(this.f70788d, null, null);
                }
            }
        };
        if (z16) {
            schedule = g.b().c().scheduleAtFixedRate(runnable, i3, i16, TimeUnit.MILLISECONDS);
        } else {
            schedule = g.b().c().schedule(runnable, i3, TimeUnit.MILLISECONDS);
        }
        String obj = schedule.toString();
        this.f70786e.put(obj, schedule);
        return obj;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public String scheduledTimerInAsyncThread(int i3, boolean z16, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), jSFunction);
        }
        return scheduledTimerDelayInAsyncThread(0, i3, z16, jSFunction);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public void setClipboardData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        f.e("Env", "setClipboardData success: " + str);
        f70781g = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public void setUseFastImageView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            com.tencent.ams.mosaic.f.k().Q(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IEnv
    public void stopTimer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Object remove = this.f70786e.remove(str);
            f.a("Env", "stopTimer: " + str + ", timer: " + remove);
            if (remove instanceof c) {
                Runnable runnable = new Runnable(remove) { // from class: com.tencent.ams.mosaic.jsengine.common.Env.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Object f70789d;

                    {
                        this.f70789d = remove;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Env.this, remove);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ((c) this.f70789d).cancel();
                        }
                    }
                };
                if (com.tencent.ams.mosaic.f.k().x()) {
                    MosaicUtils.F(runnable);
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
            if (remove instanceof ScheduledFuture) {
                ((ScheduledFuture) remove).cancel(false);
            }
        }
    }
}

package com.tencent.trackrecordlib.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trackrecordlib.d.a.e;
import com.tencent.trackrecordlib.g.f;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RecordManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final String f381002c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f381003d;

    /* renamed from: a, reason: collision with root package name */
    public Context f381004a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f381005b;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.trackrecordlib.e.a f381006e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.trackrecordlib.e.a f381007f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f381008g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f381009h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f381010i;

    /* renamed from: j, reason: collision with root package name */
    private IRecordCallback f381011j;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final RecordManager f381012a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10438);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f381012a = new RecordManager(null);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f381002c = RecordManager.class.getSimpleName();
            f381003d = false;
        }
    }

    /* synthetic */ RecordManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) anonymousClass1);
    }

    private boolean a(Object obj) {
        return (obj instanceof Dialog) || (obj instanceof View);
    }

    private boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private void c() {
        new d().start();
    }

    private void d() {
        com.tencent.trackrecordlib.core.a.a().a(this.f381004a);
    }

    private void e() {
        com.tencent.trackrecordlib.e.b bVar = new com.tencent.trackrecordlib.e.b(this.f381004a);
        this.f381006e = bVar;
        bVar.a();
    }

    private void f() {
        com.tencent.trackrecordlib.e.c cVar = new com.tencent.trackrecordlib.e.c(this.f381004a);
        this.f381007f = cVar;
        cVar.a();
    }

    public static RecordManager getInstance() {
        return a.f381012a;
    }

    @TargetApi(21)
    public String getUserEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return c.a().b();
    }

    public boolean isEnableExposure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f381009h;
    }

    public boolean isEnableRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return f381003d;
    }

    public void recordEvent(com.tencent.trackrecordlib.c.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        if (f381003d) {
            String jSONObject = bVar.e().toString();
            Log.d(f381002c, "eventMsg: " + jSONObject);
            IRecordCallback iRecordCallback = this.f381011j;
            if (iRecordCallback != null) {
                iRecordCallback.onRecordEvent(jSONObject);
            }
        }
    }

    public void setElementId(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, obj, (Object) str);
        } else if (this.f381009h && a(obj)) {
            e.a(obj, str);
        }
    }

    public void setEnableExposure(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            synchronized (RecordManager.class) {
                this.f381009h = z16;
            }
        }
    }

    public void setEnableRecord(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            synchronized (RecordManager.class) {
                f381003d = z16;
            }
        }
    }

    public void setRecentActivityName(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            if (this.f381010i) {
                return;
            }
            com.tencent.trackrecordlib.g.b.a(activity);
            synchronized (RecordManager.class) {
                this.f381010i = true;
            }
        }
    }

    @TargetApi(21)
    public void startRecord(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            startRecord(context, null, null);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
    }

    @TargetApi(21)
    public void stopRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Log.d(f381002c, "stop record!");
        if (f381003d) {
            synchronized (RecordManager.class) {
                f381003d = false;
            }
            if (this.f381004a != null) {
                com.tencent.trackrecordlib.core.a.a().b(this.f381004a);
                f.b(this.f381004a);
            }
        }
        com.tencent.trackrecordlib.e.a aVar = this.f381006e;
        if (aVar != null) {
            aVar.b();
        }
        com.tencent.trackrecordlib.e.a aVar2 = this.f381007f;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    RecordManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381005b = false;
        this.f381008g = false;
        this.f381009h = false;
        this.f381010i = false;
    }

    private boolean a(Context context) {
        return context != null && (context instanceof Application);
    }

    @TargetApi(21)
    public void startRecord(Context context, IRecordConfig iRecordConfig, IRecordCallback iRecordCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, iRecordConfig, iRecordCallback);
            return;
        }
        String str = f381002c;
        Log.d(str, "start record!");
        if (f381003d || !a()) {
            return;
        }
        if (!a(context)) {
            Log.e(str, "start record failed without Application Context!");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f381004a = applicationContext;
        a(applicationContext, iRecordConfig, iRecordCallback);
        if (b(this.f381004a) || this.f381008g) {
            synchronized (RecordManager.class) {
                f381003d = true;
            }
            b();
            c();
            d();
            if (com.tencent.trackrecordlib.g.e.b(this.f381004a)) {
                f.a(this.f381004a);
                e();
                f();
            }
        }
    }

    private void a(Context context, IRecordConfig iRecordConfig, IRecordCallback iRecordCallback) {
        com.tencent.trackrecordlib.g.c.f381135a = context.getPackageName();
        if (iRecordConfig != null && iRecordConfig.getTitleBarId() != null) {
            com.tencent.trackrecordlib.g.c.f381137c = iRecordConfig.getTitleBarId();
        }
        if (iRecordConfig != null && iRecordConfig.isEnableRelease()) {
            this.f381008g = iRecordConfig.isEnableRelease();
        }
        if (iRecordConfig != null && iRecordConfig.getCachedEventSize() > 0) {
            c.a().a(iRecordConfig.getCachedEventSize());
        }
        if (iRecordConfig != null && iRecordConfig.isFilterUGC()) {
            this.f381005b = iRecordConfig.isFilterUGC();
        }
        if (iRecordCallback != null) {
            this.f381011j = iRecordCallback;
        }
    }

    private void b() {
        new b().start();
    }

    private boolean a() {
        Log.i(f381002c, "SDK_INT: " + Build.VERSION.SDK_INT);
        return true;
    }
}

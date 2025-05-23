package com.tencent.luggage.wxa.xj;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.SparseArray;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xj.h;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g implements com.tencent.luggage.wxa.xj.d {

    /* renamed from: i, reason: collision with root package name */
    public static final SparseArray f145089i = new SparseArray();

    /* renamed from: a, reason: collision with root package name */
    public e f145090a;

    /* renamed from: b, reason: collision with root package name */
    public e f145091b;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference f145093d;

    /* renamed from: g, reason: collision with root package name */
    public int f145096g;

    /* renamed from: c, reason: collision with root package name */
    public boolean f145092c = false;

    /* renamed from: e, reason: collision with root package name */
    public ContentObserver f145094e = null;

    /* renamed from: f, reason: collision with root package name */
    public e.b f145095f = null;

    /* renamed from: h, reason: collision with root package name */
    public h f145097h = null;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            w.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
            synchronized (this) {
                try {
                    if (g.this.f145095f != null && g.this.f145093d.get() != null) {
                        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
                        g gVar = g.this;
                        g.this.a(gVar.a(gVar.f145095f), (e.a) null);
                    }
                } finally {
                    g.this.f145091b = null;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements h.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f145099a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f145100b;

        public b(e eVar, Activity activity) {
            this.f145099a = eVar;
            this.f145100b = activity;
        }

        @Override // com.tencent.luggage.wxa.xj.h.c
        public void a() {
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", this.f145099a);
            if (!this.f145100b.isDestroyed()) {
                g.this.a(this.f145100b, this.f145099a.f145107a);
            }
        }

        @Override // com.tencent.luggage.wxa.xj.h.c
        public void b() {
            w.b("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", this.f145099a);
            if (this.f145099a.f145108b != null) {
                this.f145099a.f145108b.a(this.f145099a.f145107a, false);
            }
            g.d(g.this);
            g gVar = g.this;
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(k.class));
            g.a(gVar, (k) null);
            g.d(g.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f145102a;

        static {
            int[] iArr = new int[e.b.values().length];
            f145102a = iArr;
            try {
                iArr[e.b.LANDSCAPE_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f145102a[e.b.LANDSCAPE_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public e.a f145103a;

        /* renamed from: b, reason: collision with root package name */
        public e.b f145104b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f145105c;

        /* renamed from: d, reason: collision with root package name */
        public String f145106d;

        public /* synthetic */ d(e.a aVar, e.b bVar, boolean z16, String str, a aVar2) {
            this(aVar, bVar, z16, str);
        }

        public d(e.a aVar, e.b bVar, boolean z16, String str) {
            this.f145103a = aVar;
            this.f145104b = bVar;
            this.f145105c = z16;
            this.f145106d = str;
        }

        public final void a() {
            w.d("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", this.f145106d);
            e.a aVar = this.f145103a;
            if (aVar == null) {
                w.d("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
            } else {
                aVar.a(this.f145104b, this.f145105c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public e.b f145107a;

        /* renamed from: b, reason: collision with root package name */
        public e.a f145108b;

        public /* synthetic */ e(e.b bVar, e.a aVar, a aVar2) {
            this(bVar, aVar);
        }

        public String toString() {
            return "Req{" + this.f145107a + ", " + this.f145108b + "}";
        }

        public e(e.b bVar, e.a aVar) {
            this.f145107a = bVar;
            this.f145108b = aVar;
        }
    }

    public g(Activity activity) {
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
        this.f145096g = activity.getResources().getConfiguration().orientation;
        this.f145093d = new WeakReference(activity);
        a(activity, a(e()));
    }

    public static /* synthetic */ k d(g gVar) {
        gVar.getClass();
        return null;
    }

    public static boolean e() {
        int i3 = Settings.System.getInt(z.c().getContentResolver(), "accelerometer_rotation", 0);
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", Integer.valueOf(i3));
        if (i3 == 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onConfigurationChanged(Configuration configuration) {
        b();
        this.f145096g = configuration.orientation;
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.f145096g);
        b(a(this.f145096g, e()));
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onPause() {
        if (this.f145094e != null) {
            try {
                z.c().getContentResolver().unregisterContentObserver(this.f145094e);
            } catch (Throwable th5) {
                w.a("MicroMsg.AppBrandDeviceOrientationHandler", th5, "unregisterContentObserver", new Object[0]);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onResume() {
        e.b bVar;
        synchronized (this) {
            bVar = this.f145095f;
        }
        a(bVar, (e.a) null);
        ContentResolver contentResolver = z.c().getApplicationContext().getContentResolver();
        Uri uriFor = Settings.System.getUriFor("accelerometer_rotation");
        a aVar = new a(new Handler());
        this.f145094e = aVar;
        try {
            contentResolver.registerContentObserver(uriFor, false, aVar);
        } catch (Throwable th5) {
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", th5, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void release() {
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "release");
        a(this);
        synchronized (this) {
            e eVar = this.f145090a;
            if (eVar == null && this.f145091b == null) {
                w.d("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
                return;
            }
            w.d("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", eVar, this.f145091b);
            this.f145090a = null;
            this.f145091b = null;
            this.f145092c = true;
        }
    }

    public final void b(e eVar) {
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", eVar);
        Activity activity = (Activity) this.f145093d.get();
        if (activity != null) {
            a(activity, eVar.f145107a);
            if (a(eVar)) {
                b(eVar.f145107a);
                return;
            }
            if (this.f145097h == null) {
                this.f145097h = new h();
            }
            this.f145097h.a(new b(eVar, activity));
            return;
        }
        w.f("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
        if (eVar.f145108b != null) {
            eVar.f145108b.a(eVar.f145107a, false);
        }
    }

    public boolean c() {
        boolean z16;
        synchronized (this) {
            z16 = (this.f145090a == null && this.f145091b == null) ? false : true;
        }
        return z16;
    }

    public void d() {
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "init");
        synchronized (this) {
            this.f145092c = false;
        }
    }

    public static /* synthetic */ k a(g gVar, k kVar) {
        gVar.getClass();
        return kVar;
    }

    public static g a(Activity activity) {
        g gVar;
        SparseArray sparseArray = f145089i;
        synchronized (sparseArray) {
            gVar = (g) sparseArray.get(activity.hashCode());
            if (gVar == null) {
                gVar = new g(activity);
                sparseArray.put(activity.hashCode(), gVar);
            }
        }
        return gVar;
    }

    public static void a(g gVar) {
        SparseArray sparseArray = f145089i;
        synchronized (sparseArray) {
            int indexOfValue = sparseArray.indexOfValue(gVar);
            if (indexOfValue >= 0) {
                sparseArray.removeAt(indexOfValue);
            }
        }
    }

    public final void b() {
        h hVar = this.f145097h;
        if (hVar != null) {
            hVar.a();
            this.f145097h = null;
        }
    }

    @Override // com.tencent.luggage.wxa.wj.e
    public void a(e.b bVar, e.a aVar) {
        boolean isInMultiWindowMode;
        Activity activity = (Activity) this.f145093d.get();
        e.b a16 = a(e());
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", bVar, aVar, a16, this.f145095f);
        if (activity == null) {
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
            a(aVar, a16, false);
            synchronized (this) {
                this.f145095f = bVar;
            }
            return;
        }
        e eVar = null;
        byte b16 = 0;
        byte b17 = 0;
        if (bVar == null) {
            w.f("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
            a(aVar, a16, false);
            synchronized (this) {
                this.f145095f = null;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                w.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", activity.getLocalClassName(), bVar);
                b();
                a(activity, bVar);
                if (aVar != null) {
                    aVar.a(a16, a16 == bVar);
                    return;
                }
                return;
            }
        }
        if (bVar == a16 && this.f145095f != e.b.UNSPECIFIED) {
            w.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", bVar);
            synchronized (this) {
                this.f145090a = null;
            }
            a(aVar, bVar, true);
            this.f145095f = bVar;
            b();
            a(activity, bVar);
            return;
        }
        synchronized (this) {
            if (this.f145092c) {
                w.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
                this.f145095f = bVar;
                return;
            }
            if (this.f145090a == null) {
                e eVar2 = new e(bVar, aVar, b17 == true ? 1 : 0);
                this.f145090a = eVar2;
                b(eVar2);
            } else {
                e eVar3 = this.f145091b;
                if (eVar3 == null) {
                    eVar3 = null;
                }
                this.f145091b = new e(bVar, aVar, b16 == true ? 1 : 0);
                eVar = eVar3;
            }
            this.f145095f = bVar;
            if (eVar != null) {
                w.d("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
                a(eVar.f145108b, a16, false);
            }
        }
    }

    public final void b(e.b bVar) {
        Activity activity = (Activity) this.f145093d.get();
        if (activity == null || bVar == null) {
            RuntimeException runtimeException = new RuntimeException();
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(activity == null);
            objArr[1] = Boolean.valueOf(bVar == null);
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", runtimeException, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", objArr);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this) {
            if (this.f145092c) {
                w.d("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
                return;
            }
            if (this.f145090a == null) {
                w.a("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
                return;
            }
            Object[] objArr2 = new Object[1];
            objArr2[0] = bVar == null ? "null" : bVar.name();
            w.d("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", objArr2);
            if (this.f145090a.f145108b != null) {
                linkedList.add(new d(this.f145090a.f145108b, bVar, bVar != null && bVar.a(this.f145090a.f145107a), "CurrentRequest.listener result received", null));
            }
            this.f145090a = null;
            if (this.f145091b != null) {
                a(bVar, linkedList);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a();
            }
        }
    }

    public final e.b a(e.b bVar) {
        e.b bVar2 = e.b.UNSPECIFIED;
        if (bVar == bVar2) {
            return bVar2;
        }
        e.b bVar3 = e.b.LANDSCAPE_SENSOR;
        if (bVar.a(bVar3)) {
            return e() ? e.b.LANDSCAPE_LOCKED : bVar3;
        }
        return e.b.PORTRAIT;
    }

    public final void a(Activity activity, e.b bVar) {
        activity.setRequestedOrientation(bVar.f144277a);
    }

    public final boolean a(e eVar) {
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.f145096g + "  request orientation=" + eVar.f145107a);
        if (this.f145096g == 2 && (eVar.f145107a.a(e.b.LANDSCAPE_SENSOR) || eVar.f145107a.a(e.b.LANDSCAPE_LEFT) || eVar.f145107a.a(e.b.LANDSCAPE_RIGHT))) {
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
            return true;
        }
        if (this.f145096g == 1 && eVar.f145107a.a(e.b.PORTRAIT)) {
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
            return true;
        }
        if (this.f145096g != 0) {
            if (eVar.f145107a != e.b.UNSPECIFIED) {
                return false;
            }
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
            return true;
        }
        w.a("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
        return true;
    }

    public final void a(e.b bVar, List list) {
        if (bVar == this.f145091b.f145107a) {
            if (this.f145091b.f145108b != null) {
                list.add(new d(this.f145091b.f145108b, bVar, true, "PendingRequest.Listener orientation equal direct", null));
            }
            this.f145091b = null;
        } else {
            if (((Activity) this.f145093d.get()) == null) {
                w.b("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
                if (this.f145091b.f145108b != null) {
                    list.add(new d(this.f145091b.f145108b, bVar, false, "PendingRequest.Listener activity == null", null));
                    return;
                }
                return;
            }
            e eVar = this.f145091b;
            this.f145090a = eVar;
            this.f145091b = null;
            b(eVar);
        }
    }

    public final e.b a(boolean z16) {
        w.d("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        return a(this.f145096g, z16);
    }

    @Override // com.tencent.luggage.wxa.wj.e
    public e.b a() {
        return a(e());
    }

    public final void a(e.a aVar, e.b bVar, boolean z16) {
        if (aVar == null) {
            return;
        }
        aVar.a(bVar, z16);
    }

    public final e.b a(int i3, boolean z16) {
        e.b bVar;
        if (i3 != 2) {
            if (i3 == 1) {
                w.a("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
                return e.b.PORTRAIT;
            }
            w.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(i3));
            return null;
        }
        w.a("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
        if (z16) {
            w.a("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
            return e.b.LANDSCAPE_LOCKED;
        }
        synchronized (this) {
            bVar = this.f145095f;
        }
        if (bVar != null) {
            int i16 = c.f145102a[bVar.ordinal()];
            if (i16 == 1) {
                return e.b.LANDSCAPE_LEFT;
            }
            if (i16 == 2) {
                return e.b.LANDSCAPE_RIGHT;
            }
        }
        return e.b.LANDSCAPE_SENSOR;
    }
}

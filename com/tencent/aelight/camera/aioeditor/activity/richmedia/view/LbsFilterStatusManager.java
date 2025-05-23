package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qs.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LbsFilterStatusManager implements b.d {

    /* renamed from: i, reason: collision with root package name */
    private static LbsFilterStatusManager f66554i;

    /* renamed from: b, reason: collision with root package name */
    private Handler f66556b;

    /* renamed from: c, reason: collision with root package name */
    private AppInterface f66557c;

    /* renamed from: d, reason: collision with root package name */
    private f f66558d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f66555a = true;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<a> f66559e = new SparseArray<>(1);

    /* renamed from: f, reason: collision with root package name */
    private int f66560f = 2;

    /* renamed from: g, reason: collision with root package name */
    private boolean f66561g = false;

    /* renamed from: h, reason: collision with root package name */
    private INetInfoHandler f66562h = new INetInfoHandler() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager.3
        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            Thread.currentThread().getId();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                LbsFilterStatusManager.this.n();
            } else if (LbsFilterStatusManager.this.f66556b != null) {
                LbsFilterStatusManager.this.f66556b.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LbsFilterStatusManager.this.n();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        a f66570a = null;

        /* renamed from: b, reason: collision with root package name */
        boolean f66571b = false;

        /* renamed from: c, reason: collision with root package name */
        ArrayList<String> f66572c = new ArrayList<>(1);

        /* renamed from: d, reason: collision with root package name */
        long f66573d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f66574e = 3;

        a() {
        }

        static a b() {
            a aVar = new a();
            aVar.d();
            return aVar;
        }

        String c() {
            int i3 = this.f66574e;
            if (i3 == 1) {
                return "LBS_REQ_PENDING";
            }
            if (i3 != 2) {
                return "LBS_REQ_OK";
            }
            return "LBS_REQ_PERM_OK";
        }

        void d() {
            if (this.f66570a == null) {
                this.f66570a = new a();
            }
        }

        void e() {
            a aVar = this.f66570a;
            aVar.f66571b = this.f66571b;
            aVar.f66572c.clear();
            this.f66570a.f66572c.addAll(this.f66572c);
            a aVar2 = this.f66570a;
            aVar2.f66574e = this.f66574e;
            aVar2.f66573d = this.f66573d;
        }

        void a() {
            this.f66571b = false;
            this.f66572c.clear();
            this.f66573d = 0L;
            this.f66574e = 3;
        }

        boolean f(String str) {
            LbsFilterStatusManager.k("startLocation", String.format("filterId=%s , IdList=%s", str, this.f66572c.toString()), null);
            return this.f66572c.contains(str);
        }
    }

    LbsFilterStatusManager(AppInterface appInterface) {
        if (appInterface != null) {
            this.f66557c = appInterface;
            this.f66556b = ThreadManagerV2.getUIHandlerV2();
            this.f66559e.put(1, a.b());
            AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.f66562h);
            return;
        }
        throw new RuntimeException("new LbsFilterStatusManager app==null");
    }

    private boolean g(int i3) {
        a aVar = this.f66559e.get(i3);
        int i16 = (aVar.f66571b && aVar.f(this.f66558d.f429433a)) ? 3 : 2;
        k("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", i(i16), i(this.f66560f)), null);
        return i16 != this.f66560f;
    }

    public static synchronized LbsFilterStatusManager h(AppInterface appInterface) {
        LbsFilterStatusManager lbsFilterStatusManager;
        synchronized (LbsFilterStatusManager.class) {
            if (f66554i == null) {
                f66554i = new LbsFilterStatusManager(appInterface);
                b.e(appInterface).g(f66554i);
            }
            lbsFilterStatusManager = f66554i;
        }
        return lbsFilterStatusManager;
    }

    private boolean j(int i3) {
        return this.f66559e.get(i3) != null;
    }

    public static void k(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            if (th5 != null) {
                QLog.i("LbsFilterStatusManager", 2, str + "_" + str2, th5);
                return;
            }
            QLog.i("LbsFilterStatusManager", 2, str + "_" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, boolean z16, ArrayList<String> arrayList) {
        a aVar = this.f66559e.get(i3);
        if (aVar != null) {
            k("processLocationForTemplate", String.format("[%s]acitvityName=%s", "" + z16, this.f66558d.a(i3)), null);
            if (aVar.f66574e != 3) {
                if (z16) {
                    aVar.f66572c.addAll(arrayList);
                    k("processLocationForTemplate", String.format("templateIds= %s", arrayList.toString()), null);
                }
                aVar.f66574e = 3;
                o(i3);
                return;
            }
            k("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", arrayList.toString(), aVar.c()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i3, boolean z16) {
        a aVar = this.f66559e.get(i3);
        if (aVar != null) {
            k("processLocationPermission", String.format("[%s]acitvityName=%s", "" + z16, this.f66558d.a(i3)), null);
            if (aVar.f66574e != 3) {
                aVar.f66571b = z16;
                if (z16) {
                    aVar.f66574e = 2;
                    return;
                } else {
                    aVar.f66574e = 3;
                    o(i3);
                    return;
                }
            }
            k("processLocationPermission", String.format("[Error]Status=%s", aVar.c()), null);
            aVar.f66571b = z16;
            aVar.f66572c.clear();
            aVar.f66570a.f66572c.clear();
            o(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        f fVar = this.f66558d;
        if (fVar != null) {
            k("processMobile2WifiNet", String.format("activityType=%s", fVar.a(fVar.f429452t)), null);
            if (this.f66561g) {
                return;
            }
            p();
        }
    }

    private void o(int i3) {
        k("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", this.f66558d.f429437e, this.f66558d.a(i3)), null);
        f fVar = this.f66558d;
        if (fVar.f429439g && j(fVar.f429452t) && this.f66558d.f429452t == i3) {
            k("sendLoadingFilterMsg", String.format("needRefresh=%s", "" + g(i3)), null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        boolean z16;
        a aVar = this.f66559e.get(this.f66558d.f429452t);
        f fVar = this.f66558d;
        k("startLocationUsingActivity", String.format("activityType=%s", fVar.a(fVar.f429452t)), null);
        if (aVar == null || !this.f66555a) {
            return;
        }
        k("startLocationUsingActivity", String.format("mRequestStatus=%s", aVar.c()), null);
        if (aVar.f66574e != 3) {
            return;
        }
        k("startLocationUsingActivity", String.format("mRequestBeginTime=%s", "" + aVar.f66573d), null);
        if (aVar.f66573d > 0) {
            long currentTimeMillis = System.currentTimeMillis() - aVar.f66573d;
            k("startLocationUsingActivity", String.format("diffTime=%s", "" + currentTimeMillis), null);
            if (currentTimeMillis < 30000) {
                z16 = false;
                k("startLocationUsingActivity", String.format("timeOK=%s", "" + z16), null);
                if (z16) {
                    return;
                }
                aVar.e();
                aVar.a();
                aVar.f66574e = 1;
                aVar.f66573d = System.currentTimeMillis();
                b.e(this.f66557c).h(this.f66558d.f429452t);
                return;
            }
        }
        z16 = true;
        k("startLocationUsingActivity", String.format("timeOK=%s", "" + z16), null);
        if (z16) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.b.d
    public void a(final int i3, final boolean z16, final ArrayList<String> arrayList) {
        Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            l(i3, z16, arrayList);
        } else {
            this.f66556b.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager.2
                @Override // java.lang.Runnable
                public void run() {
                    LbsFilterStatusManager.this.l(i3, z16, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.b.d
    public void b(final int i3, final boolean z16) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m(i3, z16);
        } else {
            this.f66556b.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager.1
                @Override // java.lang.Runnable
                public void run() {
                    LbsFilterStatusManager.this.m(i3, z16);
                }
            });
        }
    }

    private String i(int i3) {
        if (i3 == 1) {
            return "LBS_FILTER_LOADING_KIND";
        }
        if (i3 == 2) {
            return "LBS_FILTER_NOMAL_KIND";
        }
        if (i3 != 3) {
            return "LBS_FILTER_UNINIT_KIND";
        }
        return "LBS_FILTER_SPECIAL_KIND";
    }
}

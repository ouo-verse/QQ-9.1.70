package com.tencent.mobileqq.ark.component;

import android.annotation.TargetApi;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.component.ArkAppLocationManager;
import com.tencent.mobileqq.ark.util.g;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppLocationManager {

    /* renamed from: a, reason: collision with root package name */
    protected String f199222a;

    /* renamed from: e, reason: collision with root package name */
    private SosoInterfaceOnLocationListener f199226e;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f199223b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<b> f199224c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<a> f199225d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final c f199227f = new c();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z16, SosoLbsInfo sosoLbsInfo);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a(boolean z16, double d16, double d17);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f199232b = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

        /* renamed from: a, reason: collision with root package name */
        private QQPermission f199233a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes11.dex */
        public class a extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f199234a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Runnable f199235b;

            a(Runnable runnable, Runnable runnable2) {
                this.f199234a = runnable;
                this.f199235b = runnable2;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                Runnable runnable = this.f199234a;
                if (runnable != null) {
                    runnable.run();
                }
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> list, List<Integer> list2) {
                super.onDenied(list, list2);
                Runnable runnable = this.f199235b;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        c() {
        }

        private BusinessConfig b() {
            return new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ARK, QQPermissionConstants.Business.SCENE.ARK_GET_LOCATION);
        }

        @Nullable
        private QQPermission c() {
            if (this.f199233a == null) {
                this.f199233a = QQPermissionFactory.getQQPermission(Foreground.getTopActivity(), b());
            }
            return this.f199233a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(QQPermission qQPermission, Runnable runnable, Runnable runnable2) {
            qQPermission.requestPermissions(f199232b, 2, new a(runnable, runnable2));
        }

        public boolean d() {
            QQPermission c16 = c();
            if (c16 == null) {
                QLog.w("GetArkLocPermission", 1, "hasGranted, permission is null");
                return true;
            }
            for (String str : f199232b) {
                if (c16.hasPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        }

        public void f(final Runnable runnable, final Runnable runnable2) {
            final QQPermission c16 = c();
            if (c16 == null) {
                QLog.w("GetArkLocPermission", 1, "requestPermission, permission is null");
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.component.c
                @Override // java.lang.Runnable
                public final void run() {
                    ArkAppLocationManager.c.this.e(c16, runnable, runnable2);
                }
            });
        }
    }

    public ArkAppLocationManager(String str, long j3) {
        this.f199222a = str;
        this.f199226e = new SosoInterfaceOnLocationListener(3, true, true, j3, true, false, "ArkAppLocationManager") { // from class: com.tencent.mobileqq.ark.component.ArkAppLocationManager.1
            protected void a(int i3, final SosoLbsInfo sosoLbsInfo) {
                final boolean z16;
                if (i3 == 0 && sosoLbsInfo != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppLocationManager.this.f199222a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppLocationManager.1.1
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        double d16;
                        double d17;
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ArrayList arrayList3;
                        SosoLbsInfo sosoLbsInfo2;
                        double d18;
                        if (z16 && (sosoLbsInfo2 = sosoLbsInfo) != null) {
                            if (Math.abs(sosoLbsInfo2.mLocation.mLat84) > 1.0E-6d && Math.abs(sosoLbsInfo.mLocation.mLon84) > 1.0E-6d) {
                                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                                d16 = sosoLocation.mLat84;
                                d18 = sosoLocation.mLon84;
                            } else if (Math.abs(sosoLbsInfo.mLocation.mLat02) > 1.0E-6d && Math.abs(sosoLbsInfo.mLocation.mLon02) > 1.0E-6d) {
                                SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
                                double[] a16 = g.a(sosoLocation2.mLon02, sosoLocation2.mLat02);
                                d18 = a16[0];
                                d16 = a16[1];
                                SosoLocation sosoLocation3 = sosoLbsInfo.mLocation;
                                sosoLocation3.mLat84 = d16;
                                sosoLocation3.mLon84 = d18;
                            }
                            d17 = d18;
                            synchronized (ArkAppLocationManager.this.f199223b) {
                                arrayList = new ArrayList(ArkAppLocationManager.this.f199223b);
                            }
                            if (arrayList.size() == 0) {
                                ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppLocationManager.this.f199226e);
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                b bVar = (b) it.next();
                                bVar.a(z16, d16, d17);
                                if (!z16) {
                                    bVar.b();
                                }
                            }
                            if (!z16) {
                                synchronized (ArkAppLocationManager.this.f199223b) {
                                    ArkAppLocationManager.this.f199223b.clear();
                                }
                            }
                            synchronized (ArkAppLocationManager.this.f199224c) {
                                arrayList2 = new ArrayList(ArkAppLocationManager.this.f199224c);
                                ArkAppLocationManager.this.f199224c.removeAll(arrayList2);
                            }
                            Iterator it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                b bVar2 = (b) it5.next();
                                bVar2.a(z16, d16, d17);
                                bVar2.b();
                            }
                            synchronized (ArkAppLocationManager.this.f199225d) {
                                arrayList3 = new ArrayList(ArkAppLocationManager.this.f199225d);
                                ArkAppLocationManager.this.f199225d.removeAll(arrayList3);
                            }
                            Iterator it6 = arrayList3.iterator();
                            while (it6.hasNext()) {
                                ((a) it6.next()).a(z16, sosoLbsInfo);
                            }
                            return;
                        }
                        d16 = 0.0d;
                        d17 = 0.0d;
                        synchronized (ArkAppLocationManager.this.f199223b) {
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onConsecutiveFailure(int i3, int i16) {
                if (i16 < 3) {
                    return;
                }
                a(i3, null);
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                a(i3, sosoLbsInfo);
            }
        };
    }

    @QQPermissionDenied(1)
    @TargetApi(23)
    public void denied() {
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.f199226e);
        QLog.i("GetArkLocPermission", 1, "CheckPermission location is denied");
    }

    protected void e() {
        if (this.f199227f.d()) {
            grant();
        } else {
            this.f199227f.f(new Runnable() { // from class: com.tencent.mobileqq.ark.component.a
                @Override // java.lang.Runnable
                public final void run() {
                    ArkAppLocationManager.this.grant();
                }
            }, new Runnable() { // from class: com.tencent.mobileqq.ark.component.b
                @Override // java.lang.Runnable
                public final void run() {
                    ArkAppLocationManager.this.denied();
                }
            });
        }
    }

    public void f() {
        synchronized (this.f199223b) {
            this.f199223b.clear();
        }
        synchronized (this.f199224c) {
            this.f199224c.clear();
        }
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.f199226e);
    }

    public void g(a aVar, boolean z16) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f199225d) {
            this.f199225d.add(aVar);
        }
        if (z16) {
            e();
        } else {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.f199226e);
        }
    }

    @QQPermissionGrant(1)
    @TargetApi(23)
    public void grant() {
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.f199226e);
        QLog.i("GetArkLocPermission", 1, "CheckPermission location is granted ");
    }

    public void h(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f199224c) {
            this.f199224c.add(bVar);
        }
        e();
    }

    public void i(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f199223b) {
            this.f199223b.add(bVar);
        }
        e();
    }

    public void j() {
        ArrayList arrayList;
        if (this.f199224c.size() == 0 && this.f199225d.size() == 0) {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.f199226e);
        }
        synchronized (this.f199223b) {
            arrayList = new ArrayList(this.f199223b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
        synchronized (this.f199223b) {
            this.f199223b.clear();
        }
    }
}

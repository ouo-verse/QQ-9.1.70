package dv;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.avcore.jni.net.SocketInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ev.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements wu.a {
    private static final int[] C = {1, 2, 3, 4};

    /* renamed from: d, reason: collision with root package name */
    private Boolean f395003d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f395004e = false;

    /* renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArraySet<zu.b> f395007i = new CopyOnWriteArraySet<>();

    /* renamed from: h, reason: collision with root package name */
    private final Context f395006h = BaseApplication.getContext();

    /* renamed from: f, reason: collision with root package name */
    private final av.a f395005f = new dv.a();

    /* renamed from: m, reason: collision with root package name */
    private final a.b f395008m = new a();

    private void b() {
        if (this.f395004e) {
            return;
        }
        this.f395004e = true;
        ev.a.d(this.f395006h, this.f395008m);
    }

    private void c() {
        if (this.f395004e && this.f395007i.isEmpty()) {
            this.f395004e = false;
            ev.a.h(this.f395006h, this.f395008m);
        }
    }

    private boolean d() {
        int a16 = this.f395005f.a();
        if (a16 == -1) {
            this.f395005f.j();
        }
        return a16 == 0;
    }

    private boolean e(int i3) {
        QLog.d("OppoNetworkAccelerationApiImpl", 1, "cap:=" + i3);
        return (i3 & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3, boolean z16, Bundle bundle) {
        Iterator<zu.b> it = this.f395007i.iterator();
        while (it.hasNext()) {
            it.next().a(i3, z16, bundle);
        }
    }

    @Override // wu.a
    public void bindToNetInterface(SocketInfo socketInfo) {
        int g16 = ev.a.g(this.f395006h, socketInfo.srcIP, socketInfo.destIP, socketInfo.srcPort, socketInfo.destPort, socketInfo.f77484protocol);
        f(200, g16 == 0, null);
        QLog.d("OppoNetworkAccelerationApiImpl", 1, "bindToNetInterface :=" + g16);
    }

    @Override // wu.a
    public int getCurManufacture() {
        return 1;
    }

    @Override // wu.a
    public boolean hasFeature(int i3) {
        for (int i16 : C) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    @Override // wu.a
    public boolean isSupportNetworkAcceleration() {
        if (this.f395003d == null) {
            boolean d16 = d();
            if (!d16) {
                this.f395003d = Boolean.FALSE;
            } else {
                Pair<Integer, Integer> c16 = ev.a.c(this.f395006h);
                boolean z16 = false;
                boolean z17 = ((Integer) c16.first).intValue() == 0 && e(((Integer) c16.second).intValue());
                if (d16 && z17) {
                    z16 = true;
                }
                this.f395003d = Boolean.valueOf(z16);
            }
            QLog.d("OppoNetworkAccelerationApiImpl", 1, "isSupportNetworkAcceleration :=" + this.f395003d + ", auth:=" + d16);
        }
        return this.f395003d.booleanValue();
    }

    @Override // wu.a
    public void notifyAPPStateToSys(int i3) {
        int b16 = hv.a.b(i3);
        int f16 = ev.a.f(this.f395006h, i3);
        f(b16, f16 == 0, null);
        QLog.d("OppoNetworkAccelerationApiImpl", 1, "notifyAPPStateToSys :=" + f16);
    }

    @Override // wu.a
    public void registerNetworkEventListener(zu.b bVar) {
        b();
        this.f395007i.add(bVar);
    }

    @Override // wu.a
    public void setAppBandwidth(int i3, int i16) {
        int e16 = ev.a.e(this.f395006h, i3, i16);
        f(100, e16 == 0, null);
        QLog.d("OppoNetworkAccelerationApiImpl", 1, "setApBandwidth :=" + e16);
    }

    @Override // wu.a
    public void unBindToNetInterface(SocketInfo socketInfo) {
        int b16 = ev.a.b(this.f395006h, socketInfo.srcIP, socketInfo.destIP, socketInfo.srcPort, socketInfo.destPort, socketInfo.f77484protocol);
        f(201, b16 == 0, null);
        QLog.d("OppoNetworkAccelerationApiImpl", 1, "unBindToNetInterface :=" + b16);
    }

    @Override // wu.a
    public void unRegisterNetworkEventListener(zu.b bVar) {
        this.f395007i.remove(bVar);
        c();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements a.b {
        a() {
        }

        @Override // ev.a.b
        public void a(boolean z16, int i3, int i16) {
            int i17 = z16 ? i3 > 0 ? 300 : 301 : -1;
            if (!z16) {
                i3 = 0;
            } else if (i3 <= 0) {
                i3 = i16;
            }
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_1", String.valueOf(i3));
            b.this.f(i17, true, bundle);
        }
    }
}

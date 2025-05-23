package bv;

import android.os.Bundle;
import com.tencent.avcore.jni.net.SocketInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements wu.a {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f29243h = {1, 2, 4};

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<zu.b> f29244d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private a f29245e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f29246f;

    public b() {
        a();
    }

    private void a() {
        a aVar = new a();
        this.f29245e = aVar;
        aVar.j();
    }

    private void b(int i3, boolean z16, Bundle bundle) {
        Iterator<zu.b> it = this.f29244d.iterator();
        while (it.hasNext()) {
            it.next().a(i3, z16, bundle);
        }
    }

    @Override // wu.a
    public void bindToNetInterface(SocketInfo socketInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(QQBrowserActivity.KEY_MSG_TYPE, 16);
        bundle.putInt("scene", 4096);
        bundle.putString("KFD", String.valueOf(socketInfo.f77483fd));
        bundle.putInt("accStatus", 1);
        b(200, cv.b.b().d(bundle), null);
        QLog.d("MagicNetworkAccelerationApiImpl", 1, "bindToNetInterface :=" + bundle);
    }

    @Override // wu.a
    public int getCurManufacture() {
        return 2;
    }

    @Override // wu.a
    public boolean hasFeature(int i3) {
        for (int i16 : f29243h) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    @Override // wu.a
    public boolean isSupportNetworkAcceleration() {
        if (this.f29246f == null) {
            this.f29246f = Boolean.valueOf(this.f29245e.a() == 0);
            QLog.d("MagicNetworkAccelerationApiImpl", 1, "isSupportNetworkAcceleration :=" + this.f29246f);
        }
        return this.f29246f.booleanValue();
    }

    @Override // wu.a
    public void notifyAPPStateToSys(int i3) {
        int b16 = hv.a.b(i3);
        int i16 = i3 == 1 ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putInt(QQBrowserActivity.KEY_MSG_TYPE, 1);
        bundle.putInt("scene", 4096);
        bundle.putInt("status", i16);
        b(b16, cv.b.b().d(bundle), null);
        QLog.d("MagicNetworkAccelerationApiImpl", 1, "notifyAPPStateToSys :=" + bundle);
    }

    @Override // wu.a
    public void registerNetworkEventListener(zu.b bVar) {
        this.f29244d.add(bVar);
    }

    @Override // wu.a
    public void setAppBandwidth(int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt(QQBrowserActivity.KEY_MSG_TYPE, 8);
        bundle.putInt("scene", 4096);
        bundle.putInt("BWREQ_DL", i3);
        bundle.putInt("BWREQ_UL", i16);
        b(100, cv.b.b().d(bundle), null);
        QLog.d("MagicNetworkAccelerationApiImpl", 1, "setAppBandwidth :=" + bundle);
    }

    @Override // wu.a
    public void unBindToNetInterface(SocketInfo socketInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(QQBrowserActivity.KEY_MSG_TYPE, 16);
        bundle.putInt("scene", 4096);
        bundle.putString("KFD", String.valueOf(socketInfo.f77483fd));
        bundle.putInt("accStatus", 0);
        b(200, cv.b.b().d(bundle), null);
        QLog.d("MagicNetworkAccelerationApiImpl", 1, "unBindToNetInterface :=" + bundle);
    }

    @Override // wu.a
    public void unRegisterNetworkEventListener(zu.b bVar) {
        this.f29244d.remove(bVar);
    }
}

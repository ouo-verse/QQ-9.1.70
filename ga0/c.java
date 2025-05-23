package ga0;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends b {

    /* renamed from: e, reason: collision with root package name */
    private static c f401607e;

    /* renamed from: c, reason: collision with root package name */
    private x50.b f401608c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<a> f401609d;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void A5(x50.b bVar);
    }

    public static c m() {
        if (f401607e == null) {
            synchronized (c.class) {
                if (f401607e == null) {
                    f401607e = new c();
                }
            }
        }
        return f401607e;
    }

    @RFWTestMock(id = "QFS_MAIN_AD")
    private void o() {
        a aVar;
        WeakReference<a> weakReference = this.f401609d;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.A5(this.f401608c);
        }
    }

    @Override // ga0.b
    int b() {
        return 1147;
    }

    @Override // ga0.b
    List<Integer> c() {
        return null;
    }

    @Override // ga0.b
    protected String d() {
        return "QFSAdPendantTianShuManager";
    }

    @Override // ga0.b
    protected int e() {
        return 3000;
    }

    @Override // ga0.b
    void i() {
        QLog.d("QFSAdPendantTianShuManager", 1, "noBubbleConfig");
        this.f401608c = null;
        o();
    }

    @Override // ga0.b
    void j(int i3) {
        TianShuAccess.AdItem adItem = this.f401605a;
        if (adItem != null && adItem.argList.get() != null) {
            Map<String, String> f16 = f(this.f401605a.argList.get());
            x50.b bVar = new x50.b();
            bVar.f447218a = this.f401605a.iAdId.get();
            bVar.f447219b = f16.get("staticPic");
            bVar.f447220c = f16.get("ios_motionPic");
            bVar.f447221d = f16.get("foldStaticPic");
            bVar.f447222e = f16.get("ios_foldMotionPic");
            bVar.f447223f = f16.get("ios_frameMotionPic");
            bVar.f447224g = f16.get("ios_frameFoldMotionPic");
            bVar.f447225h = f16.get("url");
            bVar.f447226i = this.f401605a.traceinfo.get();
            if (!TextUtils.isEmpty(bVar.f447221d) && !TextUtils.isEmpty(bVar.f447219b)) {
                this.f401608c = bVar;
            } else {
                QLog.e("QFSAdPendantTianShuManager", 1, "parseBubbleInfo adConfigPackage config error:" + bVar);
                this.f401608c = null;
            }
            QLog.d("QFSAdPendantTianShuManager", 1, "parseBubbleInfo mAdConfigPackage:" + this.f401608c);
            o();
            return;
        }
        this.f401608c = null;
        QLog.d("QFSAdPendantTianShuManager", 1, "parseBubbleInfo mAdConfigPackage null");
        o();
    }

    public void l() {
        this.f401608c = null;
    }

    public x50.b n() {
        return this.f401608c;
    }

    public void p(a aVar) {
        this.f401609d = new WeakReference<>(aVar);
    }
}

package an0;

import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragmentFallbackIPCHandler;
import com.tencent.gdtad.kuikly.fragment.a;
import com.tencent.gdtad.views.wechat.kf.kuikly.GdtWXCustomerServiceKuiklyFragment;
import com.tencent.gdtad.views.wechat.kf.natives.GdtWXCustomerServiceFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends com.tencent.gdtad.kuikly.fragment.a {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f26326f;

    /* renamed from: d, reason: collision with root package name */
    private final b f26327d = new b();

    /* renamed from: e, reason: collision with root package name */
    private final c f26328e = new c();

    /* compiled from: P */
    /* renamed from: an0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static final class C0051a extends GdtBaseKuiklyFragmentFallbackIPCHandler {
        @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragmentFallbackIPCHandler
        protected String b() {
            return "IPC_ACTION_WX_CUSTOMER_SERVICE_FALLBACK";
        }

        @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragmentFallbackIPCHandler
        protected com.tencent.gdtad.kuikly.fragment.a c() {
            return a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b implements a.b {
        b() {
        }

        @Override // com.tencent.gdtad.kuikly.fragment.a.b
        public int a(a.d dVar) {
            if (!(dVar instanceof an0.b)) {
                QLog.e("GdtWXCustomerServiceKuiklyFragmentLauncherDisplayProcessor", 1, "[display] error, params not instanceof GdtWXCustomerServiceKuiklyFragmentLauncherParams");
                return 1;
            }
            return GdtWXCustomerServiceKuiklyFragment.Bh((an0.b) dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class c implements a.c {
        c() {
        }

        private void b(a.d dVar) {
            if (dVar == null) {
                QLog.e("GdtWXCustomerServiceKuiklyFragmentLauncherFallbackProcessor", 1, "[reportForLinkEvent] error, params is null");
                return;
            }
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            int h16 = (int) dVar.h();
            if (h16 >= 0) {
                reportBiz.cost_time = h16;
            }
            AdReporterForLinkEvent.getInstance().reportAsync(dVar.getActivity(), 4001067, dVar.b(), reportBiz, null);
        }

        @Override // com.tencent.gdtad.kuikly.fragment.a.c
        public int a(a.d dVar, int i3) {
            if (!(dVar instanceof an0.b)) {
                QLog.e("GdtWXCustomerServiceKuiklyFragmentLauncherFallbackProcessor", 1, "[fallback] error, params not instanceof GdtWXCustomerServiceKuiklyFragmentLauncherParams");
                return 1;
            }
            b(dVar);
            an0.b bVar = (an0.b) dVar;
            return GdtWXCustomerServiceFragment.wh(bVar.k(), bVar.d());
        }
    }

    a() {
    }

    public static a n() {
        if (f26326f == null) {
            synchronized (a.class) {
                if (f26326f == null) {
                    f26326f = new a();
                }
            }
        }
        return f26326f;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a
    protected GdtBaseKuiklyFragmentFallbackIPCHandler c() {
        return new C0051a();
    }

    public b l() {
        return this.f26327d;
    }

    public c m() {
        return this.f26328e;
    }
}

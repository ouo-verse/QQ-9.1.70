package hf2;

import af2.d;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.base.account.ECFaceVerification;
import com.tencent.mobileqq.qqecommerce.base.device.ECDeviceManager;
import com.tencent.mobileqq.qqecommerce.base.image.ECImageLoader;
import com.tencent.mobileqq.qqecommerce.base.image.ECPagSoLoader;
import com.tencent.mobileqq.qqecommerce.base.location.ECLocationService;
import com.tencent.mobileqq.qqecommerce.base.offline.ECOfflineManager;
import com.tencent.mobileqq.qqecommerce.base.qqlivesso.ECQQLiveSSORequest;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.base.somanager.ECShowPageCostTimeScene;
import com.tencent.mobileqq.qqecommerce.base.somanager.c;
import com.tencent.mobileqq.qqecommerce.biz.hippy.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyImageFetcher;
import com.tencent.mobileqq.qqecommerce.biz.qcircle.ECQCircleApi;
import com.tencent.mobileqq.qqecommerce.biz.qq.ECQQApi;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.qqecommerce.biz.report.api.QQECMobileReportManager;
import com.tencent.mobileqq.qqecommerce.biz.res.ECResourceApi;
import com.tencent.mobileqq.qqecommerce.biz.ui.ECRenderViewRegister;
import com.tencent.mobileqq.qqecommerce.biz.wallet.ECWallet;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.QLog;
import if2.e;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lhf2/b;", "", "", "b", "d", "", "Z", "getSdkAdapterHadInit", "()Z", "setSdkAdapterHadInit", "(Z)V", "sdkAdapterHadInit", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f404840a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean sdkAdapterHadInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"hf2/b$a", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "", "result", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements IECLoadSoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.base.somanager.a f404842a;

        a(com.tencent.mobileqq.qqecommerce.base.somanager.a aVar) {
            this.f404842a = aVar;
        }

        @Override // com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback
        public void loadResult(int result) {
            QLog.d("ECommerceConfig", 1, "[loadPtsLiteSo] initConfig loadPtsLiteSo result = " + result);
            this.f404842a.a(new c().a(true).b(result).c());
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        d.b(d.f26007a, 111, new HashMap(), null, 4, null);
        eg2.b.f396245a.h();
    }

    public final void b() {
        d();
        com.tencent.mobileqq.qqecommerce.base.somanager.d.f262484a.loadPtsLiteSo(new a(new com.tencent.mobileqq.qqecommerce.base.somanager.a(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_SO_LOAD)));
        ThreadManagerV2.excute(new Runnable() { // from class: hf2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c();
            }
        }, 64, null, true);
    }

    public final void d() {
        if (sdkAdapterHadInit && QQEcommerceSdk.INSTANCE.isInitialized()) {
            return;
        }
        sdkAdapterHadInit = true;
        QQEcommerceSdk.init(new com.tencent.ecommerce.base.b().T(new ECRuntimeManager()).x(new te2.a()).B(new com.tencent.mobileqq.qqecommerce.base.msf.c()).Y(new ff2.a()).U(new hg2.a()).f(new ECDataReportManager()).z(new QQECMobileReportManager()).b(new com.tencent.mobileqq.qqecommerce.base.account.a()).f0(new ECWallet()).Q(new me2.a()).Z(new ng2.a()).l(new ECFaceVerification()).r(new ECImageLoader()).E(new we2.b()).p(new g()).C(new ve2.a()).s(new bf2.a()).W(new com.tencent.mobileqq.qqecommerce.base.share.c()).e(new ig2.a()).v(new oe2.a()).A(new bg2.a()).n(new e()).P(new cf2.a()).d(new com.tencent.mobileqq.qqecommerce.base.image.a()).F(new ECPagSoLoader()).u(new vf2.a()).I(new ze2.a()).g(new ECDeviceManager()).K(new com.tencent.mobileqq.qqecommerce.base.publicaccount.b()).j(new ef2.b()).y(new ue2.e()).c(new af2.a()).w(new ECLocationService()).i(xe2.c.f447853a).h(new le2.a()).a0(new com.tencent.mobileqq.qqecommerce.base.upload.a()).G(new dg2.a()).X(com.tencent.mobileqq.qqecommerce.base.somanager.d.f262484a).J(af2.e.f26008a).d0(new kg2.a()).q(new se2.b()).D(new ECOfflineManager()).N(new ECQQLiveSSORequest()).e0(new og2.b()).H(new ye2.a()).L(new ECQCircleApi()).o(new lf2.b()).m(new kf2.a()).M(new ECQQApi()).S(new ECResourceApi()).V(new com.tencent.mobileqq.qqecommerce.base.searchbar.a()).k(new jf2.a()).b0(new dg2.b()).O(new gg2.a()).t(new QQKuiklyImageFetcher()).c0(new jg2.e()).R(new ECRenderViewRegister()).a());
    }
}

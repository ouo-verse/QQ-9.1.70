package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.sdk.app.WadlConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import gw4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/e;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "l", "", "d", "Z", "skipRedirect", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "e", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(ZLcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean skipRedirect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/e$a", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$a;", "", WadlConstant.SIGN_IS_WHITE, "isNotBlack", "", "redirectScheme", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements CheckPhoneManager.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331461b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331462c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331463d;

        a(EnterModCheckRequest enterModCheckRequest, EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar) {
            this.f331461b = enterModCheckRequest;
            this.f331462c = enterModCheckResult;
            this.f331463d = aVar;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void a(boolean isWhite, boolean isNotBlack, String redirectScheme) {
            Intrinsics.checkNotNullParameter(redirectScheme, "redirectScheme");
            e.this.f("onRedirectCheck success: appId = " + this.f331461b.getEnterParams().getAppId() + " , redirectScheme == " + redirectScheme + " skipRedirect=" + e.this.skipRedirect);
            if (isWhite && !e.this.skipRedirect) {
                if (redirectScheme.length() > 0) {
                    String appendSourceToScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendSourceToScheme(redirectScheme, e.this.source);
                    ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                    BaseApplication context = BaseApplication.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                    iSchemeApi.launchScheme(context, appendSourceToScheme);
                    this.f331462c.setResultCode(3);
                    this.f331462c.setProcessInner(true);
                    this.f331463d.b(this.f331462c);
                    return;
                }
            }
            e.this.d(this.f331461b, this.f331462c, this.f331463d);
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void b(boolean z16) {
            CheckPhoneManager.a.C9150a.a(this, z16);
        }
    }

    public e(boolean z16, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.skipRedirect = z16;
        this.source = source;
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "RedirectChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        gw4.f fVar;
        h hVar;
        String str;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        a aVar = new a(request, lastCheckResult, callback);
        CheckPhoneManager checkPhoneManager = CheckPhoneManager.f331491a;
        String k3 = checkPhoneManager.k(request.getEnterParams().getMapId(), CheckPhoneManager.EntryType.MOD);
        gw4.b j3 = checkPhoneManager.j(k3);
        boolean z16 = false;
        if (j3 != null && (fVar = j3.f403460b) != null && (hVar = fVar.f403474e) != null && (str = hVar.f403479a) != null) {
            if (str.length() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            f("check has cache");
            checkPhoneManager.e(k3, CheckPhoneManager.DataType.PHONE, aVar);
        } else {
            f("check no cache pass");
            d(request, lastCheckResult, callback);
        }
    }
}

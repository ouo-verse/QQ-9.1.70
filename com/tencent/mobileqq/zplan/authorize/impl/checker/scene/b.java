package com.tencent.mobileqq.zplan.authorize.impl.checker.scene;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.sdk.app.WadlConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.authorize.api.CheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import gw4.f;
import gw4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/scene/b;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/scene/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "j", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends BaseChecker<SceneCheckRequest, CheckResult> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/scene/b$a", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$a;", "", WadlConstant.SIGN_IS_WHITE, "isNotBlack", "", "redirectScheme", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements CheckPhoneManager.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CheckResult f331477b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> f331478c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SceneCheckRequest f331479d;

        a(CheckResult checkResult, com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> aVar, SceneCheckRequest sceneCheckRequest) {
            this.f331477b = checkResult;
            this.f331478c = aVar;
            this.f331479d = sceneCheckRequest;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void a(boolean isWhite, boolean isNotBlack, String redirectScheme) {
            Intrinsics.checkNotNullParameter(redirectScheme, "redirectScheme");
            b.this.f("onPhoneResult isWhite:" + isWhite + " isNotBlack:" + isNotBlack + ", redirectScheme:" + redirectScheme);
            if (redirectScheme.length() > 0) {
                String appendSourceToScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendSourceToScheme(redirectScheme, this.f331477b.getSource());
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                iSchemeApi.launchScheme(context, appendSourceToScheme);
                this.f331477b.setResultCode(3);
                this.f331478c.b(this.f331477b);
                return;
            }
            b.this.d(this.f331479d, this.f331477b, this.f331478c);
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void b(boolean z16) {
            CheckPhoneManager.a.C9150a.a(this, z16);
        }
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "SceneRedirectChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(SceneCheckRequest request, CheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> callback) {
        f fVar;
        h hVar;
        String str;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        a aVar = new a(lastCheckResult, callback, request);
        CheckPhoneManager checkPhoneManager = CheckPhoneManager.f331491a;
        String k3 = checkPhoneManager.k(request.getSceneId(), request.getSceneType());
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

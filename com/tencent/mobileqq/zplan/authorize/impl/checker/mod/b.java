package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/b;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "j", "", "d", "Z", "needReLaunchByScheme", "<init>", "(Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean needReLaunchByScheme;

    public b(boolean z16) {
        this.needReLaunchByScheme = z16;
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "LaunchScheneChcker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        if (!this.needReLaunchByScheme) {
            d(request, lastCheckResult, callback);
            return;
        }
        String scheme = ((com.tencent.mobileqq.zplan.authorize.impl.helper.e) i.INSTANCE.a(com.tencent.mobileqq.zplan.authorize.impl.helper.e.class)).getScheme(request.getEnterParams().getMapId());
        QLog.i(b(), 1, "launchScheme -> " + scheme);
        if (scheme != null) {
            if (!(scheme.length() == 0)) {
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iSchemeApi.launchScheme(context, scheme);
                lastCheckResult.setResultCode(21);
                lastCheckResult.setProcessInner(true);
                callback.b(lastCheckResult);
                return;
            }
        }
        d(request, lastCheckResult, callback);
    }
}

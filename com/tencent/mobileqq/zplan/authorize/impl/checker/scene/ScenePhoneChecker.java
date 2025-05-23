package com.tencent.mobileqq.zplan.authorize.impl.checker.scene;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.api.CheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.helper.CheckPhoneResultHelper;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/scene/ScenePhoneChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/scene/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "j", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ScenePhoneChecker extends BaseChecker<SceneCheckRequest, CheckResult> {
    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "ScenePhoneChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(final SceneCheckRequest request, final CheckResult lastCheckResult, final com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        CheckPhoneManager.f331491a.i(request.getSceneId(), request.getSceneType(), new CheckPhoneManager.a() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.scene.ScenePhoneChecker$check$checkPhoneCallback$1
            @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
            public void a(boolean isWhite, boolean isNotBlack, String redirectScheme) {
                Intrinsics.checkNotNullParameter(redirectScheme, "redirectScheme");
                ScenePhoneChecker.this.f("onPhoneResult success: sceneId = " + request.getSceneId() + " , checkResult == " + isWhite);
                if (isWhite) {
                    ScenePhoneChecker.this.d(request, lastCheckResult, callback);
                    return;
                }
                CheckPhoneResultHelper checkPhoneResultHelper = CheckPhoneResultHelper.f331480a;
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                ZootopiaSource source = lastCheckResult.getSource();
                int sceneId = request.getSceneId();
                CheckPhoneManager.EntryType sceneType = request.getSceneType();
                final ScenePhoneChecker scenePhoneChecker = ScenePhoneChecker.this;
                final SceneCheckRequest sceneCheckRequest = request;
                final CheckResult checkResult = lastCheckResult;
                final com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> aVar = callback;
                checkPhoneResultHelper.e(context, source, sceneId, sceneType, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.scene.ScenePhoneChecker$check$checkPhoneCallback$1$onPhoneResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        ScenePhoneChecker.this.f("onPhoneResult confirm:" + z16);
                        if (z16) {
                            ScenePhoneChecker.this.d(sceneCheckRequest, checkResult, aVar);
                        } else {
                            checkResult.setResultCode(2);
                            aVar.b(checkResult);
                        }
                        aVar.a(checkResult);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
            public void b(boolean z16) {
                CheckPhoneManager.a.C9150a.a(this, z16);
            }
        });
    }
}

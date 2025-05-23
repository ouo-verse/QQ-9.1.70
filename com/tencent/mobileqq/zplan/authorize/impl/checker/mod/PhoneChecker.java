package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.helper.CheckPhoneResultHelper;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/PhoneChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "j", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PhoneChecker extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {
    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "PhoneChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(final EnterModCheckRequest request, final EnterModCheckResult lastCheckResult, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        CheckPhoneManager.f331491a.i(request.getEnterParams().getMapId(), CheckPhoneManager.EntryType.MOD, new CheckPhoneManager.a() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.PhoneChecker$check$checkPhoneCallback$1
            @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
            public void a(boolean isWhite, boolean isNotBlack, String redirectScheme) {
                Intrinsics.checkNotNullParameter(redirectScheme, "redirectScheme");
                PhoneChecker.this.f("onPhoneCheck success: mapId = " + request.getEnterParams().getMapId() + " mapName = " + request.getEnterParams().getName() + ", checkResult == " + isWhite);
                if (isWhite) {
                    PhoneChecker.this.d(request, lastCheckResult, callback);
                    return;
                }
                CheckPhoneResultHelper checkPhoneResultHelper = CheckPhoneResultHelper.f331480a;
                Context topActivity = Foreground.getTopActivity();
                if (topActivity == null) {
                    topActivity = BaseApplication.getContext();
                }
                Context context = topActivity;
                Intrinsics.checkNotNullExpressionValue(context, "Foreground.getTopActivity()?:MobileQQ.getContext()");
                ZootopiaSource source = request.getSource();
                int mapId = request.getEnterParams().getMapId();
                CheckPhoneManager.EntryType entryType = CheckPhoneManager.EntryType.MOD;
                final PhoneChecker phoneChecker = PhoneChecker.this;
                final EnterModCheckRequest enterModCheckRequest = request;
                final EnterModCheckResult enterModCheckResult = lastCheckResult;
                final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar = callback;
                checkPhoneResultHelper.e(context, source, mapId, entryType, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.PhoneChecker$check$checkPhoneCallback$1$onPhoneResult$1
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
                        if (z16) {
                            PhoneChecker.this.d(enterModCheckRequest, enterModCheckResult, aVar);
                            return;
                        }
                        enterModCheckResult.setResultCode(2);
                        enterModCheckResult.setProcessInner(true);
                        aVar.b(enterModCheckResult);
                    }
                });
                callback.a(lastCheckResult);
            }

            @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
            public void b(boolean z16) {
                CheckPhoneManager.a.C9150a.a(this, z16);
            }
        });
    }
}

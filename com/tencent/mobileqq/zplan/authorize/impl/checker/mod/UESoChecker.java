package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.utils.ad;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/UESoChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "k", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UESoChecker extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final UESoChecker this$0, final EnterModCheckResult lastCheckResult, final com.tencent.mobileqq.zplan.authorize.api.a callback, final EnterModCheckRequest request) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lastCheckResult, "$lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(request, "$request");
        boolean j3 = ad.f335757a.j();
        this$0.f("unzipResult:" + j3);
        if (!j3) {
            this$0.f("so file not exist");
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.UESoChecker$check$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    EnterModCheckResult.this.setResultCode(19);
                    callback.b(EnterModCheckResult.this);
                }
            });
        } else {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.UESoChecker$check$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UESoChecker.this.d(request, lastCheckResult, callback);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "UESoChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(final EnterModCheckRequest request, final EnterModCheckResult lastCheckResult, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        ad adVar = ad.f335757a;
        if (!adVar.g()) {
            d(request, lastCheckResult, callback);
            f(" switch off");
        } else if (adVar.h()) {
            f("exist");
            d(request, lastCheckResult, callback);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.g
                @Override // java.lang.Runnable
                public final void run() {
                    UESoChecker.l(UESoChecker.this, lastCheckResult, callback, request);
                }
            }, 16, null, false);
        }
    }
}

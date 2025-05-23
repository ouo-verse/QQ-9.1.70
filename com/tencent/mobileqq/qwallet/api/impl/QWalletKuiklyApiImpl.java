package com.tencent.mobileqq.qwallet.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule;
import com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyPageRouterModule;
import com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyPopWindowModule;
import com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JJ\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000628\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletKuiklyApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "", "bundleName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "callback", "preloadKuiklyBundle", "clearFinancialOAuthCache", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletKuiklyApiImpl implements IQWalletKuiklyApi {

    @NotNull
    private static final String TAG = "QWalletKuiklyApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadKuiklyBundle$lambda$1(String bundleName, final Function2 function2) {
        Intrinsics.checkNotNullParameter(bundleName, "$bundleName");
        try {
            QLog.i(TAG, 1, "start updateKuikyBundle bundleName:" + bundleName);
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(bundleName, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$preloadKuiklyBundle$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                    invoke2(resError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ResError resError) {
                    Intrinsics.checkNotNullParameter(resError, "resError");
                    QLog.i("QWalletKuiklyApiImpl", 1, "error: " + resError.getCode() + " " + resError.getMessage());
                    Function2<Integer, String, Unit> function22 = function2;
                    if (function22 != null) {
                        function22.invoke(Integer.valueOf(resError.getCode()), resError.getMessage());
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "kuiklyPreLoad exception:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi
    public void clearFinancialOAuthCache() {
        QWalletOAuthLoginManager.f278603a.f();
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi
    public void preloadKuiklyBundle(@NotNull final String bundleName, @Nullable final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                QWalletKuiklyApiImpl.preloadKuiklyBundle$lambda$1(bundleName, callback);
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("QWalletOpenLoginModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new el2.a();
            }
        });
        renderExport.a("QWalletGatewaySSOModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qwallet.kuikly.b();
            }
        });
        renderExport.a("QWalletPageRouterModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$registerExternalModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QWalletKuiklyPageRouterModule();
            }
        });
        renderExport.a("QWalletFinancialModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$registerExternalModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qwallet.kuikly.a();
            }
        });
        renderExport.a("QWalletPopWindowModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$registerExternalModule$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QWalletKuiklyPopWindowModule();
            }
        });
        renderExport.a("QWalletHbModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletKuiklyApiImpl$registerExternalModule$1$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QWalletKuiklyHbModule();
            }
        });
    }
}

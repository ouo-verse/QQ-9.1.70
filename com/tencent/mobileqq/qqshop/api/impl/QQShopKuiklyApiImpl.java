package com.tencent.mobileqq.qqshop.api.impl;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qqshop.api.IQQShopKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JB\u0010\u000e\u001a\u00020\u000428\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/impl/QQShopKuiklyApiImpl;", "Lcom/tencent/mobileqq/qqshop/api/IQQShopKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "", "msg", "callback", "preloadKuiklyBundle", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasCheckRes", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "Companion", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopKuiklyApiImpl implements IQQShopKuiklyApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QWalletKuiklyApiImpl";

    @NotNull
    private final AtomicBoolean hasCheckRes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/impl/QQShopKuiklyApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.api.impl.QQShopKuiklyApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQShopKuiklyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.hasCheckRes = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadKuiklyBundle$lambda$1(final Function2 function2) {
        List<String> listOf;
        try {
            QLog.i(TAG, 1, "start updateKuikyBundle bundleName: qwallet_qqshop, benefits_center");
            IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qwallet_qqshop", "benefits_center"});
            iQQKuiklyDexResApi.updateMultiDexRes(listOf, new Function1<ResError, Unit>(function2) { // from class: com.tencent.mobileqq.qqshop.api.impl.QQShopKuiklyApiImpl$preloadKuiklyBundle$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Integer, String, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$callback = function2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                    invoke2(resError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ResError resError) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) resError);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(resError, "resError");
                    QLog.i("QWalletKuiklyApiImpl", 1, "error: " + resError.getCode() + " " + resError.getMessage());
                    Function2<Integer, String, Unit> function22 = this.$callback;
                    if (function22 != null) {
                        function22.invoke(Integer.valueOf(resError.getCode()), resError.getMessage());
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "kuiklyPreLoad exception:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopKuiklyApi
    public void preloadKuiklyBundle(@Nullable final Function2<? super Integer, ? super String, Unit> callback) {
        boolean z16;
        EcshopConfBean.MsgTabPageConfig msgTabPageConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
            return;
        }
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        if (ecshopConfBean != null && (msgTabPageConfig = ecshopConfBean.msgTabPageConfig) != null) {
            z16 = msgTabPageConfig.shouldPreloadDailyMsgPage;
        } else {
            z16 = false;
        }
        if (z16 && this.hasCheckRes.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQShopKuiklyApiImpl.preloadKuiklyBundle$lambda$1(Function2.this);
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopKuiklyApi
    public void registerExternalModule(@NotNull b renderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) renderExport);
            return;
        }
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("QQShopUIModule", QQShopKuiklyApiImpl$registerExternalModule$1$1.INSTANCE);
        renderExport.a("QQShopMsgModule", QQShopKuiklyApiImpl$registerExternalModule$1$2.INSTANCE);
    }
}

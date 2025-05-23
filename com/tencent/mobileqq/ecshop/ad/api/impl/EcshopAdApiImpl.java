package com.tencent.mobileqq.ecshop.ad.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/ecshop/ad/api/impl/EcshopAdApiImpl;", "Lcom/tencent/mobileqq/ecshop/ad/api/IEcshopAdApi;", "", "getEcshopAdHandlerClassName", "", "updateShopAdAbTest", "<init>", "()V", "Companion", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class EcshopAdApiImpl implements IEcshopAdApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "EcshopAdApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ecshop/ad/api/impl/EcshopAdApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ecshop.ad.api.impl.EcshopAdApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29110);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EcshopAdApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateShopAdAbTest$lambda$0() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(BaseApplication.getContext(), new InitGdtContextParams());
    }

    @Override // com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi
    @NotNull
    public String getEcshopAdHandlerClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String name = EcshopAdHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "EcshopAdHandler::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi
    public void updateShopAdAbTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        BaseQQAppInterface baseQQAppInterface = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ecshop.ad.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                EcshopAdApiImpl.updateShopAdAbTest$lambda$0();
            }
        }, 16, null, false);
        com.tencent.mobileqq.qqshop.message.a.f274473a.v();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        }
        if (baseQQAppInterface != null) {
            BusinessHandler businessHandler = baseQQAppInterface.getBusinessHandler(EcshopAdHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
            ((EcshopAdHandler) businessHandler).f203939d = NetConnInfoCenter.getServerTimeMillis();
        }
    }
}

package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/api/impl/QQGameKuiklyApiImpl;", "Lcom/tencent/mobileqq/qqgamepub/api/IQQGameKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "", "", "bundleList", "updateGamePubAccountKuikly", "<init>", "()V", "Companion", "a", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQGameKuiklyApiImpl implements IQQGameKuiklyApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQGameKuiklyApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/api/impl/QQGameKuiklyApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqgamepub.api.impl.QQGameKuiklyApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQGameKuiklyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameKuiklyApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) renderExport);
            return;
        }
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("QQKuiklyWadlModule", QQGameKuiklyApiImpl$registerExternalModule$1$1.INSTANCE);
        renderExport.a("gamecenter_qzone", QQGameKuiklyApiImpl$registerExternalModule$1$2.INSTANCE);
        renderExport.a("GamePubAccountKuiklyModule", QQGameKuiklyApiImpl$registerExternalModule$1$3.INSTANCE);
        renderExport.a("QQPublicPlatMsgKuiklyModule", QQGameKuiklyApiImpl$registerExternalModule$1$4.INSTANCE);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameKuiklyApi
    public void updateGamePubAccountKuikly(@Nullable List<String> bundleList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundleList);
            return;
        }
        List<String> list = bundleList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i(TAG, 2, "updateGamePubAccountKuikly list" + bundleList);
            QRouteApi api = QRoute.api(IQQKuiklyDexResApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQKuiklyDexResApi::class.java)");
            IQQKuiklyDexResApi.a.a((IQQKuiklyDexResApi) api, bundleList, null, 2, null);
        }
    }
}

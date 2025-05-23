package com.tencent.mobileqq.ecshop.api.impl;

import android.content.Context;
import com.tencent.mobileqq.ecshop.a;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.api.QQShopModule;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/ecshop/api/impl/EcshopUtilApiImpl;", "Lcom/tencent/mobileqq/ecshop/api/IEcshopUtilApi;", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getEcshopIPCModule", "", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$ForbidJumpThirdAppRule;", "getEcshopForbidJumpThirdAppRule", "<init>", "()V", "Companion", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class EcshopUtilApiImpl implements IEcshopUtilApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "EcshopUtilApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ecshop/api/impl/EcshopUtilApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ecshop.api.impl.EcshopUtilApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29162);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EcshopUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ecshop.api.IEcshopUtilApi
    @NotNull
    public List<EcshopConfBean.ForbidJumpThirdAppRule> getEcshopForbidJumpThirdAppRule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        List<EcshopConfBean.ForbidJumpThirdAppRule> list = EcshopConfUtil.getEcshopConfBean().rules;
        Intrinsics.checkNotNullExpressionValue(list, "getEcshopConfBean().rules");
        return list;
    }

    @Override // com.tencent.mobileqq.ecshop.api.IEcshopUtilApi
    @NotNull
    public QIPCModule getEcshopIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        a b16 = a.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance()");
        return b16;
    }

    @Override // com.tencent.mobileqq.ecshop.api.IEcshopUtilApi
    public void jump(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            QQShopModule.k(QQShopModule.f203940a, context, 2, false, null, 12, null);
        }
    }
}

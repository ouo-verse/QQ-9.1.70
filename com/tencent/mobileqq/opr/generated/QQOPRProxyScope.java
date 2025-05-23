package com.tencent.mobileqq.opr.generated;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qne.proxy.QNEBizRequestProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import xc2.b;
import xc2.c;

@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/opr/generated/QQOPRProxyScope;", "", "()V", "PROXY_SERVICES", "", "Ljava/lang/Class;", "qne-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QQOPRProxyScope {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final QQOPRProxyScope INSTANCE;

    @JvmField
    @NotNull
    public static final Map<Class<?>, Class<?>> PROXY_SERVICES;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new QQOPRProxyScope();
        HashMap hashMap = new HashMap();
        PROXY_SERVICES = hashMap;
        hashMap.put(c.class, QNEBizRequestProxy.class);
        hashMap.put(b.class, com.tencent.mobileqq.qne.proxy.b.class);
    }

    QQOPRProxyScope() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

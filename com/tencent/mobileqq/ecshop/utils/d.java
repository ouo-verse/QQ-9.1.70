package com.tencent.mobileqq.ecshop.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/ecshop/utils/d;", "", "", "name", "", "e", RemoteHandleConst.PARAM_DEFAULT_VALUE, "f", "", "c", "Lmqq/app/MobileQQ;", "d", "()Lmqq/app/MobileQQ;", "mobileQQ", "Lmqq/app/AppRuntime;", "a", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "b", "()Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "featureService", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f203953a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f203953a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final AppRuntime a() {
        return d().peekAppRuntime();
    }

    private final IFeatureRuntimeService b() {
        AppRuntime a16 = a();
        if (a16 != null) {
            return (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
        QLog.e("QQShopFeatureSwitch", 1, "peekAppRuntime is null");
        return null;
    }

    private final MobileQQ d() {
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        return sMobileQQ;
    }

    @Nullable
    public final Map<String, String> c(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        IFeatureRuntimeService b16 = b();
        if (b16 == null) {
            return null;
        }
        return b16.isEnabledWithDataSet(name, null);
    }

    public final boolean e(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(name, "name");
        IFeatureRuntimeService b16 = b();
        if (b16 == null) {
            return false;
        }
        return b16.isFeatureSwitchEnable(name, false);
    }

    public final boolean f(@NotNull String name, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, name, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(name, "name");
        IFeatureRuntimeService b16 = b();
        if (b16 != null) {
            return b16.isFeatureSwitchEnable(name, defaultValue);
        }
        return defaultValue;
    }
}

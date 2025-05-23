package com.tencent.mobileqq.profilecard.base.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/profilecard/base/config/ProfileEntranceConfigLoader;", "", "()V", "cacheBean", "Lcom/tencent/mobileqq/profilecard/base/config/ProfileEntranceConfigData;", "lastReqUid", "", JoinPoint.SYNCHRONIZATION_LOCK, "getConfig", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileEntranceConfigLoader {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final ProfileEntranceConfigLoader INSTANCE;

    @NotNull
    private static ProfileEntranceConfigData cacheBean;

    @NotNull
    private static String lastReqUid;

    @NotNull
    private static final Object lock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59677);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new ProfileEntranceConfigLoader();
        lastReqUid = "";
        cacheBean = new ProfileEntranceConfigData();
        lock = new Object();
    }

    ProfileEntranceConfigLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final ProfileEntranceConfigData getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProfileEntranceConfigData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (lock) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return cacheBean;
            }
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekA\u2026ime() ?: return cacheBean");
            String currentReqUid = peekAppRuntime.getCurrentUid();
            if (!Intrinsics.areEqual(currentReqUid, lastReqUid)) {
                IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("profile_entrance_config_381");
                Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.profilecard.base.config.ProfileEntranceConfigData");
                cacheBean = (ProfileEntranceConfigData) loadConfig;
                Intrinsics.checkNotNullExpressionValue(currentReqUid, "currentReqUid");
                lastReqUid = currentReqUid;
            }
            return cacheBean;
        }
    }
}

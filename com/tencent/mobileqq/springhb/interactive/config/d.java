package com.tencent.mobileqq.springhb.interactive.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/d;", "", "Lcom/tencent/mobileqq/springhb/entry/model/DragonCardConfigData;", "b", "", "a", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f289234a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f289234a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull DragonCardConfigData dragonCardConfigData) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dragonCardConfigData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dragonCardConfigData, "<this>");
        TimeInfo timeInfo = dragonCardConfigData.timeInfo;
        Long l16 = null;
        if (timeInfo != null) {
            l3 = Long.valueOf(timeInfo.begin);
        } else {
            l3 = null;
        }
        TimeInfo timeInfo2 = dragonCardConfigData.timeInfo;
        if (timeInfo2 != null) {
            l16 = Long.valueOf(timeInfo2.end);
        }
        if (l3 != null && l16 != null) {
            boolean isCurTimeInTime = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isCurTimeInTime(new TimeInfo(l3.longValue(), l16.longValue()));
            if (!isCurTimeInTime) {
                QLog.d("ManagerConfig", 1, "no in springTime");
            }
            return isCurTimeInTime;
        }
        QLog.e("ManagerConfig", 1, "checkTimeEffective begin " + l3 + "  end " + l16);
        return false;
    }

    @Nullable
    public final DragonCardConfigData b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DragonCardConfigData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ManagerConfig", 1, "peekAppRuntime is Null!!");
            return null;
        }
        DragonCardConfigData dragonCardConfig = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getDragonCardConfig(peekAppRuntime);
        if (dragonCardConfig == null) {
            QLog.e("ManagerConfig", 1, " getAnimationFlappyConfig is Null!!");
        } else {
            QLog.d("ManagerConfig", 1, " getAnimationFlappyConfig " + dragonCardConfig);
        }
        return dragonCardConfig;
    }
}

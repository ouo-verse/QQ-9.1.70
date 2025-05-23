package com.tencent.qqnt;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.push.ITroopPushInnerService;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/f;", "", "Lmqq/app/api/IRuntimeService;", "T", "Ljava/lang/Class;", "cls", "d", "(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;", "Lcom/tencent/qqnt/kernel/api/s;", "b", "()Lcom/tencent/qqnt/kernel/api/s;", "groupService", "Lcom/tencent/qqnt/inner/ITroopInfoInnerService;", "e", "()Lcom/tencent/qqnt/inner/ITroopInfoInnerService;", "troopInfoInnerService", "Lcom/tencent/qqnt/push/ITroopPushInnerService;", "g", "()Lcom/tencent/qqnt/push/ITroopPushInnerService;", "troopPushService", "Lcom/tencent/qqnt/notification/ITroopNotificationInnerService;", "f", "()Lcom/tencent/qqnt/notification/ITroopNotificationInnerService;", "troopNotificationService", "Lcom/tencent/qqnt/kernel/api/w;", "c", "()Lcom/tencent/qqnt/kernel/api/w;", "msgService", "Lcom/tencent/common/app/AppInterface;", "a", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f356721a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f356721a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final <T extends IRuntimeService> T d(Class<T> cls) {
        String str;
        boolean z16;
        MobileQQ mobileQQ;
        AppRuntime peekAppRuntime;
        AppRuntime peekAppRuntime2;
        try {
            MobileQQ mobileQQ2 = MobileQQ.sMobileQQ;
            if (mobileQQ2 != null && (peekAppRuntime2 = mobileQQ2.peekAppRuntime()) != null) {
                str = peekAppRuntime2.getAccount();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
                if (!z16 || (mobileQQ = MobileQQ.sMobileQQ) == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) {
                    return null;
                }
                return (T) peekAppRuntime.getRuntimeService(cls, "all");
            }
            z16 = true;
            if (!z16) {
                return null;
            }
            return (T) peekAppRuntime.getRuntimeService(cls, "all");
        } catch (Exception e16) {
            QLog.e("TroopServiceGetter", 1, "cls: " + cls, e16);
            return null;
        }
    }

    @Nullable
    public final AppInterface a() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AppInterface) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (!(appRuntime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) appRuntime;
    }

    @Nullable
    public final s b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (s) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        IKernelService iKernelService = (IKernelService) d(IKernelService.class);
        if (iKernelService != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    @Nullable
    public final w c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (w) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        IKernelService iKernelService = (IKernelService) d(IKernelService.class);
        if (iKernelService != null) {
            return iKernelService.getMsgService();
        }
        return null;
    }

    @Nullable
    public final ITroopInfoInnerService e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ITroopInfoInnerService) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (ITroopInfoInnerService) d(ITroopInfoInnerService.class);
    }

    @Nullable
    public final ITroopNotificationInnerService f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ITroopNotificationInnerService) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (ITroopNotificationInnerService) d(ITroopNotificationInnerService.class);
    }

    @Nullable
    public final ITroopPushInnerService g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ITroopPushInnerService) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (ITroopPushInnerService) d(ITroopPushInnerService.class);
    }
}

package com.tencent.mobileqq.dt.web;

import android.os.Bundle;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b!\u0010\"J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\rJ1\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0019H\u0014J\u0012\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001bH\u0016R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3BusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "event", "params", "Lcom/tencent/mobileqq/dt/web/a;", "observer", "", Constants.BASE_IN_PLUGIN_VERSION, "cmd", "F2", "", "data", "Lcom/tencent/mobileqq/app/BusinessObserver;", Constants.MMCCID, "", "timeout", "E2", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/dt/web/a;Ljava/lang/Long;)V", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "onReceive", "Ljava/lang/Class;", "observerClass", "", "getCommandList", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class O3BusinessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3BusinessHandler$a;", "", "", "ERROR_APP_NULL", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.web.O3BusinessHandler$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public O3BusinessHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.app = appInterface;
        }
    }

    public final void D2(@NotNull String event, @NotNull String params, @Nullable a observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, event, params, observer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        E2(event, params, observer, null);
    }

    public final void E2(@NotNull String event, @NotNull String params, @Nullable a observer, @Nullable Long timeout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, event, params, observer, timeout);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.app == null) {
            QLog.e("FEKit_O3BusinessHandler", 1, "sendRequest but app is null");
            if (observer != null) {
                observer.b(1007, new byte[0]);
                return;
            }
            return;
        }
        MsfServiceSdk msfServiceSdk = MsfServiceSdk.get();
        String currentAccountUin = getCurrentAccountUin();
        if (currentAccountUin == null) {
            currentAccountUin = "0";
        }
        ToServiceMsg secDispatchEventMsg = msfServiceSdk.getSecDispatchEventMsg(currentAccountUin);
        if (observer != null) {
            Map<Long, BusinessObserver> observerMap = this.uiObserverMap;
            Intrinsics.checkNotNullExpressionValue(observerMap, "observerMap");
            synchronized (observerMap) {
                observerMap.put(Long.valueOf(this.seq), observer);
                Bundle bundle = secDispatchEventMsg.extraData;
                String str = BaseBusinessHandler.SEQ_KEY;
                long j3 = this.seq;
                this.seq = 1 + j3;
                bundle.putLong(str, j3);
                Unit unit = Unit.INSTANCE;
            }
            observer.c(this);
        }
        secDispatchEventMsg.addAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD, event);
        secDispatchEventMsg.addAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM, params);
        if (observer != null) {
            z16 = true;
        }
        secDispatchEventMsg.setNeedCallback(z16);
        if (timeout != null) {
            secDispatchEventMsg.setTimeout(timeout.longValue());
        }
        NewIntent newIntent = new NewIntent(this.app.getApp(), b.class);
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), secDispatchEventMsg);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    public final void F2(@NotNull String cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cmd);
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        if (this.app == null) {
            QLog.e("FEKit_O3BusinessHandler", 1, "sendSSORequest but app is null");
            return;
        }
        String msfServiceName = MsfServiceSdk.get().getMsfServiceName();
        String currentAccountUin = getCurrentAccountUin();
        if (currentAccountUin == null) {
            currentAccountUin = "0";
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(msfServiceName, currentAccountUin, cmd);
        NewIntent newIntent = new NewIntent(this.app.getApp(), b.class);
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    public final void G2(@NotNull String cmd, @NotNull byte[] data, @NotNull BusinessObserver observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, cmd, data, observer);
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.app == null) {
            QLog.e("FEKit_O3BusinessHandler", 1, "sendRequest but app is null");
            return;
        }
        ToServiceMsg createToServiceMsg = super.createToServiceMsg(cmd, observer);
        createToServiceMsg.putWupBuffer(data);
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        this.app.sendToService(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @Nullable
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("trpc.o3.full_social_lock_punish.FullSocialLockPunish.SsoVerifyAndUnLock");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoEstablishShareKey");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureAccess");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureA2Access");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureA2Establish");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        notifyUI(req, 0, true, (Object) res);
    }
}

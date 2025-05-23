package com.tencent.mobileqq.thirdsig.api.impl;

import android.os.Bundle;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.msf.core.auth.NTAccountSigInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.thirdsig.api.IOpenSigInjectService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.TicketManagerImpl;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/impl/OpenSigInjectServiceImpl;", "Lcom/tencent/mobileqq/thirdsig/api/IOpenSigInjectService;", "", "uin", "Lcom/tencent/mobileqq/thirdsig/api/a;", "callback", "", "commitOpenTicketToMsf", "<init>", "()V", "Companion", "a", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class OpenSigInjectServiceImpl implements IOpenSigInjectService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "OpenSigInjectServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/impl/OpenSigInjectServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.thirdsig.api.impl.OpenSigInjectServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/OpenSigInjectServiceImpl$b", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements MainTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f292825a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f292826b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.thirdsig.api.a f292827c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TicketManager f292828d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/OpenSigInjectServiceImpl$b$a", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class a implements MainTicketCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.thirdsig.api.a f292829a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f292830b;

            a(com.tencent.mobileqq.thirdsig.api.a aVar, String str) {
                this.f292829a = aVar;
                this.f292830b = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) str);
                }
            }

            @Override // mqq.manager.MainTicketCallback
            public void onFail(int errorCode, @Nullable String errorMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                    return;
                }
                this.f292829a.onFail(-1, errorMsg + ", and QQ A2 is not exist");
            }

            @Override // mqq.manager.MainTicketCallback
            public void onSuccess(@Nullable MainTicketInfo info) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                    return;
                }
                this.f292829a.onFail(-1, this.f292830b + ", but QQ A2 is exist");
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/OpenSigInjectServiceImpl$b$b", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.thirdsig.api.impl.OpenSigInjectServiceImpl$b$b, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static final class C8647b implements BusinessObserver {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.thirdsig.api.a f292831d;

            C8647b(com.tencent.mobileqq.thirdsig.api.a aVar) {
                this.f292831d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
                }
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int type, boolean isSuccess, @Nullable Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), bundle);
                } else if (isSuccess) {
                    QLog.d(OpenSigInjectServiceImpl.TAG, 2, "requestSetMsfTicket success");
                    this.f292831d.onSuccess();
                } else {
                    this.f292831d.onFail(-1, "inject sig to msf fail");
                }
            }
        }

        b(long j3, AppRuntime appRuntime, com.tencent.mobileqq.thirdsig.api.a aVar, TicketManager ticketManager) {
            this.f292825a = j3;
            this.f292826b = appRuntime;
            this.f292827c = aVar;
            this.f292828d = ticketManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), appRuntime, aVar, ticketManager);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e(OpenSigInjectServiceImpl.TAG, 1, this.f292825a + " getMainTicket fail, errorCode = " + errorCode + ", errorMsg = " + errorMsg);
            try {
                this.f292828d.getA2(this.f292825a, 16, new a(this.f292827c, errorMsg));
            } catch (Exception unused) {
                com.tencent.mobileqq.thirdsig.api.a aVar = this.f292827c;
                if (errorMsg == null) {
                    errorMsg = "get sig fail";
                }
                aVar.onFail(-1, errorMsg);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@NotNull MainTicketInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            QLog.i(OpenSigInjectServiceImpl.TAG, 1, this.f292825a + " getMainTicket success");
            NTAccountSigInfo nTAccountSigInfo = new NTAccountSigInfo();
            nTAccountSigInfo.setUin(this.f292825a);
            nTAccountSigInfo.setUinType(6);
            nTAccountSigInfo.setA2(HexUtil.hexStr2Bytes(info.getA2()));
            nTAccountSigInfo.setD2(info.getD2());
            nTAccountSigInfo.setD2key(info.getD2Key());
            ToServiceMsg injectSigToMsf = MsfServiceSdk.get().injectSigToMsf(nTAccountSigInfo);
            NewIntent newIntent = new NewIntent(this.f292826b.getApplication(), com.tencent.mobileqq.thirdsig.api.impl.a.class);
            newIntent.withouLogin = true;
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), injectSigToMsf);
            newIntent.setObserver(new C8647b(this.f292827c));
            this.f292826b.startServlet(newIntent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public OpenSigInjectServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IOpenSigInjectService
    public void commitOpenTicketToMsf(long uin, @NotNull com.tencent.mobileqq.thirdsig.api.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(uin), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = peekAppRuntime.getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        TicketManager ticketManager = (TicketManager) manager;
        ticketManager.getMainTicket(uin, TicketManagerImpl.BUFLAG_OPEN_CONNECT, new b(uin, peekAppRuntime, callback, ticketManager));
    }
}

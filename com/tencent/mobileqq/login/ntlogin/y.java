package com.tencent.mobileqq.login.ntlogin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.msf.core.auth.NTAccountSigInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.Account;
import com.tencent.qqnt.kernel.nativeinterface.AppInfo;
import com.tencent.qqnt.kernel.nativeinterface.ILoginRefreshTicketCallback;
import com.tencent.qqnt.kernel.nativeinterface.LoginErrorCode;
import com.tencent.qqnt.kernel.nativeinterface.RefreshTicketResult;
import com.tencent.qqnt.kernel.nativeinterface.UserProfile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJZ\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/y;", "", "Lmqq/app/AppRuntime;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/RefreshTicketResult;", "resultInfo", "", "f", "l", "Lcom/tencent/mobileqq/msf/core/auth/NTAccountSigInfo;", "ticketInfo", "Lcom/tencent/mobileqq/login/ntlogin/a;", "callback", "d", "", "forceRefresh", tl.h.F, "", "account", "isHost", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errMsg", "i", "", "", "b", "[Ljava/lang/Integer;", "KICK_ACCOUNT_CODE", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f242393a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Integer[] KICK_ACCOUNT_CODE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/login/ntlogin/y$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("NTLoginTicketManager", 2, "onApplicationForeground refresh ticket");
                y.f242393a.h(false);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, isEnabled);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/login/ntlogin/y$b", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.login.ntlogin.a f242395d;

        b(com.tencent.mobileqq.login.ntlogin.a aVar) {
            this.f242395d = aVar;
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
                QLog.d("NTLoginTicketManager", 2, "requestSetMsfTicket success");
                this.f242395d.onSuccess();
            } else {
                this.f242395d.onFail(-1, "\u7968\u636e\u8bbe\u7f6e\u5931\u8d25");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/login/ntlogin/y$c", "Lcom/tencent/mobileqq/login/ntlogin/a;", "", "onSuccess", "", "retCode", "", "errMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements com.tencent.mobileqq.login.ntlogin.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f242396a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f242396a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.login.ntlogin.a
        public void onFail(int retCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, retCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("NTLoginTicketManager", 1, "refresh ticket onFail retCode: " + retCode);
            Function2<Boolean, String, Unit> function2 = this.f242396a;
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, "refresh ticket onFail");
            }
        }

        @Override // com.tencent.mobileqq.login.ntlogin.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("NTLoginTicketManager", 1, "refresh ticket onSuccess ");
            Function2<Boolean, String, Unit> function2 = this.f242396a;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, "refresh ticket onSuccess");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f242393a = new y();
        KICK_ACCOUNT_CODE = new Integer[]{Integer.valueOf(LoginErrorCode.KLOGINERROREXPIRETICKET), Integer.valueOf(LoginErrorCode.KLOGINERRORKICKEDTICKET), Integer.valueOf(LoginErrorCode.KLOGINERRORILLAGETICKET), Integer.valueOf(LoginErrorCode.KLOGINERRORSECBEAT), 150022031};
        GuardManagerCallbackDispatcher.registerCallBack(new a());
    }

    y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final AppRuntime e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return peekAppRuntime;
    }

    private final void f(RefreshTicketResult resultInfo) {
        QLog.d("NTLoginTicketManager", 2, "kickAccount refresh ret: " + resultInfo.errorInfo.errCode);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.w
            @Override // java.lang.Runnable
            public final void run() {
                y.g();
            }
        }, 16, null, true);
        MsfSdkUtils.updateSimpleAccount(e().getCurrentUin(), false);
        MobileQQ.sMobileQQ.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        l(resultInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        y yVar = f242393a;
        NewIntent newIntent = new NewIntent(yVar.e().getApplicationContext(), BuiltInServlet.class);
        newIntent.putExtra("action", 2218);
        newIntent.putExtra("uin", yVar.e().getCurrentUin());
        newIntent.putExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD, "onKicked");
        newIntent.putExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM, yVar.e().getCurrentUin());
        yVar.e().startServlet(newIntent);
        QLog.d("mqq", 1, "kicked ... send to msf");
    }

    public static /* synthetic */ void j(y yVar, long j3, boolean z16, boolean z17, Function2 function2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function2 = null;
        }
        yVar.i(j3, z16, z17, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function2 function2, boolean z16, int i3, String errMsg, RefreshTicketResult refreshTicketResult) {
        boolean z17;
        boolean z18;
        boolean z19;
        UserProfile userProfile;
        boolean contains;
        if (i3 != 0) {
            QLog.e("NTLoginTicketManager", 1, "refreshLoginUinTicket failed code: " + i3 + ", errMsg: " + errMsg);
            if (function2 != null) {
                Boolean bool = Boolean.FALSE;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                function2.invoke(bool, errMsg);
                return;
            }
            return;
        }
        if (refreshTicketResult == null) {
            QLog.e("NTLoginTicketManager", 1, "refreshLoginUinTicket refreshResult is null!");
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, "refreshResult is null!");
                return;
            }
            return;
        }
        int errCode = refreshTicketResult.getErrorInfo().getErrCode();
        String ssoErrMsg = refreshTicketResult.getErrorInfo().getErrMsg();
        if (errCode != 0) {
            QLog.d("NTLoginTicketManager", 2, "refreshLoginUinTicket failed code: " + errCode + ", errMsg: " + ssoErrMsg);
            if (errCode == 150022031) {
                MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), MobileQQ.FILE_COMMON)");
                from.encodeBool("login_hard_use_wt" + AppSetting.f99551k, true);
            }
            contains = ArraysKt___ArraysKt.contains(KICK_ACCOUNT_CODE, Integer.valueOf(errCode));
            if (contains) {
                f242393a.f(refreshTicketResult);
            }
            if (function2 != null) {
                Boolean bool2 = Boolean.FALSE;
                Intrinsics.checkNotNullExpressionValue(ssoErrMsg, "ssoErrMsg");
                function2.invoke(bool2, ssoErrMsg);
                return;
            }
            return;
        }
        byte[] bArr = refreshTicketResult.ticket.f359194d2;
        Intrinsics.checkNotNullExpressionValue(bArr, "refreshResult.ticket.d2");
        int i16 = 0;
        if (bArr.length == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            byte[] bArr2 = refreshTicketResult.ticket.f359193a2;
            Intrinsics.checkNotNullExpressionValue(bArr2, "refreshResult.ticket.a2");
            if (bArr2.length == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                byte[] bArr3 = refreshTicketResult.ticket.f359193a2;
                Intrinsics.checkNotNullExpressionValue(bArr3, "refreshResult.ticket.a2");
                if (bArr3.length == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    if (!z16) {
                        i16 = 6;
                    }
                    NTAccountSigInfo nTAccountSigInfo = new NTAccountSigInfo();
                    nTAccountSigInfo.setUin(refreshTicketResult.account.uin);
                    nTAccountSigInfo.setUid(refreshTicketResult.account.uid);
                    nTAccountSigInfo.setUinType(i16);
                    nTAccountSigInfo.setA2(refreshTicketResult.getTicket().getA2());
                    nTAccountSigInfo.setD2(refreshTicketResult.getTicket().getD2());
                    nTAccountSigInfo.setD2key(refreshTicketResult.getTicket().getD2Key());
                    Account account = refreshTicketResult.account;
                    if (account != null && (userProfile = account.userProfile) != null && userProfile.registerWithoutPwd) {
                        long j3 = account.uin;
                        if (j3 > 0) {
                            QLog.d("NTLoginTicketManager", 1, "account has not password account: " + j3);
                            ag.f242225a.u(String.valueOf(account.uin), true);
                        }
                    }
                    if (!z16) {
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, "refresh ticket onSuccess");
                            return;
                        }
                        return;
                    }
                    f242393a.d(nTAccountSigInfo, new c(function2));
                    return;
                }
            }
        }
        QLog.d("NTLoginTicketManager", 1, "refreshLoginUinTicket don't need refresh");
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, "don't need refresh");
        }
    }

    private final void l(RefreshTicketResult resultInfo) {
        if (e().isLogin()) {
            e().ntTriggerLogout(Constants.LogoutReason.expired);
        }
        final Intent intent = new Intent();
        intent.setAction(NewIntent.ACTION_KICK_TO_LOGIN);
        intent.putExtra("login_page_action", NewIntent.ACTION_ACCOUNT_EXPIRED);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        intent.setAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent.putExtra("reason", Constants.LogoutReason.expired);
        intent.putExtra("title", "");
        intent.putExtra("msg", resultInfo.errorInfo.errMsg);
        intent.putExtra("isSameDevice", false);
        intent.addFlags(268435456);
        if (e().isClearTaskBySystem && e().isBackgroundStop) {
            QLog.d("NTLoginTicketManager", 1, "kicked samedevice and set kickIntent");
            QLog.d("NTLoginTicketManager", 1, "isClearTaskBySystem=" + e().isClearTaskBySystem + " isBackgroundStop= " + e().isBackgroundStop);
            e().setKickIntent(intent);
            return;
        }
        boolean onReceiveUnhandledKickedMsg = e().onReceiveUnhandledKickedMsg(NewIntent.ACTION_ACCOUNT_KICKED, intent);
        if (!onReceiveUnhandledKickedMsg) {
            e().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.x
                @Override // java.lang.Runnable
                public final void run() {
                    y.m(intent);
                }
            });
        }
        QLog.d("NTLoginTicketManager", 1, "kicked start notification...... handle: ", Boolean.valueOf(onReceiveUnhandledKickedMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Intent notifyIntent) {
        Intrinsics.checkNotNullParameter(notifyIntent, "$notifyIntent");
        MobileQQ.sMobileQQ.startActivity(notifyIntent);
        QLog.d("NTLoginTicketManager", 1, "kicked start notification......");
    }

    public final void d(@NotNull NTAccountSigInfo ticketInfo, @NotNull com.tencent.mobileqq.login.ntlogin.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ticketInfo, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(ticketInfo, "ticketInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ToServiceMsg injectSigToMsf = MsfServiceSdk.get().injectSigToMsf(ticketInfo);
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), com.tencent.mobileqq.login.ntlogin.msfserver.a.class);
        newIntent.withouLogin = true;
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), injectSigToMsf);
        newIntent.setObserver(new b(callback));
        peekAppRuntime.startServlet(newIntent);
    }

    public final void h(boolean forceRefresh) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, forceRefresh);
            return;
        }
        if (!MobileQQ.sMobileQQ.isLoginByNT()) {
            QLog.d("NTLoginTicketManager", 2, "refreshLoginUinTicket nt login switch is close!");
            return;
        }
        if (e().isLogin()) {
            String account = e().getAccount();
            if (account != null && account.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String account2 = e().getAccount();
                Intrinsics.checkNotNullExpressionValue(account2, "getAppRuntime().account");
                j(this, Long.parseLong(account2), true, forceRefresh, null, 8, null);
                return;
            }
        }
        QLog.d("NTLoginTicketManager", 2, "refreshLoginUinTicket no login");
    }

    public final void i(long account, final boolean isHost, boolean forceRefresh, @Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(account), Boolean.valueOf(isHost), Boolean.valueOf(forceRefresh), callback);
            return;
        }
        if (!MobileQQ.sMobileQQ.isLoginByNT()) {
            QLog.d("NTLoginTicketManager", 1, "refreshLoginUinTicket nt login switch is close!");
            if (callback != null) {
                callback.invoke(Boolean.FALSE, "nt login switch is close!");
                return;
            }
            return;
        }
        QLog.d("NTLoginTicketManager", 1, "refreshTicketByUin uin: " + account + ", isHost: " + isHost + ", forceRefresh:" + forceRefresh);
        AppInfo appInfo = new AppInfo();
        if (isHost) {
            j3 = 16;
        } else {
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        }
        appInfo.appId = j3;
        appInfo.appName = "com.tencent.mobileqq";
        appInfo.qua = BaseApplication.getContext().getQua();
        ((ILoginService) QRoute.api(ILoginService.class)).refreshLoginTicketsByUin(account, appInfo, forceRefresh, new ILoginRefreshTicketCallback() { // from class: com.tencent.mobileqq.login.ntlogin.v
            @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginRefreshTicketCallback
            public final void onResult(int i3, String str, RefreshTicketResult refreshTicketResult) {
                y.k(Function2.this, isHost, i3, str, refreshTicketResult);
            }
        });
    }
}

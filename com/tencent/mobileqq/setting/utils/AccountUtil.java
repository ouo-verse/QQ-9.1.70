package com.tencent.mobileqq.setting.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ae;
import com.tencent.mobileqq.utils.at;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ci;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J0\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010R\u001b\u0010\u0017\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/AccountUtil;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "uin", "", "g", "delUin", "", "isDeleteHistory", "c", "peerUin", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "callback", "d", "b", "Lkotlin/Lazy;", tl.h.F, "()Z", "isRemoveSwitchOn", "<init>", "()V", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AccountUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final AccountUtil f286728a = new AccountUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy isRemoveSwitchOn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/AccountUtil$a;", "Lcom/tencent/mobileqq/loginregister/servlet/b;", "", "isSuccess", "", "b", "", "e", "Ljava/lang/String;", "delUin", "f", "Z", "isDelHistory", "isDelete", "<init>", "(Ljava/lang/String;Z)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends com.tencent.mobileqq.loginregister.servlet.b {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final String delUin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isDelHistory;

        public a(String delUin, boolean z16) {
            Intrinsics.checkNotNullParameter(delUin, "delUin");
            this.delUin = delUin;
            this.isDelHistory = z16;
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.b
        public void b(boolean isSuccess) {
            QLog.i("AccountUtil", 1, "DelHistoryAccountObserver onDeleteAccount isSuccess " + isSuccess + ",peerUin:" + this.delUin + ",isDeleteHistory:" + this.isDelHistory);
            String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
            if (isSuccess && lastLoginUin != null && Intrinsics.areEqual(lastLoginUin, this.delUin)) {
                MobileQQ.sMobileQQ.setLastLoginUin("");
                if (QLog.isColorLevel()) {
                    QLog.d("Switch_Account", 2, "delete Last_Login");
                }
            }
            if (isSuccess && this.isDelHistory) {
                AccountUtil.f286728a.f(this.delUin);
            }
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.setting.utils.AccountUtil$isRemoveSwitchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("switch_remove_old_delete_msg_history", true);
                QLog.i("AccountUtil", 1, "isRemoveSwitchOn " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        isRemoveSwitchOn = lazy;
    }

    AccountUtil() {
    }

    private final void c(String delUin, boolean isDeleteHistory) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(ILoginServletService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app\n            .getRunt\u2026ava, ProcessConstant.ALL)");
        ((ILoginServletService) runtimeService).deleteAccount(delUin, qQAppInterface.getUinDisplayNameBeforeLogin(delUin), new a(delUin, isDeleteHistory));
        QLog.i("AccountUtil", 1, "delAccountRecord " + delUin);
        if (isDeleteHistory) {
            com.tencent.mobileqq.nearby.i.b(delUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str, boolean z16, QQAppInterface app, Function0 callback) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        OpenProxy.c().b(str);
        if (z16) {
            ProxyManager proxyManager = app.getProxyManager();
            Intrinsics.checkNotNullExpressionValue(proxyManager, "app.getProxyManager()");
            proxyManager.transSaveToDatabase();
            try {
                String uid = ((IUidService) QRoute.api(IUidService.class)).getUid(str);
                if (!TextUtils.isEmpty(uid)) {
                    ci.k().ClearMoblieQQAccountData(uid);
                }
            } catch (Exception e16) {
                QLog.e("AccountUtil", 1, "clear nt data error:", e16);
            }
            if (!f286728a.h()) {
                new com.tencent.mobileqq.managers.c().a(str);
            }
            ae.a().c(app.getApp(), str, false);
        }
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String peerUin) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountUtil", 2, "----clear_sp----deleteDataFromSP: uin:" + peerUin);
        }
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.peekAppRuntime().getApp().getSharedPreferences(peerUin, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "app.getApp().getSharedPr\u2026xt.MODE_PRIVATE\n        )");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
        try {
            String uid = ((IUidService) QRoute.api(IUidService.class)).getUid(peerUin);
            Intent intent = new Intent("qmmkv.action.account_cleanup");
            intent.setPackage(MobileQQ.PACKAGE_NAME);
            intent.putExtra("uin", peerUin);
            intent.putExtra("uid", uid);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
        } catch (Exception e16) {
            QLog.e("AccountUtil", 1, "get uid error:", e16);
        }
    }

    private final void g(QQAppInterface app, String uin) {
        IRuntimeService runtimeService = app.getRuntimeService(ISubAccountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IS\u2026va, ProcessConstant.MAIN)");
        ISubAccountService iSubAccountService = (ISubAccountService) runtimeService;
        if (iSubAccountService.isSubAccountUin(uin)) {
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(app, (byte) 0, uin);
            iSubAccountService.clearUnreadNum(uin);
            iSubAccountService.updateA2(uin, null, true);
            iSubAccountService.setStatus(uin, 2);
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(app, uin, 7);
            int R = 1 - app.getConversationFacade().R(uin, 7000);
            if (R != 0) {
                app.getConversationFacade().c0(uin, 7000, R);
            }
        }
    }

    private final boolean h() {
        return ((Boolean) isRemoveSwitchOn.getValue()).booleanValue();
    }

    public final void d(final String uin, final boolean isDeleteHistory, Activity activity, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uin == null || activity == null || TextUtils.isEmpty(uin)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (Intrinsics.areEqual(uin, currentAccountUin)) {
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(activity, true);
        }
        c(uin, isDeleteHistory);
        at.a(uin);
        CrmUtils.g(activity, currentAccountUin);
        g(qQAppInterface, uin);
        BaseGesturePWDUtil.clearGestureData(activity, uin);
        if (Intrinsics.areEqual(uin, currentAccountUin)) {
            qQAppInterface.getApplication().refreAccountList();
            List<SimpleAccount> allAccounts = qQAppInterface.getApplication().getAllAccounts();
            Intrinsics.checkNotNullExpressionValue(allAccounts, "app.application.allAccounts");
            if (!allAccounts.isEmpty()) {
                SimpleAccount simpleAccount = allAccounts.get(0);
                if (simpleAccount.isLogined()) {
                    qQAppInterface.startPCActivePolling(simpleAccount.getUin(), "delAccount");
                }
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.setting.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                AccountUtil.e(uin, isDeleteHistory, qQAppInterface, callback);
            }
        }, 8, null, true);
    }
}

package com.tencent.mobileqq.leba.business;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.leba.impl.LebaHelperServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\u0006*\u0001\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/leba/business/j;", "", "", "uin", "", "e", "value", "", "g", "b", "c", "a", "d", "f", "Z", "register", "newGuideWordingShow", "isInit", "com/tencent/mobileqq/leba/business/j$a", "Lcom/tencent/mobileqq/leba/business/j$a;", "accountChangedCallback", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f240113a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean register;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean newGuideWordingShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a accountChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/leba/business/j$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements IAccountCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
            } else {
                j.f240113a.a();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
            } else {
                j.f240113a.a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f240113a = new j();
        newGuideWordingShow = true;
        accountChangedCallback = new a();
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e("LebaTabRedTouchHelper", 1, "[RunTime] failed");
        } else {
            MobileQQ.sMobileQQ.registerAccountCallback(accountChangedCallback);
            register = true;
        }
    }

    private final boolean e(String uin) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.isAccessible()) {
            return false;
        }
        return from.decodeBool("newGuideWordingKey" + uin, true);
    }

    private final void g(String uin, boolean value) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.isAccessible()) {
            return;
        }
        from.encodeBool("newGuideWordingKey" + uin, value);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        isInit = false;
        QLog.i("LebaTabRedTouchHelper", 1, "account " + c());
    }

    public final boolean c() {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!isInit && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            String currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            newGuideWordingShow = e(currentUin);
            isInit = true;
        }
        if (!register) {
            b();
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        return newGuideWordingShow;
    }

    public final void d() {
        IRedTouchManager iRedTouchManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessInfoCheckUpdate.AppInfo appInfo = null;
        if (peekAppRuntime != null) {
            iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        } else {
            iRedTouchManager = null;
        }
        if (iRedTouchManager != null) {
            appInfo = iRedTouchManager.getAppInfoByPath(String.valueOf(LebaHelperServiceImpl.redTouchDongTaiPath));
        }
        if (appInfo != null && peekAppRuntime != null && com.tencent.mobileqq.tianshu.ui.b.d(appInfo) && c()) {
            newGuideWordingShow = false;
            String currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            g(currentUin, newGuideWordingShow);
        }
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        BusinessInfoCheckUpdate.RedTypeInfo a16 = k.f240118a.a();
        if (a16 == null || a16.red_type.get() != 98 || !c()) {
            return false;
        }
        return true;
    }
}

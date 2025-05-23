package com.tencent.mobileqq.login.api.impl;

import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.login.ntlogin.y;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.msf.core.auth.api.UIDFileUtil;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0019\u0010\u0016\u001a\u00020\f2\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0082\bJ\u0019\u0010\u0017\u001a\u00020\f2\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0082\bJ\b\u0010\u0018\u001a\u00020\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010 \u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\"\u0010(\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010'H\u0016R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/login/api/impl/UidServiceImpl;", "Lcom/tencent/mobileqq/login/api/IUidService;", "Lmqq/app/IAccountCallback;", "", "getAutoLoginUinAtLaunch", "getCurrentUin", "Lmqq/app/AppRuntime;", "newRuntime", "", "isAccountChangedRepeat", "uid", "appRuntime", "", "dispatchUidChangedEvent", "uin", "dispatchUidUpdateFailEvent", "isRepeatDispatch", "startRequestUid", "kickToLoginPage", "closeUidBlockSwitch", "Lkotlin/Function0;", "block", "runOnUiThread", "runOnSubThread", "initUid", "getCurrentUid", "getUid", "Le72/d;", "callback", "registerUidCallback", "unregisterUidCallback", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "logoutWhenReqUidFail", "", "timeout", "Le72/c;", "requestUid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "callbackList", "Ljava/util/List;", "loginAppRuntimeWhenInit", "Lmqq/app/AppRuntime;", "", "loginTimeWhenInit", "J", "Lmqq/util/WeakReference;", "lastAppRuntimeRef", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "checkRepeatLock", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class UidServiceImpl implements IUidService, IAccountCallback {
    static IPatchRedirector $redirector_ = null;
    public static final long ACCOUNT_CHANGED_REPEAT_TIMEOUT = 10000;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String EVENT_NT_NO_UID = "NTUpgradeNoUid";

    @NotNull
    public static final String EVENT_NT_REQ_UID_FAIL = "NTUpgradeReqUidFail";

    @NotNull
    public static final String TAG = "UidServiceImpl";

    @NotNull
    private final List<e72.d> callbackList;

    @NotNull
    private final ReentrantLock checkRepeatLock;

    @NotNull
    private final AtomicBoolean hasInit;

    @Nullable
    private WeakReference<AppRuntime> lastAppRuntimeRef;

    @NotNull
    private final ReentrantLock lock;

    @Nullable
    private AppRuntime loginAppRuntimeWhenInit;
    private long loginTimeWhenInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/login/api/impl/UidServiceImpl$a;", "", "", "uin", "uid", "", "a", "", "ACCOUNT_CHANGED_REPEAT_TIMEOUT", "J", "EVENT_NT_NO_UID", "Ljava/lang/String;", "EVENT_NT_REQ_UID_FAIL", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.api.impl.UidServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a(@NotNull String uin, @Nullable String uid) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) uid)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (uid != null && uid.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return false;
            }
            QLog.i(UidServiceImpl.TAG, 1, "checkRequestUID : uid is null");
            return true;
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
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/login/api/impl/UidServiceImpl$b", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "", "userAccount", "", "dwSrcAppid", "dwDstAppid", "", "dwMainSigMap", "dwSubDstAppid", "Loicq/wlogin_sdk/request/WUserSigInfo;", "userSigInfo", "ret", "Loicq/wlogin_sdk/tools/ErrMsg;", NotificationActivity.KEY_LAST_ERROR, "", "r", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f241892d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e72.c f241893e;

        b(f fVar, e72.c cVar) {
            this.f241892d = fVar;
            this.f241893e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void r(@Nullable String userAccount, long dwSrcAppid, long dwDstAppid, int dwMainSigMap, long dwSubDstAppid, @Nullable WUserSigInfo userSigInfo, int ret, @Nullable ErrMsg lastError) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, userAccount, Long.valueOf(dwSrcAppid), Long.valueOf(dwDstAppid), Integer.valueOf(dwMainSigMap), Long.valueOf(dwSubDstAppid), userSigInfo, Integer.valueOf(ret), lastError);
                return;
            }
            f fVar = this.f241892d;
            if (fVar != null && fVar.b()) {
                return;
            }
            f fVar2 = this.f241892d;
            if (fVar2 != null) {
                fVar2.c(true);
            }
            if (lastError != null) {
                str = lastError.getMessage();
            } else {
                str = null;
            }
            QLog.i(UidServiceImpl.TAG, 1, "onGetStWithoutPasswd ret=" + ret + " msg=" + str);
            e72.c cVar = this.f241893e;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/login/api/impl/UidServiceImpl$c", "Le72/c;", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements e72.c {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f241895b;

        c(String str) {
            this.f241895b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UidServiceImpl.this, (Object) str);
            }
        }

        @Override // e72.c
        public void a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                String currentUin = UidServiceImpl.this.getCurrentUin();
                boolean z17 = false;
                if (currentUin != null && currentUin.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && Intrinsics.areEqual(currentUin, this.f241895b)) {
                    String uid = UidServiceImpl.this.getUid(currentUin);
                    if (uid == null || uid.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        UidServiceImpl.this.dispatchUidChangedEvent(uid, MobileQQ.sMobileQQ.peekAppRuntime());
                        return;
                    }
                    QLog.e(UidServiceImpl.TAG, 1, "request uid failed, start logout");
                    UidServiceImpl.this.logoutWhenReqUidFail();
                    UidServiceImpl.this.kickToLoginPage();
                    UidServiceImpl.this.dispatchUidUpdateFailEvent(currentUin);
                    return;
                }
                QLog.i(UidServiceImpl.TAG, 1, "uin is changed, currUin: " + currentUin + " reqUin: " + this.f241895b);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20356);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public UidServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hasInit = new AtomicBoolean(false);
        this.callbackList = new ArrayList();
        this.lock = new ReentrantLock();
        this.checkRepeatLock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean closeUidBlockSwitch() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100658", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchUidChangedEvent(String uid, AppRuntime appRuntime) {
        QLog.i(TAG, 1, "dispatchUidChangedEvent uid:" + uid);
        ReentrantLock reentrantLock = this.checkRepeatLock;
        reentrantLock.lock();
        try {
            if (isRepeatDispatch(appRuntime)) {
                QLog.w(TAG, 1, "repeat dispatch, ignore");
                return;
            }
            this.lastAppRuntimeRef = new WeakReference<>(appRuntime);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            ReentrantLock reentrantLock2 = this.lock;
            reentrantLock2.lock();
            try {
                ArrayList arrayList = new ArrayList(this.callbackList);
                reentrantLock2.unlock();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((e72.d) it.next()).b(uid);
                }
            } catch (Throwable th5) {
                reentrantLock2.unlock();
                throw th5;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchUidUpdateFailEvent(String uin) {
        Map mapOf;
        QLog.e(TAG, 1, "dispatchUidUpdateFailEvent");
        String currentUin = getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("login_uin", uin), TuplesKt.to(MsfConstants.ATTRIBUTE_LOGIN_TYPE, "1"));
        QQBeaconReport.report(currentUin, EVENT_NT_REQ_UID_FAIL, mapOf);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList(this.callbackList);
            reentrantLock.unlock();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((e72.d) it.next()).a();
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    private final String getAutoLoginUinAtLaunch() {
        String str;
        boolean z16;
        Object firstOrNull;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (!peekAppRuntime.isLogin()) {
                return null;
            }
            return peekAppRuntime.getCurrentUin();
        }
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) allAccounts);
            SimpleAccount simpleAccount = (SimpleAccount) firstOrNull;
            if (simpleAccount != null) {
                str = simpleAccount.getUin();
                if (str == null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && AutoLoginUtil.canAutoLogin(str)) {
                    return str;
                }
            }
        }
        str = null;
        if (str == null) {
        }
        z16 = true;
        return z16 ? null : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            return peekAppRuntime.getCurrentAccountUin();
        }
        return null;
    }

    private final boolean isAccountChangedRepeat(AppRuntime newRuntime) {
        AppRuntime appRuntime = this.loginAppRuntimeWhenInit;
        if (appRuntime != null && Intrinsics.areEqual(appRuntime, newRuntime) && System.currentTimeMillis() - this.loginTimeWhenInit < 10000) {
            return true;
        }
        return false;
    }

    private final boolean isRepeatDispatch(AppRuntime newRuntime) {
        AppRuntime appRuntime;
        WeakReference<AppRuntime> weakReference = this.lastAppRuntimeRef;
        if (weakReference != null && (appRuntime = weakReference.get()) != null) {
            return Intrinsics.areEqual(appRuntime, newRuntime);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kickToLoginPage() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f200874ta, 0).show();
            if (closeUidBlockSwitch()) {
                QLog.i(TAG, 1, "kickToLoginPage");
                QRoute.createNavigator(BaseApplication.getContext(), RouterConstants.UI_ROUTER_LOGIN).withFlags(872415232).request();
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.UidServiceImpl$kickToLoginPage$$inlined$runOnUiThread$1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UidServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f200874ta, 0).show();
                if (UidServiceImpl.this.closeUidBlockSwitch()) {
                    QLog.i(UidServiceImpl.TAG, 1, "kickToLoginPage");
                    QRoute.createNavigator(BaseApplication.getContext(), RouterConstants.UI_ROUTER_LOGIN).withFlags(872415232).request();
                }
            }
        });
    }

    private final void runOnSubThread(final Function0<Unit> block) {
        ThreadManagerV2.excute(new Runnable(block) { // from class: com.tencent.mobileqq.login.api.impl.UidServiceImpl$runOnSubThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f241896d;

            {
                this.f241896d = block;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) block);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f241896d.invoke();
                }
            }
        }, 16, null, true);
    }

    private final void runOnUiThread(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable(block) { // from class: com.tencent.mobileqq.login.api.impl.UidServiceImpl$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function0<Unit> f241897d;

                {
                    this.f241897d = block;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) block);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.f241897d.invoke();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRequestUid(String uin) {
        Map mapOf;
        String currentUin = getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("login_uin", uin), TuplesKt.to(MsfConstants.ATTRIBUTE_LOGIN_TYPE, "1"));
        QQBeaconReport.report(currentUin, EVENT_NT_NO_UID, mapOf);
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.w(TAG, 1, "startRequestUid network is not available");
            logoutWhenReqUidFail();
            kickToLoginPage();
            dispatchUidUpdateFailEvent(uin);
            return;
        }
        requestUid(uin, com.tencent.mobileqq.startup.a.f289660a, new c(uin));
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    @Nullable
    public String getCurrentUid() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String currentUin = getCurrentUin();
        if (currentUin != null && currentUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return getUid(currentUin);
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    @Nullable
    public String getUid(@NotNull String uin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        String decodeString = QMMKV.from(BaseApplication.getContext(), "msf_mmkv_file").decodeString(uin, null);
        if (decodeString != null && decodeString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return UIDFileUtil.getUIDFromFile(uin);
        }
        return decodeString;
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    public boolean initUid() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.hasInit.getAndSet(true)) {
            QLog.i(TAG, 1, "initUid but hasInit!");
            return true;
        }
        QLog.i(TAG, 1, "initUid");
        MobileQQ.sMobileQQ.registerNTSDKAccountCallback(this);
        String autoLoginUinAtLaunch = getAutoLoginUinAtLaunch();
        if (autoLoginUinAtLaunch != null && autoLoginUinAtLaunch.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "initUid but uin is empty!");
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i(TAG, 1, "isAppRuntimeLogin, app: " + peekAppRuntime + ", isLogin: " + z17);
        if (z17) {
            this.loginAppRuntimeWhenInit = peekAppRuntime;
            this.loginTimeWhenInit = System.currentTimeMillis();
        }
        String uid = getUid(autoLoginUinAtLaunch);
        if (INSTANCE.a(autoLoginUinAtLaunch, uid)) {
            QLog.i(TAG, 1, "uin can auto login, but uid is null, isAppRuntimeLogin=" + z17);
            if (z17) {
                startRequestUid(autoLoginUinAtLaunch);
            }
            return false;
        }
        QLog.i(TAG, 1, "uid is not null, isAppRuntimeLogin=" + z17);
        if (z17) {
            dispatchUidChangedEvent(uid, peekAppRuntime);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    public void logoutWhenReqUidFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            String currentUin = peekAppRuntime.getCurrentUin();
            peekAppRuntime.setAutoLogin(false);
            try {
                peekAppRuntime.logout(true);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "logout error:", e16);
            }
            MsfSdkUtils.updateSimpleAccountNotCreate(currentUin, false);
            MobileQQ.sMobileQQ.refreAccountList();
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newRuntime);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        final String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newRuntime);
            return;
        }
        QLog.i(TAG, 1, "onAccountChanged");
        if (newRuntime != null) {
            str = newRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w(TAG, 1, "onAccountChanged, but uin is null");
            return;
        }
        if (isAccountChangedRepeat(newRuntime)) {
            QLog.i(TAG, 1, "ignore repeat onAccountChanged");
            this.loginAppRuntimeWhenInit = null;
            this.loginTimeWhenInit = 0L;
            return;
        }
        this.loginAppRuntimeWhenInit = null;
        this.loginTimeWhenInit = 0L;
        String uid = getUid(str);
        if (INSTANCE.a(str, uid)) {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.login.api.impl.UidServiceImpl$onAccountChanged$$inlined$runOnSubThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f241891d;

                {
                    this.f241891d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UidServiceImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UidServiceImpl.this.startRequestUid(this.f241891d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, true);
        } else {
            dispatchUidChangedEvent(uid, newRuntime);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) reason);
        }
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    public void registerUidCallback(@Nullable e72.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        if (callback != null) {
            try {
                this.callbackList.add(callback);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    public void requestUid(@NotNull final String uin, int timeout, @Nullable final e72.c callback) {
        final f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, uin, Integer.valueOf(timeout), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i(TAG, 1, "request uid uin=" + uin);
        if (timeout > 0) {
            fVar = h.b(new Function0<Unit>(uin, callback) { // from class: com.tencent.mobileqq.login.api.impl.UidServiceImpl$requestUid$timeoutTask$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ e72.c $callback;
                final /* synthetic */ String $uin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$uin = uin;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) uin, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.w(UidServiceImpl.TAG, 1, "requestUid timeout uin=" + this.$uin);
                    e72.c cVar = this.$callback;
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }, timeout);
        } else {
            fVar = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            y.f242393a.i(Long.parseLong(uin), true, false, new Function2<Boolean, String, Unit>(callback) { // from class: com.tencent.mobileqq.login.api.impl.UidServiceImpl$requestUid$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ e72.c $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) f.this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errMsg) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), errMsg);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    QLog.d(UidServiceImpl.TAG, 1, "requestUid isSuccess: " + z16 + ", errMsg: " + errMsg);
                    f fVar2 = f.this;
                    if (fVar2 == null || !fVar2.b()) {
                        f fVar3 = f.this;
                        if (fVar3 != null) {
                            fVar3.c(true);
                        }
                        e72.c cVar = this.$callback;
                        if (cVar != null) {
                            cVar.a();
                        }
                    }
                }
            });
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILoginServletService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        ((ILoginServletService) runtimeService).getStWithoutPasswd(uin, 16L, 16L, new b(fVar, callback));
    }

    @Override // com.tencent.mobileqq.login.api.IUidService
    public void unregisterUidCallback(@Nullable e72.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        if (callback != null) {
            try {
                this.callbackList.remove(callback);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}

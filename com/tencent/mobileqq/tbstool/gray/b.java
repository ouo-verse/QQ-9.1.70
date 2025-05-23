package com.tencent.mobileqq.tbstool.gray;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tbstool.TBSToolInjector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tbstool/gray/b;", "", "", "filePath", "Lcom/tencent/mobileqq/tbstool/gray/a;", "d", "", "f", "", "g", "Lcom/tencent/mobileqq/tbstool/adapter/b;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "strategyMap", "Lmqq/app/IAccountCallback;", "c", "Lmqq/app/IAccountCallback;", "accountCB", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f291450a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.mobileqq.tbstool.gray.a> strategyMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IAccountCallback accountCB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/tbstool/gray/b$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
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
                return;
            }
            MobileQQ.sMobileQQ.unregisterAccountCallback(b.accountCB);
            b.strategyMap.clear();
            b.accountCB = null;
            QLog.d("GrayStrategyManager", 1, "onAccountChanged");
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
                return;
            }
            MobileQQ.sMobileQQ.unregisterAccountCallback(b.accountCB);
            b.strategyMap.clear();
            b.accountCB = null;
            QLog.d("GrayStrategyManager", 1, "onLogout");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23663);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f291450a = new b();
            strategyMap = new ConcurrentHashMap<>();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.tbstool.gray.a d(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        f();
        String n06 = ah.n0(filePath);
        Intrinsics.checkNotNullExpressionValue(n06, "getFileSuffix(filePath)");
        String lowerCase = n06.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        com.tencent.mobileqq.tbstool.gray.a aVar = new com.tencent.mobileqq.tbstool.gray.a(lowerCase);
        com.tencent.mobileqq.tbstool.gray.a putIfAbsent = strategyMap.putIfAbsent(lowerCase, aVar);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return aVar;
    }

    @NotNull
    public final com.tencent.mobileqq.tbstool.adapter.b e(@Nullable String filePath) {
        com.tencent.mobileqq.tbstool.adapter.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.tbstool.adapter.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) filePath);
        }
        com.tencent.mobileqq.tbstool.gray.a d16 = d(filePath);
        if (d16 == null || (a16 = d16.a()) == null) {
            return new com.tencent.mobileqq.tbstool.adapter.a();
        }
        return a16;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (accountCB != null) {
                return;
            }
            accountCB = new a();
            MobileQQ.sMobileQQ.registerAccountCallback(accountCB);
            QLog.d("GrayStrategyManager", 1, "init inject toolHost");
            TbsToolEntrance.getInstance().setToolHost(TBSToolInjector.INSTANCE.a());
        }
    }

    public final boolean g(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePath)).booleanValue();
        }
        com.tencent.mobileqq.tbstool.gray.a d16 = d(filePath);
        if (d16 != null) {
            return d16.c();
        }
        return false;
    }
}

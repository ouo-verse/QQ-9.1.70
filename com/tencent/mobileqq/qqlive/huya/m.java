package com.tencent.mobileqq.qqlive.huya;

import android.text.TextUtils;
import com.huya.huyasdk.api.HuyaLoginResult;
import com.huya.huyasdk.api.HuyaLoginToken;
import com.huya.huyasdk.api.LoginResultCallback;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/m;", "", "", tl.h.F, "", "d", QAdLoginDefine$LoginStatus.IS_LOGIN, "j", "Lcom/tencent/mobileqq/qqlive/huya/c;", "g", "Lkotlin/Function0;", "invoke", HippyReporter.RemoveEngineReason.INVALID, "c", "sdkEnabled", "i", "b", "Z", "isLogining", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Ljava/util/concurrent/atomic/AtomicReference;", "huyaOpenId", "huyaAccessToken", "Ljava/util/concurrent/atomic/AtomicLong;", "e", "Ljava/util/concurrent/atomic/AtomicLong;", "huyaUid", "", "Lcom/tencent/mobileqq/qqlive/huya/a;", "f", "Ljava/util/List;", "callDelayLoginList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCalledLogout", "Ljava/lang/Object;", "Ljava/lang/Object;", "callLock", "<init>", "()V", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f271359a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isLogining;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicReference<String> huyaOpenId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicReference<String> huyaAccessToken;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicLong huyaUid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> callDelayLoginList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean isCalledLogout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Object callLock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33091);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f271359a = new m();
        huyaOpenId = new AtomicReference<>(null);
        huyaAccessToken = new AtomicReference<>(null);
        huyaUid = new AtomicLong(0L);
        callDelayLoginList = new ArrayList();
        isCalledLogout = new AtomicBoolean(false);
        callLock = new Object();
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d() {
        ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).startGetLaunchKeys("1101115626", new IYunGameChannelApi.OnGetLaunchKeyListener() { // from class: com.tencent.mobileqq.qqlive.huya.k
            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.OnGetLaunchKeyListener
            public final void onResult(String str, String str2, String str3, String str4) {
                m.e(str, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !isCalledLogout.compareAndSet(true, false)) {
            HuyaLoginToken.loginWithOpenIdAndAccessToken(str3, str, new LoginResultCallback() { // from class: com.tencent.mobileqq.qqlive.huya.l
                @Override // com.huya.huyasdk.api.LoginResultCallback
                public final void onLoginResult(HuyaLoginResult huyaLoginResult) {
                    m.f(huyaLoginResult);
                }
            });
        } else {
            QLog.e("QQLiveHuYaLoginManager", 1, "fastLogin get ticket failed");
            f271359a.j(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(HuyaLoginResult huyaLoginResult) {
        if (isCalledLogout.compareAndSet(true, false)) {
            f271359a.j(false);
            return;
        }
        QLog.i("QQLiveHuYaLoginManager", 1, "loginWithOpenIdAndAccessToken:" + huyaLoginResult);
        huyaOpenId.set(huyaLoginResult.openID);
        huyaAccessToken.set(huyaLoginResult.accessToken);
        huyaUid.set(huyaLoginResult.uid);
        if (huyaLoginResult.isSucceed) {
            f271359a.j(true);
        } else {
            f271359a.j(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h() {
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        if (!HuyaLoginToken.hasLogin()) {
            return false;
        }
        String str = huyaOpenId.get();
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                String str2 = huyaAccessToken.get();
                if (str2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!isBlank) {
                        z17 = false;
                        if (!z17) {
                            return false;
                        }
                        return true;
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void j(boolean isLogin) {
        isLogining = false;
        synchronized (callLock) {
            for (a aVar : callDelayLoginList) {
                if (isLogin) {
                    aVar.b().invoke();
                } else {
                    aVar.a().invoke();
                }
            }
            callDelayLoginList.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c(@NotNull Function0<Unit> invoke, @NotNull Function0<Unit> invalid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) invoke, (Object) invalid);
            return;
        }
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        if (h()) {
            invoke.invoke();
            return;
        }
        if (!isLogining) {
            d();
            isLogining = true;
        }
        synchronized (callLock) {
            callDelayLoginList.add(new a(invoke, invalid));
        }
    }

    @Nullable
    public final c g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (h() && !isLogining) {
            return new c(huyaOpenId.get(), huyaAccessToken.get(), Long.valueOf(huyaUid.get()));
        }
        return null;
    }

    public final void i(boolean sdkEnabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, sdkEnabled);
            return;
        }
        isCalledLogout.set(true);
        huyaOpenId.set(null);
        huyaAccessToken.set(null);
        huyaUid.set(0L);
        if (!sdkEnabled) {
            QLog.i("QQLiveHuYaLoginManager", 2, "logoutHuYaSdk but sdk not setup");
            return;
        }
        try {
            HuyaLoginToken.logout();
        } catch (Throwable th5) {
            QLog.e("QQLiveHuYaLoginManager", 1, "logout throw t:", th5);
        }
    }
}

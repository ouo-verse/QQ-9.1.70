package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.groupvideo.ipc.GroupVideoQIPCClient;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\t\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/PSKeyManagerService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IPSKeyManagerService;", "", "", "domains", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IPSKeyManagerCallback;", "callback", "", "getPSKey", "replacePSKey", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoPSKeyListener;", "listener", "registerPSKeyListener", "unRegisterPSKeyListener", "<init>", "()V", "Companion", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class PSKeyManagerService implements IPSKeyManagerService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "PSKeyManagerService";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/PSKeyManagerService$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.bridgeengine.PSKeyManagerService$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/groupvideo/bridgeengine/PSKeyManagerService$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPSKeyManagerCallback f213714a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f213715b;

        b(IPSKeyManagerCallback iPSKeyManagerCallback, String str) {
            this.f213714a = iPSKeyManagerCallback;
            this.f213715b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iPSKeyManagerCallback, (Object) str);
            }
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i(PSKeyManagerService.TAG, 1, "getPSKey onFail: " + errMsg);
            IPSKeyManagerCallback iPSKeyManagerCallback = this.f213714a;
            if (iPSKeyManagerCallback != null) {
                iPSKeyManagerCallback.onFail(errMsg);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            QLog.i(PSKeyManagerService.TAG, 1, "getPSKey onSuccess: size=" + domainToKeyMap.size());
            IPSKeyManagerCallback iPSKeyManagerCallback = this.f213714a;
            if (iPSKeyManagerCallback != null) {
                iPSKeyManagerCallback.onSuccess(this.f213715b, domainToKeyMap);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/groupvideo/bridgeengine/PSKeyManagerService$c", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPSKeyManagerCallback f213716a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f213717b;

        c(IPSKeyManagerCallback iPSKeyManagerCallback, String str) {
            this.f213716a = iPSKeyManagerCallback;
            this.f213717b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iPSKeyManagerCallback, (Object) str);
            }
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i(PSKeyManagerService.TAG, 1, "replacePSKey onFail: " + errMsg);
            IPSKeyManagerCallback iPSKeyManagerCallback = this.f213716a;
            if (iPSKeyManagerCallback != null) {
                iPSKeyManagerCallback.onFail(errMsg);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            QLog.i(PSKeyManagerService.TAG, 1, "replacePSKey onSuccess: size=" + domainToKeyMap.size());
            IPSKeyManagerCallback iPSKeyManagerCallback = this.f213716a;
            if (iPSKeyManagerCallback != null) {
                iPSKeyManagerCallback.onSuccess(this.f213717b, domainToKeyMap);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PSKeyManagerService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IPSKeyManagerService
    public void getPSKey(@Nullable List<String> domains, @Nullable IPSKeyManagerCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) domains, (Object) callback);
            return;
        }
        if (domains == null) {
            if (callback != null) {
                callback.onFail("domains is null");
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            if (callback != null) {
                callback.onFail("app is null");
                return;
            }
            return;
        }
        String account = peekAppRuntime.getAccount();
        if (account == null) {
            account = "0";
        }
        b bVar = new b(callback, account);
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPskeyManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
        Object[] array = domains.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ((IPskeyManager) runtimeService).getPskey((String[]) array, bVar);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IPSKeyManagerService
    public void registerPSKeyListener(@Nullable IGroupVideoPSKeyListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        if (listener != null) {
            com.tencent.mobileqq.groupvideo.net.e.f213814a.f(listener);
        }
        if (!com.tencent.mobileqq.groupvideo.net.e.f213814a.d()) {
            GroupVideoQIPCClient.INSTANCE.a().o();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IPSKeyManagerService
    public void replacePSKey(@Nullable List<String> domains, @Nullable IPSKeyManagerCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) domains, (Object) callback);
            return;
        }
        if (domains == null) {
            if (callback != null) {
                callback.onFail("domains is null");
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            if (callback != null) {
                callback.onFail("app is null");
                return;
            }
            return;
        }
        String account = peekAppRuntime.getAccount();
        if (account == null) {
            account = "0";
        }
        c cVar = new c(callback, account);
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPskeyManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
        Object[] array = domains.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ((IPskeyManager) runtimeService).replacePskey((String[]) array, cVar);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IPSKeyManagerService
    public void unRegisterPSKeyListener(@Nullable IGroupVideoPSKeyListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        if (listener != null) {
            com.tencent.mobileqq.groupvideo.net.e.f213814a.h(listener);
        }
        if (com.tencent.mobileqq.groupvideo.net.e.f213814a.d()) {
            GroupVideoQIPCClient.INSTANCE.a().y();
        }
    }
}

package com.tencent.mobileqq.qqlive.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u001b\u0010\f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0005R\u001b\u0010\u000f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0005R\u001b\u0010\u0011\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/utils/LiveCoroutineScopes;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Normal", "c", "a", "Network", "d", "getFile", "File", "e", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "f", "UI", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveCoroutineScopes {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LiveCoroutineScopes f273421a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Normal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Network;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy File;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy DB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy UI;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f273421a = new LiveCoroutineScopes();
        lazy = LazyKt__LazyJVMKt.lazy(LiveCoroutineScopes$Normal$2.INSTANCE);
        Normal = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LiveCoroutineScopes$Network$2.INSTANCE);
        Network = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(LiveCoroutineScopes$File$2.INSTANCE);
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(LiveCoroutineScopes$DB$2.INSTANCE);
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(LiveCoroutineScopes$UI$2.INSTANCE);
        UI = lazy5;
    }

    LiveCoroutineScopes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final CoroutineDispatcher a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (CoroutineDispatcher) Network.getValue();
    }

    @NotNull
    public final CoroutineDispatcher b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (CoroutineDispatcher) Normal.getValue();
    }

    @NotNull
    public final CoroutineDispatcher c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (CoroutineDispatcher) UI.getValue();
    }
}

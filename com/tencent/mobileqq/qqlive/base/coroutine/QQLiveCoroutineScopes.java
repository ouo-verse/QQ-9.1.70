package com.tencent.mobileqq.qqlive.base.coroutine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\u000e\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u0011\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/coroutine/QQLiveCoroutineScopes;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "c", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Normal", "Network", "d", "a", "File", "e", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "f", "getUI", "UI", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCoroutineScopes {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQLiveCoroutineScopes f270996a;

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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22563);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f270996a = new QQLiveCoroutineScopes();
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveCoroutineScopes$Normal$2.INSTANCE);
        Normal = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(QQLiveCoroutineScopes$Network$2.INSTANCE);
        Network = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(QQLiveCoroutineScopes$File$2.INSTANCE);
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(QQLiveCoroutineScopes$DB$2.INSTANCE);
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(QQLiveCoroutineScopes$UI$2.INSTANCE);
        UI = lazy5;
    }

    QQLiveCoroutineScopes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final CoroutineDispatcher a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (CoroutineDispatcher) File.getValue();
    }

    @NotNull
    public final CoroutineDispatcher b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (CoroutineDispatcher) Network.getValue();
    }

    @NotNull
    public final CoroutineDispatcher c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (CoroutineDispatcher) Normal.getValue();
    }
}

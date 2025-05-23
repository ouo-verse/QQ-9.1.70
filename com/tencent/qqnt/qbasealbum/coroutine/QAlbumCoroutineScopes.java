package com.tencent.qqnt.qbasealbum.coroutine;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001b\u0010\u000e\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00028@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00028@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0017\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/coroutine/QAlbumCoroutineScopes;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "getNormal", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Normal", "c", "Network", "d", "File", "e", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "f", "UI", "g", Tracker.QUERY, h.F, "a", "ALBUM", "i", "REFRESH", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QAlbumCoroutineScopes {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QAlbumCoroutineScopes f361069a;

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

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy QUERY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy ALBUM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy REFRESH;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f361069a = new QAlbumCoroutineScopes();
        lazy = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$Normal$2.INSTANCE);
        Normal = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$Network$2.INSTANCE);
        Network = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$File$2.INSTANCE);
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$DB$2.INSTANCE);
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$UI$2.INSTANCE);
        UI = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$QUERY$2.INSTANCE);
        QUERY = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$ALBUM$2.INSTANCE);
        ALBUM = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(QAlbumCoroutineScopes$REFRESH$2.INSTANCE);
        REFRESH = lazy8;
    }

    QAlbumCoroutineScopes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final CoroutineDispatcher a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (CoroutineDispatcher) ALBUM.getValue();
    }

    @NotNull
    public final CoroutineDispatcher b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (CoroutineDispatcher) File.getValue();
    }

    @NotNull
    public final CoroutineDispatcher c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (CoroutineDispatcher) Network.getValue();
    }

    @NotNull
    public final CoroutineDispatcher d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (CoroutineDispatcher) QUERY.getValue();
    }

    @NotNull
    public final CoroutineDispatcher e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (CoroutineDispatcher) REFRESH.getValue();
    }

    @NotNull
    public final CoroutineDispatcher f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (CoroutineDispatcher) UI.getValue();
    }
}

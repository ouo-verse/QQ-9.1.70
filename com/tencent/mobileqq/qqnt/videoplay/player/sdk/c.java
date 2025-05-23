package com.tencent.mobileqq.qqnt.videoplay.player.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.so.a;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/c;", "", "Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/c$a;", "callback", "", "b", "a", "", "Z", "tpCoreLoaded", "c", "downloadLoaded", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f274242a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean tpCoreLoaded;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean downloadLoaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/c$a;", "", "", "isSuccess", "", "onLoad", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void onLoad(boolean isSuccess);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f274242a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(a callback) {
        try {
            if (!tpCoreLoaded) {
                System.loadLibrary(ILoadSo.SONAME_TPCORE_MASTER);
                tpCoreLoaded = true;
            }
            if (!downloadLoaded) {
                System.loadLibrary("DownloadProxy");
                downloadLoaded = true;
            }
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("VideoPlay_LoadSo", 1, e16, new Object[0]);
            callback.onLoad(false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_LoadSo", 2, "tpCoreLoaded:" + tpCoreLoaded + ", downloadLoaded:" + downloadLoaded);
        }
        if (tpCoreLoaded && downloadLoaded) {
            callback.onLoad(true);
        }
    }

    public final synchronized void a(@NotNull a callback) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        a.InterfaceC8418a a16 = com.tencent.mobileqq.qqnt.videoplay.api.so.a.f274211a.a();
        if (a16 != null) {
            callback.onLoad(a16.b());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b(callback);
        }
    }
}

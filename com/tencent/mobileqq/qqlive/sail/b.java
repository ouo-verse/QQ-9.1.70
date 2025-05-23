package com.tencent.mobileqq.qqlive.sail;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.yolo.esports.download.common.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\t\u0010\f\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/b;", "Lf05/a;", "Lcom/yolo/esports/download/cb/a;", "listener", "", "b1", "Lcom/yolo/esports/download/common/DownloadInfo;", "info", "J0", "", "url", "C3", "N3", "v0", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "p0", "init", "f3", "M0", "o2", "", "A3", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements f05.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f272169b;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ h05.a f272170a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        b bVar = new b();
        f272169b = bVar;
        bVar.init(null);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f272170a = new h05.a();
        }
    }

    @Override // f05.a
    public int A3(@NotNull DownloadInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) info)).intValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        return this.f272170a.A3(info);
    }

    @Override // f05.a
    public void C3(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            this.f272170a.C3(url);
        }
    }

    @Override // f05.a
    public void J0(@NotNull DownloadInfo info, @NotNull com.yolo.esports.download.cb.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) info, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f272170a.J0(info, listener);
    }

    @Override // f05.a
    public void M0(@NotNull com.yolo.esports.download.cb.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f272170a.M0(listener);
        }
    }

    public void N3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f272170a.N3();
        }
    }

    @Override // f05.a
    public void b1(@NotNull com.yolo.esports.download.cb.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f272170a.b1(listener);
        }
    }

    @Override // f05.a
    public void f3(@NotNull com.yolo.esports.download.cb.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f272170a.f3(listener);
        }
    }

    @Override // mm4.a
    public void init(Context p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) p06);
        } else {
            this.f272170a.init(p06);
        }
    }

    @Override // mm4.a
    public void o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f272170a.o2();
        }
    }

    @Override // f05.a
    @Nullable
    public DownloadInfo v0(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DownloadInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return this.f272170a.v0(url);
    }
}

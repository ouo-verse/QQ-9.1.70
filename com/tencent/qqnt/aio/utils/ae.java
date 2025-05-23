package com.tencent.qqnt.aio.utils;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J)\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0096\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/utils/ae;", "Lcom/tencent/qqnt/aio/api/h;", "Landroid/view/View;", "redDot", "", "b", tl.h.F, "Landroid/content/Context;", "context", "target", "f", "i", "", "d", "", "peerUid", "", "chatType", "e", "redDotId", "c", "g", AdMetricTag.Report.TYPE, "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ae implements com.tencent.qqnt.aio.api.h {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ae f352281b;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.qqnt.aio.api.h f352282a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f352281b = new ae();
        }
    }

    ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.api.h a16 = ad.f352278a.a();
        Intrinsics.checkNotNull(a16);
        this.f352282a = a16;
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void a(int reportType, @NotNull String peerUid, int chatType, @NotNull String redDotId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(reportType), peerUid, Integer.valueOf(chatType), redDotId);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDotId, "redDotId");
        this.f352282a.a(reportType, peerUid, chatType, redDotId);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void b(@NotNull View redDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) redDot);
        } else {
            Intrinsics.checkNotNullParameter(redDot, "redDot");
            this.f352282a.b(redDot);
        }
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void c(@NotNull String peerUid, int chatType, @NotNull String redDotId, @NotNull View redDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, peerUid, Integer.valueOf(chatType), redDotId, redDot);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDotId, "redDotId");
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        this.f352282a.c(peerUid, chatType, redDotId, redDot);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public boolean d(@NotNull View redDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) redDot)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        return this.f352282a.d(redDot);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void e(@NotNull String peerUid, int chatType, @NotNull View redDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, peerUid, Integer.valueOf(chatType), redDot);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        this.f352282a.e(peerUid, chatType, redDot);
    }

    @Override // com.tencent.qqnt.aio.api.h
    @NotNull
    public View f(@NotNull Context context, @NotNull View target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) target);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        return this.f352282a.f(context, target);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void g(@NotNull String peerUid, int chatType, @NotNull View redDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, peerUid, Integer.valueOf(chatType), redDot);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        this.f352282a.g(peerUid, chatType, redDot);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void h(@NotNull View redDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) redDot);
        } else {
            Intrinsics.checkNotNullParameter(redDot, "redDot");
            this.f352282a.h(redDot);
        }
    }

    @Override // com.tencent.qqnt.aio.api.h
    @NotNull
    public View i(@NotNull Context context, @NotNull View target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) target);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        return this.f352282a.i(context, target);
    }
}

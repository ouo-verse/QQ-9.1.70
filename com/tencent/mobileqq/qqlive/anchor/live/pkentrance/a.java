package com.tencent.mobileqq.qqlive.anchor.live.pkentrance;

import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.now.linkpkanchorplay.componententry.f;
import com.tencent.timi.game.liveroom.impl.room.anchor.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkentrance/a;", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "Landroid/view/ViewGroup;", "k6", "", "E0", "Lfi2/b;", "d", "Lfi2/b;", "cc", "<init>", "(Lfi2/b;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fi2.b cc;

    public a(@NotNull fi2.b cc5) {
        Intrinsics.checkNotNullParameter(cc5, "cc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc5);
        } else {
            this.cc = cc5;
        }
    }

    @Override // com.tencent.now.linkpkanchorplay.componententry.f
    @NotNull
    public int[] E0() {
        int[] y16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.qqlive.anchor.live.pkbtn.c cVar = (com.tencent.mobileqq.qqlive.anchor.live.pkbtn.c) com.tencent.mobileqq.qqlive.base.room.c.d(this.cc, com.tencent.mobileqq.qqlive.anchor.live.pkbtn.c.class);
        if (cVar == null || (y16 = cVar.y()) == null) {
            return new int[2];
        }
        return y16;
    }

    @Override // com.tencent.now.linkpkanchorplay.componententry.f
    @Nullable
    public ViewGroup k6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        p pVar = (p) com.tencent.mobileqq.qqlive.base.room.c.d(this.cc, p.class);
        if (pVar != null) {
            return pVar.v();
        }
        return null;
    }
}

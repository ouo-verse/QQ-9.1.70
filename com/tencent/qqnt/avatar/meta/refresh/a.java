package com.tencent.qqnt.avatar.meta.refresh;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/refresh/a;", "", "Lcom/tencent/qqnt/avatar/meta/refresh/b;", "refreshListener", "", "b", "Lcom/tencent/qqnt/avatar/meta/refresh/bean/a;", "refreshInfo", "a", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listenerRefSet", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f352938a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArraySet<c<b>> listenerRefSet;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352938a = new a();
            listenerRefSet = new CopyOnWriteArraySet<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull com.tencent.qqnt.avatar.meta.refresh.bean.a refreshInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) refreshInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshInfo, "refreshInfo");
        Iterator<c<b>> it = listenerRefSet.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar != null) {
                bVar.a(refreshInfo);
            }
        }
    }

    public final void b(@NotNull b refreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) refreshListener);
        } else {
            Intrinsics.checkNotNullParameter(refreshListener, "refreshListener");
            listenerRefSet.add(new c<>(refreshListener));
        }
    }

    public final void c(@NotNull b refreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) refreshListener);
        } else {
            Intrinsics.checkNotNullParameter(refreshListener, "refreshListener");
            listenerRefSet.remove(new c(refreshListener));
        }
    }
}

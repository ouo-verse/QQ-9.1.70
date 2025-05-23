package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/i;", "repoMsg", "", "c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/h;", "listener", "a", "onRelease", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/h;", "b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "data", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements g<c>, i<c> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private h<c> listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private c data;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.g
    public void a(@NotNull h<c> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        c cVar = this.data;
        if (cVar != null) {
            listener.a(cVar);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull c repoMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repoMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(repoMsg, "repoMsg");
        this.data = repoMsg;
        h<c> hVar = this.listener;
        if (hVar != null) {
            hVar.a(repoMsg);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.g
    public void onRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.listener = null;
            this.data = null;
        }
    }
}

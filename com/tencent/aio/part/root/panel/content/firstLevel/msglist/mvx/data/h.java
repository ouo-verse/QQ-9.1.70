package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0004R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/h;", "T", "", "data", "", "a", "(Ljava/lang/Object;)V", "b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;", "getDispatcher$sdk_debug", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;", "setDispatcher$sdk_debug", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;)V", "dispatcher", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class h<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g<T> dispatcher;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public abstract void a(T data);

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        g<T> gVar = this.dispatcher;
        if (gVar != null) {
            gVar.onRelease();
        }
        this.dispatcher = null;
    }
}

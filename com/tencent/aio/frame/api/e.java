package com.tencent.aio.frame.api;

import com.tencent.aio.runtime.emitter.AIOFunctionEmitter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/frame/api/e;", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "Lcom/tencent/aio/frame/api/d;", "", "duration", "", "e", "", "i", "enable", h.F, "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class e extends AIOFunctionEmitter<d> {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void g(e eVar, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 300;
            }
            eVar.e(i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeRightFrame");
    }

    public abstract void e(int duration);

    public abstract void h(boolean enable);

    public abstract boolean i();
}

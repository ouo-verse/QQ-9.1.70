package com.tencent.aio.runtime.emitter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/runtime/emitter/BackEventEmitter;", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "onBackEvent", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class BackEventEmitter extends AIOFunctionEmitter<com.tencent.aio.api.runtime.emitter.a> implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    public BackEventEmitter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        d(new Function1<com.tencent.aio.api.runtime.emitter.a, Object>() { // from class: com.tencent.aio.runtime.emitter.BackEventEmitter$onBackEvent$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) Ref.BooleanRef.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@NotNull com.tencent.aio.api.runtime.emitter.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.onBackEvent()) {
                    Ref.BooleanRef.this.element = true;
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
        return booleanRef.element;
    }
}

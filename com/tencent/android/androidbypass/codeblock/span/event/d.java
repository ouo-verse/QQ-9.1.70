package com.tencent.android.androidbypass.codeblock.span.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/event/d;", "Lcom/tencent/android/androidbypass/codeblock/span/event/b;", "Lcom/tencent/android/androidbypass/codeblock/span/event/a;", "event", "", "a", "Lcom/tencent/android/androidbypass/codeblock/span/event/b;", "dispatcher", "<init>", "(Lcom/tencent/android/androidbypass/codeblock/span/event/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class d implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b dispatcher;

    public d(@NotNull b dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dispatcher);
        } else {
            this.dispatcher = dispatcher;
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.event.b
    public void a(@NotNull a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            this.dispatcher.a(event);
        }
    }
}

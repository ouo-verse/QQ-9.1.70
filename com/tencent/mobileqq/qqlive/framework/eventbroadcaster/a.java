package com.tencent.mobileqq.qqlive.framework.eventbroadcaster;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R2\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/a;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "E", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/j;", "event", "", "a", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "b", "Lkotlin/jvm/functions/Function1;", "c", "()Lkotlin/jvm/functions/Function1;", "invoke", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class a<E extends b> extends j<E> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<E, Boolean> invoke;

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.j
    public boolean a(@NotNull E event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        return this.invoke.invoke(event).booleanValue();
    }

    @NotNull
    public final Function1<E, Boolean> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function1) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.invoke;
    }
}

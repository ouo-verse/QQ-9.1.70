package com.tencent.mobileqq.qqlive.framework.mvvm;

import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/mvvm/a;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "E", "event", "", "C0", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)V", "M1", "()V", "L1", "Lfi2/a;", "componentContext", "<init>", "(Lfi2/a;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class a extends ViewModel implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ fi2.a f271269i;

    public a(@NotNull fi2.a componentContext) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentContext);
        } else {
            this.f271269i = componentContext;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h
    public <E extends b> void C0(@NotNull E event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            this.f271269i.C0(event);
        }
    }

    public abstract void L1();

    public final void M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            L1();
        }
    }
}

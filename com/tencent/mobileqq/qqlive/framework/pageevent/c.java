package com.tencent.mobileqq.qqlive.framework.pageevent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.component.e;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.k;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/pageevent/c;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/k;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;", "c", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;", "()Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;", "requestComponentTag", "", "key", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "componentClazz", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l requestComponentTag;

    public c(@NotNull String key, @NotNull Class<e> componentClazz) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) key, (Object) componentClazz);
        } else {
            this.requestComponentTag = new l(key, componentClazz);
        }
    }

    @NotNull
    public final l c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (l) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.requestComponentTag;
    }
}

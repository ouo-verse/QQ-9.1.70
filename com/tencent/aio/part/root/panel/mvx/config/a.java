package com.tencent.aio.part.root.panel.mvx.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u5e9f\u5f03")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&R\"\u0010\u000f\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/config/a;", "", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "aioParam", "", "c", "", "panelId", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "b", "a", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "()Lcom/tencent/aio/part/root/panel/mvx/config/c;", "setMPanelParam", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "mPanelParam", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    protected c mPanelParam;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (c) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        c cVar = this.mPanelParam;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelParam");
        }
        return cVar;
    }

    @Nullable
    public abstract b b(int panelId);

    public final void c(@NotNull c aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioParam);
        } else {
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            this.mPanelParam = aioParam;
        }
    }
}

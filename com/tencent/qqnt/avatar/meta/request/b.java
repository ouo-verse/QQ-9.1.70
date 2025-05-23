package com.tencent.qqnt.avatar.meta.request;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/request/b;", "", "", "a", "Lcom/tencent/qqnt/avatar/meta/b;", "Lcom/tencent/qqnt/avatar/meta/b;", "getMetaAvatarBean", "()Lcom/tencent/qqnt/avatar/meta/b;", "metaAvatarBean", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "cancelCallback", "<init>", "(Lcom/tencent/qqnt/avatar/meta/b;Lkotlin/jvm/functions/Function0;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.b metaAvatarBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function0<Unit> cancelCallback;

    public b(@NotNull com.tencent.qqnt.avatar.meta.b metaAvatarBean, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(metaAvatarBean, "metaAvatarBean");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) metaAvatarBean, (Object) function0);
        } else {
            this.metaAvatarBean = metaAvatarBean;
            this.cancelCallback = function0;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Function0<Unit> function0 = this.cancelCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}

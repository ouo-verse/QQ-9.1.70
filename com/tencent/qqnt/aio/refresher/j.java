package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.aio.msglist.holder.external.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/j;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/g;", "", PushClientConstants.TAG_CLASS_NAME, "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j implements com.tencent.mobileqq.aio.msglist.holder.external.g {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.g
    @Nullable
    public com.tencent.mobileqq.aio.msglist.holder.external.c a(@NotNull String className, @NotNull com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.external.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) className, (Object) helper);
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(helper, "helper");
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.g
    @Nullable
    public com.tencent.mobileqq.aio.msglist.holder.external.d b(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.external.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return g.a.b(this, str);
    }
}

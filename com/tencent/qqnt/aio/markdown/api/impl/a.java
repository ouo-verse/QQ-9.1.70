package com.tencent.qqnt.aio.markdown.api.impl;

import android.content.Context;
import com.tencent.guild.aio.msglist.markdown.inlineboard.InlineButtonStyleUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/impl/a;", "", "Landroid/content/Context;", "context", "btnModel", "", "supportVas", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public Object a(@NotNull Context context, @NotNull Object btnModel, boolean supportVas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context, btnModel, Boolean.valueOf(supportVas));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        if (btnModel instanceof com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a) {
            return InlineButtonStyleUtils.f111753a.k(context, (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a) btnModel, false);
        }
        return null;
    }
}

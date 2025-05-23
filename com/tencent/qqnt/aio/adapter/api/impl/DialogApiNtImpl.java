package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IDialogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/DialogApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi;", "Landroid/content/Context;", "context", "", "title", "content", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "listener", "", "showAlert", "leftButtonText", "rightButtonText", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DialogApiNtImpl implements IDialogApi {
    static IPatchRedirector $redirector_;

    public DialogApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi
    public void showAlert(@NotNull Context context, @NotNull String title, @NotNull String content, @NotNull IDialogApi.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, title, content, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.qqnt.aio.adapter.widget.c cVar = new com.tencent.qqnt.aio.adapter.widget.c(context);
        cVar.setTitle(title);
        cVar.U(content);
        cVar.W(listener);
        cVar.show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi
    public void showAlert(@NotNull Context context, @NotNull String title, @NotNull String content, @NotNull String leftButtonText, @NotNull String rightButtonText, @NotNull IDialogApi.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, title, content, leftButtonText, rightButtonText, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.qqnt.aio.adapter.widget.c cVar = new com.tencent.qqnt.aio.adapter.widget.c(context);
        cVar.setTitle(title);
        cVar.U(content);
        cVar.R(leftButtonText);
        cVar.S(rightButtonText);
        cVar.W(listener);
        cVar.show();
    }
}

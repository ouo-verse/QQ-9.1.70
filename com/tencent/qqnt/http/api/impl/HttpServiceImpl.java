package com.tencent.qqnt.http.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/HttpServiceImpl;", "Lcom/tencent/qqnt/http/api/IHttpService;", "Lcom/tencent/qqnt/http/api/impl/h;", "Lcom/tencent/qqnt/http/api/b;", "task", "", "asyncExecute", "Lcom/tencent/qqnt/http/api/m;", "syncExecute", "cancel", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class HttpServiceImpl extends h implements IHttpService {
    static IPatchRedirector $redirector_;

    public HttpServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.http.api.IHttpService
    public void asyncExecute(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
        } else {
            Intrinsics.checkNotNullParameter(task, "task");
            submitAsyncTask(task);
        }
    }

    @Override // com.tencent.qqnt.http.api.IHttpService
    public void cancel(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
        } else {
            Intrinsics.checkNotNullParameter(task, "task");
            cancelTask(task);
        }
    }

    @Override // com.tencent.qqnt.http.api.IHttpService
    @NotNull
    public m syncExecute(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        return submitSyncTask(task);
    }
}

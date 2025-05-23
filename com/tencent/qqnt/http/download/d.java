package com.tencent.qqnt.http.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/http/download/d;", "Lcom/tencent/qqnt/http/download/a;", "Ljava/io/File;", "file", "Lcom/tencent/qqnt/http/api/b;", "task", "Lokhttp3/Response;", "response", "", "append", "<init>", "(Ljava/io/File;Lcom/tencent/qqnt/http/api/b;Lokhttp3/Response;Z)V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull File file, @NotNull com.tencent.qqnt.http.api.b task, @NotNull Response response, boolean z16) {
        super(Okio.sink(file, z16), task, response);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(response, "response");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, task, response, Boolean.valueOf(z16));
        }
    }
}

package com.tencent.qqnt.http.download;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/http/download/e;", "", "Lcom/tencent/qqnt/http/api/b;", "task", "Lokhttp3/Request;", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/Request$Builder;", "requestBuilder", "", "b", "Lokhttp3/Response;", "response", "Lokhttp3/Response$Builder;", "responseBuilder", "a", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface e {
    void a(@NotNull com.tencent.qqnt.http.api.b task, @NotNull Response response, @NotNull Response.Builder responseBuilder);

    void b(@NotNull com.tencent.qqnt.http.api.b task, @NotNull Request request, @NotNull Request.Builder requestBuilder);
}

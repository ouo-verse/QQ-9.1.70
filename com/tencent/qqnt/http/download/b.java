package com.tencent.qqnt.http.download;

import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.impl.h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/http/download/b;", "Lcom/tencent/qqnt/http/download/e;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lokhttp3/Request;", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/Request$Builder;", "requestBuilder", "", "b", "Lokhttp3/Response;", "response", "Lokhttp3/Response$Builder;", "responseBuilder", "a", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat dateFormat;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.dateFormat = simpleDateFormat;
    }

    @Override // com.tencent.qqnt.http.download.e
    public void a(@NotNull com.tencent.qqnt.http.api.b task, @NotNull Response response, @NotNull Response.Builder responseBuilder) {
        Long l3;
        Date parse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, task, response, responseBuilder);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(responseBuilder, "responseBuilder");
        try {
            String str = response.headers().get("last-modified");
            if (str != null && (parse = this.dateFormat.parse(str)) != null) {
                l3 = Long.valueOf(parse.getTime());
            } else {
                l3 = null;
            }
            if (l3 != null) {
                l3.longValue();
                File d16 = task.d();
                if (d16 != null && d16.exists()) {
                    d16.setLastModified(l3.longValue());
                }
            }
        } catch (Exception e16) {
            QLog.e(h.TAG, 1, "Cache304Interceptor error", e16);
        }
    }

    @Override // com.tencent.qqnt.http.download.e
    public void b(@NotNull com.tencent.qqnt.http.api.b task, @NotNull Request request, @NotNull Request.Builder requestBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, task, request, requestBuilder);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        File d16 = task.d();
        if (d16 != null && d16.exists()) {
            long lastModified = d16.lastModified();
            if (lastModified > 0) {
                String ifModifiedSince = this.dateFormat.format(new Date(lastModified));
                if (!TextUtils.isEmpty(ifModifiedSince)) {
                    Intrinsics.checkNotNullExpressionValue(ifModifiedSince, "ifModifiedSince");
                    requestBuilder.header("If-Modified-Since", ifModifiedSince).build();
                }
            }
        }
    }
}

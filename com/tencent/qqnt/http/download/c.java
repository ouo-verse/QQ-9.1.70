package com.tencent.qqnt.http.download;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.impl.h;
import com.tencent.qqperf.reporter.api.IDownloaderReporter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/http/download/c;", "Lcom/tencent/qqnt/http/download/e;", "Ljava/io/OutputStream;", "outputStream", "Lcom/tencent/qqnt/http/api/b;", "task", "Lokhttp3/Response;", "response", "", "d", "Ljava/io/File;", "tempFile", "c", "Lokhttp3/Request;", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/Request$Builder;", "requestBuilder", "b", "Lokhttp3/Response$Builder;", "responseBuilder", "a", "", "J", "getDownloadStartOffset", "()J", "setDownloadStartOffset", "(J)V", "downloadStartOffset", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long downloadStartOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/http/download/c$a;", "", "", "RANGE", "Ljava/lang/String;", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.download.c$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(File tempFile, com.tencent.qqnt.http.api.b task, Response response) throws IOException {
        if (!response.isSuccessful()) {
            tempFile.delete();
            return;
        }
        File d16 = task.d();
        Intrinsics.checkNotNull(d16);
        try {
            tempFile.getParentFile().mkdirs();
            boolean z16 = false;
            if (this.downloadStartOffset <= 0) {
                tempFile.delete();
            } else if (response.code() == 206) {
                z16 = true;
            }
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            try {
                d dVar = new d(tempFile, task, response, z16);
                dVar.a(this.downloadStartOffset);
                dVar.b(body.getSource());
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(body, null);
                if (!Intrinsics.areEqual(tempFile.getAbsolutePath(), d16.getAbsolutePath())) {
                    if (d16.exists()) {
                        d16.delete();
                    }
                    if (!tempFile.renameTo(d16)) {
                        DownloadException downloadException = new DownloadException(-1400);
                        downloadException.setHttpCode(Integer.valueOf(response.code()));
                        throw downloadException;
                    }
                }
            } finally {
            }
        } catch (IOException e16) {
            QLog.e(h.TAG, 1, "downloadByFile", e16);
            DownloadException downloadException2 = new DownloadException(-1401, e16);
            downloadException2.setHttpCode(Integer.valueOf(response.code()));
            throw downloadException2;
        }
    }

    private final void d(OutputStream outputStream, com.tencent.qqnt.http.api.b task, Response response) {
        if (!response.isSuccessful()) {
            return;
        }
        try {
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            try {
                g gVar = new g(outputStream, task, response);
                gVar.a(this.downloadStartOffset);
                gVar.b(body.getSource());
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(body, null);
            } finally {
            }
        } catch (IOException e16) {
            QLog.e(h.TAG, 1, "downloadByOutputStream", e16);
            DownloadException downloadException = new DownloadException(-1402, e16);
            downloadException.setHttpCode(Integer.valueOf(response.code()));
            throw downloadException;
        }
    }

    @Override // com.tencent.qqnt.http.download.e
    public void a(@NotNull com.tencent.qqnt.http.api.b task, @NotNull Response response, @NotNull Response.Builder responseBuilder) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, task, response, responseBuilder);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(responseBuilder, "responseBuilder");
        if (task.d() != null) {
            File c16 = com.tencent.qqnt.http.api.impl.b.c(task);
            Intrinsics.checkNotNull(c16);
            c(c16, task, response);
        } else if (task.k() != null) {
            OutputStream k3 = task.k();
            Intrinsics.checkNotNull(k3);
            d(k3, task, response);
        }
        try {
            ResponseBody body = response.body();
            if (body != null) {
                ((IDownloaderReporter) QRoute.api(IDownloaderReporter.class)).downloaderReport("Okhttp", task.x(), body.getContentLength());
            }
        } catch (Exception e16) {
            QLog.e(h.TAG, 1, "downloaderReport error.", e16);
        }
    }

    @Override // com.tencent.qqnt.http.download.e
    public void b(@NotNull com.tencent.qqnt.http.api.b task, @NotNull Request request, @NotNull Request.Builder requestBuilder) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, task, request, requestBuilder);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        if (task.a() != null) {
            com.tencent.qqnt.http.api.c a16 = task.a();
            Intrinsics.checkNotNull(a16);
            long startDownOffset = a16.getStartDownOffset();
            com.tencent.qqnt.http.api.c a17 = task.a();
            Intrinsics.checkNotNull(a17);
            long endDownOffset = a17.getEndDownOffset();
            if (task.d() != null) {
                File c16 = com.tencent.qqnt.http.api.impl.b.c(task);
                Intrinsics.checkNotNull(c16);
                if (c16.exists()) {
                    startDownOffset = c16.length();
                }
            }
            if (startDownOffset >= 0) {
                if (endDownOffset == 0) {
                    if (startDownOffset > 0) {
                        str = "bytes=" + startDownOffset + "-";
                    }
                    str = null;
                } else {
                    if (endDownOffset > startDownOffset) {
                        str = "bytes=" + startDownOffset + "-" + endDownOffset;
                    }
                    str = null;
                }
                if (str != null) {
                    requestBuilder.removeHeader("Range");
                    requestBuilder.addHeader("Range", str);
                    this.downloadStartOffset = startDownOffset;
                }
            }
        }
    }
}

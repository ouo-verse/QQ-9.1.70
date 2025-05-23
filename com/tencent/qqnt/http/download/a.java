package com.tencent.qqnt.http.download;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.j;
import com.tencent.qqnt.http.api.n;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/http/download/a;", "Lokio/ForwardingSink;", "Lokio/Buffer;", "source", "", "byteCount", "", k.f247492f, "Lokio/BufferedSource;", "b", "Lcom/tencent/qqnt/http/api/b;", "d", "Lcom/tencent/qqnt/http/api/b;", "getTask", "()Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/j;", "e", "Lcom/tencent/qqnt/http/api/j;", "getProgressListener", "()Lcom/tencent/qqnt/http/api/j;", "setProgressListener", "(Lcom/tencent/qqnt/http/api/j;)V", "progressListener", "f", "J", "getLastNotifyTime", "()J", "setLastNotifyTime", "(J)V", "lastNotifyTime", h.F, "getStartOffset", "a", "startOffset", "Lokio/Sink;", "sink", "Lokhttp3/Response;", "response", "<init>", "(Lokio/Sink;Lcom/tencent/qqnt/http/api/b;Lokhttp3/Response;)V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class a extends ForwardingSink {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.http.api.b task;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j progressListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastNotifyTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long startOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Sink sink, @NotNull com.tencent.qqnt.http.api.b task, @NotNull Response response) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(response, "response");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sink, task, response);
            return;
        }
        this.task = task;
        this.progressListener = task.l();
        this.lastNotifyTime = SystemClock.uptimeMillis();
        n s16 = task.s();
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        s16.i(body.getContentLength());
    }

    public final void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.startOffset = j3;
        }
    }

    public final void b(@NotNull BufferedSource source) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) source);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Throwable th5 = null;
        try {
            l3 = Long.valueOf(source.readAll(this));
        } catch (Throwable th6) {
            th5 = th6;
            l3 = null;
        }
        try {
            close();
        } catch (Throwable th7) {
            if (th5 != null) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th5, th7);
            } else {
                th5 = th7;
            }
        }
        if (th5 == null) {
            Intrinsics.checkNotNull(l3);
            return;
        }
        throw th5;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, source, Long.valueOf(byteCount));
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        super.write(source, byteCount);
        n s16 = this.task.s();
        s16.k(s16.e() + byteCount);
        j jVar = this.progressListener;
        if (jVar != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long e16 = this.task.s().e() + this.startOffset;
            if (uptimeMillis - this.lastNotifyTime > jVar.getNotifyIntervalTime()) {
                try {
                    long d16 = this.task.s().d();
                    jVar.onProgress(this.task, e16, d16);
                    if (d16 > 0) {
                        jVar.setProgressRate(((float) e16) / ((float) d16));
                    }
                } catch (Throwable th5) {
                    QLog.d(IHttpService.TAG, 2, "write notify progress error", th5);
                }
                this.lastNotifyTime = uptimeMillis;
            }
        }
    }
}

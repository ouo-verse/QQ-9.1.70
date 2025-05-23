package com.tencent.qqnt.http.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.http.api.g;
import com.tencent.qqnt.http.api.m;
import com.tencent.qqnt.http.download.DownloadException;
import com.tencent.ttpic.openapi.VError;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b?\u0010@J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\rR\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0004\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00107\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010>\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/a;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "j", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", tl.h.F, "Lokhttp3/Response;", "response", "", "i", "b", "c", "g", "Lcom/tencent/qqnt/http/api/m;", "a", "f", "Lcom/tencent/qqnt/http/api/b;", "Lcom/tencent/qqnt/http/api/b;", "()Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/impl/e;", "Lcom/tencent/qqnt/http/api/impl/e;", "d", "()Lcom/tencent/qqnt/http/api/impl/e;", "onCall", "", "I", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorCode", "Ljava/lang/Integer;", "getHttpCode", "()Ljava/lang/Integer;", "setHttpCode", "(Ljava/lang/Integer;)V", "httpCode", "Lcom/tencent/qqnt/http/api/g;", "Lcom/tencent/qqnt/http/api/g;", "getResponseImpl", "()Lcom/tencent/qqnt/http/api/g;", "setResponseImpl", "(Lcom/tencent/qqnt/http/api/g;)V", "responseImpl", "Z", "getAllowRetry", "()Z", "setAllowRetry", "(Z)V", "allowRetry", "", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorMsg", "<init>", "(Lcom/tencent/qqnt/http/api/b;Lcom/tencent/qqnt/http/api/impl/e;)V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.http.api.b task;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e onCall;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer httpCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.http.api.g responseImpl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean allowRetry;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String errorMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/http/api/impl/a$a", "Lcom/tencent/qqnt/http/api/g;", "Ljava/io/InputStream;", "a", "", "Lkotlin/Pair;", "", "headers", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.api.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9633a implements com.tencent.qqnt.http.api.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Response f357005a;

        C9633a(Response response) {
            this.f357005a = response;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) response);
            }
        }

        @Override // com.tencent.qqnt.http.api.g
        @Nullable
        public InputStream a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (InputStream) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ResponseBody body = this.f357005a.body();
            if (body != null) {
                return body.byteStream();
            }
            return null;
        }

        @Override // com.tencent.qqnt.http.api.g
        @Nullable
        public Map<String, String> getHeaders() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return g.a.a(this);
        }

        @Override // com.tencent.qqnt.http.api.g
        @Nullable
        public Iterable<Pair<String, String>> headers() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Iterable) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f357005a.headers();
        }
    }

    public a(@NotNull com.tencent.qqnt.http.api.b task, @NotNull e onCall) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onCall, "onCall");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) task, (Object) onCall);
            return;
        }
        this.task = task;
        this.onCall = onCall;
        this.allowRetry = true;
    }

    @NotNull
    public final m a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (m) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        m mVar = new m();
        mVar.f(this.errorCode);
        mVar.h(this.httpCode);
        mVar.i(this.responseImpl);
        mVar.g(this.errorMsg);
        return mVar;
    }

    public final boolean b() {
        Map<String, String> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (!this.allowRetry || this.task.z()) {
            return false;
        }
        if (!f() && !c()) {
            return false;
        }
        com.tencent.qqnt.http.api.h p16 = this.task.p();
        if (p16 != null) {
            Integer num = this.httpCode;
            com.tencent.qqnt.http.api.g gVar = this.responseImpl;
            if (gVar != null) {
                map = gVar.getHeaders();
            } else {
                map = null;
            }
            if (!p16.b(num, map)) {
                return false;
            }
        }
        if (this.task.s().a() >= this.task.o()) {
            return false;
        }
        Long b16 = this.task.s().b();
        if (b16 != null) {
            if (SystemClock.uptimeMillis() - b16.longValue() > this.task.w()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return false;
    }

    @NotNull
    public final e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.onCall;
    }

    @NotNull
    public final com.tencent.qqnt.http.api.b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.http.api.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.task;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (NetworkUtil.getSystemNetwork(BaseApplication.context) != 0) {
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.errorCode = 0;
        this.httpCode = null;
        this.responseImpl = null;
    }

    public final void h(@NotNull Call call, @NotNull IOException e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) call, (Object) e16);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e16, "e");
        String message = e16.getMessage();
        if (message != null) {
            this.errorMsg = message;
        }
        if (!f()) {
            this.errorCode = LightConstants.ErrorCode.BONE_NOT_SUPPORT;
            return;
        }
        if (call.getCanceled()) {
            if (this.task.z()) {
                this.errorCode = WeakNetLearner.PROBE_REASON.INVALID_DATA;
            } else {
                this.errorCode = WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL;
            }
            this.allowRetry = false;
            return;
        }
        if (e16 instanceof DownloadException) {
            DownloadException downloadException = (DownloadException) e16;
            this.errorCode = downloadException.getErrorCode();
            this.httpCode = downloadException.getHttpCode();
        } else if (e16.getCause() instanceof RejectedExecutionException) {
            this.errorCode = -1100;
            this.allowRetry = false;
        } else if (e16 instanceof SocketTimeoutException) {
            this.errorCode = -1201;
        } else if (e16 instanceof SSLPeerUnverifiedException) {
            this.errorCode = -1202;
        } else {
            this.errorCode = VError.ERROR_STICKER_CREATE_FAIL;
        }
    }

    public final boolean i(@NotNull Response response) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) response)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(response, "response");
        this.httpCode = Integer.valueOf(response.code());
        this.responseImpl = new C9633a(response);
        if ((this.task.t() && (num = this.httpCode) != null && num.intValue() == 304) || response.isSuccessful()) {
            return true;
        }
        this.errorMsg = String.valueOf(response.code());
        this.errorCode = VError.ERROR_BEAUTY_FACE_ATTR_NULL;
        if (response.code() >= 500) {
            this.errorCode = -1600;
            return false;
        }
        return false;
    }

    public final void j(@NotNull Exception e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) e16);
            return;
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        if (e16 instanceof DuplicateTaskException) {
            this.errorCode = -1103;
        } else {
            this.errorCode = -1104;
        }
    }
}

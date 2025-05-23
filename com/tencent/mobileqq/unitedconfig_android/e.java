package com.tencent.mobileqq.unitedconfig_android;

import com.tencent.freesia.HTTPBridge;
import com.tencent.freesia.HTTPObserverCenter;
import com.tencent.freesia.HTTPResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0096\u0002R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/e;", "Lcom/tencent/freesia/HTTPBridge;", "", "seq", "", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "header", "outputPath", "", "get", "Lcom/tencent/freesia/HTTPObserverCenter;", "a", "Lcom/tencent/freesia/HTTPObserverCenter;", "mHTTPObserverCenter", "<init>", "()V", "b", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e implements HTTPBridge {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HTTPObserverCenter mHTTPObserverCenter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.unitedconfig_android.e$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/unitedconfig_android/e$b", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onFailed", "onSuccess", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.qqnt.http.api.l {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f306038b;

        b(int i3) {
            this.f306038b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, i3);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            int i3;
            HashMap hashMap;
            Map<String, String> headers;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            HTTPObserverCenter hTTPObserverCenter = e.this.mHTTPObserverCenter;
            if (hTTPObserverCenter != null) {
                int i16 = this.f306038b;
                Integer c16 = result.c();
                if (c16 != null) {
                    i3 = c16.intValue();
                } else {
                    i3 = 0;
                }
                com.tencent.qqnt.http.api.g d16 = result.d();
                if (d16 != null && (headers = d16.getHeaders()) != null) {
                    hashMap = new HashMap(headers);
                } else {
                    hashMap = new HashMap();
                }
                hTTPObserverCenter.onResult(i16, false, new HTTPResponse(i3, hashMap));
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            int i3;
            HashMap hashMap;
            Map<String, String> headers;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            HTTPObserverCenter hTTPObserverCenter = e.this.mHTTPObserverCenter;
            if (hTTPObserverCenter != null) {
                int i16 = this.f306038b;
                Integer c16 = result.c();
                if (c16 != null) {
                    i3 = c16.intValue();
                } else {
                    i3 = 0;
                }
                com.tencent.qqnt.http.api.g d16 = result.d();
                if (d16 != null && (headers = d16.getHeaders()) != null) {
                    hashMap = new HashMap(headers);
                } else {
                    hashMap = new HashMap();
                }
                hTTPObserverCenter.onResult(i16, true, new HTTPResponse(i3, hashMap));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHTTPObserverCenter = com.tencent.freesia.a.a();
        }
    }

    @Override // com.tencent.freesia.HTTPBridge
    public void get(int seq, @NotNull String url, @NotNull HashMap<String, String> header, @NotNull String outputPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(seq), url, header, outputPath);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        if (QLog.isDevelopLevel()) {
            QLog.d("FreesiaHttp", 4, "send: " + url);
        }
        b.a aVar = new b.a("freesia", url, new File(outputPath));
        aVar.a(header).M(new com.tencent.qqnt.http.api.k());
        aVar.T(new b(seq));
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(aVar.c());
    }
}

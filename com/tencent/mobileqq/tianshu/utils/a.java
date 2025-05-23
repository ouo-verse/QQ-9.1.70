package com.tencent.mobileqq.tianshu.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/tianshu/utils/a;", "", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "b", "", "", "downloadList", "Lcom/tencent/mobileqq/tianshu/utils/a$a;", "callback", "", "c", "Ljava/lang/String;", "TAG", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "downloadStrategy", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "downloadHelper", "<init>", "()V", "a", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f293183a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final RFWDownloadStrategy downloadStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final RFWDownloader downloadHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tianshu/utils/a$a;", "", "", "url", "filePath", "", "a", "b", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8652a {
        void a(@NotNull String url, @Nullable String filePath);

        void b(@NotNull String url);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tianshu/utils/a$b;", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "", "getBusinessKey", "Landroid/content/SharedPreferences;", "getSP", "", "supportUnZipFile", "allowGeneratedNoMedia", "supportBreakPointDownload", "downloadUrl", "useSimpleFileName", "isSupplementFileExtensionName", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RFWDownloadStrategy {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean allowGeneratedNoMedia() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public String getBusinessKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "TianshuCommom";
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public SharedPreferences getSP() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            SharedPreferences sharedPreferences = RFWApplication.getApplication().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplication().getShar\u2026ODE_PRIVATE\n            )");
            return sharedPreferences;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean isSupplementFileExtensionName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportBreakPointDownload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportUnZipFile() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean useSimpleFileName(@NotNull String downloadUrl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloadUrl)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
            return !TextUtils.isEmpty(downloadUrl);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/tianshu/utils/a$c", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements RFWDownloader.RFWDownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f293187d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC8652a f293188e;

        c(String str, InterfaceC8652a interfaceC8652a) {
            this.f293187d = str;
            this.f293188e = interfaceC8652a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) interfaceC8652a);
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(percent), Long.valueOf(downloadedLength), Long.valueOf(totalLength));
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean isSuccess, @Nullable String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QLog.e(a.TAG, 1, "download success:" + isSuccess + ", url:" + this.f293187d);
                if (isSuccess && !TextUtils.isEmpty(filePath)) {
                    InterfaceC8652a interfaceC8652a = this.f293188e;
                    if (interfaceC8652a != null) {
                        interfaceC8652a.a(this.f293187d, filePath);
                        return;
                    }
                    return;
                }
                InterfaceC8652a interfaceC8652a2 = this.f293188e;
                if (interfaceC8652a2 != null) {
                    interfaceC8652a2.b(this.f293187d);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), filePath);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            v.t(this, call);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22851);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        a aVar = new a();
        f293183a = aVar;
        TAG = "TianshuFileDownloadManager";
        RFWDownloadStrategy b16 = aVar.b();
        downloadStrategy = b16;
        downloadHelper = RFWDownloaderFactory.getDownloader(b16);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final RFWDownloadStrategy b() {
        return new b();
    }

    public final void c(@NotNull List<String> downloadList, @Nullable InterfaceC8652a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadList, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(downloadList, "downloadList");
        String str = TAG;
        QLog.d(str, 1, "startLoad");
        if (RFSafeListUtils.isEmpty(downloadList)) {
            QLog.e(str, 1, "[startLoad] download list is empty");
            return;
        }
        for (String str2 : downloadList) {
            if (!TextUtils.isEmpty(str2)) {
                downloadHelper.download(str2, new c(str2, callback));
            }
        }
    }
}

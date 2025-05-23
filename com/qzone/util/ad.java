package com.qzone.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u001c\u0010\u0014\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/util/ad;", "", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "b", "", "", "downloadList", "Lcom/qzone/util/ad$a;", "callback", "", "d", "url", "c", "Ljava/lang/String;", "TAG", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "downloadStrategy", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "kotlin.jvm.PlatformType", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "downloadHelper", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    public static final ad f59766a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final RFWDownloadStrategy downloadStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final RFWDownloader downloadHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/util/ad$a;", "", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
        void a(String url, String filePath);

        void b(String url);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/util/ad$b;", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "", "getBusinessKey", "Landroid/content/SharedPreferences;", "getSP", "", "supportUnZipFile", "allowGeneratedNoMedia", "supportBreakPointDownload", "downloadUrl", "useSimpleFileName", "isSupplementFileExtensionName", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RFWDownloadStrategy {
        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean allowGeneratedNoMedia() {
            return false;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public String getBusinessKey() {
            return "QZoneStrategyCommon";
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public SharedPreferences getSP() {
            SharedPreferences o16 = u5.c.o();
            Intrinsics.checkNotNullExpressionValue(o16, "getPreferences()");
            return o16;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean isSupplementFileExtensionName() {
            return true;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportBreakPointDownload() {
            return true;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportUnZipFile() {
            return false;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean useSimpleFileName(String downloadUrl) {
            Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
            return !TextUtils.isEmpty(downloadUrl);
        }
    }

    static {
        ad adVar = new ad();
        f59766a = adVar;
        TAG = "QZoneFileDownloadManager";
        RFWDownloadStrategy b16 = adVar.b();
        downloadStrategy = b16;
        downloadHelper = RFWDownloaderFactory.getDownloader(b16);
    }

    ad() {
    }

    private final RFWDownloadStrategy b() {
        return new b();
    }

    public final String c(String url) {
        String contentFilePath = downloadHelper.getContentFilePath(url);
        QLog.d(TAG, 1, "getLocalPath url:" + url + ", localPath:" + contentFilePath);
        return contentFilePath;
    }

    public final void d(List<String> downloadList, a callback) {
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/util/ad$c", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f59770d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f59771e;

        c(String str, a aVar) {
            this.f59770d = str;
            this.f59771e = aVar;
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            com.tencent.biz.richframework.download.v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            com.tencent.biz.richframework.download.v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            com.tencent.biz.richframework.download.v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            com.tencent.biz.richframework.download.v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            com.tencent.biz.richframework.download.v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            com.tencent.biz.richframework.download.v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            com.tencent.biz.richframework.download.v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            com.tencent.biz.richframework.download.v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean isSuccess, String filePath) {
            QLog.e(ad.TAG, 1, "download success:" + isSuccess + ", url:" + this.f59770d);
            if (isSuccess && !TextUtils.isEmpty(filePath)) {
                a aVar = this.f59771e;
                if (aVar != null) {
                    aVar.a(this.f59770d, filePath);
                    return;
                }
                return;
            }
            a aVar2 = this.f59771e;
            if (aVar2 != null) {
                aVar2.b(this.f59770d);
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            com.tencent.biz.richframework.download.v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            com.tencent.biz.richframework.download.v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            com.tencent.biz.richframework.download.v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            com.tencent.biz.richframework.download.v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
        }
    }
}

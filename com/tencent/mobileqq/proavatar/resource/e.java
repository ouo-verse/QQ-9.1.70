package com.tencent.mobileqq.proavatar.resource;

import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.proavatar.resource.e;
import com.tencent.mobileqq.proavatar.util.ProAvatarUrlUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.apache.http.conn.ConnectTimeoutException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J2\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002JJ\u0010\u001a\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u001c\u0010\u001f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002J\"\u0010\"\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010$\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002J \u0010&\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0002J\"\u0010'\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u001e\u0010*\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(J?\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010+2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/proavatar/resource/e;", "", "", "k", "", "originUrl", "Ljava/io/File;", "file", "", h.F, "urlString", "Landroid/net/NetworkInfo;", "activeNetworkInfo", "Ljava/net/URL;", "url", "Lcom/tencent/mobileqq/proavatar/resource/a;", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "result", "tryCount", "useProxy", "defaultHost", "defaultPort", "type", "apnType", "i", "Ljava/io/OutputStream;", "os", "Ljava/net/HttpURLConnection;", "httpConn", "c", "tmpFile", DomainData.DOMAIN_NAME, "p", "j", "e", "Ljava/io/IOException;", "d", "o", "Lcom/tencent/qqnt/avatar/meta/resource/a;", "callback", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)[Ljava/lang/Object;", "<init>", "()V", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static int f259693b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static String f259694c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f259695d;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/proavatar/resource/e$a;", "", "Ljavax/net/ssl/HttpsURLConnection;", "conn", "Ljava/net/URL;", "urlObj", "", "isIp", "", "c", "", "DPC_WAP_DIRECT_CONNECT", "I", "", "TAG", "Ljava/lang/String;", "forceDirect", "Z", "lastApn", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.resource.e$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(HttpsURLConnection conn, final URL urlObj, final boolean isIp) {
            HostnameVerifier hostnameVerifier = new HostnameVerifier() { // from class: com.tencent.mobileqq.proavatar.resource.d
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    boolean d16;
                    d16 = e.Companion.d(isIp, urlObj, str, sSLSession);
                    return d16;
                }
            };
            conn.setRequestProperty("host", urlObj.getHost());
            conn.setSSLSocketFactory(new SniSSLSocketFactory(urlObj.getHost(), hostnameVerifier));
            conn.setHostnameVerifier(hostnameVerifier);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(boolean z16, URL urlObj, String str, SSLSession sSLSession) {
            Intrinsics.checkNotNullParameter(urlObj, "$urlObj");
            if (!z16 && !HttpsURLConnection.getDefaultHostnameVerifier().verify(urlObj.getHost(), sSLSession)) {
                return false;
            }
            return true;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18108);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f259693b = 1;
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            k();
        }
    }

    private final void c(OutputStream os5, HttpURLConnection httpConn) {
        if (httpConn != null) {
            httpConn.disconnect();
        }
        if (os5 != null) {
            try {
                os5.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int d(URL url, File tmpFile, IOException e16) {
        boolean contains$default;
        int i3;
        boolean e17;
        long c16;
        String str;
        String str2;
        boolean contains$default2;
        boolean contains$default3;
        QLog.i("ProAvatarDownloader", 1, "Download fail 1. url=" + url, e16);
        if (e16 instanceof UnknownHostException) {
            return 10;
        }
        if ((e16 instanceof ConnectTimeoutException) || (e16 instanceof SocketTimeoutException)) {
            return 2;
        }
        if (e16 instanceof SocketException) {
            return 11;
        }
        if (e16 instanceof ConnectException) {
            return 17;
        }
        if (e16 instanceof HttpRetryException) {
            return 18;
        }
        if (e16 instanceof EOFException) {
            return 19;
        }
        String message = e16.getMessage();
        Intrinsics.checkNotNull(message);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "EACCES", false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "ENOSPC", false, 2, (Object) null);
            if (!contains$default2) {
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "Read-only", false, 2, (Object) null);
                if (!contains$default3) {
                    i3 = 4;
                    e17 = cu.e();
                    if (!e17) {
                        c16 = cu.b();
                    } else {
                        c16 = cu.c();
                    }
                    str = "notExit";
                    if (tmpFile.exists()) {
                        str2 = "notExit";
                    } else {
                        str2 = tmpFile.getAbsolutePath();
                    }
                    if (tmpFile.getParentFile() != null && tmpFile.getParentFile().exists()) {
                        str = tmpFile.getParentFile().getAbsolutePath();
                    }
                    QLog.i("ProAvatarDownloader", 1, "Download fail 1. tmpFilePath=" + str2 + "tmpParentFilePath=" + str + ", result=" + i3 + ",isExistSDCard=" + e17 + ",availableSize=" + c16);
                    return i3;
                }
            }
        }
        i3 = 33;
        e17 = cu.e();
        if (!e17) {
        }
        str = "notExit";
        if (tmpFile.exists()) {
        }
        if (tmpFile.getParentFile() != null) {
            str = tmpFile.getParentFile().getAbsolutePath();
        }
        QLog.i("ProAvatarDownloader", 1, "Download fail 1. tmpFilePath=" + str2 + "tmpParentFilePath=" + str + ", result=" + i3 + ",isExistSDCard=" + e17 + ",availableSize=" + c16);
        return i3;
    }

    private final void e(int result, File tmpFile) {
        if (result != 0 && tmpFile != null) {
            try {
                j(tmpFile);
                if (tmpFile.exists()) {
                    QLog.i("ProAvatarDownloader", 1, "delete file in finally: " + tmpFile.delete());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e this$0, String url, File file, com.tencent.qqnt.avatar.meta.resource.a callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a(this$0.h(url, file));
    }

    private final boolean h(String originUrl, File file) {
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo == null) {
            QLog.i("ProAvatarDownloader", 1, "downloadData failed-----------activeNetworkInfo is null");
            return false;
        }
        try {
            URL url = new URL(originUrl);
            try {
                j(file);
                a aVar = new a(originUrl, null, 0);
                try {
                    String escapeSequence = HttpDownloadUtil.getEscapeSequence(originUrl);
                    Intrinsics.checkNotNullExpressionValue(escapeSequence, "getEscapeSequence(str)");
                    return m(escapeSequence, file, recentNetworkInfo, url, aVar);
                } catch (Throwable unused) {
                    QLog.e("ProAvatarDownloader", 1, "downloadData. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
                    return false;
                }
            } catch (Exception unused2) {
                QLog.e("ProAvatarDownloader", 1, "downloadData. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
                return false;
            }
        } catch (MalformedURLException e16) {
            QLog.e("ProAvatarDownloader", 1, "downloadData error", e16);
            return false;
        }
    }

    private final void i(String urlString, int result, int tryCount, boolean useProxy, String defaultHost, int defaultPort, int type, String apnType) {
        if (result != 0) {
            QLog.i("ProAvatarDownloader", 1, "Download. result=" + result + ", urlString=" + urlString + ", tryCount=" + tryCount + ",useProxy=" + useProxy + ",defaultHost=" + defaultHost + ",defaultPort=" + defaultPort + ",forceDirect=" + f259695d + ",type=" + type + ",apnType=" + apnType + ",dpcwap=" + f259693b);
        }
        if (result != 0 && tryCount < 2) {
            LockMethodProxy.sleep(500L);
        }
    }

    private final void j(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    private final void k() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.resource.b
            @Override // java.lang.Runnable
            public final void run() {
                e.l();
            }
        }, 5, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name(), IDPCApiConstant.AIO_CMWAP_QQHEAD);
        Intrinsics.checkNotNullExpressionValue(featureValueWithoutAccountManager, "api(\n                IDP\u2026MWAP_QQHEAD\n            )");
        if (QLog.isColorLevel()) {
            QLog.i("ProAvatarDownloader", 2, "initDPCFlag headWapConn:" + featureValueWithoutAccountManager);
        }
        Object[] array = new Regex("\\|").split(featureValueWithoutAccountManager, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length > 7) {
            try {
                f259693b = Integer.parseInt(strArr[7]);
                if (QLog.isColorLevel()) {
                    QLog.i("ProAvatarDownloader", 2, "initDPCFlag DPC_WAP_DIRECT_CONNECT=" + f259693b);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ProAvatarDownloader", 2, "initDPCFlag error :", e16);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0315 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0317 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0311 A[ADDED_TO_REGION, EDGE_INSN: B:42:0x0311->B:37:0x0311 BREAK  A[LOOP:0: B:2:0x000a->B:35:0x030b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0179 A[Catch: all -> 0x01b9, TryCatch #15 {all -> 0x01b9, blocks: (B:71:0x016f, B:73:0x0179, B:74:0x017f), top: B:70:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m(String urlString, File file, NetworkInfo activeNetworkInfo, URL url, a info) {
        int i3;
        int i16;
        int i17;
        URL url2;
        int i18;
        boolean z16;
        BufferedOutputStream bufferedOutputStream;
        String a16;
        String str;
        int i19;
        BufferedOutputStream bufferedOutputStream2;
        HttpURLConnection httpURLConnection;
        Throwable th5;
        int i26;
        String apnType;
        int i27;
        HttpURLConnection httpURLConnection2;
        Object[] q16;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream3;
        BufferedOutputStream bufferedOutputStream4;
        byte[] bArr;
        URL url3 = url;
        int i28 = -1;
        int i29 = -1;
        BufferedOutputStream bufferedOutputStream5 = null;
        HttpURLConnection httpURLConnection4 = null;
        while (true) {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            String netGetExInfo = activeNetworkInfo != null ? NetworkMonitor.netGetExInfo(activeNetworkInfo) : null;
            int type = activeNetworkInfo != null ? NetworkMonitor.getType(activeNetworkInfo) : i28;
            String apnType2 = PkgTools.getApnType(netGetExInfo);
            File file2 = new File(file.getPath() + ".tmp");
            if (file2.exists()) {
                file2.delete();
            }
            if (i29 > i28) {
                a16 = urlString;
            } else {
                try {
                    try {
                        try {
                            a16 = ProAvatarUrlUtils.f259699a.a(urlString);
                        } catch (IOException e16) {
                            e = e16;
                            i3 = type;
                            i17 = defaultPort;
                            i16 = -1;
                            url2 = url;
                            bufferedOutputStream = bufferedOutputStream5;
                            i18 = 5;
                            z16 = false;
                            try {
                                int d16 = d(url2, file2, e);
                                c(bufferedOutputStream, httpURLConnection4);
                                e(d16, file2);
                                int i36 = i29 + 1;
                                Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                                i(urlString, d16, i36, z16, defaultHost, i17, i3, apnType2);
                                bufferedOutputStream5 = bufferedOutputStream;
                                i29 = i36;
                                httpURLConnection4 = httpURLConnection4;
                                i27 = d16;
                                if (i27 != 0) {
                                }
                                info.f259678f = i27;
                                if (i27 != 0) {
                                }
                            } catch (Throwable th6) {
                                HttpURLConnection httpURLConnection5 = httpURLConnection4;
                                apnType = apnType2;
                                th5 = th6;
                                i26 = i18;
                                httpURLConnection = httpURLConnection5;
                                c(bufferedOutputStream, httpURLConnection);
                                e(i26, file2);
                                Intrinsics.checkNotNullExpressionValue(apnType, "apnType");
                                i(urlString, i26, i29 + 1, z16, defaultHost, i17, i3, apnType);
                                throw th5;
                            }
                        }
                    } catch (IOException e17) {
                        e = e17;
                        i3 = type;
                        i16 = -1;
                        URL url4 = url3;
                        i17 = defaultPort;
                        url2 = url4;
                        i18 = 5;
                        z16 = false;
                        bufferedOutputStream = bufferedOutputStream5;
                        int d162 = d(url2, file2, e);
                        c(bufferedOutputStream, httpURLConnection4);
                        e(d162, file2);
                        int i362 = i29 + 1;
                        Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                        i(urlString, d162, i362, z16, defaultHost, i17, i3, apnType2);
                        bufferedOutputStream5 = bufferedOutputStream;
                        i29 = i362;
                        httpURLConnection4 = httpURLConnection4;
                        i27 = d162;
                        if (i27 != 0) {
                        }
                        info.f259678f = i27;
                        if (i27 != 0) {
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = apnType2;
                    i3 = type;
                    i17 = defaultPort;
                    i16 = -1;
                    i19 = 5;
                    z16 = false;
                    HttpURLConnection httpURLConnection6 = httpURLConnection4;
                    bufferedOutputStream2 = bufferedOutputStream5;
                    httpURLConnection = httpURLConnection6;
                    try {
                        QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                        c(bufferedOutputStream2, httpURLConnection);
                        i27 = 5;
                        e(5, file2);
                        int i37 = i29 + 1;
                        String apnType3 = str;
                        Intrinsics.checkNotNullExpressionValue(apnType3, "apnType");
                        httpURLConnection2 = httpURLConnection;
                        i(urlString, 5, i37, z16, defaultHost, i17, i3, apnType3);
                        i29 = i37;
                        bufferedOutputStream5 = bufferedOutputStream2;
                        httpURLConnection4 = httpURLConnection2;
                        if (i27 != 0) {
                            break;
                        }
                        break;
                        info.f259678f = i27;
                        return i27 != 0;
                    } catch (Throwable th8) {
                        th5 = th8;
                        i26 = i19;
                        bufferedOutputStream = bufferedOutputStream2;
                        apnType = str;
                        c(bufferedOutputStream, httpURLConnection);
                        e(i26, file2);
                        Intrinsics.checkNotNullExpressionValue(apnType, "apnType");
                        i(urlString, i26, i29 + 1, z16, defaultHost, i17, i3, apnType);
                        throw th5;
                    }
                }
            }
            QLog.d("ProAvatarDownloader", 4, "realDownloadData realDownloadUrl:" + a16);
            Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
            o(defaultHost, type, apnType2);
            int i38 = 0;
            str = apnType2;
            i3 = type;
            try {
                q16 = q(defaultHost, defaultPort, apnType2, i29, a16);
                Object obj = q16[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                z16 = ((Boolean) obj).booleanValue();
            } catch (IOException e18) {
                e = e18;
                file2 = file2;
                i17 = defaultPort;
                i16 = -1;
                url2 = url;
                bufferedOutputStream = bufferedOutputStream5;
                apnType2 = str;
                i18 = 5;
                z16 = false;
                int d1622 = d(url2, file2, e);
                c(bufferedOutputStream, httpURLConnection4);
                e(d1622, file2);
                int i3622 = i29 + 1;
                Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                i(urlString, d1622, i3622, z16, defaultHost, i17, i3, apnType2);
                bufferedOutputStream5 = bufferedOutputStream;
                i29 = i3622;
                httpURLConnection4 = httpURLConnection4;
                i27 = d1622;
                if (i27 != 0) {
                }
                info.f259678f = i27;
                if (i27 != 0) {
                }
            } catch (Throwable th9) {
                th = th9;
                file2 = file2;
                i17 = defaultPort;
                i16 = -1;
                i19 = 5;
                z16 = false;
                HttpURLConnection httpURLConnection62 = httpURLConnection4;
                bufferedOutputStream2 = bufferedOutputStream5;
                httpURLConnection = httpURLConnection62;
                QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                c(bufferedOutputStream2, httpURLConnection);
                i27 = 5;
                e(5, file2);
                int i372 = i29 + 1;
                String apnType32 = str;
                Intrinsics.checkNotNullExpressionValue(apnType32, "apnType");
                httpURLConnection2 = httpURLConnection;
                i(urlString, 5, i372, z16, defaultHost, i17, i3, apnType32);
                i29 = i372;
                bufferedOutputStream5 = bufferedOutputStream2;
                httpURLConnection4 = httpURLConnection2;
                if (i27 != 0) {
                }
                info.f259678f = i27;
                if (i27 != 0) {
                }
            }
            try {
                Object obj2 = q16[1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection3 = (HttpURLConnection) obj2;
            } catch (IOException e19) {
                e = e19;
                file2 = file2;
                i17 = defaultPort;
                i16 = -1;
                url2 = url;
                bufferedOutputStream = bufferedOutputStream5;
            } catch (Throwable th10) {
                th = th10;
                file2 = file2;
                i17 = defaultPort;
                i16 = -1;
                i19 = 5;
                HttpURLConnection httpURLConnection622 = httpURLConnection4;
                bufferedOutputStream2 = bufferedOutputStream5;
                httpURLConnection = httpURLConnection622;
                QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                c(bufferedOutputStream2, httpURLConnection);
                i27 = 5;
                e(5, file2);
                int i3722 = i29 + 1;
                String apnType322 = str;
                Intrinsics.checkNotNullExpressionValue(apnType322, "apnType");
                httpURLConnection2 = httpURLConnection;
                i(urlString, 5, i3722, z16, defaultHost, i17, i3, apnType322);
                i29 = i3722;
                bufferedOutputStream5 = bufferedOutputStream2;
                httpURLConnection4 = httpURLConnection2;
                if (i27 != 0) {
                }
                info.f259678f = i27;
                if (i27 != 0) {
                }
            }
            try {
                httpURLConnection3.connect();
                info.f259679g = httpURLConnection3.getResponseCode();
                info.f259683k = httpURLConnection3.getContentLength();
                info.f259684l = httpURLConnection3.getContentType();
                info.f259685m = httpURLConnection3.getContentEncoding();
                info.f259682j = httpURLConnection3.getHeaderField("X-BCheck");
                try {
                    int i39 = info.f259679g;
                    if (200 == i39) {
                        try {
                            try {
                                if (file2.exists()) {
                                    try {
                                        file2.delete();
                                    } catch (FileNotFoundException unused) {
                                        file2 = file2;
                                        inputStream = null;
                                    }
                                }
                                File parentFile = file2.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                file2.createNewFile();
                                file2 = file2;
                                try {
                                    bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(file2));
                                    try {
                                        inputStream = httpURLConnection3.getInputStream();
                                        try {
                                            try {
                                                bArr = new byte[1024];
                                            } catch (Throwable th11) {
                                                th = th11;
                                            }
                                        } catch (FileNotFoundException unused2) {
                                        }
                                    } catch (FileNotFoundException unused3) {
                                        bufferedOutputStream5 = bufferedOutputStream4;
                                        inputStream = null;
                                        try {
                                            boolean exists = file2.exists();
                                            File parentFile2 = file2.getParentFile();
                                            if (parentFile2 != null) {
                                            }
                                            QLog.i("ProAvatarDownloader", 1, "FileNotFoundException file exist=" + exists + ", dir exist=" + (parentFile2 != null ? parentFile2.exists() : false));
                                            if (inputStream != null) {
                                            }
                                            bufferedOutputStream3 = bufferedOutputStream5;
                                            i38 = 4;
                                            c(bufferedOutputStream3, httpURLConnection3);
                                            e(i38, file2);
                                            int i46 = i29 + 1;
                                            httpURLConnection2 = httpURLConnection3;
                                            i16 = -1;
                                            i(urlString, i38, i46, z16, defaultHost, defaultPort, i3, str);
                                            bufferedOutputStream5 = bufferedOutputStream3;
                                            i27 = i38;
                                            i29 = i46;
                                            httpURLConnection4 = httpURLConnection2;
                                            if (i27 != 0) {
                                            }
                                            info.f259678f = i27;
                                            if (i27 != 0) {
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e26) {
                                                    e = e26;
                                                    httpURLConnection4 = httpURLConnection3;
                                                    bufferedOutputStream = bufferedOutputStream5;
                                                    apnType2 = str;
                                                    i17 = defaultPort;
                                                    i18 = 0;
                                                    i16 = -1;
                                                    url2 = url;
                                                    int d16222 = d(url2, file2, e);
                                                    c(bufferedOutputStream, httpURLConnection4);
                                                    e(d16222, file2);
                                                    int i36222 = i29 + 1;
                                                    Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                                                    i(urlString, d16222, i36222, z16, defaultHost, i17, i3, apnType2);
                                                    bufferedOutputStream5 = bufferedOutputStream;
                                                    i29 = i36222;
                                                    httpURLConnection4 = httpURLConnection4;
                                                    i27 = d16222;
                                                    if (i27 != 0) {
                                                    }
                                                    info.f259678f = i27;
                                                    if (i27 != 0) {
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    bufferedOutputStream2 = bufferedOutputStream5;
                                                    i17 = defaultPort;
                                                    i19 = 0;
                                                    i16 = -1;
                                                    httpURLConnection = httpURLConnection3;
                                                    QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                                                    c(bufferedOutputStream2, httpURLConnection);
                                                    i27 = 5;
                                                    e(5, file2);
                                                    int i37222 = i29 + 1;
                                                    String apnType3222 = str;
                                                    Intrinsics.checkNotNullExpressionValue(apnType3222, "apnType");
                                                    httpURLConnection2 = httpURLConnection;
                                                    i(urlString, 5, i37222, z16, defaultHost, i17, i3, apnType3222);
                                                    i29 = i37222;
                                                    bufferedOutputStream5 = bufferedOutputStream2;
                                                    httpURLConnection4 = httpURLConnection2;
                                                    if (i27 != 0) {
                                                    }
                                                    info.f259678f = i27;
                                                    if (i27 != 0) {
                                                    }
                                                }
                                            }
                                            throw th;
                                            break;
                                        }
                                    } catch (Throwable th14) {
                                        th = th14;
                                        bufferedOutputStream5 = bufferedOutputStream4;
                                        inputStream = null;
                                        if (inputStream != null) {
                                        }
                                        throw th;
                                        break;
                                        break;
                                    }
                                } catch (FileNotFoundException unused4) {
                                    inputStream = null;
                                    boolean exists2 = file2.exists();
                                    File parentFile22 = file2.getParentFile();
                                    if (parentFile22 != null) {
                                    }
                                    QLog.i("ProAvatarDownloader", 1, "FileNotFoundException file exist=" + exists2 + ", dir exist=" + (parentFile22 != null ? parentFile22.exists() : false));
                                    if (inputStream != null) {
                                    }
                                    bufferedOutputStream3 = bufferedOutputStream5;
                                    i38 = 4;
                                    c(bufferedOutputStream3, httpURLConnection3);
                                    e(i38, file2);
                                    int i462 = i29 + 1;
                                    httpURLConnection2 = httpURLConnection3;
                                    i16 = -1;
                                    i(urlString, i38, i462, z16, defaultHost, defaultPort, i3, str);
                                    bufferedOutputStream5 = bufferedOutputStream3;
                                    i27 = i38;
                                    i29 = i462;
                                    httpURLConnection4 = httpURLConnection2;
                                    if (i27 != 0) {
                                    }
                                    info.f259678f = i27;
                                    if (i27 != 0) {
                                    }
                                } catch (Throwable th15) {
                                    th = th15;
                                }
                            } catch (FileNotFoundException unused5) {
                                file2 = file2;
                            }
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                try {
                                    bufferedOutputStream4.write(bArr, 0, read);
                                } catch (FileNotFoundException unused6) {
                                }
                                bufferedOutputStream5 = bufferedOutputStream4;
                                boolean exists22 = file2.exists();
                                File parentFile222 = file2.getParentFile();
                                QLog.i("ProAvatarDownloader", 1, "FileNotFoundException file exist=" + exists22 + ", dir exist=" + (parentFile222 != null ? parentFile222.exists() : false));
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e27) {
                                        e = e27;
                                        httpURLConnection4 = httpURLConnection3;
                                        bufferedOutputStream = bufferedOutputStream5;
                                        i18 = 4;
                                        apnType2 = str;
                                        i17 = defaultPort;
                                        i16 = -1;
                                        url2 = url;
                                        int d162222 = d(url2, file2, e);
                                        c(bufferedOutputStream, httpURLConnection4);
                                        e(d162222, file2);
                                        int i362222 = i29 + 1;
                                        Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                                        i(urlString, d162222, i362222, z16, defaultHost, i17, i3, apnType2);
                                        bufferedOutputStream5 = bufferedOutputStream;
                                        i29 = i362222;
                                        httpURLConnection4 = httpURLConnection4;
                                        i27 = d162222;
                                        if (i27 != 0) {
                                        }
                                        info.f259678f = i27;
                                        if (i27 != 0) {
                                        }
                                    } catch (Throwable th16) {
                                        th = th16;
                                        bufferedOutputStream2 = bufferedOutputStream5;
                                        i19 = 4;
                                        i17 = defaultPort;
                                        i16 = -1;
                                        httpURLConnection = httpURLConnection3;
                                        QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                                        c(bufferedOutputStream2, httpURLConnection);
                                        i27 = 5;
                                        e(5, file2);
                                        int i372222 = i29 + 1;
                                        String apnType32222 = str;
                                        Intrinsics.checkNotNullExpressionValue(apnType32222, "apnType");
                                        httpURLConnection2 = httpURLConnection;
                                        i(urlString, 5, i372222, z16, defaultHost, i17, i3, apnType32222);
                                        i29 = i372222;
                                        bufferedOutputStream5 = bufferedOutputStream2;
                                        httpURLConnection4 = httpURLConnection2;
                                        if (i27 != 0) {
                                        }
                                        info.f259678f = i27;
                                        if (i27 != 0) {
                                        }
                                    }
                                }
                                bufferedOutputStream3 = bufferedOutputStream5;
                                i38 = 4;
                            }
                            bufferedOutputStream4.flush();
                            try {
                                n(file, file2);
                            } catch (FileNotFoundException unused7) {
                            } catch (Throwable th17) {
                                th = th17;
                                bufferedOutputStream5 = bufferedOutputStream4;
                                if (inputStream != null) {
                                }
                                throw th;
                                break;
                                break;
                            }
                            try {
                                inputStream.close();
                                bufferedOutputStream3 = bufferedOutputStream4;
                            } catch (IOException e28) {
                                e = e28;
                                bufferedOutputStream = bufferedOutputStream4;
                                i16 = -1;
                                i18 = 0;
                                apnType2 = str;
                                i17 = defaultPort;
                                httpURLConnection4 = httpURLConnection3;
                                url2 = url;
                                int d1622222 = d(url2, file2, e);
                                c(bufferedOutputStream, httpURLConnection4);
                                e(d1622222, file2);
                                int i3622222 = i29 + 1;
                                Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                                i(urlString, d1622222, i3622222, z16, defaultHost, i17, i3, apnType2);
                                bufferedOutputStream5 = bufferedOutputStream;
                                i29 = i3622222;
                                httpURLConnection4 = httpURLConnection4;
                                i27 = d1622222;
                                if (i27 != 0) {
                                }
                                info.f259678f = i27;
                                if (i27 != 0) {
                                }
                            } catch (Throwable th18) {
                                th = th18;
                                httpURLConnection = httpURLConnection3;
                                i16 = -1;
                                i19 = 0;
                                i17 = defaultPort;
                                bufferedOutputStream2 = bufferedOutputStream4;
                                QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                                c(bufferedOutputStream2, httpURLConnection);
                                i27 = 5;
                                e(5, file2);
                                int i3722222 = i29 + 1;
                                String apnType322222 = str;
                                Intrinsics.checkNotNullExpressionValue(apnType322222, "apnType");
                                httpURLConnection2 = httpURLConnection;
                                i(urlString, 5, i3722222, z16, defaultHost, i17, i3, apnType322222);
                                i29 = i3722222;
                                bufferedOutputStream5 = bufferedOutputStream2;
                                httpURLConnection4 = httpURLConnection2;
                                if (i27 != 0) {
                                }
                                info.f259678f = i27;
                                if (i27 != 0) {
                                }
                            }
                        } catch (Throwable th19) {
                            th = th19;
                            file2 = file2;
                        }
                    } else {
                        file2 = file2;
                        i38 = i39;
                        bufferedOutputStream3 = bufferedOutputStream5;
                    }
                    c(bufferedOutputStream3, httpURLConnection3);
                    e(i38, file2);
                    int i4622 = i29 + 1;
                    httpURLConnection2 = httpURLConnection3;
                    i16 = -1;
                    i(urlString, i38, i4622, z16, defaultHost, defaultPort, i3, str);
                    bufferedOutputStream5 = bufferedOutputStream3;
                    i27 = i38;
                    i29 = i4622;
                } catch (IOException e29) {
                    e = e29;
                    file2 = file2;
                    i16 = -1;
                    url2 = url;
                    bufferedOutputStream = bufferedOutputStream5;
                    httpURLConnection4 = httpURLConnection3;
                    apnType2 = str;
                    i17 = defaultPort;
                    i18 = 0;
                } catch (Throwable th20) {
                    th = th20;
                    file2 = file2;
                    i16 = -1;
                    bufferedOutputStream2 = bufferedOutputStream5;
                    httpURLConnection = httpURLConnection3;
                    i17 = defaultPort;
                    i19 = 0;
                }
                httpURLConnection4 = httpURLConnection2;
                if (i27 != 0 || i29 >= 2) {
                    break;
                }
                url3 = url;
                i28 = i16;
            } catch (Throwable th21) {
                file2 = file2;
                i16 = -1;
                i17 = defaultPort;
                try {
                    p(z16, defaultHost, i17);
                    throw th21;
                    break;
                } catch (IOException e36) {
                    e = e36;
                    url2 = url;
                    bufferedOutputStream = bufferedOutputStream5;
                    httpURLConnection4 = httpURLConnection3;
                    apnType2 = str;
                    i18 = 5;
                    int d16222222 = d(url2, file2, e);
                    c(bufferedOutputStream, httpURLConnection4);
                    e(d16222222, file2);
                    int i36222222 = i29 + 1;
                    Intrinsics.checkNotNullExpressionValue(apnType2, "apnType");
                    i(urlString, d16222222, i36222222, z16, defaultHost, i17, i3, apnType2);
                    bufferedOutputStream5 = bufferedOutputStream;
                    i29 = i36222222;
                    httpURLConnection4 = httpURLConnection4;
                    i27 = d16222222;
                    if (i27 != 0) {
                    }
                    info.f259678f = i27;
                    if (i27 != 0) {
                    }
                } catch (Throwable th22) {
                    th = th22;
                    bufferedOutputStream2 = bufferedOutputStream5;
                    httpURLConnection = httpURLConnection3;
                    i19 = 5;
                    QLog.e("ProAvatarDownloader", 1, "Download fail 2. url=" + url, th);
                    c(bufferedOutputStream2, httpURLConnection);
                    i27 = 5;
                    e(5, file2);
                    int i37222222 = i29 + 1;
                    String apnType3222222 = str;
                    Intrinsics.checkNotNullExpressionValue(apnType3222222, "apnType");
                    httpURLConnection2 = httpURLConnection;
                    i(urlString, 5, i37222222, z16, defaultHost, i17, i3, apnType3222222);
                    i29 = i37222222;
                    bufferedOutputStream5 = bufferedOutputStream2;
                    httpURLConnection4 = httpURLConnection2;
                    if (i27 != 0) {
                    }
                    info.f259678f = i27;
                    if (i27 != 0) {
                    }
                }
            }
        }
    }

    private final void n(File file, File tmpFile) {
        if (file.exists()) {
            file.delete();
        }
        tmpFile.renameTo(file);
        file.setLastModified(System.currentTimeMillis());
    }

    private final void o(String defaultHost, int type, String apnType) {
        boolean z16;
        if (!Intrinsics.areEqual(apnType, f259694c)) {
            if (type != 1 && !Intrinsics.areEqual(apnType, PkgTools.APN_TYPE_CMWAP)) {
                z16 = true;
            } else {
                z16 = false;
            }
            f259695d = z16;
            f259694c = apnType;
        }
        if (type == 1) {
            if (Intrinsics.areEqual("10.0.0.172", defaultHost) || Intrinsics.areEqual("10.0.0.200", defaultHost)) {
                f259695d = true;
            }
        }
    }

    private final void p(boolean useProxy, String defaultHost, int defaultPort) {
        if (useProxy) {
            f259695d = true;
        } else if (defaultHost != null && defaultPort > 0) {
            f259695d = false;
        }
    }

    public final void f(@NotNull final String url, @NotNull final File file, @NotNull final com.tencent.qqnt.avatar.meta.resource.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, url, file, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.proavatar.resource.c
            @Override // java.lang.Runnable
            public final void run() {
                e.g(e.this, url, file, callback);
            }
        }, 128, null, false);
    }

    @NotNull
    public final Object[] q(@Nullable String defaultHost, int defaultPort, @NotNull String apnType, int tryCount, @Nullable String urlString) throws IOException {
        HttpURLConnection httpURLConnection;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Object[]) iPatchRedirector.redirect((short) 3, this, defaultHost, Integer.valueOf(defaultPort), apnType, Integer.valueOf(tryCount), urlString);
        }
        Intrinsics.checkNotNullParameter(apnType, "apnType");
        if (defaultHost != null && defaultPort > 0 && !f259695d) {
            if (!Intrinsics.areEqual(apnType, PkgTools.APN_TYPE_CMWAP) && !Intrinsics.areEqual(apnType, PkgTools.APN_TYPE_UNIWAP) && !Intrinsics.areEqual(apnType, PkgTools.APN_TYPE_3GWAP)) {
                httpURLConnection = PkgTools.getConnectionWithDefaultProxy(urlString, defaultHost, defaultPort);
                Intrinsics.checkNotNullExpressionValue(httpURLConnection, "getConnectionWithDefault\u2026defaultHost, defaultPort)");
                z16 = true;
            } else {
                if (Math.abs(tryCount % 2) == 1 && f259693b == 1) {
                    URLConnection openConnection = new URL(urlString).openConnection();
                    Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    httpURLConnection = (HttpURLConnection) openConnection;
                    z16 = false;
                } else {
                    httpURLConnection = PkgTools.getConnectionWithXOnlineHost(urlString, defaultHost, defaultPort);
                    Intrinsics.checkNotNullExpressionValue(httpURLConnection, "getConnectionWithXOnline\u2026defaultHost, defaultPort)");
                    z16 = true;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("ProAvatarDownloader", 4, "downloadData, wapconn, DPC_WAP_DIRECT_CONNECT=" + f259693b + ", tryCount=" + tryCount);
                }
            }
        } else {
            URLConnection openConnection2 = new URL(urlString).openConnection();
            Intrinsics.checkNotNull(openConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection = (HttpURLConnection) openConnection2;
            z16 = false;
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        if (tryCount > -1) {
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
        } else {
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        if (httpURLConnection instanceof HttpsURLConnection) {
            Companion companion = INSTANCE;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            URL url = new URL(urlString);
            if (tryCount == -1) {
                z17 = true;
            } else {
                z17 = false;
            }
            companion.c(httpsURLConnection, url, z17);
        }
        return new Object[]{Boolean.valueOf(z16), httpURLConnection};
    }
}

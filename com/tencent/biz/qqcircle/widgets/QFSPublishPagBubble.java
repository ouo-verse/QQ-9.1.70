package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;
import org.libpag.PAGText;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002'(BJ\b\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J-\u0010\u000b\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0002R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR1\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble;", "Lcom/tencent/biz/qqcircle/widgets/QCircleRelativePopupWindow;", "", "t", "y", "Lkotlin/Function1;", "Lorg/libpag/PAGFile;", "Lkotlin/ParameterName;", "name", "pagFile", "block", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function0;", "u", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$PagBubbleType;", "e", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$PagBubbleType;", "type", "", "f", "Ljava/lang/String;", "pagText", "bubble", tl.h.F, "Lkotlin/jvm/functions/Function1;", "onSuccess", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "i", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "vasPagView", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$PagBubbleType;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Companion", "PagBubbleType", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSPublishPagBubble extends QCircleRelativePopupWindow {

    @NotNull
    private static final IVasTempApi C;
    private static volatile boolean D;
    private static final RFWDownloader E;

    @NotNull
    private static final ConcurrentHashMap<String, String> F;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PagBubbleType type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String pagText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<QFSPublishPagBubble, Unit> onSuccess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private VasPagImageView vasPagView;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JI\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$Companion;", "", "", "e", "", "g", "", "pagUrl", "d", "f", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$PagBubbleType;", "type", "pagText", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble;", "Lkotlin/ParameterName;", "name", "bubble", "onSuccess", "c", "i", "NEW_USER_PAG_URL_BOTTOM", "Ljava/lang/String;", "NEW_USER_PAG_URL_TOP_RIGHT", "TAG", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "kotlin.jvm.PlatformType", QDLog.TAG_DOWNLOAD, "Lcom/tencent/biz/richframework/download/RFWDownloader;", "isPagSoReady", "Z", "Ljava/util/concurrent/ConcurrentHashMap;", "pagFilePathMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "vasApi", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean d(String pagUrl) {
            boolean z16;
            String str = (String) QFSPublishPagBubble.F.get(pagUrl);
            QLog.d("QFSPublishPagBubble", 1, "checkPagFileReady, pagUrl: " + pagUrl + ", pagFilePath: " + str);
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return true;
            }
            String f16 = f(pagUrl);
            if (new File(f16).exists()) {
                QLog.d("QFSPublishPagBubble", 1, "checkPagFileReady, pagUrl: " + pagUrl + ", savePagFilePath: " + f16);
                QFSPublishPagBubble.F.put(pagUrl, f16);
                return true;
            }
            QFSPublishPagBubble.E.download(pagUrl, new a(pagUrl));
            QLog.d("QFSPublishPagBubble", 1, "checkPagFileReady, pag file not ready, pagUrl: " + pagUrl);
            return false;
        }

        private final boolean e() {
            QLog.d("QFSPublishPagBubble", 1, "checkPagSoReady, isPagSoReady: " + QFSPublishPagBubble.D);
            if (QFSPublishPagBubble.D) {
                return true;
            }
            g();
            QLog.d("QFSPublishPagBubble", 1, "checkPagSoReady, pag so not ready ");
            return QFSPublishPagBubble.D;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(String pagUrl) {
            String defaultSavePath = QFSPublishPagBubble.E.getDefaultSavePath(pagUrl);
            Intrinsics.checkNotNullExpressionValue(defaultSavePath, "downloader.getDefaultSavePath(pagUrl)");
            return defaultSavePath;
        }

        private final void g() {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.bi
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublishPagBubble.Companion.h();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h() {
            if (QFSPublishPagBubble.C.initPagSo()) {
                QLog.d("QFSPublishPagBubble", 1, "initPagSoAsync, initPagSo success ");
                QFSPublishPagBubble.D = true;
            } else {
                QFSPublishPagBubble.C.requestPagDownload(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$Companion$initPagSoAsync$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        boolean initPagSo = QFSPublishPagBubble.C.initPagSo();
                        QLog.d("QFSPublishPagBubble", 1, "initPagSoAsync, download pag so callback, initPagSo: " + initPagSo);
                        QFSPublishPagBubble.D = initPagSo;
                    }
                });
            }
        }

        @NotNull
        public final QFSPublishPagBubble c(@NotNull Context context, @NotNull PagBubbleType type, @Nullable String pagText, @Nullable Function1<? super QFSPublishPagBubble, Unit> onSuccess) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            return new QFSPublishPagBubble(context, type, pagText, onSuccess, null);
        }

        public final void i() {
            e();
            d("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8898/post_tips/qvideo_feed_popup_newcomer.pag");
            d("https://qq-video.cdn-go.cn/android/latest/defaultmode/8955/feed_post_entry_toprightconer/qvideo_feed_popup_newcomer_newtips.pag");
        }

        Companion() {
        }

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$Companion$a", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes5.dex */
        public static final class a implements RFWDownloader.RFWDownloadListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f93372d;

            a(String str) {
                this.f93372d = str;
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
            public void onRspCallback(boolean isSuccess, @NotNull String filePath) {
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                QLog.d("QFSPublishPagBubble", 1, "checkPagFileReady, onRspCallback, isSuccess: " + isSuccess + ", filePath: " + filePath);
                if (isSuccess) {
                    QFSPublishPagBubble.F.put(this.f93372d, filePath);
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$PagBubbleType;", "", "pagUrl", "", "pagWidth", "", "pagHeight", "(Ljava/lang/String;ILjava/lang/String;II)V", "getPagHeight", "()I", "getPagUrl", "()Ljava/lang/String;", "getPagWidth", "TYPE_NEW_USER", "TYPE_NEW_USER_ABOVE", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum PagBubbleType {
        TYPE_NEW_USER("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8898/post_tips/qvideo_feed_popup_newcomer.pag", bj.a(180), bj.a(220)),
        TYPE_NEW_USER_ABOVE("https://qq-video.cdn-go.cn/android/latest/defaultmode/8955/feed_post_entry_toprightconer/qvideo_feed_popup_newcomer_newtips.pag", bj.a(166), bj.a(126));

        private final int pagHeight;

        @NotNull
        private final String pagUrl;
        private final int pagWidth;

        PagBubbleType(String str, int i3, int i16) {
            this.pagUrl = str;
            this.pagWidth = i3;
            this.pagHeight = i16;
        }

        public final int getPagHeight() {
            return this.pagHeight;
        }

        @NotNull
        public final String getPagUrl() {
            return this.pagUrl;
        }

        public final int getPagWidth() {
            return this.pagWidth;
        }
    }

    static {
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        C = (IVasTempApi) api;
        E = RFWDownloaderFactory.getDownloader(vq3.a.a());
        F = new ConcurrentHashMap<>();
    }

    public /* synthetic */ QFSPublishPagBubble(Context context, PagBubbleType pagBubbleType, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, pagBubbleType, str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QFSPublishPagBubble this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSPublishPagBubble", 1, "dismiss ");
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        u(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$callSuccessOnUIThread$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1 function1;
                function1 = QFSPublishPagBubble.this.onSuccess;
                if (function1 != null) {
                    function1.invoke(QFSPublishPagBubble.this);
                }
            }
        });
    }

    private final void t() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.f168743gp3, (ViewGroup) null);
        setBackgroundDrawable(new ColorDrawable(0));
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setContentView(inflate);
        View findViewById = inflate.findViewById(R.id.f116426yp);
        VasPagImageView vasPagImageView = (VasPagImageView) findViewById;
        vasPagImageView.getLayoutParams().width = this.type.getPagWidth();
        vasPagImageView.getLayoutParams().height = this.type.getPagHeight();
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Va\u2026 type.pagHeight\n        }");
        this.vasPagView = vasPagImageView;
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.bg
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublishPagBubble.v(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(final Function1<? super PAGFile, Unit> block) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.bh
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublishPagBubble.x(QFSPublishPagBubble.this, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:3:0x0019, B:5:0x0022, B:10:0x002e, B:11:0x0039), top: B:2:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void x(QFSPublishPagBubble this$0, final Function1 block) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        try {
            final PAGFile Load = PagViewMonitor.Load(INSTANCE.f(this$0.type.getPagUrl()));
            String str = this$0.pagText;
            if (str != null && str.length() != 0) {
                z16 = false;
                if (!z16) {
                    PAGText textData = Load.getTextData(0);
                    textData.text = this$0.pagText;
                    Load.replaceText(0, textData);
                }
                this$0.u(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$getPagFile$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        block.invoke(Load);
                    }
                });
            }
            z16 = true;
            if (!z16) {
            }
            this$0.u(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$getPagFile$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    block.invoke(Load);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QFSPublishPagBubble", 1, "getPagFile, error ", th5);
        }
    }

    private final void y() {
        VasPagImageView vasPagImageView = this.vasPagView;
        VasPagImageView vasPagImageView2 = null;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vasPagView");
            vasPagImageView = null;
        }
        vasPagImageView.api().build();
        VasPagImageView vasPagImageView3 = this.vasPagView;
        if (vasPagImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vasPagView");
        } else {
            vasPagImageView2 = vasPagImageView3;
        }
        vasPagImageView2.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$playPag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final PAGImageView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                final QFSPublishPagBubble qFSPublishPagBubble = QFSPublishPagBubble.this;
                it.addListener(new com.tencent.biz.qqcircle.immersive.views.ae() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$playPag$1.1
                    {
                        super("QFSPublishPagBubble");
                    }

                    @Override // com.tencent.biz.qqcircle.immersive.views.ae, org.libpag.PAGImageView.PAGImageViewListener
                    public void onAnimationEnd(@NotNull PAGImageView pagView) {
                        Intrinsics.checkNotNullParameter(pagView, "pagView");
                        super.onAnimationEnd(pagView);
                        QLog.d("QFSPublishPagBubble", 1, "playPag, onAnimationEnd ");
                        final QFSPublishPagBubble qFSPublishPagBubble2 = QFSPublishPagBubble.this;
                        qFSPublishPagBubble2.u(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$playPag$1$1$onAnimationEnd$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                QFSPublishPagBubble.this.dismiss();
                            }
                        });
                    }
                });
                final QFSPublishPagBubble qFSPublishPagBubble2 = QFSPublishPagBubble.this;
                qFSPublishPagBubble2.w(new Function1<PAGFile, Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$playPag$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PAGFile pAGFile) {
                        invoke2(pAGFile);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable PAGFile pAGFile) {
                        if (pAGFile != null) {
                            PAGImageView.this.setComposition(pAGFile);
                            PAGImageView.this.setRepeatCount(1);
                            PAGImageView.this.setCurrentFrame(0);
                            PAGImageView.this.flush();
                            PAGImageView.this.play();
                            qFSPublishPagBubble2.s();
                        }
                    }
                });
            }
        });
    }

    private final void z() {
        VasPagImageView vasPagImageView = this.vasPagView;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vasPagView");
            vasPagImageView = null;
        }
        vasPagImageView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble$stopPag$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGImageView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying()) {
                    it.pause();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    QFSPublishPagBubble(Context context, PagBubbleType pagBubbleType, String str, Function1<? super QFSPublishPagBubble, Unit> function1) {
        super(context);
        this.context = context;
        this.type = pagBubbleType;
        this.pagText = str;
        this.onSuccess = function1;
        setTouchable(true);
        setOutsideTouchable(false);
        setFocusable(false);
        t();
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.biz.qqcircle.widgets.bf
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                QFSPublishPagBubble.i(QFSPublishPagBubble.this);
            }
        });
    }
}

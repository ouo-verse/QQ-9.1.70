package com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.immersive.views.ae;
import com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ma0.DailyPagData;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGImageView;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00100\u001a\u00020\n\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010\"R\u0014\u0010-\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/BasePlusEntryComposer;", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "vasPagView", "", "pagFileName", "", "t", "Lcom/tencent/biz/qqcircle/immersive/views/ae;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "view", "", NodeProps.VISIBLE, "v", "u", "y", "b", "a", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "f", "Landroid/view/View;", "normalView", "g", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "dailyPagView", h.F, "Lcom/tencent/biz/qqcircle/immersive/views/ae;", "mPagListener", "<set-?>", "i", "Z", "isPlaying", "()Z", "Landroidx/lifecycle/Observer;", "Loa0/a;", "Lma0/b;", "j", "Landroidx/lifecycle/Observer;", "dailyPagObserver", "r", "isEnable", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "k", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class PlusEntryDailyPagComposer extends BasePlusEntryComposer {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    private static final RFWDownloader f91702l = RFWDownloaderFactory.getDownloader(vq3.a.a());

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, String> f91703m = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View normalView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final VasPagImageView dailyPagView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ae mPagListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isPlaying;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<oa0.a<DailyPagData>> dailyPagObserver;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u001c\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer$a;", "", "", "pagUrl", "", "b", "c", "", "e", "f", "d", "PAG_NAME_PLUS", "Ljava/lang/String;", "TAG", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "kotlin.jvm.PlatformType", QDLog.TAG_DOWNLOAD, "Lcom/tencent/biz/richframework/download/RFWDownloader;", "Ljava/util/concurrent/ConcurrentHashMap;", "pagFilePathMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(String pagUrl) {
            boolean z16;
            String str = (String) PlusEntryDailyPagComposer.f91703m.get(pagUrl);
            QLog.d("PlusEntry-PlusEntryDailyPagComposer", 1, "checkPagFileReady, pagUrl: " + pagUrl + ", pagFilePath: " + str);
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return true;
            }
            String c16 = c(pagUrl);
            if (new File(c16).exists()) {
                QLog.d("PlusEntry-PlusEntryDailyPagComposer", 1, "checkPagFileReady, pagUrl: " + pagUrl + ", savePagFilePath: " + c16);
                PlusEntryDailyPagComposer.f91703m.put(pagUrl, c16);
                return true;
            }
            PlusEntryDailyPagComposer.f91702l.download(pagUrl, new C0923a(pagUrl));
            QLog.d("PlusEntry-PlusEntryDailyPagComposer", 1, "checkPagFileReady, pag file not ready, pagUrl: " + pagUrl);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String pagUrl) {
            String defaultSavePath = PlusEntryDailyPagComposer.f91702l.getDefaultSavePath(pagUrl);
            Intrinsics.checkNotNullExpressionValue(defaultSavePath, "downloader.getDefaultSavePath(pagUrl)");
            return defaultSavePath;
        }

        public final boolean d() {
            return b("https://qq-video.cdn-go.cn/android/latest/defaultmode/8955/feed_post_entry_toprightconer/qvideo_icon_feed_post_plus_animation.pag");
        }

        public final void e() {
            b("https://qq-video.cdn-go.cn/android/latest/defaultmode/8955/feed_post_entry_toprightconer/qvideo_icon_feed_post_plus_animation.pag");
        }

        public final void f() {
            Calendar calendar = Calendar.getInstance();
            f.v().V(calendar.get(1) + "-" + calendar.get(2) + "-" + calendar.get(5));
        }

        Companion() {
        }

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer$a$a", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0923a implements RFWDownloader.RFWDownloadListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f91709d;

            C0923a(String str) {
                this.f91709d = str;
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
            public void onRspCallback(boolean isSuccess, @NotNull String filePath) {
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                QLog.d("PlusEntry-PlusEntryDailyPagComposer", 1, "checkPagFileReady, onRspCallback, isSuccess: " + isSuccess + ", filePath: " + filePath);
                if (isSuccess) {
                    PlusEntryDailyPagComposer.f91703m.put(this.f91709d, filePath);
                }
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

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer$b", "Lcom/tencent/biz/qqcircle/immersive/views/ae;", "Lorg/libpag/PAGImageView;", "pagView", "", "c", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends ae {
        b(String str) {
            super(str);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.ae
        public void c(@NotNull PAGImageView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            super.c(pagView);
            PlusEntryDailyPagComposer plusEntryDailyPagComposer = PlusEntryDailyPagComposer.this;
            plusEntryDailyPagComposer.v(plusEntryDailyPagComposer.normalView, false);
            PlusEntryDailyPagComposer.INSTANCE.f();
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.ae, org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationEnd(@NotNull PAGImageView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            super.onAnimationEnd(pagView);
            PlusEntryDailyPagComposer plusEntryDailyPagComposer = PlusEntryDailyPagComposer.this;
            plusEntryDailyPagComposer.v(plusEntryDailyPagComposer.normalView, true);
            PlusEntryDailyPagComposer plusEntryDailyPagComposer2 = PlusEntryDailyPagComposer.this;
            plusEntryDailyPagComposer2.v(plusEntryDailyPagComposer2.dailyPagView, false);
            PlusEntryDailyPagComposer.this.isPlaying = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlusEntryDailyPagComposer(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.normalView = plusEntryLayout.findViewById(R.id.f502624x);
        this.dailyPagView = (VasPagImageView) plusEntryLayout.findViewById(R.id.f502324u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ae q() {
        if (this.mPagListener == null) {
            this.mPagListener = new b(d());
        }
        return this.mPagListener;
    }

    private final boolean r() {
        if (this.normalView != null && this.dailyPagView != null) {
            return true;
        }
        return false;
    }

    private final void t(VasPagImageView vasPagView, String pagFileName) {
        QLog.i(d(), 1, "playPagView ");
        this.isPlaying = true;
        vasPagView.api().build();
        vasPagView.api().postAction(new PlusEntryDailyPagComposer$playPagView$1(this, pagFileName, vasPagView));
    }

    private final void u(View view, boolean visible) {
        int i3;
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
            return;
        }
        QLog.w(d(), 1, "setViewVisible view = null ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(final View view, final boolean visible) {
        if (RFWThreadManager.isMainThread()) {
            u(view, visible);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.a
                @Override // java.lang.Runnable
                public final void run() {
                    PlusEntryDailyPagComposer.w(PlusEntryDailyPagComposer.this, view, visible);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(PlusEntryDailyPagComposer this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(view, z16);
    }

    private final void y(VasPagImageView vasPagView) {
        QLog.d(d(), 1, "stopPagView ");
        this.isPlaying = false;
        vasPagView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer$stopPagView$1
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
            public final void invoke2(@NotNull PAGImageView pagView) {
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                QLog.d(PlusEntryDailyPagComposer.this.d(), 1, "stopPagView, do action ");
                pagView.pause();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void a() {
        super.a();
        Observer<oa0.a<DailyPagData>> observer = this.dailyPagObserver;
        if (observer != null) {
            g().Z1().removeObserver(observer);
        }
        x();
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void b() {
        super.b();
        LiveData<oa0.a<DailyPagData>> Z1 = g().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        oa0.b bVar = new oa0.b(new Function1<DailyPagData, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer$startInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DailyPagData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.d(PlusEntryDailyPagComposer.this.d(), 1, "dailyPagLiveData data changed, it:" + it);
                if (it.getShow()) {
                    PlusEntryDailyPagComposer.this.x();
                    PlusEntryDailyPagComposer.this.s();
                } else {
                    PlusEntryDailyPagComposer.this.s();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DailyPagData dailyPagData) {
                invoke2(dailyPagData);
                return Unit.INSTANCE;
            }
        });
        this.dailyPagObserver = bVar;
        Unit unit = Unit.INSTANCE;
        Z1.observe(lifecycleOwner, bVar);
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-PlusEntryDailyPagComposer";
    }

    public final void s() {
        if (!r()) {
            QLog.d(d(), 1, "play, is not enable ");
            return;
        }
        if (g().getPtkBtnStart()) {
            QLog.d(d(), 1, "play, ptk btn start ");
            return;
        }
        QLog.d(d(), 1, "play ");
        VasPagImageView vasPagImageView = this.dailyPagView;
        if (vasPagImageView != null) {
            t(vasPagImageView, "https://qq-video.cdn-go.cn/android/latest/defaultmode/8955/feed_post_entry_toprightconer/qvideo_icon_feed_post_plus_animation.pag");
        }
    }

    public final void x() {
        if (!r()) {
            QLog.d(d(), 1, "stop, is not enable ");
            return;
        }
        if (g().getPtkBtnStart()) {
            QLog.d(d(), 1, "stop, pkt btn start ");
            return;
        }
        if (!this.isPlaying) {
            QLog.d(d(), 1, "stop, is not playing ");
            return;
        }
        QLog.d(d(), 1, "stop ");
        VasPagImageView vasPagImageView = this.dailyPagView;
        if (vasPagImageView != null) {
            y(vasPagImageView);
        }
    }
}

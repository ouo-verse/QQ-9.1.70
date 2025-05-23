package com.tencent.mobileqq.zootopia.download.multidownloader;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zootopia.download.HalleyDownloader;
import com.tencent.mobileqq.zootopia.download.multidownloader.a;
import com.tencent.multidownloader.MDDownloadConfig;
import com.tencent.multidownloader.MDDownloadLog;
import com.tencent.multidownloader.MDDownloadResInfo;
import com.tencent.multidownloader.MultiDownloaderBridge;
import com.tencent.multidownloader.MultiDownloaderGlobalConfig;
import com.tencent.multidownloader.MultiDownloaderSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.reporter.api.IDownloaderReporter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\t\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0004JF\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/multidownloader/ZPlanMultiDownloader;", "", "Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "listener", "", "o", "Lkotlin/Function0;", "mainLoop", "subLoop", "k", "", "rspHeaderString", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isError", "logMsg", ReportConstant.COSTREPORT_PREFIX, "", "speedLimit", "u", DomainData.DOMAIN_NAME, "url", "filePath", WadlProxyConsts.PARAM_FILENAME, "header", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "", "threadSwitchCostTime", "v", "t", "r", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSdkInited", "c", "isSdkLoading", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "initListener", "Lcom/tencent/multidownloader/MultiDownloaderBridge;", "e", "Lcom/tencent/multidownloader/MultiDownloaderBridge;", "multiDownloaderBridge", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanMultiDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanMultiDownloader f328105a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSdkInited;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSdkLoading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<com.tencent.mobileqq.zootopia.download.multidownloader.a> initListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static MultiDownloaderBridge multiDownloaderBridge;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/download/multidownloader/ZPlanMultiDownloader$a", "Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.download.multidownloader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f328110a;

        a(long j3) {
            this.f328110a = j3;
        }

        private final void b(boolean isSuccess, int errorCode, String errorMessage) {
            Iterator it = ZPlanMultiDownloader.initListener.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.zootopia.download.multidownloader.a) it.next()).a(isSuccess, errorCode, errorMessage);
            }
            ZPlanMultiDownloader.initListener.clear();
            ZPlanMultiDownloader.isSdkInited.set(isSuccess);
        }

        @Override // com.tencent.mobileqq.zootopia.download.multidownloader.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            String path;
            QLog.i("ZPlanMultiDownloader", 1, "init loadDownloaderSo - " + isSuccess + ", costTime= " + (System.currentTimeMillis() - this.f328110a) + ", errorCode= " + errorCode + ", errorMessage= " + errorMessage);
            ZPlanMultiDownloader.isSdkLoading.set(false);
            if (!isSuccess) {
                if (errorMessage == null) {
                    errorMessage = "so load failed";
                }
                b(false, errorCode, errorMessage);
                HalleyDownloader.f327980a.m(false, "new sdk so load fail");
                return;
            }
            BaseApplication baseApplication = BaseApplication.context;
            File externalFilesDir = baseApplication.getExternalFilesDir(null);
            if (externalFilesDir == null || (path = externalFilesDir.getPath()) == null) {
                path = baseApplication.getFilesDir().getPath();
            }
            String str = File.separator;
            String str2 = path + str + "ZPlanMultiDownloader" + str;
            QLog.i("ZPlanMultiDownloader", 1, "init downloadSdkDbPath= " + str2);
            try {
                FileUtils.createDirectory(str2);
            } catch (Exception e16) {
                QLog.e("ZPlanMultiDownloader", 1, "init createDirectory exception", e16);
            }
            try {
                MDDownloadLog.setProxyLogger(new com.tencent.mobileqq.zootopia.download.multidownloader.d());
                MultiDownloaderSo.setSoPreloaded(true);
                MultiDownloaderGlobalConfig.config_db_path(str2);
                ZPlanMultiDownloader zPlanMultiDownloader = ZPlanMultiDownloader.f328105a;
                ZPlanMultiDownloader.multiDownloaderBridge = new MultiDownloaderBridge();
                QLog.i("ZPlanMultiDownloader", 1, "initSdk FINISH");
                b(true, 0, "");
            } catch (Error e17) {
                QLog.e("ZPlanMultiDownloader", 1, "init sdk error", e17);
                b(false, -99901, "sdk init error " + e17.getLocalizedMessage());
            } catch (Exception e18) {
                QLog.e("ZPlanMultiDownloader", 1, "init sdk exception", e18);
                b(false, -99901, "sdk init exception");
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/download/multidownloader/ZPlanMultiDownloader$b", "Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.download.multidownloader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f328111a;

        b(String str) {
            this.f328111a = str;
        }

        @Override // com.tencent.mobileqq.zootopia.download.multidownloader.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            QLog.i("ZPlanMultiDownloader", 1, "deleteDownload- " + this.f328111a + " , sdkReady= " + isSuccess);
            if (isSuccess) {
                MultiDownloaderBridge multiDownloaderBridge = ZPlanMultiDownloader.multiDownloaderBridge;
                if (multiDownloaderBridge != null) {
                    multiDownloaderBridge.deleteDownloadTask(this.f328111a);
                }
                QLog.i("ZPlanMultiDownloader", 1, "deleteDownload call sdk FINISH - " + this.f328111a);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/download/multidownloader/ZPlanMultiDownloader$c", "Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.download.multidownloader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f328112a;

        c(String str) {
            this.f328112a = str;
        }

        @Override // com.tencent.mobileqq.zootopia.download.multidownloader.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            MultiDownloaderBridge multiDownloaderBridge;
            QLog.i("ZPlanMultiDownloader", 1, "pauseDownload- " + this.f328112a + " , sdkReady= " + isSuccess);
            if (!isSuccess || (multiDownloaderBridge = ZPlanMultiDownloader.multiDownloaderBridge) == null) {
                return;
            }
            multiDownloaderBridge.stopDownloadTask(this.f328112a);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/download/multidownloader/ZPlanMultiDownloader$d", "Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.download.multidownloader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f328113a;

        d(int i3) {
            this.f328113a = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.download.multidownloader.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            QLog.i("ZPlanMultiDownloader", 1, "setDownloadSpeedLimit- " + this.f328113a + ", sdkReady= " + isSuccess);
            if (isSuccess) {
                MultiDownloaderGlobalConfig.update_speed_limit(this.f328113a);
            }
        }
    }

    static {
        ZPlanMultiDownloader zPlanMultiDownloader = new ZPlanMultiDownloader();
        f328105a = zPlanMultiDownloader;
        isSdkInited = new AtomicBoolean(false);
        isSdkLoading = new AtomicBoolean(false);
        initListener = new CopyOnWriteArrayList<>();
        p(zPlanMultiDownloader, null, 1, null);
    }

    ZPlanMultiDownloader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(final Function0<Unit> mainLoop, final Function0<Unit> subLoop) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            if (mainLoop != null) {
                mainLoop.invoke();
            }
            if (subLoop != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanMultiDownloader.l(Function0.this);
                    }
                }, 16, null, false);
                return;
            }
            return;
        }
        if (subLoop != null) {
            subLoop.invoke();
        }
        if (mainLoop != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanMultiDownloader.m(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 function0) {
        function0.invoke();
    }

    private final void o(com.tencent.mobileqq.zootopia.download.multidownloader.a listener) {
        if (isSdkInited.get()) {
            if (listener != null) {
                a.C9108a.a(listener, true, 0, null, 6, null);
                return;
            }
            return;
        }
        if (listener != null) {
            initListener.add(listener);
        }
        if (isSdkLoading.get()) {
            return;
        }
        isSdkLoading.set(true);
        f.f328127a.b(new a(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, List<String>> q(String rspHeaderString) {
        String replace$default;
        List split$default;
        if (TextUtils.isEmpty(rspHeaderString)) {
            return new LinkedHashMap();
        }
        Headers.Builder builder = new Headers.Builder();
        replace$default = StringsKt__StringsJVMKt.replace$default(rspHeaderString, "\r\n", "\n", false, 4, (Object) null);
        split$default = StringsKt__StringsKt.split$default((CharSequence) replace$default, new String[]{"\n"}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            try {
                builder.add((String) it.next());
            } catch (Exception unused) {
            }
        }
        return builder.build().toMultimap();
    }

    public final void r(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        o(new b(url));
    }

    public final void t(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        o(new c(url));
    }

    public final void u(int speedLimit) {
        o(new d(speedLimit));
    }

    public final void v(final String url, final String filePath, final String fileName, final Map<String, String> header, final DownloaderTaskListener listener, final long threadSwitchCostTime) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        o(new com.tencent.mobileqq.zootopia.download.multidownloader.a() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1
            @Override // com.tencent.mobileqq.zootopia.download.multidownloader.a
            public void a(boolean isSuccess, int errorCode, String errorMessage) {
                boolean endsWith$default;
                String str = filePath;
                String separator = File.separator;
                Intrinsics.checkNotNullExpressionValue(separator, "separator");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, separator, false, 2, null);
                if (endsWith$default) {
                    separator = "";
                }
                String str2 = filePath + separator + fileName;
                QLog.i("ZPlanMultiDownloader", 1, "startDownload new task: " + url + ", header= " + header + ", fullSavePath= " + str2 + ", threadSwitchCostTime= " + threadSwitchCostTime);
                String str3 = url;
                String str4 = filePath;
                String str5 = fileName;
                Map map = header;
                if (map == null) {
                    map = new LinkedHashMap();
                }
                final cc3.a aVar = new cc3.a(str3, str4, str5, str2, map);
                if (!isSuccess) {
                    QLog.e("ZPlanMultiDownloader", 1, "startDownload but sdk not ready --  " + url);
                    aVar.d(errorCode, errorMessage != null ? errorMessage : "", null);
                    ZPlanMultiDownloader zPlanMultiDownloader = ZPlanMultiDownloader.f328105a;
                    final DownloaderTaskListener downloaderTaskListener = listener;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            DownloaderTaskListener.this.onTaskFailedMainloop(aVar);
                        }
                    };
                    final DownloaderTaskListener downloaderTaskListener2 = listener;
                    zPlanMultiDownloader.k(function0, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            DownloaderTaskListener.this.onTaskFailedMainloop(aVar);
                        }
                    });
                    return;
                }
                try {
                    FileUtils.createDirectory(filePath);
                } catch (Exception e16) {
                    QLog.e("ZPlanMultiDownloader", 1, "startDownload createDirectory exception", e16);
                }
                QLog.d("PERF_LOG", 2, "NF.HalleyDownloader-zplanMultiDownloader downloadUrl=" + url);
                MDDownloadConfig mDDownloadConfig = new MDDownloadConfig();
                Map<String, String> map2 = header;
                mDDownloadConfig.referer = "https://h5.cmshow.qq.com/";
                ArrayList<String> arrayList = new ArrayList<>();
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        arrayList.add(((Object) entry.getKey()) + ":" + ((Object) entry.getValue()));
                    }
                }
                mDDownloadConfig.custom_headers = arrayList;
                mDDownloadConfig.full_save_path = str2;
                MultiDownloaderBridge multiDownloaderBridge2 = ZPlanMultiDownloader.multiDownloaderBridge;
                if (multiDownloaderBridge2 != null) {
                    final String str6 = url;
                    final DownloaderTaskListener downloaderTaskListener3 = listener;
                    multiDownloaderBridge2.startDownloadTask(new MultiDownloaderBridge.MultiDownloaderListener() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3
                        @Override // com.tencent.multidownloader.MultiDownloaderBridge.MultiDownloaderListener
                        public void onTaskComplete(int res, String filePath2, MDDownloadResInfo resInfo) {
                            String str7;
                            String str8;
                            Map<String, ? extends List<String>> q16;
                            ZPlanMultiDownloader zPlanMultiDownloader2 = ZPlanMultiDownloader.f328105a;
                            zPlanMultiDownloader2.s(res != 0, " onTaskComplete, res= " + res + ", resInfoCode= " + (resInfo != null ? Long.valueOf(resInfo.err_code) : null) + ", url= " + str6 + ", time= " + (resInfo != null ? Long.valueOf(resInfo.consume_time) : null) + ", averageSpeed= " + (resInfo != null ? Long.valueOf(resInfo.average_speed) : null) + ", downloadedThisTime= " + (resInfo != null ? Long.valueOf(resInfo.total_bytes) : null) + ", totalFileSize= " + (resInfo != null ? Long.valueOf(resInfo.file_size) : null) + ", filePath= " + filePath2);
                            if (resInfo != null) {
                                ((IDownloaderReporter) QRoute.api(IDownloaderReporter.class)).downloaderReport("HalleyDownloader-zplan", str6, resInfo.file_size);
                            }
                            if (res == 0) {
                                if (resInfo != null && (str8 = resInfo.http_header) != null) {
                                    cc3.a aVar2 = aVar;
                                    if (!TextUtils.isEmpty(str8)) {
                                        q16 = zPlanMultiDownloader2.q(str8);
                                        aVar2.j(q16);
                                    }
                                }
                                aVar.e(resInfo);
                                final DownloaderTaskListener downloaderTaskListener4 = downloaderTaskListener3;
                                final cc3.a aVar3 = aVar;
                                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskComplete$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        DownloaderTaskListener.this.onTaskCompletedMainloop(aVar3);
                                    }
                                };
                                final DownloaderTaskListener downloaderTaskListener5 = downloaderTaskListener3;
                                final cc3.a aVar4 = aVar;
                                zPlanMultiDownloader2.k(function02, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskComplete$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        DownloaderTaskListener.this.onTaskCompletedSubloop(aVar4);
                                    }
                                });
                                return;
                            }
                            int i3 = (res != 2 || resInfo == null) ? res : (int) resInfo.err_code;
                            if (res == 2) {
                                str7 = "http download fail";
                            } else {
                                str7 = "";
                            }
                            aVar.d(i3, str7, resInfo);
                            final DownloaderTaskListener downloaderTaskListener6 = downloaderTaskListener3;
                            final cc3.a aVar5 = aVar;
                            Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskComplete$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskFailedMainloop(aVar5);
                                }
                            };
                            final DownloaderTaskListener downloaderTaskListener7 = downloaderTaskListener3;
                            final cc3.a aVar6 = aVar;
                            zPlanMultiDownloader2.k(function03, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskComplete$5
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskFailedSubloop(aVar6);
                                }
                            });
                        }

                        @Override // com.tencent.multidownloader.MultiDownloaderBridge.MultiDownloaderListener
                        public void onTaskDeleted() {
                            QLog.i("ZPlanMultiDownloader", 1, " onTaskDeleted- " + str6);
                            aVar.b();
                            DownloaderTaskListener downloaderTaskListener4 = downloaderTaskListener3;
                            final com.tencent.mobileqq.zootopia.download.b bVar = downloaderTaskListener4 instanceof com.tencent.mobileqq.zootopia.download.b ? (com.tencent.mobileqq.zootopia.download.b) downloaderTaskListener4 : null;
                            if (bVar != null) {
                                final cc3.a aVar2 = aVar;
                                ZPlanMultiDownloader.f328105a.k(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskDeleted$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        com.tencent.mobileqq.zootopia.download.b.this.a(aVar2);
                                    }
                                }, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskDeleted$1$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        com.tencent.mobileqq.zootopia.download.b.this.b(aVar2);
                                    }
                                });
                            }
                        }

                        @Override // com.tencent.multidownloader.MultiDownloaderBridge.MultiDownloaderListener
                        public void onTaskPaused() {
                            QLog.i("ZPlanMultiDownloader", 1, " onTaskPaused- " + str6);
                            aVar.f();
                            ZPlanMultiDownloader zPlanMultiDownloader2 = ZPlanMultiDownloader.f328105a;
                            final DownloaderTaskListener downloaderTaskListener4 = downloaderTaskListener3;
                            final cc3.a aVar2 = aVar;
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskPaused$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskPausedMainloop(aVar2);
                                }
                            };
                            final DownloaderTaskListener downloaderTaskListener5 = downloaderTaskListener3;
                            final cc3.a aVar3 = aVar;
                            zPlanMultiDownloader2.k(function02, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskPaused$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskPausedSubloop(aVar3);
                                }
                            });
                        }

                        @Override // com.tencent.multidownloader.MultiDownloaderBridge.MultiDownloaderListener
                        public void onTaskPending() {
                            QLog.i("ZPlanMultiDownloader", 1, " onTaskPending- " + str6);
                            aVar.g();
                            ZPlanMultiDownloader zPlanMultiDownloader2 = ZPlanMultiDownloader.f328105a;
                            final DownloaderTaskListener downloaderTaskListener4 = downloaderTaskListener3;
                            final cc3.a aVar2 = aVar;
                            zPlanMultiDownloader2.k(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskPending$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskPendingMainloop(aVar2);
                                }
                            }, null);
                        }

                        @Override // com.tencent.multidownloader.MultiDownloaderBridge.MultiDownloaderListener
                        public void onTaskStarted(long totalBytes, String httpHeader) {
                            Map<String, ? extends List<String>> q16;
                            String str7;
                            Object firstOrNull;
                            ZPlanMultiDownloader zPlanMultiDownloader2 = ZPlanMultiDownloader.f328105a;
                            if (httpHeader == null) {
                                httpHeader = "";
                            }
                            q16 = zPlanMultiDownloader2.q(httpHeader);
                            String str8 = str6;
                            int size = q16.size();
                            List list = (List) q16.get("x-cos-hash-crc64ecma");
                            if (list != null) {
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                str7 = (String) firstOrNull;
                            } else {
                                str7 = null;
                            }
                            QLog.i("ZPlanMultiDownloader", 1, " onTaskStarted- " + str8 + ", totalBytes= " + totalBytes + ", headerMap.size= " + size + ", crc64ecma= " + str7);
                            aVar.i();
                            aVar.j(q16);
                            aVar.c(totalBytes);
                            final DownloaderTaskListener downloaderTaskListener4 = downloaderTaskListener3;
                            final cc3.a aVar2 = aVar;
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskStarted$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskStartedMainloop(aVar2);
                                    DownloaderTaskListener.this.onTaskDetectedMainloop(aVar2);
                                }
                            };
                            final DownloaderTaskListener downloaderTaskListener5 = downloaderTaskListener3;
                            final cc3.a aVar3 = aVar;
                            zPlanMultiDownloader2.k(function02, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskStarted$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskStartedSubloop(aVar3);
                                    DownloaderTaskListener.this.onTaskDetectedSubloop(aVar3);
                                }
                            });
                        }

                        @Override // com.tencent.multidownloader.MultiDownloaderBridge.MultiDownloaderListener
                        public void onTaskProgressCallback(long bytes, long totalBytes, long realTimeSpeed, long averageSpeed) {
                            aVar.h(bytes, totalBytes, realTimeSpeed, averageSpeed);
                            ZPlanMultiDownloader zPlanMultiDownloader2 = ZPlanMultiDownloader.f328105a;
                            final DownloaderTaskListener downloaderTaskListener4 = downloaderTaskListener3;
                            final cc3.a aVar2 = aVar;
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskProgressCallback$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskReceivedMainloop(aVar2);
                                }
                            };
                            final DownloaderTaskListener downloaderTaskListener5 = downloaderTaskListener3;
                            final cc3.a aVar3 = aVar;
                            zPlanMultiDownloader2.k(function02, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader$startDownload$1$onComplete$3$onTaskProgressCallback$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DownloaderTaskListener.this.onTaskReceivedSubloop(aVar3);
                                }
                            });
                        }
                    }, url, mDDownloadConfig);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(boolean isError, String logMsg) {
        if (isError) {
            QLog.e("ZPlanMultiDownloader", 1, logMsg);
        } else {
            QLog.i("ZPlanMultiDownloader", 1, logMsg);
        }
    }

    public final void n() {
        QLog.i("ZPlanMultiDownloader", 1, "cancelDownloadSpeedLimit");
        if (multiDownloaderBridge != null) {
            MultiDownloaderGlobalConfig.cancel_speed_limit();
        }
    }

    static /* synthetic */ void p(ZPlanMultiDownloader zPlanMultiDownloader, com.tencent.mobileqq.zootopia.download.multidownloader.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        zPlanMultiDownloader.o(aVar);
    }
}

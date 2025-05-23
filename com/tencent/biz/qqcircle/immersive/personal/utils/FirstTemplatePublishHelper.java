package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqcircle.utils.y;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\b*\u00014\u0018\u0000 :2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0003J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper;", "", "", "y", "", "templateId", "o", "url", DomainData.DOMAIN_NAME, "p", "", "isSuccess", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", ReportConstant.COSTREPORT_PREFIX, "r", "Lkotlin/Function0;", "action", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/qqcircle/immersive/personal/utils/c;", "downloadListener", "v", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/biz/qqcircle/immersive/personal/utils/e;", "a", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/e;", "downloadTask", "", "b", "I", "currentCheckCount", "c", "downloadState", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/d;", "d", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/d;", "downloadResult", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "successCount", "f", "errorCount", "g", "Ljava/lang/String;", tl.h.F, "Z", "isTaskActive", "i", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/c;", "com/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper$checkTask$1", "j", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper$checkTask$1;", "checkTask", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/utils/e;)V", "k", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class FirstTemplatePublishHelper {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    private static final String f89021l = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getDownloadBasePath();

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final IAEResUtil f89022m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final IWinkEditorResourceAPI f89023n;

    /* renamed from: o, reason: collision with root package name */
    private static final Handler f89024o;

    /* renamed from: p, reason: collision with root package name */
    private static final Handler f89025p;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DownloadTask downloadTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentCheckCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int downloadState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DownloadResult downloadResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger successCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger errorCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String templateId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isTaskActive;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.utils.c downloadListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FirstTemplatePublishHelper$checkTask$1 checkTask;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper$a;", "", "", "a", "", "CHECK_INTERVAL", "J", "", "DIR_NAME", "Ljava/lang/String;", "", "MAX_CHECK_COUNT", "I", "kotlin.jvm.PlatformType", "PATH_RESOURCES", "STATE_DOWNLOADING", "STATE_DOWNLOAD_FAILED", "STATE_DOWNLOAD_SUCCEED", "STATE_INITIAL", "TAG", "Lcom/tencent/aelight/camera/download/api/IAEResUtil;", "aEResUtil", "Lcom/tencent/aelight/camera/download/api/IAEResUtil;", "Landroid/os/Handler;", "threadHandler", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/mobileqq/wink/api/IWinkEditorResourceAPI;", "winkEditorResourceAPI", "Lcom/tencent/mobileqq/wink/api/IWinkEditorResourceAPI;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.utils.FirstTemplatePublishHelper$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            try {
                FirstTemplatePublishHelper.f89022m.preDownloadAllNonEssentialBundles();
                FirstTemplatePublishHelper.f89023n.fetchEditorResource();
                FirstTemplatePublishHelper.f89023n.fetchTemplateLibraryResource();
            } catch (Error e16) {
                QLog.w("FirstTemplatePublishHelper", 1, "preloadNecessaryResources, error ", e16);
            }
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper$b", "Li83/d;", "", "isSuccess", "", "filePath", "", "onResult", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements i83.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f89036a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FirstTemplatePublishHelper f89037b;

        b(String str, FirstTemplatePublishHelper firstTemplatePublishHelper) {
            this.f89036a = str;
            this.f89037b = firstTemplatePublishHelper;
        }

        @Override // i83.d
        public void onResult(boolean isSuccess, @NotNull String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            QLog.d("FirstTemplatePublishHelper", 1, "downloadImg, getFilePath, url:" + this.f89036a + ", filePath:" + filePath);
            this.f89037b.downloadResult.e(filePath);
            this.f89037b.m(TextUtils.isEmpty(filePath) ^ true);
        }
    }

    static {
        QRouteApi api = QRoute.api(IAEResUtil.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAEResUtil::class.java)");
        f89022m = (IAEResUtil) api;
        QRouteApi api2 = QRoute.api(IWinkEditorResourceAPI.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IWinkEditorResourceAPI::class.java)");
        f89023n = (IWinkEditorResourceAPI) api2;
        f89024o = RFWThreadManager.createNewThreadHandler("FirstTemplatePublishHelper", 0);
        f89025p = RFWThreadManager.getUIHandler();
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [com.tencent.biz.qqcircle.immersive.personal.utils.FirstTemplatePublishHelper$checkTask$1] */
    public FirstTemplatePublishHelper(@NotNull DownloadTask downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "downloadTask");
        this.downloadTask = downloadTask;
        this.downloadResult = new DownloadResult(false, null, null, 7, null);
        this.successCount = new AtomicInteger(0);
        this.errorCount = new AtomicInteger(0);
        this.templateId = "";
        this.checkTask = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.FirstTemplatePublishHelper$checkTask$1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                boolean z16;
                boolean z17;
                boolean q16;
                int i16;
                int i17;
                Handler handler;
                i3 = FirstTemplatePublishHelper.this.currentCheckCount;
                z16 = FirstTemplatePublishHelper.this.isTaskActive;
                QLog.d("FirstTemplatePublishHelper", 1, "checkTask, run: " + i3 + ", isTaskActive: " + z16);
                z17 = FirstTemplatePublishHelper.this.isTaskActive;
                if (z17) {
                    q16 = FirstTemplatePublishHelper.this.q();
                    if (q16) {
                        FirstTemplatePublishHelper.this.r(true);
                        return;
                    }
                    FirstTemplatePublishHelper firstTemplatePublishHelper = FirstTemplatePublishHelper.this;
                    i16 = firstTemplatePublishHelper.currentCheckCount;
                    firstTemplatePublishHelper.currentCheckCount = i16 + 1;
                    i17 = firstTemplatePublishHelper.currentCheckCount;
                    if (i17 < 5) {
                        handler = FirstTemplatePublishHelper.f89024o;
                        handler.postDelayed(this, 1000L);
                    } else {
                        FirstTemplatePublishHelper.this.r(false);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean isSuccess) {
        boolean z16;
        if (isSuccess) {
            this.successCount.incrementAndGet();
        } else {
            this.errorCount.incrementAndGet();
        }
        int i3 = 2;
        if (this.successCount.get() + this.errorCount.get() == 2) {
            if (this.errorCount.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("FirstTemplatePublishHelper", 1, "checkAllTaskComplete, isAllSuccess:" + z16);
            if (!z16) {
                i3 = 3;
            }
            this.downloadState = i3;
            this.downloadResult.d(z16);
            s();
            if (z16) {
                w();
            }
        }
    }

    private final void n(String url) {
        QLog.d("FirstTemplatePublishHelper", 1, "downloadImg, url:" + url);
        WeakReference<i83.d> weakReference = new WeakReference<>(new b(url, this));
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).downloadPagOrImage(url, f89021l + "qqlogo", p(url), weakReference, true);
    }

    private final void o(String templateId) {
        QLog.d("FirstTemplatePublishHelper", 1, "downloadTemplate, templateId: " + templateId);
        this.templateId = templateId;
        f89023n.preDownloadMaterialResource(templateId, new c(templateId, this));
    }

    private final String p(String url) {
        String c16 = y.c(url, "k");
        Intrinsics.checkNotNullExpressionValue(c16, "getSchemaParameter(url, \"k\")");
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final boolean q() {
        IWinkEditorResourceAPI iWinkEditorResourceAPI = f89023n;
        boolean isTemplateLibraryConfigReady = iWinkEditorResourceAPI.isTemplateLibraryConfigReady();
        boolean isTemplateMaterialReady = iWinkEditorResourceAPI.isTemplateMaterialReady(this.templateId);
        QLog.d("FirstTemplatePublishHelper", 1, "isTemplateReady, templateId:" + this.templateId + ", configReady:" + isTemplateLibraryConfigReady + ", materialReady:" + isTemplateMaterialReady);
        if (isTemplateLibraryConfigReady && isTemplateMaterialReady) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final boolean isSuccess) {
        QLog.d("FirstTemplatePublishHelper", 1, "notifyCheckResult, isTaskActive:" + this.isTaskActive + ", isSuccess:" + isSuccess);
        if (!this.isTaskActive) {
            return;
        }
        t(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.FirstTemplatePublishHelper$notifyCheckResult$1
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
                c cVar;
                cVar = FirstTemplatePublishHelper.this.downloadListener;
                if (cVar != null) {
                    cVar.b(isSuccess, FirstTemplatePublishHelper.this.downloadResult);
                }
            }
        });
    }

    private final void s() {
        QLog.d("FirstTemplatePublishHelper", 1, "notifyDownloadResult, isTaskActive:" + this.isTaskActive);
        if (!this.isTaskActive) {
            return;
        }
        t(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.FirstTemplatePublishHelper$notifyDownloadResult$1
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
                c cVar;
                cVar = FirstTemplatePublishHelper.this.downloadListener;
                if (cVar != null) {
                    cVar.a(FirstTemplatePublishHelper.this.downloadResult);
                }
            }
        });
    }

    private final void t(final Function0<Unit> action) {
        f89025p.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                FirstTemplatePublishHelper.u(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function0 action) {
        Intrinsics.checkNotNullParameter(action, "$action");
        action.invoke();
    }

    private final void w() {
        QLog.d("FirstTemplatePublishHelper", 1, "startCheck, isTaskActive:" + this.isTaskActive);
        if (!this.isTaskActive) {
            return;
        }
        this.currentCheckCount = 0;
        Handler handler = f89024o;
        handler.removeCallbacks(this.checkTask);
        handler.post(this.checkTask);
    }

    private final void y() {
        QLog.d("FirstTemplatePublishHelper", 1, "startDownloadInternal ");
        this.downloadState = 1;
        this.downloadResult = new DownloadResult(false, null, null, 7, null);
        this.successCount = new AtomicInteger(0);
        this.errorCount = new AtomicInteger(0);
        o(this.downloadTask.getTemplateId());
        n(this.downloadTask.getQqLogoUrl());
    }

    public final void v(@NotNull com.tencent.biz.qqcircle.immersive.personal.utils.c downloadListener) {
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        this.downloadListener = downloadListener;
    }

    public final void x() {
        QLog.d("FirstTemplatePublishHelper", 1, "startDownload, downloadState: " + this.downloadState + ", downloadTask: " + this.downloadTask);
        this.isTaskActive = true;
        int i3 = this.downloadState;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
            } else {
                w();
                return;
            }
        }
        y();
    }

    public final void z() {
        QLog.d("FirstTemplatePublishHelper", 1, "stopDownload ");
        this.isTaskActive = false;
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper$c", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f89038a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FirstTemplatePublishHelper f89039b;

        c(String str, FirstTemplatePublishHelper firstTemplatePublishHelper) {
            this.f89038a = str;
            this.f89039b = firstTemplatePublishHelper;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x006c, code lost:
        
            if (r6 != false) goto L15;
         */
        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDownloadFinish(boolean isSuccess) {
            String str;
            boolean z16;
            boolean z17 = true;
            QLog.d("FirstTemplatePublishHelper", 1, "downloadTemplate, onDownloadFinish, templateId:" + this.f89038a + ", isSuccess:" + isSuccess);
            MetaMaterial templateLibraryMaterial = FirstTemplatePublishHelper.f89023n.getTemplateLibraryMaterial(this.f89038a);
            if (templateLibraryMaterial != null) {
                str = FirstTemplatePublishHelper.f89023n.getDownloadFolder(templateLibraryMaterial);
                Intrinsics.checkNotNullExpressionValue(str, "winkEditorResourceAPI.getDownloadFolder(material)");
            } else {
                str = "";
            }
            QLog.d("FirstTemplatePublishHelper", 1, "downloadTemplate, onDownloadFinish, materialResPath:" + str);
            this.f89039b.downloadResult.f(str);
            if (isSuccess) {
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            z17 = false;
            this.f89039b.m(z17);
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}

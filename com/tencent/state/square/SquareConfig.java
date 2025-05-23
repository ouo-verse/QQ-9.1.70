package com.tencent.state.square;

import android.app.Application;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.rapier.k;
import com.tencent.state.square.api.DefaultSquareAvatarUtils;
import com.tencent.state.square.api.ISquareAvatarUtils;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.ISquareMiniAioServiceProvider;
import com.tencent.state.square.api.ISquareServiceFactory;
import com.tencent.state.square.mmkv.SMMKV;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b@\b\u0086\b\u0018\u00002\u00020\u0001B\u00d9\u0001\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0007\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\b\b\u0002\u00100\u001a\u00020\r\u0012\b\b\u0002\u00101\u001a\u00020\u000f\u0012\b\b\u0002\u00102\u001a\u00020\u0011\u0012\b\b\u0002\u00103\u001a\u00020\u0013\u0012\b\b\u0002\u00104\u001a\u00020\u0015\u0012\b\b\u0002\u00105\u001a\u00020\u0017\u0012\b\b\u0002\u00106\u001a\u00020\u0019\u0012\b\b\u0002\u00107\u001a\u00020\u001b\u0012\b\b\u0002\u00108\u001a\u00020\u001d\u0012\b\b\u0002\u00109\u001a\u00020\u001f\u0012\b\b\u0002\u0010:\u001a\u00020!\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010<\u001a\u00020$\u0012\b\b\u0002\u0010=\u001a\u00020&\u0012\b\b\u0002\u0010>\u001a\u00020(\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\rH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0013H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0015H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0017H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0019H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u001bH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u001dH\u00c6\u0003J\t\u0010 \u001a\u00020\u001fH\u00c6\u0003J\t\u0010\"\u001a\u00020!H\u00c6\u0003J\t\u0010#\u001a\u00020\u0002H\u00c6\u0003J\t\u0010%\u001a\u00020$H\u00c6\u0003J\t\u0010'\u001a\u00020&H\u00c6\u0003J\t\u0010)\u001a\u00020(H\u00c6\u0003J\u00db\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u00112\b\b\u0002\u00103\u001a\u00020\u00132\b\b\u0002\u00104\u001a\u00020\u00152\b\b\u0002\u00105\u001a\u00020\u00172\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u001b2\b\b\u0002\u00108\u001a\u00020\u001d2\b\b\u0002\u00109\u001a\u00020\u001f2\b\b\u0002\u0010:\u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020\u00022\b\b\u0002\u0010<\u001a\u00020$2\b\b\u0002\u0010=\u001a\u00020&2\b\b\u0002\u0010>\u001a\u00020(H\u00c6\u0001J\t\u0010A\u001a\u00020@H\u00d6\u0001J\t\u0010C\u001a\u00020BH\u00d6\u0001J\u0013\u0010E\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010F\u001a\u0004\b*\u0010GR\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b+\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010F\u001a\u0004\bK\u0010GR\u0017\u0010-\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b-\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010.\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b.\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010/\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b/\u0010R\u001a\u0004\bS\u0010TR\u0017\u00100\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b0\u0010U\u001a\u0004\bV\u0010WR\u0017\u00101\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b1\u0010X\u001a\u0004\bY\u0010ZR\u0017\u00102\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b2\u0010[\u001a\u0004\b\\\u0010]R\u0017\u00103\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b3\u0010^\u001a\u0004\b_\u0010`R\u0017\u00104\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b4\u0010a\u001a\u0004\bb\u0010cR\u0017\u00105\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b5\u0010d\u001a\u0004\be\u0010fR\u0017\u00106\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b6\u0010g\u001a\u0004\bh\u0010iR\u0017\u00107\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b7\u0010j\u001a\u0004\bk\u0010lR\u0017\u00108\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b8\u0010m\u001a\u0004\bn\u0010oR\u0017\u00109\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b9\u0010p\u001a\u0004\bq\u0010rR\u0017\u0010:\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b:\u0010s\u001a\u0004\bt\u0010uR\u0017\u0010;\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b;\u0010F\u001a\u0004\bv\u0010GR\u0017\u0010<\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b<\u0010w\u001a\u0004\bx\u0010yR\u0017\u0010=\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b=\u0010z\u001a\u0004\b{\u0010|R\u0017\u0010>\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b>\u0010}\u001a\u0004\b~\u0010\u007f\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/state/square/SquareConfig;", "", "", "component1", "Ljava/io/File;", "component2", "component3", "Lcom/tencent/state/square/SquareLogger;", "component4", "Lcom/tencent/state/square/IThreadManager;", "component5", "Lcom/tencent/state/square/IHttpDownloader;", "component6", "Lcom/tencent/state/square/IRouter;", "component7", "Lcom/tencent/state/square/IZPlanRecorder;", "component8", "Lcom/tencent/state/square/ICommonUtils;", "component9", "Lcom/tencent/state/square/IObtainInstanceHelper;", "component10", "Lcom/tencent/state/square/api/ISquareMiniAioServiceProvider;", "component11", "Lcom/tencent/state/square/api/ISquareServiceFactory;", "component12", "Lcom/tencent/state/square/ISquareOnlineStatusHelper;", "component13", "Lcom/tencent/state/square/IReporter;", "component14", "Lcom/tencent/rapier/k;", "component15", "Lcom/tencent/state/square/IShareUtils;", "component16", "Lcom/tencent/state/square/api/ISquareHippyEngine;", "component17", "component18", "Lcom/tencent/state/square/mmkv/SMMKV;", "component19", "Lcom/tencent/state/square/IZipUtils;", "component20", "Lcom/tencent/state/square/api/ISquareAvatarUtils;", "component21", "isDebug", "rootCacheDir", "useRealDefaultImages", "logger", "threadManager", QDLog.TAG_DOWNLOAD, "router", "recorder", "commonUtils", "obtainInstanceHelper", "squareMiniAioServiceProvider", "serviceProvider", "onlineStatusHelper", "reporter", "rapier", "shareUtils", "hippyEngine", "needScaleAnimation", "squareMMKV", "zipUtils", "avatarUtils", "copy", "", "toString", "", "hashCode", "other", "equals", "Z", "()Z", "Ljava/io/File;", "getRootCacheDir", "()Ljava/io/File;", "getUseRealDefaultImages", "Lcom/tencent/state/square/SquareLogger;", "getLogger", "()Lcom/tencent/state/square/SquareLogger;", "Lcom/tencent/state/square/IThreadManager;", "getThreadManager", "()Lcom/tencent/state/square/IThreadManager;", "Lcom/tencent/state/square/IHttpDownloader;", "getDownloader", "()Lcom/tencent/state/square/IHttpDownloader;", "Lcom/tencent/state/square/IRouter;", "getRouter", "()Lcom/tencent/state/square/IRouter;", "Lcom/tencent/state/square/IZPlanRecorder;", "getRecorder", "()Lcom/tencent/state/square/IZPlanRecorder;", "Lcom/tencent/state/square/ICommonUtils;", "getCommonUtils", "()Lcom/tencent/state/square/ICommonUtils;", "Lcom/tencent/state/square/IObtainInstanceHelper;", "getObtainInstanceHelper", "()Lcom/tencent/state/square/IObtainInstanceHelper;", "Lcom/tencent/state/square/api/ISquareMiniAioServiceProvider;", "getSquareMiniAioServiceProvider", "()Lcom/tencent/state/square/api/ISquareMiniAioServiceProvider;", "Lcom/tencent/state/square/api/ISquareServiceFactory;", "getServiceProvider", "()Lcom/tencent/state/square/api/ISquareServiceFactory;", "Lcom/tencent/state/square/ISquareOnlineStatusHelper;", "getOnlineStatusHelper", "()Lcom/tencent/state/square/ISquareOnlineStatusHelper;", "Lcom/tencent/state/square/IReporter;", "getReporter", "()Lcom/tencent/state/square/IReporter;", "Lcom/tencent/rapier/k;", "getRapier", "()Lcom/tencent/rapier/k;", "Lcom/tencent/state/square/IShareUtils;", "getShareUtils", "()Lcom/tencent/state/square/IShareUtils;", "Lcom/tencent/state/square/api/ISquareHippyEngine;", "getHippyEngine", "()Lcom/tencent/state/square/api/ISquareHippyEngine;", "getNeedScaleAnimation", "Lcom/tencent/state/square/mmkv/SMMKV;", "getSquareMMKV", "()Lcom/tencent/state/square/mmkv/SMMKV;", "Lcom/tencent/state/square/IZipUtils;", "getZipUtils", "()Lcom/tencent/state/square/IZipUtils;", "Lcom/tencent/state/square/api/ISquareAvatarUtils;", "getAvatarUtils", "()Lcom/tencent/state/square/api/ISquareAvatarUtils;", "<init>", "(ZLjava/io/File;ZLcom/tencent/state/square/SquareLogger;Lcom/tencent/state/square/IThreadManager;Lcom/tencent/state/square/IHttpDownloader;Lcom/tencent/state/square/IRouter;Lcom/tencent/state/square/IZPlanRecorder;Lcom/tencent/state/square/ICommonUtils;Lcom/tencent/state/square/IObtainInstanceHelper;Lcom/tencent/state/square/api/ISquareMiniAioServiceProvider;Lcom/tencent/state/square/api/ISquareServiceFactory;Lcom/tencent/state/square/ISquareOnlineStatusHelper;Lcom/tencent/state/square/IReporter;Lcom/tencent/rapier/k;Lcom/tencent/state/square/IShareUtils;Lcom/tencent/state/square/api/ISquareHippyEngine;ZLcom/tencent/state/square/mmkv/SMMKV;Lcom/tencent/state/square/IZipUtils;Lcom/tencent/state/square/api/ISquareAvatarUtils;)V", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SquareConfig {

    @NotNull
    private final ISquareAvatarUtils avatarUtils;

    @NotNull
    private final ICommonUtils commonUtils;

    @NotNull
    private final IHttpDownloader downloader;

    @NotNull
    private final ISquareHippyEngine hippyEngine;
    private final boolean isDebug;

    @NotNull
    private final SquareLogger logger;
    private final boolean needScaleAnimation;

    @NotNull
    private final IObtainInstanceHelper obtainInstanceHelper;

    @NotNull
    private final ISquareOnlineStatusHelper onlineStatusHelper;

    @NotNull
    private final k rapier;

    @NotNull
    private final IZPlanRecorder recorder;

    @NotNull
    private final IReporter reporter;

    @NotNull
    private final File rootCacheDir;

    @NotNull
    private final IRouter router;

    @NotNull
    private final ISquareServiceFactory serviceProvider;

    @NotNull
    private final IShareUtils shareUtils;

    @NotNull
    private final SMMKV squareMMKV;

    @NotNull
    private final ISquareMiniAioServiceProvider squareMiniAioServiceProvider;

    @NotNull
    private final IThreadManager threadManager;
    private final boolean useRealDefaultImages;

    @NotNull
    private final IZipUtils zipUtils;

    public SquareConfig(boolean z16, @NotNull File rootCacheDir, boolean z17, @NotNull SquareLogger logger, @NotNull IThreadManager threadManager, @NotNull IHttpDownloader downloader, @NotNull IRouter router, @NotNull IZPlanRecorder recorder, @NotNull ICommonUtils commonUtils, @NotNull IObtainInstanceHelper obtainInstanceHelper, @NotNull ISquareMiniAioServiceProvider squareMiniAioServiceProvider, @NotNull ISquareServiceFactory serviceProvider, @NotNull ISquareOnlineStatusHelper onlineStatusHelper, @NotNull IReporter reporter, @NotNull k rapier, @NotNull IShareUtils shareUtils, @NotNull ISquareHippyEngine hippyEngine, boolean z18, @NotNull SMMKV squareMMKV, @NotNull IZipUtils zipUtils, @NotNull ISquareAvatarUtils avatarUtils) {
        Intrinsics.checkNotNullParameter(rootCacheDir, "rootCacheDir");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(recorder, "recorder");
        Intrinsics.checkNotNullParameter(commonUtils, "commonUtils");
        Intrinsics.checkNotNullParameter(obtainInstanceHelper, "obtainInstanceHelper");
        Intrinsics.checkNotNullParameter(squareMiniAioServiceProvider, "squareMiniAioServiceProvider");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        Intrinsics.checkNotNullParameter(onlineStatusHelper, "onlineStatusHelper");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(shareUtils, "shareUtils");
        Intrinsics.checkNotNullParameter(hippyEngine, "hippyEngine");
        Intrinsics.checkNotNullParameter(squareMMKV, "squareMMKV");
        Intrinsics.checkNotNullParameter(zipUtils, "zipUtils");
        Intrinsics.checkNotNullParameter(avatarUtils, "avatarUtils");
        this.isDebug = z16;
        this.rootCacheDir = rootCacheDir;
        this.useRealDefaultImages = z17;
        this.logger = logger;
        this.threadManager = threadManager;
        this.downloader = downloader;
        this.router = router;
        this.recorder = recorder;
        this.commonUtils = commonUtils;
        this.obtainInstanceHelper = obtainInstanceHelper;
        this.squareMiniAioServiceProvider = squareMiniAioServiceProvider;
        this.serviceProvider = serviceProvider;
        this.onlineStatusHelper = onlineStatusHelper;
        this.reporter = reporter;
        this.rapier = rapier;
        this.shareUtils = shareUtils;
        this.hippyEngine = hippyEngine;
        this.needScaleAnimation = z18;
        this.squareMMKV = squareMMKV;
        this.zipUtils = zipUtils;
        this.avatarUtils = avatarUtils;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsDebug() {
        return this.isDebug;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final IObtainInstanceHelper getObtainInstanceHelper() {
        return this.obtainInstanceHelper;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final ISquareMiniAioServiceProvider getSquareMiniAioServiceProvider() {
        return this.squareMiniAioServiceProvider;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final ISquareServiceFactory getServiceProvider() {
        return this.serviceProvider;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final ISquareOnlineStatusHelper getOnlineStatusHelper() {
        return this.onlineStatusHelper;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final IReporter getReporter() {
        return this.reporter;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final k getRapier() {
        return this.rapier;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final IShareUtils getShareUtils() {
        return this.shareUtils;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final ISquareHippyEngine getHippyEngine() {
        return this.hippyEngine;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getNeedScaleAnimation() {
        return this.needScaleAnimation;
    }

    @NotNull
    /* renamed from: component19, reason: from getter */
    public final SMMKV getSquareMMKV() {
        return this.squareMMKV;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final File getRootCacheDir() {
        return this.rootCacheDir;
    }

    @NotNull
    /* renamed from: component20, reason: from getter */
    public final IZipUtils getZipUtils() {
        return this.zipUtils;
    }

    @NotNull
    /* renamed from: component21, reason: from getter */
    public final ISquareAvatarUtils getAvatarUtils() {
        return this.avatarUtils;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUseRealDefaultImages() {
        return this.useRealDefaultImages;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final SquareLogger getLogger() {
        return this.logger;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final IThreadManager getThreadManager() {
        return this.threadManager;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final IHttpDownloader getDownloader() {
        return this.downloader;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final IRouter getRouter() {
        return this.router;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final IZPlanRecorder getRecorder() {
        return this.recorder;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final ICommonUtils getCommonUtils() {
        return this.commonUtils;
    }

    @NotNull
    public final SquareConfig copy(boolean isDebug, @NotNull File rootCacheDir, boolean useRealDefaultImages, @NotNull SquareLogger logger, @NotNull IThreadManager threadManager, @NotNull IHttpDownloader downloader, @NotNull IRouter router, @NotNull IZPlanRecorder recorder, @NotNull ICommonUtils commonUtils, @NotNull IObtainInstanceHelper obtainInstanceHelper, @NotNull ISquareMiniAioServiceProvider squareMiniAioServiceProvider, @NotNull ISquareServiceFactory serviceProvider, @NotNull ISquareOnlineStatusHelper onlineStatusHelper, @NotNull IReporter reporter, @NotNull k rapier, @NotNull IShareUtils shareUtils, @NotNull ISquareHippyEngine hippyEngine, boolean needScaleAnimation, @NotNull SMMKV squareMMKV, @NotNull IZipUtils zipUtils, @NotNull ISquareAvatarUtils avatarUtils) {
        Intrinsics.checkNotNullParameter(rootCacheDir, "rootCacheDir");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(recorder, "recorder");
        Intrinsics.checkNotNullParameter(commonUtils, "commonUtils");
        Intrinsics.checkNotNullParameter(obtainInstanceHelper, "obtainInstanceHelper");
        Intrinsics.checkNotNullParameter(squareMiniAioServiceProvider, "squareMiniAioServiceProvider");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        Intrinsics.checkNotNullParameter(onlineStatusHelper, "onlineStatusHelper");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(shareUtils, "shareUtils");
        Intrinsics.checkNotNullParameter(hippyEngine, "hippyEngine");
        Intrinsics.checkNotNullParameter(squareMMKV, "squareMMKV");
        Intrinsics.checkNotNullParameter(zipUtils, "zipUtils");
        Intrinsics.checkNotNullParameter(avatarUtils, "avatarUtils");
        return new SquareConfig(isDebug, rootCacheDir, useRealDefaultImages, logger, threadManager, downloader, router, recorder, commonUtils, obtainInstanceHelper, squareMiniAioServiceProvider, serviceProvider, onlineStatusHelper, reporter, rapier, shareUtils, hippyEngine, needScaleAnimation, squareMMKV, zipUtils, avatarUtils);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareConfig) {
                SquareConfig squareConfig = (SquareConfig) other;
                if (this.isDebug != squareConfig.isDebug || !Intrinsics.areEqual(this.rootCacheDir, squareConfig.rootCacheDir) || this.useRealDefaultImages != squareConfig.useRealDefaultImages || !Intrinsics.areEqual(this.logger, squareConfig.logger) || !Intrinsics.areEqual(this.threadManager, squareConfig.threadManager) || !Intrinsics.areEqual(this.downloader, squareConfig.downloader) || !Intrinsics.areEqual(this.router, squareConfig.router) || !Intrinsics.areEqual(this.recorder, squareConfig.recorder) || !Intrinsics.areEqual(this.commonUtils, squareConfig.commonUtils) || !Intrinsics.areEqual(this.obtainInstanceHelper, squareConfig.obtainInstanceHelper) || !Intrinsics.areEqual(this.squareMiniAioServiceProvider, squareConfig.squareMiniAioServiceProvider) || !Intrinsics.areEqual(this.serviceProvider, squareConfig.serviceProvider) || !Intrinsics.areEqual(this.onlineStatusHelper, squareConfig.onlineStatusHelper) || !Intrinsics.areEqual(this.reporter, squareConfig.reporter) || !Intrinsics.areEqual(this.rapier, squareConfig.rapier) || !Intrinsics.areEqual(this.shareUtils, squareConfig.shareUtils) || !Intrinsics.areEqual(this.hippyEngine, squareConfig.hippyEngine) || this.needScaleAnimation != squareConfig.needScaleAnimation || !Intrinsics.areEqual(this.squareMMKV, squareConfig.squareMMKV) || !Intrinsics.areEqual(this.zipUtils, squareConfig.zipUtils) || !Intrinsics.areEqual(this.avatarUtils, squareConfig.avatarUtils)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final ISquareAvatarUtils getAvatarUtils() {
        return this.avatarUtils;
    }

    @NotNull
    public final ICommonUtils getCommonUtils() {
        return this.commonUtils;
    }

    @NotNull
    public final IHttpDownloader getDownloader() {
        return this.downloader;
    }

    @NotNull
    public final ISquareHippyEngine getHippyEngine() {
        return this.hippyEngine;
    }

    @NotNull
    public final SquareLogger getLogger() {
        return this.logger;
    }

    public final boolean getNeedScaleAnimation() {
        return this.needScaleAnimation;
    }

    @NotNull
    public final IObtainInstanceHelper getObtainInstanceHelper() {
        return this.obtainInstanceHelper;
    }

    @NotNull
    public final ISquareOnlineStatusHelper getOnlineStatusHelper() {
        return this.onlineStatusHelper;
    }

    @NotNull
    public final k getRapier() {
        return this.rapier;
    }

    @NotNull
    public final IZPlanRecorder getRecorder() {
        return this.recorder;
    }

    @NotNull
    public final IReporter getReporter() {
        return this.reporter;
    }

    @NotNull
    public final File getRootCacheDir() {
        return this.rootCacheDir;
    }

    @NotNull
    public final IRouter getRouter() {
        return this.router;
    }

    @NotNull
    public final ISquareServiceFactory getServiceProvider() {
        return this.serviceProvider;
    }

    @NotNull
    public final IShareUtils getShareUtils() {
        return this.shareUtils;
    }

    @NotNull
    public final SMMKV getSquareMMKV() {
        return this.squareMMKV;
    }

    @NotNull
    public final ISquareMiniAioServiceProvider getSquareMiniAioServiceProvider() {
        return this.squareMiniAioServiceProvider;
    }

    @NotNull
    public final IThreadManager getThreadManager() {
        return this.threadManager;
    }

    public final boolean getUseRealDefaultImages() {
        return this.useRealDefaultImages;
    }

    @NotNull
    public final IZipUtils getZipUtils() {
        return this.zipUtils;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        boolean z16 = this.isDebug;
        int i56 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i57 = r06 * 31;
        File file = this.rootCacheDir;
        int i58 = 0;
        if (file != null) {
            i3 = file.hashCode();
        } else {
            i3 = 0;
        }
        int i59 = (i57 + i3) * 31;
        ?? r26 = this.useRealDefaultImages;
        int i65 = r26;
        if (r26 != 0) {
            i65 = 1;
        }
        int i66 = (i59 + i65) * 31;
        SquareLogger squareLogger = this.logger;
        if (squareLogger != null) {
            i16 = squareLogger.hashCode();
        } else {
            i16 = 0;
        }
        int i67 = (i66 + i16) * 31;
        IThreadManager iThreadManager = this.threadManager;
        if (iThreadManager != null) {
            i17 = iThreadManager.hashCode();
        } else {
            i17 = 0;
        }
        int i68 = (i67 + i17) * 31;
        IHttpDownloader iHttpDownloader = this.downloader;
        if (iHttpDownloader != null) {
            i18 = iHttpDownloader.hashCode();
        } else {
            i18 = 0;
        }
        int i69 = (i68 + i18) * 31;
        IRouter iRouter = this.router;
        if (iRouter != null) {
            i19 = iRouter.hashCode();
        } else {
            i19 = 0;
        }
        int i75 = (i69 + i19) * 31;
        IZPlanRecorder iZPlanRecorder = this.recorder;
        if (iZPlanRecorder != null) {
            i26 = iZPlanRecorder.hashCode();
        } else {
            i26 = 0;
        }
        int i76 = (i75 + i26) * 31;
        ICommonUtils iCommonUtils = this.commonUtils;
        if (iCommonUtils != null) {
            i27 = iCommonUtils.hashCode();
        } else {
            i27 = 0;
        }
        int i77 = (i76 + i27) * 31;
        IObtainInstanceHelper iObtainInstanceHelper = this.obtainInstanceHelper;
        if (iObtainInstanceHelper != null) {
            i28 = iObtainInstanceHelper.hashCode();
        } else {
            i28 = 0;
        }
        int i78 = (i77 + i28) * 31;
        ISquareMiniAioServiceProvider iSquareMiniAioServiceProvider = this.squareMiniAioServiceProvider;
        if (iSquareMiniAioServiceProvider != null) {
            i29 = iSquareMiniAioServiceProvider.hashCode();
        } else {
            i29 = 0;
        }
        int i79 = (i78 + i29) * 31;
        ISquareServiceFactory iSquareServiceFactory = this.serviceProvider;
        if (iSquareServiceFactory != null) {
            i36 = iSquareServiceFactory.hashCode();
        } else {
            i36 = 0;
        }
        int i85 = (i79 + i36) * 31;
        ISquareOnlineStatusHelper iSquareOnlineStatusHelper = this.onlineStatusHelper;
        if (iSquareOnlineStatusHelper != null) {
            i37 = iSquareOnlineStatusHelper.hashCode();
        } else {
            i37 = 0;
        }
        int i86 = (i85 + i37) * 31;
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            i38 = iReporter.hashCode();
        } else {
            i38 = 0;
        }
        int i87 = (i86 + i38) * 31;
        k kVar = this.rapier;
        if (kVar != null) {
            i39 = kVar.hashCode();
        } else {
            i39 = 0;
        }
        int i88 = (i87 + i39) * 31;
        IShareUtils iShareUtils = this.shareUtils;
        if (iShareUtils != null) {
            i46 = iShareUtils.hashCode();
        } else {
            i46 = 0;
        }
        int i89 = (i88 + i46) * 31;
        ISquareHippyEngine iSquareHippyEngine = this.hippyEngine;
        if (iSquareHippyEngine != null) {
            i47 = iSquareHippyEngine.hashCode();
        } else {
            i47 = 0;
        }
        int i95 = (i89 + i47) * 31;
        boolean z17 = this.needScaleAnimation;
        if (!z17) {
            i56 = z17 ? 1 : 0;
        }
        int i96 = (i95 + i56) * 31;
        SMMKV smmkv = this.squareMMKV;
        if (smmkv != null) {
            i48 = smmkv.hashCode();
        } else {
            i48 = 0;
        }
        int i97 = (i96 + i48) * 31;
        IZipUtils iZipUtils = this.zipUtils;
        if (iZipUtils != null) {
            i49 = iZipUtils.hashCode();
        } else {
            i49 = 0;
        }
        int i98 = (i97 + i49) * 31;
        ISquareAvatarUtils iSquareAvatarUtils = this.avatarUtils;
        if (iSquareAvatarUtils != null) {
            i58 = iSquareAvatarUtils.hashCode();
        }
        return i98 + i58;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    @NotNull
    public String toString() {
        return "SquareConfig(isDebug=" + this.isDebug + ", rootCacheDir=" + this.rootCacheDir + ", useRealDefaultImages=" + this.useRealDefaultImages + ", logger=" + this.logger + ", threadManager=" + this.threadManager + ", downloader=" + this.downloader + ", router=" + this.router + ", recorder=" + this.recorder + ", commonUtils=" + this.commonUtils + ", obtainInstanceHelper=" + this.obtainInstanceHelper + ", squareMiniAioServiceProvider=" + this.squareMiniAioServiceProvider + ", serviceProvider=" + this.serviceProvider + ", onlineStatusHelper=" + this.onlineStatusHelper + ", reporter=" + this.reporter + ", rapier=" + this.rapier + ", shareUtils=" + this.shareUtils + ", hippyEngine=" + this.hippyEngine + ", needScaleAnimation=" + this.needScaleAnimation + ", squareMMKV=" + this.squareMMKV + ", zipUtils=" + this.zipUtils + ", avatarUtils=" + this.avatarUtils + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SquareConfig(boolean z16, File file, boolean z17, SquareLogger squareLogger, IThreadManager iThreadManager, IHttpDownloader iHttpDownloader, IRouter iRouter, IZPlanRecorder iZPlanRecorder, ICommonUtils iCommonUtils, IObtainInstanceHelper iObtainInstanceHelper, ISquareMiniAioServiceProvider iSquareMiniAioServiceProvider, ISquareServiceFactory iSquareServiceFactory, ISquareOnlineStatusHelper iSquareOnlineStatusHelper, IReporter iReporter, k kVar, IShareUtils iShareUtils, ISquareHippyEngine iSquareHippyEngine, boolean z18, SMMKV smmkv, IZipUtils iZipUtils, ISquareAvatarUtils iSquareAvatarUtils, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, file, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, (524288 & i3) != 0 ? new DefaultZipUtils() : iZipUtils, (i3 & 1048576) != 0 ? new DefaultSquareAvatarUtils() : iSquareAvatarUtils);
        k kVar2;
        SMMKV smmkv2;
        boolean z19 = (i3 & 1) != 0 ? false : z16;
        boolean z26 = (i3 & 4) != 0 ? false : z17;
        SquareLogger defaultSquareLogger = (i3 & 8) != 0 ? new DefaultSquareLogger() : squareLogger;
        IThreadManager defaultThreadManager = (i3 & 16) != 0 ? new DefaultThreadManager() : iThreadManager;
        IHttpDownloader simpleHttpDownloader = (i3 & 32) != 0 ? new SimpleHttpDownloader() : iHttpDownloader;
        IRouter defaultRouter = (i3 & 64) != 0 ? new DefaultRouter() : iRouter;
        IZPlanRecorder defaultRecorder = (i3 & 128) != 0 ? new DefaultRecorder() : iZPlanRecorder;
        ICommonUtils defaultUtils = (i3 & 256) != 0 ? new DefaultUtils() : iCommonUtils;
        IObtainInstanceHelper defaultObtainInstanceHelper = (i3 & 512) != 0 ? new DefaultObtainInstanceHelper() : iObtainInstanceHelper;
        ISquareMiniAioServiceProvider defaultSquareMiniAioServiceProvider = (i3 & 1024) != 0 ? new DefaultSquareMiniAioServiceProvider() : iSquareMiniAioServiceProvider;
        ISquareServiceFactory defaultServiceFactory = (i3 & 2048) != 0 ? new DefaultServiceFactory() : iSquareServiceFactory;
        ISquareOnlineStatusHelper defaultSquareOnlineStatusHelper = (i3 & 4096) != 0 ? new DefaultSquareOnlineStatusHelper() : iSquareOnlineStatusHelper;
        IReporter defaultReporter = (i3 & 8192) != 0 ? new DefaultReporter() : iReporter;
        if ((i3 & 16384) != 0) {
            k kVar3 = new k();
            kVar3.e(15000L);
            kVar2 = kVar3;
        } else {
            kVar2 = kVar;
        }
        IShareUtils defaultShareUtils = (32768 & i3) != 0 ? new DefaultShareUtils() : iShareUtils;
        ISquareHippyEngine defaultHippyEngine = (65536 & i3) != 0 ? new DefaultHippyEngine() : iSquareHippyEngine;
        boolean z27 = (131072 & i3) != 0 ? false : z18;
        if ((262144 & i3) != 0) {
            Application application = defaultUtils.getApplication();
            smmkv2 = new SMMKV(application != null ? application.getApplicationContext() : null);
        } else {
            smmkv2 = smmkv;
        }
    }
}

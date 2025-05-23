package com.tencent.mobileqq.wink.inference;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWDownloaderTask;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.push.MiniAppPushControl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.inference.b;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResFetchResult;
import com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.WinkNewAlbumTextFetchResult;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002klB\t\b\u0002\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J:\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0005H\u0002J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0010J\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010'J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005J\u0014\u0010,\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0*J\u0014\u0010-\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0*J\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010/\u001a\u00020\u0010R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u0019R \u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0*0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0*0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010&R\u0016\u0010K\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010&R\u001c\u0010P\u001a\n M*\u0004\u0018\u00010L0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\\R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010^R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010^R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010^R#\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010b\u001a\u0004\bc\u0010dR\u0014\u0010h\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010g\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/WinkInferenceResManager;", "", "", "E", "D", "", "v", DownloadInfo.spKey_Config, "w", "o", "type", "", "requiredKeys", "", "configMap", "p", "", "M", "N", "G", DomainData.DOMAIN_NAME, "url", "Ljava/io/FileOutputStream;", "fileOutputStream", "u", "J", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/WinkNewAlbumResFetchResult;", "y", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFetchResult;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/wink/inference/WinkInferenceResManager$Error;", "error", "message", "K", "H", "directoryPath", ReportConstant.COSTREPORT_PREFIX, UserInfo.SEX_FEMALE, "I", "", BdhLogUtil.LogTag.Tag_Conn, "t", "Lcom/tencent/mobileqq/wink/inference/a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "b", "Ljava/util/Map;", "baseConfigMap", "c", "clipConfigMap", "d", "yamnetConfigMap", "e", "Ljava/lang/String;", "inferenceConfigUrl", "", "f", "startTime", "", "g", "Ljava/util/Set;", "fetchResResultCallbackList", h.F, "fetchTextResultCallbackList", "Lcom/tencent/mobileqq/wink/inference/WinkInferenceResManager$State;", "i", "Lcom/tencent/mobileqq/wink/inference/WinkInferenceResManager$State;", "currentState", "", "j", "MAX_RETRY_COUNT", "k", "retryCount", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "kotlin.jvm.PlatformType", "l", "Lcom/tencent/biz/richframework/download/RFWDownloader;", QDLog.TAG_DOWNLOAD, "Ljava/util/concurrent/ConcurrentLinkedQueue;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "downloadQueue", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDownloading", "Ljava/io/File;", "Ljava/io/File;", "lockFile", "Ljava/nio/channels/FileLock;", "Ljava/nio/channels/FileLock;", "fileLock", "Ljava/util/List;", "CHECK_CLIP_RES_FILE", "CHECK_BASE_RES_FILE", "CHECK_YAMNET_RES_FILE", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Ljava/util/List;", "urlsToDownload", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "stateLock", "<init>", "()V", "Error", "State", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInferenceResManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkInferenceResManager f322940a = new WinkInferenceResManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Object> baseConfigMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Object> clipConfigMap = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Object> yamnetConfigMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String inferenceConfigUrl = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<com.tencent.mobileqq.wink.inference.a<WinkNewAlbumResFetchResult>> fetchResResultCallbackList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<com.tencent.mobileqq.wink.inference.a<WinkNewAlbumTextFetchResult>> fetchTextResultCallbackList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static State currentState;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final int MAX_RETRY_COUNT;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int retryCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final RFWDownloader downloader;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentLinkedQueue<String> downloadQueue;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isDownloading;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final File lockFile;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static FileLock fileLock;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> CHECK_CLIP_RES_FILE;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> CHECK_BASE_RES_FILE;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> CHECK_YAMNET_RES_FILE;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy urlsToDownload;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantLock stateLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/WinkInferenceResManager$Error;", "", "message", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "toString", "NO_CONFIG", "PARSE_CONFIG_ERROR", "DOWNLOAD_ERROR", "RELEASE_ERROR", "FILE_LOCK_ERROR", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum Error {
        NO_CONFIG("no_config"),
        PARSE_CONFIG_ERROR("parse_config_error"),
        DOWNLOAD_ERROR("download_error"),
        RELEASE_ERROR("release_error"),
        FILE_LOCK_ERROR("file_lock_error");


        @NotNull
        private final String message;

        Error(String str) {
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            return this.message;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/WinkInferenceResManager$State;", "", "(Ljava/lang/String;I)V", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "START", "CONFIG_FETCHED", "CONFIG_CHECKED", "RESOURCES_DOWNLOADED", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum State {
        INIT,
        START,
        CONFIG_FETCHED,
        CONFIG_CHECKED,
        RESOURCES_DOWNLOADED
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        Lazy lazy;
        Set<com.tencent.mobileqq.wink.inference.a<WinkNewAlbumResFetchResult>> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(ConcurrentHashMap())");
        fetchResResultCallbackList = newSetFromMap;
        Set<com.tencent.mobileqq.wink.inference.a<WinkNewAlbumTextFetchResult>> newSetFromMap2 = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap2, "newSetFromMap(ConcurrentHashMap())");
        fetchTextResultCallbackList = newSetFromMap2;
        currentState = State.INIT;
        MAX_RETRY_COUNT = 3;
        downloader = RFWDownloaderFactory.getDownloader(c.f322985a);
        downloadQueue = new ConcurrentLinkedQueue<>();
        isDownloading = new AtomicBoolean(false);
        lockFile = new File(b.INFERENCE_MODEL_DOWNLOAD_PATH + "lockfile.lock");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b.C9051b.WECLIP_SO_PATH, b.C9051b.MODEL_NCNN_BIN, b.C9051b.MODEL_NCNN_PARAM, b.C9051b.ALBUM_MEMORY_INFO, b.C9051b.ALBUM_TEXT_FEATURE});
        CHECK_CLIP_RES_FILE = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b.a.NCNN_SO_PATH, b.a.CRYPTO_SO_PATH, b.a.SSL_SO_PATH, b.a.OMP_SO_PATH});
        CHECK_BASE_RES_FILE = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b.c.WEYAMNET_PARAM_PATH, b.c.WEYAMNET_BIN_PATH, b.c.WEYAMNET_SO_PATH});
        CHECK_YAMNET_RES_FILE = listOf3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.wink.inference.WinkInferenceResManager$urlsToDownload$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends String> invoke() {
                Map map;
                Map map2;
                List<? extends String> listOf4;
                map = WinkInferenceResManager.baseConfigMap;
                map2 = WinkInferenceResManager.yamnetConfigMap;
                listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(map.get("res_url")), String.valueOf(map2.get("res_url")), String.valueOf(WinkInferenceResManager.clipConfigMap.get("model_url")), String.valueOf(WinkInferenceResManager.clipConfigMap.get("text_path"))});
                return listOf4;
            }
        });
        urlsToDownload = lazy;
        stateLock = new ReentrantLock();
    }

    WinkInferenceResManager() {
    }

    private final WinkNewAlbumTextFetchResult A() {
        QLog.i("WinkInferenceResManager", 1, "getWinkNewAlbumTextFetchResult");
        return new WinkNewAlbumTextFetchResult(b.C9051b.ALBUM_MEMORY_INFO, b.C9051b.ALBUM_TEXT_FEATURE);
    }

    private final boolean D() {
        if (E() && F("clip") && F("yamnet")) {
            return true;
        }
        return false;
    }

    private final boolean E() {
        List<String> list = CHECK_BASE_RES_FILE;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!new File((String) it.next()).isFile()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        File parentFile;
        File file = lockFile;
        File parentFile2 = file.getParentFile();
        boolean z16 = false;
        if (parentFile2 != null && !parentFile2.exists()) {
            z16 = true;
        }
        if (z16 && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private final void H() {
        QLog.i("WinkInferenceResManager", 1, "onReady");
        Set<com.tencent.mobileqq.wink.inference.a<WinkNewAlbumResFetchResult>> set = fetchResResultCallbackList;
        synchronized (set) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.wink.inference.a aVar = (com.tencent.mobileqq.wink.inference.a) it.next();
                WinkNewAlbumResFetchResult y16 = f322940a.y();
                if (y16 != null) {
                    aVar.a(y16);
                }
            }
            fetchResResultCallbackList.clear();
            Unit unit = Unit.INSTANCE;
        }
        Set<com.tencent.mobileqq.wink.inference.a<WinkNewAlbumTextFetchResult>> set2 = fetchTextResultCallbackList;
        synchronized (set2) {
            Iterator<T> it5 = set2.iterator();
            while (it5.hasNext()) {
                ((com.tencent.mobileqq.wink.inference.a) it5.next()).a(f322940a.A());
            }
            fetchTextResultCallbackList.clear();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(FileOutputStream fileOutputStream) {
        Unit unit;
        try {
            try {
                FileLock fileLock2 = fileLock;
                if (fileLock2 != null) {
                    fileLock2.release();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    QLog.e("WinkInferenceResManager", 1, "File lock is null, cannot release");
                }
            } catch (Throwable th5) {
                try {
                    fileOutputStream.close();
                } catch (Exception e16) {
                    QLog.e("WinkInferenceResManager", 1, "Failed to close file output stream", e16);
                }
                isDownloading.set(false);
                N();
                throw th5;
            }
        } catch (Exception e17) {
            QLog.e("WinkInferenceResManager", 1, "Failed to release file lock", e17);
            L(this, Error.RELEASE_ERROR, null, 2, null);
            try {
                fileOutputStream.close();
            } catch (Exception e18) {
                e = e18;
                QLog.e("WinkInferenceResManager", 1, "Failed to close file output stream", e);
                isDownloading.set(false);
                N();
            }
        }
        try {
            fileOutputStream.close();
        } catch (Exception e19) {
            e = e19;
            QLog.e("WinkInferenceResManager", 1, "Failed to close file output stream", e);
            isDownloading.set(false);
            N();
        }
        isDownloading.set(false);
        N();
    }

    private final void K(Error error, String message) {
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_INFERENCE_MANGAGER_ERROR").traceId(WinkContext.INSTANCE.d().getTraceId()).ext1(error.getMessage()).ext2(message).getReportData();
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.b(reportData, "QCIRCLE");
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void L(WinkInferenceResManager winkInferenceResManager, Error error, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        winkInferenceResManager.K(error, str);
    }

    private final void M(String config) {
        QLog.d("WinkInferenceResManager", 1, "saveToLocal, saveConfig");
        ar.f326685a.r("key_wink_inference_res_config", config);
    }

    private final void N() {
        if (isDownloading.compareAndSet(false, true) && !n()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkInferenceResManager$startDownload$1(null), 3, null);
        }
    }

    private final boolean n() {
        boolean z16 = false;
        if (downloadQueue.isEmpty()) {
            isDownloading.set(false);
            z16 = true;
            if (D()) {
                currentState = State.RESOURCES_DOWNLOADED;
                H();
                M(inferenceConfigUrl);
            } else {
                QLog.i("WinkInferenceResManager", 1, "download error");
            }
        }
        return z16;
    }

    private final boolean o(String config) {
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"version", "res_url"});
        if (p(config, PM.BASE, listOf, baseConfigMap)) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"version", "text_path", "text_version", "key_str", "iv_str", "thread_count", "enable_fp16", "start_liner", "end_liner", MiniAppPushControl.KEY_CTRL_CMD_CLEAR_CACHE, "model_url"});
            if (p(config, "clip", listOf2, clipConfigMap)) {
                listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"version", "res_url", "music_indexes", "music_threshold"});
                if (p(config, "yamnet", listOf3, yamnetConfigMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean p(String config, String type, List<String> requiredKeys, Map<String, Object> configMap) {
        String joinToString$default;
        String joinToString$default2;
        boolean z16;
        try {
            JSONObject optJSONObject = new JSONObject(config).optJSONObject(type);
            if (optJSONObject != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : requiredKeys) {
                    String str = (String) obj;
                    Object opt = optJSONObject.opt(str);
                    if (opt != null) {
                        configMap.put(str, opt);
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
                    QLog.e("WinkInferenceResManager", 1, type + " missingKeys: " + joinToString$default);
                    Error error = Error.PARSE_CONFIG_ERROR;
                    joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
                    K(error, joinToString$default2);
                    return false;
                }
                return true;
            }
            QLog.e("WinkInferenceResManager", 1, type + " config not found");
            K(Error.PARSE_CONFIG_ERROR, type + " config not found");
            return false;
        } catch (JSONException e16) {
            QLog.e("WinkInferenceResManager", 1, "parse config error.", e16);
            K(Error.PARSE_CONFIG_ERROR, "JSONException");
            return false;
        }
    }

    private final void s(String directoryPath) {
        File[] listFiles;
        File file = new File(directoryPath);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                s(absolutePath);
            }
            file2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String url, FileOutputStream fileOutputStream) {
        RFWDownloader rFWDownloader = downloader;
        RFWDownloaderTask rFWDownloaderTask = new RFWDownloaderTask(url);
        String str = b.INFERENCE_MODEL_PATH + RFWUrlUtils.getFileNameFromUrl(url);
        QLog.i("WinkInferenceResManager", 1, "downloadRes, filePath:" + str);
        rFWDownloaderTask.setFilePath(str);
        String filePath = rFWDownloaderTask.getFilePath();
        boolean z16 = false;
        if (filePath != null && new File(filePath).exists()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("WinkInferenceResManager", 1, "File already exists, skipping download: " + rFWDownloaderTask.getFilePath());
            f322940a.J(fileOutputStream);
            return;
        }
        startTime = System.currentTimeMillis();
        rFWDownloaderTask.setDownloadListener(new a(url, fileOutputStream));
        rFWDownloader.download(rFWDownloaderTask);
    }

    private final String v() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105627", "");
        if (TextUtils.isEmpty(loadAsString)) {
            QLog.i("WinkInferenceResManager", 1, "config is null");
            return "";
        }
        String i3 = ar.f326685a.i("key_wink_inference_res_config", "");
        String w3 = w(loadAsString);
        if (Intrinsics.areEqual(i3, w3)) {
            QLog.i("WinkInferenceResManager", 1, "getConfig, sameConfig");
            if (D()) {
                currentState = State.RESOURCES_DOWNLOADED;
                QLog.i("WinkInferenceResManager", 1, "getConfig, hasDownloaded");
            }
        } else {
            currentState = State.CONFIG_FETCHED;
        }
        inferenceConfigUrl = w3;
        return loadAsString;
    }

    private final String w(String config) {
        try {
            JSONObject jSONObject = new JSONObject(config);
            JSONObject optJSONObject = jSONObject.optJSONObject("clip");
            if (optJSONObject != null) {
                optJSONObject.remove("key_str");
                optJSONObject.remove("iv_str");
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (Exception e16) {
            QLog.e("WinkInferenceResManager", 1, "getDesensitizedConfig " + e16);
            return "";
        }
    }

    private final List<String> x() {
        return (List) urlsToDownload.getValue();
    }

    private final WinkNewAlbumResFetchResult y() {
        String str;
        String str2;
        boolean z16;
        QLog.i("WinkInferenceResManager", 1, "getWinkNewAlbumResFetchResult");
        Map<String, Object> map = clipConfigMap;
        Object obj = map.get("key_str");
        if (obj != null) {
            str = obj.toString();
        } else {
            str = null;
        }
        Object obj2 = map.get("iv_str");
        if (obj2 != null) {
            str2 = obj2.toString();
        } else {
            str2 = null;
        }
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                return new WinkNewAlbumResFetchResult(b.C9051b.WECLIP_SO_PATH, b.a.NCNN_SO_PATH, b.a.CRYPTO_SO_PATH, b.a.SSL_SO_PATH, b.a.OMP_SO_PATH, b.C9051b.MODEL_NCNN_BIN, b.C9051b.MODEL_NCNN_PARAM, str, str2);
            }
        }
        QLog.i("WinkInferenceResManager", 1, "keyStr or ivStr is null");
        return null;
    }

    public final void B(@NotNull com.tencent.mobileqq.wink.inference.a<WinkNewAlbumTextFetchResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (currentState != State.RESOURCES_DOWNLOADED) {
            if (currentState == State.INIT) {
                I();
            }
            QLog.i("WinkInferenceResManager", 1, "getWinkNewAlbumTextFetchResult no ready");
            fetchTextResultCallbackList.add(callback);
            return;
        }
        callback.a(A());
    }

    @NotNull
    public final Map<String, Object> C() {
        return yamnetConfigMap;
    }

    public final boolean F(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (E() && !isDownloading.get() && currentState != State.INIT) {
            if (Intrinsics.areEqual(type, "yamnet")) {
                List<String> list = CHECK_YAMNET_RES_FILE;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (!new File((String) it.next()).isFile()) {
                            return false;
                        }
                    }
                }
            } else {
                if (!Intrinsics.areEqual(type, "clip")) {
                    return false;
                }
                List<String> list2 = CHECK_CLIP_RES_FILE;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        if (!new File((String) it5.next()).isFile()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        QLog.e("WinkInferenceResManager", 1, "isResReady type = " + type + " isDownloading:" + isDownloading + " currentState:" + currentState);
        return false;
    }

    public final void I() {
        boolean z16;
        ReentrantLock reentrantLock = stateLock;
        reentrantLock.lock();
        try {
            QLog.i("WinkInferenceResManager", 1, "preloadRes " + currentState);
            if (currentState != State.INIT) {
                reentrantLock.unlock();
                return;
            }
            currentState = State.START;
            String v3 = v();
            if (v3.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && o(v3)) {
                QLog.i("WinkInferenceResManager", 1, "check success");
                if (currentState != State.RESOURCES_DOWNLOADED) {
                    currentState = State.CONFIG_CHECKED;
                    for (String str : x()) {
                        if (str != null) {
                            f322940a.t(str);
                        }
                    }
                } else {
                    H();
                    QLog.i("WinkInferenceResManager", 1, "preloadRes hasDownload");
                }
            } else {
                QLog.i("WinkInferenceResManager", 1, "config is null or check error");
                L(this, Error.NO_CONFIG, null, 2, null);
            }
        } finally {
            stateLock.unlock();
        }
    }

    public final void q() {
        fetchResResultCallbackList.clear();
        fetchTextResultCallbackList.clear();
    }

    public final void r() {
        s(b.INFERENCE_MODEL_PATH);
    }

    public final void t(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        downloadQueue.add(url);
        N();
    }

    public final void z(@NotNull com.tencent.mobileqq.wink.inference.a<WinkNewAlbumResFetchResult> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (currentState != State.RESOURCES_DOWNLOADED) {
            if (currentState == State.INIT) {
                I();
            }
            QLog.i("WinkInferenceResManager", 1, "getWinkNewAlbumResFetchResult no ready");
            fetchResResultCallbackList.add(callback);
            return;
        }
        WinkNewAlbumResFetchResult y16 = y();
        if (y16 != null) {
            callback.a(y16);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("WinkInferenceResManager", 1, "error getWinkNewAlbumResFetchResult ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/inference/WinkInferenceResManager$a", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f322961d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileOutputStream f322962e;

        a(String str, FileOutputStream fileOutputStream) {
            this.f322961d = str;
            this.f322962e = fileOutputStream;
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
        public void onRspCallback(boolean isSuccess, @Nullable String filePath) {
            WinkInferenceResManager winkInferenceResManager;
            Unit unit;
            boolean z16;
            try {
                try {
                    QLog.i("WinkInferenceResManager", 1, "downloadRes, onRspCallback, isSuccess:" + isSuccess + ", filePath:" + filePath);
                    if (isSuccess) {
                        if (filePath != null && filePath.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            try {
                                if (Intrinsics.areEqual(this.f322961d, WinkInferenceResManager.clipConfigMap.get("text_path"))) {
                                    RFWFileUtils.unZipFile(new File(filePath), b.C9051b.f322973a.a());
                                } else {
                                    RFWFileUtils.unZipFile(new File(filePath), b.INFERENCE_MODEL_PATH);
                                }
                            } catch (Exception unused) {
                                if (WinkInferenceResManager.retryCount < WinkInferenceResManager.MAX_RETRY_COUNT) {
                                    WinkInferenceResManager.retryCount++;
                                    WinkInferenceResManager.downloadQueue.add(this.f322961d);
                                }
                                if (new File(filePath).isFile()) {
                                    new File(filePath).delete();
                                    QLog.i("WinkInferenceResManager", 1, "downloadRes deleteFile,  filePath:" + filePath);
                                }
                            }
                        }
                    }
                    String str = this.f322961d;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_BGM_INFERENCE_DOWNLOAD").traceId(WinkContext.INSTANCE.d().getTraceId()).ext2(String.valueOf(System.currentTimeMillis() - WinkInferenceResManager.startTime)).ext3(RFWUrlUtils.getFileNameFromUrl(str)).retCode(String.valueOf(isSuccess)).getReportData();
                        z93.c f16 = Wink.INSTANCE.f();
                        if (f16 != null) {
                            f16.b(reportData, "QCIRCLE");
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        Result.m476constructorimpl(unit);
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    winkInferenceResManager = WinkInferenceResManager.f322940a;
                } catch (Exception e16) {
                    QLog.e("WinkInferenceResManager", 1, e16, new Object[0]);
                    winkInferenceResManager = WinkInferenceResManager.f322940a;
                    WinkInferenceResManager.L(winkInferenceResManager, Error.DOWNLOAD_ERROR, null, 2, null);
                }
                winkInferenceResManager.J(this.f322962e);
            } catch (Throwable th6) {
                WinkInferenceResManager.f322940a.J(this.f322962e);
                throw th6;
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

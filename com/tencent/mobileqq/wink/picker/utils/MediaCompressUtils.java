package com.tencent.mobileqq.wink.picker.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.export.ab;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tav.decoder.ThreadPool;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J]\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000726\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019JX\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000526\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u0012J\u0016\u0010\u001e\u001a\u00020\u000f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cJ\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJL\u0010 \u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c26\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u0012J\u0014\u0010!\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010'R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R#\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R#\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/8\u0006\u00a2\u0006\f\n\u0004\b4\u0010+\u001a\u0004\b5\u00102R'\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u000207j\b\u0012\u0004\u0012\u00020\u0002`88\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010D\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010A\u001a\u0004\bB\u0010C\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/utils/MediaCompressUtils;", "", "", "originPath", "compressedPath", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "t", "v", ReportConstant.COSTREPORT_PREFIX, "", "result", "mediaInfo", "", HippyTKDListViewAdapter.X, "index", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "progress", "onProgressChanged", "l", "(ILcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyExif", "j", "", QAdVrReportParams.ParamKey.MEDIA, tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "w", "b", "Ljava/util/List;", "VIDEO_SUPPORT_TYPE", "c", "p", "()Ljava/util/List;", "DEFAULT_NOT_SUPPORT_4K_BLACK_LIST", "", "d", "Ljava/util/Map;", "_originPathToCompressedPath", "e", "_compressedPathToOriginPath", "", "f", "r", "()Ljava/util/Map;", "originPathToCompressedPath", "g", DomainData.DOMAIN_NAME, "compressedPathToOriginPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "o", "()Ljava/util/ArrayList;", "compressingPath", "Lcom/tencent/mobileqq/wink/editor/export/ab;", "i", "Lcom/tencent/mobileqq/wink/editor/export/ab;", "winkVideoCompressTask", "Lkotlin/Lazy;", "u", "()Z", "isUseCompressedVideoCache", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MediaCompressUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MediaCompressUtils f325262a = new MediaCompressUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> VIDEO_SUPPORT_TYPE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> DEFAULT_NOT_SUPPORT_4K_BLACK_LIST;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> _originPathToCompressedPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> _compressedPathToOriginPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> originPathToCompressedPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> compressedPathToOriginPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> compressingPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ab winkVideoCompressTask;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isUseCompressedVideoCache;

    static {
        List<String> listOf;
        List<String> listOf2;
        Lazy lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"video/mp4", "video/3gpp"});
        VIDEO_SUPPORT_TYPE = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf("RTE-AL00");
        DEFAULT_NOT_SUPPORT_4K_BLACK_LIST = listOf2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _originPathToCompressedPath = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        _compressedPathToOriginPath = linkedHashMap2;
        originPathToCompressedPath = linkedHashMap;
        compressedPathToOriginPath = linkedHashMap2;
        compressingPath = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils$isUseCompressedVideoCache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean checkWinkEditOptimizeOpenByUid = QzoneConfig.checkWinkEditOptimizeOpenByUid(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "qqcircle_new_publish_use_compress_cache", 0);
                u53.i.f438431d = Boolean.valueOf(checkWinkEditOptimizeOpenByUid);
                w53.b.f("MediaCompressUtils", "[WNS] isUseCompressCache = " + checkWinkEditOptimizeOpenByUid);
                return Boolean.valueOf(checkWinkEditOptimizeOpenByUid);
            }
        });
        isUseCompressedVideoCache = lazy;
    }

    MediaCompressUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        ab abVar = winkVideoCompressTask;
        if (abVar != null) {
            abVar.cancel();
        }
    }

    private final boolean m(String originPath, String compressedPath) {
        Map mapOf;
        if (!JpegExifReader.isCrashJpeg(originPath) && !JpegExifReader.isCrashJpeg(compressedPath)) {
            try {
                ExifInterface exifInterface = new ExifInterface(originPath);
                ExifInterface exifInterface2 = new ExifInterface(compressedPath);
                String attribute = exifInterface.getAttribute("DateTime");
                if (attribute == null) {
                    attribute = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new File(originPath).lastModified()));
                }
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("DateTime", attribute), TuplesKt.to("GPSLatitude", exifInterface.getAttribute("GPSLatitude")), TuplesKt.to("GPSLatitudeRef", exifInterface.getAttribute("GPSLatitudeRef")), TuplesKt.to("GPSLongitude", exifInterface.getAttribute("GPSLongitude")), TuplesKt.to("GPSLongitudeRef", exifInterface.getAttribute("GPSLongitudeRef")));
                ArrayList arrayList = new ArrayList(mapOf.size());
                for (Map.Entry entry : mapOf.entrySet()) {
                    if (entry.getValue() != null) {
                        exifInterface2.setAttribute((String) entry.getKey(), (String) entry.getValue());
                    }
                    arrayList.add(Unit.INSTANCE);
                }
                exifInterface2.saveAttributes();
                return true;
            } catch (Throwable th5) {
                w53.b.d("MediaCompressUtils", "[copyExif]", th5);
            }
        }
        return false;
    }

    private final boolean s(String compressedPath) {
        if (compressedPath != null && FileUtils.fileExists(compressedPath) && FileUtils.getFileSizes(compressedPath) > 0) {
            return true;
        }
        return false;
    }

    private final boolean t(LocalMediaInfo localMediaInfo) {
        int coerceAtMost;
        boolean z16;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
        int i3 = ScreenUtil.SCREEN_WIDTH;
        if (coerceAtMost <= i3 * 2 && localMediaInfo.orientation == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            w53.b.f("MediaCompressUtils", "[isImageNeedCompress] don't need compress, width:" + localMediaInfo.mediaWidth + ",height:" + localMediaInfo.mediaHeight + ", screenWidth:" + i3);
            return false;
        }
        c93.a aVar = c93.a.f30473a;
        String str = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
        String a16 = aVar.a(str);
        if (!s(a16)) {
            return true;
        }
        w53.b.f("MediaCompressUtils", "[isImageNeedCompress] already compressed in disk, " + localMediaInfo.path + " -> " + a16);
        Map<String, String> map = _originPathToCompressedPath;
        String str2 = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
        Intrinsics.checkNotNull(a16);
        map.put(str2, a16);
        Map<String, String> map2 = _compressedPathToOriginPath;
        String str3 = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str3, "localMediaInfo.path");
        map2.put(a16, str3);
        return false;
    }

    private final boolean u() {
        return ((Boolean) isUseCompressedVideoCache.getValue()).booleanValue();
    }

    private final boolean v(LocalMediaInfo localMediaInfo) {
        boolean contains;
        int coerceAtMost;
        int i3;
        long j3 = localMediaInfo.mDuration;
        if (j3 <= 3600000 && j3 >= 2000) {
            if (u()) {
                c93.a aVar = c93.a.f30473a;
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
                String c16 = aVar.c(str);
                if (s(c16)) {
                    w53.b.f("MediaCompressUtils", "[isVideoNeedCompress] already compressed in disk, " + localMediaInfo.path + " -> " + c16);
                    Map<String, String> map = _originPathToCompressedPath;
                    String str2 = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
                    Intrinsics.checkNotNull(c16);
                    map.put(str2, c16);
                    Map<String, String> map2 = _compressedPathToOriginPath;
                    String str3 = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str3, "localMediaInfo.path");
                    map2.put(c16, str3);
                    return false;
                }
            }
            if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                    contains = CollectionsKt___CollectionsKt.contains(VIDEO_SUPPORT_TYPE, mediaMetadataRetriever.extractMetadata(12));
                    if (!contains) {
                        return false;
                    }
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    Intrinsics.checkNotNull(extractMetadata);
                    int parseInt = Integer.parseInt(extractMetadata);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    Intrinsics.checkNotNull(extractMetadata2);
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(parseInt, Integer.parseInt(extractMetadata2));
                    if (AEOfflineConfig.getPhonePerfLevel() >= uq3.c.O4()) {
                        i3 = 2160;
                    } else {
                        i3 = 1080;
                    }
                    if (coerceAtMost > i3) {
                        w53.b.f("MediaCompressUtils", "[isVideoNeedCompress] need compress: " + localMediaInfo.path);
                        return true;
                    }
                } catch (Exception e16) {
                    w53.b.d("MediaCompressUtils", "[isVideoNeedCompress] " + localMediaInfo.path + " error: ", e16);
                }
            }
            return false;
        }
        w53.b.f("MediaCompressUtils", "[isVideoNeedCompress] duration is too long or too short, do not compress");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(final int result, final LocalMediaInfo mediaInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                MediaCompressUtils.y(result, mediaInfo);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(int i3, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        w53.b.f("MediaCompressUtils", "[reportCompressResult] result=" + i3 + ", origin path=" + mediaInfo.path);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_COMPRESS_ORIGIN_WIDTH, Integer.valueOf(mediaInfo.mediaWidth));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_COMPRESS_ORIGIN_HEIGHT, Integer.valueOf(mediaInfo.mediaHeight));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_COMPRESS_RESULT, Integer.valueOf(i3));
        VideoReport.reportEvent("ev_xsj_camera_action", map);
    }

    public final void h(@Nullable List<? extends LocalMediaInfo> media) {
        ThreadPool.execute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                MediaCompressUtils.i();
            }
        });
        if (media != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : media) {
                if (e93.i.I((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c93.a.f30473a.e((LocalMediaInfo) it.next());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ca, code lost:
    
        if (r7.isRecycled() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00cc, code lost:
    
        r7.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e4, code lost:
    
        if (r7.isRecycled() == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String j(int index, @NotNull LocalMediaInfo mediaInfo, boolean copyExif, @NotNull Function2<? super Integer, ? super Float, Unit> onProgressChanged) {
        boolean z16;
        Bitmap bitmap;
        boolean endsWith$default;
        boolean saveBitmapFileAsJPEG;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        String originPath = mediaInfo.path;
        w53.b.f("MediaCompressUtils", "[compressImage] start, index=" + index + ", path=" + originPath);
        c93.a aVar = c93.a.f30473a;
        Intrinsics.checkNotNullExpressionValue(originPath, "originPath");
        String a16 = aVar.a(originPath);
        boolean z17 = false;
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Bitmap bitmap2 = null;
        if (z16) {
            w53.b.c("MediaCompressUtils", "[compressImage] failed, outputPath isNullOrEmpty");
            return null;
        }
        try {
            bitmap = com.tencent.mobileqq.wink.utils.f.f(originPath, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
            if (bitmap != null) {
                try {
                    if (mediaInfo.orientation != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(mediaInfo.orientation);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        if (createBitmap != null) {
                            bitmap = createBitmap;
                        }
                    }
                    File file = new File(a16);
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(originPath, ".png", false, 2, null);
                    if (endsWith$default) {
                        saveBitmapFileAsJPEG = BaseImageUtil.saveBitmapFileAsPNG(bitmap, 100, file);
                    } else {
                        saveBitmapFileAsJPEG = BaseImageUtil.saveBitmapFileAsJPEG(bitmap, file);
                    }
                    mediaInfo.mediaWidth = bitmap.getWidth();
                    mediaInfo.mediaHeight = bitmap.getHeight();
                    if (copyExif) {
                        try {
                            try {
                                m(originPath, a16);
                            } catch (Throwable th5) {
                                th = th5;
                                bitmap2 = bitmap;
                                if (bitmap2 != null && !bitmap2.isRecycled()) {
                                    bitmap2.recycle();
                                }
                                throw th;
                            }
                        } catch (IOException e16) {
                            e = e16;
                            w53.b.d("MediaCompressUtils", "[compressImage]", e);
                            if (bitmap != null) {
                            }
                            if (!z17) {
                            }
                        }
                    }
                    z17 = saveBitmapFileAsJPEG;
                } catch (IOException e17) {
                    e = e17;
                } catch (Throwable th6) {
                    th = th6;
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                    throw th;
                }
            }
            if (bitmap != null) {
            }
        } catch (IOException e18) {
            e = e18;
            bitmap = null;
        } catch (Throwable th7) {
            th = th7;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            throw th;
        }
        if (!z17) {
            w53.b.f("MediaCompressUtils", "[compressImage] succeed: " + originPath + " ==> " + a16);
            _originPathToCompressedPath.put(originPath, a16);
            _compressedPathToOriginPath.put(a16, originPath);
            onProgressChanged.invoke(Integer.valueOf(index), Float.valueOf(1.0f));
            return a16;
        }
        compressingPath.clear();
        w53.b.c("MediaCompressUtils", "[compressImage] failed: " + originPath);
        return null;
    }

    public final void k(@NotNull List<? extends LocalMediaInfo> media, @NotNull Function2<? super Integer, ? super Float, Unit> onProgressChanged) {
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new MediaCompressUtils$compressQzoneMedia$1(media, onProgressChanged, null), 3, null);
    }

    @Nullable
    public final Object l(final int i3, @NotNull final LocalMediaInfo localMediaInfo, @NotNull final Function2<? super Integer, ? super Float, Unit> function2, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        w53.b.f("MediaCompressUtils", "[compressVideo] invoke, index=" + i3 + ", path=" + localMediaInfo.path);
        ThreadPool.execute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils$compressVideo$2$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/wink/picker/utils/MediaCompressUtils$compressVideo$2$1$a", "Lcom/tencent/mobileqq/wink/editor/export/c;", "", "missionID", "", "type", "", "f", "e", "Lcom/tencent/mobileqq/wink/export/model/ExportingParam;", "exportingParam", "b", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "isExported", "d", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errorCode", "c", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements com.tencent.mobileqq.wink.editor.export.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f325276a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ LocalMediaInfo f325277b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ Function2<Integer, Float, Unit> f325278c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Continuation<String> f325279d;

                /* JADX WARN: Multi-variable type inference failed */
                a(int i3, LocalMediaInfo localMediaInfo, Function2<? super Integer, ? super Float, Unit> function2, Continuation<? super String> continuation) {
                    this.f325276a = i3;
                    this.f325277b = localMediaInfo;
                    this.f325278c = function2;
                    this.f325279d = continuation;
                }

                @Override // com.tencent.mobileqq.wink.editor.export.c
                public void a(@NotNull String missionID) {
                    Intrinsics.checkNotNullParameter(missionID, "missionID");
                    w53.b.c("MediaCompressUtils", "[compressVideo] onExportCancel, index=" + this.f325276a + ", path=" + this.f325277b.path);
                }

                @Override // com.tencent.mobileqq.wink.editor.export.c
                public void b(@NotNull String missionID, @NotNull ExportingParam exportingParam) {
                    Intrinsics.checkNotNullParameter(missionID, "missionID");
                    Intrinsics.checkNotNullParameter(exportingParam, "exportingParam");
                    this.f325278c.invoke(Integer.valueOf(this.f325276a), Float.valueOf(exportingParam.f322842e));
                }

                @Override // com.tencent.mobileqq.wink.editor.export.c
                public void c(@NotNull String missionID, @NotNull ExportErrorCode errorCode) {
                    Intrinsics.checkNotNullParameter(missionID, "missionID");
                    Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                    w53.b.c("MediaCompressUtils", "[compressVideo] onExportError, index=" + this.f325276a + ", path=" + this.f325277b.path);
                    c93.a.f30473a.e(this.f325277b);
                    MediaCompressUtils.f325262a.x(0, this.f325277b);
                    this.f325279d.resumeWith(Result.m476constructorimpl(null));
                }

                @Override // com.tencent.mobileqq.wink.editor.export.c
                public void d(@NotNull String missionID, @NotNull LocalMediaInfo localMediaInfo, boolean isExported) {
                    Map map;
                    Map map2;
                    Intrinsics.checkNotNullParameter(missionID, "missionID");
                    Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
                    String str = localMediaInfo.path;
                    w53.b.f("MediaCompressUtils", "[compressVideo] onExportCompleted, index=" + this.f325276a + ", " + this.f325277b.path + " ==> " + str);
                    if (str == null) {
                        MediaCompressUtils.f325262a.x(0, this.f325277b);
                        this.f325279d.resumeWith(Result.m476constructorimpl(null));
                        return;
                    }
                    map = MediaCompressUtils._originPathToCompressedPath;
                    String str2 = this.f325277b.path;
                    Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.path");
                    map.put(str2, str);
                    map2 = MediaCompressUtils._compressedPathToOriginPath;
                    String str3 = this.f325277b.path;
                    Intrinsics.checkNotNullExpressionValue(str3, "mediaInfo.path");
                    map2.put(str, str3);
                    this.f325278c.invoke(Integer.valueOf(this.f325276a), Float.valueOf(1.0f));
                    MediaCompressUtils.f325262a.x(1, this.f325277b);
                    this.f325279d.resumeWith(Result.m476constructorimpl(str));
                }

                @Override // com.tencent.mobileqq.wink.editor.export.c
                public void e(@NotNull String missionID, int type) {
                    Intrinsics.checkNotNullParameter(missionID, "missionID");
                }

                @Override // com.tencent.mobileqq.wink.editor.export.c
                public void f(@NotNull String missionID, int type) {
                    Intrinsics.checkNotNullParameter(missionID, "missionID");
                    w53.b.f("MediaCompressUtils", "[compressVideo] onExportStart, index=" + this.f325276a + ", path=" + this.f325277b.path);
                    this.f325278c.invoke(Integer.valueOf(this.f325276a), Float.valueOf(0.0f));
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                Map map;
                Map map2;
                ab abVar;
                map = MediaCompressUtils._originPathToCompressedPath;
                String str = (String) map.remove(LocalMediaInfo.this.path);
                map2 = MediaCompressUtils._compressedPathToOriginPath;
                TypeIntrinsics.asMutableMap(map2).remove(str);
                MediaCompressUtils.winkVideoCompressTask = new ab();
                abVar = MediaCompressUtils.winkVideoCompressTask;
                if (abVar != null) {
                    LocalMediaInfo localMediaInfo2 = LocalMediaInfo.this;
                    WinkContext.Companion companion = WinkContext.INSTANCE;
                    abVar.b(ab.d(localMediaInfo2, "QCIRCLE", companion.d().getMissionId(), companion.d().getTraceId()), new a(i3, LocalMediaInfo.this, function2, safeContinuation));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public final Map<String, String> n() {
        return compressedPathToOriginPath;
    }

    @NotNull
    public final ArrayList<String> o() {
        return compressingPath;
    }

    @NotNull
    public final List<String> p() {
        return DEFAULT_NOT_SUPPORT_4K_BLACK_LIST;
    }

    @NotNull
    public final List<LocalMediaInfo> q(@NotNull List<? extends LocalMediaInfo> media) {
        boolean z16;
        Intrinsics.checkNotNullParameter(media, "media");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = media.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = ((LocalMediaInfo) next).path;
            if (str == null || str.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
            if (e93.i.I(localMediaInfo)) {
                z16 = f325262a.v(localMediaInfo);
            } else if (e93.i.G(localMediaInfo)) {
                z16 = f325262a.t(localMediaInfo);
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        w53.b.f("MediaCompressUtils", "[getNeedCompressMedia] filteredMedia.size=" + arrayList2.size());
        return arrayList2;
    }

    @NotNull
    public final Map<String, String> r() {
        return originPathToCompressedPath;
    }

    public final boolean w(@NotNull List<? extends LocalMediaInfo> media) {
        boolean z16;
        Intrinsics.checkNotNullParameter(media, "media");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = media.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = ((LocalMediaInfo) next).path;
            if (str == null || str.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
            if (e93.i.G(localMediaInfo)) {
                z16 = f325262a.t(localMediaInfo);
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return !arrayList2.isEmpty();
    }
}

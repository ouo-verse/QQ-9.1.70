package com.tencent.mobileqq.wink.h5native;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.picker.utils.p;
import com.tencent.mobileqq.wink.utils.ak;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.LightConstants;
import y53.a;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001oB\t\b\u0002\u00a2\u0006\u0004\bm\u0010nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bJ4\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J#\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ/\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0002H\u0002J1\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0006\u0010&\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J#\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J\u0018\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J'\u00102\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J,\u00107\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 2\u0006\u00104\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0002J,\u00108\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 2\u0006\u00104\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0013H\u0002J,\u0010;\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 2\u0006\u00104\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0002J\u001b\u0010<\u001a\u0002052\u0006\u0010%\u001a\u00020\"H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=JU\u0010?\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010(2\u0006\u0010&\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@J\u001b\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010CJ,\u0010F\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010E\u001a\u00020D2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H\u0002J \u0010J\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\bH\u0002J\u0010\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020\u0002H\u0002J\u0010\u0010O\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u0002H\u0002J\b\u0010P\u001a\u00020\u0002H\u0002J\u0010\u0010Q\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0013\u0010R\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010UR\u0016\u0010f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010UR\u0018\u0010h\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010]R\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010k\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager;", "", "", "requestJson", "", "P", AppConstants.Key.KEY_QZONE_VIDEO_URL, "savePath", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$DownloadAiPaintVideoListener;", "listener", "M", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$AiPaintResponseListener;", "b0", UserInfo.SEX_FEMALE, "a0", "V", "J", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqRequest;", Const.BUNDLE_KEY_REQUEST, "", "retCode", "retMsg", "decodedReq", "X", "encryptedString", "L", "videoPath", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishVideoRequest;", "publishVideoRequest", "c0", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishVideoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "materialID", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "D", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", WadlProxyConsts.KEY_MATERIAL, "cacheDir", "I", "", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$Image;", "images", "O", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageUrl", "N", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageBase64Str", "K", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "", "value", "g0", "f0", "", "startTime", "e0", "E", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "text", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qrcodeVideoPath", "Z", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "extractFramePos", BdhLogUtil.LogTag.Tag_Req, "originPath", "targetPath", "downloadListener", "H", "path", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", BdhLogUtil.LogTag.Tag_Conn, "filePath", "W", "U", "T", "d0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Ljava/lang/String;", "EXPORT_CACHE_DIR", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "c", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "templateMaterials", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "queryMaterialJob", "Lkotlinx/coroutines/sync/Mutex;", "e", "Lkotlinx/coroutines/sync/Mutex;", "syncMutex", "f", "cryptoKey", "g", "currentTraceID", tl.h.F, "currentExportJob", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultResponse;", "i", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultResponse;", "currentExportResult", "<init>", "()V", "AiPaintVideoException", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MetaCategory templateMaterials;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job queryMaterialJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job currentExportJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GetExportAiPaintVideoResultResponse currentExportResult;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkAiPaintNativeExportManager f322863a = new WinkAiPaintNativeExportManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String EXPORT_CACHE_DIR = u53.e.f438384a + "/h5_native_export_cache";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Mutex syncMutex = MutexKt.Mutex$default(false, 1, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String cryptoKey = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String currentTraceID = "";

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$AiPaintVideoException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorMsg", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class AiPaintVideoException extends Exception {
        private final int errorCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AiPaintVideoException(int i3, @NotNull String errorMsg) {
            super(errorMsg);
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.errorCode = i3;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQWinkEditorResAPI.DownloadAiPaintVideoListener f322877d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CoroutineExceptionHandler.Companion companion, IQQWinkEditorResAPI.DownloadAiPaintVideoListener downloadAiPaintVideoListener) {
            super(companion);
            this.f322877d = downloadAiPaintVideoListener;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAiPaintNativeExportManager", "Exception: " + stackTraceToString);
            this.f322877d.onDownloaded(-1, exception.toString());
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f322880d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CoroutineExceptionHandler.Companion companion, Map map) {
            super(companion);
            this.f322880d = map;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            int i3;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAiPaintNativeExportManager", "Export exception: " + stackTraceToString);
            if (exception instanceof AiPaintVideoException) {
                i3 = ((AiPaintVideoException) exception).getErrorCode();
            } else {
                i3 = -1;
            }
            WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = WinkAiPaintNativeExportManager.f322863a;
            WinkAiPaintNativeExportManager.currentExportResult = new GetExportAiPaintVideoResultResponse(i3, exception.toString(), null, null, null, 28, null);
            WinkAiPaintNativeExportManager.f322863a.f0(this.f322880d, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, i3);
            w53.b.f("WinkAiPaintNativeExportManager", "export cost time: " + this.f322880d);
            com.tencent.mobileqq.wink.report.e.o(com.tencent.mobileqq.wink.report.e.f326265a, WinkDengtaReportConstant.Action.H5_NATIVE_EXPORT_EVENT_TIME, this.f322880d, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "aeResInfo", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "kotlin.jvm.PlatformType", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEMultiDownloadFinish"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class f implements IAEMultiDownloadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f322881a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f322882b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<Unit> f322883c;

        /* JADX WARN: Multi-variable type inference failed */
        f(Map<String, String> map, long j3, Continuation<? super Unit> continuation) {
            this.f322881a = map;
            this.f322882b = j3;
            this.f322883c = continuation;
        }

        @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
        public final void onAEMultiDownloadFinish(AEResInfo aEResInfo, boolean z16, int i3) {
            if (z16) {
                WinkExportUtils.R();
                WinkAiPaintNativeExportManager.f322863a.e0(this.f322881a, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_LIGHT_BUNDLE_TIME, this.f322882b);
                Continuation<Unit> continuation = this.f322883c;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                return;
            }
            String str = "Failed to fetch light res: " + aEResInfo + ", " + i3;
            w53.b.c("WinkAiPaintNativeExportManager", str);
            Continuation<Unit> continuation2 = this.f322883c;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new AiPaintVideoException(1, str))));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public h(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAiPaintNativeExportManager", "preloadAiPaintRes exception: " + stackTraceToString);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class i extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQWinkEditorResAPI.AiPaintResponseListener f322886d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PublishVideoRequest f322887e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(CoroutineExceptionHandler.Companion companion, IQQWinkEditorResAPI.AiPaintResponseListener aiPaintResponseListener, PublishVideoRequest publishVideoRequest) {
            super(companion);
            this.f322886d = aiPaintResponseListener;
            this.f322887e = publishVideoRequest;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAiPaintNativeExportManager", "PublishAiPaintVideo exception: " + stackTraceToString);
            this.f322886d.onResponse(this.f322887e.getCallback(), new PublishVideoResponse(-1, exception.toString(), null, 4, null).toJsonStr());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$j", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class j implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkPublishParams f322888a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f322889b;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$j$a", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "task", "", "onTaskChange", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a extends ITaskListener.Stub {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TaskInfo f322890d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WinkPublishServiceProxy2 f322891e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Continuation<String> f322892f;

            /* JADX WARN: Multi-variable type inference failed */
            a(TaskInfo taskInfo, WinkPublishServiceProxy2 winkPublishServiceProxy2, Continuation<? super String> continuation) {
                this.f322890d = taskInfo;
                this.f322891e = winkPublishServiceProxy2;
                this.f322892f = continuation;
            }

            @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
            public void onTaskChange(@Nullable TaskInfo task) {
                TaskInfo taskInfo = this.f322890d;
                if (taskInfo != null && task != null && taskInfo.getTaskId() == task.getTaskId() && task.isFinish()) {
                    this.f322891e.removeTaskListener(this);
                    if (task.isSuccess()) {
                        this.f322892f.resumeWith(Result.m476constructorimpl(new FeedInfo(task.getFeedId(), String.valueOf(task.getFeedTime())).toJsonStr()));
                    } else {
                        w53.b.c("WinkAiPaintNativeExportManager", "publish failed");
                        Continuation<String> continuation = this.f322892f;
                        Result.Companion companion = Result.INSTANCE;
                        continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("Publish Failed"))));
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        j(WinkPublishParams winkPublishParams, Continuation<? super String> continuation) {
            this.f322888a = winkPublishParams;
            this.f322889b = continuation;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            service.addTaskListener2(new a(service.addTask(this.f322888a), service, this.f322889b));
        }
    }

    WinkAiPaintNativeExportManager() {
    }

    private final LocalMediaInfo C(String path) {
        boolean endsWith;
        endsWith = StringsKt__StringsJVMKt.endsWith(path, ".mp4", true);
        if (endsWith) {
            LocalMediaInfo d16 = ba3.a.d(path);
            Intrinsics.checkNotNullExpressionValue(d16, "{\n            LocalMedia\u2026sForVideo(path)\n        }");
            return d16;
        }
        LocalMediaInfo c16 = ba3.a.c(path);
        Intrinsics.checkNotNullExpressionValue(c16, "{\n            LocalMedia\u2026fosForPic(path)\n        }");
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(String str, Map<String, String> map, Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = f322863a;
        MetaMaterial T = winkAiPaintNativeExportManager.T(str);
        boolean q16 = WinkEditorResourceManager.a1().q(T);
        winkAiPaintNativeExportManager.g0(map, WinkDengtaReportConstant.Params.REPORT_PARAM_TEMPLATE_RES_READY, q16);
        if (q16) {
            safeContinuation.resumeWith(Result.m476constructorimpl(T));
        } else {
            WinkEditorResourceManager.a1().f0(T, new a(str, safeContinuation, T));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Object E(MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkEditorResourceManager.a1().h0(metaMaterial, new b(metaMaterial, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G() {
        String stackTraceToString;
        try {
            FileUtils.deleteFilesInDirectory(EXPORT_CACHE_DIR);
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            w53.b.c("WinkAiPaintNativeExportManager", "clearCache failed: " + stackTraceToString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String originPath, String targetPath, IQQWinkEditorResAPI.DownloadAiPaintVideoListener downloadListener) {
        if (FileUtils.copyFile(originPath, targetPath)) {
            downloadListener.onDownloaded(0, "success");
            return;
        }
        w53.b.c("WinkAiPaintNativeExportManager", "Failed to copy file. From " + originPath + " to " + targetPath);
        downloadListener.onDownloaded(-1, "failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(MetaMaterial material, String cacheDir) {
        String m3 = WinkEditorResourceManager.a1().m(material);
        String str = File.separator;
        String str2 = m3 + str + "pianwei.mp4";
        String str3 = cacheDir + str + "pianwei.mp4";
        if (!FileUtils.copyFile(str2, str3)) {
            w53.b.c("WinkAiPaintNativeExportManager", "Failed to copy file. From: " + str2 + ", to: " + str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String imageBase64Str, String savePath) {
        boolean contains$default;
        byte[] decode;
        List split$default;
        try {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) imageBase64Str, (CharSequence) "base64,", false, 2, (Object) null);
            if (contains$default) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) imageBase64Str, new String[]{"base64,"}, false, 0, 6, (Object) null);
                decode = PluginBaseInfoHelper.Base64Helper.decode((String) split$default.get(1), 0);
            } else {
                decode = PluginBaseInfoHelper.Base64Helper.decode(imageBase64Str, 0);
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            com.tencent.mobileqq.wink.utils.f.u(savePath, decodeByteArray, 100);
            decodeByteArray.recycle();
        } catch (Exception e16) {
            throw new AiPaintVideoException(-1, "decodeBase64ToImage failed: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L(String encryptedString) {
        return ak.f326673a.a(encryptedString, KeyPropertiesCompact.KEY_ALGORITHM_AES, "AES/ECB/NoPadding", cryptoKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(String str, String str2, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        y53.a.c().a(str, str2, new d(safeContinuation, str));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object O(List<Image> list, String str, Continuation<? super List<String>> continuation) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        BuildersKt__BuildersKt.runBlocking$default(null, new WinkAiPaintNativeExportManager$downloadImages$2(list, linkedHashMap, arrayList, str, null), 1, null);
        w53.b.f("WinkAiPaintNativeExportManager", "downloadImages costtime: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q(MetaMaterial metaMaterial, List<String> list, List<String> list2, String str, Map<String, String> map, Continuation<? super String> continuation) {
        WinkAiPaintNativeExportManager$exportVideo$1 winkAiPaintNativeExportManager$exportVideo$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        HashMap hashMap;
        String str2;
        MetaMaterial metaMaterial2;
        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager;
        ArrayList arrayList;
        HashMap hashMap2;
        long j3;
        Map<String, String> map2;
        String c16;
        try {
            if (continuation instanceof WinkAiPaintNativeExportManager$exportVideo$1) {
                winkAiPaintNativeExportManager$exportVideo$1 = (WinkAiPaintNativeExportManager$exportVideo$1) continuation;
                int i16 = winkAiPaintNativeExportManager$exportVideo$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    winkAiPaintNativeExportManager$exportVideo$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = winkAiPaintNativeExportManager$exportVideo$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = winkAiPaintNativeExportManager$exportVideo$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            long j16 = winkAiPaintNativeExportManager$exportVideo$1.J$0;
                            HashMap hashMap3 = (HashMap) winkAiPaintNativeExportManager$exportVideo$1.L$5;
                            ?? r65 = (List) winkAiPaintNativeExportManager$exportVideo$1.L$4;
                            map2 = (Map) winkAiPaintNativeExportManager$exportVideo$1.L$3;
                            String str3 = (String) winkAiPaintNativeExportManager$exportVideo$1.L$2;
                            MetaMaterial metaMaterial3 = (MetaMaterial) winkAiPaintNativeExportManager$exportVideo$1.L$1;
                            winkAiPaintNativeExportManager = (WinkAiPaintNativeExportManager) winkAiPaintNativeExportManager$exportVideo$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            hashMap2 = hashMap3;
                            arrayList = r65;
                            metaMaterial2 = metaMaterial3;
                            str2 = str3;
                            j3 = j16;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(f322863a.C((String) it.next()));
                        }
                        List<String> list3 = list2;
                        if (list3 != null && !list3.isEmpty()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            hashMap = null;
                        } else {
                            hashMap = new HashMap();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("textList", new JSONArray((Collection) list3));
                            hashMap.put(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, jSONObject.toString());
                        }
                        winkAiPaintNativeExportManager$exportVideo$1.L$0 = this;
                        winkAiPaintNativeExportManager$exportVideo$1.L$1 = metaMaterial;
                        str2 = str;
                        winkAiPaintNativeExportManager$exportVideo$1.L$2 = str2;
                        winkAiPaintNativeExportManager$exportVideo$1.L$3 = map;
                        winkAiPaintNativeExportManager$exportVideo$1.L$4 = arrayList2;
                        winkAiPaintNativeExportManager$exportVideo$1.L$5 = hashMap;
                        winkAiPaintNativeExportManager$exportVideo$1.J$0 = elapsedRealtime;
                        winkAiPaintNativeExportManager$exportVideo$1.label = 1;
                        if (E(metaMaterial, winkAiPaintNativeExportManager$exportVideo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        metaMaterial2 = metaMaterial;
                        winkAiPaintNativeExportManager = this;
                        arrayList = arrayList2;
                        hashMap2 = hashMap;
                        j3 = elapsedRealtime;
                        map2 = map;
                    }
                    String str4 = str2 + "/data.m";
                    p pVar = p.f325325a;
                    String uuid = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                    c16 = p.c(pVar, null, uuid, metaMaterial2, arrayList, str4, 720, 1280, hashMap2, null, 256, null);
                    if (c16 == null) {
                        winkAiPaintNativeExportManager.e0(map2, WinkDengtaReportConstant.Params.REPORT_EXPORT_VIDEO_TIME, j3);
                        return c16;
                    }
                    throw new AiPaintVideoException(3, "exportVideo Failed: outputPath is null");
                }
            }
            p pVar2 = p.f325325a;
            String uuid2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "randomUUID().toString()");
            c16 = p.c(pVar2, null, uuid2, metaMaterial2, arrayList, str4, 720, 1280, hashMap2, null, 256, null);
            if (c16 == null) {
            }
        } catch (Exception e16) {
            throw new AiPaintVideoException(3, "exportVideo Failed: " + e16);
        }
        winkAiPaintNativeExportManager$exportVideo$1 = new WinkAiPaintNativeExportManager$exportVideo$1(this, continuation);
        Object obj2 = winkAiPaintNativeExportManager$exportVideo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAiPaintNativeExportManager$exportVideo$1.label;
        if (i3 == 0) {
        }
        String str42 = str2 + "/data.m";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String R(String videoUrl, float extractFramePos, Map<String, String> reportParams) {
        String stackTraceToString;
        long j3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            mediaMetadataRetriever.setDataSource(videoUrl);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (extractMetadata != null) {
                j3 = Long.parseLong(extractMetadata) * 1000;
            } else {
                j3 = 0;
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(((float) j3) * extractFramePos);
            if (frameAtTime == null) {
                w53.b.c("WinkAiPaintNativeExportManager", "Failed to extractVideoCover");
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            frameAtTime.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
            frameAtTime.recycle();
            e0(reportParams, WinkDengtaReportConstant.Params.REPORT_GENERATE_IMAGE_TIME, elapsedRealtime);
            String str = "data:image/jpeg;base64," + PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            Intrinsics.checkNotNullExpressionValue(str, "encoded.toString()");
            return str;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            w53.b.c("WinkAiPaintNativeExportManager", "Failed to extract image: " + stackTraceToString);
            throw new AiPaintVideoException(4, String.valueOf(e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object S(Map<String, String> map, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(new f(map, elapsedRealtime, safeContinuation));
        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = f322863a;
        winkAiPaintNativeExportManager.g0(map, WinkDengtaReportConstant.Params.REPORT_PARAM_EDITOR_RES_READY, isCameraResReady);
        if (isCameraResReady) {
            WinkExportUtils.R();
            winkAiPaintNativeExportManager.e0(map, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_LIGHT_BUNDLE_TIME, elapsedRealtime);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    private final MetaMaterial T(String materialID) {
        ArrayList<MetaMaterial> arrayList;
        Object obj;
        MetaCategory metaCategory = templateMaterials;
        if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(materialID, ((MetaMaterial) obj).f30533id)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MetaMaterial metaMaterial = (MetaMaterial) obj;
            if (metaMaterial != null) {
                return metaMaterial;
            }
            throw new AiPaintVideoException(2, "templateMaterials is null or empty");
        }
        throw new AiPaintVideoException(2, materialID + " does not exist");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String U() {
        String str = EXPORT_CACHE_DIR + "/" + System.currentTimeMillis();
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, '.', 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String W(String filePath) {
        boolean z16;
        int lastIndexOf$default;
        if (filePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || lastIndexOf$default <= 0) {
            return "";
        }
        String substring = filePath.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    private final void X(DecodeAiPaintReqRequest request, IQQWinkEditorResAPI.AiPaintResponseListener listener, int retCode, String retMsg, String decodedReq) {
        listener.onResponse(request.getCallback(), new DecodeAiPaintReqResponse(retCode, retMsg, decodedReq).toJsonStr());
    }

    static /* synthetic */ void Y(WinkAiPaintNativeExportManager winkAiPaintNativeExportManager, DecodeAiPaintReqRequest decodeAiPaintReqRequest, IQQWinkEditorResAPI.AiPaintResponseListener aiPaintResponseListener, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            str2 = null;
        }
        winkAiPaintNativeExportManager.X(decodeAiPaintReqRequest, aiPaintResponseListener, i3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z(String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        String removeSuffix;
        List mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        removeSuffix = StringsKt__StringsKt.removeSuffix(str, (CharSequence) "data.mqr");
        String str2 = removeSuffix + "data.m";
        if (!FileUtils.fileExists(str2)) {
            w53.b.c("WinkAiPaintNativeExportManager", "mergeQrcodeVideo failed. Path does not exist: " + str2);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("originVideoPath does not exist"))));
        }
        String str3 = removeSuffix + "pianwei.mp4";
        if (!FileUtils.fileExists(str3)) {
            w53.b.g("WinkAiPaintNativeExportManager", "Path does not exist: " + str3);
            safeContinuation.resumeWith(Result.m476constructorimpl(str2));
        } else {
            WinkExportUtils.R();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TAVClip(new URLAsset(str2)), new TAVClip(new URLAsset(str3)));
            TAVComposition tAVComposition = new TAVComposition(mutableListOf, mutableListOf);
            tAVComposition.setRenderSize(new CGSize(720.0f, 1280.0f));
            TAVExporter tAVExporter = new TAVExporter();
            tAVExporter.setExportListener(new g(safeContinuation, str));
            tAVExporter.export(tAVComposition, str);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c0(String str, PublishVideoRequest publishVideoRequest, Continuation<? super String> continuation) {
        Continuation intercepted;
        HashMap hashMapOf;
        HashMap hashMapOf2;
        String str2;
        boolean z16;
        String str3;
        boolean z17;
        List mutableListOf;
        List mutableListOf2;
        List<? extends WinkPublishMediaRecord> mutableListOf3;
        List listOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        String str4 = "0";
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(QCircleLpReportDc05494.KEY_UP_TYPE, "0"), TuplesKt.to("up_source", "0"), TuplesKt.to(v4.b.CLIENTKEY, uuid));
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(v4.b.CLIENTKEY, uuid));
        String taskid = publishVideoRequest.getTaskid();
        if (taskid != null) {
            hashMapOf2.put("taskid", taskid);
        }
        PublishTeamInfo team_info = publishVideoRequest.getTeam_info();
        String str5 = "";
        if (team_info != null) {
            String id5 = team_info.getId();
            if (id5 == null) {
                id5 = "";
            }
            hashMapOf2.put("team_id", id5);
            String activity_id = team_info.getActivity_id();
            if (activity_id == null) {
                activity_id = "";
            }
            hashMapOf2.put("team_activity_id", activity_id);
        }
        String content = publishVideoRequest.getContent();
        if (content == null) {
            str2 = "";
        } else {
            str2 = content;
        }
        PublishQzoneInfo qzone_info = publishVideoRequest.getQzone_info();
        if (qzone_info != null) {
            z16 = qzone_info.getSync_to_qzone();
        } else {
            z16 = false;
        }
        String publisher_schema = publishVideoRequest.getPublisher_schema();
        if (publisher_schema == null) {
            str3 = "";
        } else {
            str3 = publisher_schema;
        }
        FeedParams feedParams = new FeedParams(null, str2, z16, false, false, str3, null, null, false, null, null, null, null, null, null, null, 0, null, hashMapOf2, hashMapOf, false, null, null, null, null, null, null, 133429209, null);
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, publishVideoRequest.getTaskid());
        PublishQzoneInfo qzone_info2 = publishVideoRequest.getQzone_info();
        if (qzone_info2 != null && qzone_info2.getSync_to_qzone()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            str4 = "1";
        }
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, str4);
        WinkPublishMediaRecord[] winkPublishMediaRecordArr = new WinkPublishMediaRecord[2];
        String[] strArr = new String[1];
        String material_id = publishVideoRequest.getMaterial_id();
        if (material_id == null) {
            material_id = "";
        }
        strArr[0] = material_id;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(strArr);
        winkPublishMediaRecordArr[0] = new WinkPublishMediaRecord("template", mutableListOf);
        String[] strArr2 = new String[1];
        String material_id2 = publishVideoRequest.getMaterial_id();
        if (material_id2 != null) {
            str5 = material_id2;
        }
        strArr2[0] = str5;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(strArr2);
        winkPublishMediaRecordArr[1] = new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, mutableListOf2);
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(winkPublishMediaRecordArr);
        LocalMediaInfo localMediaInfo = ba3.a.d(str);
        VideoParams.Companion companion = VideoParams.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
        VideoParams from = companion.from(localMediaInfo, mutableListOf3);
        String traceId = QCirclePublishQualityReporter.getTraceId();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(from);
        Intrinsics.checkNotNullExpressionValue(traceId, "getTraceId()");
        WinkPublishHelper2.INSTANCE.bindService(1, new j(new WinkPublishParams(1, uuid, traceId, false, 23, listOf, null, feedParams, bundle, null, 584, null), safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(3:3|(1:19)(1:7)|(5:9|10|(1:12)|13|(1:15)(2:17|18)))|20|21|10|(0)|13|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        w53.b.d("WinkAiPaintNativeExportManager", "[queryMaterials] exception: ", r1);
        r2 = kotlin.Result.INSTANCE;
        r0.resumeWith(kotlin.Result.m476constructorimpl(kotlin.ResultKt.createFailure(r1)));
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d0(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object orThrow;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        boolean z16;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        MetaCategory metaCategory = templateMaterials;
        if (metaCategory != null) {
            Intrinsics.checkNotNull(metaCategory);
            ArrayList<MetaMaterial> arrayList = metaCategory.materials;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Result.Companion companion = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                orThrow = safeContinuation.getOrThrow();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (orThrow == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (orThrow != coroutine_suspended2) {
                    return orThrow;
                }
                return Unit.INSTANCE;
            }
        }
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkAiPaintNativeMaterialServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeMaterialServiceHandler");
        WinkAiPaintNativeMaterialServiceHandler winkAiPaintNativeMaterialServiceHandler = (WinkAiPaintNativeMaterialServiceHandler) businessHandler;
        winkAiPaintNativeMaterialServiceHandler.r3(new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$queryMaterials$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<MetaCategory> list) {
                MetaCategory metaCategory2 = null;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "AiPaintNativeMaterial")) {
                            metaCategory2 = next;
                            break;
                        }
                    }
                    metaCategory2 = metaCategory2;
                }
                if (metaCategory2 != null) {
                    WinkAiPaintNativeExportManager.templateMaterials = metaCategory2;
                    WinkAiPaintNativeExportManager.cryptoKey = com.tencent.mobileqq.wink.editor.b.a(metaCategory2);
                    Continuation<Unit> continuation2 = safeContinuation;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                    return;
                }
                Continuation<Unit> continuation3 = safeContinuation;
                Result.Companion companion3 = Result.INSTANCE;
                continuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new WinkAiPaintNativeExportManager.AiPaintVideoException(2, "templateMaterials is null"))));
            }
        });
        winkAiPaintNativeMaterialServiceHandler.m3("H5NativeExportMaterial");
        orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(Map<String, String> reportParams, String key, long startTime) {
        reportParams.put(key, String.valueOf(SystemClock.elapsedRealtime() - startTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Map<String, String> reportParams, String key, int value) {
        reportParams.put(key, String.valueOf(value));
    }

    private final void g0(Map<String, String> reportParams, String key, boolean value) {
        String str;
        if (value) {
            str = "1";
        } else {
            str = "0";
        }
        reportParams.put(key, str);
    }

    public final void F() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.h5native.a
            @Override // java.lang.Runnable
            public final void run() {
                WinkAiPaintNativeExportManager.G();
            }
        }, 64, null, false);
    }

    public final void J(@NotNull String requestJson, @NotNull IQQWinkEditorResAPI.AiPaintResponseListener listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        w53.b.f("WinkAiPaintNativeExportManager", "decodeAiPaintReq");
        DecodeAiPaintReqRequest fromJsonStr = DecodeAiPaintReqRequest.INSTANCE.fromJsonStr(requestJson);
        if (fromJsonStr == null) {
            return;
        }
        SafeReq fromJsonStr2 = SafeReq.INSTANCE.fromJsonStr(L(fromJsonStr.getSafeReq()));
        String L = L(fromJsonStr.getEncodedReq());
        EncodedReq fromJsonStr3 = EncodedReq.INSTANCE.fromJsonStr(L);
        if (fromJsonStr2 != null && fromJsonStr3 != null) {
            if (!fromJsonStr2.getSafeInfo().isLegal()) {
                Y(this, fromJsonStr, listener, 7, "safe req illegal", null, 16, null);
                return;
            } else if (Intrinsics.areEqual(fromJsonStr2.getTraceID(), fromJsonStr3.getTraceID())) {
                X(fromJsonStr, listener, 0, "success", L);
                return;
            } else {
                Y(this, fromJsonStr, listener, 8, "traceID inconsistent", null, 16, null);
                return;
            }
        }
        Y(this, fromJsonStr, listener, 6, "decrypt failed", null, 16, null);
    }

    public final void M(@NotNull String videoUrl, @NotNull String savePath, @NotNull IQQWinkEditorResAPI.DownloadAiPaintVideoListener listener) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(videoUrl, "https://qqcircle_aipainting_native_export.qq.com/local_files", false, 2, null);
        if (!startsWith$default) {
            w53.b.c("WinkAiPaintNativeExportManager", "downloadVideo failed. invalid url: " + videoUrl);
            listener.onDownloaded(-1, "invalid url");
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), new c(CoroutineExceptionHandler.INSTANCE, listener), null, new WinkAiPaintNativeExportManager$downloadAiPaintVideo$1(videoUrl, savePath, listener, null), 2, null);
    }

    public final void P(@NotNull String requestJson) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        w53.b.f("WinkAiPaintNativeExportManager", "exportAiPaintVideoAsync");
        ExportAiPaintVideoAsyncRequest fromJsonStr = ExportAiPaintVideoAsyncRequest.INSTANCE.fromJsonStr(requestJson);
        if (fromJsonStr == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), new e(CoroutineExceptionHandler.INSTANCE, linkedHashMap), null, new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1(fromJsonStr, linkedHashMap, null), 2, null);
        currentExportJob = launch$default;
    }

    public final void V(@NotNull String requestJson, @NotNull IQQWinkEditorResAPI.AiPaintResponseListener listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        w53.b.f("WinkAiPaintNativeExportManager", "getExportAiPaintVideoResult");
        GetExportAiPaintVideoResultRequest fromJsonStr = GetExportAiPaintVideoResultRequest.INSTANCE.fromJsonStr(requestJson);
        if (fromJsonStr == null) {
            return;
        }
        SafeReq fromJsonStr2 = SafeReq.INSTANCE.fromJsonStr(L(fromJsonStr.getSafeReq()));
        if (fromJsonStr2 == null) {
            listener.onResponse(fromJsonStr.getCallback(), new GetExportAiPaintVideoResultResponse(6, "decrypt failed", null, null, null, 28, null).toJsonStr());
        } else if (fromJsonStr2.getSafeInfo().isLegal()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1(fromJsonStr2, listener, fromJsonStr, null), 3, null);
        } else {
            listener.onResponse(fromJsonStr.getCallback(), new GetExportAiPaintVideoResultResponse(7, "safe req illegal", null, null, null, 28, null).toJsonStr());
        }
    }

    public final void a0(@NotNull String requestJson) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        PreloadAiPaintResRequest fromJsonStr = PreloadAiPaintResRequest.INSTANCE.fromJsonStr(requestJson);
        if (fromJsonStr == null) {
            return;
        }
        h hVar = new h(CoroutineExceptionHandler.INSTANCE);
        WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(winkCoroutineScopes.c()), hVar, null, new WinkAiPaintNativeExportManager$preloadAiPaintRes$1(null), 2, null);
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(winkCoroutineScopes.c()), hVar, null, new WinkAiPaintNativeExportManager$preloadAiPaintRes$2(fromJsonStr, null), 2, null);
        queryMaterialJob = launch$default;
    }

    public final void b0(@NotNull String requestJson, @NotNull IQQWinkEditorResAPI.AiPaintResponseListener listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PublishVideoRequest fromJsonStr = PublishVideoRequest.INSTANCE.fromJsonStr(requestJson);
        if (fromJsonStr == null) {
            return;
        }
        w53.b.f("WinkAiPaintNativeExportManager", "publishAiPaintVideo, videoUrl: " + fromJsonStr.getVideoUrl());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), new i(CoroutineExceptionHandler.INSTANCE, listener, fromJsonStr), null, new WinkAiPaintNativeExportManager$publishAiPaintVideo$1(fromJsonStr, listener, null), 2, null);
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$g", "Lcom/tencent/tavkit/component/TAVExporter$ExportListener;", "", "onExportStart", "", "progress", "", QFSEdgeItem.KEY_VIDEO_TIME, "audioTime", "totalTime", "onExporting", "onExportCancel", "", "exportPath", "onExportCompleted", "Lcom/tencent/tav/core/AssetExportSession;", "assetExportSession", "onExportError", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements TAVExporter.ExportListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f322884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f322885b;

        /* JADX WARN: Multi-variable type inference failed */
        g(Continuation<? super String> continuation, String str) {
            this.f322884a = continuation;
            this.f322885b = str;
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportCompleted(@Nullable String exportPath) {
            Continuation<String> continuation = this.f322884a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(this.f322885b));
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportError(@Nullable AssetExportSession assetExportSession) {
            w53.b.c("WinkAiPaintNativeExportManager", "exportVideo Failed: " + assetExportSession);
            Continuation<String> continuation = this.f322884a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException(String.valueOf(assetExportSession)))));
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportCancel() {
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportStart() {
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExporting(float progress, long videoTime, long audioTime, long totalTime) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$a", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f322872a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<MetaMaterial> f322873b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322874c;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Continuation<? super MetaMaterial> continuation, MetaMaterial metaMaterial) {
            this.f322872a = str;
            this.f322873b = continuation;
            this.f322874c = metaMaterial;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            w53.b.f("WinkAiPaintNativeExportManager", "download material " + this.f322872a + MsgSummary.STR_COLON + isSuccess);
            if (isSuccess) {
                Continuation<MetaMaterial> continuation = this.f322873b;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(this.f322874c));
                return;
            }
            Continuation<MetaMaterial> continuation2 = this.f322873b;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new AiPaintVideoException(2, "download " + this.f322872a + " failed"))));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322875a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f322876b;

        /* JADX WARN: Multi-variable type inference failed */
        b(MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
            this.f322875a = metaMaterial;
            this.f322876b = continuation;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                WinkEditorResourceManager.a1().i0(this.f322875a);
                Continuation<Boolean> continuation = this.f322876b;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            w53.b.c("WinkAiPaintNativeExportManager", "checkAndDownloadTemplateFont failed");
            Continuation<Boolean> continuation2 = this.f322876b;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeExportManager$d", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Unit> f322878a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f322879b;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super Unit> continuation, String str) {
            this.f322878a = continuation;
            this.f322879b = str;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            Integer num;
            if (resp != null && resp.mResult == 0) {
                Continuation<Unit> continuation = this.f322878a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                return;
            }
            String str = this.f322879b;
            if (resp != null) {
                num = Integer.valueOf(resp.mErrCode);
            } else {
                num = null;
            }
            String str2 = "downloadImage " + str + " failed, ErrorCode: " + num;
            w53.b.c("WinkAiPaintNativeExportManager", str2);
            Continuation<Unit> continuation2 = this.f322878a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new AiPaintVideoException(-1, str2))));
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }
}

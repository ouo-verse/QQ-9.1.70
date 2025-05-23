package com.tencent.mobileqq.wink.picker.core.viewmodel;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.play.api.IFaceChangeUtils;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.decode.LibraBitmapFactoryDecodeTask;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.storage.album.WinkAlbumRoomDatabase;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tav.core.AssetExtension;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import ha3.PhotoFace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b/\u0018\u0000 \u0093\u00012\u00020\u0001:\u0004\u0094\u0001\u0095\u0001B\t\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J(\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\n\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&J\u0006\u0010*\u001a\u00020\u0002J\u0014\u0010,\u001a\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'J\"\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040&2\u0006\u0010.\u001a\u00020-H\u0016J\u0006\u00100\u001a\u00020\u0002J\u0006\u00101\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0017J\u0006\u00103\u001a\u00020\u0017J\u000e\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0017R&\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R)\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040&8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER \u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00108R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bM\u0010>R#\u0010T\u001a\n P*\u0004\u0018\u00010O0O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010XR\u001d\u0010]\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010Q\u001a\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR0\u0010j\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f`g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010>R\u0016\u0010n\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010VR\u0016\u0010q\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010s\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010pR\u0016\u0010u\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010VR\u0016\u0010w\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010VR\u0016\u0010y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010>R\u0016\u0010{\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010>R\u0016\u0010}\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010>R\u0016\u0010\u007f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010VR\u0017\u0010\u0080\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010>R\u0018\u0010\u0082\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010VR\u0018\u0010\u0084\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010>R\u0018\u0010\u0086\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010VR(\u0010\u008c\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0087\u0001\u0010p\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010\u0090\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u008d\u0001\u0010p\u001a\u0006\b\u008e\u0001\u0010\u0089\u0001\"\u0006\b\u008f\u0001\u0010\u008b\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalImageForFaceDetectViewModel;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;", "", "o2", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "uiStateData", "r2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "copyUiStateData", ICustomDataEditor.STRING_PARAM_2, "", "totalSize", "batchSize", "faceSize", "", VasPerfReportUtils.WHILE_COST_TOTAL, "t2", "", "l2", "p2", "localMediaInfo", "", "W1", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/lang/Boolean;", "index", "image", "Z1", "Landroid/graphics/Bitmap;", "X1", ICustomDataEditor.NUMBER_PARAM_2, "m2", "g2", AssetExtension.SCENE_THUMBNAIL, "d2", "Lcom/gyailib/library/GYAIFace;", "i2", "Landroidx/lifecycle/LiveData;", "", "Lha3/a;", "e2", "T1", "list", "u2", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "getMediaUIState", "y2", "z2", "q2", "c2", "needJumpToCapture", "w2", "Landroidx/lifecycle/MediatorLiveData;", "i", "Landroidx/lifecycle/MediatorLiveData;", "imagesLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "detectedImages", BdhLogUtil.LogTag.Tag_Conn, "I", "lastUIIndex", "D", "lastReportIndex", "E", "Landroidx/lifecycle/LiveData;", "k2", "()Landroidx/lifecycle/LiveData;", "imagesLiveDataObserve", UserInfo.SEX_FEMALE, "_allPhotoFaces", "", "G", "Ljava/lang/Object;", "detectLock", "H", "thumbnailSize", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", SemanticAttributes.DbSystemValues.H2, "()Landroid/content/ContentResolver;", "contentResolver", "Lcom/tencent/aelight/camera/play/api/IFaceChangeUtils;", "J", "getFaceUtils", "()Lcom/tencent/aelight/camera/play/api/IFaceChangeUtils;", "faceUtils", "K", "j2", "()Lcom/gyailib/library/GYAIFace;", "gyAIFace", "Lcom/gyailib/library/FaceDetector;", "L", "Lcom/gyailib/library/FaceDetector;", "faceDetectorCommon", "Lda3/a;", "M", "Lda3/a;", "photoFaceDao", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "N", "Ljava/util/HashMap;", "imagesFromDb", "P", "dbSize", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "startMsLoadDb", BdhLogUtil.LogTag.Tag_Req, "Z", "isNeedJumpToCapture", ExifInterface.LATITUDE_SOUTH, "isFirstReport", "T", "decodeFaceTime", "U", "checkFaceTime", "V", "checkFaceCount", "W", "hitCacheCount", "X", "getThumbByLibraCacheCount", "Y", "getThumbByLibraCacheCost", "getThumbByContentResolverCount", "a0", "getThumbByContentResolverCost", "b0", "getBitmapWithSizeCount", "c0", "getBitmapWithSizeCost", "d0", "getClickCancel", "()Z", "v2", "(Z)V", "clickCancel", "e0", "getHasExit", "x2", "hasExit", "<init>", "()V", "f0", "BitmapFactoryDecodeTask", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLocalImageForFaceDetectViewModel extends WinkLocalMediaViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private volatile int lastUIIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastReportIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<LocalMediaInfo>>> imagesLiveDataObserve;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<PhotoFace>> _allPhotoFaces;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Object detectLock;

    /* renamed from: H, reason: from kotlin metadata */
    private final int thumbnailSize;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentResolver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy faceUtils;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy gyAIFace;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final FaceDetector faceDetectorCommon;

    /* renamed from: M, reason: from kotlin metadata */
    private da3.a photoFaceDao;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Long, Integer> imagesFromDb;

    /* renamed from: P, reason: from kotlin metadata */
    private int dbSize;

    /* renamed from: Q, reason: from kotlin metadata */
    private long startMsLoadDb;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isNeedJumpToCapture;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isFirstReport;

    /* renamed from: T, reason: from kotlin metadata */
    private long decodeFaceTime;

    /* renamed from: U, reason: from kotlin metadata */
    private long checkFaceTime;

    /* renamed from: V, reason: from kotlin metadata */
    private int checkFaceCount;

    /* renamed from: W, reason: from kotlin metadata */
    private int hitCacheCount;

    /* renamed from: X, reason: from kotlin metadata */
    private int getThumbByLibraCacheCount;

    /* renamed from: Y, reason: from kotlin metadata */
    private long getThumbByLibraCacheCost;

    /* renamed from: Z, reason: from kotlin metadata */
    private int getThumbByContentResolverCount;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long getThumbByContentResolverCost;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int getBitmapWithSizeCount;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long getBitmapWithSizeCost;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean clickCancel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasExit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> imagesLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> detectedImages;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalImageForFaceDetectViewModel$BitmapFactoryDecodeTask;", "Lcom/tencent/libra/decode/LibraBitmapFactoryDecodeTask;", "", "getLogTag", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class BitmapFactoryDecodeTask extends LibraBitmapFactoryDecodeTask {
        final /* synthetic */ WinkLocalImageForFaceDetectViewModel this$0;

        @Override // com.tencent.libra.decode.LibraBitmapFactoryDecodeTask, com.tencent.libra.task.ILibraTask
        @NotNull
        public String getLogTag() {
            return "WinkLocalImageForFaceDetectViewModel";
        }
    }

    public WinkLocalImageForFaceDetectViewModel() {
        super(MediaType.LOCAL_IMAGE);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData = new MediatorLiveData<>();
        this.imagesLiveData = mediatorLiveData;
        this.detectedImages = new ArrayList();
        this.imagesLiveDataObserve = mediatorLiveData;
        this._allPhotoFaces = new MediatorLiveData<>();
        this.detectLock = new Object();
        this.thumbnailSize = 300;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ContentResolver>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel$contentResolver$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContentResolver invoke() {
                return BaseApplication.context.getContentResolver();
            }
        });
        this.contentResolver = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IFaceChangeUtils>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel$faceUtils$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IFaceChangeUtils invoke() {
                return (IFaceChangeUtils) QRoute.api(IFaceChangeUtils.class);
            }
        });
        this.faceUtils = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GYAIFace>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel$gyAIFace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GYAIFace invoke() {
                GYAIFace i26;
                i26 = WinkLocalImageForFaceDetectViewModel.this.i2();
                return i26;
            }
        });
        this.gyAIFace = lazy3;
        this.faceDetectorCommon = new FaceDetector();
        this.imagesFromDb = new HashMap<>();
        this.isFirstReport = true;
        o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Boolean W1(LocalMediaInfo localMediaInfo) {
        boolean z16;
        if (this.imagesFromDb.containsKey(Long.valueOf(localMediaInfo._id))) {
            Integer num = this.imagesFromDb.get(Long.valueOf(localMediaInfo._id));
            if (num == null || num.intValue() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            valueOf.booleanValue();
            this.hitCacheCount++;
            return valueOf;
        }
        return null;
    }

    private final Bitmap X1(int index, LocalMediaInfo image) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap n26 = n2(index, image);
        if (n26 == null && (n26 = m2(index, image)) == null) {
            n26 = g2(index, image);
        }
        this.decodeFaceTime += System.currentTimeMillis() - currentTimeMillis;
        w53.b.f("WinkLocalImageForFaceDetectViewModel", index + "-[decodeThumbnail] cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return n26;
    }

    private final int Z1(int index, LocalMediaInfo image) {
        Bitmap X1 = X1(index, image);
        if (X1 == null) {
            w53.b.g("WinkLocalImageForFaceDetectViewModel", "thumbnail == null");
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int d26 = d2(index, X1);
        this.checkFaceTime += System.currentTimeMillis() - currentTimeMillis;
        this.checkFaceCount++;
        X1.recycle();
        return d26;
    }

    private final void a2(final UIStateData<List<LocalMediaInfo>> uiStateData) {
        if (!com.tencent.mobileqq.wink.l.d()) {
            w53.b.f("WinkLocalImageForFaceDetectViewModel", "Library not Loaded");
            this.imagesLiveData.postValue(uiStateData);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.g
                @Override // java.lang.Runnable
                public final void run() {
                    WinkLocalImageForFaceDetectViewModel.b2(WinkLocalImageForFaceDetectViewModel.this, uiStateData);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(WinkLocalImageForFaceDetectViewModel this$0, UIStateData uiStateData) {
        List<LocalMediaInfo> list;
        UIStateData<List<LocalMediaInfo>> uIStateData;
        UIStateData<List<LocalMediaInfo>> uIStateData2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uiStateData, "$uiStateData");
        synchronized (this$0.detectLock) {
            long currentTimeMillis = System.currentTimeMillis();
            this$0.detectedImages.clear();
            UIStateData<List<LocalMediaInfo>> copy = uiStateData.copy();
            List<LocalMediaInfo> data = copy.getData();
            Intrinsics.checkNotNullExpressionValue(data, "copyUiStateData.data");
            list = CollectionsKt___CollectionsKt.toList(data);
            int i3 = this$0.hitCacheCount;
            int i16 = this$0.getThumbByLibraCacheCount;
            long j3 = this$0.getThumbByLibraCacheCost;
            int i17 = this$0.getThumbByContentResolverCount;
            long j16 = this$0.getThumbByContentResolverCost;
            int i18 = this$0.getBitmapWithSizeCount;
            long j17 = this$0.getBitmapWithSizeCost;
            StringBuilder sb5 = new StringBuilder();
            UIStateData<List<LocalMediaInfo>> uIStateData3 = copy;
            sb5.append("hitCacheCount: ");
            sb5.append(i3);
            sb5.append(", getThumbByLibraCacheCount: ");
            sb5.append(i16);
            sb5.append(", getThumbByLibraCacheCost: ");
            sb5.append(j3);
            sb5.append(", getThumbByContentResolverCount: ");
            sb5.append(i17);
            sb5.append(", getThumbByContentResolverCost: ");
            sb5.append(j16);
            sb5.append(", getBitmapWithSizeCount: ");
            sb5.append(i18);
            sb5.append(", getBitmapWithSizeCost: ");
            sb5.append(j17);
            w53.b.f("WinkLocalImageForFaceDetectViewModel", sb5.toString());
            w53.b.f("WinkLocalImageForFaceDetectViewModel", "doFaceDetect... size:" + list.size());
            int i19 = 0;
            for (LocalMediaInfo localMediaInfo : list) {
                int i26 = i19 + 1;
                if (!this$0.clickCancel && !this$0.hasExit) {
                    Boolean W1 = this$0.W1(localMediaInfo);
                    if (Intrinsics.areEqual(W1, Boolean.TRUE)) {
                        this$0.detectedImages.add(localMediaInfo);
                    } else if (W1 == null) {
                        int Z1 = this$0.Z1(i19, localMediaInfo);
                        this$0.imagesFromDb.put(Long.valueOf(localMediaInfo._id), Integer.valueOf(Z1));
                        if (Z1 != 0) {
                            this$0.detectedImages.add(localMediaInfo);
                        }
                    }
                    if (i26 % 100 == 0 && i19 >= this$0.lastUIIndex && i19 != 0 && this$0.detectedImages.size() != 0) {
                        if (this$0.q2()) {
                            this$0.lastUIIndex = i19;
                            uIStateData2 = uIStateData3;
                            uIStateData2.setDataList(this$0.detectedImages);
                            w53.b.f("WinkLocalImageForFaceDetectViewModel", "post-UI isFirstReport:" + this$0.isFirstReport + " lastUIInDex = " + this$0.lastUIIndex + " detectedImages.size:" + this$0.detectedImages.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                            this$0.imagesLiveData.postValue(uIStateData2);
                        } else {
                            uIStateData2 = uIStateData3;
                        }
                        if (this$0.isFirstReport) {
                            this$0.lastReportIndex = i19;
                            this$0.t2(i19 + 1, list.size(), this$0.detectedImages.size(), System.currentTimeMillis() - currentTimeMillis);
                            this$0.isFirstReport = false;
                        }
                    } else {
                        uIStateData2 = uIStateData3;
                    }
                    i19 = i26;
                    uIStateData3 = uIStateData2;
                }
                uIStateData = uIStateData3;
                w53.b.g("WinkLocalImageForFaceDetectViewModel", "clickCancel:" + this$0.clickCancel + " hasExit:" + this$0.hasExit);
            }
            uIStateData = uIStateData3;
            boolean isFinish = uIStateData.getIsFinish();
            int size = list.size();
            int size2 = this$0.detectedImages.size();
            int i27 = this$0.lastUIIndex;
            int i28 = this$0.lastReportIndex;
            long j18 = this$0.decodeFaceTime;
            long j19 = this$0.checkFaceTime;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb6 = new StringBuilder();
            UIStateData<List<LocalMediaInfo>> copyUiStateData = uIStateData;
            sb6.append("Complete... isFinish:");
            sb6.append(isFinish);
            sb6.append(" data size:");
            sb6.append(size);
            sb6.append(" detectedImages: ");
            sb6.append(size2);
            sb6.append(" lastUIInDex = ");
            sb6.append(i27);
            sb6.append(" lastReportIndex:");
            sb6.append(i28);
            sb6.append(" decodeFaceTime:");
            sb6.append(j18);
            sb6.append(" checkFaceTime:");
            sb6.append(j19);
            sb6.append(" All cost:");
            sb6.append(currentTimeMillis2);
            w53.b.f("WinkLocalImageForFaceDetectViewModel", sb6.toString());
            if (this$0.lastReportIndex != list.size() - 1) {
                this$0.lastReportIndex = list.size() - 1;
                this$0.t2(list.size(), list.size(), this$0.detectedImages.size(), System.currentTimeMillis() - currentTimeMillis);
            }
            Intrinsics.checkNotNullExpressionValue(copyUiStateData, "copyUiStateData");
            this$0.s2(copyUiStateData);
            this$0.p2();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final int d2(int index, Bitmap thumbnail) {
        long currentTimeMillis = System.currentTimeMillis();
        GYAIFace j26 = j2();
        int i3 = 0;
        if (j26 != null) {
            j26.forwardDetect(thumbnail, this.faceDetectorCommon, 0);
        }
        GYAIFace j27 = j2();
        if (j27 != null) {
            j27.clearCachedData();
        }
        FaceDetectorFeature[] faceDetectorFeatureArr = this.faceDetectorCommon.faces;
        if (faceDetectorFeatureArr != null) {
            i3 = faceDetectorFeatureArr.length;
        }
        w53.b.f("WinkLocalImageForFaceDetectViewModel", index + "-[forward] " + i3 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Bitmap g2(int index, LocalMediaInfo image) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = image.path;
        int i3 = this.thumbnailSize;
        Bitmap j3 = com.tencent.mobileqq.wink.utils.f.j(str, i3, i3, false);
        if (j3 != null) {
            this.getBitmapWithSizeCount++;
            this.getBitmapWithSizeCost += System.currentTimeMillis() - currentTimeMillis;
            w53.b.f("WinkLocalImageForFaceDetectViewModel", index + "-[getBitmapWithSize] cost=" + (System.currentTimeMillis() - currentTimeMillis));
            return j3;
        }
        return null;
    }

    private final ContentResolver h2() {
        return (ContentResolver) this.contentResolver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GYAIFace i2() {
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_FACE)) {
            w53.b.f("WinkLocalImageForFaceDetectViewModel", "[getGYAIFaceInstance] LIGHT_RES_BUNDLE_FACE not exist");
            return null;
        }
        GYAIFace gYAIFace = new GYAIFace();
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice(PreDownloadConstants.RPORT_KEY_CPU);
        int initInstance = gYAIFace.initInstance(sDKDeviceConfig);
        if (initInstance != 0) {
            w53.b.c("WinkLocalImageForFaceDetectViewModel", "[getGYAIFaceInstance] initInstance error, ret:" + initInstance);
            return null;
        }
        QRouteApi api = QRoute.api(IAEResUtil.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAEResUtil::class.java)");
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        String lightBundleDir = ((IAEResUtil) api).getLightBundleDir("FACE_AGENT");
        Intrinsics.checkNotNullExpressionValue(lightBundleDir, "aeResUtil.getLightBundle\u2026nts.AgentType.FACE_AGENT)");
        hashMap.put("root-path", lightBundleDir);
        sDKModelConfig.modelPaths = hashMap;
        gYAIFace.setupWithModel(sDKModelConfig);
        return gYAIFace;
    }

    private final GYAIFace j2() {
        return (GYAIFace) this.gyAIFace.getValue();
    }

    private final String l2(int batchSize) {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        Map mapOf4;
        Map mapOf5;
        Map mapOf6;
        Map mapOf7;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("count", Integer.valueOf(this.hitCacheCount)));
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("count", Integer.valueOf(this.getThumbByLibraCacheCount)), TuplesKt.to(QCircleWeakNetReporter.KEY_COST, Long.valueOf(this.getThumbByLibraCacheCost)));
        mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("count", Integer.valueOf(this.getThumbByContentResolverCount)), TuplesKt.to(QCircleWeakNetReporter.KEY_COST, Long.valueOf(this.getThumbByContentResolverCost)));
        mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to("count", Integer.valueOf(this.getBitmapWithSizeCount)), TuplesKt.to(QCircleWeakNetReporter.KEY_COST, Long.valueOf(this.getBitmapWithSizeCost)));
        mapOf5 = MapsKt__MapsKt.mapOf(TuplesKt.to("count", Integer.valueOf(this.checkFaceCount)), TuplesKt.to(QCircleWeakNetReporter.KEY_COST, Long.valueOf(this.checkFaceTime)));
        mapOf6 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("size", Integer.valueOf(batchSize)));
        mapOf7 = MapsKt__MapsKt.mapOf(TuplesKt.to("hitCacheCount", mapOf), TuplesKt.to("getThumbByLibra", mapOf2), TuplesKt.to("getThumbByContentResolver", mapOf3), TuplesKt.to("getBitmapWithSize", mapOf4), TuplesKt.to("checkFace", mapOf5), TuplesKt.to("batchSize", mapOf6));
        String json = new Gson().toJson(mapOf7);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(data)");
        return json;
    }

    private final Bitmap m2(int index, LocalMediaInfo image) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(h2(), image._id, 1, null);
        if (thumbnail == null) {
            return null;
        }
        this.getThumbByContentResolverCount++;
        this.getThumbByContentResolverCost += System.currentTimeMillis() - currentTimeMillis;
        w53.b.f("WinkLocalImageForFaceDetectViewModel", index + "-[getThumbByContentResolver] cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return thumbnail;
    }

    private final Bitmap n2(int index, LocalMediaInfo image) {
        LibraPicLoader libraPicLoader;
        String str;
        int i3;
        Bitmap j3;
        long currentTimeMillis = System.currentTimeMillis();
        IPicLoader d16 = QQPicLoader.f201806a.d();
        if (d16 instanceof LibraPicLoader) {
            libraPicLoader = (LibraPicLoader) d16;
        } else {
            libraPicLoader = null;
        }
        if (libraPicLoader != null) {
            Option obtain = Option.obtain();
            obtain.setLocalPath(image.path);
            str = libraPicLoader.getLocalSmallBitmapPath(obtain, this.thumbnailSize);
        } else {
            str = null;
        }
        if (str == null || (j3 = com.tencent.mobileqq.wink.utils.f.j(str, (i3 = this.thumbnailSize), i3, false)) == null) {
            return null;
        }
        this.getThumbByLibraCacheCount++;
        this.getThumbByLibraCacheCost += System.currentTimeMillis() - currentTimeMillis;
        w53.b.f("WinkLocalImageForFaceDetectViewModel", index + "-[getThumbByLibraCache] cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return j3;
    }

    private final void o2() {
        da3.a e16 = WinkAlbumRoomDatabase.d(BaseApplication.context).e();
        Intrinsics.checkNotNullExpressionValue(e16, "getInstance(MobileQQ.context).photoFaceDao()");
        this.photoFaceDao = e16;
    }

    private final void p2() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<Long, Integer> hashMap = this.imagesFromDb;
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
            arrayList.add(new PhotoFace(entry.getKey().longValue(), entry.getValue().intValue()));
        }
        da3.a aVar = this.photoFaceDao;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoFaceDao");
            aVar = null;
        }
        aVar.insertAll(arrayList);
        w53.b.f("WinkLocalImageForFaceDetectViewModel", "insertMemoryToDb size:" + arrayList.size() + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(UIStateData<List<LocalMediaInfo>> uiStateData) {
        w53.b.f("WinkLocalImageForFaceDetectViewModel", "onImagesChanged... currentAlbumId:" + getCurrentAlbumId());
        if (uiStateData.getState() == 0) {
            this.imagesLiveData.postValue(uiStateData);
            return;
        }
        if (q2()) {
            w53.b.f("WinkLocalImageForFaceDetectViewModel", "onImagesChanged... face Detect uiStateData size:" + uiStateData.getData().size());
            a2(uiStateData);
            return;
        }
        this.imagesLiveData.postValue(uiStateData);
    }

    private final void s2(UIStateData<List<LocalMediaInfo>> copyUiStateData) {
        if (!q2()) {
            w53.b.g("WinkLocalImageForFaceDetectViewModel", "postUpdateUI... not Open Face Check");
            return;
        }
        if (copyUiStateData.getIsFinish()) {
            if (this.detectedImages.size() == 0) {
                this.imagesLiveData.postValue(UIStateData.obtainEmpty().setDataList(new ArrayList()).setFinish(true));
                return;
            } else {
                copyUiStateData.setDataList(this.detectedImages);
                this.imagesLiveData.postValue(copyUiStateData);
                return;
            }
        }
        if (this.detectedImages.size() != 0) {
            copyUiStateData.setDataList(this.detectedImages);
            this.imagesLiveData.postValue(copyUiStateData);
        } else {
            w53.b.g("WinkLocalImageForFaceDetectViewModel", "postUpdateUI... detectedImages size = 0");
        }
    }

    private final void t2(int totalSize, int batchSize, int faceSize, long totalCost) {
        int i3;
        long j3;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.clickCancel) {
                i3 = -1;
            } else if (this.hasExit) {
                i3 = 2;
            } else if (this.isFirstReport) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i16 = this.getThumbByLibraCacheCount;
            int i17 = this.getThumbByContentResolverCount;
            long j16 = 0;
            if (i16 + i17 + this.getBitmapWithSizeCount != 0) {
                j3 = ((this.getThumbByLibraCacheCost + this.getThumbByContentResolverCost) + this.getBitmapWithSizeCost) / ((i16 + i17) + r5);
            } else {
                j3 = 0;
            }
            int i18 = this.checkFaceCount;
            if (i18 != 0) {
                j16 = this.checkFaceTime / i18;
            }
            WinkPublishQualityReportData.Builder retCode = new WinkPublishQualityReportData.Builder().eventId("E_PICKER_FACE_CLUSTER_RESULT").retCode(String.valueOf(i3));
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData reportData = retCode.traceId(companion2.d().getTraceId()).ext1(String.valueOf(totalCost)).ext2(String.valueOf(totalSize)).ext3(String.valueOf(faceSize)).ext4(String.valueOf(this.dbSize)).ext5(String.valueOf(j3)).ext6(String.valueOf(j16)).attachInfo(l2(batchSize)).getReportData();
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, companion2.d().k().b());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final void T1() {
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData = this.imagesLiveData;
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaUIStateLiveData = getMediaUIStateLiveData(MediaType.LOCAL_IMAGE);
        final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel$addImageChangeSource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<LocalMediaInfo>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> it) {
                WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel = WinkLocalImageForFaceDetectViewModel.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkLocalImageForFaceDetectViewModel.r2(it);
            }
        };
        mediatorLiveData.addSource(mediaUIStateLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkLocalImageForFaceDetectViewModel.U1(Function1.this, obj);
            }
        });
    }

    /* renamed from: c2, reason: from getter */
    public final boolean getIsNeedJumpToCapture() {
        return this.isNeedJumpToCapture;
    }

    @NotNull
    public final LiveData<List<PhotoFace>> e2() {
        da3.a aVar = this.photoFaceDao;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoFaceDao");
            aVar = null;
        }
        final LiveData<List<PhotoFace>> a16 = aVar.a();
        MediatorLiveData<List<PhotoFace>> mediatorLiveData = this._allPhotoFaces;
        final Function1<List<PhotoFace>, Unit> function1 = new Function1<List<PhotoFace>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel$getAllPhotoFacesFromDb$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<PhotoFace> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PhotoFace> list) {
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                mediatorLiveData2 = WinkLocalImageForFaceDetectViewModel.this._allPhotoFaces;
                mediatorLiveData2.setValue(list);
                mediatorLiveData3 = WinkLocalImageForFaceDetectViewModel.this._allPhotoFaces;
                mediatorLiveData3.removeSource(a16);
            }
        };
        mediatorLiveData.addSource(a16, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkLocalImageForFaceDetectViewModel.f2(Function1.this, obj);
            }
        });
        return this._allPhotoFaces;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel, com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    @NotNull
    public LiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIState(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return this.imagesLiveData;
    }

    @NotNull
    public final LiveData<UIStateData<List<LocalMediaInfo>>> k2() {
        return this.imagesLiveDataObserve;
    }

    public final boolean q2() {
        return uq3.k.a().c("mmkv_key_open_face_detect", false);
    }

    public final void u2(@NotNull List<PhotoFace> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.imagesFromDb.clear();
        for (PhotoFace photoFace : list) {
            this.imagesFromDb.put(Long.valueOf(photoFace.getId()), Integer.valueOf(photoFace.getFaceCount()));
        }
        this.dbSize = this.imagesFromDb.size();
        w53.b.f("WinkLocalImageForFaceDetectViewModel", "saveImageDbToMap... list:" + list.size() + " cost=" + (System.currentTimeMillis() - this.startMsLoadDb));
    }

    public final void v2(boolean z16) {
        this.clickCancel = z16;
    }

    public final void w2(boolean needJumpToCapture) {
        this.isNeedJumpToCapture = needJumpToCapture;
    }

    public final void x2(boolean z16) {
        this.hasExit = z16;
    }

    public final void y2() {
        UIStateData<List<LocalMediaInfo>> value = this.imagesLiveData.getValue();
        if (value != null) {
            a2(value);
        }
    }

    public final void z2() {
        UIStateData<List<LocalMediaInfo>> value = getMediaUIStateLiveData(MediaType.LOCAL_IMAGE).getValue();
        if (value != null) {
            this.imagesLiveData.postValue(value);
        }
    }
}

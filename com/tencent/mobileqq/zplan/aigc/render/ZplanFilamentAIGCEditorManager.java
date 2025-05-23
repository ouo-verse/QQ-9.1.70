package com.tencent.mobileqq.zplan.aigc.render;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.light.camera.ZPlanFilamentRequestManager;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.filament.zplan.view.GYFZPlanTextureView;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zplan.aigc.data.FilamentInitParams;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager;
import com.tencent.mobileqq.zplan.aigc.render.g;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.zplan.common.utils.GsonUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.util.WeakReference;
import org.json.JSONException;
import uk0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0095\u00012\u00020\u0001:\u0002=AB)\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J8\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J8\u0010\u0014\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0002J \u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0002J$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010 \u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\\\u0010)\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J9\u0010.\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J(\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u0006H\u0002J\u001a\u00103\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJP\u00106\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00105\u001a\u00020\"2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0012\u00107\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0012\u00108\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ \u0010:\u001a\u00020\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d09J\u0006\u0010;\u001a\u00020\u0006R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u0016\u0010R\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010KR\u0016\u0010T\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010KR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010KR\u0016\u0010X\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010KR\u0016\u0010Z\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010KR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010`R8\u0010i\u001a&\u0012\f\u0012\n f*\u0004\u0018\u00010e0e f*\u0012\u0012\f\u0012\n f*\u0004\u0018\u00010e0e\u0018\u00010\u000e0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\"\u0010s\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010K\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010{\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010xR\"\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R$\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0018\u0010\u0083\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010uR\u0018\u0010\u0085\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0011R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R#\u0010\u008e\u0001\u001a\f\u0018\u00010\u008a\u0001j\u0005\u0018\u0001`\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010u\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager;", "", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "model", "", "extraInfoJson", "", ExifInterface.LATITUDE_SOUTH, "color", "", "width", "height", "Landroid/graphics/Bitmap;", "pattern", "", "", "positionInfo", "I", "Lcom/tencent/mobileqq/zplan/aigc/render/Positions;", "positionsInfo", "J", "materialName", "Lcom/tencent/mobileqq/zplan/aigc/render/EditTexture;", "editeTextures", "N", "Landroid/content/Context;", "context", "Lcom/tencent/filament/zplan/data/RenderSize;", "size", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "listener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", "P", "", "isArchive", "offscreenBitmap", "", "matTextureNameMap", "matTextureMap", "subDirectoryName", "H", "originalBitmap", "gamma", "shadowGamma", "highlightGamma", "G", "(Landroid/graphics/Bitmap;DDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", UserInfo.SEX_FEMALE, "U", "X", "index", "bUpdateTexture", "V", "K", "L", "Lmqq/util/WeakReference;", "M", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/filament/zplan/view/GYFZPlanTextureView;", "a", "Lcom/tencent/filament/zplan/view/GYFZPlanTextureView;", "fTextureView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "offscreenView", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "c", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "filamentController", "d", "offScreenController", "e", "Ljava/lang/String;", "baseTemplate", "f", "exportTemplate", "g", "iblPath", tl.h.F, "fileDirPath", "i", "cacheDirPath", "j", "currentSlotID", "k", "curWhiteModelPath", "l", "curSetupConfig", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[I", "hidePrimitives", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", "currentPatternImage", "o", "currentPureColorImage", "", "Lcom/tencent/mobileqq/zplan/aigc/render/MaterialInst;", "kotlin.jvm.PlatformType", "p", "Ljava/util/List;", "materialSynchronizedList", "Landroid/content/res/AssetManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/res/AssetManager;", "assetManager", "r", "O", "()Ljava/lang/String;", "W", "(Ljava/lang/String;)V", "ugcEditorId", ReportConstant.COSTREPORT_PREFIX, "Z", "isDebug", "t", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "whiteModelFirstFrameListener", "u", "initEngineListener", "Ljava/util/concurrent/ConcurrentHashMap;", "v", "Ljava/util/concurrent/ConcurrentHashMap;", "materialTextureNameMap", "w", "materialTextureMap", HippyTKDListViewAdapter.X, "isEngineInit", "y", "currentSetModelRequest", "Landroid/os/Handler;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/os/Handler;", "uiHandler", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Runnable;", "resourceRunnable", "B", "needOnScreen", "Lcom/tencent/mobileqq/zplan/aigc/data/h;", "filamentInitParams", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/aigc/data/h;Lcom/tencent/mobileqq/zplan/aigc/render/g;)V", BdhLogUtil.LogTag.Tag_Conn, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanFilamentAIGCEditorManager {

    /* renamed from: A, reason: from kotlin metadata */
    private Runnable resourceRunnable;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean needOnScreen;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanTextureView fTextureView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView offscreenView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanController filamentController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanController offScreenController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String baseTemplate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String exportTemplate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String iblPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String fileDirPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String cacheDirPath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String currentSlotID;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String curWhiteModelPath;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String curSetupConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int[] hidePrimitives;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Bitmap currentPatternImage;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Bitmap currentPureColorImage;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final List<MaterialInst> materialSynchronizedList;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private AssetManager assetManager;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String ugcEditorId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isDebug;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.render.g whiteModelFirstFrameListener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.render.g initEngineListener;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<String, String> materialTextureNameMap;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<String, Bitmap> materialTextureMap;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean isEngineInit;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int currentSetModelRequest;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$b;", "", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f330432a = new b();

        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$c", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onScreenShot", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements GYScreenShotCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.aigc.render.g f330434b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$c$a", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "resourcePath", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zplan.aigc.render.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZplanFilamentAIGCEditorManager f330435a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bitmap f330436b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.zplan.aigc.render.g f330437c;

            a(ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, Bitmap bitmap, com.tencent.mobileqq.zplan.aigc.render.g gVar) {
                this.f330435a = zplanFilamentAIGCEditorManager;
                this.f330436b = bitmap;
                this.f330437c = gVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void h(Bitmap bitmap, com.tencent.mobileqq.zplan.aigc.render.g gVar, String resourcePath, ZplanFilamentAIGCEditorManager this$0) {
                ImageView imageView;
                Intrinsics.checkNotNullParameter(resourcePath, "$resourcePath");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (bitmap != null && (imageView = this$0.offscreenView) != null) {
                    imageView.setImageBitmap(bitmap);
                }
                if (gVar != null) {
                    gVar.d(resourcePath);
                }
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void a(final String resourcePath) {
                Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
                Handler handler = this.f330435a.uiHandler;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
                    handler = null;
                }
                final Bitmap bitmap = this.f330436b;
                final com.tencent.mobileqq.zplan.aigc.render.g gVar = this.f330437c;
                final ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.f330435a;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZplanFilamentAIGCEditorManager.c.a.h(bitmap, gVar, resourcePath, zplanFilamentAIGCEditorManager);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void b(int i3) {
                g.a.e(this, i3);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void c(boolean z16) {
                g.a.f(this, z16);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void d(String str) {
                g.a.c(this, str);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
                g.a.g(this, z16, aIGCWhiteModel);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void f(int i3) {
                g.a.a(this, i3);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void onScreenShotResult(Bitmap bitmap) {
                g.a.d(this, bitmap);
            }
        }

        c(com.tencent.mobileqq.zplan.aigc.render.g gVar) {
            this.f330434b = gVar;
        }

        @Override // com.tencent.filament.zplan.listener.GYScreenShotCallback
        public void onScreenShot(Bitmap bitmap) {
            FLog.INSTANCE.d("ZplanFilamentAIGCManager", "getAIGCArchiveResource callback");
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = ZplanFilamentAIGCEditorManager.this;
            zplanFilamentAIGCEditorManager.H(true, bitmap, zplanFilamentAIGCEditorManager.materialTextureNameMap, ZplanFilamentAIGCEditorManager.this.materialTextureMap, null, new a(ZplanFilamentAIGCEditorManager.this, bitmap, this.f330434b));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$d", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onScreenShot", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements GYScreenShotCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.aigc.render.g f330438a;

        d(com.tencent.mobileqq.zplan.aigc.render.g gVar) {
            this.f330438a = gVar;
        }

        @Override // com.tencent.filament.zplan.listener.GYScreenShotCallback
        public void onScreenShot(Bitmap bitmap) {
            FLog.INSTANCE.d("ZplanFilamentAIGCManager", "getAIGCArchiveResource callback");
            com.tencent.mobileqq.zplan.aigc.render.g gVar = this.f330438a;
            if (gVar != null) {
                gVar.onScreenShotResult(bitmap);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$e", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "resourcePath", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> f330440b;

        e(WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> weakReference) {
            this.f330440b = weakReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(WeakReference listener, String resourcePath) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(resourcePath, "$resourcePath");
            com.tencent.mobileqq.zplan.aigc.render.g gVar = (com.tencent.mobileqq.zplan.aigc.render.g) listener.get();
            if (gVar != null) {
                gVar.a(resourcePath);
            }
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(final String resourcePath) {
            Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
            Handler handler = ZplanFilamentAIGCEditorManager.this.uiHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
                handler = null;
            }
            final WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> weakReference = this.f330440b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.i
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanFilamentAIGCEditorManager.e.h(WeakReference.this, resourcePath);
                }
            });
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int i3) {
            g.a.e(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int i3) {
            g.a.a(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$f", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements GYFZPlanController.c {
        f() {
        }

        @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.c
        public void a(int result, int requestId) {
            com.tencent.mobileqq.zplan.aigc.render.g gVar;
            FLog fLog = FLog.INSTANCE;
            fLog.w("ZplanFilamentAIGCManager", "setFinishLoadingAvatarListener, onSetAvatarResult");
            if (requestId == ZplanFilamentAIGCEditorManager.this.currentSetModelRequest) {
                if (result == 0) {
                    GYFZPlanController gYFZPlanController = ZplanFilamentAIGCEditorManager.this.offScreenController;
                    if (gYFZPlanController != null) {
                        gYFZPlanController.X(ZplanFilamentAIGCEditorManager.this.currentSlotID);
                    }
                    GYFZPlanController gYFZPlanController2 = ZplanFilamentAIGCEditorManager.this.offScreenController;
                    if (gYFZPlanController2 != null) {
                        gYFZPlanController2.Q(ZplanFilamentAIGCEditorManager.this.hidePrimitives, ZplanFilamentAIGCEditorManager.this.currentSlotID);
                    }
                    if (!ZplanFilamentAIGCEditorManager.this.needOnScreen && (gVar = ZplanFilamentAIGCEditorManager.this.whiteModelFirstFrameListener) != null) {
                        gVar.c(result == 0);
                    }
                }
                if (ZplanFilamentAIGCEditorManager.this.needOnScreen || requestId != 0) {
                    return;
                }
                if (result == 0) {
                    ZplanFilamentAIGCEditorManager.this.isEngineInit = true;
                }
                com.tencent.mobileqq.zplan.aigc.render.g gVar2 = ZplanFilamentAIGCEditorManager.this.initEngineListener;
                if (gVar2 != null) {
                    gVar2.f(result);
                    return;
                }
                return;
            }
            fLog.w("ZplanFilamentAIGCManager", "fast click, abandon");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$g", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements GYFZPlanController.c {
        g() {
        }

        @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.c
        public void a(int result, int requestId) {
            if (requestId != ZplanFilamentAIGCEditorManager.this.currentSetModelRequest) {
                FLog.INSTANCE.w("ZplanFilamentAIGCManager", "fast click, abandon");
                return;
            }
            FLog.INSTANCE.d("ZplanFilamentAIGCManager", "preview onSetAvatarResult callback with result: " + result + " onlyShowSlot " + ZplanFilamentAIGCEditorManager.this.currentSlotID);
            if (result == 0) {
                GYFZPlanController gYFZPlanController = ZplanFilamentAIGCEditorManager.this.filamentController;
                if (gYFZPlanController != null) {
                    gYFZPlanController.X(ZplanFilamentAIGCEditorManager.this.currentSlotID);
                }
                GYFZPlanController gYFZPlanController2 = ZplanFilamentAIGCEditorManager.this.filamentController;
                if (gYFZPlanController2 != null) {
                    gYFZPlanController2.v(ZplanFilamentAIGCEditorManager.this.currentSlotID);
                }
                GYFZPlanController gYFZPlanController3 = ZplanFilamentAIGCEditorManager.this.filamentController;
                if (gYFZPlanController3 != null) {
                    gYFZPlanController3.Q(ZplanFilamentAIGCEditorManager.this.hidePrimitives, ZplanFilamentAIGCEditorManager.this.currentSlotID);
                }
                GYFZPlanController gYFZPlanController4 = ZplanFilamentAIGCEditorManager.this.filamentController;
                if (gYFZPlanController4 != null) {
                    gYFZPlanController4.Z();
                }
            }
            if (requestId == 0) {
                if (result == 0) {
                    ZplanFilamentAIGCEditorManager.this.isEngineInit = true;
                }
                com.tencent.mobileqq.zplan.aigc.render.g gVar = ZplanFilamentAIGCEditorManager.this.initEngineListener;
                if (gVar != null) {
                    gVar.f(result);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager$h", "Luk0/a;", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements uk0.a {
        h() {
        }

        @Override // uk0.a
        public void a(int result) {
            FLog.INSTANCE.d("ZplanFilamentAIGCManager", "firstFrame callback: " + result);
            com.tencent.mobileqq.zplan.aigc.render.g gVar = ZplanFilamentAIGCEditorManager.this.whiteModelFirstFrameListener;
            if (gVar != null) {
                gVar.c(result == 0);
            }
        }
    }

    public ZplanFilamentAIGCEditorManager(Context context, FilamentInitParams filamentInitParams, com.tencent.mobileqq.zplan.aigc.render.g gVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filamentInitParams, "filamentInitParams");
        this.baseTemplate = "";
        this.exportTemplate = "";
        this.iblPath = "";
        this.fileDirPath = "";
        this.cacheDirPath = "";
        this.currentSlotID = String.valueOf(AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_COAT.getValue());
        this.curWhiteModelPath = "";
        this.curSetupConfig = "";
        this.hidePrimitives = new int[0];
        this.materialSynchronizedList = Collections.synchronizedList(new ArrayList());
        this.ugcEditorId = "";
        this.materialTextureNameMap = new ConcurrentHashMap<>();
        this.materialTextureMap = new ConcurrentHashMap<>();
        this.currentSetModelRequest = -1;
        this.needOnScreen = true;
        U();
        this.uiHandler = new Handler(Looper.getMainLooper());
        FLog.INSTANCE.i("ZplanFilamentAIGCManager", "constructor renderSize");
        this.ugcEditorId = filamentInitParams.getUGCId();
        if (filamentInitParams.getNeedOnScreen()) {
            this.needOnScreen = true;
            RenderSize onScreenRenderSize = filamentInitParams.getOnScreenRenderSize();
            Intrinsics.checkNotNull(onScreenRenderSize);
            Q(context, onScreenRenderSize, gVar);
        } else {
            this.needOnScreen = false;
            T(context, gVar);
        }
        P(context, filamentInitParams.getOffScreenRenderSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H(final boolean isArchive, final Bitmap offscreenBitmap, final Map<String, String> matTextureNameMap, final Map<String, Bitmap> matTextureMap, String subDirectoryName, final com.tencent.mobileqq.zplan.aigc.render.g listener) {
        String str;
        if (subDirectoryName != null) {
            str = this.cacheDirPath + "/" + subDirectoryName + "/" + this.ugcEditorId;
        } else {
            str = this.cacheDirPath + "/" + this.ugcEditorId;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        final String str2 = str;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$generateAIGCResource$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                List<MaterialInst> materialSynchronizedList;
                if (isArchive) {
                    AIGCHelper aIGCHelper = AIGCHelper.f330685a;
                    aIGCHelper.n(this.getUgcEditorId(), str2);
                    aIGCHelper.r(this.getUgcEditorId(), str2, offscreenBitmap);
                }
                AIGCHelper aIGCHelper2 = AIGCHelper.f330685a;
                String ugcEditorId = this.getUgcEditorId();
                materialSynchronizedList = this.materialSynchronizedList;
                Intrinsics.checkNotNullExpressionValue(materialSynchronizedList, "materialSynchronizedList");
                aIGCHelper2.l(ugcEditorId, materialSynchronizedList, str2);
                if ((!matTextureNameMap.isEmpty()) && (!matTextureMap.isEmpty())) {
                    aIGCHelper2.p(this.getUgcEditorId(), str2, matTextureNameMap, matTextureMap);
                }
                Handler handler = this.uiHandler;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
                    handler = null;
                }
                final g gVar = listener;
                final String str3 = str2;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$generateAIGCResource$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar2 = g.this;
                        if (gVar2 != null) {
                            gVar2.a(str3);
                        }
                    }
                });
            }
        };
        this.resourceRunnable = runnable;
        ThreadManagerV2.excute(runnable, 64, null, true);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditTexture N(String materialName, List<EditTexture> editeTextures) {
        for (EditTexture editTexture : editeTextures) {
            if (Intrinsics.areEqual(editTexture.getMaterial(), materialName)) {
                return editTexture;
            }
        }
        return null;
    }

    private final void P(Context context, RenderSize size) {
        this.offScreenController = new GYFZPlanController(size, true, false, 4, null);
        if (this.iblPath.length() == 0) {
            FLog.INSTANCE.i("ZplanFilamentAIGCManager", "initOffscreenScene iblPath is empty: " + this.iblPath);
        }
        if (this.exportTemplate.length() == 0) {
            FLog.INSTANCE.i("ZplanFilamentAIGCManager", "initOffscreenScene exportTemplate is empty: " + this.exportTemplate);
        }
        GYFZPlanController gYFZPlanController = this.offScreenController;
        if (gYFZPlanController != null) {
            gYFZPlanController.n0(new f());
        }
    }

    private final void Q(Context context, RenderSize size, final com.tencent.mobileqq.zplan.aigc.render.g listener) {
        this.initEngineListener = listener;
        this.fileDirPath = context.getFilesDir().toString() + "/zplanAIGCResource";
        this.cacheDirPath = context.getCacheDir().toString() + "/zplanAIGCResource";
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZplanFilamentAIGCEditorManager$initPreviewScene$1(this, null), 3, null);
        FLog.INSTANCE.d("ZplanFilamentAIGCManager", "initPreviewScene: " + this.fileDirPath);
        this.assetManager = context.getAssets();
        GYFZPlanController gYFZPlanController = new GYFZPlanController(size, false, true);
        this.filamentController = gYFZPlanController;
        gYFZPlanController.n0(new g());
        GYFZPlanController gYFZPlanController2 = this.filamentController;
        if (gYFZPlanController2 != null) {
            gYFZPlanController2.o0(new h());
        }
        GYFZPlanTextureView gYFZPlanTextureView = new GYFZPlanTextureView(context, size, false, Boolean.TRUE);
        this.fTextureView = gYFZPlanTextureView;
        gYFZPlanTextureView.setOpaque(false);
        GYFZPlanTextureView gYFZPlanTextureView2 = this.fTextureView;
        if (gYFZPlanTextureView2 != null) {
            gYFZPlanTextureView2.setAutoInitFilament(false);
        }
        GYFZPlanTextureView gYFZPlanTextureView3 = this.fTextureView;
        if (gYFZPlanTextureView3 != null) {
            GYFZPlanController gYFZPlanController3 = this.filamentController;
            Intrinsics.checkNotNull(gYFZPlanController3);
            gYFZPlanTextureView3.setController(gYFZPlanController3);
        }
        GYFZPlanTextureView gYFZPlanTextureView4 = this.fTextureView;
        if (gYFZPlanTextureView4 != null) {
            gYFZPlanTextureView4.setFilamentRenderListener(new uk0.d() { // from class: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$initPreviewScene$4
                @Override // uk0.d
                public void a(Surface surface, int width, int height) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    FLog.INSTANCE.d("ZplanFilamentAIGCManager", "setAvatarWithAvatarInfoAndFaceJson onSurfaceTextureAvailable");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ZplanFilamentAIGCEditorManager$initPreviewScene$4$onSurfaceTextureAvailable$1(ZplanFilamentAIGCEditorManager.this, listener, null), 3, null);
                }

                @Override // uk0.d
                public void b(Surface surface) {
                    d.a.b(this, surface);
                }

                @Override // uk0.d
                public void onSurfaceChanged(Surface surface) {
                    d.a.a(this, surface);
                }
            });
        }
        GYFZPlanTextureView gYFZPlanTextureView5 = this.fTextureView;
        if (gYFZPlanTextureView5 != null) {
            GYFZPlanController gYFZPlanController4 = this.filamentController;
            gYFZPlanTextureView5.setOnTouchListener(gYFZPlanController4 != null ? gYFZPlanController4.x(context) : null);
        }
    }

    private final void T(Context context, com.tencent.mobileqq.zplan.aigc.render.g listener) {
        this.initEngineListener = listener;
        this.fileDirPath = context.getFilesDir().toString() + "/zplanAIGCResource";
        this.cacheDirPath = context.getCacheDir().toString() + "/zplanAIGCResource";
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZplanFilamentAIGCEditorManager$prepareResource$1(this, null), 3, null);
        this.assetManager = context.getAssets();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ZplanFilamentAIGCEditorManager$prepareResource$2(this, listener, null), 3, null);
    }

    private final void U() {
        ZPlanFilamentRequestManager.Light3DFilamentRegisterDownloadImpl$default(new com.tencent.mobileqq.zplan.aigc.render.b(null, 1, 0 == true ? 1 : 0), false, 2, null);
    }

    public final void K(com.tencent.mobileqq.zplan.aigc.render.g listener) {
        GYFZPlanController gYFZPlanController = this.offScreenController;
        if (gYFZPlanController != null) {
            gYFZPlanController.q0(new RenderSize(512, 512), true);
        }
        GYFZPlanController gYFZPlanController2 = this.offScreenController;
        if (gYFZPlanController2 != null) {
            gYFZPlanController2.u0(new c(listener));
        }
    }

    public final void L(com.tencent.mobileqq.zplan.aigc.render.g listener) {
        GYFZPlanController gYFZPlanController = this.offScreenController;
        if (gYFZPlanController != null) {
            gYFZPlanController.u0(new d(listener));
        }
    }

    public final void M(String subDirectoryName, WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        H(false, null, this.materialTextureNameMap, this.materialTextureMap, subDirectoryName, new e(listener));
    }

    /* renamed from: O, reason: from getter */
    public final String getUgcEditorId() {
        return this.ugcEditorId;
    }

    public final void R() {
        GYFZPlanTextureView gYFZPlanTextureView = this.fTextureView;
        if (gYFZPlanTextureView != null) {
            gYFZPlanTextureView.d();
        }
        GYFZPlanController gYFZPlanController = this.offScreenController;
        if (gYFZPlanController != null) {
            GYFZPlanController.z(gYFZPlanController, null, 1, null);
        }
        Handler handler = this.uiHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
            handler = null;
        }
        handler.removeCallbacksAndMessages(null);
        Runnable runnable = this.resourceRunnable;
        if (runnable != null) {
            Intrinsics.checkNotNull(runnable);
            ThreadManagerV2.removeJob(runnable, 64);
            this.resourceRunnable = null;
        }
        this.initEngineListener = null;
        this.whiteModelFirstFrameListener = null;
    }

    public final void V(int index, String color, int width, int height, Bitmap pattern, AIGCWhiteModel model, boolean bUpdateTexture, com.tencent.mobileqq.zplan.aigc.render.g listener) {
        Intrinsics.checkNotNullParameter(color, "color");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZplanFilamentAIGCManager", null, null, null, new ZplanFilamentAIGCEditorManager$setModelImage$1(model, index, this, pattern, color, width, height, bUpdateTexture, listener, null), 14, null);
        }
    }

    public final void W(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ugcEditorId = str;
    }

    public final void X(AIGCWhiteModel model, com.tencent.mobileqq.zplan.aigc.render.g listener) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (!this.isEngineInit) {
            FLog.INSTANCE.e("ZplanFilamentAIGCManager", "setWhiteModel when engine not ready");
            if (listener != null) {
                listener.e(false, model);
            }
        }
        FLog.INSTANCE.i("ZplanFilamentAIGCManager", " setWhiteModel");
        this.whiteModelFirstFrameListener = listener;
        synchronized (b.f330432a) {
            this.currentSlotID = String.valueOf(model.getSlotID());
            Unit unit = Unit.INSTANCE;
        }
        S(model, model.getExtraInfo());
        this.currentSetModelRequest = model.hashCode();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ZplanFilamentAIGCEditorManager$setWhiteModel$2(model, this, listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object G(Bitmap bitmap, double d16, double d17, double d18, Continuation<? super Bitmap> continuation) {
        ZplanFilamentAIGCEditorManager$adjustPixel$1 zplanFilamentAIGCEditorManager$adjustPixel$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ZplanFilamentAIGCEditorManager$adjustPixel$1) {
            zplanFilamentAIGCEditorManager$adjustPixel$1 = (ZplanFilamentAIGCEditorManager$adjustPixel$1) continuation;
            int i16 = zplanFilamentAIGCEditorManager$adjustPixel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zplanFilamentAIGCEditorManager$adjustPixel$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zplanFilamentAIGCEditorManager$adjustPixel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zplanFilamentAIGCEditorManager$adjustPixel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                    ZplanFilamentAIGCEditorManager$adjustPixel$2 zplanFilamentAIGCEditorManager$adjustPixel$2 = new ZplanFilamentAIGCEditorManager$adjustPixel$2(bitmap, this, d16, d17, d18, null);
                    zplanFilamentAIGCEditorManager$adjustPixel$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, zplanFilamentAIGCEditorManager$adjustPixel$2, zplanFilamentAIGCEditorManager$adjustPixel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNullExpressionValue(obj, "private suspend fun adju\u2026text adjustedBitmap\n    }");
                return obj;
            }
        }
        zplanFilamentAIGCEditorManager$adjustPixel$1 = new ZplanFilamentAIGCEditorManager$adjustPixel$1(this, continuation);
        Object obj2 = zplanFilamentAIGCEditorManager$adjustPixel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zplanFilamentAIGCEditorManager$adjustPixel$1.label;
        if (i3 != 0) {
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "private suspend fun adju\u2026text adjustedBitmap\n    }");
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap J(String color, int width, int height, Bitmap pattern, List<Positions> positionsInfo) {
        Bitmap bitmap = null;
        for (Positions positions : positionsInfo) {
            double d16 = width;
            double doubleValue = positions.getPosition().get(0).doubleValue() * d16;
            double d17 = height;
            double doubleValue2 = positions.getPosition().get(1).doubleValue() * d17;
            double doubleValue3 = d16 * positions.getPosition().get(2).doubleValue();
            double doubleValue4 = positions.getPosition().get(3).doubleValue() * d17;
            double d18 = 2;
            bitmap = com.tencent.mobileqq.zplan.utils.l.f335829a.d(color, width, height, pattern, (int) (doubleValue - (doubleValue3 / d18)), (int) ((d17 - doubleValue2) - ((3.0d * doubleValue4) / d18)), (int) doubleValue3, (int) doubleValue4, positions.getRotationType(), bitmap);
        }
        Intrinsics.checkNotNull(bitmap);
        return bitmap;
    }

    private final void S(AIGCWhiteModel model, String extraInfoJson) {
        int[] intArray;
        try {
            ModelExtraInfo modelExtraInfo = model.getModelExtraInfo();
            if (modelExtraInfo == null) {
                modelExtraInfo = (ModelExtraInfo) GsonUtil.f385283b.a().fromJson(extraInfoJson, ModelExtraInfo.class);
            }
            if (modelExtraInfo != null) {
                intArray = CollectionsKt___CollectionsKt.toIntArray(modelExtraInfo.getHidePrimitives());
                this.hidePrimitives = intArray;
                this.exportTemplate = modelExtraInfo.getExportTemplate();
                this.baseTemplate = modelExtraInfo.getPreviewTemplate();
                model.setModelExtraInfo(modelExtraInfo);
                this.materialSynchronizedList.clear();
                this.materialTextureNameMap.clear();
                int size = modelExtraInfo.getMaterials().size();
                int i3 = 0;
                while (i3 < size) {
                    String matSlotName = modelExtraInfo.getMaterials().get(i3).getMatSlotName();
                    int matSlotId = modelExtraInfo.getMaterials().get(i3).getMatSlotId();
                    i3++;
                    String str = this.ugcEditorId + "_" + i3 + "_texture";
                    MaterialInst materialInst = new MaterialInst("CMShow/Assets/Other/Avatar2Design/" + this.ugcEditorId + "/Texture/" + str, matSlotName, 0, matSlotId, 0, null, null, 116, null);
                    MaterialInst materialInst2 = new MaterialInst("CMShow/Assets/Other/Avatar2Design/" + this.ugcEditorId + "/Texture/" + str, matSlotName + "_LOD", 0, matSlotId, 0, null, null, 116, null);
                    this.materialTextureNameMap.put(matSlotName, String.valueOf(str));
                    this.materialSynchronizedList.add(materialInst);
                    this.materialSynchronizedList.add(materialInst2);
                }
                return;
            }
            FLog.INSTANCE.e("ZplanFilamentAIGCManager", "parseWhiteModelInfo parse extraInfo error");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap I(String color, int width, int height, Bitmap pattern, List<Double> positionInfo) {
        double d16 = width;
        double doubleValue = positionInfo.get(0).doubleValue() * d16;
        double doubleValue2 = positionInfo.get(1).doubleValue() * d16;
        double doubleValue3 = positionInfo.get(2).doubleValue() * d16;
        double doubleValue4 = positionInfo.get(3).doubleValue() * d16;
        double d17 = 2;
        return com.tencent.mobileqq.zplan.utils.l.f335829a.c(color, width, height, pattern, (int) (doubleValue - (doubleValue3 / d17)), (int) ((d16 - doubleValue2) - ((3.0d * doubleValue4) / d17)), (int) doubleValue3, (int) doubleValue4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int F(int value, double gamma, double shadowGamma, double highlightGamma) {
        double pow = Math.pow(value / 255.0d, gamma) * 255.0d;
        return (int) (pow < 127.5d ? RangesKt___RangesKt.coerceIn(Math.pow(pow / 127.5d, shadowGamma) * 127.5d, 0.0d, 255.0d) : RangesKt___RangesKt.coerceIn((Math.pow((pow - 127.5d) / 127.5d, highlightGamma) * 127.5d) + 127.5d, 0.0d, 255.0d));
    }
}

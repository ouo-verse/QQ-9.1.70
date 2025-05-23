package com.tencent.tavcut.core.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.gyailib.library.GYTrackSticker;
import com.gyailib.library.GYTrackStickerInfo;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.core.dataprocessor.EntityNodeType;
import com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.utils.c;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipAsset;
import org.light.gles.SimpleGLThread;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.ExternalRender;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.Vec3;
import td4.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0007>\u00b5\u0001\u00b6\u0001\u00b7\u0001B\t\u00a2\u0006\u0006\b\u00b3\u0001\u0010\u00b4\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020!H\u0002J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020+H\u0002J5\u00106\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00105\u001a\u000204H\u0000\u00a2\u0006\u0004\b6\u00107J\u000e\u0010:\u001a\u00020!2\u0006\u00109\u001a\u000208J\b\u0010;\u001a\u0004\u0018\u00010\u0006J\u0006\u0010<\u001a\u00020\u0004R\u0014\u0010@\u001a\u00020=8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020=8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0014\u0010E\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010J\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010IR$\u0010Q\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010X\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010b\u001a\u0002048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR$\u0010}\u001a\u0012\u0012\u0004\u0012\u00020\u00060yj\b\u0012\u0004\u0012\u00020\u0006`z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010?R \u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0088\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0082\u0001R \u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u0082\u0001R\u001a\u0010\u008e\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010\fR\u0018\u0010\u0092\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010DR\u0018\u0010\u0094\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010\fR\u0018\u0010\u0096\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010\fR\u0018\u0010\u0098\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010DR \u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0082\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010IR\u0018\u0010\u009e\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010\fR\u0018\u0010\u00a0\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010DR\u001c\u0010\u00a4\u0001\u001a\u0005\u0018\u00010\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0018\u0010\u00a6\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010DR\u0018\u0010\u00a8\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a7\u0001\u0010DR\u001b\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00a9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bI\u0010\u00aa\u0001R\u001f\u0010\u00ae\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u00ac\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bD\u0010\u00ad\u0001R\u0018\u0010\u00b0\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00af\u0001\u0010\fR\u0018\u0010\u00b2\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b1\u0001\u0010D\u00a8\u0006\u00b8\u0001"}, d2 = {"Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager$TrackingErrorCode;", "errorCode", "", "c0", "Lcom/gyailib/library/GYTrackStickerInfo;", "result", "o0", "", "lastTimeStamp", "m0", "Z", "firstFrameTimeStamp", "Y", "seekTime", "T", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", TemplateParser.KEY_ENTITY_ID, "Lorg/light/lightAssetKit/Entity;", "f0", "entity", "targetEntityId", "e0", "g0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/tavcut/core/manager/StickerTrackerManager$a;", "V", "", "d0", "h0", "a0", "Lorg/light/lightAssetKit/components/TimeOffset;", "stickerTimeOffset", "n0", "time", "isRevert", "j0", "Ljava/io/File;", "file", "i0", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "curPlayer", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "curPlayerRenderChain", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "curDataDispatcher", "Lsd4/b;", "trackConfig", "b0", "(Lcom/tencent/tavcut/core/render/player/IPlayer;Lcom/tencent/tavcut/core/render/IRenderChainManager;Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;Lsd4/b;)I", "Lcom/tencent/tavcut/core/manager/a;", "callback", "k0", "l0", "U", "", "a", "Ljava/lang/String;", "TAG", "b", "EXTERNAL_RENDER_KEY", "c", "J", "STICKER_PER_FRAME_DURATION", "d", "STICKER_PER_FRAME_MAX_DURATION", "e", "I", "DEFAULT_MAX_CACHE_SIZE", "f", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "W", "()Lcom/tencent/tavcut/core/render/player/IPlayer;", "setPlayer", "(Lcom/tencent/tavcut/core/render/player/IPlayer;)V", "player", "g", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "getPlayerRenderChain", "()Lcom/tencent/tavcut/core/render/IRenderChainManager;", "setPlayerRenderChain", "(Lcom/tencent/tavcut/core/render/IRenderChainManager;)V", "playerRenderChain", h.F, "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "dataDispatcher", "i", "Lsd4/b;", "X", "()Lsd4/b;", "setStickerTrackerConfig", "(Lsd4/b;)V", "stickerTrackerConfig", "Lorg/light/gles/SimpleGLThread;", "j", "Lorg/light/gles/SimpleGLThread;", "glThread", "Ljava/lang/Thread;", "k", "Ljava/lang/Thread;", "detectThread", "Lcom/gyailib/library/GYTrackSticker;", "l", "Lcom/gyailib/library/GYTrackSticker;", "stickerTrackerDetector", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/gyailib/library/GYTrackStickerInfo;", "targetStickerInfo", DomainData.DOMAIN_NAME, "Lcom/tencent/tavcut/core/manager/a;", "trackingCallback", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager$StickerTrackerManagerState;", "o", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager$StickerTrackerManagerState;", "status", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p", "Ljava/util/ArrayList;", "stickerTrackerResult", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "fileCacheDir", "", "r", "Ljava/util/List;", "entityTree", ReportConstant.COSTREPORT_PREFIX, "Lorg/light/lightAssetKit/Entity;", "externalEntity", "t", "gopFrameStack", "u", "totalFrameStack", "Ljava/util/concurrent/atomic/AtomicBoolean;", "v", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReversing", "w", "isDetectReversing", HippyTKDListViewAdapter.X, "tagTimeStamp", "y", "isFirstFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isFirstFrameDetect", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "detectTime", "B", "keyFrameTimeUs", BdhLogUtil.LogTag.Tag_Conn, "gopIndex", "D", "isStopping", "E", "startTrackingTime", "Lcom/tencent/tav/coremedia/CMTimeRange;", UserInfo.SEX_FEMALE, "Lcom/tencent/tav/coremedia/CMTimeRange;", "startTrackingPlayRange", "G", "pauseStamp", "H", "lastPlayerPosition", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "", "Ljava/util/Set;", "trackerTimeStampRecord", "K", "isCanceled", "L", "lastDetectTimaStamp", "<init>", "()V", "InitErrorCode", "StickerTrackerManagerState", "TrackingErrorCode", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class StickerTrackerManager {

    /* renamed from: A, reason: from kotlin metadata */
    private long detectTime;

    /* renamed from: B, reason: from kotlin metadata */
    private List<Long> keyFrameTimeUs;

    /* renamed from: C, reason: from kotlin metadata */
    private int gopIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isStopping;

    /* renamed from: E, reason: from kotlin metadata */
    private long startTrackingTime;

    /* renamed from: F, reason: from kotlin metadata */
    private CMTimeRange startTrackingPlayRange;

    /* renamed from: G, reason: from kotlin metadata */
    private long pauseStamp;

    /* renamed from: H, reason: from kotlin metadata */
    private long lastPlayerPosition;

    /* renamed from: I, reason: from kotlin metadata */
    private IPlayer.PlayerListener playerListener;

    /* renamed from: J, reason: from kotlin metadata */
    private Set<Long> trackerTimeStampRecord;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean isCanceled;

    /* renamed from: L, reason: from kotlin metadata */
    private long lastDetectTimaStamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPlayer player;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRenderChainManager playerRenderChain;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RenderDataDispatcher dataDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public sd4.b stickerTrackerConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SimpleGLThread glThread;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Thread detectThread;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private GYTrackSticker stickerTrackerDetector;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GYTrackStickerInfo targetStickerInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.core.manager.a trackingCallback;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Entity externalEntity;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private List<a> totalFrameStack;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isReversing;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isDetectReversing;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private long tagTimeStamp;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstFrame;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstFrameDetect;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "StickerTrackerManager";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String EXTERNAL_RENDER_KEY = "stickerTracker";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long STICKER_PER_FRAME_DURATION = 33333;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long STICKER_PER_FRAME_MAX_DURATION = 50000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int DEFAULT_MAX_CACHE_SIZE = 60;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private volatile StickerTrackerManagerState status = StickerTrackerManagerState.Waiting;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<GYTrackStickerInfo> stickerTrackerResult = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String fileCacheDir = "";

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private List<Entity> entityTree = new ArrayList();

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private List<a> gopFrameStack = new ArrayList();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/manager/StickerTrackerManager$InitErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "SUCCESS", "ERROR_PLAYER", "ERROR_RENDER_CHAIN", "ERROR_MODEL_PATH", "ERROR_STICKER_ENTITY_NOT_FOUND", "ERROR_CACHE_DIR", "ERROR_STICKER_END_TIME_NO_LEGAL", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum InitErrorCode {
        SUCCESS(0),
        ERROR_PLAYER(1),
        ERROR_RENDER_CHAIN(2),
        ERROR_MODEL_PATH(3),
        ERROR_STICKER_ENTITY_NOT_FOUND(4),
        ERROR_CACHE_DIR(5),
        ERROR_STICKER_END_TIME_NO_LEGAL(6);

        private final int value;

        InitErrorCode(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/tavcut/core/manager/StickerTrackerManager$StickerTrackerManagerState;", "", "(Ljava/lang/String;I)V", "Waiting", "Working", "Finished", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum StickerTrackerManagerState {
        Waiting,
        Working,
        Finished
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/core/manager/StickerTrackerManager$TrackingErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "SUCCESS", "CANCEL", "FAILED", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum TrackingErrorCode {
        SUCCESS(0),
        CANCEL(1),
        FAILED(2);

        private final int value;

        TrackingErrorCode(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/gyailib/library/GYTrackStickerInfo;", "kotlin.jvm.PlatformType", "u1", "u2", "", "a", "(Lcom/gyailib/library/GYTrackStickerInfo;Lcom/gyailib/library/GYTrackStickerInfo;)I"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b<T> implements Comparator<GYTrackStickerInfo> {

        /* renamed from: d, reason: collision with root package name */
        public static final b f374315d = new b();

        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(GYTrackStickerInfo gYTrackStickerInfo, GYTrackStickerInfo gYTrackStickerInfo2) {
            return (gYTrackStickerInfo.timestamp > gYTrackStickerInfo2.timestamp ? 1 : (gYTrackStickerInfo.timestamp == gYTrackStickerInfo2.timestamp ? 0 : -1));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/tavcut/core/manager/StickerTrackerManager$c", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "", "currentDurationUs", "playerDurationUs", "", "onPositionChanged", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class c implements IPlayer.PlayerListener {
        c() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkParameterIsNotNull(iPlayer, "iPlayer");
            IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            if (!StickerTrackerManager.this.isFirstFrame) {
                if (!StickerTrackerManager.this.isReversing.get() || currentDurationUs <= StickerTrackerManager.this.pauseStamp) {
                    boolean z16 = true;
                    if (currentDurationUs >= StickerTrackerManager.this.X().getStickerEndTime()) {
                        StickerTrackerManager.this.isStopping = true;
                    } else if (Math.abs(currentDurationUs - StickerTrackerManager.this.X().getStickerStartTime()) < 100000 && StickerTrackerManager.this.isStopping) {
                        StickerTrackerManager.this.c0(TrackingErrorCode.SUCCESS);
                    }
                    StickerTrackerManager.this.lastPlayerPosition = currentDurationUs;
                    if (StickerTrackerManager.this.isReversing.get() && currentDurationUs > StickerTrackerManager.this.tagTimeStamp) {
                        try {
                            StickerTrackerManager stickerTrackerManager = StickerTrackerManager.this;
                            stickerTrackerManager.gopIndex--;
                            Log.i(StickerTrackerManager.this.TAG, "index:" + StickerTrackerManager.this.gopIndex);
                            if (StickerTrackerManager.this.gopIndex >= 0) {
                                StickerTrackerManager stickerTrackerManager2 = StickerTrackerManager.this;
                                stickerTrackerManager2.tagTimeStamp = ((Number) stickerTrackerManager2.keyFrameTimeUs.get(StickerTrackerManager.this.gopIndex + 1)).longValue();
                                StickerTrackerManager stickerTrackerManager3 = StickerTrackerManager.this;
                                long T = stickerTrackerManager3.T(((Number) stickerTrackerManager3.keyFrameTimeUs.get(StickerTrackerManager.this.gopIndex)).longValue());
                                if (StickerTrackerManager.this.gopIndex < 0) {
                                    z16 = false;
                                }
                                stickerTrackerManager3.j0(T, z16);
                            } else if (StickerTrackerManager.this.tagTimeStamp != StickerTrackerManager.this.detectTime) {
                                StickerTrackerManager stickerTrackerManager4 = StickerTrackerManager.this;
                                stickerTrackerManager4.tagTimeStamp = stickerTrackerManager4.detectTime;
                                StickerTrackerManager stickerTrackerManager5 = StickerTrackerManager.this;
                                stickerTrackerManager5.j0(stickerTrackerManager5.detectTime, false);
                            } else {
                                StickerTrackerManager.this.isReversing.compareAndSet(true, false);
                            }
                        } catch (Exception e16) {
                            StickerTrackerManager.this.c0(TrackingErrorCode.FAILED);
                            Log.e(StickerTrackerManager.this.TAG, "reversePlay end exception " + e16.toString());
                        }
                    }
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            Intrinsics.checkParameterIsNotNull(iPlayer, "iPlayer");
            IPlayer.PlayerListener.DefaultImpls.onStatusChanged(this, playerStatus, iPlayer);
        }
    }

    public StickerTrackerManager() {
        List<a> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkExpressionValueIsNotNull(synchronizedList, "Collections.synchronized\u2026bleListOf<FrameBitmap>())");
        this.totalFrameStack = synchronizedList;
        this.isReversing = new AtomicBoolean();
        this.isDetectReversing = true;
        this.isFirstFrame = true;
        this.isFirstFrameDetect = true;
        this.keyFrameTimeUs = new ArrayList();
        this.gopIndex = -1;
        this.trackerTimeStampRecord = new LinkedHashSet();
    }

    private final void Q() {
        int i3;
        ArrayList arrayListOf;
        Entity entity;
        Integer num;
        ExternalRender j3 = rd4.c.f431135f.o().j(this.EXTERNAL_RENDER_KEY, "");
        try {
            IRenderChainManager iRenderChainManager = this.playerRenderChain;
            List<Entity> list = null;
            if (iRenderChainManager != null) {
                entity = iRenderChainManager.findMultiMediaEntity();
            } else {
                entity = null;
            }
            if (entity != null) {
                list = entity.getChildren();
            }
            if (list != null) {
                int size = entity.getChildren().size();
                i3 = 0;
                while (i3 < size) {
                    Entity entity2 = entity.getChildren().get(i3);
                    Intrinsics.checkExpressionValueIsNotNull(entity2, "parentEntity.children[index]");
                    int id5 = entity2.getId();
                    sd4.b bVar = this.stickerTrackerConfig;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                    }
                    Entity entity3 = bVar.getEntity();
                    if (entity3 != null) {
                        num = Integer.valueOf(entity3.getId());
                    } else {
                        sd4.b bVar2 = this.stickerTrackerConfig;
                        if (bVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                        }
                        num = bVar2.getCom.tencent.tavcut.rendermodel.parser.TemplateParser.KEY_ENTITY_ID java.lang.String();
                    }
                    if ((num instanceof Integer) && id5 == num.intValue()) {
                        break;
                    }
                    i3++;
                }
            }
        } catch (Exception e16) {
            Log.e(this.TAG, "addExternalRenderEntity error " + e16.getMessage());
            e16.printStackTrace();
        }
        i3 = 0;
        Log.i(this.TAG, "addExternalRenderEntity stickerIndex " + i3);
        f q16 = rd4.c.f431135f.q();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(j3);
        Entity a16 = q16.a("\u5916\u6302\u6ee4\u955c", arrayListOf);
        this.externalEntity = a16;
        IRenderChainManager iRenderChainManager2 = this.playerRenderChain;
        if (iRenderChainManager2 != null) {
            EntityNodeType entityNodeType = EntityNodeType.MULTI_MEDIA;
            if (a16 == null) {
                Intrinsics.throwNpe();
            }
            iRenderChainManager2.addEntity(entityNodeType, a16, i3);
        }
        IRenderChainManager iRenderChainManager3 = this.playerRenderChain;
        if (iRenderChainManager3 != null) {
            iRenderChainManager3.emit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(Bitmap bitmap, long timeStamp) {
        if (bitmap != null) {
            System.currentTimeMillis();
            if (!new File(this.fileCacheDir).exists()) {
                new File(this.fileCacheDir).mkdirs();
            }
            File file = new File(this.fileCacheDir + timeStamp + ".jpg");
            if (file.exists()) {
                file.delete();
            }
            i0(bitmap, file);
            this.gopFrameStack.add(new a(null, timeStamp, file, true));
            return;
        }
        this.gopFrameStack.add(new a(null, timeStamp, null, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        if (!this.gopFrameStack.isEmpty()) {
            CollectionsKt___CollectionsJvmKt.reverse(this.gopFrameStack);
            this.totalFrameStack.addAll(this.gopFrameStack);
            this.gopFrameStack.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T(long seekTime) {
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        if (bVar.getStickerStartTime() >= seekTime) {
            sd4.b bVar2 = this.stickerTrackerConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            long stickerStartTime = bVar2.getStickerStartTime();
            this.gopIndex = 0;
            return stickerStartTime;
        }
        return seekTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a V() {
        a aVar = this.totalFrameStack.get(0);
        this.totalFrameStack.remove(0);
        if (aVar.getIsCache()) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    try {
                        if (aVar.getFile() != null) {
                            File file = aVar.getFile();
                            if (file == null) {
                                Intrinsics.throwNpe();
                            }
                            if (file.exists()) {
                                FileInputStream fileInputStream2 = new FileInputStream(aVar.getFile());
                                try {
                                    aVar.e(BitmapFactory.decodeStream(fileInputStream2));
                                    File file2 = aVar.getFile();
                                    if (file2 != null) {
                                        file2.delete();
                                    }
                                    aVar.f(false);
                                    aVar.g(null);
                                    fileInputStream = fileInputStream2;
                                } catch (IOException e16) {
                                    e = e16;
                                    fileInputStream = fileInputStream2;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    return aVar;
                                } catch (Throwable th5) {
                                    th = th5;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e17) {
                                            e17.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (IOException e18) {
                        e = e18;
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(long firstFrameTimeStamp) {
        this.detectTime = firstFrameTimeStamp;
        Log.i(this.TAG, " detectTime: " + (this.detectTime / 1000));
        int size = this.keyFrameTimeUs.size();
        if (size <= 0) {
            IPlayer iPlayer = this.player;
            if (iPlayer != null) {
                iPlayer.play();
                return;
            }
            return;
        }
        this.gopIndex = size - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (this.keyFrameTimeUs.get(i3).longValue() >= this.detectTime) {
                this.gopIndex = i3 - 1;
                break;
            }
            i3++;
        }
        int i16 = this.gopIndex;
        if (i16 >= 0) {
            this.tagTimeStamp = this.detectTime;
            j0(T(this.keyFrameTimeUs.get(i16).longValue()), true);
        }
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        this.pauseStamp = bVar.getStickerEndTime();
    }

    private final void Z(TrackingErrorCode errorCode) {
        com.tencent.tavcut.core.manager.a aVar;
        GYTrackSticker gYTrackSticker = this.stickerTrackerDetector;
        if (gYTrackSticker != null) {
            gYTrackSticker.getSmoothedResult(this.stickerTrackerResult);
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.stickerTrackerResult, b.f374315d);
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        Entity entity = bVar.getEntity();
        if (entity != null && (aVar = this.trackingCallback) != null) {
            int value = errorCode.getValue();
            ArrayList<GYTrackStickerInfo> arrayList = this.stickerTrackerResult;
            sd4.b bVar2 = this.stickerTrackerConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            aVar.a(value, arrayList, bVar2.getStickerName(), entity);
        }
        Log.i(this.TAG, "stopTracking cost time " + (System.currentTimeMillis() - this.startTrackingTime) + "ms stickerTrackerResult " + this.stickerTrackerResult.size() + " errorCode " + errorCode.getValue());
    }

    private final boolean a0() {
        TimeOffset timeOffset;
        Long l3;
        Long l16;
        CMTimeRange cMTimeRange;
        Long l17;
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        if (bVar.getStickerEndTime() <= 0) {
            sd4.b bVar2 = this.stickerTrackerConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            Entity entity = bVar2.getEntity();
            Long l18 = null;
            if (entity != null) {
                timeOffset = com.tencent.tavcut.core.utils.c.f(entity);
            } else {
                timeOffset = null;
            }
            if (timeOffset != null) {
                n0(timeOffset);
            }
            if (timeOffset != null) {
                l3 = Long.valueOf(timeOffset.getStartOffset());
            } else {
                l3 = null;
            }
            if (timeOffset != null) {
                long startOffset = timeOffset.getStartOffset();
                Long valueOf = Long.valueOf(timeOffset.getDuration());
                if (valueOf == null) {
                    Intrinsics.throwNpe();
                }
                l16 = Long.valueOf(startOffset + valueOf.longValue());
            } else {
                l16 = null;
            }
            IPlayer iPlayer = this.player;
            if (iPlayer != null) {
                cMTimeRange = iPlayer.getPlayTimeRange();
            } else {
                cMTimeRange = null;
            }
            if (cMTimeRange != null) {
                l17 = Long.valueOf(cMTimeRange.getStartUs());
            } else {
                l17 = null;
            }
            if (cMTimeRange != null) {
                l18 = Long.valueOf(cMTimeRange.getEndUs());
            }
            if (l17 != null && l18 != null && l3 != null && l16 != null) {
                if (l17.longValue() >= l3.longValue()) {
                    long min = Math.min(l18.longValue(), l16.longValue());
                    if (l17.longValue() < min) {
                        sd4.b bVar3 = this.stickerTrackerConfig;
                        if (bVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                        }
                        bVar3.o(l17.longValue());
                        sd4.b bVar4 = this.stickerTrackerConfig;
                        if (bVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                        }
                        bVar4.n(min);
                    }
                } else {
                    long min2 = Math.min(l18.longValue(), l16.longValue());
                    if (l3.longValue() < min2) {
                        sd4.b bVar5 = this.stickerTrackerConfig;
                        if (bVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                        }
                        bVar5.o(l3.longValue());
                        sd4.b bVar6 = this.stickerTrackerConfig;
                        if (bVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                        }
                        bVar6.n(min2);
                    }
                }
            }
        }
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleTrackTimeOffset start ");
        sd4.b bVar7 = this.stickerTrackerConfig;
        if (bVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        sb5.append(bVar7.getStickerStartTime());
        sb5.append(" end ");
        sd4.b bVar8 = this.stickerTrackerConfig;
        if (bVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        sb5.append(bVar8.getStickerEndTime());
        Log.i(str, sb5.toString());
        sd4.b bVar9 = this.stickerTrackerConfig;
        if (bVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        if (bVar9.getStickerEndTime() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(TrackingErrorCode errorCode) {
        Thread thread;
        IPlayer iPlayer;
        GYTrackStickerInfo gYTrackStickerInfo;
        Thread thread2;
        IPlayer iPlayer2;
        Log.i(this.TAG, "internalStopTracking " + errorCode.getValue());
        S();
        this.status = StickerTrackerManagerState.Finished;
        g0();
        IRenderChainManager iRenderChainManager = this.playerRenderChain;
        if (iRenderChainManager != null) {
            iRenderChainManager.removeExternalRenderCallback(this.EXTERNAL_RENDER_KEY);
        }
        this.playerRenderChain = null;
        this.isReversing.compareAndSet(true, false);
        IPlayer.PlayerListener playerListener = this.playerListener;
        if (playerListener != null && (iPlayer2 = this.player) != null) {
            iPlayer2.removePlayerListener(playerListener);
        }
        IPlayer iPlayer3 = this.player;
        if (iPlayer3 != null) {
            iPlayer3.pause();
        }
        IPlayer iPlayer4 = this.player;
        if (iPlayer4 != null) {
            iPlayer4.seek(this.detectTime);
        }
        IPlayer iPlayer5 = this.player;
        if (iPlayer5 != null) {
            iPlayer5.setRate(1.0f, this.DEFAULT_MAX_CACHE_SIZE, true);
        }
        IPlayer iPlayer6 = this.player;
        if (iPlayer6 != null) {
            iPlayer6.setEnableSync(true);
        }
        if (errorCode == TrackingErrorCode.CANCEL && (thread2 = this.detectThread) != null) {
            thread2.interrupt();
        }
        do {
            thread = this.detectThread;
            if (thread == null) {
                break;
            } else if (thread == null) {
                Intrinsics.throwNpe();
            }
        } while (thread.isAlive());
        Z(errorCode);
        if (errorCode != TrackingErrorCode.SUCCESS && (gYTrackStickerInfo = this.targetStickerInfo) != null) {
            o0(gYTrackStickerInfo);
        }
        IPlayer iPlayer7 = this.player;
        if (iPlayer7 != null) {
            iPlayer7.play();
        }
        if (this.startTrackingPlayRange != null && (iPlayer = this.player) != null) {
            iPlayer.post(new Function0<Unit>() { // from class: com.tencent.tavcut.core.manager.StickerTrackerManager$internalStopTracking$3
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
                    CMTimeRange cMTimeRange;
                    CMTimeRange cMTimeRange2;
                    IPlayer player = StickerTrackerManager.this.getPlayer();
                    if (player != null) {
                        cMTimeRange = StickerTrackerManager.this.startTrackingPlayRange;
                        if (cMTimeRange == null) {
                            Intrinsics.throwNpe();
                        }
                        long startUs = cMTimeRange.getStartUs();
                        cMTimeRange2 = StickerTrackerManager.this.startTrackingPlayRange;
                        if (cMTimeRange2 == null) {
                            Intrinsics.throwNpe();
                        }
                        player.setPlayTimeRange(startUs, cMTimeRange2.getDurationUs());
                    }
                }
            });
        }
        GYTrackSticker gYTrackSticker = this.stickerTrackerDetector;
        if (gYTrackSticker != null) {
            gYTrackSticker.clearCachedData();
        }
        GYTrackSticker gYTrackSticker2 = this.stickerTrackerDetector;
        if (gYTrackSticker2 != null) {
            gYTrackSticker2.destroyInstance();
        }
        this.stickerTrackerDetector = null;
        U();
        this.player = null;
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        bVar.l(null);
    }

    private final boolean d0() {
        Long l3;
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("playForTracking ");
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            l3 = Long.valueOf(iPlayer.getCurrentPlayUs());
        } else {
            l3 = null;
        }
        sb5.append(l3);
        Log.e(str, sb5.toString());
        IPlayer iPlayer2 = this.player;
        if (iPlayer2 != null) {
            iPlayer2.pause();
        }
        IPlayer iPlayer3 = this.player;
        if (iPlayer3 != null) {
            iPlayer3.setRate(3.0f, this.DEFAULT_MAX_CACHE_SIZE, true);
        }
        return h0();
    }

    private final void e0(Entity entity, int targetEntityId) {
        this.entityTree.add(entity);
        Intrinsics.checkExpressionValueIsNotNull(entity.getChildren(), "entity.children");
        if (!r0.isEmpty()) {
            List<Entity> children = entity.getChildren();
            Intrinsics.checkExpressionValueIsNotNull(children, "entity.children");
            for (Entity it : children) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                e0(it, targetEntityId);
            }
        }
    }

    private final Entity f0(int entityId) {
        Entity entity;
        Log.i(this.TAG, "queryEntityByEntityId " + entityId);
        IRenderChainManager iRenderChainManager = this.playerRenderChain;
        if (iRenderChainManager != null) {
            entity = iRenderChainManager.getRootEntity();
        } else {
            entity = null;
        }
        if (entity == null) {
            return null;
        }
        e0(entity, entityId);
        for (Entity entity2 : this.entityTree) {
            if (entity2.getId() == entityId) {
                return entity2;
            }
        }
        return null;
    }

    private final void g0() {
        IRenderChainManager iRenderChainManager;
        Entity entity = this.externalEntity;
        if (entity != null && (iRenderChainManager = this.playerRenderChain) != null) {
            iRenderChainManager.removeEntity(entity);
        }
        IRenderChainManager iRenderChainManager2 = this.playerRenderChain;
        if (iRenderChainManager2 != null) {
            iRenderChainManager2.emit();
        }
    }

    private final boolean h0() {
        List<ClipAsset> list;
        IRenderChainManager iRenderChainManager = this.playerRenderChain;
        if (iRenderChainManager != null) {
            list = iRenderChainManager.getClipAssets();
        } else {
            list = null;
        }
        if (list == null) {
            Log.e(this.TAG, "reversePlay failed: clipAsset null ");
            c0(TrackingErrorCode.FAILED);
            return false;
        }
        long j3 = 0;
        long j16 = 0;
        for (ClipAsset clipAsset : list) {
            if (clipAsset.type() == ClipAsset.VIDEO) {
                Iterator<Long> it = com.tencent.tavcut.core.utils.a.b(clipAsset.path).iterator();
                while (it.hasNext()) {
                    this.keyFrameTimeUs.add(Long.valueOf(it.next().longValue() + j16));
                }
            } else if (clipAsset.type() == ClipAsset.PHOTO) {
                long j17 = clipAsset.duration / 1000000;
                for (long j18 = 0; j18 < j17; j18++) {
                    this.keyFrameTimeUs.add(Long.valueOf((j18 * 1000000) + j16));
                }
            }
            long j19 = clipAsset.duration;
            j16 += j19;
            j3 += j19;
        }
        if (this.keyFrameTimeUs.size() > 0) {
            List<Long> list2 = this.keyFrameTimeUs;
            if (list2.get(list2.size() - 1).longValue() < j3) {
                this.keyFrameTimeUs.add(Long.valueOf(j3));
            }
        }
        Log.i(this.TAG, "keyFrameTimeUs " + this.keyFrameTimeUs);
        if (this.playerListener == null) {
            this.playerListener = new c();
        }
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            IPlayer.PlayerListener playerListener = this.playerListener;
            if (playerListener == null) {
                Intrinsics.throwNpe();
            }
            iPlayer.addPlayerListener(playerListener);
        }
        IPlayer iPlayer2 = this.player;
        if (iPlayer2 != null) {
            iPlayer2.requestRender();
        }
        IPlayer iPlayer3 = this.player;
        if (iPlayer3 != null) {
            iPlayer3.play();
        }
        return true;
    }

    private final void i0(Bitmap bitmap, File file) {
        if (file.createNewFile()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
            fileOutputStream.close();
            return;
        }
        throw new RuntimeException("createNewFile return false, path = " + file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(long time, boolean isRevert) {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.pause();
        }
        IPlayer iPlayer2 = this.player;
        if (iPlayer2 != null) {
            this.pauseStamp = iPlayer2.getCurrentPlayUs();
        }
        this.isReversing.compareAndSet(!isRevert, isRevert);
        IPlayer iPlayer3 = this.player;
        if (iPlayer3 != null) {
            iPlayer3.seek(time);
        }
        Log.i(this.TAG, "reversePlay seek " + time);
        IPlayer iPlayer4 = this.player;
        if (iPlayer4 != null) {
            iPlayer4.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(long lastTimeStamp) {
        float stickerStartTime;
        long stickerEndTime;
        long stickerStartTime2;
        com.tencent.tavcut.core.manager.a aVar;
        try {
            long j3 = this.detectTime;
            if (lastTimeStamp < j3) {
                stickerStartTime = (float) (j3 - lastTimeStamp);
                sd4.b bVar = this.stickerTrackerConfig;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                stickerEndTime = bVar.getStickerEndTime();
                sd4.b bVar2 = this.stickerTrackerConfig;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                stickerStartTime2 = bVar2.getStickerStartTime();
            } else {
                long j16 = lastTimeStamp - j3;
                sd4.b bVar3 = this.stickerTrackerConfig;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                stickerStartTime = (float) (j16 + (j3 - bVar3.getStickerStartTime()));
                sd4.b bVar4 = this.stickerTrackerConfig;
                if (bVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                stickerEndTime = bVar4.getStickerEndTime();
                sd4.b bVar5 = this.stickerTrackerConfig;
                if (bVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                stickerStartTime2 = bVar5.getStickerStartTime();
            }
            float f16 = stickerStartTime / ((float) (stickerEndTime - stickerStartTime2));
            sd4.b bVar6 = this.stickerTrackerConfig;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            Entity entity = bVar6.getEntity();
            if (entity != null && (aVar = this.trackingCallback) != null) {
                sd4.b bVar7 = this.stickerTrackerConfig;
                if (bVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                aVar.b(f16, bVar7.getStickerName(), entity);
            }
        } catch (Exception e16) {
            Log.e(this.TAG, "trackingProcess error " + e16);
        }
    }

    private final void n0(TimeOffset stickerTimeOffset) {
        List<ClipAsset> list;
        long j3;
        long coerceAtLeast;
        IRenderChainManager iRenderChainManager = this.playerRenderChain;
        if (iRenderChainManager != null) {
            list = iRenderChainManager.getClipAssets();
        } else {
            list = null;
        }
        IPlayer iPlayer = this.player;
        long j16 = 0;
        if (iPlayer != null) {
            j3 = iPlayer.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        if (j3 > 0 && list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                long j17 = ((ClipAsset) it.next()).duration;
                j16 += j17;
                if (j3 < j16) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j16 - j17, stickerTimeOffset.getStartOffset());
                    stickerTimeOffset.setStartOffset(coerceAtLeast);
                    stickerTimeOffset.setEndOffset(stickerTimeOffset.getStartOffset() + stickerTimeOffset.getDuration());
                    Log.i(this.TAG, " duration startOffset: " + stickerTimeOffset.getStartOffset());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(GYTrackStickerInfo result) {
        Collection<Component> components;
        if (result.confidence != -1.0f) {
            sd4.b bVar = this.stickerTrackerConfig;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            if (bVar.getEntity() != null) {
                sd4.b bVar2 = this.stickerTrackerConfig;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
                }
                Entity entity = bVar2.getEntity();
                if (entity != null && (components = entity.getComponents()) != null) {
                    for (Component component : components) {
                        if (component instanceof ScreenTransform) {
                            ScreenTransform screenTransform = (ScreenTransform) component;
                            screenTransform.setAnchor(com.tencent.tavcut.core.utils.c.b(result));
                            screenTransform.setScale(new Vec3(1.0f, 1.0f, 1.0f));
                            screenTransform.setOffset(com.tencent.tavcut.core.utils.c.a(result));
                        }
                    }
                }
            }
        }
    }

    public final void U() {
        Log.i(this.TAG, "clearCache ");
        this.trackingCallback = null;
        this.dataDispatcher = null;
        SimpleGLThread simpleGLThread = this.glThread;
        if (simpleGLThread != null) {
            if (simpleGLThread != null) {
                simpleGLThread.destroy();
            }
            this.glThread = null;
        }
        if (this.detectThread != null) {
            this.detectThread = null;
        }
        this.totalFrameStack.clear();
        this.keyFrameTimeUs.clear();
        this.trackerTimeStampRecord.clear();
        if (new File(this.fileCacheDir).exists()) {
            new File(this.fileCacheDir).delete();
        }
    }

    @Nullable
    /* renamed from: W, reason: from getter */
    public final IPlayer getPlayer() {
        return this.player;
    }

    @NotNull
    public final sd4.b X() {
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        return bVar;
    }

    public final int b0(@Nullable IPlayer curPlayer, @Nullable IRenderChainManager curPlayerRenderChain, @Nullable RenderDataDispatcher curDataDispatcher, @NotNull sd4.b trackConfig) {
        boolean z16;
        Integer num;
        Intrinsics.checkParameterIsNotNull(trackConfig, "trackConfig");
        Log.i(this.TAG, "init entityId " + trackConfig.getCom.tencent.tavcut.rendermodel.parser.TemplateParser.KEY_ENTITY_ID java.lang.String() + " skipFrames " + trackConfig.getSkipFrames() + " stickerStartTime " + trackConfig.getStickerStartTime() + " stickerEndTime " + trackConfig.getStickerEndTime() + " cachePath " + trackConfig.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.CACHE_PATH java.lang.String() + " modePath " + trackConfig.e());
        if (curPlayer == null) {
            return InitErrorCode.ERROR_PLAYER.getValue();
        }
        if (curPlayerRenderChain == null) {
            return InitErrorCode.ERROR_RENDER_CHAIN.getValue();
        }
        if (curDataDispatcher == null) {
            return InitErrorCode.ERROR_RENDER_CHAIN.getValue();
        }
        this.player = curPlayer;
        this.playerRenderChain = curPlayerRenderChain;
        this.dataDispatcher = curDataDispatcher;
        if (trackConfig.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.CACHE_PATH java.lang.String() != null) {
            String str = trackConfig.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.CACHE_PATH java.lang.String();
            if (str == null) {
                Intrinsics.throwNpe();
            }
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                StringBuilder sb5 = new StringBuilder();
                String str2 = trackConfig.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.CACHE_PATH java.lang.String();
                if (str2 == null) {
                    Intrinsics.throwNpe();
                }
                sb5.append(str2);
                sb5.append(String.valueOf(System.currentTimeMillis()));
                sb5.append(File.separator);
                this.fileCacheDir = sb5.toString();
                this.stickerTrackerConfig = trackConfig;
                GYTrackSticker gYTrackSticker = new GYTrackSticker();
                this.stickerTrackerDetector = gYTrackSticker;
                gYTrackSticker.initInstance(new SDKDeviceConfig());
                SDKModelConfig sDKModelConfig = new SDKModelConfig();
                sDKModelConfig.modelPaths = trackConfig.e();
                GYTrackSticker gYTrackSticker2 = this.stickerTrackerDetector;
                if (gYTrackSticker2 != null) {
                    num = Integer.valueOf(gYTrackSticker2.setupWithModel(sDKModelConfig));
                } else {
                    num = null;
                }
                if (num == null || num.intValue() != 0) {
                    return InitErrorCode.ERROR_MODEL_PATH.getValue();
                }
                return InitErrorCode.SUCCESS.getValue();
            }
        }
        return InitErrorCode.ERROR_CACHE_DIR.getValue();
    }

    public final boolean k0(@NotNull com.tencent.tavcut.core.manager.a callback) {
        CMTimeRange cMTimeRange;
        IPlayer iPlayer;
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Log.i(this.TAG, "startTracking ");
        this.startTrackingTime = System.currentTimeMillis();
        IPlayer iPlayer2 = this.player;
        Entity entity = null;
        if (iPlayer2 != null) {
            cMTimeRange = iPlayer2.getPlayTimeRange();
        } else {
            cMTimeRange = null;
        }
        if (cMTimeRange == null) {
            Intrinsics.throwNpe();
        }
        this.startTrackingPlayRange = cMTimeRange;
        StickerTrackerManagerState stickerTrackerManagerState = this.status;
        StickerTrackerManagerState stickerTrackerManagerState2 = StickerTrackerManagerState.Working;
        if (stickerTrackerManagerState == stickerTrackerManagerState2) {
            return false;
        }
        sd4.b bVar = this.stickerTrackerConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        if (bVar.getEntity() == null) {
            sd4.b bVar2 = this.stickerTrackerConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            sd4.b bVar3 = this.stickerTrackerConfig;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
            }
            Integer num = bVar3.getCom.tencent.tavcut.rendermodel.parser.TemplateParser.KEY_ENTITY_ID java.lang.String();
            if (num != null) {
                entity = f0(num.intValue());
            }
            bVar2.l(entity);
        }
        sd4.b bVar4 = this.stickerTrackerConfig;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        if (bVar4.getEntity() == null) {
            Log.e(this.TAG, "error code: " + InitErrorCode.ERROR_STICKER_ENTITY_NOT_FOUND.getValue());
            return false;
        }
        sd4.b bVar5 = this.stickerTrackerConfig;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        if (!bVar5.getPlayerSkipFrame() && (iPlayer = this.player) != null) {
            iPlayer.setEnableSync(false);
        }
        this.status = stickerTrackerManagerState2;
        this.trackingCallback = callback;
        Q();
        sd4.b bVar6 = this.stickerTrackerConfig;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerTrackerConfig");
        }
        Entity entity2 = bVar6.getEntity();
        if (entity2 == null) {
            Intrinsics.throwNpe();
        }
        final ScreenTransform g16 = com.tencent.tavcut.core.utils.c.g(entity2);
        if (g16 == null) {
            return false;
        }
        if (!a0()) {
            Log.e(this.TAG, "error code: " + InitErrorCode.ERROR_STICKER_END_TIME_NO_LEGAL.getValue());
            return false;
        }
        IRenderChainManager iRenderChainManager = this.playerRenderChain;
        if (iRenderChainManager != null) {
            iRenderChainManager.addExternalRenderCallback(this.EXTERNAL_RENDER_KEY, new StickerTrackerManager$startTracking$2(this));
        }
        BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.tavcut.core.manager.StickerTrackerManager$startTracking$3
            /* JADX WARN: Incorrect condition in loop: B:29:0x01c4 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                boolean z16;
                StickerTrackerManager.StickerTrackerManagerState stickerTrackerManagerState3;
                List list;
                StickerTrackerManager.a V;
                boolean z17;
                GYTrackStickerInfo gYTrackStickerInfo;
                Float f16;
                GYTrackStickerInfo gYTrackStickerInfo2;
                Float f17;
                GYTrackStickerInfo gYTrackStickerInfo3;
                Float f18;
                GYTrackStickerInfo gYTrackStickerInfo4;
                GYTrackSticker gYTrackSticker;
                GYTrackStickerInfo gYTrackStickerInfo5;
                GYTrackSticker gYTrackSticker2;
                long j3;
                long j16;
                GYTrackSticker gYTrackSticker3;
                long j17;
                GYTrackSticker gYTrackSticker4;
                List list2;
                long j18 = 0;
                while (true) {
                    try {
                        z16 = StickerTrackerManager.this.isCanceled;
                        if (!z16) {
                            stickerTrackerManagerState3 = StickerTrackerManager.this.status;
                            boolean z18 = true;
                            int i3 = 1;
                            if (stickerTrackerManagerState3 != StickerTrackerManager.StickerTrackerManagerState.Working) {
                                list2 = StickerTrackerManager.this.totalFrameStack;
                                if (!(!list2.isEmpty())) {
                                    return;
                                }
                            }
                            list = StickerTrackerManager.this.totalFrameStack;
                            if (!list.isEmpty()) {
                                V = StickerTrackerManager.this.V();
                                z17 = StickerTrackerManager.this.isFirstFrameDetect;
                                Float f19 = null;
                                if (z17) {
                                    if (V.getBitmap() != null) {
                                        StickerTrackerManager.this.isFirstFrameDetect = false;
                                        StickerTrackerManager stickerTrackerManager = StickerTrackerManager.this;
                                        ScreenTransform screenTransform = g16;
                                        Bitmap bitmap = V.getBitmap();
                                        if (bitmap == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        int width = bitmap.getWidth();
                                        Bitmap bitmap2 = V.getBitmap();
                                        if (bitmap2 == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        stickerTrackerManager.targetStickerInfo = c.c(screenTransform, width, bitmap2.getHeight(), V.getTimeStamp());
                                        String str = StickerTrackerManager.this.TAG;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("detect first frame:");
                                        sb5.append(((float) V.getTimeStamp()) / 1000.0f);
                                        sb5.append(',');
                                        if (V.getBitmap() != null) {
                                            z18 = false;
                                        }
                                        sb5.append(z18);
                                        sb5.append(',');
                                        sb5.append("x:");
                                        gYTrackStickerInfo = StickerTrackerManager.this.targetStickerInfo;
                                        if (gYTrackStickerInfo != null) {
                                            f16 = Float.valueOf(gYTrackStickerInfo.f35992x);
                                        } else {
                                            f16 = null;
                                        }
                                        sb5.append(f16);
                                        sb5.append(",y:");
                                        gYTrackStickerInfo2 = StickerTrackerManager.this.targetStickerInfo;
                                        if (gYTrackStickerInfo2 != null) {
                                            f17 = Float.valueOf(gYTrackStickerInfo2.f35993y);
                                        } else {
                                            f17 = null;
                                        }
                                        sb5.append(f17);
                                        sb5.append(",w:");
                                        gYTrackStickerInfo3 = StickerTrackerManager.this.targetStickerInfo;
                                        if (gYTrackStickerInfo3 != null) {
                                            f18 = Float.valueOf(gYTrackStickerInfo3.f35991w);
                                        } else {
                                            f18 = null;
                                        }
                                        sb5.append(f18);
                                        sb5.append(",h:");
                                        gYTrackStickerInfo4 = StickerTrackerManager.this.targetStickerInfo;
                                        if (gYTrackStickerInfo4 != null) {
                                            f19 = Float.valueOf(gYTrackStickerInfo4.f35990h);
                                        }
                                        sb5.append(f19);
                                        sb5.append(" imageW:");
                                        Bitmap bitmap3 = V.getBitmap();
                                        if (bitmap3 == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        sb5.append(bitmap3.getWidth());
                                        sb5.append(" imageW:");
                                        Bitmap bitmap4 = V.getBitmap();
                                        if (bitmap4 == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        sb5.append(bitmap4.getHeight());
                                        Log.i(str, sb5.toString());
                                        gYTrackSticker = StickerTrackerManager.this.stickerTrackerDetector;
                                        if (gYTrackSticker != null) {
                                            Bitmap bitmap5 = V.getBitmap();
                                            gYTrackStickerInfo5 = StickerTrackerManager.this.targetStickerInfo;
                                            gYTrackSticker.detect(bitmap5, gYTrackStickerInfo5);
                                        }
                                        j18 = V.getTimeStamp();
                                    }
                                } else {
                                    GYTrackStickerInfo gYTrackStickerInfo6 = new GYTrackStickerInfo();
                                    gYTrackStickerInfo6.timestamp = V.getTimeStamp();
                                    if (j18 < StickerTrackerManager.this.detectTime && V.getTimeStamp() >= StickerTrackerManager.this.detectTime) {
                                        j18 = StickerTrackerManager.this.detectTime;
                                        gYTrackSticker4 = StickerTrackerManager.this.stickerTrackerDetector;
                                        if (gYTrackSticker4 != null) {
                                            gYTrackSticker4.resetToAnchorFrame();
                                        }
                                        Log.i(StickerTrackerManager.this.TAG, "resetToAnchorFrame " + V.getTimeStamp());
                                    }
                                    if (StickerTrackerManager.this.X().getAddEmptyTrackEnable()) {
                                        while (r8 >= j3) {
                                            if (V.getTimeStamp() > j18) {
                                                j17 = StickerTrackerManager.this.STICKER_PER_FRAME_DURATION;
                                                j18 += j17;
                                            } else {
                                                j16 = StickerTrackerManager.this.STICKER_PER_FRAME_DURATION;
                                                j18 -= j16;
                                            }
                                            GYTrackStickerInfo gYTrackStickerInfo7 = new GYTrackStickerInfo();
                                            gYTrackStickerInfo7.timestamp = j18;
                                            gYTrackSticker3 = StickerTrackerManager.this.stickerTrackerDetector;
                                            if (gYTrackSticker3 != null) {
                                                gYTrackSticker3.track(null, gYTrackStickerInfo7, 1);
                                            }
                                        }
                                    }
                                    gYTrackSticker2 = StickerTrackerManager.this.stickerTrackerDetector;
                                    if (gYTrackSticker2 != null) {
                                        Bitmap bitmap6 = V.getBitmap();
                                        if (V.getBitmap() != null) {
                                            i3 = 0;
                                        }
                                        gYTrackSticker2.track(bitmap6, gYTrackStickerInfo6, i3);
                                    }
                                    j18 = V.getTimeStamp();
                                    if (StickerTrackerManager.this.X().getUpdateStickerInLoading()) {
                                        StickerTrackerManager.this.o0(gYTrackStickerInfo6);
                                    }
                                    StickerTrackerManager.this.m0(j18);
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (InterruptedException e16) {
                        Log.e(StickerTrackerManager.this.TAG, "Interrupted stopTracking ", e16);
                        return;
                    }
                }
            }
        });
        baseThread.start();
        this.detectThread = baseThread;
        return d0();
    }

    @Nullable
    public final GYTrackStickerInfo l0() {
        Log.i(this.TAG, "stopTracking ");
        this.isCanceled = true;
        c0(TrackingErrorCode.CANCEL);
        return this.targetStickerInfo;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/tavcut/core/manager/StickerTrackerManager$a;", "", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "e", "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "b", "J", "c", "()J", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "Ljava/io/File;", "Ljava/io/File;", "()Ljava/io/File;", "g", "(Ljava/io/File;)V", "file", "", "d", "Z", "()Z", "f", "(Z)V", QAdRewardDefine$VideoParams.ISCACHE, "<init>", "(Landroid/graphics/Bitmap;JLjava/io/File;Z)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap bitmap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long timeStamp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private File file;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isCache;

        public a(@Nullable Bitmap bitmap, long j3, @Nullable File file, boolean z16) {
            this.bitmap = bitmap;
            this.timeStamp = j3;
            this.file = file;
            this.isCache = z16;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* renamed from: c, reason: from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsCache() {
            return this.isCache;
        }

        public final void e(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public final void f(boolean z16) {
            this.isCache = z16;
        }

        public final void g(@Nullable File file) {
            this.file = file;
        }

        public /* synthetic */ a(Bitmap bitmap, long j3, File file, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, j3, (i3 & 4) != 0 ? null : file, (i3 & 8) != 0 ? false : z16);
        }
    }
}

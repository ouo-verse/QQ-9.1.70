package com.tencent.filament.zplan.scene.square;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.Animation;
import com.tencent.filament.zplan.animation.sequencer.AnimationType;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Status;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \u0092\u00012\u00020\u0001:\u0002\b BN\u0012\u0006\u0010~\u001a\u00020\u001e\u0012\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u007f\u0012\u0007\u0010&\u001a\u00030\u0084\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010\u008d\u0001\u001a\u00030\u008a\u0001\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0014\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u0002j\u0002`\fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J&\u0010 \u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016JB\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020)J8\u00100\u001a\u0004\u0018\u00010/2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020)J9\u00104\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#2\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201\"\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105J\b\u00106\u001a\u00020\u0005H\u0002J\u0014\u00107\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0014\u00109\u001a\u00020\u00052\n\u00108\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0014\u0010:\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010;\u001a\u00020\u0005H\u0002J&\u0010<\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002JC\u0010B\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010$\u001a\u00020#2\n\u0010=\u001a\u00060\u0002j\u0002`\u00032\b\u0010>\u001a\u0004\u0018\u0001022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002\u00a2\u0006\u0004\bB\u0010CJ\u0014\u0010D\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002R\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010FR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010FR\u0014\u0010I\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010FR\u001a\u0010K\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010JR\u001a\u0010L\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010JR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0018\u0010W\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001a\u0010Y\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010JR\u0014\u0010[\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010FR\u001a\u0010]\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010JR\u0016\u0010`\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010_R\u001a\u0010d\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010JR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u001a\u0010q\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010JR\u001a\u0010s\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010JR\u001a\u0010u\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010JR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010JR\u0014\u0010~\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010&\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010_R\u0016\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapObjectAvatar;", "Lcom/tencent/filament/zplan/scene/square/d;", "", "Lcom/tencent/filament/zplan/scene/square/EngineTime;", "nowTime", "", "c", "frameId", "a", "play", "stop", "reset", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "renderObjectId", "", "g", "e", "destroy", NodeProps.VISIBLE, "setVisibility", "", "resource", "f", "Lcom/tencent/filament/zplan/scene/square/Location;", "location", "durationMs", "d", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "hostAnim", "guestAnim", "", "extraAnimGltf", "b", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "avatarData", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "avatarResource", "Lcom/tencent/filament/zplan/scene/square/Size;", "size", "Lcom/tencent/filament/zplan/scene/square/a;", "M", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/filament/zplan/scene/square/c;", "N", "", "Lcom/tencent/filament/zplan/scene/square/f;", "objects", "L", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;[Lcom/tencent/filament/zplan/scene/square/f;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "O", "nowInterval", "K", "P", ExifInterface.LATITUDE_SOUTH, "T", "prevAnimTime", "renderObject", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "nextAnimList", BdhLogUtil.LogTag.Tag_Req, "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;JLcom/tencent/filament/zplan/scene/square/f;Ljava/util/List;)Ljava/lang/Long;", "U", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ready", QzoneWebMusicJsPlugin.EVENT_PLAYING, "rendered", "J", "lastAnimTime", "stopAnimTime", "", "Lcom/tencent/filament/zplan/scene/square/SquareMapObjectAvatar$b;", "Ljava/util/Set;", "syncFrameBlocks", "Lcom/tencent/filament/zplan/scene/square/a;", "hostObject", tl.h.F, "guestObject", "i", "Lcom/tencent/filament/zplan/scene/square/c;", "extraObject", "j", "animationBeginTime", "k", "moving", "l", "moveStartTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplan/scene/square/Location;", "moveFrom", DomainData.DOMAIN_NAME, CanvasView.ACTION_MOVETO, "o", "moveDuration", "Lkotlinx/coroutines/Deferred;", "p", "Lkotlinx/coroutines/Deferred;", "reloadDeferred", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "isDestroyed", "Lcom/tencent/filament/zplan/scene/square/AvatarAnimationState;", "r", "Lcom/tencent/filament/zplan/scene/square/AvatarAnimationState;", "avatarAnimationState", ReportConstant.COSTREPORT_PREFIX, "interactionDuration", "t", "interactionStartTime", "u", "backToIdleAnimationBeginTimeDiff", "Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "v", "Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "statistics", "w", "createTs", HippyTKDListViewAdapter.X, "Ljava/lang/String;", "id", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/scene/square/e;", "y", "Ljava/lang/ref/WeakReference;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/tencent/filament/zplan/scene/square/Size;", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "depth", "D", "Lcom/tencent/zplan/zplantracing/c;", "<init>", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;Lcom/tencent/filament/zplan/scene/square/Location;Lcom/tencent/filament/zplan/scene/square/Size;FLcom/tencent/zplan/zplantracing/c;)V", "E", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareMapObjectAvatar implements d {

    /* renamed from: A, reason: from kotlin metadata */
    private Location location;

    /* renamed from: B, reason: from kotlin metadata */
    private final Size size;

    /* renamed from: C, reason: from kotlin metadata */
    private final float depth;

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.zplan.zplantracing.c spanContext;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean ready;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean playing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean rendered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastAnimTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long stopAnimTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Set<b> syncFrameBlocks;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AvatarRenderObject hostObject;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AvatarRenderObject guestObject;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ExtraRenderObject extraObject;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long animationBeginTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean moving;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long moveStartTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Location moveFrom;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Location moveTo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long moveDuration;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Deferred<Unit> reloadDeferred;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private AvatarAnimationState avatarAnimationState;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long interactionDuration;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private long interactionStartTime;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long backToIdleAnimationBeginTimeDiff;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private SquareLoadObjectStatistics statistics;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private long createTs;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<e> parent;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private SquareAvatarData avatarData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapObjectAvatar$b;", "", "", "frameId", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    private interface b {
        void a(long frameId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/scene/square/SquareMapObjectAvatar$animate$1$1$1", "Lcom/tencent/filament/zplan/scene/square/SquareMapObjectAvatar$b;", "", "frameId", "", "a", "zplan-android_release", "com/tencent/filament/zplan/scene/square/SquareMapObjectAvatar$$special$$inlined$synchronized$lambda$1"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Long f106069b;

        c(Long l3) {
            this.f106069b = l3;
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar.b
        public void a(long frameId) {
            SquareMapObjectAvatar.this.statistics.setLoadCost(System.currentTimeMillis() - SquareMapObjectAvatar.this.createTs);
            if (frameId - this.f106069b.longValue() >= 0) {
                e eVar = (e) SquareMapObjectAvatar.this.parent.get();
                if (eVar != null) {
                    eVar.e(new OnObjectStateChangedEvent(SquareMapObjectAvatar.this.id, ObjectState.LOADED, SquareMapObjectAvatar.this.statistics));
                }
                SquareMapObjectAvatar.this.syncFrameBlocks.remove(this);
            }
        }
    }

    public SquareMapObjectAvatar(@NotNull String id5, @NotNull WeakReference<e> parent, @NotNull SquareAvatarData avatarData, @NotNull Location location, @NotNull Size size, float f16, @Nullable com.tencent.zplan.zplantracing.c cVar) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        this.id = id5;
        this.parent = parent;
        this.avatarData = avatarData;
        this.location = location;
        this.size = size;
        this.depth = f16;
        this.spanContext = cVar;
        this.ready = new AtomicBoolean(false);
        this.playing = new AtomicBoolean(true);
        this.rendered = new AtomicBoolean(false);
        this.syncFrameBlocks = new LinkedHashSet();
        this.moving = new AtomicBoolean(false);
        this.moveFrom = new Location(0.0f, 0.0f, 3, null);
        this.moveTo = new Location(0.0f, 0.0f, 3, null);
        this.avatarAnimationState = AvatarAnimationState.IDLE;
        this.statistics = new SquareLoadObjectStatistics(id5, ObjectType.AVATAR, 0L, 0L, false, 0L, 0L, 0L, false, false, 1020, null);
        this.createTs = System.currentTimeMillis();
        Q();
    }

    private final void K(long nowInterval) {
        double d16;
        e eVar;
        FilamentAnimation headAnim;
        LongCompanionObject longCompanionObject = LongCompanionObject.INSTANCE;
        AvatarRenderObject avatarRenderObject = this.hostObject;
        if (avatarRenderObject != null && (headAnim = avatarRenderObject.getHeadAnim()) != null) {
            d16 = headAnim.getDuration();
        } else {
            d16 = 0.0d;
        }
        long d17 = com.tencent.filament.zplan.scene.square.b.d(longCompanionObject, d16);
        if (com.tencent.filament.zplan.scene.square.b.e(d17)) {
            return;
        }
        if ((nowInterval + com.tencent.filament.zplan.scene.square.b.d(longCompanionObject, 0.06666666666666667d)) % d17 < nowInterval % d17 && (eVar = this.parent.get()) != null) {
            eVar.e(new OnObjectAnimationLastFrameEvent(this.id));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(long nowTime) {
        long j3;
        Long l3;
        Long l16;
        List listOfNotNull;
        FilamentViewerV2305 b16;
        if (com.tencent.filament.zplan.scene.square.b.e(this.animationBeginTime)) {
            this.animationBeginTime = nowTime;
            j3 = 0;
        } else {
            j3 = nowTime - this.animationBeginTime;
        }
        Long[] lArr = new Long[3];
        AvatarRenderObject avatarRenderObject = this.hostObject;
        Long l17 = null;
        if (avatarRenderObject != null) {
            l3 = Long.valueOf(avatarRenderObject.d());
        } else {
            l3 = null;
        }
        lArr[0] = l3;
        AvatarRenderObject avatarRenderObject2 = this.guestObject;
        if (avatarRenderObject2 != null) {
            l16 = Long.valueOf(avatarRenderObject2.d());
        } else {
            l16 = null;
        }
        lArr[1] = l16;
        ExtraRenderObject extraRenderObject = this.extraObject;
        if (extraRenderObject != null) {
            l17 = Long.valueOf(extraRenderObject.d());
        }
        lArr[2] = l17;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) lArr);
        Iterator it = listOfNotNull.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            e eVar = this.parent.get();
            if (eVar != null && (b16 = eVar.b()) != null) {
                b16.applyAnimation(longValue, com.tencent.filament.zplan.scene.square.b.h(j3));
            }
        }
        K(j3);
    }

    private final void P(long nowTime) {
        if (!this.moving.get()) {
            return;
        }
        long j3 = (nowTime - this.moveStartTime) / this.moveDuration;
        if (j3 >= 1.0d) {
            this.moving.set(false);
            this.location = this.moveTo;
            e();
        } else {
            float f16 = (float) j3;
            this.location = new Location(this.moveFrom.getX() + ((this.moveTo.getX() - this.moveFrom.getX()) * f16), this.moveFrom.getY() + ((this.moveTo.getY() - this.moveFrom.getY()) * f16));
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void Q() {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        if (this.isDestroyed) {
            FLog.INSTANCE.d("SquareMapObjectAvatar", "reloadRenderObjects is destroyed");
            return;
        }
        Deferred<Unit> deferred = this.reloadDeferred;
        Deferred<Unit> deferred2 = null;
        if (deferred != null && deferred.isActive()) {
            FLog.INSTANCE.d("SquareMapObjectAvatar", "reloadRenderObjects is running");
            e eVar = this.parent.get();
            if (eVar != null && (coroutineScope2 = eVar.getCoroutineScope()) != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new SquareMapObjectAvatar$reloadRenderObjects$1(this, null), 3, null);
            }
            return;
        }
        e eVar2 = this.parent.get();
        if (eVar2 != null && (coroutineScope = eVar2.getCoroutineScope()) != null) {
            deferred2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SquareMapObjectAvatar$reloadRenderObjects$2(this, null), 3, null);
        }
        this.reloadDeferred = deferred2;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private final Long R(FilamentViewerV2305 viewer, long prevAnimTime, f renderObject, List<FilamentAnimation> nextAnimList) {
        Object orNull;
        ?? r26 = 0;
        if (renderObject == null) {
            return null;
        }
        if (renderObject.b().size() != nextAnimList.size()) {
            FLog.INSTANCE.e("SquareAvatarScene", "changeAnimationOnce: anim size not match");
            return null;
        }
        long objectId = renderObject.getObjectId();
        List<FilamentAnimation> b16 = renderObject.b();
        viewer.cleanAnimationTracks(this.spanContext, objectId);
        boolean z16 = false;
        double d16 = 0.0d;
        int i3 = 0;
        for (Object obj : b16) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            FilamentAnimation filamentAnimation = (FilamentAnimation) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(nextAnimList, i3);
            FilamentAnimation filamentAnimation2 = (FilamentAnimation) orNull;
            if (filamentAnimation2 != null) {
                Track track = new Track(z16, r26, 3, r26);
                AnimationType animationType = AnimationType.BLENDER;
                double d17 = d16;
                track.getAnimations().add(new Animation(0.2d, new Status(filamentAnimation.getPath(), filamentAnimation.getIndex(), prevAnimTime % filamentAnimation.getDuration()), new Status(filamentAnimation2.getPath(), filamentAnimation2.getIndex(), 0.2d), 0.0d, animationType));
                track.getAnimations().add(new NormalAnimation((filamentAnimation2.getDuration() - 0.2d) - 0.2d, filamentAnimation2, 0.2d, 0.2d, filamentAnimation2.getDuration() - 0.2d));
                track.getAnimations().add(new Animation(0.2d, new Status(filamentAnimation2.getPath(), filamentAnimation2.getIndex(), filamentAnimation2.getDuration() - 0.2d), new Status(filamentAnimation.getPath(), filamentAnimation.getIndex(), 0.2d), filamentAnimation2.getDuration() - 0.2d, animationType));
                viewer.bindAnimationTrack(this.spanContext, objectId, track);
                if (filamentAnimation2.getDuration() > d17) {
                    d16 = filamentAnimation2.getDuration();
                } else {
                    d16 = d17;
                }
                i3 = i16;
                r26 = 0;
                z16 = false;
            } else {
                i3 = i16;
            }
        }
        return Long.valueOf(com.tencent.filament.zplan.scene.square.b.d(LongCompanionObject.INSTANCE, d16));
    }

    private final void S() {
        FilamentViewerV2305 b16;
        List<f> listOfNotNull;
        List mutableListOf;
        e eVar = this.parent.get();
        if (eVar != null && (b16 = eVar.b()) != null) {
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new f[]{this.hostObject, this.guestObject, this.extraObject});
            for (f fVar : listOfNotNull) {
                b16.cleanAnimationTracks(this.spanContext, fVar.getObjectId());
                Iterator<T> it = fVar.b().iterator();
                while (it.hasNext()) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a((FilamentAnimation) it.next()));
                    b16.bindAnimationTrack(this.spanContext, fVar.getObjectId(), new Track(true, mutableListOf));
                }
            }
            this.animationBeginTime = this.lastAnimTime + this.backToIdleAnimationBeginTimeDiff;
            this.avatarAnimationState = AvatarAnimationState.IDLE;
            e eVar2 = this.parent.get();
            if (eVar2 != null) {
                eVar2.e(new OnObjectStateChangedEvent(this.id, ObjectState.LOADED, null, 4, null));
            }
            FLog.INSTANCE.i("SquareMapObjectAvatar", "switchToIdleAnimationState done " + this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(SquareAvatarData.AvatarAnim hostAnim, SquareAvatarData.AvatarAnim guestAnim, String extraAnimGltf) {
        FilamentViewerV2305 b16;
        String str;
        String str2;
        List listOfNotNull;
        String str3;
        String str4;
        List listOfNotNull2;
        List listOfNotNull3;
        List listOf;
        int collectionSizeOrDefault;
        long j3;
        long j16;
        e eVar = this.parent.get();
        if (eVar != null && (b16 = eVar.b()) != null) {
            com.tencent.zplan.zplantracing.c cVar = this.spanContext;
            String[] strArr = new String[2];
            Object obj = null;
            if (hostAnim != null) {
                str = hostAnim.getHeadAnimGltf();
            } else {
                str = null;
            }
            strArr[0] = str;
            if (hostAnim != null) {
                str2 = hostAnim.getBodyAnimGltf();
            } else {
                str2 = null;
            }
            strArr[1] = str2;
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr);
            List<FilamentAnimation> f16 = com.tencent.filament.zplan.scene.square.b.f(b16, cVar, listOfNotNull);
            com.tencent.zplan.zplantracing.c cVar2 = this.spanContext;
            String[] strArr2 = new String[2];
            if (guestAnim != null) {
                str3 = guestAnim.getHeadAnimGltf();
            } else {
                str3 = null;
            }
            strArr2[0] = str3;
            if (guestAnim != null) {
                str4 = guestAnim.getBodyAnimGltf();
            } else {
                str4 = null;
            }
            strArr2[1] = str4;
            listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr2);
            List<FilamentAnimation> f17 = com.tencent.filament.zplan.scene.square.b.f(b16, cVar2, listOfNotNull2);
            com.tencent.zplan.zplantracing.c cVar3 = this.spanContext;
            listOfNotNull3 = CollectionsKt__CollectionsKt.listOfNotNull(extraAnimGltf);
            List<FilamentAnimation> f18 = com.tencent.filament.zplan.scene.square.b.f(b16, cVar3, listOfNotNull3);
            long j17 = this.lastAnimTime - this.animationBeginTime;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(this.hostObject, f16), new Pair(this.guestObject, f17), new Pair(this.extraObject, f18)});
            List<Pair> list = listOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Pair pair : list) {
                arrayList.add(R(b16, j17, (f) pair.component1(), (List) pair.component2()));
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    Long l3 = (Long) obj;
                    if (l3 != null) {
                        j3 = l3.longValue();
                    } else {
                        j3 = 0;
                    }
                    do {
                        Object next = it.next();
                        Long l16 = (Long) next;
                        if (l16 != null) {
                            j16 = l16.longValue();
                        } else {
                            j16 = 0;
                        }
                        if (j3 < j16) {
                            obj = next;
                            j3 = j16;
                        }
                    } while (it.hasNext());
                }
            }
            Long l17 = (Long) obj;
            if (l17 != null) {
                this.interactionDuration = l17.longValue();
            }
            this.animationBeginTime = 0L;
            this.interactionStartTime = this.lastAnimTime;
            this.backToIdleAnimationBeginTimeDiff = -com.tencent.filament.zplan.scene.square.b.d(LongCompanionObject.INSTANCE, 0.2d);
            this.avatarAnimationState = AvatarAnimationState.INTERACTION;
            e eVar2 = this.parent.get();
            if (eVar2 != null) {
                eVar2.e(new OnObjectStateChangedEvent(this.id, ObjectState.INTERACTING, null, 4, null));
            }
            FLog.INSTANCE.i("SquareMapObjectAvatar", "switchToInteractionAnimationState done " + this.id);
        }
    }

    private final void U(long nowTime) {
        if (this.avatarAnimationState == AvatarAnimationState.INTERACTION && nowTime - this.interactionStartTime >= this.interactionDuration) {
            S();
        }
    }

    public final void L(@Nullable com.tencent.zplan.zplantracing.c spanContext, @Nullable FilamentViewerV2305 viewer, @NotNull f... objects) {
        List<f> filterNotNull;
        Intrinsics.checkNotNullParameter(objects, "objects");
        if (viewer != null) {
            filterNotNull = ArraysKt___ArraysKt.filterNotNull(objects);
            for (f fVar : filterNotNull) {
                viewer.cleanAnimationTracks(spanContext, fVar.getObjectId());
                viewer.deleteRenderObject(spanContext, fVar.getObjectId());
            }
        }
    }

    @Nullable
    public final AvatarRenderObject M(@Nullable com.tencent.zplan.zplantracing.c spanContext, @Nullable FilamentViewerV2305 viewer, @Nullable SquareAvatarData.AvatarData avatarData, @Nullable ReloadAvatarResourceModel avatarResource, @Nullable Location location, @NotNull Size size) {
        e eVar;
        n squareMapSceneHelper;
        FilamentAnimation filamentAnimation;
        List listOfNotNull;
        List mutableListOf;
        Object firstOrNull;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(size, "size");
        FilamentAnimation filamentAnimation2 = null;
        if (viewer == null || avatarData == null || avatarResource == null || (eVar = this.parent.get()) == null || (squareMapSceneHelper = eVar.getSquareMapSceneHelper()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(avatarData.getAvatarInfoStr());
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put("HandHeldSlot");
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("hideSlotPart", jSONArray);
        JSONObject o16 = ZPlanAvatarResourceHelper.f105660o.o(avatarResource, jSONObject, false, false, false, spanContext);
        o16.put("avatarMask", jSONObject2);
        long createAvatarRenderObject = viewer.createAvatarRenderObject(spanContext);
        viewer.updateRenderObjectAvatar(spanContext, createAvatarRenderObject, o16);
        long currentTimeMillis = System.currentTimeMillis();
        if (avatarData.getAnim() != null) {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(avatarData.getAnim().getHeadAnimGltf(), spanContext));
            filamentAnimation = (FilamentAnimation) firstOrNull2;
        } else {
            filamentAnimation = null;
        }
        if (avatarData.getAnim() != null) {
            SquareAvatarData.AvatarAnim anim = avatarData.getAnim();
            Intrinsics.checkNotNull(anim);
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(anim.getBodyAnimGltf(), spanContext));
            filamentAnimation2 = (FilamentAnimation) firstOrNull;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        SquareLoadObjectStatistics squareLoadObjectStatistics = this.statistics;
        squareLoadObjectStatistics.setLoadAnimationCost(squareLoadObjectStatistics.getLoadAnimationCost() + currentTimeMillis2);
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new FilamentAnimation[]{filamentAnimation, filamentAnimation2});
        Iterator it = listOfNotNull.iterator();
        while (it.hasNext()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a((FilamentAnimation) it.next()));
            viewer.bindAnimationTrack(spanContext, createAvatarRenderObject, new Track(true, mutableListOf));
        }
        com.tencent.filament.zplan.scene.couple.config.d b16 = squareMapSceneHelper.b(viewer, location, size, this.depth);
        viewer.setRenderObjectTransform(createAvatarRenderObject, b16.toString());
        viewer.setRenderObjectHittable(createAvatarRenderObject, true);
        return new AvatarRenderObject(createAvatarRenderObject, filamentAnimation, filamentAnimation2, b16);
    }

    @Nullable
    public final ExtraRenderObject N(@Nullable com.tencent.zplan.zplantracing.c spanContext, @Nullable FilamentViewerV2305 viewer, @Nullable SquareAvatarData.ExtraActorData extraData, @Nullable Location location, @NotNull Size size) {
        e eVar;
        n squareMapSceneHelper;
        Object firstOrNull;
        com.tencent.filament.zplan.scene.couple.config.d a16;
        double[] plus;
        List mutableListOf;
        Intrinsics.checkNotNullParameter(size, "size");
        if (viewer == null || extraData == null || (eVar = this.parent.get()) == null || (squareMapSceneHelper = eVar.getSquareMapSceneHelper()) == null) {
            return null;
        }
        long createGltfRenderObject = viewer.createGltfRenderObject(spanContext);
        viewer.updateRenderObjectGltf(spanContext, createGltfRenderObject, extraData.getMeshGltf());
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(FilamentViewerV2.loadAnimation$default(viewer, extraData.getAnimGltf(), null, 2, null));
        FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
        if (filamentAnimation != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a(filamentAnimation));
            viewer.bindAnimationTrack(spanContext, createGltfRenderObject, new Track(true, mutableListOf));
        }
        com.tencent.filament.zplan.scene.couple.config.d b16 = squareMapSceneHelper.b(viewer, location, size, this.depth);
        String transform = extraData.getTransform();
        if (transform != null && (a16 = com.tencent.filament.zplan.scene.couple.config.d.INSTANCE.a(transform)) != null) {
            plus = ArraysKt___ArraysJvmKt.plus(a16.getLocation(), b16.getLocation());
            b16 = com.tencent.filament.zplan.scene.couple.config.d.b(b16, plus, null, null, 6, null);
        }
        viewer.setRenderObjectTransform(createGltfRenderObject, b16.toString());
        viewer.setRenderObjectHittable(createGltfRenderObject, true);
        return new ExtraRenderObject(createGltfRenderObject, filamentAnimation, b16, extraData);
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void a(long frameId) {
        synchronized (this.syncFrameBlocks) {
            Iterator<T> it = this.syncFrameBlocks.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(frameId);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void b(@Nullable final SquareAvatarData.AvatarAnim hostAnim, @Nullable final SquareAvatarData.AvatarAnim guestAnim, @Nullable final String extraAnimGltf) {
        FilamentThreadHandler c16;
        FLog fLog = FLog.INSTANCE;
        fLog.i("SquareMapObjectAvatar", "interaction " + this.id);
        AvatarAnimationState avatarAnimationState = this.avatarAnimationState;
        if (avatarAnimationState == AvatarAnimationState.INTERACTION) {
            this.animationBeginTime = 0L;
            this.interactionStartTime = this.lastAnimTime;
            return;
        }
        if (avatarAnimationState != AvatarAnimationState.IDLE) {
            fLog.i("SquareMapObjectAvatar", "interaction " + this.id + " failed, state(" + this.avatarAnimationState + ") is not IDLE");
            return;
        }
        if (this.moving.get()) {
            fLog.i("SquareMapObjectAvatar", "interaction " + this.id + " failed, is moving");
            return;
        }
        if (!this.playing.get()) {
            fLog.i("SquareMapObjectAvatar", "interaction " + this.id + ", resume play");
            play();
        }
        e eVar = this.parent.get();
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$interaction$1
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
                    SquareMapObjectAvatar.this.T(hostAnim, guestAnim, extraAnimGltf);
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void c(long nowTime) {
        Long l3;
        this.lastAnimTime = nowTime;
        if (!this.ready.get() || !this.playing.get()) {
            return;
        }
        U(nowTime);
        O(nowTime);
        P(nowTime);
        if (!this.rendered.get()) {
            this.rendered.set(true);
            e eVar = this.parent.get();
            if (eVar != null) {
                l3 = Long.valueOf(eVar.g());
            } else {
                l3 = null;
            }
            if (l3 != null) {
                l3.longValue();
                synchronized (this.syncFrameBlocks) {
                    this.syncFrameBlocks.add(new c(l3));
                }
            }
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void d(@NotNull final Location location, final long durationMs) {
        FilamentThreadHandler c16;
        Intrinsics.checkNotNullParameter(location, "location");
        e eVar = this.parent.get();
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.d("SquareMapObjectAvatar.moveTo", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$moveTo$1
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
                    AtomicBoolean atomicBoolean;
                    long j3;
                    Location location2;
                    AtomicBoolean atomicBoolean2;
                    AtomicBoolean atomicBoolean3;
                    FLog.INSTANCE.d("SquareMapObjectAvatar", "moveTo targetLoc=" + location + " duration=" + durationMs);
                    atomicBoolean = SquareMapObjectAvatar.this.moving;
                    if (atomicBoolean.get()) {
                        atomicBoolean3 = SquareMapObjectAvatar.this.moving;
                        atomicBoolean3.set(false);
                        return;
                    }
                    if (durationMs == 0) {
                        SquareMapObjectAvatar.this.location = location;
                        SquareMapObjectAvatar.this.e();
                        return;
                    }
                    SquareMapObjectAvatar squareMapObjectAvatar = SquareMapObjectAvatar.this;
                    j3 = squareMapObjectAvatar.lastAnimTime;
                    squareMapObjectAvatar.moveStartTime = j3;
                    SquareMapObjectAvatar squareMapObjectAvatar2 = SquareMapObjectAvatar.this;
                    location2 = squareMapObjectAvatar2.location;
                    squareMapObjectAvatar2.moveFrom = location2;
                    SquareMapObjectAvatar.this.moveTo = location;
                    SquareMapObjectAvatar.this.moveDuration = b.c(LongCompanionObject.INSTANCE, durationMs);
                    atomicBoolean2 = SquareMapObjectAvatar.this.moving;
                    atomicBoolean2.set(true);
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public synchronized void destroy() {
        FilamentThreadHandler c16;
        CoroutineScope coroutineScope;
        this.isDestroyed = true;
        Deferred<Unit> deferred = this.reloadDeferred;
        if (deferred != null && deferred.isActive()) {
            e eVar = this.parent.get();
            if (eVar != null && (coroutineScope = eVar.getCoroutineScope()) != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SquareMapObjectAvatar$destroy$1(this, null), 3, null);
            }
            return;
        }
        this.syncFrameBlocks.clear();
        e eVar2 = this.parent.get();
        if (eVar2 != null && (c16 = eVar2.c()) != null) {
            c16.d("SquareMapObjectAvatar.destroy", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$destroy$2
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
                    FilamentViewerV2305 b16;
                    AvatarRenderObject avatarRenderObject;
                    AvatarRenderObject avatarRenderObject2;
                    ExtraRenderObject extraRenderObject;
                    e eVar3 = (e) SquareMapObjectAvatar.this.parent.get();
                    if (eVar3 == null || (b16 = eVar3.b()) == null) {
                        return;
                    }
                    SquareMapObjectAvatar squareMapObjectAvatar = SquareMapObjectAvatar.this;
                    avatarRenderObject = squareMapObjectAvatar.hostObject;
                    avatarRenderObject2 = SquareMapObjectAvatar.this.guestObject;
                    extraRenderObject = SquareMapObjectAvatar.this.extraObject;
                    squareMapObjectAvatar.L(null, b16, avatarRenderObject, avatarRenderObject2, extraRenderObject);
                    SquareMapObjectAvatar.this.hostObject = null;
                    SquareMapObjectAvatar.this.guestObject = null;
                    SquareMapObjectAvatar.this.extraObject = null;
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void e() {
        FilamentThreadHandler c16;
        e eVar = this.parent.get();
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$resetLocation$1
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
                    n squareMapSceneHelper;
                    e eVar2;
                    FilamentViewerV2305 b16;
                    AvatarRenderObject avatarRenderObject;
                    AvatarRenderObject avatarRenderObject2;
                    ExtraRenderObject extraRenderObject;
                    Location location;
                    Size size;
                    float f16;
                    ExtraRenderObject extraRenderObject2;
                    ExtraRenderObject extraRenderObject3;
                    String transform;
                    com.tencent.filament.zplan.scene.couple.config.d a16;
                    double[] plus;
                    Location location2;
                    Size size2;
                    float f17;
                    AvatarRenderObject avatarRenderObject3;
                    Location location3;
                    Size size3;
                    float f18;
                    AvatarRenderObject avatarRenderObject4;
                    e eVar3 = (e) SquareMapObjectAvatar.this.parent.get();
                    if (eVar3 == null || (squareMapSceneHelper = eVar3.getSquareMapSceneHelper()) == null || (eVar2 = (e) SquareMapObjectAvatar.this.parent.get()) == null || (b16 = eVar2.b()) == null) {
                        return;
                    }
                    avatarRenderObject = SquareMapObjectAvatar.this.hostObject;
                    if (avatarRenderObject != null) {
                        location3 = SquareMapObjectAvatar.this.location;
                        size3 = SquareMapObjectAvatar.this.size;
                        f18 = SquareMapObjectAvatar.this.depth;
                        com.tencent.filament.zplan.scene.couple.config.d b17 = squareMapSceneHelper.b(b16, location3, size3, f18);
                        avatarRenderObject4 = SquareMapObjectAvatar.this.hostObject;
                        Intrinsics.checkNotNull(avatarRenderObject4);
                        b16.setRenderObjectTransform(avatarRenderObject4.d(), b17.toString());
                    }
                    avatarRenderObject2 = SquareMapObjectAvatar.this.guestObject;
                    if (avatarRenderObject2 != null) {
                        location2 = SquareMapObjectAvatar.this.location;
                        size2 = SquareMapObjectAvatar.this.size;
                        f17 = SquareMapObjectAvatar.this.depth;
                        com.tencent.filament.zplan.scene.couple.config.d b18 = squareMapSceneHelper.b(b16, location2, size2, f17);
                        avatarRenderObject3 = SquareMapObjectAvatar.this.guestObject;
                        Intrinsics.checkNotNull(avatarRenderObject3);
                        b16.setRenderObjectTransform(avatarRenderObject3.d(), b18.toString());
                    }
                    extraRenderObject = SquareMapObjectAvatar.this.extraObject;
                    if (extraRenderObject != null) {
                        location = SquareMapObjectAvatar.this.location;
                        size = SquareMapObjectAvatar.this.size;
                        f16 = SquareMapObjectAvatar.this.depth;
                        com.tencent.filament.zplan.scene.couple.config.d b19 = squareMapSceneHelper.b(b16, location, size, f16);
                        extraRenderObject2 = SquareMapObjectAvatar.this.extraObject;
                        Intrinsics.checkNotNull(extraRenderObject2);
                        SquareAvatarData.ExtraActorData extraData = extraRenderObject2.getExtraData();
                        if (extraData != null && (transform = extraData.getTransform()) != null && (a16 = com.tencent.filament.zplan.scene.couple.config.d.INSTANCE.a(transform)) != null) {
                            plus = ArraysKt___ArraysJvmKt.plus(a16.getLocation(), b19.getLocation());
                            b19 = com.tencent.filament.zplan.scene.couple.config.d.b(b19, plus, null, null, 6, null);
                        }
                        extraRenderObject3 = SquareMapObjectAvatar.this.extraObject;
                        Intrinsics.checkNotNull(extraRenderObject3);
                        b16.setRenderObjectTransform(extraRenderObject3.d(), b19.toString());
                    }
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void f(@NotNull Object resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        if (!(resource instanceof SquareAvatarData)) {
            resource = null;
        }
        SquareAvatarData squareAvatarData = (SquareAvatarData) resource;
        if (squareAvatarData != null) {
            this.avatarData = squareAvatarData;
            Q();
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public boolean g(long renderObjectId) {
        AvatarRenderObject avatarRenderObject;
        ExtraRenderObject extraRenderObject;
        AvatarRenderObject avatarRenderObject2 = this.hostObject;
        if ((avatarRenderObject2 != null && avatarRenderObject2.d() == renderObjectId) || (((avatarRenderObject = this.guestObject) != null && avatarRenderObject.d() == renderObjectId) || ((extraRenderObject = this.extraObject) != null && extraRenderObject.d() == renderObjectId))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void play() {
        if (this.playing.compareAndSet(false, true)) {
            long j3 = this.lastAnimTime - this.stopAnimTime;
            this.animationBeginTime += j3;
            this.stopAnimTime = 0L;
            if (this.moving.get()) {
                this.moveStartTime += j3;
            }
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void reset() {
        e eVar;
        FilamentThreadHandler c16;
        this.animationBeginTime = 0L;
        if (!this.playing.get() && (eVar = this.parent.get()) != null && (c16 = eVar.c()) != null) {
            c16.e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectAvatar$reset$1
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
                    long j3;
                    SquareMapObjectAvatar squareMapObjectAvatar = SquareMapObjectAvatar.this;
                    j3 = squareMapObjectAvatar.lastAnimTime;
                    squareMapObjectAvatar.O(j3);
                    SquareMapObjectAvatar.this.animationBeginTime = 0L;
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void stop() {
        if (this.playing.compareAndSet(true, false)) {
            this.stopAnimTime = this.lastAnimTime;
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void setVisibility(boolean visible) {
    }
}

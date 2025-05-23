package com.tencent.filament.zplan.record;

import al0.a;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import cl0.FilamentRecordSizeConfig;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.FilamentAnimationHelper;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.BusinessSceneConfig;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.ClearOptions;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.FovProjection;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.record.callback.RecordCallback;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportConstant;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.GsonUtil;
import dl0.d;
import dl0.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d7\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001t\u0018\u0000 ~2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010{\u001a\u00020x\u00a2\u0006\u0004\b|\u0010}J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002JK\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J\u001e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002Jl\u0010-\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0004H\u0002J\"\u00101\u001a\u0002002\u0006\u0010.\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0010\u00104\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0012\u00105\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002J2\u00107\u001a\u0002062\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0002J\u001c\u00108\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001a\u00109\u001a\u0002002\u0006\u0010$\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010:\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010;\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010<\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010=\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020>H\u0002J8\u0010C\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010c\u001a\u00020^8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001b\u0010g\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010`\u001a\u0004\b\r\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010`\u001a\u0004\bj\u0010kR\u001e\u0010q\u001a\f\u0012\b\u0012\u00060\u001cj\u0002`n0m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010RR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010z\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/filament/zplan/record/FilamentRecordNativeApp;", "", "", "D", "Lorg/json/JSONObject;", "data", "X", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "", "E", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "T", "taskName", "", "maxRetries", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", UserInfo.SEX_FEMALE, "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "funName", "Lkotlin/Function0;", "task", BdhLogUtil.LogTag.Tag_Conn, "from", "W", "Ljava/lang/Runnable;", "y", "U", "recordParams", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "avatarInfo", "stickerConfig", "configJsonPath", "theme", "width", "height", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "bootResource", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "avatarResource", "animationResource", "statistic", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "configJson", "indirectLightPath", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "P", "configPath", "K", "J", "I", "Lcom/tencent/filament/zplan/avatar/BusinessSceneConfig;", BdhLogUtil.LogTag.Tag_Req, "H", "N", "M", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "L", "Lcom/tencent/filament/zplan/animation/b;", "trackGroup", "", "Y", "actionId", "V", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "a", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "Landroid/graphics/SurfaceTexture;", "b", "Landroid/graphics/SurfaceTexture;", "texture", "Landroid/view/Surface;", "c", "Landroid/view/Surface;", "surface", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasBoot", "e", "hasDestroy", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "f", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lal0/a;", "g", "Lal0/a;", "loadSoStep", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", h.F, "Lkotlin/Lazy;", "O", "()Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "eventDispatcher", "Landroid/os/HandlerThread;", "i", "()Landroid/os/HandlerThread;", "viewerHandlerThread", "Landroid/os/Handler;", "j", ExifInterface.LATITUDE_SOUTH, "()Landroid/os/Handler;", "viewerHandler", "", "Lkotlinx/coroutines/Runnable;", "k", "Ljava/util/List;", "viewerWaitList", "l", "appInitFinish", "com/tencent/filament/zplan/record/FilamentRecordNativeApp$loadSoListener$1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplan/record/FilamentRecordNativeApp$loadSoListener$1;", "loadSoListener", "Lcl0/e;", DomainData.DOMAIN_NAME, "Lcl0/e;", "surfaceTextureSizeConfig", "<init>", "(Lcl0/e;)V", ReportConstant.COSTREPORT_PREFIX, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp {

    /* renamed from: o, reason: collision with root package name */
    private static final Lazy f105780o;

    /* renamed from: p, reason: collision with root package name */
    private static final Lazy f105781p;

    /* renamed from: q, reason: collision with root package name */
    private static final Lazy f105782q;

    /* renamed from: r, reason: collision with root package name */
    private static final AtomicInteger f105783r;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FilamentViewerV2 viewer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SurfaceTexture texture;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Surface surface;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasBoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasDestroy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final al0.a loadSoStep;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy eventDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewerHandlerThread;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewerHandler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final List<Runnable> viewerWaitList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean appInitFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final FilamentRecordNativeApp$loadSoListener$1 loadSoListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final FilamentRecordSizeConfig surfaceTextureSizeConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0015\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0006H\u0002R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017R\u0014\u0010(\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0017R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006."}, d2 = {"Lcom/tencent/filament/zplan/record/FilamentRecordNativeApp$a;", "", "", "", "i", "(Ljava/lang/Boolean;)Ljava/lang/String;", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "j", "enableViewerThreadInitStateCheck$delegate", "Lkotlin/Lazy;", "g", "()Z", "enableViewerThreadInitStateCheck", "", "fetchResourceRetryTimes$delegate", h.F, "()I", "fetchResourceRetryTimes", "enableRecordOpenGlLocalShaderBinary$delegate", "f", "enableRecordOpenGlLocalShaderBinary", "BODY_TYPE_NEW_BOY", "Ljava/lang/String;", "BODY_TYPE_NEW_GIRL", "BODY_TYPE_OLD", "BODY_TYPE_SLOT_ID", "I", "CAMERA_JSON", "DEFAULT_FPS", "DO_DOWNLOAD_RESOURCE", "DO_NOT_DOWNLOAD_RESOURCE", "HAND_HELD_HIDE", "HAND_HELD_SHOW", "NOT_REACH_DOWNLOAD_RESOURCE", "RECORD_ENABLE_OPENGL_LOCAL_SHADER_BINARY", "RECORD_FETCH_RESOURCE_RETRY_TIMES", "RECORD_FETCH_RESOURCE_RETRY_TIMES_DEFAULT", "RECORD_VIEWER_THREAD_INIT_STATE_CHECK", "TAG", "THREAD_NAME", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadId", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.record.FilamentRecordNativeApp$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f() {
            return ((Boolean) FilamentRecordNativeApp.f105782q.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean g() {
            return ((Boolean) FilamentRecordNativeApp.f105780o.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int h() {
            return ((Number) FilamentRecordNativeApp.f105781p.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                return "0";
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return "1";
            }
            return "2";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JSONArray j(JSONObject jSONObject) {
            JSONArray jSONArray = new JSONArray();
            if (jSONObject == null) {
                return jSONArray;
            }
            if (jSONObject.has(HippyTKDListViewAdapter.X)) {
                jSONArray.mo162put(Float.valueOf((float) jSONObject.optDouble(HippyTKDListViewAdapter.X)));
            }
            if (jSONObject.has("y")) {
                jSONArray.mo162put(Float.valueOf((float) jSONObject.optDouble("y")));
            }
            if (jSONObject.has(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW)) {
                jSONArray.mo162put(Float.valueOf((float) jSONObject.optDouble(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW)));
            }
            return jSONArray;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$Companion$enableViewerThreadInitStateCheck$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                g gVar = (g) fl0.a.f399763a.a(g.class);
                boolean isSwitchOn = gVar != null ? gVar.isSwitchOn("zplan_filament_record_viewer_thread_init_state_check", true) : true;
                FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "zplan_filament_record_viewer_thread_init_state_check: " + isSwitchOn);
                return isSwitchOn;
            }
        });
        f105780o = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$Companion$fetchResourceRetryTimes$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                Integer intOrNull;
                String b16;
                g gVar = (g) fl0.a.f399763a.a(g.class);
                String valueOf = String.valueOf(3);
                if (gVar != null && (b16 = gVar.b("zplan_filament_record_fetch_resource_retry_times", valueOf)) != null) {
                    valueOf = b16;
                }
                FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "zplan_filament_record_fetch_resource_retry_times: " + valueOf);
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(valueOf);
                if (intOrNull != null) {
                    return intOrNull.intValue();
                }
                return 3;
            }
        });
        f105781p = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$Companion$enableRecordOpenGlLocalShaderBinary$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                g gVar = (g) fl0.a.f399763a.a(g.class);
                boolean isSwitchOn = gVar != null ? gVar.isSwitchOn("zplan_filament_record_opengl_local_shader_binary", true) : true;
                FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "zplan_filament_record_opengl_local_shader_binary: " + isSwitchOn);
                return isSwitchOn;
            }
        });
        f105782q = lazy3;
        f105783r = new AtomicInteger(0);
    }

    public FilamentRecordNativeApp(@NotNull FilamentRecordSizeConfig surfaceTextureSizeConfig) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(surfaceTextureSizeConfig, "surfaceTextureSizeConfig");
        this.surfaceTextureSizeConfig = surfaceTextureSizeConfig;
        this.hasBoot = new AtomicBoolean(false);
        this.hasDestroy = new AtomicBoolean(false);
        this.urlTemplate = FilamentFeatureUtil.f106409g.F();
        al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
        this.loadSoStep = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentEventDispatcher>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$eventDispatcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FilamentEventDispatcher invoke() {
                return new FilamentEventDispatcher();
            }
        });
        this.eventDispatcher = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HandlerThread>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$viewerHandlerThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HandlerThread invoke() {
                AtomicInteger atomicInteger;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("filament_native_record_");
                atomicInteger = FilamentRecordNativeApp.f105783r;
                sb5.append(atomicInteger.getAndIncrement());
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(sb5.toString());
                baseHandlerThread.start();
                return baseHandlerThread;
            }
        });
        this.viewerHandlerThread = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$viewerHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread T;
                T = FilamentRecordNativeApp.this.T();
                return new Handler(T.getLooper());
            }
        });
        this.viewerHandler = lazy3;
        this.viewerWaitList = new ArrayList();
        this.appInitFinish = new AtomicBoolean(false);
        FilamentRecordNativeApp$loadSoListener$1 filamentRecordNativeApp$loadSoListener$1 = new FilamentRecordNativeApp$loadSoListener$1(this);
        this.loadSoListener = filamentRecordNativeApp$loadSoListener$1;
        d dVar = (d) fl0.a.f399763a.a(d.class);
        if (dVar == null) {
            FLog.INSTANCE.e("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "loadSoProxy is null");
        }
        aVar.l(al0.a.INSTANCE.b());
        if (dVar != null) {
            dVar.a(new WeakReference<>(filamentRecordNativeApp$loadSoListener$1));
        }
    }

    private final void A(JSONObject recordParams, JSONObject stickerConfig) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        JSONObject jSONObject2;
        String str;
        JSONObject optJSONObject = recordParams.optJSONObject("sender");
        JSONObject jSONObject3 = null;
        if (optJSONObject == null || (jSONObject = optJSONObject.optJSONObject("userData")) == null) {
            if (optJSONObject != null) {
                jSONObject = optJSONObject.optJSONObject(IZplanHandleApi.BUSINESS_DRESS_INFO);
            } else {
                jSONObject = null;
            }
        }
        if (jSONObject != null) {
            EnumUserGender a16 = EnumUserGender.INSTANCE.a(jSONObject.optInt("gender"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("makeup_info");
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("slot_arr")) != null) {
                int length = optJSONArray.length();
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        jSONObject2 = optJSONArray.optJSONObject(i3);
                        if (jSONObject2 != null && jSONObject2.optInt(MiniAppReportManager2.KEY_SLOT_ID) == 116) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        jSONObject2 = null;
                        break;
                    }
                }
                if (jSONObject2 != null) {
                    jSONObject3 = jSONObject2.optJSONObject("item_data");
                }
                if (jSONObject3 == null) {
                    FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "correctBodyType to unset body type");
                    return;
                }
                int L = L(recordParams, stickerConfig);
                if (L != 1) {
                    if (L != 2) {
                        String optString = jSONObject3.optString("model");
                        FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "correctBodyType to current body type:" + optString);
                        return;
                    }
                    int i16 = c.f105812a[a16.ordinal()];
                    if (i16 != 1) {
                        if (i16 != 2) {
                            return;
                        } else {
                            str = "CMShow/Assets/Character/AvatarV2/BodyType/GirlStretchConfig";
                        }
                    } else {
                        str = "CMShow/Assets/Character/AvatarV2/BodyType/BoyStretchConfig";
                    }
                    jSONObject3.put("model", str);
                    FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "correctBodyType to new body type:" + str);
                    return;
                }
                jSONObject3.put("model", "CMShow/Assets/Character/AvatarV2/BodyType/BodyType40");
                FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "correctBodyType to old body type:CMShow/Assets/Character/AvatarV2/BodyType/BodyType40");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final String funName, final Function0<Unit> task) {
        S().post(new Runnable() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$doTaskOnViewerThread$1
            @Override // java.lang.Runnable
            public final void run() {
                al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                Function0 function0 = Function0.this;
                a.Companion companion = al0.a.INSTANCE;
                aVar.l(companion.b());
                function0.invoke();
                aVar.i(companion.b());
                FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "doTask: " + funName + TokenParser.SP + aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object G(FilamentRecordNativeApp filamentRecordNativeApp, String str, int i3, Function1 function1, Continuation continuation, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = INSTANCE.h();
        }
        return filamentRecordNativeApp.F(str, i3, function1, continuation);
    }

    private final JSONObject H(String configPath, JSONObject configJson) {
        boolean z16;
        boolean endsWith$default;
        if (configPath != null && configPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(configPath, "camera.json", false, 2, null);
            if (endsWith$default) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Companion companion = INSTANCE;
                jSONObject2.put("eye", companion.j(configJson.optJSONObject("eye")));
                jSONObject2.put("target", companion.j(configJson.optJSONObject("target")));
                jSONObject2.put("upward", companion.j(configJson.optJSONObject("upward")));
                jSONObject.put("lookAt", jSONObject2);
                return jSONObject;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject I(JSONObject stickerConfig) {
        int i3;
        boolean z16;
        JSONArray jSONArray;
        boolean z17;
        if (stickerConfig != null) {
            i3 = stickerConfig.optInt("show_hand_slot");
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        JSONArray jSONArray2 = new JSONArray();
        if (!z16) {
            jSONArray2.mo162put("HandHeldSlot");
        }
        if (stickerConfig != null) {
            jSONArray = stickerConfig.optJSONArray("hide_body_part");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                String optString = jSONArray.optString(i16);
                if (optString != null && optString.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    jSONArray2.mo162put(optString);
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hideSlotPart", jSONArray2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J(JSONObject configJson) {
        JSONObject optJSONObject;
        String jSONObject;
        JSONObject optJSONObject2 = configJson.optJSONObject("modification");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("facePatch")) == null || (jSONObject = optJSONObject.toString()) == null) {
            return "";
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject K(String configPath, JSONObject configJson) {
        boolean z16;
        String str;
        JSONObject optJSONObject = configJson.optJSONObject("attachments");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("meshes");
            if (configPath != null && configPath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return optJSONObject;
            }
            if (!com.tencent.zplan.common.utils.c.f385288a.h(configPath)) {
                return optJSONObject;
            }
            File parentFile = new File(configPath).getParentFile();
            if (parentFile != null) {
                str = parentFile.getAbsolutePath();
            } else {
                str = null;
            }
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        optJSONObject2.put("path", str + '/' + optJSONObject2.optString("path"));
                    }
                }
            }
            return optJSONObject;
        }
        return new JSONObject();
    }

    private final int L(JSONObject recordParams, JSONObject stickerConfig) {
        int optInt = recordParams.optInt("bodyType", -1);
        if (optInt != -1) {
            return optInt;
        }
        if (stickerConfig == null) {
            return -1;
        }
        return stickerConfig.optInt("body_version", -1);
    }

    private final LightsParams M(String indirectLightPath) {
        String str;
        Directional directional = new Directional(new float[]{1.0f, 1.0f, 1.0f}, 0, 90000.0f, new float[]{0.33f, -0.25f, -0.908f}, false, 2, null);
        if (indirectLightPath != null) {
            str = indirectLightPath;
        } else {
            str = "";
        }
        return new LightsParams(directional, new IndirectLight(str, 8000.0f), null, 4, null);
    }

    private final LightsParams N(int theme, String indirectLightPath) {
        if (theme == AppTheme.INSTANCE.b(AppTheme.NIGHT)) {
            return Q(indirectLightPath);
        }
        return M(indirectLightPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LightsParams P(JSONObject configJson, int theme, String indirectLightPath) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = configJson.optJSONObject("lights");
        AppTheme.Companion companion = AppTheme.INSTANCE;
        AppTheme appTheme = AppTheme.NIGHT;
        LightsParams lightsParams = null;
        if (theme == companion.b(appTheme)) {
            if (optJSONObject2 != null) {
                String obj = appTheme.toString();
                if (obj != null) {
                    String lowerCase = obj.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    optJSONObject = optJSONObject2.optJSONObject(lowerCase);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            optJSONObject = null;
        } else {
            if (optJSONObject2 != null) {
                String obj2 = AppTheme.DAY.toString();
                if (obj2 != null) {
                    String lowerCase2 = obj2.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                    optJSONObject = optJSONObject2.optJSONObject(lowerCase2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            optJSONObject = null;
        }
        if (optJSONObject != null) {
            optJSONObject2 = optJSONObject;
        }
        if (optJSONObject2 != null) {
            try {
                if (optJSONObject2.has("directional") || optJSONObject2.has("indirectLight") || optJSONObject2.has("spotLights")) {
                    lightsParams = (LightsParams) new Gson().fromJson(optJSONObject2.toString(), LightsParams.class);
                }
            } catch (JsonSyntaxException unused) {
            }
        }
        if (lightsParams == null) {
            lightsParams = N(theme, indirectLightPath);
        }
        if (indirectLightPath == null) {
            FLog.INSTANCE.e("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "indirectLightPath == null");
        }
        IndirectLight indirectLight = lightsParams.getIndirectLight();
        if (indirectLight != null) {
            if (indirectLightPath == null) {
                indirectLightPath = "";
            }
            indirectLight.setPath(indirectLightPath);
        }
        return lightsParams;
    }

    private final LightsParams Q(String indirectLightPath) {
        String str;
        LightsParams lightsParams = new LightsParams(null, null, null, 4, null);
        List<SpotLight> spotLights = lightsParams.getSpotLights();
        SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight.setKey("spotLight1");
        spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
        spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
        spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
        spotLight.setIntensity(3380.0f);
        spotLight.setFalloff(5.0d);
        spotLight.setInnerCone(30);
        spotLight.setOuterCone(50);
        spotLight.setCastShadows(false);
        Unit unit = Unit.INSTANCE;
        spotLights.add(spotLight);
        List<SpotLight> spotLights2 = lightsParams.getSpotLights();
        SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight2.setKey("spotLight2");
        spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
        spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
        spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
        spotLight2.setIntensity(4833.0f);
        spotLight2.setFalloff(30.0d);
        spotLight2.setInnerCone(10);
        spotLight2.setOuterCone(40);
        spotLight2.setCastShadows(false);
        spotLights2.add(spotLight2);
        Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional.setColor(new float[]{0.95f, 0.94f, 0.85f});
        directional.setIntensity(35000.0f);
        directional.setDirection(new float[]{-0.45f, -0.31f, -0.86f});
        directional.setCastShadows(true);
        lightsParams.setDirectional(directional);
        IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
        if (indirectLightPath != null) {
            str = indirectLightPath;
        } else {
            str = "";
        }
        indirectLight.setPath(str);
        indirectLight.setIntensity(2000.0f);
        lightsParams.setIndirectLight(indirectLight);
        return lightsParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BusinessSceneConfig R(JSONObject recordParams, JSONObject configJson, String configPath, int width, int height) {
        String str;
        boolean z16;
        JSONObject H;
        CameraParams cameraParams;
        CameraParams cameraParams2;
        LensProjection lensProjection;
        FovProjection fovProjection;
        JSONObject optJSONObject = recordParams.optJSONObject("camera");
        Object obj = null;
        if (optJSONObject != null) {
            str = optJSONObject.optString("raw");
        } else {
            str = null;
        }
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            H = com.tencent.zplan.common.utils.h.f385294a.b(str);
        } else {
            JSONObject optJSONObject2 = configJson.optJSONObject("camera");
            if (optJSONObject2 != null) {
                H = optJSONObject2;
            } else {
                H = H(configPath, configJson);
                if (H != null) {
                    String jSONObject = H.toString();
                    if (jSONObject == null || jSONObject.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        try {
                            obj = GsonUtil.f385283b.a().fromJson(jSONObject, (Class<Object>) CameraParams.class);
                        } catch (Throwable th5) {
                            FLog.INSTANCE.e("JsonUtil", "json2Object exception for " + jSONObject, th5);
                        }
                    }
                }
                cameraParams = (CameraParams) obj;
                if (cameraParams == null) {
                    cameraParams = new CameraParams(null, null, null, null, null, 31, null);
                }
                cameraParams2 = cameraParams;
                if (cameraParams2.getLensProjection() == null && cameraParams2.getFovProjection() == null) {
                    cameraParams2.setLensProjection(new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null));
                }
                float f16 = (width * 1.0f) / height;
                lensProjection = cameraParams2.getLensProjection();
                if (lensProjection != null) {
                    lensProjection.setAspect(f16);
                }
                fovProjection = cameraParams2.getFovProjection();
                if (fovProjection != null) {
                    fovProjection.setAspect(f16);
                }
                BusinessSceneConfig businessSceneConfig = new BusinessSceneConfig(cameraParams2, null, null, 2, null);
                ClearOptions clearOptions = businessSceneConfig.getRenderer().getClearOptions();
                clearOptions.setClearColor(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
                clearOptions.setClear(true);
                clearOptions.setDiscard(true);
                return businessSceneConfig;
            }
        }
        if (H != null) {
        }
        cameraParams = (CameraParams) obj;
        if (cameraParams == null) {
        }
        cameraParams2 = cameraParams;
        if (cameraParams2.getLensProjection() == null) {
            cameraParams2.setLensProjection(new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null));
        }
        float f162 = (width * 1.0f) / height;
        lensProjection = cameraParams2.getLensProjection();
        if (lensProjection != null) {
        }
        fovProjection = cameraParams2.getFovProjection();
        if (fovProjection != null) {
        }
        BusinessSceneConfig businessSceneConfig2 = new BusinessSceneConfig(cameraParams2, null, null, 2, null);
        ClearOptions clearOptions2 = businessSceneConfig2.getRenderer().getClearOptions();
        clearOptions2.setClearColor(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        clearOptions2.setClear(true);
        clearOptions2.setDiscard(true);
        return businessSceneConfig2;
    }

    private final Handler S() {
        return (Handler) this.viewerHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread T() {
        return (HandlerThread) this.viewerHandlerThread.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        this.viewer = new FilamentViewerV2(currentThread.getId(), null, 2, null);
        int width = this.surfaceTextureSizeConfig.getWidth();
        int height = this.surfaceTextureSizeConfig.getHeight();
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(width, height);
        Surface surface = new Surface(surfaceTexture);
        FilamentViewerV2 filamentViewerV2 = this.viewer;
        if (filamentViewerV2 != null) {
            filamentViewerV2.attach(surface, surfaceTexture, width, height);
        }
        this.texture = surfaceTexture;
        this.surface = surface;
        FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "initEngineSurface, size:" + this.surfaceTextureSizeConfig + ", texture:" + this.texture + ", surface:" + this.surface);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0.isPublicVersion() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void V(JSONObject data, int taskId, int actionId, int width, int height, int theme) {
        boolean z16;
        dl0.a aVar = (dl0.a) fl0.a.f399763a.a(dl0.a.class);
        if (aVar != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            String optString = data.optString("_uniKey_");
            FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "record, data taskId:" + taskId + ", actionId:" + actionId + ", width:" + width + ", height:" + height + ", theme:" + theme + ", unikey:" + optString);
            return;
        }
        FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "record, data:" + data);
    }

    private final void W(final String from, final Function0<Unit> task) {
        if (!INSTANCE.g()) {
            C(from, task);
            return;
        }
        FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "postToViewerThread from: " + from + ", " + task.hashCode());
        y(new Runnable() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$postToViewerThread$1
            @Override // java.lang.Runnable
            public final void run() {
                FilamentRecordNativeApp.this.C(from, task);
            }
        });
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y(com.tencent.filament.zplan.animation.b trackGroup) {
        boolean z16;
        boolean z17;
        com.tencent.filament.zplan.animation.a[] c16 = trackGroup.c();
        if (c16.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        for (com.tencent.filament.zplan.animation.a aVar : c16) {
            if (aVar.c().length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return false;
            }
        }
        return true;
    }

    private final void y(Runnable task) {
        synchronized (this.viewerWaitList) {
            this.viewerWaitList.add(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final JSONObject recordParams, final int taskId, final JSONObject avatarInfo, final JSONObject stickerConfig, final String configJsonPath, final int theme, final int width, final int height, final BootResourceModel bootResource, final ReloadAvatarResourceModel avatarResource, final ZPlanAction animationResource, final JSONObject statistic) {
        if (this.hasDestroy.get()) {
            FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "bootAndRecord but nativeApp hasDestroy, return!!");
        } else {
            W("bootAndRecord", new Function0<Unit>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$bootAndRecord$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u0011"}, d2 = {"com/tencent/filament/zplan/record/FilamentRecordNativeApp$bootAndRecord$1$a", "Lcom/tencent/filament/zplan/record/callback/RecordCallback;", "", "data", "", "onRecordFrame", "", "a", "I", "getFrameCount", "()I", "setFrameCount", "(I)V", "frameCount", "b", "getTaskId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
                /* loaded from: classes6.dex */
                public static final class a implements RecordCallback {

                    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                    private int frameCount;

                    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                    private final int taskId;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f105802d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ al0.a f105803e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ al0.a f105804f;

                    a(int i3, al0.a aVar, al0.a aVar2) {
                        this.f105802d = i3;
                        this.f105803e = aVar;
                        this.f105804f = aVar2;
                        this.taskId = taskId;
                    }

                    @Override // com.tencent.filament.zplan.record.callback.RecordCallback
                    public int getTaskId() {
                        return this.taskId;
                    }

                    @Override // com.tencent.filament.zplan.record.callback.RecordCallback
                    public void onRecordFrame(@NotNull String data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        int i3 = this.frameCount + 1;
                        this.frameCount = i3;
                        if (i3 >= this.f105802d) {
                            this.f105803e.i(al0.a.INSTANCE.b());
                        }
                        FilamentRecordNativeApp.this.O().onEvent("recordFrame", data);
                        if (this.frameCount >= this.f105802d) {
                            statistic.put("reloadAvatarTimeCost", String.valueOf(this.f105804f.f()));
                            statistic.put("recordRenderTimeCost", String.valueOf(this.f105803e.f()));
                            FilamentEventDispatcher O = FilamentRecordNativeApp.this.O();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, taskId);
                            jSONObject.put("errorCode", 0);
                            jSONObject.put("statistic", statistic);
                            Unit unit = Unit.INSTANCE;
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
                            O.onEvent("recordEnd", jSONObject2);
                        }
                    }
                }

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
                    BusinessSceneConfig R;
                    AtomicBoolean atomicBoolean;
                    long j3;
                    FilamentViewerV2 filamentViewerV2;
                    FilamentViewerV2 filamentViewerV22;
                    FilamentViewerV2 filamentViewerV23;
                    JSONObject K;
                    FilamentViewerV2 filamentViewerV24;
                    FilamentViewerV2 filamentViewerV25;
                    String J;
                    FilamentViewerV2 filamentViewerV26;
                    FilamentViewerV2 filamentViewerV27;
                    boolean Y;
                    String str;
                    FilamentViewerV2 filamentViewerV28;
                    JSONObject I;
                    LightsParams P;
                    AtomicBoolean atomicBoolean2;
                    FilamentViewerV2 filamentViewerV29;
                    FilamentViewerV2 filamentViewerV210;
                    boolean f16;
                    al0.a aVar;
                    String readFileContent = FilamentFileUtil.INSTANCE.readFileContent(configJsonPath);
                    FLog.INSTANCE.d("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "getSceneConfig configContent:\n " + readFileContent);
                    JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(readFileContent);
                    if (b16 == null) {
                        b16 = new JSONObject();
                    }
                    R = FilamentRecordNativeApp.this.R(recordParams, b16, configJsonPath, width, height);
                    atomicBoolean = FilamentRecordNativeApp.this.hasBoot;
                    boolean z16 = !atomicBoolean.get();
                    statistic.put("firstBoot", String.valueOf(wx4.d.INSTANCE.b(z16)));
                    JSONObject jSONObject = statistic;
                    if (z16) {
                        aVar = FilamentRecordNativeApp.this.loadSoStep;
                        j3 = aVar.f();
                    } else {
                        j3 = 0;
                    }
                    jSONObject.put("loadFilamentSoTimeCost", j3);
                    if (z16) {
                        atomicBoolean2 = FilamentRecordNativeApp.this.hasBoot;
                        atomicBoolean2.set(true);
                        filamentViewerV29 = FilamentRecordNativeApp.this.viewer;
                        if (filamentViewerV29 != null) {
                            BootResourceModel bootResourceModel = bootResource;
                            String json = new Gson().toJson(R);
                            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(sceneConfig)");
                            f16 = FilamentRecordNativeApp.INSTANCE.f();
                            FilamentViewerV2.boot$default(filamentViewerV29, bootResourceModel, json, false, false, false, false, f16, 60, null);
                        }
                        filamentViewerV210 = FilamentRecordNativeApp.this.viewer;
                        if (filamentViewerV210 != null) {
                            filamentViewerV210.setEnableFrustumCulling(false);
                        }
                    }
                    filamentViewerV2 = FilamentRecordNativeApp.this.viewer;
                    if (filamentViewerV2 != null) {
                        String json2 = new Gson().toJson(R.getCamera());
                        Intrinsics.checkNotNullExpressionValue(json2, "Gson().toJson(sceneConfig.camera)");
                        filamentViewerV2.setCamera(json2);
                    }
                    filamentViewerV22 = FilamentRecordNativeApp.this.viewer;
                    if (filamentViewerV22 != null) {
                        P = FilamentRecordNativeApp.this.P(b16, theme, bootResource.getIndirectLightPath());
                        filamentViewerV22.setLights(P);
                    }
                    filamentViewerV23 = FilamentRecordNativeApp.this.viewer;
                    if (filamentViewerV23 != null) {
                        filamentViewerV23.setViewPort(width, height);
                    }
                    K = FilamentRecordNativeApp.this.K(configJsonPath, b16);
                    filamentViewerV24 = FilamentRecordNativeApp.this.viewer;
                    if (filamentViewerV24 != null) {
                        String jSONObject2 = K.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "attachments.toString()");
                        filamentViewerV24.setAttachments(jSONObject2);
                    }
                    al0.a aVar2 = new al0.a(0L, 0L, false, 0, null, 31, null);
                    a.Companion companion = al0.a.INSTANCE;
                    aVar2.l(companion.b());
                    filamentViewerV25 = FilamentRecordNativeApp.this.viewer;
                    if (filamentViewerV25 != null) {
                        JSONObject p16 = ZPlanAvatarResourceHelper.p(ZPlanAvatarResourceHelper.f105660o, avatarResource, avatarInfo, false, false, recordParams.optBoolean("disableGlassesMetallic", false), null, 40, null);
                        I = FilamentRecordNativeApp.this.I(stickerConfig);
                        FilamentViewerV2.reloadAvatar$default(filamentViewerV25, p16, I, null, 4, null);
                        Unit unit = Unit.INSTANCE;
                    }
                    aVar2.i(companion.b());
                    J = FilamentRecordNativeApp.this.J(b16);
                    filamentViewerV26 = FilamentRecordNativeApp.this.viewer;
                    if (filamentViewerV26 != null) {
                        filamentViewerV26.setAnimationBoneFix(J);
                    }
                    FilamentAnimationHelper filamentAnimationHelper = FilamentAnimationHelper.f105573a;
                    ZPlanAction[] zPlanActionArr = {animationResource};
                    filamentViewerV27 = FilamentRecordNativeApp.this.viewer;
                    com.tencent.filament.zplan.animation.b c16 = filamentAnimationHelper.c(zPlanActionArr, filamentViewerV27);
                    if (c16 != null) {
                        Y = FilamentRecordNativeApp.this.Y(c16);
                        if (Y) {
                            com.tencent.filament.zplan.animation.a[] c17 = c16.c();
                            ArrayList<FilamentAnimation[]> arrayList = new ArrayList(c17.length);
                            for (com.tencent.filament.zplan.animation.a aVar3 : c17) {
                                arrayList.add(aVar3.c());
                            }
                            double d16 = 0.0d;
                            for (FilamentAnimation[] filamentAnimationArr : arrayList) {
                                for (FilamentAnimation filamentAnimation : filamentAnimationArr) {
                                    if (filamentAnimation.getDuration() > d16) {
                                        d16 = filamentAnimation.getDuration();
                                    }
                                }
                            }
                            JSONObject jSONObject3 = stickerConfig;
                            int optInt = jSONObject3 != null ? jSONObject3.optInt(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_FRAME_RATE) : 30;
                            double d17 = optInt;
                            double d18 = 1.0d / d17;
                            int optInt2 = recordParams.optInt("frameCount", -1);
                            if (optInt2 != -1) {
                                str = "recordStart";
                            } else {
                                str = "recordStart";
                                optInt2 = (int) ((d17 * d16) + 1);
                            }
                            double d19 = optInt2 * d18;
                            FLog.INSTANCE.d("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "animationTime:" + d16 + ", fps:" + optInt + ", totalFrameCount:" + optInt2 + ", beginTime:0.0, endTime:" + d19);
                            FilamentEventDispatcher O = FilamentRecordNativeApp.this.O();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, taskId);
                            jSONObject4.put("fps", optInt);
                            jSONObject4.put("totalFrameCount", optInt2);
                            jSONObject4.put("errorCode", 0);
                            jSONObject4.put("statistic", statistic);
                            Unit unit2 = Unit.INSTANCE;
                            String jSONObject5 = jSONObject4.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject5, "JSONObject().apply {\n   \u2026             }.toString()");
                            O.onEvent(str, jSONObject5);
                            al0.a aVar4 = new al0.a(0L, 0L, false, 0, null, 31, null);
                            aVar4.l(al0.a.INSTANCE.b());
                            filamentViewerV28 = FilamentRecordNativeApp.this.viewer;
                            if (filamentViewerV28 != null) {
                                filamentViewerV28.record(taskId, c16, 0.0d, d19, d18, new a(optInt2, aVar4, aVar2));
                                return;
                            }
                            return;
                        }
                    }
                    FilamentEventDispatcher O2 = FilamentRecordNativeApp.this.O();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, taskId);
                    jSONObject6.put("errorCode", 201017);
                    jSONObject6.put("statistic", statistic);
                    Unit unit3 = Unit.INSTANCE;
                    String jSONObject7 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject7, "JSONObject().apply {\n   \u2026             }.toString()");
                    O2.onEvent("recordStart", jSONObject7);
                }
            });
        }
    }

    public final void B() {
        FLog.INSTANCE.w("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "destroy");
        this.hasDestroy.set(true);
        W("destroy", new Function0<Unit>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$destroy$1
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
                FilamentViewerV2 filamentViewerV2;
                SurfaceTexture surfaceTexture;
                Surface surface;
                HandlerThread T;
                filamentViewerV2 = FilamentRecordNativeApp.this.viewer;
                if (filamentViewerV2 != null) {
                    filamentViewerV2.destroy();
                }
                surfaceTexture = FilamentRecordNativeApp.this.texture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                surface = FilamentRecordNativeApp.this.surface;
                if (surface != null) {
                    surface.release();
                }
                FilamentRecordNativeApp.this.texture = null;
                FilamentRecordNativeApp.this.surface = null;
                T = FilamentRecordNativeApp.this.T();
                T.quitSafely();
            }
        });
    }

    public final void D() {
        if (!INSTANCE.g()) {
            return;
        }
        synchronized (this.viewerWaitList) {
            if (!this.appInitFinish.get()) {
                FLog.INSTANCE.e("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "evaluateViewerWaitList, appInitFinish false, return");
                return;
            }
            FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "evaluateViewerWaitList, total:" + this.viewerWaitList.size() + ", " + this);
            Iterator<Runnable> it = this.viewerWaitList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.viewerWaitList.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object E(JSONObject jSONObject, Continuation<? super Pair<ZPlanAction, String>> continuation) {
        return CoroutineScopeKt.coroutineScope(new FilamentRecordNativeApp$fetchAnimation$2(this, jSONObject, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0078 -> B:17:0x007d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ <T> Object F(String str, int i3, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        FilamentRecordNativeApp$fetchResourceWithRetry$1 filamentRecordNativeApp$fetchResourceWithRetry$1;
        Object coroutine_suspended;
        int i16;
        int i17;
        int intValue;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        FetchFileException th5;
        Object obj;
        FilamentRecordNativeApp$fetchResourceWithRetry$1 filamentRecordNativeApp$fetchResourceWithRetry$12;
        if (continuation instanceof FilamentRecordNativeApp$fetchResourceWithRetry$1) {
            filamentRecordNativeApp$fetchResourceWithRetry$1 = (FilamentRecordNativeApp$fetchResourceWithRetry$1) continuation;
            int i18 = filamentRecordNativeApp$fetchResourceWithRetry$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                filamentRecordNativeApp$fetchResourceWithRetry$1.label = i18 - Integer.MIN_VALUE;
                Object obj2 = filamentRecordNativeApp$fetchResourceWithRetry$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = filamentRecordNativeApp$fetchResourceWithRetry$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        int i19 = filamentRecordNativeApp$fetchResourceWithRetry$1.I$2;
                        i3 = filamentRecordNativeApp$fetchResourceWithRetry$1.I$1;
                        i17 = filamentRecordNativeApp$fetchResourceWithRetry$1.I$0;
                        Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) filamentRecordNativeApp$fetchResourceWithRetry$1.L$1;
                        String str2 = (String) filamentRecordNativeApp$fetchResourceWithRetry$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            return obj2;
                        } catch (Throwable th6) {
                            th5 = th6;
                            intValue = i19;
                            str = str2;
                            obj = coroutine_suspended;
                            filamentRecordNativeApp$fetchResourceWithRetry$12 = filamentRecordNativeApp$fetchResourceWithRetry$1;
                            function12 = function13;
                            FLog.INSTANCE.e("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", str + " exception, tryCount:" + (intValue + 1), th5);
                            if (th5 instanceof FetchFileException) {
                            }
                            return null;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
                Function1<? super Continuation<? super T>, ? extends Object> function14 = function1;
                i17 = 0;
                if (i17 < i3) {
                    intValue = Boxing.boxInt(i17).intValue();
                    try {
                    } catch (Throwable th7) {
                        FilamentRecordNativeApp$fetchResourceWithRetry$1 filamentRecordNativeApp$fetchResourceWithRetry$13 = filamentRecordNativeApp$fetchResourceWithRetry$1;
                        function12 = function14;
                        th5 = th7;
                        obj = coroutine_suspended;
                        filamentRecordNativeApp$fetchResourceWithRetry$12 = filamentRecordNativeApp$fetchResourceWithRetry$13;
                        FLog.INSTANCE.e("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", str + " exception, tryCount:" + (intValue + 1), th5);
                        if (th5 instanceof FetchFileException) {
                            FetchFileException fetchFileException = th5;
                            if (fetchFileException.getType() == FetchFileException.Type.DOWNLOAD_FAIL && fetchFileException.getErrorCode() != 404) {
                                i17++;
                                function14 = function12;
                                filamentRecordNativeApp$fetchResourceWithRetry$1 = filamentRecordNativeApp$fetchResourceWithRetry$12;
                                coroutine_suspended = obj;
                                if (i17 < i3) {
                                }
                            }
                        }
                        return null;
                    }
                    filamentRecordNativeApp$fetchResourceWithRetry$1.L$0 = str;
                    filamentRecordNativeApp$fetchResourceWithRetry$1.L$1 = function14;
                    filamentRecordNativeApp$fetchResourceWithRetry$1.I$0 = i17;
                    filamentRecordNativeApp$fetchResourceWithRetry$1.I$1 = i3;
                    filamentRecordNativeApp$fetchResourceWithRetry$1.I$2 = intValue;
                    filamentRecordNativeApp$fetchResourceWithRetry$1.label = 1;
                    InlineMarker.mark(6);
                    Object invoke = function14.invoke(filamentRecordNativeApp$fetchResourceWithRetry$1);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return invoke;
                }
                return null;
            }
        }
        filamentRecordNativeApp$fetchResourceWithRetry$1 = new FilamentRecordNativeApp$fetchResourceWithRetry$1(this, continuation);
        Object obj22 = filamentRecordNativeApp$fetchResourceWithRetry$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = filamentRecordNativeApp$fetchResourceWithRetry$1.label;
        if (i16 == 0) {
        }
    }

    @NotNull
    public final FilamentEventDispatcher O() {
        return (FilamentEventDispatcher) this.eventDispatcher.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(@NotNull JSONObject data) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        int optInt = data.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        int optInt2 = data.optInt("id");
        int optInt3 = data.optInt("width");
        int optInt4 = data.optInt("height");
        JSONObject optJSONObject2 = data.optJSONObject("sender");
        int optInt5 = data.optInt("theme", AppTheme.INSTANCE.b(AppTheme.DAY));
        V(data, optInt, optInt2, optInt3, optInt4, optInt5);
        JSONObject jSONObject2 = new JSONObject();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (optInt3 <= this.surfaceTextureSizeConfig.getWidth() && optInt4 <= this.surfaceTextureSizeConfig.getHeight()) {
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("userData")) == null) {
                if (optJSONObject2 != null) {
                    optJSONObject = optJSONObject2.optJSONObject(IZplanHandleApi.BUSINESS_DRESS_INFO);
                } else {
                    jSONObject = null;
                    if (jSONObject != null) {
                        jSONObject2.put("downloadResource", INSTANCE.i((Boolean) objectRef.element));
                        FilamentEventDispatcher O = O();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, optInt);
                        jSONObject3.put("errorCode", 201009);
                        jSONObject3.put("statistic", jSONObject2);
                        Unit unit = Unit.INSTANCE;
                        String jSONObject4 = jSONObject3.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject().apply {\n   \u2026\n            }.toString()");
                        O.onEvent("recordStart", jSONObject4);
                        return;
                    }
                    com.tencent.zplan.common.utils.h hVar = com.tencent.zplan.common.utils.h.f385294a;
                    JSONObject optJSONObject3 = data.optJSONObject("stickerData");
                    if (optJSONObject3 != null) {
                        str = optJSONObject3.optString(String.valueOf(optInt2));
                    } else {
                        str = null;
                    }
                    JSONObject b16 = hVar.b(str);
                    A(data, b16);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentRecordNativeApp$record$3(this, optInt, jSONObject, data, objectRef, jSONObject2, b16, optInt5, optInt3, optInt4, null), 3, null);
                    return;
                }
            }
            jSONObject = optJSONObject;
            if (jSONObject != null) {
            }
        } else {
            jSONObject2.put("downloadResource", INSTANCE.i((Boolean) objectRef.element));
            FilamentEventDispatcher O2 = O();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, optInt);
            jSONObject5.put("errorCode", 201020);
            jSONObject5.put("statistic", jSONObject2);
            Unit unit2 = Unit.INSTANCE;
            String jSONObject6 = jSONObject5.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject6, "JSONObject().apply {\n   \u2026\n            }.toString()");
            O2.onEvent("recordStart", jSONObject6);
        }
    }
}

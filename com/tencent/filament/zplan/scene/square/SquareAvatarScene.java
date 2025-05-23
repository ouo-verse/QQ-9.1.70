package com.tencent.filament.zplan.scene.square;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.Animation;
import com.tencent.filament.zplan.animation.sequencer.AnimationType;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Status;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareAvatarScene;
import com.tencent.filament.zplan.scene.square.SquareInteractionEventData;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004+,\u000b-B\u001f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u0014\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u001a\u0010$\u001a\u00020\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006."}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "Lsk0/b;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$c;", "newState", "", "H", "", "totalTime", "frameTime", "d", "Landroid/graphics/SurfaceTexture;", "surface", "v", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "handleEvent", "", "errorCode", "errorMessage", "o", "G", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$c;", "state", "", "D", "curAnimTime", "Lkotlin/coroutines/CoroutineContext;", "I", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "K", "b", "c", "NormalState", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareAvatarScene extends BaseSceneV2305 implements CoroutineScope, sk0.b {

    @NotNull
    private static final List<String> J;

    /* renamed from: G, reason: from kotlin metadata */
    private c state;

    /* renamed from: H, reason: from kotlin metadata */
    private double curAnimTime;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J$\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J,\u0010\u001d\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002J<\u0010%\u001a\u0004\u0018\u00010 2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u001aH\u0002J2\u0010*\u001a\u0004\u0018\u00010&2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J \u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020+H\u0002R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00102R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u00106\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00102R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R$\u0010@\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010D\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010;\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010P\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010C\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006]"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$NormalState;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$c;", "", "nowTime", "", "c", "a", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "handleEvent", "b", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lkotlinx/coroutines/Job;", "y", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "touchEvent", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", HippyTKDListViewAdapter.X, "Lkotlinx/coroutines/Deferred;", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "hostRes", "guestRes", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/scene/square/g;", "avatarObject", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "avatarData", "avatarResource", "o", "Lcom/tencent/filament/zplan/scene/square/j;", "extraObject", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", WadlProxyConsts.EXTRA_DATA, "p", "Lorg/json/JSONObject;", "avatarInfo", "r", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstRenderSuccess", "booted", "d", "loaded", "e", "Lkotlinx/coroutines/Deferred;", "bootJob", "f", "Lcom/tencent/filament/zplan/scene/square/g;", "v", "()Lcom/tencent/filament/zplan/scene/square/g;", "E", "(Lcom/tencent/filament/zplan/scene/square/g;)V", "hostObject", "g", "u", "D", "guestObject", tl.h.F, "Lcom/tencent/filament/zplan/scene/square/j;", "t", "()Lcom/tencent/filament/zplan/scene/square/j;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/filament/zplan/scene/square/j;)V", "i", ReportConstant.COSTREPORT_PREFIX, "()D", "B", "(D)V", "animationBeginTime", "j", "Ljava/lang/String;", "indirectLightPath", "k", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "lastTouchEvent", "", "l", UserInfo.SEX_FEMALE, "rotateCount", "<init>", "(Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public final class NormalState implements c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final FilamentUrlTemplate urlTemplate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean firstRenderSuccess;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean booted;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean loaded;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Deferred<Unit> bootJob;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private SquareAvatarObject hostObject;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private SquareAvatarObject guestObject;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private SquareExtraObject extraObject;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private double animationBeginTime;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private String indirectLightPath;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private TouchEvent lastTouchEvent;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private float rotateCount;

        public NormalState() {
            sk0.a configuration;
            FilamentUrlTemplate urlTemplate;
            FilamentNativeAppV2305 filamentNativeAppV2305 = SquareAvatarScene.this.j().get();
            this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
            this.firstRenderSuccess = new AtomicBoolean(false);
            this.booted = new AtomicBoolean(false);
            this.loaded = new AtomicBoolean(false);
            this.indirectLightPath = "";
        }

        private final void A(final com.tencent.zplan.zplantracing.c spanContext, final TouchEvent touchEvent) {
            SquareAvatarScene.this.k().d("handleTapEvent", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$handleTapEvent$1
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
                    FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
                    if (viewer != null) {
                        Point a16 = b.a(viewer, touchEvent.getLocation());
                        long hitRenderObjectIDAt = viewer.getHitRenderObjectIDAt(a16);
                        FLog.INSTANCE.i("SquareAvatarScene", "handleTapEvent, point:" + a16 + ", tapedRenderObjectId:" + hitRenderObjectIDAt);
                        FilamentNativeAppV2305 filamentNativeAppV2305 = SquareAvatarScene.this.j().get();
                        if (filamentNativeAppV2305 != null) {
                            filamentNativeAppV2305.dispatchEvent(spanContext, "SquareAvatarScene.TAP_CLICK", String.valueOf(hitRenderObjectIDAt));
                        }
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Deferred<Unit> n(com.tencent.zplan.zplantracing.c spanContext) {
            Deferred<Unit> async$default;
            async$default = BuildersKt__Builders_commonKt.async$default(SquareAvatarScene.this, null, null, new SquareAvatarScene$NormalState$bootAsync$1(this, spanContext, null), 3, null);
            return async$default;
        }

        private final SquareAvatarObject o(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, SquareAvatarObject avatarObject, SquareAvatarData.AvatarData avatarData, ReloadAvatarResourceModel avatarResource) {
            FilamentAnimation filamentAnimation;
            List listOfNotNull;
            List mutableListOf;
            Object firstOrNull;
            Object firstOrNull2;
            FilamentAnimation filamentAnimation2 = null;
            if (viewer != null) {
                if (avatarObject != null) {
                    viewer.cleanAnimationTracks(spanContext, avatarObject.e());
                    viewer.deleteRenderObject(spanContext, avatarObject.e());
                }
                if (avatarData != null && avatarResource != null) {
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
                    if (avatarData.getAnim() != null) {
                        firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(avatarData.getAnim().getHeadAnimGltf(), spanContext));
                        filamentAnimation = (FilamentAnimation) firstOrNull2;
                    } else {
                        filamentAnimation = null;
                    }
                    if (avatarData.getAnim() != null) {
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(avatarData.getAnim().getBodyAnimGltf(), spanContext));
                        filamentAnimation2 = (FilamentAnimation) firstOrNull;
                    }
                    listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new FilamentAnimation[]{filamentAnimation, filamentAnimation2});
                    Iterator it = listOfNotNull.iterator();
                    while (it.hasNext()) {
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a((FilamentAnimation) it.next()));
                        viewer.bindAnimationTrack(spanContext, createAvatarRenderObject, new Track(true, mutableListOf));
                    }
                    return new SquareAvatarObject(createAvatarRenderObject, filamentAnimation, filamentAnimation2);
                }
            }
            return null;
        }

        private final SquareExtraObject p(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, SquareExtraObject extraObject, SquareAvatarData.ExtraActorData extraData) {
            Object firstOrNull;
            List mutableListOf;
            if (viewer != null) {
                if (extraObject != null) {
                    viewer.cleanAnimationTracks(spanContext, extraObject.d());
                    viewer.deleteRenderObject(spanContext, extraObject.d());
                }
                if (extraData != null) {
                    long createGltfRenderObject = viewer.createGltfRenderObject(spanContext);
                    viewer.updateRenderObjectGltf(spanContext, createGltfRenderObject, extraData.getMeshGltf());
                    if (extraData.getTransform() != null) {
                        viewer.setRenderObjectTransform(createGltfRenderObject, extraData.getTransform());
                    }
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(FilamentViewerV2.loadAnimation$default(viewer, extraData.getAnimGltf(), null, 2, null));
                    FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
                    if (filamentAnimation != null) {
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a(filamentAnimation));
                        viewer.bindAnimationTrack(spanContext, createGltfRenderObject, new Track(true, mutableListOf));
                    }
                    return new SquareExtraObject(createGltfRenderObject, filamentAnimation);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q(com.tencent.zplan.zplantracing.c spanContext, SquareAvatarData data, ReloadAvatarResourceModel hostRes, ReloadAvatarResourceModel guestRes) {
            CameraParams camera2 = data.getCamera();
            if (camera2 == null) {
                camera2 = i.f106111a.a();
            }
            FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
            if (viewer != null) {
                String json = new Gson().toJson(camera2);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(cameraInfo)");
                viewer.setCamera(json);
            }
            b.b(data.getLight(), SquareAvatarScene.this.j());
            IndirectLight indirectLight = data.getLight().getIndirectLight();
            if (indirectLight != null) {
                indirectLight.setPath(this.indirectLightPath);
            }
            FilamentViewerV2305 viewer2 = SquareAvatarScene.this.getViewer();
            if (viewer2 != null) {
                viewer2.setLights(data.getLight());
            }
            this.extraObject = p(spanContext, SquareAvatarScene.this.getViewer(), this.extraObject, data.getExtra());
            this.hostObject = o(spanContext, SquareAvatarScene.this.getViewer(), this.hostObject, data.getHost(), hostRes);
            this.guestObject = o(spanContext, SquareAvatarScene.this.getViewer(), this.guestObject, data.getGuest(), guestRes);
            this.animationBeginTime = 0.0d;
            this.firstRenderSuccess.set(false);
            FLog.INSTANCE.d("SquareAvatarScene", "configRenderObjects end");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Deferred<ReloadAvatarResourceModel> r(com.tencent.zplan.zplantracing.c spanContext, JSONObject avatarInfo) {
            Deferred<ReloadAvatarResourceModel> async$default;
            async$default = BuildersKt__Builders_commonKt.async$default(SquareAvatarScene.this, null, null, new SquareAvatarScene$NormalState$fetchReloadAvatarResourceAsync$1(this, spanContext, avatarInfo, null), 3, null);
            return async$default;
        }

        private final void w(final com.tencent.zplan.zplantracing.c spanContext, final TouchEvent touchEvent) {
            SquareAvatarScene.this.k().d("handleDoubleTapEvent", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$handleDoubleTapEvent$1
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
                    FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
                    if (viewer != null) {
                        Point a16 = b.a(viewer, touchEvent.getLocation());
                        long hitRenderObjectIDAt = viewer.getHitRenderObjectIDAt(a16);
                        FLog.INSTANCE.i("SquareAvatarScene", "handleDoubleTapEvent, point:" + a16 + ", tapedRenderObjectId:" + hitRenderObjectIDAt);
                        FilamentNativeAppV2305 filamentNativeAppV2305 = SquareAvatarScene.this.j().get();
                        if (filamentNativeAppV2305 != null) {
                            filamentNativeAppV2305.dispatchEvent(spanContext, "SquareAvatarScene.DOUBLE_CLICK", String.valueOf(hitRenderObjectIDAt));
                        }
                    }
                }
            });
        }

        private final void x(final com.tencent.zplan.zplantracing.c spanContext, final SquareInteractionEventData data) {
            SquareAvatarScene.this.k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$handleInteractionEvent$1
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
                    SquareAvatarScene.NormalState normalState = SquareAvatarScene.NormalState.this;
                    SquareAvatarScene squareAvatarScene = SquareAvatarScene.this;
                    squareAvatarScene.H(new SquareAvatarScene.d(squareAvatarScene, spanContext, data, normalState));
                }
            });
        }

        private final Job y(com.tencent.zplan.zplantracing.c spanContext, SquareAvatarData data) {
            Job launch$default;
            launch$default = BuildersKt__Builders_commonKt.launch$default(SquareAvatarScene.this, null, null, new SquareAvatarScene$NormalState$handleOnLoadEvent$1(this, data, spanContext, null), 3, null);
            return launch$default;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void z(TouchEvent touchEvent) {
            float f16;
            float g16;
            if (touchEvent.getTouchCount() == 1 && touchEvent.getType() == TouchEventType.Pan && touchEvent.getState() != TouchEventState.Ended && touchEvent.getState() != TouchEventState.Began) {
                TouchEvent touchEvent2 = this.lastTouchEvent;
                if (touchEvent2 != null) {
                    Intrinsics.checkNotNull(touchEvent2);
                    if (touchEvent2.getLocation().x - touchEvent.getLocation().x > 0) {
                        f16 = -0.05f;
                        g16 = this.rotateCount + b.g(f16);
                        this.rotateCount = g16;
                        if (g16 < 60.0f) {
                            this.rotateCount = 60.0f;
                            return;
                        } else if (g16 <= -60.0f) {
                            this.rotateCount = -60.0f;
                            return;
                        } else {
                            final RotateParam rotateParam = new RotateParam(0.0f, 1.0f, 0.0f, f16);
                            SquareAvatarScene.this.k().d("rotateAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$handleRotateEvent$1
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
                                    List listOfNotNull;
                                    Long[] lArr = new Long[3];
                                    SquareAvatarObject hostObject = SquareAvatarScene.NormalState.this.getHostObject();
                                    lArr[0] = hostObject != null ? Long.valueOf(hostObject.e()) : null;
                                    SquareAvatarObject guestObject = SquareAvatarScene.NormalState.this.getGuestObject();
                                    lArr[1] = guestObject != null ? Long.valueOf(guestObject.e()) : null;
                                    SquareExtraObject extraObject = SquareAvatarScene.NormalState.this.getExtraObject();
                                    lArr[2] = extraObject != null ? Long.valueOf(extraObject.d()) : null;
                                    listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) lArr);
                                    Iterator it = listOfNotNull.iterator();
                                    while (it.hasNext()) {
                                        long longValue = ((Number) it.next()).longValue();
                                        FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
                                        if (viewer != null) {
                                            viewer.rotateRenderObject(longValue, rotateParam);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                    }
                }
                f16 = 0.05f;
                g16 = this.rotateCount + b.g(f16);
                this.rotateCount = g16;
                if (g16 < 60.0f) {
                }
            }
        }

        public final void B(double d16) {
            this.animationBeginTime = d16;
        }

        public final void C(@Nullable SquareExtraObject squareExtraObject) {
            this.extraObject = squareExtraObject;
        }

        public final void D(@Nullable SquareAvatarObject squareAvatarObject) {
            this.guestObject = squareAvatarObject;
        }

        public final void E(@Nullable SquareAvatarObject squareAvatarObject) {
            this.hostObject = squareAvatarObject;
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void a() {
            if (this.loaded.get() && this.firstRenderSuccess.compareAndSet(false, true)) {
                double d16 = SquareAvatarScene.this.curAnimTime - this.animationBeginTime;
                FLog.INSTANCE.i("SquareAvatarScene", "first render success. used: " + d16 + 's');
                FilamentNativeAppV2305 filamentNativeAppV2305 = SquareAvatarScene.this.j().get();
                if (filamentNativeAppV2305 != null) {
                    filamentNativeAppV2305.dispatchEvent(null, "SquareAvatarScene.EVENT_FIRST_FRAME_RENDERED_AFTER_LOAD", String.valueOf(d16));
                }
            }
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void b(@Nullable final com.tencent.zplan.zplantracing.c spanContext) {
            SquareAvatarScene.this.k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$clean$1
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
                    SquareAvatarObject hostObject = SquareAvatarScene.NormalState.this.getHostObject();
                    if (hostObject != null) {
                        FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
                        if (viewer != null) {
                            viewer.cleanAnimationTracks(spanContext, hostObject.e());
                        }
                        FilamentViewerV2305 viewer2 = SquareAvatarScene.this.getViewer();
                        if (viewer2 != null) {
                            viewer2.deleteRenderObject(spanContext, hostObject.e());
                        }
                        SquareAvatarScene.NormalState.this.E(null);
                    }
                    SquareAvatarObject guestObject = SquareAvatarScene.NormalState.this.getGuestObject();
                    if (guestObject != null) {
                        FilamentViewerV2305 viewer3 = SquareAvatarScene.this.getViewer();
                        if (viewer3 != null) {
                            viewer3.cleanAnimationTracks(spanContext, guestObject.e());
                        }
                        FilamentViewerV2305 viewer4 = SquareAvatarScene.this.getViewer();
                        if (viewer4 != null) {
                            viewer4.deleteRenderObject(spanContext, guestObject.e());
                        }
                        SquareAvatarScene.NormalState.this.D(null);
                    }
                    SquareExtraObject extraObject = SquareAvatarScene.NormalState.this.getExtraObject();
                    if (extraObject != null) {
                        FilamentViewerV2305 viewer5 = SquareAvatarScene.this.getViewer();
                        if (viewer5 != null) {
                            viewer5.cleanAnimationTracks(spanContext, extraObject.d());
                        }
                        FilamentViewerV2305 viewer6 = SquareAvatarScene.this.getViewer();
                        if (viewer6 != null) {
                            viewer6.deleteRenderObject(spanContext, extraObject.d());
                        }
                        SquareAvatarScene.NormalState.this.C(null);
                    }
                }
            });
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void c(double nowTime) {
            Long l3;
            Long l16;
            Long l17;
            List listOfNotNull;
            if (!this.loaded.get()) {
                return;
            }
            double d16 = this.animationBeginTime;
            double d17 = 0.0d;
            if (d16 == 0.0d) {
                this.animationBeginTime = nowTime;
            } else {
                d17 = nowTime - d16;
            }
            Long[] lArr = new Long[3];
            SquareAvatarObject squareAvatarObject = this.hostObject;
            if (squareAvatarObject != null) {
                l3 = Long.valueOf(squareAvatarObject.e());
            } else {
                l3 = null;
            }
            lArr[0] = l3;
            SquareAvatarObject squareAvatarObject2 = this.guestObject;
            if (squareAvatarObject2 != null) {
                l16 = Long.valueOf(squareAvatarObject2.e());
            } else {
                l16 = null;
            }
            lArr[1] = l16;
            SquareExtraObject squareExtraObject = this.extraObject;
            if (squareExtraObject != null) {
                l17 = Long.valueOf(squareExtraObject.d());
            } else {
                l17 = null;
            }
            lArr[2] = l17;
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) lArr);
            Iterator it = listOfNotNull.iterator();
            while (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
                if (viewer != null) {
                    viewer.applyAnimation(longValue, d17);
                }
            }
            FilamentViewerV2305 viewer2 = SquareAvatarScene.this.getViewer();
            if (viewer2 != null) {
                FilamentViewerV2.render$default(viewer2, false, null, 3, null);
            }
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            int hashCode = type.hashCode();
            String str = "";
            if (hashCode != 76502261) {
                if (hashCode != 1047935630) {
                    if (hashCode == 1719579098 && type.equals("onTouchEvent")) {
                        try {
                            TouchEvent touchEvent = (TouchEvent) new Gson().fromJson(data, TouchEvent.class);
                            int i3 = h.f106110a[touchEvent.getType().ordinal()];
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 == 3) {
                                        Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                                        A(spanContext, touchEvent);
                                    }
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                                    z(touchEvent);
                                }
                            } else {
                                Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                                w(spanContext, touchEvent);
                            }
                            this.lastTouchEvent = touchEvent;
                            return;
                        } catch (Exception e16) {
                            FLog.INSTANCE.e("SquareAvatarScene", "touchEvent: error: " + e16);
                            return;
                        }
                    }
                    return;
                }
                if (type.equals("SquareAvatarScene.ON_LOAD")) {
                    FLog.INSTANCE.i("SquareAvatarScene", "handleEvent: type: " + type);
                    try {
                        SquareAvatarData.Companion companion = SquareAvatarData.INSTANCE;
                        if (data != null) {
                            str = data;
                        }
                        SquareAvatarData a16 = companion.a(str);
                        if (a16 != null) {
                            y(spanContext, a16);
                            return;
                        }
                        return;
                    } catch (Exception e17) {
                        FLog.INSTANCE.e("SquareAvatarScene", "handleEvent: type: " + type + TokenParser.SP + data, e17);
                        return;
                    }
                }
                return;
            }
            if (type.equals("SquareAvatarScene.EVENT_INTERACTION")) {
                FLog.INSTANCE.i("SquareAvatarScene", "handleEvent: type: " + type);
                try {
                    SquareInteractionEventData.Companion companion2 = SquareInteractionEventData.INSTANCE;
                    if (data != null) {
                        str = data;
                    }
                    SquareInteractionEventData a17 = companion2.a(str);
                    if (a17 != null) {
                        x(spanContext, a17);
                    }
                } catch (Exception e18) {
                    FLog.INSTANCE.e("SquareAvatarScene", "handleEvent: type: " + type + TokenParser.SP + data, e18);
                }
            }
        }

        /* renamed from: s, reason: from getter */
        public final double getAnimationBeginTime() {
            return this.animationBeginTime;
        }

        @Nullable
        /* renamed from: t, reason: from getter */
        public final SquareExtraObject getExtraObject() {
            return this.extraObject;
        }

        @Nullable
        /* renamed from: u, reason: from getter */
        public final SquareAvatarObject getGuestObject() {
            return this.guestObject;
        }

        @Nullable
        /* renamed from: v, reason: from getter */
        public final SquareAvatarObject getHostObject() {
            return this.hostObject;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SquareAvatarScene f106035d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, SquareAvatarScene squareAvatarScene) {
            super(key);
            this.f106035d = squareAvatarScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("SquareAvatarScene", "there is an error in coroutine.", exception);
            String str = "";
            if (exception instanceof FetchFileException) {
                SquareAvatarScene squareAvatarScene = this.f106035d;
                FetchFileException fetchFileException = (FetchFileException) exception;
                int errorCode = fetchFileException.getErrorCode();
                String errorMessage = fetchFileException.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                squareAvatarScene.o(errorCode, str);
                return;
            }
            if (exception instanceof BlackListResourceException) {
                SquareAvatarScene squareAvatarScene2 = this.f106035d;
                String message = exception.getMessage();
                if (message != null) {
                    str = message;
                }
                squareAvatarScene2.o(201005, str);
                return;
            }
            SquareAvatarScene squareAvatarScene3 = this.f106035d;
            String message2 = exception.getMessage();
            if (message2 != null) {
                str = message2;
            }
            squareAvatarScene3.o(201000, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u001b\u0012\n\u0010 \u001a\u00060\u001dR\u00020\u001e\u00a2\u0006\u0004\b!\u0010\"J;\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J$\u0010\u0014\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0014\u0010\u0013\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0018\u0010 \u001a\u00060\u001dR\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$d;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$c;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "prevAnimTime", "Lcom/tencent/filament/zplan/scene/square/f;", "renderObject", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "nextAnimList", "e", "(Lcom/tencent/zplan/zplantracing/c;DLcom/tencent/filament/zplan/scene/square/f;Ljava/util/List;)Ljava/lang/Double;", "", "d", "nowTime", "c", "", "type", "data", "handleEvent", "b", "a", "D", "startTime", "interactionDuration", "Lcom/tencent/zplan/zplantracing/c;", "Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", "Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$NormalState;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$NormalState;", "preState", "<init>", "(Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene;Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$NormalState;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public final class d implements c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private double startTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private double interactionDuration;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.zplan.zplantracing.c spanContext;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final SquareInteractionEventData data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final NormalState preState;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SquareAvatarScene f106041f;

        public d(@Nullable SquareAvatarScene squareAvatarScene, @NotNull com.tencent.zplan.zplantracing.c cVar, @NotNull SquareInteractionEventData data, NormalState preState) {
            String str;
            String str2;
            List listOfNotNull;
            String str3;
            String str4;
            List listOfNotNull2;
            List listOfNotNull3;
            List listOf;
            int collectionSizeOrDefault;
            Object next;
            double d16;
            double d17;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(preState, "preState");
            this.f106041f = squareAvatarScene;
            this.spanContext = cVar;
            this.data = data;
            this.preState = preState;
            this.startTime = squareAvatarScene.curAnimTime;
            FilamentViewerV2305 viewer = squareAvatarScene.getViewer();
            if (viewer != null) {
                String[] strArr = new String[2];
                SquareAvatarData.AvatarAnim hostAnim = data.getHostAnim();
                if (hostAnim != null) {
                    str = hostAnim.getHeadAnimGltf();
                } else {
                    str = null;
                }
                strArr[0] = str;
                SquareAvatarData.AvatarAnim hostAnim2 = data.getHostAnim();
                if (hostAnim2 != null) {
                    str2 = hostAnim2.getBodyAnimGltf();
                } else {
                    str2 = null;
                }
                strArr[1] = str2;
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr);
                List<FilamentAnimation> f16 = b.f(viewer, cVar, listOfNotNull);
                String[] strArr2 = new String[2];
                SquareAvatarData.AvatarAnim guestAnim = data.getGuestAnim();
                if (guestAnim != null) {
                    str3 = guestAnim.getHeadAnimGltf();
                } else {
                    str3 = null;
                }
                strArr2[0] = str3;
                SquareAvatarData.AvatarAnim guestAnim2 = data.getGuestAnim();
                if (guestAnim2 != null) {
                    str4 = guestAnim2.getBodyAnimGltf();
                } else {
                    str4 = null;
                }
                strArr2[1] = str4;
                listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr2);
                List<FilamentAnimation> f17 = b.f(viewer, cVar, listOfNotNull2);
                listOfNotNull3 = CollectionsKt__CollectionsKt.listOfNotNull(data.getExtraAnimGltf());
                List<FilamentAnimation> f18 = b.f(viewer, cVar, listOfNotNull3);
                double animationBeginTime = squareAvatarScene.curAnimTime - preState.getAnimationBeginTime();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(preState.getHostObject(), f16), new Pair(preState.getGuestObject(), f17), new Pair(preState.getExtraObject(), f18)});
                List<Pair> list = listOf;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (Pair pair : list) {
                    arrayList.add(e(this.spanContext, animationBeginTime, (f) pair.component1(), (List) pair.component2()));
                }
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    next = null;
                } else {
                    next = it.next();
                    if (it.hasNext()) {
                        Double d18 = (Double) next;
                        if (d18 != null) {
                            d16 = d18.doubleValue();
                        } else {
                            d16 = 0.0d;
                        }
                        do {
                            Object next2 = it.next();
                            Double d19 = (Double) next2;
                            if (d19 != null) {
                                d17 = d19.doubleValue();
                            } else {
                                d17 = 0.0d;
                            }
                            if (Double.compare(d16, d17) < 0) {
                                next = next2;
                                d16 = d17;
                            }
                        } while (it.hasNext());
                    }
                }
                Double d26 = (Double) next;
                if (d26 != null) {
                    this.interactionDuration = d26.doubleValue();
                }
            }
            this.startTime = squareAvatarScene.curAnimTime;
            this.preState.B(0.0d);
        }

        private final void d(f renderObject) {
            List mutableListOf;
            if (renderObject != null) {
                FilamentViewerV2305 viewer = this.f106041f.getViewer();
                if (viewer != null) {
                    viewer.cleanAnimationTracks(this.spanContext, renderObject.getObjectId());
                }
                Iterator<T> it = renderObject.b().iterator();
                while (it.hasNext()) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a((FilamentAnimation) it.next()));
                    Track track = new Track(true, mutableListOf);
                    FilamentViewerV2305 viewer2 = this.f106041f.getViewer();
                    if (viewer2 != null) {
                        viewer2.bindAnimationTrack(this.spanContext, renderObject.getObjectId(), track);
                    }
                }
            }
        }

        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        private final Double e(com.tencent.zplan.zplantracing.c spanContext, double prevAnimTime, f renderObject, List<FilamentAnimation> nextAnimList) {
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
            FilamentViewerV2305 viewer = this.f106041f.getViewer();
            if (viewer != null) {
                viewer.cleanAnimationTracks(spanContext, objectId);
            }
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
                    FilamentViewerV2305 viewer2 = this.f106041f.getViewer();
                    if (viewer2 != null) {
                        viewer2.bindAnimationTrack(spanContext, objectId, track);
                    }
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
            return Double.valueOf(d16);
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void a() {
            c.a.a(this);
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void b(@Nullable com.tencent.zplan.zplantracing.c spanContext) {
            this.preState.b(spanContext);
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void c(double nowTime) {
            List listOf;
            if (nowTime - this.startTime >= this.interactionDuration) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{this.preState.getHostObject(), this.preState.getGuestObject(), this.preState.getExtraObject()});
                Iterator it = listOf.iterator();
                while (it.hasNext()) {
                    d((f) it.next());
                }
                this.preState.B(nowTime - 0.2d);
                this.f106041f.H(this.preState);
            }
            this.preState.c(nowTime);
        }

        @Override // com.tencent.filament.zplan.scene.square.SquareAvatarScene.c
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            int hashCode = type.hashCode();
            if (hashCode != 76502261) {
                if (hashCode == 1047935630 && type.equals("SquareAvatarScene.ON_LOAD")) {
                    this.f106041f.H(this.preState);
                }
            } else if (type.equals("SquareAvatarScene.EVENT_INTERACTION")) {
                this.startTime = this.f106041f.curAnimTime;
                this.preState.B(0.0d);
                return;
            }
            this.preState.handleEvent(spanContext, type, data);
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"SquareAvatarScene.ON_LOAD", "SquareAvatarScene.EVENT_INTERACTION", "SquareAvatarScene.EVENT_CLEAN_ALL", "onTouchEvent"});
        J = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.state = new NormalState();
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
        for (String str : J) {
            FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
            if (filamentNativeAppV2305 != null) {
                filamentNativeAppV2305.addEventListener(str, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(c newState) {
        this.state = newState;
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!getAttached().get()) {
            return;
        }
        double d16 = totalTime / 1000000000;
        this.curAnimTime = d16;
        this.state.c(d16);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // sk0.b
    public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.hashCode() == 186287662 && type.equals("SquareAvatarScene.EVENT_CLEAN_ALL")) {
            FLog.INSTANCE.i("SquareAvatarScene", "handleEvent: type: " + type);
            this.state.b(spanContext);
            return;
        }
        this.state.handleEvent(spanContext, type, data);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        super.o(errorCode, errorMessage);
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorCode", errorCode);
            jSONObject.put("errorMessage", errorMessage);
            Unit unit = Unit.INSTANCE;
            filamentNativeAppV2305.dispatchEvent(null, "onFilamentRenderFail", jSONObject.toString());
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void v(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        super.v(surface);
        this.state.a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016J$\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarScene$c;", "", "", "nowTime", "", "c", "a", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "handleEvent", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b(@Nullable com.tencent.zplan.zplantracing.c spanContext);

        void c(double nowTime);

        void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes6.dex */
        public static final class a {
            public static void a(@NotNull c cVar) {
            }
        }
    }
}

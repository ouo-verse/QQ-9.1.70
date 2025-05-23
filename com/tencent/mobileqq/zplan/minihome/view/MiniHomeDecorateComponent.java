package com.tencent.mobileqq.zplan.minihome.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.filament.zplan.view.controller.FilamentTouchController;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.minihome.EventAvatarLoaded;
import com.tencent.mobileqq.zplan.minihome.EventErrorCallback;
import com.tencent.mobileqq.zplan.minihome.EventFirstFrameImageReady;
import com.tencent.mobileqq.zplan.minihome.EventPixelCallback;
import com.tencent.mobileqq.zplan.minihome.EventRoomLoaded;
import com.tencent.mobileqq.zplan.minihome.EventTimeStatCallback;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.ac;
import com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.util.WeakReference;
import org.json.JSONObject;
import yk0.DecorateInfo;
import yk0.DecorateScreenPosition;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001]\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001\u001fB\u001f\u0012\u0006\u0010>\u001a\u00020:\u0012\u0006\u0010B\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0013\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u001c\u0010\u001e\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020%H\u0016J \u0010+\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J \u0010.\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020%H\u0016J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020%H\u0016J\u0018\u00100\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020*H\u0016J\u0018\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u0002012\u0006\u0010\u001d\u001a\u00020*H\u0016J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u000201H\u0016R\u0017\u0010>\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b/\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010B\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b9\u0010?\u001a\u0004\b@\u0010AR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010?R\u0018\u0010Y\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010XR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bb\u0010c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent;", "Lcom/tencent/mobileqq/zplan/minihome/view/a;", "Lkotlinx/coroutines/CoroutineScope;", "", "G", "", "H", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", BdhLogUtil.LogTag.Tag_Conn, "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", UserInfo.SEX_FEMALE, "B", "resume", "pause", "release", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", tl.h.F, "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/view/View;", "getView", "f", "roomJsonString", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "callback", "c", "a", "l", "Lcom/tencent/filament/zplan/scene/minihome/MiniHomeScene$Companion$CAMERAMODE;", "mode", "o", "slot", "Lcom/tencent/filament/zplan/scene/minihome/a;", "k", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeMessageCallback;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "decorateJson", "i", "d", "j", "", "needCompleteRoomData", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/scene/minihome/b;", "b", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "p", "night", "e", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "getScene", "()Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "setScene", "(Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;)V", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "contextRef", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "nativeApp", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "touchController", "", "J", "startTime", "Lcom/tencent/zplan/zplantracing/b;", "Lcom/tencent/zplan/zplantracing/b;", "rootSpan", "roomResourceDir", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "eventCallback", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "loadIndex", "com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$f", "I", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$f;", "jsEventListener", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeDecorateComponent implements a, CoroutineScope {

    /* renamed from: C, reason: from kotlin metadata */
    private FilamentTouchController touchController;

    /* renamed from: D, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.zplan.zplantracing.b rootSpan;

    /* renamed from: F, reason: from kotlin metadata */
    private String roomResourceDir;

    /* renamed from: G, reason: from kotlin metadata */
    private ac eventCallback;

    /* renamed from: H, reason: from kotlin metadata */
    private final AtomicInteger loadIndex;

    /* renamed from: I, reason: from kotlin metadata */
    private final f jsEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MiniHomeSceneEnum scene;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f334366h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> contextRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IFilamentNativeAppV2305 nativeApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$b", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334370e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.scene.minihome.a f334371f;

        b(int i3, com.tencent.filament.zplan.scene.minihome.a aVar) {
            this.f334370e = i3;
            this.f334371f = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:3:0x0007, B:7:0x0014, B:9:0x001c, B:11:0x0025, B:17:0x0032, B:20:0x0047), top: B:2:0x0007 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.DELETE_DECORATE_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334370e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334371f.onDecorateInfoCallback(DecorateInfo.INSTANCE.a(jSONObject.optString(MiniHomeScene.Companion.DATA.DELETE_DECORATE_CALLBACK_DATA.name(), "{}")));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "deleteDecorate handleEvent error, " + th5);
                this.f334371f.onDecorateInfoCallback(null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$c", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.scene.minihome.b f334374f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$c$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lyk0/b;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a extends TypeToken<List<DecorateScreenPosition>> {
            a() {
            }
        }

        c(int i3, com.tencent.filament.zplan.scene.minihome.b bVar) {
            this.f334373e = i3;
            this.f334374f = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:3:0x0007, B:7:0x0014, B:9:0x001c, B:11:0x0025, B:17:0x0032, B:20:0x0047), top: B:2:0x0007 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.GET_DECORATE_POSITION_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334373e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334374f.onGetDecorateScreenPosition((List) new Gson().fromJson(jSONObject.optString(MiniHomeScene.Companion.DATA.GET_DECORATE_POSITION_DATA.name(), "{}"), new a().getType()));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "getDecorateScreenPosition handleEvent error, " + th5);
                this.f334374f.onGetDecorateScreenPosition(null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$d", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334376e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IMiniHomeMessageCallback f334377f;

        d(int i3, IMiniHomeMessageCallback iMiniHomeMessageCallback) {
            this.f334376e = i3;
            this.f334377f = iMiniHomeMessageCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:3:0x0007, B:7:0x0014, B:9:0x001c, B:11:0x0025, B:17:0x0032, B:20:0x0047), top: B:2:0x0007 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.GET_ROOM_CONFIG_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334376e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334377f.onMiniHomeMessage(jSONObject.optString(MiniHomeScene.Companion.DATA.GET_ROOM_CONFIG_DATA.name(), "{}"));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "getRoomConfig handleEvent error, " + th5);
                this.f334377f.onMiniHomeMessage(null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$e", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements FilamentTouchController.b {
        e() {
        }

        @Override // com.tencent.filament.zplan.view.controller.FilamentTouchController.b
        public void q(TouchEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.dispatchEvent(null, "onTouchEvent", new Gson().toJson(event));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$f", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements sk0.b {
        f() {
        }

        @Override // sk0.b
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            QLog.i("MiniHomeDecorateComponent", 1, "handleEvent type: " + type + ", data: " + data);
            switch (type.hashCode()) {
                case -1117604162:
                    if (type.equals("avatarLoaded")) {
                        MiniHomeDecorateComponent.this.A(data);
                        return;
                    }
                    return;
                case -207899954:
                    if (type.equals("onErrorCallback")) {
                        MiniHomeDecorateComponent.this.B(data);
                        return;
                    }
                    return;
                case -72393886:
                    if (type.equals("timeStatReady")) {
                        MiniHomeDecorateComponent.this.F(data);
                        return;
                    }
                    return;
                case 361827844:
                    if (type.equals("onFirstFrameImageReady")) {
                        MiniHomeDecorateComponent.this.C(data);
                        return;
                    }
                    return;
                case 721702080:
                    if (type.equals("roomLoaded")) {
                        MiniHomeDecorateComponent.this.E(data);
                        return;
                    }
                    return;
                case 1726043468:
                    if (type.equals("onPixelCallback")) {
                        MiniHomeDecorateComponent.this.D();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$g", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334381e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference<IMiniHomeLoadCallback> f334382f;

        g(int i3, WeakReference<IMiniHomeLoadCallback> weakReference) {
            this.f334381e = i3;
            this.f334382f = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:3:0x0008, B:7:0x0015, B:9:0x001d, B:11:0x0026, B:17:0x0033, B:20:0x0048, B:22:0x0052), top: B:2:0x0008 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            IMiniHomeLoadCallback iMiniHomeLoadCallback;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.LOAD_ROOM_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334381e == jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1) && (iMiniHomeLoadCallback = this.f334382f.get()) != null) {
                            iMiniHomeLoadCallback.onMiniHomeLoadResult(jSONObject.optBoolean(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_RESULT.name(), false), jSONObject.optString(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_DATA.name(), "{}"));
                            return;
                        }
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "loadRoom handleEvent error, " + th5);
                IMiniHomeLoadCallback iMiniHomeLoadCallback2 = this.f334382f.get();
                if (iMiniHomeLoadCallback2 != null) {
                    iMiniHomeLoadCallback2.onMiniHomeLoadResult(false, null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$h", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334384e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.scene.minihome.a f334385f;

        h(int i3, com.tencent.filament.zplan.scene.minihome.a aVar) {
            this.f334384e = i3;
            this.f334385f = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:3:0x0007, B:7:0x0014, B:9:0x001c, B:11:0x0025, B:17:0x0032, B:20:0x0047), top: B:2:0x0007 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.REPLACE_DECORATE_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334384e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334385f.onDecorateInfoCallback(DecorateInfo.INSTANCE.a(jSONObject.optString(MiniHomeScene.Companion.DATA.REPLACE_CALLBACK_DATA.name(), "{}")));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "replaceDecorate handleEvent error, " + th5);
                this.f334385f.onDecorateInfoCallback(null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$i", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334387e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IMiniHomeMessageCallback f334388f;

        i(int i3, IMiniHomeMessageCallback iMiniHomeMessageCallback) {
            this.f334387e = i3;
            this.f334388f = iMiniHomeMessageCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:3:0x0007, B:7:0x0014, B:9:0x001c, B:11:0x0025, B:17:0x0032, B:20:0x0047), top: B:2:0x0007 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.ROTATE_DECORATE_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334387e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334388f.onMiniHomeMessage(jSONObject.optString(MiniHomeScene.Companion.DATA.ROTATE_DECORATE_CALLBACK_DATA.name(), "{}"));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "rotateDecorate handleEvent error, " + th5);
                this.f334388f.onMiniHomeMessage(null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$j", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class j implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334390e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.scene.minihome.a f334391f;

        j(int i3, com.tencent.filament.zplan.scene.minihome.a aVar) {
            this.f334390e = i3;
            this.f334391f = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:3:0x0007, B:7:0x0014, B:9:0x001c, B:11:0x0025, B:17:0x0032, B:20:0x0047), top: B:2:0x0007 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.SELECT_DECORATE_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334390e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334391f.onDecorateInfoCallback(DecorateInfo.INSTANCE.a(jSONObject.optString(MiniHomeScene.Companion.DATA.SELECT_DECORATE_CALLBACK_DATA.name(), "{}")));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "selectDecorate handleEvent error, " + th5);
                this.f334391f.onDecorateInfoCallback(null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$k", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class k implements sk0.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334393e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IMiniHomeMessageCallback f334394f;

        k(int i3, IMiniHomeMessageCallback iMiniHomeMessageCallback) {
            this.f334393e = i3;
            this.f334394f = iMiniHomeMessageCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:3:0x0006, B:7:0x0013, B:9:0x001b, B:11:0x0024, B:17:0x0031, B:20:0x0046), top: B:2:0x0006 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.SELECT_DECORATE_RAYCAST_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = MiniHomeDecorateComponent.this.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334393e != jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1)) {
                            return;
                        }
                        this.f334394f.onMiniHomeMessage(jSONObject.optString(MiniHomeScene.Companion.DATA.SELECT_DECORATE_CALLBACK_DATA.name(), "{}"));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                FLog.INSTANCE.e("MiniHomeDecorateComponent", "selectDecorateRaycast handleEvent error, " + th5);
                this.f334394f.onMiniHomeMessage(null);
            }
        }
    }

    public MiniHomeDecorateComponent(Context context, String uin, MiniHomeSceneEnum scene) {
        Context context2;
        File filesDir;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.context = context;
        this.uin = uin;
        this.scene = scene;
        this.f334366h = CoroutineScopeKt.MainScope();
        this.loadIndex = new AtomicInteger(0);
        this.jsEventListener = new f();
        this.startTime = System.currentTimeMillis();
        this.contextRef = new WeakReference<>(context);
        this.rootSpan = ZPlanSpanFactory.INSTANCE.startRootSpan("mini_xw");
        WeakReference<Context> weakReference = this.contextRef;
        this.roomResourceDir = ((weakReference == null || (context2 = weakReference.get()) == null || (filesDir = context2.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/room_resource/";
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String data) {
        QLog.i("MiniHomeDecorateComponent", 1, "handleOnFirstFrameImageReady, data: " + data);
        ac acVar = this.eventCallback;
        if (acVar != null) {
            acVar.a(new EventFirstFrameImageReady(data), this.scene);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        QLog.i("MiniHomeDecorateComponent", 1, "handleOnPixelCallback");
        ac acVar = this.eventCallback;
        if (acVar != null) {
            acVar.a(new EventPixelCallback(null, 1, null), this.scene);
        }
    }

    private final void G() {
        sk0.a aVar;
        Context context;
        Context context2;
        WeakReference<Context> weakReference = this.contextRef;
        FilamentTouchController filamentTouchController = null;
        if (weakReference == null || (context2 = weakReference.get()) == null) {
            aVar = null;
        } else {
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            fl0.a aVar2 = fl0.a.f399763a;
            aVar = new sk0.a(F, false, context2, 25, (dl0.k) aVar2.a(dl0.k.class), (dl0.d) aVar2.a(dl0.d.class), (dl0.g) aVar2.a(dl0.g.class));
        }
        IFilamentNativeAppV2305 c16 = aVar != null ? FilamentRenderFactory.f105773b.c(aVar) : null;
        this.nativeApp = c16;
        if (c16 != null) {
            c16.addEventListener("roomLoaded", this.jsEventListener);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.addEventListener("avatarLoaded", this.jsEventListener);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.addEventListener("onFirstFrameImageReady", this.jsEventListener);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23053 = this.nativeApp;
        if (iFilamentNativeAppV23053 != null) {
            iFilamentNativeAppV23053.addEventListener("onPixelCallback", this.jsEventListener);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23054 = this.nativeApp;
        if (iFilamentNativeAppV23054 != null) {
            iFilamentNativeAppV23054.addEventListener("timeStatReady", this.jsEventListener);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23055 = this.nativeApp;
        if (iFilamentNativeAppV23055 != null) {
            iFilamentNativeAppV23055.addEventListener("onErrorCallback", this.jsEventListener);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23056 = this.nativeApp;
        if (iFilamentNativeAppV23056 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            iFilamentNativeAppV23056.startWithEntry(bVar != null ? bVar.c() : null, "bundle/scenes/mini_home/main.js");
        }
        QLog.i("MiniHomeDecorateComponent", 1, "initEngine nativeApp: " + this.nativeApp);
        WeakReference<Context> weakReference2 = this.contextRef;
        if (weakReference2 != null && (context = weakReference2.get()) != null) {
            filamentTouchController = new FilamentTouchController(context, new e());
        }
        this.touchController = filamentTouchController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(Continuation<? super String> continuation) {
        MiniHomeDecorateComponent$loadAvatarInfo$1 miniHomeDecorateComponent$loadAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        String jSONObject;
        if (continuation instanceof MiniHomeDecorateComponent$loadAvatarInfo$1) {
            miniHomeDecorateComponent$loadAvatarInfo$1 = (MiniHomeDecorateComponent$loadAvatarInfo$1) continuation;
            int i16 = miniHomeDecorateComponent$loadAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeDecorateComponent$loadAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeDecorateComponent$loadAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeDecorateComponent$loadAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ZPlanAvatarInfoHelperImpl.Companion companion = ZPlanAvatarInfoHelperImpl.INSTANCE;
                    String str = this.uin;
                    miniHomeDecorateComponent$loadAvatarInfo$1.label = 1;
                    obj = companion.fetchOtherAvatarInfoWithUin(str, miniHomeDecorateComponent$loadAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                jSONObject = jSONObject2 == null ? jSONObject2.toString() : null;
                if (jSONObject == null) {
                    return jSONObject;
                }
                String jSONObject3 = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().toString()");
                return jSONObject3;
            }
        }
        miniHomeDecorateComponent$loadAvatarInfo$1 = new MiniHomeDecorateComponent$loadAvatarInfo$1(this, continuation);
        Object obj2 = miniHomeDecorateComponent$loadAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeDecorateComponent$loadAvatarInfo$1.label;
        if (i3 != 0) {
        }
        JSONObject jSONObject22 = (JSONObject) obj2;
        if (jSONObject22 == null) {
        }
        if (jSONObject == null) {
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void b(com.tencent.filament.zplan.scene.minihome.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "getDecorateScreenPosition " + this.nativeApp);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.GET_DECORATE_POSITION_CALLBACK.name(), new c(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
                String name = MiniHomeScene.Companion.EVENT.GET_DECORATE_POSITION.name();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
                Unit unit = Unit.INSTANCE;
                iFilamentNativeAppV23052.dispatchEvent(c16, name, jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "getRoomConfig error, " + th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0015 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:30:0x0006, B:7:0x0016, B:9:0x0039, B:10:0x0040, B:12:0x0050, B:14:0x0063, B:15:0x0071, B:17:0x0075, B:19:0x0079, B:20:0x007d), top: B:29:0x0006 }] */
    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String roomJsonString, IMiniHomeLoadCallback callback) {
        boolean z16;
        if (roomJsonString != null) {
            try {
                if (roomJsonString.length() != 0) {
                    z16 = false;
                    if (z16) {
                        QLog.i("MiniHomeDecorateComponent", 1, "loadRoom " + this.nativeApp + ", " + roomJsonString);
                        WeakReference weakReference = callback != null ? new WeakReference(callback) : null;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MiniHomeScene.Companion.DATA.ROOM_JSON.name(), roomJsonString);
                        if (weakReference != null) {
                            int incrementAndGet = this.loadIndex.incrementAndGet();
                            jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
                            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
                            if (iFilamentNativeAppV2305 != null) {
                                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.LOAD_ROOM_CALLBACK.name(), new g(incrementAndGet, weakReference));
                            }
                        }
                        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
                        if (iFilamentNativeAppV23052 != null) {
                            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                            iFilamentNativeAppV23052.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.LOAD_ROOM.name(), jSONObject.toString());
                            return;
                        }
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "loadRoom error, " + th5);
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void d(String slot, com.tencent.filament.zplan.scene.minihome.a callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "deleteDecorate " + slot);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.DELETE_DECORATE_CALLBACK.name(), new b(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
                String name = MiniHomeScene.Companion.EVENT.DELETE_DECORATE.name();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
                jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_SLOT.name(), slot);
                Unit unit = Unit.INSTANCE;
                iFilamentNativeAppV23052.dispatchEvent(c16, name, jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "deleteDecorate error, " + th5);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void e(boolean night) {
        QLog.i("MiniHomeDecorateComponent", 1, "setIsNight : " + night + ", " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
            String name = MiniHomeScene.Companion.EVENT.SET_IS_NIGHT.name();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.IS_NIGHT.name(), night);
            Unit unit = Unit.INSTANCE;
            iFilamentNativeAppV2305.dispatchEvent(c16, name, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void f() {
        QLog.i("MiniHomeDecorateComponent", 1, "initRoom " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.INIT_HOME.name(), null);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            com.tencent.zplan.zplantracing.b bVar2 = this.rootSpan;
            com.tencent.zplan.zplantracing.c c16 = bVar2 != null ? bVar2.c() : null;
            String name = MiniHomeScene.Companion.EVENT.SET_GYRO_ANGLE_LIMIT.name();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.GYRO_ANGLE_LIMIT_PITCH.name(), "4.0");
            jSONObject.put(MiniHomeScene.Companion.DATA.GYRO_ANGLE_LIMIT_YAW.name(), "15.0");
            Unit unit = Unit.INSTANCE;
            iFilamentNativeAppV23052.dispatchEvent(c16, name, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void g(int x16, int y16, IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "selectDecorateRaycast " + x16 + ", " + y16);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_RAYCAST_VIEWPORT_X.name(), x16);
            jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_RAYCAST_VIEWPORT_Y.name(), y16);
            jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.SELECT_DECORATE_RAYCAST_CALLBACK.name(), new k(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                iFilamentNativeAppV23052.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.SELECT_DECORATE_RAYCAST.name(), jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "selectDecorate error, " + th5);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f334366h.getCoroutineContext();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public View getView() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            return iFilamentNativeAppV2305.getView();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void h(MiniHomeSceneEnum scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void i(String slot, String decorateJson, com.tencent.filament.zplan.scene.minihome.a callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(decorateJson, "decorateJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "replaceDecorate " + this.nativeApp + ", " + slot);
            if (decorateJson.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_SLOT.name(), slot);
            jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_JSON_DATA.name(), decorateJson);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.REPLACE_DECORATE_CALLBACK.name(), new h(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                iFilamentNativeAppV23052.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.REPLACE_DECORATE.name(), jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "replaceDecorate error, " + th5);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void j(String slot, IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "rotateDecorate " + slot);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.ROTATE_DECORATE_CALLBACK.name(), new i(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
                String name = MiniHomeScene.Companion.EVENT.ROTATE_DECORATE.name();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
                jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_SLOT.name(), slot);
                Unit unit = Unit.INSTANCE;
                iFilamentNativeAppV23052.dispatchEvent(c16, name, jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "rotateDecorate error, " + th5);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void k(String slot, com.tencent.filament.zplan.scene.minihome.a callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "selectDecorate " + this.nativeApp + ", " + slot);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.DECORATE_SLOT.name(), slot);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.SELECT_DECORATE_CALLBACK.name(), new j(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                iFilamentNativeAppV23052.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.SELECT_DECORATE.name(), jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "selectDecorate error, " + th5);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void l() {
        boolean z16 = true;
        QLog.i("MiniHomeDecorateComponent", 1, "resetRoomAndAvatar " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
            String name = MiniHomeScene.Companion.EVENT.ENABLE_GYRO_SENSOR.name();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.ENABLE_GYRO_SENSOR.name(), this.scene.getSceneConfig().getUseGyroscopeSensor());
            Unit unit = Unit.INSTANCE;
            iFilamentNativeAppV2305.dispatchEvent(c16, name, jSONObject.toString());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            com.tencent.zplan.zplantracing.b bVar2 = this.rootSpan;
            com.tencent.zplan.zplantracing.c c17 = bVar2 != null ? bVar2.c() : null;
            String name2 = MiniHomeScene.Companion.EVENT.ENABLE_TOUCH_EVENT.name();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiniHomeScene.Companion.DATA.ENABLE_TOUCH_EVENT.name(), this.scene.getSceneConfig().getUseTouchEvent());
            Unit unit2 = Unit.INSTANCE;
            iFilamentNativeAppV23052.dispatchEvent(c17, name2, jSONObject2.toString());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23053 = this.nativeApp;
        if (iFilamentNativeAppV23053 != null) {
            com.tencent.zplan.zplantracing.b bVar3 = this.rootSpan;
            com.tencent.zplan.zplantracing.c c18 = bVar3 != null ? bVar3.c() : null;
            String name3 = MiniHomeScene.Companion.EVENT.RESET_ROOM_AND_AVATAR.name();
            JSONObject jSONObject3 = new JSONObject();
            String name4 = MiniHomeScene.Companion.DATA.NEED_LOAD_EVENT.name();
            if (!this.scene.getSceneConfig().getNeedRoomLoadEvent() && !this.scene.getSceneConfig().getNeedAvatarLoadEvent()) {
                z16 = false;
            }
            jSONObject3.put(name4, z16);
            jSONObject3.put(MiniHomeScene.Companion.DATA.FIRST_FRAME_TYPE.name(), this.scene.getSceneConfig().getFirstFrameType());
            Unit unit3 = Unit.INSTANCE;
            iFilamentNativeAppV23053.dispatchEvent(c18, name3, jSONObject3.toString());
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void m() {
        QLog.i("MiniHomeDecorateComponent", 1, "cancelSelectDecorate " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.CANCEL_SELECT_DECORATE.name(), null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void n(boolean needCompleteRoomData, IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            QLog.i("MiniHomeDecorateComponent", 1, "getRoomConfig " + this.nativeApp);
            int incrementAndGet = this.loadIndex.incrementAndGet();
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.GET_ROOM_CONFIG_CALLBACK.name(), new d(incrementAndGet, callback));
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
                com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
                String name = MiniHomeScene.Companion.EVENT.GET_ROOM_CONFIG.name();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
                jSONObject.put(MiniHomeScene.Companion.DATA.NEED_ROOM_JSON_DATA.name(), needCompleteRoomData);
                Unit unit = Unit.INSTANCE;
                iFilamentNativeAppV23052.dispatchEvent(c16, name, jSONObject.toString());
            }
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateComponent", 1, "getRoomConfig error, " + th5);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void o(MiniHomeScene.Companion.CAMERAMODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        QLog.i("MiniHomeDecorateComponent", 1, "setCameraMode " + this.nativeApp + ", " + mode);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            com.tencent.zplan.zplantracing.c c16 = bVar != null ? bVar.c() : null;
            String name = MiniHomeScene.Companion.EVENT.SET_CAMERA_MODE.name();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.CAMERA_MODE.name(), mode.getValue());
            Unit unit = Unit.INSTANCE;
            iFilamentNativeAppV2305.dispatchEvent(c16, name, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void onTouchEvent(MotionEvent event) {
        GestureDetector m3;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.scene.getSceneConfig().getUseTouchEvent()) {
            FilamentTouchController filamentTouchController = this.touchController;
            if (filamentTouchController != null) {
                filamentTouchController.z(event);
            }
            FilamentTouchController filamentTouchController2 = this.touchController;
            if (filamentTouchController2 == null || (m3 = filamentTouchController2.m()) == null) {
                return;
            }
            m3.onTouchEvent(event);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void p(ac callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.eventCallback = callback;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void pause() {
        QLog.i("MiniHomeDecorateComponent", 1, "pause nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void release() {
        QLog.i("MiniHomeDecorateComponent", 1, "release nativeApp: " + this.nativeApp);
        this.touchController = null;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.destroy();
        }
        this.nativeApp = null;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void resume() {
        QLog.i("MiniHomeDecorateComponent", 1, "resume nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(String data) {
        ac acVar;
        QLog.i("MiniHomeDecorateComponent", 1, "handleOnAvatarLoaded");
        if (!this.scene.getSceneConfig().getNeedAvatarLoadEvent() || (acVar = this.eventCallback) == null) {
            return;
        }
        acVar.a(new EventAvatarLoaded(data), this.scene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String data) {
        QLog.i("MiniHomeDecorateComponent", 1, "handleOnErrorCallback");
        ac acVar = this.eventCallback;
        if (acVar != null) {
            acVar.a(new EventErrorCallback(data), this.scene);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String data) {
        ac acVar;
        QLog.i("MiniHomeDecorateComponent", 1, "handleOnRoomLoaded");
        if (!this.scene.getSceneConfig().getNeedRoomLoadEvent() || (acVar = this.eventCallback) == null) {
            return;
        }
        acVar.a(new EventRoomLoaded(data), this.scene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String data) {
        QLog.i("MiniHomeDecorateComponent", 1, "handleOnTimeStatReady");
        ac acVar = this.eventCallback;
        if (acVar != null) {
            acVar.a(new EventTimeStatCallback(data), this.scene);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.view.a
    public void a(IMiniHomeLoadCallback callback) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new MiniHomeDecorateComponent$loadAvatar$1(this, callback != null ? new WeakReference(callback) : null, null), 3, null);
    }
}

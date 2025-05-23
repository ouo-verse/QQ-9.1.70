package com.tencent.mobileqq.qwallet.pet.filament;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.filament.Engine;
import com.google.android.filament.EntityManager;
import com.google.android.filament.RenderableManager;
import com.google.android.filament.Scene;
import com.google.android.filament.TransformManager;
import com.google.android.filament.gltfio.AssetLoader;
import com.google.android.filament.gltfio.FilamentAsset;
import com.google.android.filament.gltfio.MaterialProvider;
import com.google.android.filament.gltfio.ResourceLoader;
import com.google.android.filament.utils.Float3;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.pet.data.PetReportBean;
import com.tencent.mobileqq.qwallet.pet.filament.d;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u00019B7\u0012\u0006\u0010=\u001a\u00020%\u0012\u0006\u0010?\u001a\u00020%\u0012\u0006\u0010C\u001a\u00020%\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010{\u001a\u00020z\u00a2\u0006\u0004\b|\u0010}J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J#\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u001c\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aJ\u001a\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010 J\u0012\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016J\u0016\u0010/\u001a\u00020\u00072\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010-J\b\u00100\u001a\u00020\u0007H\u0016J\u000e\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0011J\u0010\u00104\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u000205H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\u0010\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u00020)H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\u0010\u0010;\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0011H\u0016R\u0014\u0010=\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010<R\u0014\u0010?\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0017\u0010C\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b@\u0010<\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010<R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010[R\u0016\u0010^\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010]R\u0016\u0010_\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010]R\u0016\u0010`\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010]R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010aR\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020%0b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010cR\u0018\u0010f\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010eR\u0018\u0010i\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010]R\u0014\u0010m\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010lR$\u0010p\u001a\u00020\u00142\u0006\u0010n\u001a\u00020\u00148\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010]\u001a\u0004\bg\u0010oR$\u0010q\u001a\u00020\u00142\u0006\u0010n\u001a\u00020\u00148\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010]\u001a\u0004\bq\u0010oR\u0014\u0010r\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010lR\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010tR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010vR\u0014\u0010y\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010x\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006~"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController;", "", "Lcom/tencent/mobileqq/qwallet/pet/filament/d$a;", "Ljava/nio/Buffer;", "buffer", "Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController$a;", "callback", "", "t", "Lcom/google/android/filament/gltfio/FilamentAsset;", "asset", "l", "(Lcom/google/android/filament/gltfio/FilamentAsset;Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "", "activeEntities", "readyRenderables", "", "readyCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isActive", "v", "p", "Lcom/tencent/mobileqq/qwallet/pet/filament/b;", "launchModelInfo", "Lkotlin/Function0;", "finishCallback", ReportConstant.COSTREPORT_PREFIX, "Lcom/google/android/filament/utils/b;", "centerPoint", "customTranslation", "Lcom/google/android/filament/utils/d;", BdhLogUtil.LogTag.Tag_Conn, "transform", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "entityInstance", "", DomainData.DOMAIN_NAME, "k", "j", "", "animationTimeSeconds", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "entityNames", HippyTKDListViewAdapter.X, "B", "repeatCount", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qwallet/pet/filament/c;", "w", "Lcom/tencent/mobileqq/qwallet/pet/filament/e;", "y", "onAnimationStart", "progress", "a", "onAnimationEnd", "onAnimationRepeat", "Ljava/lang/String;", "petType", "b", "actionType", "c", "o", "()Ljava/lang/String;", "id", "Lcom/google/android/filament/Engine;", "d", "Lcom/google/android/filament/Engine;", EnginePathProvider.ENGINE_DIR, "Lcom/google/android/filament/Scene;", "e", "Lcom/google/android/filament/Scene;", "scene", "f", "TAG", "g", "Lcom/google/android/filament/gltfio/FilamentAsset;", "Lcom/tencent/mobileqq/qwallet/pet/filament/d;", h.F, "Lcom/tencent/mobileqq/qwallet/pet/filament/d;", "modelAnimator", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "fetchResourcesJob", "Lcom/google/android/filament/gltfio/AssetLoader;", "Lcom/google/android/filament/gltfio/AssetLoader;", "assetLoader", "Lcom/google/android/filament/gltfio/ResourceLoader;", "Lcom/google/android/filament/gltfio/ResourceLoader;", "resourceLoader", "Z", "normalizeSkinningWeights", "recomputeBoundingBoxes", "ignoreBindTransform", "[I", "", "Ljava/util/Set;", "currentHiddenEntities", "Lcom/tencent/mobileqq/qwallet/pet/filament/c;", "animationCallback", "r", "Lcom/tencent/mobileqq/qwallet/pet/filament/e;", "modelReadyCallback", "active", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isBeginLoad", "<set-?>", "()Z", "isParseFinish", "isReady", "isDestroy", "", "J", "startLoadTime", "Lcom/tencent/mobileqq/qwallet/pet/filament/b;", "Lcom/tencent/mobileqq/qwallet/pet/data/h;", "Lcom/tencent/mobileqq/qwallet/pet/data/h;", "reportBean", "Lcom/google/android/filament/gltfio/MaterialProvider;", "materialProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/filament/Engine;Lcom/google/android/filament/Scene;Lcom/google/android/filament/gltfio/MaterialProvider;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ModelController implements d.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String petType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Engine engine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scene scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FilamentAsset asset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d modelAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchResourcesJob;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AssetLoader assetLoader;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ResourceLoader resourceLoader;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean normalizeSkinningWeights;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean recomputeBoundingBoxes;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean ignoreBindTransform;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] readyRenderables;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> currentHiddenEntities;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c animationCallback;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e modelReadyCallback;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean active;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isBeginLoad;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean isParseFinish;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean isReady;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isDestroy;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private long startLoadTime;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LaunchModelInfo launchModelInfo;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PetReportBean reportBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController$a;", "", "", LayoutAttrDefine.CLICK_URI, "Ljava/nio/Buffer;", "b", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a();

        @Nullable
        Buffer b(@NotNull String uri);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pet/filament/ModelController$b", "Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController$a;", "", LayoutAttrDefine.CLICK_URI, "Ljava/nio/Buffer;", "b", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LaunchModelInfo f278868a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModelController f278869b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f278870c;

        b(LaunchModelInfo launchModelInfo, ModelController modelController, Function0<Unit> function0) {
            this.f278868a = launchModelInfo;
            this.f278869b = modelController;
            this.f278870c = function0;
        }

        @Override // com.tencent.mobileqq.qwallet.pet.filament.ModelController.a
        public void a() {
            this.f278869b.isParseFinish = true;
            this.f278870c.invoke();
        }

        @Override // com.tencent.mobileqq.qwallet.pet.filament.ModelController.a
        @Nullable
        public Buffer b(@NotNull String uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return jl2.a.f410583a.a(this.f278868a.getDirPath() + "/" + uri);
        }
    }

    public ModelController(@NotNull String petType, @NotNull String actionType, @NotNull String id5, @NotNull Engine engine, @NotNull Scene scene, @NotNull MaterialProvider materialProvider) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(materialProvider, "materialProvider");
        this.petType = petType;
        this.actionType = actionType;
        this.id = id5;
        this.engine = engine;
        this.scene = scene;
        this.TAG = "QWallet.Pet.Model[" + id5 + "]";
        d dVar = new d();
        this.modelAnimator = dVar;
        this.assetLoader = new AssetLoader(engine, materialProvider, EntityManager.get());
        this.normalizeSkinningWeights = true;
        this.readyRenderables = new int[128];
        this.currentHiddenEntities = new LinkedHashSet();
        this.isBeginLoad = new AtomicBoolean(false);
        this.isDestroy = new AtomicBoolean(false);
        this.reportBean = new PetReportBean(petType, actionType, id5, 0, 0, 0, 56, null);
        this.resourceLoader = new ResourceLoader(engine, this.normalizeSkinningWeights, this.recomputeBoundingBoxes, this.ignoreBindTransform);
        dVar.e(this);
    }

    private final void i(final FilamentAsset asset) {
        List take;
        int[] intArray;
        RenderableManager renderableManager = this.engine.getRenderableManager();
        Intrinsics.checkNotNullExpressionValue(renderableManager, "engine.renderableManager");
        final Ref.IntRef intRef = new Ref.IntRef();
        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.tencent.mobileqq.qwallet.pet.filament.ModelController$applyRender$popRenderables$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                int[] iArr;
                Ref.IntRef intRef2 = Ref.IntRef.this;
                FilamentAsset filamentAsset = asset;
                iArr = this.readyRenderables;
                intRef2.element = filamentAsset.popRenderables(iArr);
                return Boolean.valueOf(Ref.IntRef.this.element != 0);
            }
        };
        int[] iArr = new int[128];
        while (function0.invoke().booleanValue()) {
            int m3 = m(iArr, this.readyRenderables, intRef.element);
            for (int i3 = 0; i3 < m3; i3++) {
                renderableManager.setScreenSpaceContactShadows(renderableManager.getInstance(iArr[i3]), true);
            }
            take = ArraysKt___ArraysKt.take(iArr, m3);
            intArray = CollectionsKt___CollectionsKt.toIntArray(take);
            String str = this.TAG;
            int i16 = intRef.element;
            ArrayList arrayList = new ArrayList(intArray.length);
            for (int i17 : intArray) {
                arrayList.add(asset.getName(i17));
            }
            QLog.i(str, 1, "populateScene addEntities original=" + i16 + " result=" + m3 + " " + arrayList);
            this.scene.addEntities(intArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(FilamentAsset filamentAsset, a aVar, Continuation<? super Unit> continuation) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        String[] resourceUris = filamentAsset.getResourceUris();
        Intrinsics.checkNotNullExpressionValue(resourceUris, "asset.resourceUris");
        for (String resourceUri : resourceUris) {
            Intrinsics.checkNotNullExpressionValue(resourceUri, "resourceUri");
            Buffer b16 = aVar.b(resourceUri);
            if (b16 != null) {
                hashMap.put(resourceUri, b16);
            }
        }
        this.reportBean.c((int) (System.currentTimeMillis() - currentTimeMillis));
        return CorountineFunKt.i(i.e.f261783e, this.TAG, null, new ModelController$fetchResources$3(hashMap, this, filamentAsset, aVar, null), continuation, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003f A[EDGE_INSN: B:27:0x003f->B:12:0x003f BREAK  A[LOOP:1: B:18:0x0025->B:28:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[LOOP:1: B:18:0x0025->B:28:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m(int[] activeEntities, int[] readyRenderables, int readyCount) {
        Set set;
        Set set2;
        String str;
        boolean z16;
        boolean z17;
        boolean startsWith$default;
        int i3 = 0;
        for (int i16 = 0; i16 < readyCount; i16++) {
            FilamentAsset filamentAsset = this.asset;
            if (filamentAsset != null) {
                str = filamentAsset.getName(readyRenderables[i16]);
            } else {
                str = null;
            }
            Set<String> set3 = this.currentHiddenEntities;
            if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                for (String str2 : set3) {
                    z16 = true;
                    if (str != null) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null);
                        if (startsWith$default) {
                            z17 = true;
                            if (!z17) {
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
            }
            z16 = false;
            if (!z16) {
                activeEntities[i3] = readyRenderables[i16];
                i3++;
            }
        }
        String str3 = this.TAG;
        set = ArraysKt___ArraysKt.toSet(readyRenderables);
        set2 = ArraysKt___ArraysKt.toSet(activeEntities);
        QLog.d(str3, 2, "filterActiveEntities, original:" + set + " ret: " + set2);
        return i3;
    }

    private final void t(Buffer buffer, a callback) {
        if (buffer == null) {
            return;
        }
        FilamentAsset createAssetFromJson = this.assetLoader.createAssetFromJson(buffer);
        if (createAssetFromJson == null) {
            QLog.w(this.TAG, 1, "loadModelGltfAsync asset is null");
            return;
        }
        this.asset = createAssetFromJson;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
        if (f16 != null) {
            bVar = CorountineFunKt.e(f16, this.TAG, null, null, Boolean.TRUE, new ModelController$loadModelGltfAsync$1(this, createAssetFromJson, callback, null), 6, null);
        }
        this.fetchResourcesJob = bVar;
    }

    public final void A(@Nullable com.google.android.filament.utils.d transform) {
        if (transform == null) {
            return;
        }
        TransformManager transformManager = this.engine.getTransformManager();
        Intrinsics.checkNotNullExpressionValue(transformManager, "engine.transformManager");
        FilamentAsset filamentAsset = this.asset;
        if (filamentAsset != null) {
            transformManager.setTransform(transformManager.getInstance(filamentAsset.getRoot()), com.google.android.filament.utils.e.c(transform).f());
        }
    }

    public void B() {
        this.modelAnimator.h();
    }

    @Nullable
    public com.google.android.filament.utils.d C(@NotNull Float3 centerPoint, @NotNull Float3 customTranslation) {
        Intrinsics.checkNotNullParameter(centerPoint, "centerPoint");
        Intrinsics.checkNotNullParameter(customTranslation, "customTranslation");
        FilamentAsset filamentAsset = this.asset;
        if (filamentAsset != null) {
            TransformManager transformManager = this.engine.getTransformManager();
            Intrinsics.checkNotNullExpressionValue(transformManager, "engine.transformManager");
            float[] center = filamentAsset.getBoundingBox().getCenter();
            Float3 float3 = new Float3(center[0], center[1], center[2]);
            float[] halfExtent = filamentAsset.getBoundingBox().getHalfExtent();
            Float3 float32 = new Float3(halfExtent[0], halfExtent[1], halfExtent[2]);
            float max = 2.0f / (Math.max(float32.getX(), Math.max(float32.getY(), float32.getZ())) * 2.0f);
            Float3 float33 = new Float3(centerPoint.getX() / max, centerPoint.getY() / max, centerPoint.getZ() / max);
            Float3 float34 = new Float3(float33.getX() - float3.getX(), float33.getY() - float3.getY(), float33.getZ() - float3.getZ());
            com.google.android.filament.utils.d e16 = com.google.android.filament.utils.e.a(new Float3(max)).e(com.google.android.filament.utils.e.b(new Float3(float34.getX() + customTranslation.getX(), float34.getY() + customTranslation.getY(), float34.getZ() + customTranslation.getZ())));
            transformManager.setTransform(transformManager.getInstance(filamentAsset.getRoot()), com.google.android.filament.utils.e.c(e16).f());
            return e16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.d.a
    public void a(float progress) {
        c cVar;
        if (!this.isDestroy.get() && (cVar = this.animationCallback) != null) {
            cVar.d(this.petType, this.actionType, this.id, progress);
        }
    }

    public void j() {
        boolean z16;
        if (this.isDestroy.get()) {
            return;
        }
        this.resourceLoader.asyncUpdateLoad();
        float asyncGetLoadProgress = this.resourceLoader.asyncGetLoadProgress();
        boolean z17 = this.isReady;
        boolean z18 = false;
        if (asyncGetLoadProgress >= 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z17 != z16) {
            this.reportBean.b((int) (System.currentTimeMillis() - this.startLoadTime));
            if (asyncGetLoadProgress >= 1.0f) {
                z18 = true;
            }
            this.isReady = z18;
            QLog.i(this.TAG, 1, "checkReady: " + z18 + ", cost: " + (System.currentTimeMillis() - this.startLoadTime));
            e eVar = this.modelReadyCallback;
            if (eVar != null) {
                eVar.b(this.petType, this.actionType, this.id, this.isReady);
            }
            ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_qwallet_pet", this.reportBean.d());
        }
    }

    public void k() {
        Job a16;
        if (this.isDestroy.getAndSet(true)) {
            QLog.w(this.TAG, 1, "destroyModel fail isDestroy");
            return;
        }
        try {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchResourcesJob;
            if (bVar != null && (a16 = bVar.a()) != null) {
                Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
            }
            float asyncGetLoadProgress = this.resourceLoader.asyncGetLoadProgress();
            if (this.isBeginLoad.compareAndSet(true, false) && asyncGetLoadProgress < 1.0f) {
                QLog.i(this.TAG, 1, "destroyModel: isBeginLoad=" + this.isBeginLoad.get() + ", progress=" + asyncGetLoadProgress);
                this.resourceLoader.asyncCancelLoad();
            }
            this.resourceLoader.evictResourceData();
            FilamentAsset filamentAsset = this.asset;
            if (filamentAsset != null) {
                this.scene.removeEntities(filamentAsset.getEntities());
                this.assetLoader.destroyAsset(filamentAsset);
                this.asset = null;
                this.modelAnimator.d();
            }
            this.assetLoader.destroy();
            this.resourceLoader.destroy();
        } catch (Exception e16) {
            QLog.w(this.TAG, 1, "destroyModel error:", e16);
        }
    }

    @Nullable
    public String n(int entityInstance) {
        FilamentAsset filamentAsset = this.asset;
        if (filamentAsset != null) {
            return filamentAsset.getName(entityInstance);
        }
        return null;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.d.a
    public void onAnimationEnd() {
        c cVar;
        if (!this.isDestroy.get() && (cVar = this.animationCallback) != null) {
            cVar.g(this.petType, this.actionType, this.id);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.d.a
    public void onAnimationStart() {
        c cVar;
        if (!this.isDestroy.get() && (cVar = this.animationCallback) != null) {
            cVar.c(this.petType, this.actionType, this.id);
        }
    }

    /* renamed from: p, reason: from getter */
    public boolean getActive() {
        return this.active;
    }

    /* renamed from: q, reason: from getter */
    public boolean getIsReady() {
        return this.isReady;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsParseFinish() {
        return this.isParseFinish;
    }

    public final void s(@NotNull LaunchModelInfo launchModelInfo, @NotNull Function0<Unit> finishCallback) {
        Intrinsics.checkNotNullParameter(launchModelInfo, "launchModelInfo");
        Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
        this.startLoadTime = System.currentTimeMillis();
        this.launchModelInfo = launchModelInfo;
        t(jl2.a.f410583a.a(launchModelInfo.getDirPath() + "/" + launchModelInfo.getFileName()), new b(launchModelInfo, this, finishCallback));
    }

    public void u(float animationTimeSeconds) {
        float animTotalTime;
        boolean z16;
        LaunchModelInfo launchModelInfo = this.launchModelInfo;
        if (launchModelInfo != null && this.active && this.isReady) {
            if (launchModelInfo.getEndTime() != 0) {
                animTotalTime = (launchModelInfo.getEndTime() - launchModelInfo.getBeginTime()) / 1000;
            } else {
                animTotalTime = this.modelAnimator.getAnimTotalTime();
            }
            int i3 = 0;
            if (animTotalTime == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = (int) (animationTimeSeconds / animTotalTime);
                animationTimeSeconds %= animTotalTime;
            }
            if (1000 * animationTimeSeconds >= launchModelInfo.getBeginTime()) {
                FilamentAsset filamentAsset = this.asset;
                if (filamentAsset != null) {
                    i(filamentAsset);
                }
                this.modelAnimator.g(true);
            }
            this.modelAnimator.a(animationTimeSeconds - ((launchModelInfo.getBeginTime() - launchModelInfo.getElapseAnimTime()) / 1000), i3);
        }
    }

    public void v(boolean isActive) {
        this.active = isActive;
    }

    public void w(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animationCallback = callback;
    }

    public final synchronized void x(@Nullable Set<String> entityNames) {
        Set<String> subtract;
        Set<String> subtract2;
        int[] iArr;
        int[] iArr2;
        if (entityNames != null) {
            subtract = CollectionsKt___CollectionsKt.subtract(this.currentHiddenEntities, entityNames);
            subtract2 = CollectionsKt___CollectionsKt.subtract(entityNames, this.currentHiddenEntities);
            this.currentHiddenEntities.clear();
            this.currentHiddenEntities.addAll(entityNames);
            if (!subtract.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (String str : subtract) {
                    FilamentAsset filamentAsset = this.asset;
                    if (filamentAsset != null) {
                        iArr2 = filamentAsset.getEntitiesByPrefix(str);
                    } else {
                        iArr2 = null;
                    }
                    if (iArr2 != null) {
                        arrayList.add(iArr2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.scene.addEntities((int[]) it.next());
                    }
                    QLog.i(this.TAG, 1, "addEntities: " + arrayList);
                }
            }
            if (!subtract2.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : subtract2) {
                    FilamentAsset filamentAsset2 = this.asset;
                    if (filamentAsset2 != null) {
                        iArr = filamentAsset2.getEntitiesByPrefix(str2);
                    } else {
                        iArr = null;
                    }
                    if (iArr != null) {
                        arrayList2.add(iArr);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        this.scene.removeEntities((int[]) it5.next());
                    }
                    QLog.i(this.TAG, 1, "removeEntities: " + arrayList2);
                }
            }
        }
    }

    public void y(@NotNull e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.modelReadyCallback = callback;
    }

    public final void z(int repeatCount) {
        this.modelAnimator.f(repeatCount);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.d.a
    public void onAnimationRepeat(int repeatCount) {
    }
}

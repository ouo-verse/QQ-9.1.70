package com.tencent.mobileqq.activity.about.modelviewer;

import android.content.Context;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.filament.Camera;
import com.google.android.filament.Engine;
import com.google.android.filament.EntityManager;
import com.google.android.filament.RenderableManager;
import com.google.android.filament.Renderer;
import com.google.android.filament.Scene;
import com.google.android.filament.SwapChain;
import com.google.android.filament.TransformManager;
import com.google.android.filament.View;
import com.google.android.filament.Viewport;
import com.google.android.filament.android.DisplayHelper;
import com.google.android.filament.android.UiHelper;
import com.google.android.filament.gltfio.Animator;
import com.google.android.filament.gltfio.AssetLoader;
import com.google.android.filament.gltfio.FilamentAsset;
import com.google.android.filament.gltfio.MaterialProvider;
import com.google.android.filament.gltfio.ResourceLoader;
import com.google.android.filament.gltfio.UbershaderProvider;
import com.google.android.filament.utils.Float3;
import com.google.android.filament.utils.Manipulator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.nio.Buffer;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u000e\u0018\u0000 \u007f2\u00020\u0001:\u0002\u0013\u0019B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\bz\u0010{B9\b\u0016\u0012\u0006\u0010|\u001a\u00020\u0012\u0012\u0006\u0010\\\u001a\u00020Z\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010T\u00a2\u0006\u0004\bz\u0010~J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R(\u0010.\u001a\u0004\u0018\u00010)2\b\u0010$\u001a\u0004\u0018\u00010)8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R$\u0010<\u001a\u0002072\u0006\u00108\u001a\u0002078\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0011\u00109\"\u0004\b:\u0010;R\u0017\u0010A\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010F\u001a\u00020B8\u0006\u00a2\u0006\f\n\u0004\b,\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010K\u001a\u00020G8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010P\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bM\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010w\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010tR\u0014\u0010y\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010t\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/ModelViewer;", "", "", "j", "Lcom/google/android/filament/gltfio/FilamentAsset;", "asset", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Ljava/nio/Buffer;", "buffer", "p", "Lcom/google/android/filament/utils/b;", "centerPoint", ReportConstant.COSTREPORT_PREFIX, "", "frameTimeNanos", "r", "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "Lcom/google/android/filament/Engine;", "b", "Lcom/google/android/filament/Engine;", "l", "()Lcom/google/android/filament/Engine;", EnginePathProvider.ENGINE_DIR, "Lcom/google/android/filament/android/UiHelper;", "c", "Lcom/google/android/filament/android/UiHelper;", "getUiHelper", "()Lcom/google/android/filament/android/UiHelper;", "uiHelper", "<set-?>", "d", "Lcom/google/android/filament/gltfio/FilamentAsset;", "getAsset", "()Lcom/google/android/filament/gltfio/FilamentAsset;", "Lcom/google/android/filament/gltfio/Animator;", "e", "Lcom/google/android/filament/gltfio/Animator;", "k", "()Lcom/google/android/filament/gltfio/Animator;", "animator", "", "f", "Z", "normalizeSkinningWeights", "g", "recomputeBoundingBoxes", tl.h.F, "ignoreBindTransform", "", "value", UserInfo.SEX_FEMALE, "setCameraFocalLength", "(F)V", "cameraFocalLength", "Lcom/google/android/filament/Scene;", "Lcom/google/android/filament/Scene;", DomainData.DOMAIN_NAME, "()Lcom/google/android/filament/Scene;", "scene", "Lcom/google/android/filament/View;", "Lcom/google/android/filament/View;", "o", "()Lcom/google/android/filament/View;", "view", "Lcom/google/android/filament/Camera;", "Lcom/google/android/filament/Camera;", "getCamera", "()Lcom/google/android/filament/Camera;", "camera", "Lcom/google/android/filament/Renderer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/google/android/filament/Renderer;", "()Lcom/google/android/filament/Renderer;", "renderer", "Lcom/google/android/filament/android/DisplayHelper;", "Lcom/google/android/filament/android/DisplayHelper;", "displayHelper", "Lcom/google/android/filament/utils/Manipulator;", "Lcom/google/android/filament/utils/Manipulator;", "cameraManipulator", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceView;", "surfaceView", "Landroid/view/TextureView;", "Landroid/view/TextureView;", "textureView", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "fetchResourcesJob", "Lcom/google/android/filament/SwapChain;", "Lcom/google/android/filament/SwapChain;", "swapChain", "Lcom/google/android/filament/gltfio/AssetLoader;", "t", "Lcom/google/android/filament/gltfio/AssetLoader;", "assetLoader", "Lcom/google/android/filament/gltfio/MaterialProvider;", "Lcom/google/android/filament/gltfio/MaterialProvider;", "materialProvider", "Lcom/google/android/filament/gltfio/ResourceLoader;", "v", "Lcom/google/android/filament/gltfio/ResourceLoader;", "resourceLoader", "", "w", "[I", "readyRenderables", "", HippyTKDListViewAdapter.X, "[D", "eyePos", "y", "target", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "upward", "<init>", "(Landroid/content/Context;Lcom/google/android/filament/Engine;Lcom/google/android/filament/android/UiHelper;)V", "context", "manipulator", "(Landroid/content/Context;Landroid/view/TextureView;Lcom/google/android/filament/Engine;Lcom/google/android/filament/android/UiHelper;Lcom/google/android/filament/utils/Manipulator;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class ModelViewer {
    static IPatchRedirector $redirector_;

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Float3 B;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Engine engine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UiHelper uiHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FilamentAsset asset;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator animator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean normalizeSkinningWeights;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean recomputeBoundingBoxes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean ignoreBindTransform;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float cameraFocalLength;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scene scene;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Camera camera;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Renderer renderer;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private DisplayHelper displayHelper;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Manipulator cameraManipulator;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SurfaceView surfaceView;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextureView textureView;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchResourcesJob;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SwapChain swapChain;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AssetLoader assetLoader;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MaterialProvider materialProvider;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ResourceLoader resourceLoader;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] readyRenderables;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] eyePos;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] target;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] upward;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/ModelViewer$a;", "", "", "APERTRUE", UserInfo.SEX_FEMALE, "Lcom/google/android/filament/utils/b;", "DEFAULT_OBJECT_POSITION", "Lcom/google/android/filament/utils/b;", "", "FAR_PLANE", "D", "NEAR_PLANE", "SENSITIVITY", "SHUTTER_SPEED", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.modelviewer.ModelViewer$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/ModelViewer$b;", "Lcom/google/android/filament/android/UiHelper$RendererCallback;", "Landroid/view/Surface;", "surface", "", "onNativeWindowChanged", "onDetachedFromSurface", "", "width", "height", "onResized", "<init>", "(Lcom/tencent/mobileqq/activity/about/modelviewer/ModelViewer;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public final class b implements UiHelper.RendererCallback {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModelViewer.this);
            }
        }

        @Override // com.google.android.filament.android.UiHelper.RendererCallback
        public void onDetachedFromSurface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                DisplayHelper displayHelper = ModelViewer.this.displayHelper;
                if (displayHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                    displayHelper = null;
                }
                displayHelper.c();
                SwapChain swapChain = ModelViewer.this.swapChain;
                if (swapChain != null) {
                    ModelViewer modelViewer = ModelViewer.this;
                    modelViewer.l().destroySwapChain(swapChain);
                    modelViewer.l().flushAndWait();
                    modelViewer.swapChain = null;
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.google.android.filament.android.UiHelper.RendererCallback
        public void onNativeWindowChanged(@NotNull Surface surface) {
            Display display;
            Display display2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) surface);
                return;
            }
            Intrinsics.checkNotNullParameter(surface, "surface");
            SwapChain swapChain = ModelViewer.this.swapChain;
            if (swapChain != null) {
                ModelViewer.this.l().destroySwapChain(swapChain);
            }
            ModelViewer modelViewer = ModelViewer.this;
            modelViewer.swapChain = modelViewer.l().createSwapChain(surface);
            DisplayHelper displayHelper = null;
            if (ModelViewer.this.surfaceView != null) {
                DisplayHelper displayHelper2 = ModelViewer.this.displayHelper;
                if (displayHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                    displayHelper2 = null;
                }
                Renderer m3 = ModelViewer.this.m();
                SurfaceView surfaceView = ModelViewer.this.surfaceView;
                Intrinsics.checkNotNull(surfaceView);
                displayHelper2.b(m3, surfaceView.getDisplay());
            }
            SurfaceView surfaceView2 = ModelViewer.this.surfaceView;
            if (surfaceView2 != null && (display2 = surfaceView2.getDisplay()) != null) {
                ModelViewer modelViewer2 = ModelViewer.this;
                DisplayHelper displayHelper3 = modelViewer2.displayHelper;
                if (displayHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                    displayHelper3 = null;
                }
                displayHelper3.b(modelViewer2.m(), display2);
            }
            TextureView textureView = ModelViewer.this.textureView;
            if (textureView != null && (display = textureView.getDisplay()) != null) {
                ModelViewer modelViewer3 = ModelViewer.this;
                DisplayHelper displayHelper4 = modelViewer3.displayHelper;
                if (displayHelper4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                } else {
                    displayHelper = displayHelper4;
                }
                displayHelper.b(modelViewer3.m(), display);
            }
        }

        @Override // com.google.android.filament.android.UiHelper.RendererCallback
        public void onResized(int width, int height) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(width), Integer.valueOf(height));
                return;
            }
            ModelViewer.this.o().setViewport(new Viewport(0, 0, width, height));
            Manipulator manipulator = ModelViewer.this.cameraManipulator;
            if (manipulator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraManipulator");
                manipulator = null;
            }
            manipulator.m(width, height);
            ModelViewer.this.u();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
            B = new Float3(0.0f, 0.0f, -4.0f);
        }
    }

    public ModelViewer(@NotNull Context mContext, @NotNull Engine engine, @NotNull UiHelper uiHelper) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, engine, uiHelper);
            return;
        }
        this.mContext = mContext;
        this.engine = engine;
        this.uiHelper = uiHelper;
        this.normalizeSkinningWeights = true;
        this.cameraFocalLength = 30.0f;
        Renderer createRenderer = engine.createRenderer();
        Intrinsics.checkNotNullExpressionValue(createRenderer, "engine.createRenderer()");
        this.renderer = createRenderer;
        this.readyRenderables = new int[128];
        this.eyePos = new double[3];
        this.target = new double[3];
        this.upward = new double[3];
        Renderer.a aVar = new Renderer.a();
        aVar.f32968b = true;
        createRenderer.setClearOptions(aVar);
        Scene createScene = engine.createScene();
        Intrinsics.checkNotNullExpressionValue(createScene, "engine.createScene()");
        this.scene = createScene;
        Camera createCamera = engine.createCamera(engine.getEntityManager().create());
        Intrinsics.checkNotNullExpressionValue(createCamera, "engine.createCamera(engine.entityManager.create())");
        createCamera.setExposure(16.0f, 0.008f, 100.0f);
        this.camera = createCamera;
        View createView = engine.createView();
        Intrinsics.checkNotNullExpressionValue(createView, "engine.createView()");
        this.view = createView;
        createView.setScene(createScene);
        createView.setCamera(createCamera);
        UbershaderProvider ubershaderProvider = new UbershaderProvider(engine);
        this.materialProvider = ubershaderProvider;
        Intrinsics.checkNotNull(ubershaderProvider);
        this.assetLoader = new AssetLoader(engine, ubershaderProvider, EntityManager.get());
        this.resourceLoader = new ResourceLoader(engine, this.normalizeSkinningWeights, this.recomputeBoundingBoxes, this.ignoreBindTransform);
    }

    private final void j() {
        Job a16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchResourcesJob;
        if (bVar != null && (a16 = bVar.a()) != null) {
            Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
        }
        this.resourceLoader.asyncCancelLoad();
        this.resourceLoader.evictResourceData();
        FilamentAsset filamentAsset = this.asset;
        if (filamentAsset != null) {
            this.scene.removeEntities(filamentAsset.getEntities());
            this.assetLoader.destroyAsset(filamentAsset);
            this.asset = null;
            this.animator = null;
        }
    }

    private final void q(final FilamentAsset asset) {
        List take;
        int[] intArray;
        RenderableManager renderableManager = this.engine.getRenderableManager();
        Intrinsics.checkNotNullExpressionValue(renderableManager, "engine.renderableManager");
        final Ref.IntRef intRef = new Ref.IntRef();
        Function0<Boolean> function0 = new Function0<Boolean>(asset, this) { // from class: com.tencent.mobileqq.activity.about.modelviewer.ModelViewer$populateScene$popRenderables$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ FilamentAsset $asset;
            final /* synthetic */ ModelViewer this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$asset = asset;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Ref.IntRef.this, asset, this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                int[] iArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                Ref.IntRef intRef2 = Ref.IntRef.this;
                FilamentAsset filamentAsset = this.$asset;
                iArr = this.this$0.readyRenderables;
                intRef2.element = filamentAsset.popRenderables(iArr);
                return Boolean.valueOf(Ref.IntRef.this.element != 0);
            }
        };
        while (function0.invoke().booleanValue()) {
            int i3 = intRef.element;
            for (int i16 = 0; i16 < i3; i16++) {
                renderableManager.setScreenSpaceContactShadows(renderableManager.getInstance(this.readyRenderables[i16]), true);
            }
            Scene scene = this.scene;
            take = ArraysKt___ArraysKt.take(this.readyRenderables, intRef.element);
            intArray = CollectionsKt___CollectionsKt.toIntArray(take);
            scene.addEntities(intArray);
        }
        this.scene.addEntities(asset.getLightEntities());
    }

    public static /* synthetic */ void t(ModelViewer modelViewer, Float3 float3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            float3 = B;
        }
        modelViewer.s(float3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.camera.setLensProjection(this.cameraFocalLength, this.view.getViewport().width / this.view.getViewport().height, 0.05d, 1000.0d);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        j();
        this.assetLoader.destroy();
        MaterialProvider materialProvider = this.materialProvider;
        if (materialProvider != null) {
            materialProvider.destroyMaterials();
        }
        MaterialProvider materialProvider2 = this.materialProvider;
        if (materialProvider2 != null) {
            materialProvider2.destroy();
        }
        this.resourceLoader.destroy();
        this.engine.destroyRenderer(this.renderer);
        this.engine.destroyView(this.view);
        this.engine.destroyScene(this.scene);
        this.engine.destroyCameraComponent(this.camera.getEntity());
        EntityManager.get().destroy(this.camera.getEntity());
        this.engine.destroy();
    }

    @Nullable
    public final Animator k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Animator) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.animator;
    }

    @NotNull
    public final Engine l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Engine) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.engine;
    }

    @NotNull
    public final Renderer m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Renderer) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.renderer;
    }

    @NotNull
    public final Scene n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Scene) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.scene;
    }

    @NotNull
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.view;
    }

    public final void p(@NotNull Buffer buffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) buffer);
            return;
        }
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        j();
        FilamentAsset createAssetFromBinary = this.assetLoader.createAssetFromBinary(buffer);
        this.asset = createAssetFromBinary;
        if (createAssetFromBinary != null) {
            this.resourceLoader.asyncBeginLoad(createAssetFromBinary);
            this.animator = createAssetFromBinary.getAnimator();
            this.scene.addEntities(createAssetFromBinary.getLightEntities());
            createAssetFromBinary.releaseSourceData();
        }
    }

    public final void r(long frameTimeNanos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, frameTimeNanos);
            return;
        }
        if (!this.uiHelper.isReadyToRender()) {
            return;
        }
        this.resourceLoader.asyncUpdateLoad();
        FilamentAsset filamentAsset = this.asset;
        if (filamentAsset != null) {
            q(filamentAsset);
        }
        Manipulator manipulator = this.cameraManipulator;
        if (manipulator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraManipulator");
            manipulator = null;
        }
        manipulator.g(this.eyePos, this.target, this.upward);
        Camera camera2 = this.camera;
        double[] dArr = this.eyePos;
        double d16 = dArr[0];
        double d17 = dArr[1];
        double d18 = dArr[2];
        double[] dArr2 = this.target;
        double d19 = dArr2[0];
        double d26 = dArr2[1];
        double d27 = dArr2[2];
        double[] dArr3 = this.upward;
        camera2.lookAt(d16, d17, d18, d19, d26, d27, dArr3[0], dArr3[1], dArr3[2]);
        Renderer renderer = this.renderer;
        SwapChain swapChain = this.swapChain;
        Intrinsics.checkNotNull(swapChain);
        if (renderer.beginFrame(swapChain, frameTimeNanos)) {
            this.renderer.render(this.view);
            this.renderer.endFrame();
        }
    }

    public final void s(@NotNull Float3 centerPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) centerPoint);
            return;
        }
        Intrinsics.checkNotNullParameter(centerPoint, "centerPoint");
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
            transformManager.setTransform(transformManager.getInstance(filamentAsset.getRoot()), com.google.android.filament.utils.e.c(com.google.android.filament.utils.e.a(new Float3(max)).e(com.google.android.filament.utils.e.b(new Float3(float3.getX() - float33.getX(), float3.getY() - float33.getY(), float3.getZ() - float33.getZ()).d()))).f());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelViewer(@NotNull Context context, @NotNull TextureView textureView, @NotNull Engine engine, @NotNull UiHelper uiHelper, @Nullable Manipulator manipulator) {
        this(context, engine, uiHelper);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, textureView, engine, uiHelper, manipulator);
            return;
        }
        if (manipulator == null) {
            Manipulator.a aVar = new Manipulator.a();
            Float3 float3 = B;
            manipulator = aVar.b(float3.getX(), float3.getY(), float3.getZ()).c(textureView.getWidth(), textureView.getHeight()).a(Manipulator.Mode.ORBIT);
            Intrinsics.checkNotNullExpressionValue(manipulator, "Builder()\n              \u2026d(Manipulator.Mode.ORBIT)");
        }
        this.cameraManipulator = manipulator;
        this.textureView = textureView;
        this.displayHelper = new DisplayHelper(textureView.getContext());
        uiHelper.setRenderCallback(new b());
    }
}

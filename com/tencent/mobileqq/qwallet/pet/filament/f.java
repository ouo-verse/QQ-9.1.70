package com.tencent.mobileqq.qwallet.pet.filament;

import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.filament.Camera;
import com.google.android.filament.Colors;
import com.google.android.filament.Engine;
import com.google.android.filament.Entity;
import com.google.android.filament.EntityManager;
import com.google.android.filament.IndirectLight;
import com.google.android.filament.LightManager;
import com.google.android.filament.Renderer;
import com.google.android.filament.Scene;
import com.google.android.filament.SwapChain;
import com.google.android.filament.View;
import com.google.android.filament.Viewport;
import com.google.android.filament.android.DisplayHelper;
import com.google.android.filament.android.UiHelper;
import com.google.android.filament.gltfio.MaterialProvider;
import com.google.android.filament.gltfio.UbershaderProvider;
import com.google.android.filament.utils.Bookmark;
import com.google.android.filament.utils.Float3;
import com.google.android.filament.utils.KTX1Loader;
import com.google.android.filament.utils.Manipulator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0003(.2B\u000f\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\b|\u0010}B'\b\u0016\u0012\u0006\u0010h\u001a\u00020f\u0012\b\b\u0002\u0010,\u001a\u00020'\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b|\u0010~J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0014J\u0010\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0006J\u0010\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001aJ\u0010\u0010#\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\"J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R*\u0010;\u001a\u00020\r2\u0006\u00105\u001a\u00020\r8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u001f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010A\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0003\u001a\u00020B8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010L\u001a\u00020G8\u0006\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010R\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010W\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010jR\u0016\u0010n\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010mR\u0014\u0010q\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010pR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010pR\u0014\u0010s\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010pR\u0017\u0010x\u001a\u00020t8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010u\u001a\u0004\bv\u0010wR\u0014\u0010{\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010z\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "", "Landroid/view/View;", "view", "Lcom/google/android/filament/utils/Manipulator;", "manipulator", "", "B", "", "viewWidth", "viewHeight", "Lcom/tencent/mobileqq/qwallet/pet/filament/f$c;", "o", "", "yRatio", DomainData.DOMAIN_NAME, "D", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "G", "", "petType", "actionType", "", "isLoop", "id", "Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "rootDir", "p", "u", UserInfo.SEX_FEMALE, "controller", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qwallet/pet/filament/CombineModelController;", "r", "", "frameTimeNanos", "E", "Lcom/google/android/filament/Engine;", "a", "Lcom/google/android/filament/Engine;", "v", "()Lcom/google/android/filament/Engine;", EnginePathProvider.ENGINE_DIR, "", "b", "Ljava/util/List;", "modelControllers", "Lcom/google/android/filament/android/UiHelper;", "c", "Lcom/google/android/filament/android/UiHelper;", "uiHelper", "value", "d", "getCameraFocalLength", "()F", "setCameraFocalLength", "(F)V", "cameraFocalLength", "Lcom/google/android/filament/Scene;", "e", "Lcom/google/android/filament/Scene;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/google/android/filament/Scene;", "scene", "Lcom/google/android/filament/View;", "f", "Lcom/google/android/filament/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/google/android/filament/View;", "Lcom/google/android/filament/Camera;", "g", "Lcom/google/android/filament/Camera;", "t", "()Lcom/google/android/filament/Camera;", "camera", "Lcom/google/android/filament/Renderer;", h.F, "Lcom/google/android/filament/Renderer;", "y", "()Lcom/google/android/filament/Renderer;", "renderer", "i", "I", "w", "()I", MiniAppConst.MENU_STYLE_LIGHT, "Lcom/google/android/filament/android/DisplayHelper;", "j", "Lcom/google/android/filament/android/DisplayHelper;", "displayHelper", "k", "Lcom/google/android/filament/utils/Manipulator;", "cameraManipulator", "Lcom/google/android/filament/utils/Bookmark;", "l", "Lcom/google/android/filament/utils/Bookmark;", "originBookMark", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceView;", "surfaceView", "Landroid/view/TextureView;", "Landroid/view/TextureView;", "textureView", "Lcom/google/android/filament/SwapChain;", "Lcom/google/android/filament/SwapChain;", "swapChain", "Lcom/google/android/filament/gltfio/MaterialProvider;", "Lcom/google/android/filament/gltfio/MaterialProvider;", "materialProvider", "", "[D", "eyePos", "target", "upward", "", "[I", HippyTKDListViewAdapter.X, "()[I", "modelArea", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroy", "<init>", "(Lcom/google/android/filament/Engine;)V", "(Landroid/view/TextureView;Lcom/google/android/filament/Engine;Lcom/google/android/filament/utils/Manipulator;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private static final Float3 f278889w = new Float3(-1.4f, -0.4f, -7.3f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Engine engine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<ModelController> modelControllers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UiHelper uiHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float cameraFocalLength;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scene scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Camera camera;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Renderer renderer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Entity
    private final int light;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private DisplayHelper displayHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Manipulator cameraManipulator;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Bookmark originBookMark;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SurfaceView surfaceView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextureView textureView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SwapChain swapChain;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MaterialProvider materialProvider;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] eyePos;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] target;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] upward;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] modelArea;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/f$a;", "", "Lcom/google/android/filament/utils/b;", "kDefaultObjectPosition", "Lcom/google/android/filament/utils/b;", "a", "()Lcom/google/android/filament/utils/b;", "", "TAG", "Ljava/lang/String;", "", "kAperture", UserInfo.SEX_FEMALE, "", "kFarPlane", "D", "kNearPlane", "kSensitivity", "kShutterSpeed", "viewPortTargetYRatio", "viewPortWidthHeightRatio", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.filament.f$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Float3 a() {
            return f.f278889w;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/f$b;", "Lcom/google/android/filament/android/UiHelper$RendererCallback;", "Landroid/view/Surface;", "surface", "", "onNativeWindowChanged", "onDetachedFromSurface", "", "width", "height", "onResized", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/filament/f;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b implements UiHelper.RendererCallback {
        public b() {
        }

        @Override // com.google.android.filament.android.UiHelper.RendererCallback
        public void onDetachedFromSurface() {
            QLog.i("QWallet.Pet.SceneViewer", 1, "onDetachedFromSurface");
            DisplayHelper displayHelper = f.this.displayHelper;
            if (displayHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                displayHelper = null;
            }
            displayHelper.c();
            SwapChain swapChain = f.this.swapChain;
            if (swapChain != null) {
                f fVar = f.this;
                fVar.getEngine().destroySwapChain(swapChain);
                fVar.getEngine().flushAndWait();
                fVar.swapChain = null;
            }
        }

        @Override // com.google.android.filament.android.UiHelper.RendererCallback
        public void onNativeWindowChanged(@NotNull Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            QLog.i("QWallet.Pet.SceneViewer", 1, "onNativeWindowChanged");
            SwapChain swapChain = f.this.swapChain;
            if (swapChain != null) {
                f.this.getEngine().destroySwapChain(swapChain);
            }
            f fVar = f.this;
            fVar.swapChain = fVar.getEngine().createSwapChain(surface);
            SurfaceView surfaceView = f.this.surfaceView;
            DisplayHelper displayHelper = null;
            if (surfaceView != null) {
                f fVar2 = f.this;
                DisplayHelper displayHelper2 = fVar2.displayHelper;
                if (displayHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                    displayHelper2 = null;
                }
                displayHelper2.b(fVar2.getRenderer(), surfaceView.getDisplay());
            }
            TextureView textureView = f.this.textureView;
            if (textureView != null) {
                f fVar3 = f.this;
                DisplayHelper displayHelper3 = fVar3.displayHelper;
                if (displayHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("displayHelper");
                } else {
                    displayHelper = displayHelper3;
                }
                displayHelper.b(fVar3.getRenderer(), textureView.getDisplay());
            }
        }

        @Override // com.google.android.filament.android.UiHelper.RendererCallback
        public void onResized(int width, int height) {
            ViewPortInfo o16 = f.this.o(width, height);
            f.this.getView().setViewport(new Viewport(0, -o16.getBottom(), o16.getWidth(), o16.getHeight()));
            Manipulator manipulator = f.this.cameraManipulator;
            if (manipulator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraManipulator");
                manipulator = null;
            }
            manipulator.m(o16.getWidth(), o16.getHeight());
            f.this.G();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/f$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "width", "b", "height", "bottom", "<init>", "(III)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.filament.f$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ViewPortInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bottom;

        public ViewPortInfo(int i3, int i16, int i17) {
            this.width = i3;
            this.height = i16;
            this.bottom = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        /* renamed from: b, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: c, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewPortInfo)) {
                return false;
            }
            ViewPortInfo viewPortInfo = (ViewPortInfo) other;
            if (this.width == viewPortInfo.width && this.height == viewPortInfo.height && this.bottom == viewPortInfo.bottom) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.width * 31) + this.height) * 31) + this.bottom;
        }

        @NotNull
        public String toString() {
            return "ViewPortInfo(width=" + this.width + ", height=" + this.height + ", bottom=" + this.bottom + ")";
        }
    }

    public f(@NotNull Engine engine) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.engine = engine;
        this.modelControllers = new ArrayList();
        UiHelper uiHelper = new UiHelper(UiHelper.ContextErrorPolicy.DONT_CHECK);
        this.uiHelper = uiHelper;
        this.cameraFocalLength = 28.0f;
        this.eyePos = new double[3];
        this.target = new double[3];
        this.upward = new double[3];
        this.modelArea = new int[4];
        this.isDestroy = new AtomicBoolean(false);
        uiHelper.setOpaque(false);
        Renderer createRenderer = engine.createRenderer();
        Intrinsics.checkNotNullExpressionValue(createRenderer, "engine.createRenderer()");
        this.renderer = createRenderer;
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
        this.materialProvider = new UbershaderProvider(engine);
        int create = EntityManager.get().create();
        this.light = create;
        float[] cct = Colors.cct(6500.0f);
        Intrinsics.checkNotNullExpressionValue(cct, "cct(6_500.0f)");
        new LightManager.Builder(LightManager.Type.DIRECTIONAL).color(cct[0], cct[1], cct[2]).intensity(100000.0f).direction(0.0f, -0.8f, 0.5f).castShadows(true).build(engine, create);
        createScene.addEntity(create);
    }

    private final void B(android.view.View view, Manipulator manipulator) {
        ViewPortInfo o16 = o(view.getWidth(), view.getHeight());
        if (manipulator == null) {
            Manipulator.a aVar = new Manipulator.a();
            Float3 float3 = f278889w;
            manipulator = aVar.b(float3.getX(), float3.getY(), float3.getZ()).c(o16.getWidth(), o16.getHeight()).a(Manipulator.Mode.ORBIT);
            Intrinsics.checkNotNullExpressionValue(manipulator, "Builder()\n              \u2026d(Manipulator.Mode.ORBIT)");
        }
        this.cameraManipulator = manipulator;
        if (manipulator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraManipulator");
            manipulator = null;
        }
        Bookmark f16 = manipulator.f();
        Intrinsics.checkNotNullExpressionValue(f16, "cameraManipulator.currentBookmark");
        this.originBookMark = f16;
        this.displayHelper = new DisplayHelper(view.getContext());
        this.uiHelper.setOpaque(false);
        this.uiHelper.setRenderCallback(new b());
        if (view instanceof TextureView) {
            this.uiHelper.attachTo((TextureView) view);
        } else if (view instanceof SurfaceView) {
            this.uiHelper.attachTo((SurfaceView) view);
        }
        m(view);
        D();
        C();
    }

    private final void C() {
        i f16 = x.f(jl2.b.f410584a.a());
        this.modelArea[0] = f16.b() / 5;
        this.modelArea[1] = (f16.a() * 2) / 5;
        this.modelArea[2] = (f16.b() * 3) / 5;
        this.modelArea[3] = f16.a() / 4;
        String arrays = Arrays.toString(this.modelArea);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d("QWallet.Pet.SceneViewer", 1, "initModelArea: " + arrays);
    }

    private final void D() {
        Renderer.a clearOptions = this.renderer.getClearOptions();
        Intrinsics.checkNotNullExpressionValue(clearOptions, "renderer.clearOptions");
        clearOptions.f32968b = true;
        clearOptions.f32969c = true;
        this.renderer.setClearOptions(clearOptions);
        this.view.setBlendMode(View.BlendMode.TRANSLUCENT);
        View view = this.view;
        View.RenderQuality renderQuality = view.getRenderQuality();
        renderQuality.hdrColorBuffer = View.QualityLevel.MEDIUM;
        view.setRenderQuality(renderQuality);
        View view2 = this.view;
        View.c multiSampleAntiAliasingOptions = view2.getMultiSampleAntiAliasingOptions();
        multiSampleAntiAliasingOptions.f33024a = true;
        view2.setMultiSampleAntiAliasingOptions(multiSampleAntiAliasingOptions);
        this.view.setAntiAliasing(View.AntiAliasing.FXAA);
        View view3 = this.view;
        View.AmbientOcclusionOptions ambientOcclusionOptions = view3.getAmbientOcclusionOptions();
        ambientOcclusionOptions.enabled = true;
        view3.setAmbientOcclusionOptions(ambientOcclusionOptions);
        View view4 = this.view;
        View.BloomOptions bloomOptions = view4.getBloomOptions();
        bloomOptions.f32992i = true;
        view4.setBloomOptions(bloomOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        this.camera.setLensProjection(this.cameraFocalLength, this.view.getViewport().width / this.view.getViewport().height, 0.05d, 1000.0d);
    }

    private final void m(android.view.View view) {
        view.addOnAttachStateChangeListener(new d());
    }

    private final int n(int viewHeight, float yRatio) {
        return ((int) ((viewHeight / 2) - (viewHeight * yRatio))) * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewPortInfo o(int viewWidth, int viewHeight) {
        if (viewHeight == 0) {
            return new ViewPortInfo(viewWidth, viewHeight, 0);
        }
        float f16 = viewWidth;
        float f17 = viewHeight;
        float f18 = 0.47297296f;
        if (0.46216217f < f16 / f17) {
            float f19 = f16 / 0.46216217f;
            f18 = ((f19 * 0.47297296f) - ((f19 - f17) / 2)) / f17;
        }
        int n3 = n(viewHeight, f18);
        ViewPortInfo viewPortInfo = new ViewPortInfo(viewWidth, viewHeight + n3, n3);
        QLog.i("QWallet.Pet.SceneViewer", 1, "calculateViewPort: (" + viewWidth + ", " + viewHeight + ")->" + viewPortInfo);
        return viewPortInfo;
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final View getView() {
        return this.view;
    }

    public final void E(long frameTimeNanos) {
        if (!this.uiHelper.isReadyToRender()) {
            return;
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

    public final void F() {
        Manipulator manipulator = this.cameraManipulator;
        Bookmark bookmark = null;
        if (manipulator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraManipulator");
            manipulator = null;
        }
        Bookmark bookmark2 = this.originBookMark;
        if (bookmark2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originBookMark");
        } else {
            bookmark = bookmark2;
        }
        manipulator.k(bookmark);
    }

    public final void p(@Nullable String rootDir) {
        if (rootDir == null) {
            return;
        }
        ByteBuffer a16 = jl2.a.f410583a.a(rootDir + "/filament_default_resource/default_env/default_env_ibl.ktx");
        if (a16 != null) {
            this.scene.setIndirectLight(KTX1Loader.b(KTX1Loader.f33068a, this.engine, a16, null, 4, null));
            IndirectLight indirectLight = this.scene.getIndirectLight();
            Intrinsics.checkNotNull(indirectLight);
            indirectLight.setIntensity(35000.0f);
        }
    }

    @NotNull
    public final ModelController q(@NotNull String petType, @NotNull String actionType, boolean isLoop, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(id5, "id");
        ModelController modelController = new ModelController(petType, actionType, id5, this.engine, this.scene, this.materialProvider);
        this.modelControllers.add(modelController);
        int i3 = 1;
        QLog.d("QWallet.Pet.SceneViewer", 1, "createModel " + id5 + ", size=" + this.modelControllers.size());
        if (isLoop) {
            i3 = -1;
        }
        modelController.z(i3);
        return modelController;
    }

    public final void r(@Nullable CombineModelController controller) {
        if (controller == null) {
            return;
        }
        this.modelControllers.removeAll(controller.f());
        controller.j();
    }

    public final void s(@Nullable ModelController controller) {
        TypeIntrinsics.asMutableCollection(this.modelControllers).remove(controller);
        if (controller != null) {
            controller.k();
        }
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final Camera getCamera() {
        return this.camera;
    }

    @NotNull
    public final Manipulator u() {
        Manipulator manipulator = this.cameraManipulator;
        if (manipulator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraManipulator");
            return null;
        }
        return manipulator;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final Engine getEngine() {
        return this.engine;
    }

    /* renamed from: w, reason: from getter */
    public final int getLight() {
        return this.light;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final int[] getModelArea() {
        return this.modelArea;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final Renderer getRenderer() {
        return this.renderer;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final Scene getScene() {
        return this.scene;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qwallet/pet/filament/f$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable android.view.View v3) {
            if (f.this.isDestroy.getAndSet(true)) {
                return;
            }
            QLog.i("QWallet.Pet.SceneViewer", 2, "onViewDetachedFromWindow");
            f.this.uiHelper.detach();
            Iterator it = f.this.modelControllers.iterator();
            while (it.hasNext()) {
                ((ModelController) it.next()).k();
            }
            f.this.modelControllers.clear();
            f.this.getEngine().destroyEntity(f.this.getLight());
            f.this.getEngine().destroyRenderer(f.this.getRenderer());
            f.this.getEngine().destroyView(f.this.getView());
            f.this.getEngine().destroyScene(f.this.getScene());
            f.this.getEngine().destroyCameraComponent(f.this.getCamera().getEntity());
            EntityManager.get().destroy(f.this.getCamera().getEntity());
            EntityManager.get().destroy(f.this.getLight());
            f.this.getEngine().destroy();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable android.view.View v3) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ f(TextureView textureView, Engine engine, Manipulator manipulator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(textureView, engine, (i3 & 4) != 0 ? null : manipulator);
        if ((i3 & 2) != 0) {
            engine = Engine.create();
            Intrinsics.checkNotNullExpressionValue(engine, "create()");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NotNull TextureView textureView, @NotNull Engine engine, @Nullable Manipulator manipulator) {
        this(engine);
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.textureView = textureView;
        B(textureView, manipulator);
    }
}

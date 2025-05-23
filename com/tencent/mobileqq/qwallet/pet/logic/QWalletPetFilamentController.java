package com.tencent.mobileqq.qwallet.pet.logic;

import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.qwallet.pet.data.FilamentDefaultResource;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager;
import com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.LoadingUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0002:;B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u00060!R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R(\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "i", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "k", "sceneViewer", "j", h.F, "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "l", DomainData.DOMAIN_NAME, "o", "Landroid/view/MotionEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "d", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "fragment", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "e", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "h5Controller", "Landroid/view/Choreographer;", "f", "Landroid/view/Choreographer;", "choreographer", "Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController$b;", "Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController$b;", "frameScheduler", "Lcom/tencent/mobileqq/qwallet/pet/logic/c;", "Lcom/tencent/mobileqq/qwallet/pet/logic/c;", "playerController", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "loadingContainer", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "g", "()Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "Lcom/tencent/mobileqq/qwallet/pet/logic/PetGestureController;", "D", "Lcom/tencent/mobileqq/qwallet/pet/logic/PetGestureController;", "petGestureController", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStarted", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;)V", UserInfo.SEX_FEMALE, "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPetFilamentController implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private PetGestureController petGestureController;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean hasStarted;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletPetFragment fragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletPetH5Controller h5Controller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Choreographer choreographer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b frameScheduler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c playerController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup loadingContainer;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController$b;", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "", "doFrame", "d", "J", "lastFrameTime", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b implements Choreographer.FrameCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long lastFrameTime = System.nanoTime();

        public b() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            Choreographer choreographer = QWalletPetFilamentController.this.choreographer;
            if (choreographer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("choreographer");
                choreographer = null;
            }
            choreographer.postFrameCallback(this);
            if (!QWalletPetFilamentController.this.hasStarted.get()) {
                return;
            }
            long j3 = frameTimeNanos - this.lastFrameTime;
            this.lastFrameTime = frameTimeNanos;
            c cVar = QWalletPetFilamentController.this.playerController;
            if (cVar != null) {
                cVar.i(j3);
            }
            com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer = QWalletPetFilamentController.this.getSceneViewer();
            if (sceneViewer != null) {
                sceneViewer.E(frameTimeNanos);
            }
        }
    }

    public QWalletPetFilamentController(@NotNull QWalletPetFragment fragment, @NotNull QWalletPetH5Controller h5Controller) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(h5Controller, "h5Controller");
        this.fragment = fragment;
        this.h5Controller = h5Controller;
        this.frameScheduler = new b();
        this.hasStarted = new AtomicBoolean(false);
        fragment.getLifecycle().addObserver(this);
        LiveData<Boolean> x16 = PetStateManager.f278740a.x();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.logic.QWalletPetFilamentController.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isShowLoading) {
                ViewGroup viewGroup = QWalletPetFilamentController.this.loadingContainer;
                if (viewGroup == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(isShowLoading, "isShowLoading");
                viewGroup.setVisibility(isShowLoading.booleanValue() ? 0 : 8);
            }
        };
        x16.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.qwallet.pet.logic.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletPetFilamentController.b(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void h(com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer) {
        this.petGestureController = new PetGestureController(this.fragment, sceneViewer, this.playerController, this.h5Controller);
    }

    private final void i(View rootView) {
        int i3;
        int dip2px = ViewUtils.dip2px(24.0f);
        View loadingView = LoadingUtil.getLoadingView(rootView.getContext(), dip2px, dip2px, 1);
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.f242908q);
        viewGroup.addView(loadingView);
        if (Intrinsics.areEqual(PetStateManager.f278740a.x().getValue(), Boolean.TRUE)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        this.loadingContainer = viewGroup;
    }

    private final void j(com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer) {
        c cVar = new c(sceneViewer);
        cVar.m();
        this.playerController = cVar;
    }

    private final com.tencent.mobileqq.qwallet.pet.filament.f k(View rootView) {
        String str;
        boolean z16;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.f242808p);
        TextureView textureView = new TextureView(rootView.getContext());
        if (frameLayout != null) {
            frameLayout.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
        }
        com.tencent.mobileqq.qwallet.pet.filament.f fVar = new com.tencent.mobileqq.qwallet.pet.filament.f(textureView, null, null, 6, null);
        PetDownloadManager petDownloadManager = PetDownloadManager.f278805a;
        FilamentDefaultResource d16 = com.tencent.mobileqq.qwallet.pet.data.f.f278777a.d();
        if (d16 != null) {
            str = d16.getDefaultResource();
        } else {
            str = null;
        }
        String p16 = petDownloadManager.p(str);
        if (p16 != null && p16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            fVar.p(p16);
        }
        this.sceneViewer = fVar;
        return fVar;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final com.tencent.mobileqq.qwallet.pet.filament.f getSceneViewer() {
        return this.sceneViewer;
    }

    public final void l(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        i(rootView);
    }

    public final void m(@NotNull MotionEvent event) {
        PetGestureController petGestureController;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.hasStarted.get() && PetStateManager.f278740a.s() && (petGestureController = this.petGestureController) != null) {
            petGestureController.g(event);
        }
    }

    public final void n(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        QLog.i("QWallet.Pet.FilamentController", 1, "startRender, hasStarted=" + this.hasStarted);
        if (!this.hasStarted.compareAndSet(false, true)) {
            return;
        }
        com.tencent.mobileqq.qwallet.pet.filament.f k3 = k(rootView);
        j(k3);
        h(k3);
    }

    public final void o() {
        c cVar;
        QLog.i("QWallet.Pet.FilamentController", 1, "stopRender, hasStarted=" + this.hasStarted);
        if (this.hasStarted.compareAndSet(true, false) && (cVar = this.playerController) != null) {
            cVar.k();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        QLog.i("QWallet.Pet.FilamentController", 1, "onCreate");
        Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance()");
        this.choreographer = choreographer;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        QLog.i("QWallet.Pet.FilamentController", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Choreographer choreographer = this.choreographer;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
            choreographer = null;
        }
        choreographer.removeFrameCallback(this.frameScheduler);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        QLog.i("QWallet.Pet.FilamentController", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        Choreographer choreographer = this.choreographer;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
            choreographer = null;
        }
        choreographer.removeFrameCallback(this.frameScheduler);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("QWallet.Pet.FilamentController", 1, "onResume");
        Choreographer choreographer = this.choreographer;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
            choreographer = null;
        }
        choreographer.postFrameCallback(this.frameScheduler);
    }
}

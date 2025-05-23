package com.tencent.mobileqq.activity.about.modelviewer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Choreographer;
import android.view.TextureView;
import android.view.View;
import com.google.android.filament.Engine;
import com.google.android.filament.View;
import com.google.android.filament.android.UiHelper;
import com.google.android.filament.gltfio.Animator;
import com.google.android.filament.utils.Float3;
import com.google.android.filament.utils.Manipulator;
import com.tencent.mobileqq.activity.about.modelviewer.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001 \u0018\u0000 \t2\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\u001c\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/b;", "", "", "e", "Landroid/view/TextureView;", "textureView", "k", "Ljava/nio/ByteBuffer;", "glbBuffer", "f", "Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;", "callback", "j", "i", tl.h.F, "g", "Landroid/view/Choreographer;", "a", "Landroid/view/Choreographer;", "choreographer", "Lcom/tencent/mobileqq/activity/about/modelviewer/ModelViewer;", "b", "Lcom/tencent/mobileqq/activity/about/modelviewer/ModelViewer;", "modelViewer", "Lcom/tencent/mobileqq/activity/about/modelviewer/o;", "c", "Lcom/tencent/mobileqq/activity/about/modelviewer/o;", "gestureDetector", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "com/tencent/mobileqq/activity/about/modelviewer/b$b", "Lcom/tencent/mobileqq/activity/about/modelviewer/b$b;", "frameCallback", "context", "<init>", "(Landroid/content/Context;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Float3 f177722g;

    /* renamed from: h, reason: collision with root package name */
    private static final long f177723h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Choreographer choreographer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ModelViewer modelViewer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private o gestureDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChoreographerFrameCallbackC7118b frameCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/b$a;", "", "Lcom/google/android/filament/utils/b;", "DEFAULT_OBJECT_POSITION", "Lcom/google/android/filament/utils/b;", "", "FRAME_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.modelviewer.b$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/b$b", "Landroid/view/Choreographer$FrameCallback;", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "doFrame", "d", "J", "startTime", "e", "lastFrameTime", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.modelviewer.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class ChoreographerFrameCallbackC7118b implements Choreographer.FrameCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long startTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long lastFrameTime;

        ChoreographerFrameCallbackC7118b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            } else {
                this.startTime = System.nanoTime();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long currentTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Choreographer choreographer = b.this.choreographer;
                ModelViewer modelViewer = null;
                if (choreographer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("choreographer");
                    choreographer = null;
                }
                choreographer.postFrameCallback(this);
                if (this.lastFrameTime == 0) {
                    this.lastFrameTime = currentTime;
                }
                if (currentTime - this.lastFrameTime >= b.f177723h) {
                    this.lastFrameTime = currentTime;
                    double d16 = (currentTime - this.startTime) / 1000000000;
                    ModelViewer modelViewer2 = b.this.modelViewer;
                    if (modelViewer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("modelViewer");
                        modelViewer2 = null;
                    }
                    Animator k3 = modelViewer2.k();
                    if (k3 != null) {
                        if (k3.getAnimationCount() > 0) {
                            k3.applyAnimation(0, (float) d16);
                        }
                        k3.updateBoneMatrices();
                    }
                    ModelViewer modelViewer3 = b.this.modelViewer;
                    if (modelViewer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("modelViewer");
                    } else {
                        modelViewer = modelViewer3;
                    }
                    modelViewer.r(currentTime);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, currentTime);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/b$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class c implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ UiHelper f177732d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f177733e;

        c(UiHelper uiHelper, b bVar) {
            this.f177732d = uiHelper;
            this.f177733e = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiHelper, (Object) bVar);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            boolean z16 = view instanceof TextureView;
            UiHelper uiHelper = this.f177732d;
            b bVar = this.f177733e;
            if (z16) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.TextureView");
                uiHelper.attachTo((TextureView) view);
                Choreographer choreographer = bVar.choreographer;
                if (choreographer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("choreographer");
                    choreographer = null;
                }
                choreographer.postFrameCallback(bVar.frameCallback);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            boolean z16 = view instanceof TextureView;
            UiHelper uiHelper = this.f177732d;
            b bVar = this.f177733e;
            if (z16) {
                uiHelper.detach();
                Choreographer choreographer = bVar.choreographer;
                if (choreographer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("choreographer");
                    choreographer = null;
                }
                choreographer.removeFrameCallback(bVar.frameCallback);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26618);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        com.google.android.filament.utils.f.f33090a.a();
        f177722g = new Float3(0.0f, 0.0f, -4.0f);
        f177723h = 16666666L;
    }

    public b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.frameCallback = new ChoreographerFrameCallbackC7118b();
            this.mContext = context;
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance()");
        this.choreographer = choreographer;
    }

    public final void f(@NotNull ByteBuffer glbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) glbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(glbBuffer, "glbBuffer");
        ModelViewer modelViewer = this.modelViewer;
        if (modelViewer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelViewer");
            modelViewer = null;
        }
        modelViewer.p(glbBuffer);
        ModelViewer.t(modelViewer, null, 1, null);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d("CustomViewer", 1, "onResume destory filament");
        Choreographer choreographer = this.choreographer;
        ModelViewer modelViewer = null;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
            choreographer = null;
        }
        choreographer.removeFrameCallback(this.frameCallback);
        ModelViewer modelViewer2 = this.modelViewer;
        if (modelViewer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelViewer");
        } else {
            modelViewer = modelViewer2;
        }
        modelViewer.i();
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("CustomViewer", 1, "onResume end filament");
        Choreographer choreographer = this.choreographer;
        o oVar = null;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
            choreographer = null;
        }
        choreographer.removeFrameCallback(this.frameCallback);
        o oVar2 = this.gestureDetector;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        } else {
            oVar = oVar2;
        }
        oVar.q();
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("CustomViewer", 1, "onResume start filament");
        Choreographer choreographer = this.choreographer;
        o oVar = null;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
            choreographer = null;
        }
        choreographer.postFrameCallback(this.frameCallback);
        o oVar2 = this.gestureDetector;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        } else {
            oVar = oVar2;
        }
        oVar.V();
    }

    public final void j(@NotNull o.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        o oVar = this.gestureDetector;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            oVar = null;
        }
        oVar.L(callback);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void k(@NotNull TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textureView);
            return;
        }
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        UiHelper uiHelper = new UiHelper(UiHelper.ContextErrorPolicy.DONT_CHECK);
        uiHelper.setOpaque(false);
        Manipulator.a aVar = new Manipulator.a();
        Float3 float3 = f177722g;
        Manipulator a16 = aVar.b(float3.getX(), float3.getY(), float3.getZ()).c(textureView.getWidth(), textureView.getHeight()).a(Manipulator.Mode.ORBIT);
        Intrinsics.checkNotNullExpressionValue(a16, "Builder()\n            .t\u2026d(Manipulator.Mode.ORBIT)");
        Context context = this.mContext;
        Engine create = Engine.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.modelViewer = new ModelViewer(context, textureView, create, uiHelper, a16);
        uiHelper.attachTo(textureView);
        ModelViewer modelViewer = this.modelViewer;
        if (modelViewer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelViewer");
            modelViewer = null;
        }
        modelViewer.o().setBlendMode(View.BlendMode.TRANSLUCENT);
        ModelViewer modelViewer2 = this.modelViewer;
        if (modelViewer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelViewer");
            modelViewer2 = null;
        }
        modelViewer2.n().setSkybox(null);
        this.gestureDetector = new o(textureView, a16);
        textureView.addOnAttachStateChangeListener(new c(uiHelper, this));
    }
}

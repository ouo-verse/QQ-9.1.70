package com.tencent.nativepreview.render;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.TDFHostDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014R\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R.\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/nativepreview/render/TdfAndroidView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/tdf/TDFHostDelegate$HostCallback;", "Lcom/tencent/tdf/TDFEngine;", "createEngine", "Landroid/app/Activity;", "getActivity", "", "visibility", "", "onWindowVisibilityChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Lcom/tencent/tdf/TDFEngine;", "getEngine", "()Lcom/tencent/tdf/TDFEngine;", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/tdf/TDFHostDelegate;", "e", "Lcom/tencent/tdf/TDFHostDelegate;", "hostDelegate", "Landroid/view/View;", "f", "Landroid/view/View;", "tdfView", "value", h.F, "Landroid/app/Activity;", "getAttachActivity", "()Landroid/app/Activity;", "setAttachActivity", "(Landroid/app/Activity;)V", "attachActivity", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/tdf/TDFEngine;Landroid/content/Context;)V", "i", "a", "native_preview_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public final class TdfAndroidView extends FrameLayout implements TDFHostDelegate.HostCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TDFEngine engine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TDFHostDelegate hostDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View tdfView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity attachActivity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/nativepreview/render/TdfAndroidView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.nativepreview.render.TdfAndroidView$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15220);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TdfAndroidView(@NotNull TDFEngine engine, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) engine, (Object) context);
        } else {
            this.engine = engine;
        }
    }

    @Override // com.tencent.tdf.TDFHostDelegate.HostCallback
    @NotNull
    public TDFEngine createEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TDFEngine) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.engine;
    }

    @Override // com.tencent.tdf.TDFHostDelegate.HostCallback
    @NotNull
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Activity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Activity activity = this.attachActivity;
        Intrinsics.checkNotNull(activity);
        return activity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        Log.d("TdfAndroidView", NodeProps.ON_ATTACHED_TO_WINDOW);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        TDFHostDelegate tDFHostDelegate = this.hostDelegate;
        TDFHostDelegate tDFHostDelegate2 = null;
        if (tDFHostDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostDelegate");
            tDFHostDelegate = null;
        }
        View contentView = tDFHostDelegate.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "hostDelegate.contentView");
        this.tdfView = contentView;
        if (contentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tdfView");
            contentView = null;
        }
        addView(contentView, layoutParams);
        TDFHostDelegate tDFHostDelegate3 = this.hostDelegate;
        if (tDFHostDelegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostDelegate");
        } else {
            tDFHostDelegate2 = tDFHostDelegate3;
        }
        tDFHostDelegate2.onResume();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Log.d("TdfAndroidView", NodeProps.ON_DETACHED_FROM_WINDOW);
        View view = this.tdfView;
        TDFHostDelegate tDFHostDelegate = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tdfView");
            view = null;
        }
        removeView(view);
        TDFHostDelegate tDFHostDelegate2 = this.hostDelegate;
        if (tDFHostDelegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostDelegate");
        } else {
            tDFHostDelegate = tDFHostDelegate2;
        }
        tDFHostDelegate.onStop();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, visibility);
            return;
        }
        super.onWindowVisibilityChanged(visibility);
        Log.d("TdfAndroidView", Intrinsics.stringPlus("onWindowVisibilityChanged visibility: ", Integer.valueOf(visibility)));
        TDFHostDelegate tDFHostDelegate = null;
        if (visibility == 0) {
            TDFHostDelegate tDFHostDelegate2 = this.hostDelegate;
            if (tDFHostDelegate2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostDelegate");
            } else {
                tDFHostDelegate = tDFHostDelegate2;
            }
            tDFHostDelegate.onResume();
            return;
        }
        TDFHostDelegate tDFHostDelegate3 = this.hostDelegate;
        if (tDFHostDelegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostDelegate");
        } else {
            tDFHostDelegate = tDFHostDelegate3;
        }
        tDFHostDelegate.onPause();
    }

    public final void setAttachActivity(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        this.attachActivity = activity;
        TDFHostDelegate tDFHostDelegate = new TDFHostDelegate(this);
        tDFHostDelegate.onCreate(activity, null);
        Unit unit = Unit.INSTANCE;
        this.hostDelegate = tDFHostDelegate;
    }
}

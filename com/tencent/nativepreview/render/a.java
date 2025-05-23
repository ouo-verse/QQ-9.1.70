package com.tencent.nativepreview.render;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.Log;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.TDFEngineConfig;
import com.tencent.tdf.tdf_flutter.p016native.TdfNativeBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002\t\u0010B#\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/nativepreview/render/a;", "Lcom/tencent/tdf/TDFEngine;", "", "engineHandle", "", "onShellStarted", DKHippyEvent.EVENT_STOP, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "b", "Z", "_disposed", "c", "Ljava/lang/Long;", "shell", "d", "viewContext", "e", "Lcom/tencent/nativepreview/render/a$b;", "f", "Lcom/tencent/nativepreview/render/a$b;", "onShellCreated", "Lcom/tencent/tdf/TDFEngineConfig;", "configuration", "<init>", "(Landroid/content/Context;Lcom/tencent/tdf/TDFEngineConfig;Lcom/tencent/nativepreview/render/a$b;)V", "g", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class a extends TDFEngine {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean _disposed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long shell;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long viewContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long engineHandle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b onShellCreated;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/nativepreview/render/a$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/nativepreview/render/a$b;", "onShellCreated", "Lcom/tencent/nativepreview/render/a;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.nativepreview.render.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final a a(@NotNull Context context, @Nullable b onShellCreated) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) onShellCreated);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            TDFEngineConfig tDFEngineConfig = new TDFEngineConfig();
            tDFEngineConfig.setViewMode(TDFEngineConfig.TDFViewMode.TextureView);
            return new a(new MutableContextWrapper(context), tDFEngineConfig, onShellCreated);
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/nativepreview/render/a$b;", "", "", "shell", "viewContext", "", "a", "(Ljava/lang/Long;Ljava/lang/Long;)V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@Nullable Long shell, @Nullable Long viewContext);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @Nullable TDFEngineConfig tDFEngineConfig, @Nullable b bVar) {
        super(context, tDFEngineConfig);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, tDFEngineConfig, bVar);
        } else {
            this.context = context;
            this.onShellCreated = bVar;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this._disposed) {
            return;
        }
        this._disposed = true;
        Log.d("TdfFlutterEngine", "destroy engine");
        Long l3 = this.engineHandle;
        if (l3 == null) {
            return;
        }
        TdfNativeBinding.INSTANCE.destroyEngine(l3.longValue());
        onDestroy();
    }

    @Override // com.tencent.tdf.TDFEngine
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this._disposed) {
                return;
            }
            super.onPause();
        }
    }

    @Override // com.tencent.tdf.TDFEngine
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (this._disposed) {
                return;
            }
            super.onResume();
        }
    }

    @Override // com.tencent.tdf.TDFEngine, com.tencent.tdf.TDFEngineEvent
    public void onShellStarted(long engineHandle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, engineHandle);
            return;
        }
        Log.d("TdfFlutterEngine", Intrinsics.stringPlus("onShellStarted ", Long.valueOf(engineHandle)));
        TdfNativeBinding tdfNativeBinding = TdfNativeBinding.INSTANCE;
        long shell = tdfNativeBinding.getShell(engineHandle);
        long initViewContext = tdfNativeBinding.initViewContext(engineHandle);
        this.viewContext = Long.valueOf(initViewContext);
        this.shell = Long.valueOf(shell);
        this.engineHandle = Long.valueOf(engineHandle);
        b bVar = this.onShellCreated;
        if (bVar != null) {
            bVar.a(Long.valueOf(shell), Long.valueOf(initViewContext));
        }
    }

    @Override // com.tencent.tdf.TDFEngine
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this._disposed) {
                return;
            }
            super.onStop();
        }
    }
}

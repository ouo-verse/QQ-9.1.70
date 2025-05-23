package com.tencent.mobileqq.qqnt.videoplay.player.sdk;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.IVideoPlaySoLoaderInit;
import com.tencent.mobileqq.qqnt.videoplay.api.so.a;
import com.tencent.mobileqq.qqnt.videoplay.player.sdk.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperModuleLoader;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.config.RequestRootGroup;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/b;", "", "", h.F, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/d;", "listener", "g", "", "i", "e", "b", "Z", "inited", "com/tencent/mobileqq/qqnt/videoplay/player/sdk/b$b", "c", "Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/b$b;", "mNativeLogger", "Lcom/tencent/superplayer/api/ISuperModuleLoader;", "d", "Lcom/tencent/superplayer/api/ISuperModuleLoader;", "mNativeLibLoader", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final b f274236a;

    /* renamed from: b, reason: from kotlin metadata */
    private static volatile boolean inited;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static C8420b mNativeLogger;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static final ISuperModuleLoader mNativeLibLoader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqnt/videoplay/player/sdk/b$a", "Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/c$a;", "", "isSuccess", "", "onLoad", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ Context f274240a;

        /* renamed from: b */
        final /* synthetic */ d f274241b;

        a(Context context, d dVar) {
            this.f274240a = context;
            this.f274241b = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.player.sdk.c.a
        public void onLoad(boolean isSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSuccess);
                return;
            }
            if (isSuccess) {
                SuperPlayerSDKMgr.setOnLogListener(b.mNativeLogger);
                SuperPlayerSDKMgr.setLibLoader(b.mNativeLibLoader);
                File externalCacheDir = this.f274240a.getExternalCacheDir();
                Intrinsics.checkNotNull(externalCacheDir);
                String str = externalCacheDir.getAbsolutePath() + File.separator + "superPlayer";
                SuperPlayerSdkOption option = SuperPlayerSdkOption.option();
                option.deviceModel = DeviceInfoMonitor.getModel();
                SuperPlayerSDKMgr.initSDK(this.f274240a, RequestRootGroup.APP_ID_MOBILE_QQ, str, option);
                b.inited = true;
            }
            QLog.d("VideoPlay_InitSdk", 1, "load so local, result:" + isSuccess);
            d dVar = this.f274241b;
            if (dVar != null) {
                dVar.onSDKInited(isSuccess);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqnt/videoplay/player/sdk/b$b", "Lcom/tencent/superplayer/api/SuperPlayerSDKMgr$ILogListener;", "", "tag", "content", "", "v", "d", "i", "w", "e", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.player.sdk.b$b */
    /* loaded from: classes17.dex */
    public static final class C8420b implements SuperPlayerSDKMgr.ILogListener {
        static IPatchRedirector $redirector_;

        C8420b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int d(@Nullable String tag, @Nullable String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) content)).intValue();
            }
            QLog.d(tag, 4, content);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int e(@Nullable String tag, @Nullable String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) content)).intValue();
            }
            QLog.e(tag, 1, content);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int i(@Nullable String tag, @Nullable String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) content)).intValue();
            }
            QLog.i(tag, 2, content);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int v(@Nullable String tag, @Nullable String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) content)).intValue();
            }
            QLog.d(tag, 4, content);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int w(@Nullable String tag, @Nullable String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) content)).intValue();
            }
            QLog.w(tag, 2, content);
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f274236a = new b();
        mNativeLogger = new C8420b();
        mNativeLibLoader = new ISuperModuleLoader() { // from class: com.tencent.mobileqq.qqnt.videoplay.player.sdk.a
            @Override // com.tencent.superplayer.api.ISuperModuleLoader
            public final void loadLibrary(String str, String str2) {
                b.j(str, str2);
            }
        };
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void f(b bVar, Context context, d dVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dVar = null;
        }
        bVar.e(context, dVar);
    }

    private final void g(Context context, d listener) {
        QLog.d("VideoPlay_InitSdk", 1, "load so local, start");
        c.f274242a.a(new a(context, listener));
    }

    private final void h() {
        try {
            ((IVideoPlaySoLoaderInit) QRoute.api(IVideoPlaySoLoaderInit.class)).initLoader();
        } catch (Throwable th5) {
            QLog.w("VideoPlay_InitSdk", 1, "[initVideoSoLoader] exception=" + th5);
        }
    }

    public static final void j(String str, String str2) {
        boolean z16 = true;
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("VideoPlay_InitSdk", 1, e16, new Object[0]);
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_InitSdk", 2, "load so, name:" + str + ", suc:" + z16);
        }
    }

    public final synchronized void e(@NotNull Context context, @Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (inited) {
            return;
        }
        h();
        a.InterfaceC8418a a16 = com.tencent.mobileqq.qqnt.videoplay.api.so.a.f274211a.a();
        Unit unit = null;
        if (a16 != null) {
            QLog.d("VideoPlay_InitSdk", 1, "load so outside, start");
            boolean a17 = a16.a();
            if (a17) {
                inited = true;
            }
            QLog.d("VideoPlay_InitSdk", 1, "load so outside, result:" + a17);
            if (listener != null) {
                listener.onSDKInited(a17);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            g(context, listener);
        }
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return inited;
    }
}

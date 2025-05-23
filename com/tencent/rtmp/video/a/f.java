package com.tencent.rtmp.video.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.audio2.SystemLoopbackRecorder2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.ScreenCaptureService;
import com.tencent.rtmp.video.TXScreenCapture;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.VirtualDisplayWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f368832a;

    /* renamed from: b, reason: collision with root package name */
    final Handler f368833b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.rtmp.video.a.a f368834c;

    /* renamed from: d, reason: collision with root package name */
    final Map<Surface, a> f368835d;

    /* renamed from: e, reason: collision with root package name */
    MediaProjection f368836e;

    /* renamed from: f, reason: collision with root package name */
    boolean f368837f;

    /* renamed from: g, reason: collision with root package name */
    final Runnable f368838g;

    /* renamed from: h, reason: collision with root package name */
    final Runnable f368839h;

    /* renamed from: i, reason: collision with root package name */
    final MediaProjection.Callback f368840i;

    /* compiled from: P */
    /* renamed from: com.tencent.rtmp.video.a.f$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    final class AnonymousClass1 extends MediaProjection.Callback {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(f fVar) {
            HashMap hashMap = new HashMap(fVar.f368835d);
            fVar.f368835d.clear();
            for (a aVar : hashMap.values()) {
                VirtualDisplayListener virtualDisplayListener = aVar.f368845d;
                if (virtualDisplayListener != null) {
                    if (aVar.f368846e != null) {
                        virtualDisplayListener.onCaptureError();
                    } else {
                        virtualDisplayListener.onStartFinish(false, false);
                    }
                }
            }
            fVar.c();
        }

        @Override // android.media.projection.MediaProjection.Callback
        public final void onStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            BaseBridge.printLog("VirtualDisplayManager", "MediaProjection session is no longer valid");
            f fVar = f.this;
            fVar.f368834c.a(l.a(fVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Surface f368842a;

        /* renamed from: b, reason: collision with root package name */
        public int f368843b;

        /* renamed from: c, reason: collision with root package name */
        public int f368844c;

        /* renamed from: d, reason: collision with root package name */
        public VirtualDisplayListener f368845d;

        /* renamed from: e, reason: collision with root package name */
        public VirtualDisplayWrapper f368846e;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f368832a = null;
        this.f368835d = new HashMap();
        this.f368837f = false;
        this.f368838g = g.a(this);
        this.f368839h = h.a(this);
        this.f368840i = new AnonymousClass1();
        this.f368833b = new Handler(Looper.getMainLooper());
        this.f368834c = new com.tencent.rtmp.video.a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        Context appContext = BaseBridge.getAppContext();
        if (appContext == null) {
            BaseBridge.printLog("VirtualDisplayManager", "context is null!");
            return;
        }
        Intent intent = new Intent(appContext, (Class<?>) TXScreenCapture.TXScreenCaptureAssistantActivity.class);
        intent.addFlags(268435456);
        appContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        BaseBridge.printLog("VirtualDisplayManager", "stopScreenCaptureService");
        try {
            Context appContext = BaseBridge.getAppContext();
            if (appContext == null) {
                BaseBridge.printLog("VirtualDisplayManager", "context is null!");
            } else {
                appContext.stopService(new Intent(appContext, (Class<?>) ScreenCaptureService.class));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        for (a aVar : this.f368835d.values()) {
            if (aVar.f368846e == null) {
                try {
                    aVar.f368846e = new VirtualDisplayWrapper(this.f368836e.createVirtualDisplay("TXCScreenCapture", aVar.f368843b, aVar.f368844c, 1, 1, aVar.f368842a, null, null));
                    BaseBridge.printLog("VirtualDisplayManager", "create VirtualDisplay " + aVar.f368846e);
                    VirtualDisplayListener virtualDisplayListener = aVar.f368845d;
                    if (virtualDisplayListener != null) {
                        virtualDisplayListener.onVirtualDisplayCreate(aVar.f368846e);
                        aVar.f368845d.onStartFinish(true, false);
                    }
                } catch (Throwable th5) {
                    BaseBridge.printLog("VirtualDisplayManager", "create VirtualDisplay error ".concat(String.valueOf(th5)));
                    VirtualDisplayListener virtualDisplayListener2 = aVar.f368845d;
                    if (virtualDisplayListener2 != null) {
                        virtualDisplayListener2.onStartFinish(false, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (!this.f368835d.isEmpty()) {
            return;
        }
        BaseBridge.printLog("VirtualDisplayManager", "Stop media projection session " + this.f368836e);
        if (this.f368836e != null) {
            b(null);
            try {
                this.f368836e.unregisterCallback(this.f368840i);
                this.f368836e.stop();
            } catch (Throwable th5) {
                BaseBridge.printLog("VirtualDisplayManager", "stop media projection session with exception ".concat(String.valueOf(th5)));
            }
            this.f368836e = null;
        }
        d();
    }

    public final void a(MediaProjection mediaProjection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f368834c.a(k.a(this, mediaProjection));
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaProjection);
        }
    }

    public final synchronized void a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            BaseBridge.printLog("VirtualDisplayManager", "Register request permission activity:".concat(String.valueOf(activity)));
            this.f368832a = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(MediaProjection mediaProjection) {
        try {
            int i3 = SystemLoopbackRecorder2.f118846a;
            SystemLoopbackRecorder2.class.getMethod("notifyMediaProjectionState", MediaProjection.class).invoke(null, mediaProjection);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            BaseBridge.printLog("VirtualDisplayManager", "fail to send media projection session " + e16.getMessage());
        }
    }
}

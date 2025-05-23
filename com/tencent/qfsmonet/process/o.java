package com.tencent.qfsmonet.process;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qcircle.player.QFSPlayerNativeSDR;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.IMonetTextureIdInterceptor;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.data.MonetGLTexturePacket;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.api.outputstream.OnNewPacketAvailableListener;
import com.tencent.qfsmonet.gles.MonetShaderDescriptor;
import com.tencent.qfsmonet.process.core.MonetProcessData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import com.tencent.qfsmonet.utils.MonetHandler;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class o implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name */
    private static int f342593q;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f342594a;

    /* renamed from: b, reason: collision with root package name */
    private MonetHandler f342595b;

    /* renamed from: c, reason: collision with root package name */
    private MonetContext f342596c;

    /* renamed from: d, reason: collision with root package name */
    private HandlerThread f342597d;

    /* renamed from: e, reason: collision with root package name */
    private MonetHandler f342598e;

    /* renamed from: f, reason: collision with root package name */
    private OnNewPacketAvailableListener f342599f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.qfsmonet.gles.c f342600g;

    /* renamed from: h, reason: collision with root package name */
    private IMonetTextureIdInterceptor f342601h;

    /* renamed from: i, reason: collision with root package name */
    private int f342602i;

    /* renamed from: j, reason: collision with root package name */
    private int f342603j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.qfsmonet.gles.b f342604k;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f342605l;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f342606m;

    /* renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f342607n;

    /* renamed from: o, reason: collision with root package name */
    private FutureTask<Boolean> f342608o;

    /* renamed from: p, reason: collision with root package name */
    private QFSPlayerNativeSDR f342609p;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342594a = null;
        this.f342595b = null;
        this.f342596c = null;
        this.f342597d = null;
        this.f342598e = null;
        this.f342605l = new AtomicBoolean(false);
        this.f342606m = new AtomicBoolean(false);
        this.f342607n = new AtomicBoolean(false);
        com.tencent.qfsmonet.utils.a.c(s(), "MonetProcessCore!");
        u();
        w();
    }

    private void D(MonetProcessData monetProcessData) {
        QFSPlayerNativeSDR qFSPlayerNativeSDR;
        OnNewPacketAvailableListener onNewPacketAvailableListener = this.f342599f;
        IMonetTextureIdInterceptor iMonetTextureIdInterceptor = this.f342601h;
        if (monetProcessData != null && (monetProcessData.getPacketData() instanceof MonetGLTexturePacket) && onNewPacketAvailableListener != null) {
            MonetGLTexturePacket monetGLTexturePacket = (MonetGLTexturePacket) monetProcessData.getPacketData();
            int textureId = monetGLTexturePacket.textureId();
            int width = monetGLTexturePacket.width();
            int height = monetGLTexturePacket.height();
            if (this.f342606m.get()) {
                onNewPacketAvailableListener.onNewPacketAvailable(monetGLTexturePacket);
                com.tencent.qfsmonet.utils.a.a(s(), "onNewPacketAvailable out process has any frame failed");
                return;
            }
            if (!this.f342605l.get()) {
                if (x()) {
                    this.f342603j = textureId;
                }
                onNewPacketAvailableListener.onNewPacketAvailable(monetGLTexturePacket);
                m(width, height);
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f342607n.get() || (qFSPlayerNativeSDR = this.f342609p) == null) {
                    return;
                }
                int i3 = width * 2;
                int i16 = height * 2;
                try {
                    boolean execute = qFSPlayerNativeSDR.execute(textureId, width, height, this.f342602i, i3, i16);
                    iMonetTextureIdInterceptor.onTextureIdAvailable(textureId, this.f342602i, width, height);
                    E(System.currentTimeMillis() - currentTimeMillis);
                    if (execute) {
                        onNewPacketAvailableListener.onNewPacketAvailable(new MonetGLTexturePacket(this.f342602i, new MonetPacketDescriptor(i3, i16, 6407)));
                    } else {
                        this.f342606m.set(true);
                        com.tencent.qfsmonet.utils.a.a(s(), "onNewPacketAvailable out process failed");
                        monetGLTexturePacket = monetGLTexturePacket;
                        onNewPacketAvailableListener.onNewPacketAvailable(monetGLTexturePacket);
                    }
                } catch (Exception e16) {
                    e = e16;
                    monetGLTexturePacket = monetGLTexturePacket;
                    com.tencent.qfsmonet.utils.a.a(s(), "onNewPacketAvailable exception:" + e);
                    onNewPacketAvailableListener.onNewPacketAvailable(monetGLTexturePacket);
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void C(@NonNull ArrayList<MonetProcessData> arrayList) {
        if (this.f342599f == null) {
            com.tencent.qfsmonet.utils.a.c(s(), "processInner not output, no process!");
        } else if (this.f342601h != null) {
            D(arrayList.get(0));
        }
    }

    private void m(final int i3, final int i16) {
        if (this.f342608o != null) {
            return;
        }
        FutureTask<Boolean> futureTask = new FutureTask<>(new Callable() { // from class: com.tencent.qfsmonet.process.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean y16;
                y16 = o.this.y(i3, i16);
                return y16;
            }
        });
        this.f342608o = futureTask;
        this.f342598e.post(futureTask);
    }

    private void n(int i3, int i16) {
        if (this.f342607n.get()) {
            com.tencent.qfsmonet.utils.a.b(s(), "createInterceptorOutputGlId return destroy");
            return;
        }
        if (this.f342602i <= 0) {
            if (x()) {
                this.f342602i = com.tencent.qfsmonet.gles.h.f(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D, i3, i16);
            } else {
                this.f342602i = com.tencent.qfsmonet.gles.h.e(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D, i3 * 2, i16 * 2);
            }
        }
        if (this.f342603j <= 0) {
            this.f342603j = com.tencent.qfsmonet.gles.h.e(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void z() {
        com.tencent.qfsmonet.utils.a.c(s(), "destroyInner start!");
        FutureTask<Boolean> futureTask = this.f342608o;
        if (futureTask != null) {
            try {
                futureTask.get();
            } catch (Exception unused) {
                com.tencent.qfsmonet.utils.a.b(s(), "destroyInner exception!");
            }
        }
        p();
        QFSPlayerNativeSDR qFSPlayerNativeSDR = this.f342609p;
        if (qFSPlayerNativeSDR != null) {
            qFSPlayerNativeSDR.release();
            this.f342609p = null;
        }
        int i3 = this.f342603j;
        if (i3 > 0) {
            com.tencent.qfsmonet.gles.h.a(i3);
            this.f342603j = -1;
        }
        int i16 = this.f342602i;
        if (i16 > 0) {
            com.tencent.qfsmonet.gles.h.a(i16);
            this.f342602i = -1;
        }
        com.tencent.qfsmonet.gles.b bVar = this.f342604k;
        if (bVar != null) {
            com.tencent.qfsmonet.gles.d.i(bVar);
            this.f342604k = null;
        }
        com.tencent.qfsmonet.gles.c cVar = this.f342600g;
        if (cVar != null) {
            cVar.b();
            this.f342600g = null;
        }
        com.tencent.qfsmonet.utils.a.c(s(), "destroyInner end!");
    }

    private void p() {
        MonetHandler monetHandler = this.f342598e;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.h(s(), "destroy failed, not init!");
            return;
        }
        monetHandler.removeCallbacksAndMessages(null);
        this.f342598e = null;
        HandlerThread handlerThread = this.f342597d;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f342597d = null;
        }
        com.tencent.qfsmonet.utils.a.h(s(), "destroyPreloadHandler success");
    }

    private void q() {
        MonetHandler monetHandler = this.f342595b;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.h(s(), "destroy failed, not init!");
            return;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.l
            @Override // java.lang.Runnable
            public final void run() {
                o.this.z();
            }
        });
        this.f342595b.removeCallbacksAndMessages(null);
        this.f342595b = null;
        HandlerThread handlerThread = this.f342594a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f342594a = null;
        }
    }

    private boolean r() {
        try {
            String model = DeviceInfoMonitor.getModel();
            com.tencent.qfsmonet.utils.a.b(s(), "enableModel:" + model);
            IMonetTextureIdInterceptor iMonetTextureIdInterceptor = this.f342601h;
            String str = "V2;V1;Lenovo;ASUS_I003DD;SHARK;ANY-AN00;DT2002C;";
            if (iMonetTextureIdInterceptor != null && !TextUtils.isEmpty(iMonetTextureIdInterceptor.getBlackName())) {
                str = "V2;V1;Lenovo;ASUS_I003DD;SHARK;ANY-AN00;DT2002C;" + this.f342601h.getBlackName();
            }
            String[] split = str.split(";");
            if (split == null) {
                return false;
            }
            for (String str2 : split) {
                if (model.equals(str2) || model.contains(str2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b(s(), e16.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void A(@Nullable EGLContext eGLContext) {
        com.tencent.qfsmonet.gles.c cVar = new com.tencent.qfsmonet.gles.c();
        this.f342600g = cVar;
        com.tencent.qfsmonet.gles.b a16 = cVar.a(eGLContext);
        if (a16 != null) {
            this.f342596c = new com.tencent.qfsmonet.gles.e(this.f342594a.getLooper(), a16);
            com.tencent.qfsmonet.utils.a.c(s(), "initContextInner success !");
        }
    }

    private void u() {
        com.tencent.qfsmonet.utils.a.c(s(), "initHandler!");
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Monet-Thread_" + this);
            this.f342594a = baseHandlerThread;
            baseHandlerThread.start();
            if (this.f342594a.getLooper() != null) {
                this.f342595b = new MonetHandler(this.f342594a.getLooper());
                com.tencent.qfsmonet.utils.a.c(s(), "create handler success !");
            } else {
                this.f342594a.quitSafely();
                this.f342594a = null;
                com.tencent.qfsmonet.utils.a.b(s(), "create handler failed!");
            }
        } catch (Throwable th5) {
            com.tencent.qfsmonet.utils.a.b(s(), "create handler exception! ex= " + th5.toString());
            HandlerThread handlerThread = this.f342594a;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.f342594a = null;
            }
            this.f342595b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void B() {
        com.tencent.qfsmonet.gles.b f16 = com.tencent.qfsmonet.gles.d.f(this.f342596c.context().b());
        this.f342604k = f16;
        if (f16 != null) {
            com.tencent.qfsmonet.utils.a.c(s(), "init preload ContextInner success !");
        }
    }

    private void w() {
        com.tencent.qfsmonet.utils.a.c(s(), "initPreloadHandler!");
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Monet-Thread-preload_" + this);
            this.f342597d = baseHandlerThread;
            baseHandlerThread.start();
            if (this.f342597d.getLooper() != null) {
                this.f342598e = new MonetHandler(this.f342597d.getLooper());
                com.tencent.qfsmonet.utils.a.c(s(), "create preload handler success !");
            } else {
                this.f342597d.quitSafely();
                this.f342597d = null;
                com.tencent.qfsmonet.utils.a.b(s(), "create preload handler failed!");
            }
        } catch (Throwable th5) {
            com.tencent.qfsmonet.utils.a.b(s(), "create preload handler exception! ex= " + th5.toString());
            HandlerThread handlerThread = this.f342597d;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.f342597d = null;
            }
            this.f342595b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean y(int i3, int i16) throws Exception {
        n(i3, i16);
        if (this.f342607n.get()) {
            com.tencent.qfsmonet.utils.a.b(s(), "doPreloadEmptyFrame return destroy");
            return Boolean.FALSE;
        }
        if (!r()) {
            com.tencent.qfsmonet.utils.a.b(s(), "not enable model return false");
            return Boolean.FALSE;
        }
        this.f342609p = new QFSPlayerNativeSDR();
        long currentTimeMillis = System.currentTimeMillis();
        boolean init = this.f342609p.init(QFSPlayerNativeSDR.SR_QUALITY_HIGH);
        com.tencent.qfsmonet.utils.a.b(s(), "init spr cost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (init && this.f342603j >= 0 && i3 > 0 && i16 > 0 && this.f342602i > 0) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f342605l.set(this.f342609p.execute(this.f342603j, i3, i16, this.f342602i, i3 * 2, i16 * 2));
            com.tencent.qfsmonet.utils.a.b(s(), "doPreloadEmptyFrame:" + this.f342605l.get() + "|width: " + i3 + "|height:" + i16 + "|timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
            return Boolean.TRUE;
        }
        com.tencent.qfsmonet.utils.a.b(s(), "doPreloadEmptyFrame return:initSuccess:" + init + " |mPreloadInPutGlId:" + this.f342603j + " |mInterceptorOutPutGlId:" + this.f342602i + " |width:" + i3 + " |height:" + i16);
        return Boolean.FALSE;
    }

    public void E(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
            return;
        }
        if (f342593q % 100 == 0) {
            com.tencent.qfsmonet.utils.a.a(s(), "process(frame) = " + j3 + "ms");
            f342593q = 0;
        }
        f342593q++;
    }

    @Override // com.tencent.qfsmonet.process.a
    public void a(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void b(@NonNull final ArrayList<MonetProcessData> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
            return;
        }
        MonetHandler monetHandler = this.f342595b;
        if (monetHandler != null && this.f342596c != null) {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.m
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.C(arrayList);
                }
            });
        } else {
            com.tencent.qfsmonet.utils.a.b(s(), "process failed, not init!");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void c(@Nullable MonetProcessParams monetProcessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) monetProcessParams);
        } else {
            if (this.f342595b != null && this.f342596c != null && monetProcessParams != null) {
                return;
            }
            com.tencent.qfsmonet.utils.a.b(s(), "setParams failed, not init or params is null!");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public boolean d(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f342595b != null && this.f342596c != null) {
            return true;
        }
        com.tencent.qfsmonet.utils.a.b(s(), "setProcessProtocol failed, not init!");
        return false;
    }

    @Override // com.tencent.qfsmonet.process.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f342607n.set(true);
        com.tencent.qfsmonet.utils.a.c(s(), "destroy start!");
        q();
        com.tencent.qfsmonet.utils.a.c(s(), "destroy end!");
    }

    @Override // com.tencent.qfsmonet.process.a
    public void e(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) runnable);
            return;
        }
        MonetHandler monetHandler = this.f342595b;
        if (monetHandler != null && this.f342596c != null && runnable != null) {
            com.tencent.qfsmonet.utils.c.a(monetHandler, runnable);
        } else {
            com.tencent.qfsmonet.utils.a.b(s(), "postSyncRunnableOnGPU failed, not init or runnable is null!");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void f(@Nullable OnNewPacketAvailableListener onNewPacketAvailableListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onNewPacketAvailableListener);
        } else {
            com.tencent.qfsmonet.utils.a.c(s(), "setProcessOutputListener!");
            this.f342599f = onNewPacketAvailableListener;
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public MonetContext g(@Nullable final EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonetContext) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eGLContext);
        }
        MonetHandler monetHandler = this.f342595b;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b(s(), "initContext failed, handler is null!");
            return null;
        }
        if (this.f342596c != null) {
            com.tencent.qfsmonet.utils.a.c(s(), "duplicate init.");
            return this.f342596c;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.j
            @Override // java.lang.Runnable
            public final void run() {
                o.this.A(eGLContext);
            }
        });
        if (this.f342596c != null) {
            com.tencent.qfsmonet.utils.c.a(this.f342598e, new Runnable() { // from class: com.tencent.qfsmonet.process.k
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.B();
                }
            });
        }
        com.tencent.qfsmonet.utils.a.c(s(), "initContext success.");
        return this.f342596c;
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        IMonetTextureIdInterceptor iMonetTextureIdInterceptor = this.f342601h;
        if (iMonetTextureIdInterceptor != null) {
            return iMonetTextureIdInterceptor.getTag();
        }
        return "MonetProcessCoreWithoutNativeWrapper";
    }

    @Override // com.tencent.qfsmonet.process.a
    public void setDestroyFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f342607n.set(true);
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void setTextureIdInterceptor(IMonetTextureIdInterceptor iMonetTextureIdInterceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iMonetTextureIdInterceptor);
        } else {
            this.f342601h = iMonetTextureIdInterceptor;
        }
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        String glGetString = GLES20.glGetString(7937);
        String str = Build.HARDWARE;
        if (!str.toLowerCase().contains("kirin") && !str.toLowerCase().contains("mt") && (TextUtils.isEmpty(glGetString) || !glGetString.toLowerCase().contains("mali"))) {
            return false;
        }
        return true;
    }
}

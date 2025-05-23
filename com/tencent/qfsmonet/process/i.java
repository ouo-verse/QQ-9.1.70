package com.tencent.qfsmonet.process;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.IMonetTextureIdInterceptor;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.outputstream.OnNewPacketAvailableListener;
import com.tencent.qfsmonet.process.core.MonetProcessData;
import com.tencent.qfsmonet.process.core.MonetProcessNativeWrapper;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import com.tencent.qfsmonet.utils.MonetHandler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes22.dex */
public class i implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static int f342576h;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f342577a;

    /* renamed from: b, reason: collision with root package name */
    private MonetHandler f342578b;

    /* renamed from: c, reason: collision with root package name */
    private MonetContext f342579c;

    /* renamed from: d, reason: collision with root package name */
    private MonetProcessNativeWrapper f342580d;

    /* renamed from: e, reason: collision with root package name */
    private OnNewPacketAvailableListener f342581e;

    /* renamed from: f, reason: collision with root package name */
    private String f342582f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.qfsmonet.gles.c f342583g;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342577a = null;
        this.f342578b = null;
        this.f342579c = null;
        this.f342582f = null;
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "MonetProcessCore!");
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void w(@NonNull String str) {
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "set protocol:" + str);
        MonetProcessNativeWrapper monetProcessNativeWrapper = this.f342580d;
        if (monetProcessNativeWrapper == null) {
            com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "processor init failed, can not update");
            return;
        }
        if (monetProcessNativeWrapper.updateProcessProtocol(str)) {
            this.f342582f = str;
            return;
        }
        if (!TextUtils.isEmpty(this.f342582f)) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "set protocol:" + this.f342582f);
            this.f342580d.updateProcessProtocol(this.f342582f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void r() {
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "destroyInner start!");
        MonetProcessNativeWrapper monetProcessNativeWrapper = this.f342580d;
        if (monetProcessNativeWrapper != null) {
            monetProcessNativeWrapper.deInitProcessor();
            this.f342580d = null;
        }
        com.tencent.qfsmonet.gles.c cVar = this.f342583g;
        if (cVar != null) {
            cVar.b();
        }
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "destroyInner end!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void s(@Nullable EGLContext eGLContext) {
        com.tencent.qfsmonet.gles.c cVar = new com.tencent.qfsmonet.gles.c();
        this.f342583g = cVar;
        com.tencent.qfsmonet.gles.b a16 = cVar.a(eGLContext);
        if (a16 != null) {
            this.f342579c = new com.tencent.qfsmonet.gles.e(this.f342577a.getLooper(), a16);
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "initContextInner success !");
        }
    }

    private void p() {
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "initHandler!");
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Monet-Thread_" + this);
            this.f342577a = baseHandlerThread;
            baseHandlerThread.start();
            if (this.f342577a.getLooper() != null) {
                this.f342578b = new MonetHandler(this.f342577a.getLooper());
                com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "create handler success !");
            } else {
                this.f342577a.quitSafely();
                this.f342577a = null;
                com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "create handler failed!");
            }
        } catch (Throwable th5) {
            com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "create handler exception! ex= " + th5.toString());
            HandlerThread handlerThread = this.f342577a;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.f342577a = null;
            }
            this.f342578b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void t(@Nullable String str) {
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "load module, protocol:" + str);
        if (this.f342580d != null) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "monet process has init");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "protocol is null");
            return;
        }
        MonetProcessNativeWrapper monetProcessNativeWrapper = new MonetProcessNativeWrapper();
        this.f342580d = monetProcessNativeWrapper;
        if (!monetProcessNativeWrapper.initProcessor(str)) {
            com.tencent.qfsmonet.utils.a.h("MonetProcessCore", "initProcessorWithProtocolInner, monet init fail");
            this.f342580d.deInitProcessor();
            this.f342580d = null;
            return;
        }
        this.f342582f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void u(@NonNull ArrayList<MonetProcessData> arrayList) {
        OnNewPacketAvailableListener onNewPacketAvailableListener = this.f342581e;
        if (onNewPacketAvailableListener == null) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "processInner not output, no process!");
            return;
        }
        if ((TextUtils.isEmpty(this.f342582f) || this.f342580d == null) && arrayList.size() == 1) {
            onNewPacketAvailableListener.onNewPacketAvailable(arrayList.get(0).getPacketData());
            return;
        }
        if (this.f342580d == null) {
            com.tencent.qfsmonet.utils.a.h("MonetProcessCore", "process failed!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MonetProcessData process = this.f342580d.process(arrayList);
        x(System.currentTimeMillis() - currentTimeMillis);
        if (process != null) {
            onNewPacketAvailableListener.onNewPacketAvailable(process.getPacketData());
        } else if (arrayList.size() == 1) {
            onNewPacketAvailableListener.onNewPacketAvailable(arrayList.get(0).getPacketData());
        } else {
            com.tencent.qfsmonet.utils.a.h("MonetProcessCore", "process failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void v(@NonNull MonetProcessParams monetProcessParams) {
        MonetProcessNativeWrapper monetProcessNativeWrapper = this.f342580d;
        if (monetProcessNativeWrapper != null) {
            monetProcessNativeWrapper.setParams(monetProcessParams);
        } else {
            com.tencent.qfsmonet.utils.a.h("MonetProcessCore", "setParamsInner fail, monet init fail");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void a(@Nullable final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.f342578b != null && this.f342579c != null) {
            if (TextUtils.isEmpty(str)) {
                this.f342582f = str;
                com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "setProcessProtocol null");
                return;
            } else {
                com.tencent.qfsmonet.utils.c.a(this.f342578b, new Runnable() { // from class: com.tencent.qfsmonet.process.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.this.w(str);
                    }
                });
                return;
            }
        }
        com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "setProcessProtocol failed, not init!");
    }

    @Override // com.tencent.qfsmonet.process.a
    public void b(@NonNull final ArrayList<MonetProcessData> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
            return;
        }
        MonetHandler monetHandler = this.f342578b;
        if (monetHandler != null && this.f342579c != null) {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.d
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.u(arrayList);
                }
            });
        } else {
            com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "process failed, not init!");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void c(@Nullable final MonetProcessParams monetProcessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) monetProcessParams);
            return;
        }
        MonetHandler monetHandler = this.f342578b;
        if (monetHandler != null && this.f342579c != null && monetProcessParams != null) {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.v(monetProcessParams);
                }
            });
        } else {
            com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "setParams failed, not init or params is null!");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public boolean d(@Nullable final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        MonetHandler monetHandler = this.f342578b;
        if (monetHandler != null && this.f342579c != null) {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.c
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.t(str);
                }
            });
            if (this.f342580d == null) {
                return false;
            }
            return true;
        }
        com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "setProcessProtocol failed, not init!");
        return false;
    }

    @Override // com.tencent.qfsmonet.process.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "destroy start!");
        MonetHandler monetHandler = this.f342578b;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.h("MonetProcessCore", "destroy failed, not init!");
            return;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.f
            @Override // java.lang.Runnable
            public final void run() {
                i.this.r();
            }
        });
        this.f342578b.removeCallbacksAndMessages(null);
        this.f342578b = null;
        HandlerThread handlerThread = this.f342577a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f342577a = null;
        }
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "destroy end!");
    }

    @Override // com.tencent.qfsmonet.process.a
    public void e(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) runnable);
            return;
        }
        MonetHandler monetHandler = this.f342578b;
        if (monetHandler != null && this.f342579c != null && runnable != null) {
            com.tencent.qfsmonet.utils.c.a(monetHandler, runnable);
        } else {
            com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "postSyncRunnableOnGPU failed, not init or runnable is null!");
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void f(@Nullable OnNewPacketAvailableListener onNewPacketAvailableListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onNewPacketAvailableListener);
        } else {
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "setProcessOutputListener!");
            this.f342581e = onNewPacketAvailableListener;
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public MonetContext g(@Nullable final EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonetContext) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eGLContext);
        }
        MonetHandler monetHandler = this.f342578b;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetProcessCore", "initContext failed, handler is null!");
            return null;
        }
        if (this.f342579c != null) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "duplicate init.");
            return this.f342579c;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.process.g
            @Override // java.lang.Runnable
            public final void run() {
                i.this.s(eGLContext);
            }
        });
        com.tencent.qfsmonet.utils.a.c("MonetProcessCore", "initContext success.");
        return this.f342579c;
    }

    @Override // com.tencent.qfsmonet.process.a
    public void setDestroyFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qfsmonet.process.a
    public void setTextureIdInterceptor(IMonetTextureIdInterceptor iMonetTextureIdInterceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iMonetTextureIdInterceptor);
        }
    }

    public void x(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
            return;
        }
        if (f342576h % 50 == 0) {
            com.tencent.qfsmonet.utils.a.a("MonetProcessCore", "process(frame) = " + j3 + "ms");
            f342576h = 0;
        }
        f342576h++;
    }
}

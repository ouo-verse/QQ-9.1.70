package com.tencent.qfsmonet.inputstream;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.data.MonetGLTexturePacket;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream;
import com.tencent.qfsmonet.api.inputstream.MonetSurfaceTexture;
import com.tencent.qfsmonet.gles.o;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.utils.MonetHandler;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class d implements IMonetSurfaceInputStream, com.tencent.qfsmonet.inputstream.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f342544a;

    /* renamed from: b, reason: collision with root package name */
    private int f342545b;

    /* renamed from: c, reason: collision with root package name */
    private int f342546c;

    /* renamed from: d, reason: collision with root package name */
    private o f342547d;

    /* renamed from: e, reason: collision with root package name */
    private MonetSurfaceTexture f342548e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.qfsmonet.inputstream.b f342549f;

    /* renamed from: g, reason: collision with root package name */
    private MonetOperatorData f342550g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f342551h;

    /* renamed from: i, reason: collision with root package name */
    private MonetGLTexturePacket f342552i;

    /* renamed from: j, reason: collision with root package name */
    private b f342553j;

    /* renamed from: k, reason: collision with root package name */
    private SurfaceTexture.OnFrameAvailableListener f342554k;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements SurfaceTexture.OnFrameAvailableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    d.this.k((MonetSurfaceTexture) surfaceTexture);
                    return;
                } catch (Exception e16) {
                    com.tencent.qfsmonet.utils.a.h("MonetSurfaceInputStream", "onFrameAvailable, processFrame fail, ex=" + e16.toString());
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends MonetHandler {
        static IPatchRedirector $redirector_;

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 1001:
                    if (!d.this.f342551h) {
                        com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "exit internal refresh loop");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    d dVar = d.this;
                    dVar.l(dVar.f342552i);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 < 10) {
                        sendEmptyMessageDelayed(1001, 10 - currentTimeMillis2);
                        return;
                    } else {
                        sendEmptyMessage(1001);
                        return;
                    }
                case 1002:
                    d.this.f342551h = false;
                    return;
                case 1003:
                    d.this.f342551h = true;
                    com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "start internal refresh loop");
                    sendEmptyMessage(1001);
                    return;
                default:
                    return;
            }
        }
    }

    public d(@NonNull MonetContext monetContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) monetContext);
            return;
        }
        this.f342550g = null;
        this.f342551h = false;
        this.f342552i = null;
        this.f342554k = new a();
        com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "MonetSurfaceInputStream, ptr=" + this);
        this.f342547d = new o(monetContext);
        this.f342553j = new b(monetContext.looper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f342551h = false;
    }

    @TargetApi(15)
    private void i(int i3, int i16) {
        if (this.f342545b != i3 || this.f342546c != i16) {
            com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "onVideoSizeChange,old w:h=" + this.f342545b + ":" + this.f342546c + "w:h=" + i3 + ":" + i16);
            this.f342548e.setDefaultBufferSize(i3, i16);
            this.f342545b = i3;
            this.f342546c = i16;
        }
    }

    private void j(long j3) {
        if (this.f342544a % 100 == 0) {
            com.tencent.qfsmonet.utils.a.a("MonetSurfaceInputStream", "process(frame) total time = " + j3 + "ms");
            this.f342544a = 0;
        }
        this.f342544a++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(@NonNull MonetSurfaceTexture monetSurfaceTexture) {
        if (monetSurfaceTexture instanceof MonetSurfaceTexture) {
            i(monetSurfaceTexture.width(), monetSurfaceTexture.height());
        }
        com.tencent.qfsmonet.inputstream.b bVar = this.f342549f;
        if (bVar != null) {
            bVar.a();
        }
        this.f342547d.x(monetSurfaceTexture);
        MonetGLTexturePacket k3 = this.f342547d.k();
        this.f342552i = k3;
        if (!this.f342551h) {
            l(k3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable MonetGLTexturePacket monetGLTexturePacket) {
        if (monetGLTexturePacket == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.qfsmonet.inputstream.b bVar = this.f342549f;
        if (bVar != null) {
            bVar.b(this.f342550g.getDataName(), monetGLTexturePacket);
        }
        j(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.tencent.qfsmonet.inputstream.a
    public void a(@NonNull MonetOperatorData monetOperatorData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) monetOperatorData);
        } else {
            this.f342550g = monetOperatorData;
            this.f342547d.z(new MonetPacketDescriptor(this.f342545b, this.f342546c, monetOperatorData.getDataFormat()));
        }
    }

    @Override // com.tencent.qfsmonet.inputstream.a
    public synchronized void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "destroy start, ptr=" + this);
        this.f342553j.b(new Runnable() { // from class: com.tencent.qfsmonet.inputstream.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.h();
            }
        });
        this.f342553j.removeCallbacksAndMessages(null);
        MonetSurfaceTexture monetSurfaceTexture = this.f342548e;
        if (monetSurfaceTexture != null) {
            monetSurfaceTexture.setOnFrameAvailableListener(null);
        }
        o oVar = this.f342547d;
        if (oVar != null) {
            oVar.m();
        }
        this.f342548e = null;
        this.f342549f = null;
        com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "destroy end, ptr=" + this);
    }

    @Override // com.tencent.qfsmonet.api.inputstream.IMonetInputStream
    public void enableInputRefreshLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (z16) {
            com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "enable internal refresh loop");
            this.f342553j.sendEmptyMessage(1003);
        } else {
            com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "disable internal refresh loop");
            this.f342553j.sendEmptyMessage(1002);
        }
    }

    @Override // com.tencent.qfsmonet.api.inputstream.IMonetInputStream
    public int getInputStreamType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream
    public synchronized MonetSurfaceTexture getRenderObject() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonetSurfaceTexture) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f342548e == null) {
            MonetSurfaceTexture o16 = this.f342547d.o();
            this.f342548e = o16;
            if (o16 != null) {
                o16.setOnFrameAvailableListener(this.f342554k);
            } else {
                com.tencent.qfsmonet.utils.a.b("MonetSurfaceInputStream", "getRenderObject, OESTexture create failed, ptr=" + this);
                throw new IllegalStateException("getRenderObject failed!");
            }
        }
        com.tencent.qfsmonet.utils.a.c("MonetSurfaceInputStream", "getRenderObject,ptr=" + this + "obj=" + this.f342548e);
        return this.f342548e;
    }

    public void m(@Nullable com.tencent.qfsmonet.inputstream.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.f342549f = bVar;
        }
    }
}

package com.tencent.qfsmonet.process;

import android.opengl.EGLContext;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.IMonetProcessor;
import com.tencent.qfsmonet.api.IMonetTextureIdInterceptor;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.data.MonetPacket;
import com.tencent.qfsmonet.api.inputstream.IMonetInputStream;
import com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.outputstream.IMonetOutputStream;
import com.tencent.qfsmonet.api.outputstream.OnNewPacketAvailableListener;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.MonetModuleRuntimeParams;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.process.core.MonetProcessData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class q implements IMonetProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MonetContext f342611a;

    /* renamed from: b, reason: collision with root package name */
    private IMonetModule f342612b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<IMonetInputStream> f342613c;

    /* renamed from: d, reason: collision with root package name */
    private IMonetOutputStream f342614d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.qfsmonet.process.a f342615e;

    /* renamed from: f, reason: collision with root package name */
    private IMonetTextureIdInterceptor f342616f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f342617g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.qfsmonet.inputstream.b f342618h;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements com.tencent.qfsmonet.inputstream.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // com.tencent.qfsmonet.inputstream.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (q.this.f342614d != null && (q.this.f342614d instanceof com.tencent.qfsmonet.outputstream.a)) {
                ((com.tencent.qfsmonet.outputstream.a) q.this.f342614d).a();
            }
        }

        @Override // com.tencent.qfsmonet.inputstream.b
        public void b(@NonNull String str, @NonNull MonetPacket monetPacket) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                q.this.g(str, monetPacket);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) monetPacket);
            }
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342611a = null;
        this.f342613c = new ArrayList<>();
        this.f342617g = true;
        this.f342618h = new a();
        com.tencent.qfsmonet.utils.a.c("MonetProcessor", "createMonetProcessor, ptr=" + this);
    }

    private boolean d(@NonNull ArrayList<IMonetInputStream> arrayList, @NonNull ArrayList<MonetOperatorData> arrayList2) {
        if (arrayList2.size() != arrayList.size()) {
            return false;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ((com.tencent.qfsmonet.inputstream.a) arrayList.get(i3)).a(arrayList2.get(i3));
        }
        return true;
    }

    private boolean e(@NonNull IMonetModule iMonetModule, @NonNull IMonetModule iMonetModule2) {
        if ((iMonetModule instanceof IMonetSingleInputModule) && (iMonetModule2 instanceof IMonetSingleInputModule)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull String str, @NonNull MonetPacket monetPacket) {
        if (this.f342615e == null) {
            return;
        }
        k((MonetModuleInner) this.f342612b);
        i((MonetModuleInner) this.f342612b);
        ArrayList<MonetProcessData> arrayList = new ArrayList<>();
        arrayList.add(new MonetProcessData(monetPacket, h(monetPacket), str));
        this.f342615e.b(arrayList);
    }

    @NonNull
    private List<MonetProcessParams> h(@NonNull MonetPacket monetPacket) {
        ArrayList arrayList = new ArrayList();
        if (this.f342612b == null) {
            return arrayList;
        }
        return ((MonetModuleInner) this.f342612b).parseParameters(monetPacket.getPacketParameter());
    }

    private void i(MonetModuleInner monetModuleInner) {
        ArrayList<MonetProcessParams> moduleProcessParams;
        if (monetModuleInner != null && (moduleProcessParams = monetModuleInner.getModuleProcessParams()) != null && moduleProcessParams.size() != 0) {
            for (int i3 = 0; i3 < moduleProcessParams.size(); i3++) {
                this.f342615e.c(moduleProcessParams.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f() {
        d(this.f342613c, ((MonetModuleInner) this.f342612b).getInputData());
        this.f342615e.a(((MonetModuleInner) this.f342612b).getProtocol());
    }

    private void k(MonetModuleInner monetModuleInner) {
        Size size;
        if (monetModuleInner == null) {
            return;
        }
        IMonetOutputStream iMonetOutputStream = this.f342614d;
        if (iMonetOutputStream != null && (iMonetOutputStream instanceof com.tencent.qfsmonet.outputstream.b)) {
            size = ((com.tencent.qfsmonet.outputstream.b) iMonetOutputStream).b();
        } else {
            size = null;
        }
        if (size != null) {
            monetModuleInner.setCommonParameters(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_WIDTH, Integer.toString(size.getWidth()));
            monetModuleInner.setCommonParameters(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_HEIGHT, Integer.toString(size.getHeight()));
        }
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    public synchronized void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<IMonetInputStream> it = this.f342613c.iterator();
        while (it.hasNext()) {
            IMonetInputStream next = it.next();
            if (next instanceof com.tencent.qfsmonet.inputstream.a) {
                ((com.tencent.qfsmonet.inputstream.a) next).destroy();
            }
        }
        this.f342613c.clear();
        IMonetOutputStream iMonetOutputStream = this.f342614d;
        if (iMonetOutputStream != null && (iMonetOutputStream instanceof com.tencent.qfsmonet.outputstream.a)) {
            ((com.tencent.qfsmonet.outputstream.a) iMonetOutputStream).destroy();
        }
        this.f342614d = null;
        this.f342612b = null;
        com.tencent.qfsmonet.process.a aVar = this.f342615e;
        if (aVar != null) {
            aVar.destroy();
            this.f342615e = null;
        }
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    @Nullable
    public synchronized MonetContext initialize(@Nullable EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonetContext) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eGLContext);
        }
        if (this.f342615e != null) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessor", "duplicate initialize." + this);
            return this.f342611a;
        }
        com.tencent.qfsmonet.process.a iVar = this.f342617g ? new i() : new o();
        MonetContext g16 = iVar.g(eGLContext);
        IMonetTextureIdInterceptor iMonetTextureIdInterceptor = this.f342616f;
        if (iMonetTextureIdInterceptor != null) {
            iVar.setTextureIdInterceptor(iMonetTextureIdInterceptor);
            com.tencent.qfsmonet.utils.a.b("MonetProcessor", "initialize set Process mProcessInterceptor" + this);
        }
        if (g16 != null) {
            this.f342615e = iVar;
            this.f342611a = g16;
            com.tencent.qfsmonet.utils.a.c("MonetProcessor", "initialize success." + this);
        } else {
            com.tencent.qfsmonet.utils.a.b("MonetProcessor", "initialize failed. ptr=" + this);
        }
        return g16;
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    @Nullable
    public MonetContext initializeWithSoLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MonetContext) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        this.f342617g = false;
        return initialize(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    public synchronized void loadModule(@NonNull IMonetSingleInputModule iMonetSingleInputModule, @NonNull IMonetInputStream iMonetInputStream, @NonNull IMonetOutputStream iMonetOutputStream) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, iMonetSingleInputModule, iMonetInputStream, iMonetOutputStream);
            return;
        }
        if (this.f342615e != null) {
            if (this.f342613c.size() == 0) {
                if (iMonetSingleInputModule instanceof MonetModuleInner) {
                    String protocol2 = ((MonetModuleInner) iMonetSingleInputModule).getProtocol();
                    if (!this.f342615e.d(protocol2) && !protocol2.isEmpty()) {
                        throw new IllegalStateException("module init failed");
                    }
                    ((com.tencent.qfsmonet.inputstream.a) iMonetInputStream).a(((MonetModuleInner) iMonetSingleInputModule).getInputData().get(0));
                    this.f342612b = iMonetSingleInputModule;
                    this.f342613c.clear();
                    this.f342613c.add(iMonetInputStream);
                    this.f342614d = iMonetOutputStream;
                    return;
                }
                throw new IllegalStateException("invalid module.");
            }
            throw new IllegalStateException("duplicate loadModule.");
        }
        throw new IllegalStateException("not initialize.");
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    public synchronized void run() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f342615e != null) {
            if (this.f342613c.size() != 0) {
                Iterator<IMonetInputStream> it = this.f342613c.iterator();
                while (it.hasNext()) {
                    IMonetInputStream next = it.next();
                    if (next instanceof IMonetSurfaceInputStream) {
                        ((com.tencent.qfsmonet.inputstream.d) next).m(this.f342618h);
                    }
                }
                this.f342615e.f((OnNewPacketAvailableListener) this.f342614d);
                return;
            }
            throw new IllegalStateException("not load module");
        }
        throw new IllegalStateException("not call initialize or initialize failed");
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    public void setDestroyFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.qfsmonet.process.a aVar = this.f342615e;
        if (aVar != null) {
            aVar.setDestroyFlag();
        }
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    public void setTextureIdInterceptor(IMonetTextureIdInterceptor iMonetTextureIdInterceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iMonetTextureIdInterceptor);
            return;
        }
        com.tencent.qfsmonet.utils.a.b("MonetProcessor", "Process setTextureIdInterceptor" + this);
        this.f342616f = iMonetTextureIdInterceptor;
        com.tencent.qfsmonet.process.a aVar = this.f342615e;
        if (aVar == null) {
            return;
        }
        aVar.setTextureIdInterceptor(iMonetTextureIdInterceptor);
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    public synchronized void updateModule(@Nullable IMonetModule iMonetModule) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iMonetModule);
            return;
        }
        if (this.f342615e != null) {
            if (this.f342613c.size() != 0) {
                if (iMonetModule == null) {
                    this.f342612b = null;
                    this.f342615e.a(null);
                    return;
                }
                IMonetModule iMonetModule2 = this.f342612b;
                if (iMonetModule2 != null && !e(iMonetModule2, iMonetModule)) {
                    throw new IllegalStateException("module mode not the same.");
                }
                this.f342612b = iMonetModule;
                this.f342615e.e(new Runnable() { // from class: com.tencent.qfsmonet.process.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.this.f();
                    }
                });
                return;
            }
            throw new IllegalStateException("not load module");
        }
        throw new IllegalStateException("not initialize.");
    }

    @Override // com.tencent.qfsmonet.api.IMonetProcessor
    @Nullable
    public MonetContext initialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? initialize(null) : (MonetContext) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}

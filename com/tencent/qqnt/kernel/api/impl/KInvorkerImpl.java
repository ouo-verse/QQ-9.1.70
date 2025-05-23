package com.tencent.qqnt.kernel.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.IKInvorker;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.invorker.KBaseInvorkService;
import com.tencent.qqnt.kernel.invorker.KBuddyInvorkService;
import com.tencent.qqnt.kernel.invorker.KCommonInvorkService;
import com.tencent.qqnt.kernel.invorker.KGroupInvorkService;
import com.tencent.qqnt.kernel.invorker.KProfileInvorkService;
import com.tencent.qqnt.kernel.invorker.KSearchInvorkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J(\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/KInvorkerImpl;", "Lcom/tencent/qqnt/kernel/api/IKInvorker;", "Lcom/tencent/qqnt/kernel/invorker/f;", "", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "", "Lcom/tencent/qqnt/kernel/invorker/i;", "toSim", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getServiceMsgs", "", "serviceInd", "", "methodName", "parasInd", "cmd", "call", "Lcom/tencent/qqnt/kernel/invorker/e;", "listener", "addListener", "removeListener", "source", "msg", "notify", "services$delegate", "Lkotlin/Lazy;", "getServices", "()Ljava/util/List;", "services", "listeners$delegate", "getListeners", "listeners", "Ljava/util/concurrent/atomic/AtomicInteger;", "curSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lmqq/util/WeakReference;", "mAppRef", "Lmqq/util/WeakReference;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KInvorkerImpl implements IKInvorker, com.tencent.qqnt.kernel.invorker.f {
    static IPatchRedirector $redirector_;

    @NotNull
    private final AtomicInteger curSeq;

    /* renamed from: listeners$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listeners;

    @Nullable
    private WeakReference<AppRuntime> mAppRef;

    /* renamed from: services$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy services;

    public KInvorkerImpl() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(KInvorkerImpl$services$2.INSTANCE);
            this.services = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(KInvorkerImpl$listeners$2.INSTANCE);
            this.listeners = lazy2;
            this.curSeq = new AtomicInteger(0);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final List<com.tencent.qqnt.kernel.invorker.e> getListeners() {
        return (List) this.listeners.getValue();
    }

    private final List<KBaseInvorkService> getServices() {
        return (List) this.services.getValue();
    }

    private final List<com.tencent.qqnt.kernel.invorker.i> toSim(List<KBaseInvorkService> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((KBaseInvorkService) it.next()).x());
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.kernel.api.IKInvorker
    public void addListener(@NotNull com.tencent.qqnt.kernel.invorker.e listener) {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        getListeners().add(listener);
        listener.onResult("welcome to Kernel Interface Debug View!");
        WeakReference<AppRuntime> weakReference = this.mAppRef;
        if (weakReference != null && (appRuntime = weakReference.get()) != null) {
            listener.onResult("---uin : " + appRuntime.getCurrentUin());
            listener.onResult("---uid : " + appRuntime.getCurrentUid() + "\n");
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKInvorker
    public void call(int serviceInd, @NotNull String methodName, int parasInd, @NotNull String cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(serviceInd), methodName, Integer.valueOf(parasInd), cmd);
            return;
        }
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        KBaseInvorkService kBaseInvorkService = getServices().get(serviceInd);
        String y16 = kBaseInvorkService.y(methodName, parasInd, cmd);
        if (y16 != null) {
            notify(this.curSeq.getAndIncrement() + ")---" + kBaseInvorkService.q() + "---" + methodName, y16);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKInvorker
    @NotNull
    public List<com.tencent.qqnt.kernel.invorker.i> getServiceMsgs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return toSim(getServices());
    }

    @Override // com.tencent.qqnt.kernel.invorker.f
    public void notify(@NotNull String source, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) source, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        for (com.tencent.qqnt.kernel.invorker.e eVar : getListeners()) {
            eVar.onResult(source + "---" + msg2);
            eVar.a(source);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime != null) {
            this.mAppRef = new WeakReference<>(appRuntime);
            IKernelService kernel = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "all");
            List<KBaseInvorkService> services = getServices();
            Intrinsics.checkNotNullExpressionValue(kernel, "kernel");
            services.add(new KCommonInvorkService(kernel, appRuntime, this));
            getServices().add(new KBuddyInvorkService(kernel, appRuntime, this));
            getServices().add(new KGroupInvorkService(kernel, appRuntime, this));
            getServices().add(new KProfileInvorkService(kernel, appRuntime, this));
            getServices().add(new com.tencent.qqnt.kernel.invorker.k(kernel, appRuntime, this));
            getServices().add(new com.tencent.qqnt.kernel.invorker.j(kernel, appRuntime, this));
            getServices().add(new KSearchInvorkService(kernel, appRuntime, this));
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<T> it = getServices().iterator();
        while (it.hasNext()) {
            ((KBaseInvorkService) it.next()).u();
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKInvorker
    public void removeListener(@NotNull com.tencent.qqnt.kernel.invorker.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getListeners().remove(listener);
        }
    }
}

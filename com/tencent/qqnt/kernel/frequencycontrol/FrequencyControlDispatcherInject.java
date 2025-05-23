package com.tencent.qqnt.kernel.frequencycontrol;

import com.tencent.mobileqq.app.cd;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tofumsg.i;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.kernel.VasDispatcherAdapterProcess;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ux3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u0006H\u0002J@\u0010\u000b\u001a\u00020\n2.\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rR&\u0010\u0015\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00130\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014RC\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/kernel/frequencycontrol/FrequencyControlDispatcherInject;", "", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "Lkotlin/collections/HashMap;", "e", "dispatcherMap", "dispatcher", "", "f", "cmd", "", "pbBuffer", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "Ljava/lang/Class;", "Ljava/util/ArrayList;", "frequencyControlDispatcherList", "Lkotlin/Lazy;", "d", "()Ljava/util/HashMap;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class FrequencyControlDispatcherInject {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FrequencyControlDispatcherInject f359076a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_Frequency_Control_Dispatcher.yml", version = 2)
    @NotNull
    private static ArrayList<Class<? extends b>> frequencyControlDispatcherList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy dispatcherMap;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359076a = new FrequencyControlDispatcherInject();
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        frequencyControlDispatcherList = arrayList;
        arrayList.add(com.tencent.qqnt.kernel.frequencycontrol.dispatcher.a.class);
        frequencyControlDispatcherList.add(com.tencent.mobileqq.troop.essencemsg.b.class);
        frequencyControlDispatcherList.add(VasDispatcherAdapterProcess.class);
        frequencyControlDispatcherList.add(d.class);
        frequencyControlDispatcherList.add(com.tencent.mobileqq.nt.msgpush.b.class);
        frequencyControlDispatcherList.add(com.tencent.mobileqq.database.corrupt.d.class);
        frequencyControlDispatcherList.add(cd.class);
        frequencyControlDispatcherList.add(i.class);
        lazy = LazyKt__LazyJVMKt.lazy(FrequencyControlDispatcherInject$dispatcherMap$2.INSTANCE);
        dispatcherMap = lazy;
    }

    FrequencyControlDispatcherInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HashMap<Integer, ArrayList<b>> d() {
        return (HashMap) dispatcherMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<Integer, ArrayList<b>> e() {
        HashMap<Integer, ArrayList<b>> hashMap = new HashMap<>();
        Iterator<T> it = frequencyControlDispatcherList.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((Class) it.next()).newInstance();
            if (bVar != null) {
                f359076a.f(hashMap, bVar);
            }
        }
        return hashMap;
    }

    private final void f(HashMap<Integer, ArrayList<b>> dispatcherMap2, b dispatcher) {
        for (int i3 : dispatcher.a()) {
            QLog.i("FrequencyControlDispatcherInject", 1, "[registerDispatcher]: cmd is " + i3 + ", dispatcher is " + dispatcher);
            ArrayList<b> arrayList = dispatcherMap2.get(Integer.valueOf(i3));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                dispatcherMap2.put(Integer.valueOf(i3), arrayList);
            }
            arrayList.add(dispatcher);
        }
    }

    public final void b(int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, cmd, (Object) pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        ArrayList<b> arrayList = d().get(Integer.valueOf(cmd));
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(cmd, pbBuffer);
            }
        }
    }

    public final void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        ArrayList<b> arrayList = d().get(Integer.valueOf(cmd));
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).c(requestId, cmd, pbBuffer);
            }
        }
    }
}

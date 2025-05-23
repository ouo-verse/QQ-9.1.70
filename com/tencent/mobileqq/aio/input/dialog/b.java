package com.tencent.mobileqq.aio.input.dialog;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import l64.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R4\u0010\b\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003`\u00058\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R4\u0010\n\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003`\u00058\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0002j\b\u0012\u0004\u0012\u00020\u0004`\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0002j\b\u0012\u0004\u0012\u00020\u0004`\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/input/dialog/b;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/dialog/a;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "c2COuterHelperProvider", "c", "groupOuterProcessorProvider", "a", "()Ljava/util/ArrayList;", "c2COuterProcessorList", "groupOuterProcessorList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f189373a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/input/Inject_Input_Dialog_Priority_Processor_supplier.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends a>> c2COuterHelperProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/input/Inject_Input_Dialog_Priority_Processor_supplier.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends a>> groupOuterProcessorProvider;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f189373a = new b();
        c2COuterHelperProvider = new ArrayList<>();
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        groupOuterProcessorProvider = arrayList;
        arrayList.add(d.class);
        arrayList.add(l64.c.class);
        arrayList.add(c.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<T> it = c2COuterHelperProvider.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((Class) it.next()).getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e16) {
                QLog.e("InputDialogPriorityInjector", 1, "getC2COuterProcessorList exception", e16);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<a> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<T> it = groupOuterProcessorProvider.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((Class) it.next()).getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e16) {
                QLog.e("InputDialogPriorityInjector", 1, "getGroupOuterProcessorList exception", e16);
            }
        }
        return arrayList;
    }
}

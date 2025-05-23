package com.tencent.mobileqq.aio.msg.service;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vas.ak;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u0016J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\b\u001a\u00020\u0007R<\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f`\u00118\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/a;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/aio/msg/b;", "Lkotlin/collections/HashMap;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "", "b", "", "injectSet", "c", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/msg/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getProcessorFactoryClass", "()Ljava/util/ArrayList;", "getProcessorFactoryClass$annotations", "()V", "processorFactoryClass", "", "Ljava/util/List;", "factoryList", "d", "Ljava/util/HashMap;", "processorMap", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f190218a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msg/Inject_Business_MsgData_Processor_Factory.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.aio.msg.c>> processorFactoryClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<com.tencent.qqnt.aio.msg.c> factoryList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, com.tencent.qqnt.aio.msg.b> processorMap;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f190218a = new a();
        ArrayList<Class<com.tencent.qqnt.aio.msg.c>> arrayList = new ArrayList<>();
        processorFactoryClass = arrayList;
        arrayList.add(com.tencent.qqnt.msg.g.class);
        arrayList.add(com.tencent.qqnt.aio.msg.a.class);
        arrayList.add(ak.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.aio.msg.IAIOMsgDataProcessorFactory");
            arrayList2.add((com.tencent.qqnt.aio.msg.c) newInstance);
        }
        factoryList = arrayList2;
        processorMap = f190218a.a();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HashMap<Integer, com.tencent.qqnt.aio.msg.b> a() {
        HashMap<Integer, com.tencent.qqnt.aio.msg.b> hashMap = new HashMap<>();
        Iterator<T> it = factoryList.iterator();
        while (it.hasNext()) {
            for (com.tencent.qqnt.aio.msg.b bVar : ((com.tencent.qqnt.aio.msg.c) it.next()).a()) {
                hashMap.put(Integer.valueOf(bVar.getBusinessType()), bVar);
            }
        }
        return hashMap;
    }

    public final void b(@NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        StopWatch i3 = new StopWatch("AIOBusinessMsgDataInject.processMsg", QLog.isDevelopLevel()).i();
        for (Map.Entry<Integer, com.tencent.qqnt.aio.msg.b> entry : processorMap.entrySet()) {
            entry.getValue().a(msg2);
            i3.e(entry.getValue().getClass().getName() + " injectData");
        }
        i3.b("AIOBusinessMsgDataInject.processMsg.end");
        msg2.X0();
    }

    public final void c(@NotNull Set<Integer> injectSet, @NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) injectSet, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(injectSet, "injectSet");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        StopWatch i3 = new StopWatch("AIOBusinessMsgDataInject.processMsg.injectSet", QLog.isDevelopLevel()).i();
        Iterator<T> it = injectSet.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.aio.msg.b bVar = processorMap.get(Integer.valueOf(((Number) it.next()).intValue()));
            if (bVar != null) {
                bVar.a(msg2);
                i3.e(bVar.getClass().getName() + " injectData");
            }
        }
        i3.b("AIOBusinessMsgDataInject.processMsg.end");
        msg2.X0();
    }
}

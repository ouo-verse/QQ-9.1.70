package com.tencent.qqnt.aio.factory;

import com.tencent.aio.stranger.impl.factory.supplier.g;
import com.tencent.mobileqq.mini.entry.aio.MiniStrangerAIOFactorySupplier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/factory/b;", "", "Lcom/tencent/qqnt/aio/factory/a;", "param", "", "a", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/factory/f;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getSupplierClass", "()Ljava/util/ArrayList;", "getSupplierClass$annotations", "()V", "supplierClass", "", "c", "Ljava/util/List;", "supplierList", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f349915a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/factory/Inject_factory_supplier.yml", version = 6)
    @NotNull
    private static final ArrayList<Class<f>> supplierClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<f> supplierList;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f349915a = new b();
        ArrayList<Class<f>> arrayList = new ArrayList<>();
        supplierClass = arrayList;
        arrayList.add(com.tencent.mobileqq.multiforward.a.class);
        arrayList.add(k24.b.class);
        arrayList.add(com.tencent.mobileqq.aio.factory.supplier.d.class);
        arrayList.add(com.tencent.mobileqq.aio.factory.supplier.a.class);
        arrayList.add(com.tencent.mobileqq.aio.factory.supplier.c.class);
        arrayList.add(com.tencent.aio.stranger.impl.factory.supplier.a.class);
        arrayList.add(com.tencent.aio.stranger.impl.factory.supplier.c.class);
        arrayList.add(com.tencent.aio.stranger.impl.factory.supplier.b.class);
        arrayList.add(g.class);
        arrayList.add(com.tencent.aio.stranger.impl.factory.supplier.e.class);
        arrayList.add(com.tencent.aio.stranger.impl.factory.supplier.f.class);
        arrayList.add(com.tencent.aio.stranger.impl.factory.supplier.d.class);
        arrayList.add(com.tencent.qqnt.aio.factory.supplier.a.class);
        arrayList.add(com.tencent.mobileqq.aio.notifyservice.a.class);
        arrayList.add(com.tencent.mobileqq.aio.chatfactory.publicaccount.a.class);
        arrayList.add(wq3.b.class);
        arrayList.add(MiniStrangerAIOFactorySupplier.class);
        arrayList.add(xz2.c.class);
        arrayList.add(ba2.b.class);
        arrayList.add(com.tencent.qqnt.aio.mycomputer.a.class);
        arrayList.add(com.tencent.mobileqq.aio.factory.supplier.b.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.aio.factory.IAIOFactorySupplier");
            arrayList2.add((f) newInstance);
        }
        supplierList = arrayList2;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        for (f fVar : supplierList) {
            if (fVar.match(param)) {
                return fVar.getAIOFactoryClassName(param);
            }
        }
        throw new Exception("make sure at least one default IAIOFactorySupplier has been injected!!!");
    }

    public final boolean b(@NotNull a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) param)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(param, "param");
        for (f fVar : supplierList) {
            if (fVar.match(param)) {
                return fVar.cacheAble();
            }
        }
        return false;
    }
}

package com.tencent.qqnt.aio.palette;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0012J\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\u0013\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/palette/b;", "", "Lcom/tencent/qqnt/aio/palette/a;", "param", "Lkotlin/Pair;", "", "Lae0/a;", "a", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/palette/d;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getSupplierClass", "()Ljava/util/ArrayList;", "getSupplierClass$annotations", "()V", "supplierClass", "", "c", "Ljava/util/List;", "supplierList", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f351744a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/palette/Inject_palette_supplier.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<d>> supplierClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<d> supplierList;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f351744a = new b();
        ArrayList<Class<d>> arrayList = new ArrayList<>();
        supplierClass = arrayList;
        arrayList.add(w24.a.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.aio.palette.IAIOPaletteSupplier");
            arrayList2.add((d) newInstance);
        }
        supplierList = arrayList2;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Pair<String, ae0.a> a(@NotNull a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        for (d dVar : supplierList) {
            if (dVar.b(param)) {
                return dVar.a(param);
            }
        }
        return null;
    }

    public final boolean b(@NotNull a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) param)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Iterator<T> it = supplierList.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).b(param)) {
                return true;
            }
        }
        return false;
    }
}

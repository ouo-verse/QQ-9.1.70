package com.tencent.mobileqq.aio.helper;

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
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/g;", "", "Lcom/tencent/aio/api/help/a;", "param", "Lcom/tencent/aio/api/help/d;", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/helper/z;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getClassList", "()Ljava/util/ArrayList;", "getClassList$annotations", "()V", "classList", "", "c", "Ljava/util/List;", "matcherList", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f189049a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/helper/Inject_helper_provider.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<z>> classList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<z> matcherList;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f189049a = new g();
        ArrayList<Class<z>> arrayList = new ArrayList<>();
        classList = arrayList;
        arrayList.add(com.tencent.qqnt.aio.helper.provider.h.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.f.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.d.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.b.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.k.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.a.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.c.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.e.class);
        arrayList.add(com.tencent.qqnt.aio.helper.provider.i.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.helper.IHelperMatch");
            arrayList2.add((z) newInstance);
        }
        matcherList = arrayList2;
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.aio.api.help.d a(@NotNull com.tencent.aio.api.help.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        for (z zVar : matcherList) {
            if (zVar.a(param)) {
                if (!(zVar instanceof com.tencent.aio.api.help.d)) {
                    return null;
                }
                return (com.tencent.aio.api.help.d) zVar;
            }
        }
        return null;
    }
}

package com.tencent.mobileqq.aio.msglist.holder.external;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.aio.refresher.j;
import com.tencent.qqnt.aio.refresher.n;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f`\u00118\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0012\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/external/a;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "refreshRequest", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "c", "", "type", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "a", "", "d", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/g;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "getRefresherProviderClass$annotations", "()V", "refresherProviderClass", "", "Ljava/util/List;", "refresherProviderList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "preloaderMap", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f192382a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/refresher/Inject_AIO_Refresher_Provider_Inject.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<g>> refresherProviderClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<g> refresherProviderList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, d> preloaderMap;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f192382a = new a();
        ArrayList<Class<g>> arrayList = new ArrayList<>();
        refresherProviderClass = arrayList;
        arrayList.add(n.class);
        arrayList.add(j.class);
        arrayList.add(wz2.a.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.external.IRefresherProvider");
            arrayList2.add((g) newInstance);
        }
        refresherProviderList = arrayList2;
        preloaderMap = new HashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public static final ArrayList<Class<g>> b() {
        return refresherProviderClass;
    }

    private final d c(h refreshRequest) {
        String qualifiedName = Reflection.getOrCreateKotlinClass(refreshRequest.getClass()).getQualifiedName();
        if (preloaderMap.get(qualifiedName) == null) {
            for (g gVar : refresherProviderList) {
                Intrinsics.checkNotNull(qualifiedName);
                d b16 = gVar.b(qualifiedName);
                if (b16 != null) {
                    return b16;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final c a(@NotNull String type, @NotNull e helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type, (Object) helper);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Iterator<T> it = refresherProviderList.iterator();
        while (it.hasNext()) {
            c a16 = ((g) it.next()).a(type, helper);
            if (a16 != null) {
                return a16;
            }
        }
        return null;
    }

    public final void d(@NotNull h refreshRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) refreshRequest);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshRequest, "refreshRequest");
        d c16 = c(refreshRequest);
        if (c16 != null) {
            if (!QQTheme.isNowSimpleUI() || c16.b()) {
                c16.a(refreshRequest);
            }
        }
    }
}

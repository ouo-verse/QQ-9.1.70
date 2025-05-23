package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.aio.util.AIOMsgListCacheParamProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002J\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002J\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002R&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/b;", "", "", "Lkotlin/Pair;", "", "c", "b", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/api/c;", "Ljava/util/ArrayList;", "getSProvider", "()Ljava/util/ArrayList;", "sProvider", "Lcom/tencent/qqnt/aio/api/c;", "getProvider", "()Lcom/tencent/qqnt/aio/api/c;", "provider", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f190447a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/aio/Inject_aio_cache_config.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.aio.api.c>> sProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final com.tencent.qqnt.aio.api.c provider;

    static {
        Object orNull;
        com.tencent.qqnt.aio.api.c cVar;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f190447a = new b();
        ArrayList<Class<com.tencent.qqnt.aio.api.c>> arrayList = new ArrayList<>();
        sProvider = arrayList;
        arrayList.add(AIOMsgListCacheParamProvider.class);
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
        Class cls = (Class) orNull;
        if (cls != null) {
            cVar = (com.tencent.qqnt.aio.api.c) cls.newInstance();
        } else {
            cVar = null;
        }
        provider = cVar;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<Pair<Integer, Integer>> a() {
        List<Pair<Integer, Integer>> mutableListOf;
        List<Pair<Integer, Integer>> i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.qqnt.aio.api.c cVar = provider;
        if (cVar == null || (i3 = cVar.i()) == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Pair(7, 5), new Pair(6, 8), new Pair(5, 2), new Pair(4, 2), new Pair(84, 2), new Pair(85, 2), new Pair(11, 1), new Pair(10, 2), new Pair(13, 1), new Pair(12, 1), new Pair(56, 6), new Pair(24, 2), new Pair(23, 2), new Pair(34, 2), new Pair(35, 2), new Pair(100, 2), new Pair(101, 2), new Pair(37, 1), new Pair(36, 1), new Pair(39, 1), new Pair(38, 1), new Pair(15, 1), new Pair(14, 2), new Pair(50, 1), new Pair(90, 1), new Pair(91, 2));
            mutableListOf.add(TuplesKt.to(Integer.valueOf(com.tencent.aio.data.msglist.b.a(3, 201)), 1));
            mutableListOf.add(TuplesKt.to(Integer.valueOf(com.tencent.aio.data.msglist.b.a(2, 201)), 1));
            return mutableListOf;
        }
        return i3;
    }

    @NotNull
    public final List<Pair<Integer, Integer>> b() {
        List<Pair<Integer, Integer>> mutableListOf;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.qqnt.aio.api.c cVar = provider;
        if (cVar == null || (mutableListOf = cVar.e()) == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Pair(7, 5), new Pair(6, 10), new Pair(5, 2), new Pair(4, 5), new Pair(84, 2), new Pair(85, 5), new Pair(11, 2), new Pair(10, 2), new Pair(13, 2), new Pair(12, 2), new Pair(56, 8), new Pair(24, 2), new Pair(23, 5), new Pair(34, 2), new Pair(35, 5), new Pair(100, 2), new Pair(101, 5), new Pair(37, 2), new Pair(36, 5), new Pair(33, 2), new Pair(32, 5), new Pair(39, 2), new Pair(38, 2), new Pair(15, 2), new Pair(14, 2), new Pair(50, 5), new Pair(66, 1), new Pair(90, 2), new Pair(91, 2));
            List<Integer> a16 = FileMsgItem.INSTANCE.a();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(TuplesKt.to(Integer.valueOf(((Number) it.next()).intValue()), 2));
            }
            mutableListOf.addAll(arrayList);
        }
        return mutableListOf;
    }

    @NotNull
    public final List<Pair<Integer, Integer>> c() {
        List<Pair<Integer, Integer>> mutableListOf;
        List<Pair<Integer, Integer>> h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.qqnt.aio.api.c cVar = provider;
        if (cVar == null || (h16 = cVar.h()) == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Pair(7, 5), new Pair(6, 8), new Pair(5, 2), new Pair(4, 2), new Pair(84, 2), new Pair(85, 2), new Pair(11, 1), new Pair(10, 2), new Pair(13, 1), new Pair(12, 1), new Pair(56, 6), new Pair(24, 2), new Pair(23, 2), new Pair(34, 2), new Pair(35, 2), new Pair(100, 2), new Pair(101, 2), new Pair(37, 1), new Pair(36, 1), new Pair(39, 1), new Pair(38, 1), new Pair(15, 1), new Pair(14, 2), new Pair(50, 1), new Pair(90, 1), new Pair(91, 2));
            mutableListOf.add(TuplesKt.to(Integer.valueOf(com.tencent.aio.data.msglist.b.a(3, 201)), 1));
            mutableListOf.add(TuplesKt.to(Integer.valueOf(com.tencent.aio.data.msglist.b.a(2, 201)), 1));
            return mutableListOf;
        }
        return h16;
    }
}

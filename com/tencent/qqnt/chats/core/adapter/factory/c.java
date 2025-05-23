package com.tencent.qqnt.chats.core.adapter.factory;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.biz.guildhelper.d;
import com.tencent.qqnt.chats.biz.miniaio.f;
import com.tencent.qqnt.chats.biz.troophelper.e;
import com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011RH\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u000fj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0014`\u00108\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/factory/c;", "", "", "style", "Lcom/tencent/qqnt/chats/core/adapter/factory/a;", "a", "c", "viewType", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "b", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "DEFAULT_BUILDER", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "builderMap", "", "Ljava/lang/Class;", "d", "getFactoryClzMap", "()Ljava/util/HashMap;", "getFactoryClzMap$annotations", "()V", "factoryClzMap", "", "e", "Ljava/util/Map;", "builderFactoryMap", "<init>", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f354467a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CommonRecentItemBuilder DEFAULT_BUILDER;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, a> builderMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ItemBuilder.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<a>> factoryClzMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, a> builderFactoryMap;

    static {
        int mapCapacity;
        int mapCapacity2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45538);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f354467a = new c();
        DEFAULT_BUILDER = CommonRecentItemBuilder.INSTANCE.a();
        builderMap = new HashMap<>();
        HashMap<String, Class<a>> hashMap = new HashMap<>();
        factoryClzMap = hashMap;
        hashMap.put("22", d.class);
        hashMap.put("21", com.tencent.qqnt.chats.biz.serviceaccountfolder.a.class);
        hashMap.put("20", com.tencent.qqnt.chats.biz.notifyservice.c.class);
        hashMap.put("19", com.tencent.qqnt.chats.biz.miniaio.horizontal.b.class);
        hashMap.put("18", f.class);
        hashMap.put("1", e.class);
        hashMap.put("0", com.tencent.qqnt.chats.core.adapter.factory.impl.b.class);
        hashMap.put("-1", com.tencent.qqnt.chats.core.adapter.factory.impl.a.class);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(hashMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(Integer.parseInt((String) entry.getKey())), entry.getValue());
        }
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object newInstance = ((Class) entry2.getValue()).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.factory.AbsRecentBuilderFactory");
            linkedHashMap2.put(key, (a) newInstance);
        }
        builderFactoryMap = linkedHashMap2;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a a(int style) {
        Map<Integer, a> map = builderFactoryMap;
        if (map.containsKey(Integer.valueOf(style))) {
            a aVar = map.get(Integer.valueOf(style));
            Intrinsics.checkNotNull(aVar);
            return aVar;
        }
        a aVar2 = map.get(-1);
        Intrinsics.checkNotNull(aVar2);
        return aVar2;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> b(int style, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.core.adapter.builder.a) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(style), Integer.valueOf(viewType));
        }
        a c16 = c(style);
        com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> b16 = c16.b(viewType);
        if (b16 == null) {
            com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> a16 = c16.a(viewType);
            if (a16 != null) {
                c16.f(viewType, a16);
                return a16;
            }
            CommonRecentItemBuilder commonRecentItemBuilder = DEFAULT_BUILDER;
            c16.f(viewType, commonRecentItemBuilder);
            return commonRecentItemBuilder;
        }
        return b16;
    }

    @NotNull
    public final a c(int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, style);
        }
        HashMap<Integer, a> hashMap = builderMap;
        if (hashMap.containsKey(Integer.valueOf(style))) {
            a aVar = hashMap.get(Integer.valueOf(style));
            Intrinsics.checkNotNull(aVar);
            Intrinsics.checkNotNullExpressionValue(aVar, "{\n            builderMap[style]!!\n        }");
            return aVar;
        }
        a a16 = a(style);
        hashMap.put(Integer.valueOf(style), a16);
        return a16;
    }
}
